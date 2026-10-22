package androidx.databinding;

import androidx.core.util.Pools$SynchronizedPool;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pools$SynchronizedPool f2913f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c.a f2914g = null;

    public static class a extends c.a {
        public a() {
        }

        @Override // androidx.databinding.c.a
        public /* bridge */ /* synthetic */ void a(Object r10, Object r11, int r12, Object r13) {
            b((ObservableList.a) r10, (ObservableList) r11, r12, (b) r13);
        }

        public void b(ObservableList.a r10, ObservableList r11, int r12, b r13) {
            if (r12 != 1) goto L5;
            r10.b(r11, r13.f2915a, r13.f2916b);
            return;
        L5:
            if (r12 != 2) goto L7;
            r10.c(r11, r13.f2915a, r13.f2916b);
            return;
        L7:
            if (r12 != 3) goto L9;
            r10.d(r11, r13.f2915a, r13.f2917c, r13.f2916b);
            return;
        L9:
            if (r12 == 4) goto L11;
            r10.a(r11);
            return;
        L11:
            r10.e(r11, r13.f2915a, r13.f2916b);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2917c;

        public b() {
        }
    }

    static {
        f2913f = new Pools$SynchronizedPool(10);
        f2914g = new a();
    }

    public f() {
        super(f2914g);
    }

    public static b l(int r10, int r11, int r12) {
        b r13 = (b) f2913f.acquire();
        if (r13 != null) goto L5;
        r13 = new b();
    L5:
        r13.f2915a = r10;
        r13.f2917c = r11;
        r13.f2916b = r12;
        return r13;
    }

    public synchronized void m(ObservableList r10, int r11, b r12) {
        monitor-enter(this);
        super.d(r10, r11, r12);     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        f2913f.release(r12);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void n(ObservableList r10, int r11, int r12) {
        m(r10, 1, l(r11, 0, r12));
    }

    public void o(ObservableList r10, int r11, int r12) {
        m(r10, 2, l(r11, 0, r12));
    }

    public void p(ObservableList r10, int r11, int r12) {
        m(r10, 4, l(r11, 0, r12));
    }
}
