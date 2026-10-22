package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes17.dex */
public abstract class DataSource<Key, Value> {
    private AtomicBoolean mInvalid;
    private CopyOnWriteArrayList<InvalidatedCallback> mOnInvalidatedCallbacks;

    public static abstract class Factory<Key, Value> {
        public Factory() {
        }

        public abstract DataSource<Key, Value> create();

        public <ToValue> Factory<Key, ToValue> map(Function<Value, ToValue> r100) {
            return mapByPage(DataSource.createListFunction(r100));
        }

        public <ToValue> Factory<Key, ToValue> mapByPage(final Function<List<Value>, List<ToValue>> r100) {
            return new AnonymousClass1(this, r100);
        }
    }

    public interface InvalidatedCallback {
        void onInvalidated();
    }

    public static class LoadCallbackHelper<T> {
        private final DataSource mDataSource;
        private boolean mHasSignalled;
        private Executor mPostExecutor;
        final PageResult.Receiver<T> mReceiver;
        final int mResultType;
        private final Object mSignalLock;

        public boolean dispatchInvalidResultIfInvalid() {
            if (this.mDataSource.isInvalid() == false) goto L6;
            dispatchResultToReceiver(PageResult.getInvalidResult());
            return true;
        L6:
            return false;
        }

        public void dispatchResultToReceiver(final PageResult<T> r100) {
            Object r101 = this.mSignalLock;
            monitor-enter(r101);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.mHasSignalled == true) goto L13;
            this.mHasSignalled = true;     // Catch: Throwable -> L14
            Executor r102 = this.mPostExecutor;     // Catch: Throwable -> L14
            monitor-exit(r101);     // Catch: Throwable -> L14
            if (r102 == null) goto L10;
            r102.execute(new AnonymousClass1(this, r100));
            return;
        L10:
            this.mReceiver.onPageResult(this.mResultType, r100);
            return;
        L13:
            throw new IllegalStateException("callback.onResult already called, cannot call again.");     // Catch: Throwable -> L14
        }

        public void setPostExecutor(Executor r100) {
            Object r101 = this.mSignalLock;
            monitor-enter(r101);
            this.mPostExecutor = r100;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public static void validateInitialLoadParams(List<?> r100, int r101, int r102) {
            if (r101 < 0) goto L15;
            if ((r100.size() + r101) > r102) goto L13;
            if (r100.size() != 0) goto L11;
            if (r102 > 0) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
        L11:
            return;
        L13:
            throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
        L15:
            throw new IllegalArgumentException("Position must be non-negative");
        }

        public LoadCallbackHelper(DataSource r100, int r101, Executor r102, PageResult.Receiver<T> r103) {
            this.mSignalLock = new Object();
            this.mHasSignalled = false;
            this.mDataSource = r100;
            this.mResultType = r101;
            this.mPostExecutor = r102;
            this.mReceiver = r103;
        }
    }

    public abstract boolean isContiguous();

    public abstract <ToValue> DataSource<Key, ToValue> map(Function<Value, ToValue> r100);

    public abstract <ToValue> DataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> r100);

    public void invalidate() {
        if (this.mInvalid.compareAndSet(false, true) == false) goto L8;
        Iterator<InvalidatedCallback> r100 = this.mOnInvalidatedCallbacks.iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        r100.next().onInvalidated();
        goto L6
    L10:
        return;
    }

    public boolean isInvalid() {
        return this.mInvalid.get();
    }

    public DataSource() {
        this.mInvalid = new AtomicBoolean(false);
        this.mOnInvalidatedCallbacks = new CopyOnWriteArrayList();
    }

    public static <X, Y> Function<List<X>, List<Y>> createListFunction(final Function<X, Y> r100) {
        return new AnonymousClass1(r100);
    }

    public void addInvalidatedCallback(InvalidatedCallback r100) {
        this.mOnInvalidatedCallbacks.add(r100);
    }

    public void removeInvalidatedCallback(InvalidatedCallback r100) {
        this.mOnInvalidatedCallbacks.remove(r100);
    }

    public static <A, B> List<B> convert(Function<List<A>, List<B>> r100, List<A> r101) {
        List<B> r102 = r100.apply(r101);
        if (r102.size() != r101.size()) goto L6;
        return r102;
    L6:
        throw new IllegalStateException("Invalid Function " + r100 + " changed return size. This is not supported.");
    }
}
