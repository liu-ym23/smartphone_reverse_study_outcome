package com.android.server.wm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.util.ArraySet;
import android.util.Slog;
import android.window.DisplayWindowPolicyController;
import com.android.server.am.ProcessList;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class DisplayWindowPolicyControllerHelper {
    private static final String TAG = "DisplayWindowPolicyControllerHelper";
    private final DisplayContent mDisplayContent;
    private DisplayWindowPolicyController mDisplayWindowPolicyController;
    private ArraySet<Integer> mRunningUid;
    private ActivityRecord mTopRunningActivity;

    public static /* synthetic */ void $r8$lambda$yfZfl2PliRnd_2KVsTr2KO03HDc(boolean[] r0, ArraySet r1, ActivityRecord r2) {
        lambda$onRunningActivityChanged$0(r0, r1, r2);
    }

    DisplayWindowPolicyControllerHelper(DisplayContent displayContent) {
        this.mTopRunningActivity = null;
        this.mRunningUid = new ArraySet();
        this.mDisplayContent = displayContent;
        this.mDisplayWindowPolicyController = this.mDisplayContent.mWmService.mDisplayManagerInternal.getDisplayWindowPolicyController(this.mDisplayContent.mDisplayId);
    }

    public boolean hasController() {
        if (this.mDisplayWindowPolicyController == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canContainActivities(List<ActivityInfo> activities, int windowingMode) {
        if (this.mDisplayWindowPolicyController != null) goto L17;
        int i = 0;
    L6:
        if (i >= activities.size()) goto L14;
        if (hasDisplayCategory(activities.get(i)) == true) goto L9;
        if (launchAllowedByDisplayPolicy(activities.get(i)) == false) goto L12;
        i = i + 1;
        goto L6
    L12:
        return false;
    L9:
        return false;
    L14:
        return true;
    L17:
        return this.mDisplayWindowPolicyController.canContainActivities(activities, windowingMode);
    }

    public boolean canActivityBeLaunched(ActivityInfo activityInfo, Intent intent, int windowingMode, int launchingFromDisplayId, boolean isNewTask, boolean isResultExpected, Supplier<IntentSender> intentSender) {
        if (this.mDisplayWindowPolicyController != null) goto L13;
        if (hasDisplayCategory(activityInfo) == false) goto L8;
        return false;
    L8:
        if (launchAllowedByDisplayPolicy(activityInfo) == true) goto L10;
        return false;
    L10:
        return true;
    L13:
        return this.mDisplayWindowPolicyController.canActivityBeLaunched(activityInfo, intent, windowingMode, launchingFromDisplayId, isNewTask, isResultExpected, intentSender);
    }

    private boolean hasDisplayCategory(ActivityInfo aInfo) {
        if (aInfo.requiredDisplayCategory == null) goto L6;
        Slog.d(TAG, String.format("Checking activity launch with requiredDisplayCategory='%s' on display %d, which doesn't have a matching category.", new Object[]{aInfo.requiredDisplayCategory, Integer.valueOf(this.mDisplayContent.mDisplayId)}));
        return true;
    L6:
        return false;
    }

    private boolean launchAllowedByDisplayPolicy(ActivityInfo aInfo) {
        int displayType = this.mDisplayContent.getDisplay().getType();
        if (displayType == 5) goto L8;
        if (displayType == 3) goto L8;
        return true;
    L8:
        if ((aInfo.flags & 65536) != 0) goto L11;
        Slog.d(TAG, String.format("Checking activity launch on display %d, activity requires android:canDisplayOnRemoteDevices=true", new Object[]{Integer.valueOf(this.mDisplayContent.mDisplayId)}));
        return false;
    L11:
        return true;
    }

    boolean keepActivityOnWindowFlagsChanged(ActivityInfo aInfo, int flagChanges, int privateFlagChanges, int flagValues, int privateFlagValues) {
        if (this.mDisplayWindowPolicyController != null) goto L6;
        return true;
    L6:
        if (this.mDisplayWindowPolicyController.isInterestedWindowFlags(flagChanges, privateFlagChanges) == true) goto L9;
        return true;
    L9:
        return this.mDisplayWindowPolicyController.keepActivityOnWindowFlagsChanged(aInfo, flagValues, privateFlagValues);
    }

    void onRunningActivityChanged() {
        if (this.mDisplayWindowPolicyController != null) goto L5;
        return;
    L5:
        ActivityRecord topActivity = this.mDisplayContent.getTopActivity(false, true);
        if (topActivity == this.mTopRunningActivity) goto L11;
        this.mTopRunningActivity = topActivity;
        if (topActivity != null) goto L10;
        this.mDisplayWindowPolicyController.onTopActivityChanged(null, -1, ProcessList.INVALID_ADJ);
        goto L11
    L10:
        this.mDisplayWindowPolicyController.onTopActivityChanged(topActivity.info.getComponentName(), topActivity.info.applicationInfo.uid, topActivity.mUserId);
    L11:
        final boolean[] notifyChanged = {false};
        final ArraySet<Integer> runningUids = new ArraySet();
        this.mDisplayContent.forAllActivities(new DisplayWindowPolicyControllerHelper$$ExternalSyntheticLambda0(notifyChanged, runningUids));
        if (notifyChanged[0] == false) goto L14;
    L15:
        this.mRunningUid = runningUids;
        this.mDisplayWindowPolicyController.onRunningAppsChanged(runningUids);
        return;
    L14:
        if (this.mRunningUid.size() != runningUids.size()) goto L15;
    }

    private static /* synthetic */ void lambda$onRunningActivityChanged$0(boolean[] notifyChanged, ArraySet runningUids, ActivityRecord r) {
        if (r.finishing == true) goto L6;
        notifyChanged[0] = notifyChanged[0] | runningUids.add(Integer.valueOf(r.getUid()));
        return;
    }

    public final boolean isWindowingModeSupported(int windowingMode) {
        if (this.mDisplayWindowPolicyController != null) goto L7;
        return true;
    L7:
        return this.mDisplayWindowPolicyController.isWindowingModeSupported(windowingMode);
    }

    public final boolean canShowTasksInHostDeviceRecents() {
        if (this.mDisplayWindowPolicyController != null) goto L7;
        return true;
    L7:
        return this.mDisplayWindowPolicyController.canShowTasksInHostDeviceRecents();
    }

    public final boolean isEnteringPipAllowed(int uid) {
        if (this.mDisplayWindowPolicyController != null) goto L7;
        return true;
    L7:
        return this.mDisplayWindowPolicyController.isEnteringPipAllowed(uid);
    }

    public ComponentName getCustomHomeComponent() {
        if (this.mDisplayWindowPolicyController != null) goto L7;
        return null;
    L7:
        return this.mDisplayWindowPolicyController.getCustomHomeComponent();
    }

    void dump(String prefix, PrintWriter pw) {
        if (this.mDisplayWindowPolicyController == null) goto L6;
        pw.println();
        this.mDisplayWindowPolicyController.dump(prefix, pw);
        return;
    }
}
