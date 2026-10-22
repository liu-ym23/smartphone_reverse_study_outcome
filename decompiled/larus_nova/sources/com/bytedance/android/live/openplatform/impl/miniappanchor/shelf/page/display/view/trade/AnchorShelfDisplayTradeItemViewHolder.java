package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/trade/AnchorShelfDisplayTradeItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayTradeItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorShelfDisplayTradeLayout f84559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnchorShelfDisplayTradeLayout.a f84560b;

    public AnchorShelfDisplayTradeItemViewHolder(AnchorShelfDisplayTradeLayout r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "tradeLayout");
        Intrinsics.checkNotNullParameter(r101, "config");
        super(r100);
        this.f84559a = r100;
        this.f84560b = r101;
    }
}
