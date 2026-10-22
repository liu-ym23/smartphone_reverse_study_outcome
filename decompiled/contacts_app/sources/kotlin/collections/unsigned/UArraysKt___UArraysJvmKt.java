package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: _UArraysJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b#\u0010$\u001a\u001c\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\b,\u0010-\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\b.\u0010/\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\b0\u00101\u001a=\u00102\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a=\u00102\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a=\u00102\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a=\u00102\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a1\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\bC\u0010D\u001a1\u0010?\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\bE\u0010F\u001a1\u0010?\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\bG\u0010H\u001a1\u0010?\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\bI\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007¢\u0006\u0004\bL\u0010+\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007¢\u0006\u0004\bM\u0010-\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007¢\u0006\u0004\bN\u0010/\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007¢\u0006\u0004\bO\u00101\u001a=\u0010P\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a=\u0010P\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a=\u0010P\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a=\u0010P\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a1\u0010U\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007¢\u0006\u0004\bV\u0010D\u001a1\u0010U\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007¢\u0006\u0004\bW\u0010F\u001a1\u0010U\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007¢\u0006\u0004\bX\u0010H\u001a1\u0010U\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007¢\u0006\u0004\bY\u0010J\u001a+\u0010Z\u001a\u00020[*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a+\u0010Z\u001a\u00020^*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a+\u0010Z\u001a\u00020[*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010a\u001a+\u0010Z\u001a\u00020^*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010b\u001a+\u0010Z\u001a\u00020[*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010c\u001a+\u0010Z\u001a\u00020^*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010d\u001a+\u0010Z\u001a\u00020[*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010e\u001a+\u0010Z\u001a\u00020^*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020^06H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006g"}, d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "max", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    public UArraysKt___UArraysJvmKt() {
    }

    /* JADX INFO: renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m1285elementAtqFRl0hI(int[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return UIntArray.m958getpVg5ArA(r1, r2);
    }

    /* JADX INFO: renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m1286elementAtr7IrZao(long[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return ULongArray.m1037getsVKNKU(r1, r2);
    }

    /* JADX INFO: renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m1283elementAtPpDY95g(byte[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return UByteArray.m879getw2LRezQ(r1, r2);
    }

    /* JADX INFO: renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m1284elementAtnggk6HY(short[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$elementAt");
        return UShortArray.m1142getMh2AYeg(r1, r2);
    }

    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<UInt> m1271asListajY9A(int[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(r1);
    }

    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m1273asListQwZRm1k(long[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(r1);
    }

    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m1272asListGBYM_sE(byte[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(r1);
    }

    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m1274asListrL5Bavg(short[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(r1);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m1276binarySearch2fe2U9s$default(int[] r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = UIntArray.m959getSizeimpl(r0);
    L9:
        return UArraysKt.m1275binarySearch2fe2U9s(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m1275binarySearch2fe2U9s(int[] r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r4, r5, UIntArray.m959getSizeimpl(r2));
        int r6 = r5 - 1;
    L3:
        if (r4 > r6) goto L11;
        int r0 = (r4 + r6) >>> 1;
        int r1 = UnsignedKt.uintCompare(r2[r0], r3);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r6 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return -(r4 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m1280binarySearchK6DWlUc$default(long[] r0, long r1, int r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = ULongArray.m1038getSizeimpl(r0);
    L9:
        return UArraysKt.m1279binarySearchK6DWlUc(r0, r1, r3, r4);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m1279binarySearchK6DWlUc(long[] r3, long r4, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r6, r7, ULongArray.m1038getSizeimpl(r3));
        int r8 = r7 - 1;
    L3:
        if (r6 > r8) goto L11;
        int r0 = (r6 + r8) >>> 1;
        int r1 = UnsignedKt.ulongCompare(r3[r0], r4);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r8 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r6 = r0 + 1;
        goto L3
    L11:
        return -(r6 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m1282binarySearchWpHrYlw$default(byte[] r0, byte r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = UByteArray.m880getSizeimpl(r0);
    L9:
        return UArraysKt.m1281binarySearchWpHrYlw(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m1281binarySearchWpHrYlw(byte[] r2, byte r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r4, r5, UByteArray.m880getSizeimpl(r2));
        int r6 = r3 & 255;
        int r7 = r5 - 1;
    L3:
        if (r4 > r7) goto L11;
        int r0 = (r4 + r7) >>> 1;
        int r1 = UnsignedKt.uintCompare(r2[r0], r6);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r7 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return -(r4 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m1278binarySearchEtDCXyQ$default(short[] r0, short r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = UShortArray.m1143getSizeimpl(r0);
    L9:
        return UArraysKt.m1277binarySearchEtDCXyQ(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m1277binarySearchEtDCXyQ(short[] r2, short r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r4, r5, UShortArray.m1143getSizeimpl(r2));
        int r6 = r3 & UShort.MAX_VALUE;
        int r7 = r5 - 1;
    L3:
        if (r4 > r7) goto L11;
        int r0 = (r4 + r7) >>> 1;
        int r1 = UnsignedKt.uintCompare(r2[r0], r6);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r7 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return -(r4 + 1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m1287maxajY9A(int[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m1655maxOrNullajY9A(r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m1289maxQwZRm1k(long[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m1657maxOrNullQwZRm1k(r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m1288maxGBYM_sE(byte[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m1656maxOrNullGBYM_sE(r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m1290maxrL5Bavg(short[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$max");
        return UArraysKt.m1658maxOrNullrL5Bavg(r1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m1293maxByjgv0xPQ(int[] r6, Function1<? super UInt, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r7, "selector");
        if (UIntArray.m961isEmptyimpl(r6) == false) goto L5;
        return null;
    L5:
        int r0 = UIntArray.m958getpVg5ArA(r6, 0);
        int r1 = ArraysKt.getLastIndex(r6);
        if (r1 == 0) goto L20;
        R r2 = r7.invoke(UInt.m892boximpl(r0));
        ?? r3 = new IntRange(1, r1).iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        int r4 = UIntArray.m958getpVg5ArA(r6, r3.nextInt());
        R r5 = r7.invoke(UInt.m892boximpl(r4));
        if (r2.compareTo(r5) >= 0) goto L10;
        r0 = r4;
        r2 = r5;
    L20:
        return UInt.m892boximpl(r0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m1292maxByMShoTSo(long[] r8, Function1<? super ULong, ? extends R> r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r9, "selector");
        if (ULongArray.m1040isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        long r0 = ULongArray.m1037getsVKNKU(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L20;
        R r3 = r9.invoke(ULong.m971boximpl(r0));
        ?? r4 = new IntRange(1, r2).iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        long r5 = ULongArray.m1037getsVKNKU(r8, r4.nextInt());
        R r6 = r9.invoke(ULong.m971boximpl(r5));
        if (r3.compareTo(r6) >= 0) goto L10;
        r0 = r5;
        r3 = r6;
    L20:
        return ULong.m971boximpl(r0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m1291maxByJOV_ifY(byte[] r6, Function1<? super UByte, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r7, "selector");
        if (UByteArray.m882isEmptyimpl(r6) == false) goto L5;
        return null;
    L5:
        byte r0 = UByteArray.m879getw2LRezQ(r6, 0);
        int r1 = ArraysKt.getLastIndex(r6);
        if (r1 == 0) goto L20;
        R r2 = r7.invoke(UByte.m815boximpl(r0));
        ?? r3 = new IntRange(1, r1).iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        byte r4 = UByteArray.m879getw2LRezQ(r6, r3.nextInt());
        R r5 = r7.invoke(UByte.m815boximpl(r4));
        if (r2.compareTo(r5) >= 0) goto L10;
        r0 = r4;
        r2 = r5;
    L20:
        return UByte.m815boximpl(r0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m1294maxByxTcfx_M(short[] r6, Function1<? super UShort, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r7, "selector");
        if (UShortArray.m1145isEmptyimpl(r6) == false) goto L5;
        return null;
    L5:
        short r0 = UShortArray.m1142getMh2AYeg(r6, 0);
        int r1 = ArraysKt.getLastIndex(r6);
        if (r1 == 0) goto L20;
        R r2 = r7.invoke(UShort.m1078boximpl(r0));
        ?? r3 = new IntRange(1, r1).iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        short r4 = UShortArray.m1142getMh2AYeg(r6, r3.nextInt());
        R r5 = r7.invoke(UShort.m1078boximpl(r4));
        if (r2.compareTo(r5) >= 0) goto L10;
        r0 = r4;
        r2 = r5;
    L20:
        return UShort.m1078boximpl(r0);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m1296maxWithYmdZ_VM(int[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1664maxWithOrNullYmdZ_VM(r1, r2);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m1298maxWithzrEWJaI(long[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1666maxWithOrNullzrEWJaI(r1, r2);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m1295maxWithXMRcp5o(byte[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1663maxWithOrNullXMRcp5o(r1, r2);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m1297maxWitheOHTfZs(short[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1665maxWithOrNulleOHTfZs(r1, r2);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m1299minajY9A(int[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m1711minOrNullajY9A(r1);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m1301minQwZRm1k(long[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m1713minOrNullQwZRm1k(r1);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m1300minGBYM_sE(byte[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m1712minOrNullGBYM_sE(r1);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m1302minrL5Bavg(short[] r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$min");
        return UArraysKt.m1714minOrNullrL5Bavg(r1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m1305minByjgv0xPQ(int[] r6, Function1<? super UInt, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$minBy");
        Intrinsics.checkNotNullParameter(r7, "selector");
        if (UIntArray.m961isEmptyimpl(r6) == false) goto L5;
        return null;
    L5:
        int r0 = UIntArray.m958getpVg5ArA(r6, 0);
        int r1 = ArraysKt.getLastIndex(r6);
        if (r1 == 0) goto L20;
        R r2 = r7.invoke(UInt.m892boximpl(r0));
        ?? r3 = new IntRange(1, r1).iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        int r4 = UIntArray.m958getpVg5ArA(r6, r3.nextInt());
        R r5 = r7.invoke(UInt.m892boximpl(r4));
        if (r2.compareTo(r5) <= 0) goto L10;
        r0 = r4;
        r2 = r5;
    L20:
        return UInt.m892boximpl(r0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m1304minByMShoTSo(long[] r8, Function1<? super ULong, ? extends R> r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$minBy");
        Intrinsics.checkNotNullParameter(r9, "selector");
        if (ULongArray.m1040isEmptyimpl(r8) == false) goto L5;
        return null;
    L5:
        long r0 = ULongArray.m1037getsVKNKU(r8, 0);
        int r2 = ArraysKt.getLastIndex(r8);
        if (r2 == 0) goto L20;
        R r3 = r9.invoke(ULong.m971boximpl(r0));
        ?? r4 = new IntRange(1, r2).iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        long r5 = ULongArray.m1037getsVKNKU(r8, r4.nextInt());
        R r6 = r9.invoke(ULong.m971boximpl(r5));
        if (r3.compareTo(r6) <= 0) goto L10;
        r0 = r5;
        r3 = r6;
    L20:
        return ULong.m971boximpl(r0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m1303minByJOV_ifY(byte[] r6, Function1<? super UByte, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$minBy");
        Intrinsics.checkNotNullParameter(r7, "selector");
        if (UByteArray.m882isEmptyimpl(r6) == false) goto L5;
        return null;
    L5:
        byte r0 = UByteArray.m879getw2LRezQ(r6, 0);
        int r1 = ArraysKt.getLastIndex(r6);
        if (r1 == 0) goto L20;
        R r2 = r7.invoke(UByte.m815boximpl(r0));
        ?? r3 = new IntRange(1, r1).iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        byte r4 = UByteArray.m879getw2LRezQ(r6, r3.nextInt());
        R r5 = r7.invoke(UByte.m815boximpl(r4));
        if (r2.compareTo(r5) <= 0) goto L10;
        r0 = r4;
        r2 = r5;
    L20:
        return UByte.m815boximpl(r0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m1306minByxTcfx_M(short[] r6, Function1<? super UShort, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$minBy");
        Intrinsics.checkNotNullParameter(r7, "selector");
        if (UShortArray.m1145isEmptyimpl(r6) == false) goto L5;
        return null;
    L5:
        short r0 = UShortArray.m1142getMh2AYeg(r6, 0);
        int r1 = ArraysKt.getLastIndex(r6);
        if (r1 == 0) goto L20;
        R r2 = r7.invoke(UShort.m1078boximpl(r0));
        ?? r3 = new IntRange(1, r1).iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        short r4 = UShortArray.m1142getMh2AYeg(r6, r3.nextInt());
        R r5 = r7.invoke(UShort.m1078boximpl(r4));
        if (r2.compareTo(r5) <= 0) goto L10;
        r0 = r4;
        r2 = r5;
    L20:
        return UShort.m1078boximpl(r0);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m1308minWithYmdZ_VM(int[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$minWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1720minWithOrNullYmdZ_VM(r1, r2);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m1310minWithzrEWJaI(long[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$minWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1722minWithOrNullzrEWJaI(r1, r2);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m1307minWithXMRcp5o(byte[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$minWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1719minWithOrNullXMRcp5o(r1, r2);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m1309minWitheOHTfZs(short[] r1, Comparator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$minWith");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return UArraysKt.m1721minWithOrNulleOHTfZs(r1, r2);
    }

    private static final BigDecimal sumOfBigDecimal(int[] r4, Function1<? super UInt, ? extends BigDecimal> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r5, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = UIntArray.m959getSizeimpl(r4);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r5.invoke(UInt.m892boximpl(UIntArray.m958getpVg5ArA(r4, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigDecimal sumOfBigDecimal(long[] r5, Function1<? super ULong, ? extends BigDecimal> r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r6, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = ULongArray.m1038getSizeimpl(r5);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r6.invoke(ULong.m971boximpl(ULongArray.m1037getsVKNKU(r5, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] r4, Function1<? super UByte, ? extends BigDecimal> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r5, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = UByteArray.m880getSizeimpl(r4);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r5.invoke(UByte.m815boximpl(UByteArray.m879getw2LRezQ(r4, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigDecimal sumOfBigDecimal(short[] r4, Function1<? super UShort, ? extends BigDecimal> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r5, "selector");
        BigDecimal r0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = UShortArray.m1143getSizeimpl(r4);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r5.invoke(UShort.m1078boximpl(UShortArray.m1142getMh2AYeg(r4, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(int[] r4, Function1<? super UInt, ? extends BigInteger> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r5, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = UIntArray.m959getSizeimpl(r4);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r5.invoke(UInt.m892boximpl(UIntArray.m958getpVg5ArA(r4, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(long[] r5, Function1<? super ULong, ? extends BigInteger> r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r6, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = ULongArray.m1038getSizeimpl(r5);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r6.invoke(ULong.m971boximpl(ULongArray.m1037getsVKNKU(r5, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(byte[] r4, Function1<? super UByte, ? extends BigInteger> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r5, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = UByteArray.m880getSizeimpl(r4);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r5.invoke(UByte.m815boximpl(UByteArray.m879getw2LRezQ(r4, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final BigInteger sumOfBigInteger(short[] r4, Function1<? super UShort, ? extends BigInteger> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r5, "selector");
        BigInteger r0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        int r1 = UShortArray.m1143getSizeimpl(r4);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0.add(r5.invoke(UShort.m1078boximpl(UShortArray.m1142getMh2AYeg(r4, r2))));
        Intrinsics.checkNotNullExpressionValue(r0, "add(...)");
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
