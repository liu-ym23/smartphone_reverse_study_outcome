package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000¨\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "UnsignedKt")
/* loaded from: classes2.dex */
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d4) {
        if (Double.isNaN(d4) || d4 <= uintToDouble(0)) {
            return 0;
        }
        if (d4 >= uintToDouble(-1)) {
            return -1;
        }
        if (d4 <= 2.147483647E9d) {
            return UInt.m117constructorimpl((int) d4);
        }
        return UInt.m117constructorimpl(UInt.m117constructorimpl(Integer.MAX_VALUE) + UInt.m117constructorimpl((int) (d4 - Integer.MAX_VALUE)));
    }

    @PublishedApi
    public static final long doubleToULong(double d4) {
        if (Double.isNaN(d4) || d4 <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d4 >= ulongToDouble(-1L)) {
            return -1L;
        }
        return d4 < 9.223372036854776E18d ? ULong.m196constructorimpl((long) d4) : ULong.m196constructorimpl(ULong.m196constructorimpl((long) (d4 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int uintCompare(int i4, int i5) {
        return Intrinsics.compare(i4 ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m373uintDivideJ1ME1BU(int i4, int i5) {
        return UInt.m117constructorimpl((int) ((i4 & 4294967295L) / (i5 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m374uintRemainderJ1ME1BU(int i4, int i5) {
        return UInt.m117constructorimpl((int) ((i4 & 4294967295L) % (i5 & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i4) {
        return (((i4 >>> 31) << 30) * 2) + (Integer.MAX_VALUE & i4);
    }

    @PublishedApi
    public static final int ulongCompare(long j4, long j5) {
        return Intrinsics.compare(j4 ^ Long.MIN_VALUE, j5 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m375ulongDivideeb3DHEI(long j4, long j5) {
        if (j5 < 0) {
            return Long.compareUnsigned(j4, j5) < 0 ? ULong.m196constructorimpl(0L) : ULong.m196constructorimpl(1L);
        }
        if (j4 >= 0) {
            return ULong.m196constructorimpl(j4 / j5);
        }
        long j6 = ((j4 >>> 1) / j5) << 1;
        return ULong.m196constructorimpl(j6 + (Long.compareUnsigned(ULong.m196constructorimpl(j4 - (j6 * j5)), ULong.m196constructorimpl(j5)) < 0 ? 0 : 1));
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m376ulongRemaindereb3DHEI(long j4, long j5) {
        if (j5 < 0) {
            return Long.compareUnsigned(j4, j5) < 0 ? j4 : ULong.m196constructorimpl(j4 - j5);
        }
        if (j4 >= 0) {
            return ULong.m196constructorimpl(j4 % j5);
        }
        long j6 = j4 - ((((j4 >>> 1) / j5) << 1) * j5);
        if (Long.compareUnsigned(ULong.m196constructorimpl(j6), ULong.m196constructorimpl(j5)) < 0) {
            j5 = 0;
        }
        return ULong.m196constructorimpl(j6 - j5);
    }

    @PublishedApi
    public static final double ulongToDouble(long j4) {
        return ((j4 >>> 11) * 2048) + (j4 & 2047);
    }

    @NotNull
    public static final String ulongToString(long j4) {
        return ulongToString(j4, 10);
    }

    @NotNull
    public static final String ulongToString(long j4, int i4) {
        if (j4 >= 0) {
            String string = Long.toString(j4, CharsKt.checkRadix(i4));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long j5 = i4;
        long j6 = ((j4 >>> 1) / j5) << 1;
        long j7 = j4 - (j6 * j5);
        if (j7 >= j5) {
            j7 -= j5;
            j6++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j6, CharsKt.checkRadix(i4));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j7, CharsKt.checkRadix(i4));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
