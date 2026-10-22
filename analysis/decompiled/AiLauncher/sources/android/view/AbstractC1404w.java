package android.view;

import k.C4794c;
import l.C4854b;

/* renamed from: androidx.lifecycle.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1404w<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f14295k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f14296a;

    /* renamed from: b, reason: collision with root package name */
    public C4854b<z<? super T>, AbstractC1404w<T>.d> f14297b;

    /* renamed from: c, reason: collision with root package name */
    public int f14298c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14299d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f14300e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f14301f;

    /* renamed from: g, reason: collision with root package name */
    public int f14302g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14303h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14304i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f14305j;

    /* renamed from: androidx.lifecycle.w$a */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (AbstractC1404w.this.f14296a) {
                obj = AbstractC1404w.this.f14301f;
                AbstractC1404w.this.f14301f = AbstractC1404w.f14295k;
            }
            AbstractC1404w.this.k(obj);
        }
    }

    /* renamed from: androidx.lifecycle.w$b */
    public class b extends AbstractC1404w<T>.d {
        public b(z<? super T> zVar) {
            super(zVar);
        }

        @Override // android.view.AbstractC1404w.d
        public boolean d() {
            return true;
        }
    }

    /* renamed from: androidx.lifecycle.w$c */
    public class c extends AbstractC1404w<T>.d implements InterfaceC1395m {
    }

    /* renamed from: androidx.lifecycle.w$d */
    public abstract class d {

        /* renamed from: a, reason: collision with root package name */
        public final z<? super T> f14308a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f14309b;

        /* renamed from: c, reason: collision with root package name */
        public int f14310c = -1;

        public d(z<? super T> zVar) {
            this.f14308a = zVar;
        }

        public void a(boolean z10) {
            if (z10 == this.f14309b) {
                return;
            }
            this.f14309b = z10;
            AbstractC1404w.this.b(z10 ? 1 : -1);
            if (this.f14309b) {
                AbstractC1404w.this.d(this);
            }
        }

        public void c() {
        }

        public abstract boolean d();
    }

    public AbstractC1404w(T t10) {
        this.f14296a = new Object();
        this.f14297b = new C4854b<>();
        this.f14298c = 0;
        this.f14301f = f14295k;
        this.f14305j = new a();
        this.f14300e = t10;
        this.f14302g = 0;
    }

    public static void a(String str) {
        if (C4794c.g().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void b(int i10) {
        int i11 = this.f14298c;
        this.f14298c = i10 + i11;
        if (this.f14299d) {
            return;
        }
        this.f14299d = true;
        while (true) {
            try {
                int i12 = this.f14298c;
                if (i11 == i12) {
                    this.f14299d = false;
                    return;
                }
                boolean z10 = i11 == 0 && i12 > 0;
                boolean z11 = i11 > 0 && i12 == 0;
                if (z10) {
                    g();
                } else if (z11) {
                    h();
                }
                i11 = i12;
            } catch (Throwable th) {
                this.f14299d = false;
                throw th;
            }
        }
    }

    public final void c(AbstractC1404w<T>.d dVar) {
        if (dVar.f14309b) {
            if (!dVar.d()) {
                dVar.a(false);
                return;
            }
            int i10 = dVar.f14310c;
            int i11 = this.f14302g;
            if (i10 >= i11) {
                return;
            }
            dVar.f14310c = i11;
            dVar.f14308a.a((Object) this.f14300e);
        }
    }

    public void d(AbstractC1404w<T>.d dVar) {
        if (this.f14303h) {
            this.f14304i = true;
            return;
        }
        this.f14303h = true;
        do {
            this.f14304i = false;
            if (dVar != null) {
                c(dVar);
                dVar = null;
            } else {
                C4854b<z<? super T>, AbstractC1404w<T>.d>.d dVarE = this.f14297b.e();
                while (dVarE.hasNext()) {
                    c((d) dVarE.next().getValue());
                    if (this.f14304i) {
                        break;
                    }
                }
            }
        } while (this.f14304i);
        this.f14303h = false;
    }

    public T e() {
        T t10 = (T) this.f14300e;
        if (t10 != f14295k) {
            return t10;
        }
        return null;
    }

    public void f(z<? super T> zVar) {
        a("observeForever");
        b bVar = new b(zVar);
        AbstractC1404w<T>.d dVarJ = this.f14297b.j(zVar, bVar);
        if (dVarJ instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVarJ != null) {
            return;
        }
        bVar.a(true);
    }

    public void g() {
    }

    public void h() {
    }

    public void i(T t10) {
        boolean z10;
        synchronized (this.f14296a) {
            z10 = this.f14301f == f14295k;
            this.f14301f = t10;
        }
        if (z10) {
            C4794c.g().c(this.f14305j);
        }
    }

    public void j(z<? super T> zVar) {
        a("removeObserver");
        AbstractC1404w<T>.d dVarK = this.f14297b.k(zVar);
        if (dVarK == null) {
            return;
        }
        dVarK.c();
        dVarK.a(false);
    }

    public void k(T t10) {
        a("setValue");
        this.f14302g++;
        this.f14300e = t10;
        d(null);
    }

    public AbstractC1404w() {
        this.f14296a = new Object();
        this.f14297b = new C4854b<>();
        this.f14298c = 0;
        Object obj = f14295k;
        this.f14301f = obj;
        this.f14305j = new a();
        this.f14300e = obj;
        this.f14302g = -1;
    }
}
