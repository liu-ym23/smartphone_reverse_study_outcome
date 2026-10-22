package rx.subjects;

/* JADX INFO: loaded from: classes4.dex */
interface ReplaySubject$ReplayBuffer<T> {
    void complete();

    void drain(ReplaySubject$ReplayProducer<T> r10);

    Throwable error();

    void error(Throwable r10);

    boolean isComplete();

    boolean isEmpty();

    T last();

    void next(T r10);

    int size();

    T[] toArray(T[] r10);
}
