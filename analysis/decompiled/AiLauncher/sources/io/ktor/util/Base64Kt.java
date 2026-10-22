package io.ktor.util;

import La.D;
import La.H;
import fb.C4074a;
import fb.v;
import fb.x;
import io.ktor.utils.io.core.InputKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0001\u0010\u0004\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0005¢\u0006\u0004\b\u0001\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0002\u001a\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\b\u001a\u00060\u0005j\u0002`\n*\u00020\u0005¢\u0006\u0004\b\b\u0010\u000b\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\fH\u0080\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u0010H\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"", "encodeBase64", "(Ljava/lang/String;)Ljava/lang/String;", "", "([B)Ljava/lang/String;", "Lfb/v;", "(Lfb/v;)Ljava/lang/String;", "decodeBase64String", "decodeBase64Bytes", "(Ljava/lang/String;)[B", "Lio/ktor/utils/io/core/Input;", "(Lfb/v;)Lfb/v;", "", "", "toBase64", "(I)C", "", "fromBase64", "(B)B", "BASE64_ALPHABET", "Ljava/lang/String;", "BASE64_MASK", "B", "BASE64_MASK_INT", "I", "BASE64_PAD", "C", "", "BASE64_INVERSE_ALPHABET", "[I", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Base64Kt {
    private static final String BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static final int[] BASE64_INVERSE_ALPHABET;
    private static final byte BASE64_MASK = 63;
    private static final int BASE64_MASK_INT = 63;
    private static final char BASE64_PAD = '=';

    static {
        int[] iArr = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr[i10] = H.t0(BASE64_ALPHABET, (char) i10, 0, false, 6, null);
        }
        iArr[45] = iArr[43];
        iArr[95] = iArr[47];
        BASE64_INVERSE_ALPHABET = iArr;
    }

    public static final byte[] decodeBase64Bytes(String str) {
        String strSubstring;
        kotlin.jvm.internal.p.i(str, "<this>");
        C4074a c4074a = new C4074a();
        int iN0 = H.n0(str);
        while (true) {
            if (-1 >= iN0) {
                strSubstring = "";
                break;
            }
            if (str.charAt(iN0) != '=') {
                strSubstring = str.substring(0, iN0 + 1);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                break;
            }
            iN0--;
        }
        StringsKt.writeText$default(c4074a, strSubstring, 0, 0, (Charset) null, 14, (Object) null);
        return x.c(decodeBase64Bytes(c4074a));
    }

    public static final String decodeBase64String(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        byte[] bArrDecodeBase64Bytes = decodeBase64Bytes(str);
        return D.F(bArrDecodeBase64Bytes, 0, bArrDecodeBase64Bytes.length, false, 4, null);
    }

    public static final String encodeBase64(byte[] bArr) {
        int i10;
        int i11;
        kotlin.jvm.internal.p.i(bArr, "<this>");
        int i12 = 3;
        char[] cArr = new char[((bArr.length * 8) / 6) + 3];
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i13 + 3;
            if (i15 > bArr.length) {
                break;
            }
            int i16 = (bArr[i13 + 2] & 255) | ((bArr[i13] & 255) << 16) | ((bArr[i13 + 1] & 255) << 8);
            int i17 = 3;
            while (-1 < i17) {
                cArr[i14] = BASE64_ALPHABET.charAt((i16 >> (i17 * 6)) & 63);
                i17--;
                i14++;
            }
            i13 = i15;
        }
        int length = bArr.length - i13;
        if (length == 0) {
            return D.C(cArr, 0, i14);
        }
        if (length == 1) {
            i10 = (bArr[i13] & 255) << 16;
        } else {
            i10 = ((bArr[i13 + 1] & 255) << 8) | ((bArr[i13] & 255) << 16);
        }
        int i18 = ((3 - length) * 8) / 6;
        if (i18 <= 3) {
            while (true) {
                i11 = i14 + 1;
                cArr[i14] = BASE64_ALPHABET.charAt((i10 >> (i12 * 6)) & 63);
                if (i12 == i18) {
                    break;
                }
                i12--;
                i14 = i11;
            }
            i14 = i11;
        }
        int i19 = 0;
        while (i19 < i18) {
            cArr[i14] = BASE64_PAD;
            i19++;
            i14++;
        }
        return D.C(cArr, 0, i14);
    }

    public static final byte fromBase64(byte b10) {
        return (byte) (((byte) BASE64_INVERSE_ALPHABET[b10 & 255]) & BASE64_MASK);
    }

    public static final char toBase64(int i10) {
        return BASE64_ALPHABET.charAt(i10);
    }

    public static final v decodeBase64Bytes(v vVar) {
        int i10;
        kotlin.jvm.internal.p.i(vVar, "<this>");
        C4074a c4074a = new C4074a();
        byte[] bArr = new byte[4];
        while (!vVar.k()) {
            int i11 = 0;
            v vVar2 = vVar;
            int available$default = InputKt.readAvailable$default(vVar2, bArr, 0, 0, 6, null);
            int i12 = 0;
            int i13 = 0;
            while (i11 < 4) {
                i12 |= ((byte) (((byte) BASE64_INVERSE_ALPHABET[bArr[i11] & 255]) & BASE64_MASK)) << ((3 - i13) * 6);
                i11++;
                i13++;
            }
            int i14 = 4 - available$default;
            if (i14 <= 2) {
                while (true) {
                    c4074a.H0((byte) ((i12 >> (i10 * 8)) & 255));
                    i10 = i10 != i14 ? i10 - 1 : 2;
                }
            }
            vVar = vVar2;
        }
        return c4074a;
    }

    public static final String encodeBase64(v vVar) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        return encodeBase64(x.c(vVar));
    }

    public static final String encodeBase64(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        C4074a c4074a = new C4074a();
        StringsKt.writeText$default(c4074a, str, 0, 0, (Charset) null, 14, (Object) null);
        return encodeBase64(c4074a);
    }
}
