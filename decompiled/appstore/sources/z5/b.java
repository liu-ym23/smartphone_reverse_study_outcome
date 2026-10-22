package z5;

import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;

/* JADX INFO: loaded from: classes.dex */
public class b implements ExceptionCatcher {
    public b() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean analysis(Object r10, Throwable r11) {
        StackTraceElement[] r12 = Thread.currentThread().getStackTrace();
        if ((r11 instanceof ClassNotFoundException) == false) goto L11;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L11;
        if (r12[r14].getMethodName().contains("installProvider") == true) goto L8;
        r14 = r14 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean registerCondition() {
        return true;
    }
}
