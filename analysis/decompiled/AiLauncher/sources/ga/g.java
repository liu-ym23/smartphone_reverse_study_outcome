package ga;

import ga.c;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f32741a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final e f32742b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f32743c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f32744d;

    /* renamed from: e, reason: collision with root package name */
    public static final e f32745e;

    /* renamed from: f, reason: collision with root package name */
    public static final e f32746f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f32747g;

    /* renamed from: h, reason: collision with root package name */
    public static final e f32748h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f32749i;

    /* renamed from: j, reason: collision with root package name */
    public static final e f32750j;

    /* renamed from: k, reason: collision with root package name */
    public static final e f32751k;

    /* renamed from: l, reason: collision with root package name */
    public static final e f32752l;

    /* renamed from: m, reason: collision with root package name */
    public static final e f32753m;

    /* renamed from: n, reason: collision with root package name */
    public static final e f32754n;

    /* renamed from: o, reason: collision with root package name */
    public static final e f32755o;

    /* renamed from: p, reason: collision with root package name */
    public static final e f32756p;

    /* renamed from: q, reason: collision with root package name */
    public static final e f32757q;

    /* renamed from: r, reason: collision with root package name */
    public static final e f32758r;

    /* renamed from: s, reason: collision with root package name */
    public static final e f32759s;

    static {
        e eVarM = e.m("<no name provided>");
        p.h(eVarM, "special(...)");
        f32742b = eVarM;
        e eVarM2 = e.m("<root package>");
        p.h(eVarM2, "special(...)");
        f32743c = eVarM2;
        e eVarJ = e.j("Companion");
        p.h(eVarJ, "identifier(...)");
        f32744d = eVarJ;
        e eVarJ2 = e.j("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        p.h(eVarJ2, "identifier(...)");
        f32745e = eVarJ2;
        e eVarM3 = e.m("<anonymous>");
        p.h(eVarM3, "special(...)");
        f32746f = eVarM3;
        c.a aVar = c.f32725c;
        e eVarM4 = e.m("<anonymous>");
        p.h(eVarM4, "special(...)");
        f32747g = aVar.a(eVarM4);
        e eVarM5 = e.m("<unary>");
        p.h(eVarM5, "special(...)");
        f32748h = eVarM5;
        e eVarM6 = e.m("<this>");
        p.h(eVarM6, "special(...)");
        f32749i = eVarM6;
        e eVarM7 = e.m("<init>");
        p.h(eVarM7, "special(...)");
        f32750j = eVarM7;
        e eVarM8 = e.m("<when-subject>");
        p.h(eVarM8, "special(...)");
        f32751k = eVarM8;
        e eVarM9 = e.m("<iterator>");
        p.h(eVarM9, "special(...)");
        f32752l = eVarM9;
        e eVarM10 = e.m("<destruct>");
        p.h(eVarM10, "special(...)");
        f32753m = eVarM10;
        e eVarM11 = e.m("<local>");
        p.h(eVarM11, "special(...)");
        f32754n = eVarM11;
        e eVarM12 = e.m("<unused var>");
        p.h(eVarM12, "special(...)");
        f32755o = eVarM12;
        e eVarM13 = e.m("<set-?>");
        p.h(eVarM13, "special(...)");
        f32756p = eVarM13;
        e eVarM14 = e.m("<array>");
        p.h(eVarM14, "special(...)");
        f32757q = eVarM14;
        e eVarM15 = e.m("<receiver>");
        p.h(eVarM15, "special(...)");
        f32758r = eVarM15;
        e eVarM16 = e.m("<get-entries>");
        p.h(eVarM16, "special(...)");
        f32759s = eVarM16;
    }

    public static final e b(e eVar) {
        return (eVar == null || eVar.k()) ? f32745e : eVar;
    }

    public final boolean a(e name) {
        p.i(name, "name");
        String strB = name.b();
        p.h(strB, "asString(...)");
        return strB.length() > 0 && !name.k();
    }
}
