package com.bytedance.android.annie.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.larus.nova.R;
import y9.i;

/* JADX INFO: loaded from: classes43.dex */
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f40080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f40081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f40082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f40083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f40084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f40086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f40087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f40088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f40089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f40090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f40091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f40092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f40093o;

    public final void a() {
        this.f40088j = -1;
        if (this.f40089k > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.annie_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f40089k <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f40081c != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f40081c = r101;
    L12:
        this.f40085g = true;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f40087i = false;
        this.f40085g = false;
        this.f40083e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
        b(r100);
    }

    public final void b(Context r100) {
        this.f40079a = ContextCompat.getColor(r100, R.color.annie_loading_color1);
        this.f40080b = ContextCompat.getColor(r100, R.color.annie_loading_color2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f40087i == true) goto L7;
        if (this.f40084f == false) goto L7;
        return;
    L7:
        if (this.f40085g == false) goto L39;
        boolean r100 = false;
        if (this.f40084f == false) goto L18;
        long r101 = System.nanoTime() / 1000000;
        if (this.f40088j >= 0) goto L14;
        this.f40088j = r101;
    L14:
        float r102 = (r101 - this.f40088j) / 400.0f;
        this.f40083e = r102;
        int r103 = (int) r102;
        if (((this.f40086h + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.f40083e = r102 - r103;
    L18:
        float r104 = this.f40083e;
        if (r104 >= 0.5f) goto L21;
        float r105 = (r104 * 2.0f) * r104;
    L22:
        int r106 = this.f40089k;
        int r107 = r110.saveLayer(0.0f, 0.0f, r106, r106, this.f40081c, 31);
        float r108 = (this.f40093o * r105) + this.f40092n;
        if (r105 >= 0.5f) goto L25;
        float r109 = r105 * 2.0f;
    L26:
        float r111 = this.f40091m;
        float r112 = ((0.25f * r109) * r111) + r111;
        Paint r113 = this.f40081c;
        if (r100 == false) goto L29;
        int r114 = this.f40080b;
    L30:
        r113.setColor(r114);
        r110.drawCircle(r108, this.f40090l, r112, this.f40081c);
        float r115 = this.f40089k - r108;
        float r116 = this.f40091m;
        float r117 = r116 - ((r109 * 0.375f) * r116);
        Paint r118 = this.f40081c;
        if (r100 == false) goto L33;
        int r119 = this.f40079a;
    L34:
        r118.setColor(r119);
        this.f40081c.setXfermode(this.f40082d);
        r110.drawCircle(r115, this.f40090l, r117, this.f40081c);
        this.f40081c.setXfermode(null);
        r110.restoreToCount(r107);
        i<Long> r120 = AnnieConfigSettingKeys.ANNIE_DOUBLE_COLOR_BALL_DELAY;
        if (r120.a().longValue() <= 0) goto L37;
        postInvalidateDelayed(r120.a().longValue());
        return;
    L37:
        postInvalidateDelayed(17);
        return;
    L33:
        r119 = this.f40080b;
        goto L34
    L29:
        r114 = this.f40079a;
        goto L30
    L25:
        r109 = 2.0f - (r105 * 2.0f);
        goto L26
    L21:
        r105 = ((r104 * 2.0f) * (2.0f - r104)) - 1.0f;
        goto L22
    }

    public void setCycleBias(int r100) {
        this.f40086h = r100;
    }

    public void setProgress(float r100) {
        if (this.f40085g == true) goto L5;
        a();
    L5:
        this.f40083e = r100;
        this.f40087i = false;
        this.f40084f = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f40089k = r100;
        this.f40090l = r100 / 2.0f;
        float r101 = (r100 >> 1) * 0.32f;
        this.f40091m = r101;
        float r102 = (r100 * 0.16f) + r101;
        this.f40092n = r102;
        this.f40093o = r100 - (r102 * 2.0f);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        a();
        this.f40087i = true;
        this.f40084f = true;
        postInvalidate();
        return;
    L5:
        this.f40087i = false;
        this.f40085g = false;
        this.f40083e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        b(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f40089k <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f40082d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f40084f = false;
        this.f40085g = false;
        this.f40086h = 0;
        this.f40087i = false;
        this.f40088j = -1;
        this.f40089k = -1;
        b(r100);
    }
}
