package com.bytedance.android.ec.store.status;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/store/status/ECStoreSearchProductLoadingView;", "Lcom/bytedance/android/ec/store/status/ECStatusStructView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreSearchProductLoadingView extends ECStatusStructView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f48632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f48633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f48634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f48635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f48636f;

    @Override // com.bytedance.android.ec.store.status.ECStatusStructView
    public final e[][] a() {
        StructType r100 = StructType.PRODUCT_DOUBLE_LOADING;
        return new e[][]{new e[]{new e(r100, new a(this.f48632b, 0, this.f48633c, this.f48636f), 2), new e(r100, new a(this.f48632b, 0, this.f48633c, this.f48636f), 2), new e(r100, new a(this.f48632b, 0, this.f48633c, this.f48636f), 2)}, new e[]{new e(r100, new a(this.f48634d, 0, this.f48635e, this.f48636f), 2), new e(r100, new a(this.f48634d, 0, this.f48635e, this.f48636f), 2), new e(r100, new a(this.f48634d, 0, this.f48635e, this.f48636f), 2)}};
    }

    public ECStoreSearchProductLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f48632b = com.bytedance.android.shopping.extensions.b.b(12);
        Double r102 = Double.valueOf(4.5d);
        this.f48633c = com.bytedance.android.shopping.extensions.b.b(r102);
        this.f48634d = com.bytedance.android.shopping.extensions.b.b(r102);
        this.f48635e = com.bytedance.android.shopping.extensions.b.b(12);
        this.f48636f = com.bytedance.android.shopping.extensions.b.b(9);
    }
}
