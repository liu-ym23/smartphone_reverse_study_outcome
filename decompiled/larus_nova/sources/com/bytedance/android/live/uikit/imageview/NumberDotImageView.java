package com.bytedance.android.live.uikit.imageview;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes7.dex */
public class NumberDotImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f102199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f102200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f102201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f102202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f102203e;

    public final void a() {
        UIUtils.dip2Px(this.f102200b, 5.0f);
        this.f102199a = (int) UIUtils.dip2Px(this.f102200b, 8.0f);
        UIUtils.dip2Px(this.f102200b, 3.0f);
        int r100 = (this.f102199a * 2) + 4;
        this.f102201c = r100;
        setMaxHeight(r100);
        setMinimumHeight(this.f102201c);
        Paint r101 = new Paint();
        this.f102202d = r101;
        r101.setAntiAlias(true);
        this.f102202d.setColor(getResources().getColor(R.color.white));
        this.f102202d.setAlpha(125);
        Paint r102 = new Paint();
        this.f102203e = r102;
        r102.reset();
        this.f102203e.setAntiAlias(true);
        this.f102203e.setColor(getResources().getColor(R.color.black));
        this.f102203e.setAlpha(255);
        invalidate();
    }

    public NumberDotImageView(Context r100) {
        super(r100);
        this.f102200b = r100;
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public NumberDotImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f102200b = r100;
        a();
    }

    public NumberDotImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f102200b = r100;
        a();
    }
}
