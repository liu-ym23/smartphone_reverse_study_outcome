package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKTitleSelectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKTitleSelectViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f96265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f96266b;

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        return this.f96266b;
    }

    public PKTitleSelectViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f96265a = r100;
        this.f96266b = "";
    }
}
