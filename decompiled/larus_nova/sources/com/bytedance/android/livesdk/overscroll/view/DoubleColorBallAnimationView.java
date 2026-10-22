package com.bytedance.android.livesdk.overscroll.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.config.uo;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f154165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f154166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f154167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f154168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f154169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f154170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f154171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f154172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f154173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f154174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f154175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f154176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f154177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f154178n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f154179o;

    public final void a() {
        this.f154174j = -1;
        if (this.f154175k > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.annie_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f154175k <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f154167c != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f154167c = r101;
    L12:
        this.f154171g = true;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f154173i = false;
        this.f154171g = false;
        this.f154169e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
        b(r100);
    }

    public final void b(Context r100) {
        this.f154165a = ContextCompat.getColor(r100, R.color.annie_loading_color1);
        this.f154166b = ContextCompat.getColor(r100, R.color.annie_loading_color2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f154173i == true) goto L7;
        if (this.f154170f == false) goto L7;
        return;
    L7:
        if (this.f154171g == false) goto L39;
        boolean r100 = false;
        if (this.f154170f == false) goto L18;
        long r101 = System.nanoTime() / 1000000;
        if (this.f154174j >= 0) goto L14;
        this.f154174j = r101;
    L14:
        float r102 = (r101 - this.f154174j) / 400.0f;
        this.f154169e = r102;
        int r103 = (int) r102;
        if (((this.f154172h + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.f154169e = r102 - r103;
    L18:
        float r104 = this.f154169e;
        if (r104 >= 0.5f) goto L21;
        float r105 = (r104 * 2.0f) * r104;
    L22:
        int r106 = this.f154175k;
        int r107 = r110.saveLayer(0.0f, 0.0f, r106, r106, this.f154167c, 31);
        float r108 = (this.f154179o * r105) + this.f154178n;
        if (r105 >= 0.5f) goto L25;
        float r109 = r105 * 2.0f;
    L26:
        float r111 = this.f154177m;
        float r112 = ((0.25f * r109) * r111) + r111;
        Paint r113 = this.f154167c;
        if (r100 == false) goto L29;
        int r114 = this.f154166b;
    L30:
        r113.setColor(r114);
        r110.drawCircle(r108, this.f154176l, r112, this.f154167c);
        float r115 = this.f154175k - r108;
        float r116 = this.f154177m;
        float r117 = r116 - ((r109 * 0.375f) * r116);
        Paint r118 = this.f154167c;
        if (r100 == false) goto L33;
        int r119 = this.f154165a;
    L34:
        r118.setColor(r119);
        this.f154167c.setXfermode(this.f154168d);
        r110.drawCircle(r115, this.f154176l, r117, this.f154167c);
        this.f154167c.setXfermode(null);
        r110.restoreToCount(r107);
        uo r120 = uo.f121389a;
        if (r120.getValue().longValue() <= 0) goto L37;
        postInvalidateDelayed(r120.getValue().longValue());
        return;
    L37:
        postInvalidateDelayed(17);
        return;
    L33:
        r119 = this.f154166b;
        goto L34
    L29:
        r114 = this.f154165a;
        goto L30
    L25:
        r109 = 2.0f - (r105 * 2.0f);
        goto L26
    L21:
        r105 = ((r104 * 2.0f) * (2.0f - r104)) - 1.0f;
        goto L22
    }

    public void setCycleBias(int r100) {
        this.f154172h = r100;
    }

    public void setProgress(float r100) {
        if (this.f154171g == true) goto L5;
        a();
    L5:
        this.f154169e = r100;
        this.f154173i = false;
        this.f154170f = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f154175k = r100;
        this.f154176l = r100 / 2.0f;
        float r101 = (r100 >> 1) * 0.32f;
        this.f154177m = r101;
        float r102 = (r100 * 0.16f) + r101;
        this.f154178n = r102;
        this.f154179o = r100 - (r102 * 2.0f);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        a();
        this.f154173i = true;
        this.f154170f = true;
        postInvalidate();
        return;
    L5:
        this.f154173i = false;
        this.f154171g = false;
        this.f154169e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        b(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f154175k <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f154168d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f154170f = false;
        this.f154171g = false;
        this.f154172h = 0;
        this.f154173i = false;
        this.f154174j = -1;
        this.f154175k = -1;
        b(r100);
    }
}
