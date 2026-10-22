package reactor.core;

import qd.d;
import qd.e;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface CoreSubscriber<T> extends d {
    default Context currentContext() {
        return Context.empty();
    }

    @Override // qd.d
    /* synthetic */ void onComplete();

    @Override // qd.d
    /* synthetic */ void onError(Throwable th);

    @Override // qd.d
    /* synthetic */ void onNext(Object obj);

    @Override // qd.d
    void onSubscribe(e eVar);
}
