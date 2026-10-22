package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerPlaceHolderViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerPlaceHolderViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f123918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f123919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f123920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f123921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f123922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f123923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.feed.j f123924g;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
    }

    public DrawerPlaceHolderViewHolder(View r100, com.bytedance.android.livesdk.feed.j r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f123924g = r101;
        this.f123918a = (TextView) r100.findViewById(R.id.drawer_left);
        this.f123919b = (TextView) r100.findViewById(R.id.drawer_center);
        this.f123920c = r100.findViewById(R.id.drawer_center_divide_container);
        this.f123921d = (TextView) r100.findViewById(R.id.drawer_center_divide);
        this.f123922e = (LinearLayout) r100.findViewById(R.id.date_indicator_layout);
        this.f123923f = (TextView) r100.findViewById(R.id.date);
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        FeedItem r102 = r100;
        if (r102 == null) goto L20;
        PlaceHolder r103 = r102.placeHolder;
        if (r103 == null) goto L21;
        int r104 = r103.getType();
        if (r104 != 1) goto L9;
        this.f123922e.setVisibility(8);
        this.f123918a.setVisibility(8);
        this.f123919b.setVisibility(8);
        this.f123920c.setVisibility(0);
        this.f123921d.setText(r103.getMsg());
        return;
    L9:
        if (r104 != 2) goto L11;
        this.f123922e.setVisibility(8);
        this.f123918a.setVisibility(0);
        this.f123919b.setVisibility(8);
        this.f123920c.setVisibility(8);
        this.f123918a.setText(r103.getMsg());
        return;
    L11:
        if (r104 != 3) goto L13;
        this.f123922e.setVisibility(8);
        this.f123918a.setVisibility(8);
        this.f123919b.setVisibility(0);
        this.f123920c.setVisibility(8);
        this.f123919b.setText(r103.getMsg());
        return;
    L13:
        if (r104 != 4) goto L25;
        this.f123918a.setVisibility(8);
        this.f123919b.setVisibility(8);
        this.f123920c.setVisibility(8);
        this.f123922e.setVisibility(0);
        this.f123923f.setText(r103.getMsg());
        return;
    L25:
        return;
    L21:
        return;
    }
}
