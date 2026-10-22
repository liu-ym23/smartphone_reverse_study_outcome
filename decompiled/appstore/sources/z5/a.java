package z5;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements ExceptionCatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f26287a;

    static {
        ArrayList r10 = new ArrayList();
        f26287a = r10;
        r10.add("FILE_PROVIDER_PATHS");
        f26287a.add("NullPointerException");
        f26287a.add("Failed to resolve canonical path");
        f26287a.add("android.os.DeadSystemException");
        f26287a.add("Package manager has died");
    }

    public a() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean analysis(Object r10, Throwable r11) {
        StackTraceElement[] r12 = Thread.currentThread().getStackTrace();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L15;
        if (r12[r14].getMethodName().contains("installProvider") == false) goto L14;
        if (r11 == null) goto L14;
        String r15 = r11.toString();
        Iterator r16 = f26287a.iterator();
    L9:
        if (r16.hasNext() == false) goto L14;
        String r17 = (String) r16.next();
        if (r15.contains(r17) == false) goto L9;
        Logger.a("ProviderInstallFailed", "Hint the crash " + r17);
        return true;
    L14:
        r14 = r14 + 1;
        goto L3
    L15:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean registerCondition() {
        return true;
    }
}
