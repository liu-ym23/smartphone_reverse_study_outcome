package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class DragIndexView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f153131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f153132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f153133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f153134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f153135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f153136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f153137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f153138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f153139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f153140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f153141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f153142l;

    public interface a {
    }

    public void setOnClickIndexListener(a r100) {
    }

    public DragIndexView(Context r100) {
        super(r100);
        this.f153131a = new Paint();
        this.f153132b = 0;
        this.f153133c = 0;
        this.f153134d = "";
        this.f153138h = 2;
        this.f153139i = 0;
        this.f153140j = new Path();
        this.f153141k = new Paint();
        a(r100);
    }

    public final void a(Context r100) {
        setClickable(true);
        Resources r101 = r100.getResources();
        this.f153136f = w0.a(8.0f);
        this.f153137g = w0.a(6.0f);
        this.f153142l = w0.a(24.0f);
        this.f153132b = r101.getColor(R.color.ec_color_9e9e9e);
        r101.getColor(R.color.ec_color_e0e0e0);
        this.f153135e = w0.a(10.0f);
        this.f153131a.setAntiAlias(true);
        this.f153131a.setTypeface(Typeface.DEFAULT_BOLD);
        this.f153133c = r101.getColor(R.color.ec_text_color_75black);
        this.f153131a.setTextSize(w0.a(16.0f));
        this.f153131a.setColor(this.f153133c);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getMeasuredWidth();
        int r101 = getMeasuredHeight();
        if (this.f153138h != 2) goto L5;
        this.f153141k.setAntiAlias(true);
        this.f153141k.setColor(this.f153132b);
        this.f153141k.setStyle(Paint.Style.FILL);
        r110.save();
        r110.translate(0.0f, this.f153139i);
        float r102 = getMeasuredWidth();
        float r103 = this.f153136f;
        float r104 = (r102 - r103) / 2.0f;
        float r105 = this.f153137g;
        float r106 = r104 + r103;
        float r111 = (r104 + r106) / 2.0f;
        float r112 = r105 - r105;
        float r107 = r103 * 0.25f;
        float r113 = r107 * 0.5f;
        float r114 = r105 - (r105 * 0.25f);
        this.f153140j.moveTo(r113 + r104, r114);
        this.f153140j.quadTo(r104, r105, r107 + r104, r105);
        this.f153140j.lineTo(r106 - r107, r105);
        this.f153140j.quadTo(r106, r105, r106 - r113, r114);
        float r108 = (this.f153137g * 0.25f) + r112;
        this.f153140j.lineTo(r111 + r113, r108);
        this.f153140j.quadTo(r111, r112, r111 - r113, r108);
        this.f153140j.close();
        r110.drawPath(this.f153140j, this.f153141k);
        r110.restore();
        r110.save();
        r110.translate(0.0f, -this.f153139i);
        int r109 = getMeasuredWidth();
        int r115 = getMeasuredHeight();
        float r116 = this.f153136f;
        float r117 = (r109 - r116) / 2.0f;
        float r118 = r115;
        float r119 = this.f153137g;
        float r120 = r118 - r119;
        float r121 = r117 + r116;
        float r122 = (r117 + r121) / 2.0f;
        float r123 = r116 * 0.25f;
        float r124 = r123 * 0.5f;
        float r125 = (r119 * 0.25f) + r120;
        this.f153140j.moveTo(r124 + r117, r125);
        this.f153140j.quadTo(r117, r120, r123 + r117, r120);
        this.f153140j.lineTo(r121 - r123, r120);
        this.f153140j.quadTo(r121, r120, r121 - r124, r125);
        float r126 = r118 - (this.f153137g * 0.25f);
        this.f153140j.lineTo(r122 + r124, r126);
        this.f153140j.quadTo(r122, r118, r122 - r124, r126);
        this.f153140j.close();
        r110.drawPath(this.f153140j, this.f153141k);
        r110.restore();
    L5:
        float r127 = (r100 - this.f153131a.measureText(this.f153134d)) / 2.0f;
        Paint.FontMetrics r128 = this.f153131a.getFontMetrics();
        float r129 = r128.descent;
        r110.drawText(this.f153134d, r127, ((r101 / 2.0f) + ((r129 - r128.ascent) / 2.0f)) - r129, this.f153131a);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f153138h != 2) goto L11;
        getMeasuredHeight();
        int r101 = r100.getAction();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L11;
        Handler r102 = k.f153092a;
        System.currentTimeMillis();
        r100.getY();
        goto L11
    L9:
        r100.getY();
        Handler r103 = k.f153092a;
        System.currentTimeMillis();
    L11:
        return super.onTouchEvent(r100);
    }

    public void setNum(int r100) {
        if (r100 <= 0) goto L5;
        this.f153134d = String.valueOf(r100);
        requestLayout();
        return;
    }

    public void setNum(String r100) {
        if (r100 == null) goto L5;
        this.f153134d = r100;
        requestLayout();
        return;
    }

    public DragIndexView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f153131a = new Paint();
        this.f153132b = 0;
        this.f153133c = 0;
        this.f153134d = "";
        this.f153138h = 2;
        this.f153139i = 0;
        this.f153140j = new Path();
        this.f153141k = new Paint();
        a(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        float r102 = this.f153131a.measureText(this.f153134d);
        int r103 = (int) (((this.f153137g * 2.0f) + this.f153142l) + (this.f153135e * 2.0f));
        float r104 = this.f153136f;
        if (r102 > r104) goto L6;
        r102 = r104;
    L6:
        int r105 = (int) r102;
        if (View.MeasureSpec.getMode(r100) != 1073741824) goto L12;
        int r106 = getMeasuredWidth();
        if (r106 <= r105) goto L12;
        r105 = r106;
    L12:
        if (View.MeasureSpec.getMode(r101) != 1073741824) goto L16;
        int r107 = getMeasuredHeight();
        if (r107 <= r103) goto L16;
        this.f153139i = (int) ((r107 - r103) * 0.5f);
        r103 = r107;
    L16:
        setMeasuredDimension(r105, r103);
    }

    public DragIndexView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f153131a = new Paint();
        this.f153132b = 0;
        this.f153133c = 0;
        this.f153134d = "";
        this.f153138h = 2;
        this.f153139i = 0;
        this.f153140j = new Path();
        this.f153141k = new Paint();
        a(r100);
    }
}
