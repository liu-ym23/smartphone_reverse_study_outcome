package com.android.server.wm;

import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class EnsureActivitiesVisibleHelper {
    private boolean mAboveTop;
    private boolean mBehindFullyOccludedContainer;
    private boolean mContainerShouldBeVisible;
    private boolean mNotifyClients;
    private ActivityRecord mStarting;
    private final TaskFragment mTaskFragment;
    private ActivityRecord mTopRunningActivity;

    /* JADX INFO: renamed from: $r8$lambda$QjmemDRlAMjTs9p6w-73LC8Uhds, reason: not valid java name */
    public static /* synthetic */ void m9989$r8$lambda$QjmemDRlAMjTs9p6w73LC8Uhds(ArrayList r0, TaskFragment r1) {
        lambda$process$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$pFgq3mv7pWvdD6HY9d3CCGkWB-g, reason: not valid java name */
    public static /* synthetic */ boolean m9990$r8$lambda$pFgq3mv7pWvdD6HY9d3CCGkWBg(ActivityRecord r0, TaskFragment r1) {
        return lambda$process$0(r0, r1);
    }

    EnsureActivitiesVisibleHelper(TaskFragment container) {
        this.mTaskFragment = container;
    }

    void reset(ActivityRecord starting, boolean notifyClients) {
        this.mStarting = starting;
        this.mTopRunningActivity = this.mTaskFragment.topRunningActivity();
        if (this.mTopRunningActivity == null) goto L5;
        boolean r0 = true;
    L6:
        this.mAboveTop = r0;
        this.mContainerShouldBeVisible = this.mTaskFragment.shouldBeVisible(this.mStarting);
        this.mBehindFullyOccludedContainer = !this.mContainerShouldBeVisible;
        this.mNotifyClients = notifyClients;
        return;
    L5:
        r0 = false;
        goto L6
    }

    void process(final ActivityRecord starting, boolean notifyClients) {
        reset(starting, notifyClients);
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L6;
        Slog.v("ActivityTaskManager", "ensureActivitiesVisible behind " + this.mTopRunningActivity);
    L6:
        if (this.mTopRunningActivity == null) goto L11;
        if (this.mTaskFragment.asTask() == null) goto L11;
        this.mTaskFragment.asTask().checkTranslucentActivityWaiting(this.mTopRunningActivity);
    L11:
        if (this.mTopRunningActivity != null) goto L13;
    L20:
        boolean resumeTopActivity = false;
    L21:
        ArrayList<TaskFragment> adjacentTaskFragments = null;
        int i = this.mTaskFragment.mChildren.size() - 1;
    L22:
        if (i < 0) goto L64;
        WindowContainer child = (WindowContainer) this.mTaskFragment.mChildren.get(i);
        TaskFragment childTaskFragment = child.asTaskFragment();
        if (childTaskFragment == null) goto L60;
        if (childTaskFragment.getTopNonFinishingActivity() == null) goto L60;
        childTaskFragment.updateActivityVisibilities(starting, notifyClients);
        boolean r7 = this.mBehindFullyOccludedContainer;
        if (childTaskFragment.getBounds().equals(this.mTaskFragment.getBounds()) == true) goto L30;
    L32:
        boolean r8 = false;
    L33:
        this.mBehindFullyOccludedContainer = r7 | r8;
        if (this.mAboveTop == false) goto L39;
        if (this.mTopRunningActivity.getTaskFragment() != childTaskFragment) goto L39;
        this.mAboveTop = false;
    L39:
        if (this.mBehindFullyOccludedContainer == true) goto L62;
        if (adjacentTaskFragments != null) goto L43;
    L54:
        boolean isTranslucent = childTaskFragment.hasAdjacentTaskFragment();
        if (isTranslucent == false) goto L62;
        if (adjacentTaskFragments != null) goto L58;
        adjacentTaskFragments = new ArrayList();
    L58:
        final ArrayList<TaskFragment> adjacentTfs = adjacentTaskFragments;
        childTaskFragment.forOtherAdjacentTaskFragments(new EnsureActivitiesVisibleHelper$$ExternalSyntheticLambda1(adjacentTfs));
        goto L62
    L43:
        if (adjacentTaskFragments.contains(childTaskFragment) == false) goto L54;
        if (childTaskFragment.isTranslucent(starting) == false) goto L47;
    L50:
        boolean isTranslucent2 = true;
    L52:
        if (isTranslucent2 == true) goto L62;
        this.mBehindFullyOccludedContainer = true;
        goto L62
    L47:
        if (childTaskFragment.forOtherAdjacentTaskFragments(new EnsureActivitiesVisibleHelper$$ExternalSyntheticLambda0(starting)) == true) goto L50;
        isTranslucent2 = false;
    L62:
        i = i - 1;
        goto L22
    L30:
        if (childTaskFragment.isTranslucent(starting) == true) goto L32;
        r8 = true;
    L60:
        if (child.asActivityRecord() == null) goto L62;
        setActivityVisibilityState(child.asActivityRecord(), starting, resumeTopActivity);
        goto L62
    L64:
        return;
    L13:
        if (this.mTopRunningActivity.mLaunchTaskBehind == true) goto L20;
        if (this.mTaskFragment.canBeResumed(starting) == false) goto L20;
        if (starting != null) goto L18;
    L19:
        resumeTopActivity = true;
        goto L21
    L18:
        if (starting.isDescendantOf(this.mTaskFragment) == true) goto L20;
        goto L19
    }

    private static /* synthetic */ boolean lambda$process$0(ActivityRecord starting, TaskFragment adjacentTaskFragment) {
        return adjacentTaskFragment.isTranslucent(starting);
    }

    private static /* synthetic */ void lambda$process$1(ArrayList adjacentTfs, TaskFragment adjacentTf) {
        adjacentTfs.add(adjacentTf);
    }

    private void setActivityVisibilityState(ActivityRecord r, ActivityRecord starting, boolean resumeTopActivity) {
        boolean r1 = false;
        if (r != this.mTopRunningActivity) goto L5;
        boolean isTop = true;
    L7:
        if (this.mAboveTop == false) goto L11;
        if (isTop == true) goto L11;
        r.makeInvisible();
        return;
    L11:
        this.mAboveTop = false;
        r.updateVisibilityIgnoringKeyguard(this.mBehindFullyOccludedContainer);
        boolean reallyVisible = r.shouldBeVisibleUnchecked();
        if (r.visibleIgnoringKeyguard == false) goto L21;
        if (r.occludesParent() == true) goto L16;
        this.mBehindFullyOccludedContainer = false;
    L24:
        if (r.app == null) goto L30;
        if ((r.app.getWPCSmtEx().unfreezeReason & 3) == 0) goto L30;
        Slog.i("AMS.Freeze", "proc:" + r.app + " return, at setActivityVisibilityState");
        return;
    L30:
        if (reallyVisible == false) goto L83;
        if (r.finishing == false) goto L35;
        return;
    L35:
        if (r.isState(ActivityRecord.State.STOPPING, ActivityRecord.State.STOPPED) == false) goto L43;
        if (r.hasProcess() == false) goto L43;
        if (r.app.getWPCSmtEx().freezingStat == 0) goto L43;
        r.app.getWPCSmtEx().unFreezeProcIfNeedLocked(new UpdateVisibilityEvent(r.app));
        Slog.i("AMS.Freeze", "unFreezeProcIfNeedLocked proc:" + r.app + " for UpdateVisibilityEvent, at setActivityVisibilityState");
        return;
    L43:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L46;
        Slog.v("ActivityTaskManager", "Make visible? " + r + " finishing=" + r.finishing + " state=" + r.getState());
    L46:
        if (r == this.mStarting) goto L53;
        if (this.mNotifyClients == false) goto L53;
        if (isTop == true) goto L51;
        r.mDisplayContent.applyFixedRotationForNonTopVisibleActivityIfNeeded(r);
    L51:
        r.ensureActivityConfiguration(true);
    L53:
        if (r.attachedToProcess() == true) goto L55;
    L77:
        ActivityRecord r7 = this.mStarting;
        if (resumeTopActivity == false) goto L81;
        if (isTop == false) goto L81;
        r1 = true;
    L81:
        makeVisibleAndRestartIfNeeded(r7, r1, r);
    L87:
        if (this.mBehindFullyOccludedContainer == false) goto L89;
        return;
    L89:
        if (this.mTaskFragment.isActivityTypeHome() == true) goto L91;
        return;
    L91:
        if (r.isRootOfTask() == true) goto L93;
        return;
    L93:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L95;
        Slog.v("ActivityTaskManager", "Home task: at " + this.mTaskFragment + " containerShouldBeVisible=" + this.mContainerShouldBeVisible + " behindOccludedParentContainer=" + this.mBehindFullyOccludedContainer);
    L95:
        this.mBehindFullyOccludedContainer = true;
        return;
    L55:
        if (r.app.hasThread() == true) goto L60;
        if (r.app.getWPCSmtEx().freezingStat == 0) goto L77;
    L60:
        if (r.isVisibleRequested() == true) goto L62;
        r.makeVisibleIfNeeded(this.mStarting, this.mNotifyClients);
        goto L87
    L62:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L65;
        Slog.v("ActivityTaskManager", "Skipping: already visible at " + r);
    L65:
        if (r.mClientVisibilityDeferred == true) goto L67;
    L73:
        r.handleAlreadyVisible();
        if (this.mNotifyClients == false) goto L87;
        r.makeActiveIfNeeded(this.mStarting);
        goto L87
    L67:
        if (this.mNotifyClients == false) goto L73;
        if (r.mClientVisibilityDeferred == false) goto L71;
        ActivityRecord r8 = null;
    L72:
        r.makeActiveIfNeeded(r8);
        r.mClientVisibilityDeferred = false;
        goto L73
    L71:
        r8 = starting;
        goto L72
    L83:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L85;
        Slog.v("ActivityTaskManager", "Make invisible? " + r + " finishing=" + r.finishing + " state=" + r.getState() + " containerShouldBeVisible=" + this.mContainerShouldBeVisible + " behindFullyOccludedContainer=" + this.mBehindFullyOccludedContainer + " mLaunchTaskBehind=" + r.mLaunchTaskBehind);
    L85:
        r.makeInvisible();
        goto L87
    L16:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L18;
        Slog.v("ActivityTaskManager", "Fullscreen: at " + r + " containerVisible=" + this.mContainerShouldBeVisible + " behindFullyOccluded=" + this.mBehindFullyOccludedContainer);
    L18:
        this.mBehindFullyOccludedContainer = true;
        goto L24
    L21:
        if (r.isState(ActivityRecord.State.INITIALIZING) == false) goto L24;
        r.cancelInitializing();
        goto L24
    L5:
        isTop = false;
        goto L7
    }

    private void makeVisibleAndRestartIfNeeded(ActivityRecord starting, boolean andResume, ActivityRecord r) {
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L6;
        Slog.v("ActivityTaskManager", "Start and freeze screen for " + r);
    L6:
        if (r.isVisibleRequested() == false) goto L10;
        if (r.mLaunchTaskBehind == true) goto L10;
    L13:
        if (r != starting) goto L15;
        return;
    L15:
        if (this.mNotifyClients == false) goto L19;
        this.mTaskFragment.mTaskSupervisor.startSpecificActivity(r, andResume, true);
        return;
    L19:
        return;
    L10:
        if (ActivityTaskManagerDebugConfig.DEBUG_VISIBILITY == false) goto L12;
        Slog.v("ActivityTaskManager", "Starting and making visible: " + r);
    L12:
        r.setVisibility(true);
        goto L13
    }
}
