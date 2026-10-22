package com.android.server.wm;

import android.app.ActivityManager;
import android.app.IApplicationThread;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.Slog;
import android.util.SparseArray;
import android.view.SurfaceControl;
import android.view.WindowManager;
import android.window.ScreenCapture;
import android.window.TaskFragmentAnimationParams;
import android.window.WindowContainerToken;
import android.window.WindowContainerTransaction;
import com.android.internal.graphics.ColorUtils;
import com.android.internal.policy.TransitionAnimation;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.SysOptBridge;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.job.JobPackageTracker;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.resmng.BoostHintType;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class Transition implements BLASTSyncEngine.TransactionReadyListener {
    static final int PARALLEL_TYPE_MUTUAL = 1;
    static final int PARALLEL_TYPE_NONE = 0;
    static final int PARALLEL_TYPE_RECENTS = 2;
    private static final int STATE_ABORT = 3;
    private static final int STATE_COLLECTING = 0;
    private static final int STATE_FINISHED = 4;
    private static final int STATE_PENDING = -1;
    private static final int STATE_PLAYING = 2;
    private static final int STATE_STARTED = 1;
    private static final String TAG = "Transition";
    private static final String TRACE_NAME_PLAY_TRANSITION = "playing";
    int mAnimationTrack;
    private boolean mCanPipOnFinish;
    ActionChain mChainHead;
    final ArrayMap<WindowContainer, ChangeInfo> mChanges;
    private SurfaceControl.Transaction mCleanupTransaction;
    private IRemoteCallback mClientAnimationFinishCallback;
    private IRemoteCallback mClientAnimationStartCallback;
    ArrayList<ActivityRecord> mConfigAtEndActivities;
    private IContainerFreezer mContainerFreezer;
    final TransitionController mController;
    private IExtTransition mExt;
    private SurfaceControl.Transaction mFinishTransaction;
    private int mFlags;
    private boolean mForcePlaying;
    private boolean mIsAnimationPerfLockAcquired;
    boolean mIsPlayerEnabled;
    boolean mIsSeamlessRotation;
    final TransitionController.Logger mLogger;
    private DisplayContent mOnTopDisplayAtReady;
    private DisplayContent mOnTopDisplayStart;
    private final ArrayList<Task> mOnTopTasksAtReady;
    private final ArrayList<Task> mOnTopTasksStart;
    private int mOverrideBackgroundColor;
    private android.window.TransitionInfo.AnimationOptions mOverrideOptions;
    int mParallelCollectType;
    final ArraySet<WindowContainer> mParticipants;
    private BoostFramework mPerf;
    private ActivityRecord mPipActivity;
    boolean mPriorVisibilityMightBeDirty;
    final ReadyTracker mReadyTracker;
    private final ReadyTrackerOld mReadyTrackerOld;
    private int mRecentsDisplayId;
    IApplicationThread mRemoteDelegate;
    private SurfaceControl.Transaction mStartTransaction;
    private int mState;
    long mStatusBarTransitionDelay;
    private final BLASTSyncEngine mSyncEngine;
    private int mSyncId;
    private final ArrayList<DisplayContent> mTargetDisplays;
    ArrayList<ChangeInfo> mTargets;
    private final Token mToken;
    ArrayList<Runnable> mTransactionCompletedListeners;
    private ArrayList<Task> mTransientHideTasks;
    private ArrayMap<ActivityRecord, Task> mTransientLaunches;
    private ArrayList<Runnable> mTransitionEndedListeners;
    final int mType;
    private final ArraySet<WindowToken> mVisibleAtTransitionEndTokens;

    static class ChangeInfo {
        private static final int FLAG_BACK_GESTURE_ANIMATION = 128;
        private static final int FLAG_BELOW_BACK_GESTURE_ANIMATION = 256;
        private static final int FLAG_CHANGE_CONFIG_AT_END = 64;
        private static final int FLAG_CHANGE_MOVED_TO_TOP = 32;
        private static final int FLAG_CHANGE_NO_ANIMATION = 8;
        private static final int FLAG_CHANGE_YES_ANIMATION = 16;
        private static final int FLAG_NONE = 0;
        private static final int FLAG_SEAMLESS_ROTATION = 1;
        private static final int FLAG_TRANSIENT_HIDE = 4;
        private static final int FLAG_TRANSIENT_LAUNCH = 2;
        final Rect mAbsoluteBounds;
        WindowContainer mCommonAncestor;
        final WindowContainer mContainer;
        int mDisplayId;
        WindowContainer mEndParent;
        boolean mExistenceChanged;
        int mFlags;
        int mKnownConfigChanges;
        int mReadyFlags;
        int mReadyMode;
        boolean mRestoringTransientHide;
        int mRotation;
        boolean mShowWallpaper;
        SurfaceControl mSnapshot;
        float mSnapshotLuma;
        final Point mStartOffset;
        WindowContainer mStartParent;
        float mStartScale;
        boolean mVisible;
        int mWindowingMode;

        @Retention(RetentionPolicy.SOURCE)
        @interface ChangeInfoFlag {
        }

        ChangeInfo(WindowContainer origState) {
            this.mExistenceChanged = false;
            this.mRestoringTransientHide = false;
            this.mAbsoluteBounds = new Rect();
            this.mRotation = -1;
            this.mDisplayId = -1;
            this.mFlags = 0;
            this.mStartScale = 1.0f;
            this.mStartOffset = new Point();
            this.mContainer = origState;
            this.mVisible = origState.isVisibleRequested();
            this.mWindowingMode = origState.getWindowingMode();
            this.mAbsoluteBounds.set(origState.getBounds());
            this.mShowWallpaper = origState.showWallpaper();
            this.mRotation = origState.getWindowConfiguration().getRotation();
            this.mStartParent = origState.getParent();
            this.mDisplayId = Transition.m10333$$Nest$smgetDisplayId(origState);
            if (Features.FEAT_QUICK_WIN == true) goto L5;
            return;
        L5:
            if (origState.asTask() == null) goto L9;
            this.mStartScale = origState.asTask().getExt().getScale();
            this.mStartOffset.set(origState.asTask().getExt().getOffset());
            return;
        }

        ChangeInfo(WindowContainer container, boolean visible, boolean existChange) {
            this(container);
            this.mVisible = visible;
            this.mExistenceChanged = existChange;
            this.mShowWallpaper = false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("ChangeInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" container=");
            sb.append(this.mContainer);
            sb.append(" flags=0x");
            sb.append(Integer.toHexString(this.mFlags));
            sb.append('}');
            return sb.toString();
        }

        boolean hasChanged() {
            if (Features.FEAT_QUICK_WIN == true) goto L5;
        L12:
            boolean currVisible = this.mContainer.isVisibleRequested();
            if (currVisible == false) goto L19;
            if ((this.mFlags & 2) == 0) goto L17;
        L50:
            return true;
        L17:
            if ((this.mFlags & 4) != 0) goto L50;
        L19:
            if ((this.mFlags & 128) != 0) goto L50;
            if ((this.mFlags & 256) != 0) goto L50;
            if (currVisible != this.mVisible) goto L29;
            if (this.mVisible == true) goto L29;
            return false;
        L29:
            if (currVisible == this.mVisible) goto L31;
            return true;
        L31:
            if (this.mKnownConfigChanges == 0) goto L33;
            return true;
        L33:
            if (this.mWindowingMode == 0) goto L37;
            if (this.mContainer.getWindowingMode() == this.mWindowingMode) goto L37;
            return true;
        L37:
            if (this.mContainer.getBounds().equals(this.mAbsoluteBounds) == true) goto L39;
            return true;
        L39:
            if (this.mRotation == this.mContainer.getWindowConfiguration().getRotation()) goto L41;
            return true;
        L41:
            if (this.mDisplayId == Transition.m10333$$Nest$smgetDisplayId(this.mContainer)) goto L43;
            return true;
        L43:
            if ((this.mFlags & 32) == 0) goto L45;
            return true;
        L45:
            if (this.mRestoringTransientHide == false) goto L49;
            return true;
        L49:
            return false;
        L5:
            if (this.mContainer.asTask() == null) goto L12;
            if (this.mStartScale == this.mContainer.asTask().getExt().getScale()) goto L10;
            return true;
        L10:
            if (Objects.equals(this.mStartOffset, this.mContainer.asTask().getExt().getOffset()) == true) goto L12;
            return true;
        }

        int getTransitMode(WindowContainer wc) {
            if ((this.mFlags & 4) == 0) goto L9;
            if (this.mExistenceChanged == true) goto L7;
            return 4;
        L7:
            return 2;
        L9:
            if ((this.mFlags & 256) == 0) goto L11;
            return 3;
        L11:
            boolean nowVisible = wc.isVisibleRequested();
            if (nowVisible != this.mVisible) goto L16;
            return 6;
        L16:
            if (this.mExistenceChanged == false) goto L20;
            if (nowVisible == false) goto L24;
            return 1;
        L24:
            return 2;
        L20:
            if (nowVisible == true) goto L22;
            return 4;
        L22:
            return 3;
        }

        int getChangeFlags(WindowContainer wc) {
            int flags = 0;
            if (this.mShowWallpaper == false) goto L5;
        L6:
            flags = 0 | 1;
        L8:
            if (Transition.m10336$$Nest$smisTranslucent(wc) == false) goto L11;
            flags = flags | 4;
        L11:
            if (wc.mWmService.mAtmService.mBackNavigationController.isMonitorTransitionTarget(wc) == false) goto L13;
            flags = flags | 131072;
        L13:
            TaskDisplayArea tda = wc.asTaskDisplayArea();
            if (tda == null) goto L16;
            flags = flags | 8388608;
        L16:
            Task task = wc.asTask();
            if (task == null) goto L36;
            ActivityRecord topActivity = task.getTopNonFinishingActivity();
            if (topActivity == null) goto L34;
            if (topActivity.mStartingData == null) goto L26;
            if (topActivity.mStartingData.hasImeSurface() == false) goto L26;
            flags = flags | 2048;
        L26:
            if (topActivity.mLaunchTaskBehind == false) goto L31;
            if (topActivity.isAnimating(2, 256) == true) goto L31;
            Slog.e(Transition.TAG, "Unexpected launch-task-behind operation in shell transition");
            flags = flags | 524288;
        L31:
            if ((topActivity.mTransitionChangeFlags & 294912) != 294912) goto L34;
            flags = flags | 294912;
        L34:
            if (task.voiceSession == null) goto L36;
            flags = flags | 16;
        L36:
            Task parentTask = null;
            ActivityRecord record = wc.asActivityRecord();
            if (record == null) goto L44;
            parentTask = record.getTask();
            if (record.mVoiceInteraction == false) goto L41;
            flags = flags | 16;
        L41:
            flags = flags | record.mTransitionChangeFlags;
            if (record.isConfigurationDispatchPaused() == false) goto L44;
            flags = flags | 4194304;
        L44:
            TaskFragment taskFragment = wc.asTaskFragment();
            if (taskFragment == null) goto L48;
            if (task != null) goto L48;
            parentTask = taskFragment.getTask();
        L48:
            if (parentTask != null) goto L50;
            DisplayContent dc = wc.asDisplayContent();
            if (dc == null) goto L76;
            flags = flags | 32;
            if (dc.hasAlertWindowSurfaces() == false) goto L87;
            flags = flags | 128;
        L87:
            if ((this.mFlags & 8) == 0) goto L92;
            if ((this.mFlags & 16) != 0) goto L92;
            flags = flags | 262144;
        L92:
            if ((this.mFlags & 32) == 0) goto L95;
            flags = flags | 1048576;
        L95:
            if ((this.mFlags & 64) != 0) goto L97;
            return flags;
        L97:
            return flags | 4194304;
        L76:
            if (Transition.m10337$$Nest$smisWallpaper(wc) == false) goto L79;
            flags = flags | 2;
            goto L87
        L79:
            if (Transition.m10334$$Nest$smisInputMethod(wc) == false) goto L81;
            flags = flags | 256;
            goto L87
        L81:
            int type = wc.getWindowType();
            if (type < 2000) goto L87;
            if (type > 2999) goto L87;
            flags = flags | 65536;
            goto L87
        L50:
            if (parentTask.forAllLeafTaskFragments(new ActivityRecord$$ExternalSyntheticLambda7()) == false) goto L52;
            flags = flags | 512;
        L52:
            ActivityRecord starting = parentTask.topActivityContainsStartingWindow();
            if (starting == null) goto L67;
            if (starting != record) goto L56;
        L65:
            flags = flags | 16384;
            goto L67
        L56:
            if (starting.mStartingData != null) goto L58;
        L61:
            if (record == null) goto L67;
            if (parentTask.mChildren.indexOf(record) >= parentTask.mChildren.indexOf(starting)) goto L67;
            flags = flags | 16384;
            goto L67
        L58:
            if (starting.mStartingData.mAssociatedTask == null) goto L61;
        L67:
            if (isWindowFillingTask(wc, parentTask) == false) goto L87;
            flags = flags | 1024;
            goto L87
        L5:
            if (wc.showWallpaper() == false) goto L8;
            goto L6
        }

        private boolean isWindowFillingTask(WindowContainer wc, Task parentTask) {
            Rect taskBounds = parentTask.getBounds();
            int taskWidth = taskBounds.width();
            int taskHeight = taskBounds.height();
            Rect startBounds = this.mAbsoluteBounds;
            Rect endBounds = wc.getBounds();
            if (this.mVisible == true) goto L5;
        L10:
            boolean isInvisibleOrFillingTaskBeforeTransition = true;
        L12:
            if (wc.isVisibleRequested() == true) goto L14;
        L19:
            boolean isInVisibleOrFillingTaskAfterTransition = true;
        L21:
            if (isInvisibleOrFillingTaskBeforeTransition == false) goto L25;
            if (isInVisibleOrFillingTaskAfterTransition == false) goto L25;
            return true;
        L25:
            return false;
        L14:
            if (taskWidth == endBounds.width()) goto L16;
        L18:
            isInVisibleOrFillingTaskAfterTransition = false;
            goto L21
        L16:
            if (taskHeight != endBounds.height()) goto L18;
        L5:
            if (taskWidth == startBounds.width()) goto L7;
        L9:
            isInvisibleOrFillingTaskBeforeTransition = false;
            goto L12
        L7:
            if (taskHeight != startBounds.height()) goto L9;
            goto L9
        }
    }

    interface IContainerFreezer {
        void cleanUp(SurfaceControl.Transaction r1);

        boolean freeze(WindowContainer r1, Rect r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ParallelType {
    }

    static class ReadyCondition {
        String mAlternate;
        final Object mDebugTarget;
        boolean mMet;
        final String mName;
        ReadyTracker mTracker;

        ReadyCondition(String name) {
            this.mMet = false;
            this.mAlternate = null;
            this.mName = name;
            this.mDebugTarget = null;
        }

        ReadyCondition(String name, Object debugTarget) {
            this.mMet = false;
            this.mAlternate = null;
            this.mName = name;
            this.mDebugTarget = debugTarget;
        }

        protected String getDebugRep() {
            if (this.mDebugTarget == null) goto L7;
            return this.mName + ":" + this.mDebugTarget;
        L7:
            return this.mName;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("{");
            r0.append(getDebugRep());
            if (this.mAlternate == null) goto L5;
            String r1 = " (" + this.mAlternate + ")";
        L6:
            r0.append(r1);
            r0.append("}");
            return r0.toString();
        L5:
            r1 = "";
            goto L6
        }

        void startTracking() {
        }

        void meetAlternate(String reason) {
            if (this.mMet == false) goto L5;
            return;
        L5:
            this.mAlternate = reason;
            meet();
        }

        void meet() {
            if (this.mMet == false) goto L6;
            return;
        L6:
            if (this.mTracker == null) goto L10;
            this.mTracker.meet(this);
            return;
        L10:
            throw new IllegalStateException("Can't meet a condition before it is waited on");
        }
    }

    static class ReadyTracker {
        static final ReadyTracker NULL_TRACKER = null;
        final ArrayList<ReadyCondition> mConditions;
        final ArrayList<ReadyCondition> mMet;
        private final Transition mTransition;

        static {
            NULL_TRACKER = new ReadyTracker(null);
        }

        ReadyTracker(Transition transition) {
            this.mConditions = new ArrayList();
            this.mMet = new ArrayList();
            this.mTransition = transition;
        }

        void add(ReadyCondition condition) {
            if (this.mTransition != null) goto L5;
        L12:
            condition.mTracker = NULL_TRACKER;
            return;
        L5:
            if (this.mTransition.mController.useFullReadyTracking() == false) goto L12;
            this.mConditions.add(condition);
            condition.mTracker = this;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L10;
            String protoLogParam0 = String.valueOf(condition);
            long protoLogParam1 = Transition.m10331$$Nest$fgetmSyncId(this.mTransition);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -2971560715211489406L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
        L10:
            condition.startTracking();
        }

        void meet(ReadyCondition condition) {
            if (this.mTransition != null) goto L5;
            return;
        L5:
            if (this.mTransition.mController.useFullReadyTracking() == true) goto L8;
            return;
        L8:
            if (Transition.m10330$$Nest$fgetmState(this.mTransition) < 2) goto L12;
            Slog.w(Transition.TAG, "#%d: Condition met too late, already in state=" + Transition.m10330$$Nest$fgetmState(this.mTransition) + ": " + condition);
            return;
        L12:
            if (this.mConditions.remove(condition) == false) goto L14;
            condition.mMet = true;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L22;
            String protoLogParam0 = String.valueOf(condition);
            long protoLogParam1 = Transition.m10331$$Nest$fgetmSyncId(this.mTransition);
            long protoLogParam2 = this.mConditions.size();
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 7631061720069910622L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
        L22:
            this.mMet.add(condition);
            Transition.m10332$$Nest$mapplyReady(this.mTransition);
            return;
        L14:
            if (this.mMet.contains(condition) == false) goto L18;
            throw new IllegalStateException("Can't meet the same condition more than once: " + condition + " #" + Transition.m10331$$Nest$fgetmSyncId(this.mTransition));
        L18:
            throw new IllegalArgumentException("Can't meet a condition that isn't being waited on: " + condition + " in #" + Transition.m10331$$Nest$fgetmSyncId(this.mTransition));
        }

        boolean isReady() {
            if (this.mConditions.isEmpty() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mMet.isEmpty() == true) goto L7;
            return true;
        }
    }

    private static class ReadyTrackerOld {
        private int mDeferReadyDepth;
        private final ArrayMap<WindowContainer, Boolean> mReadyGroups;
        private boolean mReadyOverride;
        private boolean mUsed;

        /* JADX INFO: renamed from: -$$Nest$fgetmDeferReadyDepth, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10338$$Nest$fgetmDeferReadyDepth(ReadyTrackerOld r0) {
            return r0.mDeferReadyDepth;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReadyGroups, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m10339$$Nest$fgetmReadyGroups(ReadyTrackerOld r0) {
            return r0.mReadyGroups;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUsed, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10340$$Nest$fgetmUsed(ReadyTrackerOld r0) {
            return r0.mUsed;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDeferReadyDepth, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10341$$Nest$fputmDeferReadyDepth(ReadyTrackerOld r0, int r1) {
            r0.mDeferReadyDepth = r1;
        }

        /* synthetic */ ReadyTrackerOld(TransitionIA r1) {
            this();
        }

        private ReadyTrackerOld() {
            this.mReadyGroups = new ArrayMap();
            this.mUsed = false;
            this.mReadyOverride = false;
            this.mDeferReadyDepth = 0;
        }

        void addGroup(WindowContainer wc) {
            if (this.mReadyGroups.containsKey(wc) == false) goto L5;
            return;
        L5:
            this.mReadyGroups.put(wc, false);
        }

        void setReadyFrom(WindowContainer wc, boolean ready) {
            this.mUsed = true;
            WindowContainer current = wc;
        L3:
            if (current == null) goto L14;
            if (Transition.m10335$$Nest$smisReadyGroup(current) == true) goto L6;
            current = current.getParent();
            goto L3
        L6:
            this.mReadyGroups.put(current, Boolean.valueOf(ready));
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L10;
            String protoLogParam1 = String.valueOf(current);
            String protoLogParam2 = String.valueOf(wc);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -4770394322045550928L, 3, new Object[]{Boolean.valueOf(ready), protoLogParam1, protoLogParam2});
            return;
        L10:
            return;
        }

        void setAllReady() {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L5;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 6039132370452820927L, 0, null);
        L5:
            this.mUsed = true;
            this.mReadyOverride = true;
        }

        void resetAllReady() {
            this.mUsed = false;
            this.mReadyOverride = false;
        }

        boolean allReady() {
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L5;
            boolean protoLogParam0 = this.mUsed;
            boolean protoLogParam1 = this.mReadyOverride;
            long protoLogParam2 = this.mDeferReadyDepth;
            String protoLogParam3 = String.valueOf(groupsToString());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -3263748870548668913L, 31, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Long.valueOf(protoLogParam2), protoLogParam3});
        L5:
            boolean protoLogParam4 = this.mUsed;
            if (protoLogParam4 == true) goto L9;
            return false;
        L9:
            if (this.mDeferReadyDepth <= 0) goto L12;
            return false;
        L12:
            if (this.mReadyOverride == false) goto L14;
            return true;
        L14:
            int i = this.mReadyGroups.size() - 1;
        L15:
            if (i < 0) goto L26;
            WindowContainer wc = this.mReadyGroups.keyAt(i);
            if (wc.isAttached() == false) goto L24;
            if (wc.isVisibleRequested() == false) goto L24;
            if (this.mReadyGroups.valueAt(i).booleanValue() == true) goto L24;
            return false;
        L24:
            i = i - 1;
            goto L15
        L26:
            return true;
        }

        private String groupsToString() {
            StringBuilder b = new StringBuilder();
            int i = 0;
        L4:
            if (i >= this.mReadyGroups.size()) goto L9;
            if (i == 0) goto L7;
            b.append(',');
        L7:
            b.append(this.mReadyGroups.keyAt(i));
            b.append(':');
            b.append(this.mReadyGroups.valueAt(i));
            i = i + 1;
            goto L4
        L9:
            return b.toString();
        }
    }

    private class ScreenshotFreezer implements IContainerFreezer {
        private final ArraySet<WindowContainer> mFrozen;
        final /* synthetic */ Transition this$0;

        /* synthetic */ ScreenshotFreezer(Transition r1, TransitionIA r2) {
            this(r1);
        }

        private ScreenshotFreezer(Transition r1) {
            this.this$0 = r1;
            this.mFrozen = new ArraySet();
        }

        @Override // com.android.server.wm.Transition.IContainerFreezer
        public boolean freeze(WindowContainer wc, Rect bounds) {
            if (wc.isVisibleRequested() == true) goto L5;
            return false;
        L5:
            WindowContainer p = wc;
        L6:
            if (p == null) goto L12;
            if (this.mFrozen.contains(p) == true) goto L9;
            p = p.getParent();
            goto L6
        L9:
            return false;
        L12:
            if (this.this$0.mIsSeamlessRotation == false) goto L25;
            if (wc.getDisplayContent() != null) goto L16;
            WindowState top = null;
        L18:
            if (top == null) goto L25;
            if (top != wc) goto L21;
        L22:
            this.mFrozen.add(wc);
            return true;
        L21:
            if (top.isDescendantOf(wc) == false) goto L25;
        L16:
            top = wc.getDisplayContent().getDisplayPolicy().getTopFullscreenOpaqueWindow();
        L25:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L27;
            String protoLogParam0 = String.valueOf(wc.toString());
            String protoLogParam1 = String.valueOf(bounds.toString());
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 2699903406935781477L, 0, new Object[]{protoLogParam0, protoLogParam1});
        L27:
            Rect cropBounds = new Rect(bounds);
            cropBounds.offsetTo(0, 0);
            if (wc.asDisplayContent() != null) goto L30;
        L32:
            boolean r1 = false;
        L33:
            boolean isDisplayRotation = r1;
            ScreenCapture.LayerCaptureArgs captureArgs = new ScreenCapture.LayerCaptureArgs.Builder(wc.getSurfaceControl()).setSourceCrop(cropBounds).setCaptureSecureLayers(true).setAllowProtected(true).setHintForSeamlessTransition(true).build();
            ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer = ScreenCapture.captureLayers(captureArgs);
            if (screenshotBuffer != null) goto L36;
            HardwareBuffer r2 = null;
        L37:
            HardwareBuffer buffer = r2;
            if (buffer != null) goto L40;
        L56:
            Slog.w(Transition.TAG, "Failed to capture screenshot for " + wc);
            return false;
        L40:
            if (buffer.getWidth() <= 1) goto L56;
            if (buffer.getHeight() <= 1) goto L56;
            if (isDisplayRotation == false) goto L46;
            String r3 = "RotationLayer";
        L47:
            String name = r3;
            SurfaceControl.Builder r4 = wc.makeAnimationLeash().setName(name).setOpaque(wc.fillsParent());
            if (this.this$0.mType != 2003) goto L50;
            SurfaceControl r5 = null;
        L51:
            SurfaceControl snapshotSurface = r4.setParent(r5).setSecure(screenshotBuffer.containsSecureLayers()).setCallsite("Transition.ScreenshotSync").setBLASTLayer().build();
            this.mFrozen.add(wc);
            ChangeInfo changeInfo = this.this$0.mChanges.get(wc);
            changeInfo.getClass();
            changeInfo.mSnapshot = snapshotSurface;
            if (changeInfo.mRotation == wc.mDisplayContent.getRotation()) goto L54;
            changeInfo.mSnapshotLuma = TransitionAnimation.getBorderLuma(buffer, screenshotBuffer.getColorSpace(), wc.mSurfaceControl);
        L54:
            SurfaceControl.Transaction t = wc.mWmService.mTransactionFactory.get();
            TransitionAnimation.configureScreenshotLayer(t, snapshotSurface, screenshotBuffer);
            this.this$0.getExt().onFreezeSnapshotReady(this.this$0.mType, wc, changeInfo, snapshotSurface, t);
            t.show(snapshotSurface);
            t.setLayer(snapshotSurface, Integer.MAX_VALUE);
            t.apply();
            t.close();
            buffer.close();
            wc.getSyncTransaction().reparent(snapshotSurface, null);
            return true;
        L50:
            r5 = wc.getSurfaceControl();
            goto L51
        L46:
            r3 = "transition snapshot: " + wc;
            goto L47
        L36:
            r2 = screenshotBuffer.getHardwareBuffer();
            goto L37
        L30:
            if (wc.asDisplayContent().isRotationChanging() == false) goto L32;
            r1 = true;
            goto L33
        }

        @Override // com.android.server.wm.Transition.IContainerFreezer
        public void cleanUp(SurfaceControl.Transaction t) {
            int i = 0;
        L4:
            if (i >= this.mFrozen.size()) goto L11;
            ChangeInfo r1 = this.this$0.mChanges.get(this.mFrozen.valueAt(i));
            r1.getClass();
            SurfaceControl snap = r1.mSnapshot;
            if (snap == null) goto L9;
            t.reparent(snap, null);
        L9:
            i = i + 1;
            goto L4
        }
    }

    private static class Targets {
        final SparseArray<ChangeInfo> mArray;
        private int mDepthFactor;
        private ArrayList<ChangeInfo> mRemovedTargets;

        /* synthetic */ Targets(TransitionIA r1) {
            this();
        }

        private Targets() {
            this.mArray = new SparseArray();
        }

        void add(ChangeInfo target) {
            if (this.mDepthFactor != 0) goto L5;
            this.mDepthFactor = target.mContainer.mWmService.mRoot.getTreeWeight() + 1;
        L5:
            int score = target.mContainer.getPrefixOrderIndex();
            WindowContainer<?> wc = target.mContainer;
        L6:
            if (wc == null) goto L11;
            WindowContainer<?> parent = wc.getParent();
            if (parent == null) goto L10;
            score = score + this.mDepthFactor;
        L10:
            wc = parent;
            goto L6
        L11:
            this.mArray.put(score, target);
        }

        void remove(int index) {
            ChangeInfo removingTarget = this.mArray.valueAt(index);
            this.mArray.removeAt(index);
            if (this.mRemovedTargets != null) goto L5;
            this.mRemovedTargets = new ArrayList();
        L5:
            this.mRemovedTargets.add(removingTarget);
        }

        boolean wasParticipated(ChangeInfo wc) {
            if (this.mArray.indexOfValue(wc) < 0) goto L5;
        L10:
            return true;
        L5:
            if (this.mRemovedTargets != null) goto L7;
        L9:
            return false;
        L7:
            if (this.mRemovedTargets.contains(wc) == false) goto L9;
            goto L9
        }

        ArrayList<ChangeInfo> getListSortedByZ() {
            SparseArray<ChangeInfo> arrayByZ = new SparseArray(this.mArray.size());
            int i = this.mArray.size() - 1;
        L3:
            if (i < 0) goto L5;
            int zOrder = this.mArray.keyAt(i) % this.mDepthFactor;
            arrayByZ.put(zOrder, this.mArray.valueAt(i));
            i = i - 1;
            goto L3
        L5:
            ArrayList<ChangeInfo> sortedTargets = new ArrayList(arrayByZ.size());
            int i2 = arrayByZ.size() - 1;
        L6:
            if (i2 < 0) goto L9;
            sortedTargets.add(arrayByZ.valueAt(i2));
            i2 = i2 - 1;
            goto L6
        L9:
            return sortedTargets;
        }
    }

    private static class Token extends Binder {
        final WeakReference<Transition> mTransition;

        Token(Transition transition) {
            this.mTransition = new WeakReference(transition);
        }

        public String toString() {
            return "Token{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.mTransition.get() + "}";
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface TransitionState {
    }

    /* JADX INFO: renamed from: $r8$lambda$-Zrqv9SgkkAY30AWOt0m2rJSsbw, reason: not valid java name */
    public static /* synthetic */ boolean m10323$r8$lambda$Zrqv9SgkkAY30AWOt0m2rJSsbw(Task r0) {
        return lambda$handleLegacyRecentsStartBehavior$10(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$6P0d0TdcueYXfvom7E_tR-J1fP0, reason: not valid java name */
    public static /* synthetic */ void m10324$r8$lambda$6P0d0TdcueYXfvom7E_tRJ1fP0(Runnable r0, SurfaceControl.TransactionStats r1) {
        lambda$onTransactionReady$8(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$7u-fn7VqmBuRsg7PdONkj6v3G7w, reason: not valid java name */
    public static /* synthetic */ void m10325$r8$lambda$7ufn7VqmBuRsg7PdONkj6v3G7w(Task r0) {
        lambda$finishTransition$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$Bd9t7_cXvsExMst_o9vJ3jPwTnw(ArraySet r0, ActivityRecord r1) {
        lambda$applyDisplayChangeIfNeeded$14(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JF5kuO075N6GGSCYS1rcdSlMiJI(Transition r0) {
        r0.lambda$postCleanupOnFailure$9();
    }

    public static /* synthetic */ boolean $r8$lambda$M6wH2HEM1Z7mDppJQRMyBRlOzWk(Transition r0, Task r1, Task r2, Task r3) {
        return r0.lambda$setTransientLaunch$0(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$SZu63gJM1sDweH3PrOJU3kTDLPM(Transition r0, ActivityRecord r1) {
        r0.lambda$setConfigAtEnd$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ae2rOBsvLNpO5hISqyOOeQUaP48(Task r0) {
        return lambda$addOnTopTasks$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$g8zdsX8l8uFGw7KqE-WHceDfWhg, reason: not valid java name */
    public static /* synthetic */ boolean m10326$r8$lambda$g8zdsX8l8uFGw7KqEWHceDfWhg(int r0, ArraySet r1, ActivityRecord r2) {
        return lambda$findAnimLayoutParamsActivityRecord$11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$kPxQ7qFowyfVDQtPYc35gZ7JoMs(int r0, SurfaceControl.Transaction r1) {
        lambda$commitConfigAtEndActivities$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$l-oAoCfJkscbIwo8-SCNzjktQkg, reason: not valid java name */
    public static /* synthetic */ void m10327$r8$lambda$loAoCfJkscbIwo8SCNzjktQkg(IRemoteCallback r0) {
        lambda$sendRemoteCallback$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$mtZ5g4CRC98NR_J2j4MG72Wbs-U, reason: not valid java name */
    public static /* synthetic */ boolean m10328$r8$lambda$mtZ5g4CRC98NR_J2j4MG72WbsU(ActivityRecord r0) {
        return lambda$findAnimLayoutParamsActivityRecord$13(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$nm-N6zwqOkYjJbrt2zNKNbMnT08, reason: not valid java name */
    public static /* synthetic */ boolean m10329$r8$lambda$nmN6zwqOkYjJbrt2zNKNbMnT08(ActivityRecord r0) {
        return lambda$findAnimLayoutParamsActivityRecord$12(r0);
    }

    public static /* synthetic */ void $r8$lambda$tznWdmYk4DuTLhN0IJ0SMRe633A(Transition r0, Task r1, ActivityRecord r2) {
        r0.lambda$finishTransition$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ufArhAiG3KdgsKRoZwUPQwqztPs(WindowState r0) {
        lambda$commitConfigAtEndActivities$7(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10330$$Nest$fgetmState(Transition r0) {
        return r0.mState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSyncId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10331$$Nest$fgetmSyncId(Transition r0) {
        return r0.mSyncId;
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10332$$Nest$mapplyReady(Transition r0) {
        r0.applyReady();
    }

    /* JADX INFO: renamed from: -$$Nest$smgetDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10333$$Nest$smgetDisplayId(WindowContainer r0) {
        return getDisplayId(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisInputMethod, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10334$$Nest$smisInputMethod(WindowContainer r0) {
        return isInputMethod(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisReadyGroup, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10335$$Nest$smisReadyGroup(WindowContainer r0) {
        return isReadyGroup(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisTranslucent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10336$$Nest$smisTranslucent(WindowContainer r0) {
        return isTranslucent(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisWallpaper, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10337$$Nest$smisWallpaper(WindowContainer r0) {
        return isWallpaper(r0);
    }

    Transition(int type, int flags, TransitionController controller, BLASTSyncEngine syncEngine) {
        this.mSyncId = -1;
        this.mRemoteDelegate = null;
        this.mStartTransaction = null;
        this.mFinishTransaction = null;
        this.mPerf = null;
        this.mIsAnimationPerfLockAcquired = false;
        this.mCleanupTransaction = null;
        this.mChanges = new ArrayMap();
        this.mParticipants = new ArraySet();
        this.mTargetDisplays = new ArrayList();
        this.mOnTopTasksStart = new ArrayList();
        this.mOnTopTasksAtReady = new ArrayList();
        this.mOnTopDisplayStart = null;
        this.mOnTopDisplayAtReady = null;
        this.mVisibleAtTransitionEndTokens = new ArraySet();
        this.mTransientLaunches = null;
        this.mTransactionCompletedListeners = null;
        this.mTransitionEndedListeners = null;
        this.mClientAnimationStartCallback = null;
        this.mClientAnimationFinishCallback = null;
        this.mState = -1;
        this.mReadyTrackerOld = new ReadyTrackerOld(null);
        this.mReadyTracker = new ReadyTracker(this);
        this.mRecentsDisplayId = -1;
        this.mCanPipOnFinish = true;
        this.mIsSeamlessRotation = false;
        this.mContainerFreezer = null;
        this.mPriorVisibilityMightBeDirty = false;
        this.mLogger = new TransitionController.Logger();
        this.mForcePlaying = false;
        this.mIsPlayerEnabled = true;
        this.mParallelCollectType = 0;
        this.mAnimationTrack = 0;
        this.mConfigAtEndActivities = null;
        this.mChainHead = null;
        this.mExt = (IExtTransition) ExtImplFactory.getImpl(IExtTransition.class, new Object[]{this});
        this.mType = type;
        this.mFlags = flags;
        this.mController = controller;
        this.mSyncEngine = syncEngine;
        this.mToken = new Token(this);
        TransitionController.Logger r0 = this.mLogger;
        r0.mCreateWallTimeMs = System.currentTimeMillis();
        TransitionController.Logger r1 = this.mLogger;
        r1.mCreateTimeNs = SystemClock.elapsedRealtimeNanos();
        if (this.mPerf != null) goto L6;
        this.mPerf = new BoostFramework();
        return;
    }

    static Transition fromBinder(IBinder token) {
        if (token != null) goto L10;
        return null;
    L10:
        return ((Token) token).mTransition.get();
    L7:
        e = move-exception;
        Slog.w(TAG, "Invalid transition token: " + token, e);
        return null;
    }

    IBinder getToken() {
        return this.mToken;
    }

    void addFlag(int flags) {
        this.mFlags |= flags;
    }

    void removeFlag(int flags) {
        this.mFlags &= ~flags;
    }

    void calcParallelCollectType(WindowContainerTransaction wct) {
        int i = 0;
    L4:
        if (i >= wct.getHierarchyOps().size()) goto L21;
        WindowContainerTransaction.HierarchyOp hop = (WindowContainerTransaction.HierarchyOp) wct.getHierarchyOps().get(i);
        if (hop.getType() != 7) goto L19;
        Bundle b = hop.getLaunchOptions();
        if (b == null) goto L19;
        if (b.isEmpty() == true) goto L19;
        boolean transientLaunch = b.getBoolean("android.activity.transientLaunch");
        if (transientLaunch == false) goto L19;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L18;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -2700498872917476567L, 0, null);
    L18:
        this.mParallelCollectType = 2;
    L19:
        i = i + 1;
        goto L4
    }

    void setTransientLaunch(ActivityRecord activity, final Task restoreBelow) {
        if (this.mTransientLaunches != null) goto L5;
        this.mTransientLaunches = new ArrayMap();
        this.mTransientHideTasks = new ArrayList();
    L5:
        this.mTransientLaunches.put(activity, restoreBelow);
        setTransientLaunchToChanges(activity);
        if (restoreBelow == null) goto L8;
        int restoreBelowTaskId = restoreBelow.mTaskId;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L12;
        long protoLogParam0 = this.mSyncId;
        String protoLogParam1 = String.valueOf(activity);
        long protoLogParam2 = restoreBelowTaskId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -8475765840916037837L, 17, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1, Long.valueOf(protoLogParam2)});
    L12:
        final Task transientLaunchRootTask = activity.getRootTask();
        if (restoreBelow == null) goto L15;
        WindowContainer<?> parent = restoreBelow.getParent();
    L19:
        if (parent == null) goto L24;
        parent.forAllTasks(new Transition$$ExternalSyntheticLambda1(this, transientLaunchRootTask, restoreBelow));
        int i = this.mChanges.size() - 1;
    L21:
        if (i < 0) goto L24;
        updateTransientFlags(this.mChanges.valueAt(i));
        i = i - 1;
    L24:
        if (activity.isActivityTypeHomeOrRecents() == false) goto L28;
        addFlag(128);
        activity.getTask().setCanAffectSystemUiFlags(false);
        this.mExt.setTransientHideTaskInsetsFrozen(this.mTransientHideTasks, true);
        return;
    L28:
        return;
    L15:
        if (transientLaunchRootTask == null) goto L17;
        parent = transientLaunchRootTask.getParent();
        goto L19
    L17:
        parent = null;
        goto L19
    L8:
        restoreBelowTaskId = -1;
        goto L10
    }

    private /* synthetic */ boolean lambda$setTransientLaunch$0(Task transientLaunchRootTask, Task restoreBelow, Task t) {
        if (t != transientLaunchRootTask) goto L6;
        return false;
    L6:
        if (t.isVisibleRequested() == true) goto L8;
    L18:
        if (restoreBelow == null) goto L22;
        if (t == restoreBelow) goto L28;
        return false;
    L28:
        return true;
    L22:
        if (t.isRootTask() == true) goto L24;
        return false;
    L24:
        if (t.fillsParent() == true) goto L26;
        return false;
    L26:
        return true;
    L8:
        if (t.isAlwaysOnTop() == true) goto L18;
        if (t.isRootTask() == false) goto L16;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L14;
        long protoLogParam0 = t.mTaskId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -3957629866060925043L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L14:
        this.mTransientHideTasks.add(t);
    L16:
        if (t.isLeafTask() == false) goto L18;
        collect(t);
        goto L18
    }

    boolean isInTransientHide(WindowContainer wc) {
        if (this.mTransientHideTasks != null) goto L5;
        return false;
    L5:
        int i = this.mTransientHideTasks.size() - 1;
    L6:
        if (i < 0) goto L15;
        Task task = this.mTransientHideTasks.get(i);
        if (wc == task) goto L13;
        if (wc.isDescendantOf(task) == true) goto L13;
        i = i - 1;
    L13:
        return true;
    L15:
        return false;
    }

    void updateChangesForRestoreTransientHideTasks(Transition transientLaunchTransition) {
        if (transientLaunchTransition.mTransientHideTasks == null) goto L5;
        int i = 0;
    L10:
        if (i >= this.mChanges.size()) goto L19;
        WindowContainer container = this.mChanges.keyAt(i);
        if (transientLaunchTransition.isInTransientHide(container) == false) goto L17;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L16;
        long protoLogParam0 = this.mSyncId;
        String protoLogParam1 = String.valueOf(container);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 3691275084260389957L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L16:
        ChangeInfo info = this.mChanges.valueAt(i);
        info.mRestoringTransientHide = true;
    L17:
        i = i + 1;
        goto L10
    L19:
        return;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L23;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -2842673544924350424L, 0, null);
        return;
    }

    boolean isTransientVisible(Task task) {
        if (this.mTransientLaunches != null) goto L5;
        return false;
    L5:
        int occludedCount = 0;
        int numTransient = this.mTransientLaunches.size();
        int i = numTransient - 1;
    L6:
        if (i < 0) goto L28;
        Task transientRoot = this.mTransientLaunches.keyAt(i).getRootTask();
        if (transientRoot == null) goto L26;
        WindowContainer<?> rootParent = transientRoot.getParent();
        if (rootParent == null) goto L26;
        if (rootParent.getTopChild() == transientRoot) goto L26;
        int j = rootParent.getChildCount() - 1;
    L16:
        if (j < 0) goto L26;
        WindowContainer<?> sibling = rootParent.getChildAt(j);
        if (sibling == transientRoot) goto L26;
        if (sibling.getWindowConfiguration().isAlwaysOnTop() == true) goto L25;
        if (this.mController.mAtm.mTaskSupervisor.mOpaqueContainerHelper.isOpaque(sibling) == false) goto L25;
        occludedCount = occludedCount + 1;
    L25:
        j = j - 1;
    L26:
        i = i - 1;
        goto L6
    L28:
        if (occludedCount != numTransient) goto L31;
        return false;
    L31:
        return isInTransientHide(task);
    }

    boolean canApplyDim(Task task) {
        if (this.mTransientLaunches != null) goto L6;
        return true;
    L6:
        if (task.isSuitableForDimming() == false) goto L8;
        return true;
    L8:
        int i = this.mTransientLaunches.size() - 1;
    L9:
        if (i < 0) goto L18;
        Task transientTask = this.mTransientLaunches.keyAt(i).getTask();
        if (transientTask == null) goto L16;
        if (transientTask.canAffectSystemUiFlags() == false) goto L16;
        return false;
    L16:
        i = i - 1;
        goto L9
    L18:
        return true;
    }

    boolean hasTransientLaunch() {
        if (this.mTransientLaunches != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mTransientLaunches.isEmpty() == true) goto L7;
        return true;
    }

    boolean isTransientLaunch(ActivityRecord activity) {
        if (this.mTransientLaunches != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mTransientLaunches.containsKey(activity) == false) goto L7;
        return true;
    }

    Task getTransientLaunchRestoreTarget(WindowContainer container) {
        if (this.mTransientLaunches != null) goto L5;
        return null;
    L5:
        int i = 0;
    L7:
        if (i >= this.mTransientLaunches.size()) goto L14;
        if (this.mTransientLaunches.keyAt(i).isDescendantOf(container) == true) goto L11;
        i = i + 1;
        goto L7
    L11:
        return this.mTransientLaunches.valueAt(i);
    L14:
        return null;
    }

    boolean isOnDisplay(DisplayContent dc) {
        return this.mTargetDisplays.contains(dc);
    }

    void setConfigAtEnd(WindowContainer<?> wc) {
        wc.forAllActivities(new Transition$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$setConfigAtEnd$1(ActivityRecord ar) {
        if (ar.isVisible() == true) goto L5;
        return;
    L5:
        if (ar.isVisibleRequested() == true) goto L8;
        return;
    L8:
        if (this.mConfigAtEndActivities != null) goto L11;
        this.mConfigAtEndActivities = new ArrayList();
    L13:
        this.mConfigAtEndActivities.add(ar);
        ar.pauseConfigurationDispatch();
        collect(ar);
        this.mChanges.get(ar).mFlags |= 64;
        return;
    L11:
        if (this.mConfigAtEndActivities.contains(ar) == false) goto L13;
    }

    void setBackGestureAnimation(WindowContainer wc, boolean isTop) {
        ChangeInfo info = this.mChanges.get(wc);
        if (info != null) goto L5;
        return;
    L5:
        int r1 = info.mFlags;
        if (isTop == false) goto L8;
        int r2 = 128;
    L9:
        info.mFlags = r1 | r2;
        return;
    L8:
        r2 = 256;
        goto L9
    }

    void setSeamlessRotation(WindowContainer wc) {
        ChangeInfo info = this.mChanges.get(wc);
        if (info != null) goto L5;
        return;
    L5:
        info.mFlags |= 1;
        onSeamlessRotating(wc.getDisplayContent());
    }

    void onSeamlessRotating(DisplayContent dc) {
        if (this.mSyncEngine.getSyncSet(this.mSyncId).mSyncMethod != 1) goto L6;
        return;
    L6:
        if (this.mContainerFreezer != null) goto L8;
        this.mContainerFreezer = new ScreenshotFreezer(this, null);
    L8:
        WindowState top = dc.getDisplayPolicy().getTopFullscreenOpaqueWindow();
        if (top == null) goto L14;
        this.mIsSeamlessRotation = true;
        top.mSyncMethodOverride = 1;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L15;
        String protoLogParam0 = String.valueOf(top.getName());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 2734227875286695843L, 0, new Object[]{protoLogParam0});
        return;
    L15:
        return;
    }

    void setPipActivity(ActivityRecord pipActivity) {
        this.mPipActivity = pipActivity;
    }

    ActivityRecord getPipActivity() {
        return this.mPipActivity;
    }

    private void setTransientLaunchToChanges(WindowContainer wc) {
        WindowContainer curr = wc;
    L3:
        if (curr == null) goto L12;
        if (this.mChanges.containsKey(curr) == false) goto L18;
        if (curr.asTask() != null) goto L11;
        if (curr.asActivityRecord() != null) goto L11;
        return;
    L11:
        ChangeInfo info = this.mChanges.get(curr);
        info.mFlags |= 2;
        curr = curr.getParent();
        goto L3
    L18:
        return;
    }

    void setContainerFreezer(IContainerFreezer freezer) {
        this.mContainerFreezer = freezer;
    }

    int getState() {
        return this.mState;
    }

    int getSyncId() {
        return this.mSyncId;
    }

    int getFlags() {
        return this.mFlags;
    }

    SurfaceControl.Transaction getStartTransaction() {
        return this.mStartTransaction;
    }

    SurfaceControl.Transaction getFinishTransaction() {
        return this.mFinishTransaction;
    }

    boolean isPending() {
        if (this.mState != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isCollecting() {
        if (this.mState != 0) goto L5;
        return true;
    L5:
        if (this.mState == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean isAborted() {
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isStarted() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isPlaying() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isFinished() {
        if (this.mState != 4) goto L5;
        return true;
    L5:
        return false;
    }

    void startCollecting(long timeoutMs) {
        if (this.mState != (-1)) goto L10;
        boolean r0 = false;
        this.mState = 0;
        BLASTSyncEngine r1 = this.mSyncEngine;
        String r5 = "Transition-" + WindowManager.transitTypeToString(this.mType);
        if (this.mParallelCollectType == 0) goto L7;
        r0 = true;
    L7:
        this.mSyncId = r1.startSyncSet(this, timeoutMs, r5, r0);
        this.mSyncEngine.setSyncMethod(this.mSyncId, TransitionController.SYNC_METHOD);
        this.mLogger.mSyncId = this.mSyncId;
        this.mLogger.mCollectTimeNs = SystemClock.elapsedRealtimeNanos();
        return;
    L10:
        throw new IllegalStateException("Attempting to re-use a transition");
    }

    void start() {
        if (this.mState < 0) goto L26;
        if (this.mState < 1) goto L8;
        Slog.w(TAG, "Transition already started id=" + this.mSyncId + " state=" + this.mState);
        return;
    L8:
        this.mState = 1;
        if (this.mPerf == null) goto L14;
        if (this.mType != 6) goto L14;
        this.mPerf.perfHint(4240, null);
        this.mIsAnimationPerfLockAcquired = true;
    L14:
        if (this.mType != 2) goto L16;
    L19:
        SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquire(BoostHintType.VENDOR_HINT_APP_OUT_ANIMATION_BOOST);
    L21:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L23;
        long protoLogParam0 = this.mSyncId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 2808217645990556209L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L23:
        applyReady();
        this.mLogger.mStartTimeNs = SystemClock.elapsedRealtimeNanos();
        this.mController.updateAnimatingState();
        return;
    L16:
        if (this.mType == 4) goto L19;
        if (this.mType != 3) goto L21;
    L26:
        throw new IllegalStateException("Can't start Transition which isn't collecting.");
    }

    void collect(WindowContainer wc) {
        if (this.mState < 0) goto L29;
        if (isCollecting() == true) goto L8;
        return;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L10;
        long protoLogParam0 = this.mSyncId;
        String protoLogParam1 = String.valueOf(wc);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -4672522645315112127L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L10:
        snapshotStartState(getAnimatableParent(wc));
        if (this.mParticipants.contains(wc) == false) goto L14;
        return;
    L14:
        if (isInTransientHide(wc) == true) goto L17;
        this.mSyncEngine.addToSyncSet(this.mSyncId, wc);
    L17:
        if (wc.asWindowToken() != null) goto L19;
    L21:
        ChangeInfo info = this.mChanges.get(wc);
        if (info != null) goto L24;
        info = new ChangeInfo(wc);
        updateTransientFlags(info);
        this.mChanges.put(wc, info);
    L24:
        this.mParticipants.add(wc);
        recordDisplay(wc.getDisplayContent());
        if (info.mShowWallpaper == false) goto L30;
        wc.mDisplayContent.mWallpaperController.collectTopWallpapers(this);
        return;
    L30:
        return;
    L19:
        if (wc.asWindowToken().mRoundedCornerOverlay == false) goto L21;
        return;
    L29:
        throw new IllegalStateException("Transition hasn't started collecting.");
    }

    private void snapshotStartState(WindowContainer<?> wc) {
        WindowContainer<?> curr = wc;
    L3:
        if (curr == null) goto L12;
        if (this.mChanges.containsKey(curr) == true) goto L18;
        ChangeInfo info = new ChangeInfo(curr);
        updateTransientFlags(info);
        this.mChanges.put(curr, info);
        if (isReadyGroup(curr) == false) goto L11;
        this.mReadyTrackerOld.addGroup(curr);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L11;
        long protoLogParam0 = this.mSyncId;
        String protoLogParam1 = String.valueOf(curr);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 65881049096729394L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L11:
        curr = getAnimatableParent(curr);
        goto L3
    L18:
        return;
    }

    private void updateTransientFlags(ChangeInfo info) {
        WindowContainer<?> wc = info.mContainer;
        if (wc.asTaskFragment() != null) goto L8;
        if (wc.asActivityRecord() != null) goto L8;
        return;
    L8:
        if (isInTransientHide(wc) == true) goto L10;
        return;
    L10:
        info.mFlags |= 4;
    }

    private void recordDisplay(DisplayContent dc) {
        if (dc != null) goto L4;
        return;
    L4:
        if (this.mTargetDisplays.contains(dc) == true) goto L15;
        this.mTargetDisplays.add(dc);
        addOnTopTasks(dc, this.mOnTopTasksStart);
        if (this.mOnTopDisplayStart != null) goto L10;
        this.mOnTopDisplayStart = this.mController.mAtm.mRootWindowContainer.getTopFocusedDisplayContent();
    L10:
        if (this.mController.isAnimating() == false) goto L12;
        dc.enableHighPerfTransition(true);
    L12:
        this.mController.dispatchLegacyAppTransitionPending(dc.mDisplayId);
        return;
    }

    void recordTaskOrder(WindowContainer from) {
        recordDisplay(from.getDisplayContent());
    }

    private static void addOnTopTasks(Task task, ArrayList<Task> out) {
        int i = task.getChildCount() - 1;
    L3:
        if (i < 0) goto L15;
        Task child = task.getChildAt(i).asTask();
        if (child == null) goto L6;
        if (child.getWindowConfiguration().isAlwaysOnTop() == false) goto L10;
        i = i - 1;
        goto L3
    L10:
        out.add(child);
        addOnTopTasks(child, out);
        return;
    L6:
        return;
    }

    private static void addOnTopTasks(DisplayContent dc, ArrayList<Task> out) {
        Task topNotAlwaysOnTop = dc.getRootTask(new Transition$$ExternalSyntheticLambda4());
        if (topNotAlwaysOnTop != null) goto L5;
        return;
    L5:
        out.add(topNotAlwaysOnTop);
        addOnTopTasks(topNotAlwaysOnTop, out);
    }

    private static /* synthetic */ boolean lambda$addOnTopTasks$2(Task t) {
        return !t.getWindowConfiguration().isAlwaysOnTop();
    }

    void collectExistenceChange(WindowContainer wc) {
        if (this.mState < 2) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L8;
        long protoLogParam0 = this.mSyncId;
        String protoLogParam1 = String.valueOf(wc);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 1101215730201607371L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L8:
        collect(wc);
        this.mChanges.get(wc).mExistenceChanged = true;
    }

    void collectVisibleChange(WindowContainer wc) {
        if (this.mSyncEngine.getSyncSet(this.mSyncId).mSyncMethod != 1) goto L6;
        return;
    L6:
        if (wc.mDisplayContent != null) goto L8;
        return;
    L8:
        if (isInTransition(wc) == true) goto L11;
        return;
    L11:
        if (wc.mDisplayContent.getDisplayPolicy().isScreenOnFully() == true) goto L13;
    L37:
        this.mFlags |= 1024;
        return;
    L13:
        if (wc.mDisplayContent.getDisplayInfo().state == 1) goto L37;
        if (wc.asActivityRecord() == null) goto L23;
        ActivityRecord activityRecord = wc.asActivityRecord();
        if (activityRecord.mStartingData == null) goto L23;
        if (activityRecord.mStartingData.mAssociatedTask == null) goto L23;
        return;
    L23:
        if (this.mContainerFreezer != null) goto L25;
        this.mContainerFreezer = new ScreenshotFreezer(this, null);
    L25:
        ChangeInfo change = this.mChanges.get(wc);
        if (change != null) goto L28;
        return;
    L28:
        if (change.mVisible == true) goto L30;
        return;
    L30:
        if (wc.isVisibleRequested() == true) goto L32;
        return;
    L32:
        if (getExt().shouldSkipFreeze(wc) == true) goto L42;
        this.mContainerFreezer.freeze(wc, change.mAbsoluteBounds);
        return;
    }

    void collectReparentChange(WindowContainer wc, WindowContainer newParent) {
        if (this.mChanges.containsKey(wc) == true) goto L5;
        return;
    L5:
        ChangeInfo change = this.mChanges.get(wc);
        if (change.mStartParent != null) goto L8;
    L11:
        WindowContainer prevParent = change.mStartParent;
    L13:
        if (prevParent != null) goto L15;
    L31:
        Slog.w(TAG, "Trying to collect reparenting of a window after the previous parent has been detached: " + wc);
        return;
    L15:
        if (prevParent.isAttached() == false) goto L31;
        if (prevParent != newParent) goto L21;
        Slog.w(TAG, "Trying to collect reparenting of a window that has not been reparented: " + wc);
        return;
    L21:
        if (newParent.isAttached() == true) goto L24;
        Slog.w(TAG, "Trying to collect reparenting of a window that is not attached after reparenting: " + wc);
        return;
    L24:
        WindowContainer ancestor = newParent;
    L25:
        if (prevParent == ancestor) goto L29;
        if (prevParent.isDescendantOf(ancestor) == true) goto L29;
        ancestor = ancestor.getParent();
    L29:
        change.mCommonAncestor = ancestor;
        return;
    L8:
        if (change.mStartParent.isAttached() == true) goto L11;
        prevParent = change.mCommonAncestor;
        goto L13
    }

    void collectClose(WindowContainer<?> wc) {
        if (wc.isVisibleRequested() == false) goto L5;
        collectExistenceChange(wc);
        return;
    L5:
        collect(wc);
    }

    boolean isInTransition(WindowContainer wc) {
        WindowContainer p = wc;
    L3:
        if (p == null) goto L9;
        if (this.mParticipants.contains(p) == true) goto L6;
        p = p.getParent();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    boolean isInAodAppearTransition() {
        if ((this.mFlags & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void setKnownConfigChanges(WindowContainer<?> wc, int changes) {
        ChangeInfo changeInfo = this.mChanges.get(wc);
        if (changeInfo == null) goto L6;
        changeInfo.mKnownConfigChanges = changes;
        return;
    }

    private void sendRemoteCallback(IRemoteCallback callback) {
        if (callback != null) goto L4;
        return;
    L4:
        this.mController.mAtm.mH.sendMessage(PooledLambda.obtainMessage(new Transition$$ExternalSyntheticLambda12(), callback));
    }

    private static /* synthetic */ void lambda$sendRemoteCallback$3(IRemoteCallback cb) {
        cb.sendResult(null);     // Catch: RemoteException -> L5
        return;
    }

    void setOverrideAnimation(android.window.TransitionInfo.AnimationOptions options, ActivityRecord r, IRemoteCallback startCallback, IRemoteCallback finishCallback) {
        if (isCollecting() == true) goto L5;
        return;
    L5:
        this.mOverrideOptions = options;
        if (this.mOverrideOptions == null) goto L8;
        this.mOverrideOptions.setUserId(r.mUserId);
    L8:
        sendRemoteCallback(this.mClientAnimationStartCallback);
        this.mClientAnimationStartCallback = startCallback;
        this.mClientAnimationFinishCallback = finishCallback;
    }

    void setOverrideBackgroundColor(int backgroundColor) {
        this.mOverrideBackgroundColor = backgroundColor;
    }

    void setReady(WindowContainer wc, boolean ready) {
        if (isCollecting() == true) goto L5;
        return;
    L5:
        if (this.mSyncId < 0) goto L16;
        if (ready == false) goto L9;
    L13:
        this.mReadyTrackerOld.setReadyFrom(wc, ready);
        applyReady();
        return;
    L9:
        if (this.mParallelCollectType != 2) goto L13;
        if (this.mParticipants.contains(wc) == false) goto L13;
        Slog.d(TAG, "resetAllReady for wc: " + wc);
        this.mReadyTrackerOld.resetAllReady();
        goto L13
    }

    private void applyReady() {
        if (this.mState >= 1) goto L6;
        return;
    L6:
        if (this.mController.useFullReadyTracking() == false) goto L8;
        boolean ready = this.mReadyTracker.isReady();
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L12;
        boolean protoLogParam0 = ready;
        long protoLogParam1 = this.mSyncId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -3942072270654590479L, 7, new Object[]{Boolean.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});
    L12:
        getExt().traceSetTransitionReady(ready, this.mSyncId);
        boolean changed = this.mSyncEngine.setReady(this.mSyncId, ready);
        if (changed == false) goto L22;
        if (ready == false) goto L23;
        this.mLogger.mReadyTimeNs = SystemClock.elapsedRealtimeNanos();
        this.mOnTopTasksAtReady.clear();
        int i = 0;
    L17:
        if (i >= this.mTargetDisplays.size()) goto L19;
        addOnTopTasks(this.mTargetDisplays.get(i), this.mOnTopTasksAtReady);
        i = i + 1;
        goto L17
    L19:
        this.mOnTopDisplayAtReady = this.mController.mAtm.mRootWindowContainer.getTopFocusedDisplayContent();
        this.mController.onTransitionPopulated(this);
        return;
    L23:
        return;
    L22:
        return;
    L8:
        ready = this.mReadyTrackerOld.allReady();
        goto L10
    }

    void setAllReady() {
        if (isCollecting() == true) goto L5;
        return;
    L5:
        if (this.mSyncId < 0) goto L10;
        this.mReadyTrackerOld.setAllReady();
        applyReady();
        return;
    }

    boolean allReady() {
        return this.mReadyTrackerOld.allReady();
    }

    boolean isPopulated() {
        if (this.mState >= 1) goto L5;
    L7:
        return false;
    L5:
        if (this.mReadyTrackerOld.allReady() == false) goto L7;
        return true;
    }

    private void resetSurfaceTransform(SurfaceControl.Transaction t, WindowContainer target, SurfaceControl targetLeash) {
        Point tmpPos = new Point();
        target.getRelativePosition(tmpPos);
        t.setPosition(targetLeash, tmpPos.x, tmpPos.y);
        if (target.asTaskFragment() != null) goto L5;
        t.setCrop(targetLeash, null);
    L6:
        t.setMatrix(targetLeash, 1.0f, 0.0f, 0.0f, 1.0f);
        if (Features.FEAT_QUICK_WIN == false) goto L14;
        if (target.asTask() == null) goto L14;
        if (target.inFreeformWindowingMode() == false) goto L14;
        float scale = target.asTask().getExt().getScale();
        t.setMatrix(targetLeash, scale, 0.0f, 0.0f, scale);
        t.setCornerRadius(targetLeash, target.asTask().getExt().getCornerRadius());
    L14:
        if (target.isOrganized() == true) goto L16;
        return;
    L16:
        if (target.matchParentBounds() == false) goto L20;
        t.setWindowCrop(targetLeash, -1, -1);
        return;
    L20:
        return;
    L5:
        Rect clipRect = target.getResolvedOverrideBounds();
        t.setWindowCrop(targetLeash, clipRect.width(), clipRect.height());
        goto L6
    }

    private void buildFinishTransaction(SurfaceControl.Transaction t, android.window.TransitionInfo info, DisplayContent[] participantDisplays) {
        int i = this.mTargets.size();
    L3:
        i = i - 1;
        if (i < 0) goto L15;
        WindowContainer<?> target = this.mTargets.get(i).mContainer;
        if (target.getParent() == null) goto L3;
        SurfaceControl targetLeash = getLeashSurface(target, null);
        SurfaceControl origParent = getOrigParentSurface(target);
        t.reparent(targetLeash, origParent);
        t.setLayer(targetLeash, target.getLastLayer());
        t.setCornerRadius(targetLeash, 0.0f);
        t.setShadowRadius(targetLeash, 0.0f);
        t.setAlpha(targetLeash, 1.0f);
        if (target.asActivityRecord() != null) goto L11;
    L12:
        resetSurfaceTransform(t, target, targetLeash);
        goto L3
    L11:
        if ((this.mTargets.get(i).mFlags & 64) != 0) goto L3;
    L15:
        if (this.mContainerFreezer == null) goto L17;
        this.mContainerFreezer.cleanUp(t);
    L17:
        int i2 = participantDisplays.length - 1;
    L18:
        if (i2 < 0) goto L20;
        assignLayers(participantDisplays[i2], t);
        i2 = i2 - 1;
        goto L18
    L20:
        int i3 = 0;
    L22:
        if (i3 >= info.getRootCount()) goto L25;
        t.reparent(info.getRoot(i3).getLeash(), null);
        i3 = i3 + 1;
        goto L22
    }

    static void assignLayers(WindowContainer<?> wc, SurfaceControl.Transaction t) {
        wc.mTransitionController.mBuildingFinishLayers = true;
        wc.assignChildLayers(t);     // Catch: Throwable -> L6
        wc.mTransitionController.mBuildingFinishLayers = false;
        return;
    L6:
        th = move-exception;
        wc.mTransitionController.mBuildingFinishLayers = false;
        throw th;
    }

    private static void buildCleanupTransaction(SurfaceControl.Transaction t, android.window.TransitionInfo info) {
        int i = info.getChanges().size();
    L3:
        i = i - 1;
        if (i < 0) goto L16;
        android.window.TransitionInfo.Change c = (android.window.TransitionInfo.Change) info.getChanges().get(i);
        if (c.getSnapshot() == null) goto L9;
        t.reparent(c.getSnapshot(), null);
    L9:
        if (c.hasFlags(32) == false) goto L3;
        if (c.getStartRotation() == c.getEndRotation()) goto L3;
        if (c.getContainer() == null) goto L3;
        t.unsetFixedTransformHint(WindowContainer.fromBinder(c.getContainer().asBinder()).asDisplayContent().mSurfaceControl);
        goto L3
    L16:
        int i2 = info.getRootCount();
        int i3 = i2 - 1;
    L17:
        if (i3 < 0) goto L24;
        SurfaceControl leash = info.getRoot(i3).getLeash();
        if (leash == null) goto L22;
        t.reparent(leash, null);
    L22:
        i3 = i3 - 1;
        goto L17
    }

    void setCanPipOnFinish(boolean canPipOnFinish) {
        this.mCanPipOnFinish = canPipOnFinish;
    }

    private boolean didCommitTransientLaunch() {
        if (this.mTransientLaunches != null) goto L5;
        return false;
    L5:
        int j = 0;
    L7:
        if (j >= this.mTransientLaunches.size()) goto L14;
        if (this.mTransientLaunches.keyAt(j).isVisibleRequested() == true) goto L10;
        j = j + 1;
        goto L7
    L10:
        return true;
    L14:
        return false;
    }

    private boolean checkEnterPipOnFinish(ActivityRecord ar) {
        if (this.mCanPipOnFinish == true) goto L5;
    L46:
        return false;
    L5:
        if (ar.isVisible() == false) goto L46;
        if (ar.getTask() == null) goto L46;
        if (ar.isState(ActivityRecord.State.RESUMED) == false) goto L46;
        ActivityRecord resuming = getVisibleTransientLaunch(ar.getTaskDisplayArea());
        if (ar.pictureInPictureArgs == null) goto L34;
        if (ar.pictureInPictureArgs.isAutoEnterEnabled() == false) goto L34;
        if (ar.getTask().isVisibleRequested() == true) goto L18;
    L19:
        ar.supportsEnterPipOnTaskSwitch = true;
    L21:
        if (ar.checkEnterPictureInPictureState("enterPictureInPictureMode", true) == true) goto L23;
        return false;
    L23:
        int prevMode = ar.getTask().getWindowingMode();
        boolean inPip = this.mController.mAtm.enterPictureInPictureMode(ar, ar.pictureInPictureArgs, false, true);
        int currentMode = ar.getTask().getWindowingMode();
        if (prevMode == 1) goto L26;
    L32:
        return inPip;
    L26:
        if (currentMode != 2) goto L32;
        if (this.mTransientLaunches == null) goto L32;
        if (ar.mDisplayContent.hasTopFixedRotationLaunchingApp() == false) goto L32;
        ar.mDisplayContent.mPinnedTaskController.setEnterPipWithRotatedTransientLaunch();
        goto L32
    L18:
        if (didCommitTransientLaunch() == false) goto L21;
    L34:
        if (ar.getTask().isVisibleRequested() == false) goto L38;
        if (didCommitTransientLaunch() == true) goto L38;
    L47:
        this.mController.mAtm.mTaskSupervisor.mUserLeaving = true;     // Catch: Throwable -> L43
        ar.getTaskFragment().startPausing(false, resuming, "finishTransition");     // Catch: Throwable -> L43
        this.mController.mAtm.mTaskSupervisor.mUserLeaving = false;
        return false;
    L43:
        th = move-exception;
        this.mController.mAtm.mTaskSupervisor.mUserLeaving = false;
        throw th;
    L38:
        if (ar.supportsPictureInPicture() == false) goto L47;
        ar.supportsEnterPipOnTaskSwitch = true;
        goto L47
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void finishTransition(ActionChain r30) {
        if (Trace.isTagEnabled(32) == false) goto L8;
        if (this.mIsPlayerEnabled == false) goto L8;
        asyncTraceEnd(System.identityHashCode(this));
    L8:
        if (r30.isFinishing() == false) goto L292;
        this.mLogger.mFinishTimeNs = SystemClock.elapsedRealtimeNanos();
        Handler r1 = this.mController.mLoggerHandler;
        final TransitionController.Logger r2 = this.mLogger;
        r2.getClass();
        r1.post(new Transition$$ExternalSyntheticLambda13(r2));
        this.mController.mTransitionTracer.logFinishedTransition(this);
        getExt().traceTransitionFinish(this.mLogger.buildOnFinishLog());
        getExt().finishTransition(this.mCleanupTransaction);
        if (this.mStartTransaction == null) goto L13;
        this.mStartTransaction.close();
    L13:
        if (this.mFinishTransaction == null) goto L15;
        this.mFinishTransaction.close();
    L15:
        this.mFinishTransaction = null;
        this.mStartTransaction = null;
        if (this.mCleanupTransaction == null) goto L19;
        this.mCleanupTransaction.apply();
        this.mCleanupTransaction = null;
    L19:
        if (this.mState < 2) goto L290;
        this.mController.mFinishingTransition = this;
        int r4 = 0;
        int r5 = 1;
        if (this.mTransientHideTasks != null) goto L23;
    L25:
        boolean r3 = false;
    L27:
        if (this.mTransientHideTasks != null) goto L29;
    L40:
        int r6 = 0;
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
        int r10 = 0;
    L42:
        if (r10 >= this.mParticipants.size()) goto L140;
        WindowContainer r11 = this.mParticipants.valueAt(r10);
        ActivityRecord r13 = r11.asActivityRecord();
        if (r13 == null) goto L125;
        Task r14 = r13.getTask();
        if (r14 != null) goto L48;
        r3 = r3;
    L139:
        r10 = r10 + 1;
        r3 = r3;
        r4 = 0;
        r5 = 1;
        goto L42
    L48:
        boolean r15 = this.mVisibleAtTransitionEndTokens.contains(r13);
        if (isTransientLaunch(r13) == false) goto L56;
        if (r13.isVisibleRequested() == true) goto L56;
        if (this.mController.inTransition(r13) == false) goto L56;
        Slog.w(TAG, "skip commit invisible on transient launch: " + r13);
        r15 = true;
    L56:
        if (this.mExt.skipCommitInvisibleWhenFinish(r11) == false) goto L59;
        r15 = true;
    L59:
        if (r13.mDisplayContent != null) goto L61;
    L64:
        int r12 = r5;
    L66:
        if (r15 == false) goto L71;
        if (r12 != 0) goto L71;
        r3 = r3;
    L97:
        if (r13.mStartingData != null) goto L99;
    L105:
        ChangeInfo r16 = this.mChanges.get(r13);
        if (r16 == null) goto L111;
        if (r16.mVisible == r15) goto L111;
        r13.mEnteringAnimation = r15;
    L111:
        if (this.mTransientLaunches == null) goto L139;
        if (this.mTransientLaunches.containsKey(r13) == false) goto L139;
        if (r13.isVisible() == false) goto L139;
        r13.mEnteringAnimation = true;
        if (r14.isFocused() == true) goto L122;
        if (r13.isTopRunningActivity() == false) goto L122;
        this.mController.mAtm.setLastResumedActivityUncheckLocked(r13, "transitionFinished");
    L122:
        if (r13.mDisplayContent.mFocusedApp != r13) goto L124;
        this.mController.mAtm.stopAppSwitches();
    L124:
        r7 = true;
        goto L139
    L99:
        if (r13.mStartingData.mRemoveAfterTransaction != 3) goto L105;
        if (r13.isVisible() == true) goto L103;
    L104:
        r13.mStartingData.mRemoveAfterTransaction = 0;
        r13.removeStartingWindow();
        goto L105
    L103:
        if (r13.mTransitionController.inTransition(r13) == true) goto L105;
    L71:
        if (r13.isVisibleRequested() == false) goto L73;
        r3 = r3;
        goto L97
    L73:
        if (((checkEnterPipOnFinish(r13) ? 1 : 0) ^ r5) != 0) goto L75;
        r3 = r3;
        r8 = true;
        goto L97
    L75:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[r5] == false) goto L78;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -4688704756793656554L, r4, new Object[]{String.valueOf(r13)});
    L78:
        SnapshotController r17 = this.mController.mSnapshotController;
        if (this.mTransientLaunches != null) goto L81;
    L92:
        boolean r18 = r5;
    L93:
        r13.commitVisibility(false, false, r18);
        r9 = true;
        goto L97
    L81:
        if (r14.isVisibleRequested() == true) goto L92;
        if (r14.isActivityTypeHome() == false) goto L85;
        r18 = r5;
        goto L93
    L85:
        if (r17.mTaskSnapshotController.getSnapshotCaptureTime(r14.mTaskId) >= this.mLogger.mSendTimeNs) goto L88;
        r17.mTaskSnapshotController.recordSnapshot(r14);
        r18 = r5;
        goto L93
    L88:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[r5] == false) goto L90;
        long r19 = r14.mTaskId;
        WmProtoLogGroups r110 = WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS;
        Object[] r20 = {Long.valueOf(r19)};
        int r21 = r5;
        ProtoLogImpl_798997914.v(r110, 1817207111271920503L, r21 == true ? 1 : 0, r20);
        r18 = r21;
        goto L93
    L90:
        r18 = r5;
        goto L93
    L61:
        if (r13.mDisplayContent.getDisplayInfo().state == r5) goto L64;
        r12 = r4;
        goto L66
    L125:
        r3 = r3;
        if (r11.asDisplayContent() == null) goto L128;
        r6 = 1;
        goto L139
    L128:
        final Task r22 = r11.asTask();
        if (r22 == null) goto L139;
        if (r22.isVisibleRequested() == false) goto L139;
        if (r22.inPinnedWindowingMode() == false) goto L139;
        ActivityRecord r23 = r22.getTopNonFinishingActivity();
        if (r23 == null) goto L139;
        if (r23.inPinnedWindowingMode() == true) goto L139;
        this.mController.mStateValidators.add(new Transition$$ExternalSyntheticLambda15(r22));
        goto L139
    L140:
        boolean r111 = r3;
        int r24 = this.mParticipants.size() - 1;
    L141:
        if (r24 < 0) goto L175;
        WallpaperWindowToken r25 = this.mParticipants.valueAt(r24).asWallpaperToken();
        if (r25 != null) goto L145;
        r24 = r24;
    L173:
        r24 = r24 - 1;
        goto L141
    L145:
        if (r25.isVisible() == true) goto L147;
        r24 = r24;
        goto L173
    L147:
        WindowState r26 = r25.mDisplayContent.mWallpaperController.getWallpaperTarget();
        if (r26 != null) goto L150;
    L153:
        boolean r112 = true;
    L155:
        if (r25.isVisibleRequested() == false) goto L157;
    L160:
        boolean r113 = true;
    L161:
        if (r112 == true) goto L166;
        if (r113 == false) goto L166;
        r24 = r24;
    L170:
        if (r112 == false) goto L173;
        r25.mDisplayContent.pendingLayoutChanges |= 4;
    L166:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L168;
        boolean r27 = false;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -2960171012238790176L, 0, new Object[]{String.valueOf(r25)});
    L169:
        r25.commitVisibility(r27);
        goto L170
    L168:
        r27 = false;
        goto L169
    L157:
        if (this.mVisibleAtTransitionEndTokens.contains(r25) == true) goto L160;
        r113 = false;
        goto L161
    L150:
        if (r26.mToken.isVisible() == false) goto L153;
        r112 = false;
        goto L155
    L175:
        if (r9 == false) goto L178;
        this.mController.onCommittedInvisibles();
    L178:
        if ((this.mFlags & 128) != 0) goto L180;
    L182:
        boolean r28 = false;
    L183:
        if (r28 == false) goto L186;
        if (r111 == false) goto L186;
        boolean r29 = true;
    L187:
        if (r7 == true) goto L189;
        if (r29 == true) goto L189;
    L194:
        commitConfigAtEndActivities();
        int r31 = 0;
    L196:
        if (r31 >= this.mParticipants.size()) goto L217;
        ActivityRecord r32 = this.mParticipants.valueAt(r31).asActivityRecord();
        if (r32 != null) goto L201;
    L216:
        r31 = r31 + 1;
        goto L196
    L201:
        if (r32.isVisibleRequested() == true) goto L207;
        if (r32.isState(ActivityRecord.State.INITIALIZING) == false) goto L207;
    L210:
        if (r32.currentLaunchCanTurnScreenOn() == false) goto L216;
        if (r32.getDisplayContent() == null) goto L216;
        if (r32.getDisplayContent().topRunningActivity() == r32) goto L216;
        r32.setCurrentLaunchCanTurnScreenOn(false);
    L207:
        if (r32.isAnimating(2, 256) == true) goto L210;
        this.mController.dispatchLegacyAppTransitionFinished(r32);
        goto L210
    L217:
        int r33 = 0;
        int r34 = 0;
    L219:
        if (r34 >= this.mParticipants.size()) goto L229;
        ActivityRecord r35 = this.mParticipants.valueAt(r34).asActivityRecord();
        if (r35 == null) goto L228;
        if (r35.isVisible() == false) goto L228;
        if (r35.getParent() == null) goto L228;
        r33 = 1;
        r35.mActivityRecordInputSink.applyChangesToSurfaceIfChanged(r35.getPendingTransaction());
    L228:
        r34 = r34 + 1;
        goto L219
    L229:
        getExt().handleSeamlessRotation();
        if (r33 == 0) goto L232;
        this.mController.mAtm.mWindowManager.scheduleAnimationLocked();
    L232:
        this.mController.mAtm.mTaskSupervisor.scheduleProcessStoppingAndFinishingActivitiesIfNeeded();
        sendRemoteCallback(this.mClientAnimationFinishCallback);
        legacyRestoreNavigationBarFromApp();
        if (this.mRecentsDisplayId == (-1)) goto L236;
        DisplayContent r36 = this.mController.mAtm.mRootWindowContainer.getDisplayContent(this.mRecentsDisplayId);
        r36.getInputMonitor().setActiveRecents(null, null);
        r36.getInputMonitor().updateInputWindowsLw(false);
    L236:
        if (this.mTransientLaunches == null) goto L244;
        int r37 = this.mTransientLaunches.size() - 1;
    L238:
        if (r37 < 0) goto L244;
        Task r38 = this.mTransientLaunches.keyAt(r37).getTask();
        if (r38 == null) goto L243;
        r38.setCanAffectSystemUiFlags(true);
    L243:
        r37 = r37 - 1;
    L244:
        int r39 = 0;
    L246:
        if (r39 >= this.mTargetDisplays.size()) goto L278;
        DisplayContent r40 = this.mTargetDisplays.get(r39);
        AsyncRotationController r114 = r40.getAsyncRotationController();
        if (r114 != null) goto L250;
    L252:
        r40.onTransitionFinished();
        if (r6 == 0) goto L260;
        ChangeInfo r115 = this.mChanges.get(r40);
        if (r115 == null) goto L260;
        if (r115.mRotation == r40.getWindowConfiguration().getRotation()) goto L260;
        r40.mAppCompatCameraPolicy.onScreenRotationAnimationFinished();
    L260:
        if (this.mTransientLaunches == null) goto L277;
        TaskDisplayArea r116 = null;
        int r117 = 0;
    L263:
        if (r117 >= this.mTransientLaunches.size()) goto L270;
        if (this.mTransientLaunches.keyAt(r117).getDisplayContent() == r40) goto L266;
        r117 = r117 + 1;
        goto L263
    L266:
        if (r7 == false) goto L268;
        updateImeForVisibleTransientLaunch(r40);
    L268:
        r116 = this.mTransientLaunches.keyAt(r39).getTaskDisplayArea();
    L270:
        if (r7 == false) goto L272;
    L274:
        if (r7 == true) goto L277;
        if (r116 == null) goto L277;
        r116.pauseBackTasks(null);
        goto L277
    L272:
        if (this.mRecentsDisplayId != r40.mDisplayId) goto L274;
        InputMethodManagerInternal.get().updateImeWindowStatus(false, r40.getDisplayId());
    L277:
        r40.removeImeSurfaceImmediately();
        r40.handleCompleteDeferredRemoval();
        r39 = r39 + 1;
        goto L246
    L250:
        if (containsChangeFor(r40, this.mTargets) == false) goto L252;
        r114.onTransitionFinished();
        goto L252
    L278:
        validateKeyguardOcclusion();
        this.mController.getExt().initValidateWC(this);
        this.mState = 4;
        if (this.mPerf != null) goto L281;
    L283:
        if (r6 != 0) goto L285;
    L287:
        cleanUpInternal();
        this.mController.mAtm.mBackNavigationController.onTransitionFinish(this);
        this.mController.mFinishingTransition = null;
        this.mController.mSnapshotController.onTransitionFinish(this.mType, this.mTargets);
        this.mController.updateAnimatingState();
        invokeTransitionEndedListeners();
        getExt().finishTransition(this.mController);
        return;
    L285:
        if (this.mController.useShellTransitionsRotation() == true) goto L287;
        this.mController.mAtm.mWindowManager.updateRotation(false, false);
        goto L287
    L281:
        if (this.mIsAnimationPerfLockAcquired == false) goto L283;
        this.mPerf.perfLockRelease();
        this.mIsAnimationPerfLockAcquired = false;
    L189:
        if (r8 == false) goto L191;
        this.mController.mAtm.getTaskChangeNotificationController().notifyTaskStackChanged();
    L191:
        this.mController.mAtm.mRootWindowContainer.rankTaskLayers();
        if (r29 == false) goto L194;
        Slog.d(TAG, "keyguard recents finish and all transient hide tasks invisible");
        this.mController.mAtm.stopAppSwitches();
    L186:
        r29 = false;
        goto L187
    L180:
        if ((this.mFlags & 64) == 0) goto L182;
        r28 = true;
        goto L183
    L29:
        if (this.mTransientHideTasks.isEmpty() == true) goto L40;
        this.mController.mAtm.mRootWindowContainer.ensureActivitiesVisible();
        if ((this.mFlags & 128) == 0) goto L33;
        this.mExt.setTransientHideTaskInsetsFrozen(this.mTransientHideTasks, false);
    L33:
        int r41 = 0;
    L35:
        if (r41 >= this.mTransientHideTasks.size()) goto L40;
        final Task r42 = this.mTransientHideTasks.get(r41);
        if (r42.isVisibleRequested() == false) goto L39;
        r3 = false;
    L39:
        r42.forAllActivities(new Transition$$ExternalSyntheticLambda14(this, r42));
        r41 = r41 + 1;
        goto L35
    L23:
        if (this.mTransientHideTasks.isEmpty() == true) goto L25;
        r3 = true;
        goto L27
    L290:
        throw new IllegalStateException("Can't finish a non-playing transition " + this.mSyncId);
    L292:
        throw new IllegalStateException("Can't finish on a non-finishing transition " + r30.mTransition);
    }

    private /* synthetic */ void lambda$finishTransition$4(Task rootTask, ActivityRecord r) {
        if (this.mParticipants.contains(r.getTask()) == true) goto L6;
        return;
    L6:
        if (rootTask.isVisibleRequested() == true) goto L8;
        this.mParticipants.add(r);
        return;
    L8:
        if (r.isVisibleRequested() == true) goto L10;
        this.mController.mValidateCommitVis.add(r);
        return;
    L10:
        this.mParticipants.add(r);
    }

    private static /* synthetic */ void lambda$finishTransition$5(Task tr) {
        if (tr.isAttached() == true) goto L5;
        return;
    L5:
        if (tr.isVisibleRequested() == true) goto L7;
        return;
    L7:
        if (tr.inPinnedWindowingMode() == false) goto L19;
        ActivityRecord currTop = tr.getTopNonFinishingActivity();
        if (currTop != null) goto L13;
        return;
    L13:
        if (currTop.inPinnedWindowingMode() == false) goto L15;
        return;
    L15:
        Slog.e(TAG, "Enter-PIP was started but not completed, this is a Shell/SysUI bug. This state breaks gesture-nav, so attempting clean-up.");
        tr.abortPipEnter(currTop);
        return;
    }

    private void invokeTransitionEndedListeners() {
        if (this.mTransitionEndedListeners != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mTransitionEndedListeners.size()) goto L9;
        this.mTransitionEndedListeners.get(i).run();
        i = i + 1;
        goto L7
    L9:
        this.mTransitionEndedListeners = null;
    }

    private void commitConfigAtEndActivities() {
        if (this.mConfigAtEndActivities != null) goto L5;
        return;
    L5:
        if (this.mConfigAtEndActivities.isEmpty() == true) goto L33;
        int syncId = -1;
        int i = 0;
    L9:
        if (i >= this.mConfigAtEndActivities.size()) goto L25;
        ActivityRecord target = this.mConfigAtEndActivities.get(i);
        SurfaceControl targetLeash = target.getSurfaceControl();
        if (targetLeash != null) goto L14;
        target.resumeConfigurationDispatch();
    L23:
        i = i + 1;
        goto L9
    L14:
        if (target.getSyncGroup() != null) goto L16;
    L19:
        if (syncId >= 0) goto L21;
        BLASTSyncEngine.SyncGroup sg = this.mSyncEngine.prepareSyncSet(new Transition$$ExternalSyntheticLambda7(), "ConfigAtTransitEnd");
        syncId = sg.mSyncId;
        this.mSyncEngine.startSyncSet(sg, 5000, true);
        this.mSyncEngine.setSyncMethod(syncId, 1);
    L21:
        this.mSyncEngine.addToSyncSet(syncId, target);
    L22:
        resetSurfaceTransform(target.getSyncTransaction(), target, targetLeash);
        target.resumeConfigurationDispatch();
        goto L23
    L16:
        if (target.getSyncGroup().isIgnoring(target) == true) goto L19;
        target.forAllWindows(new Transition$$ExternalSyntheticLambda8(), true);
        goto L22
    L25:
        if (syncId < 0) goto L32;
        this.mSyncEngine.setReady(syncId);
        return;
    L32:
        return;
    }

    private static /* synthetic */ void lambda$commitConfigAtEndActivities$6(int mSyncId, SurfaceControl.Transaction transaction) {
        transaction.apply();
    }

    private static /* synthetic */ void lambda$commitConfigAtEndActivities$7(WindowState windowState) {
        windowState.mSyncMethodOverride = 1;
    }

    private ActivityRecord getVisibleTransientLaunch(TaskDisplayArea taskDisplayArea) {
        if (this.mTransientLaunches != null) goto L5;
        return null;
    L5:
        int i = this.mTransientLaunches.size() - 1;
    L6:
        if (i < 0) goto L15;
        ActivityRecord candidateActivity = this.mTransientLaunches.keyAt(i);
        if (candidateActivity.getTaskDisplayArea() != taskDisplayArea) goto L12;
        if (candidateActivity.isVisibleRequested() == false) goto L12;
        return candidateActivity;
    L12:
        i = i - 1;
        goto L6
    L15:
        return null;
    }

    private void updateImeForVisibleTransientLaunch(DisplayContent dc) {
        WindowState imeTarget = dc.computeImeTarget(true);
        WindowState imeWindow = dc.mInputMethodWindow;
        if (imeWindow == null) goto L27;
        if (imeTarget != null) goto L6;
        return;
    L6:
        if (this.mController.hasCollectingRotationChange(dc, dc.getRotation()) == false) goto L36;
        InsetsSourceProvider sourceProvider = imeWindow.getControllableInsetProvider();
        if (sourceProvider != null) goto L11;
        return;
    L11:
        if (sourceProvider.mControl != null) goto L13;
        return;
    L13:
        if (sourceProvider.isClientVisible() == true) goto L15;
        return;
    L15:
        if (imeTarget == sourceProvider.getControlTarget()) goto L34;
        SurfaceControl imeInsetsLeash = sourceProvider.mControl.getLeash();
        InsetsControlTarget controlTarget = sourceProvider.getControlTarget();
        if (imeInsetsLeash == null) goto L28;
        if (controlTarget != null) goto L21;
        return;
    L21:
        if (controlTarget.getWindow() != null) goto L23;
        return;
    L23:
        if (controlTarget.getWindow().mToken.isVisible() == true) goto L31;
        dc.getSyncTransaction().reparent(imeInsetsLeash, null);
        return;
    L31:
        return;
    L28:
        return;
    L34:
        return;
    L36:
        return;
    }

    void abort() {
        if (this.mState != 3) goto L5;
        return;
    L5:
        getExt().traceAbort(this, this.mState, isCollecting(), this.mController.mCollectingTransition);
        if (this.mState != (-1)) goto L10;
        this.mState = 3;
        return;
    L10:
        if (this.mState == 0) goto L17;
        if (this.mState == 1) goto L17;
        throw new IllegalStateException("Too late to abort. state=" + this.mState);
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L19;
        long protoLogParam0 = this.mSyncId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 1230784960534033968L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L19:
        this.mState = 3;
        this.mLogger.mAbortTimeNs = SystemClock.elapsedRealtimeNanos();
        this.mController.mTransitionTracer.logAbortedTransition(this);
        this.mSyncEngine.abort(this.mSyncId);
        this.mController.dispatchLegacyAppTransitionCancelled(this.mTargetDisplays);
        invokeTransitionEndedListeners();
    }

    void playNow() {
        if (this.mState == 0) goto L8;
        if (this.mState == 1) goto L8;
        return;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L10;
        long protoLogParam0 = this.mSyncId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -892865733969888022L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L10:
        this.mForcePlaying = true;
        int i = this.mReadyTracker.mConditions.size() - 1;
    L11:
        if (i < 0) goto L13;
        this.mReadyTracker.mConditions.get(i).meetAlternate("play-now");
        i = i - 1;
        goto L11
    L13:
        ReadyCondition forcePlay = new ReadyCondition("force-play-now");
        this.mReadyTracker.add(forcePlay);
        forcePlay.meet();
        setAllReady();
        if (this.mState != 0) goto L16;
        start();
    L16:
        this.mSyncEngine.onSurfacePlacement();
    }

    boolean isForcePlaying() {
        return this.mForcePlaying;
    }

    void setRemoteAnimationApp(IApplicationThread app) {
        WindowProcessController wpc = this.mController.mAtm.getProcessController(app);
        if (wpc == null) goto L6;
        this.mController.mRemotePlayer.update(wpc, true, true);
        return;
    }

    void setNoAnimation(WindowContainer wc) {
        ChangeInfo change = this.mChanges.get(wc);
        if (change == null) goto L7;
        change.mFlags |= 8;
        return;
    L7:
        throw new IllegalStateException("Can't set no-animation property of non-participant");
    }

    static boolean containsChangeFor(WindowContainer wc, ArrayList<ChangeInfo> list) {
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (list.get(i).mContainer == wc) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    @Override // com.android.server.wm.BLASTSyncEngine.TransactionReadyListener
    public void onTransactionReady(int syncId, SurfaceControl.Transaction transaction) {
        if (syncId == this.mSyncId) goto L6;
        Slog.e(TAG, "Unexpected Sync ID " + syncId + ". Expected " + this.mSyncId);
        return;
    L6:
        getExt().markSyncFinished(syncId, transaction);
        if (this.mController.useFullReadyTracking() == false) goto L15;
        int i = 0;
    L10:
        if (i >= this.mReadyTracker.mMet.size()) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L14;
        long protoLogParam0 = this.mSyncId;
        String protoLogParam1 = String.valueOf(this.mReadyTracker.mMet.get(i));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -1354622424895965634L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L14:
        i = i + 1;
    L15:
        getExt().traceStartTrace(transaction, "onTransactionReady");
        commitVisibleActivities(transaction);
        commitVisibleWallpapers(transaction);
        if (this.mTransactionCompletedListeners == null) goto L23;
        int i2 = 0;
    L19:
        if (i2 >= this.mTransactionCompletedListeners.size()) goto L21;
        final Runnable listener = this.mTransactionCompletedListeners.get(i2);
        transaction.addTransactionCompletedListener(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new Transition$$ExternalSyntheticLambda17(listener));
        i2 = i2 + 1;
        goto L19
    L21:
        this.mTransactionCompletedListeners = null;
    L23:
        if (this.mTargetDisplays.isEmpty() == true) goto L25;
        DisplayContent r0 = this.mTargetDisplays.get(0);
    L26:
        DisplayContent primaryDisplay = r0;
        if (this.mState != 3) goto L38;
        this.mController.onAbort(this);
        if (this.mConfigAtEndActivities == null) goto L35;
        int i3 = 0;
    L32:
        if (i3 >= this.mConfigAtEndActivities.size()) goto L34;
        this.mConfigAtEndActivities.get(i3).resumeConfigurationDispatch();
        i3 = i3 + 1;
        goto L32
    L34:
        this.mConfigAtEndActivities = null;
    L35:
        primaryDisplay.getPendingTransaction().merge(transaction);
        this.mSyncId = -1;
        this.mOverrideOptions = null;
        cleanUpInternal();
        getExt().traceEndTrace(transaction);
        return;
    L38:
        if (this.mState == 1) goto L40;
        Slog.e(TAG, "Playing a Transition which hasn't started! #" + this.mSyncId + " This will likely cause an exception in Shell");
    L40:
        this.mState = 2;
        this.mStartTransaction = transaction;
        this.mFinishTransaction = this.mController.mAtm.mWindowManager.mTransactionFactory.get();
        if (primaryDisplay.isKeyguardLocked() == false) goto L43;
        this.mFlags |= 64;
    L43:
        collectOrderChanges(this.mController.mWaitingTransitions.isEmpty());
        if (this.mPriorVisibilityMightBeDirty == false) goto L46;
        updatePriorVisibility();
    L46:
        this.mTargets = calculateTargets(this.mParticipants, this.mChanges);
        this.mExt.updateAnimTargetIfNeed(this.mTargets, this.mParticipants);
        this.mController.mAtm.mBackNavigationController.onTransactionReady(this, this.mTargets, transaction, this.mFinishTransaction);
        android.window.TransitionInfo info = calculateTransitionInfo(this.mType, this.mFlags, this.mTargets, transaction);
        if (Features.FEAT_QUICK_WIN == false) goto L49;
        getExt().checkForFreeformAppInvisible(info, transaction);
    L49:
        info.setDebugId(this.mSyncId);
        this.mController.assignTrack(this, info);
        this.mController.moveToPlaying(this);
        this.mExt.onTransactionReady(info, transaction);
        DisplayContent[] participantDisplays = (DisplayContent[]) this.mTargetDisplays.toArray(new DisplayContent[this.mTargetDisplays.size()]);
        this.mTargetDisplays.clear();
        int i4 = 0;
    L51:
        if (i4 >= info.getRootCount()) goto L53;
        this.mTargetDisplays.add(this.mController.mAtm.mRootWindowContainer.getDisplayContent(info.getRoot(i4).getDisplayId()));
        i4 = i4 + 1;
        goto L51
    L53:
        int i5 = 0;
    L55:
        if (i5 >= this.mTargets.size()) goto L78;
        WindowContainer<?> wc = this.mTargets.get(i5).mContainer;
        WallpaperWindowToken wp = wc.asWallpaperToken();
        if (wp != null) goto L59;
        DisplayArea<?> da = wc.asDisplayArea();
        if (da == null) goto L77;
        if (da.isVisibleRequested() == false) goto L76;
        int inValidateList = this.mController.mValidateDisplayVis.indexOf(da);
        if (inValidateList < 0) goto L77;
        if (this.mChanges.get(da).mVisible == true) goto L77;
        this.mController.mValidateDisplayVis.remove(inValidateList);
        goto L77
    L76:
        this.mController.mValidateDisplayVis.add(da);
    L77:
        i5 = i5 + 1;
        goto L55
    L59:
        if (wp.mWmService.mFlags.mEnsureWallpaperInTransitions == false) goto L77;
        if (wp.isVisibleRequested() == false) goto L77;
        if (wp.getFixedRotationLeash() == null) goto L77;
        transaction.show(wp.mSurfaceControl);
        goto L77
    L78:
        overrideAnimationOptionsToInfoIfNecessary(info);
        int i6 = 0;
    L80:
        if (i6 >= this.mTargetDisplays.size()) goto L85;
        handleLegacyRecentsStartBehavior(this.mTargetDisplays.get(i6), info);
        if (this.mRecentsDisplayId != (-1)) goto L85;
        i6 = i6 + 1;
    L85:
        sendRemoteCallback(this.mClientAnimationStartCallback);
        int i7 = this.mParticipants.size() - 1;
    L86:
        if (i7 < 0) goto L104;
        ActivityRecord ar = this.mParticipants.valueAt(i7).asActivityRecord();
        if (ar == null) goto L102;
        if (ar.isVisibleRequested() == false) goto L102;
        transaction.show(ar.getSurfaceControl());
        WindowContainer p = ar.getParent();
    L93:
        if (p == null) goto L102;
        if (containsChangeFor(p, this.mTargets) == true) goto L102;
        if (p.isOrganized() == true) goto L102;
        if (p.getSurfaceControl() == null) goto L101;
        transaction.show(p.getSurfaceControl());
    L101:
        p = p.getParent();
    L102:
        i7 = i7 - 1;
        goto L86
    L104:
        if (this.mTransientLaunches != null) goto L114;
        int i8 = this.mParticipants.size() - 1;
    L106:
        if (i8 < 0) goto L114;
        WindowContainer wc2 = this.mParticipants.valueAt(i8);
        if (wc2.asWindowToken() == null) goto L113;
        if (wc2.isVisibleRequested() == false) goto L113;
        this.mVisibleAtTransitionEndTokens.add(wc2.asWindowToken());
    L113:
        i8 = i8 - 1;
    L114:
        int i9 = 0;
    L116:
        if (i9 >= this.mTargetDisplays.size()) goto L123;
        DisplayContent dc = this.mTargetDisplays.get(i9);
        AsyncRotationController controller = dc.getAsyncRotationController();
        if (controller == null) goto L122;
        if (containsChangeFor(dc, this.mTargets) == false) goto L122;
        controller.setupStartTransaction(transaction);
    L122:
        i9 = i9 + 1;
        goto L116
    L123:
        getExt().traceStartTrace(this.mFinishTransaction, "onTransitionReady");
        buildFinishTransaction(this.mFinishTransaction, info, participantDisplays);
        this.mCleanupTransaction = this.mController.mAtm.mWindowManager.mTransactionFactory.get();
        getExt().traceStartTrace(this.mCleanupTransaction, "onTransitionReady");
        buildCleanupTransaction(this.mCleanupTransaction, info);
        getExt().traceEndTrace(transaction);
        getExt().traceEndTrace(this.mFinishTransaction);
        getExt().traceEndTrace(this.mCleanupTransaction);
        if (this.mController.getTransitionPlayer() == null) goto L147;
        if (this.mIsPlayerEnabled == false) goto L147;
        this.mController.dispatchLegacyAppTransitionStarting(participantDisplays, this.mStatusBarTransitionDelay);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L133;
        String protoLogParam2 = String.valueOf(info);     // Catch: RemoteException -> L131
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -5350671621840749173L, 0, new Object[]{protoLogParam2});     // Catch: RemoteException -> L131
    L133:
        this.mLogger.mSendTimeNs = SystemClock.elapsedRealtimeNanos();     // Catch: RemoteException -> L131
        this.mLogger.mInfo = info;     // Catch: RemoteException -> L131
        this.mController.getTransitionPlayer().onTransitionReady(this.mToken, info, transaction, this.mFinishTransaction);     // Catch: RemoteException -> L131
        if (Trace.isTagEnabled(32) == false) goto L138;
        asyncTraceBegin(TRACE_NAME_PLAY_TRANSITION, System.identityHashCode(this));     // Catch: RemoteException -> L131
    L138:
        int i10 = 0;
    L140:
        if (i10 >= this.mTargetDisplays.size()) goto L152;
        DisplayContent dc2 = this.mTargetDisplays.get(i10);
        AccessibilityController accessibilityController = dc2.mWmService.mAccessibilityController;
        if (accessibilityController.hasCallbacks() == false) goto L144;
        accessibilityController.onWMTransition(dc2.getDisplayId(), this.mType, this.mFlags);
    L144:
        i10 = i10 + 1;
    L152:
        this.mOverrideOptions = null;
        reportStartReasonsToLogger();
        if (this.mTransientLaunches == null) goto L155;
    L157:
        info.releaseAnimSurfaces();
        if (this.mLogger.mInfo == null) goto L160;
        this.mLogger.logOnSendAsync(this.mController.mLoggerHandler);
        this.mController.mTransitionTracer.logSentTransition(this, this.mTargets);
    L160:
        getExt().traceOnTransactionReady(TAG, this.mSyncId, info.toString("  "));
        getExt().onTransactionReady(this.mType, this.mTargets, this.mController.mSnapshotController);
        return;
    L155:
        if (this.mExt.skipSnapshotWhenReady() == true) goto L157;
        this.mController.mSnapshotController.onTransactionReady(this.mType, this.mTargets);
    L137:
        postCleanupOnFailure();
    L147:
        if (this.mIsPlayerEnabled == true) goto L151;
        this.mLogger.mSendTimeNs = SystemClock.elapsedRealtimeNanos();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L151;
        long protoLogParam3 = this.mSyncId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 1830385055586991567L, 1, new Object[]{Long.valueOf(protoLogParam3)});
    L151:
        postCleanupOnFailure();
        goto L152
    L25:
        r0 = this.mController.mAtm.mRootWindowContainer.getDefaultDisplay();
        goto L26
    }

    private static /* synthetic */ void lambda$onTransactionReady$8(Runnable listener, SurfaceControl.TransactionStats stats) {
        listener.run();
    }

    void overrideAnimationOptionsToInfoIfNecessary(android.window.TransitionInfo info) {
        if (this.mOverrideOptions != null) goto L5;
        return;
    L5:
        List<android.window.TransitionInfo.Change> changes = info.getChanges();
        int i = changes.size() - 1;
    L6:
        if (i < 0) goto L17;
        WindowContainer<?> container = this.mTargets.get(i).mContainer;
        if (container.asActivityRecord() == null) goto L10;
    L15:
        changes.get(i).setAnimationOptions(this.mOverrideOptions);
        changes.get(i).setBackgroundColor(this.mOverrideBackgroundColor);
    L16:
        i = i - 1;
        goto L6
    L10:
        if (shouldApplyAnimOptionsToTask(container.asTask()) == true) goto L15;
        if (shouldApplyAnimOptionsToEmbeddedTf(container.asTaskFragment()) == false) goto L16;
        changes.get(i).setAnimationOptions(this.mOverrideOptions);
        goto L16
    L17:
        updateActivityTargetForCrossProfileAnimation(info);
    }

    private boolean shouldApplyAnimOptionsToTask(Task task) {
        if (task != null) goto L5;
    L13:
        return false;
    L5:
        if (this.mOverrideOptions == null) goto L13;
        int animType = this.mOverrideOptions.getType();
        if (animType != 5) goto L10;
    L11:
        return true;
    L10:
        if (this.mOverrideOptions.getOverrideTaskTransition() == true) goto L11;
        return false;
    }

    private boolean shouldApplyAnimOptionsToEmbeddedTf(TaskFragment taskFragment) {
        if (taskFragment != null) goto L5;
    L16:
        return false;
    L5:
        if (taskFragment.isEmbedded() == false) goto L16;
        if (taskFragment.getAnimationParams().hasOverrideAnimation() == false) goto L11;
        return false;
    L11:
        if (this.mOverrideOptions != null) goto L13;
        return false;
    L13:
        if (this.mOverrideOptions.getType() == 1) goto L15;
        return false;
    L15:
        return true;
    }

    private void updateActivityTargetForCrossProfileAnimation(android.window.TransitionInfo info) {
        if (this.mOverrideOptions.getType() == 12) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mTargets.size()) goto L24;
        ActivityRecord activity = this.mTargets.get(i).mContainer.asActivityRecord();
        android.window.TransitionInfo.Change change = (android.window.TransitionInfo.Change) info.getChanges().get(i);
        if (activity == null) goto L18;
        if (change.getMode() != 1) goto L18;
        int flags = change.getFlags();
        if (activity.mUserId != activity.mWmService.mCurrentUserId) goto L16;
        int r4 = 4096;
    L17:
        change.setFlags(flags | r4);
        return;
    L16:
        r4 = 8192;
    L18:
        i = i + 1;
        goto L7
    }

    @Override // com.android.server.wm.BLASTSyncEngine.TransactionReadyListener
    public void onTransactionCommitted() {
        TransitionController.Logger r0 = this.mLogger;
        r0.mTransactionCommitTimeNs = SystemClock.elapsedRealtimeNanos();
    }

    @Override // com.android.server.wm.BLASTSyncEngine.TransactionReadyListener
    public void onTransactionCommitTimeout() {
        if (this.mCleanupTransaction != null) goto L5;
        return;
    L5:
        int i = this.mTargetDisplays.size() - 1;
    L6:
        if (i < 0) goto L14;
        DisplayContent dc = this.mTargetDisplays.get(i);
        AsyncRotationController asyncRotationController = dc.getAsyncRotationController();
        if (asyncRotationController == null) goto L12;
        if (containsChangeFor(dc, this.mTargets) == false) goto L12;
        asyncRotationController.onTransactionCommitTimeout(this.mCleanupTransaction);
    L12:
        i = i - 1;
        goto L6
    }

    void addTransactionCompletedListener(Runnable listener) {
        if (this.mTransactionCompletedListeners != null) goto L5;
        this.mTransactionCompletedListeners = new ArrayList();
    L5:
        this.mTransactionCompletedListeners.add(listener);
    }

    void addTransitionEndedListener(Runnable listener) {
        if (this.mState == 0) goto L10;
        if (this.mState == 1) goto L10;
        throw new IllegalStateException("Can't register listeners if the transition isn't collecting. state=" + this.mState);
    L10:
        if (this.mTransitionEndedListeners != null) goto L12;
        this.mTransitionEndedListeners = new ArrayList();
    L12:
        this.mTransitionEndedListeners.add(listener);
    }

    boolean hasOrderChanges() {
        ArrayList<Task> onTopTasks = new ArrayList();
        Iterator<DisplayContent> r1 = this.mTargetDisplays.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        DisplayContent dc = r1.next();
        addOnTopTasks(dc, onTopTasks);
        goto L4
    L6:
        Iterator<Task> r2 = onTopTasks.iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Task task = r2.next();
        if (this.mOnTopTasksStart.contains(task) == true) goto L8;
        return true;
    L14:
        return false;
    }

    void collectOrderChanges(boolean reportCurrent) {
        if (this.mOnTopTasksStart.isEmpty() == false) goto L5;
        return;
    L5:
        boolean includesOrderChange = false;
        int i = 0;
    L7:
        if (i >= this.mOnTopTasksAtReady.size()) goto L13;
        if (this.mOnTopTasksStart.contains(this.mOnTopTasksAtReady.get(i)) == false) goto L11;
        i = i + 1;
        goto L7
    L11:
        includesOrderChange = true;
    L13:
        if ((includesOrderChange | false) == true) goto L16;
        if (reportCurrent == true) goto L16;
        return;
    L16:
        ArrayList<Task> onTopTasksEnd = new ArrayList();
        this.mController.mAtm.mRootWindowContainer.getTopFocusedDisplayContent();
        int d = 0;
    L18:
        if (d >= this.mTargetDisplays.size()) goto L39;
        addOnTopTasks(this.mTargetDisplays.get(d), onTopTasksEnd);
        int displayId = this.mTargetDisplays.get(d).mDisplayId;
        ArrayList<Task> reportedOnTop = this.mController.mLatestOnTopTasksReported.get(displayId);
        int i2 = onTopTasksEnd.size() - 1;
    L20:
        if (i2 < 0) goto L33;
        Task task = onTopTasksEnd.get(i2);
        if (task.getDisplayId() != displayId) goto L32;
        if (reportedOnTop != null) goto L29;
        if (this.mOnTopTasksStart.contains(task) == true) goto L32;
    L31:
        addToTopChange(task);
        goto L32
    L29:
        if (reportedOnTop.contains(task) == false) goto L31;
    L32:
        i2 = i2 - 1;
        goto L20
    L33:
        this.mController.mLatestOnTopTasksReported.put(displayId, onTopTasksEnd);
        if (reportedOnTop == null) goto L36;
        ArrayList<Task> r6 = reportedOnTop;
    L37:
        onTopTasksEnd = r6;
        onTopTasksEnd.clear();
        d = d + 1;
        goto L18
    L36:
        r6 = new ArrayList();
        goto L37
    }

    private void addToTopChange(WindowContainer wc) {
        this.mParticipants.add(wc);
        if (this.mChanges.containsKey(wc) == true) goto L5;
        this.mChanges.put(wc, new ChangeInfo(wc));
    L5:
        this.mChanges.get(wc).mFlags |= 32;
    }

    private void postCleanupOnFailure() {
        this.mController.mAtm.mH.post(new Transition$$ExternalSyntheticLambda16(this));
    }

    private /* synthetic */ void lambda$postCleanupOnFailure$9() {
        WindowManagerGlobalLock r0 = this.mController.mAtm.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        cleanUpOnFailure();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void cleanUpOnFailure() {
        if (this.mState >= 2) goto L6;
        return;
    L6:
        if (this.mStartTransaction == null) goto L9;
        this.mStartTransaction.apply();
    L9:
        if (this.mFinishTransaction == null) goto L11;
        this.mFinishTransaction.apply();
    L11:
        this.mController.finishTransition(this.mController.mAtm.mChainTracker.startFinish("clean-up", this));
    }

    private void cleanUpInternal() {
        int i = 0;
    L4:
        if (i >= this.mChanges.size()) goto L10;
        ChangeInfo ci = this.mChanges.valueAt(i);
        if (ci.mSnapshot == null) goto L8;
        ci.mSnapshot.release();
    L8:
        i = i + 1;
        goto L4
    L10:
        if (this.mCleanupTransaction == null) goto L16;
        this.mCleanupTransaction.apply();
        this.mCleanupTransaction = null;
        return;
    }

    private void commitVisibleActivities(SurfaceControl.Transaction transaction) {
        int i = this.mParticipants.size() - 1;
    L3:
        if (i < 0) goto L15;
        ActivityRecord ar = this.mParticipants.valueAt(i).asActivityRecord();
        if (ar == null) goto L13;
        if (ar.getTask() == null) goto L13;
        if (ar.isVisibleRequested() == false) goto L12;
        ar.commitVisibility(true, false, true);
        ar.commitFinishDrawing(transaction);
    L12:
        ar.getTask().setDeferTaskAppear(false);
    L13:
        i = i - 1;
        goto L3
    }

    private void commitVisibleWallpapers(SurfaceControl.Transaction t) {
        boolean showWallpaper = shouldWallpaperBeVisible();
        int i = this.mParticipants.size() - 1;
    L3:
        if (i < 0) goto L19;
        WallpaperWindowToken wallpaper = this.mParticipants.valueAt(i).asWallpaperToken();
        if (wallpaper == null) goto L17;
        if (wallpaper.isVisible() == false) goto L9;
    L11:
        if (showWallpaper == false) goto L17;
        if (wallpaper.isVisibleRequested() == false) goto L17;
        int j = wallpaper.mChildren.size() - 1;
    L15:
        if (j < 0) goto L17;
        ((WindowState) wallpaper.mChildren.get(j)).mWinAnimator.prepareSurfaceLocked(t);
        j = j - 1;
        goto L15
    L9:
        if (wallpaper.isVisibleRequested() == false) goto L11;
        wallpaper.commitVisibility(showWallpaper);
    L17:
        i = i - 1;
        goto L3
    }

    private boolean shouldWallpaperBeVisible() {
        int i = this.mParticipants.size() - 1;
    L3:
        if (i < 0) goto L8;
        WindowContainer participant = this.mParticipants.valueAt(i);
        if (participant.showWallpaper() == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    private void handleLegacyRecentsStartBehavior(DisplayContent dc, android.window.TransitionInfo info) {
        if ((this.mFlags & 128) != 0) goto L5;
        return;
    L5:
        InputConsumerImpl recentsAnimationInputConsumer = dc.getInputMonitor().getInputConsumer("recents_animation_input_consumer");
        Task recentsTask = null;
        if (recentsAnimationInputConsumer == null) goto L39;
        Task topNonRecentsTask = null;
        int i = 0;
    L9:
        if (i >= info.getChanges().size()) goto L31;
        ActivityManager.RunningTaskInfo taskInfo = ((android.window.TransitionInfo.Change) info.getChanges().get(i)).getTaskInfo();
        if (taskInfo == null) goto L29;
        Task task = Task.fromWindowContainerToken(taskInfo.token);
        if (task == null) goto L29;
        int activityType = taskInfo.topActivityType;
        if (activityType != 2) goto L19;
    L22:
        boolean isRecents = true;
    L23:
        if (isRecents == false) goto L26;
        if (recentsTask != null) goto L26;
        recentsTask = task;
    L26:
        if (isRecents == true) goto L29;
        if (topNonRecentsTask != null) goto L29;
        topNonRecentsTask = task;
        goto L29
    L19:
        if (activityType == 3) goto L22;
        isRecents = false;
    L29:
        i = i + 1;
        goto L9
    L31:
        if (recentsTask == null) goto L33;
    L35:
        Slog.d(TAG, "handleLegacyRecentsStartBehavior recentsTask=" + recentsTask + ",topNonRecentsTask=" + topNonRecentsTask);
        if (recentsTask == null) goto L39;
        if (topNonRecentsTask == null) goto L39;
        recentsAnimationInputConsumer.mWindowHandle.touchableRegion.set(topNonRecentsTask.getBounds());
        dc.getInputMonitor().setActiveRecents(recentsTask, topNonRecentsTask);
        dc.getInputMonitor().updateInputWindowsLw(true);
        goto L39
    L33:
        if (this.mOnTopDisplayAtReady == null) goto L35;
        recentsTask = this.mOnTopDisplayAtReady.getTask(new Transition$$ExternalSyntheticLambda3());
    L39:
        if (recentsTask != null) goto L41;
        return;
    L41:
        this.mRecentsDisplayId = dc.mDisplayId;
        if (dc.getDisplayPolicy().shouldAttachNavBarToAppDuringTransition() == true) goto L44;
        return;
    L44:
        if (dc.getAsyncRotationController() != null) goto L96;
        WindowContainer topWC = null;
        int i2 = 0;
    L48:
        if (i2 >= info.getChanges().size()) goto L62;
        android.window.TransitionInfo.Change c = (android.window.TransitionInfo.Change) info.getChanges().get(i2);
        if (c.getTaskInfo() == null) goto L61;
        if (c.getTaskInfo().displayId != this.mRecentsDisplayId) goto L61;
        if (c.getTaskInfo().getActivityType() != 1) goto L61;
        if (c.getMode() == 2) goto L60;
        if (c.getMode() != 4) goto L61;
    L60:
        topWC = WindowContainer.fromBinder(c.getContainer().asBinder());
    L61:
        i2 = i2 + 1;
    L62:
        if (topWC != null) goto L64;
        return;
    L64:
        if (topWC.inMultiWindowMode() == true) goto L95;
        WindowState navWindow = dc.getDisplayPolicy().getNavigationBar();
        if (navWindow != null) goto L69;
        return;
    L69:
        if (navWindow.mToken == null) goto L94;
        this.mController.mNavigationBarAttachedToApp = true;
        navWindow.mToken.cancelAnimation();
        SurfaceControl.Transaction t = navWindow.mToken.getPendingTransaction();
        SurfaceControl navSurfaceControl = navWindow.mToken.getSurfaceControl();
        t.reparent(navSurfaceControl, topWC.getSurfaceControl());
        t.show(navSurfaceControl);
        WindowContainer imeContainer = dc.getImeContainer();
        if (imeContainer.isVisible() == false) goto L74;
        t.setRelativeLayer(navSurfaceControl, imeContainer.getSurfaceControl(), 1);
    L75:
        sendLumaSamplingEnabledToStatusBarInternal(dc, false);
        return;
    L74:
        t.setLayer(navSurfaceControl, Integer.MAX_VALUE);
        goto L75
    L94:
        return;
    L95:
        return;
    }

    private static /* synthetic */ boolean lambda$handleLegacyRecentsStartBehavior$10(Task t) {
        if (t.getTaskInfo().topActivityType == 2) goto L5;
    L7:
        return false;
    L5:
        if (t.isRootTask() == false) goto L7;
        return true;
    }

    void legacyRestoreNavigationBarFromApp() {
        if (this.mController.mNavigationBarAttachedToApp == true) goto L5;
        return;
    L5:
        this.mController.mNavigationBarAttachedToApp = false;
        int recentsDisplayId = this.mRecentsDisplayId;
        if (recentsDisplayId != (-1)) goto L8;
        Slog.i(TAG, "Restore parent surface of navigation bar by another transition");
        recentsDisplayId = 0;
    L8:
        DisplayContent dc = this.mController.mAtm.mRootWindowContainer.getDisplayContent(recentsDisplayId);
        sendLumaSamplingEnabledToStatusBarInternal(dc, true);
        WindowState navWindow = dc.getDisplayPolicy().getNavigationBar();
        if (navWindow != null) goto L11;
        return;
    L11:
        navWindow.setSurfaceTranslationY(0);
        WindowToken navToken = navWindow.mToken;
        if (navToken != null) goto L14;
        return;
    L14:
        SurfaceControl.Transaction t = dc.getPendingTransaction();
        WindowContainer parent = navToken.getParent();
        t.setLayer(navToken.getSurfaceControl(), navToken.getLastLayer());
        boolean animate = false;
        int i = 0;
    L16:
        if (i >= this.mTargets.size()) goto L24;
        Task task = this.mTargets.get(i).mContainer.asTask();
        if (task == null) goto L23;
        if (task.isActivityTypeHomeOrRecents() == false) goto L23;
        animate = task.isVisibleRequested();
    L23:
        i = i + 1;
    L24:
        if (animate == false) goto L26;
        NavBarFadeAnimationController controller = new NavBarFadeAnimationController(dc);
        controller.fadeWindowToken(true);
    L27:
        dc.mWmService.scheduleAnimationLocked();
        return;
    L26:
        t.reparent(navToken.getSurfaceControl(), parent.getSurfaceControl());
        goto L27
    }

    private void sendLumaSamplingEnabledToStatusBarInternal(DisplayContent dc, boolean enabled) {
        StatusBarManagerInternal bar = dc.getDisplayPolicy().getStatusBarManagerInternal();
        if (bar == null) goto L6;
        bar.setNavigationBarLumaSamplingEnabled(dc.getDisplayId(), enabled);
        return;
    }

    private void reportStartReasonsToLogger() {
        ArrayMap<WindowContainer, Integer> reasons = new ArrayMap();
        int i = this.mParticipants.size() - 1;
    L3:
        if (i < 0) goto L21;
        ActivityRecord r = this.mParticipants.valueAt(i).asActivityRecord();
        if (r == null) goto L20;
        if (r.isVisibleRequested() == false) goto L20;
        int transitionReason = 2;
        if ((r.mStartingData instanceof SplashScreenStartingData) == false) goto L15;
        if (r.mLastAllReadyAtSync == true) goto L15;
        transitionReason = 1;
    L19:
        reasons.put(r, Integer.valueOf(transitionReason));
    L15:
        if (r.isActivityTypeHomeOrRecents() == false) goto L19;
        if (isTransientLaunch(r) == false) goto L19;
        transitionReason = 5;
    L20:
        i = i - 1;
        goto L3
    L21:
        this.mController.mAtm.mTaskSupervisor.getActivityMetricsLogger().notifyTransitionStarting(reasons);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("TransitionRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" id=" + this.mSyncId);
        sb.append(" type=" + WindowManager.transitTypeToString(this.mType));
        sb.append(" flags=0x" + Integer.toHexString(this.mFlags));
        if (this.mOverrideOptions == null) goto L6;
        sb.append(" overrideAnimOptions=" + this.mOverrideOptions);
    L6:
        if (this.mOverrideBackgroundColor == 0) goto L9;
        sb.append(" overrideBackgroundColor=" + this.mOverrideBackgroundColor);
    L9:
        if (this.mChanges.isEmpty() == true) goto L15;
        sb.append(" c=[");
        int i = 0;
    L12:
        if (i >= this.mChanges.size()) goto L14;
        sb.append("\n");
        sb.append("   ");
        sb.append(this.mChanges.valueAt(i).toString());
        i = i + 1;
        goto L12
    L14:
        sb.append("\n]\n");
    L15:
        sb.append('}');
        return sb.toString();
    }

    private static WindowContainer<?> getAnimatableParent(WindowContainer<?> wc) {
        WindowContainer<?> parent = wc.getParent();
    L3:
        if (parent == null) goto L9;
        if (parent.canCreateRemoteAnimationTarget() == true) goto L9;
        if (parent.isOrganized() == true) goto L9;
        parent = parent.getParent();
    L9:
        return parent;
    }

    private static boolean reportIfNotTop(WindowContainer wc) {
        return wc.isOrganized();
    }

    private static boolean isWallpaper(WindowContainer wc) {
        if (wc.asWallpaperToken() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isInputMethod(WindowContainer wc) {
        if (wc.getWindowType() != 2011) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean occludesKeyguard(WindowContainer wc) {
        ActivityRecord ar = wc.asActivityRecord();
        if (ar != null) goto L5;
        Task t = wc.asTask();
        if (t == null) goto L14;
        ActivityRecord top = t.getActivity(new Transition$$ExternalSyntheticLambda2());
        if (top != null) goto L11;
        return false;
    L11:
        if (top.canShowWhenLocked() == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    L5:
        return ar.canShowWhenLocked();
    }

    private static boolean isTranslucent(WindowContainer wc) {
        TaskFragment taskFragment = wc.asTaskFragment();
        if (taskFragment != null) goto L7;
        return true ^ wc.fillsParent();
    L7:
        if (taskFragment.isTranslucentForTransition() == false) goto L10;
        return true;
    L10:
        if (taskFragment.hasAdjacentTaskFragment() == true) goto L14;
        return true ^ wc.fillsParent();
    L14:
        return taskFragment.forOtherAdjacentTaskFragments(new Transition$$ExternalSyntheticLambda5());
    }

    private void updatePriorVisibility() {
        int i = 0;
    L4:
        if (i >= this.mChanges.size()) goto L16;
        ChangeInfo chg = this.mChanges.valueAt(i);
        if (chg.mContainer.asActivityRecord() != null) goto L11;
        if (chg.mContainer.asTask() != null) goto L11;
    L14:
        i = i + 1;
    L11:
        if (chg.mVisible == false) goto L14;
        chg.mVisible = chg.mContainer.isVisible();
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean canPromote(ChangeInfo targetChange, Targets targets, ArrayMap<WindowContainer, ChangeInfo> changes) {
        WindowContainer<?> target = targetChange.mContainer;
        WindowContainer<?> parent = target.getParent();
        ChangeInfo parentChange = changes.get(parent);
        char r6 = 1;
        if (parent.canCreateRemoteAnimationTarget() == false) goto L58;
        if (parentChange == null) goto L58;
        if (parentChange.hasChanged() == false) goto L58;
        Object r8 = null;
        if (isWallpaper(target) == false) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L13;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -2714847784842612086L, 0, null);
    L13:
        return false;
    L15:
        if (targetChange.mStartParent != null) goto L17;
    L19:
        int mode = targetChange.getTransitMode(target);
        int i = parent.getChildCount() - 1;
    L20:
        if (i < 0) goto L55;
        WindowContainer<?> sibling = parent.getChildAt(i);
        if (target != sibling) goto L25;
        r6 = r6;
        Object r13 = r8;
        i = i;
    L53:
        i = i - 1;
        r8 = r13;
        r6 = r6;
        goto L20
    L25:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[r6] == false) goto L27;
        String protoLogParam0 = String.valueOf(sibling);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 1855461834864671586L, 0, new Object[]{protoLogParam0});
    L27:
        ChangeInfo siblingChange = changes.get(sibling);
        if (siblingChange == null) goto L45;
        if (targets.wasParticipated(siblingChange) == false) goto L45;
        int siblingMode = siblingChange.getTransitMode(sibling);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[r6] == false) goto L37;
        String protoLogParam1 = String.valueOf(android.window.TransitionInfo.modeToString(siblingMode));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 3873493605120555608L, 0, new Object[]{protoLogParam1});
    L37:
        if (reduceMode(mode) != reduceMode(siblingMode)) goto L39;
        r13 = null;
        goto L53
    L39:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[r6] == false) goto L41;
        String protoLogParam2 = String.valueOf(android.window.TransitionInfo.modeToString(mode));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 7665553560859456426L, 0, new Object[]{protoLogParam2});
    L41:
        return false;
    L45:
        if (sibling.isVisibleRequested() == true) goto L47;
        r13 = null;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[r6] == false) goto L53;
        String protoLogParam3 = String.valueOf(sibling);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 7897657428993391672L, 0, new Object[]{protoLogParam3});
        goto L53
    L47:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[r6] == false) goto L49;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -6292043690918793069L, 0, null);
    L49:
        return false;
    L55:
        return r6;
    L17:
        if (target.getParent() == targetChange.mStartParent) goto L19;
        return false;
    L58:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L60;
        String protoLogParam4 = String.valueOf("parent can't be target " + parent);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -758501334967569539L, 0, new Object[]{protoLogParam4});
    L60:
        return false;
    }

    private static int reduceMode(int mode) {
        switch(mode) {
            case 3: goto L6;
            case 4: goto L4;
            default: goto L3;
        };
    L3:
        return mode;
    L4:
        return 2;
    L6:
        return 1;
    }

    private static void tryPromote(Targets targets, ArrayMap<WindowContainer, ChangeInfo> changes) {
        WindowContainer<?> lastNonPromotableParent = null;
        int i = targets.mArray.size() - 1;
    L3:
        if (i < 0) goto L41;
        ChangeInfo targetChange = targets.mArray.valueAt(i);
        WindowContainer<?> target = targetChange.mContainer;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L7;
        String protoLogParam0 = String.valueOf(target);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -8916099332247176657L, 0, new Object[]{protoLogParam0});
    L7:
        WindowContainer<?> parent = target.getParent();
        if (parent != lastNonPromotableParent) goto L13;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L39;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -6818387694968032301L, 0, null);
    L39:
        i = i - 1;
        goto L3
    L13:
        if (canPromote(targetChange, targets, changes) == true) goto L16;
        lastNonPromotableParent = parent;
        goto L39
    L16:
        if (reportIfNotTop(target) == false) goto L21;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L29;
        String protoLogParam1 = String.valueOf(target);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -7326702978448933012L, 0, new Object[]{protoLogParam1});
    L29:
        ChangeInfo parentChange = changes.get(parent);
        if (targets.mArray.indexOfValue(parentChange) >= 0) goto L36;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L34;
        String protoLogParam2 = String.valueOf(parent);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 841543868388687804L, 0, new Object[]{protoLogParam2});
    L34:
        i = i + 1;
        targets.add(parentChange);
    L36:
        if ((targetChange.mFlags & 8) == 0) goto L38;
        parentChange.mFlags |= 8;
        goto L39
    L38:
        parentChange.mFlags |= 16;
        goto L39
    L21:
        if ((targetChange.mFlags & 64) == 0) goto L26;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L29;
        String protoLogParam3 = String.valueOf(target);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 2213295726053571498L, 0, new Object[]{protoLogParam3});
        goto L29
    L26:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L28;
        String protoLogParam4 = String.valueOf(target);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 943961036184959431L, 0, new Object[]{protoLogParam4});
    L28:
        targets.remove(i);
        goto L29
    }

    static ArrayList<ChangeInfo> calculateTargets(ArraySet<WindowContainer> participants, ArrayMap<WindowContainer, ChangeInfo> changes) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(participants);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 743586316159041023L, 0, new Object[]{protoLogParam0});
    L5:
        Targets targets = new Targets(null);
        int i = participants.size() - 1;
    L6:
        if (i < 0) goto L23;
        WindowContainer<?> wc = participants.valueAt(i);
        if (wc.isAttached() == true) goto L13;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L21;
        String protoLogParam1 = String.valueOf(wc);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -7247430213293162757L, 0, new Object[]{protoLogParam1});
    L21:
        i = i - 1;
        goto L6
    L13:
        if (wc.asWindowState() != null) goto L21;
        ChangeInfo changeInfo = changes.get(wc);
        if (changeInfo.hasChanged() == false) goto L18;
        targets.add(changeInfo);
        goto L21
    L18:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L21;
        String protoLogParam2 = String.valueOf(wc);
        boolean protoLogParam3 = wc.isVisibleRequested();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -8084544187550452362L, 12, new Object[]{protoLogParam2, Boolean.valueOf(protoLogParam3)});
        goto L21
    L23:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L25;
        String protoLogParam4 = String.valueOf(targets.mArray);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -1153926883525904120L, 0, new Object[]{protoLogParam4});
    L25:
        tryPromote(targets, changes);
        populateParentChanges(targets, changes);
        ArrayList<ChangeInfo> targetList = targets.getListSortedByZ();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L28;
        String protoLogParam5 = String.valueOf(targetList);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, -9191328656870721224L, 0, new Object[]{protoLogParam5});
    L28:
        return targetList;
    }

    private static void populateParentChanges(Targets targets, ArrayMap<WindowContainer, ChangeInfo> changes) {
        ArrayList<ChangeInfo> intermediates = new ArrayList();
        ArrayList<ChangeInfo> targetList = new ArrayList(targets.mArray.size());
        int i = targets.mArray.size() - 1;
    L3:
        if (i < 0) goto L5;
        targetList.add(targets.mArray.valueAt(i));
        i = i - 1;
        goto L3
    L5:
        int i2 = targetList.size();
        int i3 = i2 - 1;
    L6:
        if (i3 < 0) goto L43;
        ChangeInfo targetChange = targetList.get(i3);
        WindowContainer wc = targetChange.mContainer;
        boolean skipIntermediateReports = isWallpaper(wc);
        intermediates.clear();
        boolean foundParentInTargets = false;
        WindowContainer<?> p = getAnimatableParent(wc);
    L8:
        if (p == null) goto L33;
        ChangeInfo parentChange = changes.get(p);
        if (parentChange == null) goto L33;
        if (parentChange.hasChanged() == false) goto L32;
        if (p.mRemoteToken == null) goto L32;
        if (parentChange.mEndParent == null) goto L23;
        if (skipIntermediateReports == true) goto L23;
        targetChange.mEndParent = p;
    L23:
        if (targetList.contains(parentChange) == true) goto L24;
        if (reportIfNotTop(p) == false) goto L32;
        if (skipIntermediateReports == true) goto L32;
        intermediates.add(parentChange);
        goto L32
    L24:
        if (skipIntermediateReports == false) goto L26;
        targetChange.mEndParent = p;
    L27:
        foundParentInTargets = true;
        goto L33
    L26:
        intermediates.add(parentChange);
    L32:
        p = getAnimatableParent(p);
    L33:
        if (foundParentInTargets == false) goto L41;
        if (intermediates.isEmpty() == true) goto L41;
        targetChange.mEndParent = intermediates.get(0).mContainer;
        int j = 0;
    L39:
        if (j >= (intermediates.size() - 1)) goto L41;
        ChangeInfo intermediate = intermediates.get(j);
        intermediate.mEndParent = intermediates.get(j + 1).mContainer;
        targets.add(intermediate);
        j = j + 1;
    L41:
        i3 = i3 - 1;
        goto L6
    }

    private static SurfaceControl getLeashSurface(WindowContainer wc, SurfaceControl.Transaction t) {
        DisplayContent asDC = wc.asDisplayContent();
        if (asDC == null) goto L7;
        return asDC.getWindowingLayer();
    L7:
        if (wc.mTransitionController.useShellTransitionsRotation() == true) goto L17;
        WindowToken asToken = wc.asWindowToken();
        if (asToken == null) goto L17;
        if (t == null) goto L12;
        SurfaceControl leash = asToken.getOrCreateFixedRotationLeash(t);
    L14:
        if (leash == null) goto L17;
        return leash;
    L12:
        leash = asToken.getFixedRotationLeash();
    L17:
        return wc.getSurfaceControl();
    }

    private static SurfaceControl getOrigParentSurface(WindowContainer wc) {
        if (wc.asDisplayContent() == null) goto L7;
        return wc.getSurfaceControl();
    L7:
        return wc.getParent().getSurfaceControl();
    }

    private static boolean isReadyGroup(WindowContainer wc) {
        return wc instanceof DisplayContent;
    }

    private static int getDisplayId(WindowContainer wc) {
        if (wc.getDisplayContent() != null) goto L7;
        return -1;
    L7:
        return wc.getDisplayContent().getDisplayId();
    }

    static void calculateTransitionRoots(android.window.TransitionInfo outInfo, ArrayList<ChangeInfo> sortedTargets, SurfaceControl.Transaction startT) {
        int i = 0;
    L4:
        if (i >= sortedTargets.size()) goto L27;
        WindowContainer<?> wc = sortedTargets.get(i).mContainer;
        if (isWallpaper(wc) == true) goto L25;
        DisplayContent dc = wc.getDisplayContent();
        if (dc == null) goto L25;
        int endDisplayId = dc.getDisplayId();
        if (outInfo.findRootIndex(endDisplayId) >= 0) goto L25;
        WindowContainer<?> ancestor = findCommonAncestor(sortedTargets, wc);
        boolean hasReparent = !wc.isDescendantOf(ancestor);
        WindowContainer<?> r6 = wc;
        if (hasReparent == false) goto L18;
        Slog.e(TAG, "Did not find common ancestor! Ancestor= " + ancestor + " target= " + wc);
    L20:
        if (wc == r6) goto L22;
    L24:
        SurfaceControl rootLeash = r6.makeAnimationLeash().setName("Transition Root: " + r6.getName()).setCallsite("Transition.calculateTransitionRoots").build();
        rootLeash.setUnreleasedWarningCallSite("Transition.calculateTransitionRoots");
        assignLayers(dc, startT);
        startT.setLayer(rootLeash, r6.getLastLayer());
        outInfo.addRootLeash(endDisplayId, rootLeash, ancestor.getBounds().left, ancestor.getBounds().top);
        goto L25
    L22:
        if (sortedTargets.get(i).mWindowingMode != 2) goto L24;
        r6 = ancestor.getTopChild();
    L18:
        if (r6.getParent() == ancestor) goto L20;
        r6 = r6.getParent();
    L25:
        i = i + 1;
        goto L4
    }

    static android.window.TransitionInfo calculateTransitionInfo(int type, int flags, ArrayList<ChangeInfo> sortedTargets, SurfaceControl.Transaction startT) {
        ArrayList<ChangeInfo> r1 = sortedTargets;
        SurfaceControl.Transaction r2 = startT;
        android.window.TransitionInfo out = new android.window.TransitionInfo(type, flags);
        calculateTransitionRoots(out, r1, r2);
        if (out.getRootCount() != 0) goto L5;
        return out;
    L5:
        android.window.TransitionInfo.AnimationOptions animOptionsForActivityTransition = calculateAnimationOptionsForActivityTransition(type, r1);
        ArraySet<WindowContainer> occludedAtEndContainers = new ArraySet();
        int count = r1.size();
        int i = 0;
    L6:
        if (i >= count) goto L129;
        ChangeInfo info = r1.get(i);
        WindowContainer target = info.mContainer;
        if (target.mRemoteToken == null) goto L10;
        WindowContainerToken r12 = target.mRemoteToken.toWindowContainerToken();
    L11:
        android.window.TransitionInfo.Change change = new android.window.TransitionInfo.Change(r12, getLeashSurface(target, r2));
        if (info.mEndParent == null) goto L15;
        change.setParent(info.mEndParent.mRemoteToken.toWindowContainerToken());
    L15:
        if (info.mStartParent != null) goto L17;
    L21:
        change.setMode(info.getTransitMode(target));
        info.mReadyMode = change.getMode();
        change.setStartAbsBounds(info.mAbsoluteBounds);
        change.setFlags(info.getChangeFlags(target));
        info.mReadyFlags = change.getFlags();
        change.setDisplayId(info.mDisplayId, getDisplayId(target));
        if (change.getMode() != 3) goto L24;
    L25:
        int occIndex = occludedAtEndContainers.size() - 1;
    L26:
        if (occIndex < 0) goto L32;
        if (target.isDescendantOf(occludedAtEndContainers.valueAt(occIndex)) == true) goto L29;
        occIndex = occIndex - 1;
        goto L26
    L29:
        change.setFlags(change.getFlags() | 32768);
    L32:
        if (change.hasFlags(4) == false) goto L34;
    L40:
        Task task = target.asTask();
        TaskFragment taskFragment = target.asTaskFragment();
        if (taskFragment != null) goto L43;
    L45:
        boolean isEmbeddedTaskFragment = false;
    L47:
        if (taskFragment == null) goto L49;
        IBinder r17 = taskFragment.getFragmentToken();
    L50:
        IBinder taskFragmentToken = r17;
        change.setTaskFragmentToken(taskFragmentToken);
        ActivityRecord activityRecord = target.asActivityRecord();
        if (task == null) goto L61;
        ActivityManager.RunningTaskInfo tinfo = new ActivityManager.RunningTaskInfo();
        task.fillTaskInfo(tinfo);
        change.setTaskInfo(tinfo);
        change.setRotationAnimation(getTaskRotationAnimation(task));
        ActivityRecord topRunningActivity = task.topRunningActivity();
        if (topRunningActivity != null) goto L55;
    L58:
        change.setTaskId(task.mTaskId);
    L63:
        WindowContainer<?> parent = target.getParent();
        Rect bounds = target.getBounds();
        Rect parentBounds = parent.getBounds();
        change.setEndRelOffset(bounds.left - parentBounds.left, bounds.top - parentBounds.top);
        change.setEndParentSize(parentBounds.width(), parentBounds.height());
        int endRotation = target.getWindowConfiguration().getRotation();
        if (activityRecord == null) goto L76;
        change.setEndAbsBounds(parentBounds);
        if (activityRecord.getRelativeDisplayRotation() == 0) goto L71;
        if (activityRecord.mTransitionController.useShellTransitionsRotation() == true) goto L71;
        endRotation = parent.getWindowConfiguration().getRotation();
    L71:
        if (activityRecord.getTask() == null) goto L73;
        int r4 = activityRecord.getTask().mTaskId;
    L74:
        change.setTaskId(r4);
    L85:
        if (activityRecord != null) goto L89;
        if (isEmbeddedTaskFragment == true) goto L89;
    L103:
        if (activityRecord == null) goto L106;
        if (animOptionsForActivityTransition == null) goto L106;
        android.window.TransitionInfo.AnimationOptions animOptions = animOptionsForActivityTransition;
        animOptionsForActivityTransition = animOptionsForActivityTransition;
        occludedAtEndContainers = occludedAtEndContainers;
    L113:
        if (animOptions == null) goto L115;
        change.setAnimationOptions(animOptions);
    L115:
        if (activityRecord == null) goto L117;
        change.setActivityComponent(activityRecord.mActivityComponent);
    L117:
        change.setRotation(info.mRotation, endRotation);
        if (info.mSnapshot == null) goto L121;
        change.setSnapshot(info.mSnapshot, info.mSnapshotLuma);
    L121:
        if (Features.FEAT_QUICK_WIN == false) goto L127;
        change.setStartWindowingMode(info.mWindowingMode);
        change.setEndWindowingMode(target.getWindowingMode());
        if (target.asTask() == null) goto L127;
        change.setStartScale(info.mStartScale);
        change.setEndScale(target.asTask().getExt().getScale());
        change.getStartAbsBounds().offset(info.mStartOffset.x, info.mStartOffset.y);
        Point endPosition = target.asTask().getExt().getOffset();
        change.getEndAbsBounds().offset(endPosition.x, endPosition.y);
        Point offset = change.getEndRelOffset();
        change.setEndRelOffset(offset.x + endPosition.x, offset.y + endPosition.y);
    L127:
        out.addChange(change);
        i = i + 1;
        r1 = sortedTargets;
        r2 = startT;
        animOptionsForActivityTransition = animOptionsForActivityTransition;
        occludedAtEndContainers = occludedAtEndContainers;
    L106:
        if (isEmbeddedTaskFragment == false) goto L112;
        TaskFragmentAnimationParams params = taskFragment.getAnimationParams();
        if (params.hasOverrideAnimation() == false) goto L112;
        animOptionsForActivityTransition = animOptionsForActivityTransition;
        occludedAtEndContainers = occludedAtEndContainers;
        animOptions = android.window.TransitionInfo.AnimationOptions.makeCustomAnimOptions(taskFragment.getTask().getBasePackageName(), params.getOpenAnimationResId(), params.getChangeAnimationResId(), params.getCloseAnimationResId(), false);
        animOptions.setUserId(taskFragment.getTask().mUserId);
    L112:
        animOptions = null;
    L89:
        if (activityRecord == null) goto L91;
        TaskFragment organizedTf = activityRecord.getOrganizedTaskFragment();
    L93:
        if (organizedTf != null) goto L95;
    L97:
        if (activityRecord == null) goto L99;
        Task parentTask = activityRecord.getTask();
    L100:
        int backgroundColor = parentTask.getTaskDescription().getBackgroundColor();
    L101:
        change.setBackgroundColor(ColorUtils.setAlphaComponent(backgroundColor, 255));
        goto L103
    L99:
        parentTask = taskFragment.getTask();
        goto L100
    L95:
        if (organizedTf.getAnimationParams().getAnimationBackgroundColor() == 0) goto L97;
        backgroundColor = organizedTf.getAnimationParams().getAnimationBackgroundColor();
        goto L101
    L91:
        organizedTf = taskFragment.getOrganizedTaskFragment();
        goto L93
    L73:
        r4 = 0;
        goto L74
    L76:
        if (isWallpaper(target) == true) goto L78;
    L84:
        change.setEndAbsBounds(bounds);
        goto L85
    L78:
        if (target.mWmService.mFlags.mEnsureWallpaperInTransitions == false) goto L84;
        if (target.getRelativeDisplayRotation() == 0) goto L84;
        if (target.mTransitionController.useShellTransitionsRotation() == true) goto L84;
        change.setEndAbsBounds(parent.getBounds());
        endRotation = parent.getWindowConfiguration().getRotation();
        goto L85
    L55:
        if (topRunningActivity.info.supportsPictureInPicture() == false) goto L57;
        change.setAllowEnterPip(topRunningActivity.checkEnterPictureInPictureAppOpsState());
    L57:
        setEndFixedRotationIfNeeded(change, task, topRunningActivity);
        goto L58
    L61:
        if ((info.mFlags & 1) == 0) goto L63;
        change.setRotationAnimation(3);
        goto L63
    L49:
        r17 = null;
        goto L50
    L43:
        if (taskFragment.isEmbedded() == false) goto L45;
        isEmbeddedTaskFragment = true;
        goto L47
    L34:
        if (change.getMode() != 1) goto L36;
    L39:
        occludedAtEndContainers.add(target.getParent());
        goto L40
    L36:
        if (change.getMode() == 3) goto L39;
        if (change.getMode() != 6) goto L40;
    L24:
        if (change.getMode() != 1) goto L32;
    L17:
        if (info.mStartParent.mRemoteToken == null) goto L21;
        if (target.getParent() == info.mStartParent) goto L21;
        change.setLastParent(info.mStartParent.mRemoteToken.toWindowContainerToken());
        goto L21
    L10:
        r12 = null;
        goto L11
    L129:
        return out;
    }

    private static android.window.TransitionInfo.AnimationOptions calculateAnimationOptionsForActivityTransition(int type, ArrayList<ChangeInfo> sortedTargets) {
        android.window.TransitionInfo.AnimationOptions animOptions = null;
        WindowContainer<?> topApp = null;
        int i = 0;
    L4:
        if (i >= sortedTargets.size()) goto L9;
        if (isWallpaper(sortedTargets.get(i).mContainer) == false) goto L8;
        i = i + 1;
        goto L4
    L8:
        topApp = sortedTargets.get(i).mContainer;
    L9:
        WindowManager.LayoutParams animLp = null;
        if (topApp.asActivityRecord() == null) goto L12;
        ActivityRecord topActivity = topApp.asActivityRecord();
        android.window.TransitionInfo.AnimationOptions animOptions2 = addCustomActivityTransition(topActivity, true, null);
        animOptions = addCustomActivityTransition(topActivity, false, animOptions2);
    L12:
        ActivityRecord animLpActivity = findAnimLayoutParamsActivityRecord(type, sortedTargets);
        if (animLpActivity == null) goto L15;
        WindowState mainWindow = animLpActivity.findMainWindow();
    L16:
        if (mainWindow == null) goto L19;
        animLp = mainWindow.mAttrs;
    L19:
        if (animLp != null) goto L21;
    L27:
        if (animLp != null) goto L29;
        return animOptions;
    L29:
        if (animLp.type != 3) goto L31;
        return animOptions;
    L31:
        if ((animLp.getExt().getPrivateFlags() & JobPackageTracker.EVENT_STOP_REASON_MASK) == 0) goto L40;
        if (animOptions != null) goto L34;
        android.window.TransitionInfo.AnimationOptions animOptions3 = android.window.TransitionInfo.AnimationOptions.makeAnimOptionsFromLayoutParameters(animLp);
        return animOptions3;
    L34:
        animOptions.setObricFlag(animLp.getExt().getPrivateFlags());
        return animOptions;
    L40:
        return animOptions;
    L21:
        if (animLp.type == 3) goto L27;
        if (animLp.windowAnimations == 0) goto L27;
        if (animOptions == null) goto L26;
        animOptions.addOptionsFromLayoutParameters(animLp);
        goto L27
    L26:
        animOptions = android.window.TransitionInfo.AnimationOptions.makeAnimOptionsFromLayoutParameters(animLp);
        animOptions.setUserId(animLpActivity.mUserId);
        goto L27
    L15:
        mainWindow = null;
        goto L16
    }

    private static android.window.TransitionInfo.AnimationOptions addCustomActivityTransition(ActivityRecord activity, boolean open, android.window.TransitionInfo.AnimationOptions animOptions) {
        ActivityRecord.CustomAppTransition customAnim = activity.getCustomAnimation(open);
        if (customAnim == null) goto L7;
        if (animOptions != null) goto L6;
        animOptions = android.window.TransitionInfo.AnimationOptions.makeCommonAnimOptions(activity.packageName);
        animOptions.setUserId(activity.mUserId);
    L6:
        animOptions.addCustomActivityTransition(open, customAnim.mEnterAnim, customAnim.mExitAnim, customAnim.mBackgroundColor);
    L7:
        return animOptions;
    }

    private static void setEndFixedRotationIfNeeded(android.window.TransitionInfo.Change change, Task task, ActivityRecord taskTopRunning) {
        if (taskTopRunning.isVisibleRequested() == true) goto L6;
        return;
    L6:
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == false) goto L8;
    L12:
        int taskRotation = task.getWindowConfiguration().getDisplayRotation();
        int activityRotation = taskTopRunning.getWindowConfiguration().getDisplayRotation();
        if (taskRotation == activityRotation) goto L17;
        change.setEndFixedRotation(activityRotation);
        return;
    L17:
        if (task.inPinnedWindowingMode() == true) goto L19;
        return;
    L19:
        if (taskTopRunning.mDisplayContent.inTransition() == true) goto L30;
        WindowContainer<?> orientationSource = taskTopRunning.mDisplayContent.getLastOrientationSource();
        if (orientationSource != null) goto L24;
        return;
    L24:
        int nextRotation = orientationSource.getWindowConfiguration().getDisplayRotation();
        if (taskRotation == nextRotation) goto L29;
        change.setEndFixedRotation(nextRotation);
        return;
    L29:
        return;
    L30:
        return;
    L8:
        if (task.inMultiWindowMode() == false) goto L12;
        if (taskTopRunning.inMultiWindowMode() == false) goto L12;
    }

    private static WindowContainer<?> findCommonAncestor(ArrayList<ChangeInfo> targets, WindowContainer<?> topApp) {
        int displayId = getDisplayId(topApp);
        WindowContainer<?> ancestor = topApp.getParent();
        int i = targets.size() - 1;
    L3:
        if (i < 0) goto L38;
        ChangeInfo change = targets.get(i);
        WindowContainer wc = change.mContainer;
        if (isWallpaper(wc) == true) goto L36;
        if (getDisplayId(wc) != displayId) goto L36;
        if (change.mStartParent == null) goto L25;
        if (wc.getParent() == null) goto L25;
        if (change.mStartParent.isAttached() == false) goto L25;
        if (wc.getParent() == change.mStartParent) goto L25;
        if (i != (targets.size() - 1)) goto L25;
        int transitionMode = change.getTransitMode(wc);
        if (transitionMode != 2) goto L22;
    L23:
        ancestor = change.mStartParent;
        goto L36
    L22:
        if (transitionMode == 4) goto L23;
    L25:
        if (wc.isDescendantOf(ancestor) == true) goto L27;
        ancestor = ancestor.getParent();
        goto L25
    L27:
        WindowContainer<?> r5 = change.mCommonAncestor;
        if (r5 == null) goto L36;
        if (r5.isAttached() == false) goto L36;
    L32:
        if (r5 == ancestor) goto L36;
        if (r5.isDescendantOf(ancestor) == true) goto L36;
        ancestor = ancestor.getParent();
    L36:
        i = i - 1;
        goto L3
    L38:
        return ancestor;
    }

    private static ActivityRecord findAnimLayoutParamsActivityRecord(int type, ArrayList<ChangeInfo> sortedTargets) {
        ArraySet<Integer> activityTypes = new ArraySet();
        int targetCount = sortedTargets.size();
        int i = 0;
    L4:
        if (i >= targetCount) goto L15;
        WindowContainer target = sortedTargets.get(i).mContainer;
        if (target.asActivityRecord() == null) goto L9;
        activityTypes.add(Integer.valueOf(target.getActivityType()));
    L13:
        i = i + 1;
        goto L4
    L9:
        if (target.asWindowToken() != null) goto L13;
        if (target.asWindowState() != null) goto L13;
        return null;
    L15:
        if (activityTypes.isEmpty() == false) goto L18;
        return null;
    L18:
        return findAnimLayoutParamsActivityRecord(sortedTargets, type, activityTypes);
    }

    private static ActivityRecord findAnimLayoutParamsActivityRecord(List<ChangeInfo> sortedTargets, final int transit, final ArraySet<Integer> activityTypes) {
        ActivityRecord result = lookForTopWindowWithFilter(sortedTargets, new Transition$$ExternalSyntheticLambda9(transit, activityTypes));
        if (result == null) goto L5;
        return result;
    L5:
        ActivityRecord result2 = lookForTopWindowWithFilter(sortedTargets, new Transition$$ExternalSyntheticLambda10());
        if (result2 == null) goto L9;
        return result2;
    L9:
        return lookForTopWindowWithFilter(sortedTargets, new Transition$$ExternalSyntheticLambda11());
    }

    private static /* synthetic */ boolean lambda$findAnimLayoutParamsActivityRecord$11(int transit, ArraySet activityTypes, ActivityRecord w) {
        if (w.getRemoteAnimationDefinition() != null) goto L5;
    L7:
        return false;
    L5:
        if (w.getRemoteAnimationDefinition().hasTransition(transit, activityTypes) == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$findAnimLayoutParamsActivityRecord$12(ActivityRecord w) {
        if (w.fillsParent() == true) goto L5;
    L7:
        return false;
    L5:
        if (w.findMainWindow() == null) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$findAnimLayoutParamsActivityRecord$13(ActivityRecord w) {
        if (w.findMainWindow() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static ActivityRecord lookForTopWindowWithFilter(List<ChangeInfo> sortedTargets, Predicate<ActivityRecord> filter) {
        int count = sortedTargets.size();
        int i = 0;
    L3:
        if (i >= count) goto L14;
        WindowContainer target = sortedTargets.get(i).mContainer;
        if (target.asTaskFragment() == null) goto L7;
        ActivityRecord activityRecord = target.asTaskFragment().getTopNonFinishingActivity();
    L9:
        if (activityRecord == null) goto L13;
        if (filter.test(activityRecord) == false) goto L13;
        return activityRecord;
    L13:
        i = i + 1;
        goto L3
    L7:
        activityRecord = target.asActivityRecord();
        goto L9
    L14:
        return null;
    }

    private static int getTaskRotationAnimation(Task task) {
        ActivityRecord top = task.getTopVisibleActivity();
        if (top != null) goto L5;
        return -1;
    L5:
        WindowState mainWin = top.findMainWindow(false);
        if (mainWin != null) goto L8;
        return -1;
    L8:
        int anim = mainWin.getRotationAnimationHint();
        if (anim < 0) goto L11;
        return anim;
    L11:
        int anim2 = mainWin.mAttrs.rotationAnimation;
        if (anim2 == 3) goto L15;
        return anim2;
    L15:
        if (mainWin == task.mDisplayContent.getDisplayPolicy().getTopFullscreenOpaqueWindow()) goto L17;
    L21:
        return -1;
    L17:
        if (top.matchParentBounds() == false) goto L21;
        return mainWin.mAttrs.rotationAnimation;
    }

    private void validateKeyguardOcclusion() {
        if ((this.mFlags & 47360) == 0) goto L6;
        ArrayList<Runnable> r0 = this.mController.mStateValidators;
        WindowManagerPolicy r1 = this.mController.mAtm.mWindowManager.mPolicy;
        r1.getClass();
        r0.add(new KeyguardController$$ExternalSyntheticLambda0(r1));
        return;
    }

    boolean shouldUsePerfHint(DisplayContent dc) {
        if (this.mOverrideOptions == null) goto L13;
        if (this.mOverrideOptions.getType() != 5) goto L13;
        if (this.mType != 4) goto L13;
        if (this.mParticipants.size() != 1) goto L13;
        return false;
    L13:
        return this.mTargetDisplays.contains(dc);
    }

    boolean shouldApplyOnDisplayThread() {
        int i = this.mParticipants.size() - 1;
    L4:
        if (i < 0) goto L19;
        DisplayContent dc = this.mParticipants.valueAt(i).asDisplayContent();
        if (dc == null) goto L17;
        ChangeInfo changeInfo = this.mChanges.get(dc);
        if (changeInfo == null) goto L17;
        if (changeInfo.mRotation == dc.getRotation()) goto L17;
        if (Looper.myLooper() == this.mController.mAtm.mWindowManager.mH.getLooper()) goto L16;
        return true;
    L16:
        return false;
    L17:
        i = i - 1;
        goto L4
    L19:
        return false;
    }

    void applyDisplayChangeIfNeeded(final ArraySet<WindowContainer<?>> activitiesMayChange) {
        int i = this.mParticipants.size() - 1;
    L3:
        if (i < 0) goto L19;
        WindowContainer<?> wc = this.mParticipants.valueAt(i);
        DisplayContent dc = wc.asDisplayContent();
        if (dc == null) goto L17;
        if (this.mChanges.get(dc).hasChanged() == false) goto L17;
        boolean changed = dc.sendNewConfiguration();
        if (ReadyTrackerOld.m10340$$Nest$fgetmUsed(this.mReadyTrackerOld) == true) goto L12;
        setReady(dc, true);
    L12:
        if (changed == false) goto L17;
        if (this.mController.mAtm.mTaskSupervisor.isRootVisibilityUpdateDeferred() == false) goto L17;
        dc.forAllActivities(new Transition$$ExternalSyntheticLambda6(activitiesMayChange));
    L17:
        i = i - 1;
        goto L3
    }

    private static /* synthetic */ void lambda$applyDisplayChangeIfNeeded$14(ArraySet activitiesMayChange, ActivityRecord r) {
        if (r.isVisibleRequested() == false) goto L6;
        activitiesMayChange.add(r);
        return;
    }

    boolean getLegacyIsReady() {
        if (isCollecting() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mSyncId < 0) goto L7;
        return true;
    }

    static void asyncTraceBegin(String name, int cookie) {
        Trace.asyncTraceForTrackBegin(32, TAG, name, cookie);
    }

    static void asyncTraceEnd(int cookie) {
        Trace.asyncTraceForTrackEnd(32, TAG, cookie);
    }

    @Override // com.android.server.wm.BLASTSyncEngine.TransactionReadyListener
    public void onReadyTraceStart(String name, int id) {
        asyncTraceBegin(name, id);
    }

    @Override // com.android.server.wm.BLASTSyncEngine.TransactionReadyListener
    public void onReadyTraceEnd(String name, int id) {
        asyncTraceEnd(id);
    }

    boolean hasChanged(WindowContainer wc) {
        ChangeInfo chg = this.mChanges.get(wc);
        if (chg != null) goto L7;
        return false;
    L7:
        return chg.hasChanged();
    }

    boolean hasChanges() {
        int i = 0;
    L4:
        if (i >= this.mParticipants.size()) goto L10;
        if (this.mChanges.get(this.mParticipants.valueAt(i)).hasChanged() == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    void recordChain(ActionChain chain) {
        chain.mPrevious = this.mChainHead;
        this.mChainHead = chain;
    }

    void deferTransitionReady() {
        ReadyTrackerOld r0 = this.mReadyTrackerOld;
        ReadyTrackerOld.m10341$$Nest$fputmDeferReadyDepth(r0, ReadyTrackerOld.m10338$$Nest$fgetmDeferReadyDepth(r0) + 1);
        this.mSyncEngine.setReady(this.mSyncId, false);
    }

    void continueTransitionReady() {
        ReadyTrackerOld r0 = this.mReadyTrackerOld;
        ReadyTrackerOld.m10341$$Nest$fputmDeferReadyDepth(r0, ReadyTrackerOld.m10338$$Nest$fgetmDeferReadyDepth(r0) - 1);
        applyReady();
    }

    @Override // com.android.server.wm.BLASTSyncEngine.TransactionReadyListener
    public void onReadyTimeout() {
        if (this.mController.useFullReadyTracking() == true) goto L5;
        Slog.e(TAG, "#" + this.mSyncId + " readiness timeout, used=" + ReadyTrackerOld.m10340$$Nest$fgetmUsed(this.mReadyTrackerOld) + " deferReadyDepth=" + ReadyTrackerOld.m10338$$Nest$fgetmDeferReadyDepth(this.mReadyTrackerOld) + " group=" + ReadyTrackerOld.m10339$$Nest$fgetmReadyGroups(this.mReadyTrackerOld));
    L7:
        if (this.mState < 1) goto L9;
        return;
    L9:
        if (this != this.mController.getCollectingTransition()) goto L13;
        applyDisplayChangeIfNeeded(new ArraySet());
        return;
    L13:
        return;
    L5:
        Slog.e(TAG, "#" + this.mSyncId + " met conditions: " + this.mReadyTracker.mMet);
        Slog.e(TAG, "#" + this.mSyncId + " unmet conditions: " + this.mReadyTracker.mConditions);
        goto L7
    }

    public void updateTransientLaunches(ArrayList<ActivityRecord> launchActivities, Task restoreBelow, ActivityRecord homeActivity) {
        if (this.mTransientLaunches != null) goto L5;
        this.mTransientLaunches = new ArrayMap();
        this.mTransientHideTasks = new ArrayList();
    L5:
        if (homeActivity == null) goto L7;
        this.mTransientLaunches.put(homeActivity, restoreBelow);
    L14:
        this.mTransientHideTasks.add(restoreBelow);
        this.mVisibleAtTransitionEndTokens.clear();
        return;
    L7:
        if (launchActivities == null) goto L14;
        if (launchActivities.isEmpty() == true) goto L14;
        Iterator<ActivityRecord> r0 = launchActivities.iterator();
    L12:
        if (r0.hasNext() == false) goto L14;
        ActivityRecord ar = r0.next();
        this.mTransientLaunches.put(ar, restoreBelow);
        goto L12
    }

    public void handleRecentsStartBehavior(android.window.TransitionInfo info) {
        int i = 0;
    L4:
        if (i >= this.mTargetDisplays.size()) goto L9;
        handleLegacyRecentsStartBehavior(this.mTargetDisplays.get(i), info);
        if (this.mRecentsDisplayId != (-1)) goto L12;
        i = i + 1;
        goto L4
    L12:
        return;
    }

    public IExtTransition getExt() {
        return this.mExt;
    }
}
