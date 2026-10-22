package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1227differenceModuloWZ9TVnA(int i4, int i5, int i6) {
        int iRemainderUnsigned = Integer.remainderUnsigned(i4, i6);
        int iRemainderUnsigned2 = Integer.remainderUnsigned(i5, i6);
        int iCompareUnsigned = Integer.compareUnsigned(iRemainderUnsigned, iRemainderUnsigned2);
        int iM117constructorimpl = UInt.m117constructorimpl(iRemainderUnsigned - iRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? iM117constructorimpl : UInt.m117constructorimpl(iM117constructorimpl + i6);
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1228differenceModulosambcqE(long j4, long j5, long j6) {
        long jRemainderUnsigned = Long.remainderUnsigned(j4, j6);
        long jRemainderUnsigned2 = Long.remainderUnsigned(j5, j6);
        int iCompareUnsigned = Long.compareUnsigned(jRemainderUnsigned, jRemainderUnsigned2);
        long jM196constructorimpl = ULong.m196constructorimpl(jRemainderUnsigned - jRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? jM196constructorimpl : ULong.m196constructorimpl(jM196constructorimpl + j6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1229getProgressionLastElement7ftBX0g(long j4, long j5, long j6) {
        if (j6 > 0) {
            return Long.compareUnsigned(j4, j5) >= 0 ? j5 : ULong.m196constructorimpl(j5 - m1228differenceModulosambcqE(j5, j4, ULong.m196constructorimpl(j6)));
        }
        if (j6 < 0) {
            return Long.compareUnsigned(j4, j5) <= 0 ? j5 : ULong.m196constructorimpl(j5 + m1228differenceModulosambcqE(j4, j5, ULong.m196constructorimpl(-j6)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1230getProgressionLastElementNkh28Cs(int i4, int i5, int i6) {
        if (i6 > 0) {
            return Integer.compareUnsigned(i4, i5) >= 0 ? i5 : UInt.m117constructorimpl(i5 - m1227differenceModuloWZ9TVnA(i5, i4, UInt.m117constructorimpl(i6)));
        }
        if (i6 < 0) {
            return Integer.compareUnsigned(i4, i5) <= 0 ? i5 : UInt.m117constructorimpl(i5 + m1227differenceModuloWZ9TVnA(i4, i5, UInt.m117constructorimpl(-i6)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
