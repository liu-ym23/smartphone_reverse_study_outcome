package com.stepos.familyguard.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.r;
import f2.C0702g;
import java.util.Arrays;

/* loaded from: classes.dex */
public class RoundedImageView extends r {

    /* renamed from: d, reason: collision with root package name */
    private Paint f15202d;

    /* renamed from: e, reason: collision with root package name */
    private float f15203e;

    /* renamed from: f, reason: collision with root package name */
    private int f15204f;

    /* renamed from: g, reason: collision with root package name */
    private float f15205g;

    /* renamed from: h, reason: collision with root package name */
    private Path f15206h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f15207i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f15208j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f15209k;

    /* renamed from: l, reason: collision with root package name */
    private final float[] f15210l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f15211m;

    /* renamed from: n, reason: collision with root package name */
    private final float f15212n;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            if (RoundedImageView.this.f15208j) {
                outline.setOval(0, 0, width, height);
            } else {
                outline.setRoundRect(0, 0, width, height, Math.max(0.0f, RoundedImageView.this.f15210l.length > 0 ? RoundedImageView.this.f15210l[0] : 0.0f));
            }
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        this.f15207i = false;
        this.f15208j = false;
        this.f15209k = true;
        this.f15210l = new float[8];
        this.f15211m = false;
        this.f15212n = 0.2f;
        k(context, attributeSet, 0);
    }

    private void h(int i5, int i6) {
        this.f15206h.reset();
        if (this.f15208j) {
            Arrays.fill(this.f15210l, (Math.min(i5, i6) / 2.0f) + 0.5f);
        } else if (this.f15205g < 0.0f) {
            Arrays.fill(this.f15210l, this.f15211m ? Math.min(i5, i6) * 0.2f : i(getContext(), i5, i6));
        }
        C0702g.b("RoundedImageView", "mRadii = " + C0702g.e(this.f15210l));
        this.f15206h.addRoundRect(0.0f, 0.0f, (float) i5, (float) i6, this.f15210l, Path.Direction.CCW);
        invalidateOutline();
    }

    public static float i(Context context, int i5, int i6) {
        float fJ = j(context);
        float fMin = Math.min(i5, i6) * fJ;
        C0702g.b("RoundedImageView", "ratio = " + fJ + ", result = " + fMin);
        return fMin;
    }

    public static float j(Context context) {
        int i5 = Settings.System.getInt(context.getContentResolver(), "current_launcher_icon_corner_size", -1);
        float fA = N1.a.a(context);
        C0702g.b("RoundedImageView", "roundedCornerLimiter = " + i5 + ", ratio = " + fA);
        return fA;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k(android.content.Context r18, android.util.AttributeSet r19, int r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.familyguard.ui.widget.RoundedImageView.k(android.content.Context, android.util.AttributeSet, int):void");
    }

    private boolean l(float f5, float f6, float f7, float f8) {
        return f5 >= 0.0f && f6 >= 0.0f && f7 >= 0.0f && f8 >= 0.0f;
    }

    public int getBorderColor() {
        return this.f15204f;
    }

    public float getBorderRadius() {
        return this.f15205g;
    }

    public float getBorderWidth() {
        return this.f15203e;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f15209k) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f15206h);
        super.onDraw(canvas);
        canvas.drawPath(this.f15206h, this.f15202d);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if (z5 || this.f15207i) {
            this.f15207i = false;
            h(i9, i10);
        }
    }

    public void setBorderColor(int i5) {
        this.f15204f = i5;
        this.f15202d.setColor(i5);
        invalidate();
    }

    public void setBorderEnabled(boolean z5) {
        this.f15209k = z5;
        invalidate();
    }

    public void setBorderRadius(float f5) {
        this.f15205g = f5;
        Arrays.fill(this.f15210l, f5);
        this.f15207i = true;
        requestLayout();
        invalidate();
    }

    public void setBorderWidth(float f5) {
        this.f15203e = f5;
        this.f15202d.setStrokeWidth(f5 * 2.0f);
        invalidate();
    }

    public void setFixedRound(boolean z5) {
        this.f15211m = z5;
    }
}
