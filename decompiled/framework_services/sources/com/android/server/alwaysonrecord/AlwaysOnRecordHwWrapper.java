package com.android.server.alwaysonrecord;

import android.media.MediaMetrics;
import android.media.audio.common.AudioChannelLayout;
import android.media.audio.common.AudioConfigBase;
import android.media.audio.common.AudioFormatDescription;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import android.util.Slog;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import vendor.bytedance.hardware.alwaysonrecord.AlwaysOnRecordConfig;
import vendor.bytedance.hardware.alwaysonrecord.IAlwaysOnRecordHw;
import vendor.bytedance.hardware.alwaysonrecord.IAlwaysOnRecordHwCallback;

/* JADX INFO: loaded from: classes.dex */
public class AlwaysOnRecordHwWrapper {
    static final int LOG_NB_EVENTS_DATA_AVAILABLE = 256;
    private static final String mMetricsId = "audio.alwaysOnRecord.service.";
    private final int DEFAULT_CHANNEL_LAYOUT;
    private final byte DEFAULT_PCM_TYPE;
    private final byte DEFAULT_RECORD_MODE;
    private final int DEFAULT_SAMPLE_RATE;
    private final int INVALID_HAL_HANDLE;
    private final long MIN_WAKEUP_PERIOD_IN_MINIMUTE;
    private final int MSG_AIDL_SERVICE_DIED;
    private final String TAG;
    private AlwaysOnRecordHwCallback mCallback;
    private HwStateContext mContext;
    final EventLogger mDataAvailableEventLogger;
    private AidlServiceDeathRecipient mDeathRecipient;
    private IAlwaysOnRecordHw mHal;
    private int mHandle;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private HwState mIdleState;
    private HwState mInitState;
    private AudioDataListener mListener;
    private final Object mListenerLock;
    private long mMinWakeupPeriodInMinute;
    private AlwaysOnRecordDataParser mParser;
    private HwState mPreparedState;
    private HwState mStartedState;

    private class AidlServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        public AidlServiceDeathRecipient(AlwaysOnRecordHwWrapper r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.e("AlwaysOnRecordHwWrapper", "HAL AIDL service died");
            this.this$0.logServiceResetMetrics();
            AlwaysOnRecordHwWrapper.m1064$$Nest$mresetHalAidlService(this.this$0);
            AlwaysOnRecordHwWrapper.m1053$$Nest$fgetmHandler(this.this$0).obtainMessage(1).sendToTarget();
        }
    }

    private class AlwaysOnRecordHwCallback extends IAlwaysOnRecordHwCallback.Stub {
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        public static /* synthetic */ void $r8$lambda$YBYX9VaWg3cC4kXkoumIxaPknVU(AlwaysOnRecordHwCallback r0, AtomicInteger r1, AlwaysOnRecordDataParser.AudioDataSegmentParameter r2) {
            r0.lambda$onAudioDataAvailable$0(r1, r2);
        }

        public AlwaysOnRecordHwCallback(AlwaysOnRecordHwWrapper r1) {
            this.this$0 = r1;
        }

        public int onAudioDataAvailable(int handle, ParcelFileDescriptor dataFd, int dataSize) {
            if (handle == AlwaysOnRecordHwWrapper.m1052$$Nest$fgetmHandle(this.this$0)) goto L6;
            Log.e("AlwaysOnRecordHwWrapper", "Invalid handle from HAL");
            this.this$0.mDataAvailableEventLogger.enqueue(new AlwaysOnRecordEvents.DataAvailableEvent(0, 0, dataSize, "Invalid handle from HAL"));
            return 1;
        L6:
            if (dataFd != null) goto L9;
            Log.e("AlwaysOnRecordHwWrapper", "Invalid fd from HAL");
            this.this$0.mDataAvailableEventLogger.enqueue(new AlwaysOnRecordEvents.DataAvailableEvent(0, 0, dataSize, "Invalid fd from HAL"));
            return 1;
        L9:
            Object r0 = AlwaysOnRecordHwWrapper.m1057$$Nest$fgetmListenerLock(this.this$0);
            monitor-enter(r0);
        L16:
            th = move-exception;
            throw th;
        L12:
            if (AlwaysOnRecordHwWrapper.m1056$$Nest$fgetmListener(this.this$0) != null) goto L18;
            Log.w("AlwaysOnRecordHwWrapper", "No listener registered, skip to parse data");     // Catch: Throwable -> L16
            this.this$0.mDataAvailableEventLogger.enqueue(new AlwaysOnRecordEvents.DataAvailableEvent(0, 0, dataSize, "No listener registered"));     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            return 0;
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L16
            SharedMemory sharedMemory = SharedMemory.fromFileDescriptor(dataFd);
            ByteBuffer buffer = sharedMemory.mapReadWrite();     // Catch: ErrnoException -> L33
            if (buffer != null) goto L23;
        L31:
            Log.e("AlwaysOnRecordHwWrapper", "No data from HAL");
            SharedMemory.unmap(buffer);
            sharedMemory.close();
            return 1;
        L23:
            if (buffer.remaining() == 0) goto L31;
            final AtomicInteger countAtomic = new AtomicInteger(0);
            int segmentCount = AlwaysOnRecordHwWrapper.m1058$$Nest$fgetmParser(this.this$0).parse(buffer, new AlwaysOnRecordHwWrapper$AlwaysOnRecordHwCallback$$ExternalSyntheticLambda0(this, countAtomic));
            EventLogger r5 = this.this$0.mDataAvailableEventLogger;
            int r7 = countAtomic.get();
            if (segmentCount >= 0) goto L28;
            String r8 = "Parse error";
        L29:
            r5.enqueue(new AlwaysOnRecordEvents.DataAvailableEvent(segmentCount, r7, dataSize, r8));
            SharedMemory.unmap(buffer);
            sharedMemory.close();
            return 0;
        L28:
            r8 = "Success";
        L34:
            Log.e("AlwaysOnRecordHwWrapper", "Fail to map fd to shared memory");
            return 4;
        }

        private /* synthetic */ void lambda$onAudioDataAvailable$0(AtomicInteger countAtomic, AlwaysOnRecordDataParser.AudioDataSegmentParameter segmentParam) {
            Object r1 = AlwaysOnRecordHwWrapper.m1057$$Nest$fgetmListenerLock(this.this$0);
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (AlwaysOnRecordHwWrapper.m1056$$Nest$fgetmListener(this.this$0) != null) goto L7;
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L7:
            if (AlwaysOnRecordHwWrapper.m1056$$Nest$fgetmListener(this.this$0).onAudioDataReady(segmentParam.timestamp, segmentParam.duration, segmentParam.buffer) == false) goto L11;
            countAtomic.incrementAndGet();     // Catch: Throwable -> L9
            this.this$0.logSaveDataMetrics(segmentParam.timestamp, segmentParam.buffer.limit());     // Catch: Throwable -> L9
            goto L11
        }

        public int getInterfaceVersion() {
            return 1;
        }

        public String getInterfaceHash() {
            return "47bf2c05945f1c11e13b61309a15a1e8ce98f1ad";
        }
    }

    public interface AudioDataListener {
        void onAudioConfigUpated(int r1, int r2, int r3);

        boolean onAudioDataReady(long r1, long r3, ByteBuffer r5);
    }

    private class DataParser implements AlwaysOnRecordDataParser.AudioDataParserListener {
        private DataParser(AlwaysOnRecordHwWrapper r1) {
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordDataParser.AudioDataParserListener
        public void onAudioDataSegmentParsed(AlwaysOnRecordDataParser.AudioDataSegmentParameter segmentParam) {
            Log.d("AlwaysOnRecordHwWrapper", "onAudioDataSegmentParsed: " + segmentParam);
        }
    }

    private static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event DESTROY = null;
        public static final Event FORCE_SYNC = null;
        public static final Event INITIALIZE = null;
        public static final Event PREPARE = null;
        public static final Event START_RECORD = null;
        public static final Event STOP_RECORD = null;

        private static /* synthetic */ Event[] $values() {
            return new Event[]{INITIALIZE, PREPARE, DESTROY, START_RECORD, STOP_RECORD, FORCE_SYNC};
        }

        private Event(String r1, int r2) {
            super(r1, r2);
        }

        public static Event valueOf(String name) {
            return (Event) Enum.valueOf(Event.class, name);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        static {
            INITIALIZE = new Event("INITIALIZE", 0);
            PREPARE = new Event("PREPARE", 1);
            DESTROY = new Event("DESTROY", 2);
            START_RECORD = new Event("START_RECORD", 3);
            STOP_RECORD = new Event("STOP_RECORD", 4);
            FORCE_SYNC = new Event("FORCE_SYNC", 5);
            $VALUES = $values();
        }
    }

    private class HwHandler extends Handler {
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        public HwHandler(AlwaysOnRecordHwWrapper r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L5:
            AlwaysOnRecordHwWrapper.m1051$$Nest$fgetmContext(this.this$0).restoreState();
        }
    }

    private class HwIdleState implements HwState {
        HwStateContext mContext;
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        HwIdleState(AlwaysOnRecordHwWrapper r1, HwStateContext context) {
            this.this$0 = r1;
            this.mContext = context;
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public int processEvent(Event event) {
            switch(event.ordinal()) {
                case 0: goto L6;
                default: goto L4;
            };
        L4:
            Log.e("AlwaysOnRecordHwWrapper", "Invalid event: " + event.toString() + " in State " + getState().toString());
            return -3;
        L6:
            int state = AlwaysOnRecordHwWrapper.m1062$$Nest$mconnectToHalAidlService(this.this$0);
            if (state != 0) goto L9;
            this.mContext.setState(AlwaysOnRecordHwWrapper.m1055$$Nest$fgetmInitState(this.this$0));
        L9:
            return state;
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public State getState() {
            return State.IDLE;
        }
    }

    private class HwInitState implements HwState {
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        HwInitState(AlwaysOnRecordHwWrapper r1, HwStateContext context) {
            this.this$0 = r1;
            AlwaysOnRecordHwWrapper.m1061$$Nest$fputmContext(r1, context);
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public int processEvent(Event event) {
            switch(event.ordinal()) {
                case 1: goto L6;
                default: goto L4;
            };
        L4:
            Log.e("AlwaysOnRecordHwWrapper", "Invalid event: " + event.toString() + " in State " + getState().toString());
            return -3;
        L6:
            int state = this.this$0.prepareInternal();
            if (state != 0) goto L9;
            AlwaysOnRecordHwWrapper.m1051$$Nest$fgetmContext(this.this$0).setState(AlwaysOnRecordHwWrapper.m1059$$Nest$fgetmPreparedState(this.this$0));
        L9:
            return state;
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public State getState() {
            return State.INIT;
        }
    }

    private class HwPreparedState implements HwState {
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        HwPreparedState(AlwaysOnRecordHwWrapper r1, HwStateContext context) {
            this.this$0 = r1;
            AlwaysOnRecordHwWrapper.m1061$$Nest$fputmContext(r1, context);
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public int processEvent(Event event) {
            switch(event.ordinal()) {
                case 0: goto L15;
                case 1: goto L15;
                case 2: goto L10;
                case 3: goto L6;
                default: goto L4;
            };
        L4:
            Log.e("AlwaysOnRecordHwWrapper", "Invalid event: " + event.toString() + " in State " + getState().toString());
            return -3;
        L6:
            int state = AlwaysOnRecordHwWrapper.m1065$$Nest$mstartRecordInternal(this.this$0);
            if (state != 0) goto L9;
            AlwaysOnRecordHwWrapper.m1051$$Nest$fgetmContext(this.this$0).setState(AlwaysOnRecordHwWrapper.m1060$$Nest$fgetmStartedState(this.this$0));
        L9:
            return state;
        L10:
            int state2 = this.this$0.destroyInternal();
            if (state2 == 0) goto L13;
            Log.e("AlwaysOnRecordHwWrapper", "fail to destroy, state: " + state2);
        L13:
            AlwaysOnRecordHwWrapper.m1051$$Nest$fgetmContext(this.this$0).setState(AlwaysOnRecordHwWrapper.m1055$$Nest$fgetmInitState(this.this$0));
            return state2;
        L15:
            return 0;
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public State getState() {
            return State.PREPARED;
        }
    }

    private class HwStartedState implements HwState {
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        HwStartedState(AlwaysOnRecordHwWrapper r1, HwStateContext context) {
            this.this$0 = r1;
            AlwaysOnRecordHwWrapper.m1061$$Nest$fputmContext(r1, context);
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public int processEvent(Event event) {
            switch(event.ordinal()) {
                case 0: goto L12;
                case 1: goto L12;
                case 2: goto L4;
                case 3: goto L12;
                case 4: goto L8;
                case 5: goto L7;
                default: goto L4;
            };
        L4:
            Log.e("AlwaysOnRecordHwWrapper", "Invalid event: " + event.toString() + " in State " + getState().toString());
            return -3;
        L8:
            int state = AlwaysOnRecordHwWrapper.m1066$$Nest$mstopRecordInternal(this.this$0);
            if (state != 0) goto L11;
            AlwaysOnRecordHwWrapper.m1051$$Nest$fgetmContext(this.this$0).setState(AlwaysOnRecordHwWrapper.m1059$$Nest$fgetmPreparedState(this.this$0));
        L11:
            return state;
        L12:
            return 0;
        L7:
            return AlwaysOnRecordHwWrapper.m1063$$Nest$mforceSyncRecordInternal(this.this$0);
        }

        @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.HwState
        public State getState() {
            return State.STARTED;
        }
    }

    private interface HwState {
        State getState();

        int processEvent(Event r1);
    }

    private class HwStateContext {
        private HwState mState;
        final /* synthetic */ AlwaysOnRecordHwWrapper this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
        static /* bridge */ /* synthetic */ HwState m1067$$Nest$fgetmState(HwStateContext r0) {
            return r0.mState;
        }

        public HwStateContext(AlwaysOnRecordHwWrapper r1) {
            this.this$0 = r1;
        }

        public void setState(HwState state) {
            this.mState = state;
        }

        public int processEvent(Event event) {
            return this.mState.processEvent(event);
        }

        public int restoreState() {
            Log.d("AlwaysOnRecordHwWrapper", "restoreState to " + this.mState.getState().toString());
            switch(this.mState.getState().ordinal()) {
                case 1: goto L21;
                case 2: goto L15;
                case 3: goto L6;
                default: goto L4;
            };
        L4:
            Log.e("AlwaysOnRecordHwWrapper", "No need to restore. state: " + this.mState.getState().toString());
            return 0;
        L6:
            if (AlwaysOnRecordHwWrapper.m1054$$Nest$fgetmIdleState(this.this$0).processEvent(Event.INITIALIZE) == 0) goto L9;
            setState(AlwaysOnRecordHwWrapper.m1054$$Nest$fgetmIdleState(this.this$0));
            return 0;
        L9:
            if (AlwaysOnRecordHwWrapper.m1055$$Nest$fgetmInitState(this.this$0).processEvent(Event.PREPARE) == 0) goto L12;
            setState(AlwaysOnRecordHwWrapper.m1055$$Nest$fgetmInitState(this.this$0));
            return 0;
        L12:
            if (AlwaysOnRecordHwWrapper.m1059$$Nest$fgetmPreparedState(this.this$0).processEvent(Event.START_RECORD) == 0) goto L28;
            setState(AlwaysOnRecordHwWrapper.m1059$$Nest$fgetmPreparedState(this.this$0));
            return 0;
        L28:
            return 0;
        L15:
            if (AlwaysOnRecordHwWrapper.m1054$$Nest$fgetmIdleState(this.this$0).processEvent(Event.INITIALIZE) == 0) goto L18;
            setState(AlwaysOnRecordHwWrapper.m1054$$Nest$fgetmIdleState(this.this$0));
            return 0;
        L18:
            if (AlwaysOnRecordHwWrapper.m1055$$Nest$fgetmInitState(this.this$0).processEvent(Event.PREPARE) == 0) goto L31;
            setState(AlwaysOnRecordHwWrapper.m1055$$Nest$fgetmInitState(this.this$0));
            return 0;
        L31:
            return 0;
        L21:
            if (AlwaysOnRecordHwWrapper.m1054$$Nest$fgetmIdleState(this.this$0).processEvent(Event.INITIALIZE) == 0) goto L33;
            setState(AlwaysOnRecordHwWrapper.m1054$$Nest$fgetmIdleState(this.this$0));
            return 0;
        L33:
            return 0;
        }
    }

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State IDLE = null;
        public static final State INIT = null;
        public static final State PREPARED = null;
        public static final State STARTED = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{IDLE, INIT, PREPARED, STARTED};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String name) {
            return (State) Enum.valueOf(State.class, name);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            IDLE = new State("IDLE", 0);
            INIT = new State("INIT", 1);
            PREPARED = new State("PREPARED", 2);
            STARTED = new State("STARTED", 3);
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ HwStateContext m1051$$Nest$fgetmContext(AlwaysOnRecordHwWrapper r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandle, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1052$$Nest$fgetmHandle(AlwaysOnRecordHwWrapper r0) {
        return r0.mHandle;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m1053$$Nest$fgetmHandler(AlwaysOnRecordHwWrapper r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdleState, reason: not valid java name */
    static /* bridge */ /* synthetic */ HwState m1054$$Nest$fgetmIdleState(AlwaysOnRecordHwWrapper r0) {
        return r0.mIdleState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInitState, reason: not valid java name */
    static /* bridge */ /* synthetic */ HwState m1055$$Nest$fgetmInitState(AlwaysOnRecordHwWrapper r0) {
        return r0.mInitState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioDataListener m1056$$Nest$fgetmListener(AlwaysOnRecordHwWrapper r0) {
        return r0.mListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListenerLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1057$$Nest$fgetmListenerLock(AlwaysOnRecordHwWrapper r0) {
        return r0.mListenerLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmParser, reason: not valid java name */
    static /* bridge */ /* synthetic */ AlwaysOnRecordDataParser m1058$$Nest$fgetmParser(AlwaysOnRecordHwWrapper r0) {
        return r0.mParser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPreparedState, reason: not valid java name */
    static /* bridge */ /* synthetic */ HwState m1059$$Nest$fgetmPreparedState(AlwaysOnRecordHwWrapper r0) {
        return r0.mPreparedState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStartedState, reason: not valid java name */
    static /* bridge */ /* synthetic */ HwState m1060$$Nest$fgetmStartedState(AlwaysOnRecordHwWrapper r0) {
        return r0.mStartedState;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1061$$Nest$fputmContext(AlwaysOnRecordHwWrapper r0, HwStateContext r1) {
        r0.mContext = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectToHalAidlService, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1062$$Nest$mconnectToHalAidlService(AlwaysOnRecordHwWrapper r0) {
        return r0.connectToHalAidlService();
    }

    /* JADX INFO: renamed from: -$$Nest$mforceSyncRecordInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1063$$Nest$mforceSyncRecordInternal(AlwaysOnRecordHwWrapper r0) {
        return r0.forceSyncRecordInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mresetHalAidlService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1064$$Nest$mresetHalAidlService(AlwaysOnRecordHwWrapper r0) {
        r0.resetHalAidlService();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartRecordInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1065$$Nest$mstartRecordInternal(AlwaysOnRecordHwWrapper r0) {
        return r0.startRecordInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopRecordInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1066$$Nest$mstopRecordInternal(AlwaysOnRecordHwWrapper r0) {
        return r0.stopRecordInternal();
    }

    public AlwaysOnRecordHwWrapper() {
        this.TAG = "AlwaysOnRecordHwWrapper";
        this.DEFAULT_SAMPLE_RATE = 16000;
        this.DEFAULT_CHANNEL_LAYOUT = 1;
        this.DEFAULT_PCM_TYPE = 1;
        this.DEFAULT_RECORD_MODE = 0;
        this.INVALID_HAL_HANDLE = -1;
        this.MSG_AIDL_SERVICE_DIED = 1;
        this.MIN_WAKEUP_PERIOD_IN_MINIMUTE = 1;
        this.mDeathRecipient = new AidlServiceDeathRecipient(this);
        this.mHandle = -1;
        this.mMinWakeupPeriodInMinute = 1;
        this.mParser = new AlwaysOnRecordDataParser();
        this.mListenerLock = new Object();
        this.mDataAvailableEventLogger = new EventLogger(256, "Data availble to save");
        this.mHandlerThread = new HandlerThread("AlwaysOnRecordHwWrapper");
        this.mHandlerThread.start();
        this.mHandler = new HwHandler(this, this.mHandlerThread.getLooper());
        this.mContext = new HwStateContext(this);
        this.mIdleState = new HwIdleState(this, this.mContext);
        this.mInitState = new HwInitState(this, this.mContext);
        this.mPreparedState = new HwPreparedState(this, this.mContext);
        this.mStartedState = new HwStartedState(this, this.mContext);
        this.mContext.setState(this.mIdleState);
        this.mContext.processEvent(Event.INITIALIZE);
        this.mCallback = new AlwaysOnRecordHwCallback(this);
    }

    private synchronized int connectToHalAidlService() {
        monitor-enter(this);
        String aidlServiceName = IAlwaysOnRecordHw.class.getCanonicalName() + "/default";     // Catch: Throwable -> L9
        if (ServiceManager.isDeclared(aidlServiceName) == false) goto L15;
        Log.d("AlwaysOnRecordHwWrapper", "Connecting to default alwaysonrecord.IAlwaysOnRecordHw");     // Catch: Throwable -> L9
        IBinder binder = ServiceManager.waitForService(aidlServiceName);     // Catch: Throwable -> L9
        this.mHal = IAlwaysOnRecordHw.Stub.asInterface(binder);     // Catch: Throwable -> L9
        this.mHal.asBinder().linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L9 RemoteException -> L11
        monitor-exit(this);
        return 0;
    L11:
        e = move-exception;
        Log.w("AlwaysOnRecordHwWrapper", "Could not link to client death", e);     // Catch: Throwable -> L9
        return -1;
    L15:
        Slog.w("AlwaysOnRecordHwWrapper", "AIDL service " + aidlServiceName + " is not declared.");     // Catch: Throwable -> L9
        monitor-exit(this);
        return -1;
    L9:
        th = move-exception;
        throw th;
    }

    private synchronized void resetHalAidlService() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mHal == null) goto L9;
        this.mHal.asBinder().unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L7
        this.mHal = null;     // Catch: Throwable -> L7
        this.mHandle = -1;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public long getMinWakeupPeriodInMinute() {
        return this.mMinWakeupPeriodInMinute;
    }

    public boolean isReady() {
        if (this.mHal != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mHandle == (-1)) goto L7;
        return true;
    }

    public boolean isStarted() {
        if (HwStateContext.m1067$$Nest$fgetmState(this.mContext).getState() != State.STARTED) goto L5;
        return true;
    L5:
        return false;
    }

    public int prepare() {
        return this.mContext.processEvent(Event.PREPARE);
    }

    public synchronized int prepareInternal() {
        monitor-enter(this);
        Log.d("AlwaysOnRecordHwWrapper", "prepare");     // Catch: Throwable -> L17
        AlwaysOnRecordConfig config = new AlwaysOnRecordConfig();     // Catch: Throwable -> L17
        config.mode = 0;     // Catch: Throwable -> L17
        config.base = constructDefaultAudioConfig();     // Catch: Throwable -> L17
        Log.d("AlwaysOnRecordHwWrapper", "prepare config: " + config.toString());     // Catch: Throwable -> L17
        this.mHandle = this.mHal.prepare(config, this.mCallback);     // Catch: Throwable -> L17 RemoteException -> L21
        Object r2 = this.mListenerLock;     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
    L10:
        th = th;
    L31:
        throw th;     // Catch: Throwable -> L17
    L19:
        th = th;
        goto L31
    L8:
        if (this.mListener == null) goto L12;
        this.mListener.onAudioConfigUpated(16000, getChannelCount(1), getBitsPerSample((byte) 1));     // Catch: Throwable -> L10
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return 0;
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public int destroy() {
        return this.mContext.processEvent(Event.DESTROY);
    }

    public synchronized int destroyInternal() {
        monitor-enter(this);
        Log.d("AlwaysOnRecordHwWrapper", "destroyInternal");     // Catch: Throwable -> L12
        if (this.mHal != null) goto L19;
        monitor-exit(this);
        return -1;
    L19:
        this.mHandle = this.mHal.destroy(this.mHandle);     // Catch: Throwable -> L12 RemoteException -> L14
        monitor-exit(this);
        return 0;
    L14:
        e = move-exception;
        Slog.e("AlwaysOnRecordHwWrapper", e.toString());     // Catch: Throwable -> L12
        e.printStackTrace();     // Catch: Throwable -> L12
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public int startRecord() {
        int status = this.mContext.processEvent(Event.START_RECORD);
        logStartMetrics(status);
        return status;
    }

    private synchronized int startRecordInternal() {
        monitor-enter(this);
        Log.d("AlwaysOnRecordHwWrapper", "startRecord: " + this.mHandle);     // Catch: Throwable -> L12
        if (this.mHal != null) goto L19;
        monitor-exit(this);
        return -1;
    L19:
        this.mHal.startRecordInBackground(this.mHandle);     // Catch: Throwable -> L12 RemoteException -> L14
        monitor-exit(this);
        return 0;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public int forceSyncRecord() {
        int status = this.mContext.processEvent(Event.FORCE_SYNC);
        logForceSyncMetrics(status);
        return status;
    }

    private synchronized int forceSyncRecordInternal() {
        monitor-enter(this);
        Log.d("AlwaysOnRecordHwWrapper", "forceSyncRecordInternal: " + this.mHandle);     // Catch: Throwable -> L12
        if (this.mHal != null) goto L29;
        monitor-exit(this);
        return -1;
    L29:
        this.mHal.forceSyncRecordInBackground(this.mHandle);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        monitor-exit(this);
        return 0;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L12
    L14:
        e = move-exception;
        Log.e("AlwaysOnRecordHwWrapper", "ServiceSpecificException: " + e.getMessage());     // Catch: Throwable -> L12
        return -3;
    L12:
        th = move-exception;
        throw th;
    }

    public int stopRecord() {
        int status = this.mContext.processEvent(Event.STOP_RECORD);
        logStopMetrics(status);
        return status;
    }

    private synchronized int stopRecordInternal() {
        monitor-enter(this);
        Log.d("AlwaysOnRecordHwWrapper", "stopRecord: " + this.mHandle);     // Catch: Throwable -> L12
        if (this.mHal != null) goto L19;
        monitor-exit(this);
        return -1;
    L19:
        this.mHal.stopRecordInBackground(this.mHandle);     // Catch: Throwable -> L12 RemoteException -> L14
        monitor-exit(this);
        return 0;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private AudioConfigBase constructDefaultAudioConfig() {
        AudioConfigBase config = new AudioConfigBase();
        config.sampleRate = 16000;
        config.channelMask = AudioChannelLayout.layoutMask(1);
        config.format = new AudioFormatDescription();
        config.format.type = 1;
        config.format.pcm = 1;
        config.format.encoding = "audio/pcm";
        return config;
    }

    private int getChannelCount(int layout) {
        switch(layout) {
            case 1: goto L7;
            case 2: goto L3;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    L7:
        return 1;
    }

    private int getBitsPerSample(byte type) {
        switch(type) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L3;
            case 4: goto L3;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 24;
    L7:
        return 32;
    L9:
        return 16;
    L11:
        return 8;
    }

    public void registerListener(AudioDataListener listener) {
        Object r0 = this.mListenerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mListener == null) goto L11;
        Log.w("AlwaysOnRecordHwWrapper", "Listener already registered");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mListener = listener;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void unregisterListener() {
        Object r0 = this.mListenerLock;
        monitor-enter(r0);
        this.mListener = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void logStartMetrics(int status) {
        logMetrics(IMediaProjectionManagerServiceExt.NODE_START, status);
    }

    public void logSaveDataMetrics(long timestampInMs, int dataSize) {
        MediaMetrics.Item mmi = new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "saveDataFile").set(MediaMetrics.Property.ID, Integer.valueOf(this.mHandle)).set(MediaMetrics.Property.DATA_SIZE, Integer.valueOf(dataSize)).setTimestamp(1000000 * timestampInMs);
        mmi.record();
    }

    public void logForceSyncMetrics(int status) {
        logMetrics("forceSync", status);
    }

    public void logStopMetrics(int status) {
        logMetrics(IMediaProjectionManagerServiceExt.NODE_STOP, status);
    }

    public void logServiceResetMetrics() {
        logMetrics("serviceReset", 0);
    }

    public void logMetrics(String operation, int status) {
        MediaMetrics.Item mmi = new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, operation).set(MediaMetrics.Property.ID, Integer.valueOf(this.mHandle)).set(MediaMetrics.Property.STATUS, Integer.valueOf(status));
        mmi.record();
    }

    public void dump(PrintWriter pw) {
        pw.println("- HAL handle = " + this.mHandle);
        StringBuilder r0 = new StringBuilder();
        r0.append("- HAL aidl service = ");
        if (this.mHal == null) goto L5;
        String r1 = "Ready";
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        pw.println("- HAL state = " + HwStateContext.m1067$$Nest$fgetmState(this.mContext).getState().toString());
        return;
    L5:
        r1 = "Not Exist";
        goto L6
    }
}
