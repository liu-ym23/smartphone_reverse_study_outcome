package com.bytedance.android.shopping.store.status;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.store.status.ECStatusStructView;
import com.bytedance.android.ec.store.status.StructType;
import com.bytedance.android.ec.store.status.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/status/ECStoreFrameLoadingView;", "Lcom/bytedance/android/ec/store/status/ECStatusStructView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreFrameLoadingView extends ECStatusStructView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f186429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f186430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f186431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f186432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f186433f;

    @Override // com.bytedance.android.ec.store.status.ECStatusStructView
    public final e[][] a() {
        StructType r100 = StructType.SORT_BAR_LOADING;
        int r101 = this.f186430c;
        StructType r102 = StructType.PRODUCT_LOADING;
        int r103 = this.f186432e;
        int r104 = this.f186432e;
        return new e[][]{new e[]{new e(StructType.TOP_BAR_LOADING, new com.bytedance.android.ec.store.status.a(0, this.f186429b, 0, 0), 2), new e(StructType.STORE_INFO_LOADING, null, 6), new e(r100, new com.bytedance.android.ec.store.status.a(r101, this.f186431d, r101, 0), 2), new e(r102, new com.bytedance.android.ec.store.status.a(r103, this.f186433f, r103, 0), 2), new e(r102, new com.bytedance.android.ec.store.status.a(r104, this.f186433f, r104, 0), 2)}};
    }

    public ECStoreFrameLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f186429b = com.bytedance.android.shopping.extensions.b.b(44);
        this.f186430c = com.bytedance.android.shopping.extensions.b.b(8);
        this.f186431d = com.bytedance.android.shopping.extensions.b.b(11);
        this.f186432e = com.bytedance.android.shopping.extensions.b.b(8);
        this.f186433f = com.bytedance.android.shopping.extensions.b.b(12);
    }
}
