package com.bytedance.android.livesdk.interactivity.medialink.dialog.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class MediaAnchorLinkInfoInviteView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VHeadView f138132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f138133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f138134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VHeadView f138135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f138136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f138137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f138138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f138139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f138140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f138141j;

    public final void a() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_media_view_anchor_link_info_invite, this, true);
        this.f138132a = (VHeadView) r100.findViewById(R.id.iv_avatar);
        this.f138133b = r100.findViewById(R.id.anim_wave);
        this.f138134c = r100.findViewById(R.id.view_wave);
        this.f138135d = (VHeadView) r100.findViewById(R.id.iv_gender);
        this.f138136e = (TextView) r100.findViewById(R.id.tv_label_top);
        this.f138137f = (TextView) r100.findViewById(R.id.tv_nickname);
        this.f138138g = (TextView) r100.findViewById(R.id.tv_label_bottom);
        this.f138139h = (ImageView) r100.findViewById(R.id.iv_location);
        this.f138140i = (TextView) r100.findViewById(R.id.tv_distance);
        this.f138141j = (TextView) r100.findViewById(R.id.link_tv_money);
    }

    public View getAnimWave() {
        return this.f138133b;
    }

    public VHeadView getIvAvatar() {
        return this.f138132a;
    }

    public VHeadView getIvGender() {
        return this.f138135d;
    }

    public ImageView getIvLocation() {
        return this.f138139h;
    }

    public TextView getTvDistance() {
        return this.f138140i;
    }

    public TextView getTvLabelBottom() {
        return this.f138138g;
    }

    public TextView getTvLabelTop() {
        return this.f138136e;
    }

    public TextView getTvMoney() {
        return this.f138141j;
    }

    public TextView getTvNickname() {
        return this.f138137f;
    }

    public View getViewWave() {
        return this.f138134c;
    }

    public MediaAnchorLinkInfoInviteView(Context r100) {
        super(r100);
        a();
    }

    public MediaAnchorLinkInfoInviteView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public MediaAnchorLinkInfoInviteView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
