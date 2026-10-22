package ai4;

import android.app.ApplicationExitInfo;
import android.os.Build;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.crash.monitor.a f3769b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = this.f3768a.iterator();     // Catch: Throwable -> L19
    L3:
        if (r100.hasNext() == false) goto L30;
        ApplicationExitInfo r101 = (ApplicationExitInfo) r100.next();     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT < 30) goto L16;
        int r102 = r101.getImportance();     // Catch: Throwable -> L19
        if (n.f3775c == true) goto L16;
        if (r102 >= 0) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L16;
    L11:
        if (r102 >= 300) goto L13;
        r103 = true;
    L16:
        n.a(this.f3769b, r101);     // Catch: Throwable -> L19
        goto L3
    L30:
        return;
    }

    public h(List r100, com.bytedance.crash.monitor.a r101) {
        this.f3768a = r100;
        this.f3769b = r101;
    }
}
