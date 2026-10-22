package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProgressionUtilKt {
    private static final int differenceModulo(int i4, int i5, int i6) {
        return mod(mod(i4, i6) - mod(i5, i6), i6);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int i4, int i5, int i6) {
        if (i6 > 0) {
            return i4 >= i5 ? i5 : i5 - differenceModulo(i5, i4, i6);
        }
        if (i6 < 0) {
            return i4 <= i5 ? i5 : i5 + differenceModulo(i4, i5, -i6);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int mod(int i4, int i5) {
        int i6 = i4 % i5;
        return i6 >= 0 ? i6 : i6 + i5;
    }

    private static final long differenceModulo(long j4, long j5, long j6) {
        return mod(mod(j4, j6) - mod(j5, j6), j6);
    }

    private static final long mod(long j4, long j5) {
        long j6 = j4 % j5;
        return j6 >= 0 ? j6 : j6 + j5;
    }

    @PublishedApi
    public static final long getProgressionLastElement(long j4, long j5, long j6) {
        if (j6 > 0) {
            return j4 >= j5 ? j5 : j5 - differenceModulo(j5, j4, j6);
        }
        if (j6 < 0) {
            return j4 <= j5 ? j5 : j5 + differenceModulo(j4, j5, -j6);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
