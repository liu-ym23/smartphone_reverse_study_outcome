package cc4;

import com.larus.apm.impl.protector.RunnableProtector;
import qb4.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f23265a;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (g.a(this.f23265a) == true) goto L9;
        g r100 = this.f23265a;     // Catch: Throwable -> L6
        r100.getClass();     // Catch: Throwable -> L6
        c0.a.f532328a.b(new f(r100), 3000);     // Catch: Throwable -> L6
        return;
    }

    public e(g r100) {
        this.f23265a = r100;
    }
}
