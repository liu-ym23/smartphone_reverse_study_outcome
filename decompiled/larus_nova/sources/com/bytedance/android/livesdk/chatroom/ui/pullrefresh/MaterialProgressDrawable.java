package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

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
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.video.AudioStats;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class MaterialProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Interpolator f113833k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f113834l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f113835m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Animation> f113836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f113837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f113838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Resources f113839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f113840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.pullrefresh.a f113841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f113842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f113843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f113844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f113845j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialProgressDrawable f113846a;

        public a(MaterialProgressDrawable r100) {
            this.f113846a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f113846a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f113846a.unscheduleSelf(r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            this.f113846a.scheduleSelf(r101, r102);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f113847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f113848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f113849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable.Callback f113850d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f113851e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f113852f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f113853g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f113854h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f113855i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f113856j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f113857k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f113858l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f113859m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f113860n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f113861o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Path f113862p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f113863q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f113864r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f113865s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f113866t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f113867u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Paint f113868v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f113869w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f113870x;

        public final void a() {
            this.f113850d.invalidateDrawable(null);
        }

        public b(a r100) {
            this.f113847a = new RectF();
            Paint r101 = new Paint();
            this.f113848b = r101;
            Paint r102 = new Paint();
            this.f113849c = r102;
            this.f113851e = 0.0f;
            this.f113852f = 0.0f;
            this.f113853g = 0.0f;
            this.f113854h = 5.0f;
            this.f113855i = 2.5f;
            this.f113868v = new Paint(1);
            this.f113850d = r100;
            r101.setStrokeCap(Paint.Cap.SQUARE);
            r101.setAntiAlias(true);
            r101.setStyle(Paint.Style.STROKE);
            r102.setStyle(Paint.Style.FILL);
            r102.setAntiAlias(true);
        }

        public final void b(int r100) {
            this.f113857k = r100;
            this.f113870x = this.f113856j[r100];
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    static {
        f113833k = new LinearInterpolator();
        f113834l = new FastOutSlowInInterpolator();
        f113835m = new int[]{-16777216};
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f113837b.f113867u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f113844i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f113843h;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r100 = this.f113836a;
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
        this.f113841f.reset();
        b r100 = this.f113837b;
        float r101 = r100.f113851e;
        r100.f113858l = r101;
        float r102 = r100.f113852f;
        r100.f113859m = r102;
        r100.f113860n = r100.f113853g;
        if (r102 == r101) goto L5;
        this.f113845j = true;
        this.f113841f.setDuration(666);
        this.f113840e.startAnimation(this.f113841f);
        return;
    L5:
        r100.b(0);
        b r103 = this.f113837b;
        r103.f113858l = 0.0f;
        r103.f113859m = 0.0f;
        r103.f113860n = 0.0f;
        r103.f113851e = 0.0f;
        r103.a();
        r103.f113852f = 0.0f;
        r103.a();
        r103.f113853g = 0.0f;
        r103.a();
        this.f113841f.setDuration(1332);
        this.f113840e.startAnimation(this.f113841f);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f113840e.clearAnimation();
        this.f113838c = 0.0f;
        invalidateSelf();
        b r100 = this.f113837b;
        if (r100.f113861o == false) goto L5;
        r100.f113861o = false;
        r100.a();
    L5:
        this.f113837b.b(0);
        b r101 = this.f113837b;
        r101.f113858l = 0.0f;
        r101.f113859m = 0.0f;
        r101.f113860n = 0.0f;
        r101.f113851e = 0.0f;
        r101.a();
        r101.f113852f = 0.0f;
        r101.a();
        r101.f113853g = 0.0f;
        r101.a();
    }

    public final void a(float r100) {
        b r101 = this.f113837b;
        if (r100 == r101.f113863q) goto L6;
        r101.f113863q = r100;
        r101.a();
        return;
    }

    public final void d(int r210) {
        if (r210 != 0) goto L4;
        b(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        return;
    L4:
        b(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r110.save();
        r110.rotate(this.f113838c, r100.exactCenterX(), r100.exactCenterY());
        b r102 = this.f113837b;
        RectF r103 = r102.f113847a;
        r103.set(r100);
        float r104 = r102.f113855i;
        r103.inset(r104, r104);
        float r105 = r102.f113851e;
        float r106 = r102.f113853g;
        float r107 = (r105 + r106) * 360.0f;
        float r111 = ((r102.f113852f + r106) * 360.0f) - r107;
        r102.f113848b.setColor(r102.f113870x);
        r110.drawArc(r103, r107, r111, false, r102.f113848b);
        if (r102.f113861o == false) goto L10;
        Path r108 = r102.f113862p;
        if (r108 != null) goto L7;
        Path r109 = new Path();
        r102.f113862p = r109;
        r109.setFillType(Path.FillType.EVEN_ODD);
    L8:
        float r112 = (((int) r102.f113855i) / 2) * r102.f113863q;
        float r113 = (float) ((r102.f113864r * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterX()));
        float r114 = (float) ((r102.f113864r * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterY()));
        r102.f113862p.moveTo(0.0f, 0.0f);
        r102.f113862p.lineTo(r102.f113865s * r102.f113863q, 0.0f);
        Path r115 = r102.f113862p;
        float r116 = r102.f113865s;
        float r117 = r102.f113863q;
        r115.lineTo((r116 * r117) / 2.0f, r102.f113866t * r117);
        r102.f113862p.offset(r113 - r112, r114);
        r102.f113862p.close();
        r102.f113849c.setColor(r102.f113870x);
        r110.rotate((r107 + r111) - 5.0f, r100.exactCenterX(), r100.exactCenterY());
        r110.drawPath(r102.f113862p, r102.f113849c);
        goto L10
    L7:
        r108.reset();
    L10:
        if (r102.f113867u >= 255) goto L12;
        r102.f113868v.setColor(r102.f113869w);
        r102.f113868v.setAlpha(255 - r102.f113867u);
        r110.drawCircle(r100.exactCenterX(), r100.exactCenterY(), r100.width() / 2, r102.f113868v);
    L12:
        r110.restoreToCount(r101);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f113837b.f113867u = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        b r101 = this.f113837b;
        r101.f113848b.setColorFilter(r100);
        r101.a();
    }

    public MaterialProgressDrawable(Context r100, View r101) {
        this.f113836a = new ArrayList();
        a r102 = new a(this);
        this.f113840e = r101;
        this.f113839d = r100.getResources();
        b r103 = new b(r102);
        this.f113837b = r103;
        r103.f113856j = f113835m;
        r103.b(0);
        d(1);
        com.bytedance.android.livesdk.chatroom.ui.pullrefresh.a r104 = new com.bytedance.android.livesdk.chatroom.ui.pullrefresh.a(this, r103);
        r104.setRepeatCount(-1);
        r104.setRepeatMode(1);
        r104.setInterpolator(f113833k);
        r104.setAnimationListener(new com.bytedance.android.livesdk.chatroom.ui.pullrefresh.b(this, r103));
        this.f113841f = r104;
    }

    public static void c(float r100, b r101) {
        if (r100 <= 0.75f) goto L6;
        float r102 = (r100 - 0.75f) / 0.25f;
        int[] r103 = r101.f113856j;
        int r104 = r101.f113857k;
        int r105 = r103[r104];
        int r106 = r103[(r104 + 1) % r103.length];
        int r107 = (r105 >> 24) & 255;
        int r108 = (r105 >> 16) & 255;
        int r109 = (r105 >> 8) & 255;
        int r110 = r105 & 255;
        r101.f113870x = ((((r107 + ((int) ((((r106 >> 24) & 255) - r107) * r102))) << 24) | ((r108 + ((int) ((((r106 >> 16) & 255) - r108) * r102))) << 16)) | ((r109 + ((int) ((((r106 >> 8) & 255) - r109) * r102))) << 8)) | (r110 + ((int) (r102 * ((r106 & 255) - r110))));
        return;
    }

    public final void b(double r100, double r101, double r102, double r110, float r111, float r112) {
        b r103 = this.f113837b;
        Resources r104 = this.f113839d;
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        double r106 = r105;
        this.f113843h = r100 * r106;
        this.f113844i = r101 * r106;
        float r107 = ((float) r110) * r105;
        r103.f113854h = r107;
        r103.f113848b.setStrokeWidth(r107);
        r103.a();
        r103.f113864r = r102 * r106;
        r103.b(0);
        r103.f113865s = (int) (r111 * r105);
        r103.f113866t = (int) (r112 * r105);
        float r108 = Math.min((int) this.f113843h, (int) this.f113844i);
        double r109 = r103.f113864r;
        if (r109 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        double r113 = Math.ceil(r103.f113854h / 2.0f);
    L9:
        r103.f113855i = (float) r113;
        return;
    L5:
        if (r108 < 0.0f) goto L8;
        r113 = ((double) (r108 / 2.0f)) - r109;
        goto L9
    }
}
