package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final enum ArrayListSupplier extends Enum<ArrayListSupplier> implements Callable<List<Object>>, Function<Object, List<Object>> {
    private static final /* synthetic */ ArrayListSupplier[] $VALUES = null;
    public static final ArrayListSupplier INSTANCE = null;

    static {
        ArrayListSupplier r10 = new ArrayListSupplier("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new ArrayListSupplier[]{r10};
    }

    private ArrayListSupplier(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> Function<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String r10) {
        return (ArrayListSupplier) Enum.valueOf(ArrayListSupplier.class, r10);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<Object> apply(Object r10) throws Exception {
        return apply2(r10);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Object> call() throws Exception {
        return call2();
    }

    @Override // io.reactivex.functions.Function
    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List<Object> apply2(Object r10) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Object> call2() throws Exception {
        return new ArrayList();
    }
}
