package io.reactivex.internal.operators.single;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import mf.e;

/* JADX INFO: loaded from: classes4.dex */
final enum SingleInternalHelper$ToObservable extends Enum<SingleInternalHelper$ToObservable> implements Function<SingleSource, e> {
    private static final /* synthetic */ SingleInternalHelper$ToObservable[] $VALUES = null;
    public static final SingleInternalHelper$ToObservable INSTANCE = null;

    static {
        SingleInternalHelper$ToObservable r10 = new SingleInternalHelper$ToObservable("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new SingleInternalHelper$ToObservable[]{r10};
    }

    private SingleInternalHelper$ToObservable(String r10, int r11) {
        super(r10, r11);
    }

    public static SingleInternalHelper$ToObservable valueOf(String r10) {
        return (SingleInternalHelper$ToObservable) Enum.valueOf(SingleInternalHelper$ToObservable.class, r10);
    }

    public static SingleInternalHelper$ToObservable[] values() {
        return (SingleInternalHelper$ToObservable[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ e apply(SingleSource r10) throws Exception {
        return apply2(r10);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public e apply2(SingleSource r10) {
        return new SingleToObservable(r10);
    }
}
