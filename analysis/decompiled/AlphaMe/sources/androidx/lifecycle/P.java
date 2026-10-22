package androidx.lifecycle;

import java.util.Map;
import l.C0744b;

/* loaded from: classes.dex */
public abstract class P {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f3888k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f3889a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final m.g f3890b = new m.g();

    /* renamed from: c, reason: collision with root package name */
    public int f3891c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3892d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f3893e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f3894f;

    /* renamed from: g, reason: collision with root package name */
    public int f3895g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3896h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3897i;

    /* renamed from: j, reason: collision with root package name */
    public final L f3898j;

    public P() {
        Object obj = f3888k;
        this.f3894f = obj;
        this.f3898j = new L(this);
        this.f3893e = obj;
        this.f3895g = -1;
    }

    public static void a(String str) {
        if (!C0744b.g0().h0()) {
            throw new IllegalStateException(B0.g.n("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(O o4) {
        if (o4.f3885b) {
            if (!o4.e()) {
                o4.b(false);
                return;
            }
            int i4 = o4.f3886c;
            int i5 = this.f3895g;
            if (i4 >= i5) {
                return;
            }
            o4.f3886c = i5;
            o4.f3884a.onChanged(this.f3893e);
        }
    }

    public final void c(O o4) {
        if (this.f3896h) {
            this.f3897i = true;
            return;
        }
        this.f3896h = true;
        do {
            this.f3897i = false;
            if (o4 != null) {
                b(o4);
                o4 = null;
            } else {
                m.g gVar = this.f3890b;
                gVar.getClass();
                m.d dVar = new m.d(gVar);
                gVar.f13520c.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((O) ((Map.Entry) dVar.next()).getValue());
                    if (this.f3897i) {
                        break;
                    }
                }
            }
        } while (this.f3897i);
        this.f3896h = false;
    }

    public final void d(G g4, V v4) {
        Object obj;
        a("observe");
        if (((I) g4.getLifecycle()).f3871d == EnumC0327y.f3983a) {
            return;
        }
        N n4 = new N(this, g4, v4);
        m.g gVar = this.f3890b;
        m.c cVarA = gVar.a(v4);
        if (cVarA != null) {
            obj = cVarA.f13510b;
        } else {
            m.c cVar = new m.c(v4, n4);
            gVar.f13521d++;
            m.c cVar2 = gVar.f13519b;
            if (cVar2 == null) {
                gVar.f13518a = cVar;
                gVar.f13519b = cVar;
            } else {
                cVar2.f13511c = cVar;
                cVar.f13512d = cVar2;
                gVar.f13519b = cVar;
            }
            obj = null;
        }
        O o4 = (O) obj;
        if (o4 != null && !o4.d(g4)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (o4 != null) {
            return;
        }
        g4.getLifecycle().a(n4);
    }

    public void e() {
    }

    public void f() {
    }

    public abstract void g(Object obj);
}
