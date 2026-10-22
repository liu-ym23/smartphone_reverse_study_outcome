package as3;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f16091a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f16091a.i();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public a(b r100) {
        this.f16091a = r100;
    }
}
