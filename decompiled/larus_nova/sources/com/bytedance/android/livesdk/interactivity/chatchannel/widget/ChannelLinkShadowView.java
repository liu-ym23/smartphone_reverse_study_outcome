package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class ChannelLinkShadowView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f134487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f134488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f134489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f134490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f134491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f134492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f134493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f134494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f134495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f134496j;

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return 0;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return 0;
    }

    public ChannelLinkShadowView(Context r100) {
        super(r100);
        this.f134496j = true;
        R5(r100, null);
    }

    public void setInvalidateShadowOnSizeChanged(boolean r100) {
        this.f134496j = r100;
    }

    public ChannelLinkShadowView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f134496j = true;
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        int r102 = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bottomShow, R.attr.cornerRadius, R.attr.dx, R.attr.dy, R.attr.leftShow, R.attr.rightShow, R.attr.shadowColor, R.attr.shadowLimit, R.attr.topShow}, 0, 0);
        if (r103 != null) goto L28;
    L8:
        int r104 = (int) (this.f134488b + Math.abs(this.f134490d));
        int r105 = (int) (this.f134488b + Math.abs(this.f134491e));
        if (this.f134492f == false) goto L11;
        int r106 = r104;
    L13:
        if (this.f134494h == false) goto L15;
        int r107 = r105;
    L17:
        if (this.f134493g == true) goto L21;
        r104 = 0;
    L21:
        if (this.f134495i == false) goto L23;
        r102 = r105;
    L23:
        setPadding(r106, r107, r104, r102);
        return;
    L15:
        r107 = 0;
        goto L17
    L11:
        r106 = 0;
        goto L13
    L28:
        this.f134492f = r103.getBoolean(4, true);     // Catch: Throwable -> L25
        this.f134493g = r103.getBoolean(5, true);     // Catch: Throwable -> L25
        this.f134495i = r103.getBoolean(0, true);     // Catch: Throwable -> L25
        this.f134494h = r103.getBoolean(8, true);     // Catch: Throwable -> L25
        this.f134489c = r103.getDimension(1, 0.0f);     // Catch: Throwable -> L25
        this.f134488b = r103.getDimension(7, 0.0f);     // Catch: Throwable -> L25
        this.f134490d = r103.getDimension(2, 0.0f);     // Catch: Throwable -> L25
        this.f134491e = r103.getDimension(3, 0.0f);     // Catch: Throwable -> L25
        this.f134487a = r103.getColor(6, getResources().getColor(R.color.ttlive_room_channel_member_manage_bg_gray));     // Catch: Throwable -> L25
        r103.recycle();
    L25:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    public final void S5(int r110, int r111) {
        float r100 = this.f134489c;
        float r101 = this.f134488b;
        float r102 = this.f134490d;
        float r103 = this.f134491e;
        int r104 = this.f134487a;
        Bitmap r105 = Bitmap.createBitmap(r110, r111, Bitmap.Config.ARGB_8888);
        Canvas r106 = new Canvas(r105);
        RectF r107 = new RectF(r101, r101, r110 - r101, r111 - r101);
        if (r103 <= 0.0f) goto L6;
        r107.top += r103;
        r107.bottom -= r103;
    L9:
        if (r102 <= 0.0f) goto L12;
        r107.left += r102;
        r107.right -= r102;
    L14:
        Paint r112 = new Paint();
        r112.setAntiAlias(true);
        r112.setColor(0);
        r112.setStyle(Paint.Style.FILL);
        if (isInEditMode() == true) goto L17;
        r112.setShadowLayer(r101, r102, r103, r104);
    L17:
        r106.drawRoundRect(r107, r100, r100, r112);
        setBackground(new BitmapDrawable(getResources(), r105));
        return;
    L12:
        if (r102 >= 0.0f) goto L14;
        r107.left += Math.abs(r102);
        r107.right -= Math.abs(r102);
        goto L14
    L6:
        if (r103 >= 0.0f) goto L9;
        r107.top += Math.abs(r103);
        r107.bottom -= Math.abs(r103);
        goto L9
    }

    public ChannelLinkShadowView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f134496j = true;
        R5(r100, r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L12;
        if (r101 > 0) goto L6;
        return;
    L6:
        if (getBackground() != null) goto L8;
    L10:
        S5(r100, r101);
        return;
    L8:
        if (this.f134496j == true) goto L10;
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
