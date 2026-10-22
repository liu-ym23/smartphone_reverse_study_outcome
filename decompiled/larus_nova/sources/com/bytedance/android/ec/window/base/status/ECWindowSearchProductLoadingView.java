package com.bytedance.android.ec.window.base.status;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/window/base/status/ECWindowSearchProductLoadingView;", "Lcom/bytedance/android/ec/window/base/status/ECWindowStatusStructView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSearchProductLoadingView extends ECWindowStatusStructView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f49684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f49685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f49686f;

    @Override // com.bytedance.android.ec.window.base.status.ECWindowStatusStructView
    public final b[][] a() {
        StructType r100 = StructType.PRODUCT_DOUBLE_LOADING;
        return new b[][]{new b[]{new b(r100, new a(this.f49682b, 0, this.f49683c, this.f49686f)), new b(r100, new a(this.f49682b, 0, this.f49683c, this.f49686f)), new b(r100, new a(this.f49682b, 0, this.f49683c, this.f49686f))}, new b[]{new b(r100, new a(this.f49684d, 0, this.f49685e, this.f49686f)), new b(r100, new a(this.f49684d, 0, this.f49685e, this.f49686f)), new b(r100, new a(this.f49684d, 0, this.f49685e, this.f49686f))}};
    }

    public ECWindowSearchProductLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f49682b = com.bytedance.android.shopping.extensions.b.b(12);
        Double r102 = Double.valueOf(4.5d);
        this.f49683c = com.bytedance.android.shopping.extensions.b.b(r102);
        this.f49684d = com.bytedance.android.shopping.extensions.b.b(r102);
        this.f49685e = com.bytedance.android.shopping.extensions.b.b(12);
        this.f49686f = com.bytedance.android.shopping.extensions.b.b(9);
    }
}
