package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

/* JADX INFO: loaded from: classes4.dex */
public final enum ParallelFailureHandling extends Enum<ParallelFailureHandling> implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    private static final /* synthetic */ ParallelFailureHandling[] $VALUES = null;
    public static final ParallelFailureHandling ERROR = null;
    public static final ParallelFailureHandling RETRY = null;
    public static final ParallelFailureHandling SKIP = null;
    public static final ParallelFailureHandling STOP = null;

    static {
        ParallelFailureHandling r10 = new ParallelFailureHandling("STOP", 0);
        STOP = r10;
        ParallelFailureHandling r11 = new ParallelFailureHandling("ERROR", 1);
        ERROR = r11;
        ParallelFailureHandling r12 = new ParallelFailureHandling("SKIP", 2);
        SKIP = r12;
        ParallelFailureHandling r13 = new ParallelFailureHandling("RETRY", 3);
        RETRY = r13;
        $VALUES = new ParallelFailureHandling[]{r10, r11, r12, r13};
    }

    private ParallelFailureHandling(String r10, int r11) {
        super(r10, r11);
    }

    public static ParallelFailureHandling valueOf(String r10) {
        return (ParallelFailureHandling) Enum.valueOf(ParallelFailureHandling.class, r10);
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ParallelFailureHandling apply2(Long r10, Throwable r11) {
        return this;
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ ParallelFailureHandling apply(Long r10, Throwable r11) throws Exception {
        return apply2(r10, r11);
    }
}
