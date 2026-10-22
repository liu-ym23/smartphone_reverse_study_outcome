package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/SimpleGuestApplyFootHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SimpleGuestApplyFootHolder extends RecyclerView.ViewHolder {
    public SimpleGuestApplyFootHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final void T3(int r100) {
        ViewGroup.LayoutParams r101 = this.itemView.getLayoutParams();
        if (r101 == null) goto L6;
        r101.height = r100;
        this.itemView.setLayoutParams(r101);
        return;
    }
}
