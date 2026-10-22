package com.android.server.wm;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.server.common.Constants;
import com.android.server.dispatcher.KeyguardStateDispatcher;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.policy.WindowManagerPolicy;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class KeyguardController {
    private static final int DEFER_WAKE_TRANSITION_TIMEOUT_MS = 5000;
    private static final boolean ENABLE_NEW_KEYGUARD_SHELL_TRANSITIONS = false;
    private static final int GOING_AWAY_TIMEOUT_MS = 10500;
    static final String KEYGUARD_SLEEP_TOKEN_TAG = "keyguard";
    private static final String TAG = "ActivityTaskManager";
    private final SparseArray<KeyguardDisplayState> mDisplayStates;
    private IExtKeyguardController mExt;
    private final Runnable mGoingAwayTimeout;
    private final Runnable mResetWaitTransition;
    private RootWindowContainer mRootWindowContainer;
    private final ActivityTaskManagerService mService;
    private final ActivityTaskManagerService.SleepTokenAcquirer mSleepTokenAcquirer;
    private final ActivityTaskSupervisor mTaskSupervisor;
    private Transition.ReadyCondition mWaitAodHide;
    private boolean mWaitingForWakeTransition;
    private WindowManagerService mWindowManager;

    protected static class KeyguardDisplayState {
        private boolean mAodShowing;
        private boolean mDismissalRequested;
        private ActivityRecord mDismissingKeyguardActivity;
        private final int mDisplayId;
        private boolean mKeyguardGoingAway;
        private boolean mKeyguardShowing;
        private boolean mOccluded;
        private boolean mRequestDismissKeyguard;
        private final ActivityTaskManagerService mService;
        protected final ActivityTaskManagerService.SleepTokenAcquirer mSleepTokenAcquirer;
        protected ActivityRecord mTopOccludesActivity;
        private ActivityRecord mTopTurnScreenOnActivity;

        public static /* synthetic */ boolean $r8$lambda$UYxm3jSn5iwGFQ04QlWkFzJcydA(Task r0) {
            return lambda$getRootTaskForControllingOccluding$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAodShowing, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10027$$Nest$fgetmAodShowing(KeyguardDisplayState r0) {
            return r0.mAodShowing;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDismissalRequested, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10028$$Nest$fgetmDismissalRequested(KeyguardDisplayState r0) {
            return r0.mDismissalRequested;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDismissingKeyguardActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityRecord m10029$$Nest$fgetmDismissingKeyguardActivity(KeyguardDisplayState r0) {
            return r0.mDismissingKeyguardActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardGoingAway, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10030$$Nest$fgetmKeyguardGoingAway(KeyguardDisplayState r0) {
            return r0.mKeyguardGoingAway;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardShowing, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10031$$Nest$fgetmKeyguardShowing(KeyguardDisplayState r0) {
            return r0.mKeyguardShowing;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOccluded, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10032$$Nest$fgetmOccluded(KeyguardDisplayState r0) {
            return r0.mOccluded;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRequestDismissKeyguard, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10033$$Nest$fgetmRequestDismissKeyguard(KeyguardDisplayState r0) {
            return r0.mRequestDismissKeyguard;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAodShowing, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10034$$Nest$fputmAodShowing(KeyguardDisplayState r0, boolean r1) {
            r0.mAodShowing = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDismissalRequested, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10035$$Nest$fputmDismissalRequested(KeyguardDisplayState r0, boolean r1) {
            r0.mDismissalRequested = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmKeyguardGoingAway, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10036$$Nest$fputmKeyguardGoingAway(KeyguardDisplayState r0, boolean r1) {
            r0.mKeyguardGoingAway = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmKeyguardShowing, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10037$$Nest$fputmKeyguardShowing(KeyguardDisplayState r0, boolean r1) {
            r0.mKeyguardShowing = r1;
        }

        KeyguardDisplayState(ActivityTaskManagerService service, int displayId, ActivityTaskManagerService.SleepTokenAcquirer acquirer) {
            this.mService = service;
            this.mDisplayId = displayId;
            this.mSleepTokenAcquirer = acquirer;
        }

        void onRemoved() {
            this.mTopOccludesActivity = null;
            this.mDismissingKeyguardActivity = null;
            this.mTopTurnScreenOnActivity = null;
            this.mSleepTokenAcquirer.release(this.mDisplayId);
        }

        void writeEventLog(String r7) {
            int r0 = this.mDisplayId;
            boolean r1 = this.mKeyguardShowing;
            boolean r2 = this.mAodShowing;
            boolean r3 = this.mKeyguardGoingAway;
            boolean r4 = this.mOccluded;
            EventLogTags.writeWmSetKeyguardShown(r0, r1 ? 1 : 0, r2 ? 1 : 0, r3 ? 1 : 0, r4 ? 1 : 0, r7);
        }

        void updateVisibility(KeyguardController controller, DisplayContent display) {
            boolean lastOccluded = this.mOccluded;
            boolean lastKeyguardGoingAway = this.mKeyguardGoingAway;
            ActivityRecord lastDismissKeyguardActivity = this.mDismissingKeyguardActivity;
            boolean occludedChanged = false;
            this.mRequestDismissKeyguard = false;
            this.mOccluded = false;
            ActivityRecord r4 = null;
            this.mTopOccludesActivity = null;
            this.mDismissingKeyguardActivity = null;
            this.mTopTurnScreenOnActivity = null;
            Task task = getRootTaskForControllingOccluding(display);
            if (task == null) goto L5;
            r4 = task.getTopNonFinishingActivity();
        L5:
            ActivityRecord top = r4;
            if (top == null) goto L45;
            if (top.containsDismissKeyguardWindow() == false) goto L11;
            this.mDismissingKeyguardActivity = top;
        L11:
            if (top.getTurnScreenOnFlag() == true) goto L13;
        L15:
            boolean isKeyguardSecure = KeyguardController.m10023$$Nest$fgetmWindowManager(controller).isKeyguardSecure(KeyguardController.m10021$$Nest$fgetmService(controller).getCurrentUserId());
            if (top.mDismissKeyguardIfInsecure == false) goto L22;
            if (this.mKeyguardShowing == false) goto L22;
            if (isKeyguardSecure == true) goto L22;
            this.mKeyguardGoingAway = true;
        L24:
            top.mDismissKeyguardIfInsecure = false;
            if (this.mTopOccludesActivity == null) goto L27;
        L34:
            boolean r7 = true;
        L35:
            this.mOccluded = r7;
            if (this.mDisplayId == 0) goto L45;
            boolean r8 = this.mOccluded;
            if (display.canShowWithInsecureKeyguard() == true) goto L40;
        L42:
            boolean r9 = false;
        L43:
            this.mOccluded = r8 | r9;
            goto L45
        L40:
            if (controller.canDismissKeyguard() == false) goto L42;
            r9 = true;
            goto L43
        L27:
            if (this.mDismissingKeyguardActivity != null) goto L29;
        L33:
            r7 = false;
            goto L35
        L29:
            if (task.topRunningActivity() != this.mDismissingKeyguardActivity) goto L33;
            if (controller.canShowWhileOccluded(true, false) == false) goto L33;
        L22:
            if (top.canShowWhenLocked() == false) goto L24;
            this.mTopOccludesActivity = top;
            goto L24
        L13:
            if (top.currentLaunchCanTurnScreenOn() == false) goto L15;
            this.mTopTurnScreenOnActivity = top;
        L45:
            if (lastDismissKeyguardActivity != this.mDismissingKeyguardActivity) goto L47;
        L53:
            boolean r6 = false;
        L54:
            this.mRequestDismissKeyguard = r6;
            if (this.mOccluded == false) goto L66;
            if (this.mKeyguardShowing == false) goto L66;
            if (display.isSleeping() == true) goto L66;
            if (top.fillsParent() == true) goto L66;
            if (display.mWallpaperController.getWallpaperTarget() != null) goto L66;
            display.pendingLayoutChanges |= 4;
        L66:
            if (this.mTopTurnScreenOnActivity != null) goto L68;
        L74:
            if (lastKeyguardGoingAway == false) goto L76;
        L78:
            boolean r10 = false;
        L79:
            boolean startedGoingAway = r10;
            if (lastOccluded == this.mOccluded) goto L82;
            occludedChanged = true;
        L82:
            if (startedGoingAway == false) goto L85;
            writeEventLog("dismissIfInsecure");
            KeyguardController.m10024$$Nest$mhandleDismissInsecureKeyguard(controller, display);
            KeyguardController.m10026$$Nest$mscheduleGoingAwayTimeout(controller, this.mDisplayId);
        L85:
            if (occludedChanged == false) goto L87;
            controller.getExt().traceOccludedChanged(this.mOccluded, this.mTopOccludesActivity, this.mDismissingKeyguardActivity, top, this.mDisplayId);
            KeyguardController.m10025$$Nest$mhandleOccludedChanged(controller, this.mDisplayId, this.mTopOccludesActivity);
        L87:
            if (top == null) goto L94;
            if (startedGoingAway == true) goto L92;
            if (occludedChanged == true) goto L91;
            return;
        L91:
            if (this.mOccluded == true) goto L92;
            return;
        L92:
            display.mTransitionController.collect(top);
            return;
        L94:
            return;
        L76:
            if (this.mKeyguardGoingAway == false) goto L78;
            r10 = true;
            goto L79
        L68:
            if (this.mService.mWindowManager.mPowerManager.isInteractive(display.getDisplayId()) == true) goto L74;
            if (this.mRequestDismissKeyguard == false) goto L72;
        L73:
            KeyguardController.m10022$$Nest$fgetmTaskSupervisor(controller).wakeUp(display.getDisplayId(), "handleTurnScreenOn");
            this.mTopTurnScreenOnActivity.setCurrentLaunchCanTurnScreenOn(false);
            goto L74
        L72:
            if (this.mOccluded == false) goto L74;
        L47:
            if (this.mOccluded == true) goto L53;
            if (this.mKeyguardGoingAway == true) goto L53;
            if (this.mDismissingKeyguardActivity == null) goto L53;
            r6 = true;
            goto L54
        }

        private Task getRootTaskForControllingOccluding(DisplayContent display) {
            return display.getRootTask(new KeyguardController$KeyguardDisplayState$$ExternalSyntheticLambda0());
        }

        private static /* synthetic */ boolean lambda$getRootTaskForControllingOccluding$0(Task task) {
            if (task != null) goto L4;
        L10:
            return false;
        L4:
            if (task.isFocusableAndVisible() == false) goto L10;
            if (task.inPinnedWindowingMode() == true) goto L10;
            if (task.inFreeformWindowingMode() == true) goto L10;
            return true;
        }

        void dumpStatus(PrintWriter pw, String prefix) {
            pw.println(prefix + " KeyguardShowing=" + this.mKeyguardShowing + " AodShowing=" + this.mAodShowing + " KeyguardGoingAway=" + this.mKeyguardGoingAway + " DismissalRequested=" + this.mDismissalRequested + "  Occluded=" + this.mOccluded + " DismissingKeyguardActivity=" + this.mDismissingKeyguardActivity + " TurnScreenOnActivity=" + this.mTopTurnScreenOnActivity + " at display=" + this.mDisplayId);
        }

        void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, this.mDisplayId);
            proto.write(1133871366146L, this.mKeyguardShowing);
            proto.write(1133871366147L, this.mAodShowing);
            proto.write(1133871366148L, this.mOccluded);
            proto.write(1133871366149L, this.mKeyguardGoingAway);
            proto.end(token);
        }
    }

    public static /* synthetic */ void $r8$lambda$YvZEvwSShUAQJF9tGNSmKT7fzbU(KeyguardController r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ void $r8$lambda$dd9qFZWezuQZkMmVMxnnt8OrEnw(KeyguardController r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerService m10021$$Nest$fgetmService(KeyguardController r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTaskSupervisor, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskSupervisor m10022$$Nest$fgetmTaskSupervisor(KeyguardController r0) {
        return r0.mTaskSupervisor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m10023$$Nest$fgetmWindowManager(KeyguardController r0) {
        return r0.mWindowManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleDismissInsecureKeyguard, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10024$$Nest$mhandleDismissInsecureKeyguard(KeyguardController r0, DisplayContent r1) {
        r0.handleDismissInsecureKeyguard(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOccludedChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10025$$Nest$mhandleOccludedChanged(KeyguardController r0, int r1, ActivityRecord r2) {
        r0.handleOccludedChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleGoingAwayTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10026$$Nest$mscheduleGoingAwayTimeout(KeyguardController r0, int r1) {
        r0.scheduleGoingAwayTimeout(r1);
    }

    static {
        ENABLE_NEW_KEYGUARD_SHELL_TRANSITIONS = false;
    }

    KeyguardController(ActivityTaskManagerService service, ActivityTaskSupervisor taskSupervisor) {
        this.mDisplayStates = new SparseArray();
        this.mWaitAodHide = null;
        this.mResetWaitTransition = new KeyguardController$$ExternalSyntheticLambda1(this);
        this.mGoingAwayTimeout = new KeyguardController$$ExternalSyntheticLambda2(this);
        this.mExt = (IExtKeyguardController) ExtImplFactory.getImpl(IExtKeyguardController.class, new Object[]{this});
        this.mService = service;
        this.mTaskSupervisor = taskSupervisor;
        ActivityTaskManagerService r1 = this.mService;
        r1.getClass();
        this.mSleepTokenAcquirer = new ActivityTaskManagerService.SleepTokenAcquirer(r1, KEYGUARD_SLEEP_TOKEN_TAG);
    }

    void setWindowManager(WindowManagerService windowManager) {
        this.mWindowManager = windowManager;
        this.mRootWindowContainer = this.mService.mRootWindowContainer;
    }

    boolean isAodShowing(int displayId) {
        return KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(getDisplayState(displayId));
    }

    boolean isKeyguardOrAodShowing(int displayId) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == true) goto L7;
        if (KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(state) == true) goto L7;
    L11:
        return false;
    L7:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L11;
        if (KeyguardDisplayState.m10032$$Nest$fgetmOccluded(state) == true) goto L11;
        return true;
    }

    boolean isKeyguardUnoccludedOrAodShowing(int displayId) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (displayId != 0) goto L9;
        if (KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(state) == false) goto L9;
        return !KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state);
    L9:
        return isKeyguardOrAodShowing(displayId);
    }

    boolean isKeyguardShowing(int displayId) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == true) goto L5;
    L9:
        return false;
    L5:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L9;
        if (KeyguardDisplayState.m10032$$Nest$fgetmOccluded(state) == true) goto L9;
        return true;
    }

    boolean isKeyguardLocked(int displayId) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == true) goto L5;
    L7:
        return false;
    L5:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L7;
        return true;
    }

    boolean isKeyguardOccluded(int displayId) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == true) goto L5;
    L9:
        return false;
    L5:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L9;
        if (KeyguardDisplayState.m10032$$Nest$fgetmOccluded(state) == false) goto L9;
        return true;
    }

    boolean topActivityOccludesKeyguard(ActivityRecord r) {
        if (getDisplayState(r.getDisplayId()).mTopOccludesActivity != r) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isKeyguardGoingAway(int displayId) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L5;
    L7:
        return false;
    L5:
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == false) goto L7;
        return true;
    }

    void setKeyguardShown(int displayId, boolean keyguardShowing, boolean aodShowing) {
        DisplayContent dc = this.mRootWindowContainer.getDisplayContent(displayId);
        if (dc != null) goto L7;
        Slog.w(TAG, "setKeyguardShown called on non-existent display " + displayId);
        return;
    L7:
        if (dc.isKeyguardAlwaysUnlocked() == false) goto L10;
        Slog.i(TAG, "setKeyguardShown ignoring always unlocked display " + displayId);
        return;
    L10:
        KeyguardDisplayState state = getDisplayState(displayId);
        boolean keyguardChanged = true;
        if (aodShowing == KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(state)) goto L13;
        boolean aodChanged = true;
    L15:
        if (KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(state) == false) goto L18;
        if (aodShowing == true) goto L18;
        boolean aodRemoved = true;
    L20:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == false) goto L23;
        if (keyguardShowing == false) goto L23;
        boolean goingAwayRemoved = true;
    L25:
        if (keyguardShowing != KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state)) goto L30;
        if (goingAwayRemoved == false) goto L29;
        if (aodRemoved == false) goto L30;
    L29:
        keyguardChanged = false;
    L30:
        if (aodRemoved == false) goto L32;
        updateDeferTransitionForAod(false);
    L32:
        if (keyguardChanged == true) goto L37;
        if (aodChanged == true) goto L37;
        setWakeTransitionReady();
        return;
    L37:
        if (Constants.ENABLE_GAME_SCREEN_SAVER == false) goto L40;
        KeyguardStateDispatcher.getInstance().notifyKeyguardState(displayId, keyguardShowing, aodShowing);
    L40:
        if (ENABLE_NEW_KEYGUARD_SHELL_TRANSITIONS == false) goto L58;
        TransitionController transitionController = this.mWindowManager.mAtmService.getTransitionController();
        Transition transition = transitionController.getCollectingTransition();
        if (transition == null) goto L58;
        if (displayId != 0) goto L58;
        if (keyguardShowing == false) goto L46;
    L48:
        if (keyguardShowing == true) goto L50;
    L53:
        if (this.mWindowManager.mFlags.mAodTransition == false) goto L58;
        if (aodShowing == false) goto L58;
        if (KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(state) == true) goto L58;
        transition.addFlag(32768);
        goto L58
    L50:
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == true) goto L53;
        transition.addFlag(2048);
        goto L53
    L46:
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == false) goto L48;
        transition.addFlag(256);
    L58:
        if (displayId == 0) goto L60;
    L69:
        KeyguardDisplayState.m10037$$Nest$fputmKeyguardShowing(state, keyguardShowing);
        KeyguardDisplayState.m10034$$Nest$fputmAodShowing(state, aodShowing);
        state.writeEventLog("setKeyguardShown");
        if (keyguardChanged == false) goto L72;
    L74:
        if (keyguardChanged == false) goto L79;
        KeyguardDisplayState.m10036$$Nest$fputmKeyguardGoingAway(state, false);
        if (keyguardShowing == false) goto L79;
        KeyguardDisplayState.m10035$$Nest$fputmDismissalRequested(state, false);
    L79:
        if (goingAwayRemoved == true) goto L87;
        if (keyguardShowing == false) goto L84;
        if (Display.isOffState(dc.getDisplayInfo().state) == false) goto L87;
    L84:
        if (this.mWindowManager.mFlags.mAodTransition == false) goto L97;
        if (aodShowing == true) goto L87;
    L97:
        getExt().scheduleWallpaperRedoOnKeyguardGone(keyguardChanged, keyguardShowing, displayId, dc);
        scheduleGoingAwayTimeout(displayId);
    L98:
        updateKeyguardSleepToken();
        this.mRootWindowContainer.ensureActivitiesVisible();
        InputMethodManagerInternal.get().updateImeWindowStatus(false, displayId);
        setWakeTransitionReady();
        if (aodChanged == false) goto L102;
        this.mWindowManager.mWindowPlacerLocked.performSurfacePlacement();
        return;
    L102:
        return;
    L87:
        if (ENABLE_NEW_KEYGUARD_SHELL_TRANSITIONS == false) goto L89;
    L96:
        dc.mWallpaperController.adjustWallpaperWindows();
        dc.executeAppTransition();
        goto L97
    L89:
        if (keyguardChanged == false) goto L92;
        dc.requestTransitionAndLegacyPrepare(3, 2048, null);
    L92:
        if (this.mWindowManager.mFlags.mAodTransition == false) goto L96;
        if (aodChanged == false) goto L96;
        if (aodShowing == false) goto L96;
        dc.requestTransitionAndLegacyPrepare(3, 32768, null);
        goto L96
    L72:
        if (this.mWindowManager.mFlags.mAodTransition == false) goto L98;
        if (aodChanged == false) goto L98;
    L60:
        if ((aodShowing ^ keyguardShowing) == true) goto L65;
        if (aodShowing == false) goto L69;
        if (aodChanged == false) goto L69;
        if (keyguardChanged == false) goto L69;
    L65:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L69;
        if (Display.isOnState(dc.getDisplayInfo().state) == false) goto L69;
        this.mWindowManager.mTaskSnapshotController.snapshotForSleeping(0);
    L23:
        goingAwayRemoved = false;
    L18:
        aodRemoved = false;
        goto L20
    L13:
        aodChanged = false;
        goto L15
    }

    private void setWakeTransitionReady() {
        if (this.mWindowManager.mAtmService.getTransitionController().getCollectingTransitionType() != 11) goto L6;
        this.mWindowManager.mAtmService.getTransitionController().setReady(this.mRootWindowContainer.getDefaultDisplay());
        return;
    }

    void keyguardGoingAway(int displayId, int flags) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(state) == true) goto L5;
        return;
    L5:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L17;
        Trace.traceBegin(32, "keyguardGoingAway");
        this.mService.deferWindowLayout();
        KeyguardDisplayState.m10036$$Nest$fputmKeyguardGoingAway(state, true);
        state.writeEventLog("keyguardGoingAway");     // Catch: Throwable -> L11
        int transitFlags = convertTransitFlags(flags);     // Catch: Throwable -> L11
        DisplayContent dc = this.mRootWindowContainer.getDefaultDisplay();     // Catch: Throwable -> L11
        dc.mAtmService.getTransitionController().requestTransitionIfNeeded(4, transitFlags, null, dc);     // Catch: Throwable -> L11
        updateKeyguardSleepToken();     // Catch: Throwable -> L11
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();     // Catch: Throwable -> L11
        this.mRootWindowContainer.ensureActivitiesVisible();     // Catch: Throwable -> L11
        this.mRootWindowContainer.addStartingWindowsForVisibleActivities();     // Catch: Throwable -> L11
        this.mWindowManager.executeAppTransition();     // Catch: Throwable -> L11
        scheduleGoingAwayTimeout(displayId);     // Catch: Throwable -> L11
        this.mService.continueWindowLayout();
        Trace.traceEnd(32);
        return;
    L11:
        th = move-exception;
        this.mService.continueWindowLayout();
        Trace.traceEnd(32);
        throw th;
    }

    void dismissKeyguard(IBinder token, IKeyguardDismissCallback callback, CharSequence message) {
        ActivityRecord activityRecord = ActivityRecord.forTokenLocked(token);
        if (activityRecord != null) goto L5;
    L14:
        failCallback(callback);
        return;
    L5:
        if (activityRecord.visibleIgnoringKeyguard == false) goto L14;
        Slog.i(TAG, "Activity requesting to dismiss Keyguard: " + activityRecord);
        if (activityRecord.getTurnScreenOnFlag() == true) goto L10;
    L12:
        this.mWindowManager.dismissKeyguard(callback, message);
        return;
    L10:
        if (activityRecord.isTopRunningActivity() == false) goto L12;
        this.mTaskSupervisor.wakeUp(activityRecord.getDisplayId(), "dismissKeyguard");
        goto L12
    }

    private void failCallback(IKeyguardDismissCallback callback) {
        callback.onDismissError();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to call callback", e);
    }

    private int convertTransitFlags(int keyguardGoingAwayFlags) {
        int result = 256;
        if ((keyguardGoingAwayFlags & 1) == 0) goto L6;
        result = 256 | 1;
    L6:
        if ((keyguardGoingAwayFlags & 2) == 0) goto L9;
        result = result | 2;
    L9:
        if ((keyguardGoingAwayFlags & 4) == 0) goto L12;
        result = result | 4;
    L12:
        if ((keyguardGoingAwayFlags & 8) == 0) goto L15;
        result = result | 8;
    L15:
        if ((keyguardGoingAwayFlags & 16) != 0) goto L17;
        return result;
    L17:
        return result | 512;
    }

    boolean canShowActivityWhileKeyguardShowing(ActivityRecord r) {
        KeyguardDisplayState state = getDisplayState(r.getDisplayId());
        if (r.containsDismissKeyguardWindow() == true) goto L5;
    L15:
        return false;
    L5:
        if (canDismissKeyguard() == false) goto L15;
        if (KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(state) == true) goto L15;
        if (KeyguardDisplayState.m10028$$Nest$fgetmDismissalRequested(state) == false) goto L11;
    L14:
        return true;
    L11:
        if (r.canShowWhenLocked() == false) goto L15;
        if (KeyguardDisplayState.m10029$$Nest$fgetmDismissingKeyguardActivity(state) == r) goto L15;
        goto L14
    }

    boolean canShowWhileOccluded(boolean dismissKeyguard, boolean showWhenLocked) {
        if (showWhenLocked == true) goto L8;
        if (dismissKeyguard == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mWindowManager.isKeyguardSecure(this.mService.getCurrentUserId()) == true) goto L7;
    L8:
        return true;
    }

    boolean checkKeyguardVisibility(ActivityRecord r) {
        if (r.mDisplayContent.canShowWithInsecureKeyguard() == false) goto L8;
        if (canDismissKeyguard() == false) goto L8;
        return true;
    L8:
        if (isKeyguardOrAodShowing(r.mDisplayContent.getDisplayId()) == false) goto L12;
        return canShowActivityWhileKeyguardShowing(r);
    L12:
        if (isKeyguardLocked(r.getDisplayId()) == true) goto L14;
        return true;
    L14:
        return canShowWhileOccluded(r.containsDismissKeyguardWindow(), r.canShowWhenLocked());
    }

    void updateVisibility() {
        int displayNdx = this.mRootWindowContainer.getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L14;
        DisplayContent display = this.mRootWindowContainer.getChildAt(displayNdx);
        if (display.isRemoving() == true) goto L12;
        if (display.isRemoved() == true) goto L12;
        KeyguardDisplayState state = getDisplayState(display.mDisplayId);
        state.updateVisibility(this, display);
        if (KeyguardDisplayState.m10033$$Nest$fgetmRequestDismissKeyguard(state) == false) goto L12;
        handleDismissKeyguard(display.getDisplayId());
    L12:
        displayNdx = displayNdx - 1;
        goto L3
    }

    private void handleOccludedChanged(int displayId, ActivityRecord topActivity) {
        if (displayId == 0) goto L5;
        updateKeyguardSleepToken(displayId);
        return;
    L5:
        TransitionController tc = this.mRootWindowContainer.mTransitionController;
        KeyguardDisplayState state = getDisplayState(displayId);
        DisplayContent dc = this.mRootWindowContainer.getDisplayContent(displayId);
        boolean locked = isKeyguardLocked(displayId);
        if (tc.isShellTransitionsEnabled() == false) goto L10;
        if (locked == false) goto L9;
        tc.isCollecting();
    L9:
        boolean executeTransition = false;
    L12:
        if (KeyguardDisplayState.m10032$$Nest$fgetmOccluded(state) == false) goto L14;
        int transitType = 8;
        int transitFlags = 4096;
        int notFlags = 8192;
    L15:
        this.mWindowManager.mPolicy.onKeyguardOccludedChangedLw(KeyguardDisplayState.m10032$$Nest$fgetmOccluded(state));
        this.mService.deferWindowLayout();
        if (locked == false) goto L34;
        if (tc.isShellTransitionsEnabled() == true) goto L20;
    L37:
        updateKeyguardSleepToken(displayId);     // Catch: Throwable -> L23
        if (executeTransition == false) goto L40;
        dc.executeAppTransition();     // Catch: Throwable -> L23
    L40:
        this.mService.continueWindowLayout();
        return;
    L20:
        if (KeyguardDisplayState.m10032$$Nest$fgetmOccluded(state) == false) goto L25;
        if (topActivity == null) goto L25;
        Task trigger = topActivity.getRootTask();     // Catch: Throwable -> L23
    L26:
        tc.requestTransitionIfNeeded(transitType, transitFlags, trigger, dc);     // Catch: Throwable -> L23
        Transition transition = tc.getCollectingTransition();     // Catch: Throwable -> L23
        if ((transition.getFlags() & notFlags) == 0) goto L29;
        transition.removeFlag(notFlags);     // Catch: Throwable -> L23
    L30:
        if (trigger == null) goto L37;
        transition.collect(trigger);     // Catch: Throwable -> L23
        goto L37
    L29:
        transition.addFlag(transitFlags);     // Catch: Throwable -> L23
    L25:
        trigger = null;
        goto L26
    L34:
        if (tc.inTransition() == false) goto L36;
        ArrayList<Runnable> r8 = tc.mStateValidators;     // Catch: Throwable -> L23
        WindowManagerPolicy r9 = this.mWindowManager.mPolicy;     // Catch: Throwable -> L23
        r9.getClass();     // Catch: Throwable -> L23
        r8.add(new KeyguardController$$ExternalSyntheticLambda0(r9));     // Catch: Throwable -> L23
        goto L37
    L36:
        this.mWindowManager.mPolicy.applyKeyguardOcclusionChange();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.mService.continueWindowLayout();
        throw th;
    L14:
        transitType = 9;
        transitFlags = 8192;
        notFlags = 4096;
        goto L15
    L10:
        executeTransition = true;
        goto L12
    }

    private void handleDismissInsecureKeyguard(DisplayContent dc) {
        this.mService.deferWindowLayout();
        dc.mAtmService.getTransitionController().requestTransitionIfNeeded(1, 256, null, dc);     // Catch: Throwable -> L6
        updateKeyguardSleepToken();     // Catch: Throwable -> L6
        this.mWindowManager.executeAppTransition();     // Catch: Throwable -> L6
        this.mService.continueWindowLayout();
        return;
    L6:
        th = move-exception;
        this.mService.continueWindowLayout();
        throw th;
    }

    private void handleDismissKeyguard(int displayId) {
        if (this.mWindowManager.isKeyguardSecure(this.mService.getCurrentUserId()) == true) goto L5;
        return;
    L5:
        this.mWindowManager.dismissKeyguard(null, null);
        KeyguardDisplayState state = getDisplayState(displayId);
        KeyguardDisplayState.m10035$$Nest$fputmDismissalRequested(state, true);
    }

    ActivityRecord getTopOccludingActivity(int displayId) {
        return getDisplayState(displayId).mTopOccludesActivity;
    }

    ActivityRecord getDismissKeyguardActivity(int displayId) {
        return KeyguardDisplayState.m10029$$Nest$fgetmDismissingKeyguardActivity(getDisplayState(displayId));
    }

    boolean canDismissKeyguard() {
        if (this.mWindowManager.mPolicy.isKeyguardTrustedLw() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mWindowManager.isKeyguardSecure(this.mService.getCurrentUserId()) == false) goto L8;
        return false;
    }

    private void updateKeyguardSleepToken() {
        int displayNdx = this.mRootWindowContainer.getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L6;
        DisplayContent display = this.mRootWindowContainer.getChildAt(displayNdx);
        updateKeyguardSleepToken(display.mDisplayId);
        displayNdx = displayNdx - 1;
        goto L3
    }

    private void updateKeyguardSleepToken(int displayId) {
        KeyguardDisplayState state = getDisplayState(displayId);
        if (isKeyguardUnoccludedOrAodShowing(displayId) == false) goto L5;
        state.mSleepTokenAcquirer.acquire(displayId);
        return;
    L5:
        state.mSleepTokenAcquirer.release(displayId);
    }

    protected KeyguardDisplayState getDisplayState(int displayId) {
        KeyguardDisplayState state = this.mDisplayStates.get(displayId);
        if (state != null) goto L6;
        KeyguardDisplayState state2 = new KeyguardDisplayState(this.mService, displayId, this.mSleepTokenAcquirer);
        this.mDisplayStates.append(displayId, state2);
        return state2;
    L6:
        return state;
    }

    void onDisplayRemoved(int displayId) {
        KeyguardDisplayState state = this.mDisplayStates.get(displayId);
        if (state == null) goto L6;
        state.onRemoved();
        this.mDisplayStates.remove(displayId);
        return;
    }

    private /* synthetic */ void lambda$new$0() {
        WindowManagerGlobalLock r0 = this.mWindowManager.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        updateDeferTransitionForAod(false);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void updateDeferTransitionForAod(boolean waiting) {
        if (this.mService.getTransitionController().useFullReadyTracking() == false) goto L11;
        if (this.mWaitAodHide == null) goto L7;
        boolean r0 = true;
    L8:
        if (waiting != r0) goto L14;
        return;
    L14:
        if (this.mService.getTransitionController().isCollecting() == true) goto L16;
        return;
    L16:
        if (waiting == true) goto L18;
    L20:
        if (waiting == true) goto L24;
        this.mWaitingForWakeTransition = false;
        this.mWindowManager.mAtmService.getTransitionController().continueTransitionReady();
        this.mWindowManager.mH.removeCallbacks(this.mResetWaitTransition);
        Transition.ReadyCondition waitAodHide = this.mWaitAodHide;
        this.mWaitAodHide = null;
        waitAodHide.meet();
        return;
    L24:
        return;
    L18:
        if (isAodShowing(0) == false) goto L20;
        this.mWaitingForWakeTransition = true;
        this.mWindowManager.mAtmService.getTransitionController().deferTransitionReady();
        this.mWaitAodHide = new Transition.ReadyCondition("AOD hidden");
        this.mWindowManager.mAtmService.getTransitionController().waitFor(this.mWaitAodHide);
        this.mWindowManager.mH.postDelayed(this.mResetWaitTransition, 5000);
        return;
    L7:
        r0 = false;
        goto L8
    L11:
        if (waiting != this.mWaitingForWakeTransition) goto L14;
    }

    private /* synthetic */ void lambda$new$1() {
        WindowManagerGlobalLock r0 = this.mWindowManager.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        KeyguardDisplayState state = getDisplayState(0);     // Catch: Throwable -> L10
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(state) == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        KeyguardDisplayState.m10036$$Nest$fputmKeyguardGoingAway(state, false);     // Catch: Throwable -> L10
        state.writeEventLog("goingAwayTimeout");     // Catch: Throwable -> L10
        this.mWindowManager.mPolicy.startKeyguardExitAnimation(SystemClock.uptimeMillis() - 10500);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void scheduleGoingAwayTimeout(int displayId) {
        if (displayId == 0) goto L5;
        return;
    L5:
        if (KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(getDisplayState(displayId)) == true) goto L7;
        this.mWindowManager.mH.removeCallbacks(this.mGoingAwayTimeout);
        return;
    L7:
        if (this.mWindowManager.mH.hasCallbacks(this.mGoingAwayTimeout) == true) goto L11;
        this.mWindowManager.mH.postDelayed(this.mGoingAwayTimeout, 10500);
        return;
    }

    void dump(PrintWriter pw, String prefix) {
        KeyguardDisplayState default_state = getDisplayState(0);
        pw.println(prefix + "KeyguardController:");
        pw.println(prefix + "  mKeyguardShowing=" + KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(default_state));
        pw.println(prefix + "  mAodShowing=" + KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(default_state));
        pw.println(prefix + "  mKeyguardGoingAway=" + KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(default_state));
        dumpDisplayStates(pw, prefix);
        pw.println(prefix + "  mDismissalRequested=" + KeyguardDisplayState.m10028$$Nest$fgetmDismissalRequested(default_state));
        pw.println();
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        KeyguardDisplayState default_state = getDisplayState(0);
        long token = proto.start(fieldId);
        proto.write(1133871366147L, KeyguardDisplayState.m10027$$Nest$fgetmAodShowing(default_state));
        proto.write(1133871366145L, KeyguardDisplayState.m10031$$Nest$fgetmKeyguardShowing(default_state));
        proto.write(1133871366149L, KeyguardDisplayState.m10030$$Nest$fgetmKeyguardGoingAway(default_state));
        writeDisplayStatesToProto(proto, 2246267895812L);
        proto.end(token);
    }

    private void dumpDisplayStates(PrintWriter pw, String prefix) {
        int i = 0;
    L4:
        if (i >= this.mDisplayStates.size()) goto L7;
        this.mDisplayStates.valueAt(i).dumpStatus(pw, prefix);
        i = i + 1;
        goto L4
    }

    private void writeDisplayStatesToProto(ProtoOutputStream proto, long fieldId) {
        int i = 0;
    L4:
        if (i >= this.mDisplayStates.size()) goto L7;
        this.mDisplayStates.valueAt(i).dumpDebug(proto, fieldId);
        i = i + 1;
        goto L4
    }

    boolean isDisplayOccluded(int displayId) {
        return KeyguardDisplayState.m10032$$Nest$fgetmOccluded(getDisplayState(displayId));
    }

    public IExtKeyguardController getExt() {
        return this.mExt;
    }
}
