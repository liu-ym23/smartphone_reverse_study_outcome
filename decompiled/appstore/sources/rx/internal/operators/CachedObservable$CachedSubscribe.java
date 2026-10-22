package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = -2817751667698696782L;
    final b state;

    public CachedObservable$CachedSubscribe(b r10) {
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        new CachedObservable$ReplayProducer(r10, null);
        throw null;
    }
}
