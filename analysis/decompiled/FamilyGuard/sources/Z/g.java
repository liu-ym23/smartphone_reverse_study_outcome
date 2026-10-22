package Z;

import a0.AbstractC0407a;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.util.Log;
import d0.C0646a;
import d0.InterfaceC0647b;
import d0.InterfaceC0648c;
import d0.InterfaceC0650e;
import d0.InterfaceC0651f;
import e0.C0679c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    protected volatile InterfaceC0647b f6568a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f6569b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0648c f6570c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6572e;

    /* renamed from: f, reason: collision with root package name */
    boolean f6573f;

    /* renamed from: g, reason: collision with root package name */
    protected List<b> f6574g;

    /* renamed from: h, reason: collision with root package name */
    private final ReentrantLock f6575h = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    private final e f6571d = d();

    public static class a<T extends g> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f6576a;

        /* renamed from: b, reason: collision with root package name */
        private final String f6577b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f6578c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<b> f6579d;

        /* renamed from: e, reason: collision with root package name */
        private Executor f6580e;

        /* renamed from: f, reason: collision with root package name */
        private InterfaceC0648c.InterfaceC0205c f6581f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f6582g;

        /* renamed from: h, reason: collision with root package name */
        private c f6583h = c.AUTOMATIC;

        /* renamed from: i, reason: collision with root package name */
        private boolean f6584i = true;

        /* renamed from: j, reason: collision with root package name */
        private final d f6585j = new d();

        /* renamed from: k, reason: collision with root package name */
        private Set<Integer> f6586k;

        /* renamed from: l, reason: collision with root package name */
        private Set<Integer> f6587l;

        a(Context context, Class<T> cls, String str) {
            this.f6578c = context;
            this.f6576a = cls;
            this.f6577b = str;
        }

        public a<T> a(b bVar) {
            if (this.f6579d == null) {
                this.f6579d = new ArrayList<>();
            }
            this.f6579d.add(bVar);
            return this;
        }

        public a<T> b(AbstractC0407a... abstractC0407aArr) {
            if (this.f6587l == null) {
                this.f6587l = new HashSet();
            }
            for (AbstractC0407a abstractC0407a : abstractC0407aArr) {
                this.f6587l.add(Integer.valueOf(abstractC0407a.f6685a));
                this.f6587l.add(Integer.valueOf(abstractC0407a.f6686b));
            }
            this.f6585j.b(abstractC0407aArr);
            return this;
        }

        public T c() {
            if (this.f6578c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.f6576a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            if (this.f6580e == null) {
                this.f6580e = m.c.g();
            }
            Set<Integer> set = this.f6587l;
            if (set != null && this.f6586k != null) {
                for (Integer num : set) {
                    if (this.f6586k.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            if (this.f6581f == null) {
                this.f6581f = new C0679c();
            }
            Context context = this.f6578c;
            Z.a aVar = new Z.a(context, this.f6577b, this.f6581f, this.f6585j, this.f6579d, this.f6582g, this.f6583h.b(context), this.f6580e, this.f6584i, this.f6586k);
            T t5 = (T) f.b(this.f6576a, "_Impl");
            t5.l(aVar);
            return t5;
        }
    }

    public static abstract class b {
        public void a(InterfaceC0647b interfaceC0647b) {
        }

        public void b(InterfaceC0647b interfaceC0647b) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        c b(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (activityManager == null || androidx.core.app.b.a(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private q.j<q.j<AbstractC0407a>> f6592a = new q.j<>();

        private void a(AbstractC0407a abstractC0407a) {
            int i5 = abstractC0407a.f6685a;
            int i6 = abstractC0407a.f6686b;
            q.j<AbstractC0407a> jVarG = this.f6592a.g(i5);
            if (jVarG == null) {
                jVarG = new q.j<>();
                this.f6592a.j(i5, jVarG);
            }
            AbstractC0407a abstractC0407aG = jVarG.g(i6);
            if (abstractC0407aG != null) {
                Log.w("ROOM", "Overriding migration " + abstractC0407aG + " with " + abstractC0407a);
            }
            jVarG.b(i6, abstractC0407a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0019 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.util.List<a0.AbstractC0407a> d(java.util.List<a0.AbstractC0407a> r10, boolean r11, int r12, int r13) {
            /*
                r9 = this;
                r0 = -1
                r1 = 1
                if (r11 == 0) goto L6
                r2 = r0
                goto L7
            L6:
                r2 = r1
            L7:
                if (r11 == 0) goto Lc
                if (r12 >= r13) goto L47
                goto Le
            Lc:
                if (r12 <= r13) goto L47
            Le:
                q.j<q.j<a0.a>> r3 = r9.f6592a
                java.lang.Object r3 = r3.g(r12)
                q.j r3 = (q.j) r3
                r4 = 0
                if (r3 != 0) goto L1a
                return r4
            L1a:
                int r5 = r3.k()
                r6 = 0
                if (r11 == 0) goto L25
                int r5 = r5 + (-1)
                r7 = r0
                goto L27
            L25:
                r7 = r5
                r5 = r6
            L27:
                if (r5 == r7) goto L44
                int r8 = r3.i(r5)
                if (r11 == 0) goto L34
                if (r8 > r13) goto L42
                if (r8 <= r12) goto L42
                goto L38
            L34:
                if (r8 < r13) goto L42
                if (r8 >= r12) goto L42
            L38:
                java.lang.Object r12 = r3.l(r5)
                r10.add(r12)
                r6 = r1
                r12 = r8
                goto L44
            L42:
                int r5 = r5 + r2
                goto L27
            L44:
                if (r6 != 0) goto L7
                return r4
            L47:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: Z.g.d.d(java.util.List, boolean, int, int):java.util.List");
        }

        public void b(AbstractC0407a... abstractC0407aArr) {
            for (AbstractC0407a abstractC0407a : abstractC0407aArr) {
                a(abstractC0407a);
            }
        }

        public List<AbstractC0407a> c(int i5, int i6) {
            if (i5 == i6) {
                return Collections.EMPTY_LIST;
            }
            return d(new ArrayList(), i6 > i5, i5, i6);
        }
    }

    private static boolean n() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a() {
        if (!this.f6572e && n()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void b() {
        a();
        InterfaceC0647b interfaceC0647bB = this.f6570c.b();
        this.f6571d.k(interfaceC0647bB);
        interfaceC0647bB.g();
    }

    public InterfaceC0651f c(String str) {
        a();
        return this.f6570c.b().p(str);
    }

    protected abstract e d();

    protected abstract InterfaceC0648c e(Z.a aVar);

    public void f() {
        this.f6570c.b().P();
        if (k()) {
            return;
        }
        this.f6571d.f();
    }

    Lock g() {
        return this.f6575h;
    }

    public e h() {
        return this.f6571d;
    }

    public InterfaceC0648c i() {
        return this.f6570c;
    }

    public Executor j() {
        return this.f6569b;
    }

    public boolean k() {
        return this.f6570c.b().i0();
    }

    public void l(Z.a aVar) {
        InterfaceC0648c interfaceC0648cE = e(aVar);
        this.f6570c = interfaceC0648cE;
        boolean z5 = aVar.f6537g == c.WRITE_AHEAD_LOGGING;
        interfaceC0648cE.a(z5);
        this.f6574g = aVar.f6535e;
        this.f6569b = aVar.f6538h;
        this.f6572e = aVar.f6536f;
        this.f6573f = z5;
    }

    protected void m(InterfaceC0647b interfaceC0647b) {
        this.f6571d.e(interfaceC0647b);
    }

    public boolean o() {
        InterfaceC0647b interfaceC0647b = this.f6568a;
        return interfaceC0647b != null && interfaceC0647b.isOpen();
    }

    public Cursor p(InterfaceC0650e interfaceC0650e) {
        a();
        return this.f6570c.b().a0(interfaceC0650e);
    }

    public Cursor q(String str, Object[] objArr) {
        return this.f6570c.b().a0(new C0646a(str, objArr));
    }

    public void r(Runnable runnable) {
        b();
        try {
            runnable.run();
            s();
        } finally {
            f();
        }
    }

    public void s() {
        this.f6570c.b().B();
    }
}
