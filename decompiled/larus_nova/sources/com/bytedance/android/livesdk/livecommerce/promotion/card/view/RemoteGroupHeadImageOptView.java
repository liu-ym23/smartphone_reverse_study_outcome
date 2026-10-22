package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class RemoteGroupHeadImageOptView extends SimpleDraweeView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Float f150393d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Float f150394e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f150395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f150396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f150397c;

    static {
        f150393d = Float.valueOf(7.0f);
        f150394e = Float.valueOf(2.8f);
    }

    public RemoteGroupHeadImageOptView(Context r100) {
        super(r100);
        this.f150397c = false;
        setBackgroundColor(0);
        setClip(true);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f150397c == true) goto L5;
        return;
    L5:
        if (this.f150395a == null) goto L11;
        float r100 = -getHeight();
        Float r101 = f150393d;
        float r102 = r100 / r101.floatValue();
        float r103 = -getWidth();
        float r104 = getWidth() / f150394e.floatValue();
        float r105 = getWidth() + (getWidth() / r101.floatValue());
        RectF r106 = this.f150396b;
        if (r106 == null) goto L12;
        r106.set(r103, r102, r104, r105);
        r110.drawArc(this.f150396b, -90.0f, 180.0f, false, this.f150395a);
        return;
    L12:
        return;
    }

    public void setClip(boolean r100) {
        this.f150397c = r100;
        if (r100 == false) goto L6;
        setLayerType(2, null);
        Paint r101 = new Paint();
        this.f150395a = r101;
        r101.setAntiAlias(true);
        this.f150395a.setColor(getResources().getColor(R.color.ec_color_00000000));
        this.f150395a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f150396b = new RectF();
        return;
    }

    public RemoteGroupHeadImageOptView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f150397c = false;
        setBackgroundColor(0);
        setClip(true);
    }
}
