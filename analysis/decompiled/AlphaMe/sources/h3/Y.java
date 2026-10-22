package h3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class Y {
    public static X a(String str, M m4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Charset charset = Charsets.UTF_8;
        if (m4 != null) {
            Pattern pattern = M.f12732d;
            Charset charsetA = m4.a(null);
            if (charsetA == null) {
                m4 = C0611u.t(m4 + "; charset=utf-8");
            } else {
                charset = charsetA;
            }
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return b(bytes, m4, 0, bytes.length);
    }

    public static X b(byte[] bArr, M m4, int i4, int i5) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Util.checkOffsetAndCount(bArr.length, i4, i5);
        return new X(m4, bArr, i5, i4);
    }

    public static /* synthetic */ X c(Y y4, byte[] bArr, M m4, int i4, int i5) {
        if ((i5 & 1) != 0) {
            m4 = null;
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        int length = bArr.length;
        y4.getClass();
        return b(bArr, m4, i4, length);
    }
}
