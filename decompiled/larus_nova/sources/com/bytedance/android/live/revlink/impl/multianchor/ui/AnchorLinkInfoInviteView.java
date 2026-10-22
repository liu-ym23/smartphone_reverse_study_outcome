package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public class AnchorLinkInfoInviteView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VHeadView f94719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f94720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f94721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VHeadView f94722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f94723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f94724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f94725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f94726h;

    public final void a() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_anchor_link_info_invite, this, true);
        this.f94719a = (VHeadView) r100.findViewById(R.id.iv_avatar);
        this.f94720b = r100.findViewById(R.id.anim_wave);
        this.f94721c = r100.findViewById(R.id.view_wave);
        this.f94722d = (VHeadView) r100.findViewById(R.id.iv_gender);
        this.f94723e = (TextView) r100.findViewById(R.id.tv_label_top);
        this.f94724f = (TextView) r100.findViewById(R.id.tv_nickname);
        this.f94725g = (TextView) r100.findViewById(R.id.tv_label_bottom);
        this.f94726h = (TextView) r100.findViewById(R.id.tv_distance);
    }

    public View getAnimWave() {
        return this.f94720b;
    }

    public VHeadView getIvAvatar() {
        return this.f94719a;
    }

    public VHeadView getIvGender() {
        return this.f94722d;
    }

    public TextView getTvDistance() {
        return this.f94726h;
    }

    public TextView getTvLabelBottom() {
        return this.f94725g;
    }

    public TextView getTvLabelTop() {
        return this.f94723e;
    }

    public TextView getTvNickname() {
        return this.f94724f;
    }

    public View getViewWave() {
        return this.f94721c;
    }

    public AnchorLinkInfoInviteView(Context r100) {
        super(r100);
        a();
    }

    public AnchorLinkInfoInviteView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public AnchorLinkInfoInviteView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
