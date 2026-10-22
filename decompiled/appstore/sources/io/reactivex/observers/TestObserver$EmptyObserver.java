package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
final enum TestObserver$EmptyObserver extends Enum<TestObserver$EmptyObserver> implements Observer<Object> {
    private static final /* synthetic */ TestObserver$EmptyObserver[] $VALUES = null;
    public static final TestObserver$EmptyObserver INSTANCE = null;

    static {
        TestObserver$EmptyObserver r10 = new TestObserver$EmptyObserver("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new TestObserver$EmptyObserver[]{r10};
    }

    private TestObserver$EmptyObserver(String r10, int r11) {
        super(r10, r11);
    }

    public static TestObserver$EmptyObserver valueOf(String r10) {
        return (TestObserver$EmptyObserver) Enum.valueOf(TestObserver$EmptyObserver.class, r10);
    }

    public static TestObserver$EmptyObserver[] values() {
        return (TestObserver$EmptyObserver[]) $VALUES.clone();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
    }
}
