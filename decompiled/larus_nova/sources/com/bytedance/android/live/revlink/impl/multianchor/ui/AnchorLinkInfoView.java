package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public class AnchorLinkInfoView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VHeadView f94727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VHeadView f94728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VHeadView f94729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f94730d;

    public final void a() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_anchor_link_info, this, true);
        this.f94727a = (VHeadView) r100.findViewById(R.id.iv_anchor_link_info_1);
        this.f94728b = (VHeadView) r100.findViewById(R.id.iv_anchor_link_info_2);
        this.f94729c = (VHeadView) r100.findViewById(R.id.iv_anchor_link_info_3);
        this.f94730d = (TextView) r100.findViewById(R.id.tv_anchor_link_info);
    }

    public VHeadView getIvAnchorAvatar1() {
        return this.f94727a;
    }

    public VHeadView getIvAnchorAvatar2() {
        return this.f94728b;
    }

    public VHeadView getIvAnchorAvatar3() {
        return this.f94729c;
    }

    public TextView getTvAnchorLinkInfo() {
        return this.f94730d;
    }

    public AnchorLinkInfoView(Context r100) {
        super(r100);
        a();
    }

    public AnchorLinkInfoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public AnchorLinkInfoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
