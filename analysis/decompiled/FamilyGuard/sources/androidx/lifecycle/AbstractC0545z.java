package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;
import java.util.Iterator;
import java.util.Map;
import n.C0870b;

/* renamed from: androidx.lifecycle.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0545z<T> {

    /* renamed from: k, reason: collision with root package name */
    static final Object f10910k = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f10911a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private C0870b<C<? super T>, AbstractC0545z<T>.d> f10912b = new C0870b<>();

    /* renamed from: c, reason: collision with root package name */
    int f10913c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10914d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f10915e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f10916f;

    /* renamed from: g, reason: collision with root package name */
    private int f10917g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10918h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10919i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f10920j;

    /* renamed from: androidx.lifecycle.z$a */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (AbstractC0545z.this.f10911a) {
                obj = AbstractC0545z.this.f10916f;
                AbstractC0545z.this.f10916f = AbstractC0545z.f10910k;
            }
            AbstractC0545z.this.n(obj);
        }
    }

    /* renamed from: androidx.lifecycle.z$b */
    private class b extends AbstractC0545z<T>.d {
        b(C<? super T> c6) {
            super(c6);
        }

        @Override // androidx.lifecycle.AbstractC0545z.d
        boolean g() {
            return true;
        }
    }

    /* renamed from: androidx.lifecycle.z$c */
    class c extends AbstractC0545z<T>.d implements InterfaceC0537q {

        /* renamed from: e, reason: collision with root package name */
        final InterfaceC0539t f10923e;

        c(InterfaceC0539t interfaceC0539t, C<? super T> c6) {
            super(c6);
            this.f10923e = interfaceC0539t;
        }

        @Override // androidx.lifecycle.AbstractC0545z.d
        void d() {
            this.f10923e.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.AbstractC0545z.d
        boolean e(InterfaceC0539t interfaceC0539t) {
            return this.f10923e == interfaceC0539t;
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            AbstractC0533m.b bVarB = this.f10923e.getLifecycle().b();
            if (bVarB == AbstractC0533m.b.DESTROYED) {
                AbstractC0545z.this.l(this.f10925a);
                return;
            }
            AbstractC0533m.b bVar = null;
            while (bVar != bVarB) {
                b(g());
                bVar = bVarB;
                bVarB = this.f10923e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.AbstractC0545z.d
        boolean g() {
            return this.f10923e.getLifecycle().b().d(AbstractC0533m.b.STARTED);
        }
    }

    /* renamed from: androidx.lifecycle.z$d */
    private abstract class d {

        /* renamed from: a, reason: collision with root package name */
        final C<? super T> f10925a;

        /* renamed from: b, reason: collision with root package name */
        boolean f10926b;

        /* renamed from: c, reason: collision with root package name */
        int f10927c = -1;

        d(C<? super T> c6) {
            this.f10925a = c6;
        }

        void b(boolean z5) {
            if (z5 == this.f10926b) {
                return;
            }
            this.f10926b = z5;
            AbstractC0545z.this.b(z5 ? 1 : -1);
            if (this.f10926b) {
                AbstractC0545z.this.d(this);
            }
        }

        void d() {
        }

        boolean e(InterfaceC0539t interfaceC0539t) {
            return false;
        }

        abstract boolean g();
    }

    public AbstractC0545z() {
        Object obj = f10910k;
        this.f10916f = obj;
        this.f10920j = new a();
        this.f10915e = obj;
        this.f10917g = -1;
    }

    static void a(String str) {
        if (m.c.h().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(AbstractC0545z<T>.d dVar) {
        if (dVar.f10926b) {
            if (!dVar.g()) {
                dVar.b(false);
                return;
            }
            int i5 = dVar.f10927c;
            int i6 = this.f10917g;
            if (i5 >= i6) {
                return;
            }
            dVar.f10927c = i6;
            dVar.f10925a.a((Object) this.f10915e);
        }
    }

    void b(int i5) {
        int i6 = this.f10913c;
        this.f10913c = i5 + i6;
        if (this.f10914d) {
            return;
        }
        this.f10914d = true;
        while (true) {
            try {
                int i7 = this.f10913c;
                if (i6 == i7) {
                    this.f10914d = false;
                    return;
                }
                boolean z5 = i6 == 0 && i7 > 0;
                boolean z6 = i6 > 0 && i7 == 0;
                if (z5) {
                    i();
                } else if (z6) {
                    j();
                }
                i6 = i7;
            } catch (Throwable th) {
                this.f10914d = false;
                throw th;
            }
        }
    }

    void d(AbstractC0545z<T>.d dVar) {
        if (this.f10918h) {
            this.f10919i = true;
            return;
        }
        this.f10918h = true;
        do {
            this.f10919i = false;
            if (dVar != null) {
                c(dVar);
                dVar = null;
            } else {
                C0870b<C<? super T>, AbstractC0545z<T>.d>.d dVarF = this.f10912b.f();
                while (dVarF.hasNext()) {
                    c((d) dVarF.next().getValue());
                    if (this.f10919i) {
                        break;
                    }
                }
            }
        } while (this.f10919i);
        this.f10918h = false;
    }

    public T e() {
        T t5 = (T) this.f10915e;
        if (t5 != f10910k) {
            return t5;
        }
        return null;
    }

    public boolean f() {
        return this.f10913c > 0;
    }

    public void g(InterfaceC0539t interfaceC0539t, C<? super T> c6) {
        a("observe");
        if (interfaceC0539t.getLifecycle().b() == AbstractC0533m.b.DESTROYED) {
            return;
        }
        c cVar = new c(interfaceC0539t, c6);
        AbstractC0545z<T>.d dVarM = this.f10912b.m(c6, cVar);
        if (dVarM != null && !dVarM.e(interfaceC0539t)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVarM != null) {
            return;
        }
        interfaceC0539t.getLifecycle().a(cVar);
    }

    public void h(C<? super T> c6) {
        a("observeForever");
        b bVar = new b(c6);
        AbstractC0545z<T>.d dVarM = this.f10912b.m(c6, bVar);
        if (dVarM instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVarM != null) {
            return;
        }
        bVar.b(true);
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k(T t5) {
        boolean z5;
        synchronized (this.f10911a) {
            z5 = this.f10916f == f10910k;
            this.f10916f = t5;
        }
        if (z5) {
            m.c.h().d(this.f10920j);
        }
    }

    public void l(C<? super T> c6) {
        a("removeObserver");
        AbstractC0545z<T>.d dVarN = this.f10912b.n(c6);
        if (dVarN == null) {
            return;
        }
        dVarN.d();
        dVarN.b(false);
    }

    public void m(InterfaceC0539t interfaceC0539t) {
        a("removeObservers");
        Iterator<Map.Entry<C<? super T>, AbstractC0545z<T>.d>> it = this.f10912b.iterator();
        while (it.hasNext()) {
            Map.Entry<C<? super T>, AbstractC0545z<T>.d> next = it.next();
            if (next.getValue().e(interfaceC0539t)) {
                l(next.getKey());
            }
        }
    }

    protected void n(T t5) {
        a("setValue");
        this.f10917g++;
        this.f10915e = t5;
        d(null);
    }
}
