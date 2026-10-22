package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "zero", "", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    /* JADX INFO: compiled from: TimeSources.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long r1, AbstractLongTimeSource r3, long r4, DefaultConstructorMarker r6) {
            this(r1, r3, r4);
        }

        private LongTimeMark(long r2, AbstractLongTimeSource r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "timeSource");
            this.startedAt = r2;
            this.timeSource = r4;
            this.offset = r5;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ComparableTimeMark r1) {
            return compareTo2(r1);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ComparableTimeMark r1) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, r1);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo2135minusLRDsOJo(long r1) {
            return ComparableTimeMark.DefaultImpls.m2139minusLRDsOJo(this, r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo2135minusLRDsOJo(long r1) {
            return mo2135minusLRDsOJo(r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo2137plusLRDsOJo(long r1) {
            return mo2137plusLRDsOJo(r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo2134elapsedNowUwyO8pc() {
            return Duration.m2179minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(AbstractLongTimeSource.access$adjustedRead(this.timeSource), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo2137plusLRDsOJo(long r11) {
            DurationUnit r0 = this.timeSource.getUnit();
            if (Duration.m2176isInfiniteimpl(r11) == true) goto L5;
            long r1 = Duration.m2196truncateToUwyO8pc$kotlin_stdlib(r11, r0);
            long r12 = Duration.m2180plusLRDsOJo(Duration.m2179minusLRDsOJo(r11, r1), this.offset);
            long r2 = LongSaturatedMathKt.m2273saturatingAddNuflL3o(this.startedAt, r0, r1);
            long r3 = Duration.m2196truncateToUwyO8pc$kotlin_stdlib(r12, r0);
            long r4 = LongSaturatedMathKt.m2273saturatingAddNuflL3o(r2, r0, r3);
            long r13 = Duration.m2179minusLRDsOJo(r12, r3);
            long r5 = Duration.m2164getInWholeNanosecondsimpl(r13);
            if (r4 == 0) goto L14;
            if (r5 == 0) goto L14;
            if ((r4 ^ r5) >= 0) goto L14;
            long r6 = DurationKt.toDuration(MathKt.getSign(r5), r0);
            r4 = LongSaturatedMathKt.m2273saturatingAddNuflL3o(r4, r0, r6);
            r13 = Duration.m2179minusLRDsOJo(r13, r6);
        L14:
            if ((1 | (r4 - 1)) != Long.MAX_VALUE) goto L16;
            boolean r7 = true;
        L17:
            if (r7 == false) goto L19;
            r13 = Duration.Companion.m2247getZEROUwyO8pc();
        L19:
            AbstractLongTimeSource r8 = this.timeSource;
            return new LongTimeMark(r4, r8, r13, null);
        L16:
            r7 = false;
            goto L17
        L5:
            return new LongTimeMark(LongSaturatedMathKt.m2273saturatingAddNuflL3o(this.startedAt, r0, r11), this.timeSource, Duration.Companion.m2247getZEROUwyO8pc(), null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo2136minusUwyO8pc(ComparableTimeMark r7) {
            Intrinsics.checkNotNullParameter(r7, "other");
            if ((r7 instanceof LongTimeMark) == false) goto L9;
            LongTimeMark r1 = (LongTimeMark) r7;
            if (Intrinsics.areEqual(this.timeSource, r1.timeSource) == false) goto L9;
            return Duration.m2180plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, r1.startedAt, this.timeSource.getUnit()), Duration.m2179minusLRDsOJo(this.offset, r1.offset));
        L9:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r7);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r3) {
            if ((r3 instanceof LongTimeMark) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((LongTimeMark) r3).timeSource) == false) goto L9;
            if (Duration.m2149equalsimpl0(mo2136minusUwyO8pc((ComparableTimeMark) r3), Duration.Companion.m2247getZEROUwyO8pc()) == false) goto L9;
            return true;
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m2172hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m2193toStringimpl(this.offset) + ", " + this.timeSource + ')';
        }
    }

    protected abstract long read();

    public AbstractLongTimeSource(DurationUnit r2) {
        Intrinsics.checkNotNullParameter(r2, "unit");
        this.unit = r2;
        this.zero$delegate = LazyKt.lazy(new AbstractLongTimeSource$zero$2(this));
    }

    public static final /* synthetic */ long access$adjustedRead(AbstractLongTimeSource r2) {
        return r2.adjustedRead();
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return markNow();
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    private final long adjustedRead() {
        return read() - getZero();
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m2247getZEROUwyO8pc(), null);
    }
}
