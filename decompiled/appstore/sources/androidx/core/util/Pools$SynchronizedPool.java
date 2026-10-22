package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public class Pools$SynchronizedPool extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2645c;

    public Pools$SynchronizedPool(int r10) {
        super(r10);
        this.f2645c = new Object();
    }

    @Override // androidx.core.util.d, androidx.core.util.Pools$Pool
    public Object acquire() {
        Object r10 = this.f2645c;
        monitor-enter(r10);
        Object r11 = super.acquire();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.core.util.d, androidx.core.util.Pools$Pool
    public boolean release(Object r10) {
        Object r11 = this.f2645c;
        monitor-enter(r11);
        boolean r12 = super.release(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }
}
