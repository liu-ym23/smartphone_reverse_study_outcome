package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final enum ListAddBiConsumer extends Enum<ListAddBiConsumer> implements BiFunction<List, Object, List> {
    private static final /* synthetic */ ListAddBiConsumer[] $VALUES = null;
    public static final ListAddBiConsumer INSTANCE = null;

    static {
        ListAddBiConsumer r10 = new ListAddBiConsumer("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new ListAddBiConsumer[]{r10};
    }

    private ListAddBiConsumer(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    public static ListAddBiConsumer valueOf(String r10) {
        return (ListAddBiConsumer) Enum.valueOf(ListAddBiConsumer.class, r10);
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ List apply(List r10, Object r11) throws Exception {
        return apply2(r10, r11);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List apply2(List r10, Object r11) throws Exception {
        r10.add(r11);
        return r10;
    }
}
