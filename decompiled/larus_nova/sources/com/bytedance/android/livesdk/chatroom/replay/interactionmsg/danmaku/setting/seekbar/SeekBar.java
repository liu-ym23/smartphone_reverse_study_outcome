package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.seekbar;

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
import ul1.c;

/* JADX INFO: loaded from: classes7.dex */
public final class SeekBar {
    public float A;
    public boolean B;
    public final boolean C;
    public Bitmap D;
    public Bitmap E;
    public Bitmap F;
    public ValueAnimator G;
    public String H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f109216J;
    public final RangeSeekBar K;
    public String L;
    public final Path M;
    public final Rect N;
    public final Rect O;
    public final Paint P;
    public DecimalFormat Q;
    public int R;
    public int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f109217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f109218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f109219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f109220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f109221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f109222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f109223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f109224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f109225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f109226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f109227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f109228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f109229m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f109230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f109231o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f109232p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f109233q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f109234r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f109235s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f109236t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f109237u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f109238v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f109239w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f109240x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f109241y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f109242z;

    public @interface IndicatorModeDef {
    }

    public @interface IndicatorTextStyleDef {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBar f109243a;

        public a(SeekBar r100) {
            this.f109243a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            SeekBar r101 = this.f109243a;
            r101.A = ((Float) r100.getAnimatedValue()).floatValue();
            RangeSeekBar r102 = this.f109243a.K;
            if (r102 == null) goto L6;
            r102.invalidate();
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBar f109244a;

        public b(SeekBar r100) {
            this.f109244a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SeekBar r101 = this.f109244a;
            r101.A = 0.0f;
            RangeSeekBar r102 = r101.K;
            if (r102 == null) goto L6;
            r102.invalidate();
            return;
        }
    }

    public final int c() {
        int r100 = this.f109220d;
        if (r100 <= 0) goto L11;
        if (this.F == null) goto L9;
        int r101 = this.f109222f;
    L8:
        return r100 + r101;
    L9:
        r100 = r100 + this.f109224h;
        r101 = this.f109222f;
        goto L8
    L11:
        if (this.F == null) goto L13;
        r100 = (c.e("8", this.f109225i).height() + this.f109231o) + this.f109232p;
        r101 = this.f109222f;
        goto L8
    L13:
        r100 = ((c.e("8", this.f109225i).height() + this.f109231o) + this.f109232p) + this.f109222f;
        r101 = this.f109224h;
        goto L8
    }

    public final float d() {
        return this.f109236t * this.f109237u;
    }

    public final float e() {
        return this.f109235s * this.f109237u;
    }

    public final void f() {
        int r100 = this.f109223g;
        if (r100 == 0) goto L5;
        this.f109223g = r100;
        this.F = BitmapFactory.decodeResource(getResources(), r100);
    L5:
        k(this.f109233q, this.f109235s, this.f109236t);
        int r101 = this.f109234r;
        int r102 = this.f109235s;
        int r103 = this.f109236t;
        if (r101 != 0) goto L8;
        return;
    L8:
        if (getResources() == null) goto L12;
        this.f109234r = r101;
        this.E = c.c(r102, r103, getResources().getDrawable(r101, null));
        return;
    }

    public final void g() {
        this.R = this.f109235s;
        this.S = this.f109236t;
        if (this.f109220d != (-1)) goto L6;
        this.f109220d = (c.e("8", this.f109225i).height() + this.f109231o) + this.f109232p;
    L6:
        if (this.f109224h > 0) goto L9;
        this.f109224h = this.f109235s / 4;
        return;
    }

    public Context getContext() {
        return this.K.getContext();
    }

    public final void h() {
        ValueAnimator r100 = this.G;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{this.A, 0.0f});
        this.G = r101;
        if (r101 == null) goto L9;
        r101.addUpdateListener(new a(this));
        this.G.addListener(new b(this));
        this.G.start();
        return;
    }

    public Resources getResources() {
        if (getContext() != null) goto L5;
        return null;
    L5:
        return getContext().getResources();
    }

    public final void b(Canvas r110) {
        if (this.f109216J == true) goto L5;
        return;
    L5:
        r110.save();
        r110.translate(((int) (this.K.getProgressWidth() * this.f109242z)) + this.f109238v, 0.0f);
        Paint r100 = this.P;
        String r101 = this.H;
        ul1.b[] r102 = this.K.getRangeSeekBarState();
        if (TextUtils.isEmpty(r101) == true) goto L8;
    L17:
        String r103 = this.L;
        if (r103 == null) goto L21;
        r101 = String.format(r103, new Object[]{r101});
    L21:
        if (this.B == false) goto L80;
        if (TextUtils.isEmpty(r101) == true) goto L80;
        r100.setTextSize(this.f109225i);
        r100.setStyle(Paint.Style.FILL);
        r100.setColor(this.f109228l);
        r100.getTextBounds(r101, 0, r101.length(), this.N);
        int r104 = (this.N.width() + this.f109229m) + this.f109230n;
        int r105 = this.f109221e;
        if (r105 <= r104) goto L28;
        r104 = r105;
    L28:
        int r106 = (this.N.height() + this.f109231o) + this.f109232p;
        int r111 = this.f109220d;
        if (r111 <= r106) goto L31;
        r106 = r111;
    L31:
        Rect r112 = this.O;
        int r113 = this.R;
        int r114 = (int) ((r113 / 2.0f) - (r104 / 2.0f));
        r112.left = r114;
        r112.right = r114 + r104;
        int r115 = this.f109218b;
        if (r115 != 0) goto L34;
        r112.top = ((this.f109241y - this.S) - r106) - this.f109222f;
    L35:
        int r116 = r112.top;
        int r117 = r116 + r106;
        r112.bottom = r117;
        if (this.F == null) goto L38;
    L44:
        int r107 = c.b(getContext(), 1.0f);
        int r118 = (((this.O.width() / 2) - ((int) (this.K.getProgressWidth() * this.f109242z))) - this.K.getProgressLeft()) + r107;
        int r119 = (((this.O.width() / 2) - ((int) (this.K.getProgressWidth() * (1.0f - this.f109242z)))) - this.K.getProgressPaddingRight()) + r107;
        if (r118 <= 0) goto L47;
        Rect r108 = this.O;
        r108.left += r118;
        r108.right += r118;
    L49:
        Bitmap r109 = this.F;
        if (r109 == null) goto L58;
        Rect r120 = this.O;
        if (NinePatch.isNinePatchChunk(r109.getNinePatchChunk()) == false) goto L56;
        NinePatch.isNinePatchChunk(r109.getNinePatchChunk());     // Catch: Exception -> L91
        new NinePatch(r109, r109.getNinePatchChunk(), null).draw(r110, r120);     // Catch: Exception -> L91
    L63:
        int r121 = this.f109229m;
        if (r121 <= 0) goto L66;
        int r122 = this.O.left;
    L70:
        int r123 = r122 + r121;
    L72:
        if (this.f109231o <= 0) goto L75;
        int r124 = (this.O.top + this.N.height()) + this.f109231o;
    L78:
        r100.setColor(this.f109226j);
        r110.drawText(r101, r123, r124, r100);
        goto L80
    L75:
        if (this.f109232p <= 0) goto L77;
        r124 = (this.O.bottom - this.N.height()) - this.f109232p;
        goto L78
    L77:
        r124 = (this.O.bottom - ((r106 - this.N.height()) / 2)) + 1;
        goto L78
    L66:
        int r125 = this.f109230n;
        if (r125 <= 0) goto L69;
        r123 = (this.O.right - r125) - this.N.width();
        goto L72
    L69:
        r121 = this.O.left;
        r122 = (r104 - this.N.width()) / 2;
    L56:
        r110.drawBitmap(r109, r120.left, r120.top, r100);
        goto L63
    L58:
        if (this.f109219c == false) goto L63;
        if (this.f109227k <= 0.0f) goto L62;
        RectF r126 = new RectF(this.O);
        float r127 = this.f109227k;
        r110.drawRoundRect(r126, r127, r127, r100);
        goto L63
    L62:
        r110.drawRect(this.O, r100);
        goto L63
    L47:
        if (r119 <= 0) goto L49;
        Rect r128 = this.O;
        r128.left -= r119;
        r128.right -= r119;
        goto L49
    L38:
        if (this.f109219c == false) goto L44;
        int r129 = r113 / 2;
        int r130 = this.f109224h;
        int r131 = r129 - r130;
        int r132 = r129 + r130;
        if (r115 != 0) goto L42;
        int r133 = r117 - r130;
        r112.top = r116 - r130;
        r112.bottom = r133;
        r116 = r117;
    L43:
        this.M.reset();
        this.M.moveTo(r129, r116);
        float r134 = r133;
        this.M.lineTo(r131, r134);
        this.M.lineTo(r132, r134);
        this.M.close();
        r110.drawPath(this.M, r100);
        goto L44
    L42:
        r133 = r116 + r130;
        r112.top = r133;
        r112.bottom = r117 + r130;
        goto L43
    L34:
        r112.top = (this.f109241y + ((this.S - this.f109236t) / 2)) + this.f109222f;
    L80:
        if (this.I == false) goto L85;
        Bitmap r135 = this.E;
        if (r135 == null) goto L84;
        r110.drawBitmap(r135, 0.0f, this.K.getProgressTop() + ((this.K.getProgressHeight() - this.S) / 2.0f), null);
    L89:
        r110.restore();
        return;
    L84:
        this.P.setColor(-1);
        float r136 = this.K.getProgressTop() + ((this.K.getProgressHeight() - this.f109236t) / 2.0f);
        r110.drawOval(new RectF(0.0f, r136, this.R + 0.0f, this.S + r136), this.P);
        goto L89
    L85:
        Bitmap r137 = this.D;
        if (r137 == null) goto L88;
        r110.drawBitmap(r137, 0.0f, this.K.getProgressTop() + ((this.K.getProgressHeight() - this.f109236t) / 2.0f), null);
        goto L89
    L88:
        this.P.setColor(-1);
        float r138 = this.K.getProgressTop() + ((this.K.getProgressHeight() - this.f109236t) / 2.0f);
        r110.drawOval(new RectF(0.0f, r138, this.f109235s + 0.0f, this.f109236t + r138), this.P);
        goto L89
    L8:
        if (this.C == false) goto L13;
        DecimalFormat r139 = this.Q;
        if (r139 == null) goto L12;
        r101 = r139.format(r102[0].f550591b);
        goto L17
    L12:
        r101 = r102[0].f550590a;
        goto L17
    L13:
        DecimalFormat r140 = this.Q;
        if (r140 == null) goto L16;
        r101 = r140.format(r102[1].f550591b);
        goto L17
    L16:
        r101 = r102[1].f550590a;
        goto L17
    }

    public final void j(boolean r100) {
        int r101 = this.f109217a;
        if (r101 != 0) goto L5;
        this.B = r100;
        return;
    L5:
        if (r101 != 1) goto L7;
        this.B = false;
        return;
    L7:
        if (r101 != 2) goto L9;
    L11:
        this.B = true;
        return;
    L9:
        if (r101 == 3) goto L11;
    }

    public final void l(float r100) {
        if (r100 >= 0.0f) goto L6;
        r100 = 0.0f;
    L8:
        this.f109242z = r100;
        return;
    L6:
        if (r100 <= 1.0f) goto L8;
        r100 = 1.0f;
        goto L8
    }

    public final boolean a(float r100, float r101) {
        int r102 = (int) (this.K.getProgressWidth() * this.f109242z);
        if (r100 > (this.f109238v + r102)) goto L5;
    L11:
        return false;
    L5:
        if (r100 >= (this.f109239w + r102)) goto L11;
        if (r101 <= this.f109240x) goto L11;
        if (r101 >= this.f109241y) goto L11;
        return true;
    }

    public final void i(int r100, int r101) {
        g();
        f();
        float r102 = r100;
        this.f109238v = (int) (r102 - (e() / 2.0f));
        this.f109239w = (int) (r102 + (e() / 2.0f));
        int r103 = this.f109236t / 2;
        this.f109240x = r101 - r103;
        this.f109241y = r101 + r103;
    }

    public SeekBar(RangeSeekBar r100, AttributeSet r101, boolean r102) {
        this.A = 0.0f;
        this.I = false;
        this.f109216J = true;
        this.M = new Path();
        this.N = new Rect();
        this.O = new Rect();
        this.P = new Paint(1);
        this.K = r100;
        this.C = r102;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.rsb_gravity, R.attr.rsb_indicator_arrow_size, R.attr.rsb_indicator_background_color, R.attr.rsb_indicator_drawable, R.attr.rsb_indicator_drawable_use_default, R.attr.rsb_indicator_height, R.attr.rsb_indicator_margin, R.attr.rsb_indicator_padding_bottom, R.attr.rsb_indicator_padding_left, R.attr.rsb_indicator_padding_right, R.attr.rsb_indicator_padding_top, R.attr.rsb_indicator_radius, R.attr.rsb_indicator_show_mode, R.attr.rsb_indicator_text_color, R.attr.rsb_indicator_text_gravity, R.attr.rsb_indicator_text_size, R.attr.rsb_indicator_width, R.attr.rsb_max, R.attr.rsb_min, R.attr.rsb_min_interval, R.attr.rsb_mode, R.attr.rsb_progress_color, R.attr.rsb_progress_default_color, R.attr.rsb_progress_drawable, R.attr.rsb_progress_drawable_default, R.attr.rsb_progress_height, R.attr.rsb_progress_radius, R.attr.rsb_step_auto_bonding, R.attr.rsb_step_circle_style, R.attr.rsb_step_color, R.attr.rsb_step_drawable, R.attr.rsb_step_height, R.attr.rsb_step_radius, R.attr.rsb_step_start_end_lines, R.attr.rsb_step_width, R.attr.rsb_steps, R.attr.rsb_thumb_drawable, R.attr.rsb_thumb_height, R.attr.rsb_thumb_inactivated_drawable, R.attr.rsb_thumb_scale_ratio, R.attr.rsb_thumb_width, R.attr.rsb_tick_mark_gravity, R.attr.rsb_tick_mark_in_range_text_color, R.attr.rsb_tick_mark_layout_gravity, R.attr.rsb_tick_mark_mode, R.attr.rsb_tick_mark_number, R.attr.rsb_tick_mark_text_array, R.attr.rsb_tick_mark_text_color, R.attr.rsb_tick_mark_text_margin, R.attr.rsb_tick_mark_text_size});
        if (r103 == null) goto L6;
        this.f109222f = (int) r103.getDimension(6, 0.0f);
        this.f109223g = r103.getResourceId(3, 0);
        this.f109217a = r103.getInt(12, 1);
        this.f109218b = r103.getInt(14, 0);
        this.f109219c = r103.getBoolean(4, true);
        this.f109220d = r103.getLayoutDimension(5, -1);
        this.f109221e = r103.getLayoutDimension(16, -1);
        this.f109225i = (int) r103.getDimension(15, c.b(getContext(), 14.0f));
        this.f109226j = r103.getColor(13, -1);
        this.f109228l = r103.getColor(2, -65536);
        this.f109229m = (int) r103.getDimension(8, 0.0f);
        this.f109230n = (int) r103.getDimension(9, 0.0f);
        this.f109231o = (int) r103.getDimension(10, 0.0f);
        this.f109232p = (int) r103.getDimension(7, 0.0f);
        this.f109224h = (int) r103.getDimension(1, 0.0f);
        this.f109233q = r103.getResourceId(36, 0);
        this.f109234r = r103.getResourceId(38, 0);
        this.f109235s = (int) r103.getDimension(40, c.b(getContext(), 26.0f));
        this.f109236t = (int) r103.getDimension(37, c.b(getContext(), 26.0f));
        this.f109237u = r103.getFloat(39, 1.0f);
        this.f109227k = r103.getDimension(11, 0.0f);
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
        this.f109233q = r100;
        this.D = c.c(r101, r102, getResources().getDrawable(r100, null));
        return;
    L12:
        return;
    L11:
        return;
    }
}
