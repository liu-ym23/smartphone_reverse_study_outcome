package D9;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f438a = new char[117];
    public static final byte[] b = new byte[126];

    static {
        for (int i = 0; i < 32; i++) {
        }
        a(8, 'b');
        a(9, 't');
        a(10, 'n');
        a(12, 'f');
        a(13, 'r');
        a(47, JsonPointer.SEPARATOR);
        a(34, JsonFactory.DEFAULT_QUOTE_CHAR);
        a(92, '\\');
        byte[] bArr = b;
        for (int i6 = 0; i6 < 33; i6++) {
            bArr[i6] = 127;
        }
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
    }

    public static void a(int i, char c) {
        if (c != 'u') {
            f438a[c] = (char) i;
        }
    }
}
