package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class ZoomableControllerImp extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f139316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float[] f139317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float[] f139318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f139319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Matrix f139320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Matrix f139321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ValueAnimator f139322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f139323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final i f139324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Scroller f139325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f139326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f139327v;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public final void j() {
        if (this.f139322q.isRunning() == false) goto L6;
        this.f139322q.cancel();
        this.f139322q.removeAllUpdateListeners();
        this.f139322q.removeAllListeners();
        return;
    }

    public final boolean e(Matrix r100) {
        RectF r101 = this.f139326u;
        RectF r102 = this.f139333f;
        RectF r103 = this.f139332e;
        r101.set(r102);
        r100.mapRect(r101);
        float r104 = d(r101.left, r101.right, r103.left, r103.right, r102.centerX());
        float r105 = d(r101.top, r101.bottom, r103.top, r103.bottom, r102.centerY());
        if (r104 == 0.0f) goto L5;
    L9:
        r100.postTranslate(r104, r105);
        return true;
    L5:
        if (r105 != 0.0f) goto L9;
        return false;
    }

    public void f(ba2.e r100) {
        if (this.f139327v == false) goto L5;
        return;
    L5:
        j();
        if (this.f139325t.computeScrollOffset() == false) goto L9;
        this.f139325t.forceFinished(true);
        return;
    }

    public void g(ba2.e r110) {
        if (this.f139327v == false) goto L5;
        return;
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        boolean r100 = false;
        if (this.f139322q.isRunning() == false) goto L10;
    L13:
        boolean r101 = true;
    L14:
        if (r101 == false) goto L16;
        return;
    L16:
        ba2.d r111 = r110.f18399b;
        int r102 = r111.f18388a;
        if (r102 == r111.f18389b) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == false) goto L31;
        if (r102 != 1) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == false) goto L31;
        this.f139319n.set(this.f139335h);
        RectF r114 = this.f139332e;
        Matrix r103 = this.f139319n;
        float r104 = r114.centerX();
        float r115 = r114.centerY();
        r103.getValues(this.f139337j);
        float r105 = this.f139337j[0];
        float r106 = Math.min(Math.max(1.0f, r105), this.f139331d);
        if (r106 == r105) goto L29;
        float r107 = r106 / r105;
        r103.postScale(r107, r107, r104, r115);
        r100 = true;
    L29:
        if ((e(this.f139319n) | r100) == false) goto L45;
        this.f139327v = true;
        i(this.f139319n, this.f139323r, this.f139324s, null);
        return;
    L45:
        return;
    L23:
        r113 = false;
    L31:
        Matrix r116 = this.f139335h;
        ba2.e r108 = this.f139328a;
        r116.set(r116);
        r116.postTranslate(r108.f18406i, r108.f18407j);
        if (r108.f18399b.f18388a <= 1) goto L34;
        boolean r109 = true;
    L35:
        if (r109 == false) goto L38;
        float r117 = r108.f18408k;
        r116.postScale(r117, r117, r108.f18404g, r108.f18405h);
    L38:
        if (r108.f18399b.f18388a != 1) goto L40;
        r100 = true;
    L40:
        if (r100 == false) goto L43;
        e(r116);
    L43:
        a();
        return;
    L34:
        r109 = false;
        goto L35
    L19:
        r112 = false;
        goto L20
    L10:
        if (this.f139325t.computeScrollOffset() == true) goto L13;
        r101 = false;
        goto L14
    }

    public final boolean h(MotionEvent r100) {
        int r101 = 0;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f139330c == false) goto L53;
        ba2.e r102 = this.f139328a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        ba2.d r103 = r102.f18399b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r104 = r100.getActionMasked();
        if (r104 == 0) goto L44;
        if (r104 != 1) goto L11;
        r103.b(r100);
        if (r103.f18388a != 0) goto L41;
        r103.a();
    L48:
        return true;
    L41:
        ba2.b<ba2.d> r105 = r103.f18397j;
        if (r105 == null) goto L48;
        r105.onGestureUpdate(r103);
        goto L48
    L11:
        if (r104 != 2) goto L13;
        r103.f18389b = r103.f18388a;
    L30:
        if (r101 >= 2) goto L35;
        int r106 = r100.findPointerIndex(r103.f18390c[r101]);
        if (r106 == (-1)) goto L34;
        float[] r107 = r103.f18395h;
        float[] r108 = r103.f18393f;
        r107[r101] = r108[r101];
        r103.f18396i[r101] = r103.f18394g[r101];
        r108[r101] = r100.getX(r106);
        r103.f18394g[r101] = r100.getY(r106);
    L34:
        r101 = r101 + 1;
        goto L30
    L35:
        ba2.b<ba2.d> r109 = r103.f18397j;
        if (r109 == null) goto L48;
        r109.onGestureUpdate(r103);
        goto L48
    L13:
        if (r104 != 3) goto L15;
        r103.a();
        goto L48
    L15:
        if (r104 != 5) goto L17;
        r103.b(r100);
        ba2.b<ba2.d> r110 = r103.f18397j;
        if (r110 == null) goto L48;
        r110.onGestureUpdate(r103);
        goto L48
    L17:
        if (r104 != 6) goto L48;
        r103.b(r100);
        if (r103.f18388a != 0) goto L22;
        r103.a();
        goto L48
    L22:
        ba2.b<ba2.d> r111 = r103.f18397j;
        if (r111 == null) goto L48;
        r111.onGestureUpdate(r103);
        goto L48
    L44:
        ba2.b<ba2.d> r112 = r103.f18397j;
        if (r112 == null) goto L47;
        r112.onGestureBegin(r103);
    L47:
        r103.b(r100);
        goto L48
    L53:
        return false;
    }

    @Override // ba2.b
    public /* bridge */ /* synthetic */ void onGestureBegin(ba2.e r100) {
        f(r100);
    }

    @Override // ba2.b
    public /* bridge */ /* synthetic */ void onGestureUpdate(ba2.e r100) {
        g(r100);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.android.livesdk.interactivity.publicscreen.preview.i] */
    public ZoomableControllerImp(ba2.e r100, Context r101) {
        super(r100);
        this.f139316k = new float[9];
        this.f139317l = new float[9];
        this.f139318m = new float[9];
        this.f139319n = new Matrix();
        this.f139320o = new Matrix();
        this.f139321p = new Matrix();
        this.f139323r = 400;
        this.f139324s = new i(this);
        this.f139326u = new RectF();
        this.f139327v = false;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f139322q = r102;
        r102.setInterpolator(new DecelerateInterpolator(1.2f));
        this.f139325t = new Scroller(r101);
    }

    public final void i(Matrix r100, long r101, Runnable r102, final ca2.c.b r103) {
        if (this.f139322q.isRunning() == false) goto L5;
        j();
    L5:
        this.f139322q.setDuration(r101);
        this.f139335h.getValues(this.f139316k);
        r100.getValues(this.f139317l);
        this.f139322q.addUpdateListener(new g(this, r103));
        this.f139322q.addListener(new j(this, r102));
        this.f139322q.start();
    }

    public static float d(float r100, float r101, float r102, float r103, float r104) {
        float r105 = r101 - r100;
        float r106 = r103 - r102;
        if (r105 >= (Math.min(r104 - r102, r103 - r104) * 2.0f)) goto L7;
        return r104 - ((r101 + r100) / 2.0f);
    L7:
        if (r105 >= r106) goto L15;
        if (r104 >= ((r102 + r103) / 2.0f)) goto L13;
        return r102 - r100;
    L13:
        return r103 - r101;
    L15:
        if (r100 <= r102) goto L19;
        return r102 - r100;
    L19:
        if (r101 < r103) goto L21;
        return 0.0f;
    L21:
        return r103 - r101;
    }
}
