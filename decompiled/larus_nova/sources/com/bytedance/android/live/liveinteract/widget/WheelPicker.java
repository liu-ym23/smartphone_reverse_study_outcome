package com.bytedance.android.live.liveinteract.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public class WheelPicker extends View implements Runnable {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean H0;
    public final int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f80932J;
    public int K;
    public int L;
    public boolean L0;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public final int S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f80933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f80934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Scroller f80935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f80936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f80937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f80938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f80939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f80940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Camera f80941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f80942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f80943k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f80944k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f80945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f80946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f80947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f80948o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f80949p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f80950p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f80951q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f80952r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f80953s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f80954t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f80955u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f80956v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f80957w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f80958x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f80959y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f80960z;

    public interface a {
    }

    public interface b {
    }

    public final void f() {
        boolean r100 = false;
        this.f80951q = 0;
        this.f80952r = 0;
        if (this.T == false) goto L5;
        this.f80951q = (int) this.f80934b.measureText(String.valueOf(ListProtector.get(this.f80945l, 0)));
    L19:
        Paint.FontMetrics r101 = this.f80934b.getFontMetrics();
        this.f80952r = (int) (r101.bottom - r101.top);
        return;
    L5:
        int r102 = this.P;
        if (r102 >= 0) goto L8;
    L10:
        if (r100 == false) goto L13;
        this.f80951q = (int) this.f80934b.measureText(String.valueOf(ListProtector.get(this.f80945l, this.P)));
        goto L19
    L13:
        if (TextUtils.isEmpty(this.f80946m) == true) goto L15;
        this.f80951q = (int) this.f80934b.measureText(this.f80946m);
        goto L19
    L15:
        Iterator r103 = this.f80945l.iterator();
    L17:
        if (r103.hasNext() == false) goto L19;
        String r104 = String.valueOf(r103.next());
        int r105 = (int) this.f80934b.measureText(r104);
        this.f80951q = Math.max(this.f80951q, r105);
        goto L17
    L8:
        if (r102 >= this.f80945l.size()) goto L10;
        r100 = true;
        goto L10
    }

    public void setOnItemSelectedListener(a r100) {
    }

    public void setOnWheelChangeListener(b r100) {
    }

    public final void a() {
        List r100 = this.f80945l;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() != 0) goto L8;
        return;
    L8:
        if (this.f80935c.isFinished() == false) goto L19;
        if (this.L0 == true) goto L19;
        int r101 = this.B;
        if (r101 != 0) goto L14;
        return;
    L14:
        int r102 = (((-this.O) / r101) + this.E) % this.f80945l.size();
        if (r102 >= 0) goto L17;
        r102 = r102 + this.f80945l.size();
    L17:
        this.F = r102;
    L19:
        if (this.f80935c.computeScrollOffset() == false) goto L23;
        this.O = this.f80935c.getCurrY();
        postInvalidate();
        this.f80933a.postDelayed(this, 16);
        return;
    }

    public final void b() {
        if (this.V == false) goto L5;
    L7:
        Rect r100 = this.f80940h;
        Rect r101 = this.f80937e;
        int r102 = r101.left;
        int r103 = this.L;
        int r104 = this.C;
        r100.set(r102, r103 - r104, r101.right, r103 + r104);
        return;
    L5:
        if (this.f80954t != (-1)) goto L7;
    }

    public final void c() {
        int r100 = this.A;
        if (r100 != 1) goto L5;
        this.M = this.f80937e.left;
    L9:
        this.N = (int) (this.L - ((this.f80934b.ascent() + this.f80934b.descent()) / 2.0f));
        return;
    L5:
        if (r100 == 2) goto L7;
        this.M = this.K;
        goto L9
    L7:
        this.M = this.f80937e.right;
        goto L9
    }

    public final void d() {
        int r100 = this.E;
        int r101 = this.B;
        int r102 = r100 * r101;
        if (this.f80944k0 == false) goto L5;
        int r103 = Integer.MIN_VALUE;
    L6:
        this.G = r103;
        if (this.f80944k0 == false) goto L9;
        r102 = Integer.MAX_VALUE;
    L9:
        this.H = r102;
        return;
    L5:
        r103 = ((-r101) * (this.f80945l.size() - 1)) + r102;
        goto L6
    }

    public final void e() {
        if (this.U == true) goto L5;
        return;
    L5:
        int r100 = this.f80957w / 2;
        int r101 = this.L;
        int r102 = this.C;
        int r103 = r101 + r102;
        int r104 = r101 - r102;
        Rect r105 = this.f80938f;
        Rect r106 = this.f80937e;
        r105.set(r106.left, r103 - r100, r106.right, r103 + r100);
        Rect r107 = this.f80939g;
        Rect r108 = this.f80937e;
        r107.set(r108.left, r104 - r100, r108.right, r104 + r100);
    }

    public Typeface getTypeface() {
        Paint r100 = this.f80934b;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTypeface();
    }

    public final void h() {
        int r100 = this.A;
        if (r100 != 1) goto L5;
        this.f80934b.setTextAlign(Paint.Align.LEFT);
        return;
    L5:
        if (r100 == 2) goto L7;
        this.f80934b.setTextAlign(Paint.Align.CENTER);
        return;
    L7:
        this.f80934b.setTextAlign(Paint.Align.RIGHT);
    }

    public final void i() {
        int r100 = this.f80947n;
        if (r100 < 2) goto L10;
        if ((r100 % 2) != 0) goto L7;
        this.f80947n = r100 + 1;
    L7:
        int r101 = this.f80947n + 2;
        this.f80948o = r101;
        this.f80949p = r101 / 2;
        return;
    L10:
        throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
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

    static {
    }

    public int getCurrentItemPosition() {
        return this.F;
    }

    public int getCurtainColor() {
        return this.f80959y;
    }

    public List getData() {
        return this.f80945l;
    }

    public int getIndicatorColor() {
        return this.f80958x;
    }

    public int getIndicatorSize() {
        return this.f80957w;
    }

    public int getItemAlign() {
        return this.A;
    }

    public int getItemSpace() {
        return this.f80960z;
    }

    public int getItemTextColor() {
        return this.f80953s;
    }

    public int getItemTextSize() {
        return this.f80955u;
    }

    public String getMaximumWidthText() {
        return this.f80946m;
    }

    public int getMaximumWidthTextPosition() {
        return this.P;
    }

    public int getSelectedItemPosition() {
        return this.E;
    }

    public int getSelectedItemTextColor() {
        return this.f80954t;
    }

    public int getVisibleItemCount() {
        return this.f80947n;
    }

    public WheelPicker(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        int r100 = (-this.O) / this.B;
        int r101 = this.f80949p;
        int r102 = r100 - r101;
        int r103 = this.E + r102;
        int r104 = -r101;
    L4:
        if (r103 >= ((this.E + r102) + this.f80948o)) goto L70;
        if (this.f80944k0 == false) goto L11;
        int r105 = r103 % this.f80945l.size();
        if (r105 >= 0) goto L10;
        r105 = r105 + this.f80945l.size();
    L10:
        String r106 = String.valueOf(ListProtector.get(this.f80945l, r105));
    L19:
        this.f80934b.setColor(this.f80953s);
        this.f80934b.setTextSize(this.f80955u);
        this.f80934b.setStyle(Paint.Style.FILL);
        int r107 = this.N;
        int r108 = this.B;
        int r110 = ((r104 * r108) + r107) + (this.O % r108);
        if (this.f80950p0 == false) goto L41;
        int r109 = r107 - Math.abs(r107 - r110);
        int r111 = this.f80937e.top;
        int r112 = this.N;
        float r113 = ((r109 - r111) * 1.0f) / (r112 - r111);
        if (r110 <= r112) goto L24;
        int r114 = 1;
    L27:
        float r115 = 90.0f;
        float r116 = ((-(1.0f - r113)) * 90.0f) * r114;
        if (r116 >= (-90.0f)) goto L31;
        r116 = -90.0f;
    L31:
        if (r116 > 90.0f) goto L34;
        r115 = r116;
    L34:
        double r117 = (int) r115;
        int r118 = (int) (((double) this.D) * Math.sin(Math.toRadians(r117)));
        int r119 = this.K;
        int r120 = this.A;
        if (r120 == 1) goto L39;
        if (r120 != 2) goto L40;
        r119 = this.f80937e.right;
    L40:
        int r121 = this.L - r118;
        this.f80941i.save();
        this.f80941i.rotateX(r115);
        this.f80941i.getMatrix(this.f80942j);
        this.f80941i.restore();
        float r122 = -r119;
        float r123 = -r121;
        this.f80942j.preTranslate(r122, r123);
        float r124 = r119;
        float r125 = r121;
        this.f80942j.postTranslate(r124, r125);
        this.f80941i.save();
        this.f80941i.translate(0.0f, 0.0f, (int) (((double) this.D) - (Math.cos(Math.toRadians(r117)) * ((double) this.D))));
        this.f80941i.getMatrix(this.f80943k);
        this.f80941i.restore();
        this.f80943k.preTranslate(r122, r123);
        this.f80943k.postTranslate(r124, r125);
        this.f80942j.postConcat(this.f80943k);
    L43:
        if (this.W == false) goto L49;
        int r126 = this.N;
        int r127 = (int) ((((r126 - Math.abs(r126 - r110)) * 1.0f) / this.N) * 255.0f);
        if (r127 >= 0) goto L47;
        r127 = 0;
    L47:
        this.f80934b.setAlpha(r127);
    L49:
        if (this.f80950p0 == false) goto L52;
        r110 = this.N - r118;
    L52:
        if (this.f80954t == (-1)) goto L64;
        r210.save();
        if (this.f80950p0 == false) goto L57;
        r210.concat(this.f80942j);
    L57:
        if (r110 >= this.f80940h.bottom) goto L59;
        RectF r128 = new RectF(this.f80940h);
        r128.bottom = r128.top;
        r128.top = 0.0f;
        r210.clipRect(r128);
    L60:
        r210.clipRect(this.f80940h, Region.Op.DIFFERENCE);
        float r129 = r110;
        String r130 = r106;
        r210.drawText(r130, this.M, r129, this.f80934b);
        r210.restore();
        this.f80934b.setColor(this.f80954t);
        this.f80934b.setTextSize(this.f80956v);
        r210.save();
        if (this.f80950p0 == false) goto L63;
        r210.concat(this.f80942j);
    L63:
        r210.clipRect(this.f80940h);
        r210.drawText(r130, this.M, (int) (r129 + (((this.f80934b.descent() - this.f80934b.ascent()) / 2.0f) - (this.f80952r / 2))), this.f80934b);
        r210.restore();
    L68:
        r103 = r103 + 1;
        r104 = r104 + 1;
        r102 = r102;
        goto L4
    L59:
        RectF r131 = new RectF(this.f80940h);
        r131.top = r131.bottom;
        r131.bottom = getBottom();
        r210.clipRect(r131);
        goto L60
    L64:
        String r132 = r106;
        r210.save();
        r210.clipRect(this.f80937e);
        if (this.f80950p0 == false) goto L67;
        r210.concat(this.f80942j);
    L67:
        r210.drawText(r132, this.M, r110, this.f80934b);
        r210.restore();
        goto L68
    L39:
        r119 = this.f80937e.left;
        goto L40
    L24:
        if (r110 >= r112) goto L26;
        r114 = -1;
        goto L27
    L26:
        r114 = 0;
        goto L27
    L41:
        r118 = 0;
        goto L43
    L11:
        if (r103 >= 0) goto L13;
    L15:
        boolean r133 = false;
    L16:
        if (r133 == false) goto L18;
        r106 = String.valueOf(ListProtector.get(this.f80945l, r103));
        goto L19
    L18:
        r106 = "";
        goto L19
    L13:
        if (r103 >= this.f80945l.size()) goto L15;
        r133 = true;
        goto L16
    L70:
        if (this.V == false) goto L73;
        this.f80934b.setColor(this.f80959y);
        this.f80934b.setStyle(Paint.Style.FILL);
        r210.drawRect(this.f80940h, this.f80934b);
    L73:
        if (this.U == false) goto L79;
        this.f80934b.setColor(this.f80958x);
        this.f80934b.setStyle(Paint.Style.FILL);
        r210.drawRect(this.f80938f, this.f80934b);
        r210.drawRect(this.f80939g, this.f80934b);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        if (r100 == 0) goto L64;
        if (r100 == 1) goto L25;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L12;
    L74:
        return true;
    L12:
        if (getParent() == null) goto L14;
        getParent().requestDisallowInterceptTouchEvent(false);
    L14:
        VelocityTracker r111 = this.f80936d;
        if (r111 == null) goto L74;
        r111.recycle();
        this.f80936d = null;
        goto L74
    L18:
        if (Math.abs(this.R - r110.getY()) >= this.S) goto L20;
        this.H0 = true;
        goto L74
    L20:
        this.H0 = false;
        this.f80936d.addMovement(r110);
        float r101 = r110.getY() - this.Q;
        if (Math.abs(r101) < 1.0f) goto L74;
        this.O = (int) (this.O + r101);
        this.Q = (int) r110.getY();
        invalidate();
        goto L74
    L25:
        if (getParent() == null) goto L28;
        getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        if (this.H0 == true) goto L30;
    L32:
        this.f80936d.addMovement(r110);
        this.f80936d.computeCurrentVelocity(1000, this.f80932J);
        this.L0 = false;
        int r102 = (int) this.f80936d.getYVelocity();
        if (Math.abs(r102) <= this.I) goto L43;
        this.f80935c.fling(0, this.O, 0, r102, 0, 0, this.G, this.H);
        Scroller r112 = this.f80935c;
        int r103 = r112.getFinalY();
        int r104 = this.f80935c.getFinalY() % this.B;
        if (Math.abs(r104) > this.C) goto L37;
        int r105 = -r104;
    L42:
        r112.setFinalY(r103 + r105);
    L53:
        if (this.f80944k0 == true) goto L60;
        int r113 = this.f80935c.getFinalY();
        int r106 = this.H;
        if (r113 <= r106) goto L57;
        this.f80935c.setFinalY(r106);
        goto L60
    L57:
        int r114 = this.f80935c.getFinalY();
        int r107 = this.G;
        if (r114 >= r107) goto L60;
        this.f80935c.setFinalY(r107);
    L60:
        this.f80933a.post(this);
        VelocityTracker r115 = this.f80936d;
        if (r115 == null) goto L74;
        r115.recycle();
        this.f80936d = null;
        goto L74
    L37:
        if (this.O >= 0) goto L39;
        int r108 = -this.B;
    L40:
        r105 = r108 - r104;
        goto L42
    L39:
        r108 = this.B;
        goto L40
    L43:
        Scroller r116 = this.f80935c;
        int r109 = this.O;
        int r117 = r109 % this.B;
        if (Math.abs(r117) > this.C) goto L46;
        int r118 = -r117;
    L51:
        r116.startScroll(0, r109, 0, r118);
        goto L53
    L46:
        if (this.O >= 0) goto L48;
        int r119 = -this.B;
    L49:
        r118 = r119 - r117;
        goto L51
    L48:
        r119 = this.B;
        goto L49
    L30:
        if (this.L0 == true) goto L32;
    L64:
        if (getParent() == null) goto L66;
        getParent().requestDisallowInterceptTouchEvent(true);
    L66:
        VelocityTracker r120 = this.f80936d;
        if (r120 != null) goto L69;
        this.f80936d = VelocityTracker.obtain();
    L70:
        this.f80936d.addMovement(r110);
        if (this.f80935c.isFinished() == true) goto L73;
        this.f80935c.abortAnimation();
        this.L0 = true;
    L73:
        int r121 = (int) r110.getY();
        this.Q = r121;
        this.R = r121;
        goto L74
    L69:
        r120.clear();
        goto L70
    }

    public void setAtmospheric(boolean r100) {
        this.W = r100;
        invalidate();
    }

    public void setCurtain(boolean r100) {
        this.V = r100;
        b();
        invalidate();
    }

    public void setCurtainColor(int r100) {
        this.f80959y = r100;
        invalidate();
    }

    public void setCurved(boolean r100) {
        this.f80950p0 = r100;
        requestLayout();
        invalidate();
    }

    public void setCyclic(boolean r100) {
        this.f80944k0 = r100;
        d();
        invalidate();
    }

    public void setData(List r100) {
        if (r100 == null) goto L13;
        this.f80945l = r100;
        if (this.E <= (r100.size() - 1)) goto L6;
    L9:
        int r101 = r100.size() - 1;
        this.F = r101;
        this.E = r101;
    L10:
        this.O = 0;
        f();
        d();
        requestLayout();
        invalidate();
        return;
    L6:
        if (this.F > (r100.size() - 1)) goto L9;
        this.E = this.F;
        goto L10
    L13:
        throw new NullPointerException("WheelPicker's data can not be null!");
    }

    public void setIndicator(boolean r100) {
        this.U = r100;
        e();
        invalidate();
    }

    public void setIndicatorColor(int r100) {
        this.f80958x = r100;
        invalidate();
    }

    public void setIndicatorSize(int r100) {
        this.f80957w = r100;
        e();
        invalidate();
    }

    public void setItemAlign(int r100) {
        this.A = r100;
        h();
        c();
        invalidate();
    }

    public void setItemSpace(int r100) {
        this.f80960z = r100;
        requestLayout();
        invalidate();
    }

    public void setItemTextColor(int r100) {
        this.f80953s = r100;
        invalidate();
    }

    public void setItemTextSize(int r100) {
        this.f80955u = r100;
        this.f80934b.setTextSize(r100);
        f();
        requestLayout();
        invalidate();
    }

    public void setMaximumWidthText(String r100) {
        if (r100 == null) goto L6;
        this.f80946m = r100;
        f();
        requestLayout();
        invalidate();
        return;
    L6:
        throw new NullPointerException("Maximum width text can not be null!");
    }

    public void setMaximumWidthTextPosition(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == false) goto L11;
        this.P = r100;
        f();
        requestLayout();
        invalidate();
        return;
    L11:
        throw new ArrayIndexOutOfBoundsException("Maximum width text Position must in [0, " + this.f80945l.size() + "), but current is " + r100);
    L4:
        if (r100 >= this.f80945l.size()) goto L6;
        r101 = true;
        goto L7
    }

    public void setSameWidth(boolean r100) {
        this.T = r100;
        f();
        requestLayout();
        invalidate();
    }

    public void setSelectItemTextSize(int r100) {
        this.f80956v = r100;
    }

    public void setSelectedItemPosition(int r100) {
        g(r100, true);
    }

    public void setSelectedItemTextColor(int r100) {
        this.f80954t = r100;
        b();
        invalidate();
    }

    public void setTypeface(Typeface r100) {
        Paint r101 = this.f80934b;
        if (r101 == null) goto L5;
        r101.setTypeface(r100);
    L5:
        f();
        requestLayout();
        invalidate();
    }

    public void setVisibleItemCount(int r100) {
        this.f80947n = r100;
        i();
        requestLayout();
    }

    public WheelPicker(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f80933a = new Handler();
        this.I = 50;
        this.f80932J = 8000;
        this.S = 8;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_wheel_font_path, R.attr.ttlive_wheel_item_align, R.attr.wheel_atmospheric, R.attr.wheel_curtain, R.attr.wheel_curtain_color, R.attr.wheel_curved, R.attr.wheel_cyclic, R.attr.wheel_data, R.attr.wheel_indicator, R.attr.wheel_indicator_color, R.attr.wheel_indicator_size, R.attr.wheel_item_space, R.attr.wheel_item_text_color, R.attr.wheel_item_text_size, R.attr.wheel_maximum_width_text, R.attr.wheel_maximum_width_text_position, R.attr.wheel_same_width, R.attr.wheel_selected_item_position, R.attr.wheel_selected_item_text_color, R.attr.wheel_selected_item_text_size, R.attr.wheel_visible_item_count});
        int r103 = r102.getResourceId(7, 0);
        if (r103 != 0) goto L5;
        this.f80945l = new ArrayList();
    L6:
        this.f80947n = r102.getInt(20, 7);
        this.E = r102.getInt(17, 0);
        this.T = r102.getBoolean(16, false);
        this.P = r102.getInt(15, -1);
        this.f80946m = r102.getString(14);
        this.f80954t = r102.getColor(18, -1);
        this.f80953s = r102.getColor(12, FakePickerAvatarCreator.GRAY);
        this.f80944k0 = r102.getBoolean(6, false);
        this.U = r102.getBoolean(8, false);
        this.f80958x = r102.getColor(9, -2105377);
        this.V = r102.getBoolean(3, false);
        this.f80959y = r102.getColor(4, -1996488705);
        this.W = r102.getBoolean(2, false);
        this.f80950p0 = r102.getBoolean(5, false);
        this.A = r102.getInt(1, 0);
        String r104 = r102.getString(0);
        r102.recycle();
        i();
        Paint r105 = new Paint(69);
        this.f80934b = r105;
        r105.setTextSize(this.f80955u);
        if (r104 == null) goto L9;
        setTypeface(Typeface.createFromAsset(r100.getAssets(), r104));
    L9:
        h();
        f();
        this.f80935c = new Scroller(getContext());
        ViewConfiguration r106 = ViewConfiguration.get(getContext());
        this.I = r106.getScaledMinimumFlingVelocity();
        this.f80932J = r106.getScaledMaximumFlingVelocity();
        this.S = r106.getScaledTouchSlop();
        this.f80937e = new Rect();
        this.f80938f = new Rect();
        this.f80939g = new Rect();
        this.f80940h = new Rect();
        this.f80941i = new Camera();
        this.f80942j = new Matrix();
        this.f80943k = new Matrix();
        return;
    L5:
        this.f80945l = Arrays.asList(getResources().getStringArray(r103));
        goto L6
    }

    public final void g(int r100, boolean r101) {
        if (r101 == false) goto L18;
        if (this.f80935c.isFinished() == false) goto L18;
        int r102 = getData().size();
        int r103 = r100 - this.F;
        if (r103 != 0) goto L10;
        return;
    L10:
        if (this.f80944k0 == true) goto L12;
    L16:
        Scroller r104 = this.f80935c;
        r104.startScroll(0, r104.getCurrY(), 0, (-r103) * this.B);
        this.f80933a.post(this);
        return;
    L12:
        if (Math.abs(r103) <= (r102 / 2)) goto L16;
        if (r103 <= 0) goto L15;
        r102 = -r102;
    L15:
        r103 = r103 + r102;
    L18:
        if (this.f80935c.isFinished() == true) goto L20;
        this.f80935c.abortAnimation();
    L20:
        int r105 = Math.max(Math.min(r100, this.f80945l.size() - 1), 0);
        this.E = r105;
        this.F = r105;
        this.O = 0;
        d();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        int r106 = this.f80951q;
        int r107 = this.f80952r;
        int r108 = this.f80947n;
        int r109 = (r107 * r108) + (this.f80960z * (r108 - 1));
        if (this.f80950p0 == false) goto L5;
        r109 = (int) (((double) (r109 * 2)) / 3.141592653589793d);
    L5:
        int r110 = r106 + (getPaddingLeft() + getPaddingRight());
        int r111 = r109 + (getPaddingTop() + getPaddingBottom());
        if (r102 == 1073741824) goto L11;
        if (r102 != Integer.MIN_VALUE) goto L10;
        r104 = Math.min(r110, r104);
        goto L11
    L10:
        r104 = r110;
    L11:
        if (r103 == 1073741824) goto L16;
        if (r103 != Integer.MIN_VALUE) goto L15;
        r105 = Math.min(r111, r105);
        goto L16
    L15:
        r105 = r111;
    L16:
        setMeasuredDimension(r104, r105);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        this.f80937e.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.K = this.f80937e.centerX();
        this.L = this.f80937e.centerY();
        c();
        this.D = this.f80937e.height() / 2;
        int r104 = this.f80937e.height() / this.f80947n;
        this.B = r104;
        this.C = r104 / 2;
        d();
        e();
        b();
    }
}
