package com.bytedance.android.livesdk.livecommerce.iron.widgets;

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
public class RemoteGroupHeadImageView extends SimpleDraweeView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Float f149161f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Float f149162g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f149163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f149164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f149165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f149166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f149167e;

    static {
        f149161f = Float.valueOf(9.0f);
        f149162g = Float.valueOf(4.5f);
    }

    public RemoteGroupHeadImageView(Context r100) {
        super(r100);
        this.f149165c = false;
        this.f149166d = 1.0f / f149161f.floatValue();
        this.f149167e = 1.0f / f149162g.floatValue();
        setBackgroundColor(0);
        setClip(true);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f149165c == true) goto L5;
        return;
    L5:
        if (this.f149163a == null) goto L11;
        float r100 = (-getHeight()) * this.f149166d;
        float r101 = getWidth() * this.f149167e;
        float r102 = getWidth() + (getWidth() * this.f149166d);
        float r103 = r101 - (r102 - r100);
        RectF r104 = this.f149164b;
        if (r104 == null) goto L12;
        r104.set(r103, r100, r101, r102);
        r110.drawArc(this.f149164b, -90.0f, 180.0f, false, this.f149163a);
        return;
    L12:
        return;
    }

    public void setClip(boolean r100) {
        this.f149165c = r100;
        if (r100 == false) goto L6;
        setLayerType(2, null);
        Paint r101 = new Paint();
        this.f149163a = r101;
        r101.setAntiAlias(true);
        this.f149163a.setColor(getResources().getColor(R.color.ec_color_00000000));
        this.f149163a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f149164b = new RectF();
        return;
    }

    public void setRightOffsetPercent(float r100) {
        this.f149167e = r100;
    }

    public void setTopOffsetPercent(float r100) {
        this.f149166d = r100;
    }

    public RemoteGroupHeadImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f149165c = false;
        this.f149166d = 1.0f / f149161f.floatValue();
        this.f149167e = 1.0f / f149162g.floatValue();
        setBackgroundColor(0);
        setClip(true);
    }
}
