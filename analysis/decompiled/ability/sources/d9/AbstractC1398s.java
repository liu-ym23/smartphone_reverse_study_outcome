package d9;

import D7.N;
import java.util.Set;
import kotlin.Pair;
import kotlin.text.Regex;

/* renamed from: d9.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1398s {

    /* renamed from: A, reason: collision with root package name */
    public static final Set f4317A;

    /* renamed from: B, reason: collision with root package name */
    public static final Object f4318B;

    /* renamed from: a, reason: collision with root package name */
    public static final G8.f f4319a;
    public static final G8.f b;
    public static final G8.f c;
    public static final G8.f d;
    public static final G8.f e;
    public static final G8.f f;
    public static final G8.f g;
    public static final G8.f h;
    public static final G8.f i;

    /* renamed from: j, reason: collision with root package name */
    public static final G8.f f4320j;
    public static final G8.f k;
    public static final G8.f l;
    public static final Regex m;
    public static final G8.f n;
    public static final G8.f o;
    public static final G8.f p;

    /* renamed from: q, reason: collision with root package name */
    public static final G8.f f4321q;

    /* renamed from: r, reason: collision with root package name */
    public static final Set f4322r;

    /* renamed from: s, reason: collision with root package name */
    public static final Set f4323s;

    /* renamed from: t, reason: collision with root package name */
    public static final Set f4324t;
    public static final Set u;

    /* renamed from: v, reason: collision with root package name */
    public static final Set f4325v;

    /* renamed from: w, reason: collision with root package name */
    public static final Set f4326w;

    /* renamed from: x, reason: collision with root package name */
    public static final Set f4327x;
    public static final Set y;

    /* renamed from: z, reason: collision with root package name */
    public static final Object f4328z;

    static {
        G8.f fVarE = G8.f.e("getValue");
        f4319a = fVarE;
        G8.f fVarE2 = G8.f.e("setValue");
        b = fVarE2;
        G8.f fVarE3 = G8.f.e("provideDelegate");
        c = fVarE3;
        G8.f fVarE4 = G8.f.e("equals");
        d = fVarE4;
        G8.f.e("hashCode");
        G8.f fVarE5 = G8.f.e("compareTo");
        e = fVarE5;
        G8.f fVarE6 = G8.f.e("contains");
        f = fVarE6;
        g = G8.f.e("invoke");
        h = G8.f.e("iterator");
        i = G8.f.e("get");
        G8.f fVarE7 = G8.f.e("set");
        f4320j = fVarE7;
        k = G8.f.e("next");
        l = G8.f.e("hasNext");
        G8.f.e("toString");
        m = new Regex("component\\d+");
        G8.f fVarE8 = G8.f.e("and");
        G8.f fVarE9 = G8.f.e("or");
        G8.f fVarE10 = G8.f.e("xor");
        G8.f fVarE11 = G8.f.e("inv");
        G8.f fVarE12 = G8.f.e("shl");
        G8.f fVarE13 = G8.f.e("shr");
        G8.f fVarE14 = G8.f.e("ushr");
        G8.f fVarE15 = G8.f.e("inc");
        n = fVarE15;
        G8.f fVarE16 = G8.f.e("dec");
        o = fVarE16;
        G8.f fVarE17 = G8.f.e("plus");
        G8.f fVarE18 = G8.f.e("minus");
        G8.f fVarE19 = G8.f.e("not");
        G8.f fVarE20 = G8.f.e("unaryMinus");
        G8.f fVarE21 = G8.f.e("unaryPlus");
        G8.f fVarE22 = G8.f.e("times");
        G8.f fVarE23 = G8.f.e("div");
        G8.f fVarE24 = G8.f.e("mod");
        G8.f fVarE25 = G8.f.e("rem");
        G8.f fVarE26 = G8.f.e("rangeTo");
        p = fVarE26;
        G8.f fVarE27 = G8.f.e("rangeUntil");
        f4321q = fVarE27;
        G8.f fVarE28 = G8.f.e("timesAssign");
        G8.f fVarE29 = G8.f.e("divAssign");
        G8.f fVarE30 = G8.f.e("modAssign");
        G8.f fVarE31 = G8.f.e("remAssign");
        G8.f fVarE32 = G8.f.e("plusAssign");
        G8.f fVarE33 = G8.f.e("minusAssign");
        G8.f fVarE34 = G8.f.e("toDouble");
        G8.f fVarE35 = G8.f.e("toFloat");
        G8.f fVarE36 = G8.f.e("toLong");
        G8.f fVarE37 = G8.f.e("toInt");
        G8.f fVarE38 = G8.f.e("toChar");
        G8.f fVarE39 = G8.f.e("toShort");
        G8.f fVarE40 = G8.f.e("toByte");
        f4322r = D7.q.K0(new G8.f[]{fVarE15, fVarE16, fVarE21, fVarE20, fVarE19, fVarE11});
        f4323s = D7.q.K0(new G8.f[]{fVarE21, fVarE20, fVarE19, fVarE11});
        Set setK0 = D7.q.K0(new G8.f[]{fVarE22, fVarE17, fVarE18, fVarE23, fVarE24, fVarE25, fVarE26, fVarE27});
        f4324t = setK0;
        u = D7.q.K0(new G8.f[]{fVarE22, fVarE17, fVarE18, fVarE23, fVarE24, fVarE25});
        Set setK02 = D7.q.K0(new G8.f[]{fVarE8, fVarE9, fVarE10, fVarE11, fVarE12, fVarE13, fVarE14});
        f4325v = setK02;
        f4326w = D7.q.K0(new G8.f[]{fVarE8, fVarE9, fVarE10, fVarE12, fVarE13, fVarE14});
        N.L(N.L(setK0, setK02), D7.q.K0(new G8.f[]{fVarE4, fVarE6, fVarE5}));
        Set setK03 = D7.q.K0(new G8.f[]{fVarE28, fVarE29, fVarE30, fVarE31, fVarE32, fVarE33});
        f4327x = setK03;
        y = D7.q.K0(new G8.f[]{fVarE, fVarE2, fVarE3});
        f4328z = kotlin.collections.a.R(new Pair(fVarE24, fVarE25), new Pair(fVarE30, fVarE31));
        N.L(N.Q(fVarE7), setK03);
        f4317A = D7.q.K0(new G8.f[]{fVarE34, fVarE35, fVarE36, fVarE37, fVarE39, fVarE40, fVarE38});
        f4318B = kotlin.collections.a.R(new Pair(fVarE15, "++"), new Pair(fVarE16, "--"), new Pair(fVarE21, "+"), new Pair(fVarE20, "-"), new Pair(fVarE19, "!"), new Pair(fVarE22, "*"), new Pair(fVarE17, "+"), new Pair(fVarE18, "-"), new Pair(fVarE23, "/"), new Pair(fVarE25, "%"), new Pair(fVarE26, ".."), new Pair(fVarE27, "..<"));
    }
}
