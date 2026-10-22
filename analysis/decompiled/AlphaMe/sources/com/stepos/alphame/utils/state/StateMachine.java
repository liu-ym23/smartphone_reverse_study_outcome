package com.stepos.alphame.utils.state;

import B0.g;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

/* loaded from: classes.dex */
public class StateMachine {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    private static final int SM_INIT_CMD = -2;
    private static final int SM_QUIT_CMD = -1;
    private static final String TAG = "StateMachine";
    private String mName;
    private SmHandler mSmHandler;
    private HandlerThread mSmThread;

    public static class LogRec {
        private String mInfo;
        private State mOrgState;
        private State mState;
        private long mTime;
        private int mWhat;

        public LogRec(Message message, String str, State state, State state2) {
            update(message, str, state, state2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(Message message, String str, State state, State state2) {
            this.mTime = System.currentTimeMillis();
            this.mWhat = message != null ? message.what : 0;
            this.mInfo = str;
            this.mState = state;
            this.mOrgState = state2;
        }

        public String getInfo() {
            return this.mInfo;
        }

        public State getOriginalState() {
            return this.mOrgState;
        }

        public State getState() {
            return this.mState;
        }

        public long getTime() {
            return this.mTime;
        }

        public long getWhat() {
            return this.mWhat;
        }

        public String toString(StateMachine stateMachine) {
            StringBuilder sb = new StringBuilder("time=");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.mTime);
            sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar));
            sb.append(" state=");
            State state = this.mState;
            sb.append(state == null ? "<null>" : state.getName());
            sb.append(" orgState=");
            State state2 = this.mOrgState;
            sb.append(state2 != null ? state2.getName() : "<null>");
            sb.append(" what=");
            String whatToString = stateMachine.getWhatToString(this.mWhat);
            if (TextUtils.isEmpty(whatToString)) {
                sb.append(this.mWhat);
                sb.append("(0x");
                sb.append(Integer.toHexString(this.mWhat));
                sb.append(")");
            } else {
                sb.append(whatToString);
            }
            if (!TextUtils.isEmpty(this.mInfo)) {
                sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
                sb.append(this.mInfo);
            }
            return sb.toString();
        }
    }

    public static class LogRecords {
        private static final int DEFAULT_SIZE = 20;
        private int mCount;
        private Vector<LogRec> mLogRecords;
        private int mMaxSize;
        private int mOldestIndex;

        public /* synthetic */ LogRecords(int i4) {
            this();
        }

        public synchronized void add(Message message, String str, State state, State state2) {
            try {
                this.mCount++;
                if (this.mLogRecords.size() < this.mMaxSize) {
                    this.mLogRecords.add(new LogRec(message, str, state, state2));
                } else {
                    LogRec logRec = this.mLogRecords.get(this.mOldestIndex);
                    int i4 = this.mOldestIndex + 1;
                    this.mOldestIndex = i4;
                    if (i4 >= this.mMaxSize) {
                        this.mOldestIndex = 0;
                    }
                    logRec.update(message, str, state, state2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void cleanup() {
            this.mLogRecords.clear();
        }

        public synchronized int count() {
            return this.mCount;
        }

        public synchronized LogRec get(int i4) {
            int i5 = this.mOldestIndex + i4;
            int i6 = this.mMaxSize;
            if (i5 >= i6) {
                i5 -= i6;
            }
            if (i5 >= size()) {
                return null;
            }
            return this.mLogRecords.get(i5);
        }

        public synchronized void setSize(int i4) {
            this.mMaxSize = i4;
            this.mCount = 0;
            this.mLogRecords.clear();
        }

        public synchronized int size() {
            return this.mLogRecords.size();
        }

        private LogRecords() {
            this.mLogRecords = new Vector<>();
            this.mMaxSize = 20;
            this.mOldestIndex = 0;
            this.mCount = 0;
        }
    }

    public static class SmHandler extends Handler {
        private static final Object mSmHandlerObj = new Object();
        private boolean mDbg;
        private ArrayList<Message> mDeferredMessages;
        private State mDestState;
        private HaltingState mHaltingState;
        private State mInitialState;
        private boolean mIsConstructionCompleted;
        private LogRecords mLogRecords;
        private Message mMsg;
        private QuittingState mQuittingState;
        private StateMachine mSm;
        private HashMap<State, StateInfo> mStateInfo;
        private StateInfo[] mStateStack;
        private int mStateStackTopIndex;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;

        public class HaltingState extends State {
            public /* synthetic */ HaltingState(SmHandler smHandler, int i4) {
                this();
            }

            @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
            public boolean processMessage(Message message) {
                SmHandler.this.mSm.haltedProcessMessage(message);
                return true;
            }

            private HaltingState() {
            }
        }

        public class QuittingState extends State {
            public /* synthetic */ QuittingState(SmHandler smHandler, int i4) {
                this();
            }

            @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
            public boolean processMessage(Message message) {
                return false;
            }

            private QuittingState() {
            }
        }

        public class StateInfo {
            boolean active;
            StateInfo parentStateInfo;
            State state;

            public /* synthetic */ StateInfo(SmHandler smHandler, int i4) {
                this();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("state=");
                sb.append(this.state.getName());
                sb.append(",active=");
                sb.append(this.active);
                sb.append(",parent=");
                StateInfo stateInfo = this.parentStateInfo;
                sb.append(stateInfo == null ? "null" : stateInfo.state.getName());
                return sb.toString();
            }

            private StateInfo() {
            }
        }

        public /* synthetic */ SmHandler(Looper looper, StateMachine stateMachine, int i4) {
            this(looper, stateMachine);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final StateInfo addState(State state, State state2) {
            if (this.mDbg) {
                StringBuilder sb = new StringBuilder("addStateInternal: E state=");
                sb.append(state.getName());
                sb.append(",parent=");
                sb.append(state2 == null ? "" : state2.getName());
                Log.d(StateMachine.TAG, sb.toString());
            }
            StateInfo stateInfoAddState = null;
            if (state2 != null) {
                StateInfo stateInfo = this.mStateInfo.get(state2);
                stateInfoAddState = stateInfo == null ? addState(state2, null) : stateInfo;
            }
            StateInfo stateInfo2 = this.mStateInfo.get(state);
            int i4 = 0;
            if (stateInfo2 == null) {
                stateInfo2 = new StateInfo(this, i4);
                this.mStateInfo.put(state, stateInfo2);
            }
            StateInfo stateInfo3 = stateInfo2.parentStateInfo;
            if (stateInfo3 != null && stateInfo3 != stateInfoAddState) {
                AlphaMeLogger.eLog("state already added");
                return stateInfo2;
            }
            stateInfo2.state = state;
            stateInfo2.parentStateInfo = stateInfoAddState;
            stateInfo2.active = false;
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "addStateInternal: X stateInfo: " + stateInfo2);
            }
            return stateInfo2;
        }

        private final void cleanupAfterQuitting() {
            if (this.mSm.mSmThread != null) {
                getLooper().quit();
                this.mSm.mSmThread = null;
            }
            this.mSm.mSmHandler = null;
            this.mSm = null;
            this.mMsg = null;
            this.mLogRecords.cleanup();
            this.mStateStack = null;
            this.mTempStateStack = null;
            this.mStateInfo.clear();
            this.mInitialState = null;
            this.mDestState = null;
            this.mDeferredMessages.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void completeConstruction() {
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "completeConstruction: E");
            }
            int i4 = 0;
            for (StateInfo stateInfo : this.mStateInfo.values()) {
                int i5 = 0;
                while (stateInfo != null) {
                    stateInfo = stateInfo.parentStateInfo;
                    i5++;
                }
                if (i4 < i5) {
                    i4 = i5;
                }
            }
            if (this.mDbg) {
                g.z("completeConstruction: maxDepth=", i4, StateMachine.TAG);
            }
            this.mStateStack = new StateInfo[i4];
            this.mTempStateStack = new StateInfo[i4];
            setupInitialStateStack();
            sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "completeConstruction: X");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void deferMessage(Message message) {
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "deferMessage: msg=" + message.what);
            }
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.copyFrom(message);
            this.mDeferredMessages.add(messageObtainMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Message getCurrentMessage() {
            return this.mMsg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IState getCurrentState() {
            return this.mStateStack[this.mStateStackTopIndex].state;
        }

        private final void invokeEnterMethods(int i4) {
            while (i4 <= this.mStateStackTopIndex) {
                if (this.mDbg) {
                    Log.d(StateMachine.TAG, "invokeEnterMethods: " + this.mStateStack[i4].state.getName());
                }
                this.mStateStack[i4].state.enter();
                this.mStateStack[i4].active = true;
                i4++;
            }
        }

        private final void invokeExitMethods(StateInfo stateInfo) {
            StateInfo stateInfo2;
            while (true) {
                int i4 = this.mStateStackTopIndex;
                if (i4 < 0 || (stateInfo2 = this.mStateStack[i4]) == stateInfo) {
                    return;
                }
                State state = stateInfo2.state;
                if (this.mDbg) {
                    Log.d(StateMachine.TAG, "invokeExitMethods: " + state.getName());
                }
                state.exit();
                StateInfo[] stateInfoArr = this.mStateStack;
                int i5 = this.mStateStackTopIndex;
                stateInfoArr[i5].active = false;
                this.mStateStackTopIndex = i5 - 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDbg() {
            return this.mDbg;
        }

        private final boolean isQuit(Message message) {
            return message.what == -1 && message.obj == mSmHandlerObj;
        }

        private final void moveDeferredMessageAtFrontOfQueue() {
            for (int size = this.mDeferredMessages.size() - 1; size >= 0; size--) {
                Message message = this.mDeferredMessages.get(size);
                if (this.mDbg) {
                    Log.d(StateMachine.TAG, "moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.mDeferredMessages.clear();
        }

        private final int moveTempStateStackToStateStack() {
            int i4 = this.mStateStackTopIndex + 1;
            int i5 = i4;
            for (int i6 = this.mTempStateStackCount - 1; i6 >= 0; i6--) {
                if (this.mDbg) {
                    Log.d(StateMachine.TAG, "moveTempStackToStateStack: i=" + i6 + ",j=" + i5);
                }
                this.mStateStack[i5] = this.mTempStateStack[i6];
                i5++;
            }
            this.mStateStackTopIndex = i5 - 1;
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "moveTempStackToStateStack: X mStateStackTop=" + this.mStateStackTopIndex + ",startingIndex=" + i4 + ",Top=" + this.mStateStack[this.mStateStackTopIndex].state.getName());
            }
            return i4;
        }

        private void performTransitions() {
            State state = null;
            while (this.mDestState != null) {
                if (this.mDbg) {
                    Log.d(StateMachine.TAG, "handleMessage: new destination call exit");
                }
                state = this.mDestState;
                this.mDestState = null;
                invokeExitMethods(setupTempStateStackWithStatesToEnter(state));
                invokeEnterMethods(moveTempStateStackToStateStack());
                moveDeferredMessageAtFrontOfQueue();
            }
            if (state != null) {
                if (state == this.mQuittingState) {
                    this.mSm.onQuitting();
                    cleanupAfterQuitting();
                } else if (state == this.mHaltingState) {
                    this.mSm.onHalting();
                }
            }
        }

        private final void processMsg(Message message) {
            StateInfo stateInfo = this.mStateStack[this.mStateStackTopIndex];
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "processMsg: " + stateInfo.state.getName());
            }
            if (isQuit(message)) {
                transitionTo(this.mQuittingState);
                return;
            }
            while (true) {
                if (stateInfo.state.processMessage(message)) {
                    break;
                }
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null) {
                    this.mSm.unhandledMessage(message);
                    break;
                } else if (this.mDbg) {
                    Log.d(StateMachine.TAG, "processMsg: " + stateInfo.state.getName());
                }
            }
            if (this.mSm.recordLogRec(message)) {
                if (stateInfo == null) {
                    this.mLogRecords.add(message, this.mSm.getLogRecString(message), null, null);
                } else {
                    this.mLogRecords.add(message, this.mSm.getLogRecString(message), stateInfo.state, this.mStateStack[this.mStateStackTopIndex].state);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void quit() {
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "quit:");
            }
            sendMessage(obtainMessage(-1, mSmHandlerObj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void quitNow() {
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "abort:");
            }
            sendMessageAtFrontOfQueue(obtainMessage(-1, mSmHandlerObj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setDbg(boolean z4) {
            this.mDbg = z4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setInitialState(State state) {
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "setInitialState: initialState=" + state.getName());
            }
            this.mInitialState = state;
        }

        private final void setupInitialStateStack() {
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
            }
            StateInfo stateInfo = this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
            while (stateInfo != null) {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i4 = this.mTempStateStackCount;
                stateInfoArr[i4] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                this.mTempStateStackCount = i4 + 1;
            }
            this.mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(State state) {
            this.mTempStateStackCount = 0;
            StateInfo stateInfo = this.mStateInfo.get(state);
            do {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i4 = this.mTempStateStackCount;
                this.mTempStateStackCount = i4 + 1;
                stateInfoArr[i4] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null) {
                    break;
                }
            } while (!stateInfo.active);
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + stateInfo);
            }
            return stateInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void transitionTo(IState iState) {
            this.mDestState = (State) iState;
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "transitionTo: destState=" + this.mDestState.getName());
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "handleMessage: E msg.what=" + message.what);
            }
            this.mMsg = message;
            boolean z4 = this.mIsConstructionCompleted;
            if (z4) {
                processMsg(message);
            } else {
                if (z4 || message.what != -2 || message.obj != mSmHandlerObj) {
                    AlphaMeLogger.eLog("StateMachine.handleMessage: The start method not called, received msg: " + message);
                    return;
                }
                this.mIsConstructionCompleted = true;
                invokeEnterMethods(0);
            }
            performTransitions();
            if (this.mDbg) {
                Log.d(StateMachine.TAG, "handleMessage: X");
            }
        }

        private SmHandler(Looper looper, StateMachine stateMachine) {
            super(looper);
            int i4 = 0;
            this.mDbg = false;
            this.mLogRecords = new LogRecords(i4);
            this.mStateStackTopIndex = -1;
            this.mHaltingState = new HaltingState(this, i4);
            this.mQuittingState = new QuittingState(this, i4);
            this.mStateInfo = new HashMap<>();
            this.mDeferredMessages = new ArrayList<>();
            this.mSm = stateMachine;
            addState(this.mHaltingState, null);
            addState(this.mQuittingState, null);
        }
    }

    public StateMachine(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        this.mSmThread = handlerThread;
        handlerThread.start();
        initStateMachine(str, this.mSmThread.getLooper());
    }

    private void initStateMachine(String str, Looper looper) {
        this.mName = str;
        this.mSmHandler = new SmHandler(looper, this, 0);
    }

    public void addLogRec(String str) {
        this.mSmHandler.mLogRecords.add(null, str, null, null);
    }

    public final void addState(State state, State state2) {
        this.mSmHandler.addState(state, state2);
    }

    public final void deferMessage(Message message) {
        this.mSmHandler.deferMessage(message);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println(getName() + AwarenessDataItem.USERID_SPLITTER);
        StringBuilder sb = new StringBuilder(" total records=");
        sb.append(getLogRecCount());
        printWriter.println(sb.toString());
        for (int i4 = 0; i4 < getLogRecSize(); i4++) {
            printWriter.printf(" rec[%d]: %s\n", Integer.valueOf(i4), getLogRec(i4).toString(this));
            printWriter.flush();
        }
        printWriter.println("curState=" + getCurrentState().getName());
    }

    public final Message getCurrentMessage() {
        return this.mSmHandler.getCurrentMessage();
    }

    public final IState getCurrentState() {
        return this.mSmHandler.getCurrentState();
    }

    public final Handler getHandler() {
        return this.mSmHandler;
    }

    public final LogRec getLogRec(int i4) {
        return this.mSmHandler.mLogRecords.get(i4);
    }

    public final int getLogRecCount() {
        return this.mSmHandler.mLogRecords.count();
    }

    public final int getLogRecSize() {
        return this.mSmHandler.mLogRecords.size();
    }

    public String getLogRecString(Message message) {
        return "";
    }

    public final String getName() {
        return this.mName;
    }

    public String getWhatToString(int i4) {
        return null;
    }

    public void haltedProcessMessage(Message message) {
    }

    public boolean isDbg() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return false;
        }
        return smHandler.isDbg();
    }

    public final Message obtainMessage() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return Message.obtain(smHandler);
    }

    public void onHalting() {
    }

    public void onQuitting() {
    }

    public final void quit() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.quit();
    }

    public final void quitNow() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.quitNow();
    }

    public boolean recordLogRec(Message message) {
        return true;
    }

    public final void removeMessages(int i4) {
        this.mSmHandler.removeMessages(i4);
    }

    public final void sendMessage(int i4) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(obtainMessage(i4));
    }

    public final void sendMessageAtFrontOfQueue(int i4, Object obj) {
        this.mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(i4, obj));
    }

    public final void sendMessageDelayed(int i4, long j4) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i4), j4);
    }

    public void setDbg(boolean z4) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.setDbg(z4);
    }

    public final void setInitialState(State state) {
        this.mSmHandler.setInitialState(state);
    }

    public final void setLogRecSize(int i4) {
        this.mSmHandler.mLogRecords.setSize(i4);
    }

    public void start() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.completeConstruction();
    }

    public final void transitionTo(IState iState) {
        this.mSmHandler.transitionTo(iState);
    }

    public final void transitionToHaltingState() {
        SmHandler smHandler = this.mSmHandler;
        smHandler.transitionTo(smHandler.mHaltingState);
    }

    public void unhandledMessage(Message message) {
        if (this.mSmHandler.mDbg) {
            Log.e(TAG, this.mName + " - unhandledMessage: msg.what=" + message.what);
        }
    }

    public void addLogRec(String str, State state) {
        this.mSmHandler.mLogRecords.add(null, str, state, null);
    }

    public final void addState(State state) {
        this.mSmHandler.addState(state, null);
    }

    public final void sendMessageAtFrontOfQueue(int i4) {
        this.mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(i4));
    }

    public final Message obtainMessage(int i4) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return Message.obtain(smHandler, i4);
    }

    public final void sendMessage(int i4, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(obtainMessage(i4, obj));
    }

    public final void sendMessageAtFrontOfQueue(Message message) {
        this.mSmHandler.sendMessageAtFrontOfQueue(message);
    }

    public final void sendMessageDelayed(int i4, Object obj, long j4) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i4, obj), j4);
    }

    public final Message obtainMessage(int i4, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return Message.obtain(smHandler, i4, obj);
    }

    public final void sendMessage(Message message) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(message);
    }

    public final void sendMessageDelayed(Message message, long j4) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(message, j4);
    }

    public StateMachine(String str, Looper looper) {
        initStateMachine(str, looper);
    }

    public final Message obtainMessage(int i4, int i5, int i6) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return Message.obtain(smHandler, i4, i5, i6);
    }

    public final Message obtainMessage(int i4, int i5, int i6, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return Message.obtain(smHandler, i4, i5, i6, obj);
    }
}
