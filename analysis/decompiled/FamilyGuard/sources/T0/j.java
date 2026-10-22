package T0;

import C0.k;
import C0.q;
import C0.v;
import Y0.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.libpag.BuildConfig;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public final class j<R> implements d, U0.d, i, a.f {

    /* renamed from: C, reason: collision with root package name */
    private static final D.e<j<?>> f5348C = Y0.a.d(150, new a());

    /* renamed from: D, reason: collision with root package name */
    private static final boolean f5349D = Log.isLoggable("Request", 2);

    /* renamed from: A, reason: collision with root package name */
    private int f5350A;

    /* renamed from: B, reason: collision with root package name */
    private RuntimeException f5351B;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5352a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5353b;

    /* renamed from: c, reason: collision with root package name */
    private final Y0.c f5354c;

    /* renamed from: d, reason: collision with root package name */
    private g<R> f5355d;

    /* renamed from: e, reason: collision with root package name */
    private e f5356e;

    /* renamed from: f, reason: collision with root package name */
    private Context f5357f;

    /* renamed from: g, reason: collision with root package name */
    private v0.e f5358g;

    /* renamed from: h, reason: collision with root package name */
    private Object f5359h;

    /* renamed from: i, reason: collision with root package name */
    private Class<R> f5360i;

    /* renamed from: j, reason: collision with root package name */
    private T0.a<?> f5361j;

    /* renamed from: k, reason: collision with root package name */
    private int f5362k;

    /* renamed from: l, reason: collision with root package name */
    private int f5363l;

    /* renamed from: m, reason: collision with root package name */
    private v0.g f5364m;

    /* renamed from: n, reason: collision with root package name */
    private U0.e<R> f5365n;

    /* renamed from: o, reason: collision with root package name */
    private List<g<R>> f5366o;

    /* renamed from: p, reason: collision with root package name */
    private C0.k f5367p;

    /* renamed from: q, reason: collision with root package name */
    private V0.c<? super R> f5368q;

    /* renamed from: r, reason: collision with root package name */
    private Executor f5369r;

    /* renamed from: s, reason: collision with root package name */
    private v<R> f5370s;

    /* renamed from: t, reason: collision with root package name */
    private k.d f5371t;

    /* renamed from: u, reason: collision with root package name */
    private long f5372u;

    /* renamed from: v, reason: collision with root package name */
    private b f5373v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f5374w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f5375x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f5376y;

    /* renamed from: z, reason: collision with root package name */
    private int f5377z;

    class a implements a.d<j<?>> {
        a() {
        }

        @Override // Y0.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j<?> a() {
            return new j<>();
        }
    }

    private enum b {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    j() {
        this.f5353b = f5349D ? String.valueOf(super.hashCode()) : null;
        this.f5354c = Y0.c.a();
    }

    private void A() {
        e eVar = this.f5356e;
        if (eVar != null) {
            eVar.c(this);
        }
    }

    public static <R> j<R> B(Context context, v0.e eVar, Object obj, Class<R> cls, T0.a<?> aVar, int i5, int i6, v0.g gVar, U0.e<R> eVar2, g<R> gVar2, List<g<R>> list, e eVar3, C0.k kVar, V0.c<? super R> cVar, Executor executor) {
        j<?> jVarB = f5348C.b();
        if (jVarB == null) {
            jVarB = new j<>();
        }
        j<R> jVar = (j<R>) jVarB;
        jVar.t(context, eVar, obj, cls, aVar, i5, i6, gVar, eVar2, gVar2, list, eVar3, kVar, cVar, executor);
        return jVar;
    }

    private synchronized void C(q qVar, int i5) {
        boolean zH;
        try {
            this.f5354c.c();
            qVar.k(this.f5351B);
            int iF = this.f5358g.f();
            if (iF <= i5) {
                Log.w("Glide", "Load failed for " + this.f5359h + " with size [" + this.f5377z + "x" + this.f5350A + "]", qVar);
                if (iF <= 4) {
                    qVar.g("Glide");
                }
            }
            this.f5371t = null;
            this.f5373v = b.FAILED;
            boolean z5 = true;
            this.f5352a = true;
            try {
                List<g<R>> list = this.f5366o;
                if (list != null) {
                    Iterator<g<R>> it = list.iterator();
                    zH = false;
                    while (it.hasNext()) {
                        zH |= it.next().h(qVar, this.f5359h, this.f5365n, u());
                    }
                } else {
                    zH = false;
                }
                g<R> gVar = this.f5355d;
                if (gVar == null || !gVar.h(qVar, this.f5359h, this.f5365n, u())) {
                    z5 = false;
                }
                if (!(zH | z5)) {
                    F();
                }
                this.f5352a = false;
                z();
            } catch (Throwable th) {
                this.f5352a = false;
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void D(v<R> vVar, R r5, EnumC1335a enumC1335a) {
        boolean zI;
        try {
            boolean zU = u();
            this.f5373v = b.COMPLETE;
            this.f5370s = vVar;
            if (this.f5358g.f() <= 3) {
                Log.d("Glide", "Finished loading " + r5.getClass().getSimpleName() + " from " + enumC1335a + " for " + this.f5359h + " with size [" + this.f5377z + "x" + this.f5350A + "] in " + X0.f.a(this.f5372u) + " ms");
            }
            boolean z5 = true;
            this.f5352a = true;
            try {
                List<g<R>> list = this.f5366o;
                if (list != null) {
                    Iterator<g<R>> it = list.iterator();
                    zI = false;
                    while (it.hasNext()) {
                        R r6 = r5;
                        EnumC1335a enumC1335a2 = enumC1335a;
                        zI |= it.next().i(r6, this.f5359h, this.f5365n, enumC1335a2, zU);
                        r5 = r6;
                        enumC1335a = enumC1335a2;
                    }
                } else {
                    zI = false;
                }
                R r7 = r5;
                EnumC1335a enumC1335a3 = enumC1335a;
                g<R> gVar = this.f5355d;
                if (gVar == null || !gVar.i(r7, this.f5359h, this.f5365n, enumC1335a3, zU)) {
                    z5 = false;
                }
                if (!(z5 | zI)) {
                    this.f5365n.l(r7, this.f5368q.a(enumC1335a3, zU));
                }
                this.f5352a = false;
                A();
            } catch (Throwable th) {
                this.f5352a = false;
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void E(v<?> vVar) {
        this.f5367p.j(vVar);
        this.f5370s = null;
    }

    private synchronized void F() {
        try {
            if (n()) {
                Drawable drawableR = this.f5359h == null ? r() : null;
                if (drawableR == null) {
                    drawableR = q();
                }
                if (drawableR == null) {
                    drawableR = s();
                }
                this.f5365n.f(drawableR);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void i() {
        if (this.f5352a) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean l() {
        e eVar = this.f5356e;
        return eVar == null || eVar.l(this);
    }

    private boolean n() {
        e eVar = this.f5356e;
        return eVar == null || eVar.i(this);
    }

    private boolean o() {
        e eVar = this.f5356e;
        return eVar == null || eVar.g(this);
    }

    private void p() {
        i();
        this.f5354c.c();
        this.f5365n.b(this);
        k.d dVar = this.f5371t;
        if (dVar != null) {
            dVar.a();
            this.f5371t = null;
        }
    }

    private Drawable q() {
        if (this.f5374w == null) {
            Drawable drawableK = this.f5361j.k();
            this.f5374w = drawableK;
            if (drawableK == null && this.f5361j.j() > 0) {
                this.f5374w = w(this.f5361j.j());
            }
        }
        return this.f5374w;
    }

    private Drawable r() {
        if (this.f5376y == null) {
            Drawable drawableL = this.f5361j.l();
            this.f5376y = drawableL;
            if (drawableL == null && this.f5361j.n() > 0) {
                this.f5376y = w(this.f5361j.n());
            }
        }
        return this.f5376y;
    }

    private Drawable s() {
        if (this.f5375x == null) {
            Drawable drawableU = this.f5361j.u();
            this.f5375x = drawableU;
            if (drawableU == null && this.f5361j.v() > 0) {
                this.f5375x = w(this.f5361j.v());
            }
        }
        return this.f5375x;
    }

    private synchronized void t(Context context, v0.e eVar, Object obj, Class<R> cls, T0.a<?> aVar, int i5, int i6, v0.g gVar, U0.e<R> eVar2, g<R> gVar2, List<g<R>> list, e eVar3, C0.k kVar, V0.c<? super R> cVar, Executor executor) {
        this.f5357f = context;
        this.f5358g = eVar;
        this.f5359h = obj;
        this.f5360i = cls;
        this.f5361j = aVar;
        this.f5362k = i5;
        this.f5363l = i6;
        this.f5364m = gVar;
        this.f5365n = eVar2;
        this.f5355d = gVar2;
        this.f5366o = list;
        this.f5356e = eVar3;
        this.f5367p = kVar;
        this.f5368q = cVar;
        this.f5369r = executor;
        this.f5373v = b.PENDING;
        if (this.f5351B == null && eVar.h()) {
            this.f5351B = new RuntimeException("Glide request origin trace");
        }
    }

    private boolean u() {
        e eVar = this.f5356e;
        return eVar == null || !eVar.a();
    }

    private synchronized boolean v(j<?> jVar) {
        boolean z5;
        synchronized (jVar) {
            List<g<R>> list = this.f5366o;
            int size = list == null ? 0 : list.size();
            List<g<?>> list2 = jVar.f5366o;
            z5 = size == (list2 == null ? 0 : list2.size());
        }
        return z5;
    }

    private Drawable w(int i5) {
        return M0.a.a(this.f5358g, i5, this.f5361j.A() != null ? this.f5361j.A() : this.f5357f.getTheme());
    }

    private void x(String str) {
        Log.v("Request", str + " this: " + this.f5353b);
    }

    private static int y(int i5, float f5) {
        return i5 == Integer.MIN_VALUE ? i5 : Math.round(f5 * i5);
    }

    private void z() {
        e eVar = this.f5356e;
        if (eVar != null) {
            eVar.d(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // T0.i
    public synchronized void a(v<?> vVar, EnumC1335a enumC1335a) {
        this.f5354c.c();
        this.f5371t = null;
        if (vVar == null) {
            c(new q("Expected to receive a Resource<R> with an object of " + this.f5360i + " inside, but instead got null."));
            return;
        }
        Object obj = vVar.get();
        if (obj != null && this.f5360i.isAssignableFrom(obj.getClass())) {
            if (o()) {
                D(vVar, obj, enumC1335a);
                return;
            } else {
                E(vVar);
                this.f5373v = b.COMPLETE;
                return;
            }
        }
        E(vVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.f5360i);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : BuildConfig.FLAVOR);
        sb.append("{");
        sb.append(obj);
        sb.append("} inside Resource{");
        sb.append(vVar);
        sb.append("}.");
        sb.append(obj != null ? BuildConfig.FLAVOR : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        c(new q(sb.toString()));
    }

    @Override // T0.d
    public synchronized void b() {
        i();
        this.f5357f = null;
        this.f5358g = null;
        this.f5359h = null;
        this.f5360i = null;
        this.f5361j = null;
        this.f5362k = -1;
        this.f5363l = -1;
        this.f5365n = null;
        this.f5366o = null;
        this.f5355d = null;
        this.f5356e = null;
        this.f5368q = null;
        this.f5371t = null;
        this.f5374w = null;
        this.f5375x = null;
        this.f5376y = null;
        this.f5377z = -1;
        this.f5350A = -1;
        this.f5351B = null;
        f5348C.a(this);
    }

    @Override // T0.i
    public synchronized void c(q qVar) {
        C(qVar, 5);
    }

    @Override // T0.d
    public synchronized void clear() {
        try {
            i();
            this.f5354c.c();
            b bVar = this.f5373v;
            b bVar2 = b.CLEARED;
            if (bVar == bVar2) {
                return;
            }
            p();
            v<R> vVar = this.f5370s;
            if (vVar != null) {
                E(vVar);
            }
            if (l()) {
                this.f5365n.m(s());
            }
            this.f5373v = bVar2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // U0.d
    public synchronized void d(int i5, int i6) throws Throwable {
        try {
            try {
                this.f5354c.c();
                boolean z5 = f5349D;
                if (z5) {
                    x("Got onSizeReady in " + X0.f.a(this.f5372u));
                }
                if (this.f5373v != b.WAITING_FOR_SIZE) {
                    return;
                }
                b bVar = b.RUNNING;
                this.f5373v = bVar;
                float fZ = this.f5361j.z();
                this.f5377z = y(i5, fZ);
                this.f5350A = y(i6, fZ);
                if (z5) {
                    x("finished setup for calling load in " + X0.f.a(this.f5372u));
                }
                try {
                    this.f5371t = this.f5367p.f(this.f5358g, this.f5359h, this.f5361j.y(), this.f5377z, this.f5350A, this.f5361j.x(), this.f5360i, this.f5364m, this.f5361j.i(), this.f5361j.B(), this.f5361j.J(), this.f5361j.G(), this.f5361j.q(), this.f5361j.E(), this.f5361j.D(), this.f5361j.C(), this.f5361j.p(), this, this.f5369r);
                    if (this.f5373v != bVar) {
                        this.f5371t = null;
                    }
                    if (z5) {
                        x("finished onSizeReady in " + X0.f.a(this.f5372u));
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // T0.d
    public synchronized boolean e(d dVar) {
        boolean z5 = false;
        if (!(dVar instanceof j)) {
            return false;
        }
        j<?> jVar = (j) dVar;
        synchronized (jVar) {
            try {
                if (this.f5362k == jVar.f5362k && this.f5363l == jVar.f5363l && X0.k.c(this.f5359h, jVar.f5359h) && this.f5360i.equals(jVar.f5360i) && this.f5361j.equals(jVar.f5361j) && this.f5364m == jVar.f5364m && v(jVar)) {
                    z5 = true;
                }
            } finally {
            }
        }
        return z5;
    }

    @Override // T0.d
    public synchronized boolean f() {
        return m();
    }

    @Override // Y0.a.f
    public Y0.c g() {
        return this.f5354c;
    }

    @Override // T0.d
    public synchronized boolean h() {
        return this.f5373v == b.FAILED;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    @Override // T0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isRunning() {
        /*
            r2 = this;
            monitor-enter(r2)
            T0.j$b r0 = r2.f5373v     // Catch: java.lang.Throwable -> Le
            T0.j$b r1 = T0.j.b.RUNNING     // Catch: java.lang.Throwable -> Le
            if (r0 == r1) goto L10
            T0.j$b r1 = T0.j.b.WAITING_FOR_SIZE     // Catch: java.lang.Throwable -> Le
            if (r0 != r1) goto Lc
            goto L10
        Lc:
            r0 = 0
            goto L11
        Le:
            r0 = move-exception
            goto L13
        L10:
            r0 = 1
        L11:
            monitor-exit(r2)
            return r0
        L13:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Le
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: T0.j.isRunning():boolean");
    }

    @Override // T0.d
    public synchronized boolean j() {
        return this.f5373v == b.CLEARED;
    }

    @Override // T0.d
    public synchronized void k() {
        try {
            i();
            this.f5354c.c();
            this.f5372u = X0.f.b();
            if (this.f5359h == null) {
                if (X0.k.s(this.f5362k, this.f5363l)) {
                    this.f5377z = this.f5362k;
                    this.f5350A = this.f5363l;
                }
                C(new q("Received null model"), r() == null ? 5 : 3);
                return;
            }
            b bVar = this.f5373v;
            b bVar2 = b.RUNNING;
            if (bVar == bVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (bVar == b.COMPLETE) {
                a(this.f5370s, EnumC1335a.MEMORY_CACHE);
                return;
            }
            b bVar3 = b.WAITING_FOR_SIZE;
            this.f5373v = bVar3;
            if (X0.k.s(this.f5362k, this.f5363l)) {
                d(this.f5362k, this.f5363l);
            } else {
                this.f5365n.e(this);
            }
            b bVar4 = this.f5373v;
            if ((bVar4 == bVar2 || bVar4 == bVar3) && n()) {
                this.f5365n.j(s());
            }
            if (f5349D) {
                x("finished run method in " + X0.f.a(this.f5372u));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // T0.d
    public synchronized boolean m() {
        return this.f5373v == b.COMPLETE;
    }
}
