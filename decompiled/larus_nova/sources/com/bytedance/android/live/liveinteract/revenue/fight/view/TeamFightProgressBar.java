package com.bytedance.android.live.liveinteract.revenue.fight.view;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes46.dex */
public class TeamFightProgressBar extends View {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f78248r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f78249s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f78250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f78251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f78252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f78254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f78255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f78257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f78258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f78260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f78261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f78262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f78263n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f78264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f78265p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f78266q;

    public interface a {
        void a(float r100);

        void onProgressChange();
    }

    static {
        f78248r = s1.f(16.0f);
        f78249s = s1.f(20.0f);
    }

    private Path getClipPath() {
        float r100 = getLeftPaddingOffset();
        float r101 = getTopPaddingOffset();
        float r102 = getRightPaddingOffset();
        float r103 = getBottomPaddingOffset();
        float r104 = (getWidth() - r100) - r102;
        float r105 = (getHeight() - r101) - r103;
        Path r106 = new Path();
        r106.moveTo(r100, r101);
        float r107 = r104 + r100;
        r106.lineTo(r107, r101);
        float r108 = r105 + r101;
        r106.lineTo(r107, r108);
        r106.lineTo(r100, r108);
        r106.lineTo(r100, r101);
        r106.close();
        return r106;
    }

    public int getLeftValue() {
        return this.f78252c;
    }

    public float getProgress() {
        return this.f78250a;
    }

    public int getRightValue() {
        return this.f78253d;
    }

    public TeamFightProgressBar(Context r100) {
        this(r100, null);
    }

    private void setProgress(float r100) {
        this.f78264o.onProgressChange();
        float r101 = this.f78250a;
        ValueAnimator r102 = this.f78263n;
        if (r102 != null) goto L5;
    L7:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{r101, r100});
        this.f78263n = r103;
        r103.setDuration(300);
        this.f78263n.addUpdateListener(new d(this));
        this.f78263n.start();
        return;
    L5:
        if (r102.isRunning() == false) goto L7;
        this.f78263n.cancel();
        goto L7
    }

    public final int a(boolean r100) {
        if (r100 == false) goto L9;
        if (this.f78266q == false) goto L7;
        return f78249s;
    L7:
        return f78248r;
    L9:
        return f78248r;
    }

    public final void b(int r100) {
        if (this.f78261l != r100) goto L5;
        return;
    L5:
        this.f78261l = r100;
        invalidate();
    }

    public final void c(int r100) {
        if (this.f78262m != r100) goto L5;
        return;
    L5:
        this.f78262m = r100;
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        float r100 = this.f78250a;
        int r101 = getWidth();
        int r102 = this.f78260k;
        float r103 = (r100 * (r101 - (r102 * 2))) + r102;
        if (r103 <= 0.0f) goto L8;
        int r104 = this.f78261l;
        if (r103 >= r104) goto L8;
        r103 = r104;
    L8:
        if ((getWidth() - r103) > 0.0f) goto L10;
    L12:
        RectF r105 = this.f78254e;
        r105.right = r103;
        r105.bottom = a(true);
        RectF r106 = this.f78255f;
        r106.left = r103;
        r106.top = (a(true) - a(false)) / 2;
        RectF r107 = this.f78255f;
        r107.bottom = r107.top + a(false);
        this.f78255f.right = getWidth();
        r110.clipPath(getClipPath());
        if (this.f78265p == false) goto L15;
        RectF r108 = this.f78254e;
        this.f78251b.setShader(new LinearGradient(r108.left, r108.top, r108.right, a(true), this.f78256g, this.f78257h, Shader.TileMode.MIRROR));
        r110.drawRect(this.f78254e, this.f78251b);
        RectF r109 = this.f78255f;
        this.f78251b.setShader(new LinearGradient(r109.left, r109.top, r109.right, a(false), this.f78258i, this.f78259j, Shader.TileMode.MIRROR));
        r110.drawRect(this.f78255f, this.f78251b);
    L28:
        this.f78251b.setShader(null);
        return;
    L15:
        RectF r111 = this.f78255f;
        this.f78251b.setShader(new LinearGradient(r111.left, r111.top, r111.right, a(false), this.f78258i, this.f78259j, Shader.TileMode.MIRROR));
        r110.drawRect(this.f78255f, this.f78251b);
        RectF r112 = this.f78254e;
        this.f78251b.setShader(new LinearGradient(r112.left, r112.top, r112.right, a(true), this.f78256g, this.f78257h, Shader.TileMode.MIRROR));
        int r113 = li0.a.f509311a;
        float r114 = r103 + s1.f(7.0f);
        float r115 = getHeight();
        Path r116 = new Path();
        float r117 = 0;
        float r118 = 24.0f;
        if (24.0f >= r117) goto L18;
        float r119 = 0.0f;
    L19:
        if (24.0f >= r117) goto L21;
        r118 = 0.0f;
    L21:
        float r120 = r114 - 0.0f;
        float r121 = r115 - 0.0f;
        float r122 = 2;
        float r123 = r120 / r122;
        if (r119 <= r123) goto L24;
        r119 = r123;
    L24:
        float r124 = r121 / r122;
        if (r118 <= r124) goto L27;
        r118 = r124;
    L27:
        float r125 = r120 - (r122 * r119);
        float r126 = r121 - (r122 * r118);
        r116.moveTo(r114, 0.0f + r118);
        float r127 = -r118;
        float r128 = -r119;
        r116.rQuadTo(0.0f, r127, r128, r127);
        r116.rLineTo(-r125, 0.0f);
        r116.rLineTo(r128, 0.0f);
        r116.rLineTo(0.0f, r118);
        r116.rLineTo(0.0f, r126);
        r116.rLineTo(0.0f, r118);
        r116.rLineTo(r119, 0.0f);
        r116.rLineTo(r125, 0.0f);
        r116.rQuadTo(r119, 0.0f, r119, r127);
        r116.rLineTo(0.0f, -r126);
        r116.close();
        r110.drawPath(r116, this.f78251b);
        goto L28
    L18:
        r119 = 24.0f;
        goto L19
    L10:
        if ((getWidth() - r103) >= this.f78262m) goto L12;
        r103 = getWidth() - this.f78262m;
        goto L12
    }

    public void setEnlarge(boolean r100) {
        this.f78266q = r100;
        invalidate();
    }

    public void setLeftValue(int r100) {
        this.f78265p = false;
        this.f78252c = r100;
        int r101 = this.f78253d;
        if ((r101 + r100) != 0) goto L5;
        this.f78265p = true;
        setProgress(0.5f);
        return;
    L5:
        setProgress(r100 / (r100 + r101));
    }

    public void setOnProgressChangeListener(a r100) {
        this.f78264o = r100;
    }

    public void setRightValue(int r100) {
        this.f78265p = false;
        this.f78253d = r100;
        int r101 = this.f78252c;
        if ((r100 + r101) != 0) goto L5;
        this.f78265p = true;
        setProgress(0.5f);
        return;
    L5:
        setProgress(r101 / (r101 + r100));
    }

    public TeamFightProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.seekBarStyle);
    }

    public TeamFightProgressBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f78260k = s1.f(30.0f);
        this.f78261l = 0;
        this.f78262m = 0;
        this.f78265p = true;
        this.f78266q = false;
        this.f78253d = 0;
        this.f78252c = 0;
        this.f78250a = 0.5f;
        this.f78256g = ColorProtector.parseColor("#fd2d55");
        this.f78257h = ColorProtector.parseColor("#ff3ce3");
        this.f78258i = ColorProtector.parseColor("#7ddeff");
        this.f78259j = ColorProtector.parseColor("#606bff");
        Paint r103 = new Paint();
        this.f78251b = r103;
        r103.setTypeface(Typeface.DEFAULT_BOLD);
        r103.setStyle(Paint.Style.FILL);
        r103.setDither(true);
        r103.setAntiAlias(true);
        this.f78254e = new RectF(0.0f, 0.0f, this.f78250a * getWidth(), a(true));
        this.f78255f = new RectF(this.f78250a * getWidth(), 0.0f, getWidth(), a(false));
    }
}
