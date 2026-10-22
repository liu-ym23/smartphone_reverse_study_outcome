package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public abstract class PageKeyedDataSource<Key, Value> extends ContiguousDataSource<Key, Value> {
    private final Object mKeyLock;
    private Key mNextKey;
    private Key mPreviousKey;

    public static abstract class LoadCallback<Key, Value> {
        public LoadCallback() {
        }

        public abstract void onResult(List<Value> r100, Key r101);
    }

    public static class LoadCallbackImpl<Key, Value> extends LoadCallback<Key, Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;
        private final PageKeyedDataSource<Key, Value> mDataSource;

        @Override // androidx.paging.PageKeyedDataSource.LoadCallback
        public void onResult(List<Value> r100, Key r101) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == false) goto L5;
            return;
        L5:
            if (this.mCallbackHelper.mResultType != 1) goto L7;
            this.mDataSource.setNextKey(r101);
        L8:
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, 0, 0, 0));
            return;
        L7:
            this.mDataSource.setPreviousKey(r101);
            goto L8
        }

        public LoadCallbackImpl(PageKeyedDataSource<Key, Value> r100, int r101, Executor r102, PageResult.Receiver<Value> r103) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper(r100, r101, r102, r103);
            this.mDataSource = r100;
        }
    }

    public static abstract class LoadInitialCallback<Key, Value> {
        public LoadInitialCallback() {
        }

        public abstract void onResult(List<Value> r100, int r101, int r102, Key r103, Key r104);

        public abstract void onResult(List<Value> r100, Key r101, Key r102);
    }

    public static class LoadInitialCallbackImpl<Key, Value> extends LoadInitialCallback<Key, Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;
        private final boolean mCountingEnabled;
        private final PageKeyedDataSource<Key, Value> mDataSource;

        public LoadInitialCallbackImpl(PageKeyedDataSource<Key, Value> r100, boolean r101, PageResult.Receiver<Value> r102) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper(r100, 0, null, r102);
            this.mDataSource = r100;
            this.mCountingEnabled = r101;
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
        public void onResult(List<Value> r100, Key r101, Key r102) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L6;
            this.mDataSource.initKeys(r101, r102);
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, 0, 0, 0));
            return;
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
        public void onResult(List<Value> r100, int r101, int r102, Key r103, Key r104) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L9;
            DataSource.LoadCallbackHelper.validateInitialLoadParams(r100, r101, r102);
            this.mDataSource.initKeys(r103, r104);
            int r105 = (r102 - r101) - r100.size();
            if (this.mCountingEnabled == false) goto L7;
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, r101, r105, 0));
            return;
        L7:
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, r101));
            return;
        }
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;

        public LoadInitialParams(int r100, boolean r101) {
            this.requestedLoadSize = r100;
            this.placeholdersEnabled = r101;
        }
    }

    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key r100, int r101) {
            this.key = r100;
            this.requestedLoadSize = r101;
        }
    }

    @Override // androidx.paging.ContiguousDataSource
    public final Key getKey(int r100, Value r101) {
        return null;
    }

    public abstract void loadAfter(LoadParams<Key> r100, LoadCallback<Key, Value> r101);

    public abstract void loadBefore(LoadParams<Key> r100, LoadCallback<Key, Value> r101);

    public abstract void loadInitial(LoadInitialParams<Key> r100, LoadInitialCallback<Key, Value> r101);

    @Override // androidx.paging.ContiguousDataSource
    public boolean supportsPageDropping() {
        return false;
    }

    private Key getNextKey() {
        Object r100 = this.mKeyLock;
        monitor-enter(r100);
        Key r101 = this.mNextKey;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private Key getPreviousKey() {
        Object r100 = this.mKeyLock;
        monitor-enter(r100);
        Key r101 = this.mPreviousKey;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public PageKeyedDataSource() {
        this.mKeyLock = new Object();
        this.mNextKey = null;
        this.mPreviousKey = null;
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(Function<Value, ToValue> r100) {
        return mapByPage(DataSource.createListFunction(r100));
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> r100) {
        return new WrapperPageKeyedDataSource(this, r100);
    }

    public void setNextKey(Key r100) {
        Object r101 = this.mKeyLock;
        monitor-enter(r101);
        this.mNextKey = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPreviousKey(Key r100) {
        Object r101 = this.mKeyLock;
        monitor-enter(r101);
        this.mPreviousKey = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ DataSource map(Function r100) {
        return map(r100);
    }

    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ DataSource mapByPage(Function r100) {
        return mapByPage(r100);
    }

    public void initKeys(Key r100, Key r101) {
        Object r102 = this.mKeyLock;
        monitor-enter(r102);
        this.mPreviousKey = r100;     // Catch: Throwable -> L7
        this.mNextKey = r101;     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.paging.ContiguousDataSource
    public final void dispatchLoadAfter(int r100, Value r101, int r102, Executor r103, PageResult.Receiver<Value> r104) {
        Key r105 = getNextKey();
        if (r105 == null) goto L5;
        loadAfter(new LoadParams(r105, r102), new LoadCallbackImpl(this, 1, r103, r104));
        return;
    L5:
        r104.onPageResult(1, PageResult.getEmptyResult());
    }

    @Override // androidx.paging.ContiguousDataSource
    public final void dispatchLoadBefore(int r100, Value r101, int r102, Executor r103, PageResult.Receiver<Value> r104) {
        Key r105 = getPreviousKey();
        if (r105 == null) goto L5;
        loadBefore(new LoadParams(r105, r102), new LoadCallbackImpl(this, 2, r103, r104));
        return;
    L5:
        r104.onPageResult(2, PageResult.getEmptyResult());
    }

    @Override // androidx.paging.ContiguousDataSource
    public final void dispatchLoadInitial(Key r100, int r101, int r102, boolean r103, Executor r104, PageResult.Receiver<Value> r105) {
        LoadInitialCallbackImpl r106 = new LoadInitialCallbackImpl(this, r103, r105);
        loadInitial(new LoadInitialParams(r101, r103), r106);
        r106.mCallbackHelper.setPostExecutor(r104);
    }
}
