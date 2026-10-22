package io.reactivex.internal.operators.single;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
final enum SingleInternalHelper$ToFlowable extends Enum<SingleInternalHelper$ToFlowable> implements Function<SingleSource, Publisher> {
    private static final /* synthetic */ SingleInternalHelper$ToFlowable[] $VALUES = null;
    public static final SingleInternalHelper$ToFlowable INSTANCE = null;

    static {
        SingleInternalHelper$ToFlowable r10 = new SingleInternalHelper$ToFlowable("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new SingleInternalHelper$ToFlowable[]{r10};
    }

    private SingleInternalHelper$ToFlowable(String r10, int r11) {
        super(r10, r11);
    }

    public static SingleInternalHelper$ToFlowable valueOf(String r10) {
        return (SingleInternalHelper$ToFlowable) Enum.valueOf(SingleInternalHelper$ToFlowable.class, r10);
    }

    public static SingleInternalHelper$ToFlowable[] values() {
        return (SingleInternalHelper$ToFlowable[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Publisher apply(SingleSource r10) throws Exception {
        return apply2(r10);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Publisher apply2(SingleSource r10) {
        return new SingleToFlowable(r10);
    }
}
