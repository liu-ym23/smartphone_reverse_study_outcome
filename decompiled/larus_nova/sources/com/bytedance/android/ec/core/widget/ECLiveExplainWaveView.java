package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import java.util.Random;

/* JADX INFO: loaded from: classes43.dex */
public class ECLiveExplainWaveView extends View {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int[] f45964l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f45966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f45967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f45968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f45969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f45970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f45971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f45972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f45973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f45974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f45975k;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f45975k = false;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public ECLiveExplainWaveView(Context r100) {
        super(r100);
        this.f45965a = 4;
        this.f45966b = 10.0f;
        this.f45967c = 5.0f;
        this.f45968d = -65536;
        this.f45969e = 0.0f;
        this.f45970f = 20;
        this.f45971g = 0.0f;
        this.f45972h = new RectF();
        this.f45973i = new Paint();
        this.f45974j = null;
        this.f45975k = false;
        a(r100);
    }

    public final void a(Context r100) {
        this.f45965a = 4;
        this.f45966b = UIUtils.dip2Px(r100, 2.0f);
        this.f45967c = UIUtils.dip2Px(r100, 2.0f);
        this.f45968d = -65536;
        this.f45974j = new int[this.f45965a];
        this.f45973i.setAntiAlias(true);
        this.f45973i.setColor(this.f45968d);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f45965a > 0) goto L5;
        return;
    L5:
        if (this.f45966b > 0.0f) goto L7;
        return;
    L7:
        if (this.f45969e <= 0.0f) goto L34;
        int r100 = getMeasuredHeight();
        int r101 = 0;
    L10:
        if (r101 >= this.f45965a) goto L24;
        if (r101 <= 0) goto L13;
        float r102 = this.f45969e * r101;
    L14:
        float r103 = (r101 * this.f45966b) + r102;
        int r104 = this.f45974j[r101];
        this.f45972h.set(r103, r100 - Math.abs(r104), this.f45966b + r103, r100);
        RectF r105 = this.f45972h;
        float r106 = this.f45967c;
        r110.drawRoundRect(r105, r106, r106, this.f45973i);
        if (r104 < 0) goto L19;
        int r107 = (int) (r104 + this.f45971g);
        if (r107 < r100) goto L22;
        r107 = r100 * (-1);
    L22:
        this.f45974j[r101] = r107;
        r101 = r101 + 1;
        goto L10
    L19:
        r107 = (int) (r104 + this.f45971g);
        if (r107 < 0) goto L22;
        r107 = 0;
        goto L22
    L13:
        r102 = 0.0f;
        goto L14
    L24:
        if (this.f45975k == false) goto L35;
        invalidate();
        return;
    L35:
        return;
    }

    public void setWaveLineColor(int r100) {
        this.f45968d = r100;
        this.f45973i.setColor(r100);
    }

    public void setWaveLineRadius(float r100) {
        this.f45967c = r100;
    }

    public void setWavePerLineWidth(float r100) {
        this.f45966b = r100;
    }

    public ECLiveExplainWaveView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f45965a = 4;
        this.f45966b = 10.0f;
        this.f45967c = 5.0f;
        this.f45968d = -65536;
        this.f45969e = 0.0f;
        this.f45970f = 20;
        this.f45971g = 0.0f;
        this.f45972h = new RectF();
        this.f45973i = new Paint();
        this.f45974j = null;
        this.f45975k = false;
        a(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        int r104 = this.f45965a;
        if (r104 <= 0) goto L24;
        float r105 = this.f45966b;
        if (r105 <= 0.0f) goto L25;
        this.f45969e = ((r102 - (r104 * r105)) * 1.0f) / (r104 - 1);
        int[] r106 = f45964l;
        int r107 = 0;
        if (r106 != null) goto L17;
        if (r104 != 4) goto L12;
        float r108 = r103;
        f45964l = new int[]{(int) (0.8f * r108), (int) (0.3f * r108), (int) (0.6f * r108), (int) (r108 * 0.4f)};
    L15:
        r106 = f45964l;
        goto L17
    L12:
        f45964l = new int[r104];
        Random r109 = new Random();
        int r110 = 0;
    L13:
        if (r110 >= r104) goto L15;
        f45964l[r110] = r109.nextInt(r103);
        r110 = r110 + 1;
    L17:
        if (r107 >= r106.length) goto L19;
        this.f45974j[r107] = r106[r107];
        r107 = r107 + 1;
        goto L17
    L19:
        this.f45971g = (r103 * 1.0f) / this.f45970f;
        return;
    L25:
        return;
    }

    public ECLiveExplainWaveView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f45965a = 4;
        this.f45966b = 10.0f;
        this.f45967c = 5.0f;
        this.f45968d = -65536;
        this.f45969e = 0.0f;
        this.f45970f = 20;
        this.f45971g = 0.0f;
        this.f45972h = new RectF();
        this.f45973i = new Paint();
        this.f45974j = null;
        this.f45975k = false;
        a(r100);
    }
}
