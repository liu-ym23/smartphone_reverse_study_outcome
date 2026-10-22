package b96;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18310b;

    public f(String r100, String r101) {
        this.f18309a = r100;
        this.f18310b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = x86.a.f562912a;     // Catch: Throwable -> L4
        x86.a.a(this.f18309a, this.f18310b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
