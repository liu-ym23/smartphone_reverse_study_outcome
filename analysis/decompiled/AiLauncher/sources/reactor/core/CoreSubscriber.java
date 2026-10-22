package reactor.core;

import reactor.util.context.Context;

/* loaded from: classes5.dex */
public interface CoreSubscriber<T> extends qc.c<T> {
    default Context currentContext() {
        return Context.empty();
    }

    @Override // qc.c
    /* synthetic */ void onComplete();

    @Override // qc.c
    /* synthetic */ void onError(Throwable th);

    @Override // qc.c
    /* synthetic */ void onNext(Object obj);

    @Override // qc.c
    void onSubscribe(qc.d dVar);
}
