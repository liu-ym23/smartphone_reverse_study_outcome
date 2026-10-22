package com.android.server.wm;

import android.content.pm.ApplicationInfo;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class RootWindowContainerSmtBase extends ConfigurationContainerSysEx {
    protected RootWindowContainer mContainer;
    WindowState mHoldPcScreenWindow;
    boolean mPhoneStateIdel;

    public RootWindowContainerSmtBase(RootWindowContainer container) {
        super(container);
        this.mHoldPcScreenWindow = null;
        this.mPhoneStateIdel = true;
        this.mContainer = container;
    }

    boolean canShowSysDialog() {
        return true;
    }

    protected void dispatchVisibleWindowChanged(String title, String packageName) {
        int i = 0;
    L4:
        if (i >= this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.size()) goto L7;
        this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.get(i).onVisibleWindowAdd(title, packageName);
        i = i + 1;
        goto L4
    }

    protected void dispatchVisibleWindowCleared() {
        int i = 0;
    L4:
        if (i >= this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.size()) goto L7;
        this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.get(i).onVisibleWindowClear();
        i = i + 1;
        goto L4
    }

    protected void dispatchVisibleUidsChanged(HashSet<Integer> oldVisibleUids, HashSet<Integer> visibleUids) {
        HashSet<Integer> addedUids = new HashSet();
        addedUids.addAll(visibleUids);
        addedUids.removeAll(oldVisibleUids);
        HashSet<Integer> removedUids = new HashSet();
        removedUids.addAll(oldVisibleUids);
        removedUids.removeAll(visibleUids);
        if (addedUids.size() <= 0) goto L5;
    L6:
        int i = 0;
    L8:
        if (i >= this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.size()) goto L12;
        this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.get(i).onVisibleUidsChange(addedUids, removedUids);
        i = i + 1;
        goto L8
    L12:
        return;
    L5:
        if (removedUids.size() > 0) goto L6;
    }

    protected void dispatchVisibleApplicationInfosChanged(HashSet<ApplicationInfo> oldVisibleApplicationInfos, HashSet<ApplicationInfo> visibleApplicationInfos) {
        HashSet<ApplicationInfo> addedApplicationInfos = new HashSet();
        addedApplicationInfos.addAll(visibleApplicationInfos);
        addedApplicationInfos.removeAll(oldVisibleApplicationInfos);
        HashSet<ApplicationInfo> removedApplicationInfos = new HashSet();
        removedApplicationInfos.addAll(oldVisibleApplicationInfos);
        removedApplicationInfos.removeAll(visibleApplicationInfos);
        if (addedApplicationInfos.size() <= 0) goto L5;
    L6:
        int i = 0;
    L8:
        if (i >= this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.size()) goto L12;
        this.mContainer.mWmService.getSmtEx().mVisibleWindowChangeListeners.get(i).onVisibleApplicationInfosChange(addedApplicationInfos, removedApplicationInfos, visibleApplicationInfos);
        i = i + 1;
        goto L8
    L12:
        return;
    L5:
        if (removedApplicationInfos.size() > 0) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.android.server.wm.WindowContainer] */
    public String isAnyDisplayTaskTopLocked(String pkg) {
        int displayNdx = this.mContainer.getChildCount() - 1;
    L3:
        if (displayNdx < 0) goto L28;
        DisplayContent display = this.mContainer.getChildAt(displayNdx);
        Task topTask = display.getTopMostTask();
        if (topTask == null) goto L27;
        if (topTask.getTopMostActivity() == null) goto L27;
        if (pkg.equals(topTask.getTopMostActivity().packageName) == false) goto L27;
        int taskNdx = display.getChildCount() - 1;
    L11:
        if (taskNdx < 0) goto L27;
        DisplayArea area = (DisplayArea) display.getChildAt(taskNdx);
        if (area == null) goto L26;
        if (area.getChildCount() <= 0) goto L26;
        if (area.getChildAt(0) == 0) goto L26;
        ActivityRecord bottom = area.getChildAt(0).getBottomMostActivity();
        if (bottom == null) goto L26;
        if (bottom.packageName == null) goto L26;
        if (bottom.packageName.equals(pkg) == true) goto L26;
        return bottom.packageName;
    L26:
        taskNdx = taskNdx - 1;
    L27:
        displayNdx = displayNdx - 1;
        goto L3
    L28:
        return null;
    }
}
