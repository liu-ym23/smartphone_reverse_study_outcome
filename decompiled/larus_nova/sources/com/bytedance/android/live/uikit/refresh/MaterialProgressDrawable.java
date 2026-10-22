package com.bytedance.android.live.uikit.refresh;

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
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class MaterialProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Interpolator f102365k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f102366l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f102367m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Animation> f102368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f102369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f102370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Resources f102371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f102372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.uikit.refresh.a f102373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f102374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f102375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f102376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f102377j;

    @Retention(RetentionPolicy.CLASS)
    public @interface ProgressDrawableSize {
    }

    public class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialProgressDrawable f102378a;

        public a(MaterialProgressDrawable r100) {
            this.f102378a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f102378a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f102378a.unscheduleSelf(r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            this.f102378a.scheduleSelf(r101, r102);
        }
    }

    public static class b extends AccelerateDecelerateInterpolator {
        public b() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return super.getInterpolation(Math.max(0.0f, (r100 - 0.5f) * 2.0f));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f102379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f102380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f102381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable.Callback f102382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f102383e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f102384f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f102385g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f102386h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f102387i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f102388j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f102389k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f102390l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f102391m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f102392n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f102393o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Path f102394p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f102395q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f102396r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f102397s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f102398t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f102399u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Paint f102400v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f102401w;

        public final void a() {
            this.f102382d.invalidateDrawable(null);
        }

        public c(a r100) {
            this.f102379a = new RectF();
            Paint r101 = new Paint();
            this.f102380b = r101;
            Paint r102 = new Paint();
            this.f102381c = r102;
            this.f102383e = 0.0f;
            this.f102384f = 0.0f;
            this.f102385g = 0.0f;
            this.f102386h = 5.0f;
            this.f102387i = 2.5f;
            this.f102400v = new Paint();
            this.f102382d = r100;
            r101.setStrokeCap(Paint.Cap.SQUARE);
            r101.setAntiAlias(true);
            r101.setStyle(Paint.Style.STROKE);
            r102.setStyle(Paint.Style.FILL);
            r102.setAntiAlias(true);
        }
    }

    public static class d extends AccelerateDecelerateInterpolator {
        public d() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return super.getInterpolation(Math.min(1.0f, r100 * 2.0f));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    static {
        f102365k = new LinearInterpolator();
        f102366l = new b();
        f102367m = new d();
        new AccelerateDecelerateInterpolator();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f102369b.f102399u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f102376i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f102375h;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r100 = this.f102368a;
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        Animation r103 = (Animation) ListProtector.get(r100, r102);
        if (r103.hasStarted() == false) goto L10;
        if (r103.hasEnded() == true) goto L10;
        return true;
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f102373f.reset();
        c r100 = this.f102369b;
        float r101 = r100.f102383e;
        r100.f102390l = r101;
        float r102 = r100.f102384f;
        r100.f102391m = r102;
        r100.f102392n = r100.f102385g;
        if (r102 == r101) goto L5;
        this.f102377j = true;
        this.f102373f.setDuration(666);
        this.f102372e.startAnimation(this.f102373f);
        return;
    L5:
        r100.f102389k = 0;
        r100.f102390l = 0.0f;
        r100.f102391m = 0.0f;
        r100.f102392n = 0.0f;
        r100.f102383e = 0.0f;
        r100.a();
        r100.f102384f = 0.0f;
        r100.a();
        r100.f102385g = 0.0f;
        r100.a();
        this.f102373f.setDuration(1333);
        this.f102372e.startAnimation(this.f102373f);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f102372e.clearAnimation();
        this.f102370c = 0.0f;
        invalidateSelf();
        c r100 = this.f102369b;
        if (r100.f102393o == false) goto L5;
        r100.f102393o = false;
        r100.a();
    L5:
        c r101 = this.f102369b;
        r101.f102389k = 0;
        r101.f102390l = 0.0f;
        r101.f102391m = 0.0f;
        r101.f102392n = 0.0f;
        r101.f102383e = 0.0f;
        r101.a();
        r101.f102384f = 0.0f;
        r101.a();
        r101.f102385g = 0.0f;
        r101.a();
    }

    public final void b(int r210) {
        if (r210 != 0) goto L4;
        a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        return;
    L4:
        a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r110.save();
        r110.rotate(this.f102370c, r100.exactCenterX(), r100.exactCenterY());
        c r102 = this.f102369b;
        RectF r103 = r102.f102379a;
        r103.set(r100);
        float r104 = r102.f102387i;
        r103.inset(r104, r104);
        float r105 = r102.f102383e;
        float r106 = r102.f102385g;
        float r107 = (r105 + r106) * 360.0f;
        float r111 = ((r102.f102384f + r106) * 360.0f) - r107;
        r102.f102380b.setColor(r102.f102388j[r102.f102389k]);
        r110.drawArc(r103, r107, r111, false, r102.f102380b);
        if (r102.f102393o == false) goto L10;
        Path r108 = r102.f102394p;
        if (r108 != null) goto L7;
        Path r109 = new Path();
        r102.f102394p = r109;
        r109.setFillType(Path.FillType.EVEN_ODD);
    L8:
        float r112 = (((int) r102.f102387i) / 2) * r102.f102395q;
        float r113 = (float) ((r102.f102396r * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterX()));
        float r114 = (float) ((r102.f102396r * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterY()));
        r102.f102394p.moveTo(0.0f, 0.0f);
        r102.f102394p.lineTo(r102.f102397s * r102.f102395q, 0.0f);
        Path r115 = r102.f102394p;
        float r116 = r102.f102397s;
        float r117 = r102.f102395q;
        r115.lineTo((r116 * r117) / 2.0f, r102.f102398t * r117);
        r102.f102394p.offset(r113 - r112, r114);
        r102.f102394p.close();
        r102.f102381c.setColor(r102.f102388j[r102.f102389k]);
        r110.rotate((r107 + r111) - 5.0f, r100.exactCenterX(), r100.exactCenterY());
        r110.drawPath(r102.f102394p, r102.f102381c);
        goto L10
    L7:
        r108.reset();
    L10:
        if (r102.f102399u >= 255) goto L12;
        r102.f102400v.setColor(r102.f102401w);
        r102.f102400v.setAlpha(255 - r102.f102399u);
        r110.drawCircle(r100.exactCenterX(), r100.exactCenterY(), r100.width() / 2, r102.f102400v);
    L12:
        r110.restoreToCount(r101);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f102369b.f102399u = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        c r101 = this.f102369b;
        r101.f102380b.setColorFilter(r100);
        r101.a();
    }

    public MaterialProgressDrawable(Context r100, View r101) {
        this.f102368a = new ArrayList();
        a r102 = new a(this);
        this.f102372e = r101;
        this.f102371d = r100.getResources();
        c r103 = new c(r102);
        this.f102369b = r103;
        r103.f102388j = new int[]{-16777216};
        r103.f102389k = 0;
        b(1);
        com.bytedance.android.live.uikit.refresh.a r104 = new com.bytedance.android.live.uikit.refresh.a(this, r103);
        r104.setRepeatCount(-1);
        r104.setRepeatMode(1);
        r104.setInterpolator(f102365k);
        r104.setAnimationListener(new com.bytedance.android.live.uikit.refresh.b(this, r103));
        this.f102373f = r104;
    }

    public final void a(double r100, double r101, double r102, double r110, float r111, float r112) {
        c r103 = this.f102369b;
        Resources r104 = this.f102371d;
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        double r106 = r105;
        this.f102375h = r100 * r106;
        this.f102376i = r101 * r106;
        float r107 = ((float) r110) * r105;
        r103.f102386h = r107;
        r103.f102380b.setStrokeWidth(r107);
        r103.a();
        r103.f102396r = r102 * r106;
        r103.f102389k = 0;
        r103.f102397s = (int) (r111 * r105);
        r103.f102398t = (int) (r112 * r105);
        float r108 = Math.min((int) this.f102375h, (int) this.f102376i);
        double r109 = r103.f102396r;
        if (r109 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        double r113 = Math.ceil(r103.f102386h / 2.0f);
    L9:
        r103.f102387i = (float) r113;
        return;
    L5:
        if (r108 < 0.0f) goto L8;
        r113 = ((double) (r108 / 2.0f)) - r109;
        goto L9
    }
}
