package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0086\u0080\u0004J\u0012\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082\u0080\u0004J\u001c\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0080\u0004J\u0012\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\nH\u0086\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/internal/InternalHexConverter;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "hexCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "parseHexBinary", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "s", "hexToInt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ch", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "printHexBinary", "data", "lowerCase", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toHexString", "n", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InternalHexConverter {
    public static final InternalHexConverter INSTANCE = new InternalHexConverter();
    private static final String hexCode = "0123456789ABCDEF";

    private InternalHexConverter() {
    }

    private final int hexToInt(char ch) {
        if ('0' <= ch && ch < ':') {
            return ch - '0';
        }
        if ('A' <= ch && ch < 'G') {
            return ch - '7';
        }
        if ('a' > ch || ch >= 'g') {
            return -1;
        }
        return ch - 'W';
    }

    public static /* synthetic */ String printHexBinary$default(InternalHexConverter internalHexConverter, byte[] bArr, boolean z, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z = false;
        }
        return internalHexConverter.printHexBinary(bArr, z);
    }

    public final byte[] parseHexBinary(String s8) {
        p.e(s8, "s");
        int length = s8.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("HexBinary string must be even length");
        }
        byte[] bArr = new byte[length / 2];
        for (int i8 = 0; i8 < length; i8 += 2) {
            int iHexToInt = hexToInt(s8.charAt(i8));
            int i9 = i8 + 1;
            int iHexToInt2 = hexToInt(s8.charAt(i9));
            if (iHexToInt == -1 || iHexToInt2 == -1) {
                throw new IllegalArgumentException(("Invalid hex chars: " + s8.charAt(i8) + s8.charAt(i9)).toString());
            }
            bArr[i8 / 2] = (byte) ((iHexToInt << 4) + iHexToInt2);
        }
        return bArr;
    }

    public final String printHexBinary(byte[] data, boolean lowerCase) {
        p.e(data, "data");
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte b9 : data) {
            sb.append(hexCode.charAt((b9 >> 4) & 15));
            sb.append(hexCode.charAt(b9 & 15));
        }
        String string = sb.toString();
        p.d(string, "toString(...)");
        if (!lowerCase) {
            return string;
        }
        String lowerCase2 = string.toLowerCase(Locale.ROOT);
        p.d(lowerCase2, "toLowerCase(...)");
        return lowerCase2;
    }

    public final String toHexString(int n3) {
        byte[] bArr = new byte[4];
        for (int i8 = 0; i8 < 4; i8++) {
            bArr[i8] = (byte) (n3 >> (24 - (i8 * 8)));
        }
        String strX1 = n.X1(printHexBinary(bArr, true), '0');
        if (strX1.length() <= 0) {
            strX1 = null;
        }
        return strX1 == null ? "0" : strX1;
    }
}
