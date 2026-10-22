package H1;

import F1.A;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: A, reason: collision with root package name */
    public static final v f774A;

    /* renamed from: B, reason: collision with root package name */
    public static final a f775B;

    /* renamed from: a, reason: collision with root package name */
    public static final v f776a = a(Class.class, new F1.k(11).a());

    /* renamed from: b, reason: collision with root package name */
    public static final v f777b = a(BitSet.class, new F1.k(21).a());

    /* renamed from: c, reason: collision with root package name */
    public static final F1.k f778c;

    /* renamed from: d, reason: collision with root package name */
    public static final w f779d;

    /* renamed from: e, reason: collision with root package name */
    public static final w f780e;

    /* renamed from: f, reason: collision with root package name */
    public static final w f781f;

    /* renamed from: g, reason: collision with root package name */
    public static final w f782g;

    /* renamed from: h, reason: collision with root package name */
    public static final v f783h;

    /* renamed from: i, reason: collision with root package name */
    public static final v f784i;

    /* renamed from: j, reason: collision with root package name */
    public static final v f785j;

    /* renamed from: k, reason: collision with root package name */
    public static final F1.k f786k;

    /* renamed from: l, reason: collision with root package name */
    public static final w f787l;

    /* renamed from: m, reason: collision with root package name */
    public static final F1.k f788m;

    /* renamed from: n, reason: collision with root package name */
    public static final F1.k f789n;

    /* renamed from: o, reason: collision with root package name */
    public static final F1.k f790o;

    /* renamed from: p, reason: collision with root package name */
    public static final v f791p;

    /* renamed from: q, reason: collision with root package name */
    public static final v f792q;

    /* renamed from: r, reason: collision with root package name */
    public static final v f793r;

    /* renamed from: s, reason: collision with root package name */
    public static final v f794s;

    /* renamed from: t, reason: collision with root package name */
    public static final v f795t;

    /* renamed from: u, reason: collision with root package name */
    public static final v f796u;

    /* renamed from: v, reason: collision with root package name */
    public static final v f797v;

    /* renamed from: w, reason: collision with root package name */
    public static final v f798w;

    /* renamed from: x, reason: collision with root package name */
    public static final w f799x;

    /* renamed from: y, reason: collision with root package name */
    public static final v f800y;

    /* renamed from: z, reason: collision with root package name */
    public static final F1.k f801z;

    static {
        F1.k kVar = new F1.k(22);
        f778c = new F1.k(23);
        f779d = b(Boolean.TYPE, Boolean.class, kVar);
        f780e = b(Byte.TYPE, Byte.class, new F1.k(24));
        f781f = b(Short.TYPE, Short.class, new F1.k(25));
        f782g = b(Integer.TYPE, Integer.class, new F1.k(26));
        f783h = a(AtomicInteger.class, new F1.k(27).a());
        f784i = a(AtomicBoolean.class, new F1.k(28).a());
        int i4 = 1;
        f785j = a(AtomicIntegerArray.class, new F1.k(1).a());
        f786k = new F1.k(2);
        f787l = b(Character.TYPE, Character.class, new F1.k(5));
        F1.k kVar2 = new F1.k(6);
        f788m = new F1.k(7);
        f789n = new F1.k(8);
        f790o = new F1.k(9);
        f791p = a(String.class, kVar2);
        f792q = a(StringBuilder.class, new F1.k(10));
        f793r = a(StringBuffer.class, new F1.k(12));
        f794s = a(URL.class, new F1.k(13));
        f795t = a(URI.class, new F1.k(14));
        f796u = new v(InetAddress.class, new F1.k(15), i4);
        f797v = a(UUID.class, new F1.k(16));
        f798w = a(Currency.class, new F1.k(17).a());
        f799x = new w(Calendar.class, GregorianCalendar.class, new F1.k(18), i4);
        f800y = a(Locale.class, new F1.k(19));
        F1.k kVar3 = new F1.k(20);
        f801z = kVar3;
        f774A = new v(F1.p.class, kVar3, i4);
        f775B = new a(2);
    }

    public static v a(Class cls, A a4) {
        return new v(cls, a4, 0);
    }

    public static w b(Class cls, Class cls2, A a4) {
        return new w(cls, cls2, a4, 0);
    }
}
