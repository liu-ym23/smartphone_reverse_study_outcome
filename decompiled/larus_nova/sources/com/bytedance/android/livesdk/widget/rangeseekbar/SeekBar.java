package com.bytedance.android.livesdk.widget.rangeseekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.larus.nova.R;
import java.text.DecimalFormat;
import ov2.c;

/* JADX INFO: loaded from: classes11.dex */
public final class SeekBar {
    public float A;
    public float B;
    public boolean C;
    public final boolean D;
    public Bitmap E;
    public Bitmap F;
    public Bitmap G;
    public ValueAnimator H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f161984J;
    public boolean K;
    public final RangeSeekBar L;
    public String M;
    public final Path N;
    public final Rect O;
    public final Rect P;
    public final Paint Q;
    public DecimalFormat R;
    public int S;
    public int T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f161985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f161986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f161987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f161988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f161989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f161990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f161991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f161992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f161993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f161994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f161995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f161996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f161997m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f161998n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f161999o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f162000p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f162001q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f162002r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f162003s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f162004t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f162005u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f162006v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f162007w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f162008x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f162009y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f162010z;

    public @interface IndicatorModeDef {
    }

    public @interface IndicatorTextStyleDef {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBar f162011a;

        public a(SeekBar r100) {
            this.f162011a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            SeekBar r101 = this.f162011a;
            r101.B = ((Float) r100.getAnimatedValue()).floatValue();
            RangeSeekBar r102 = this.f162011a.L;
            if (r102 == null) goto L6;
            r102.invalidate();
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBar f162012a;

        public b(SeekBar r100) {
            this.f162012a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SeekBar r101 = this.f162012a;
            r101.B = 0.0f;
            RangeSeekBar r102 = r101.L;
            if (r102 == null) goto L6;
            r102.invalidate();
            return;
        }
    }

    public final int c() {
        int r100 = this.f161988d;
        if (r100 <= 0) goto L11;
        if (this.G == null) goto L9;
        int r101 = this.f161990f;
    L8:
        return r100 + r101;
    L9:
        r100 = r100 + this.f161992h;
        r101 = this.f161990f;
        goto L8
    L11:
        if (this.G == null) goto L13;
        r100 = (c.e("8", this.f161993i).height() + this.f161999o) + this.f162000p;
        r101 = this.f161990f;
        goto L8
    L13:
        r100 = ((c.e("8", this.f161993i).height() + this.f161999o) + this.f162000p) + this.f161990f;
        r101 = this.f161992h;
        goto L8
    }

    public final float d() {
        return this.f162004t * this.f162006v;
    }

    public final float e() {
        return this.f162003s * this.f162006v;
    }

    public final void f() {
        int r100 = this.f161991g;
        if (r100 == 0) goto L5;
        this.f161991g = r100;
        this.G = BitmapFactory.decodeResource(getResources(), r100);
    L5:
        k(this.f162001q, this.f162003s, this.f162004t);
        int r101 = this.f162002r;
        int r102 = this.f162003s;
        int r103 = this.f162004t;
        if (r101 != 0) goto L8;
        return;
    L8:
        if (getResources() == null) goto L12;
        this.f162002r = r101;
        this.F = c.c(r102, r103, getResources().getDrawable(r101, null));
        return;
    }

    public final void g() {
        this.S = this.f162003s;
        this.T = this.f162004t;
        if (this.f161988d != (-1)) goto L6;
        this.f161988d = (c.e("8", this.f161993i).height() + this.f161999o) + this.f162000p;
    L6:
        if (this.f161992h > 0) goto L9;
        this.f161992h = this.f162003s / 4;
        return;
    }

    public Context getContext() {
        return this.L.getContext();
    }

    public final void h() {
        ValueAnimator r100 = this.H;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{this.B, 0.0f});
        this.H = r101;
        r101.addUpdateListener(new a(this));
        this.H.addListener(new b(this));
        this.H.start();
    }

    public Resources getResources() {
        if (getContext() != null) goto L5;
        return null;
    L5:
        return getContext().getResources();
    }

    public final void b(Canvas r110) {
        if (this.K == true) goto L5;
        return;
    L5:
        r110.save();
        r110.translate(((int) (this.L.getProgressWidth() * this.A)) + this.f162007w, 0.0f);
        Paint r100 = this.Q;
        String r101 = this.I;
        ov2.b[] r102 = this.L.getRangeSeekBarState();
        if (TextUtils.isEmpty(r101) == true) goto L8;
    L17:
        String r103 = this.M;
        if (r103 == null) goto L21;
        r101 = String.format(r103, new Object[]{r101});
    L21:
        if (this.C == false) goto L80;
        if (TextUtils.isEmpty(r101) == true) goto L80;
        r100.setTextSize(this.f161993i);
        r100.setStyle(Paint.Style.FILL);
        r100.setColor(this.f161996l);
        r100.getTextBounds(r101, 0, r101.length(), this.O);
        int r104 = (this.O.width() + this.f161997m) + this.f161998n;
        int r105 = this.f161989e;
        if (r105 <= r104) goto L28;
        r104 = r105;
    L28:
        int r106 = (this.O.height() + this.f161999o) + this.f162000p;
        int r111 = this.f161988d;
        if (r111 <= r106) goto L31;
        r106 = r111;
    L31:
        Rect r112 = this.P;
        int r113 = this.S;
        int r114 = (int) ((r113 / 2.0f) - (r104 / 2.0f));
        r112.left = r114;
        r112.right = r114 + r104;
        int r115 = this.f161986b;
        if (r115 != 0) goto L34;
        r112.top = ((this.f162010z - this.T) - r106) - this.f161990f;
    L35:
        int r107 = r112.top;
        int r116 = r107 + r106;
        r112.bottom = r116;
        if (this.G == null) goto L38;
    L44:
        int r108 = c.b(getContext(), 1.0f);
        int r109 = (((this.P.width() / 2) - ((int) (this.L.getProgressWidth() * this.A))) - this.L.getProgressLeft()) + r108;
        int r117 = (((this.P.width() / 2) - ((int) (this.L.getProgressWidth() * (1.0f - this.A)))) - this.L.getProgressPaddingRight()) + r108;
        if (r109 <= 0) goto L47;
        Rect r118 = this.P;
        r118.left += r109;
        r118.right += r109;
    L49:
        Bitmap r119 = this.G;
        if (r119 == null) goto L58;
        Rect r120 = this.P;
        if (NinePatch.isNinePatchChunk(r119.getNinePatchChunk()) == false) goto L56;
        NinePatch.isNinePatchChunk(r119.getNinePatchChunk());     // Catch: Exception -> L97
        new NinePatch(r119, r119.getNinePatchChunk(), null).draw(r110, r120);     // Catch: Exception -> L97
    L63:
        int r121 = this.f161997m;
        if (r121 <= 0) goto L66;
        int r122 = this.P.left;
    L70:
        int r123 = r122 + r121;
    L72:
        if (this.f161999o <= 0) goto L75;
        int r124 = (this.P.top + this.O.height()) + this.f161999o;
    L78:
        r100.setColor(this.f161994j);
        r110.drawText(r101, r123, r124, r100);
        goto L80
    L75:
        if (this.f162000p <= 0) goto L77;
        r124 = (this.P.bottom - this.O.height()) - this.f162000p;
        goto L78
    L77:
        r124 = (this.P.bottom - ((r106 - this.O.height()) / 2)) + 1;
        goto L78
    L66:
        int r125 = this.f161998n;
        if (r125 <= 0) goto L69;
        r123 = (this.P.right - r125) - this.O.width();
        goto L72
    L69:
        r121 = this.P.left;
        r122 = (r104 - this.O.width()) / 2;
    L56:
        r110.drawBitmap(r119, r120.left, r120.top, r100);
        goto L63
    L58:
        if (this.f161987c == false) goto L63;
        if (this.f161995k <= 0.0f) goto L62;
        RectF r126 = new RectF(this.P);
        float r127 = this.f161995k;
        r110.drawRoundRect(r126, r127, r127, r100);
        goto L63
    L62:
        r110.drawRect(this.P, r100);
        goto L63
    L47:
        if (r117 <= 0) goto L49;
        Rect r128 = this.P;
        r128.left -= r117;
        r128.right -= r117;
        goto L49
    L38:
        if (this.f161987c == false) goto L44;
        int r129 = r113 / 2;
        int r130 = this.f161992h;
        int r131 = r129 - r130;
        int r132 = r129 + r130;
        if (r115 != 0) goto L42;
        int r133 = r116 - r130;
        r112.top = r107 - r130;
        r112.bottom = r133;
        r107 = r116;
    L43:
        this.N.reset();
        this.N.moveTo(r129, r107);
        float r134 = r133;
        this.N.lineTo(r131, r134);
        this.N.lineTo(r132, r134);
        this.N.close();
        r110.drawPath(this.N, r100);
        goto L44
    L42:
        r133 = r107 + r130;
        r112.top = r133;
        r112.bottom = r116 + r130;
        goto L43
    L34:
        r112.top = (this.f162010z + ((this.T - this.f162004t) / 2)) + this.f161990f;
    L80:
        if (this.f161984J == false) goto L88;
        Bitmap r135 = this.F;
        if (r135 == null) goto L84;
        r110.drawBitmap(r135, 0.0f, this.L.getProgressTop() + ((this.L.getProgressHeight() - this.T) / 2.0f), null);
    L95:
        r110.restore();
        return;
    L84:
        int r136 = this.f162005u;
        if (r136 == 0) goto L87;
        this.Q.setColor(r136);
        float r137 = this.L.getProgressTop() + ((this.L.getProgressHeight() - this.f162004t) / 2.0f);
        RectF r138 = new RectF(0.0f, r137, this.S + 0.0f, this.T + r137);
        r110.drawOval(r138, this.Q);
        this.Q.setColor(-1);
        r138.left += 1.0f;
        r138.top += 1.0f;
        r138.bottom -= 1.0f;
        r138.right -= 1.0f;
        r110.drawOval(r138, this.Q);
        goto L95
    L87:
        this.Q.setColor(-1);
        float r139 = this.L.getProgressTop() + ((this.L.getProgressHeight() - this.f162004t) / 2.0f);
        r110.drawOval(new RectF(0.0f, r139, this.S + 0.0f, this.T + r139), this.Q);
        goto L95
    L88:
        Bitmap r140 = this.E;
        if (r140 == null) goto L91;
        r110.drawBitmap(r140, 0.0f, this.L.getProgressTop() + ((this.L.getProgressHeight() - this.f162004t) / 2.0f), null);
        goto L95
    L91:
        int r141 = this.f162005u;
        if (r141 == 0) goto L94;
        this.Q.setColor(r141);
        float r142 = this.L.getProgressTop() + ((this.L.getProgressHeight() - this.f162004t) / 2.0f);
        RectF r143 = new RectF(0.0f, r142, this.f162003s + 0.0f, this.f162004t + r142);
        r110.drawOval(r143, this.Q);
        this.Q.setColor(-1);
        r143.left += 1.0f;
        r143.top += 1.0f;
        r143.bottom -= 1.0f;
        r143.right -= 1.0f;
        r110.drawOval(r143, this.Q);
        goto L95
    L94:
        this.Q.setColor(-1);
        float r144 = this.L.getProgressTop() + ((this.L.getProgressHeight() - this.f162004t) / 2.0f);
        r110.drawOval(new RectF(0.0f, r144, this.f162003s + 0.0f, this.f162004t + r144), this.Q);
        goto L95
    L8:
        if (this.D == false) goto L13;
        DecimalFormat r145 = this.R;
        if (r145 == null) goto L12;
        r101 = r145.format(r102[0].f526873b);
        goto L17
    L12:
        r101 = r102[0].f526872a;
        goto L17
    L13:
        DecimalFormat r146 = this.R;
        if (r146 == null) goto L16;
        r101 = r146.format(r102[1].f526873b);
        goto L17
    L16:
        r101 = r102[1].f526872a;
        goto L17
    }

    public final void j(boolean r100) {
        int r101 = this.f161985a;
        if (r101 != 0) goto L5;
        this.C = r100;
        return;
    L5:
        if (r101 != 1) goto L7;
        this.C = false;
        return;
    L7:
        if (r101 != 2) goto L9;
    L11:
        this.C = true;
        return;
    L9:
        if (r101 == 3) goto L11;
    }

    public final void l(float r100) {
        if (r100 >= 0.0f) goto L6;
        r100 = 0.0f;
    L8:
        this.A = r100;
        return;
    L6:
        if (r100 <= 1.0f) goto L8;
        r100 = 1.0f;
        goto L8
    }

    public final boolean a(float r100, float r101) {
        int r102 = (int) (this.L.getProgressWidth() * this.A);
        if (r100 > (this.f162007w + r102)) goto L5;
    L11:
        return false;
    L5:
        if (r100 >= (this.f162008x + r102)) goto L11;
        if (r101 <= this.f162009y) goto L11;
        if (r101 >= this.f162010z) goto L11;
        return true;
    }

    public final void i(int r100, int r101) {
        g();
        f();
        float r102 = r100;
        this.f162007w = (int) (r102 - (e() / 2.0f));
        this.f162008x = (int) (r102 + (e() / 2.0f));
        int r103 = this.f162004t / 2;
        this.f162009y = r101 - r103;
        this.f162010z = r101 + r103;
    }

    public SeekBar(RangeSeekBar r100, AttributeSet r101, boolean r102) {
        this.B = 0.0f;
        this.f161984J = false;
        this.K = true;
        this.N = new Path();
        this.O = new Rect();
        this.P = new Rect();
        this.Q = new Paint(1);
        this.L = r100;
        this.D = r102;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.rsb_gravity, R.attr.rsb_indicator_arrow_size, R.attr.rsb_indicator_background_color, R.attr.rsb_indicator_drawable, R.attr.rsb_indicator_drawable_use_default, R.attr.rsb_indicator_height, R.attr.rsb_indicator_margin, R.attr.rsb_indicator_padding_bottom, R.attr.rsb_indicator_padding_left, R.attr.rsb_indicator_padding_right, R.attr.rsb_indicator_padding_top, R.attr.rsb_indicator_radius, R.attr.rsb_indicator_show_mode, R.attr.rsb_indicator_text_color, R.attr.rsb_indicator_text_gravity, R.attr.rsb_indicator_text_size, R.attr.rsb_indicator_width, R.attr.rsb_max, R.attr.rsb_min, R.attr.rsb_min_interval, R.attr.rsb_mode, R.attr.rsb_progress_color, R.attr.rsb_progress_default_color, R.attr.rsb_progress_drawable, R.attr.rsb_progress_drawable_default, R.attr.rsb_progress_height, R.attr.rsb_progress_radius, R.attr.rsb_step_auto_bonding, R.attr.rsb_step_circle_style, R.attr.rsb_step_color, R.attr.rsb_step_drawable, R.attr.rsb_step_height, R.attr.rsb_step_radius, R.attr.rsb_step_start_end_lines, R.attr.rsb_step_width, R.attr.rsb_steps, R.attr.rsb_thumb_drawable, R.attr.rsb_thumb_height, R.attr.rsb_thumb_inactivated_drawable, R.attr.rsb_thumb_scale_ratio, R.attr.rsb_thumb_width, R.attr.rsb_tick_mark_gravity, R.attr.rsb_tick_mark_in_range_text_color, R.attr.rsb_tick_mark_layout_gravity, R.attr.rsb_tick_mark_mode, R.attr.rsb_tick_mark_number, R.attr.rsb_tick_mark_text_array, R.attr.rsb_tick_mark_text_color, R.attr.rsb_tick_mark_text_margin, R.attr.rsb_tick_mark_text_size});
        if (r103 == null) goto L6;
        this.f161990f = (int) r103.getDimension(6, 0.0f);
        this.f161991g = r103.getResourceId(3, 0);
        this.f161985a = r103.getInt(12, 1);
        this.f161986b = r103.getInt(14, 0);
        this.f161987c = r103.getBoolean(4, true);
        this.f161988d = r103.getLayoutDimension(5, -1);
        this.f161989e = r103.getLayoutDimension(16, -1);
        this.f161993i = (int) r103.getDimension(15, c.b(getContext(), 14.0f));
        this.f161994j = r103.getColor(13, -1);
        this.f161996l = r103.getColor(2, -65536);
        this.f161997m = (int) r103.getDimension(8, 0.0f);
        this.f161998n = (int) r103.getDimension(9, 0.0f);
        this.f161999o = (int) r103.getDimension(10, 0.0f);
        this.f162000p = (int) r103.getDimension(7, 0.0f);
        this.f161992h = (int) r103.getDimension(1, 0.0f);
        this.f162001q = r103.getResourceId(36, 0);
        this.f162002r = r103.getResourceId(38, 0);
        this.f162003s = (int) r103.getDimension(40, c.b(getContext(), 26.0f));
        this.f162004t = (int) r103.getDimension(37, c.b(getContext(), 26.0f));
        this.f162006v = r103.getFloat(39, 1.0f);
        this.f161995k = r103.getDimension(11, 0.0f);
        r103.recycle();
    L6:
        f();
        g();
    }

    public final void k(int r100, int r101, int r102) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (getResources() == null) goto L10;
        if (r101 <= 0) goto L11;
        if (r102 <= 0) goto L12;
        this.f162001q = r100;
        this.E = c.c(r101, r102, getResources().getDrawable(r100, null));
        return;
    L12:
        return;
    L11:
        return;
    }
}
