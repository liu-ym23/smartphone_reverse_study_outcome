package cl7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f24127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.b f24128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f24129c;

    public d(c r100, c.b r101, b r102, a r103) {
        this.f24127a = r100;
        this.f24128b = r101;
        this.f24129c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f24127a;     // Catch: Throwable -> L6
        c.b r101 = this.f24128b;     // Catch: Throwable -> L6
        r100.getClass();     // Catch: Throwable -> L6
        c.c(r101);     // Catch: Throwable -> L6
        b r102 = this.f24129c;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
