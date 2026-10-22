package androidx.paging;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
abstract class ContiguousDataSource<Key, Value> extends DataSource<Key, Value> {
    public abstract void dispatchLoadAfter(int r100, Value r101, int r102, Executor r103, PageResult.Receiver<Value> r104);

    public abstract void dispatchLoadBefore(int r100, Value r101, int r102, Executor r103, PageResult.Receiver<Value> r104);

    public abstract void dispatchLoadInitial(Key r100, int r101, int r102, boolean r103, Executor r104, PageResult.Receiver<Value> r105);

    public abstract Key getKey(int r100, Value r101);

    @Override // androidx.paging.DataSource
    public boolean isContiguous() {
        return true;
    }

    public boolean supportsPageDropping() {
        return true;
    }

    public ContiguousDataSource() {
    }
}
