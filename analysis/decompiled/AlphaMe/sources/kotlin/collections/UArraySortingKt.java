package kotlin.collections;

import com.stepos.activeview.moveline.item.ViewTweenItem;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", ViewTweenItem.LEFT, "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m477partitionnroSd4(long[] jArr, int i4, int i5) {
        long jM256getsVKNKU = ULongArray.m256getsVKNKU(jArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (Long.compareUnsigned(ULongArray.m256getsVKNKU(jArr, i4), jM256getsVKNKU) < 0) {
                i4++;
            }
            while (Long.compareUnsigned(ULongArray.m256getsVKNKU(jArr, i5), jM256getsVKNKU) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                long jM256getsVKNKU2 = ULongArray.m256getsVKNKU(jArr, i4);
                ULongArray.m261setk8EXiF4(jArr, i4, ULongArray.m256getsVKNKU(jArr, i5));
                ULongArray.m261setk8EXiF4(jArr, i5, jM256getsVKNKU2);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m478partition4UcCI2c(byte[] bArr, int i4, int i5) {
        int i6;
        byte bM98getw2LRezQ = UByteArray.m98getw2LRezQ(bArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (true) {
                int iM98getw2LRezQ = UByteArray.m98getw2LRezQ(bArr, i4) & UByte.MAX_VALUE;
                i6 = bM98getw2LRezQ & UByte.MAX_VALUE;
                if (Intrinsics.compare(iM98getw2LRezQ, i6) >= 0) {
                    break;
                }
                i4++;
            }
            while (Intrinsics.compare(UByteArray.m98getw2LRezQ(bArr, i5) & UByte.MAX_VALUE, i6) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                byte bM98getw2LRezQ2 = UByteArray.m98getw2LRezQ(bArr, i4);
                UByteArray.m103setVurrAj0(bArr, i4, UByteArray.m98getw2LRezQ(bArr, i5));
                UByteArray.m103setVurrAj0(bArr, i5, bM98getw2LRezQ2);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m479partitionAa5vz7o(short[] sArr, int i4, int i5) {
        int i6;
        short sM361getMh2AYeg = UShortArray.m361getMh2AYeg(sArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (true) {
                int iM361getMh2AYeg = UShortArray.m361getMh2AYeg(sArr, i4) & UShort.MAX_VALUE;
                i6 = sM361getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM361getMh2AYeg, i6) >= 0) {
                    break;
                }
                i4++;
            }
            while (Intrinsics.compare(UShortArray.m361getMh2AYeg(sArr, i5) & UShort.MAX_VALUE, i6) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                short sM361getMh2AYeg2 = UShortArray.m361getMh2AYeg(sArr, i4);
                UShortArray.m366set01HTLdE(sArr, i4, UShortArray.m361getMh2AYeg(sArr, i5));
                UShortArray.m366set01HTLdE(sArr, i5, sM361getMh2AYeg2);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m480partitionoBK06Vg(int[] iArr, int i4, int i5) {
        int iM177getpVg5ArA = UIntArray.m177getpVg5ArA(iArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (Integer.compareUnsigned(UIntArray.m177getpVg5ArA(iArr, i4), iM177getpVg5ArA) < 0) {
                i4++;
            }
            while (Integer.compareUnsigned(UIntArray.m177getpVg5ArA(iArr, i5), iM177getpVg5ArA) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                int iM177getpVg5ArA2 = UIntArray.m177getpVg5ArA(iArr, i4);
                UIntArray.m182setVXSXFK8(iArr, i4, UIntArray.m177getpVg5ArA(iArr, i5));
                UIntArray.m182setVXSXFK8(iArr, i5, iM177getpVg5ArA2);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m481quickSortnroSd4(long[] jArr, int i4, int i5) {
        int iM477partitionnroSd4 = m477partitionnroSd4(jArr, i4, i5);
        int i6 = iM477partitionnroSd4 - 1;
        if (i4 < i6) {
            m481quickSortnroSd4(jArr, i4, i6);
        }
        if (iM477partitionnroSd4 < i5) {
            m481quickSortnroSd4(jArr, iM477partitionnroSd4, i5);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m482quickSort4UcCI2c(byte[] bArr, int i4, int i5) {
        int iM478partition4UcCI2c = m478partition4UcCI2c(bArr, i4, i5);
        int i6 = iM478partition4UcCI2c - 1;
        if (i4 < i6) {
            m482quickSort4UcCI2c(bArr, i4, i6);
        }
        if (iM478partition4UcCI2c < i5) {
            m482quickSort4UcCI2c(bArr, iM478partition4UcCI2c, i5);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m483quickSortAa5vz7o(short[] sArr, int i4, int i5) {
        int iM479partitionAa5vz7o = m479partitionAa5vz7o(sArr, i4, i5);
        int i6 = iM479partitionAa5vz7o - 1;
        if (i4 < i6) {
            m483quickSortAa5vz7o(sArr, i4, i6);
        }
        if (iM479partitionAa5vz7o < i5) {
            m483quickSortAa5vz7o(sArr, iM479partitionAa5vz7o, i5);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m484quickSortoBK06Vg(int[] iArr, int i4, int i5) {
        int iM480partitionoBK06Vg = m480partitionoBK06Vg(iArr, i4, i5);
        int i6 = iM480partitionoBK06Vg - 1;
        if (i4 < i6) {
            m484quickSortoBK06Vg(iArr, i4, i6);
        }
        if (iM480partitionoBK06Vg < i5) {
            m484quickSortoBK06Vg(iArr, iM480partitionoBK06Vg, i5);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m485sortArraynroSd4(@NotNull long[] array, int i4, int i5) {
        Intrinsics.checkNotNullParameter(array, "array");
        m481quickSortnroSd4(array, i4, i5 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m486sortArray4UcCI2c(@NotNull byte[] array, int i4, int i5) {
        Intrinsics.checkNotNullParameter(array, "array");
        m482quickSort4UcCI2c(array, i4, i5 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m487sortArrayAa5vz7o(@NotNull short[] array, int i4, int i5) {
        Intrinsics.checkNotNullParameter(array, "array");
        m483quickSortAa5vz7o(array, i4, i5 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m488sortArrayoBK06Vg(@NotNull int[] array, int i4, int i5) {
        Intrinsics.checkNotNullParameter(array, "array");
        m484quickSortoBK06Vg(array, i4, i5 - 1);
    }
}
