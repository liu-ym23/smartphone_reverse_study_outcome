package H;

import android.os.Process;

/* loaded from: classes.dex */
public final class j extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final int f684a;

    public j(Runnable runnable, String str, int i4) {
        super(runnable, str);
        this.f684a = i4;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(this.f684a);
        super.run();
    }
}
