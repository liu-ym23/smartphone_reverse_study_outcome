package bv7;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f20947a;

    public a(Runnable r100) {
        this.f20947a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);     // Catch: Throwable -> L5
        this.f20947a.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
