package com.bytedance.android.gamecp.common.ui.pullrefresh;

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

/* JADX INFO: loaded from: classes44.dex */
public final class MaterialProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Interpolator f57055j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f57056k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f57057l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Animation> f57058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f57059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f57060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f57061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.gamecp.common.ui.pullrefresh.a f57062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f57063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f57064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f57065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f57066i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialProgressDrawable f57067a;

        public a(MaterialProgressDrawable r100) {
            this.f57067a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f57067a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f57067a.unscheduleSelf(r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            this.f57067a.scheduleSelf(r101, r102);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f57068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f57069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f57070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable.Callback f57071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f57072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f57073f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f57074g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f57075h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f57076i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f57077j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f57078k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f57079l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f57080m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f57081n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f57082o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Path f57083p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f57084q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f57085r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f57086s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f57087t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f57088u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Paint f57089v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f57090w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f57091x;

        public final void a() {
            this.f57071d.invalidateDrawable(null);
        }

        public b(a r100) {
            this.f57068a = new RectF();
            Paint r101 = new Paint();
            this.f57069b = r101;
            Paint r102 = new Paint();
            this.f57070c = r102;
            this.f57072e = 0.0f;
            this.f57073f = 0.0f;
            this.f57074g = 0.0f;
            this.f57075h = 5.0f;
            this.f57076i = 2.5f;
            this.f57089v = new Paint(1);
            this.f57071d = r100;
            r101.setStrokeCap(Paint.Cap.SQUARE);
            r101.setAntiAlias(true);
            r101.setStyle(Paint.Style.STROKE);
            r102.setStyle(Paint.Style.FILL);
            r102.setAntiAlias(true);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    static {
        f57055j = new LinearInterpolator();
        f57056k = new FastOutSlowInInterpolator();
        f57057l = new int[]{-16777216};
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f57059b.f57088u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f57065h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f57064g;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r100 = this.f57058a;
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
        this.f57062e.reset();
        b r100 = this.f57059b;
        float r101 = r100.f57072e;
        r100.f57079l = r101;
        float r102 = r100.f57073f;
        r100.f57080m = r102;
        r100.f57081n = r100.f57074g;
        if (r102 == r101) goto L5;
        this.f57066i = true;
        this.f57062e.setDuration(666);
        this.f57061d.startAnimation(this.f57062e);
        return;
    L5:
        r100.f57078k = 0;
        r100.f57091x = r100.f57077j[0];
        r100.f57079l = 0.0f;
        r100.f57080m = 0.0f;
        r100.f57081n = 0.0f;
        r100.f57072e = 0.0f;
        r100.a();
        r100.f57073f = 0.0f;
        r100.a();
        r100.f57074g = 0.0f;
        r100.a();
        this.f57062e.setDuration(1332);
        this.f57061d.startAnimation(this.f57062e);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f57061d.clearAnimation();
        this.f57060c = 0.0f;
        invalidateSelf();
        b r100 = this.f57059b;
        if (r100.f57082o == false) goto L5;
        r100.f57082o = false;
        r100.a();
    L5:
        b r101 = this.f57059b;
        r101.f57078k = 0;
        r101.f57091x = r101.f57077j[0];
        r101.f57079l = 0.0f;
        r101.f57080m = 0.0f;
        r101.f57081n = 0.0f;
        r101.f57072e = 0.0f;
        r101.a();
        r101.f57073f = 0.0f;
        r101.a();
        r101.f57074g = 0.0f;
        r101.a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r110.save();
        r110.rotate(this.f57060c, r100.exactCenterX(), r100.exactCenterY());
        b r102 = this.f57059b;
        RectF r103 = r102.f57068a;
        r103.set(r100);
        float r104 = r102.f57076i;
        r103.inset(r104, r104);
        float r105 = r102.f57072e;
        float r106 = r102.f57074g;
        float r107 = (r105 + r106) * 360.0f;
        float r111 = ((r102.f57073f + r106) * 360.0f) - r107;
        r102.f57069b.setColor(r102.f57091x);
        r110.drawArc(r103, r107, r111, false, r102.f57069b);
        if (r102.f57082o == false) goto L10;
        Path r108 = r102.f57083p;
        if (r108 != null) goto L7;
        Path r109 = new Path();
        r102.f57083p = r109;
        r109.setFillType(Path.FillType.EVEN_ODD);
    L8:
        float r112 = (((int) r102.f57076i) / 2) * r102.f57084q;
        float r113 = (float) ((r102.f57085r * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterX()));
        float r114 = (float) ((r102.f57085r * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterY()));
        r102.f57083p.moveTo(0.0f, 0.0f);
        r102.f57083p.lineTo(r102.f57086s * r102.f57084q, 0.0f);
        Path r115 = r102.f57083p;
        float r116 = r102.f57086s;
        float r117 = r102.f57084q;
        r115.lineTo((r116 * r117) / 2.0f, r102.f57087t * r117);
        r102.f57083p.offset(r113 - r112, r114);
        r102.f57083p.close();
        r102.f57070c.setColor(r102.f57091x);
        r110.rotate((r107 + r111) - 5.0f, r100.exactCenterX(), r100.exactCenterY());
        r110.drawPath(r102.f57083p, r102.f57070c);
        goto L10
    L7:
        r108.reset();
    L10:
        if (r102.f57088u >= 255) goto L12;
        r102.f57089v.setColor(r102.f57090w);
        r102.f57089v.setAlpha(255 - r102.f57088u);
        r110.drawCircle(r100.exactCenterX(), r100.exactCenterY(), r100.width() / 2, r102.f57089v);
    L12:
        r110.restoreToCount(r101);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f57059b.f57088u = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        b r101 = this.f57059b;
        r101.f57069b.setColorFilter(r100);
        r101.a();
    }

    public MaterialProgressDrawable(Context r100, View r101) {
        this.f57058a = new ArrayList();
        a r102 = new a(this);
        this.f57061d = r101;
        Resources r103 = r100.getResources();
        b r104 = new b(r102);
        this.f57059b = r104;
        int[] r105 = f57057l;
        r104.f57077j = r105;
        r104.f57078k = 0;
        r104.f57091x = r105[0];
        float r106 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        double r107 = r106;
        double r108 = 40.0d * r107;
        this.f57064g = r108;
        this.f57065h = r108;
        float r109 = ((float) 2.5d) * r106;
        r104.f57075h = r109;
        r104.f57069b.setStrokeWidth(r109);
        r104.a();
        r104.f57085r = r107 * 8.75d;
        r104.f57078k = 0;
        r104.f57091x = r104.f57077j[0];
        r104.f57086s = (int) (10.0f * r106);
        r104.f57087t = (int) (r106 * 5.0f);
        float r110 = Math.min((int) this.f57064g, (int) this.f57065h);
        double r111 = r104.f57085r;
        if (r111 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        double r112 = Math.ceil(r104.f57075h / 2.0f);
    L9:
        r104.f57076i = (float) r112;
        com.bytedance.android.gamecp.common.ui.pullrefresh.a r113 = new com.bytedance.android.gamecp.common.ui.pullrefresh.a(this, r104);
        r113.setRepeatCount(-1);
        r113.setRepeatMode(1);
        r113.setInterpolator(f57055j);
        r113.setAnimationListener(new com.bytedance.android.gamecp.common.ui.pullrefresh.b(this, r104));
        this.f57062e = r113;
        return;
    L5:
        if (r110 < 0.0f) goto L8;
        r112 = ((double) (r110 / 2.0f)) - r111;
        goto L9
    }

    public static void a(float r100, b r101) {
        if (r100 <= 0.75f) goto L6;
        float r102 = (r100 - 0.75f) / 0.25f;
        int[] r103 = r101.f57077j;
        int r104 = r101.f57078k;
        int r105 = r103[r104];
        int r106 = r103[(r104 + 1) % r103.length];
        int r107 = (r105 >> 24) & 255;
        int r108 = (r105 >> 16) & 255;
        int r109 = (r105 >> 8) & 255;
        int r110 = r105 & 255;
        r101.f57091x = ((((r107 + ((int) ((((r106 >> 24) & 255) - r107) * r102))) << 24) | ((r108 + ((int) ((((r106 >> 16) & 255) - r108) * r102))) << 16)) | ((r109 + ((int) ((((r106 >> 8) & 255) - r109) * r102))) << 8)) | (r110 + ((int) (r102 * ((r106 & 255) - r110))));
        return;
    }
}
