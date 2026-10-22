package okio;

import Mb.M;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0007\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\"\u001a\u0010\f\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001a\u0010\u000e\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)[B", "", "includePadding", C3081a.FOCUS_MAP_NAME, Const.INTENT_KEY_PKGNAME, "([BZ[B)Ljava/lang/String;", "[B", "getBASE64", "()[B", "BASE64", "getBASE64_URL_SAFE", "BASE64_URL_SAFE", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f37762a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f37763b;

    static {
        ByteString.a aVar = ByteString.f37755d;
        f37762a = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").m();
        f37763b = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").m();
    }

    public static final byte[] a(String str) {
        int i10;
        char cCharAt;
        p.i(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i11 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            char cCharAt2 = str.charAt(i15);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i10 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i10 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i10 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i10 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i10 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i13 = (i13 << 6) | i10;
            i12++;
            if (i12 % 4 == 0) {
                bArr[i14] = (byte) (i13 >> 16);
                int i16 = i14 + 2;
                bArr[i14 + 1] = (byte) (i13 >> 8);
                i14 += 3;
                bArr[i16] = (byte) i13;
            }
        }
        int i17 = i12 % 4;
        if (i17 == 1) {
            return null;
        }
        if (i17 == 2) {
            bArr[i14] = (byte) ((i13 << 12) >> 16);
            i14++;
        } else if (i17 == 3) {
            int i18 = i13 << 6;
            int i19 = i14 + 1;
            bArr[i14] = (byte) (i18 >> 16);
            i14 += 2;
            bArr[i19] = (byte) (i18 >> 8);
        }
        if (i14 == i11) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i14);
        p.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static final String b(byte[] bArr, boolean z10, byte[] map) {
        p.i(bArr, "<this>");
        p.i(map, "map");
        byte[] bArr2 = new byte[z10 ? ((bArr.length + 2) / 3) * 4 : ((bArr.length * 4) + 2) / 3];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i10 + 2;
            byte b11 = bArr[i10 + 1];
            i10 += 3;
            byte b12 = bArr[i12];
            bArr2[i11] = map[(b10 & 255) >> 2];
            bArr2[i11 + 1] = map[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i13 = i11 + 3;
            bArr2[i11 + 2] = map[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 += 4;
            bArr2[i13] = map[b12 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b13 = bArr[i10];
            bArr2[i11] = map[(b13 & 255) >> 2];
            int i14 = i11 + 2;
            bArr2[i11 + 1] = map[(b13 & 3) << 4];
            if (z10) {
                bArr2[i14] = 61;
                bArr2[i11 + 3] = 61;
            }
        } else if (length2 == 2) {
            int i15 = i10 + 1;
            byte b14 = bArr[i10];
            byte b15 = bArr[i15];
            bArr2[i11] = map[(b14 & 255) >> 2];
            int i16 = i11 + 2;
            bArr2[i11 + 1] = map[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            int i17 = i11 + 3;
            bArr2[i16] = map[(b15 & 15) << 2];
            if (z10) {
                bArr2[i17] = 61;
            }
        }
        return M.c(bArr2);
    }

    public static /* synthetic */ String c(byte[] bArr, boolean z10, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bArr2 = f37762a;
        }
        return b(bArr, z10, bArr2);
    }
}
