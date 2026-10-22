package com.android.server.wm;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class WindowProcessControllerSmtEx extends WindowProcessControllerSmtBase {
    WindowProcessControllerSmtEx(WindowProcessController _host) {
        super(_host);
    }

    void getActivityRecordsForPackage(String packageName, ArrayList<ActivityRecord> records) {
        if (records != null) goto L4;
        return;
    L4:
        int i = 0;
    L6:
        if (i >= this.host.mActivities.size()) goto L9;
        ActivityRecord r1 = this.host.mActivities.get(i);
        i = i + 1;
        goto L6
    }

    @Override // com.android.server.wm.WindowProcessControllerSmtBase
    void bringProcessToDefaultLocked() {
        if (this.listener != null) goto L5;
        return;
    }

    void changeStringNameForUpdatePcMode() {
        if (this.listener != null) goto L5;
        return;
    }

    public int getUid() {
        return this.host.mUid;
    }

    boolean checkFrozenState(ActivityRecord next) {
        if (next.hasProcess() == true) goto L5;
        return false;
    L5:
        if (next.app.hasThread() == false) goto L7;
        return false;
    L7:
        if ((this.unfreezeReason & 2) != 0) goto L9;
        this.unfreezeReason |= 2;
    L9:
        ((WindowProcessControllerSmtEx) next.app.getWPCSmtEx()).unFreezeForLaunchType = 2;
        return true;
    }
}
