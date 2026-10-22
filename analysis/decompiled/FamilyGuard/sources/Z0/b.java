package Z0;

import java.util.List;
import org.ahocorasick.trie.Trie;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static Trie f6619a;

    /* renamed from: b, reason: collision with root package name */
    static List<g> f6620b;

    private static short a(byte[] bArr, byte[] bArr2, int i5) {
        int i6 = i5 % 8;
        short s5 = (short) (bArr2[i5] & 255);
        return (bArr[i5 / 8] & f.f6627a[i6]) != 0 ? (short) (s5 | 256) : s5;
    }

    private static int b(char c6) {
        int i5 = c6 - 19968;
        return (i5 < 0 || i5 >= 7000) ? (7000 > i5 || i5 >= 14000) ? a(e.f6625a, e.f6626b, c6 - 33968) : a(d.f6623a, d.f6624b, c6 - 26968) : a(c.f6621a, c.f6622b, i5);
    }

    public static boolean c(char c6) {
        return (19968 <= c6 && c6 <= 40869 && b(c6) > 0) || 12295 == c6;
    }

    public static String d(char c6) {
        return c(c6) ? c6 == 12295 ? "LING" : f.f6628b[b(c6)] : String.valueOf(c6);
    }

    public static String e(String str, String str2) {
        return a.b(str, f6619a, f6620b, str2, null);
    }
}
