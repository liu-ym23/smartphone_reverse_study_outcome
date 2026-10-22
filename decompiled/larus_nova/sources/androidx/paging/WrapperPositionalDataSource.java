package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {
    final Function<List<A>, List<B>> mListFunction;
    private final PositionalDataSource<A> mSource;

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

    public WrapperPositionalDataSource(PositionalDataSource<A> r100, Function<List<A>, List<B>> r101) {
        this.mSource = r100;
        this.mListFunction = r101;
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadInitial(PositionalDataSource.LoadInitialParams r100, final PositionalDataSource.LoadInitialCallback<B> r101) {
        this.mSource.loadInitial(r100, new AnonymousClass1(this, r101));
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(PositionalDataSource.LoadRangeParams r100, final PositionalDataSource.LoadRangeCallback<B> r101) {
        this.mSource.loadRange(r100, new AnonymousClass2(this, r101));
    }
}
