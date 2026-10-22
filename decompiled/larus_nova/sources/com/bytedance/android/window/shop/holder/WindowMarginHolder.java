package com.bytedance.android.window.shop.holder;

import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowMarginHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/w;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowMarginHolder extends ShopWindowItemHolder<w> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f187881q;

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowMarginHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f187881q = r100;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r100) {
        w r101 = (w) r100;
        Intrinsics.checkNotNullParameter(r101, "vo");
        this.f187881q.setLayoutParams(new RecyclerView.LayoutParams(-1, com.bytedance.android.shopping.widget.rittag.a.b(Double.valueOf(RangesKt.coerceAtLeast(r101.f189640j, AudioStats.AUDIO_AMPLITUDE_NONE)))));
    }
}
