package androidx.core.os;

import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CancellationSignal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OnCancelListener f2569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2571d;

    public interface OnCancelListener {
        void onCancel();
    }

    public static class a {
        @DoNotInline
        public static void a(Object r10) {
            ((android.os.CancellationSignal) r10).cancel();
        }

        @DoNotInline
        public static android.os.CancellationSignal b() {
            return new android.os.CancellationSignal();
        }
    }

    public CancellationSignal() {
    }

    public void a() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f2568a == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.f2568a = true;     // Catch: Throwable -> L7
        this.f2571d = true;     // Catch: Throwable -> L7
        OnCancelListener r10 = this.f2569b;     // Catch: Throwable -> L7
        Object r11 = this.f2570c;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r10 != null) goto L40;
    L16:
        if (r11 == null) goto L26;
        a.a(r11);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        monitor-enter(this);
        this.f2571d = false;     // Catch: Throwable -> L23
        notifyAll();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L26:
        monitor-enter(this);
        this.f2571d = false;     // Catch: Throwable -> L30
        notifyAll();     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L40:
        r10.onCancel();     // Catch: Throwable -> L14
        goto L16
    }

    public final void b() {
    L3:
        if (this.f2571d == false) goto L6;
        wait();     // Catch: InterruptedException -> L7
        goto L3
    }

    public void setOnCancelListener(@Nullable OnCancelListener r10) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L7
        if (this.f2569b != r10) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.f2569b = r10;     // Catch: Throwable -> L7
        if (this.f2568a == false) goto L16;
        if (r10 == null) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L7
        r10.onCancel();
        return;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
