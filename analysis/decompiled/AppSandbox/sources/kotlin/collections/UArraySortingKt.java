package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import stepos.com.android.os.StatsLogEnums;

/* compiled from: UArraySorting.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_MATCHER_NOT_IN_PREV_CONFIG_VALUE)
/* loaded from: classes.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m873partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM493getw2LRezQ = UByteArray.m493getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM493getw2LRezQ = UByteArray.m493getw2LRezQ(bArr, i) & UByte.MAX_VALUE;
                i3 = bM493getw2LRezQ & UByte.MAX_VALUE;
                if (Intrinsics.compare(iM493getw2LRezQ, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m493getw2LRezQ(bArr, i2) & UByte.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM493getw2LRezQ2 = UByteArray.m493getw2LRezQ(bArr, i);
                UByteArray.m498setVurrAj0(bArr, i, UByteArray.m493getw2LRezQ(bArr, i2));
                UByteArray.m498setVurrAj0(bArr, i2, bM493getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m877quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM873partition4UcCI2c = m873partition4UcCI2c(bArr, i, i2);
        int i3 = iM873partition4UcCI2c - 1;
        if (i < i3) {
            m877quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM873partition4UcCI2c < i2) {
            m877quickSort4UcCI2c(bArr, iM873partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m874partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM756getMh2AYeg = UShortArray.m756getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM756getMh2AYeg = UShortArray.m756getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM756getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM756getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m756getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM756getMh2AYeg2 = UShortArray.m756getMh2AYeg(sArr, i);
                UShortArray.m761set01HTLdE(sArr, i, UShortArray.m756getMh2AYeg(sArr, i2));
                UShortArray.m761set01HTLdE(sArr, i2, sM756getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m878quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM874partitionAa5vz7o = m874partitionAa5vz7o(sArr, i, i2);
        int i3 = iM874partitionAa5vz7o - 1;
        if (i < i3) {
            m878quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM874partitionAa5vz7o < i2) {
            m878quickSortAa5vz7o(sArr, iM874partitionAa5vz7o, i2);
        }
    }

    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m875partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM572getpVg5ArA = UIntArray.m572getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m572getpVg5ArA(iArr, i), iM572getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m572getpVg5ArA(iArr, i2), iM572getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM572getpVg5ArA2 = UIntArray.m572getpVg5ArA(iArr, i);
                UIntArray.m577setVXSXFK8(iArr, i, UIntArray.m572getpVg5ArA(iArr, i2));
                UIntArray.m577setVXSXFK8(iArr, i2, iM572getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m879quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM875partitionoBK06Vg = m875partitionoBK06Vg(iArr, i, i2);
        int i3 = iM875partitionoBK06Vg - 1;
        if (i < i3) {
            m879quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM875partitionoBK06Vg < i2) {
            m879quickSortoBK06Vg(iArr, iM875partitionoBK06Vg, i2);
        }
    }

    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m872partitionnroSd4(long[] jArr, int i, int i2) {
        long jM651getsVKNKU = ULongArray.m651getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m651getsVKNKU(jArr, i), jM651getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m651getsVKNKU(jArr, i2), jM651getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM651getsVKNKU2 = ULongArray.m651getsVKNKU(jArr, i);
                ULongArray.m656setk8EXiF4(jArr, i, ULongArray.m651getsVKNKU(jArr, i2));
                ULongArray.m656setk8EXiF4(jArr, i2, jM651getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m876quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM872partitionnroSd4 = m872partitionnroSd4(jArr, i, i2);
        int i3 = iM872partitionnroSd4 - 1;
        if (i < i3) {
            m876quickSortnroSd4(jArr, i, i3);
        }
        if (iM872partitionnroSd4 < i2) {
            m876quickSortnroSd4(jArr, iM872partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m881sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m877quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m882sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m878quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m883sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m879quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m880sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m876quickSortnroSd4(array, i, i2 - 1);
    }
}
