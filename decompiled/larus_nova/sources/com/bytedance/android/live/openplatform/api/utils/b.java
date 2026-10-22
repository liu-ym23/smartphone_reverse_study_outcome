package com.bytedance.android.live.openplatform.api.utils;

import com.bytedance.android.livesdk.config.r;
import com.bytedance.android.livesdkapi.model.ProductShelfExperimentConfig;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f84002b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductShelfExperimentConfig f84003a;

    public static final class a {
    }

    static {
        f84002b = new b();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean a() {
        return this.f84003a.getProductCourseNumShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean b() {
        return this.f84003a.getProductGiveawayShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean c() {
        return this.f84003a.getProductImgShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean d() {
        return this.f84003a.getProductListShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean e() {
        return this.f84003a.getProductPriceShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean f() {
        return this.f84003a.getProductTitleShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean g() {
        return this.f84003a.getProductValidityShow();
    }

    public b() {
        this.f84003a = r.f121095a.getValue();
    }
}
