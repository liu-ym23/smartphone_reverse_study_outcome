package reactor.core;

/* loaded from: classes5.dex */
public interface CorePublisher<T> extends qc.b<T> {
    @Override // qc.b
    /* synthetic */ void subscribe(qc.c cVar);

    void subscribe(CoreSubscriber<? super T> coreSubscriber);
}
