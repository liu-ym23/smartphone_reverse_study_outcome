package com.android.server.location;

import android.location.Location;
import android.location.util.identity.CallerIdentity;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import com.android.internal.util.HexDump;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import com.android.server.ISmtResourceControl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class GPOStateMachine extends StateMachine {
    private static final int BLOCKED_STATE_TIMEOUT_MS = 2000;
    private static final String CLASS_REGISTRATION = "com.android.server.location.provider.LocationProviderManager$Registration";
    private static final String FEATURE_GPO_VERSION = "feature_gpo_version";
    private static final int FEATURE_GPO_VERSION_1 = 1;
    private static final int FEATURE_GPO_VERSION_2 = 2;
    private static final int FEATURE_GPO_VERSION_3 = 3;
    public static final int GPO_STATE_BLOCKED = 1;
    public static final int GPO_STATE_BLOCKED_LV1 = 2;
    public static final int GPO_STATE_BLOCKED_LV2 = 3;
    public static final int GPO_STATE_BLOCKED_LV3 = 4;
    public static final int GPO_STATE_CONTROLLED = 6;
    public static final int GPO_STATE_RUNNING = 5;
    public static final int GPO_STATE_STOPPED = 0;
    private static final int MAX_DISABLE_TIMEOUT_MS = 300000;
    private static final String METHOD_GET_IDENTITY = "getIdentity";
    public static final int MSG_BLOCKED_STATE_TIMEOUT = 7;
    public static final int MSG_INJECT_NLP_LOCATION = 5;
    public static final int MSG_REQUEST_ACTIVE = 3;
    public static final int MSG_REQUEST_INACTIVE = 4;
    public static final int MSG_REQUEST_NLP_TIMEOUT = 6;
    public static final int MSG_RESET_GLP_MAP = 8;
    public static final int MSG_START_REQUEST = 1;
    public static final int MSG_STOP_REQUEST = 2;
    private static final int REQUEST_NLP_TIMEOUT_MS = 2000;
    private static final String TAG = null;
    private static volatile GPOStateMachine sInstance;
    private final State STATE_BLOCKED;
    private final State STATE_BLOCKED_LV1;
    private final State STATE_BLOCKED_LV2;
    private final State STATE_BLOCKED_LV3;
    private final State STATE_CONTROLLED;
    private final State STATE_RUNNING;
    private final State STATE_STOPPED;
    private int mFeatureGpoVersion;
    private final AtomicBoolean mFlagCurDisableGpo;
    private final ConcurrentHashMap<String, Object> mGlpRequest;
    private List<GPOStateMachineListener> mListeners;
    private int mPrevState;
    private StarLocation mStarLocation;
    private final Object mStateLock;

    private abstract class BaseAdapterState extends State {
        final /* synthetic */ GPOStateMachine this$0;

        /* synthetic */ BaseAdapterState(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        abstract int getStateValue();

        private BaseAdapterState(GPOStateMachine r1) {
            this.this$0 = r1;
        }

        public void enter() {
            int curState = getStateValue();
            logd("entered");
            Object r1 = GPOStateMachine.m5125$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r1);
            int prevState = GPOStateMachine.m5123$$Nest$fgetmPrevState(this.this$0);     // Catch: Throwable -> L10
            if (prevState == curState) goto L12;
            GPOStateMachine.m5126$$Nest$fputmPrevState(this.this$0, curState);     // Catch: Throwable -> L10
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, GPOStateMachine.m5130$$Nest$mstateString(this.this$0, prevState) + " -> " + GPOStateMachine.m5130$$Nest$mstateString(this.this$0, curState));     // Catch: Throwable -> L10
            Iterator r3 = GPOStateMachine.m5122$$Nest$fgetmListeners(this.this$0).iterator();     // Catch: Throwable -> L10
        L8:
            if (r3.hasNext() == false) goto L12;
            GPOStateMachineListener listener = (GPOStateMachineListener) r3.next();     // Catch: Throwable -> L10
            listener.onStateChanged(prevState, curState);     // Catch: Throwable -> L10
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void exit() {
            logd("exited");
        }

        public boolean processMessage(Message msg) {
            logi(" <== " + GPOStateMachine.m5127$$Nest$mmessageString(this.this$0, msg.what));
            return true;
        }

        void logv(String msg) {
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).logv(GPOStateMachine.m5132$$Nest$sfgetTAG(), GPOStateMachine.m5130$$Nest$mstateString(this.this$0, getStateValue()) + " : " + msg);
        }

        void logd(String msg) {
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).logd(GPOStateMachine.m5132$$Nest$sfgetTAG(), GPOStateMachine.m5130$$Nest$mstateString(this.this$0, getStateValue()) + " : " + msg);
        }

        void logi(String msg) {
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).logi(GPOStateMachine.m5132$$Nest$sfgetTAG(), GPOStateMachine.m5130$$Nest$mstateString(this.this$0, getStateValue()) + " : " + msg);
        }

        void loge(String msg) {
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).loge(GPOStateMachine.m5132$$Nest$sfgetTAG(), GPOStateMachine.m5130$$Nest$mstateString(this.this$0, getStateValue()) + " : " + msg);
        }
    }

    private class BlockedLv1State extends BaseAdapterState {
        /* synthetic */ BlockedLv1State(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        private BlockedLv1State(GPOStateMachine r2) {
            super(r2, null);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public int getStateValue() {
            return 2;
        }
    }

    private class BlockedLv2State extends BaseAdapterState {
        /* synthetic */ BlockedLv2State(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        private BlockedLv2State(GPOStateMachine r2) {
            super(r2, null);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public int getStateValue() {
            return 3;
        }
    }

    private class BlockedLv3State extends BaseAdapterState {
        /* synthetic */ BlockedLv3State(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        private BlockedLv3State(GPOStateMachine r2) {
            super(r2, null);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public int getStateValue() {
            return 4;
        }
    }

    private class BlockedState extends BaseAdapterState {
        final /* synthetic */ GPOStateMachine this$0;

        /* synthetic */ BlockedState(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        private BlockedState(GPOStateMachine r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public int getStateValue() {
            return 1;
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public void enter() {
            super.enter();
            this.this$0.sendMessageDelayed(7, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
            if (GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).isCacheNlpLocationValid() == false) goto L5;
            GPOStateMachine.m5129$$Nest$mreportLocation2Glp(this.this$0);
            return;
        L5:
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).registerNetworkLocationUpdates();
            this.this$0.sendMessageDelayed(6, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public void exit() {
            super.exit();
            if (GPOStateMachine.access$400(this.this$0, 7) == false) goto L6;
            GPOStateMachine.access$500(this.this$0, 7);
        L6:
            if (GPOStateMachine.access$600(this.this$0, 6) == false) goto L9;
            GPOStateMachine.access$700(this.this$0, 6);
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).unregisterNetworkLocationUpdates();
            return;
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public boolean processMessage(Message msg) {
            Object r0 = GPOStateMachine.m5125$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r0);
            super.processMessage(msg);     // Catch: Throwable -> L9
            switch(msg.what) {
                case 1: goto L24;
                case 2: goto L17;
                case 3: goto L24;
                case 4: goto L17;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L12;
                default: goto L6;
            };     // Catch: Throwable -> L9
        L6:
            logv("Unhandled message - " + GPOStateMachine.m5127$$Nest$mmessageString(this.this$0, msg.what));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L11:
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).unregisterNetworkLocationUpdates();     // Catch: Throwable -> L9
        L12:
            logd("timeout: " + GPOStateMachine.m5127$$Nest$mmessageString(this.this$0, msg.what));     // Catch: Throwable -> L9
            this.this$0.transitionTo(GPOStateMachine.m5118$$Nest$fgetSTATE_RUNNING(this.this$0));     // Catch: Throwable -> L9
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L13:
            GPOStateMachine.access$800(this.this$0, 6);     // Catch: Throwable -> L9
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).unregisterNetworkLocationUpdates();     // Catch: Throwable -> L9
            GPOStateMachine.m5129$$Nest$mreportLocation2Glp(this.this$0);     // Catch: Throwable -> L9
            goto L14
        L17:
            if (GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, false, msg.obj) == true) goto L19;
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L19:
            if (GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).isEmpty() == false) goto L21;
            this.this$0.transitionTo(GPOStateMachine.m5119$$Nest$fgetSTATE_STOPPED(this.this$0));     // Catch: Throwable -> L9
            goto L21
        L24:
            if (this.this$0.disableFeature() == false) goto L29;
            GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj);     // Catch: Throwable -> L9
            this.this$0.transitionTo(GPOStateMachine.m5118$$Nest$fgetSTATE_RUNNING(this.this$0));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L29:
            if (GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj) == true) goto L34;
            GPOStateMachine.m5120$$Nest$fgetmFlagCurDisableGpo(this.this$0).set(true);     // Catch: Throwable -> L9
            this.this$0.transitionTo(GPOStateMachine.m5118$$Nest$fgetSTATE_RUNNING(this.this$0));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L34:
            if (GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).isCacheNlpLocationValid() == false) goto L36;
            GPOStateMachine.m5129$$Nest$mreportLocation2Glp(this.this$0);     // Catch: Throwable -> L9
        L36:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private class ControlledState extends BaseAdapterState {
        final /* synthetic */ GPOStateMachine this$0;

        /* synthetic */ ControlledState(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        private ControlledState(GPOStateMachine r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public int getStateValue() {
            return 6;
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public boolean processMessage(Message msg) {
            Object r0 = GPOStateMachine.m5125$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r0);
            super.processMessage(msg);     // Catch: Throwable -> L9
            switch(msg.what) {
                case 1: goto L25;
                case 2: goto L20;
                case 3: goto L15;
                case 4: goto L11;
                default: goto L6;
            };     // Catch: Throwable -> L9
        L6:
            logv("Unhandled message - " + GPOStateMachine.m5127$$Nest$mmessageString(this.this$0, msg.what));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L11:
            boolean r1 = GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, false, msg.obj);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L15:
            if (GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj) == true) goto L17;
        L29:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L17:
            if (GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).size() != 1) goto L29;
            this.this$0.transitionTo(GPOStateMachine.m5118$$Nest$fgetSTATE_RUNNING(this.this$0));     // Catch: Throwable -> L9
            goto L29
        L20:
            if (GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, false, msg.obj) == false) goto L29;
            if (GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).isEmpty() == false) goto L29;
            this.this$0.transitionTo(GPOStateMachine.m5119$$Nest$fgetSTATE_STOPPED(this.this$0));     // Catch: Throwable -> L9
            goto L29
        L25:
            if (GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj) == false) goto L29;
            if (GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).size() != 1) goto L29;
            this.this$0.transitionTo(GPOStateMachine.m5118$$Nest$fgetSTATE_RUNNING(this.this$0));     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    public interface GPOStateMachineListener {
        void onGpoDelieverLocation(Location r1);

        void onStateChanged(int r1, int r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GpoSmMsg {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GpoState {
    }

    private class RunningState extends BaseAdapterState {
        final /* synthetic */ GPOStateMachine this$0;

        /* synthetic */ RunningState(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        private RunningState(GPOStateMachine r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public int getStateValue() {
            return 5;
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public void enter() {
            super.enter();
            GPOStateMachine.m5120$$Nest$fgetmFlagCurDisableGpo(this.this$0).set(false);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public boolean processMessage(Message msg) {
            Object r0 = GPOStateMachine.m5125$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r0);
            super.processMessage(msg);     // Catch: Throwable -> L9
            switch(msg.what) {
                case 1: goto L27;
                case 2: goto L21;
                case 3: goto L17;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L6;
            };     // Catch: Throwable -> L9
        L6:
            logv("Unhandled message - " + GPOStateMachine.m5127$$Nest$mmessageString(this.this$0, msg.what));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L11:
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).unregisterNetworkLocationUpdates();     // Catch: Throwable -> L9
            GPOStateMachine.m5129$$Nest$mreportLocation2Glp(this.this$0);     // Catch: Throwable -> L9
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L12:
            GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, false, msg.obj);     // Catch: Throwable -> L9
            if (GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).isEmpty() == false) goto L15;
            this.this$0.transitionTo(GPOStateMachine.m5119$$Nest$fgetSTATE_STOPPED(this.this$0));     // Catch: Throwable -> L9
            goto L15
        L17:
            boolean r1 = GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L27:
            boolean r2 = GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L21:
            if (GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, false, msg.obj) == true) goto L23;
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L23:
            if (GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).isEmpty() == false) goto L25;
            this.this$0.transitionTo(GPOStateMachine.m5119$$Nest$fgetSTATE_STOPPED(this.this$0));     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    private class StoppedState extends BaseAdapterState {
        final /* synthetic */ GPOStateMachine this$0;

        /* synthetic */ StoppedState(GPOStateMachine r1, GPOStateMachineIA r2) {
            this(r1);
        }

        private StoppedState(GPOStateMachine r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public int getStateValue() {
            return 0;
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public void enter() {
            super.enter();
            if (GPOStateMachine.access$000(this.this$0, 6) == false) goto L5;
            GPOStateMachine.access$100(this.this$0, 6);
        L5:
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).updateLastSteps();
        }

        @Override // com.android.server.location.GPOStateMachine.BaseAdapterState
        public boolean processMessage(Message msg) {
            Object r0 = GPOStateMachine.m5125$$Nest$fgetmStateLock(this.this$0);
            monitor-enter(r0);
            super.processMessage(msg);     // Catch: Throwable -> L9
            switch(msg.what) {
                case 1: goto L23;
                case 2: goto L19;
                case 3: goto L23;
                case 4: goto L19;
                case 5: goto L16;
                case 6: goto L6;
                case 7: goto L6;
                case 8: goto L12;
                default: goto L6;
            };     // Catch: Throwable -> L9
        L6:
            logv("Unhandled message - " + GPOStateMachine.m5127$$Nest$mmessageString(this.this$0, msg.what));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L16:
            GPOStateMachine.m5124$$Nest$fgetmStarLocation(this.this$0).unregisterNetworkLocationUpdates();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L19:
            GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, false, msg.obj);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L12:
            if (GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).isEmpty() == true) goto L14;
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "MSG_RESET_GLP_MAP received, but mGlpRequest is not empty: " + GPOStateMachine.m5121$$Nest$fgetmGlpRequest(this.this$0).keySet().toString());     // Catch: Throwable -> L9
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L23:
            if (this.this$0.disableFeature() == false) goto L28;
            GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj);     // Catch: Throwable -> L9
            this.this$0.transitionTo(GPOStateMachine.m5118$$Nest$fgetSTATE_RUNNING(this.this$0));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L28:
            if (GPOStateMachine.access$200(this.this$0, 8) == false) goto L31;
            GPOStateMachine.access$300(this.this$0, 8);     // Catch: Throwable -> L9
        L31:
            if (GPOStateMachine.m5128$$Nest$mprocessRequest(this.this$0, true, msg.obj) == true) goto L35;
            GPOStateMachine.m5120$$Nest$fgetmFlagCurDisableGpo(this.this$0).set(true);     // Catch: Throwable -> L9
            this.this$0.transitionTo(GPOStateMachine.m5118$$Nest$fgetSTATE_RUNNING(this.this$0));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L35:
            this.this$0.transitionTo(GPOStateMachine.m5117$$Nest$fgetSTATE_BLOCKED(this.this$0));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetSTATE_BLOCKED, reason: not valid java name */
    static /* bridge */ /* synthetic */ State m5117$$Nest$fgetSTATE_BLOCKED(GPOStateMachine r0) {
        return r0.STATE_BLOCKED;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetSTATE_RUNNING, reason: not valid java name */
    static /* bridge */ /* synthetic */ State m5118$$Nest$fgetSTATE_RUNNING(GPOStateMachine r0) {
        return r0.STATE_RUNNING;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetSTATE_STOPPED, reason: not valid java name */
    static /* bridge */ /* synthetic */ State m5119$$Nest$fgetSTATE_STOPPED(GPOStateMachine r0) {
        return r0.STATE_STOPPED;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlagCurDisableGpo, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m5120$$Nest$fgetmFlagCurDisableGpo(GPOStateMachine r0) {
        return r0.mFlagCurDisableGpo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlpRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m5121$$Nest$fgetmGlpRequest(GPOStateMachine r0) {
        return r0.mGlpRequest;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5122$$Nest$fgetmListeners(GPOStateMachine r0) {
        return r0.mListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrevState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5123$$Nest$fgetmPrevState(GPOStateMachine r0) {
        return r0.mPrevState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStarLocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ StarLocation m5124$$Nest$fgetmStarLocation(GPOStateMachine r0) {
        return r0.mStarLocation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5125$$Nest$fgetmStateLock(GPOStateMachine r0) {
        return r0.mStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPrevState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5126$$Nest$fputmPrevState(GPOStateMachine r0, int r1) {
        r0.mPrevState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mmessageString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5127$$Nest$mmessageString(GPOStateMachine r0, int r1) {
        return r0.messageString(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5128$$Nest$mprocessRequest(GPOStateMachine r0, boolean r1, Object r2) {
        return r0.processRequest(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportLocation2Glp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5129$$Nest$mreportLocation2Glp(GPOStateMachine r0) {
        r0.reportLocation2Glp();
    }

    /* JADX INFO: renamed from: -$$Nest$mstateString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5130$$Nest$mstateString(GPOStateMachine r0, int r1) {
        return r0.stateString(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateGpoVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5131$$Nest$mupdateGpoVersion(GPOStateMachine r0) {
        r0.updateGpoVersion();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5132$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ boolean access$000(GPOStateMachine x0, int x1) {
        return x0.hasMessages(x1);
    }

    static /* synthetic */ void access$100(GPOStateMachine x0, int x1) {
        x0.removeMessages(x1);
    }

    static /* synthetic */ boolean access$200(GPOStateMachine x0, int x1) {
        return x0.hasMessages(x1);
    }

    static /* synthetic */ void access$300(GPOStateMachine x0, int x1) {
        x0.removeMessages(x1);
    }

    static /* synthetic */ boolean access$400(GPOStateMachine x0, int x1) {
        return x0.hasMessages(x1);
    }

    static /* synthetic */ void access$500(GPOStateMachine x0, int x1) {
        x0.removeMessages(x1);
    }

    static /* synthetic */ boolean access$600(GPOStateMachine x0, int x1) {
        return x0.hasMessages(x1);
    }

    static /* synthetic */ void access$700(GPOStateMachine x0, int x1) {
        x0.removeMessages(x1);
    }

    static /* synthetic */ void access$800(GPOStateMachine x0, int x1) {
        x0.removeMessages(x1);
    }

    static {
        TAG = GPOStateMachine.class.getSimpleName();
    }

    private GPOStateMachine() {
        super(TAG);
        GPOStateMachineIA r1 = null;
        this.STATE_STOPPED = new StoppedState(this, r1);
        this.STATE_BLOCKED = new BlockedState(this, r1);
        this.STATE_BLOCKED_LV1 = new BlockedLv1State(this, r1);
        this.STATE_BLOCKED_LV2 = new BlockedLv2State(this, r1);
        this.STATE_BLOCKED_LV3 = new BlockedLv3State(this, r1);
        this.STATE_RUNNING = new RunningState(this, r1);
        this.STATE_CONTROLLED = new ControlledState(this, r1);
        this.mPrevState = 0;
        this.mGlpRequest = new ConcurrentHashMap();
        this.mFlagCurDisableGpo = new AtomicBoolean(false);
        this.mStateLock = new Object();
        this.mListeners = new ArrayList();
        addState(this.STATE_STOPPED);
        addState(this.STATE_BLOCKED);
        addState(this.STATE_BLOCKED_LV1);
        addState(this.STATE_BLOCKED_LV2);
        addState(this.STATE_BLOCKED_LV3);
        addState(this.STATE_RUNNING);
        addState(this.STATE_CONTROLLED);
        setInitialState(this.STATE_STOPPED);
        this.mStarLocation = StarLocation.getInstance();
        registerObserver();
    }

    public static synchronized GPOStateMachine getGpoStateMachine() {
        monitor-enter(GPOStateMachine.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new GPOStateMachine();     // Catch: Throwable -> L7
    L9:
        GPOStateMachine r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(GPOStateMachine.class);
        return r1;
    }

    public static GPOStateMachine makeGPOStateMachine() {
        GPOStateMachine sm = getGpoStateMachine();
        sm.start();
        return sm;
    }

    private void updateGpoVersion() {
        this.mFeatureGpoVersion = Settings.Global.getInt(this.mStarLocation.getContext().getContentResolver(), FEATURE_GPO_VERSION, 1);
        this.mStarLocation.logi(TAG, "mFeatureGpoVersion: " + this.mFeatureGpoVersion);
    }

    private void registerObserver() {
        final Handler r3 = null;
        this.mStarLocation.getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor(FEATURE_GPO_VERSION), false, new AnonymousClass1(this, r3));
        updateGpoVersion();
    }

    public int getCurState() {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        int r1 = this.mPrevState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addListener(GPOStateMachineListener listener) {
        if (listener == null) goto L12;
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        this.mListeners.add(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("Listener cannot be null");
    }

    public void removeListener(GPOStateMachineListener listener) {
        if (listener == null) goto L12;
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        this.mListeners.remove(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("Listener cannot be null");
    }

    private String messageString(int message) {
        switch(message) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L4;
        };
    L5:
        return "MSG_RESET_GLP_MAP";
    L7:
        return "MSG_BLOCKED_STATE_TIMEOUT";
    L9:
        return "MSG_REQUEST_NLP_TIMEOUT";
    L11:
        return "MSG_INJECT_NLP_LOCATION";
    L13:
        return "MSG_REQUEST_INACTIVE";
    L15:
        return "MSG_REQUEST_ACTIVE";
    L17:
        return "MSG_STOP_REQUEST";
    L19:
        return "MSG_START_REQUEST";
    L4:
        return "Unknown message (" + message + ")";
    }

    private String stateString(int state) {
        switch(state) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L5:
        return "GPO_STATE_CONTROLLED";
    L7:
        return "GPO_STATE_RUNNING";
    L9:
        return "GPO_STATE_BLOCKED_LV3";
    L11:
        return "GPO_STATE_BLOCKED_LV2";
    L13:
        return "GPO_STATE_BLOCKED_LV1";
    L15:
        return "GPO_STATE_BLOCKED";
    L17:
        return "GPO_STATE_STOPPED";
    L4:
        return "Unknown state (" + state + ")";
    }

    private CallerIdentity getIdentity(Class<?> registrationClass, Object registrationInstance) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getIdentityMethod = registrationClass.getDeclaredMethod(METHOD_GET_IDENTITY, new Class[0]);
        getIdentityMethod.setAccessible(true);
        return (CallerIdentity) getIdentityMethod.invoke(registrationInstance, new Object[0]);
    }

    private void reportLocation2Glp() {
        Location location = this.mStarLocation.getCachedNlpLocation();
        if (location != null) goto L6;
        this.mStarLocation.loge(TAG, "Cached NLP location is null, cannot deliver to app request.");
        return;
    L6:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "GPO reportLocation2Glp");
        Object r1 = this.mStateLock;
        monitor-enter(r1);
        Iterator<GPOStateMachineListener> r2 = this.mListeners.iterator();     // Catch: Throwable -> L12
    L10:
        if (r2.hasNext() == false) goto L14;
        GPOStateMachineListener listener = r2.next();     // Catch: Throwable -> L12
        listener.onGpoDelieverLocation(location);     // Catch: Throwable -> L12
        goto L10
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean processRequest(boolean addRequest, Object registration) {
        Class<?> registrationClass = Class.forName(CLASS_REGISTRATION);     // Catch: Exception -> L7
        CallerIdentity identity = getIdentity(registrationClass, registration);     // Catch: Exception -> L7
        if (identity != null) goto L9;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "Failed to get identity from registration: " + registration);     // Catch: Exception -> L7
        return false;
    L9:
        String identityHash = HexDump.toHexString(identity.getListenerId().hashCode());     // Catch: Exception -> L7
        if (addRequest == false) goto L12;
        this.mGlpRequest.put(identityHash, registration);     // Catch: Exception -> L7
    L13:
        LocationLogsRecorder r5 = LocationLogsRecorder.getInstance();     // Catch: Exception -> L7
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L7
        r6.append("Received ");     // Catch: Exception -> L7
        if (addRequest == false) goto L16;
        String r7 = "add";
    L17:
        r6.append(r7);     // Catch: Exception -> L7
        r6.append(" request: ");     // Catch: Exception -> L7
        r6.append(identity);     // Catch: Exception -> L7
        r6.append(", mGlpRequest = ");     // Catch: Exception -> L7
        r6.append(this.mGlpRequest.keySet().toString());     // Catch: Exception -> L7
        r5.writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, r6.toString());     // Catch: Exception -> L7
        return true;
    L16:
        r7 = "remove";
        goto L17
    L12:
        this.mGlpRequest.remove(identityHash);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "Failed to processRequest: " + e.getMessage());
        return false;
    }

    public boolean disableFeature() {
        if (this.mFlagCurDisableGpo.get() == false) goto L7;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "disableFeature: Current disable");
        return true;
    L7:
        if (this.mFeatureGpoVersion >= 1) goto L11;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "disableFeature: Feature version < 1");
        return true;
    L11:
        if (this.mStarLocation.isNetworkValid() == true) goto L14;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "disableFeature: Network invalid");
        return true;
    L14:
        long currentTime = SystemClock.elapsedRealtime();
        if ((currentTime - this.mStarLocation.getLastOutsideTime()) >= 300000) goto L21;
        if (this.mStarLocation.getLastOutsideTime() == 0) goto L21;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "disableFeature: recently outside");
        return true;
    L21:
        if ((currentTime - this.mStarLocation.getLastWalkTime()) < 300000) goto L23;
        return false;
    L23:
        if (this.mStarLocation.getLastWalkTime() == 0) goto L28;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "disableFeature: recently walk");
        return true;
    L28:
        return false;
    }
}
