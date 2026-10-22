package rc;

import java.io.InputStream;
import java.lang.Character;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.scilab.forge.jlatexmath.FormulaNotFoundException;
import org.scilab.forge.jlatexmath.ParseException;
import org.scilab.forge.jlatexmath.ResourceParseException;

/* loaded from: classes5.dex */
public class a1 {

    /* renamed from: g, reason: collision with root package name */
    public static float f39201g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public static float f39202h = 100.0f;

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, a1> f39203i = new HashMap(com.stepos.ailauncher.chat.wake.circle.F.GESTURE_HEIGHT_DP);

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, String> f39204j = new HashMap(com.stepos.ailauncher.chat.wake.circle.F.GESTURE_HEIGHT_DP);

    /* renamed from: k, reason: collision with root package name */
    public static String[] f39205k = new String[65536];

    /* renamed from: l, reason: collision with root package name */
    public static String[] f39206l = new String[65536];

    /* renamed from: m, reason: collision with root package name */
    public static String[] f39207m = new String[65536];

    /* renamed from: n, reason: collision with root package name */
    public static Map<Character.UnicodeBlock, a> f39208n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public List<C5283g0> f39209a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f39210b;

    /* renamed from: c, reason: collision with root package name */
    public d1 f39211c;

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39212d;

    /* renamed from: e, reason: collision with root package name */
    public String f39213e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39214f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f39215a;

        /* renamed from: b, reason: collision with root package name */
        public String f39216b;

        public a(String str, String str2) {
            this.f39215a = str;
            this.f39216b = str2;
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public Integer f39217a;

        /* renamed from: b, reason: collision with root package name */
        public Float f39218b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f39219c;

        /* renamed from: d, reason: collision with root package name */
        public Cc.c f39220d;

        /* renamed from: f, reason: collision with root package name */
        public Integer f39222f;

        /* renamed from: g, reason: collision with root package name */
        public Float f39223g;

        /* renamed from: h, reason: collision with root package name */
        public Integer f39224h;

        /* renamed from: j, reason: collision with root package name */
        public Integer f39226j;

        /* renamed from: k, reason: collision with root package name */
        public Float f39227k;

        /* renamed from: e, reason: collision with root package name */
        public boolean f39221e = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f39225i = false;

        public b() {
        }

        public c1 a() {
            c1 c1Var;
            Q q10;
            if (this.f39217a == null) {
                throw new IllegalStateException("A style is required. Use setStyle()");
            }
            Float f10 = this.f39218b;
            if (f10 == null) {
                throw new IllegalStateException("A size is required. Use setStyle()");
            }
            C5307t c5307t = this.f39219c == null ? new C5307t(this.f39218b.floatValue()) : a1.this.j(f10.floatValue(), this.f39219c.intValue());
            Y0 y02 = this.f39222f != null ? new Y0(this.f39217a.intValue(), c5307t, this.f39222f.intValue(), this.f39223g.floatValue()) : new Y0(this.f39217a.intValue(), c5307t);
            Integer num = this.f39226j;
            if (num != null) {
                y02.v(num.intValue(), this.f39227k.floatValue());
            }
            AbstractC5284h abstractC5284hI = a1.this.i(y02);
            if (this.f39222f != null) {
                if (this.f39226j != null) {
                    AbstractC5284h abstractC5284hC = C5286i.c(abstractC5284hI, y02.p(), this.f39227k.floatValue() * R0.j(this.f39226j.intValue(), y02));
                    q10 = new Q(abstractC5284hC, this.f39225i ? abstractC5284hC.k() : y02.p(), this.f39224h.intValue());
                } else {
                    q10 = new Q(abstractC5284hI, this.f39225i ? abstractC5284hI.k() : y02.p(), this.f39224h.intValue());
                }
                c1Var = new c1(q10, this.f39218b.floatValue(), this.f39221e);
            } else {
                c1Var = new c1(abstractC5284hI, this.f39218b.floatValue(), this.f39221e);
            }
            Cc.c cVar = this.f39220d;
            if (cVar != null) {
                c1Var.d(cVar);
            }
            c1Var.f39247e = y02.f39193l;
            return c1Var;
        }

        public b b(Cc.c cVar) {
            this.f39220d = cVar;
            return this;
        }

        public b c(float f10) {
            this.f39218b = Float.valueOf(f10);
            return this;
        }

        public b d(int i10) {
            this.f39217a = Integer.valueOf(i10);
            return this;
        }
    }

    static {
        b1 b1Var = new b1();
        b1Var.c(f39205k, f39206l);
        new C5318y0();
        new C5320z0();
        new C5316x0();
        b1Var.d(f39207m, f39206l);
        try {
            C5307t.X((InterfaceC5272b) sc.a.class.newInstance());
            C5307t.X((InterfaceC5272b) uc.a.class.newInstance());
        } catch (Exception unused) {
        }
    }

    public a1() {
        this.f39209a = new LinkedList();
        this.f39212d = null;
        this.f39213e = null;
        this.f39214f = false;
        this.f39211c = new d1("", this, false);
    }

    public static void g(InputStream inputStream, String str) throws ResourceParseException {
        b1 b1Var = new b1(inputStream, str);
        b1Var.c(f39205k, f39206l);
        b1Var.d(f39207m, f39206l);
    }

    public static a1 k(String str) throws FormulaNotFoundException {
        a1 a1Var = f39203i.get(str);
        if (a1Var != null) {
            return new a1(a1Var);
        }
        String str2 = f39204j.get(str);
        if (str2 == null) {
            throw new FormulaNotFoundException(str);
        }
        a1 a1Var2 = new a1(str2);
        if (!(a1Var2.f39212d instanceof I0)) {
            f39203i.put(str, a1Var2);
        }
        return a1Var2;
    }

    public static a l(Character.UnicodeBlock unicodeBlock) {
        a aVar = f39208n.get(unicodeBlock);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a("SansSerif", "Serif");
        f39208n.put(unicodeBlock, aVar2);
        return aVar2;
    }

    public static boolean m(Character.UnicodeBlock unicodeBlock) {
        return f39208n.get(unicodeBlock) != null;
    }

    public a1 c(String str) throws ParseException {
        if (str != null && str.length() != 0) {
            this.f39213e = null;
            e(new a1(str));
        }
        return this;
    }

    public a1 d(AbstractC5276d abstractC5276d) {
        int iH;
        if (abstractC5276d != null) {
            if (abstractC5276d instanceof C5283g0) {
                this.f39209a.add((C5283g0) abstractC5276d);
            }
            AbstractC5276d abstractC5276d2 = this.f39212d;
            if (abstractC5276d2 == null) {
                this.f39212d = abstractC5276d;
                return this;
            }
            if (!(abstractC5276d2 instanceof I0)) {
                this.f39212d = new I0(this.f39212d);
            }
            ((I0) this.f39212d).i(abstractC5276d);
            if ((abstractC5276d instanceof i1) && ((iH = ((i1) abstractC5276d).h()) == 2 || iH == 3)) {
                ((I0) this.f39212d).i(new C5288j());
            }
        }
        return this;
    }

    public a1 e(a1 a1Var) {
        f(a1Var);
        return this;
    }

    public final void f(a1 a1Var) {
        AbstractC5276d abstractC5276d = a1Var.f39212d;
        if (abstractC5276d != null) {
            if (abstractC5276d instanceof I0) {
                d(new I0(a1Var.f39212d));
            } else {
                d(abstractC5276d);
            }
        }
    }

    public a1 h(boolean z10, String str) throws ParseException {
        if (str != null && str.length() != 0) {
            new d1(z10, str, this).F();
        }
        return this;
    }

    public final AbstractC5284h i(Y0 y02) {
        AbstractC5276d abstractC5276d = this.f39212d;
        return abstractC5276d == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d.f(y02);
    }

    public final C5307t j(float f10, int i10) {
        C5307t c5307t = new C5307t(f10);
        if (i10 == 0) {
            c5307t.L(false);
        }
        if ((i10 & 8) != 0) {
            c5307t.a(true);
        }
        if ((i10 & 16) != 0) {
            c5307t.b(true);
        }
        if ((i10 & 1) != 0) {
            c5307t.L(true);
        }
        if ((i10 & 4) != 0) {
            c5307t.c(true);
        }
        if ((i10 & 2) != 0) {
            c5307t.G(true);
        }
        return c5307t;
    }

    public a1(String str) throws ParseException {
        this(str, (String) null);
    }

    public a1(String str, boolean z10) throws ParseException {
        this.f39209a = new LinkedList();
        this.f39212d = null;
        this.f39214f = false;
        this.f39213e = null;
        d1 d1Var = new d1(str, this, z10);
        this.f39211c = d1Var;
        d1Var.F();
    }

    public a1(String str, String str2) throws ParseException {
        this.f39209a = new LinkedList();
        this.f39212d = null;
        this.f39214f = false;
        this.f39213e = str2;
        d1 d1Var = new d1(str, this);
        this.f39211c = d1Var;
        d1Var.F();
    }

    public a1(a1 a1Var) {
        this.f39209a = new LinkedList();
        this.f39212d = null;
        this.f39213e = null;
        this.f39214f = false;
        if (a1Var != null) {
            f(a1Var);
        }
    }

    public a1(d1 d1Var, String str) throws ParseException {
        this(d1Var, str, (String) null);
    }

    public a1(d1 d1Var, String str, boolean z10) throws ParseException {
        this.f39209a = new LinkedList();
        this.f39212d = null;
        this.f39214f = false;
        this.f39213e = null;
        this.f39210b = d1Var.f39255a.f39210b;
        boolean zO = d1Var.o();
        d1 d1Var2 = new d1(zO, str, this, z10);
        this.f39211c = d1Var2;
        if (zO) {
            try {
                d1Var2.F();
            } catch (Exception unused) {
            }
        } else {
            d1Var2.F();
        }
    }

    public a1(d1 d1Var, String str, String str2) throws ParseException {
        this.f39209a = new LinkedList();
        this.f39212d = null;
        this.f39214f = false;
        this.f39213e = str2;
        this.f39210b = d1Var.f39255a.f39210b;
        boolean zO = d1Var.o();
        d1 d1Var2 = new d1(zO, str, this);
        this.f39211c = d1Var2;
        if (zO) {
            try {
                d1Var2.F();
                return;
            } catch (Exception unused) {
                if (this.f39212d == null) {
                    this.f39212d = new C5317y();
                    return;
                }
                return;
            }
        }
        d1Var2.F();
    }

    public a1(d1 d1Var, String str, String str2, boolean z10, boolean z11) throws ParseException {
        this.f39209a = new LinkedList();
        this.f39212d = null;
        this.f39214f = false;
        this.f39213e = str2;
        this.f39210b = d1Var.f39255a.f39210b;
        boolean zO = d1Var.o();
        d1 d1Var2 = new d1(zO, str, this, z10, z11);
        this.f39211c = d1Var2;
        if (zO) {
            try {
                d1Var2.F();
                return;
            } catch (Exception unused) {
                if (this.f39212d == null) {
                    this.f39212d = new C5317y();
                    return;
                }
                return;
            }
        }
        d1Var2.F();
    }
}
