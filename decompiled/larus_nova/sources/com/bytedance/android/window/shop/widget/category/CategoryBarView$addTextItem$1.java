package com.bytedance.android.window.shop.widget.category;

import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;", "p1", "", "p2", "p3", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;II)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CategoryBarView$addTextItem$1 extends FunctionReferenceImpl implements Function3<WindowProductCategoryVODeprecated.a, Integer, Integer, Unit> {
    public CategoryBarView$addTextItem$1(CategoryBarView r100) {
        super(3, r100, CategoryBarView.class, "notifyUpdated", "notifyUpdated(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$Category;II)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(WindowProductCategoryVODeprecated.a r100, Integer r101, Integer r102) {
        invoke(r100, r101.intValue(), r102.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(WindowProductCategoryVODeprecated.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        CategoryBarView.a((CategoryBarView) this.receiver, r100, r101, r102);
    }
}
