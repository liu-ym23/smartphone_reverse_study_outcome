package com.bytedance.android.ec.window.base.product.presenter.element.price;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/widget/price/a;", "builder", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowV2ProductItemVO;", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/core/widget/price/a;Lcom/bytedance/android/ec/window/base/repository/vo/WindowV2ProductItemVO;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PricePostProcessKt$ShrinkYuanSymbolPricePostProcessor$1 extends Lambda implements Function2<com.bytedance.android.ec.core.widget.price.a, WindowV2ProductItemVO, Unit> {
    public static final PricePostProcessKt$ShrinkYuanSymbolPricePostProcessor$1 INSTANCE = null;

    static {
        INSTANCE = new PricePostProcessKt$ShrinkYuanSymbolPricePostProcessor$1();
    }

    public PricePostProcessKt$ShrinkYuanSymbolPricePostProcessor$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.ec.core.widget.price.a r100, WindowV2ProductItemVO r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.ec.core.widget.price.a r100, WindowV2ProductItemVO r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "<anonymous parameter 1>");
        r100.f46133j = 0.7222222f;
    }
}
