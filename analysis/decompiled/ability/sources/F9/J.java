package F9;

import j9.AbstractC1607a;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class J {
    public static I a(B b, byte[] bArr, int i, int i6) {
        kotlin.jvm.internal.k.f(bArr, "<this>");
        long length = bArr.length;
        long j5 = i;
        long j6 = i6;
        byte[] bArr2 = G9.b.f704a;
        if ((j5 | j6) < 0 || j5 > length || length - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return new I(b, bArr, i6, i);
    }

    public static I b(String str, B b) {
        kotlin.jvm.internal.k.f(str, "<this>");
        Charset charset = AbstractC1607a.f4778a;
        if (b != null) {
            Pattern pattern = B.e;
            Charset charsetA = b.a(null);
            if (charsetA == null) {
                b = AbstractC0226d.j(b + "; charset=utf-8");
            } else {
                charset = charsetA;
            }
        }
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.k.e(bytes, "this as java.lang.String).getBytes(charset)");
        return a(b, bytes, 0, bytes.length);
    }

    public static /* synthetic */ I c(J j5, byte[] bArr, B b, int i, int i6) {
        if ((i6 & 1) != 0) {
            b = null;
        }
        if ((i6 & 2) != 0) {
            i = 0;
        }
        int length = bArr.length;
        j5.getClass();
        return a(b, bArr, i, length);
    }
}
