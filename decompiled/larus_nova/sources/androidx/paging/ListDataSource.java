package androidx.paging;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class ListDataSource<T> extends PositionalDataSource<T> {
    private final List<T> mList;

    public ListDataSource(List<T> r100) {
        this.mList = new ArrayList(r100);
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadInitial(PositionalDataSource.LoadInitialParams r100, PositionalDataSource.LoadInitialCallback<T> r101) {
        int r102 = this.mList.size();
        int r103 = PositionalDataSource.computeInitialLoadPosition(r100, r102);
        int r104 = PositionalDataSource.computeInitialLoadSize(r100, r103, r102);
        r101.onResult(this.mList.subList(r103, r104 + r103), r103, r102);
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(PositionalDataSource.LoadRangeParams r100, PositionalDataSource.LoadRangeCallback<T> r101) {
        List<T> r102 = this.mList;
        int r103 = r100.startPosition;
        r101.onResult(r102.subList(r103, r100.loadSize + r103));
    }
}
