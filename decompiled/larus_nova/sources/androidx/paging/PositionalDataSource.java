package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {

    public static class ContiguousWithoutPlaceholdersWrapper<Value> extends ContiguousDataSource<Integer, Value> {
        final PositionalDataSource<Value> mSource;

        @Override // androidx.paging.DataSource
        public void invalidate() {
            this.mSource.invalidate();
        }

        @Override // androidx.paging.DataSource
        public boolean isInvalid() {
            return this.mSource.isInvalid();
        }

        public ContiguousWithoutPlaceholdersWrapper(PositionalDataSource<Value> r100) {
            this.mSource = r100;
        }

        @Override // androidx.paging.DataSource
        public void addInvalidatedCallback(DataSource.InvalidatedCallback r100) {
            this.mSource.addInvalidatedCallback(r100);
        }

        @Override // androidx.paging.DataSource
        public <ToValue> DataSource<Integer, ToValue> map(Function<Value, ToValue> r100) {
            throw new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        }

        @Override // androidx.paging.DataSource
        public <ToValue> DataSource<Integer, ToValue> mapByPage(Function<List<Value>, List<ToValue>> r100) {
            throw new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        }

        @Override // androidx.paging.DataSource
        public void removeInvalidatedCallback(DataSource.InvalidatedCallback r100) {
            this.mSource.removeInvalidatedCallback(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.paging.ContiguousDataSource
        public Integer getKey(int r100, Value r101) {
            return Integer.valueOf(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.paging.ContiguousDataSource
        public /* bridge */ /* synthetic */ Integer getKey(int r100, Object r101) {
            return getKey(r100, r101);
        }

        @Override // androidx.paging.ContiguousDataSource
        public void dispatchLoadAfter(int r100, Value r101, int r102, Executor r110, PageResult.Receiver<Value> r111) {
            PositionalDataSource<Value> r103 = this.mSource;
            r103.dispatchLoadRange(1, r100 + 1, r102, r110, r111);
        }

        @Override // androidx.paging.ContiguousDataSource
        public void dispatchLoadBefore(int r110, Value r111, int r112, Executor r113, PageResult.Receiver<Value> r114) {
            int r100 = r110 - 1;
            if (r100 >= 0) goto L5;
            this.mSource.dispatchLoadRange(2, r100, 0, r113, r114);
            return;
        L5:
            int r101 = Math.min(r112, r100 + 1);
            this.mSource.dispatchLoadRange(2, (r100 - r101) + 1, r101, r113, r114);
        }

        /* JADX INFO: renamed from: dispatchLoadInitial, reason: avoid collision after fix types in other method */
        public void dispatchLoadInitial2(Integer r100, int r101, int r110, boolean r111, Executor r112, PageResult.Receiver<Value> r113) {
            if (r100 != null) goto L5;
            Integer r102 = 0;
        L6:
            PositionalDataSource<Value> r103 = this.mSource;
            int r104 = r102.intValue();
            r103.dispatchLoadInitial(false, r104, r101, r110, r112, r113);
            return;
        L5:
            r101 = Math.max(r101 / r110, 2) * r110;
            r102 = Integer.valueOf(Math.max(0, ((r100.intValue() - (r101 / 2)) / r110) * r110));
            goto L6
        }

        @Override // androidx.paging.ContiguousDataSource
        public /* bridge */ /* synthetic */ void dispatchLoadInitial(Integer r100, int r101, int r102, boolean r103, Executor r104, PageResult.Receiver r105) {
            dispatchLoadInitial2(r100, r101, r102, r103, r104, r105);
        }
    }

    public static abstract class LoadInitialCallback<T> {
        public LoadInitialCallback() {
        }

        public abstract void onResult(List<T> r100, int r101);

        public abstract void onResult(List<T> r100, int r101, int r102);
    }

    public static class LoadInitialCallbackImpl<T> extends LoadInitialCallback<T> {
        final DataSource.LoadCallbackHelper<T> mCallbackHelper;
        private final boolean mCountingEnabled;
        private final int mPageSize;

        @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
        public void onResult(List<T> r100, int r101) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L18;
            if (r101 < 0) goto L17;
            if (r100.isEmpty() == false) goto L12;
            if (r101 == 0) goto L12;
            throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
        L12:
            if (this.mCountingEnabled == true) goto L15;
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, r101));
            return;
        L15:
            throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
        L17:
            throw new IllegalArgumentException("Position must be non-negative");
        }

        @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
        public void onResult(List<T> r100, int r101, int r102) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L16;
            DataSource.LoadCallbackHelper.validateInitialLoadParams(r100, r101, r102);
            if ((r100.size() + r101) == r102) goto L12;
            if ((r100.size() % this.mPageSize) == 0) goto L12;
            throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + r100.size() + ", position " + r101 + ", totalCount " + r102 + ", pageSize " + this.mPageSize);
        L12:
            if (this.mCountingEnabled == false) goto L14;
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, r101, (r102 - r101) - r100.size(), 0));
            return;
        L14:
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, r101));
            return;
        }

        public LoadInitialCallbackImpl(PositionalDataSource r100, boolean r101, int r102, PageResult.Receiver<T> r103) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper(r100, 0, null, r103);
            this.mCountingEnabled = r101;
            this.mPageSize = r102;
            if (r102 < 1) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Page size must be non-negative");
        }
    }

    public static class LoadInitialParams {
        public final int pageSize;
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;
        public final int requestedStartPosition;

        public LoadInitialParams(int r100, int r101, int r102, boolean r103) {
            this.requestedStartPosition = r100;
            this.requestedLoadSize = r101;
            this.pageSize = r102;
            this.placeholdersEnabled = r103;
        }
    }

    public static abstract class LoadRangeCallback<T> {
        public LoadRangeCallback() {
        }

        public abstract void onResult(List<T> r100);
    }

    public static class LoadRangeCallbackImpl<T> extends LoadRangeCallback<T> {
        private DataSource.LoadCallbackHelper<T> mCallbackHelper;
        private final int mPositionOffset;

        @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
        public void onResult(List<T> r100) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid() == true) goto L6;
            this.mCallbackHelper.dispatchResultToReceiver(new PageResult(r100, 0, 0, this.mPositionOffset));
            return;
        }

        public LoadRangeCallbackImpl(PositionalDataSource r100, int r101, int r102, Executor r103, PageResult.Receiver<T> r104) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper(r100, r101, r103, r104);
            this.mPositionOffset = r102;
        }
    }

    public static class LoadRangeParams {
        public final int loadSize;
        public final int startPosition;

        public LoadRangeParams(int r100, int r101) {
            this.startPosition = r100;
            this.loadSize = r101;
        }
    }

    @Override // androidx.paging.DataSource
    public boolean isContiguous() {
        return false;
    }

    public abstract void loadInitial(LoadInitialParams r100, LoadInitialCallback<T> r101);

    public abstract void loadRange(LoadRangeParams r100, LoadRangeCallback<T> r101);

    public ContiguousDataSource<Integer, T> wrapAsContiguousWithoutPlaceholders() {
        return new ContiguousWithoutPlaceholdersWrapper(this);
    }

    public PositionalDataSource() {
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(Function<T, V> r100) {
        return mapByPage(DataSource.createListFunction(r100));
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> mapByPage(Function<List<T>, List<V>> r100) {
        return new WrapperPositionalDataSource(this, r100);
    }

    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ DataSource map(Function r100) {
        return map(r100);
    }

    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ DataSource mapByPage(Function r100) {
        return mapByPage(r100);
    }

    public static int computeInitialLoadPosition(LoadInitialParams r100, int r101) {
        int r102 = r100.requestedStartPosition;
        int r103 = r100.requestedLoadSize;
        int r104 = r100.pageSize;
        return Math.max(0, Math.min(((((r101 - r103) + r104) - 1) / r104) * r104, (r102 / r104) * r104));
    }

    public static int computeInitialLoadSize(LoadInitialParams r100, int r101, int r102) {
        return Math.min(r102 - r101, r100.requestedLoadSize);
    }

    public final void dispatchLoadRange(int r100, int r101, int r110, Executor r111, PageResult.Receiver<T> r112) {
        LoadRangeCallbackImpl r102 = new LoadRangeCallbackImpl(this, r100, r101, r111, r112);
        if (r110 != 0) goto L5;
        r102.onResult(Collections.emptyList());
        return;
    L5:
        loadRange(new LoadRangeParams(r101, r110), r102);
    }

    public final void dispatchLoadInitial(boolean r100, int r101, int r102, int r103, Executor r104, PageResult.Receiver<T> r105) {
        LoadInitialCallbackImpl r106 = new LoadInitialCallbackImpl(this, r100, r103, r105);
        loadInitial(new LoadInitialParams(r101, r102, r103, r100), r106);
        r106.mCallbackHelper.setPostExecutor(r104);
    }
}
