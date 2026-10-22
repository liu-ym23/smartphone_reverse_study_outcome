package com.bytedance.android.ec.store.common.starter;

import android.app.Activity;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.window.WindowEntranceInfoScene;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "skuCartResult", "Lcom/bytedance/android/ec/model/sku/SkuCartResult;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/ec/store/common/starter/ECShopAddCartStarter$addToCart$2$2"}, k = 3, mv = {1, 4, 3})
final class ECShopAddCartStarter$addToCart$$inlined$let$lambda$1 extends Lambda implements Function1<SkuCartResult, Unit> {
    final /* synthetic */ Function1 $addCartListener$inlined;
    final /* synthetic */ com.bytedance.android.btm.api.model.d $btmModel$inlined;
    final /* synthetic */ String $btmPageId$inlined;
    final /* synthetic */ Function3 $cartListener$inlined;
    final /* synthetic */ Activity $context$inlined;
    final /* synthetic */ StoreV2ProductItemVO $currentItem$inlined;
    final /* synthetic */ WindowEntranceInfoScene $entranceInfoScene$inlined;
    final /* synthetic */ d $require$inlined;
    final /* synthetic */ a this$0;

    public ECShopAddCartStarter$addToCart$$inlined$let$lambda$1(a r100, d r101, Activity r102, StoreV2ProductItemVO r103, WindowEntranceInfoScene r104, Function3 r105, com.bytedance.android.btm.api.model.d r106, String r107, Function1 r108) {
        this.this$0 = r100;
        this.$context$inlined = r102;
        this.$currentItem$inlined = r103;
        this.$entranceInfoScene$inlined = r104;
        this.$cartListener$inlined = r105;
        this.$btmModel$inlined = r106;
        this.$btmPageId$inlined = r107;
        this.$addCartListener$inlined = r108;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SkuCartResult r100) {
        Intrinsics.checkNotNullParameter(r100, "skuCartResult");
        Function3 r101 = this.$cartListener$inlined;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(r100.getSpec(), r100.getSkuId(), Long.valueOf(r100.getComboNum()));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SkuCartResult r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
