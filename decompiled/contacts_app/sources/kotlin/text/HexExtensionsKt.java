package kotlin.text;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HexExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0004\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a@\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a@\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002\u001a,\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H\u0002\u001a,\u0010\u001b\u001a\u00020\u001c*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a\u001c\u0010!\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002\u001a\u0014\u0010\"\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH\u0002\u001a*\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a0\u0010+\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\tH\u0003\u001a*\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\u00062\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020-2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u001c\u0010/\u001a\u00020\u0003*\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u00100\u001a\u00020\tH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"HEX_DIGITS_TO_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "formattedStringLength", "totalBytes", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "part", "index", "endIndex", "partName", "checkHexLength", "", "startIndex", "maxDigits", "requireMaxLength", "", "checkNewLineAt", "decimalFromHexDigitAt", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "", "hexToInt", "hexToLong", "hexToLongImpl", "hexToShort", "", "toHexString", "toHexStringImpl", "bits", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class HexExtensionsKt {
    private static final int[] HEX_DIGITS_TO_DECIMAL = null;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] r1 = new int[128];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= 128) goto L5;
        r1[r3] = -1;
        r3 = r3 + 1;
        goto L3
    L5:
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r0.length()) goto L9;
        r1[r0.charAt(r4)] = r5;
        r4 = r4 + 1;
        r5 = r5 + 1;
        goto L7
    L9:
        int r6 = 0;
    L11:
        if (r2 >= r0.length()) goto L13;
        r1[r0.charAt(r2)] = r6;
        r2 = r2 + 1;
        r6 = r6 + 1;
        goto L11
    L13:
        HEX_DIGITS_TO_DECIMAL = r1;
    }

    public static final String toHexString(byte[] r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return toHexString(r2, 0, r2.length, r3);
    }

    public static /* synthetic */ String toHexString$default(byte[] r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    public static /* synthetic */ String toHexString$default(byte[] r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return toHexString(r0, r1, r2, r3);
    }

    public static final String toHexString(byte[] r17, int r18, int r19, HexFormat r20) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r20, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r18, r19, r17.length);
        if (r18 != r19) goto L7;
        return "";
    L7:
        if (r20.getUpperCase() == false) goto L9;
        String r3 = UPPER_CASE_HEX_DIGITS;
    L10:
        HexFormat.BytesHexFormat r4 = r20.getBytes();
        int r12 = r4.getBytesPerLine();
        int r13 = r4.getBytesPerGroup();
        String r14 = r4.getBytePrefix();
        String r15 = r4.getByteSuffix();
        String r11 = r4.getByteSeparator();
        String r5 = r4.getGroupSeparator();
        int r6 = formattedStringLength(r19 - r18, r12, r13, r5.length(), r11.length(), r14.length(), r15.length());
        StringBuilder r7 = new StringBuilder(r6);
        int r8 = r18;
        int r9 = 0;
        int r10 = 0;
    L11:
        if (r8 >= r19) goto L21;
        int r16 = r17[r8] & 255;
        if (r9 != r12) goto L16;
        r7.append('\n');
        r9 = 0;
    L15:
        r10 = 0;
    L18:
        if (r10 == 0) goto L20;
        r7.append(r11);
    L20:
        r7.append(r14);
        r7.append(r3.charAt(r16 >> 4));
        r7.append(r3.charAt(r16 & 15));
        r7.append(r15);
        r10 = r10 + 1;
        r9 = r9 + 1;
        r8 = r8 + 1;
        goto L11
    L16:
        if (r10 != r13) goto L18;
        r7.append(r5);
        goto L15
    L21:
        boolean r21 = true;
        if (r6 == r7.length()) goto L25;
        r21 = false;
    L25:
        if (r21 == false) goto L29;
        String r0 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        return r0;
    L29:
        throw new IllegalStateException("Check failed.".toString());
    L9:
        r3 = LOWER_CASE_HEX_DIGITS;
        goto L10
    }

    public static final int formattedStringLength(int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        if (r7 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L18;
        int r3 = r7 - 1;
        int r4 = r3 / r8;
        int r5 = (r8 - 1) / r9;
        int r6 = r7 % r8;
        if (r6 == 0) goto L11;
        r8 = r6;
    L11:
        int r14 = (r5 * r4) + ((r8 - 1) / r9);
        long r15 = ((((long) r4) + (((long) r14) * ((long) r10))) + (((long) ((r3 - r4) - r14)) * ((long) r11))) + (((long) r7) * ((((long) r12) + 2) + ((long) r13)));
        if (RangesKt.intRangeContains(new IntRange(0, Integer.MAX_VALUE), r15) == false) goto L16;
        return (int) r15;
    L16:
        throw new IllegalArgumentException("The resulting string length is too big: " + ULong.m1023toStringimpl(ULong.m977constructorimpl(r15)));
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final byte[] hexToByteArray(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToByteArray(r2, 0, r2.length(), r3);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToByteArray(r0, r1);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToByteArray(r0, r1, r2, r3);
    }

    private static final byte[] hexToByteArray(String r17, int r18, int r19, HexFormat r20) {
        int r1 = r18;
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r1, r19, r17.length());
        if (r1 == r19) goto L5;
        HexFormat.BytesHexFormat r4 = r20.getBytes();
        int r12 = r4.getBytesPerLine();
        int r13 = r4.getBytesPerGroup();
        String r14 = r4.getBytePrefix();
        String r15 = r4.getByteSuffix();
        String r11 = r4.getByteSeparator();
        String r5 = r4.getGroupSeparator();
        String r3 = r11;
        int r6 = parsedByteArrayMaxSize(r19 - r1, r12, r13, r5.length(), r11.length(), r14.length(), r15.length());
        byte[] r7 = new byte[r6];
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L7:
        if (r1 >= r19) goto L16;
        if (r9 != r12) goto L11;
        r1 = checkNewLineAt(r17, r1, r19);
        r9 = 0;
    L10:
        r10 = 0;
    L15:
        r9 = r9 + 1;
        r10 = r10 + 1;
        int r2 = checkContainsAt(r17, r14, r1, r19, "byte prefix");
        String r16 = r3;
        checkHexLength(r17, r2, RangesKt.coerceAtMost(r2 + 2, r19), 2, true);
        int r110 = r2 + 1;
        int r111 = r110 + 1;
        r7[r8] = (byte) ((decimalFromHexDigitAt(r17, r2) << 4) | decimalFromHexDigitAt(r17, r110));
        r1 = checkContainsAt(r17, r15, r111, r19, "byte suffix");
        r8 = r8 + 1;
        r3 = r16;
        goto L7
    L11:
        if (r10 != r13) goto L13;
        r1 = checkContainsAt(r17, r5, r1, r19, "group separator");
        goto L10
    L13:
        if (r10 == 0) goto L15;
        r1 = checkContainsAt(r17, r3, r1, r19, "byte separator");
        goto L15
    L16:
        if (r8 == r6) goto L24;
        byte[] r21 = Arrays.copyOf(r7, r8);
        Intrinsics.checkNotNullExpressionValue(r21, "copyOf(...)");
        return r21;
    L24:
        return r7;
    L5:
        return new byte[0];
    }

    public static final int parsedByteArrayMaxSize(int r19, int r20, int r21, int r22, int r23, int r24, int r25) {
        if (r19 <= 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L20;
        long r8 = (((long) r24) + 2) + ((long) r25);
        long r9 = charsPerSet(r8, r21, r23);
        if (r20 > r21) goto L10;
        long r11 = charsPerSet(r8, r20, r23);
    L13:
        long r13 = r19;
        long r15 = wholeElementsPerSet(r13, r11, 1);
        long r14 = r13 - ((r11 + 1) * r15);
        long r12 = wholeElementsPerSet(r14, r9, r22);
        long r16 = r14 - ((r9 + ((long) r22)) * r12);
        long r5 = wholeElementsPerSet(r16, r8, r23);
        if ((r16 - ((r8 + ((long) r23)) * r5)) <= 0) goto L16;
        int r0 = 1;
    L18:
        return (int) (r0 + (((r15 * ((long) r20)) + (r12 * ((long) r21))) + r5));
    L16:
        r0 = 0;
        goto L18
    L10:
        r11 = charsPerSet(r9, r20 / r21, r22);
        int r17 = r20 % r21;
        if (r17 == 0) goto L13;
        r11 = (r11 + ((long) r22)) + charsPerSet(r8, r17, r23);
        goto L13
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r7 = false;
        goto L6
    }

    private static final long charsPerSet(long r4, int r6, int r7) {
        if (r6 <= 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        long r1 = r6;
        return (r4 * r1) + (((long) r7) * (r1 - 1));
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r0 = false;
        goto L5
    }

    private static final long wholeElementsPerSet(long r3, long r5, int r7) {
        if (r3 > 0) goto L5;
        return 0;
    L5:
        if (r5 <= 0) goto L10;
        long r0 = r7;
        return (r3 + r0) / (r5 + r0);
    L10:
        return 0;
    }

    private static final int checkNewLineAt(String r3, int r4, int r5) {
        if (r3.charAt(r4) != '\r') goto L10;
        int r0 = r4 + 1;
        if (r0 < r5) goto L7;
        return r0;
    L7:
        if (r3.charAt(r0) == '\n') goto L17;
        return r0;
    L17:
        return r4 + 2;
    L10:
        if (r3.charAt(r4) != '\n') goto L14;
        return r4 + 1;
    L14:
        throw new NumberFormatException("Expected a new line at index " + r4 + ", but was " + r3.charAt(r4));
    }

    public static final String toHexString(byte r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r3, "format");
        return toHexStringImpl(r2, r3, 8);
    }

    public static /* synthetic */ String toHexString$default(byte r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    public static final byte hexToByte(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToByte(r2, 0, r2.length(), r3);
    }

    public static /* synthetic */ byte hexToByte$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToByte(r0, r1);
    }

    static /* synthetic */ byte hexToByte$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToByte(r0, r1, r2, r3);
    }

    private static final byte hexToByte(String r1, int r2, int r3, HexFormat r4) {
        return (byte) hexToLongImpl(r1, r2, r3, r4, 2);
    }

    public static final String toHexString(short r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r3, "format");
        return toHexStringImpl(r2, r3, 16);
    }

    public static /* synthetic */ String toHexString$default(short r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    public static final short hexToShort(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToShort(r2, 0, r2.length(), r3);
    }

    public static /* synthetic */ short hexToShort$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToShort(r0, r1);
    }

    static /* synthetic */ short hexToShort$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToShort(r0, r1, r2, r3);
    }

    private static final short hexToShort(String r1, int r2, int r3, HexFormat r4) {
        return (short) hexToLongImpl(r1, r2, r3, r4, 4);
    }

    public static final String toHexString(int r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r3, "format");
        return toHexStringImpl(r2, r3, 32);
    }

    public static /* synthetic */ String toHexString$default(int r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    public static final int hexToInt(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToInt(r2, 0, r2.length(), r3);
    }

    public static /* synthetic */ int hexToInt$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToInt(r0, r1);
    }

    static /* synthetic */ int hexToInt$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToInt(r0, r1, r2, r3);
    }

    private static final int hexToInt(String r1, int r2, int r3, HexFormat r4) {
        return (int) hexToLongImpl(r1, r2, r3, r4, 8);
    }

    public static final String toHexString(long r1, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r3, "format");
        return toHexStringImpl(r1, r3, 64);
    }

    public static /* synthetic */ String toHexString$default(long r0, HexFormat r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r2);
    }

    public static final long hexToLong(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToLong(r2, 0, r2.length(), r3);
    }

    public static /* synthetic */ long hexToLong$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToLong(r0, r1);
    }

    static /* synthetic */ long hexToLong$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToLong(r0, r1, r2, r3);
    }

    private static final long hexToLong(String r1, int r2, int r3, HexFormat r4) {
        return hexToLongImpl(r1, r2, r3, r4, 16);
    }

    private static final String toHexStringImpl(long r11, HexFormat r13, int r14) {
        if ((r14 & 3) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L24;
        if (r13.getUpperCase() == false) goto L10;
        String r1 = UPPER_CASE_HEX_DIGITS;
    L11:
        String r3 = r13.getNumber().getPrefix();
        String r4 = r13.getNumber().getSuffix();
        int r5 = (r3.length() + (r14 >> 2)) + r4.length();
        boolean r15 = r13.getNumber().getRemoveLeadingZeros();
        StringBuilder r6 = new StringBuilder(r5);
        r6.append(r3);
    L12:
        if (r14 <= 0) goto L21;
        r14 = r14 - 4;
        int r7 = (int) ((r11 >> r14) & 15);
        if (r15 == false) goto L18;
        if (r7 != 0) goto L18;
        if (r14 <= 0) goto L18;
        r15 = true;
    L19:
        if (r15 == true) goto L12;
        r6.append(r1.charAt(r7));
    L18:
        r15 = false;
        goto L19
    L21:
        r6.append(r4);
        String r12 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        return r12;
    L10:
        r1 = LOWER_CASE_HEX_DIGITS;
        goto L11
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ long hexToLongImpl$default(String r0, int r1, int r2, HexFormat r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return hexToLongImpl(r0, r1, r2, r3, r4);
    }

    private static final long hexToLongImpl(String r3, int r4, int r5, HexFormat r6, int r7) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r4, r5, r3.length());
        String r0 = r6.getNumber().getPrefix();
        String r8 = r6.getNumber().getSuffix();
        if ((r0.length() + r8.length()) >= (r5 - r4)) goto L8;
        int r9 = checkContainsAt(r3, r0, r4, r5, "prefix");
        int r1 = r5 - r8.length();
        checkContainsAt(r3, r8, r1, r5, "suffix");
        checkHexLength(r3, r9, r1, r7, false);
        long r10 = 0;
    L5:
        if (r9 >= r1) goto L7;
        r10 = (r10 << 4) | ((long) decimalFromHexDigitAt(r3, r9));
        r9 = r9 + 1;
        goto L5
    L7:
        return r10;
    L8:
        StringBuilder r11 = new StringBuilder("Expected a hexadecimal number with prefix \"").append(r0).append("\" and suffix \"").append(r8).append("\", but was ");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.String");
        String r12 = r3.substring(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r12, "substring(...)");
        throw new NumberFormatException(r11.append(r12).toString());
    }

    private static final int checkContainsAt(String r7, String r8, int r9, int r10, String r11) {
        int r0 = r8.length() + r9;
        if (r0 <= r10) goto L5;
    L7:
        StringBuilder r12 = new StringBuilder("Expected ").append(r11).append(" \"").append(r8).append("\" at index ").append(r9).append(", but was ");
        int r13 = RangesKt.coerceAtMost(r0, r10);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.String");
        String r14 = r7.substring(r9, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "substring(...)");
        throw new NumberFormatException(r12.append(r14).toString());
    L5:
        if (StringsKt.regionMatches(r7, r9, r8, 0, r8.length(), true) == false) goto L7;
        return r0;
    }

    private static final void checkHexLength(String r3, int r4, int r5, int r6, boolean r7) {
        int r0 = r5 - r4;
        boolean r1 = true;
        if (r7 == false) goto L6;
        if (r0 == r6) goto L9;
    L8:
        r1 = false;
    L9:
        if (r1 == true) goto L15;
        if (r7 == false) goto L12;
        String r8 = "exactly";
    L13:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.String");
        String r9 = r3.substring(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r9, "substring(...)");
        throw new NumberFormatException("Expected " + r8 + ' ' + r6 + " hexadecimal digits at index " + r4 + ", but was " + r9 + " of length " + r0);
    L12:
        r8 = "at most";
        goto L13
    L15:
        return;
    L6:
        if (r0 > r6) goto L8;
        goto L8
    }

    private static final int decimalFromHexDigitAt(String r3, int r4) {
        char r0 = r3.charAt(r4);
        if (r0 > 127) goto L8;
        int r1 = HEX_DIGITS_TO_DECIMAL[r0];
        if (r1 < 0) goto L8;
        return r1;
    L8:
        throw new NumberFormatException("Expected a hexadecimal digit at index " + r4 + ", but was " + r3.charAt(r4));
    }
}
