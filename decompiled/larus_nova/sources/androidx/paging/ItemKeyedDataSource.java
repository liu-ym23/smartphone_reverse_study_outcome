package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ItemKeyedDataSource<Key, Value> extends ContiguousDataSource<Key, Value> {

    public static abstract class LoadCallback<Value> {
        public LoadCallback() {
        }

        public abstract void onResult(List<Value> r100);
    }

    public static class LoadCallbackImpl<Value> extends LoadCallback<Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;

        @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
        public void onResult(List<Value> r100) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L6;
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, 0, 0, 0));
            return;
        }

        public LoadCallbackImpl(ItemKeyedDataSource r100, int r101, Executor r102, PageResult.Receiver<Value> r103) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper(r100, r101, r102, r103);
        }
    }

    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
        public abstract void onResult(List<Value> r100, int r101, int r102);

        public LoadInitialCallback() {
        }
    }

    public static class LoadInitialCallbackImpl<Value> extends LoadInitialCallback<Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;
        private final boolean mCountingEnabled;

        @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
        public void onResult(List<Value> r100) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L6;
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, 0, 0, 0));
            return;
        }

        public LoadInitialCallbackImpl(ItemKeyedDataSource r100, boolean r101, PageResult.Receiver<Value> r102) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper(r100, 0, null, r102);
            this.mCountingEnabled = r101;
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
        public void onResult(List<Value> r100, int r101, int r102) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L9;
            DataSource.LoadCallbackHelper.validateInitialLoadParams(r100, r101, r102);
            int r103 = (r102 - r101) - r100.size();
            if (this.mCountingEnabled == false) goto L7;
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, r101, r103, 0));
            return;
        L7:
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, r101));
            return;
        }
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final Key requestedInitialKey;
        public final int requestedLoadSize;

        public LoadInitialParams(Key r100, int r101, boolean r102) {
            this.requestedInitialKey = r100;
            this.requestedLoadSize = r101;
            this.placeholdersEnabled = r102;
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

    public abstract Key getKey(Value r100);

    public abstract void loadAfter(LoadParams<Key> r100, LoadCallback<Value> r101);

    public abstract void loadBefore(LoadParams<Key> r100, LoadCallback<Value> r101);

    public abstract void loadInitial(LoadInitialParams<Key> r100, LoadInitialCallback<Value> r101);

    public ItemKeyedDataSource() {
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(Function<Value, ToValue> r100) {
        return mapByPage(DataSource.createListFunction(r100));
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> r100) {
        return new WrapperItemKeyedDataSource(this, r100);
    }

    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ DataSource map(Function r100) {
        return map(r100);
    }

    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ DataSource mapByPage(Function r100) {
        return mapByPage(r100);
    }

    @Override // androidx.paging.ContiguousDataSource
    public final Key getKey(int r100, Value r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return getKey(r101);
    }

    @Override // androidx.paging.ContiguousDataSource
    public final void dispatchLoadAfter(int r100, Value r101, int r102, Executor r103, PageResult.Receiver<Value> r104) {
        loadAfter(new LoadParams(getKey(r101), r102), new LoadCallbackImpl(this, 1, r103, r104));
    }

    @Override // androidx.paging.ContiguousDataSource
    public final void dispatchLoadBefore(int r100, Value r101, int r102, Executor r103, PageResult.Receiver<Value> r104) {
        loadBefore(new LoadParams(getKey(r101), r102), new LoadCallbackImpl(this, 2, r103, r104));
    }

    @Override // androidx.paging.ContiguousDataSource
    public final void dispatchLoadInitial(Key r100, int r101, int r102, boolean r103, Executor r104, PageResult.Receiver<Value> r105) {
        LoadInitialCallbackImpl r106 = new LoadInitialCallbackImpl(this, r103, r105);
        loadInitial(new LoadInitialParams(r100, r101, r103), r106);
        r106.mCallbackHelper.setPostExecutor(r104);
    }
}
