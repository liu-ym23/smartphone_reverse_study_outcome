package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final enum EmptyObservableHolder extends Enum<EmptyObservableHolder> implements Observable.OnSubscribe<Object> {
    private static final /* synthetic */ EmptyObservableHolder[] $VALUES = null;
    static final Observable EMPTY = null;
    public static final EmptyObservableHolder INSTANCE = null;

    static {
        EmptyObservableHolder r10 = new EmptyObservableHolder("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new EmptyObservableHolder[]{r10};
        EMPTY = Observable.y(r10);
    }

    private EmptyObservableHolder(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> Observable instance() {
        return EMPTY;
    }

    public static EmptyObservableHolder valueOf(String r10) {
        return (EmptyObservableHolder) Enum.valueOf(EmptyObservableHolder.class, r10);
    }

    public static EmptyObservableHolder[] values() {
        return (EmptyObservableHolder[]) $VALUES.clone();
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        r10.onCompleted();
    }
}
