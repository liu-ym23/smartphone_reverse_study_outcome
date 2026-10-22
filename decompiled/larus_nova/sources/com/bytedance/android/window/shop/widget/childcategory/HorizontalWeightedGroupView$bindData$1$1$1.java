package com.bytedance.android.window.shop.widget.childcategory;

import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryVO;", "p2", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class HorizontalWeightedGroupView$bindData$1$1$1 extends FunctionReferenceImpl implements Function2<WindowChildCategoryVO.ChildCategoryVO, Boolean, Unit> {
    public HorizontalWeightedGroupView$bindData$1$1$1(HorizontalWeightedGroupView r100) {
        super(2, r100, HorizontalWeightedGroupView.class, "onSelectionChanged", "onSelectionChanged(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryVO;Z)V", 0);
    }

    public final void invoke(WindowChildCategoryVO.ChildCategoryVO r100, boolean r101) {
        HorizontalWeightedGroupView r102 = (HorizontalWeightedGroupView) this.receiver;
        if (r101 == true) goto L7;
        HorizontalWeightedGroupView.d r103 = r102.f190001b;
        if (r103 == null) goto L23;
        r103.a(null);
        return;
    L23:
        return;
    L7:
        Iterator r104 = ((LinkedHashMap) r102.f190002c).entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L14;
        Map.Entry r105 = (Map.Entry) r104.next();
        WindowChildCategoryVO.ChildCategoryVO r106 = (WindowChildCategoryVO.ChildCategoryVO) r105.getKey();
        HorizontalWeightedGroupView.a r107 = (HorizontalWeightedGroupView.a) r105.getValue();
        if (Intrinsics.areEqual(r106, r100) == true) goto L9;
        r106.setSelected(false);
        r107.a(r106);
        goto L9
    L14:
        HorizontalWeightedGroupView.d r108 = r102.f190001b;
        if (r108 == null) goto L25;
        r108.a(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(WindowChildCategoryVO.ChildCategoryVO r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
