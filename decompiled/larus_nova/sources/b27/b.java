package b27;

import com.bytedance.monitor.collector.AbsMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsMonitor f17032b;

    @Override // java.lang.Runnable
    public final void run() {
        AbsMonitor r100 = this.f17032b;     // Catch: Throwable -> L11
        int r101 = r100.f265560b;     // Catch: Throwable -> L11
        if (r101 > (-1)) goto L6;
        return;
    L6:
        if (r101 != 2) goto L18;
        int r102 = r100.f265561c;     // Catch: Throwable -> L11
        int r103 = this.f17031a;     // Catch: Throwable -> L11
        if (r102 == r103) goto L19;
        r100.f265561c = r103;     // Catch: Throwable -> L11
        r100.d(r103);     // Catch: Throwable -> L11
        return;
    L19:
        return;
    L18:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }

    public b(AbsMonitor r100, int r101) {
        this.f17032b = r100;
        this.f17031a = r101;
    }
}
