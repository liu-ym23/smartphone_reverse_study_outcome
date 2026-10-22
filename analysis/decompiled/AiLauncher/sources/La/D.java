package La;

import Z8.AbstractC1156d;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Comparator;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0016\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u0000*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0015\u001a\u00020\u0000*\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0018\u001a\u00020\u0000*\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010\u001b\u001a\u00020\u0000*\u00020\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001d\u001a\u00020\u0017*\u00020\u0000H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a1\u0010\u001f\u001a\u00020\u0017*\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\"\u001a\u00020\u0002*\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\u0005\u001a+\u0010#\u001a\u00020\u0002*\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$\u001a#\u0010&\u001a\u00020\u0002*\u00020\u00002\u0006\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0005\u001a#\u0010'\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(\u001a;\u0010,\u001a\u00020\u0002*\u00020\u00002\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-\u001a\u0019\u00100\u001a\u00020\u0000*\u00020.2\u0006\u0010/\u001a\u00020\u0012¢\u0006\u0004\b0\u00101\"%\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u000003j\b\u0012\u0004\u0012\u00020\u0000`4*\u0002028F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"", "other", "", "ignoreCase", "L", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "", "oldChar", "newChar", "Q", "(Ljava/lang/String;CCZ)Ljava/lang/String;", "oldValue", "newValue", "R", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "", "B", "([C)Ljava/lang/String;", "", "startIndex", "endIndex", "C", "([CII)Ljava/lang/String;", "", "D", "([B)Ljava/lang/String;", "throwOnInvalidSequence", ExifInterface.LONGITUDE_EAST, "([BIIZ)Ljava/lang/String;", "G", "(Ljava/lang/String;)[B", "H", "(Ljava/lang/String;IIZ)[B", "prefix", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "U", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "suffix", "J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;Z)I", "thisOffset", "otherOffset", "length", "N", "(Ljava/lang/String;ILjava/lang/String;IIZ)Z", "", "n", "P", "(Ljava/lang/CharSequence;I)Ljava/lang/String;", "Lkotlin/String$Companion;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "M", "(Lkotlin/jvm/internal/y;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
public class D extends C {
    public static int A(String str, String other, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        return z10 ? str.compareToIgnoreCase(other) : str.compareTo(other);
    }

    public static String B(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        return new String(cArr);
    }

    public static String C(char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        AbstractC1156d.INSTANCE.a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    public static String D(byte[] bArr) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        return new String(bArr, C0953c.UTF_8);
    }

    public static final String E(byte[] bArr, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        AbstractC1156d.INSTANCE.a(i10, i11, bArr.length);
        if (!z10) {
            return new String(bArr, i10, i11 - i10, C0953c.UTF_8);
        }
        CharsetDecoder charsetDecoderNewDecoder = C0953c.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i10, i11 - i10)).toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String F(byte[] bArr, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return E(bArr, i10, i11, z10);
    }

    public static byte[] G(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        byte[] bytes = str.getBytes(C0953c.UTF_8);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        return bytes;
    }

    public static final byte[] H(String str, int i10, int i11, boolean z10) throws CharacterCodingException {
        kotlin.jvm.internal.p.i(str, "<this>");
        AbstractC1156d.INSTANCE.a(i10, i11, str.length());
        if (!z10) {
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            Charset charset = C0953c.UTF_8;
            kotlin.jvm.internal.p.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = strSubstring.getBytes(charset);
            kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
            return bytes;
        }
        CharsetEncoder charsetEncoderNewEncoder = C0953c.UTF_8.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, i10, i11));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            kotlin.jvm.internal.p.f(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                kotlin.jvm.internal.p.f(bArrArray2);
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    public static /* synthetic */ byte[] I(String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return H(str, i10, i11, z10);
    }

    public static boolean J(String str, String suffix, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(suffix, "suffix");
        return !z10 ? str.endsWith(suffix) : N(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean K(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return J(str, str2, z10);
    }

    public static boolean L(String str, String str2, boolean z10) {
        return str == null ? str2 == null : !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Comparator<String> M(kotlin.jvm.internal.y yVar) {
        kotlin.jvm.internal.p.i(yVar, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.p.h(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static boolean N(String str, int i10, String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        return !z10 ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z10, i10, other, i11, i12);
    }

    public static /* synthetic */ boolean O(String str, int i10, String str2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return N(str, i10, str2, i11, i12, z10);
    }

    public static String P(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.p.i(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        }
        if (i10 == 0) {
            return "";
        }
        int i11 = 1;
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                cArr[i12] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
        if (1 <= i10) {
            while (true) {
                sb2.append(charSequence);
                if (i11 == i10) {
                    break;
                }
                i11++;
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.f(string);
        return string;
    }

    public static final String Q(String str, char c10, char c11, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        if (!z10) {
            String strReplace = str.replace(c10, c11);
            kotlin.jvm.internal.p.h(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (C0952b.d(cCharAt, c10, z10)) {
                cCharAt = c11;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static final String R(String str, String oldValue, String newValue, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(oldValue, "oldValue");
        kotlin.jvm.internal.p.i(newValue, "newValue");
        int i10 = 0;
        int iQ0 = H.q0(str, oldValue, 0, z10);
        if (iQ0 < 0) {
            return str;
        }
        int length = oldValue.length();
        int iF = C5685n.f(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iQ0);
            sb2.append(newValue);
            i10 = iQ0 + length;
            if (iQ0 >= str.length()) {
                break;
            }
            iQ0 = H.q0(str, oldValue, iQ0 + iF, z10);
        } while (iQ0 > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String S(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return Q(str, c10, c11, z10);
    }

    public static /* synthetic */ String T(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return R(str, str2, str3, z10);
    }

    public static boolean U(String str, String prefix, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        return !z10 ? str.startsWith(prefix, i10) : N(str, i10, prefix, 0, prefix.length(), z10);
    }

    public static boolean V(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : N(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean W(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return U(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean X(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return V(str, str2, z10);
    }
}
