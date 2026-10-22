package reactor.core;

import Z9.c;
import Z9.d;

/* loaded from: classes4.dex */
public interface CorePublisher<T> extends c {
    @Override // Z9.c
    /* synthetic */ void subscribe(d dVar);

    void subscribe(CoreSubscriber<? super T> coreSubscriber);
}
