package h3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import k3.C0694i;
import k3.InterfaceC0696k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes2.dex */
public final class e0 {
    public static d0 a(String string, M m4) {
        Intrinsics.checkNotNullParameter(string, "<this>");
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
        C0694i c0694i = new C0694i();
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        c0694i.b0(string, 0, string.length(), charset);
        return b(c0694i, m4, c0694i.f13357b);
    }

    public static d0 b(InterfaceC0696k interfaceC0696k, M m4, long j4) {
        Intrinsics.checkNotNullParameter(interfaceC0696k, "<this>");
        return new d0(m4, j4, interfaceC0696k);
    }

    public static d0 c(byte[] bArr, M m4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        C0694i c0694i = new C0694i();
        c0694i.U(bArr);
        return b(c0694i, m4, bArr.length);
    }
}
