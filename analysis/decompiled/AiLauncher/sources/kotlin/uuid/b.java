package kotlin.uuid;

import La.C0956f;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\u000f\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0012\u001a\u00020\u000e*\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u001b\u0010\u001a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001d\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"", "randomBytes", "Lkotlin/uuid/Uuid;", "n", "([B)Lkotlin/uuid/Uuid;", "", "index", "", "k", "([BI)J", "dst", "dstOffset", "startIndex", "endIndex", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J[BIII)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;I)V", "hexDashString", "p", "(Ljava/lang/String;)Lkotlin/uuid/Uuid;", "hexString", "o", "maxLength", "l", "(Ljava/lang/String;I)Ljava/lang/String;", "maxSize", "m", "([BI)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
/* loaded from: classes5.dex */
public class b extends a {
    public static final void i(String str, int i10) {
        p.i(str, "<this>");
        if (str.charAt(i10) == '-') {
            return;
        }
        throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + i10 + ", but was '" + str.charAt(i10) + '\'').toString());
    }

    public static final void j(long j10, byte[] dst, int i10, int i11, int i12) {
        p.i(dst, "dst");
        int i13 = 7 - i11;
        int i14 = 8 - i12;
        if (i14 > i13) {
            return;
        }
        while (true) {
            int i15 = C0956f.d()[(int) ((j10 >> (i13 << 3)) & 255)];
            int i16 = i10 + 1;
            dst[i10] = (byte) (i15 >> 8);
            i10 += 2;
            dst[i16] = (byte) i15;
            if (i13 == i14) {
                return;
            } else {
                i13--;
            }
        }
    }

    public static final long k(byte[] bArr, int i10) {
        p.i(bArr, "<this>");
        return (bArr[i10 + 7] & 255) | ((bArr[i10] & 255) << 56) | ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
    }

    public static final String l(String str, int i10) {
        if (str.length() <= i10) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        p.g(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, i10);
        p.h(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        sb2.append("...");
        return sb2.toString();
    }

    public static final String m(byte[] bArr, int i10) {
        return r.v0(bArr, null, "[", "]", i10, null, null, 49, null);
    }

    public static final Uuid n(byte[] randomBytes) {
        p.i(randomBytes, "randomBytes");
        byte b10 = (byte) (randomBytes[6] & 15);
        randomBytes[6] = b10;
        randomBytes[6] = (byte) (b10 | 64);
        byte b11 = (byte) (randomBytes[8] & 63);
        randomBytes[8] = b11;
        randomBytes[8] = (byte) (b11 | 128);
        return Uuid.INSTANCE.a(randomBytes);
    }

    public static final Uuid o(String hexString) {
        p.i(hexString, "hexString");
        return Uuid.INSTANCE.b(C0956f.f(hexString, 0, 16, null, 4, null), C0956f.f(hexString, 16, 32, null, 4, null));
    }

    public static final Uuid p(String hexDashString) {
        p.i(hexDashString, "hexDashString");
        long jF = C0956f.f(hexDashString, 0, 8, null, 4, null);
        i(hexDashString, 8);
        long jF2 = C0956f.f(hexDashString, 9, 13, null, 4, null);
        i(hexDashString, 13);
        long jF3 = C0956f.f(hexDashString, 14, 18, null, 4, null);
        i(hexDashString, 18);
        long jF4 = C0956f.f(hexDashString, 19, 23, null, 4, null);
        i(hexDashString, 23);
        return Uuid.INSTANCE.b((jF2 << 16) | (jF << 32) | jF3, (jF4 << 48) | C0956f.f(hexDashString, 24, 36, null, 4, null));
    }
}
