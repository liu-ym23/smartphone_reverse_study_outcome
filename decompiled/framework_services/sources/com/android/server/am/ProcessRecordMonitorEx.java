package com.android.server.am;

import android.util.SmtUidUtil;

/* JADX INFO: loaded from: classes.dex */
public class ProcessRecordMonitorEx {
    public boolean isolatedOf3rdPartApp;
    protected ProcessRecord mProcessRecord;
    int smtUid;

    public ProcessRecordMonitorEx(ProcessRecord record) {
        this.smtUid = 1000;
        this.mProcessRecord = record;
    }

    public int getSmtUid(int uid, String packageName) {
        if (uid == 1000) goto L5;
        return uid;
    L5:
        if (this.smtUid != 1000) goto L7;
        this.smtUid = SmtUidUtil.getSystemUidForPackage(packageName);
    L7:
        int result = this.smtUid;
        return result;
    }

    public int getSmtUid() {
        int result = this.mProcessRecord.uid;
        if (this.mProcessRecord.info == null) goto L6;
        int result2 = getSmtUid(this.mProcessRecord.info.uid, this.mProcessRecord.info.packageName);
        return result2;
    L6:
        return result;
    }
}
