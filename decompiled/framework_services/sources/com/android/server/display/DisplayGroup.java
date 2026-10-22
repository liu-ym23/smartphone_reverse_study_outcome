package com.android.server.display;

import android.util.IndentingPrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayGroup {
    private int mChangeCount;
    private final List<LogicalDisplay> mDisplays;
    private final int mGroupId;

    DisplayGroup(int groupId) {
        this.mDisplays = new ArrayList();
        this.mGroupId = groupId;
    }

    int getGroupId() {
        return this.mGroupId;
    }

    void addDisplayLocked(LogicalDisplay display) {
        if (containsLocked(display) == true) goto L6;
        this.mChangeCount++;
        this.mDisplays.add(display);
        return;
    }

    boolean containsLocked(LogicalDisplay display) {
        return this.mDisplays.contains(display);
    }

    boolean removeDisplayLocked(LogicalDisplay display) {
        this.mChangeCount++;
        return this.mDisplays.remove(display);
    }

    boolean isEmptyLocked() {
        return this.mDisplays.isEmpty();
    }

    int getChangeCountLocked() {
        return this.mChangeCount;
    }

    int getSizeLocked() {
        return this.mDisplays.size();
    }

    int getIdLocked(int index) {
        return this.mDisplays.get(index).getDisplayIdLocked();
    }

    int[] getIdsLocked() {
        int numDisplays = this.mDisplays.size();
        int[] displayIds = new int[numDisplays];
        int i = 0;
    L3:
        if (i >= numDisplays) goto L6;
        displayIds[i] = this.mDisplays.get(i).getDisplayIdLocked();
        i = i + 1;
        goto L3
    L6:
        return displayIds;
    }

    void dumpLocked(IndentingPrintWriter ipw) {
        int numDisplays = this.mDisplays.size();
        int i = 0;
    L3:
        if (i >= numDisplays) goto L6;
        LogicalDisplay logicalDisplay = this.mDisplays.get(i);
        ipw.println("Display " + logicalDisplay.getDisplayIdLocked() + " " + logicalDisplay.getPrimaryDisplayDeviceLocked());
        i = i + 1;
        goto L3
    }
}
