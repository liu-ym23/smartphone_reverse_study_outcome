package a5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.a f1868a;

    @Override // java.lang.Runnable
    public final void run() {
        l r100 = this.f1868a.f1861b.f1858e.get();     // Catch: Throwable -> L9
        if (r100 == null) goto L12;
        b r101 = r100.f1887d;     // Catch: Throwable -> L9
        if (r101 == null) goto L16;
        r101.b();     // Catch: Throwable -> L9
        l.a(r100.f1887d);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }

    public d(b.a r100) {
        this.f1868a = r100;
    }
}
