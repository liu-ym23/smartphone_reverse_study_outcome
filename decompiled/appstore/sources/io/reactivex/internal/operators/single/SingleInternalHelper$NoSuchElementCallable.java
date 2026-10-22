package io.reactivex.internal.operators.single;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
final enum SingleInternalHelper$NoSuchElementCallable extends Enum<SingleInternalHelper$NoSuchElementCallable> implements Callable<NoSuchElementException> {
    private static final /* synthetic */ SingleInternalHelper$NoSuchElementCallable[] $VALUES = null;
    public static final SingleInternalHelper$NoSuchElementCallable INSTANCE = null;

    static {
        SingleInternalHelper$NoSuchElementCallable r10 = new SingleInternalHelper$NoSuchElementCallable("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new SingleInternalHelper$NoSuchElementCallable[]{r10};
    }

    private SingleInternalHelper$NoSuchElementCallable(String r10, int r11) {
        super(r10, r11);
    }

    public static SingleInternalHelper$NoSuchElementCallable valueOf(String r10) {
        return (SingleInternalHelper$NoSuchElementCallable) Enum.valueOf(SingleInternalHelper$NoSuchElementCallable.class, r10);
    }

    public static SingleInternalHelper$NoSuchElementCallable[] values() {
        return (SingleInternalHelper$NoSuchElementCallable[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ NoSuchElementException call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public NoSuchElementException call2() throws Exception {
        return new NoSuchElementException();
    }
}
