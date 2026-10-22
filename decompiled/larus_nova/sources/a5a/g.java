package a5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.a f1872b;

    @Override // java.lang.Runnable
    public final void run() {
        l r100 = this.f1872b.f1861b.f1858e.get();     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        r100.d(this.f1871a, this.f1872b.f1861b.f1857d);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public g(b.a r100, int r101) {
        this.f1872b = r100;
        this.f1871a = r101;
    }
}
