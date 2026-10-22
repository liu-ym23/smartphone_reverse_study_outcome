package com.bytedance.android.window.shop.innerflow.util;

import android.content.Context;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "skuCartResult", "Lcom/bytedance/android/ec/model/sku/SkuCartResult;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/window/shop/innerflow/util/WindowShoppingCartUtil$addProductToCart$2$2"}, k = 3, mv = {1, 4, 3})
final class WindowShoppingCartUtil$addProductToCart$$inlined$let$lambda$1 extends Lambda implements Function1<SkuCartResult, Unit> {
    final /* synthetic */ Function1 $addCartListener$inlined;
    final /* synthetic */ String $btmPageId$inlined;
    final /* synthetic */ Function3 $cartListener$inlined;
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ WindowV2ProductItemVO $currentItem$inlined;
    final /* synthetic */ Map $eventParams$inlined;
    final /* synthetic */ a.C2759a $param$inlined;
    final /* synthetic */ String $searchParam$inlined;

    public WindowShoppingCartUtil$addProductToCart$$inlined$let$lambda$1(a.C2759a r100, WindowV2ProductItemVO r101, Map r102, String r103, Function3 r104, Context r105, String r106, Function1 r107) {
        this.$currentItem$inlined = r101;
        this.$eventParams$inlined = r102;
        this.$searchParam$inlined = r103;
        this.$cartListener$inlined = r104;
        this.$context$inlined = r105;
        this.$btmPageId$inlined = r106;
        this.$addCartListener$inlined = r107;
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
