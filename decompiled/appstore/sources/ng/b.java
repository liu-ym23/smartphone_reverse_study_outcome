package ng;

import rx.Observer;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;

/* JADX INFO: loaded from: classes4.dex */
public class b implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer f22455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f22457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f22458d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f22459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22460b;

        public a() {
        }

        public void a(Object r10) {
            int r11 = this.f22460b;
            Object[] r12 = this.f22459a;
            if (r12 != null) goto L6;
            r12 = new Object[16];
            this.f22459a = r12;
        L8:
            r12[r11] = r10;
            this.f22460b = r11 + 1;
            return;
        L6:
            if (r11 != r12.length) goto L8;
            Object[] r13 = new Object[(r11 >> 2) + r11];
            System.arraycopy(r12, 0, r13, 0, r11);
            this.f22459a = r13;
            r12 = r13;
            goto L8
        }
    }

    public b(Observer r10) {
        this.f22455a = r10;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.f22457c == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f22457c == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.f22457c = true;     // Catch: Throwable -> L10
        if (this.f22456b == false) goto L20;
        a r10 = this.f22458d;     // Catch: Throwable -> L10
        if (r10 != null) goto L17;
        r10 = new a();     // Catch: Throwable -> L10
        this.f22458d = r10;     // Catch: Throwable -> L10
    L17:
        r10.a(NotificationLite.b());     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.f22456b = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.f22455a.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        rx.exceptions.a.e(r10);
        if (this.f22457c == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f22457c == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.f22457c = true;     // Catch: Throwable -> L10
        if (this.f22456b == false) goto L20;
        a r11 = this.f22458d;     // Catch: Throwable -> L10
        if (r11 != null) goto L17;
        r11 = new a();     // Catch: Throwable -> L10
        this.f22458d = r11;     // Catch: Throwable -> L10
    L17:
        r11.a(NotificationLite.c(r10));     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.f22456b = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.f22455a.onError(r10);
    }

    @Override // rx.Observer
    public void onNext(Object r10) {
        if (this.f22457c == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f22457c == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.f22456b == false) goto L20;
        a r11 = this.f22458d;     // Catch: Throwable -> L10
        if (r11 != null) goto L17;
        r11 = new a();     // Catch: Throwable -> L10
        this.f22458d = r11;     // Catch: Throwable -> L10
    L17:
        r11.a(NotificationLite.g(r10));     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.f22456b = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.f22455a.onNext(r10);     // Catch: Throwable -> L49
    L23:
        monitor-enter(this);
        a r12 = this.f22458d;     // Catch: Throwable -> L29
        int r13 = 0;
        if (r12 == null) goto L26;
        this.f22458d = null;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        Object[] r14 = r12.f22459a;
        int r15 = r14.length;
    L34:
        if (r13 >= r15) goto L23;
        Object r16 = r14[r13];
        if (r16 == null) goto L23;
    L42:
        th = move-exception;
        this.f22457c = true;
        rx.exceptions.a.e(th);
        this.f22455a.onError(OnErrorThrowable.addValueAsLastCause(th, r10));
        return;
    L39:
        if (NotificationLite.a(this.f22455a, r16) == true) goto L40;
        r13 = r13 + 1;
        goto L34
    L40:
        this.f22457c = true;     // Catch: Throwable -> L42
        return;
    L26:
        this.f22456b = false;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L49:
        th = move-exception;
        this.f22457c = true;
        rx.exceptions.a.g(th, this.f22455a, r10);
    }
}
