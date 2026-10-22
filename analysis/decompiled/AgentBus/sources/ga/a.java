package ga;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4005a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Charset f4006b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Charset f4007c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        q7.k.d(charsetForName, "forName(...)");
        f4005a = charsetForName;
        q7.k.d(Charset.forName("UTF-16"), "forName(...)");
        q7.k.d(Charset.forName("UTF-16BE"), "forName(...)");
        q7.k.d(Charset.forName("UTF-16LE"), "forName(...)");
        q7.k.d(Charset.forName("US-ASCII"), "forName(...)");
        q7.k.d(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
