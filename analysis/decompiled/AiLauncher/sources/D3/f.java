package D3;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2260a = Charset.defaultCharset();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f2261b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f2262c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f2263d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f2264e;

    static {
        Charset charsetForName;
        Charset charsetForName2;
        Charset charsetForName3 = null;
        try {
            charsetForName = Charset.forName("SJIS");
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        f2261b = charsetForName;
        try {
            charsetForName2 = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused2) {
            charsetForName2 = null;
        }
        f2262c = charsetForName2;
        try {
            charsetForName3 = Charset.forName("EUC_JP");
        } catch (UnsupportedCharsetException unused3) {
        }
        f2263d = charsetForName3;
        Charset charset = f2261b;
        f2264e = (charset != null && charset.equals(f2260a)) || (charsetForName3 != null && charsetForName3.equals(f2260a));
    }
}
