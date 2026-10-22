package rx.internal.util;

import java.util.Queue;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.unsafe.e0;
import rx.internal.util.unsafe.i;
import rx.internal.util.unsafe.q;

/* JADX INFO: loaded from: classes4.dex */
public class f implements Subscription {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24424d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Queue f24425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Object f24427c;

    static {
        if (e.b() == false) goto L5;
        int r10 = 16;
    L6:
        String r11 = System.getProperty("rx.ring-buffer.size");
        if (r11 != null) goto L14;
    L12:
        f24424d = r10;
        return;
    L14:
        r10 = Integer.parseInt(r11);     // Catch: NumberFormatException -> L10
    L10:
        e = move-exception;
        System.err.println("Failed to set 'rx.buffer.size' with value " + r11 + " => " + e.getMessage());
        goto L12
    L5:
        r10 = 128;
        goto L6
    }

    public f(Queue r10, int r11) {
        this.f24425a = r10;
        this.f24426b = r11;
    }

    public static f a() {
        if (e0.b() == false) goto L7;
        return new f(true, f24424d);
    L7:
        return new f();
    }

    public Object b(Object r10) {
        return NotificationLite.d(r10);
    }

    public boolean c(Object r10) {
        return NotificationLite.e(r10);
    }

    public void d() {
        if (this.f24427c != null) goto L6;
        this.f24427c = NotificationLite.b();
        return;
    }

    public void e(Object r10) {
        monitor-enter(this);
        Queue r11 = this.f24425a;     // Catch: Throwable -> L6
        boolean r12 = true;
        boolean r13 = false;
        if (r11 == null) goto L8;
        r12 = false;
        r13 = !r11.offer(NotificationLite.g(r10));     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        if (r12 == true) goto L15;
        if (r13 == true) goto L13;
        return;
    L13:
        throw new MissingBackpressureException();
    L15:
        throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
    L6:
        th = move-exception;
        throw th;
    }

    public Object f() {
        monitor-enter(this);
        Queue r10 = this.f24425a;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    L10:
        Object r11 = r10.peek();     // Catch: Throwable -> L8
        Object r12 = this.f24427c;     // Catch: Throwable -> L8
        if (r11 != null) goto L16;
        if (r12 == null) goto L16;
        if (r10.peek() != null) goto L16;
        r11 = r12;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    public Object g() {
        monitor-enter(this);
        Queue r10 = this.f24425a;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return null;
    L9:
        Object r11 = r10.poll();     // Catch: Throwable -> L7
        Object r12 = this.f24427c;     // Catch: Throwable -> L7
        if (r11 != null) goto L15;
        if (r12 == null) goto L15;
        if (r10.peek() != null) goto L15;
        this.f24427c = null;     // Catch: Throwable -> L7
        r11 = r12;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void h() {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (this.f24425a != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        h();
    }

    public f(boolean r10, int r11) {
        if (r10 == false) goto L5;
        Queue r12 = new i(r11);
    L6:
        this.f24425a = r12;
        this.f24426b = r11;
        return;
    L5:
        r12 = new q(r11);
        goto L6
    }

    public f() {
        int r10 = f24424d;
        this(new rx.internal.util.atomic.c(r10), r10);
    }
}
