package androidx.core.os;

import android.os.Build;
import android.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CancellationSignal.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f1265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f1266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1267d;

    /* JADX INFO: compiled from: CancellationSignal.java */
    static class a {
        static void a(Object r2) {
            ((CancellationSignal) ZeusTransformUtils.preCheckCast(r2, CancellationSignal.class, "com.obric.aiagent.plugin")).cancel();
        }

        static CancellationSignal a() {
            return new CancellationSignal();
        }
    }

    /* JADX INFO: compiled from: CancellationSignal.java */
    public interface b {
        void a();
    }

    public f() {
    }

    public boolean a() {
        monitor-enter(this);
        boolean r0 = this.f1264a;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void b() {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L4:
        if (this.f1264a == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L33
        return;
    L7:
        this.f1264a = true;     // Catch: Throwable -> L33
        this.f1267d = true;     // Catch: Throwable -> L33
        b r0 = this.f1265b;     // Catch: Throwable -> L33
        Object r1 = this.f1266c;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r0 != null) goto L36;
    L14:
        if (r1 != null) goto L16;
    L26:
        monitor-enter(this);
        this.f1267d = false;     // Catch: Throwable -> L30
        notifyAll();     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L16:
        if (Build.VERSION.SDK_INT < 16) goto L26;
        a.a(r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        monitor-enter(this);
        this.f1267d = false;     // Catch: Throwable -> L23
        notifyAll();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L36:
        r0.a();     // Catch: Throwable -> L12
        goto L14
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        c();     // Catch: Throwable -> L17
        if (this.f1265b != r4) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L8:
        this.f1265b = r4;     // Catch: Throwable -> L17
        if (this.f1264a == false) goto L15;
        if (r4 == null) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L17
        r4.a();
        return;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void c() {
    L3:
        if (this.f1267d == false) goto L6;
        wait();     // Catch: InterruptedException -> L7
        goto L3
    }
}
