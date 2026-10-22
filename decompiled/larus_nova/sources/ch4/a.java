package ch4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (b.f23762d == null) goto L9;
        c.b r100 = new c.b("npthStart");     // Catch: Throwable -> L6
        r100.f23771b = b.f23762d.f23763a;     // Catch: Throwable -> L6
        r100.a();     // Catch: Throwable -> L6
        b.f23762d = null;     // Catch: Throwable -> L6
        return;
    }
}
