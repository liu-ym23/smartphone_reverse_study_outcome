package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class WrapperPageKeyedDataSource<K, A, B> extends PageKeyedDataSource<K, B> {
    final Function<List<A>, List<B>> mListFunction;
    private final PageKeyedDataSource<K, A> mSource;

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

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback r100) {
        this.mSource.removeInvalidatedCallback(r100);
    }

    public WrapperPageKeyedDataSource(PageKeyedDataSource<K, A> r100, Function<List<A>, List<B>> r101) {
        this.mSource = r100;
        this.mListFunction = r101;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(PageKeyedDataSource.LoadParams<K> r100, final PageKeyedDataSource.LoadCallback<K, B> r101) {
        this.mSource.loadAfter(r100, new AnonymousClass3(this, r101));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(PageKeyedDataSource.LoadParams<K> r100, final PageKeyedDataSource.LoadCallback<K, B> r101) {
        this.mSource.loadBefore(r100, new AnonymousClass2(this, r101));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(PageKeyedDataSource.LoadInitialParams<K> r100, final PageKeyedDataSource.LoadInitialCallback<K, B> r101) {
        this.mSource.loadInitial(r100, new AnonymousClass1(this, r101));
    }
}
