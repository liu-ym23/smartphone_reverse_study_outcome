package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes11.dex */
public class EdgeTransparentConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f160824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f160825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f160826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f160827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f160828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f160829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f160830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f160831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f160832i;

    public EdgeTransparentConstraintLayout(Context r100) {
        this(r100, null);
    }

    public EdgeTransparentConstraintLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public EdgeTransparentConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160825b = 1;
        this.f160826c = 2;
        this.f160827d = 4;
        this.f160828e = 8;
        this.f160831h = new int[]{-1, 0};
        this.f160832i = new float[]{0.0f, 1.0f};
        Paint r103 = new Paint(1);
        this.f160824a = r103;
        r103.setStyle(Paint.Style.FILL);
        this.f160824a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r110, View r111, long r112) {
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean r101 = super.drawChild(r110, r111, r112);
        if ((this.f160825b & 0) == 0) goto L6;
        r110.drawRect(0.0f, 0.0f, this.f160829f, 0.0f, this.f160824a);
    L6:
        if ((this.f160826c & 0) == 0) goto L8;
        int r113 = r110.save();
        r110.rotate(180.0f, this.f160829f / 2.0f, this.f160830g / 2.0f);
        r110.drawRect(0.0f, 0.0f, this.f160829f, 0.0f, this.f160824a);
        r110.restoreToCount(r113);
    L8:
        float r114 = (this.f160830g - this.f160829f) / 2.0f;
        if ((this.f160827d & 0) == 0) goto L12;
        int r115 = r110.save();
        r110.rotate(270.0f, this.f160829f / 2.0f, this.f160830g / 2.0f);
        r110.translate(0.0f, r114);
        r110.drawRect(0.0f - r114, 0.0f, this.f160829f + r114, 0.0f, this.f160824a);
        r110.restoreToCount(r115);
    L12:
        if ((this.f160828e & 0) == 0) goto L14;
        int r116 = r110.save();
        r110.rotate(90.0f, this.f160829f / 2.0f, this.f160830g / 2.0f);
        r110.translate(0.0f, r114);
        r110.drawRect(0.0f - r114, 0.0f, this.f160829f + r114, 0.0f, this.f160824a);
        r110.restoreToCount(r116);
    L14:
        r110.restoreToCount(r100);
        return r101;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f160824a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, this.f160831h, this.f160832i, Shader.TileMode.CLAMP));
        this.f160829f = getWidth();
        this.f160830g = getHeight();
    }
}
