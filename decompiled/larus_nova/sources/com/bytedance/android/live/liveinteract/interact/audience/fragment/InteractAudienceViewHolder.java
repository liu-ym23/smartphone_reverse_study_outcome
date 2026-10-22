package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/InteractAudienceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f73795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f73796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f73797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f73798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f73799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HSImageView f73800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f73801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f73802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RelativeLayout f73803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f73804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f73805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f73806l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f73807m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f73808n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinearLayout f73809o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinearLayout f73810p;

    public InteractAudienceViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f73795a = (HSImageView) this.itemView.findViewById(R.id.iv_head);
        this.f73796b = (TextView) this.itemView.findViewById(R.id.tv_name);
        this.f73797c = (TextView) this.itemView.findViewById(R.id.tv_time);
        this.f73798d = (TextView) this.itemView.findViewById(R.id.btn);
        this.f73799e = (ImageView) this.itemView.findViewById(R.id.iv_gender);
        this.f73800f = (HSImageView) this.itemView.findViewById(R.id.iv_honor);
        this.f73801g = (LinearLayout) this.itemView.findViewById(R.id.fans);
        this.f73802h = (TextView) this.itemView.findViewById(R.id.tv_friend);
        this.f73803i = (RelativeLayout) this.itemView.findViewById(R.id.friend_layout);
        this.f73804j = (TextView) this.itemView.findViewById(R.id.tv_fans);
        this.f73805k = (TextView) this.itemView.findViewById(R.id.tv_distance);
        this.f73806l = (ImageView) this.itemView.findViewById(R.id.iv_location);
        this.f73807m = this.itemView.findViewById(R.id.gap);
        this.f73808n = (TextView) this.itemView.findViewById(R.id.apply_reason);
        this.f73809o = (LinearLayout) this.itemView.findViewById(R.id.other_info);
        this.f73810p = (LinearLayout) this.itemView.findViewById(R.id.name_container);
    }
}
