package r4;

import java.nio.charset.Charset;

/* renamed from: r4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1020c {

    /* renamed from: a, reason: collision with root package name */
    public static final C1020c f20082a = new C1020c();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f20083b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f20084c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f20085d;

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f20086e;

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f20087f;

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f20088g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        j4.k.f(charsetForName, "forName(...)");
        f20083b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        j4.k.f(charsetForName2, "forName(...)");
        f20084c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        j4.k.f(charsetForName3, "forName(...)");
        f20085d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        j4.k.f(charsetForName4, "forName(...)");
        f20086e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        j4.k.f(charsetForName5, "forName(...)");
        f20087f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        j4.k.f(charsetForName6, "forName(...)");
        f20088g = charsetForName6;
    }

    private C1020c() {
    }
}
