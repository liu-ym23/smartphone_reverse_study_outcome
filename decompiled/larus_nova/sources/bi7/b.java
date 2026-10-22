package bi7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f19144a;

    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f19144a;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        System.currentTimeMillis();     // Catch: Throwable -> L4
        r100.a(ci7.d.b(r100.f19145a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        fi7.d.a("", "", null, false);     // Catch: Throwable -> L7
        th.printStackTrace();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public b(c r100) {
        this.f19144a = r100;
    }
}
