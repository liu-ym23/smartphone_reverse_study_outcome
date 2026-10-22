package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final enum ListAddBiConsumer extends Enum<ListAddBiConsumer> implements BiFunction<List, Object, List> {
    private static final /* synthetic */ ListAddBiConsumer[] $VALUES = null;
    public static final ListAddBiConsumer INSTANCE = null;

    public static ListAddBiConsumer valueOf(String r1) {
        return (ListAddBiConsumer) Enum.valueOf(ListAddBiConsumer.class, r1);
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ List apply(List r1, Object r2) throws Exception {
        return apply2(r1, r2);
    }

    private ListAddBiConsumer(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ListAddBiConsumer r0 = new ListAddBiConsumer("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new ListAddBiConsumer[]{r0};
    }

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List apply2(List r1, Object r2) throws Exception {
        r1.add(r2);
        return r1;
    }
}
