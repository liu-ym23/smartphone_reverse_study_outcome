package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: longSaturatedMath.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LongSaturatedMathKt {
    public static final boolean isSaturated(long r2) {
        if (((r2 - 1) | 1) != Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m2273saturatingAddNuflL3o(long r11, DurationUnit r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "unit");
        long r5 = Duration.m2190toLongimpl(r14, r13);
        boolean r3 = true;
        if (((r11 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        return m2272checkInfiniteSumDefinedPjuGub4(r11, r14, r5);
    L10:
        if ((1 | (r5 - 1)) == Long.MAX_VALUE) goto L13;
        r3 = false;
    L13:
        if (r3 == true) goto L15;
        long r15 = r11 + r5;
        if (((r11 ^ r15) & (r5 ^ r15)) < 0) goto L19;
        return r15;
    L19:
        if (r11 >= 0) goto L23;
        return Long.MIN_VALUE;
    L23:
        return Long.MAX_VALUE;
    L15:
        return m2274saturatingAddInHalvesNuflL3o(r11, r13, r14);
    L5:
        r2 = false;
        goto L6
    }

    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m2272checkInfiniteSumDefinedPjuGub4(long r0, long r2, long r4) {
        if (Duration.m2176isInfiniteimpl(r2) == true) goto L5;
    L9:
        return r0;
    L5:
        if ((r0 ^ r4) >= 0) goto L9;
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m2274saturatingAddInHalvesNuflL3o(long r8, DurationUnit r10, long r11) {
        long r0 = Duration.m2147divUwyO8pc(r11, 2);
        long r2 = Duration.m2190toLongimpl(r0, r10);
        if ((1 | (r2 - 1)) != Long.MAX_VALUE) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        return r2;
    L9:
        return m2273saturatingAddNuflL3o(m2273saturatingAddNuflL3o(r8, r10, r0), r10, Duration.m2179minusLRDsOJo(r11, r0));
    L5:
        r4 = false;
        goto L6
    }

    private static final long infinityOfSign(long r2) {
        if (r2 >= 0) goto L6;
        return Duration.Companion.m2246getNEG_INFINITEUwyO8pc$kotlin_stdlib();
    L6:
        return Duration.Companion.m2245getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long r4, long r6, DurationUnit r8) {
        Intrinsics.checkNotNullParameter(r8, "unit");
        if ((1 | (r6 - 1)) != Long.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return Duration.m2197unaryMinusUwyO8pc(infinityOfSign(r6));
    L10:
        return saturatingFiniteDiff(r4, r6, r8);
    L5:
        r0 = false;
        goto L6
    }

    public static final long saturatingOriginsDiff(long r9, long r11, DurationUnit r13) {
        Intrinsics.checkNotNullParameter(r13, "unit");
        boolean r3 = true;
        if (((r11 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L14;
        if (r9 != r11) goto L12;
        return Duration.Companion.m2247getZEROUwyO8pc();
    L12:
        return Duration.m2197unaryMinusUwyO8pc(infinityOfSign(r11));
    L14:
        if ((1 | (r9 - 1)) == Long.MAX_VALUE) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L21;
        return infinityOfSign(r9);
    L21:
        return saturatingFiniteDiff(r9, r11, r13);
    L5:
        r2 = false;
        goto L6
    }

    private static final long saturatingFiniteDiff(long r6, long r8, DurationUnit r10) {
        long r0 = r6 - r8;
        if (((r0 ^ r6) & (~(r0 ^ r8))) >= 0) goto L11;
        if (r10.compareTo(DurationUnit.MILLISECONDS) >= 0) goto L9;
        long r1 = DurationUnitKt.convertDurationUnit(1, DurationUnit.MILLISECONDS, r10);
        long r2 = (r6 / r1) - (r8 / r1);
        long r7 = (r6 % r1) - (r8 % r1);
        Duration.Companion r9 = Duration.Companion;
        return Duration.m2180plusLRDsOJo(DurationKt.toDuration(r2, DurationUnit.MILLISECONDS), DurationKt.toDuration(r7, r10));
    L9:
        return Duration.m2197unaryMinusUwyO8pc(infinityOfSign(r0));
    L11:
        return DurationKt.toDuration(r0, r10);
    }
}
