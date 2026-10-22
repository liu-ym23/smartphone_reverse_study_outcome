package com.stepos.alphame.systemstate;

import B0.g;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.reflect.TelephonyManagerStepos;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.ReceiverUtils;
import com.stepos.alphame.utils.Utils;
import com.stepos.alphame.utils.state.State;
import com.stepos.alphame.utils.state.StateMachine;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SystemStateMachine extends StateMachine {
    private static final String INTENT_ACTION_IDLE = "com.stepos.alphame.system.idle";
    private static final String INTENT_ACTION_STANDBY = "com.stepos.alphame.system.standby";
    private static final int MSG_SCREEN_OFF = 2;
    private static final int MSG_SCREEN_ON = 1;
    private static final int MSG_SCRREN_OFF_30_MINUTES = 4;
    private static final int MSG_SCRREN_OFF_3_MINUTES = 3;
    private static final int MSG_SLEEP_END = 6;
    private static final int MSG_SLEEP_START = 5;
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_IDLE = 3;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_SLEEP = 5;
    public static final int STATE_STANDBY = 4;
    public static final String TAG = "SystemStateMachine";
    private static final int TIME_TO_IDLE = 180000;
    private static final int TIME_TO_STANDBY = 1800000;
    private State mActiveState;
    private AlarmManager mAlarmManager;
    private AlarmBroadcastReceiver mAlarmReceiver;
    private Context mContext;
    private int mCurrentState;
    private State mIdleState;
    private ArrayList<IStateChangeListener> mListener;
    private State mPauseState;
    private b mScreenEventReceiver;
    private State mSleepState;
    private State mStandbyState;
    private PendingIntent mSystemStatePIntent;
    public static final boolean DEBUG = Utils.DEBUG.get();

    @SuppressLint({"StaticFieldLeak"})
    private static SystemStateMachine mInstance = null;

    public class ActiveState extends State {
        public /* synthetic */ ActiveState(SystemStateMachine systemStateMachine, int i4) {
            this();
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public void enter() {
            SystemStateMachine.this.notifyStateChange(1);
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public boolean processMessage(Message message) {
            if (message.what != 2) {
                return false;
            }
            SystemStateMachine systemStateMachine = SystemStateMachine.this;
            systemStateMachine.transitionTo(systemStateMachine.mPauseState);
            return true;
        }

        private ActiveState() {
        }
    }

    public class AlarmBroadcastReceiver extends BroadcastReceiver {
        public /* synthetic */ AlarmBroadcastReceiver(SystemStateMachine systemStateMachine, int i4) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || action.length() <= 0) {
                if (SystemStateMachine.DEBUG) {
                    Log.e(SystemStateMachine.TAG, "receive a null intent");
                    return;
                }
                return;
            }
            AlphaMeLogger.debugLog("receive intent: ".concat(action));
            SystemStateMachine.this.mSystemStatePIntent = null;
            if (SystemStateMachine.INTENT_ACTION_IDLE.equals(action)) {
                SystemStateMachine.this.sendMessage(3);
            } else if (SystemStateMachine.INTENT_ACTION_STANDBY.equals(action)) {
                SystemStateMachine.this.sendMessage(4);
            }
        }

        private AlarmBroadcastReceiver() {
        }
    }

    public interface IStateChangeListener {
        void onStateChange(int i4);
    }

    public class IdleState extends State {
        public /* synthetic */ IdleState(SystemStateMachine systemStateMachine, int i4) {
            this();
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public void enter() {
            SystemStateMachine.this.notifyStateChange(3);
            SystemStateMachine.this.setupSystemStandbyAlarm();
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public boolean processMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                SystemStateMachine systemStateMachine = SystemStateMachine.this;
                systemStateMachine.transitionTo(systemStateMachine.mActiveState);
                SystemStateMachine.this.cleanSystemStandbyAlarm();
            } else {
                if (i4 != 4) {
                    return false;
                }
                SystemStateMachine systemStateMachine2 = SystemStateMachine.this;
                systemStateMachine2.transitionTo(systemStateMachine2.mStandbyState);
            }
            return true;
        }

        private IdleState() {
        }
    }

    public class PauseState extends State {
        public /* synthetic */ PauseState(SystemStateMachine systemStateMachine, int i4) {
            this();
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public void enter() {
            SystemStateMachine.this.notifyStateChange(2);
            SystemStateMachine.this.setupSystemIdleAlarm();
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public boolean processMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                SystemStateMachine systemStateMachine = SystemStateMachine.this;
                systemStateMachine.transitionTo(systemStateMachine.mActiveState);
                SystemStateMachine.this.cleanSystemIdleAlarm();
            } else {
                if (i4 != 3) {
                    return false;
                }
                SystemStateMachine systemStateMachine2 = SystemStateMachine.this;
                systemStateMachine2.transitionTo(systemStateMachine2.mIdleState);
            }
            return true;
        }

        private PauseState() {
        }
    }

    public class SleepState extends State {
        public /* synthetic */ SleepState(SystemStateMachine systemStateMachine, int i4) {
            this();
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public void enter() {
            SystemStateMachine.this.notifyStateChange(5);
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public boolean processMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                SystemStateMachine systemStateMachine = SystemStateMachine.this;
                systemStateMachine.transitionTo(systemStateMachine.mActiveState);
            } else {
                if (i4 != 6) {
                    return false;
                }
                SystemStateMachine systemStateMachine2 = SystemStateMachine.this;
                systemStateMachine2.transitionTo(systemStateMachine2.mStandbyState);
            }
            return true;
        }

        private SleepState() {
        }
    }

    public class StandbyState extends State {
        public /* synthetic */ StandbyState(SystemStateMachine systemStateMachine, int i4) {
            this();
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public void enter() {
            SystemStateMachine.this.notifyStateChange(4);
        }

        @Override // com.stepos.alphame.utils.state.State, com.stepos.alphame.utils.state.IState
        public boolean processMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                SystemStateMachine systemStateMachine = SystemStateMachine.this;
                systemStateMachine.transitionTo(systemStateMachine.mActiveState);
            } else {
                if (i4 != 5) {
                    return false;
                }
                SystemStateMachine systemStateMachine2 = SystemStateMachine.this;
                systemStateMachine2.transitionTo(systemStateMachine2.mSleepState);
            }
            return true;
        }

        private StandbyState() {
        }
    }

    public SystemStateMachine() {
        super(TAG);
        this.mAlarmManager = null;
        this.mSystemStatePIntent = null;
        this.mListener = new ArrayList<>();
        this.mCurrentState = 1;
        int i4 = 0;
        this.mActiveState = new ActiveState(this, i4);
        this.mPauseState = new PauseState(this, i4);
        this.mIdleState = new IdleState(this, i4);
        this.mStandbyState = new StandbyState(this, i4);
        this.mSleepState = new SleepState(this, i4);
        this.mAlarmReceiver = new AlarmBroadcastReceiver(this, i4);
        this.mScreenEventReceiver = new b("SCREEN_EVENT") { // from class: com.stepos.alphame.systemstate.SystemStateMachine.1
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str, Object obj) {
                if (obj != null) {
                    int iIntValue = ((Integer) obj).intValue();
                    if (SystemStateMachine.DEBUG) {
                        g.z("receive screen state: ", iIntValue, SystemStateMachine.TAG);
                    }
                    if (iIntValue == 1) {
                        SystemStateMachine.this.sendMessage(1);
                    } else {
                        if (TelephonyManagerStepos.getCallState(SystemStateMachine.this.mContext) != 0) {
                            return;
                        }
                        SystemStateMachine.this.sendMessage(2);
                    }
                }
            }
        };
        initVariable();
        addState(this.mActiveState);
        addState(this.mPauseState);
        addState(this.mIdleState);
        addState(this.mStandbyState);
        if (((PowerManager) ApplicationImpl.getApplication().getSystemService("power")).isInteractive()) {
            this.mCurrentState = 1;
            setInitialState(this.mActiveState);
        } else {
            this.mCurrentState = 2;
            setInitialState(this.mPauseState);
        }
        start();
    }

    private void cleanAlarm() {
        PendingIntent pendingIntent = this.mSystemStatePIntent;
        AlarmManager alarmManager = this.mAlarmManager;
        this.mSystemStatePIntent = null;
        if (pendingIntent == null || alarmManager == null) {
            return;
        }
        try {
            alarmManager.cancel(pendingIntent);
        } catch (Exception e4) {
            Log.w(TAG, "" + e4.getMessage());
        }
    }

    public static synchronized SystemStateMachine getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new SystemStateMachine();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private void initVariable() {
        ApplicationImpl application = ApplicationImpl.getApplication();
        this.mContext = application;
        this.mAlarmManager = (AlarmManager) application.getSystemService("alarm");
        c.f11224a.f(this.mScreenEventReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(INTENT_ACTION_IDLE);
        intentFilter.addAction(INTENT_ACTION_STANDBY);
        ReceiverUtils.registerReceiverExported(this.mContext, this.mAlarmReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStateChange(int i4) {
        this.mCurrentState = i4;
        synchronized (this.mListener) {
            try {
                Iterator<IStateChangeListener> it = this.mListener.iterator();
                while (it.hasNext()) {
                    it.next().onStateChange(i4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(34)
    private PendingIntent setupAlarm(String str, PendingIntent pendingIntent, int i4, int i5) {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 0, new Intent(str), 184549376);
        this.mAlarmManager.setExact(i4, SystemClock.elapsedRealtime() + i5, broadcast);
        if (DEBUG) {
            Log.d(TAG, "set alarm " + str);
        }
        return broadcast;
    }

    public void cleanSystemIdleAlarm() {
        cleanAlarm();
        if (DEBUG) {
            Log.d(TAG, "cleanSystemIdleAlarm");
        }
    }

    public void cleanSystemStandbyAlarm() {
        cleanAlarm();
        if (DEBUG) {
            Log.d(TAG, "cleanSystemStandbyAlarm");
        }
    }

    public int getTrackedSystemState() {
        return this.mCurrentState;
    }

    public void registerStateLister(IStateChangeListener iStateChangeListener) {
        Log.d(TAG, "Register listener " + iStateChangeListener);
        synchronized (this.mListener) {
            this.mListener.add(iStateChangeListener);
        }
    }

    public void removeStateLister(IStateChangeListener iStateChangeListener) {
        synchronized (this.mListener) {
            this.mListener.remove(iStateChangeListener);
        }
    }

    public void setupSystemIdleAlarm() {
        PendingIntent pendingIntent = this.mSystemStatePIntent;
        if (pendingIntent != null) {
            return;
        }
        this.mSystemStatePIntent = setupAlarm(INTENT_ACTION_IDLE, pendingIntent, 3, TIME_TO_IDLE);
        if (DEBUG) {
            Log.d(TAG, "set system idle alarm");
        }
    }

    public void setupSystemStandbyAlarm() {
        PendingIntent pendingIntent = this.mSystemStatePIntent;
        if (pendingIntent != null) {
            return;
        }
        this.mSystemStatePIntent = setupAlarm(INTENT_ACTION_STANDBY, pendingIntent, 3, 1800000);
        if (DEBUG) {
            Log.d(TAG, "set system standby alarm");
        }
    }
}
