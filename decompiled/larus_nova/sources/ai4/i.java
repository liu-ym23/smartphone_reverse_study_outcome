package ai4;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements Runnable {
    public i() {
    }

    public static void a() {
        new PolarisFileWrapper(n.f3778f, "custom_data").listFiles(new j());     // Catch: Throwable -> L4
    L6:
        if (n.f3776d.exists() == true) goto L9;
        return;
    L9:
        if (n.f3782j == true) goto L25;
        n.f3782j = true;
        File[] r100 = n.f3776d.listFiles(new l());
        if (r100 != null) goto L14;
        return;
    L14:
        if (r100.length <= 20) goto L23;
        Arrays.sort(r100, new m());
        int r101 = 0;
    L17:
        if (r101 >= (r100.length - 20)) goto L26;
        com.bytedance.crash.util.h.b(r100[r101]);
        r101 = r101 + 1;
        goto L17
    L26:
        return;
    L23:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
