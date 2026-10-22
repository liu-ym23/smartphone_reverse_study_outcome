package a5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.a f1870a;

    @Override // java.lang.Runnable
    public final void run() {
        l r100 = this.f1870a.f1861b.f1858e.get();     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        r100.d(-1, this.f1870a.f1861b.f1857d);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public f(b.a r100) {
        this.f1870a = r100;
    }
}
