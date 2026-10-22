package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final enum NeverObservableHolder extends Enum<NeverObservableHolder> implements Observable.OnSubscribe<Object> {
    private static final /* synthetic */ NeverObservableHolder[] $VALUES = null;
    public static final NeverObservableHolder INSTANCE = null;
    static final Observable NEVER = null;

    static {
        NeverObservableHolder r10 = new NeverObservableHolder("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new NeverObservableHolder[]{r10};
        NEVER = Observable.y(r10);
    }

    private NeverObservableHolder(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> Observable instance() {
        return NEVER;
    }

    public static NeverObservableHolder valueOf(String r10) {
        return (NeverObservableHolder) Enum.valueOf(NeverObservableHolder.class, r10);
    }

    public static NeverObservableHolder[] values() {
        return (NeverObservableHolder[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }
}
