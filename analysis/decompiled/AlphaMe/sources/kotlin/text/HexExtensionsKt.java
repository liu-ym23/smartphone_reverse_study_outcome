package kotlin.text;

import B0.g;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.HexFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0004\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a@\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a@\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002\u001a,\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H\u0002\u001a,\u0010\u001b\u001a\u00020\u001c*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a\u001c\u0010!\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002\u001a\u0014\u0010\"\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH\u0002\u001a*\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a0\u0010+\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\tH\u0003\u001a*\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\u00062\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020-2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u001c\u0010/\u001a\u00020\u0003*\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u00100\u001a\u00020\tH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"HEX_DIGITS_TO_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "formattedStringLength", "totalBytes", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "part", MapBundleKey.MapObjKey.OBJ_SL_INDEX, "endIndex", "partName", "checkHexLength", "", "startIndex", "maxDigits", "requireMaxLength", "", "checkNewLineAt", "decimalFromHexDigitAt", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "", "hexToInt", "hexToLong", "hexToLongImpl", "hexToShort", "", "toHexString", "toHexStringImpl", "bits", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,591:1\n1#2:592\n1183#3,3:593\n1183#3,3:596\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n13#1:593,3\n14#1:596,3\n*E\n"})
/* loaded from: classes2.dex */
public final class HexExtensionsKt {

    @NotNull
    private static final int[] HEX_DIGITS_TO_DECIMAL;

    @NotNull
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";

    @NotNull
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[128];
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            iArr[i5] = -1;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < LOWER_CASE_HEX_DIGITS.length()) {
            iArr[LOWER_CASE_HEX_DIGITS.charAt(i6)] = i7;
            i6++;
            i7++;
        }
        int i8 = 0;
        while (i4 < UPPER_CASE_HEX_DIGITS.length()) {
            iArr[UPPER_CASE_HEX_DIGITS.charAt(i4)] = i8;
            i4++;
            i8++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr;
    }

    private static final long charsPerSet(long j4, int i4, int i5) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j5 = i4;
        return ((j5 - 1) * i5) + (j4 * j5);
    }

    private static final int checkContainsAt(String str, String str2, int i4, int i5, String str3) {
        int length = str2.length() + i4;
        if (length <= i5 && StringsKt__StringsJVMKt.regionMatches(str, i4, str2, 0, str2.length(), true)) {
            return length;
        }
        StringBuilder sbX = g.x("Expected ", str3, " \"", str2, "\" at index ");
        sbX.append(i4);
        sbX.append(", but was ");
        int iCoerceAtMost = RangesKt.coerceAtMost(length, i5);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i4, iCoerceAtMost);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sbX.append(strSubstring);
        throw new NumberFormatException(sbX.toString());
    }

    private static final void checkHexLength(String str, int i4, int i5, int i6, boolean z4) {
        int i7 = i5 - i4;
        if (z4) {
            if (i7 == i6) {
                return;
            }
        } else if (i7 <= i6) {
            return;
        }
        String str2 = z4 ? "exactly" : "at most";
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i4, i5);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i6 + " hexadecimal digits at index " + i4 + ", but was " + strSubstring + " of length " + i7);
    }

    private static final int checkNewLineAt(String str, int i4, int i5) {
        if (str.charAt(i4) == '\r') {
            int i6 = i4 + 1;
            return (i6 >= i5 || str.charAt(i6) != '\n') ? i6 : i4 + 2;
        }
        if (str.charAt(i4) == '\n') {
            return i4 + 1;
        }
        StringBuilder sbT = g.t("Expected a new line at index ", i4, ", but was ");
        sbT.append(str.charAt(i4));
        throw new NumberFormatException(sbT.toString());
    }

    private static final int decimalFromHexDigitAt(String str, int i4) {
        int i5;
        char cCharAt = str.charAt(i4);
        if (cCharAt <= 127 && (i5 = HEX_DIGITS_TO_DECIMAL[cCharAt]) >= 0) {
            return i5;
        }
        StringBuilder sbT = g.t("Expected a hexadecimal digit at index ", i4, ", but was ");
        sbT.append(str.charAt(i4));
        throw new NumberFormatException(sbT.toString());
    }

    public static final int formattedStringLength(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i11 = i4 - 1;
        int i12 = i11 / i5;
        int i13 = (i5 - 1) / i6;
        int i14 = i4 % i5;
        if (i14 != 0) {
            i5 = i14;
        }
        int i15 = (i13 * i12) + ((i5 - 1) / i6);
        long j4 = ((i9 + 2 + i10) * i4) + (((i11 - i12) - i15) * i8) + (i15 * i7) + i12;
        if (RangesKt___RangesKt.intRangeContains((ClosedRange<Integer>) new IntRange(0, Integer.MAX_VALUE), j4)) {
            return (int) j4;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m242toStringimpl(ULong.m196constructorimpl(j4))));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte hexToByte(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final byte[] hexToByteArray(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int hexToInt(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long hexToLong(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLongImpl(String str, int i4, int i5, HexFormat hexFormat, int i6) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i4, i5, str.length());
        String prefix = hexFormat.getNumber().getPrefix();
        String suffix = hexFormat.getNumber().getSuffix();
        if (suffix.length() + prefix.length() >= i5 - i4) {
            StringBuilder sbX = g.x("Expected a hexadecimal number with prefix \"", prefix, "\" and suffix \"", suffix, "\", but was ");
            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = str.substring(i4, i5);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sbX.append(strSubstring);
            throw new NumberFormatException(sbX.toString());
        }
        int iCheckContainsAt = checkContainsAt(str, prefix, i4, i5, "prefix");
        int length = i5 - suffix.length();
        checkContainsAt(str, suffix, length, i5, "suffix");
        checkHexLength(str, iCheckContainsAt, length, i6, false);
        long jDecimalFromHexDigitAt = 0;
        while (iCheckContainsAt < length) {
            jDecimalFromHexDigitAt = (jDecimalFromHexDigitAt << 4) | decimalFromHexDigitAt(str, iCheckContainsAt);
            iCheckContainsAt++;
        }
        return jDecimalFromHexDigitAt;
    }

    public static /* synthetic */ long hexToLongImpl$default(String str, int i4, int i5, HexFormat hexFormat, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i4 = 0;
        }
        if ((i7 & 2) != 0) {
            i5 = str.length();
        }
        return hexToLongImpl(str, i4, i5, hexFormat, i6);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short hexToShort(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    public static final int parsedByteArrayMaxSize(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        long jCharsPerSet;
        int i11;
        int i12;
        if (i4 <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j4 = i9 + 2 + i10;
        long jCharsPerSet2 = charsPerSet(j4, i6, i8);
        if (i5 <= i6) {
            jCharsPerSet = charsPerSet(j4, i5, i8);
        } else {
            jCharsPerSet = charsPerSet(jCharsPerSet2, i5 / i6, i7);
            int i13 = i5 % i6;
            if (i13 != 0) {
                jCharsPerSet = jCharsPerSet + i7 + charsPerSet(j4, i13, i8);
            }
        }
        long j5 = i4;
        long jWholeElementsPerSet = wholeElementsPerSet(j5, jCharsPerSet, 1);
        long j6 = j5 - ((jCharsPerSet + 1) * jWholeElementsPerSet);
        long jWholeElementsPerSet2 = wholeElementsPerSet(j6, jCharsPerSet2, i7);
        long j7 = j6 - ((jCharsPerSet2 + i7) * jWholeElementsPerSet2);
        long jWholeElementsPerSet3 = wholeElementsPerSet(j7, j4, i8);
        if (j7 - ((j4 + i8) * jWholeElementsPerSet3) > 0) {
            i12 = i5;
            i11 = 1;
        } else {
            i11 = 0;
            i12 = i5;
        }
        return (int) ((jWholeElementsPerSet2 * i6) + (jWholeElementsPerSet * i12) + jWholeElementsPerSet3 + i11);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(@NotNull byte[] bArr, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringImpl(long j4, HexFormat hexFormat, int i4) {
        if ((i4 & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        String str = hexFormat.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        String prefix = hexFormat.getNumber().getPrefix();
        String suffix = hexFormat.getNumber().getSuffix();
        int length = suffix.length() + prefix.length() + (i4 >> 2);
        boolean removeLeadingZeros = hexFormat.getNumber().getRemoveLeadingZeros();
        StringBuilder sb = new StringBuilder(length);
        sb.append(prefix);
        while (i4 > 0) {
            i4 -= 4;
            int i5 = (int) ((j4 >> i4) & 15);
            removeLeadingZeros = removeLeadingZeros && i5 == 0 && i4 > 0;
            if (!removeLeadingZeros) {
                sb.append(str.charAt(i5));
            }
        }
        sb.append(suffix);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final long wholeElementsPerSet(long j4, long j5, int i4) {
        if (j4 <= 0 || j5 <= 0) {
            return 0L;
        }
        long j6 = i4;
        return (j4 + j6) / (j5 + j6);
    }

    @ExperimentalStdlibApi
    private static final byte hexToByte(String str, int i4, int i5, HexFormat hexFormat) {
        return (byte) hexToLongImpl(str, i4, i5, hexFormat, 2);
    }

    public static /* synthetic */ byte hexToByte$default(String str, int i4, int i5, HexFormat hexFormat, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i4, i5, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArray(String str, int i4, int i5, HexFormat hexFormat) {
        int iCheckContainsAt = i4;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(iCheckContainsAt, i5, str.length());
        if (iCheckContainsAt == i5) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        int bytesPerLine = bytes.getBytesPerLine();
        int bytesPerGroup = bytes.getBytesPerGroup();
        String bytePrefix = bytes.getBytePrefix();
        String byteSuffix = bytes.getByteSuffix();
        String byteSeparator = bytes.getByteSeparator();
        String groupSeparator = bytes.getGroupSeparator();
        String str2 = byteSeparator;
        int i6 = parsedByteArrayMaxSize(i5 - iCheckContainsAt, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[i6];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (iCheckContainsAt < i5) {
            if (i8 == bytesPerLine) {
                iCheckContainsAt = checkNewLineAt(str, iCheckContainsAt, i5);
                i8 = 0;
            } else if (i9 == bytesPerGroup) {
                iCheckContainsAt = checkContainsAt(str, groupSeparator, iCheckContainsAt, i5, "group separator");
            } else {
                if (i9 != 0) {
                    iCheckContainsAt = checkContainsAt(str, str2, iCheckContainsAt, i5, "byte separator");
                }
                i8++;
                i9++;
                int iCheckContainsAt2 = checkContainsAt(str, bytePrefix, iCheckContainsAt, i5, "byte prefix");
                checkHexLength(str, iCheckContainsAt2, RangesKt.coerceAtMost(iCheckContainsAt2 + 2, i5), 2, true);
                int iDecimalFromHexDigitAt = decimalFromHexDigitAt(str, iCheckContainsAt2) << 4;
                bArr[i7] = (byte) (iDecimalFromHexDigitAt | decimalFromHexDigitAt(str, iCheckContainsAt2 + 1));
                iCheckContainsAt = checkContainsAt(str, byteSuffix, iCheckContainsAt2 + 2, i5, "byte suffix");
                i7++;
                str2 = str2;
            }
            i9 = 0;
            i8++;
            i9++;
            int iCheckContainsAt22 = checkContainsAt(str, bytePrefix, iCheckContainsAt, i5, "byte prefix");
            checkHexLength(str, iCheckContainsAt22, RangesKt.coerceAtMost(iCheckContainsAt22 + 2, i5), 2, true);
            int iDecimalFromHexDigitAt2 = decimalFromHexDigitAt(str, iCheckContainsAt22) << 4;
            bArr[i7] = (byte) (iDecimalFromHexDigitAt2 | decimalFromHexDigitAt(str, iCheckContainsAt22 + 1));
            iCheckContainsAt = checkContainsAt(str, byteSuffix, iCheckContainsAt22 + 2, i5, "byte suffix");
            i7++;
            str2 = str2;
        }
        if (i7 == i6) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i7);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, int i4, int i5, HexFormat hexFormat, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i4, i5, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final int hexToInt(String str, int i4, int i5, HexFormat hexFormat) {
        return (int) hexToLongImpl(str, i4, i5, hexFormat, 8);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i4, int i5, HexFormat hexFormat, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i4, i5, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLong(String str, int i4, int i5, HexFormat hexFormat) {
        return hexToLongImpl(str, i4, i5, hexFormat, 16);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i4, int i5, HexFormat hexFormat, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i4, i5, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final short hexToShort(String str, int i4, int i5, HexFormat hexFormat) {
        return (short) hexToLongImpl(str, i4, i5, hexFormat, 4);
    }

    public static /* synthetic */ short hexToShort$default(String str, int i4, int i5, HexFormat hexFormat, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i4, i5, hexFormat);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[SYNTHETIC] */
    @kotlin.SinceKotlin(version = "1.9")
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String toHexString(@org.jetbrains.annotations.NotNull byte[] r17, int r18, int r19, @org.jetbrains.annotations.NotNull kotlin.text.HexFormat r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "format"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.collections.AbstractList$Companion r3 = kotlin.collections.AbstractList.INSTANCE
            int r5 = r0.length
            r3.checkBoundsIndexes$kotlin_stdlib(r1, r2, r5)
            if (r1 != r2) goto L1d
            java.lang.String r0 = ""
            return r0
        L1d:
            boolean r3 = r20.getUpperCase()
            if (r3 == 0) goto L26
            java.lang.String r3 = "0123456789ABCDEF"
            goto L28
        L26:
            java.lang.String r3 = "0123456789abcdef"
        L28:
            kotlin.text.HexFormat$BytesHexFormat r4 = r20.getBytes()
            int r12 = r4.getBytesPerLine()
            int r13 = r4.getBytesPerGroup()
            java.lang.String r14 = r4.getBytePrefix()
            java.lang.String r15 = r4.getByteSuffix()
            java.lang.String r11 = r4.getByteSeparator()
            java.lang.String r4 = r4.getGroupSeparator()
            int r5 = r2 - r1
            int r8 = r4.length()
            int r9 = r11.length()
            int r10 = r14.length()
            int r16 = r15.length()
            r6 = r12
            r7 = r13
            r1 = r11
            r11 = r16
            int r5 = formattedStringLength(r5, r6, r7, r8, r9, r10, r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r8 = r18
            r9 = 0
            r10 = 0
        L68:
            if (r8 >= r2) goto La2
            r11 = r0[r8]
            r7 = r11 & 255(0xff, float:3.57E-43)
            if (r9 != r12) goto L78
            r9 = 10
            r6.append(r9)
            r9 = 0
        L76:
            r10 = 0
            goto L7e
        L78:
            if (r10 != r13) goto L7e
            r6.append(r4)
            goto L76
        L7e:
            if (r10 == 0) goto L83
            r6.append(r1)
        L83:
            r6.append(r14)
            int r7 = r7 >> 4
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r7 = r11 & 15
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r6.append(r15)
            int r10 = r10 + 1
            int r9 = r9 + 1
            int r8 = r8 + 1
            goto L68
        La2:
            int r0 = r6.length()
            if (r5 != r0) goto Lb2
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        Lb2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.HexExtensionsKt.toHexString(byte[], int, int, kotlin.text.HexFormat):java.lang.String");
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i4, int i5, HexFormat hexFormat, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = bArr.length;
        }
        if ((i6 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i4, i5, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte b4, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b4, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s4, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s4, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(int i4, HexFormat hexFormat, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i4, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j4, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j4, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(byte b4, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(b4, format, 8);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(short s4, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(s4, format, 16);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(int i4, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(i4, format, 32);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(long j4, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(j4, format, 64);
    }
}
