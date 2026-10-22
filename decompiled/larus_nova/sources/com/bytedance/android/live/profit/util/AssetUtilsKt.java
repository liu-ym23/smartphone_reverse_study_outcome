package com.bytedance.android.live.profit.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class AssetUtilsKt {

    public static final class a implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAssetsManager f89075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f89076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f89077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f89078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function2 f89079e;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r100) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r100) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r100) {
            this.f89077c.invoke(new Error("download asset cancelled"));
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            this.f89077c.invoke(r100);
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "path");
            com.bytedance.android.live.core.resources.e r102 = this.f89075a.G1(this.f89076b);
            if (r102 != null) goto L7;
            this.f89077c.invoke(new UnknownError("asset success callback but still null"));
            return;
        L7:
            if (r102.getResourceType() == this.f89078d) goto L10;
            this.f89077c.invoke(new Error("invalid resource type"));
            return;
        L10:
            this.f89079e.invoke(r101, Boolean.FALSE);
        }

        public a(IAssetsManager r100, long r101, Function1 r102, int r103, Function2 r104) {
            this.f89075a = r100;
            this.f89076b = r101;
            this.f89077c = r102;
            this.f89078d = r103;
            this.f89079e = r104;
        }
    }

    public static final void a(IAssetsManager r100, final long r110, int r111, int r112, final Function2<? super Result<String>, ? super Boolean, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, "assetManager");
        Intrinsics.checkNotNullParameter(r113, "callback");
        ALogger.i("ProfitAssetUtil", "loading asset: assetId=" + r110);
        Function1<Throwable, Unit> r101 = new AssetUtilsKt$loadEffectAsset$failed$1(r110, r113);
        Function2<String, Boolean, Unit> r102 = new AssetUtilsKt$loadEffectAsset$succeed$1(r110, r113);
        if (r110 > 0) goto L6;
        r101.invoke(new Error("invalid assetId: assetId=" + r110));
        return;
    L6:
        com.bytedance.android.live.core.resources.e r114 = r100.G1(r110);
        if (r114 != null) goto L10;
        r101.invoke(new Error("asset not found: assetId=" + r110));
        return;
    L10:
        String r103 = r100.H0(r110);
        if (r103 == null) goto L14;
        r102.invoke(r103, Boolean.TRUE);
        return;
    L14:
        r100.Ne(r114, new a(r100, r110, r101, r111, r102), r112);
    }
}
