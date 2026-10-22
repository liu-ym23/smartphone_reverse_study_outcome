package com.android.server.wm;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.ResourceId;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.RemoteAnimationTarget;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.window.BackAnimationAdapter;
import android.window.BackNavigationInfo;
import android.window.IBackAnimationFinishedCallback;
import android.window.IBackAnimationRunner;
import android.window.OnBackInvokedCallbackInfo;
import android.window.TaskSnapshot;
import com.android.internal.policy.TransitionAnimation;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class BackNavigationController {
    private static final String TAG = "CoreBackPreview";
    private static int sDefaultAnimationResId;
    static final boolean sPredictBackEnable = false;
    private AnimationHandler mAnimationHandler;
    private boolean mBackAnimationInProgress;
    private RemoteCallback mGestureRequest;
    private int mLastBackType;
    private final NavigationMonitor mNavigationMonitor;
    private Runnable mPendingAnimation;
    private AnimationHandler.ScheduleAnimationBuilder mPendingAnimationBuilder;
    private boolean mShowWallpaper;
    private final ArrayList<WindowContainer> mTmpCloseApps;
    private final ArrayList<WindowContainer> mTmpOpenApps;
    private WindowManagerService mWindowManagerService;

    static class AnimationHandler {
        private static final int ACTIVITY_SWITCH = 2;
        private static final int DIALOG_CLOSE = 3;
        private static final int TASK_SWITCH = 1;
        private static final int UNKNOWN = 0;
        private BackWindowAnimationAdaptor mCloseAdaptor;
        private boolean mComposed;
        private ActivityRecord[] mOpenActivities;
        private BackWindowAnimationAdaptorWrapper mOpenAnimAdaptor;
        Transition mPrepareCloseTransition;
        private final boolean mShowWindowlessSurface;
        private boolean mStartingSurfaceTargetMatch;
        private int mSwitchType;
        private boolean mWaitTransition;
        private final WindowManagerService mWindowManagerService;

        private static class BackWindowAnimationAdaptor implements AnimationAdapter {
            private RemoteAnimationTarget mAnimationTarget;
            boolean mAppWindowDrawn;
            private final Rect mBounds;
            SurfaceControl mCapturedLeash;
            private final boolean mIsOpen;
            private final int mSwitchType;
            private final WindowContainer mTarget;

            /* JADX INFO: renamed from: -$$Nest$fgetmAnimationTarget, reason: not valid java name */
            static /* bridge */ /* synthetic */ RemoteAnimationTarget m9780$$Nest$fgetmAnimationTarget(BackWindowAnimationAdaptor r0) {
                return r0.mAnimationTarget;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmSwitchType, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9781$$Nest$fgetmSwitchType(BackWindowAnimationAdaptor r0) {
                return r0.mSwitchType;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmTarget, reason: not valid java name */
            static /* bridge */ /* synthetic */ WindowContainer m9782$$Nest$fgetmTarget(BackWindowAnimationAdaptor r0) {
                return r0.mTarget;
            }

            BackWindowAnimationAdaptor(WindowContainer target, boolean isOpen, int switchType) {
                this.mBounds = new Rect();
                this.mBounds.set(target.getBounds());
                this.mTarget = target;
                this.mIsOpen = isOpen;
                this.mSwitchType = switchType;
            }

            Task getTopTask() {
                Task asTask = this.mTarget.asTask();
                if (asTask == null) goto L5;
                return asTask;
            L5:
                ActivityRecord ar = this.mTarget.asActivityRecord();
                if (ar != null) goto L8;
                TaskFragment tf = this.mTarget.asTaskFragment();
                if (tf != null) goto L12;
                return null;
            L12:
                return tf.getTask();
            L8:
                return ar.getTask();
            }

            @Override // com.android.server.wm.AnimationAdapter
            public boolean getShowWallpaper() {
                return false;
            }

            @Override // com.android.server.wm.AnimationAdapter
            public void startAnimation(SurfaceControl animationLeash, SurfaceControl.Transaction t, int type, SurfaceAnimator.OnAnimationFinishedCallback finishCallback) {
                this.mCapturedLeash = animationLeash;
                createRemoteAnimationTarget();
                WindowState win = this.mTarget.asWindowState();
                if (win != null) goto L5;
                return;
            L5:
                if (this.mSwitchType != 3) goto L9;
                Rect frame = win.getFrame();
                Point position = new Point();
                win.transformFrameToSurfacePosition(frame.left, frame.top, position);
                t.setPosition(this.mCapturedLeash, position.x, position.y);
                return;
            }

            @Override // com.android.server.wm.AnimationAdapter
            public void onAnimationCancelled(SurfaceControl animationLeash) {
                if (this.mCapturedLeash != animationLeash) goto L6;
                this.mCapturedLeash = null;
                return;
            }

            @Override // com.android.server.wm.AnimationAdapter
            public long getDurationHint() {
                return 0;
            }

            @Override // com.android.server.wm.AnimationAdapter
            public long getStatusBarTransitionsStartTime() {
                return 0;
            }

            @Override // com.android.server.wm.AnimationAdapter
            public void dump(PrintWriter pw, String prefix) {
                pw.print(prefix + "BackWindowAnimationAdaptor mCapturedLeash=");
                pw.print(this.mCapturedLeash);
                pw.println();
            }

            @Override // com.android.server.wm.AnimationAdapter
            public void dumpDebug(ProtoOutputStream proto) {
            }

            RemoteAnimationTarget createRemoteAnimationTarget() {
                if (this.mAnimationTarget != null) goto L5;
                WindowState r1 = this.mTarget.asWindowState();
                if (r1 == null) goto L9;
                ActivityRecord r3 = r1.getActivityRecord();
            L10:
                if (r3 == null) goto L12;
                Task r4 = r3.getTask();
            L13:
                if (r4 == null) goto L15;
            L17:
                if (r3 != null) goto L22;
                if (r4 == null) goto L20;
                ActivityRecord r5 = r4.getTopNonFinishingActivity();
            L21:
                r3 = r5;
                goto L22
            L20:
                r5 = this.mTarget.asActivityRecord();
            L22:
                if (r4 != null) goto L25;
                if (r3 == null) goto L25;
                r4 = r3.getTask();
            L25:
                if (r4 == null) goto L34;
                if (r3 == null) goto L34;
                WindowState r2 = r3.findMainWindow();
                if (r2 == null) goto L31;
                Rect r6 = r2.getInsetsStateWithVisibilityOverride().calculateInsets(this.mBounds, WindowInsets.Type.tappableElement(), false).toRect();
            L32:
                int r8 = !this.mIsOpen ? 1 : 0;
                this.mAnimationTarget = new RemoteAnimationTarget(r4.mTaskId, r8, this.mCapturedLeash, !r3.fillsParent(), new Rect(), r6, r3.getPrefixOrderIndex(), new Point(this.mBounds.left, this.mBounds.top), this.mBounds, this.mBounds, r4.getWindowConfiguration(), true, null, null, r4.getTaskInfo(), r3.checkEnterPictureInPictureAppOpsState());
                return this.mAnimationTarget;
            L31:
                r6 = new Rect();
            L34:
                Slog.e(BackNavigationController.TAG, "createRemoteAnimationTarget fail " + this.mTarget);
                return null;
            L15:
                if (this.mTarget.asTaskFragment() == null) goto L17;
                r4 = this.mTarget.asTaskFragment().getTask();
                r3 = this.mTarget.asTaskFragment().getTopNonFinishingActivity();
                goto L17
            L12:
                r4 = this.mTarget.asTask();
                goto L13
            L9:
                r3 = null;
                goto L10
            L5:
                return this.mAnimationTarget;
            }
        }

        private static class BackWindowAnimationAdaptorWrapper {
            final BackWindowAnimationAdaptor[] mAdaptors;
            SurfaceControl.Transaction mCloseTransaction;
            private Transition mPreparedOpenTransition;
            final RemoteAnimationTarget mRemoteAnimationTarget;
            private int mRequestedStartingSurfaceId;
            private SurfaceControl mStartingSurface;

            /* JADX INFO: renamed from: -$$Nest$fgetmPreparedOpenTransition, reason: not valid java name */
            static /* bridge */ /* synthetic */ Transition m9783$$Nest$fgetmPreparedOpenTransition(BackWindowAnimationAdaptorWrapper r0) {
                return r0.mPreparedOpenTransition;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmRequestedStartingSurfaceId, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9784$$Nest$fgetmRequestedStartingSurfaceId(BackWindowAnimationAdaptorWrapper r0) {
                return r0.mRequestedStartingSurfaceId;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmStartingSurface, reason: not valid java name */
            static /* bridge */ /* synthetic */ SurfaceControl m9785$$Nest$fgetmStartingSurface(BackWindowAnimationAdaptorWrapper r0) {
                return r0.mStartingSurface;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmPreparedOpenTransition, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m9786$$Nest$fputmPreparedOpenTransition(BackWindowAnimationAdaptorWrapper r0, Transition r1) {
                r0.mPreparedOpenTransition = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmStartingSurface, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m9787$$Nest$fputmStartingSurface(BackWindowAnimationAdaptorWrapper r0, SurfaceControl r1) {
                r0.mStartingSurface = r1;
            }

            BackWindowAnimationAdaptorWrapper(boolean isOpen, int switchType, SurfaceControl.Transaction st, WindowContainer... targets) {
                this.mRequestedStartingSurfaceId = -1;
                this.mAdaptors = new BackWindowAnimationAdaptor[targets.length];
                int i = targets.length - 1;
            L3:
                if (i < 0) goto L5;
                this.mAdaptors[i] = AnimationHandler.m9779$$Nest$smcreateAdaptor(targets[i], isOpen, switchType, st);
                i = i - 1;
                goto L3
            L5:
                int i2 = targets.length;
                if (i2 <= 1) goto L8;
                RemoteAnimationTarget r0 = createWrapTarget(st);
            L9:
                this.mRemoteAnimationTarget = r0;
                return;
            L8:
                r0 = BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(this.mAdaptors[0]);
                goto L9
            }

            boolean isValid() {
                int i = this.mAdaptors.length - 1;
            L3:
                if (i < 0) goto L10;
                if (BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(this.mAdaptors[i]) == null) goto L6;
                i = i - 1;
                goto L3
            L6:
                return false;
            L10:
                return true;
            }

            void cleanUp(boolean startingSurfaceMatch) {
                cleanUpWindowlessSurface(startingSurfaceMatch);
                int i = this.mAdaptors.length - 1;
            L3:
                if (i < 0) goto L6;
                BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mAdaptors[i]).cancelAnimation();
                i = i - 1;
                goto L3
            L6:
                if (this.mCloseTransaction == null) goto L8;
                this.mCloseTransaction.apply();
                this.mCloseTransaction = null;
            L8:
                this.mPreparedOpenTransition = null;
            }

            private RemoteAnimationTarget createWrapTarget(SurfaceControl.Transaction st) {
                Rect unionBounds = new Rect();
                int i = this.mAdaptors.length - 1;
            L3:
                if (i < 0) goto L5;
                unionBounds.union(BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(this.mAdaptors[i]).localBounds);
                i = i - 1;
                goto L3
            L5:
                WindowContainer wc = BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mAdaptors[0]);
                Task task = this.mAdaptors[0].getTopTask();
                RemoteAnimationTarget represent = BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(this.mAdaptors[0]);
                SurfaceControl leashSurface = new SurfaceControl.Builder().setName("cross-animation-leash").setContainerLayer().setHidden(false).setParent(task.getSurfaceControl()).setCallsite("BackWindowAnimationAdaptorWrapper.getOrCreateAnimationTarget").build();
                this.mCloseTransaction = new SurfaceControl.Transaction();
                this.mCloseTransaction.reparent(leashSurface, null);
                st.setLayer(leashSurface, wc.getLastLayer());
                int i2 = this.mAdaptors.length - 1;
            L6:
                if (i2 < 0) goto L12;
                BackWindowAnimationAdaptor adaptor = this.mAdaptors[i2];
                st.reparent(BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(adaptor).leash, leashSurface);
                st.setPosition(BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(adaptor).leash, BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(adaptor).localBounds.left, BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(adaptor).localBounds.top);
                WindowContainer parent = BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(adaptor).getParent();
                if (parent == null) goto L10;
                this.mCloseTransaction.reparent(BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(adaptor).getSurfaceControl(), parent.getSurfaceControl());
            L10:
                i2 = i2 - 1;
                goto L6
            L12:
                return new RemoteAnimationTarget(represent.taskId, represent.mode, leashSurface, represent.isTranslucent, represent.clipRect, represent.contentInsets, represent.prefixOrderIndex, new Point(unionBounds.left, unionBounds.top), unionBounds, unionBounds, represent.windowConfiguration, true, null, null, represent.taskInfo, represent.allowEnterPip);
            }

            void createStartingSurface(TaskSnapshot snapshot) {
                if (snapshot != null) goto L4;
                return;
            L4:
                boolean chooseActivity = false;
                if (BackWindowAnimationAdaptor.m9781$$Nest$fgetmSwitchType(this.mAdaptors[0]) != 3) goto L7;
                return;
            L7:
                WindowContainer mainOpen = BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mAdaptors[0]);
                int switchType = BackWindowAnimationAdaptor.m9781$$Nest$fgetmSwitchType(this.mAdaptors[0]);
                final Task openTask = this.mAdaptors[0].getTopTask();
                if (openTask != null) goto L10;
                return;
            L10:
                ActivityRecord mainActivity = null;
                if (switchType != 2) goto L17;
                mainActivity = mainOpen.asActivityRecord();
                if (mainActivity != null) goto L17;
                if (mainOpen.asTaskFragment() == null) goto L17;
                mainActivity = mainOpen.asTaskFragment().getTopNonFinishingActivity();
            L17:
                if (mainActivity != null) goto L19;
                ActivityRecord mainActivity2 = openTask.getTopNonFinishingActivity();
                ActivityRecord mainActivity3 = mainActivity2;
            L20:
                if (mainActivity3 != null) goto L23;
                return;
            L23:
                if (this.mAdaptors.length != 1) goto L30;
                if (switchType != 2) goto L26;
            L27:
                chooseActivity = true;
                goto L30
            L26:
                if (mainActivity3.mDisplayContent.isFixedRotationLaunchingApp(mainActivity3) == true) goto L27;
            L30:
                if (chooseActivity == false) goto L33;
                Configuration r3 = mainActivity3.getConfiguration();
            L32:
                Configuration openConfig = r3;
                TaskOrganizerController r4 = openTask.mAtmService.mTaskOrganizerController;
                if (chooseActivity == false) goto L37;
                SurfaceControl r7 = mainActivity3.getSurfaceControl();
            L38:
                this.mRequestedStartingSurfaceId = r4.addWindowlessStartingSurface(openTask, mainActivity3, r7, snapshot, openConfig, new AnonymousClass1(this, openTask));
                return;
            L37:
                r7 = this.mRemoteAnimationTarget.leash;
                goto L38
            L33:
                r3 = openTask.getConfiguration();
                goto L32
            L19:
                mainActivity3 = mainActivity;
                goto L20
            }

            void cleanUpWindowlessSurface(boolean openTransitionMatch) {
                if (this.mRequestedStartingSurfaceId != (-1)) goto L5;
                return;
            L5:
                BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mAdaptors[0]).mWmService.mAtmService.mTaskOrganizerController.removeWindowlessStartingSurface(this.mRequestedStartingSurfaceId, !openTransitionMatch);
                this.mRequestedStartingSurfaceId = -1;
                if (this.mStartingSurface != null) goto L8;
                return;
            L8:
                if (this.mStartingSurface.isValid() == false) goto L12;
                this.mStartingSurface.release();
                this.mStartingSurface = null;
                return;
            }
        }

        class ScheduleAnimationBuilder {
            final BackAnimationAdapter mBackAnimationAdapter;
            WindowContainer mCloseTarget;
            boolean mIsLaunchBehind;
            final NavigationMonitor mNavigationMonitor;
            WindowContainer[] mOpenTargets;
            TaskSnapshot mSnapshot;
            final /* synthetic */ AnimationHandler this$0;

            /* JADX INFO: renamed from: $r8$lambda$5-TMGNN5bJg5OrHMzzAUjDRpoUs, reason: not valid java name */
            public static /* synthetic */ void m9788$r8$lambda$5TMGNN5bJg5OrHMzzAUjDRpoUs(ScheduleAnimationBuilder r0, RemoteAnimationTarget[] r1, IBackAnimationFinishedCallback r2) {
                r0.lambda$build$0(r1, r2);
            }

            /* JADX INFO: renamed from: -$$Nest$mprepareTransitionIfNeeded, reason: not valid java name */
            static /* bridge */ /* synthetic */ Transition m9789$$Nest$mprepareTransitionIfNeeded(ScheduleAnimationBuilder r0, ActivityRecord[] r1, WindowContainer r2, WindowContainer[] r3) {
                return r0.prepareTransitionIfNeeded(r1, r2, r3);
            }

            ScheduleAnimationBuilder(AnimationHandler this$0, BackAnimationAdapter adapter, NavigationMonitor monitor) {
                this.this$0 = this$0;
                this.mBackAnimationAdapter = adapter;
                this.mNavigationMonitor = monitor;
            }

            ScheduleAnimationBuilder setComposeTarget(WindowContainer close, WindowContainer... open) {
                this.mCloseTarget = close;
                this.mOpenTargets = open;
                return this;
            }

            ScheduleAnimationBuilder setIsLaunchBehind(boolean launchBehind) {
                this.mIsLaunchBehind = launchBehind;
                return this;
            }

            boolean containTarget(WindowContainer wc) {
                if (this.mOpenTargets == null) goto L16;
                int i = this.mOpenTargets.length - 1;
            L5:
                if (i < 0) goto L16;
                if (wc == this.mOpenTargets[i]) goto L14;
                if (this.mOpenTargets[i].hasChild(wc) == true) goto L14;
                if (wc.hasChild(this.mOpenTargets[i]) == true) goto L14;
                i = i - 1;
            L14:
                return true;
            L16:
                if (wc != this.mCloseTarget) goto L18;
                return true;
            L18:
                if (this.mCloseTarget.hasChild(wc) == false) goto L20;
                return true;
            L20:
                if (wc.hasChild(this.mCloseTarget) == true) goto L30;
                return false;
            L30:
                return true;
            }

            private Transition prepareTransitionIfNeeded(ActivityRecord[] visibleOpenActivities, WindowContainer promoteToClose, WindowContainer[] promoteToOpen) {
                if (this.mCloseTarget.asWindowState() == null) goto L5;
                return null;
            L5:
                ArrayList<ActivityRecord> makeVisibles = new ArrayList();
                int i = visibleOpenActivities.length - 1;
            L6:
                if (i < 0) goto L14;
                ActivityRecord activity = visibleOpenActivities[i];
                if (activity.mLaunchTaskBehind == true) goto L13;
                if (activity.isVisibleRequested() == true) goto L13;
                makeVisibles.add(activity);
            L13:
                i = i - 1;
                goto L6
            L14:
                TransitionController tc = visibleOpenActivities[0].mTransitionController;
                Transition prepareOpen = tc.createTransition(13);
                tc.collect(promoteToClose);
                prepareOpen.setBackGestureAnimation(promoteToClose, true);
                int i2 = promoteToOpen.length - 1;
            L15:
                if (i2 < 0) goto L18;
                tc.collect(promoteToOpen[i2]);
                prepareOpen.setBackGestureAnimation(promoteToOpen[i2], false);
                i2 = i2 - 1;
                goto L15
            L18:
                if (makeVisibles.isEmpty() == true) goto L20;
                BackNavigationController.m9767$$Nest$smsetLaunchBehind(visibleOpenActivities);
            L20:
                tc.requestStartTransition(prepareOpen, null, null, null);
                prepareOpen.setReady(this.mCloseTarget, true);
                return prepareOpen;
            }

            private void applyPreviewStrategy(BackWindowAnimationAdaptorWrapper openAnimationAdaptor, ActivityRecord[] visibleOpenActivities) {
                if (this.this$0.isSupportWindowlessSurface() == false) goto L16;
                if (AnimationHandler.m9774$$Nest$fgetmShowWindowlessSurface(this.this$0) == false) goto L16;
                if (this.mIsLaunchBehind == true) goto L16;
                boolean activitiesAreDrawn = false;
                int i = visibleOpenActivities.length - 1;
            L9:
                if (i < 0) goto L12;
                activitiesAreDrawn = activitiesAreDrawn | visibleOpenActivities[i].firstWindowDrawn;
                i = i - 1;
                goto L9
            L12:
                if (this.mSnapshot != null) goto L14;
                if (activitiesAreDrawn == true) goto L16;
            L14:
                openAnimationAdaptor.createStartingSurface(this.mSnapshot);
            L16:
                if (AnimationHandler.m9777$$Nest$fgetmWindowManagerService(this.this$0).mRoot.mTransitionController.isShellTransitionsEnabled() == false) goto L20;
                int i2 = visibleOpenActivities.length - 1;
            L18:
                if (i2 < 0) goto L23;
                WindowContainer.enforceSurfaceVisible(visibleOpenActivities[i2]);
                i2 = i2 - 1;
                goto L18
            L23:
                return;
            }

            Runnable build() {
                if (this.mOpenTargets != null) goto L5;
            L30:
                return null;
            L5:
                if (this.mCloseTarget == null) goto L30;
                if (this.mOpenTargets.length == 0) goto L30;
                if (this.mIsLaunchBehind == false) goto L12;
            L15:
                boolean shouldLaunchBehind = true;
            L16:
                ActivityRecord[] openingActivities = BackNavigationController.m9765$$Nest$smgetTopOpenActivities(this.mOpenTargets);
                if (shouldLaunchBehind == false) goto L21;
                if (openingActivities != null) goto L21;
                Slog.e(BackNavigationController.TAG, "No opening activity");
                return null;
            L21:
                if (shouldLaunchBehind == true) goto L26;
                if (AnimationHandler.m9774$$Nest$fgetmShowWindowlessSurface(this.this$0) == false) goto L26;
                this.mSnapshot = BackNavigationController.getSnapshot(this.mOpenTargets[0], openingActivities);
            L26:
                if (AnimationHandler.m9778$$Nest$mcomposeAnimations(this.this$0, this, openingActivities) == true) goto L28;
                return null;
            L28:
                this.mCloseTarget.mTransitionController.mSnapshotController.mActivitySnapshotController.clearOnBackPressedActivities();
                applyPreviewStrategy(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.this$0), openingActivities);
                final IBackAnimationFinishedCallback callback = makeAnimationFinishedCallback();
                final RemoteAnimationTarget[] targets = this.this$0.getAnimationTargets();
                return new BackNavigationController$AnimationHandler$ScheduleAnimationBuilder$$ExternalSyntheticLambda0(this, targets, callback);
            L12:
                if (this.this$0.isSupportWindowlessSurface() == false) goto L15;
                shouldLaunchBehind = false;
                goto L16
            }

            private /* synthetic */ void lambda$build$0(RemoteAnimationTarget[] targets, IBackAnimationFinishedCallback callback) {
            L10:
                e = move-exception;
                e.printStackTrace();
                return;
            L3:
                if (this.this$0.hasTargetDetached() == true) goto L14;
                if (BackNavigationController.m9768$$Nest$smvalidateAnimationTargets(targets) == false) goto L14;
                IBackAnimationRunner r0 = this.mBackAnimationAdapter.getRunner();     // Catch: RemoteException -> L10
                if (BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.this$0)) == null) goto L12;
                IBinder r1 = BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.this$0)).getToken();     // Catch: RemoteException -> L10
            L13:
                r0.onAnimationStart(targets, r1, callback);     // Catch: RemoteException -> L10
                return;
            L12:
                r1 = null;
            L14:
                NavigationMonitor.m9790$$Nest$mcancelBackNavigating(this.mNavigationMonitor, "cancelAnimation");     // Catch: RemoteException -> L10
                this.mBackAnimationAdapter.getRunner().onAnimationCancelled();     // Catch: RemoteException -> L10
            }

            private IBackAnimationFinishedCallback makeAnimationFinishedCallback() {
                return new AnonymousClass1(this);
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$j_Usepx8sckcuZ-ZGxie3DwEoCs, reason: not valid java name */
        public static /* synthetic */ void m9769$r8$lambda$j_Usepx8sckcuZZGxie3DwEoCs(AnimationHandler r0) {
            r0.lambda$markStartingSurfaceMatch$0();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCloseAdaptor, reason: not valid java name */
        static /* bridge */ /* synthetic */ BackWindowAnimationAdaptor m9770$$Nest$fgetmCloseAdaptor(AnimationHandler r0) {
            return r0.mCloseAdaptor;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmComposed, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9771$$Nest$fgetmComposed(AnimationHandler r0) {
            return r0.mComposed;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOpenActivities, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityRecord[] m9772$$Nest$fgetmOpenActivities(AnimationHandler r0) {
            return r0.mOpenActivities;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOpenAnimAdaptor, reason: not valid java name */
        static /* bridge */ /* synthetic */ BackWindowAnimationAdaptorWrapper m9773$$Nest$fgetmOpenAnimAdaptor(AnimationHandler r0) {
            return r0.mOpenAnimAdaptor;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShowWindowlessSurface, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9774$$Nest$fgetmShowWindowlessSurface(AnimationHandler r0) {
            return r0.mShowWindowlessSurface;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSwitchType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9775$$Nest$fgetmSwitchType(AnimationHandler r0) {
            return r0.mSwitchType;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWaitTransition, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9776$$Nest$fgetmWaitTransition(AnimationHandler r0) {
            return r0.mWaitTransition;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerService, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowManagerService m9777$$Nest$fgetmWindowManagerService(AnimationHandler r0) {
            return r0.mWindowManagerService;
        }

        /* JADX INFO: renamed from: -$$Nest$mcomposeAnimations, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9778$$Nest$mcomposeAnimations(AnimationHandler r0, ScheduleAnimationBuilder r1, ActivityRecord[] r2) {
            return r0.composeAnimations(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$smcreateAdaptor, reason: not valid java name */
        static /* bridge */ /* synthetic */ BackWindowAnimationAdaptor m9779$$Nest$smcreateAdaptor(WindowContainer r0, boolean r1, int r2, SurfaceControl.Transaction r3) {
            return createAdaptor(r0, r1, r2, r3);
        }

        AnimationHandler(WindowManagerService wms) {
            this.mSwitchType = 0;
            this.mWindowManagerService = wms;
            Context context = wms.mContext;
            this.mShowWindowlessSurface = context.getResources().getBoolean(R.bool.config_refreshRateSynchronizationEnabled);
        }

        private static boolean isActivitySwitch(WindowContainer close, WindowContainer[] open) {
            if (open != null) goto L5;
        L20:
            return false;
        L5:
            if (open.length == 0) goto L20;
            if (close.asActivityRecord() == null) goto L20;
            Task closeTask = close.asActivityRecord().getTask();
            int i = open.length - 1;
        L10:
            if (i < 0) goto L19;
            if (open[i].asActivityRecord() == null) goto L17;
            if (closeTask != open[i].asActivityRecord().getTask()) goto L17;
            i = i - 1;
        L17:
            return false;
        L19:
            return true;
        }

        private static boolean isTaskSwitch(WindowContainer close, WindowContainer[] open) {
            if (open != null) goto L5;
        L15:
            return false;
        L5:
            if (open.length != 1) goto L15;
            if (close.asTask() == null) goto L15;
            if (open[0].asTask() != null) goto L12;
            return false;
        L12:
            if (close.asTask() != open[0].asTask()) goto L14;
            return false;
        L14:
            return true;
        }

        private static boolean isDialogClose(WindowContainer close) {
            if (close.asWindowState() == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void initiate(ScheduleAnimationBuilder builder, ActivityRecord[] openingActivities) {
            WindowContainer close = builder.mCloseTarget;
            WindowContainer[] open = builder.mOpenTargets;
            if (isActivitySwitch(close, open) == false) goto L6;
            this.mSwitchType = 2;
            Pair<WindowContainer, WindowContainer[]> replaced = promoteToTFIfNeeded(close, open);
            close = (WindowContainer) replaced.first;
            open = (WindowContainer[]) replaced.second;
        L11:
            Transition prepareTransition = ScheduleAnimationBuilder.m9789$$Nest$mprepareTransitionIfNeeded(builder, openingActivities, close, open);
            SurfaceControl.Transaction st = openingActivities[0].getSyncTransaction();
            if (prepareTransition == null) goto L14;
            SurfaceControl.Transaction ct = st;
        L15:
            this.mCloseAdaptor = createAdaptor(close, false, this.mSwitchType, ct);
            if (BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(this.mCloseAdaptor) != null) goto L23;
            Slog.w(BackNavigationController.TAG, "composeNewAnimations fail, skip");
            if (prepareTransition == null) goto L20;
            prepareTransition.abort();
        L20:
            clearBackAnimateTarget(true);
            return;
        L23:
            if (openingActivities.length != 1) goto L27;
            ActivityRecord next = openingActivities[0];
            DisplayContent dc = next.mDisplayContent;
            dc.rotateInDifferentOrientationIfNeeded(next);
            if (next.hasFixedRotationTransform() == false) goto L27;
            dc.setFixedRotationLaunchingApp(next, next.getWindowConfiguration().getRotation());
        L27:
            this.mOpenAnimAdaptor = new BackWindowAnimationAdaptorWrapper(true, this.mSwitchType, st, open);
            if (this.mOpenAnimAdaptor.isValid() == true) goto L34;
            Slog.w(BackNavigationController.TAG, "compose animations fail, skip");
            if (prepareTransition == null) goto L32;
            prepareTransition.abort();
        L32:
            clearBackAnimateTarget(true);
            return;
        L34:
            BackWindowAnimationAdaptorWrapper.m9786$$Nest$fputmPreparedOpenTransition(this.mOpenAnimAdaptor, prepareTransition);
            this.mOpenActivities = openingActivities;
            return;
        L14:
            ct = close.getPendingTransaction();
            goto L15
        L6:
            if (isTaskSwitch(close, open) == false) goto L9;
            this.mSwitchType = 1;
            goto L11
        L9:
            if (isDialogClose(close) == false) goto L36;
            this.mSwitchType = 3;
            goto L11
        L36:
            this.mSwitchType = 0;
        }

        private Pair<WindowContainer, WindowContainer[]> promoteToTFIfNeeded(WindowContainer close, WindowContainer[] open) {
            WindowContainer replaceClose = close;
            TaskFragment closeTF = close.asActivityRecord().getTaskFragment();
            if (closeTF != null) goto L5;
        L7:
            WindowContainer[] replaceOpen = new WindowContainer[open.length];
            if (open.length < 2) goto L17;
            int i = open.length - 1;
        L10:
            if (i < 0) goto L33;
            replaceOpen[i] = open[i].asActivityRecord().getTaskFragment();
            if (closeTF == null) goto L14;
            WindowContainer r4 = closeTF;
        L15:
            replaceClose = r4;
            i = i - 1;
            goto L10
        L14:
            r4 = close;
        L33:
            return new Pair(replaceClose, replaceOpen);
        L17:
            TaskFragment openTF = open[0].asActivityRecord().getTaskFragment();
            if (openTF != null) goto L20;
        L22:
            if (closeTF == openTF) goto L31;
            if (openTF == null) goto L25;
            WindowContainer r5 = openTF;
        L26:
            replaceOpen[0] = r5;
            if (closeTF == null) goto L29;
            WindowContainer r3 = closeTF;
        L30:
            replaceClose = r3;
            goto L33
        L29:
            r3 = close;
            goto L30
        L25:
            r5 = open[0];
            goto L26
        L31:
            replaceOpen[0] = open[0];
            goto L33
        L20:
            if (openTF.isEmbedded() == true) goto L22;
            openTF = null;
            goto L22
        L5:
            if (closeTF.isEmbedded() == true) goto L7;
            closeTF = null;
            goto L7
        }

        private boolean composeAnimations(ScheduleAnimationBuilder builder, ActivityRecord[] openingActivities) {
            if (this.mComposed == false) goto L5;
        L22:
            Slog.e(BackNavigationController.TAG, "Previous animation is running " + this);
            return false;
        L5:
            if (this.mWaitTransition == true) goto L22;
            clearBackAnimateTarget(true);
            WindowContainer[] open = builder.mOpenTargets;
            if (builder.mCloseTarget == null) goto L20;
            if (open == null) goto L20;
            if (open.length == 0) goto L20;
            if (open.length > 2) goto L20;
            initiate(builder, openingActivities);
            if (this.mSwitchType != 0) goto L18;
            return false;
        L18:
            this.mComposed = true;
            this.mWaitTransition = false;
            return true;
        L20:
            Slog.e(BackNavigationController.TAG, "reset animation with null target close: " + builder.mCloseTarget + " open: " + Arrays.toString(open));
            return false;
        }

        RemoteAnimationTarget[] getAnimationTargets() {
            if (this.mComposed == true) goto L6;
            return null;
        L6:
            RemoteAnimationTarget[] targets = {BackWindowAnimationAdaptor.m9780$$Nest$fgetmAnimationTarget(this.mCloseAdaptor), this.mOpenAnimAdaptor.mRemoteAnimationTarget};
            return targets;
        }

        boolean isSupportWindowlessSurface() {
            return this.mWindowManagerService.mAtmService.mTaskOrganizerController.isSupportWindowlessStartingSurface();
        }

        boolean containTarget(ArrayList<WindowContainer> wcs, boolean open) {
            int i = wcs.size() - 1;
        L3:
            if (i < 0) goto L9;
            if (isTarget(wcs.get(i), open) == true) goto L6;
            i = i - 1;
            goto L3
        L6:
            return true;
        L9:
            return wcs.isEmpty();
        }

        boolean isTarget(WindowContainer wc, boolean open) {
            if (this.mComposed == true) goto L5;
            return false;
        L5:
            if (open == false) goto L15;
            int i = this.mOpenAnimAdaptor.mAdaptors.length - 1;
        L7:
            if (i < 0) goto L13;
            if (isAnimateTarget(wc, BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mOpenAnimAdaptor.mAdaptors[i]), this.mSwitchType) == true) goto L10;
            i = i - 1;
            goto L7
        L10:
            return true;
        L13:
            return false;
        L15:
            return isAnimateTarget(wc, BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mCloseAdaptor), this.mSwitchType);
        }

        void markWindowHasDrawn(ActivityRecord activity) {
            if (this.mComposed == true) goto L5;
            return;
        L5:
            if (this.mWaitTransition == false) goto L7;
            return;
        L7:
            if (BackWindowAnimationAdaptorWrapper.m9784$$Nest$fgetmRequestedStartingSurfaceId(this.mOpenAnimAdaptor) == (-1)) goto L31;
            boolean allWindowDrawn = true;
            int i = this.mOpenAnimAdaptor.mAdaptors.length - 1;
        L10:
            if (i < 0) goto L15;
            BackWindowAnimationAdaptor next = this.mOpenAnimAdaptor.mAdaptors[i];
            if (isAnimateTarget(activity, BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(next), this.mSwitchType) == false) goto L14;
            next.mAppWindowDrawn = true;
        L14:
            allWindowDrawn = allWindowDrawn & next.mAppWindowDrawn;
            i = i - 1;
            goto L10
        L15:
            int i2 = activity.getSyncTransactionCommitCallbackDepth();
            if (i2 <= 0) goto L18;
            return;
        L18:
            if (activity.mSyncState != 0) goto L29;
            if (allWindowDrawn == false) goto L28;
            this.mOpenAnimAdaptor.cleanUpWindowlessSurface(true);
            return;
        L28:
            return;
        L29:
            return;
        }

        boolean isStartingSurfaceDrawn(ActivityRecord activity) {
            if (this.mComposed == true) goto L5;
        L14:
            return false;
        L5:
            if (BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(this.mOpenAnimAdaptor) == null) goto L14;
            if (isTarget(activity, true) == true) goto L10;
            return false;
        L10:
            if (BackWindowAnimationAdaptorWrapper.m9785$$Nest$fgetmStartingSurface(this.mOpenAnimAdaptor) != null) goto L12;
            return false;
        L12:
            return true;
        }

        private static boolean isAnimateTarget(WindowContainer window, WindowContainer animationTarget, int switchType) {
            if (switchType != 1) goto L23;
            if (window.isActivityTypeHome() == true) goto L7;
        L9:
            if (window == animationTarget) goto L21;
            if (animationTarget.asTask() == null) goto L15;
            if (animationTarget.hasChild(window) == true) goto L21;
        L15:
            if (animationTarget.asActivityRecord() != null) goto L17;
            return false;
        L17:
            if (window.hasChild(animationTarget) == true) goto L21;
            return false;
        L21:
            return true;
        L7:
            if (animationTarget.isActivityTypeHome() == false) goto L9;
            return true;
        L23:
            if (switchType != 2) goto L37;
            if (window == animationTarget) goto L36;
            if (window.asTaskFragment() == null) goto L30;
            if (window.hasChild(animationTarget) == true) goto L36;
        L30:
            if (animationTarget.asTaskFragment() != null) goto L32;
            return false;
        L32:
            if (animationTarget.hasChild(window) == true) goto L36;
            return false;
        L36:
            return true;
        L37:
            return false;
        }

        void finishPresentAnimations(boolean cancel) {
            if (this.mOpenActivities == null) goto L24;
            int i = this.mOpenActivities.length - 1;
        L5:
            if (i < 0) goto L24;
            ActivityRecord resetActivity = this.mOpenActivities[i];
            if (resetActivity.mDisplayContent.isFixedRotationLaunchingApp(resetActivity) == false) goto L9;
            resetActivity.mDisplayContent.continueUpdateOrientationForDiffOrienLaunchingApp();
        L9:
            Transition finishTransition = resetActivity.mTransitionController.mFinishingTransition;
            if (finishTransition != null) goto L12;
        L18:
            boolean inFinishTransition = false;
        L20:
            if (resetActivity.mLaunchTaskBehind == false) goto L22;
            BackNavigationController.m9766$$Nest$smrestoreLaunchBehind(resetActivity, cancel, inFinishTransition);
        L22:
            i = i - 1;
            goto L5
        L12:
            if (this.mPrepareCloseTransition != finishTransition) goto L14;
        L17:
            inFinishTransition = true;
            goto L20
        L14:
            if (this.mOpenAnimAdaptor == null) goto L18;
            if (BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(this.mOpenAnimAdaptor) != finishTransition) goto L18;
        L24:
            if (this.mCloseAdaptor == null) goto L27;
            BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mCloseAdaptor).cancelAnimation();
            this.mCloseAdaptor = null;
        L27:
            if (this.mOpenAnimAdaptor == null) goto L33;
            this.mOpenAnimAdaptor.cleanUp(this.mStartingSurfaceTargetMatch);
            this.mOpenAnimAdaptor = null;
            return;
        }

        void markStartingSurfaceMatch(SurfaceControl.Transaction startTransaction) {
            if (this.mStartingSurfaceTargetMatch == false) goto L5;
            return;
        L5:
            this.mStartingSurfaceTargetMatch = true;
            if (BackWindowAnimationAdaptorWrapper.m9784$$Nest$fgetmRequestedStartingSurfaceId(this.mOpenAnimAdaptor) != (-1)) goto L8;
            return;
        L8:
            boolean allWindowDrawn = true;
            int i = this.mOpenAnimAdaptor.mAdaptors.length - 1;
        L9:
            if (i < 0) goto L12;
            BackWindowAnimationAdaptor next = this.mOpenAnimAdaptor.mAdaptors[i];
            allWindowDrawn = allWindowDrawn & next.mAppWindowDrawn;
            i = i - 1;
            goto L9
        L12:
            if (allWindowDrawn == true) goto L14;
            return;
        L14:
            startTransaction.addTransactionCommittedListener(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new BackNavigationController$AnimationHandler$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$markStartingSurfaceMatch$0() {
            WindowManagerGlobalLock r0 = this.mWindowManagerService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.mOpenAnimAdaptor == null) goto L9;
            this.mOpenAnimAdaptor.cleanUpWindowlessSurface(true);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
        }

        void clearBackAnimateTarget(boolean cancel) {
            if (this.mComposed == false) goto L5;
            this.mComposed = false;
            finishPresentAnimations(cancel);
        L5:
            this.mPrepareCloseTransition = null;
            this.mWaitTransition = false;
            this.mStartingSurfaceTargetMatch = false;
            this.mSwitchType = 0;
            this.mOpenActivities = null;
        }

        boolean containsBackAnimationTargets(ArrayList<WindowContainer> openApps, ArrayList<WindowContainer> closeApps) {
            if (containTarget(closeApps, false) == true) goto L5;
            return false;
        L5:
            if (containTarget(openApps, true) == true) goto L10;
            if (containTarget(openApps, false) == true) goto L10;
            return false;
        L10:
            return true;
        }

        boolean hasTargetDetached() {
            if (this.mComposed == true) goto L6;
            return false;
        L6:
            int i = this.mOpenAnimAdaptor.mAdaptors.length - 1;
        L7:
            if (i < 0) goto L13;
            if (BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mOpenAnimAdaptor.mAdaptors[i]).isAttached() == false) goto L10;
            i = i - 1;
            goto L7
        L10:
            return true;
        L13:
            return !BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mCloseAdaptor).isAttached();
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("AnimationTargets{ openTarget= ");
            WindowContainer r2 = null;
            if (this.mOpenAnimAdaptor == null) goto L5;
            String r1 = dumpOpenAnimTargetsToString();
        L6:
            r0.append(r1);
            r0.append(" closeTarget= ");
            if (this.mCloseAdaptor == null) goto L9;
            r2 = BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mCloseAdaptor);
        L9:
            r0.append(r2);
            r0.append(" mSwitchType= ");
            r0.append(this.mSwitchType);
            r0.append(" mComposed= ");
            r0.append(this.mComposed);
            r0.append(" mWaitTransition= ");
            r0.append(this.mWaitTransition);
            r0.append('}');
            return r0.toString();
        L5:
            r1 = null;
            goto L6
        }

        private String dumpOpenAnimTargetsToString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            int i = 0;
        L4:
            if (i >= this.mOpenAnimAdaptor.mAdaptors.length) goto L8;
            if (i <= 0) goto L7;
            sb.append(',');
        L7:
            sb.append(BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(this.mOpenAnimAdaptor.mAdaptors[i]));
            i = i + 1;
            goto L4
        L8:
            sb.append("}");
            return sb.toString();
        }

        private static BackWindowAnimationAdaptor createAdaptor(WindowContainer target, boolean isOpen, int switchType, SurfaceControl.Transaction st) {
            BackWindowAnimationAdaptor adaptor = new BackWindowAnimationAdaptor(target, isOpen, switchType);
            if (isOpen == true) goto L5;
        L9:
            target.startAnimation(st, adaptor, false, 256);
            return adaptor;
        L5:
            if (target.asActivityRecord() == null) goto L9;
            TaskFragment fragment = target.asActivityRecord().getTaskFragment();
            if (fragment == null) goto L9;
            fragment.updateOrganizedTaskFragmentSurface();
            st.show(fragment.mSurfaceControl);
            goto L9
        }

        ScheduleAnimationBuilder prepareAnimation(int backType, BackAnimationAdapter adapter, NavigationMonitor monitor, Task currentTask, Task previousTask, ActivityRecord currentActivity, ArrayList<ActivityRecord> previousActivity, WindowContainer removedWindowContainer) {
            ScheduleAnimationBuilder builder = new ScheduleAnimationBuilder(this, adapter, monitor);
            switch(backType) {
                case 0: goto L13;
                case 1: goto L11;
                case 2: goto L8;
                case 3: goto L7;
                default: goto L4;
            };
        L4:
            return null;
        L8:
            ActivityRecord[] prevActs = new ActivityRecord[previousActivity.size()];
            ActivityRecord[] prevActs2 = (ActivityRecord[]) previousActivity.toArray(prevActs);
            return builder.setComposeTarget(currentActivity, prevActs2).setIsLaunchBehind(false);
        L7:
            return builder.setComposeTarget(currentTask, new WindowContainer[]{previousTask}).setIsLaunchBehind(false);
        L11:
            return builder.setIsLaunchBehind(true).setComposeTarget(currentTask, new WindowContainer[]{previousTask});
        L13:
            return builder.setComposeTarget(removedWindowContainer, new WindowContainer[]{currentActivity}).setIsLaunchBehind(false);
        }
    }

    class NavigationMonitor {
        private final IBinder.DeathRecipient mListenerDeathRecipient;
        private WindowState mNavigatingWindow;
        private RemoteCallback mObserver;
        final /* synthetic */ BackNavigationController this$0;

        /* JADX INFO: renamed from: -$$Nest$mcancelBackNavigating, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9790$$Nest$mcancelBackNavigating(NavigationMonitor r0, String r1) {
            r0.cancelBackNavigating(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monFocusWindowChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9791$$Nest$monFocusWindowChanged(NavigationMonitor r0, WindowState r1) {
            r0.onFocusWindowChanged(r1);
        }

        NavigationMonitor(BackNavigationController this$0) {
            this.this$0 = this$0;
            this.mListenerDeathRecipient = new AnonymousClass1(this);
        }

        void startMonitor(WindowState window, RemoteCallback observer) {
            this.mNavigatingWindow = window;
            this.mObserver = observer;
            this.mObserver.getInterface().asBinder().linkToDeath(this.mListenerDeathRecipient, 0);     // Catch: RemoteException -> L5
            return;
        L6:
            Slog.e(BackNavigationController.TAG, "Failed to link to death");
        }

        void stopMonitorForRemote() {
            if (this.mObserver == null) goto L5;
            this.mObserver.getInterface().asBinder().unlinkToDeath(this.mListenerDeathRecipient, 0);
        L5:
            this.mObserver = null;
        }

        void stopMonitorTransition() {
            this.mNavigatingWindow = null;
        }

        boolean isMonitorForRemote() {
            if (this.mNavigatingWindow != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mObserver == null) goto L7;
            return true;
        }

        boolean isMonitorAnimationOrTransition() {
            if (this.mNavigatingWindow != null) goto L5;
        L9:
            return false;
        L5:
            if (AnimationHandler.m9771$$Nest$fgetmComposed(BackNavigationController.m9761$$Nest$fgetmAnimationHandler(this.this$0)) == false) goto L7;
        L8:
            return true;
        L7:
            if (AnimationHandler.m9776$$Nest$fgetmWaitTransition(BackNavigationController.m9761$$Nest$fgetmAnimationHandler(this.this$0)) == false) goto L9;
            goto L8
        }

        private void onFocusWindowChanged(WindowState newFocus) {
            if (atSameDisplay(newFocus) == true) goto L5;
            return;
        L5:
            if (isMonitorForRemote() == false) goto L7;
        L9:
            if (newFocus != null) goto L11;
            return;
        L11:
            if (newFocus != this.mNavigatingWindow) goto L13;
            return;
        L13:
            if (newFocus.mActivityRecord != null) goto L15;
        L16:
            cancelBackNavigating("focusWindowChanged");
            return;
        L15:
            if (newFocus.mActivityRecord == this.mNavigatingWindow.mActivityRecord) goto L16;
            return;
        L7:
            if (isMonitorAnimationOrTransition() == true) goto L9;
        }

        void onEmbeddedWindowGestureTransferred(WindowState host) {
            if (isMonitorForRemote() == true) goto L5;
            return;
        L5:
            if (host != this.mNavigatingWindow) goto L10;
            Bundle result = new Bundle();
            result.putBoolean("TouchGestureTransferred", true);
            this.mObserver.sendResult(result);
            return;
        }

        private boolean atSameDisplay(WindowState newFocus) {
            if (this.mNavigatingWindow != null) goto L5;
            return false;
        L5:
            int navigatingDisplayId = this.mNavigatingWindow.getDisplayId();
            if (newFocus != null) goto L8;
        L9:
            return true;
        L8:
            if (newFocus.getDisplayId() == navigatingDisplayId) goto L9;
            return false;
        }

        private void cancelBackNavigating(String reason) {
            EventLogTags.writeWmBackNaviCanceled(reason);
            if (isMonitorForRemote() == false) goto L6;
            this.mObserver.sendResult(null);
        L6:
            if (isMonitorAnimationOrTransition() == true) goto L8;
        L10:
            BackNavigationController.m9764$$Nest$mcancelPendingAnimation(this.this$0);
            return;
        L8:
            if (BackNavigationController.m9763$$Nest$mcanCancelAnimations(this.this$0) == false) goto L10;
            this.this$0.clearBackAnimations(true);
            goto L10
        }
    }

    public static /* synthetic */ void $r8$lambda$3_KWrE8HBx9sWqaF7TUbrvEMTM8(BackNavigationController r0, Bundle r1) {
        r0.lambda$startBackNavigation$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$9FAtneOmsYwhkA7x9NZbSzZmCVg(ActivityRecord r0) {
        return lambda$getAnimatablePrevActivities$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$MpGSwhHhHzFwdxMFmCI8GhqOovU(ArrayList r0, TaskFragment r1) {
        lambda$addPreviousAdjacentActivityIfExist$10(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ZWcHyBw4KQ0liM5RskEDFSCfIrs(ActivityRecord r0) {
        return lambda$getAnimatablePrevActivities$7(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$_sV-s730ojBqnLYMHc-ZKLBxF6k, reason: not valid java name */
    public static /* synthetic */ ComponentName m9756$r8$lambda$_sVs730ojBqnLYMHcZKLBxF6k(ActivityRecord r0) {
        return lambda$startBackNavigation$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$dzjU19f-cdWdq3iK18MCOe7rztY, reason: not valid java name */
    public static /* synthetic */ boolean m9757$r8$lambda$dzjU19fcdWdq3iK18MCOe7rztY(TaskFragment[] r0, TaskFragment r1) {
        return lambda$getAnimatablePrevActivities$8(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$g_ByDeNVNXPA9YaYHzGXMOjxL_o(Task r0) {
        return lambda$startBackNavigation$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$iba_QcmJPhU9b-dQl7x9mb0PizA, reason: not valid java name */
    public static /* synthetic */ void m9758$r8$lambda$iba_QcmJPhU9bdQl7x9mb0PizA(ArrayList r0, TaskFragment r1) {
        lambda$findAdjacentActivityIfExist$11(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jtdGhPvR6R8BpMfaHPUFhfbu-Xk, reason: not valid java name */
    public static /* synthetic */ boolean m9759$r8$lambda$jtdGhPvR6R8BpMfaHPUFhfbuXk(ActivityRecord r0) {
        return lambda$getAnimatablePrevActivities$6(r0);
    }

    public static /* synthetic */ void $r8$lambda$mF74DH2d0MR6aEa1hZ5Su4VxFXQ(BackNavigationController r0) {
        r0.lambda$registerBackGestureDelegate$0();
    }

    public static /* synthetic */ void $r8$lambda$ptIdwp8stbZ4vPWtkGqX3ppBLc4(BackNavigationController r0, int r1, Bundle r2) {
        r0.lambda$startBackNavigation$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$zeWg6C_okbSt8pY-FxCY8pNTnmg, reason: not valid java name */
    public static /* synthetic */ boolean m9760$r8$lambda$zeWg6C_okbSt8pYFxCY8pNTnmg(ActivityRecord r0) {
        return lambda$getAnimatablePrevActivities$9(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAnimationHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ AnimationHandler m9761$$Nest$fgetmAnimationHandler(BackNavigationController r0) {
        return r0.mAnimationHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m9762$$Nest$fgetmWindowManagerService(BackNavigationController r0) {
        return r0.mWindowManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$mcanCancelAnimations, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9763$$Nest$mcanCancelAnimations(BackNavigationController r0) {
        return r0.canCancelAnimations();
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelPendingAnimation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9764$$Nest$mcancelPendingAnimation(BackNavigationController r0) {
        r0.cancelPendingAnimation();
    }

    /* JADX INFO: renamed from: -$$Nest$smgetTopOpenActivities, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityRecord[] m9765$$Nest$smgetTopOpenActivities(WindowContainer[] r0) {
        return getTopOpenActivities(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smrestoreLaunchBehind, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9766$$Nest$smrestoreLaunchBehind(ActivityRecord r0, boolean r1, boolean r2) {
        restoreLaunchBehind(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smsetLaunchBehind, reason: not valid java name */
    static /* bridge */ /* synthetic */ Transition m9767$$Nest$smsetLaunchBehind(ActivityRecord[] r0) {
        return setLaunchBehind(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smvalidateAnimationTargets, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9768$$Nest$smvalidateAnimationTargets(RemoteAnimationTarget[] r0) {
        return validateAnimationTargets(r0);
    }

    BackNavigationController() {
        this.mNavigationMonitor = new NavigationMonitor(this);
        this.mTmpOpenApps = new ArrayList();
        this.mTmpCloseApps = new ArrayList();
    }

    static {
        sPredictBackEnable = SystemProperties.getBoolean("persist.wm.debug.predictive_back", true);
    }

    void onFocusChanged(WindowState newFocus) {
        NavigationMonitor.m9791$$Nest$monFocusWindowChanged(this.mNavigationMonitor, newFocus);
    }

    void onEmbeddedWindowGestureTransferred(WindowState host) {
        this.mNavigationMonitor.onEmbeddedWindowGestureTransferred(host);
    }

    void registerBackGestureDelegate(RemoteCallback requestObserver) {
        if (sPredictBackEnable == true) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r0 = this.mWindowManagerService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mGestureRequest = requestObserver;     // Catch: Throwable -> L10
        requestObserver.getInterface().asBinder().linkToDeath(new BackNavigationController$$ExternalSyntheticLambda6(this), 0);     // Catch: Throwable -> L10 RemoteException -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        Slog.e(TAG, "Failed to link to death");     // Catch: Throwable -> L10
        this.mGestureRequest = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$registerBackGestureDelegate$0() {
        WindowManagerGlobalLock r0 = this.mWindowManagerService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mGestureRequest = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean requestBackGesture() {
        WindowManagerGlobalLock r0 = this.mWindowManagerService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mGestureRequest != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L11:
        this.mGestureRequest.sendResult(null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0158: MOVE (r6 I:??[OBJECT, ARRAY] A[D('currentActivity' com.android.server.wm.ActivityRecord)]) = (r18 I:??[OBJECT, ARRAY] A[D('prevTask' com.android.server.wm.Task)]), block:B:90:0x0153 */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x0358: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r29 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('backType' int)]), block:B:215:0x0352 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v57, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v4 */
    BackNavigationInfo startBackNavigation(RemoteCallback r35, BackAnimationAdapter r36) {
        if (sPredictBackEnable == true) goto L5;
        return null;
    L5:
        WindowManagerService r12 = this.mWindowManagerService;
        Task r5 = null;
        BackNavigationInfo.Builder r0 = new BackNavigationInfo.Builder();
        WindowManagerGlobalLock r14 = r12.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r14);
    L369:
        th = th;
    L380:
        monitor-exit(r14);     // Catch: Throwable -> L374
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L374:
        th = th;
        goto L380
    L8:
        if (isMonitoringFinishTransition() == true) goto L403;
        WindowState r1 = r12.getObricExt().resolveBackFocusedWindow();     // Catch: Throwable -> L369
        if (r1 == null) goto L389;
        int r10 = -1;
        Object r16 = null;
    L407:
        r12.mAtmService.getObricExt().onBackNavigationStarted(r1);     // Catch: Throwable -> L367
        if (r1 != null) goto L42;
        Slog.e(TAG, "Window is null, returning null.");     // Catch: Throwable -> L23
        monitor-exit(r14);     // Catch: Throwable -> L23
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L42:
        if (r1.getDisplayContent().getImeContainer().isVisible() == false) goto L44;
    L45:
        if (r1.isDrawn() == true) goto L397;
    L54:
        th = th;
        goto L380
    L48:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L57;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, 2881085074175114605L, 0, null);     // Catch: Throwable -> L52
    L57:
        monitor-exit(r14);     // Catch: Throwable -> L52
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L397:
        ActivityRecord r2 = r1.getActivityRecord();     // Catch: Throwable -> L365
        if (r2 != null) goto L64;
    L68:
        ArrayList<EmbeddedWindowController.EmbeddedWindow> r6 = r12.mEmbeddedWindowController.getByHostWindow(r1);     // Catch: Throwable -> L365
        ActivityRecord r7 = r1.mActivityRecord;     // Catch: Throwable -> L365
        Task r17 = r1.getTask();     // Catch: Throwable -> L363
        if (r17 == null) goto L77;
    L75:
        th = th;
        goto L380
    L73:
        if (r17.isVisibleRequested() == true) goto L77;
    L85:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L94;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, -6183551796617134986L, 0, null);     // Catch: Throwable -> L89
    L91:
        th = th;
    L94:
        monitor-exit(r14);     // Catch: Throwable -> L89
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L77:
        if (r7 == null) goto L80;
        if (r7.isVisibleRequested() == false) goto L85;
    L80:
        if (r7 == null) goto L436;
        if (r17 == null) goto L436;
        if (r17.getTopNonFinishingActivity() != r7) goto L85;
    L436:
        OnBackInvokedCallbackInfo r3 = r1.getOnBackInvokedCallbackInfo();     // Catch: Throwable -> L361
        if (r3 != null) goto L106;
        Slog.e(TAG, "No callback registered, returning null.");     // Catch: Throwable -> L89
        monitor-exit(r14);     // Catch: Throwable -> L89
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L106:
        if (r3.isSystemCallback() == true) goto L109;
        int r4 = 4;
    L411:
        r0.setOnBackInvokedCallback(r3.getCallback());     // Catch: Throwable -> L359
        r0.setAnimationCallback(r3.isAnimationCallback());     // Catch: Throwable -> L359
        r0.setTouchableRegion(r1.getFrame());     // Catch: Throwable -> L359
        if (r17 == null) goto L116;
        r0.setFocusedTaskId(r17.mTaskId);     // Catch: Throwable -> L113
    L113:
        th = th;
    L116:
        if (r6 == null) goto L123;
        int r11 = r6.size() - 1;     // Catch: Throwable -> L113
    L118:
        if (r11 < 0) goto L123;
        if (r6.get(r11).mGestureToEmbedded == true) goto L121;
        r11 = r11 - 1;
        goto L118
    L121:
        char r13 = 1;
    L126:
        if ((r1.mAttrs.privateFlags & 128) == 0) goto L128;
        boolean r8 = true;
    L130:
        if (r8 == false) goto L135;
        if (r13 != 0) goto L135;
        if (r3.isAnimationCallback() == false) goto L135;
        boolean r9 = true;
    L136:
        r0.setAppProgressAllowed(r9);     // Catch: Throwable -> L359
        this.mNavigationMonitor.startMonitor(r1, r35);     // Catch: Throwable -> L359
        int r15 = r3.getOverrideBehavior();     // Catch: Throwable -> L359
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == true) goto L421;
        WindowContainer r22 = null;
    L147:
        if (r15 != 2) goto L156;
        if (r17 == null) goto L151;
        ActivityRecord r18 = r17.getRootActivity();     // Catch: Throwable -> L141
    L153:
        if (r7 == null) goto L156;
        if (r18 == r7) goto L156;
        int r19 = 0;
    L415:
        this.mWindowManagerService.clearPointerDownOutsideFocusRunnable();     // Catch: Throwable -> L350
        if (r4 == 4) goto L401;
        if (r7 == null) goto L401;
        if (r17 == null) goto L401;
        if (r7.isActivityTypeHome() == false) goto L169;
        if (r1.mAttrs.type == 1) goto L401;
    L169:
        if (r7.mHasSceneTransition == true) goto L401;
        ArrayList<ActivityRecord> r20 = new ArrayList();     // Catch: Throwable -> L350
        boolean r21 = getAnimatablePrevActivities(r17, r7, r20);     // Catch: Throwable -> L350
        boolean r23 = isKeyguardOccluded(r1);     // Catch: Throwable -> L350
        if (r21 == true) goto L175;
        int r24 = 4;
        Task r25 = null;
        WindowContainer r110 = r22;
    L391:
        r0.setType(r24);     // Catch: Throwable -> L346
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == true) goto L430;
        ActivityRecord r31 = r7;
        Task r111 = r25;
        int r26 = 0;
    L299:
        if (r24 != 1) goto L301;
    L305:
        if (r36 == null) goto L309;
        if (r36.isAnimatable(r24) == false) goto L309;
        int r27 = 1;
    L311:
        if (r27 == 0) goto L337;
        int r28 = r24;
        int r33 = r27;
        Task r29 = r17;
        AnimationHandler.ScheduleAnimationBuilder r30 = this.mAnimationHandler.prepareAnimation(r28, r36, this.mNavigationMonitor, r29, r111, r31, r20, r110);     // Catch: Throwable -> L333
        if (r30 == null) goto L318;
        ?? r32 = 1;
    L405:
        this.mBackAnimationInProgress = r32;     // Catch: Throwable -> L326
        if (this.mBackAnimationInProgress == true) goto L322;
    L338:
        r0.setPrepareRemoteAnimation(r33);     // Catch: Throwable -> L326
        if (r110 == null) goto L341;
        final int r34 = r28;
        r0.setOnBackNavigationDone(new RemoteCallback(new BackNavigationController$$ExternalSyntheticLambda11(this, r34)));     // Catch: Throwable -> L326
    L342:
        this.mLastBackType = r28;     // Catch: Throwable -> L326
        BackNavigationInfo r37 = r0.build();     // Catch: Throwable -> L326
        monitor-exit(r14);     // Catch: Throwable -> L326
        WindowManagerService.resetPriorityAfterLockedSection();
        return r37;
    L341:
        this.mNavigationMonitor.stopMonitorForRemote();     // Catch: Throwable -> L326
        goto L342
    L322:
        if (r110.mTransitionController.inTransition() == true) goto L324;
        scheduleAnimation(r30);     // Catch: Throwable -> L326
        goto L338
    L324:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[3] == false) goto L328;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, 4900967164780429209L, r26, null);     // Catch: Throwable -> L326
    L328:
        this.mPendingAnimationBuilder = r30;     // Catch: Throwable -> L326
        int r38 = r20.size() - 1;     // Catch: Throwable -> L326
    L329:
        if (r38 < 0) goto L338;
        r20.get(r38).setDeferHidingClient();     // Catch: Throwable -> L326
        r38 = r38 - 1;     // Catch: Throwable -> L326
    L326:
        th = th;
        goto L380
    L318:
        r32 = r26;
    L333:
        th = th;
    L335:
        th = th;
        goto L380
    L337:
        r28 = r24;
        r33 = r27;
        r29 = r17;
    L293:
        th = th;
    L309:
        r27 = r26;
        goto L311
    L301:
        if (r24 == 3) goto L305;
        if (r24 == 2) goto L305;
        if (r24 != 0) goto L309;
    L430:
    L295:
        th = th;
        goto L380
    L279:
        if (r20.size() > 0) goto L413;
        String r39 = null;
    L285:
        String r40 = String.valueOf(r39);     // Catch: Throwable -> L295
        if (r25 == null) goto L289;
        String r41 = r25.getName();     // Catch: Throwable -> L282
    L290:
        r31 = r7;
        r111 = r25;
        Object[] r42 = {r40, String.valueOf(r41), String.valueOf(r110), String.valueOf(BackNavigationInfo.typeToString(r24))};     // Catch: Throwable -> L293
        r26 = 0;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, 8456834061534378653L, 0, r42);     // Catch: Throwable -> L293
    L282:
        th = th;
        goto L380
    L289:
        r41 = null;
        goto L290
    L413:
        r39 = TextUtils.join(";", r20.stream().map(new BackNavigationController$$ExternalSyntheticLambda10()).toArray());     // Catch: Throwable -> L282
    L346:
        th = th;
        goto L380
    L175:
        if (r1.mAttrs.type == 1) goto L178;
        r24 = 0;
        r110 = r1;
        r25 = r3;
        goto L391
    L178:
        if (hasTranslucentActivity(r7, r20) == false) goto L181;
        r24 = 4;
        r25 = r3;
        r110 = r22;
        goto L391
    L181:
        if (allActivitiesHaveProcesses(r20) == true) goto L183;
        r24 = 4;
        r25 = r3;
        r110 = r22;
        goto L391
    L183:
        if (r20.size() <= 0) goto L399;
        if (r19 != 0) goto L399;
        if (r23 == true) goto L188;
    L434:
    L216:
        th = th;
        goto L380
    L192:
        if (isAllActivitiesCreated(r20) == false) goto L227;
        WindowContainer r43 = r7.getParent();     // Catch: Throwable -> L216
        if (r43 != null) goto L196;
    L202:
        boolean r44 = false;
    L204:
        if (r44 == false) goto L220;
        if (isCustomizeExitAnimation(r1) == false) goto L209;
        r0.setWindowAnimations(r1.mAttrs.packageName, r1.mAttrs.windowAnimations);     // Catch: Throwable -> L141
    L141:
        th = th;
    L209:
        ActivityRecord.CustomAppTransition r112 = r7.getCustomAnimation(false);     // Catch: Throwable -> L216
        if (r112 == null) goto L220;
        r0.setCustomAnimation(r7.packageName, r112.mEnterAnim, r112.mExitAnim, r112.mBackgroundColor);     // Catch: Throwable -> L214
    L220:
        r0.setLetterboxColor(r7.mAppCompatController.getLetterboxOverrides().getLetterboxBackgroundColor().toArgb());     // Catch: Throwable -> L214
        r24 = 2;
        r110 = r7;
        r25 = r20.get(0).getTask();     // Catch: Throwable -> L224
    L224:
        th = th;
        goto L380
    L196:
        if (r43.asTask() == null) goto L198;
    L201:
        r44 = true;
        goto L204
    L198:
        if (r43.asTaskFragment() == null) goto L202;
        if (r43.canCustomizeAppTransition() == false) goto L202;
    L227:
        r24 = 4;
        r25 = r3;
        r110 = r22;
        goto L391
    L188:
        if (isAllActivitiesCanShowWhenLocked(r20) == false) goto L227;
    L399:
        if (r17.mAtmService.getLockTaskController().isTaskLocked(r17) == false) goto L232;
    L275:
        r24 = 4;
        r25 = r3;
        r110 = r22;
        goto L391
    L232:
        if (r17.getWindowConfiguration().tasksAreFloating() == true) goto L275;
        Task r45 = r17.mRootWindowContainer.getTask(new BackNavigationController$$ExternalSyntheticLambda9(), r17, false, true);     // Catch: Throwable -> L214
        if (r45 != null) goto L432;
        ActivityRecord r46 = null;
    L241:
        if (r46 == null) goto L243;
        r20.add(r46);     // Catch: Throwable -> L238
        findAdjacentActivityIfExist(r46, r20);     // Catch: Throwable -> L238
    L243:
        if (r45 != null) goto L245;
    L274:
        r25 = r45;
        r24 = 4;
        r110 = r22;
        goto L391
    L245:
        if (r20.isEmpty() == true) goto L274;
        if (r23 == false) goto L251;
        if (isAllActivitiesCanShowWhenLocked(r20) == false) goto L274;
    L251:
        if (r45.isActivityTypeHome() == true) goto L383;
        Task r47 = r45.getParent().asTask();     // Catch: Throwable -> L238
        Task r48 = r17.getParent().asTask();     // Catch: Throwable -> L238
        if (r45.inMultiWindowMode() == false) goto L270;
        if (r47 == r48) goto L270;
    L272:
        r25 = r45;
        r24 = 4;
        r110 = r22;
    L270:
        if (hasTranslucentActivity(r7, r20) == true) goto L272;
        r25 = r45;
        r24 = 3;
        r110 = r45;
    L238:
        th = th;
        goto L380
    L383:
        Task r49 = r45.getRootTask();     // Catch: Throwable -> L265
        r24 = 1;
        ActivityRecord r50 = r49.getTopNonFinishingActivity();     // Catch: Throwable -> L260
        if (r50 != null) goto L258;
    L262:
        boolean r113 = false;
    L263:
        this.mShowWallpaper = r113;     // Catch: Throwable -> L260
        r110 = r17;
        r25 = r49;
        goto L391
    L258:
        if (r50.hasWallpaper() == false) goto L262;
        r113 = true;
    L260:
        th = th;
    L265:
        th = th;
        goto L380
    L432:
        r46 = r45.getTopNonFinishingActivity();     // Catch: Throwable -> L238
    L348:
        th = th;
    L214:
        th = th;
    L401:
        r0.setType(4);     // Catch: Throwable -> L357
        r0.setOnBackNavigationDone(new RemoteCallback(new BackNavigationController$$ExternalSyntheticLambda8(this)));     // Catch: Throwable -> L357
        this.mLastBackType = 4;     // Catch: Throwable -> L357
        BackNavigationInfo r51 = r0.build();     // Catch: Throwable -> L357
        monitor-exit(r14);     // Catch: Throwable -> L357
        WindowManagerService.resetPriorityAfterLockedSection();
        return r51;
    L357:
        th = th;
    L350:
        th = th;
        goto L380
    L151:
        r18 = null;
    L156:
        r19 = r15;
        goto L415
    L421:
        r22 = null;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, 4039315468791789889L, 0, new Object[]{String.valueOf(r17), String.valueOf(r7), String.valueOf(r3), String.valueOf(r1)});     // Catch: Throwable -> L141
    L143:
        th = th;
    L135:
        r9 = false;
        goto L136
    L128:
        r8 = false;
    L123:
        r13 = 0;
    L359:
        th = th;
        goto L380
    L109:
        r4 = r10;
    L361:
        th = th;
    L89:
        th = th;
    L363:
        th = th;
        goto L380
    L64:
        if (r2.mTransitionController.getExt().shouldInterceptBackForRecents(r2) == false) goto L68;
        monitor-exit(r14);     // Catch: Throwable -> L52
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L365:
        th = th;
    L52:
        th = th;
        goto L380
    L44:
        r1 = this.mWindowManagerService.getMostRecentUsedEmbeddedWindowForBack(r1);     // Catch: Throwable -> L23
    L367:
        th = th;
        goto L380
    L389:
        boolean r52 = ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[3];     // Catch: Throwable -> L25
        if (r52 == false) goto L27;
        WmProtoLogGroups r53 = WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW;     // Catch: Throwable -> L25
        r10 = -1;
        r16 = null;
        ProtoLogImpl_798997914.w(r53, -699215053676660941L, 0, null);     // Catch: Throwable -> L23
        ?? r54 = r53;
    L28:
        r5 = r12.mAtmService.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L23
        if (r5 == null) goto L32;
        WindowState r55 = r5.getWindow(new BackNavigationController$$ExternalSyntheticLambda7());     // Catch: Throwable -> L23
    L33:
        r1 = r55;
        goto L407
    L32:
        r55 = null;
    L23:
        th = th;
        goto L380
    L27:
        r10 = -1;
        r16 = null;
        r54 = r52;
    L25:
        th = th;
        goto L380
    L403:
        Slog.w(TAG, "Previous animation hasn't finish, status: " + this.mAnimationHandler);     // Catch: Throwable -> L13
        monitor-exit(r14);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L13:
        th = th;
        goto L380
    }

    private /* synthetic */ void lambda$startBackNavigation$1(Bundle result) {
        onBackNavigationDone(result, 4);
    }

    private static /* synthetic */ boolean lambda$startBackNavigation$2(Task t) {
        if (t.showToCurrentUser() == true) goto L5;
    L12:
        return false;
    L5:
        if (t.mChildren.isEmpty() == true) goto L12;
        ActivityRecord ar = t.getTopNonFinishingActivity();
        if (ar != null) goto L9;
        return false;
    L9:
        if (ar.showToCurrentUser() == false) goto L14;
        return true;
    L14:
        return false;
    }

    private static /* synthetic */ ComponentName lambda$startBackNavigation$3(ActivityRecord r) {
        return r.mActivityComponent;
    }

    private /* synthetic */ void lambda$startBackNavigation$4(int finalBackType, Bundle result) {
        onBackNavigationDone(result, finalBackType);
    }

    static boolean getAnimatablePrevActivities(Task currentTask, ActivityRecord currentActivity, ArrayList<ActivityRecord> outPrevActivities) {
        if (currentActivity.mAtmService.mTaskOrganizerController.shouldInterceptBackPressedOnRootTask(currentTask.getRootTask()) == false) goto L5;
        return false;
    L5:
        ActivityRecord root = currentTask.getRootActivity(false, true);
        if (root != null) goto L8;
    L10:
        ActivityRecord prevActivity = currentTask.getActivity(new BackNavigationController$$ExternalSyntheticLambda0(), currentActivity, false, true);
        TaskFragment currTF = currentActivity.getTaskFragment();
        if (currTF != null) goto L13;
    L43:
        if (prevActivity != null) goto L45;
        return true;
    L45:
        addPreviousAdjacentActivityIfExist(prevActivity, outPrevActivities);
        outPrevActivities.add(prevActivity);
        return true;
    L13:
        if (currTF.asTask() != null) goto L43;
        if (prevActivity == null) goto L20;
        if (currTF.hasChild(prevActivity) == false) goto L20;
        outPrevActivities.add(prevActivity);
        return true;
    L20:
        if (currTF.hasAdjacentTaskFragment() == true) goto L29;
        TaskFragment nextTF = findNextTaskFragment(currentTask, currTF);
        if (isSecondCompanionToFirst(currTF, nextTF) == false) goto L43;
        ActivityRecord bottomActivityInCompanion = nextTF.getActivity(new BackNavigationController$$ExternalSyntheticLambda1(), false);
        ActivityRecord underPrevious = currentTask.getActivity(new BackNavigationController$$ExternalSyntheticLambda2(), bottomActivityInCompanion, false, true);
        if (underPrevious == null) goto L26;
        outPrevActivities.add(underPrevious);
        addPreviousAdjacentActivityIfExist(underPrevious, outPrevActivities);
    L26:
        return true;
    L29:
        if (currTF.getAdjacentTaskFragments().size() > 2) goto L42;
        final TaskFragment[] tmpAdjacent = new TaskFragment[1];
        currTF.forOtherAdjacentTaskFragments(new BackNavigationController$$ExternalSyntheticLambda3(tmpAdjacent));
        TaskFragment adjacentTF = tmpAdjacent[0];
        if (isSecondCompanionToFirst(currTF, adjacentTF) == false) goto L40;
        WindowContainer commonParent = currTF.getParent();
        if (commonParent.mChildren.indexOf(currTF) >= commonParent.mChildren.indexOf(adjacentTF)) goto L35;
        TaskFragment lowerTF = currTF;
    L36:
        ActivityRecord lowerActivity = lowerTF.getTopNonFinishingActivity();
        if (currentTask.getActivity(new BackNavigationController$$ExternalSyntheticLambda4(), lowerActivity, false, true) == null) goto L39;
        return false;
    L39:
        return true;
    L35:
        lowerTF = adjacentTF;
        goto L36
    L40:
        return false;
    L42:
        throw new IllegalStateException("Not yet support 3+ adjacent for non-Task TFs");
    L8:
        if (ActivityClientController.shouldMoveTaskToBack(currentActivity, root) == false) goto L10;
        return true;
    }

    private static /* synthetic */ boolean lambda$getAnimatablePrevActivities$5(ActivityRecord below) {
        return !below.finishing;
    }

    private static /* synthetic */ boolean lambda$getAnimatablePrevActivities$6(ActivityRecord below) {
        return !below.finishing;
    }

    private static /* synthetic */ boolean lambda$getAnimatablePrevActivities$7(ActivityRecord below) {
        return !below.finishing;
    }

    private static /* synthetic */ boolean lambda$getAnimatablePrevActivities$8(TaskFragment[] tmpAdjacent, TaskFragment tf) {
        tmpAdjacent[0] = tf;
        return true;
    }

    private static /* synthetic */ boolean lambda$getAnimatablePrevActivities$9(ActivityRecord below) {
        return !below.finishing;
    }

    private static TaskFragment findNextTaskFragment(Task currentTask, TaskFragment topTF) {
        int topIndex = currentTask.mChildren.indexOf(topTF);
        if (topIndex > 0) goto L6;
        return null;
    L6:
        WindowContainer next = (WindowContainer) currentTask.mChildren.get(topIndex - 1);
        return next.asTaskFragment();
    }

    private static boolean isSecondCompanionToFirst(TaskFragment first, TaskFragment second) {
        if (second != null) goto L4;
    L6:
        return false;
    L4:
        if (second.getCompanionTaskFragment() != first) goto L6;
        return true;
    }

    private static void addPreviousAdjacentActivityIfExist(ActivityRecord prevActivity, final ArrayList<ActivityRecord> outPrevActivities) {
        TaskFragment prevTF = prevActivity.getTaskFragment();
        if (prevTF != null) goto L5;
        return;
    L5:
        if (prevTF.asTask() == null) goto L8;
        return;
    L8:
        if (prevTF.hasAdjacentTaskFragment() == true) goto L10;
        return;
    L10:
        prevTF.forOtherAdjacentTaskFragments(new BackNavigationController$$ExternalSyntheticLambda13(outPrevActivities));
    }

    private static /* synthetic */ void lambda$addPreviousAdjacentActivityIfExist$10(ArrayList outPrevActivities, TaskFragment prevTFAdjacent) {
        ActivityRecord prevActivityAdjacent = prevTFAdjacent.getTopNonFinishingActivity();
        if (prevActivityAdjacent == null) goto L6;
        outPrevActivities.add(prevActivityAdjacent);
        return;
    }

    private static void findAdjacentActivityIfExist(ActivityRecord mainActivity, final ArrayList<ActivityRecord> outList) {
        TaskFragment mainTF = mainActivity.getTaskFragment();
        if (mainTF != null) goto L5;
        return;
    L5:
        if (mainTF.hasAdjacentTaskFragment() == false) goto L10;
        mainTF.forOtherAdjacentTaskFragments(new BackNavigationController$$ExternalSyntheticLambda5(outList));
        return;
    }

    private static /* synthetic */ void lambda$findAdjacentActivityIfExist$11(ArrayList outList, TaskFragment adjacentTF) {
        ActivityRecord topActivity = adjacentTF.getTopNonFinishingActivity();
        if (topActivity == null) goto L6;
        outList.add(topActivity);
        return;
    }

    private static boolean hasTranslucentActivity(ActivityRecord currentActivity, ArrayList<ActivityRecord> prevActivities) {
        if (currentActivity.occludesParent() == true) goto L5;
    L18:
        return true;
    L5:
        if (currentActivity.showWallpaper() == true) goto L18;
        int i = prevActivities.size() - 1;
    L8:
        if (i < 0) goto L16;
        ActivityRecord test = prevActivities.get(i);
        if (test.occludesParent() == false) goto L15;
        if (test.hasWallpaper() == true) goto L15;
        i = i - 1;
    L15:
        return true;
    L16:
        return false;
    }

    private static boolean allActivitiesHaveProcesses(ArrayList<ActivityRecord> prevActivities) {
        int i = prevActivities.size() - 1;
    L3:
        if (i < 0) goto L10;
        ActivityRecord test = prevActivities.get(i);
        if (test.hasProcess() == false) goto L6;
        i = i - 1;
        goto L3
    L6:
        return false;
    L10:
        return true;
    }

    private static boolean isAllActivitiesCanShowWhenLocked(ArrayList<ActivityRecord> prevActivities) {
        int i = prevActivities.size() - 1;
    L3:
        if (i < 0) goto L10;
        if (prevActivities.get(i).canShowWhenLocked() == false) goto L6;
        i = i - 1;
        goto L3
    L6:
        return false;
    L10:
        return !prevActivities.isEmpty();
    }

    private static boolean isAllActivitiesCreated(ArrayList<ActivityRecord> prevActivities) {
        int i = prevActivities.size() - 1;
    L3:
        if (i < 0) goto L10;
        ActivityRecord check = prevActivities.get(i);
        if (check.isState(ActivityRecord.State.INITIALIZING) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return false;
    L10:
        return !prevActivities.isEmpty();
    }

    boolean isMonitoringFinishTransition() {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mNavigationMonitor.isMonitorForRemote() == true) goto L8;
        return false;
    }

    boolean isMonitoringPrepareTransition(Transition transition) {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L5;
    L7:
        return false;
    L5:
        if (AnimationHandler.BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler)) != transition) goto L7;
        return true;
    }

    private void scheduleAnimation(AnimationHandler.ScheduleAnimationBuilder builder) {
        this.mPendingAnimation = builder.build();
        if (AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler) != null) goto L5;
    L7:
        this.mWindowManagerService.mWindowPlacerLocked.requestTraversal();
        if (this.mShowWallpaper == false) goto L12;
        this.mWindowManagerService.getDefaultDisplayContentLocked().mWallpaperController.adjustWallpaperWindows();
        return;
    L12:
        return;
    L5:
        if (AnimationHandler.BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler)) == null) goto L7;
        startAnimation();
    }

    boolean hasFixedRotationAnimation(DisplayContent displayContent) {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L5;
        return false;
    L5:
        ActivityRecord openActivity = AnimationHandler.m9772$$Nest$fgetmOpenActivities(this.mAnimationHandler)[0];
        if (displayContent == openActivity.mDisplayContent) goto L8;
        return false;
    L8:
        if (displayContent.isFixedRotationLaunchingApp(openActivity) == false) goto L13;
        return true;
    L13:
        return false;
    }

    boolean isKeyguardOccluded(WindowState focusWindow) {
        KeyguardController kc = this.mWindowManagerService.mAtmService.mKeyguardController;
        int displayId = focusWindow.getDisplayId();
        return kc.isKeyguardOccluded(displayId);
    }

    private static boolean isCustomizeExitAnimation(WindowState window) {
        if (Objects.equals(window.mAttrs.packageName, PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L6;
        return false;
    L6:
        if (window.mAttrs.windowAnimations == 0) goto L16;
        TransitionAnimation transitionAnimation = window.mDisplayContent.mTransitionAnimation;
        int appResId = transitionAnimation.getAnimationResId(window.mAttrs, 7, 0);
        if (ResourceId.isValid(appResId) == false) goto L16;
        if (sDefaultAnimationResId != 0) goto L13;
        sDefaultAnimationResId = transitionAnimation.getDefaultAnimationResId(7, 0);
    L13:
        if (sDefaultAnimationResId == appResId) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    }

    void removePredictiveSurfaceIfNeeded(ActivityRecord openActivity) {
        this.mAnimationHandler.markWindowHasDrawn(openActivity);
    }

    boolean isStartingSurfaceShown(ActivityRecord openActivity) {
        return this.mAnimationHandler.isStartingSurfaceDrawn(openActivity);
    }

    void onAppVisibilityChanged(ActivityRecord ar, boolean visible) {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L6;
        return;
    L6:
        if (AnimationHandler.BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler)) == null) goto L8;
        boolean openingTransition = true;
    L9:
        if (openingTransition == false) goto L44;
        if (visible == false) goto L12;
        return;
    L12:
        if (this.mAnimationHandler.isTarget(ar, false) == true) goto L14;
        return;
    L14:
        if (ar.mTransitionController.isCollecting(ar) == false) goto L47;
        TransitionController controller = ar.mTransitionController;
        Transition transition = controller.getCollectingTransition();
        int switchType = AnimationHandler.BackWindowAnimationAdaptor.m9781$$Nest$fgetmSwitchType(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mAdaptors[0]);
        boolean collectTask = false;
        ActivityRecord changedActivity = null;
        int i = AnimationHandler.m9772$$Nest$fgetmOpenActivities(this.mAnimationHandler).length - 1;
    L16:
        if (i < 0) goto L21;
        ActivityRecord next = AnimationHandler.m9772$$Nest$fgetmOpenActivities(this.mAnimationHandler)[i];
        if (next.mLaunchTaskBehind == false) goto L20;
        controller.collect(next);
        collectTask = true;
        restoreLaunchBehind(next, true, false);
        changedActivity = next;
    L20:
        i = i - 1;
        goto L16
    L21:
        int i2 = AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mAdaptors.length - 1;
    L22:
        if (i2 < 0) goto L24;
        collectAnimatableTarget(transition, switchType, AnimationHandler.BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mAdaptors[i2]), false);
        i2 = i2 - 1;
        goto L22
    L24:
        collectAnimatableTarget(transition, switchType, AnimationHandler.BackWindowAnimationAdaptor.m9782$$Nest$fgetmTarget(AnimationHandler.m9770$$Nest$fgetmCloseAdaptor(this.mAnimationHandler)), true);
        if (collectTask == false) goto L35;
        if (switchType != 1) goto L35;
        Task topTask = AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mAdaptors[0].getTopTask();
        if (topTask == null) goto L35;
        WindowContainer parent = AnimationHandler.m9772$$Nest$fgetmOpenActivities(this.mAnimationHandler)[0].getParent();
    L30:
        if (parent == topTask) goto L34;
        if (parent.isDescendantOf(topTask) == false) goto L34;
        controller.collect(parent);
        parent = parent.getParent();
    L34:
        controller.collect(topTask);
    L35:
        if (changedActivity == null) goto L48;
        changedActivity.getDisplayContent().ensureActivitiesVisible(null, true);
        return;
    L48:
        return;
    L47:
        return;
    L44:
        return;
    L8:
        openingTransition = false;
        goto L9
    }

    private static void collectAnimatableTarget(Transition transition, int switchType, WindowContainer animatingTarget, boolean isTop) {
        if (switchType != 2) goto L9;
        if (animatingTarget.asActivityRecord() == null) goto L7;
    L12:
        transition.collect(animatingTarget);
        transition.setBackGestureAnimation(animatingTarget, isTop);
        return;
    L7:
        if (animatingTarget.asTaskFragment() != null) goto L12;
    L9:
        if (switchType == 1) goto L11;
        return;
    L11:
        if (animatingTarget.asTask() != null) goto L12;
    }

    void onTransactionReady(Transition transition, ArrayList<Transition.ChangeInfo> targets, SurfaceControl.Transaction startTransaction, SurfaceControl.Transaction finishTransaction) {
        if (isMonitoringPrepareTransition(transition) == false) goto L7;
        this.mAnimationHandler.markStartingSurfaceMatch(startTransaction);
        return;
    L7:
        if (targets.isEmpty() == false) goto L10;
        return;
    L10:
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L13;
        return;
    L13:
        if (isMonitoringFinishTransition() == true) goto L16;
        return;
    L16:
        if (this.mAnimationHandler.hasTargetDetached() == false) goto L19;
        NavigationMonitor.m9790$$Nest$mcancelBackNavigating(this.mNavigationMonitor, "targetDetached");
        return;
    L19:
        int i = targets.size() - 1;
    L20:
        if (i < 0) goto L36;
        WindowContainer wc = targets.get(i).mContainer;
        if (wc.asActivityRecord() != null) goto L29;
        if (wc.asTask() != null) goto L29;
        if (wc.asTaskFragment() != null) goto L29;
    L35:
        i = i - 1;
    L29:
        if (targets.get(i).getTransitMode(wc) == 6) goto L35;
        if (wc.isVisibleRequested() == false) goto L34;
        this.mTmpOpenApps.add(wc);
        goto L35
    L34:
        this.mTmpCloseApps.add(wc);
        goto L35
    L36:
        boolean matchAnimationTargets = this.mAnimationHandler.containsBackAnimationTargets(this.mTmpOpenApps, this.mTmpCloseApps);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L40;
        String protoLogParam0 = String.valueOf(this.mTmpOpenApps);
        String protoLogParam1 = String.valueOf(this.mTmpCloseApps);
        String protoLogParam2 = String.valueOf(this.mAnimationHandler);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, -6431452312492819825L, 192, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2, Boolean.valueOf(matchAnimationTargets)});
    L40:
        if (this.mAnimationHandler.mPrepareCloseTransition == null) goto L43;
        Slog.e(TAG, "Gesture animation is applied on another transition?");
        return;
    L43:
        this.mAnimationHandler.mPrepareCloseTransition = transition;
        this.mAnimationHandler.markStartingSurfaceMatch(startTransaction);
        if (AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mCloseTransaction == null) goto L46;
        finishTransaction.merge(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mCloseTransaction);
        AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mCloseTransaction = null;
    L46:
        this.mTmpOpenApps.clear();
        this.mTmpCloseApps.clear();
    }

    boolean isMonitorTransitionTarget(WindowContainer wc) {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L6;
        return false;
    L6:
        if (AnimationHandler.m9775$$Nest$fgetmSwitchType(this.mAnimationHandler) != 1) goto L10;
        if (wc.asActivityRecord() == null) goto L10;
    L13:
        return false;
    L10:
        if (AnimationHandler.m9775$$Nest$fgetmSwitchType(this.mAnimationHandler) != 2) goto L15;
        if (wc.asTask() != null) goto L13;
    L15:
        if (this.mAnimationHandler.isTarget(wc, true) == true) goto L19;
        if (this.mAnimationHandler.isTarget(wc, false) == true) goto L19;
        return false;
    L19:
        return true;
    }

    boolean shouldPauseTouch(WindowContainer wc) {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mAnimationHandler.mPrepareCloseTransition != null) goto L9;
        if (this.mAnimationHandler.isTarget(wc, wc.isVisibleRequested()) == false) goto L9;
        return true;
    }

    void clearBackAnimations(boolean cancel) {
        this.mAnimationHandler.clearBackAnimateTarget(cancel);
        this.mNavigationMonitor.stopMonitorTransition();
    }

    void onTransitionFinish(Transition finishedTransition) {
        if (isMonitoringPrepareTransition(finishedTransition) == false) goto L9;
        if (this.mAnimationHandler.mPrepareCloseTransition != null) goto L50;
        clearBackAnimations(true);
        return;
    L50:
        return;
    L9:
        if (finishedTransition != this.mAnimationHandler.mPrepareCloseTransition) goto L12;
        clearBackAnimations(false);
    L12:
        if (this.mBackAnimationInProgress == true) goto L14;
        return;
    L14:
        if (this.mPendingAnimationBuilder != null) goto L17;
        return;
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L19;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, -4051770154814262074L, 0, null);
    L19:
        boolean hasTarget = false;
        int i = 0;
    L21:
        if (i >= finishedTransition.mParticipants.size()) goto L34;
        WindowContainer wc = finishedTransition.mParticipants.valueAt(i);
        if (wc.asActivityRecord() != null) goto L30;
        if (wc.asTask() != null) goto L30;
        if (wc.asTaskFragment() != null) goto L30;
    L32:
        i = i + 1;
    L30:
        if (this.mPendingAnimationBuilder.containTarget(wc) == false) goto L32;
        hasTarget = true;
    L34:
        if (hasTarget == true) goto L38;
        Slog.w(TAG, "Finished transition didn't include the targets open: " + Arrays.toString(this.mPendingAnimationBuilder.mOpenTargets) + " close: " + this.mPendingAnimationBuilder.mCloseTarget);
        cancelPendingAnimation();
        return;
    L38:
        if (this.mWindowManagerService.mRoot.mTransitionController.inTransition() == false) goto L42;
        Slog.v(TAG, "Skip predictive back transition, another transition is playing");
        cancelPendingAnimation();
        return;
    L42:
        if (this.mPendingAnimationBuilder == null) goto L51;
        scheduleAnimation(this.mPendingAnimationBuilder);
        this.mPendingAnimationBuilder = null;
        return;
    }

    private void cancelPendingAnimation() {
        if (this.mPendingAnimationBuilder != null) goto L11;
        return;
    L11:
        this.mPendingAnimationBuilder.mBackAnimationAdapter.getRunner().onAnimationCancelled();     // Catch: RemoteException -> L7
    L9:
        this.mPendingAnimationBuilder = null;
        this.mNavigationMonitor.stopMonitorTransition();
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Remote animation gone", e);
        goto L9
    }

    private static boolean validateAnimationTargets(RemoteAnimationTarget[] apps) {
        if (apps != null) goto L5;
    L15:
        return false;
    L5:
        if (apps.length == 0) goto L15;
        int i = apps.length - 1;
    L8:
        if (i < 0) goto L14;
        if (apps[i].leash.isValid() == false) goto L11;
        i = i - 1;
        goto L8
    L11:
        return false;
    L14:
        return true;
    }

    private static ActivityRecord[] getTopOpenActivities(WindowContainer[] openWindows) {
        ActivityRecord[] openActivities = null;
        WindowContainer mainTarget = openWindows[0];
        if (mainTarget.asTask() == null) goto L13;
        ArrayList<ActivityRecord> inTaskActivities = new ArrayList();
        Task task = mainTarget.asTask();
        ActivityRecord tmpPreActivity = task.getTopNonFinishingActivity();
        if (tmpPreActivity == null) goto L7;
        inTaskActivities.add(tmpPreActivity);
        findAdjacentActivityIfExist(tmpPreActivity, inTaskActivities);
    L7:
        openActivities = new ActivityRecord[inTaskActivities.size()];
        int i = inTaskActivities.size() - 1;
    L8:
        if (i < 0) goto L17;
        openActivities[i] = inTaskActivities.get(i);
        i = i - 1;
    L17:
        return openActivities;
    L13:
        if (mainTarget.asActivityRecord() == null) goto L17;
        int size = openWindows.length;
        openActivities = new ActivityRecord[size];
        int i2 = size - 1;
    L15:
        if (i2 < 0) goto L17;
        openActivities[i2] = openWindows[i2].asActivityRecord();
        i2 = i2 - 1;
        goto L15
    }

    boolean restoreBackNavigation() {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L5;
        return false;
    L5:
        ActivityRecord[] penActivities = AnimationHandler.m9772$$Nest$fgetmOpenActivities(this.mAnimationHandler);
        boolean changed = false;
        if (penActivities == null) goto L13;
        int i = penActivities.length - 1;
    L8:
        if (i < 0) goto L13;
        ActivityRecord resetActivity = penActivities[i];
        if (resetActivity.mLaunchTaskBehind == false) goto L12;
        resetActivity.mTransitionController.collect(resetActivity);
        restoreLaunchBehind(resetActivity, true, false);
        changed = true;
    L12:
        i = i - 1;
    L13:
        return changed;
    }

    boolean restoreBackNavigationSetTransitionReady(Transition transition) {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L5;
        return false;
    L5:
        ActivityRecord[] penActivities = AnimationHandler.m9772$$Nest$fgetmOpenActivities(this.mAnimationHandler);
        if (penActivities == null) goto L14;
        int i = penActivities.length - 1;
    L8:
        if (i < 0) goto L14;
        ActivityRecord resetActivity = penActivities[i];
        if (transition.isInTransition(resetActivity) == true) goto L11;
        i = i - 1;
        goto L8
    L11:
        transition.setReady(resetActivity.getDisplayContent(), true);
        return true;
    L14:
        return false;
    }

    private static Transition setLaunchBehind(ActivityRecord[] activities) {
        ArrayList<ActivityRecord> affects = new ArrayList();
        int i = activities.length - 1;
    L3:
        if (i < 0) goto L11;
        ActivityRecord activity = activities[i];
        if (activity.mLaunchTaskBehind == true) goto L10;
        if (activity.isVisibleRequested() == true) goto L10;
        affects.add(activity);
    L10:
        i = i - 1;
        goto L3
    L11:
        Transition prepareOpen = null;
        if (affects.isEmpty() == false) goto L14;
        return null;
    L14:
        TransitionController tc = activities[0].mTransitionController;
        int i2 = affects.size() - 1;
    L15:
        if (i2 < 0) goto L24;
        ActivityRecord activity2 = affects.get(i2);
        activity2.mTransitionController.mSnapshotController.mActivitySnapshotController.addOnBackPressedActivity(activity2);
        activity2.mLaunchTaskBehind = true;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L19;
        String protoLogParam0 = String.valueOf(activity2);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, 2077221835543623088L, 0, new Object[]{protoLogParam0});
    L19:
        activity2.mTaskSupervisor.mStoppingActivities.remove(activity2);
        if (activity2.shouldBeVisible() == false) goto L22;
        activity2.ensureActivityConfiguration(true);
        activity2.makeVisibleIfNeeded(null, true);
    L22:
        i2 = i2 - 1;
        goto L15
    L24:
        if (0 != 0) goto L26;
    L30:
        return null;
    L26:
        if (prepareOpen.hasChanges() == false) goto L29;
        tc.requestStartTransition(null, null, null, null);
        prepareOpen.setReady(affects.get(0), true);
        return null;
    L29:
        prepareOpen.abort();
        goto L30
    }

    private static void restoreLaunchBehind(ActivityRecord activity, boolean cancel, boolean finishTransition) {
        if (activity.isAttached() == true) goto L5;
        return;
    L5:
        activity.mLaunchTaskBehind = false;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L8;
        String protoLogParam0 = String.valueOf(activity);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, -4442170697458371588L, 0, new Object[]{protoLogParam0});
    L8:
        if (cancel == false) goto L15;
        if (finishTransition == true) goto L11;
    L13:
        activity.mTransitionController.mSnapshotController.mActivitySnapshotController.clearOnBackPressedActivities();
        return;
    L11:
        if (activity.shouldBeVisible() == true) goto L13;
        activity.commitVisibility(false, false, true);
        goto L13
    }

    void checkAnimationReady(WallpaperController wallpaperController) {
        if (this.mBackAnimationInProgress == true) goto L6;
        return;
    L6:
        if (this.mShowWallpaper == true) goto L8;
    L13:
        boolean wallpaperReady = true;
    L15:
        if (wallpaperReady == true) goto L17;
        return;
    L17:
        if (this.mPendingAnimation == null) goto L21;
        this.mWindowManagerService.mAnimator.addAfterPrepareSurfacesRunnable(new BackNavigationController$$ExternalSyntheticLambda12(this));
        return;
    L21:
        return;
    L8:
        if (wallpaperController.getWallpaperTarget() != null) goto L10;
    L12:
        wallpaperReady = false;
        goto L15
    L10:
        if (wallpaperController.wallpaperTransitionReady() == false) goto L12;
        goto L12
    }

    private boolean canCancelAnimations() {
        if (AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler) != null) goto L5;
    L8:
        return true;
    L5:
        if (AnimationHandler.BackWindowAnimationAdaptorWrapper.m9783$$Nest$fgetmPreparedOpenTransition(AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler)) == null) goto L8;
        return false;
    }

    void startAnimation() {
        if (this.mBackAnimationInProgress == true) goto L12;
        if (this.mPendingAnimation != null) goto L7;
        return;
    L7:
        if (canCancelAnimations() == false) goto L9;
        clearBackAnimations(true);
    L9:
        this.mPendingAnimation = null;
        return;
    L12:
        if (this.mPendingAnimation == null) goto L16;
        this.mPendingAnimation.run();
        this.mPendingAnimation = null;
        return;
    }

    private void onBackNavigationDone(Bundle result, int backType) {
        if (result != null) goto L5;
        return;
    L5:
        if (result.containsKey("NavigationFinished") == false) goto L18;
        boolean triggerBack = result.getBoolean("NavigationFinished");
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L9;
        String protoLogParam0 = String.valueOf(backType);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, 267946503010201613L, 12, new Object[]{protoLogParam0, Boolean.valueOf(triggerBack)});
    L9:
        WindowManagerGlobalLock r1 = this.mWindowManagerService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mNavigationMonitor.stopMonitorForRemote();     // Catch: Throwable -> L14
        this.mBackAnimationInProgress = false;     // Catch: Throwable -> L14
        this.mShowWallpaper = false;     // Catch: Throwable -> L14
        this.mPendingAnimation = null;     // Catch: Throwable -> L14
        this.mPendingAnimationBuilder = null;     // Catch: Throwable -> L14
        this.mWindowManagerService.mAtmService.getObricExt().onBackNavigationDone(this.mWindowManagerService);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    static TaskSnapshot getSnapshot(WindowContainer w, ActivityRecord[] visibleOpenActivities) {
        TaskSnapshot snapshot = null;
        if (w.asTask() == null) goto L5;
        Task task = w.asTask();
        snapshot = task.mRootWindowContainer.mWindowManager.mTaskSnapshotController.getSnapshot(task.mTaskId, false);
    L13:
        if (isSnapshotCompatible(snapshot, visibleOpenActivities) == true) goto L17;
        return null;
    L17:
        return snapshot;
    L5:
        ActivityRecord ar = w.asActivityRecord();
        if (ar == null) goto L8;
    L10:
        if (ar == null) goto L13;
        snapshot = ar.mWmService.mSnapshotController.mActivitySnapshotController.getSnapshot(visibleOpenActivities);
        goto L13
    L8:
        if (w.asTaskFragment() == null) goto L10;
        ar = w.asTaskFragment().getTopNonFinishingActivity();
        goto L10
    }

    static boolean isSnapshotCompatible(TaskSnapshot snapshot, ActivityRecord[] visibleOpenActivities) {
        if (snapshot != null) goto L5;
        return false;
    L5:
        boolean oneComponentMatch = false;
        int i = visibleOpenActivities.length - 1;
    L6:
        if (i < 0) goto L15;
        ActivityRecord ar = visibleOpenActivities[i];
        if (ar.isSnapshotOrientationCompatible(snapshot) == false) goto L9;
        int appNightMode = ar.getConfiguration().uiMode & 48;
        int snapshotNightMode = snapshot.getUiMode() & 48;
        if (appNightMode != snapshotNightMode) goto L12;
        oneComponentMatch = oneComponentMatch | ar.isSnapshotComponentCompatible(snapshot);
        i = i - 1;
        goto L6
    L12:
        return false;
    L9:
        return false;
    L15:
        return oneComponentMatch;
    }

    void setWindowManager(WindowManagerService wm) {
        this.mWindowManagerService = wm;
        this.mAnimationHandler = new AnimationHandler(wm);
    }

    boolean isWallpaperVisible(WindowState w) {
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == true) goto L5;
    L13:
        return false;
    L5:
        if (this.mShowWallpaper == false) goto L13;
        if (w.mAttrs.type != 1) goto L13;
        if (w.mActivityRecord == null) goto L13;
        if (this.mAnimationHandler.isTarget(w.mActivityRecord, true) == false) goto L13;
        return true;
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1133871366145L, this.mBackAnimationInProgress);
        proto.write(1120986464258L, this.mLastBackType);
        proto.write(1133871366147L, this.mShowWallpaper);
        boolean r5 = false;
        if (AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler) != null) goto L5;
    L7:
        proto.write(1138166333444L, "");
    L9:
        if (AnimationHandler.m9771$$Nest$fgetmComposed(this.mAnimationHandler) == false) goto L11;
    L12:
        r5 = true;
    L13:
        proto.write(1133871366149L, r5);
        proto.end(token);
        return;
    L11:
        if (AnimationHandler.m9776$$Nest$fgetmWaitTransition(this.mAnimationHandler) == false) goto L13;
    L5:
        if (AnimationHandler.m9773$$Nest$fgetmOpenAnimAdaptor(this.mAnimationHandler).mAdaptors.length <= 0) goto L7;
        AnimationHandler.m9772$$Nest$fgetmOpenActivities(this.mAnimationHandler)[0].writeNameToProto(proto, 1138166333444L);
        goto L9
    }
}
