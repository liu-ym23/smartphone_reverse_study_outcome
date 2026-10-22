package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.live.browser.jsbridge.base.RevenueRequestStickerEffectStatusResultModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"onFail", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GiftEffectCloseRequestMethod$invoke$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ f this$0;

    public GiftEffectCloseRequestMethod$invoke$2(f r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RevenueRequestStickerEffectStatusResultModel r100 = new RevenueRequestStickerEffectStatusResultModel();
        RevenueRequestStickerEffectStatusResultModel.a r101 = new RevenueRequestStickerEffectStatusResultModel.a();
        r101.a(Boolean.FALSE);
        r101.b("");
        Unit r102 = Unit.INSTANCE;
        r100.b(r101);
        r100.a(RevenueRequestStickerEffectStatusResultModel.Code.Failed);
        this.this$0.finishWithResult(r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
