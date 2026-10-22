package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class BubbleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f160764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f160765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f160766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f160767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f160768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f160769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Path f160770g;

    public BubbleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawPath(this.f160770g, this.f160769f);
    }

    public BubbleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public BubbleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160764a = 0;
        this.f160765b = 0;
        this.f160766c = 0;
        this.f160767d = 20;
        this.f160768e = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bubble_bg_color, R.attr.bubble_orientation, R.attr.triangle_edge, R.attr.triangle_margin, R.attr.triangle_right_margin});
    L20:
        th = move-exception;
        r103.recycle();
        throw th;
    L4:
        if (r103.hasValue(1) == false) goto L7;
        this.f160764a = r103.getInt(1, 0);     // Catch: Throwable -> L20
    L7:
        if (r103.hasValue(3) == false) goto L10;
        this.f160765b = r103.getDimensionPixelOffset(3, 0);     // Catch: Throwable -> L20
    L10:
        if (r103.hasValue(4) == false) goto L13;
        this.f160766c = r103.getDimensionPixelOffset(4, 0);     // Catch: Throwable -> L20
    L13:
        if (r103.hasValue(0) == false) goto L16;
        this.f160768e = r103.getColor(0, 0);     // Catch: Throwable -> L20
    L16:
        if (r103.hasValue(2) == false) goto L18;
        this.f160767d = r103.getDimensionPixelSize(2, 20);     // Catch: Throwable -> L20
    L18:
        r103.recycle();
        setBackgroundColor(getResources().getColor(android.R.color.transparent));
        Paint r104 = new Paint(1);
        this.f160769f = r104;
        r104.setColor(this.f160768e);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r110, int r111) {
        super.onSizeChanged(r100, r101, r110, r111);
        if (this.f160764a != 0) goto L9;
        int r102 = this.f160765b;
        if (r102 != 0) goto L8;
        r102 = UIUtils.getScreenWidth(getContext()) - this.f160766c;
    L8:
        Path r103 = new Path();
        r103.moveTo(r102, 0.0f);
        double r104 = Math.sqrt(3.0d) / 2.0d;
        double r105 = this.f160767d;
        float r106 = (float) (r104 * r105);
        double r107 = r102;
        r103.lineTo((float) (r107 - (r105 * 0.5d)), r106);
        r103.lineTo(0.0f, r106);
        r103.lineTo(0.0f, getMeasuredHeight());
        r103.lineTo(getMeasuredWidth(), getMeasuredHeight());
        r103.lineTo(getMeasuredWidth(), r106);
        r103.lineTo((float) (r107 + (((double) this.f160767d) * 0.5d)), r106);
        r103.close();
    L10:
        this.f160770g = r103;
        return;
    L9:
        r103 = new Path();
        r103.moveTo(this.f160765b, getMeasuredHeight());
        double r108 = Math.sqrt(3.0d) / 2.0d;
        double r109 = this.f160767d;
        float r112 = (float) (r108 * r109);
        r103.lineTo((float) (((double) this.f160765b) + (r109 * 0.5d)), getMeasuredHeight() - r112);
        r103.lineTo(getMeasuredWidth(), getMeasuredHeight() - r112);
        r103.lineTo(getMeasuredWidth(), 0.0f);
        r103.lineTo(0.0f, 0.0f);
        r103.lineTo(0.0f, getMeasuredHeight() - r112);
        r103.lineTo((float) (((double) this.f160765b) - (((double) this.f160767d) * 0.5d)), getMeasuredHeight() - r112);
        r103.close();
        goto L10
    }
}
