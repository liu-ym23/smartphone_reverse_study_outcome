package bt3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f20542a;

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        ((Runnable) ((LinkedTransferQueue) this.f20542a.f20544b).take()).run();     // Catch: Throwable -> L4 InterruptedException -> L6
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L4
        goto L13
    }

    public d(e r100) {
        this.f20542a = r100;
    }
}
