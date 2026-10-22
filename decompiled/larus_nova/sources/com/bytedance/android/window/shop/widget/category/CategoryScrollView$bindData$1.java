package com.bytedance.android.window.shop.widget.category;

import android.content.res.Resources;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.x;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;", "<anonymous parameter 0>", "", "currentIndex", "width", "left", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;III)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CategoryScrollView$bindData$1 extends Lambda implements Function4<WindowProductCategoryVODeprecated.a, Integer, Integer, Integer, Unit> {
    final /* synthetic */ x $vo;
    final /* synthetic */ CategoryScrollView this$0;

    public CategoryScrollView$bindData$1(CategoryScrollView r100, x r101) {
        this.this$0 = r100;
        this.$vo = r101;
        super(4);
    }

    public final void invoke(WindowProductCategoryVODeprecated.a r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        this.$vo.f189642j = r101;
        CategoryScrollView r104 = this.this$0;
        int r105 = CategoryScrollView.f189975d;
        Resources r106 = r104.getResources();
        r104.smoothScrollTo(r103 - ((WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).widthPixels - r102) / 2), 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(WindowProductCategoryVODeprecated.a r100, Integer r101, Integer r102, Integer r103) {
        invoke(r100, r101.intValue(), r102.intValue(), r103.intValue());
        return Unit.INSTANCE;
    }
}
