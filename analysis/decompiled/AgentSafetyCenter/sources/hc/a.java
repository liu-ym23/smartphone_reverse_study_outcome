package hc;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f5448a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Charset f5449b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Charset f5450c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        charsetForName.getClass();
        f5448a = charsetForName;
        Charset.forName("UTF-16").getClass();
        Charset.forName("UTF-16BE").getClass();
        Charset.forName("UTF-16LE").getClass();
        Charset.forName("US-ASCII").getClass();
        Charset.forName("ISO-8859-1").getClass();
    }
}
