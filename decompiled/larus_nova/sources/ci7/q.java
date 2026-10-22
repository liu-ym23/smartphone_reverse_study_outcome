package ci7;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f23880a;

    @Override // java.lang.Runnable
    public final void run() {
        r.a.f23882a.a(this.f23880a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(Context r100) {
        this.f23880a = r100;
    }
}
