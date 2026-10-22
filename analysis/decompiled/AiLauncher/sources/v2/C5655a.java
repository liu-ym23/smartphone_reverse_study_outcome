package v2;

import android.os.Process;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5655a extends Thread {
    public C5655a(ThreadGroup threadGroup, String str) {
        super(threadGroup, "GmsDynamite");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(19);
        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }
}
