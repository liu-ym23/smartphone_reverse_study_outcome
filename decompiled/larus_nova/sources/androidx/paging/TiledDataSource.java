package androidx.paging;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public abstract class TiledDataSource<T> extends PositionalDataSource<T> {
    public abstract int countItems();

    @Override // androidx.paging.PositionalDataSource, androidx.paging.DataSource
    public boolean isContiguous() {
        return false;
    }

    public abstract List<T> loadRange(int r100, int r101);

    public TiledDataSource() {
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadInitial(PositionalDataSource.LoadInitialParams r100, PositionalDataSource.LoadInitialCallback<T> r101) {
        int r102 = countItems();
        if (r102 != 0) goto L6;
        r101.onResult(Collections.emptyList(), 0, 0);
        return;
    L6:
        int r103 = PositionalDataSource.computeInitialLoadPosition(r100, r102);
        int r104 = PositionalDataSource.computeInitialLoadSize(r100, r103, r102);
        List<T> r105 = loadRange(r103, r104);
        if (r105 != null) goto L9;
    L11:
        invalidate();
        return;
    L9:
        if (r105.size() != r104) goto L11;
        r101.onResult(r105, r103, r102);
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(PositionalDataSource.LoadRangeParams r100, PositionalDataSource.LoadRangeCallback<T> r101) {
        List<T> r102 = loadRange(r100.startPosition, r100.loadSize);
        if (r102 == null) goto L5;
        r101.onResult(r102);
        return;
    L5:
        invalidate();
    }
}
