package La;

import La.HexFormat;
import Z8.AbstractC1156d;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0003\u001a1\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001aC\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0013\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a3\u0010\u001b\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a3\u0010 \u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b \u0010!\u001a3\u0010\"\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\"\u0010!\u001a\u001b\u0010$\u001a\u00020#*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0001H\u0002¢\u0006\u0004\b$\u0010%\"\u001a\u0010*\u001a\u00020&8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)\"\u0014\u0010+\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'\"\u0014\u0010,\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010'\"\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010.¨\u00060"}, d2 = {"", "", "startIndex", "endIndex", "LLa/g;", "format", "", "e", "(Ljava/lang/String;IILLa/g;)J", "typeHexLength", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;IILLa/g;I)J", "prefix", "suffix", "", "ignoreCase", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZI)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;III)V", "c", "(Ljava/lang/String;II)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;II)J", "specifier", "expected", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;IILjava/lang/String;I)V", "index", "part", "partName", "l", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "k", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;I)Ljava/lang/Void;", "", "[I", Const.INTENT_KEY_UMID, "()[I", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "", "[J", "HEX_DIGITS_TO_LONG_DECIMAL", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: La.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0956f {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4355a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f4356b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f4357c;

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f4358d;

    static {
        int[] iArr = new int[256];
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            iArr[i11] = "0123456789abcdef".charAt(i11 & 15) | ("0123456789abcdef".charAt(i11 >> 4) << '\b');
        }
        f4355a = iArr;
        int[] iArr2 = new int[256];
        for (int i12 = 0; i12 < 256; i12++) {
            iArr2[i12] = "0123456789ABCDEF".charAt(i12 & 15) | ("0123456789ABCDEF".charAt(i12 >> 4) << '\b');
        }
        f4356b = iArr2;
        int[] iArr3 = new int[256];
        for (int i13 = 0; i13 < 256; i13++) {
            iArr3[i13] = -1;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i14)] = i15;
            i14++;
            i15++;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i16)] = i17;
            i16++;
            i17++;
        }
        f4357c = iArr3;
        long[] jArr = new long[256];
        for (int i18 = 0; i18 < 256; i18++) {
            jArr[i18] = -1;
        }
        int i19 = 0;
        int i20 = 0;
        while (i19 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i19)] = i20;
            i19++;
            i20++;
        }
        int i21 = 0;
        while (i10 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i10)] = i21;
            i10++;
            i21++;
        }
        f4358d = jArr;
    }

    public static final void a(String str, int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if (i13 < 1) {
            j(str, i10, i11, "at least", 1);
        } else if (i13 > i12) {
            c(str, i10, (i13 + i10) - i12);
        }
    }

    public static final void b(String str, int i10, int i11, String str2, String str3, boolean z10, int i12) {
        if ((i11 - i10) - str2.length() <= str3.length()) {
            k(str, i10, i11, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i13 = 0; i13 < length; i13++) {
                if (!C0952b.d(str2.charAt(i13), str.charAt(i10 + i13), z10)) {
                    l(str, i10, i11, str2, "prefix");
                }
            }
            i10 += str2.length();
        }
        int length2 = i11 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i14 = 0; i14 < length3; i14++) {
                if (!C0952b.d(str3.charAt(i14), str.charAt(length2 + i14), z10)) {
                    l(str, length2, i11, str3, "suffix");
                }
            }
        }
        a(str, i10, length2, i12);
    }

    public static final void c(String str, int i10, int i11) {
        while (i10 < i11) {
            if (str.charAt(i10) != '0') {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i10 + ", but was '" + str.charAt(i10) + "'.\nThe result won't fit the type being parsed.");
            }
            i10++;
        }
    }

    public static final int[] d() {
        return f4355a;
    }

    public static final long e(String str, int i10, int i11, HexFormat format) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(format, "format");
        return g(str, i10, i11, format, 16);
    }

    public static /* synthetic */ long f(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.a();
        }
        return e(str, i10, i11, hexFormat);
    }

    public static final long g(String str, int i10, int i11, HexFormat hexFormat, int i12) {
        AbstractC1156d.INSTANCE.a(i10, i11, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getCom.autonavi.aps.amapapi.config.Const.JSON_KEY_NUMBER java.lang.String();
        if (number.getIsDigitsOnly()) {
            a(str, i10, i11, i12);
            return h(str, i10, i11);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        b(str, i10, i11, prefix, suffix, number.getIgnoreCase(), i12);
        return h(str, i10 + prefix.length(), i11 - suffix.length());
    }

    public static final long h(String str, int i10, int i11) {
        long j10 = 0;
        while (i10 < i11) {
            long j11 = j10 << 4;
            char cCharAt = str.charAt(i10);
            if ((cCharAt >>> '\b') == 0) {
                long j12 = f4358d[cCharAt];
                if (j12 >= 0) {
                    j10 = j11 | j12;
                    i10++;
                }
            }
            i(str, i10);
            throw new KotlinNothingValueException();
        }
        return j10;
    }

    public static final Void i(String str, int i10) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i10 + ", but was " + str.charAt(i10));
    }

    public static final void j(String str, int i10, int i11, String str2, int i12) {
        kotlin.jvm.internal.p.g(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, i11);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i12 + " hexadecimal digits at index " + i10 + ", but was \"" + strSubstring + "\" of length " + (i11 - i10));
    }

    public static final void k(String str, int i10, int i11, String str2, String str3) {
        kotlin.jvm.internal.p.g(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, i11);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + strSubstring);
    }

    public static final void l(String str, int i10, int i11, String str2, String str3) {
        int iJ = C5685n.j(str2.length() + i10, i11);
        kotlin.jvm.internal.p.g(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, iJ);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i10 + ", but was " + strSubstring);
    }
}
