package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class GiftCommonHintView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f126962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f126963b;

    public GiftCommonHintView(Context r100) {
        this(r100, null);
    }

    public void setSubTitle(String r100) {
        this.f126963b.setText(r100);
    }

    public void setTitle(String r100) {
        this.f126962a.setText(r100);
    }

    public GiftCommonHintView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public GiftCommonHintView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_hint_subtitle, this);
        this.f126962a = (TextView) findViewById(R.id.first_title);
        this.f126963b = (TextView) findViewById(R.id.sub_title);
    }
}
