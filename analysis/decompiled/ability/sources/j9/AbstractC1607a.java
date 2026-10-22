package j9;

import java.nio.charset.Charset;

/* renamed from: j9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1607a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4778a;
    public static final Charset b;
    public static volatile Charset c;
    public static volatile Charset d;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.k.e(charsetForName, "forName(...)");
        f4778a = charsetForName;
        kotlin.jvm.internal.k.e(Charset.forName("UTF-16"), "forName(...)");
        kotlin.jvm.internal.k.e(Charset.forName("UTF-16BE"), "forName(...)");
        kotlin.jvm.internal.k.e(Charset.forName("UTF-16LE"), "forName(...)");
        Charset charsetForName2 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.k.e(charsetForName2, "forName(...)");
        b = charsetForName2;
        kotlin.jvm.internal.k.e(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
