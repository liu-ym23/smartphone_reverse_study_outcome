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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/status/ECStoreProductDoubleLoadingView;", "Lcom/bytedance/android/ec/store/status/ECStatusStructView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreProductDoubleLoadingView extends ECStatusStructView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f186434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f186435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f186436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f186437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f186438f;

    @Override // com.bytedance.android.ec.store.status.ECStatusStructView
    public final e[][] a() {
        StructType r100 = StructType.PRODUCT_DOUBLE_LOADING;
        return new e[][]{new e[]{new e(r100, new com.bytedance.android.ec.store.status.a(this.f186434b, 0, this.f186435c, this.f186438f), 2), new e(r100, new com.bytedance.android.ec.store.status.a(this.f186434b, 0, this.f186435c, this.f186438f), 2), new e(r100, new com.bytedance.android.ec.store.status.a(this.f186434b, 0, this.f186435c, this.f186438f), 2)}, new e[]{new e(r100, new com.bytedance.android.ec.store.status.a(this.f186436d, 0, this.f186437e, this.f186438f), 2), new e(r100, new com.bytedance.android.ec.store.status.a(this.f186436d, 0, this.f186437e, this.f186438f), 2), new e(r100, new com.bytedance.android.ec.store.status.a(this.f186436d, 0, this.f186437e, this.f186438f), 2)}};
    }

    public ECStoreProductDoubleLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f186434b = com.bytedance.android.shopping.extensions.b.b(12);
        Double r102 = Double.valueOf(4.5d);
        this.f186435c = com.bytedance.android.shopping.extensions.b.b(r102);
        this.f186436d = com.bytedance.android.shopping.extensions.b.b(r102);
        this.f186437e = com.bytedance.android.shopping.extensions.b.b(12);
        this.f186438f = com.bytedance.android.shopping.extensions.b.b(9);
    }
}
