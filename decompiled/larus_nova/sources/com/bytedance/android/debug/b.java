package com.bytedance.android.debug;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.resources.f f42609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.f f42610b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r100) {
        ALogger.i("LiveAnchorPushStreamMockManager", "downloadAssetByUrlNoCache#onCancel " + r100);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r101 = this.f42610b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        ALogger.i("GiftPreviewAutoTest", "downloadAssetByUrlNoCache#onFailed " + r100.getMessage());
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r101 = this.f42610b;
        if (r101 == null) goto L6;
        r101.onFailed(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onProgress(int r100) {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r101 = this.f42610b;
        if (r101 == null) goto L6;
        r101.onProgress(r100);
        return;
    }

    public b(com.bytedance.android.live.core.resources.f r100, f r101) {
        this.f42609a = r100;
        this.f42610b = r101;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "path");
        ALogger.i("LiveAnchorPushStreamMockManager", "downloadAssetByUrlNoCache#onResult " + this.f42609a);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r102 = this.f42610b;
        if (r102 == null) goto L5;
        r102.c(r100, r101);
    L5:
        String r103 = this.f42609a.getMD5();
        if (r103 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.core.b.b(r103);
        return;
    }
}
