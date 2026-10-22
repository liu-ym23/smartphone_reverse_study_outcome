package com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed;

import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;

/* JADX INFO: loaded from: classes2.dex */
public class ProviderClassNotFoundException implements ExceptionCatcher {
    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean registerCondition() {
        return true;
    }

    public ProviderClassNotFoundException() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean analysis(Object r4, Throwable r5) {
        StackTraceElement[] r3 = Thread.currentThread().getStackTrace();
        if ((r5 instanceof ClassNotFoundException) == false) goto L11;
        int r6 = r3.length;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L11;
        if (r3[r0].getMethodName().contains("installProvider") == true) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }
}
