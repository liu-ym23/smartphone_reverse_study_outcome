package reactor.core.publisher;

import reactor.core.publisher.SinkManyBestEffort;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
interface DirectInnerContainer<T> {
    boolean add(SinkManyBestEffort.DirectInner<T> directInner);

    void remove(SinkManyBestEffort.DirectInner<T> directInner);
}
