package cc4;

import com.larus.apm.impl.protector.RunnableProtector;
import qb4.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f23266a;

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (g.a(this.f23266a) == true) goto L11;
        int r100 = g.f23272l;     // Catch: Throwable -> L8
        if (r100 >= 3) goto L15;
        g.f23272l = r100 + 1;     // Catch: Throwable -> L8
        g r101 = this.f23266a;     // Catch: Throwable -> L8
        r101.getClass();     // Catch: Throwable -> L8
        c0.a.f532328a.b(new f(r101), 2000);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }

    public f(g r100) {
        this.f23266a = r100;
    }
}
