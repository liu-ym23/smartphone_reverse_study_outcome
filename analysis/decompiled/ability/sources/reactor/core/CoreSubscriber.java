package reactor.core;

import Z9.d;
import Z9.e;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
public interface CoreSubscriber<T> extends d {
    default Context currentContext() {
        return Context.empty();
    }

    @Override // Z9.d
    /* synthetic */ void onComplete();

    @Override // Z9.d
    /* synthetic */ void onError(Throwable th);

    @Override // Z9.d
    /* synthetic */ void onNext(Object obj);

    @Override // Z9.d
    void onSubscribe(e eVar);
}
