package a5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LogBoxLogLevel f1882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f1883b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f1883b.d(-1, this.f1882a);     // Catch: Throwable -> L6
        b r100 = this.f1883b.f1887d;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.f1860g = Boolean.TRUE;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public k(l r100, LogBoxLogLevel r101) {
        this.f1883b = r100;
        this.f1882a = r101;
    }
}
