package com.android.ttcjpaysdk.base.performance;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;

/* JADX INFO: loaded from: classes28.dex */
public abstract class CompileOnlyManager {
    private volatile int installStatus;

    public abstract boolean checkInstall();

    public boolean isInstall() {
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CompileOnlyManager#isInstall", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CompileOnlyManager#isInstall", e);
    L14:
        if (this.installStatus != 1) goto L19;
        return true;
    L19:
        return false;
    L4:
        if (this.installStatus != (-1)) goto L14;
        if (checkInstall() == false) goto L8;
        int r100 = 1;
    L9:
        this.installStatus = r100;     // Catch: Exception -> L11
        goto L14
    L8:
        r100 = 0;
        goto L9
    }

    public CompileOnlyManager() {
        this.installStatus = -1;
    }
}
