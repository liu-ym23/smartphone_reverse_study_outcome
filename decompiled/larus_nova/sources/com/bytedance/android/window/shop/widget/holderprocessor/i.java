package com.bytedance.android.window.shop.widget.holderprocessor;

import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends gr3.d {
    public i() {
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r100, com.bytedance.android.window.shop.repository.tab.entity.f r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "vo");
        if ((r100 instanceof WindowLynxHolder) == false) goto L12;
        WindowLynxHolder r103 = (WindowLynxHolder) r100;
        ViewGroup.LayoutParams r104 = r103.itemView.getLayoutParams();
        if ((r104 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L7;
        r104 = null;
    L7:
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r104;
        if (r105 != null) goto L10;
        r105 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
    L10:
        r105.setFullSpan(r103.s4());
        r103.itemView.setLayoutParams(r105);
        return;
    }
}
