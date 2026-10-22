package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.view.PaidQueueTabView;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/GuestApplyPaidQueueViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestApplyPaidQueueViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f75115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f75116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Integer, Unit> f75117c;

    public final void T3(final int r100, final ApplyTitlePanelType r101, final Pair<Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r101, "panelType");
        Intrinsics.checkNotNullParameter(r102, "pair");
        View r103 = this.itemView;
        if ((r103 instanceof PaidQueueTabView) == true) goto L5;
        r103 = null;
    L5:
        PaidQueueTabView r104 = (PaidQueueTabView) r103;
        if (r104 == null) goto L28;
        r104.setTabOnClickListener(new GuestApplyPaidQueueViewHolder$bindView$$inlined$apply$lambda$1(this, r101, r100, r102));
        r104.setPanelType(r101);
        r104.setDefaultTab(r100);
        boolean r105 = true;
        r104.setQueueSortTypeVisibility(!this.f75115a);
        r104.setApplyUserCount(r102);
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == true) goto L10;
        return;
    L10:
        if (o.c() == 4) goto L13;
        r105 = false;
    L13:
        if (r105 == true) goto L30;
        r104.setSortOnClickListener(this.f75117c);
        if (r100 != 2) goto L20;
        View r106 = r104.f75077e;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSortContainer");
    L19:
        r106.setVisibility(8);
        return;
    L20:
        View r107 = r104.f75077e;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSortContainer");
    L23:
        r107.setVisibility(0);
        TextView r108 = r104.f75078f;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSortSwitchText");
    L26:
        r108.setText(r104.T5(r104.f75085m.intValue()));
        return;
    L30:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuestApplyPaidQueueViewHolder(View r100, boolean r101, Function1<? super Integer, Unit> r102, Function1<? super Integer, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f75115a = r101;
        this.f75116b = r102;
        this.f75117c = r103;
    }
}
