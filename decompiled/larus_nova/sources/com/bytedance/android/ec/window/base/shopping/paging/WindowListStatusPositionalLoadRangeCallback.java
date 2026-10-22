package com.bytedance.android.ec.window.base.shopping.paging;

import androidx.paging.PositionalDataSource;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/window/base/shopping/paging/WindowListStatusPositionalLoadRangeCallback;", "V", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WindowListStatusPositionalLoadRangeCallback<V> extends PositionalDataSource.LoadRangeCallback<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionalDataSource.LoadRangeCallback<V> f49671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QLiveData<WindowLoadStatus> f49672b;

    @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
    public final void onResult(List<V> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f49671a.onResult(r100);
        if ((!r100.isEmpty()) == false) goto L5;
        this.f49672b.e(WindowLoadStatus.LoadMoreSuccess);
        return;
    L5:
        this.f49672b.e(WindowLoadStatus.LoadMoreEnd);
    }

    public WindowListStatusPositionalLoadRangeCallback(PositionalDataSource.LoadRangeCallback<V> r100, QLiveData<WindowLoadStatus> r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "loadStatus");
        this.f49671a = r100;
        this.f49672b = r101;
    }
}
