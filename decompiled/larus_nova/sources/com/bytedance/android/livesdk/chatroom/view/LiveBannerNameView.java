package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class LiveBannerNameView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f114692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f114693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f114694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f114695d;

    public LiveBannerNameView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_banner_name_layout, this, true);
        this.f114695d = r101;
        this.f114692a = (TextView) r101.findViewById(R.id.banner_name_one_tv);
        this.f114693b = (TextView) this.f114695d.findViewById(R.id.banner_name_two_tv);
        this.f114694c = (TextView) this.f114695d.findViewById(R.id.banner_name_three_tv);
    }

    public void setText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b(0, 8, 8);
        this.f114692a.setText("");
        return;
    L6:
        int r101 = r100.length();
        if (r101 != 1) goto L9;
        b(8, 0, 8);
        this.f114693b.setText(r100);
    L9:
        char[] r102 = r100.toCharArray();
        if (r101 != 2) goto L13;
        b(0, 4, 0);
        this.f114692a.setText("" + r102[0]);
        this.f114694c.setText("" + r102[1]);
    L13:
        if (r101 < 3) goto L16;
        b(0, 0, 0);
        this.f114692a.setText("" + r102[0]);
        this.f114693b.setText("" + r102[1]);
        this.f114694c.setText("" + r102[2]);
        return;
    }

    public void setTextColor(int r100) {
        this.f114692a.setTextColor(r100);
        this.f114693b.setTextColor(r100);
        this.f114694c.setTextColor(r100);
    }

    public LiveBannerNameView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public LiveBannerNameView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }

    public final void b(int r100, int r101, int r102) {
        this.f114692a.setVisibility(r100);
        this.f114693b.setVisibility(r101);
        this.f114694c.setVisibility(r102);
    }
}
