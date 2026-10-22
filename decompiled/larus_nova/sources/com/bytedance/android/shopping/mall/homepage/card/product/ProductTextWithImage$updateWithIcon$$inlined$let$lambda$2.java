package com.bytedance.android.shopping.mall.homepage.card.product;

import android.graphics.Bitmap;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ProductStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TagUIParams;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TextWithIconConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/mall/homepage/card/product/ProductTextWithImage$updateWithIcon$2$1"}, k = 3, mv = {1, 4, 3})
final class ProductTextWithImage$updateWithIcon$$inlined$let$lambda$2 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ TextWithIconConfig $config$inlined;
    final /* synthetic */ TagUIParams $iconParams;
    final /* synthetic */ Pair $imageMonitorTag$inlined;
    final /* synthetic */ ProductTextWithImage this$0;

    public ProductTextWithImage$updateWithIcon$$inlined$let$lambda$2(TagUIParams r100, ProductTextWithImage r101, TextWithIconConfig r102, Pair r103) {
        this.$iconParams = r100;
        this.this$0 = r101;
        this.$config$inlined = r102;
        this.$imageMonitorTag$inlined = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap r100) {
        this.this$0.getClass();
        if (r100 == null) goto L14;
        ProductStyle r101 = this.$iconParams.getStyle();
        Float r102 = null;
        if (r101 == null) goto L7;
        Float r103 = r101.getWidth();
    L8:
        ProductStyle r104 = this.$iconParams.getStyle();
        if (r104 == null) goto L11;
        r102 = r104.getHeight();
    L11:
        if (r103 == null) goto L14;
        if (r102 == null) goto L14;
        float r105 = r102.floatValue();
        ProductTextWithImage.A(this.this$0, r100, r103.floatValue(), r105);
        goto L14
    L7:
        r103 = null;
    L14:
        this.this$0.getClass();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
