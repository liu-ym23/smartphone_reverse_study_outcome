package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
public final enum MaybeToPublisher extends Enum<MaybeToPublisher> implements Function<MaybeSource<Object>, Publisher<Object>> {
    private static final /* synthetic */ MaybeToPublisher[] $VALUES = null;
    public static final MaybeToPublisher INSTANCE = null;

    static {
        MaybeToPublisher r10 = new MaybeToPublisher("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new MaybeToPublisher[]{r10};
    }

    private MaybeToPublisher(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String r10) {
        return (MaybeToPublisher) Enum.valueOf(MaybeToPublisher.class, r10);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Publisher<Object> apply(MaybeSource<Object> r10) throws Exception {
        return apply2(r10);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Publisher<Object> apply2(MaybeSource<Object> r10) throws Exception {
        return new MaybeToFlowable(r10);
    }
}
