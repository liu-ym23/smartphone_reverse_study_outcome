package com.bytedance.android.window.shop.holder;

import android.view.View;
import com.bytedance.android.window.shop.repository.tab.entity.x;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "scrollX", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class WindowProductCategoryHolder$bindActually$1 extends Lambda implements Function5<View, Integer, Integer, Integer, Integer, Unit> {
    final /* synthetic */ x $vo;

    public WindowProductCategoryHolder$bindActually$1(x r100) {
        this.$vo = r100;
        super(5);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Unit invoke(View r100, Integer r101, Integer r102, Integer r110, Integer r111) {
        invoke(r100, r101.intValue(), r102.intValue(), r110.intValue(), r111.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        this.$vo.getClass();
    }
}
