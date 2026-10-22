package com.bytedance.android.livesdk.chatroom.ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.ToggleButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class LiveSwitchButton extends View implements Checkable {
    public static final int H0 = 0;
    public static final int L0 = 0;
    public float A;
    public Paint B;
    public Paint C;
    public g D;
    public g E;
    public g F;
    public int G;
    public ValueAnimator H;
    public final ArgbEvaluator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f112347J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public e S;
    public View.OnClickListener T;
    public f U;
    public long V;
    public final b W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f112348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f112349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f112350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f112351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f112352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f112353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f112354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f112355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f112356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f112357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f112358k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final c f112359k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f112360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f112361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f112362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f112363o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f112364p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final d f112365p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f112366q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f112367r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f112368s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f112369t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f112370u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f112371v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f112372w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f112373x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f112374y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f112375z;

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSwitchButton f112376a;

        public a(LiveSwitchButton r100) {
            this.f112376a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setCheckable(true);
            r101.setChecked(this.f112376a.f112347J);
            r101.setClassName(ToggleButton.class.getName());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSwitchButton f112377a;

        public final void a() {
            LiveSwitchButton r100 = this.f112377a;
            int r101 = LiveSwitchButton.H0;
            int r102 = r100.G;
            boolean r103 = false;
            if (r102 == 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L26;
            if (r102 == 0) goto L9;
            r103 = true;
        L9:
            if (r103 == false) goto L12;
            return;
        L12:
            if (r100.O == true) goto L15;
            return;
        L15:
            if (r100.L == true) goto L18;
            return;
        L18:
            if (r100.H.isRunning() == false) goto L20;
            r100.H.cancel();
        L20:
            r100.G = 1;
            g.a(r100.E, r100.D);
            g.a(r100.F, r100.D);
            if (r100.isChecked() == false) goto L23;
            g r105 = r100.F;
            int r106 = r100.f112361m;
            r105.f112381b = r106;
            r105.f112380a = r100.A;
            r105.f112382c = r106;
        L24:
            r100.H.start();
            return;
        L23:
            g r107 = r100.F;
            r107.f112381b = r100.f112360l;
            r107.f112380a = r100.f112375z;
            r107.f112383d = r100.f112351d;
            goto L24
        L26:
            return;
        L5:
            r104 = false;
            goto L6
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

        public b(LiveSwitchButton r100) {
            this.f112377a = r100;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSwitchButton f112378a;

        public c(LiveSwitchButton r100) {
            this.f112378a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = ((Float) r100.getAnimatedValue()).floatValue();
            LiveSwitchButton r102 = this.f112378a;
            int r103 = r102.G;
            if (r103 != 1) goto L5;
        L12:
            g r104 = r102.D;
            r104.f112382c = ((Integer) r102.I.evaluate(r101, Integer.valueOf(r102.E.f112382c), Integer.valueOf(this.f112378a.F.f112382c))).intValue();
            LiveSwitchButton r105 = this.f112378a;
            g r106 = r105.D;
            g r107 = r105.E;
            float r108 = r107.f112383d;
            g r109 = r105.F;
            r106.f112383d = r108 + ((r109.f112383d - r108) * r101);
            if (r105.G == 1) goto L15;
            float r110 = r107.f112380a;
            r106.f112380a = r110 + ((r109.f112380a - r110) * r101);
        L15:
            r106.f112381b = ((Integer) r105.I.evaluate(r101, Integer.valueOf(r107.f112381b), Integer.valueOf(this.f112378a.F.f112381b))).intValue();
        L16:
            this.f112378a.postInvalidate();
            return;
        L5:
            if (r103 == 3) goto L12;
            if (r103 == 4) goto L12;
            if (r103 != 5) goto L16;
            g r111 = r102.D;
            float r112 = r102.E.f112380a;
            float r113 = r112 + ((r102.F.f112380a - r112) * r101);
            r111.f112380a = r113;
            float r114 = r102.f112375z;
            float r115 = (r113 - r114) / (r102.A - r114);
            r111.f112381b = ((Integer) r102.I.evaluate(r115, Integer.valueOf(r102.f112360l), Integer.valueOf(this.f112378a.f112361m))).intValue();
            LiveSwitchButton r116 = this.f112378a;
            g r117 = r116.D;
            r117.f112383d = r116.f112351d * r115;
            r117.f112382c = ((Integer) r116.I.evaluate(r115, 0, Integer.valueOf(this.f112378a.f112363o))).intValue();
            goto L16
        }
    }

    public class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSwitchButton f112379a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public d(LiveSwitchButton r100) {
            this.f112379a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            LiveSwitchButton r101 = this.f112379a;
            int r102 = r101.G;
            if (r102 != 1) goto L5;
            r101.G = 2;
            g r103 = r101.D;
            r103.f112382c = 0;
            r103.f112383d = r101.f112351d;
            r101.postInvalidate();
            return;
        L5:
            if (r102 != 3) goto L7;
            r101.G = 0;
            r101.postInvalidate();
            return;
        L7:
            if (r102 != 4) goto L9;
            r101.G = 0;
            r101.postInvalidate();
            this.f112379a.a();
            return;
        L9:
            if (r102 != 5) goto L19;
            r101.f112347J = !r101.f112347J;
            r101.G = 0;
            r101.postInvalidate();
            this.f112379a.a();
            return;
        }
    }

    public interface e {
        void d0(LiveSwitchButton r100, boolean r101);
    }

    public interface f {
        Boolean a(boolean r100);
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f112380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f112381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f112382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f112383d;

        public g() {
        }

        public static void a(g r100, g r101) {
            r100.getClass();
            r100.f112380a = r101.f112380a;
            r100.f112381b = r101.f112381b;
            r100.f112382c = r101.f112382c;
            r100.f112383d = r101.f112383d;
        }
    }

    @Override // android.view.View
    public final void setOnLongClickListener(View.OnLongClickListener r100) {
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        f(true, true);
    }

    static {
        H0 = (int) b(58.0f);
        L0 = (int) b(36.0f);
    }

    public final void a() {
        e r100 = this.S;
        if (r100 == null) goto L5;
        this.Q = true;
        r100.d0(this, isChecked());
    L5:
        this.Q = false;
    }

    public final void e() {
        int r100 = this.G;
        boolean r101 = true;
        if (r100 != 2) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 3) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L14;
        return;
    L14:
        if (this.H.isRunning() == false) goto L16;
        this.H.cancel();
    L16:
        this.G = 3;
        g.a(this.E, this.D);
        if (isChecked() == false) goto L19;
        setCheckedViewState(this.F);
    L20:
        this.H.start();
        return;
    L19:
        setUncheckViewState(this.F);
        goto L20
    L5:
        r102 = false;
        goto L7
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (j40.m3.f497264a.getValue().booleanValue() == false) goto L8;
        if (this.T != null) goto L8;
        toggle();
    L8:
        return super.performClick();
    }

    public boolean getEnableTouchEvent() {
        return this.R;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f112347J;
    }

    public LiveSwitchButton(Context r100) {
        super(r100);
        new RectF();
        this.G = 0;
        this.I = new ArgbEvaluator();
        this.L = true;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.W = new b(this);
        this.f112359k0 = new c(this);
        this.f112365p0 = new d(this);
        c(r100, null);
    }

    public static float b(float r100) {
        return TypedValue.applyDimension(1, r100, com.bytedance.android.live.core.utils.s1.l());
    }

    private void setCheckedViewState(g r100) {
        r100.f112383d = this.f112351d;
        r100.f112381b = this.f112361m;
        r100.f112382c = this.f112363o;
        r100.f112380a = this.A;
        this.B.setColor(this.f112374y);
    }

    private void setUncheckViewState(g r100) {
        r100.f112383d = 0.0f;
        r100.f112381b = this.f112360l;
        r100.f112382c = 0;
        r100.f112380a = this.f112375z;
        this.B.setColor(this.f112373x);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        this.C.setStrokeWidth(this.f112362n);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setColor(this.f112358k);
        float r100 = this.f112353f;
        float r101 = this.f112354g;
        float r102 = this.f112355h;
        float r103 = this.f112356i;
        float r104 = this.f112351d;
        r110.drawRoundRect(r100, r101, r102, r103, r104, r104, this.C);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setColor(this.f112360l);
        float r105 = this.f112353f;
        float r106 = this.f112354g;
        float r107 = this.f112355h;
        float r108 = this.f112356i;
        float r109 = this.f112351d;
        r110.drawRoundRect(r105, r106, r107, r108, r109, r109, this.C);
        if (this.N == false) goto L5;
        int r111 = this.f112367r;
        float r112 = this.f112368s;
        float r113 = this.f112355h - this.f112369t;
        float r114 = this.f112357j;
        float r115 = this.f112370u;
        Paint r116 = this.C;
        r116.setStyle(Paint.Style.STROKE);
        r116.setColor(r111);
        r116.setStrokeWidth(r112);
        r110.drawCircle(r113, r114, r115, r116);
    L5:
        float r117 = this.D.f112383d * 0.5f;
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setColor(this.D.f112381b);
        this.C.setStrokeWidth(this.f112362n + (r117 * 2.0f));
        float r118 = this.f112353f + r117;
        float r119 = this.f112354g + r117;
        float r120 = this.f112355h - r117;
        float r121 = this.f112356i - r117;
        float r122 = this.f112351d;
        r110.drawRoundRect(r118, r119, r120, r121, r122, r122, this.C);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setStrokeWidth(1.0f);
        float r123 = this.f112353f;
        float r124 = this.f112354g;
        float r125 = this.f112351d * 2.0f;
        r110.drawArc(r123, r124, r123 + r125, r124 + r125, 90.0f, 180.0f, true, this.C);
        float r126 = this.f112353f;
        float r127 = this.f112351d;
        float r128 = this.f112354g;
        r110.drawRect(r126 + r127, r128, this.D.f112380a, r128 + (r127 * 2.0f), this.C);
        if (this.N == false) goto L8;
        int r129 = this.D.f112382c;
        float r130 = this.f112364p;
        float r131 = this.f112353f + this.f112351d;
        float r132 = r131 - this.f112371v;
        float r133 = this.f112357j;
        float r134 = this.f112366q;
        Paint r135 = this.C;
        r135.setStyle(Paint.Style.STROKE);
        r135.setColor(r129);
        r135.setStrokeWidth(r130);
        r110.drawLine(r132, r133 - r134, r131 - this.f112372w, r133 + r134, r135);
    L8:
        float r136 = this.D.f112380a;
        float r137 = this.f112357j;
        r110.drawCircle(r136, r137, this.f112352e, this.B);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(1.0f);
        this.C.setColor(-2236963);
        r110.drawCircle(r136, r137, this.f112352e, this.C);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
        if (isEnabled() == true) goto L6;
        return false;
    L6:
        if (this.R == false) goto L8;
        return false;
    L8:
        View.OnClickListener r101 = this.T;
        if (r101 == null) goto L12;
        r101.onClick(this);
        return false;
    L12:
        int r102 = r110.getActionMasked();
        if (r102 != 0) goto L15;
        this.O = true;
        this.V = System.currentTimeMillis();
        removeCallbacks(this.W);
        postDelayed(this.W, 100);
    L73:
        return true;
    L15:
        if (r102 == 1) goto L42;
        if (r102 == 2) goto L30;
        if (r102 != 3) goto L73;
        this.O = false;
        removeCallbacks(this.W);
        int r111 = this.G;
        if (r111 == 1) goto L24;
        if (r111 == 3) goto L24;
        boolean r103 = false;
    L25:
        if (r103 == true) goto L29;
        if (r111 != 2) goto L28;
        r100 = true;
    L28:
        if (r100 == false) goto L73;
    L29:
        e();
    L24:
        r103 = true;
        goto L25
    L30:
        float r112 = r110.getX();
        int r104 = this.G;
        if (r104 == 1) goto L35;
        if (r104 == 3) goto L35;
        boolean r105 = false;
    L36:
        if (r105 == false) goto L38;
        float r113 = Math.max(0.0f, Math.min(1.0f, r112 / getWidth()));
        g r106 = this.D;
        float r107 = this.f112375z;
        r106.f112380a = r107 + ((this.A - r107) * r113);
        goto L73
    L38:
        if (r104 != 2) goto L40;
        r100 = true;
    L40:
        if (r100 == false) goto L73;
        float r114 = Math.max(0.0f, Math.min(1.0f, r112 / getWidth()));
        g r108 = this.D;
        float r109 = this.f112375z;
        r108.f112380a = r109 + ((this.A - r109) * r114);
        r108.f112381b = ((Integer) this.I.evaluate(r114, Integer.valueOf(this.f112360l), Integer.valueOf(this.f112361m))).intValue();
        postInvalidate();
    L35:
        r105 = true;
        goto L36
    L42:
        this.O = false;
        removeCallbacks(this.W);
        if ((System.currentTimeMillis() - this.V) <= 300) goto L45;
        int r115 = this.G;
        if (r115 != 2) goto L51;
        boolean r116 = true;
    L52:
        if (r116 == true) goto L54;
        if (r115 == 1) goto L69;
        if (r115 == 3) goto L69;
    L70:
        if (r100 == false) goto L73;
        e();
    L69:
        r100 = true;
        goto L70
    L54:
        if (Math.max(0.0f, Math.min(1.0f, r110.getX() / getWidth())) <= 0.5f) goto L57;
        r100 = true;
    L57:
        if (r100 != isChecked()) goto L59;
        e();
        goto L73
    L59:
        this.f112347J = r100;
        if (this.H.isRunning() == false) goto L62;
        this.H.cancel();
    L62:
        this.G = 4;
        g.a(this.E, this.D);
        if (isChecked() == false) goto L65;
        setCheckedViewState(this.F);
    L66:
        this.H.start();
        goto L73
    L65:
        setUncheckViewState(this.F);
        goto L66
    L51:
        r116 = false;
        goto L52
    L45:
        if (j40.m3.f497264a.getValue().booleanValue() == false) goto L47;
        performClick();
        goto L73
    L47:
        toggle();
        goto L73
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (r100 != isChecked()) goto L6;
        postInvalidate();
        return;
    L6:
        f(this.K, false);
    }

    public void setCheckedButtonColor(int r100) {
        this.f112374y = r100;
    }

    public void setEnableDrag(boolean r100) {
        this.L = r100;
    }

    public void setEnableEffect(boolean r100) {
        this.K = r100;
    }

    public void setEnableTouchEvent(boolean r100) {
        this.R = r100;
    }

    public void setOnCheckedChangeListener(e r100) {
        this.S = r100;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.T = r100;
    }

    public void setShadowEffect(boolean r100) {
        if (this.M != r100) goto L5;
        return;
    L5:
        this.M = r100;
        if (r100 == false) goto L8;
        this.B.setShadowLayer(this.f112348a, 0.0f, this.f112349b, this.f112350c);
        return;
    L8:
        this.B.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    }

    public void setSwitchBackgroundColor(int r100) {
        this.f112358k = r100;
    }

    public void setToggleEventInterceptor(f r100) {
        this.U = r100;
    }

    public void setUncheckButtonColor(int r100) {
        this.f112373x = r100;
    }

    public LiveSwitchButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        new RectF();
        this.G = 0;
        this.I = new ArgbEvaluator();
        this.L = true;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.W = new b(this);
        this.f112359k0 = new c(this);
        this.f112365p0 = new d(this);
        c(r100, r101);
    }

    public final void c(Context r100, AttributeSet r110) {
        if (r110 == null) goto L5;
        TypedArray r101 = r100.obtainStyledAttributes(r110, new int[]{R.attr.lsb_background, R.attr.lsb_border_width, R.attr.lsb_button_color, R.attr.lsb_checked, R.attr.lsb_checked_color, R.attr.lsb_checkedbutton_color, R.attr.lsb_checkline_color, R.attr.lsb_checkline_width, R.attr.lsb_effect_duration, R.attr.lsb_enable_effect, R.attr.lsb_shadow_color, R.attr.lsb_shadow_effect, R.attr.lsb_shadow_offset, R.attr.lsb_shadow_radius, R.attr.lsb_show_indicator, R.attr.lsb_uncheck_color, R.attr.lsb_uncheckbutton_color, R.attr.lsb_uncheckcircle_color, R.attr.lsb_uncheckcircle_radius, R.attr.lsb_uncheckcircle_width});
    L7:
        if (r101 != null) goto L9;
        boolean r102 = true;
    L10:
        this.M = r102;
        this.f112367r = d(r101, 17, -5592406);
        int r103 = (int) b(1.5f);
        if (r101 == null) goto L14;
        r103 = r101.getDimensionPixelOffset(19, r103);
    L14:
        this.f112368s = r103;
        this.f112369t = b(10.0f);
        float r104 = b(4.0f);
        if (r101 == null) goto L18;
        r104 = r101.getDimension(18, r104);
    L18:
        this.f112370u = r104;
        this.f112371v = b(4.0f);
        this.f112372w = b(4.0f);
        int r105 = (int) b(2.5f);
        if (r101 == null) goto L22;
        r105 = r101.getDimensionPixelOffset(13, r105);
    L22:
        this.f112348a = r105;
        int r106 = (int) b(1.5f);
        if (r101 == null) goto L26;
        r106 = r101.getDimensionPixelOffset(12, r106);
    L26:
        this.f112349b = r106;
        this.f112350c = d(r101, 10, 855638016);
        this.f112360l = d(r101, 15, -2236963);
        this.f112361m = d(r101, 4, -11414681);
        int r107 = (int) b(1.0f);
        if (r101 == null) goto L30;
        r107 = r101.getDimensionPixelOffset(1, r107);
    L30:
        this.f112362n = r107;
        this.f112363o = d(r101, 6, -1);
        int r108 = (int) b(1.0f);
        if (r101 == null) goto L34;
        r108 = r101.getDimensionPixelOffset(7, r108);
    L34:
        this.f112364p = r108;
        this.f112366q = b(6.0f);
        int r109 = d(r101, 2, -1);
        this.f112373x = d(r101, 16, r109);
        this.f112374y = d(r101, 5, r109);
        int r111 = 300;
        if (r101 == null) goto L39;
        r111 = r101.getInt(8, 300);
    L39:
        if (r101 != null) goto L41;
        boolean r112 = false;
    L42:
        this.f112347J = r112;
        if (r101 != null) goto L45;
        boolean r113 = true;
    L46:
        this.N = r113;
        this.f112358k = d(r101, 0, -1);
        if (r101 != null) goto L49;
        boolean r114 = true;
    L50:
        this.K = r114;
        if (r101 == null) goto L53;
        r101.recycle();
    L53:
        this.C = new Paint(1);
        Paint r115 = new Paint(1);
        this.B = r115;
        r115.setColor(r109);
        if (this.M == false) goto L56;
        this.B.setShadowLayer(this.f112348a, 0.0f, this.f112349b, this.f112350c);
    L56:
        this.D = new g();
        this.E = new g();
        this.F = new g();
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.H = r116;
        r116.setDuration(r111);
        this.H.setRepeatCount(0);
        this.H.addUpdateListener(this.f112359k0);
        this.H.addListener(this.f112365p0);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        setLayerType(1, null);
        com.bytedance.android.livesdk.r3.e(this, new a(this));
        return;
    L49:
        r114 = r101.getBoolean(9, true);
        goto L50
    L45:
        r113 = r101.getBoolean(14, true);
        goto L46
    L41:
        r112 = r101.getBoolean(3, false);
        goto L42
    L9:
        r102 = r101.getBoolean(11, true);
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public final void f(boolean r100, boolean r101) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        if (r101 == false) goto L12;
        f r102 = this.U;
        if (r102 == null) goto L12;
        if (r102.a(!this.f112347J).booleanValue() == false) goto L12;
        return;
    L12:
        if (this.Q == true) goto L41;
        if (this.P == true) goto L20;
        this.f112347J = !this.f112347J;
        if (r101 == false) goto L42;
        a();
        return;
    L42:
        return;
    L20:
        if (this.H.isRunning() == false) goto L23;
        this.H.cancel();
    L23:
        if (this.K == false) goto L32;
        if (r100 == false) goto L32;
        this.G = 5;
        g.a(this.E, this.D);
        if (isChecked() == false) goto L29;
        setUncheckViewState(this.F);
    L30:
        this.H.start();
        return;
    L29:
        setCheckedViewState(this.F);
    L32:
        this.f112347J = !this.f112347J;
        if (isChecked() == false) goto L35;
        setCheckedViewState(this.D);
    L36:
        postInvalidate();
        if (r101 == false) goto L43;
        a();
        return;
    L43:
        return;
    L35:
        setUncheckViewState(this.D);
        goto L36
    L41:
        throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        if (r102 == 0) goto L5;
        if (r102 == Integer.MIN_VALUE) goto L5;
    L6:
        if (r103 == 0) goto L8;
        if (r103 == Integer.MIN_VALUE) goto L8;
    L9:
        super.onMeasure(r100, r101);
        return;
    L8:
        r101 = View.MeasureSpec.makeMeasureSpec(L0, 1073741824);
    L5:
        r100 = View.MeasureSpec.makeMeasureSpec(H0, 1073741824);
        goto L6
    }

    public LiveSwitchButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new RectF();
        this.G = 0;
        this.I = new ArgbEvaluator();
        this.L = true;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.W = new b(this);
        this.f112359k0 = new c(this);
        this.f112365p0 = new d(this);
        c(r100, r101);
    }

    public static int d(TypedArray r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return r102;
    L5:
        return r100.getColor(r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = Math.max(this.f112348a + this.f112349b, this.f112362n);
        float r105 = r101 - r104;
        float r106 = r100 - r104;
        float r107 = (r105 - r104) * 0.5f;
        this.f112351d = r107;
        this.f112352e = r107 - this.f112362n;
        this.f112353f = r104;
        this.f112354g = r104;
        this.f112355h = r106;
        this.f112356i = r105;
        this.f112357j = (r105 + r104) * 0.5f;
        this.f112375z = r104 + r107;
        this.A = r106 - r107;
        if (isChecked() == false) goto L5;
        setCheckedViewState(this.D);
    L6:
        this.P = true;
        postInvalidate();
        return;
    L5:
        setUncheckViewState(this.D);
        goto L6
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(0, 0, 0, 0);
    }
}
