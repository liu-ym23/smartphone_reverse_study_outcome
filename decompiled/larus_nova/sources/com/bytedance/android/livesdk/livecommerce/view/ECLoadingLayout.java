package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class ECLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f153164a;

    public ECLoadingLayout(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        setClickable(true);
        this.f153164a = new ImageView(r100);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(w0.a(20.0f), w0.a(20.0f));
        r101.gravity = 17;
        this.f153164a.setLayoutParams(r101);
        this.f153164a.setImageResource(R.drawable.ec_loading);
        addView(this.f153164a);
        RotateAnimation r102 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r102.setInterpolator(new LinearInterpolator());
        r102.setDuration(1000);
        r102.setRepeatCount(-1);
        r102.setFillAfter(true);
        r102.setStartOffset(0);
        this.f153164a.setAnimation(r102);
    }

    public ECLoadingLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public ECLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
