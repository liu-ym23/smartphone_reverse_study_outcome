package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f3445k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i.b f3447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f3450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f3451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f3455j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveData f3456a;

        public a(LiveData r10) {
            this.f3456a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = this.f3456a.f3446a;
            monitor-enter(r10);
            Object r11 = this.f3456a.f3451f;     // Catch: Throwable -> L8
            LiveData r12 = this.f3456a;     // Catch: Throwable -> L8
            r12.f3451f = LiveData.f3445k;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            this.f3456a.p(r11);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public class b extends d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LiveData f3457e;

        public b(LiveData r10, Observer r11) {
            this.f3457e = r10;
            super(r10, r11);
        }

        @Override // androidx.lifecycle.LiveData.d
        public boolean d() {
            return true;
        }
    }

    public class c extends d implements LifecycleEventObserver {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LifecycleOwner f3458e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LiveData f3459f;

        public c(LiveData r10, LifecycleOwner r11, Observer r12) {
            this.f3459f = r10;
            super(r10, r12);
            this.f3458e = r11;
        }

        @Override // androidx.lifecycle.LiveData.d
        public void b() {
            this.f3458e.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.LiveData.d
        public boolean c(LifecycleOwner r10) {
            if (this.f3458e != r10) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LiveData.d
        public boolean d() {
            return this.f3458e.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            Lifecycle.State r12 = this.f3458e.getLifecycle().b();
            if (r12 != Lifecycle.State.DESTROYED) goto L6;
            this.f3459f.n(this.f3460a);
            return;
        L6:
            Lifecycle.State r13 = null;
        L7:
            if (r13 == r12) goto L9;
            a(d());
            Lifecycle.State r14 = this.f3458e.getLifecycle().b();
            r13 = r12;
            r12 = r14;
            goto L7
        }
    }

    public abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer f3460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3462c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LiveData f3463d;

        public d(LiveData r10, Observer r11) {
            this.f3463d = r10;
            this.f3462c = -1;
            this.f3460a = r11;
        }

        public void a(boolean r10) {
            if (r10 != this.f3461b) goto L5;
            return;
        L5:
            this.f3461b = r10;
            LiveData r11 = this.f3463d;
            if (r10 == false) goto L8;
            int r12 = 1;
        L9:
            r11.b(r12);
            if (this.f3461b == false) goto L13;
            this.f3463d.d(this);
            return;
        L13:
            return;
        L8:
            r12 = -1;
            goto L9
        }

        public void b() {
        }

        public boolean c(LifecycleOwner r10) {
            return false;
        }

        public abstract boolean d();
    }

    static {
        f3445k = new Object();
    }

    public LiveData(Object r10) {
        this.f3446a = new Object();
        this.f3447b = new i.b();
        this.f3448c = 0;
        this.f3451f = f3445k;
        this.f3455j = new a(this);
        this.f3450e = r10;
        this.f3452g = 0;
    }

    public static void a(String r10) {
        if (h.c.h().c() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r10 + " on a background thread");
    }

    public void b(int r10) {
        int r11 = this.f3448c;
        this.f3448c = r10 + r11;
        if (this.f3449d == false) goto L5;
        return;
    L5:
        this.f3449d = true;
    L28:
        int r12 = this.f3448c;     // Catch: Throwable -> L19
        if (r11 == r12) goto L24;
        if (r11 != 0) goto L12;
        if (r12 <= 0) goto L12;
        boolean r13 = true;
    L13:
        if (r11 <= 0) goto L16;
        if (r12 != 0) goto L16;
        boolean r14 = true;
    L17:
        if (r13 == false) goto L21;
        k();     // Catch: Throwable -> L19
    L23:
        r11 = r12;
        goto L28
    L21:
        if (r14 == false) goto L23;
        l();     // Catch: Throwable -> L19
    L16:
        r14 = false;
    L12:
        r13 = false;
        goto L13
    L24:
        this.f3449d = false;
        return;
    L19:
        th = move-exception;
        this.f3449d = false;
        throw th;
    }

    public final void c(d r10) {
        if (r10.f3461b == true) goto L6;
        return;
    L6:
        if (r10.d() == true) goto L9;
        r10.a(false);
        return;
    L9:
        int r11 = r10.f3462c;
        int r12 = this.f3452g;
        if (r11 < r12) goto L12;
        return;
    L12:
        r10.f3462c = r12;
        r10.f3460a.onChanged(this.f3450e);
    }

    public void d(d r10) {
        if (this.f3453h == false) goto L6;
        this.f3454i = true;
        return;
    L6:
        this.f3453h = true;
    L7:
        this.f3454i = false;
        if (r10 == null) goto L10;
        c(r10);
        r10 = null;
    L16:
        if (this.f3454i == true) goto L7;
        this.f3453h = false;
        return;
    L10:
        i.b.d r11 = this.f3447b.c();
    L12:
        if (r11.hasNext() == false) goto L16;
        c((d) ((Map.Entry) r11.next()).getValue());
        if (this.f3454i == false) goto L12;
        goto L16
    }

    public Object e() {
        Object r10 = this.f3450e;
        if (r10 == f3445k) goto L5;
        return r10;
    L5:
        return null;
    }

    public int f() {
        return this.f3452g;
    }

    public boolean g() {
        if (this.f3448c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f3450e == f3445k) goto L5;
        return true;
    L5:
        return false;
    }

    public void i(LifecycleOwner r10, Observer r11) {
        a("observe");
        if (r10.getLifecycle().b() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        c r12 = new c(this, r10, r11);
        d r13 = (d) this.f3447b.f(r11, r12);
        if (r13 != null) goto L8;
    L12:
        if (r13 == null) goto L14;
        return;
    L14:
        r10.getLifecycle().a(r12);
        return;
    L8:
        if (r13.c(r10) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void j(Observer r10) {
        a("observeForever");
        b r11 = new b(this, r10);
        d r12 = (d) this.f3447b.f(r10, r11);
        if ((r12 instanceof c) == true) goto L9;
        if (r12 == null) goto L6;
        return;
    L6:
        r11.a(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void k() {
    }

    public void l() {
    }

    public void m(Object r10) {
        Object r11 = this.f3446a;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f3451f != f3445k) goto L7;
        boolean r12 = true;
    L8:
        this.f3451f = r10;     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        if (r12 == true) goto L12;
        return;
    L12:
        h.c.h().d(this.f3455j);
        return;
    L7:
        r12 = false;
        goto L8
    }

    public void n(Observer r10) {
        a("removeObserver");
        d r11 = (d) this.f3447b.g(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.b();
        r11.a(false);
    }

    public void o(LifecycleOwner r10) {
        a("removeObservers");
        Iterator r11 = this.f3447b.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((d) r12.getValue()).c(r10) == false) goto L4;
        n((Observer) r12.getKey());
        goto L4
    }

    public void p(Object r10) {
        a("setValue");
        this.f3452g++;
        this.f3450e = r10;
        d(null);
    }

    public LiveData() {
        this.f3446a = new Object();
        this.f3447b = new i.b();
        this.f3448c = 0;
        Object r10 = f3445k;
        this.f3451f = r10;
        this.f3455j = new a(this);
        this.f3450e = r10;
        this.f3452g = -1;
    }
}
