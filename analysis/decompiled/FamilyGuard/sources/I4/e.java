package I4;

import java.io.IOException;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    static final L4.h f3017a = L4.h.h("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f3018b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c, reason: collision with root package name */
    static final String[] f3019c = new String[64];

    /* renamed from: d, reason: collision with root package name */
    static final String[] f3020d = new String[256];

    static {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = f3020d;
            if (i6 >= strArr.length) {
                break;
            }
            strArr[i6] = D4.e.q("%8s", Integer.toBinaryString(i6)).replace(' ', '0');
            i6++;
        }
        String[] strArr2 = f3019c;
        strArr2[0] = BuildConfig.FLAVOR;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i7 = iArr[0];
        strArr2[i7 | 8] = strArr2[i7] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr2[i8];
            int i10 = iArr[0];
            String[] strArr3 = f3019c;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + '|' + strArr3[i9];
            strArr3[i11 | 8] = strArr3[i10] + '|' + strArr3[i9] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f3019c;
            if (i5 >= strArr4.length) {
                return;
            }
            if (strArr4[i5] == null) {
                strArr4[i5] = f3020d[i5];
            }
            i5++;
        }
    }

    private e() {
    }

    static String a(byte b6, byte b7) {
        if (b7 == 0) {
            return BuildConfig.FLAVOR;
        }
        if (b6 != 2 && b6 != 3) {
            if (b6 == 4 || b6 == 6) {
                return b7 == 1 ? "ACK" : f3020d[b7];
            }
            if (b6 != 7 && b6 != 8) {
                String[] strArr = f3019c;
                String str = b7 < strArr.length ? strArr[b7] : f3020d[b7];
                return (b6 != 5 || (b7 & 4) == 0) ? (b6 != 0 || (b7 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f3020d[b7];
    }

    static String b(boolean z5, int i5, int i6, byte b6, byte b7) {
        String[] strArr = f3018b;
        return D4.e.q("%s 0x%08x %5d %-13s %s", z5 ? "<<" : ">>", Integer.valueOf(i5), Integer.valueOf(i6), b6 < strArr.length ? strArr[b6] : D4.e.q("0x%02x", Byte.valueOf(b6)), a(b6, b7));
    }

    static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(D4.e.q(str, objArr));
    }

    static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(D4.e.q(str, objArr));
    }
}
