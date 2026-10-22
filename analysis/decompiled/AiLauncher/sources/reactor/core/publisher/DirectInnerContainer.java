package reactor.core.publisher;

import reactor.core.publisher.SinkManyBestEffort;

@Deprecated
/* loaded from: classes5.dex */
interface DirectInnerContainer<T> {
    boolean add(SinkManyBestEffort.DirectInner<T> directInner);

    void remove(SinkManyBestEffort.DirectInner<T> directInner);
}
