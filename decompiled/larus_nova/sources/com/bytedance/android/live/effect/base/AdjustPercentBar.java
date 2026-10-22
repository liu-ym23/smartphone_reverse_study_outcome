package com.bytedance.android.live.effect.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes45.dex */
public class AdjustPercentBar extends View {

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static Drawable f66907b1;
    public boolean A;
    public boolean B;
    public final Rect C;
    public b D;
    public String E;
    public float F;
    public float G;
    public float H;
    public ValueAnimator H0;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f66908J;
    public int K;
    public int L;
    public float L0;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public final Handler P0;
    public boolean Q;
    public boolean R;
    public ValueAnimator S;
    public boolean T;
    public final int U;
    public final c V;
    public final a V0;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f66909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f66911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f66912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f66913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f66914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f66916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f66917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f66918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f66919k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f66920k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f66921l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f66922m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f66923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Paint f66924o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f66925p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f66926p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f66927q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f66928r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f66929s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Paint f66930t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Paint f66931u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f66932v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f66933w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f66934x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f66935y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f66936z;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }

        public a() {
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f66937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdjustPercentBar f66938b;

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void b() {
            this.f66937a.b();
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void a(int r100) {
            this.f66937a.a(r100);
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void onChanged(int r100) {
            AdjustPercentBar r101 = this.f66938b;
            r101.P0.removeCallbacks(r101.V0);
            AdjustPercentBar r102 = this.f66938b;
            if (r102.f66926p0 != null) goto L5;
        L7:
            ValueAnimator r103 = r102.H0;
            if (r103 == null) goto L10;
            r103.cancel();
            this.f66938b.H0 = null;
        L10:
            this.f66937a.onChanged(r100);
            return;
        L5:
            if (r100 != r102.O) goto L7;
            r102.P0.postDelayed(r102.V0, 100);
            goto L10
        }

        public b(AdjustPercentBar r100, d r101) {
            this.f66938b = r100;
            this.f66937a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustPercentBar f66939a;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f66940a;

            public a(c r100) {
                this.f66940a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                int r101 = (int) ((1.0f - ((Float) r100.getAnimatedValue()).floatValue()) * 255.0f);
                AdjustPercentBar.a(this.f66940a.f66939a, r101);
                this.f66940a.f66939a.invalidate();
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                super.onAnimationEnd(r100);
            }
        }

        public final void a() {
            AdjustPercentBar r100 = this.f66939a;
            if (r100.T == true) goto L5;
            return;
        L5:
            ValueAnimator r101 = r100.S;
            if (r101 == null) goto L8;
            r101.removeAllListeners();
            this.f66939a.S.cancel();
        L8:
            AdjustPercentBar r102 = this.f66939a;
            r102.f66931u.setShadowLayer(0.0f, 0.0f, 0.0f, r102.f66916h);
            this.f66939a.S = ValueAnimator.ofFloat(new float[]{1.0f});
            this.f66939a.S.addUpdateListener(new a(this));
            this.f66939a.S.addListener(new b());
            this.f66939a.S.setDuration(300);
            this.f66939a.S.start();
            this.f66939a.T = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(AdjustPercentBar r100) {
            this.f66939a = r100;
        }
    }

    public interface d {
        void a(int r100);

        void b();

        void onChanged(int r100);
    }

    public void setIsTwoWayMode(boolean r100) {
    }

    public final void b() {
        this.f66927q.setColor(-1);
        Paint r100 = new Paint();
        this.f66928r = r100;
        r100.setStrokeWidth(12.0f);
        this.f66928r.setStyle(Paint.Style.STROKE);
        this.f66928r.setAntiAlias(true);
        Paint r101 = this.f66928r;
        if (this.R == false) goto L5;
        int r102 = this.f66915g;
    L6:
        r101.setColor(r102);
        this.f66928r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.f66920k0 = true;
        invalidate();
        return;
    L5:
        r102 = this.f66921l;
        goto L6
    }

    @Override // android.view.View
    public final void buildDrawingCache() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
    L6:
        super.buildDrawingCache();
        return;
    L5:
        if (((((long) getWidth()) * ((long) getHeight())) * 4) < 838860800) goto L6;
    }

    public final void f() {
        this.f66917i = this.f66909a / 2;
        if (this.f66920k0 == false) goto L5;
        int r100 = this.f66910b / 2;
    L6:
        this.f66918j = r100;
        this.f66919k = (this.f66909a - (this.f66908J * 2.0f)) / this.L;
        this.B = true;
        invalidate();
        return;
    L5:
        r100 = s1.f(32.0f);
        goto L6
    }

    public final void h() {
        removeCallbacks(this.V);
        if (this.f66920k0 == false) goto L5;
        return;
    L5:
        if (this.T == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f66934x) == true) goto L20;
        ValueAnimator r100 = this.S;
        if (r100 == null) goto L12;
        r100.removeAllListeners();
        this.S.cancel();
    L12:
        Paint r101 = this.f66931u;
        if (this.R == false) goto L15;
        float r102 = 0.0f;
    L16:
        r101.setShadowLayer(s1.f(r102), 0.0f, 0.0f, this.f66916h);
        setTextAlpha(255);
        this.T = true;
        invalidate();
        return;
    L15:
        r102 = 3.0f;
        goto L16
    }

    public int getMaxPercent() {
        return this.M;
    }

    public int getMinPercent() {
        return this.N;
    }

    public int getPercent() {
        return this.f66932v;
    }

    public int getRange() {
        return this.L;
    }

    public AdjustPercentBar(Context r100) {
        this(r100, null);
    }

    private void setTextAlpha(int r100) {
        this.W = r100;
        this.f66931u.setAlpha(r100);
        this.f66930t.setAlpha(r100);
    }

    @Override // android.view.View
    public final void buildDrawingCache(boolean r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
    L6:
        super.buildDrawingCache(r100);
        return;
    L5:
        if (((((long) getWidth()) * ((long) getHeight())) * 4) < 838860800) goto L6;
    }

    public final int d(int r100) {
        int r101 = this.K;
        boolean r102 = true;
        if (r101 <= 1) goto L10;
        if ((r100 % r101) < (r101 / 2.0f)) goto L7;
        int r103 = (r100 / r101) + 1;
    L8:
        r100 = r103 * r101;
        goto L10
    L7:
        r103 = r100 / r101;
    L10:
        if (r100 <= this.L) goto L12;
        int r104 = this.M;
    L16:
        if (this.N == 0) goto L18;
    L21:
        if (r102 == false) goto L28;
        int r105 = this.O;
        if (r104 >= (r105 - 2)) goto L25;
        return r104;
    L25:
        if (r104 <= (r105 + 2)) goto L27;
        return r104;
    L27:
        return r105;
    L28:
        return r104;
    L18:
        if (this.O != 0) goto L21;
        r102 = false;
        goto L21
    L12:
        if (r100 > 0) goto L14;
        r104 = this.N;
        goto L16
    L14:
        r104 = r100 + this.N;
        goto L16
    }

    public final void g(boolean r100) {
        this.f66924o.setColor(this.f66913e);
        if (r100 == false) goto L5;
        this.f66924o.setShadowLayer(s1.f(1.0f), 0.0f, 0.0f, this.f66916h);
    L6:
        this.f66925p.setColor(this.f66914f);
        if (r100 == false) goto L9;
        this.f66925p.setShadowLayer(s1.f(1.0f), 0.0f, 0.0f, this.f66916h);
    L10:
        this.f66927q.setColor(this.f66921l);
        if (r100 == false) goto L13;
        this.f66927q.setShadowLayer(s1.f(3.0f), 0.0f, 0.0f, this.f66916h);
    L14:
        this.f66929s.setColor(this.f66913e);
        this.f66930t.setColor(this.f66922m);
        this.f66931u.setColor(this.f66913e);
        setTextAlpha(this.W);
        this.R = false;
        if (f66907b1 != null) goto L17;
        f66907b1 = getResources().getDrawable(R.drawable.ttlive_effect_bg_progress_drawable);
    L17:
        invalidate();
        return;
    L13:
        this.f66927q.clearShadowLayer();
        goto L14
    L9:
        this.f66925p.clearShadowLayer();
        goto L10
    L5:
        this.f66924o.clearShadowLayer();
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.B == true) goto L5;
        return;
    L5:
        int r100 = this.f66932v;
        int r101 = this.N;
        float r102 = this.f66908J;
        float r103 = this.f66919k;
        float r104 = ((r100 - r101) * r103) + r102;
        float r105 = ((this.O - r101) * r103) + r102;
        float r106 = this.f66918j;
        r110.drawLine(r102, r106, this.f66909a - r102, r106, this.f66925p);
        if (this.P == false) goto L8;
        float r107 = this.f66908J;
        float r108 = this.f66918j;
        r110.drawLine(r107, r108, r104, r108, this.f66924o);
    L9:
        int r109 = 255;
        this.f66927q.setAlpha(255);
        this.f66929s.setAlpha(255);
        this.f66931u.setAlpha(255);
        this.f66930t.setAlpha(255);
        r110.drawCircle(r104, this.f66918j, this.H, this.f66927q);
        Paint r111 = this.f66928r;
        if (r111 == null) goto L12;
        r110.drawCircle(r104, this.f66918j, this.H + 4.0f, r111);
    L12:
        int r112 = this.O;
        int r113 = this.N;
        if (r112 < r113) goto L26;
        if (r112 > this.M) goto L26;
        if (r113 != 0) goto L20;
        if (r112 != 0) goto L20;
        boolean r114 = false;
    L21:
        if (r114 == false) goto L26;
        if (this.f66920k0 == true) goto L26;
        r110.drawCircle(r105, this.f66918j, this.f66923n, this.f66929s);
    L20:
        r114 = true;
    L26:
        if (this.f66920k0 == false) goto L28;
        return;
    L28:
        int r115 = this.U;
        if (r115 != Integer.MIN_VALUE) goto L32;
        r115 = this.f66932v;
    L32:
        if (this.L0 != 0.0f) goto L34;
        String r116 = String.valueOf(r115);
    L38:
        if (TextUtils.isEmpty(this.E) == false) goto L40;
    L43:
        this.f66934x = r116;
    L45:
        if (TextUtils.isEmpty(this.f66934x) == false) goto L48;
        return;
    L48:
        if (this.Q == false) goto L50;
        Paint r117 = this.f66931u;
    L51:
        Paint r118 = this.f66930t;
        String r119 = this.f66934x;
        r118.getTextBounds(r119, 0, r119.length(), this.C);
        int r120 = this.C.width();
        int r121 = s1.f(14.0f);
        if (this.Q == false) goto L54;
        int r122 = this.f66917i;
    L55:
        int r123 = (r122 - (r120 / 2)) - s1.f(1.0f);
        int r124 = (int) ((this.f66918j - r121) - this.F);
        if (this.R == false) goto L58;
        Drawable r125 = null;
    L60:
        if (this.Q == true) goto L70;
        if (r125 == null) goto L70;
        int r126 = r125.getIntrinsicWidth();
        int r127 = Math.max(r120, r126);
        float r128 = this.L0;
        if (r128 != 1.0f) goto L66;
        r109 = this.W;
        r127 = r127 + r126;
    L69:
        float r129 = this.f66918j - s1.f(57.0f);
        r125.setAlpha(r109);
        r125.setBounds(0, 0, r127, r125.getIntrinsicHeight());
        r110.save();
        r110.translate(r122 - (r127 / 2.0f), r129);
        r125.draw(r110);
        r110.restore();
        goto L70
    L66:
        if (r128 <= 0.0f) goto L68;
        float r130 = r126;
        r127 = (int) (((int) (((r127 - r126) * r128) + r130)) + (r130 * r128));
        goto L69
    L68:
        r109 = this.W;
    L70:
        float r131 = this.L0;
        if (r131 > 0.0f) goto L73;
    L75:
        r110.drawText(this.f66934x, r123, r124, r117);
        return;
    L73:
        if (r131 >= 1.0f) goto L75;
        int r132 = r117.getAlpha();
        r117.setAlpha((int) (this.L0 * 255.0f));
        r110.drawText(this.f66934x, r123, r124, r117);
        r117.setAlpha(r132);
        return;
    L58:
        r125 = f66907b1;
        goto L60
    L54:
        r122 = (int) r104;
        goto L55
    L50:
        r117 = this.f66930t;
        goto L51
    L40:
        if (TextUtils.isEmpty(r116) == true) goto L43;
        this.f66934x = this.E + " " + r116;
        goto L45
    L34:
        r116 = this.f66926p0;
        if (r116 != null) goto L38;
        r116 = "";
        goto L38
    L8:
        float r133 = this.f66918j;
        r110.drawLine(r104, r133, r105, r133, this.f66924o);
        goto L9
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        r100.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS);
    L6:
        if (isEnabled() == true) goto L8;
    L13:
        r100.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(0, this.N, this.M, this.f66932v));
        return;
    L8:
        if (this.f66932v <= this.N) goto L11;
        r100.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
    L11:
        if (this.f66932v >= this.M) goto L13;
        r100.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        goto L13
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r100) {
        super.onPopulateAccessibilityEvent(r100);
        r100.setItemCount(this.M - this.N);
        r100.setCurrentItemIndex(this.f66932v);
        if (getTag() == null) goto L5;
        String r101 = getTag().toString();
    L7:
        if (this.f66932v >= 0) goto L9;
        String r102 = "负";
    L11:
        if (this.N >= 0) goto L13;
        setContentDescription("实际效果，" + r102 + Math.abs(this.f66932v) + "，" + r101);
        return;
    L13:
        setContentDescription(r101);
        return;
    L9:
        r102 = " ";
        goto L11
    L5:
        r101 = "";
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.A == true) goto L5;
        return true;
    L5:
        boolean r100 = false;
        if (r110.getAction() != 0) goto L13;
        if (r110.getX() >= (this.f66908J - this.f66912d)) goto L10;
    L11:
        return false;
    L10:
        if (r110.getX() > (s1.y() - (this.f66908J - this.f66912d))) goto L11;
    L13:
        if (r110.getAction() == 0) goto L15;
    L17:
        int r101 = r110.getAction();
        if (r101 != 0) goto L20;
        h();
        this.f66933w = this.f66932v;
        float r102 = r110.getX();
        float r103 = r110.getY();
        if (Math.abs(r102 - (this.f66908J + ((this.f66932v - this.N) * this.f66919k))) <= (((double) this.f66911c) * 2.5d)) goto L43;
    L45:
        this.f66936z = !r100;
        float r111 = r110.getX();
        this.f66935y = r111;
        int r112 = d((int) ((r111 - this.f66908J) / this.f66919k));
        if (this.f66932v == r112) goto L51;
        this.f66932v = r112;
        this.f66933w = r112;
        b r104 = this.D;
        if (r104 == null) goto L50;
        r104.onChanged(r112);
    L50:
        invalidate();
    L51:
        b r113 = this.D;
        if (r113 == null) goto L54;
        r113.b();
    L54:
        return true;
    L43:
        if (Math.abs(r103 - this.f66918j) > (((double) this.f66911c) * 2.5d)) goto L45;
        r100 = true;
        goto L45
    L20:
        if (r101 == 1) goto L29;
        if (r101 != 2) goto L23;
        h();
        setCurrentProgress(d((this.f66933w - this.N) + ((int) ((r110.getX() - this.f66935y) / this.f66919k))));
        goto L51
    L23:
        if (r101 != 3) goto L51;
        b r114 = this.D;
        if (r114 == null) goto L51;
        r114.a(this.f66932v);
        goto L51
    L29:
        float r115 = r110.getX();
        if (this.f66936z == true) goto L32;
    L37:
        b r116 = this.D;
        if (r116 == null) goto L51;
        r116.a(this.f66932v);
        goto L51
    L32:
        if (Math.abs(r115 - this.f66935y) > s1.f(3.0f)) goto L37;
        int r117 = d((int) ((r115 - this.f66908J) / this.f66919k));
        b r105 = this.D;
        if (r105 == null) goto L36;
        this.f66932v = r117;
        r105.onChanged(r117);
        this.D.a(r117);
    L36:
        int r106 = this.f66932v;
        this.A = false;
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r107.setTarget(this);
        r107.addUpdateListener(new com.bytedance.android.live.effect.base.a(this, r106, r117));
        r107.addListener(new com.bytedance.android.live.effect.base.b(this));
        r107.setDuration(50);
        r107.setInterpolator(new AccelerateDecelerateInterpolator());
        r107.start();
        goto L51
    L15:
        if (Math.abs(r110.getY() - this.f66918j) <= (this.f66910b - this.f66918j)) goto L17;
        return false;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence r100) {
        Field r101 = View.class.getDeclaredField("mContentDescription");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r101.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r101.set(this, r100);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    L8:
        super.setContentDescription(r100);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void setCurrentProgress(int r100) {
        if (this.D != null) goto L5;
    L7:
        invalidate();
        sendAccessibilityEvent(4);
        return;
    L5:
        if (this.f66932v == r100) goto L7;
        int r101 = Math.min(this.M, Math.max(r100, this.N));
        this.f66932v = r101;
        this.D.onChanged(r101);
        goto L7
    }

    public void setDefaultCircleConfig(int r100) {
        Paint r101 = this.f66929s;
        if (r101 == null) goto L6;
        r101.setColor(s1.h(r100));
        return;
    }

    public void setDefaultCircleRadius(int r100) {
        this.f66923n = r100;
    }

    public void setLevelAdjustBarTitle(String r100) {
        this.E = r100;
    }

    public void setOnLevelChangeListener(d r100) {
        this.D = new b(this, r100);
    }

    public void setPercent(int r100) {
        this.f66932v = r100;
        invalidate();
    }

    public void setTextInCenter(boolean r100) {
        this.Q = r100;
    }

    public AdjustPercentBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ void a(AdjustPercentBar r100, int r101) {
        r100.setTextAlpha(r101);
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int r100, Bundle r101) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        Objects.toString(r101);
        if (r100 == 4096) goto L21;
        if (r100 == 8192) goto L21;
        if (r100 == 16908349) goto L13;
        return super.performAccessibilityAction(r100, r101);
    L13:
        if (Build.VERSION.SDK_INT < 24) goto L20;
        if (r101 == null) goto L20;
        if (r101.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) == false) goto L20;
        setCurrentProgress((int) r101.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE));
        return true;
    L20:
        return false;
    L21:
        int r102 = Math.max(1, Math.round((this.M - this.N) / 20.0f));
        if (r100 != 8192) goto L24;
        r102 = -r102;
    L24:
        setCurrentProgress(this.f66932v + r102);
        return true;
    }

    public AdjustPercentBar(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        int r112 = s1.f(4.0f);
        int r101 = s1.f(9.0f);
        this.f66911c = r101;
        int r102 = s1.f(2.0f);
        this.f66912d = s1.f(10.0f);
        this.f66923n = r102;
        this.A = true;
        this.B = false;
        this.C = new Rect();
        this.E = null;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.f66908J = s1.f(40.0f);
        this.P = true;
        this.Q = false;
        this.T = true;
        this.U = Integer.MIN_VALUE;
        this.V = new c(this);
        this.W = 0;
        this.f66920k0 = false;
        this.L0 = 0.1f;
        this.P0 = new Handler(Looper.getMainLooper());
        this.V0 = new a();
        if (r110 == null) goto L14;
        TypedArray r103 = r100.obtainStyledAttributes(r110, new int[]{R.attr.ttlive_effect_bar_padding, R.attr.ttlive_effect_followTextColor, R.attr.ttlive_effect_lineWidth, R.attr.ttlive_effect_sliderRadius, R.attr.ttlive_effect_step, R.attr.ttlive_effect_text, R.attr.ttlive_effect_textColor, R.attr.ttlive_effect_textPadding, R.attr.ttlive_effect_textSize});
        String r113 = r103.getString(5);
        if (r113 != null) goto L9;
        r113 = "";
    L9:
        this.E = r113;
        r103.getColor(6, -16777216);
        this.G = r103.getDimension(8, s1.f(14.0f));
        this.F = r103.getDimension(7, 0.0f);
        this.f66908J = r103.getDimension(0, s1.f(40.0f));
        this.H = r103.getDimension(3, r101);
        this.I = r103.getDimension(2, r112);
        this.K = r103.getInt(4, 1);
        this.f66922m = r103.getColor(1, -1);
        r103.recycle();
        setLayerType(1, null);
        this.f66913e = -1;
        this.f66914f = 1040187391;
        this.f66915g = -16777216;
        this.f66916h = 1073741824;
        s1.h(R.color.transparent);
        this.f66921l = s1.i("#ff4e33", -1);
        Paint r104 = new Paint();
        this.f66924o = r104;
        r104.setStyle(Paint.Style.FILL);
        this.f66924o.setStrokeWidth(this.I);
        this.f66924o.setStrokeCap(Paint.Cap.ROUND);
        this.f66924o.setAntiAlias(true);
        Paint r105 = new Paint();
        this.f66925p = r105;
        r105.setStyle(Paint.Style.FILL);
        this.f66925p.setStrokeWidth(this.I);
        this.f66925p.setStrokeCap(Paint.Cap.ROUND);
        this.f66925p.setAntiAlias(true);
        Paint r106 = new Paint();
        this.f66927q = r106;
        r106.setStyle(Paint.Style.FILL);
        this.f66927q.setAntiAlias(true);
        Paint r107 = new Paint();
        this.f66929s = r107;
        r107.setStyle(Paint.Style.FILL);
        this.f66929s.setAntiAlias(true);
        Paint r108 = new Paint();
        this.f66930t = r108;
        r108.setTextSize(this.G);
        this.f66930t.setAntiAlias(true);
        Paint r109 = new Paint();
        this.f66931u = r109;
        r109.setTextSize(this.G);
        this.f66931u.setAntiAlias(true);
        g(true);
        setImportantForAccessibility(1);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        if (Build.VERSION.SDK_INT < 26) goto L13;
        setFocusedByDefault(true);
        return;
    L13:
        return;
    }

    public final void c(int r100, int r101, int r102) {
        this.f66913e = r100;
        this.f66914f = r101;
        this.f66921l = r102;
        g(false);
    }

    public final void e(int r100, int r101, int r102, boolean r103) {
        this.M = r100;
        this.N = r101;
        if (r102 > r100) goto L6;
        if (r102 < r101) goto L6;
        this.O = r102;
    L7:
        this.L = r100 - r101;
        this.P = r103;
        if (this.f66909a > 0) goto L10;
    L12:
        invalidate();
        this.f66926p0 = null;
        ValueAnimator r104 = this.H0;
        if (r104 == null) goto L15;
        r104.cancel();
        this.H0 = null;
    L15:
        this.L0 = 0.0f;
        return;
    L10:
        if (this.f66910b <= 0) goto L12;
        f();
    L6:
        this.O = r100;
        goto L7
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f66910b == getMeasuredHeight()) goto L5;
    L6:
        this.f66909a = getMeasuredWidth();
        this.f66910b = getMeasuredHeight();
        f();
        return;
    L5:
        if (this.f66909a != getMeasuredWidth()) goto L6;
    }
}
