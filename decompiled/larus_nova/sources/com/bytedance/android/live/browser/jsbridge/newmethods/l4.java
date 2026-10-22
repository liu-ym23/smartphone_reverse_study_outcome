package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.bridge.method.abs.GetDownloadGiftAssetsResultModel;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l4 implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k4 f63542a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onProgress(int r100) {
    }

    public l4(k4 r100) {
        this.f63542a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r100) {
        k4 r101 = this.f63542a;
        GetDownloadGiftAssetsResultModel r102 = new GetDownloadGiftAssetsResultModel();
        r102.a(GetDownloadGiftAssetsResultModel.Code.Success);
        r102.c("cancel");
        GetDownloadGiftAssetsResultModel.a r103 = new GetDownloadGiftAssetsResultModel.a();
        r103.a(1);
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        k4 r101 = this.f63542a;
        GetDownloadGiftAssetsResultModel r102 = new GetDownloadGiftAssetsResultModel();
        r102.a(GetDownloadGiftAssetsResultModel.Code.Success);
        r102.c("failed, " + ExceptionsKt.stackTraceToString(r100));
        GetDownloadGiftAssetsResultModel.a r103 = new GetDownloadGiftAssetsResultModel.a();
        r103.a(2);
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "path");
        k4 r102 = this.f63542a;
        GetDownloadGiftAssetsResultModel r103 = new GetDownloadGiftAssetsResultModel();
        r103.a(GetDownloadGiftAssetsResultModel.Code.Success);
        r103.c("success");
        GetDownloadGiftAssetsResultModel.a r104 = new GetDownloadGiftAssetsResultModel.a();
        r104.a(0);
        r104.b(MSkiaImageRegionDecoder.FILE_PREFIX + r101);
        Unit r105 = Unit.INSTANCE;
        r103.b(r104);
        r102.finishWithResult(r103);
    }
}
