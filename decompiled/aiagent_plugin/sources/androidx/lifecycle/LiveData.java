package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f1930b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f1931a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile Object f1933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private androidx.a.a.b.b<w<? super T>, LiveData<T>.b> f1934e;
    private boolean f;
    private volatile Object g;
    private int h;
    private boolean i;
    private boolean j;
    private final Runnable k;

    class LifecycleBoundObserver extends LiveData<T>.b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final p f1936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LiveData f1937b;

        LifecycleBoundObserver(LiveData r3, p r4, w<? super T> r5) {
            p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
            w r7 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            this.f1937b = r3;
            super(r3, r7);
            this.f1936a = r6;
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a() {
            return this.f1936a.getLifecycle().b().a(i.b.f2057d);
        }

        @Override // androidx.lifecycle.m
        public void onStateChanged(p r3, i.a r4) {
            p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
            i.b r6 = this.f1936a.getLifecycle().b();
            if (r6 != i.b.f2054a) goto L6;
            this.f1937b.b(this.f1939c);
            return;
        L6:
            i.b r7 = null;
        L7:
            if (r7 == r6) goto L9;
            a(a());
            i.b r8 = this.f1936a.getLifecycle().b();
            r7 = r6;
            r6 = r8;
            goto L7
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a(p r3) {
            p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
            if (this.f1936a != r4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LiveData.b
        void b() {
            this.f1936a.getLifecycle().b(this);
        }
    }

    private class a extends LiveData<T>.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LiveData f1938a;

        @Override // androidx.lifecycle.LiveData.b
        boolean a() {
            return true;
        }

        a(LiveData r3, w<? super T> r4) {
            w r5 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            this.f1938a = r3;
            super(r3, r5);
        }
    }

    private abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final w<? super T> f1939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1941e;
        final /* synthetic */ LiveData f;

        abstract boolean a();

        boolean a(p r2) {
            p r1 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.aiagent.plugin");
            return false;
        }

        void b() {
        }

        b(LiveData r3, w<? super T> r4) {
            w<? super T> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.f1941e = -1;
            this.f1939c = r5;
        }

        void a(boolean r2) {
            if (r2 != this.f1940d) goto L5;
            return;
        L5:
            this.f1940d = r2;
            LiveData r0 = this.f;
            if (r2 == false) goto L8;
            int r3 = 1;
        L9:
            r0.a(r3);
            if (this.f1940d == false) goto L13;
            this.f.a(this);
            return;
        L13:
            return;
        L8:
            r3 = -1;
            goto L9
        }
    }

    public void b() {
    }

    public void c() {
    }

    static {
        f1930b = new Object();
    }

    public LiveData(T r3) {
        this.f1931a = new Object();
        this.f1934e = new androidx.a.a.b.b();
        this.f1932c = 0;
        this.f1933d = f1930b;
        this.k = new AnonymousClass1(this);
        this.g = r3;
        this.h = 0;
    }

    public LiveData() {
        this.f1931a = new Object();
        this.f1934e = new androidx.a.a.b.b();
        this.f1932c = 0;
        Object r0 = f1930b;
        this.f1933d = r0;
        this.k = new AnonymousClass1(this);
        this.g = r0;
        this.h = -1;
    }

    private void b(LiveData<T>.b r3) {
        if (r3.f1940d == true) goto L6;
        return;
    L6:
        if (r3.a() == true) goto L9;
        r3.a(false);
        return;
    L9:
        int r0 = r3.f1941e;
        int r1 = this.h;
        if (r0 < r1) goto L12;
        return;
    L12:
        r3.f1941e = r1;
        r3.f1939c.onChanged((Object) this.g);
    }

    void a(LiveData<T>.b r6) {
        if (this.i == false) goto L6;
        this.j = true;
        return;
    L6:
        this.i = true;
    L7:
        this.j = false;
        if (r6 == null) goto L10;
        b(r6);
        r6 = null;
    L16:
        if (this.j == true) goto L7;
        this.i = false;
        return;
    L10:
        androidx.a.a.b.b<w<? super T>, LiveData<T>.b>.d r1 = this.f1934e.c();
    L12:
        if (r1.hasNext() == false) goto L16;
        b((b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), b.class, "com.obric.aiagent.plugin"));
        if (this.j == false) goto L12;
        goto L16
    }

    public void a(p r4, w<? super T> r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        w<? super T> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
        a("observe");
        if (r6.getLifecycle().b() != i.b.f2054a) goto L5;
        return;
    L5:
        LifecycleBoundObserver r0 = new LifecycleBoundObserver(this, r6, r7);
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f1934e.a(r7, r0), b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
    L12:
        if (r3 == null) goto L14;
        return;
    L14:
        r6.getLifecycle().a(r0);
        return;
    L8:
        if (r3.a(r6) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void a(w<? super T> r3) {
        w<? super T> r4 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
        a("observeForever");
        a r0 = new a(this, r4);
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f1934e.a(r4, r0), b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, LifecycleBoundObserver.class) == true) goto L9;
        if (r2 == null) goto L6;
        return;
    L6:
        r0.a(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void b(w<? super T> r3) {
        w<? super T> r4 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
        a("removeObserver");
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f1934e.b(r4), b.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        r2.b();
        r2.a(false);
    }

    public void a(T r4) {
        Object r0 = this.f1931a;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f1933d != f1930b) goto L7;
        boolean r1 = true;
    L8:
        this.f1933d = r4;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (r1 == true) goto L12;
        return;
    L12:
        androidx.a.a.a.a.a().b(this.k);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void b(T r2) {
        a("setValue");
        this.h++;
        this.g = r2;
        a(null);
    }

    public T a() {
        T r1 = (T) this.g;
        if (r1 == f1930b) goto L5;
        return r1;
    L5:
        return null;
    }

    public boolean d() {
        if (this.f1932c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void a(int r5) {
        int r0 = this.f1932c;
        this.f1932c = r5 + r0;
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
    L27:
        int r2 = this.f1932c;     // Catch: Throwable -> L24
        if (r0 == r2) goto L22;
        if (r0 != 0) goto L12;
        if (r2 <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r0 <= 0) goto L16;
        if (r2 != 0) goto L16;
        boolean r1 = true;
    L17:
        if (r3 == false) goto L19;
        b();     // Catch: Throwable -> L24
    L21:
        r0 = r2;
        goto L27
    L19:
        if (r1 == false) goto L21;
        c();     // Catch: Throwable -> L24
    L16:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    L22:
        this.f = false;
        return;
    L24:
        th = move-exception;
        this.f = false;
        throw th;
    }

    static void a(String r3) {
        if (androidx.a.a.a.a.a().c() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r3 + " on a background thread");
    }
}
