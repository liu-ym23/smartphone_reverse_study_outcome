package com.bytedance.android.ec.store.shopping.paging;

import androidx.paging.PositionalDataSource;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/store/shopping/paging/ListStatusPositionalDataSource;", "V", "Landroidx/paging/PositionalDataSource;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ListStatusPositionalDataSource<V> extends PositionalDataSource<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QLiveData<LoadStatus> f48579a;

    public boolean e() {
        return true;
    }

    public abstract void f(PositionalDataSource.LoadInitialParams r100, ListStatusPositionalLoadInitialCallback<V> r101);

    public abstract void g(PositionalDataSource.LoadRangeParams r100, ListStatusPositionalLoadRangeCallback<V> r101);

    public ListStatusPositionalDataSource(QLiveData<LoadStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "loadStatus");
        this.f48579a = r100;
    }

    @Override // androidx.paging.PositionalDataSource
    public final void loadInitial(PositionalDataSource.LoadInitialParams r100, PositionalDataSource.LoadInitialCallback<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f48579a.e(LoadStatus.Initialize);
        QLiveData<LoadStatus> r102 = this.f48579a;
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "loadStatus");
        f(r100, new ListStatusPositionalLoadInitialCallback(r101, r102));
    }

    @Override // androidx.paging.PositionalDataSource
    public final void loadRange(PositionalDataSource.LoadRangeParams r100, PositionalDataSource.LoadRangeCallback<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (e() == false) goto L5;
        this.f48579a.e(LoadStatus.LoadMoreIn);
    L5:
        QLiveData<LoadStatus> r102 = this.f48579a;
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "loadStatus");
        g(r100, new ListStatusPositionalLoadRangeCallback(r101, r102));
    }
}
