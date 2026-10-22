package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/livecommerce/iron/ui/ECPromotionListHintBannerView$registerMissionCallback$1$3"}, k = 3, mv = {1, 4, 3})
final class ECPromotionListHintBannerView$registerMissionCallback$$inlined$let$lambda$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $originText$inlined;
    final /* synthetic */ int $replaceIndex$inlined;
    final /* synthetic */ ECPromotionListHintBannerView this$0;

    public ECPromotionListHintBannerView$registerMissionCallback$$inlined$let$lambda$3(ECPromotionListHintBannerView r100, int r101, String r102) {
        this.this$0 = r100;
        this.$replaceIndex$inlined = r101;
        this.$originText$inlined = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ECPromotionListHintBannerView r100 = this.this$0;
        int r101 = this.$replaceIndex$inlined;
        int r102 = ECPromotionListHintBannerView.f148900k;
        r100.f(r101);
        this.this$0.setVisibility(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
