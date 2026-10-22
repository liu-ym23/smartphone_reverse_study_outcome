package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemBaseVH;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractPanelItemAdapter extends RecyclerView.Adapter<LinkPKAudienceInteractPanelItemBaseVH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f81974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f81975b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f81975b.size();
    }

    public LinkPKAudienceInteractPanelItemAdapter(List<g> r100) {
        Intrinsics.checkNotNullParameter(r100, "panelItemList");
        this.f81975b = r100;
        this.f81974a = s1.f(10.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((g) ListProtector.get(this.f81975b, r100)).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        LinkPKAudienceInteractPanelItemBaseVH r102 = (LinkPKAudienceInteractPanelItemBaseVH) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.T3((g) ListProtector.get(this.f81975b, r101));
        View r103 = r102.itemView;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L13;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        r105.leftMargin = 0;
        r105.rightMargin = 0;
        if (r101 != 0) goto L8;
        r105.leftMargin = this.f81974a;
    L10:
        r103.setLayoutParams(r105);
        return;
    L8:
        if (r101 != (this.f81975b.size() - 1)) goto L10;
        r105.rightMargin = this.f81974a;
        goto L10
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        boolean r102 = true;
        if (r101 == 1) goto L11;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_linkpk_interact_emoji_action_vh, r100, false);
        int r104 = s1.y();
        int r105 = s1.f(40.0f);
        int r106 = s1.f(68.0f);
        if (((this.f81975b.size() * r106) + this.f81974a) > (r104 + r105)) goto L7;
        r102 = false;
    L7:
        if (r102 == false) goto L12;
        double r107 = ((double) (s1.y() - this.f81974a)) / 5.33d;
        int r108 = (int) r107;
        r103.getLayoutParams().width = r108;
    L12:
        return new LinkPKAudienceInteractPanelItemNormalVH(r103);
    L11:
        return new LinkPKAudienceInteractPanelDigitShowModeItemVH(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_linkpk_item_interact_emoji_action_digit_show_mode_vh, r100, false));
    }
}
