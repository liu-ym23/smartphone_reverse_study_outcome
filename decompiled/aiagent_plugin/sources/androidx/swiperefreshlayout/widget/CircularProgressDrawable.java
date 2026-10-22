package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.g;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = null;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    private static final Interpolator MATERIAL_INTERPOLATOR = null;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final a mRing;
    private float mRotation;
    float mRotationCount;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final RectF f2756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Paint f2757b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Paint f2758c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Paint f2759d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2760e;
        float f;
        float g;
        float h;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p;
        float q;
        int r;
        int s;
        int t;
        int u;

        a() {
            this.f2756a = new RectF();
            Paint r0 = new Paint();
            this.f2757b = r0;
            Paint r1 = new Paint();
            this.f2758c = r1;
            Paint r2 = new Paint();
            this.f2759d = r2;
            this.f2760e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            r0.setStrokeCap(Paint.Cap.SQUARE);
            r0.setAntiAlias(true);
            r0.setStyle(Paint.Style.STROKE);
            r1.setStyle(Paint.Style.FILL);
            r1.setAntiAlias(true);
            r2.setColor(0);
        }

        void a(float r1, float r2) {
            this.r = (int) r1;
            this.s = (int) r2;
        }

        void a(Paint.Cap r1) {
            this.f2757b.setStrokeCap(r1);
        }

        Paint.Cap a() {
            return this.f2757b.getStrokeCap();
        }

        float b() {
            return this.r;
        }

        float c() {
            return this.s;
        }

        void a(Canvas r9, Rect r10) {
            RectF r6 = this.f2756a;
            float r0 = this.q;
            float r1 = (this.h / 2.0f) + r0;
            if (r0 > 0.0f) goto L5;
            r1 = (Math.min(r10.width(), r10.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.h / 2.0f);
        L5:
            r6.set(r10.centerX() - r1, r10.centerY() - r1, r10.centerX() + r1, r10.centerY() + r1);
            float r11 = this.f2760e;
            float r2 = this.g;
            float r12 = (r11 + r2) * 360.0f;
            float r7 = ((this.f + r2) * 360.0f) - r12;
            this.f2757b.setColor(this.u);
            this.f2757b.setAlpha(this.t);
            float r3 = this.h / 2.0f;
            r6.inset(r3, r3);
            r9.drawCircle(r6.centerX(), r6.centerY(), r6.width() / 2.0f, this.f2759d);
            float r4 = -r3;
            r6.inset(r4, r4);
            r9.drawArc(r6, r12, r7, false, this.f2757b);
            a(r9, r12, r7, r6);
        }

        void a(Canvas r8, float r9, float r10, RectF r11) {
            if (this.n == false) goto L10;
            Path r0 = this.o;
            if (r0 != null) goto L7;
            Path r1 = new Path();
            this.o = r1;
            r1.setFillType(Path.FillType.EVEN_ODD);
        L8:
            float r2 = Math.min(r11.width(), r11.height()) / 2.0f;
            float r3 = (this.r * this.p) / 2.0f;
            this.o.moveTo(0.0f, 0.0f);
            this.o.lineTo(this.r * this.p, 0.0f);
            Path r4 = this.o;
            float r5 = this.r;
            float r6 = this.p;
            r4.lineTo((r5 * r6) / 2.0f, this.s * r6);
            this.o.offset((r2 + r11.centerX()) - r3, r11.centerY() + (this.h / 2.0f));
            this.o.close();
            this.f2758c.setColor(this.u);
            this.f2758c.setAlpha(this.t);
            r8.save();
            r8.rotate(r9 + r10, r11.centerX(), r11.centerY());
            r8.drawPath(this.o, this.f2758c);
            r8.restore();
            return;
        L7:
            r0.reset();
            goto L8
        }

        void a(int[] r1) {
            this.i = r1;
            c(0);
        }

        int[] d() {
            return this.i;
        }

        void a(int r1) {
            this.u = r1;
        }

        void b(int r1) {
            this.f2759d.setColor(r1);
        }

        int e() {
            return this.f2759d.getColor();
        }

        void c(int r2) {
            this.j = r2;
            this.u = this.i[r2];
        }

        int f() {
            return this.i[g()];
        }

        int g() {
            return (this.j + 1) % this.i.length;
        }

        void h() {
            c(g());
        }

        void a(ColorFilter r1) {
            this.f2757b.setColorFilter(r1);
        }

        void d(int r1) {
            this.t = r1;
        }

        int i() {
            return this.t;
        }

        void a(float r1) {
            this.h = r1;
            this.f2757b.setStrokeWidth(r1);
        }

        float j() {
            return this.h;
        }

        void b(float r1) {
            this.f2760e = r1;
        }

        float k() {
            return this.f2760e;
        }

        float l() {
            return this.k;
        }

        float m() {
            return this.l;
        }

        int n() {
            return this.i[this.j];
        }

        void c(float r1) {
            this.f = r1;
        }

        float o() {
            return this.f;
        }

        void d(float r1) {
            this.g = r1;
        }

        float p() {
            return this.g;
        }

        void e(float r1) {
            this.q = r1;
        }

        float q() {
            return this.q;
        }

        void a(boolean r2) {
            if (this.n == r2) goto L6;
            this.n = r2;
            return;
        }

        boolean r() {
            return this.n;
        }

        void f(float r2) {
            if (r2 == this.p) goto L6;
            this.p = r2;
            return;
        }

        float s() {
            return this.p;
        }

        float t() {
            return this.m;
        }

        void u() {
            this.k = this.f2760e;
            this.l = this.f;
            this.m = this.g;
        }

        void v() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            b(0.0f);
            c(0.0f);
            d(0.0f);
        }
    }

    private int evaluateColorChange(float r6, int r7, int r8) {
        int r5 = (r7 >> 24) & 255;
        int r0 = (r7 >> 16) & 255;
        int r1 = (r7 >> 8) & 255;
        int r9 = r7 & 255;
        return ((((r5 + ((int) ((((r8 >> 24) & 255) - r5) * r6))) << 24) | ((r0 + ((int) ((((r8 >> 16) & 255) - r0) * r6))) << 16)) | ((r1 + ((int) ((((r8 >> 8) & 255) - r1) * r6))) << 8)) | (r9 + ((int) (r6 * ((r8 & 255) - r9))));
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
        COLORS = new int[]{-16777216};
    }

    public CircularProgressDrawable(Context r3) {
        this.mResources = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(g.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        a r4 = new a();
        this.mRing = r4;
        r4.a(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void setSizeParameters(float r2, float r3, float r4, float r5) {
        a r0 = this.mRing;
        float r1 = this.mResources.getDisplayMetrics().density;
        r0.a(r3 * r1);
        r0.e(r2 * r1);
        r0.c(0);
        r0.a(r4 * r1, r5 * r1);
    }

    public void setStyle(int r4) {
        if (r4 != 0) goto L4;
        setSizeParameters(CENTER_RADIUS_LARGE, STROKE_WIDTH_LARGE, 12.0f, 6.0f);
    L5:
        invalidateSelf();
        return;
    L4:
        setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        goto L5
    }

    public float getStrokeWidth() {
        return this.mRing.j();
    }

    public void setStrokeWidth(float r2) {
        this.mRing.a(r2);
        invalidateSelf();
    }

    public float getCenterRadius() {
        return this.mRing.q();
    }

    public void setCenterRadius(float r2) {
        this.mRing.e(r2);
        invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap r2) {
        this.mRing.a(r2);
        invalidateSelf();
    }

    public Paint.Cap getStrokeCap() {
        return this.mRing.a();
    }

    public float getArrowWidth() {
        return this.mRing.b();
    }

    public float getArrowHeight() {
        return this.mRing.c();
    }

    public void setArrowDimensions(float r2, float r3) {
        this.mRing.a(r2, r3);
        invalidateSelf();
    }

    public boolean getArrowEnabled() {
        return this.mRing.r();
    }

    public void setArrowEnabled(boolean r2) {
        this.mRing.a(r2);
        invalidateSelf();
    }

    public float getArrowScale() {
        return this.mRing.s();
    }

    public void setArrowScale(float r2) {
        this.mRing.f(r2);
        invalidateSelf();
    }

    public float getStartTrim() {
        return this.mRing.k();
    }

    public float getEndTrim() {
        return this.mRing.o();
    }

    public void setStartEndTrim(float r2, float r3) {
        this.mRing.b(r2);
        this.mRing.c(r3);
        invalidateSelf();
    }

    public float getProgressRotation() {
        return this.mRing.p();
    }

    public void setProgressRotation(float r2) {
        this.mRing.d(r2);
        invalidateSelf();
    }

    public int getBackgroundColor() {
        return this.mRing.e();
    }

    public void setBackgroundColor(int r2) {
        this.mRing.b(r2);
        invalidateSelf();
    }

    public int[] getColorSchemeColors() {
        return this.mRing.d();
    }

    public void setColorSchemeColors(int... r2) {
        this.mRing.a(r2);
        this.mRing.c(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        Rect r0 = getBounds();
        r5.save();
        r5.rotate(this.mRotation, r0.exactCenterX(), r0.exactCenterY());
        this.mRing.a(r5, r0);
        r5.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.mRing.d(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.i();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mRing.a(r2);
        invalidateSelf();
    }

    private void setRotation(float r1) {
        this.mRotation = r1;
    }

    private float getRotation() {
        return this.mRotation;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRing.u();
        if (this.mRing.o() == this.mRing.k()) goto L5;
        this.mFinishing = true;
        this.mAnimator.setDuration(666);
        this.mAnimator.start();
        return;
    L5:
        this.mRing.c(0);
        this.mRing.v();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.a(false);
        this.mRing.c(0);
        this.mRing.v();
        invalidateSelf();
    }

    void updateRingColor(float r3, a r4) {
        if (r3 <= COLOR_CHANGE_OFFSET) goto L5;
        r4.a(evaluateColorChange((r3 - COLOR_CHANGE_OFFSET) / 0.25f, r4.n(), r4.f()));
        return;
    L5:
        r4.a(r4.n());
    }

    private void applyFinishTranslation(float r5, a r6) {
        updateRingColor(r5, r6);
        float r4 = (float) (Math.floor(r6.t() / MAX_PROGRESS_ARC) + 1.0d);
        r6.b(r6.l() + (((r6.m() - MIN_PROGRESS_ARC) - r6.l()) * r5));
        r6.c(r6.m());
        r6.d(r6.t() + ((r4 - r6.t()) * r5));
    }

    void applyTransformation(float r8, a r9, boolean r10) {
        if (this.mFinishing == false) goto L6;
        applyFinishTranslation(r8, r9);
        return;
    L6:
        if (r8 != 1.0f) goto L8;
        if (r10 == true) goto L8;
        return;
    L8:
        float r11 = r9.t();
        if (r8 >= SHRINK_OFFSET) goto L11;
        float r0 = r8 / SHRINK_OFFSET;
        float r1 = r9.l();
        float r2 = ((MATERIAL_INTERPOLATOR.getInterpolation(r0) * 0.79f) + MIN_PROGRESS_ARC) + r1;
    L12:
        float r12 = r11 + (RING_ROTATION * r8);
        float r13 = (r8 + this.mRotationCount) * GROUP_FULL_ROTATION;
        r9.b(r1);
        r9.c(r2);
        r9.d(r12);
        setRotation(r13);
        return;
    L11:
        float r3 = (r8 - SHRINK_OFFSET) / SHRINK_OFFSET;
        float r4 = r9.l() + 0.79f;
        r1 = r4 - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation(r3)) * 0.79f) + MIN_PROGRESS_ARC);
        r2 = r4;
        goto L12
    }

    private void setupAnimators() {
        final a r0 = this.mRing;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(new AnonymousClass1(this, r0));
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(LINEAR_INTERPOLATOR);
        r1.addListener(new AnonymousClass2(this, r0));
        this.mAnimator = r1;
    }
}
