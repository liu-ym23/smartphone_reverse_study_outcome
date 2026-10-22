package gc;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9105a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f9106b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f9107c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f9108d;

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f9109e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile Charset f9110f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile Charset f9111g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.g.e(charsetForName, "forName(...)");
        f9106b = charsetForName;
        kotlin.jvm.internal.g.e(Charset.forName("UTF-16"), "forName(...)");
        Charset charsetForName2 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.g.e(charsetForName2, "forName(...)");
        f9107c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.g.e(charsetForName3, "forName(...)");
        f9108d = charsetForName3;
        Charset charsetForName4 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.g.e(charsetForName4, "forName(...)");
        f9109e = charsetForName4;
        kotlin.jvm.internal.g.e(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
