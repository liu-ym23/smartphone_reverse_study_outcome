package ar7;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ br7.a f16040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f16041b;

    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f16041b;     // Catch: Throwable -> L4
        r100.f16031c = Looper.myQueue();     // Catch: Throwable -> L4
        this.f16041b.c(this.f16040a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(c r100, br7.a r101) {
        this.f16041b = r100;
        this.f16040a = r101;
    }
}
