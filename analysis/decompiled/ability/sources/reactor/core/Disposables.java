package reactor.core;

import E3.d;
import S6.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public final class Disposables {
    static final Disposable DISPOSED = disposed();

    public static final class AlwaysDisposable implements Disposable {
        @Override // reactor.core.Disposable
        public void dispose() {
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return true;
        }
    }

    public static final class ListCompositeDisposable implements Disposable.Composite, Scannable {
        volatile boolean disposed;

        @Nullable
        List<Disposable> resources;

        public ListCompositeDisposable() {
        }

        @Override // reactor.core.Disposable.Composite
        public boolean add(Disposable disposable) {
            Objects.requireNonNull(disposable, "d is null");
            if (!this.disposed) {
                synchronized (this) {
                    try {
                        if (!this.disposed) {
                            List linkedList = this.resources;
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                                this.resources = linkedList;
                            }
                            linkedList.add(disposable);
                            return true;
                        }
                    } finally {
                    }
                }
            }
            disposable.dispose();
            return false;
        }

        @Override // reactor.core.Disposable.Composite
        public boolean addAll(Collection<? extends Disposable> collection) {
            Objects.requireNonNull(collection, "ds is null");
            if (!this.disposed) {
                synchronized (this) {
                    try {
                        if (!this.disposed) {
                            List linkedList = this.resources;
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                                this.resources = linkedList;
                            }
                            for (Disposable disposable : collection) {
                                Objects.requireNonNull(disposable, "d is null");
                                linkedList.add(disposable);
                            }
                            return true;
                        }
                    } finally {
                    }
                }
            }
            Iterator<? extends Disposable> it = collection.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
            return false;
        }

        public Stream<Disposable> asStream() {
            List<Disposable> list = this.resources;
            return list == null ? Stream.empty() : list.stream();
        }

        public void clear() {
            if (this.disposed) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.disposed) {
                        return;
                    }
                    List<Disposable> list = this.resources;
                    this.resources = null;
                    dispose(list);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.Disposable.Composite, reactor.core.Disposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.disposed) {
                        return;
                    }
                    this.disposed = true;
                    List<Disposable> list = this.resources;
                    this.resources = null;
                    dispose(list);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return asStream().filter(new c(6)).map(new d(23));
        }

        @Override // reactor.core.Disposable.Composite, reactor.core.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // reactor.core.Disposable.Composite
        public boolean remove(Disposable disposable) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            if (this.disposed) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.disposed) {
                        return false;
                    }
                    List<Disposable> list = this.resources;
                    if (list != null && list.remove(disposable)) {
                        return true;
                    }
                    return false;
                } finally {
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            return null;
        }

        @Override // reactor.core.Disposable.Composite
        public int size() {
            List<Disposable> list = this.resources;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public ListCompositeDisposable(Disposable... disposableArr) {
            Objects.requireNonNull(disposableArr, "resources is null");
            this.resources = new LinkedList();
            for (Disposable disposable : disposableArr) {
                Objects.requireNonNull(disposable, "Disposable item is null");
                this.resources.add(disposable);
            }
        }

        public ListCompositeDisposable(Iterable<? extends Disposable> iterable) {
            Objects.requireNonNull(iterable, "resources is null");
            this.resources = new LinkedList();
            for (Disposable disposable : iterable) {
                Objects.requireNonNull(disposable, "Disposable item is null");
                this.resources.add(disposable);
            }
        }

        public void dispose(@Nullable List<Disposable> list) {
            if (list == null) {
                return;
            }
            Iterator<Disposable> it = list.iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                try {
                    it.next().dispose();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            if (arrayList != null) {
                if (arrayList.size() == 1) {
                    throw Exceptions.propagate((Throwable) arrayList.get(0));
                }
                throw Exceptions.multiple(arrayList);
            }
        }
    }

    public static final class NeverDisposable implements Disposable {
        @Override // reactor.core.Disposable
        public void dispose() {
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return false;
        }
    }

    public static final class SimpleDisposable extends AtomicBoolean implements Disposable {
        @Override // reactor.core.Disposable
        public void dispose() {
            set(true);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public static final class SwapDisposable implements Disposable.Swap {
        static final AtomicReferenceFieldUpdater<SwapDisposable, Disposable> INNER = AtomicReferenceFieldUpdater.newUpdater(SwapDisposable.class, Disposable.class, "inner");
        volatile Disposable inner;

        @Override // reactor.core.Disposable
        public void dispose() {
            Disposables.dispose(INNER, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return Disposables.isDisposed(INNER.get(this));
        }

        @Override // reactor.core.Disposable.Swap
        public boolean replace(@Nullable Disposable disposable) {
            return Disposables.replace(INNER, this, disposable);
        }

        @Override // reactor.core.Disposable.Swap
        public boolean update(@Nullable Disposable disposable) {
            return Disposables.set(INNER, this, disposable);
        }

        @Override // java.util.function.Supplier
        @Nullable
        public Disposable get() {
            return this.inner;
        }
    }

    private Disposables() {
    }

    public static Disposable.Composite composite() {
        return new ListCompositeDisposable();
    }

    public static <T> boolean dispose(AtomicReferenceFieldUpdater<T, Disposable> atomicReferenceFieldUpdater, T t9) {
        Disposable andSet;
        Disposable disposable = atomicReferenceFieldUpdater.get(t9);
        Disposable disposable2 = DISPOSED;
        if (disposable == disposable2 || (andSet = atomicReferenceFieldUpdater.getAndSet(t9, disposable2)) == disposable2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static Disposable disposed() {
        return new AlwaysDisposable();
    }

    public static boolean isDisposed(Disposable disposable) {
        return disposable == DISPOSED;
    }

    public static Disposable never() {
        return new NeverDisposable();
    }

    public static <T> boolean replace(AtomicReferenceFieldUpdater<T, Disposable> atomicReferenceFieldUpdater, T t9, @Nullable Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReferenceFieldUpdater.get(t9);
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(t9, disposable2, disposable));
        return true;
    }

    public static <T> boolean set(AtomicReferenceFieldUpdater<T, Disposable> atomicReferenceFieldUpdater, T t9, @Nullable Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReferenceFieldUpdater.get(t9);
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(t9, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.dispose();
        return true;
    }

    public static Disposable single() {
        return new SimpleDisposable();
    }

    public static Disposable.Swap swap() {
        return new SwapDisposable();
    }

    public static Disposable.Composite composite(Disposable... disposableArr) {
        return new ListCompositeDisposable(disposableArr);
    }

    public static Disposable.Composite composite(Iterable<? extends Disposable> iterable) {
        return new ListCompositeDisposable(iterable);
    }
}
