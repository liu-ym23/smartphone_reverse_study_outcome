package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class LiveNumberPicker extends View {
    public static final int U = 0;
    public static final int V = 0;
    public Rect A;
    public int B;
    public int C;
    public Scroller D;
    public Scroller E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f161018J;
    public int K;
    public int L;
    public boolean M;
    public VelocityTracker N;
    public c O;
    public a P;
    public final Set<String> Q;
    public int R;
    public final float S;
    public String[] T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f161019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f161020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextPaint f161021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextPaint f161022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextPaint f161023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f161024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f161025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b[] f161026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f161027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f161028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f161029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f161030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f161031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f161032n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f161033o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f161034p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f161035q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f161036r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f161037s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f161038t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f161039u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f161040v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f161041w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f161042x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f161043y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RectF f161044z;

    public interface a {
        void a();
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f161045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f161046b;

        public b(int r100, int r101) {
            this.f161045a = r100;
            this.f161046b = r101;
        }
    }

    public interface c {
        void a();
    }

    static {
        U = Color.rgb(0, 150, 136);
        V = Color.rgb(0, 150, 136);
    }

    public final void e() {
        int r100 = 0;
    L3:
        b[] r101 = this.f161026h;
        if (r100 >= r101.length) goto L11;
        b r102 = new b((this.f161042x - 3) + r100, this.f161027i + (this.L * r100));
        int r103 = r102.f161045a;
        int[] r104 = this.f161041w;
        if (r103 <= (r104.length - 1)) goto L8;
        r102.f161045a = r103 - r104.length;
    L10:
        r101[r100] = r102;
        r100 = r100 + 1;
        goto L3
    L8:
        if (r103 >= 0) goto L10;
        r102.f161045a = r103 + r104.length;
        goto L10
    }

    public final void a() {
        if (this.E.isFinished() == false) goto L8;
        this.I = 0;
        int r100 = (this.f161027i + (Math.round((this.f161026h[0].f161046b - this.f161027i) / this.L) * this.L)) - this.f161026h[0].f161046b;
        if (r100 == 0) goto L9;
        this.E.startScroll(0, 0, 0, r100, 300);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller r100 = this.D;
        if (r100.isFinished() == true) goto L5;
    L11:
        r100.computeScrollOffset();
        int r101 = r100.getCurrY();
        this.f161018J = r101;
        int r102 = r101 - this.I;
        this.K = r102;
        b(r102);
        invalidate();
        this.I = this.f161018J;
        return;
    L5:
        if (this.B == 0) goto L8;
        this.B = 0;
    L8:
        r100 = this.E;
        if (r100.isFinished() == false) goto L11;
    }

    public final void d() {
        TextPaint r100 = new TextPaint();
        this.f161021c = r100;
        r100.setTextSize(this.f161031m);
        this.f161021c.setColor(this.f161029k);
        this.f161021c.setFlags(1);
        this.f161021c.setTextAlign(Paint.Align.CENTER);
        TextPaint r101 = new TextPaint(this.f161021c);
        this.f161023e = r101;
        r101.setColor(Color.argb((int) (Color.alpha(this.f161029k) * 0.3f), Color.red(this.f161029k), Color.green(this.f161029k), Color.blue(this.f161029k)));
        TextPaint r102 = new TextPaint();
        this.f161022d = r102;
        r102.setTextSize(this.f161040v);
        this.f161022d.setColor(this.f161039u);
        this.f161022d.setFlags(1);
        this.f161022d.setTextAlign(Paint.Align.LEFT);
        Paint r103 = new Paint();
        this.f161024f = r103;
        r103.setColor(this.f161030l);
        this.f161024f.setStyle(Paint.Style.STROKE);
        this.f161024f.setStrokeWidth(this.f161035q);
    }

    public final void f() {
        int r100 = this.f161032n;
        if (r100 < 0) goto L25;
        int r101 = this.f161033o;
        if (r101 < 0) goto L25;
        if (r100 <= r101) goto L9;
        this.f161033o = r100;
    L9:
        if (this.f161034p >= r100) goto L11;
        this.f161034p = r100;
    L11:
        int r102 = this.f161034p;
        int r103 = this.f161033o;
        if (r102 <= r103) goto L14;
        this.f161034p = r103;
    L14:
        String[] r104 = this.T;
        if (r104 == null) goto L17;
        this.f161041w = new int[r104.length];
    L18:
        int r105 = 0;
    L19:
        int[] r106 = this.f161041w;
        if (r105 >= r106.length) goto L22;
        r106[r105] = this.f161032n + r105;
        r105 = r105 + 1;
        goto L19
    L22:
        this.f161042x = this.f161034p - this.f161032n;
        return;
    L17:
        this.f161041w = new int[(r103 - r100) + 1];
    L25:
        throw new IllegalArgumentException("number can not be negative");
    }

    public String getCurrentText() {
        String[] r100 = this.T;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100[this.f161034p];
    }

    public final void c() {
        f();
        d();
        this.f161025g = new Rect();
        this.A = new Rect();
        int r100 = String.valueOf(this.f161033o).length();
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101.append("0");
        r102 = r102 + 1;
        goto L3
    L5:
        String r103 = r101.toString();
        this.f161021c.getTextBounds(r103, 0, r103.length(), this.f161025g);
        String r104 = this.f161038t;
        if (r104 == null) goto L8;
        this.f161022d.getTextBounds(r104, 0, r104.length(), this.A);
    L8:
        ViewConfiguration r105 = ViewConfiguration.get(getContext());
        this.f161043y = ViewConfigurationCompat.getScaledPagingTouchSlop(r105);
        this.F = r105.getScaledMinimumFlingVelocity();
        this.G = r105.getScaledMaximumFlingVelocity() / 8;
        this.D = new Scroller(getContext(), null);
        this.E = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        setFocusable(true);
    }

    public int getCurrNumIndex() {
        return this.f161042x;
    }

    public int getCurrentNumber() {
        return this.f161034p;
    }

    public LiveNumberPicker(Context r100) {
        this(r100, null);
    }

    public final void b(int r100) {
        int r101 = 0;
    L3:
        b[] r102 = this.f161026h;
        if (r101 >= r102.length) goto L28;
        b r103 = r102[r101];
        int r104 = r103.f161046b + r100;
        r103.f161046b = r104;
        int r105 = this.f161028j;
        int r106 = this.L;
        if (r104 < (r105 + r106)) goto L11;
        int r107 = this.R + 2;
        r103.f161046b = r104 - (r106 * r107);
        r103.f161045a -= r107;
    L8:
        b r108 = this.f161026h[r101];
        int r109 = r108.f161045a;
        if (r109 >= 0) goto L11;
        r108.f161045a = r109 + this.f161041w.length;
    L11:
        b r110 = this.f161026h[r101];
        int r111 = r110.f161046b;
        int r112 = this.f161027i;
        int r113 = this.L;
        if (r111 > (r112 - r113)) goto L18;
        int r114 = this.R + 2;
        r110.f161046b = r111 + (r113 * r114);
        r110.f161045a += r114;
    L14:
        b r115 = this.f161026h[r101];
        int r116 = r115.f161045a;
        int[] r117 = this.f161041w;
        if (r116 <= (r117.length - 1)) goto L18;
        r115.f161045a = r116 - r117.length;
    L18:
        if (Math.abs(this.f161026h[r101].f161046b - (this.f161020b / 2)) >= (this.L / 4)) goto L27;
        int r118 = Math.min(this.f161026h[r101].f161045a, this.f161041w.length - 1);
        this.f161042x = r118;
        int r119 = this.f161034p;
        if (r118 < 0) goto L23;
        this.f161034p = this.f161041w[r118];
    L23:
        if (r119 == this.f161034p) goto L27;
        c r120 = this.O;
        if (r120 == null) goto L27;
        r120.a();
    L27:
        r101 = r101 + 1;
        goto L3
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        r110.drawColor(this.H);
        if (this.f161036r != 0.0f) goto L5;
        this.f161036r = this.f161019a;
    L5:
        float r100 = this.f161036r;
        int r101 = this.f161019a;
        if (r100 <= r101) goto L8;
        r100 = r101;
    L8:
        float r102 = r100 / 2.0f;
        float r103 = (r101 / 2) - r102;
        float r104 = r102 + (r101 / 2);
        float r105 = this.f161044z.top;
        r110.drawLine(r103, r105, r104, r105, this.f161024f);
        float r106 = this.f161044z.bottom;
        r110.drawLine(r103, r106, r104, r106, this.f161024f);
        if (this.f161038t == null) goto L11;
        r110.drawText(this.f161038t, (int) (((this.f161019a + this.f161025g.width()) / 2) + (this.S * 4.0f)), ((this.f161020b / 2) + (this.f161025g.height() / 2)) - 4, this.f161022d);
    L11:
        int r107 = 0;
    L12:
        b[] r108 = this.f161026h;
        if (r107 >= r108.length) goto L35;
        int r109 = r108[r107].f161045a;
        if (r109 < 0) goto L34;
        if (r109 > (this.f161033o - this.f161032n)) goto L34;
        if (r109 < 0) goto L25;
        int[] r111 = this.f161041w;
        if (r109 >= r111.length) goto L25;
        String[] r112 = this.T;
        if (r112 == null) goto L24;
        String r113 = r112[r109];
    L27:
        if (this.f161026h[r107].f161045a != this.f161042x) goto L29;
        TextPaint r114 = this.f161021c;
    L31:
        if (isEnabled() == true) goto L33;
        r114 = this.f161023e;
    L33:
        r110.drawText(r113, this.f161019a / 2, this.f161026h[r107].f161046b + (this.f161025g.height() / 2), r114);
        ((HashSet) this.Q).add(r113);
        goto L34
    L29:
        r114 = this.f161023e;
        goto L31
    L24:
        r113 = String.valueOf(r111[r109]);
    L25:
        r113 = "";
    L34:
        r107 = r107 + 1;
        goto L12
    L35:
        ((HashSet) this.Q).clear();
        if (1 == this.C) goto L38;
        return;
    L38:
        if (this.D.isFinished() == false) goto L46;
        a();
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (isEnabled() == true) goto L9;
        a r111 = this.P;
        if (r111 == null) goto L7;
        r111.a();
    L7:
        return false;
    L9:
        if (this.N != null) goto L11;
        this.N = VelocityTracker.obtain();
    L11:
        this.N.addMovement(r110);
        int r100 = MotionEventCompat.getActionMasked(r110);
        this.C = r100;
        if (r100 != 0) goto L22;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.I = (int) r110.getY();
        if (this.D.isFinished() == true) goto L16;
    L17:
        this.D.forceFinished(true);
        this.E.forceFinished(true);
        if (this.B == 0) goto L53;
        this.B = 0;
    L53:
        return true;
    L16:
        if (this.E.isFinished() == true) goto L53;
    L22:
        if (2 != r100) goto L39;
        int r112 = (int) r110.getY();
        this.f161018J = r112;
        int r113 = r112 - this.I;
        this.K = r113;
        if (this.M == false) goto L26;
    L28:
        this.M = true;
        int r114 = this.K;
        int r101 = this.f161043y;
        if (r114 <= r101) goto L32;
        this.K = r114 - r101;
    L34:
        this.I = this.f161018J;
        b(this.K);
        if (this.B == 1) goto L38;
        this.B = 1;
    L38:
        invalidate();
        goto L53
    L32:
        if (r114 >= (-r101)) goto L34;
        this.K = r114 + r101;
        goto L34
    L26:
        if (Math.abs(r113) >= this.f161043y) goto L28;
        return false;
    L39:
        if (1 != r100) goto L53;
        this.M = false;
        VelocityTracker r115 = this.N;
        r115.computeCurrentVelocity(1000, this.G);
        int r102 = (int) r115.getYVelocity();
        if (Math.abs(r102) > this.F) goto L43;
        a();
        invalidate();
    L52:
        this.N.recycle();
        this.N = null;
        goto L53
    L43:
        if (r102 <= 0) goto L45;
        int r116 = (int) (this.f161031m * 10.0f);
        this.I = 0;
        this.D.fling(0, 0, 0, r102, 0, 0, 0, r116);
    L47:
        invalidate();
        if (this.B == 2) goto L52;
        this.B = 2;
        goto L52
    L45:
        if (r102 >= 0) goto L47;
        int r117 = (int) (this.f161031m * 10.0f);
        this.I = r117;
        this.D.fling(0, r117, 0, r102, 0, 0, 0, r117);
        goto L47
    }

    public void setActionListener(a r100) {
        this.P = r100;
    }

    @Override // android.view.View
    public void setSoundEffectsEnabled(boolean r100) {
        super.setSoundEffectsEnabled(r100);
    }

    public LiveNumberPicker(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 != 1073741824) goto L5;
        this.f161019a = r104;
    L6:
        if (r103 != 1073741824) goto L8;
        this.f161020b = r105;
    L9:
        setMeasuredDimension(this.f161019a, this.f161020b);
        if (this.f161044z != null) goto L13;
        RectF r106 = new RectF();
        this.f161044z = r106;
        r106.left = 0.0f;
        r106.right = this.f161019a;
        r106.top = ((this.f161020b - this.f161025g.height()) - this.f161037s) / 2;
        RectF r107 = this.f161044z;
        int r108 = this.f161020b + this.f161025g.height();
        int r109 = this.f161037s;
        r107.bottom = (r108 + r109) / 2;
        int r110 = r109 + this.f161025g.height();
        this.L = r110;
        int r111 = this.f161020b;
        this.f161027i = (r111 / 2) - (r110 * 3);
        this.f161028j = (r111 / 2) + (r110 * 3);
        e();
        return;
    L13:
        return;
    L8:
        this.f161020b = (((this.R * this.f161025g.height()) + ((this.R - 1) * this.f161037s)) + getPaddingTop()) + getPaddingBottom();
        goto L9
    L5:
        this.f161019a = (((this.f161025g.width() + getPaddingLeft()) + getPaddingRight()) + this.A.width()) + 6;
        goto L6
    }

    public LiveNumberPicker(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.B = 0;
        this.C = 3;
        this.Q = new HashSet();
        Resources r103 = getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        this.S = r104;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_backgroundColor, R.attr.ttlive_currentNumber, R.attr.ttlive_dateTextColor, R.attr.ttlive_dateTextSize, R.attr.ttlive_dividerColor, R.attr.ttlive_dividerLength, R.attr.ttlive_dividerStroke, R.attr.ttlive_endNumber, R.attr.ttlive_flagText, R.attr.ttlive_flagTextColor, R.attr.ttlive_flagTextSize, R.attr.ttlive_rowNumber, R.attr.ttlive_startNumber, R.attr.ttlive_verticalSpacing}, r102, 0);
        int r106 = U;
        this.f161029k = r105.getColor(2, r106);
        this.f161031m = r105.getDimension(3, 32.0f * r104);
        this.f161030l = r105.getColor(4, r106);
        this.f161032n = r105.getInteger(12, 0);
        this.f161033o = r105.getInteger(7, 0);
        this.f161034p = r105.getInteger(1, 0);
        this.f161037s = (int) r105.getDimension(13, 16.0f * r104);
        this.f161038t = r105.getString(8);
        this.f161039u = r105.getColor(9, V);
        this.f161040v = r105.getDimension(10, 12.0f * r104);
        this.H = r105.getColor(0, 0);
        this.R = r105.getInteger(11, 5);
        this.f161035q = r105.getDimension(6, r104 * 2.0f);
        this.f161036r = r105.getDimension(5, 0.0f);
        r105.recycle();
        c();
        this.f161026h = new b[this.R + 4];
    }
}
