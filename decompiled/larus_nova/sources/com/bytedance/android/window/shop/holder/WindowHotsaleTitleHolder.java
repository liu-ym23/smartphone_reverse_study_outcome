package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sq3.i;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleTitleHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lsq3/i;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleTitleHolder extends ShopWindowItemHolder<i> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final bp.a f187871q;

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowHotsaleTitleHolder(bp.a r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerView");
        super(r100);
        this.f187871q = r100;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "vo");
        this.f187871q.getTextView().setText(r101.f542987l);
        Integer r102 = r101.f542985j;
        if (r102 == null) goto L5;
        int r103 = com.bytedance.android.shopping.extensions.b.b(r102);
    L6:
        Integer r104 = r101.f542986k;
        if (r104 == null) goto L9;
        int r105 = com.bytedance.android.shopping.extensions.b.b(r104);
    L10:
        bp.a r106 = this.f187871q;
        r106.setPadding(r106.getPaddingLeft(), r103, this.f187871q.getPaddingRight(), r105);
        return;
    L9:
        r105 = this.f187871q.getPaddingBottom();
        goto L10
    L5:
        r103 = this.f187871q.getPaddingTop();
        goto L6
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r100) {
        return new Rect(0, d.a(16), 0, d.a(12));
    }
}
