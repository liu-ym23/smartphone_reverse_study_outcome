package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final enum FlowableInternalHelper$RequestMax extends Enum<FlowableInternalHelper$RequestMax> implements Consumer<Subscription> {
    private static final /* synthetic */ FlowableInternalHelper$RequestMax[] $VALUES = null;
    public static final FlowableInternalHelper$RequestMax INSTANCE = null;

    static {
        FlowableInternalHelper$RequestMax r10 = new FlowableInternalHelper$RequestMax("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new FlowableInternalHelper$RequestMax[]{r10};
    }

    private FlowableInternalHelper$RequestMax(String r10, int r11) {
        super(r10, r11);
    }

    public static FlowableInternalHelper$RequestMax valueOf(String r10) {
        return (FlowableInternalHelper$RequestMax) Enum.valueOf(FlowableInternalHelper$RequestMax.class, r10);
    }

    public static FlowableInternalHelper$RequestMax[] values() {
        return (FlowableInternalHelper$RequestMax[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Subscription r10) throws Exception {
        accept2(r10);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Subscription r10) throws Exception {
        r10.request(Long.MAX_VALUE);
    }
}
