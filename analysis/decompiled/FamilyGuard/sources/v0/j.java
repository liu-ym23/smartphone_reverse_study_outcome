package v0;

import Q0.c;
import Q0.m;
import Q0.n;
import Q0.p;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class j implements Q0.i {

    /* renamed from: l, reason: collision with root package name */
    private static final T0.h f23291l = T0.h.Y(Bitmap.class).L();

    /* renamed from: m, reason: collision with root package name */
    private static final T0.h f23292m = T0.h.Y(O0.c.class).L();

    /* renamed from: n, reason: collision with root package name */
    private static final T0.h f23293n = T0.h.Z(C0.j.f396c).O(g.LOW).T(true);

    /* renamed from: a, reason: collision with root package name */
    protected final ComponentCallbacks2C1180c f23294a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f23295b;

    /* renamed from: c, reason: collision with root package name */
    final Q0.h f23296c;

    /* renamed from: d, reason: collision with root package name */
    private final n f23297d;

    /* renamed from: e, reason: collision with root package name */
    private final m f23298e;

    /* renamed from: f, reason: collision with root package name */
    private final p f23299f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f23300g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f23301h;

    /* renamed from: i, reason: collision with root package name */
    private final Q0.c f23302i;

    /* renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArrayList<T0.g<Object>> f23303j;

    /* renamed from: k, reason: collision with root package name */
    private T0.h f23304k;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.f23296c.a(jVar);
        }
    }

    private class b implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private final n f23306a;

        b(n nVar) {
            this.f23306a = nVar;
        }

        @Override // Q0.c.a
        public void a(boolean z5) {
            if (z5) {
                synchronized (j.this) {
                    this.f23306a.e();
                }
            }
        }
    }

    public j(ComponentCallbacks2C1180c componentCallbacks2C1180c, Q0.h hVar, m mVar, Context context) {
        this(componentCallbacks2C1180c, hVar, mVar, new n(), componentCallbacks2C1180c.g(), context);
    }

    private void x(U0.e<?> eVar) {
        if (w(eVar) || this.f23294a.p(eVar) || eVar.k() == null) {
            return;
        }
        T0.d dVarK = eVar.k();
        eVar.c(null);
        dVarK.clear();
    }

    @Override // Q0.i
    public synchronized void a() {
        t();
        this.f23299f.a();
    }

    @Override // Q0.i
    public synchronized void d() {
        try {
            this.f23299f.d();
            Iterator<U0.e<?>> it = this.f23299f.i().iterator();
            while (it.hasNext()) {
                o(it.next());
            }
            this.f23299f.h();
            this.f23297d.c();
            this.f23296c.b(this);
            this.f23296c.b(this.f23302i);
            this.f23301h.removeCallbacks(this.f23300g);
            this.f23294a.s(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // Q0.i
    public synchronized void g() {
        s();
        this.f23299f.g();
    }

    public <ResourceType> i<ResourceType> h(Class<ResourceType> cls) {
        return new i<>(this.f23294a, this, cls, this.f23295b);
    }

    public i<Bitmap> i() {
        return h(Bitmap.class).b(f23291l);
    }

    public i<Drawable> n() {
        return h(Drawable.class);
    }

    public synchronized void o(U0.e<?> eVar) {
        if (eVar == null) {
            return;
        }
        x(eVar);
    }

    List<T0.g<Object>> p() {
        return this.f23303j;
    }

    synchronized T0.h q() {
        return this.f23304k;
    }

    <T> k<?, T> r(Class<T> cls) {
        return this.f23294a.i().d(cls);
    }

    public synchronized void s() {
        this.f23297d.d();
    }

    public synchronized void t() {
        this.f23297d.f();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f23297d + ", treeNode=" + this.f23298e + "}";
    }

    protected synchronized void u(T0.h hVar) {
        this.f23304k = hVar.clone().d();
    }

    synchronized void v(U0.e<?> eVar, T0.d dVar) {
        this.f23299f.n(eVar);
        this.f23297d.g(dVar);
    }

    synchronized boolean w(U0.e<?> eVar) {
        T0.d dVarK = eVar.k();
        if (dVarK == null) {
            return true;
        }
        if (!this.f23297d.b(dVarK)) {
            return false;
        }
        this.f23299f.o(eVar);
        eVar.c(null);
        return true;
    }

    j(ComponentCallbacks2C1180c componentCallbacks2C1180c, Q0.h hVar, m mVar, n nVar, Q0.d dVar, Context context) {
        this.f23299f = new p();
        a aVar = new a();
        this.f23300g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f23301h = handler;
        this.f23294a = componentCallbacks2C1180c;
        this.f23296c = hVar;
        this.f23298e = mVar;
        this.f23297d = nVar;
        this.f23295b = context;
        Q0.c cVarA = dVar.a(context.getApplicationContext(), new b(nVar));
        this.f23302i = cVarA;
        if (X0.k.p()) {
            handler.post(aVar);
        } else {
            hVar.a(this);
        }
        hVar.a(cVarA);
        this.f23303j = new CopyOnWriteArrayList<>(componentCallbacks2C1180c.i().b());
        u(componentCallbacks2C1180c.i().c());
        componentCallbacks2C1180c.o(this);
    }
}
