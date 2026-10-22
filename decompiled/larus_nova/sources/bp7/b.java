package bp7;

import android.content.Context;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f19984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f19985b;

    @Override // java.lang.Runnable
    public final void run() {
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        this.f19985b.a();     // Catch: Throwable -> L18
        if (this.f19984a == false) goto L16;
        Context r100 = this.f19985b.f19988a;     // Catch: Throwable -> L18
        if (wo7.b.f560527d != null) goto L16;
        monitor-enter(wo7.b.class);     // Catch: Throwable -> L18
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L9:
        if (wo7.b.f560527d != null) goto L11;
        wo7.b.f560527d = new wo7.b(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(wo7.b.class);     // Catch: Throwable -> L13
    L16:
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L22;
        return;
    L22:
        throw th;
    }

    public b(d r100, boolean r101) {
        this.f19985b = r100;
        this.f19984a = r101;
    }
}
