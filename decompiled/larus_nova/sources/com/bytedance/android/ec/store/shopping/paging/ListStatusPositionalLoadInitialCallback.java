package com.bytedance.android.ec.store.shopping.paging;

import androidx.paging.PositionalDataSource;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/store/shopping/paging/ListStatusPositionalLoadInitialCallback;", "V", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ListStatusPositionalLoadInitialCallback<V> extends PositionalDataSource.LoadInitialCallback<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionalDataSource.LoadInitialCallback<V> f48580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QLiveData<LoadStatus> f48581b;

    public final void a() {
        this.f48581b.e(LoadStatus.InitializeError);
    }

    public ListStatusPositionalLoadInitialCallback(PositionalDataSource.LoadInitialCallback<V> r100, QLiveData<LoadStatus> r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "loadStatus");
        this.f48580a = r100;
        this.f48581b = r101;
    }

    @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
    public final void onResult(List<V> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f48580a.onResult(r100, r101);
        if ((!r100.isEmpty()) == false) goto L5;
        this.f48581b.e(LoadStatus.InitializeSuccess);
        return;
    L5:
        this.f48581b.e(LoadStatus.InitializeEmpty);
    }

    @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
    public final void onResult(List<V> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f48580a.onResult(r100, r101, r102);
        if ((!r100.isEmpty()) == false) goto L5;
        this.f48581b.e(LoadStatus.InitializeSuccess);
        return;
    L5:
        this.f48581b.e(LoadStatus.InitializeEmpty);
    }
}
