package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {
    private final IdentityHashMap<B, K> mKeyMap;
    final Function<List<A>, List<B>> mListFunction;
    private final ItemKeyedDataSource<K, A> mSource;

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.mSource.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.mSource.isInvalid();
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback r100) {
        this.mSource.addInvalidatedCallback(r100);
    }

    public List<B> convertWithStashedKeys(List<A> r100) {
        List<B> r101 = DataSource.convert(this.mListFunction, r100);
        IdentityHashMap<B, K> r102 = this.mKeyMap;
        monitor-enter(r102);
        int r103 = 0;
    L13:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r103 >= r101.size()) goto L8;
        this.mKeyMap.put(r101.get(r103), this.mSource.getKey(r100.get(r103)));     // Catch: Throwable -> L10
        r103 = r103 + 1;     // Catch: Throwable -> L10
        goto L13
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L10
        return r101;
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public K getKey(B r100) {
        IdentityHashMap<B, K> r101 = this.mKeyMap;
        monitor-enter(r101);
        K r102 = this.mKeyMap.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback r100) {
        this.mSource.removeInvalidatedCallback(r100);
    }

    public WrapperItemKeyedDataSource(ItemKeyedDataSource<K, A> r100, Function<List<A>, List<B>> r101) {
        this.mKeyMap = new IdentityHashMap();
        this.mSource = r100;
        this.mListFunction = r101;
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadAfter(ItemKeyedDataSource.LoadParams<K> r100, final ItemKeyedDataSource.LoadCallback<B> r101) {
        this.mSource.loadAfter(r100, new AnonymousClass2(this, r101));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadBefore(ItemKeyedDataSource.LoadParams<K> r100, final ItemKeyedDataSource.LoadCallback<B> r101) {
        this.mSource.loadBefore(r100, new AnonymousClass3(this, r101));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadInitial(ItemKeyedDataSource.LoadInitialParams<K> r100, final ItemKeyedDataSource.LoadInitialCallback<B> r101) {
        this.mSource.loadInitial(r100, new AnonymousClass1(this, r101));
    }
}
