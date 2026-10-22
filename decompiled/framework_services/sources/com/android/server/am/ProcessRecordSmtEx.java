package com.android.server.am;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public class ProcessRecordSmtEx extends ProcessRecordSmtBase {
    public long HighPriorityTime;
    boolean coldLaunchDone;
    public Configuration mSmtFreeFormConfig;
    int not3rdReasonFlag;

    public ProcessRecordSmtEx(ProcessRecord processRecord) {
        super(processRecord);
        this.HighPriorityTime = 0;
        this.coldLaunchDone = false;
        this.mSmtFreeFormConfig = new Configuration();
        this.not3rdReasonFlag = -1;
    }

    public void setRemoved(boolean removed) {
    }

    @Override // com.android.server.am.ProcessRecordSmtBase, com.android.server.wm.WindowProcessListenerSmtBase
    public void bringProcessToDefaultLocked() {
    }

    public void changeStringNameForUpdatePcMode() {
    }
}
