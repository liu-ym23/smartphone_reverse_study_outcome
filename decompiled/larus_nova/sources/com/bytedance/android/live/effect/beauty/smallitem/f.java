package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements com.bytedance.android.live.effect.api.k.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f67693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f67694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.effect.api.j f67695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WeakReference f67696d;

    @Override // com.bytedance.android.live.effect.api.k.c
    public final void onFetchFailed() {
        ALogger.i("ttlive_anchor_effect_LiveBeautyMultiCategoryHelper", "on getCatetoryInfo fail");
        WeakReference r100 = this.f67696d;
        if (r100 == null) goto L8;
        b r101 = (b) r100.get();
        if (r101 == null) goto L9;
        r101.onError();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.c
    public final void a(CategoryInfoModelList r100, EffectDataFetchCacheType r101) {
        Intrinsics.checkNotNullParameter(r100, "categoryInfoModelList");
        Intrinsics.checkNotNullParameter(r101, "cacheType");
        List<EffectCategoryModel> r102 = r100.getCategoryList();
        if (r102 == null) goto L9;
        this.f67693a.f67669a.put(this.f67694b, r102);
        this.f67693a.b(this.f67694b, r102, this.f67695c, null);
        WeakReference r103 = this.f67696d;
        if (r103 == null) goto L9;
        b r104 = (b) r103.get();
        if (r104 == null) goto L9;
        r104.onSuccess(r102);
    L9:
        ALogger.i("ttlive_anchor_effect_LiveBeautyMultiCategoryHelper", "on getCatetoryInfo FetchSuccess");
    }

    public f(d r100, String r101, com.bytedance.android.live.effect.api.j r102, WeakReference r103) {
        this.f67693a = r100;
        this.f67694b = r101;
        this.f67695c = r102;
        this.f67696d = r103;
    }
}
