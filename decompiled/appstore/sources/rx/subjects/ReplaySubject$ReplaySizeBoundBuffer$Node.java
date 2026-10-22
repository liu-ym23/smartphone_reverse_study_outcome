package rx.subjects;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ReplaySubject$ReplaySizeBoundBuffer$Node<T> extends AtomicReference<ReplaySubject$ReplaySizeBoundBuffer$Node<T>> {
    private static final long serialVersionUID = 3713592843205853725L;
    final T value;

    public ReplaySubject$ReplaySizeBoundBuffer$Node(T r10) {
        this.value = r10;
    }
}
