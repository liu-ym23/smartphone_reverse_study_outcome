package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import ul1.a;
import ul1.b;
import ul1.c;

/* JADX INFO: loaded from: classes7.dex */
public class RangeSeekBar extends View {
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public float F;
    public float G;
    public boolean H;
    public a H0;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f109181J;
    public float K;
    public boolean L;
    public boolean L0;
    public final Paint M;
    public final RectF N;
    public final RectF O;
    public final Rect P;
    public final RectF Q;
    public final Rect R;
    public SeekBar S;
    public SeekBar T;
    public SeekBar U;
    public Bitmap V;
    public Bitmap W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f109182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f109183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f109184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f109185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f109186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f109187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f109188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f109189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f109190i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f109191j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f109192k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final List<Bitmap> f109193k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f109194l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence[] f109195m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f109196n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f109197o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f109198p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f109199p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f109200q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f109201r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f109202s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f109203t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f109204u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f109205v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f109206w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f109207x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f109208y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f109209z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityDef {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SeekBarModeDef {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TickMarkGravityDef {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TickMarkLayoutGravityDef {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TickMarkModeDef {
    }

    public void getStep() {
    }

    public void setEnableThumbOverlap(boolean r100) {
    }

    public final void d() {
        if (this.V != null) goto L6;
        this.V = c.d(getContext(), this.f109203t, this.f109202s, this.f109200q);
    L6:
        if (this.W != null) goto L9;
        this.W = c.d(getContext(), this.f109203t, this.f109202s, this.f109201r);
        return;
    }

    public b[] getRangeSeekBarState() {
        b r100 = new b();
        SeekBar r101 = this.S;
        if (r101 == null) goto L5;
        r100.f550591b = r101.K.getMinProgress() + ((r101.K.getMaxProgress() - r101.K.getMinProgress()) * r101.f109242z);
    L5:
        r100.f550590a = String.valueOf(r100.f550591b);
        if (c.a(r100.f550591b, this.F) != 0) goto L9;
        r100.f550592c = true;
    L11:
        b r102 = new b();
        if (this.f109186e != 2) goto L22;
        SeekBar r103 = this.T;
        if (r103 == null) goto L22;
        float r104 = r103.K.getMinProgress() + ((r103.K.getMaxProgress() - r103.K.getMinProgress()) * r103.f109242z);
        r102.f550591b = r104;
        r102.f550590a = String.valueOf(r104);
        if (c.a(this.T.f109242z, this.F) != 0) goto L19;
        r102.f550592c = true;
        goto L22
    L19:
        if (c.a(this.T.f109242z, this.G) != 0) goto L22;
        r102.f550593d = true;
    L22:
        return new b[]{r100, r102};
    L9:
        if (c.a(r100.f550591b, this.G) != 0) goto L11;
        r100.f550593d = true;
        goto L11
    }

    public float getRawHeight() {
        SeekBar r100 = this.S;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        if (this.T != null) goto L8;
        return 0.0f;
    L8:
        if (this.f109186e != 1) goto L14;
        float r101 = ((r100.f109220d + r100.f109224h) + r100.f109222f) + r100.d();
        if (this.f109191j == 1) goto L12;
        return r101;
    L12:
        if (this.f109195m != null) goto L24;
        return r101;
    L24:
        return ((r101 - (this.S.d() / 2.0f)) + (this.f109202s / 2.0f)) + Math.max((this.S.d() - this.f109202s) / 2.0f, getTickMarkRawHeight());
    L14:
        float r102 = ((r100.f109220d + r100.f109224h) + r100.f109222f) + r100.d();
        SeekBar r103 = this.T;
        float r104 = Math.max(r102, ((r103.f109220d + r103.f109224h) + r103.f109222f) + r103.d());
        if (this.f109191j == 1) goto L17;
        return r104;
    L17:
        if (this.f109195m == null) goto L26;
        float r105 = Math.max(this.S.d(), this.T.d());
        return ((r104 - (r105 / 2.0f)) + (this.f109202s / 2.0f)) + Math.max((r105 - this.f109202s) / 2.0f, getTickMarkRawHeight());
    L26:
        return r104;
    }

    public int getTickMarkRawHeight() {
        CharSequence[] r100 = this.f109195m;
        if (r100 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r100.length <= 0) goto L8;
        return (this.f109188g + c.e(String.valueOf(r100[0]), this.f109189h).height()) + 3;
    }

    public final void h() {
        SeekBar r100 = this.U;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f109237u > 1.0f) goto L7;
        return;
    L7:
        if (this.L == false) goto L12;
        this.L = false;
        r100.R = r100.f109235s;
        r100.S = r100.f109236t;
        int r101 = r100.K.getProgressBottom();
        int r102 = r100.S;
        int r103 = r102 / 2;
        r100.f109240x = r101 - r103;
        r100.f109241y = r101 + r103;
        r100.k(r100.f109233q, r100.R, r102);
        return;
    }

    public final void i() {
        SeekBar r100 = this.U;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f109237u > 1.0f) goto L7;
        return;
    L7:
        if (this.L == true) goto L12;
        this.L = true;
        r100.R = (int) r100.e();
        r100.S = (int) r100.d();
        int r101 = r100.K.getProgressBottom();
        int r102 = r100.S;
        int r103 = r102 / 2;
        r100.f109240x = r101 - r103;
        r100.f109241y = r101 + r103;
        r100.k(r100.f109233q, r100.R, r102);
        return;
    }

    public final boolean l() {
        if (this.A >= 1) goto L5;
    L9:
        return false;
    L5:
        if (this.f109208y <= 0.0f) goto L9;
        if (this.f109207x <= 0.0f) goto L9;
        return true;
    }

    public final void e() {
        if (l() == true) goto L5;
        return;
    L5:
        if (this.E != 0) goto L8;
        return;
    L8:
        if (this.f109193k0.isEmpty() == false) goto L15;
        Bitmap r100 = c.d(getContext(), (int) this.f109207x, (int) this.f109208y, this.E);
        int r101 = 0;
    L11:
        if (r101 > this.A) goto L17;
        this.f109193k0.add(r100);
        r101 = r101 + 1;
        goto L11
    L17:
        return;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f109210a = this.F;
        r100.f109211b = this.G;
        r100.f109212c = this.f109204u;
        b[] r101 = getRangeSeekBarState();
        r100.f109214e = r101[0].f550591b;
        r100.f109215f = r101[1].f550591b;
        return r100;
    }

    public int getGravity() {
        return this.f109205v;
    }

    public SeekBar getLeftSeekBar() {
        return this.S;
    }

    public float getMaxProgress() {
        return this.G;
    }

    public float getMinInterval() {
        return this.f109204u;
    }

    public float getMinProgress() {
        return this.F;
    }

    public int getProgressBottom() {
        return this.f109183b;
    }

    public int getProgressColor() {
        return this.f109197o;
    }

    public int getProgressDefaultColor() {
        return this.f109198p;
    }

    public int getProgressDefaultDrawableId() {
        return this.f109201r;
    }

    public int getProgressDrawableId() {
        return this.f109200q;
    }

    public int getProgressHeight() {
        return this.f109202s;
    }

    public int getProgressLeft() {
        return this.f109184c;
    }

    public int getProgressPaddingRight() {
        return this.f109199p0;
    }

    public float getProgressRadius() {
        return this.f109196n;
    }

    public int getProgressRight() {
        return this.f109185d;
    }

    public int getProgressTop() {
        return this.f109182a;
    }

    public int getProgressWidth() {
        return this.f109203t;
    }

    public SeekBar getRightSeekBar() {
        return this.T;
    }

    public int getSeekBarMode() {
        return this.f109186e;
    }

    public int getStepCount() {
        return this.A;
    }

    public List<Bitmap> getStepsBitmaps() {
        return this.f109193k0;
    }

    public int getStepsColor() {
        return this.f109206w;
    }

    public int getStepsDrawableId() {
        return this.E;
    }

    public float getStepsHeight() {
        return this.f109208y;
    }

    public float getStepsRadius() {
        return this.f109209z;
    }

    public float getStepsWidth() {
        return this.f109207x;
    }

    public int getTickMarkGravity() {
        return this.f109190i;
    }

    public int getTickMarkInRangeTextColor() {
        return this.f109194l;
    }

    public int getTickMarkLayoutGravity() {
        return this.f109191j;
    }

    public int getTickMarkMode() {
        return this.f109187f;
    }

    public CharSequence[] getTickMarkTextArray() {
        return this.f109195m;
    }

    public int getTickMarkTextColor() {
        return this.f109192k;
    }

    public int getTickMarkTextMargin() {
        return this.f109188g;
    }

    public int getTickMarkTextSize() {
        return this.f109189h;
    }

    public RangeSeekBar(Context r100) {
        this(r100, null);
    }

    public final float a(float r100) {
        float r101 = 0.0f;
        if (this.U != null) goto L5;
        return 0.0f;
    L5:
        float r102 = ((r100 - getProgressLeft()) * 1.0f) / this.f109203t;
        if (r100 < getProgressLeft()) goto L13;
        if (r100 <= getProgressRight()) goto L11;
        r101 = 1.0f;
        goto L13
    L11:
        r101 = r102;
    L13:
        if (this.f109186e != 2) goto L28;
        SeekBar r103 = this.U;
        SeekBar r104 = this.S;
        if (r103 != r104) goto L22;
        SeekBar r105 = this.T;
        if (r105 == null) goto L29;
        float r106 = r105.f109242z;
        float r107 = this.K;
        if (r101 > (r106 - r107)) goto L31;
        return r101;
    L31:
        return r106 - r107;
    L29:
        return r101;
    L22:
        if (r103 != this.T) goto L32;
        if (r104 == null) goto L33;
        float r108 = r104.f109242z;
        float r109 = this.K;
        if (r101 < (r108 + r109)) goto L27;
        return r101;
    L27:
        return r108 + r109;
    L33:
        return r101;
    L32:
        return r101;
    L28:
        return r101;
    }

    public final void b(boolean r100) {
        boolean r101 = false;
        if (r100 == false) goto L16;
        SeekBar r102 = this.U;
        if (r102 == null) goto L16;
        SeekBar r103 = this.S;
        if (r102 != r103) goto L9;
        r101 = true;
    L9:
        if (r103 == null) goto L12;
        r103.I = r101;
    L12:
        if (this.f109186e != 2) goto L25;
        SeekBar r104 = this.T;
        if (r104 == null) goto L26;
        r104.I = !r101;
        return;
    L26:
        return;
    L25:
        return;
    L16:
        SeekBar r105 = this.S;
        if (r105 == null) goto L20;
        r105.I = false;
    L20:
        if (this.f109186e != 2) goto L28;
        SeekBar r106 = this.T;
        if (r106 == null) goto L29;
        r106.I = false;
        return;
    L29:
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        Paint r100 = this.M;
        CharSequence[] r101 = this.f109195m;
        if (r101 == null) goto L37;
        int r102 = this.f109203t / (r101.length - 1);
        int r103 = 0;
    L5:
        CharSequence[] r104 = this.f109195m;
        if (r103 >= r104.length) goto L37;
        String r105 = r104[r103].toString();
        if (TextUtils.isEmpty(r105) == true) goto L35;
        r100.getTextBounds(r105, 0, r105.length(), this.R);
        r100.setColor(this.f109192k);
        if (this.f109187f != 1) goto L55;
        int r106 = this.f109190i;
        if (r106 != 2) goto L15;
        int r107 = (getProgressLeft() + (r103 * r102)) - this.R.width();
    L18:
        float r108 = r107;
    L31:
        if (this.f109191j != 0) goto L33;
        int r109 = getProgressTop() - this.f109188g;
    L34:
        r110.drawText(r105, r108, r109, r100);
        goto L35
    L33:
        r109 = (getProgressBottom() + this.f109188g) + this.R.height();
        goto L34
    L15:
        if (r106 != 1) goto L17;
        r108 = (getProgressLeft() + (r103 * r102)) - (this.R.width() / 2.0f);
        goto L31
    L17:
        r107 = getProgressLeft() + (r103 * r102);
        goto L18
    L55:
        float r111 = CastFloatProtector.parseFloat(r105);     // Catch: NumberFormatException -> L21
    L22:
        b[] r112 = getRangeSeekBarState();
        if (c.a(r111, r112[0].f550591b) != (-1)) goto L25;
    L29:
        float r113 = getProgressLeft();
        float r114 = this.f109203t;
        float r115 = this.F;
        r108 = (r113 + ((r114 * (r111 - r115)) / (this.G - r115))) - (this.R.width() / 2.0f);
        goto L31
    L25:
        if (c.a(r111, r112[1].f550591b) == 1) goto L29;
        if (this.f109186e != 2) goto L29;
        r100.setColor(this.f109194l);
    L21:
        r111 = 0.0f;
    L35:
        r103 = r103 + 1;
    L37:
        if (this.D == false) goto L39;
        f(r110, this.M);
        g(r110, this.M);
    L40:
        SeekBar r116 = this.S;
        if (r116 == null) goto L47;
        if (r116.f109217a != 3) goto L45;
        r116.j(true);
    L45:
        this.S.b(r110);
    L47:
        if (this.f109186e != 2) goto L60;
        SeekBar r117 = this.T;
        if (r117 != null) goto L51;
        return;
    L51:
        if (r117.f109217a != 3) goto L53;
        r117.j(true);
    L53:
        this.T.b(r110);
        return;
    L60:
        return;
    L39:
        g(r110, this.M);
        f(r110, this.M);
        goto L40
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;     // Catch: Exception -> L4
        super.onRestoreInstanceState(r101.getSuperState());     // Catch: Exception -> L4
        k(r101.f109210a, r101.f109211b, r101.f109212c);     // Catch: Exception -> L4
        j(r101.f109214e, r101.f109215f);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.H == true) goto L5;
        return true;
    L5:
        int r101 = r100.getAction();
        float r102 = 1.0f;
        if (r101 == 0) goto L88;
        if (r101 == 1) goto L65;
        if (r101 != 2) goto L10;
        float r103 = r100.getX();
        float r104 = r100.getY();
        if (Math.abs(r103 - this.I) > Math.abs(r104 - this.f109181J)) goto L36;
        if (this.L0 == true) goto L36;
        return false;
    L36:
        if (getParent() == null) goto L39;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.L0 = true;
    L39:
        if (this.f109186e != 2) goto L60;
        SeekBar r105 = this.S;
        if (r105 == null) goto L60;
        SeekBar r106 = this.T;
        if (r106 == null) goto L60;
        if (r105.f109242z != r106.f109242z) goto L60;
        this.U.h();
        a r107 = this.H0;
        if (r107 == null) goto L50;
        r107.b();
    L50:
        if ((r103 - this.I) <= 0.0f) goto L54;
        SeekBar r108 = this.U;
        if (r108 == this.T) goto L57;
        r108.j(false);
        h();
        this.U = this.T;
    L57:
        a r109 = this.H0;
        if (r109 == null) goto L60;
        r109.a();
        goto L60
    L54:
        SeekBar r110 = this.U;
        if (r110 == this.S) goto L57;
        r110.j(false);
        h();
        this.U = this.S;
    L60:
        i();
        SeekBar r111 = this.U;
        float r112 = r111.A;
        if (r112 >= 1.0f) goto L64;
        r102 = 0.1f + r112;
    L64:
        r111.A = r102;
        this.I = r103;
        r111.l(a(r103));
        this.U.j(true);
        c(r103, true);
        invalidate();
        b(true);
    L87:
        return super.onTouchEvent(r100);
    L10:
        if (r101 != 3) goto L87;
        if (this.f109186e != 2) goto L17;
        SeekBar r113 = this.T;
        if (r113 == null) goto L17;
        r113.j(false);
    L17:
        SeekBar r114 = this.U;
        if (r114 != this.S) goto L21;
        h();
    L23:
        SeekBar r115 = this.S;
        if (r115 == null) goto L26;
        r115.j(false);
    L26:
        c(r100.getX(), false);
        if (getParent() == null) goto L29;
        getParent().requestDisallowInterceptTouchEvent(true);
    L29:
        b(false);
        goto L87
    L21:
        if (r114 != this.T) goto L23;
        h();
        goto L23
    L65:
        float r116 = a(r100.getX());
        if (l() == true) goto L68;
    L70:
        this.U.l(r116);
    L72:
        if (this.f109186e != 2) goto L76;
        SeekBar r117 = this.T;
        if (r117 == null) goto L76;
        r117.j(false);
    L76:
        SeekBar r118 = this.S;
        if (r118 == null) goto L79;
        r118.j(false);
    L79:
        this.U.h();
        h();
        c(r100.getX(), false);
        if (getParent() == null) goto L82;
        getParent().requestDisallowInterceptTouchEvent(true);
    L82:
        a r119 = this.H0;
        if (r119 == null) goto L85;
        r119.b();
    L85:
        b(false);
        goto L87
    L68:
        if (this.C == false) goto L70;
        float r120 = 1.0f / this.A;
        this.U.l(new BigDecimal(r116 / r120).setScale(0, RoundingMode.HALF_UP).intValue() * r120);
        goto L72
    L88:
        this.I = r100.getX();
        this.f109181J = r100.getY();
        this.L0 = false;
        if (this.f109186e != 2) goto L107;
        SeekBar r121 = this.S;
        if (r121 == null) goto L108;
        SeekBar r122 = this.T;
        if (r122 == null) goto L108;
        if (r122.f109242z < 1.0f) goto L100;
        if (r121.a(r100.getX(), r100.getY()) == false) goto L100;
        this.U = this.S;
        i();
    L100:
        if (this.T.a(r100.getX(), r100.getY()) == false) goto L102;
        this.U = this.T;
        i();
        goto L108
    L102:
        float r123 = ((this.I - getProgressLeft()) * 1.0f) / this.f109203t;
        if (Math.abs(this.S.f109242z - r123) >= Math.abs(this.T.f109242z - r123)) goto L105;
        this.U = this.S;
    L106:
        this.U.l(a(this.I));
        goto L108
    L105:
        this.U = this.T;
    L108:
        a r124 = this.H0;
        if (r124 == null) goto L111;
        r124.a();
    L111:
        b(true);
        return true;
    L107:
        this.U = this.S;
        i();
        goto L108
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.H = r100;
    }

    public void setGravity(int r100) {
        this.f109205v = r100;
    }

    public void setIndicatorText(String r100) {
        SeekBar r101 = this.S;
        if (r101 == null) goto L6;
        r101.H = r100;
    L6:
        if (this.f109186e != 2) goto L11;
        SeekBar r102 = this.T;
        if (r102 == null) goto L12;
        r102.H = r100;
        return;
    L12:
        return;
    }

    public void setIndicatorTextDecimalFormat(String r100) {
        SeekBar r101 = this.S;
        if (r101 == null) goto L6;
        r101.Q = new DecimalFormat(r100);
    L6:
        if (this.f109186e != 2) goto L11;
        SeekBar r102 = this.T;
        if (r102 == null) goto L12;
        r102.Q = new DecimalFormat(r100);
        return;
    L12:
        return;
    }

    public void setIndicatorTextStringFormat(String r100) {
        SeekBar r101 = this.S;
        if (r101 == null) goto L6;
        r101.L = r100;
    L6:
        if (this.f109186e != 2) goto L11;
        SeekBar r102 = this.T;
        if (r102 == null) goto L12;
        r102.L = r100;
        return;
    L12:
        return;
    }

    public void setOnRangeChangedListener(a r100) {
        this.H0 = r100;
    }

    public void setProgress(float r100) {
        j(r100, this.G);
    }

    public void setProgressBottom(int r100) {
        this.f109183b = r100;
    }

    public void setProgressColor(int r100) {
        this.f109197o = r100;
    }

    public void setProgressDefaultColor(int r100) {
        this.f109198p = r100;
    }

    public void setProgressDefaultDrawableId(int r100) {
        this.f109201r = r100;
        this.W = null;
        d();
    }

    public void setProgressDrawableId(int r100) {
        this.f109200q = r100;
        this.V = null;
        d();
    }

    public void setProgressHeight(int r100) {
        this.f109202s = r100;
    }

    public void setProgressLeft(int r100) {
        this.f109184c = r100;
    }

    public void setProgressRadius(float r100) {
        this.f109196n = r100;
    }

    public void setProgressRight(int r100) {
        this.f109185d = r100;
    }

    public void setProgressTop(int r100) {
        this.f109182a = r100;
    }

    public void setProgressWidth(int r100) {
        this.f109203t = r100;
    }

    public void setSeekBarMode(int r100) {
        this.f109186e = r100;
        SeekBar r101 = this.T;
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r100 != 1) goto L8;
        r102 = false;
    L8:
        r101.f109216J = r102;
        return;
    }

    public void setStep(int r100) {
        int r101 = this.A;
        if (r101 > 0) goto L5;
        return;
    L5:
        setProgress((r100 * 100.0f) / r101);
    }

    public void setStepCount(int r100) {
        this.A = r100;
    }

    public void setStepsAutoBonding(boolean r100) {
        this.C = r100;
    }

    public void setStepsBitmaps(List<Bitmap> r100) {
        if (r100 == null) goto L10;
        if (r100.isEmpty() == true) goto L10;
        if (r100.size() <= this.A) goto L10;
        ((ArrayList) this.f109193k0).clear();
        ((ArrayList) this.f109193k0).addAll(r100);
        return;
    L10:
        throw new IllegalArgumentException("stepsBitmaps must > stepCount !");
    }

    public void setStepsColor(int r100) {
        this.f109206w = r100;
    }

    public void setStepsDrawable(List<Integer> r100) {
        if (r100 == null) goto L18;
        if (r100.isEmpty() == true) goto L18;
        if (r100.size() <= this.A) goto L18;
        if (l() == false) goto L16;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L11:
        if (r102 >= r100.size()) goto L13;
        r101.add(c.d(getContext(), (int) this.f109207x, (int) this.f109208y, ((Integer) ListProtector.get(r100, r102)).intValue()));
        r102 = r102 + 1;
        goto L11
    L13:
        setStepsBitmaps(r101);
        return;
    L16:
        throw new IllegalArgumentException("stepsWidth must > 0, stepsHeight must > 0,stepCount must > 0 First!!");
    L18:
        throw new IllegalArgumentException("stepsDrawableIds must > stepCount !");
    }

    public void setStepsDrawableId(int r100) {
        ((ArrayList) this.f109193k0).clear();
        this.E = r100;
        e();
    }

    public void setStepsHeight(float r100) {
        this.f109208y = r100;
    }

    public void setStepsRadius(float r100) {
        this.f109209z = r100;
    }

    public void setStepsWidth(float r100) {
        this.f109207x = r100;
    }

    public void setTickMarkGravity(int r100) {
        this.f109190i = r100;
    }

    public void setTickMarkInRangeTextColor(int r100) {
        this.f109194l = r100;
    }

    public void setTickMarkLayoutGravity(int r100) {
        this.f109191j = r100;
    }

    public void setTickMarkMode(int r100) {
        this.f109187f = r100;
    }

    public void setTickMarkTextArray(CharSequence[] r100) {
        this.f109195m = r100;
    }

    public void setTickMarkTextColor(int r100) {
        this.f109192k = r100;
    }

    public void setTickMarkTextMargin(int r100) {
        this.f109188g = r100;
    }

    public void setTickMarkTextSize(int r100) {
        this.f109189h = r100;
    }

    public void setTypeface(Typeface r100) {
        this.M.setTypeface(r100);
    }

    public RangeSeekBar(Context r210, AttributeSet r211) {
        super(r210, r211);
        this.H = true;
        this.L = false;
        this.M = new Paint();
        this.N = new RectF();
        this.O = new RectF();
        this.P = new Rect();
        this.Q = new RectF();
        this.R = new Rect();
        this.f109193k0 = new ArrayList();
        this.L0 = false;
        TypedArray r100 = getContext().obtainStyledAttributes(r211, new int[]{R.attr.rsb_gravity, R.attr.rsb_indicator_arrow_size, R.attr.rsb_indicator_background_color, R.attr.rsb_indicator_drawable, R.attr.rsb_indicator_drawable_use_default, R.attr.rsb_indicator_height, R.attr.rsb_indicator_margin, R.attr.rsb_indicator_padding_bottom, R.attr.rsb_indicator_padding_left, R.attr.rsb_indicator_padding_right, R.attr.rsb_indicator_padding_top, R.attr.rsb_indicator_radius, R.attr.rsb_indicator_show_mode, R.attr.rsb_indicator_text_color, R.attr.rsb_indicator_text_gravity, R.attr.rsb_indicator_text_size, R.attr.rsb_indicator_width, R.attr.rsb_max, R.attr.rsb_min, R.attr.rsb_min_interval, R.attr.rsb_mode, R.attr.rsb_progress_color, R.attr.rsb_progress_default_color, R.attr.rsb_progress_drawable, R.attr.rsb_progress_drawable_default, R.attr.rsb_progress_height, R.attr.rsb_progress_radius, R.attr.rsb_step_auto_bonding, R.attr.rsb_step_circle_style, R.attr.rsb_step_color, R.attr.rsb_step_drawable, R.attr.rsb_step_height, R.attr.rsb_step_radius, R.attr.rsb_step_start_end_lines, R.attr.rsb_step_width, R.attr.rsb_steps, R.attr.rsb_thumb_drawable, R.attr.rsb_thumb_height, R.attr.rsb_thumb_inactivated_drawable, R.attr.rsb_thumb_scale_ratio, R.attr.rsb_thumb_width, R.attr.rsb_tick_mark_gravity, R.attr.rsb_tick_mark_in_range_text_color, R.attr.rsb_tick_mark_layout_gravity, R.attr.rsb_tick_mark_mode, R.attr.rsb_tick_mark_number, R.attr.rsb_tick_mark_text_array, R.attr.rsb_tick_mark_text_color, R.attr.rsb_tick_mark_text_margin, R.attr.rsb_tick_mark_text_size});     // Catch: Exception -> L5
        this.f109186e = r100.getInt(20, 2);     // Catch: Exception -> L5
        this.F = r100.getFloat(18, 0.0f);     // Catch: Exception -> L5
        this.G = r100.getFloat(17, 100.0f);     // Catch: Exception -> L5
        this.f109204u = r100.getFloat(19, 0.0f);     // Catch: Exception -> L5
        this.f109205v = r100.getInt(0, 0);     // Catch: Exception -> L5
        this.f109197o = r100.getColor(21, -11806366);     // Catch: Exception -> L5
        this.f109196n = (int) r100.getDimension(26, -1.0f);     // Catch: Exception -> L5
        this.f109198p = r100.getColor(22, -2631721);     // Catch: Exception -> L5
        this.f109200q = r100.getResourceId(23, 0);     // Catch: Exception -> L5
        this.f109201r = r100.getResourceId(24, 0);     // Catch: Exception -> L5
        this.f109202s = (int) r100.getDimension(25, c.b(getContext(), 2.0f));     // Catch: Exception -> L5
        this.f109187f = r100.getInt(44, 0);     // Catch: Exception -> L5
        this.f109190i = r100.getInt(41, 1);     // Catch: Exception -> L5
        this.f109191j = r100.getInt(43, 0);     // Catch: Exception -> L5
        this.f109195m = r100.getTextArray(46);     // Catch: Exception -> L5
        this.f109188g = (int) r100.getDimension(48, c.b(getContext(), 7.0f));     // Catch: Exception -> L5
        this.f109189h = (int) r100.getDimension(49, c.b(getContext(), 12.0f));     // Catch: Exception -> L5
        this.f109192k = r100.getColor(47, this.f109198p);     // Catch: Exception -> L5
        this.f109194l = r100.getColor(47, this.f109197o);     // Catch: Exception -> L5
        this.A = r100.getInt(35, 0);     // Catch: Exception -> L5
        this.B = r100.getBoolean(33, false);     // Catch: Exception -> L5
        this.f109206w = r100.getColor(29, -6447715);     // Catch: Exception -> L5
        this.f109209z = r100.getDimension(32, 0.0f);     // Catch: Exception -> L5
        this.f109207x = r100.getDimension(34, 0.0f);     // Catch: Exception -> L5
        this.f109208y = r100.getDimension(31, 0.0f);     // Catch: Exception -> L5
        this.E = r100.getResourceId(30, 0);     // Catch: Exception -> L5
        this.C = r100.getBoolean(27, true);     // Catch: Exception -> L5
        this.D = r100.getBoolean(28, false);     // Catch: Exception -> L5
        r100.recycle();     // Catch: Exception -> L5
    L7:
        this.M.setFlags(1);
        this.M.setStyle(Paint.Style.FILL);
        this.M.setColor(this.f109198p);
        this.M.setTextSize(this.f109189h);
        boolean r101 = true;
        this.S = new SeekBar(this, r211, true);
        SeekBar r102 = new SeekBar(this, r211, false);
        this.T = r102;
        if (this.f109186e != 1) goto L11;
        r101 = false;
    L11:
        r102.f109216J = r101;
        e();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void c(float r100, boolean r101) {
        if (this.H0 != null) goto L6;
        return;
    L6:
        if (l() == true) goto L8;
    L10:
        b[] r102 = getRangeSeekBarState();
        a r103 = this.H0;
        float r104 = r102[0].f550591b;
        float r105 = r102[1].f550591b;
        r103.c(this, r104);
        return;
    L8:
        if (this.C == false) goto L10;
        this.H0.d(this, new BigDecimal(a(r100) / (1.0f / this.A)).setScale(0, RoundingMode.HALF_UP).intValue(), r101);
        goto L10
    }

    public final void f(Canvas r110, Paint r111) {
        Bitmap r100 = this.W;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L12:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L16;
        r110.drawBitmap(this.W, null, this.N, r111);
    L18:
        if (this.f109186e != 2) goto L25;
        if (this.S != null) goto L22;
    L27:
        Bitmap r103 = this.V;
        if (r103 != null) goto L30;
    L35:
        r101 = false;
    L36:
        if (r101 == false) goto L48;
        Rect r112 = this.P;
        r112.top = 0;
        r112.bottom = this.V.getHeight();
        int r113 = this.V.getWidth();
        if (this.f109186e != 2) goto L44;
        SeekBar r104 = this.S;
        if (r104 == null) goto L47;
        SeekBar r105 = this.T;
        if (r105 == null) goto L47;
        Rect r106 = this.P;
        float r114 = r113;
        r106.left = (int) (r104.f109242z * r114);
        r106.right = (int) (r114 * r105.f109242z);
    L47:
        r110.drawBitmap(this.V, this.P, this.O, null);
        return;
    L44:
        SeekBar r107 = this.S;
        if (r107 == null) goto L47;
        Rect r108 = this.P;
        r108.left = 0;
        r108.right = (int) (r113 * r107.f109242z);
        goto L47
    L48:
        r111.setColor(this.f109197o);
        RectF r109 = this.O;
        float r115 = this.f109196n;
        r110.drawRoundRect(r109, r115, r115, r111);
        return;
    L30:
        if (r103.isRecycled() == true) goto L35;
        if (r103.getWidth() <= 0) goto L35;
        if (r103.getHeight() > 0) goto L36;
    L22:
        if (this.T == null) goto L27;
        this.O.top = getProgressTop();
        RectF r116 = this.O;
        SeekBar r117 = this.S;
        r116.left = (r117.f109238v + (r117.e() / 2.0f)) + (this.f109203t * this.S.f109242z);
        RectF r118 = this.O;
        SeekBar r119 = this.T;
        r118.right = (r119.f109238v + (r119.e() / 2.0f)) + (this.f109203t * this.T.f109242z);
        this.O.bottom = getProgressBottom();
        goto L27
    L25:
        if (this.S == null) goto L27;
        this.O.top = getProgressTop();
        RectF r120 = this.O;
        SeekBar r121 = this.S;
        r120.left = r121.f109238v + (r121.e() / 2.0f);
        RectF r122 = this.O;
        SeekBar r123 = this.S;
        r122.right = (r123.f109238v + (r123.e() / 2.0f)) + (this.f109203t * this.S.f109242z);
        this.O.bottom = getProgressBottom();
        goto L27
    L16:
        r111.setColor(this.f109198p);
        RectF r124 = this.N;
        float r125 = this.f109196n;
        r110.drawRoundRect(r124, r125, r125, r111);
        goto L18
    L5:
        if (r100.isRecycled() == true) goto L12;
        if (r100.getWidth() <= 0) goto L12;
        if (r100.getHeight() <= 0) goto L12;
        r102 = true;
        goto L14
    }

    public final void g(Canvas r110, Paint r111) {
        int r100 = 0;
        if (l() == false) goto L19;
        float r101 = (getProgressWidth() * 1.0f) / this.A;
        float r102 = (this.f109208y - getProgressHeight()) / 2.0f;
    L6:
        if (r100 > this.A) goto L43;
        float r103 = (getProgressLeft() + (r100 * r101)) - (this.f109207x / 2.0f);
        this.Q.set(r103, getProgressTop() - r102, this.f109207x + r103, getProgressBottom() + r102);
        if (((ArrayList) this.f109193k0).isEmpty() == false) goto L10;
    L13:
        r111.setColor(this.f109206w);
        if (this.D == false) goto L16;
        r110.drawCircle(r103 + (this.f109207x / 2.0f), (getProgressTop() + getProgressBottom()) / 2.0f, this.f109207x, r111);
    L17:
        r100 = r100 + 1;
        goto L6
    L16:
        RectF r104 = this.Q;
        float r105 = this.f109209z;
        r110.drawRoundRect(r104, r105, r105, r111);
        goto L17
    L10:
        if (((ArrayList) this.f109193k0).size() <= r100) goto L13;
        r110.drawBitmap((Bitmap) ListProtector.get(this.f109193k0, r100), null, this.Q, r111);
        goto L17
    L43:
        return;
    L19:
        if (this.B == false) goto L34;
        float r106 = (this.f109208y - getProgressHeight()) / 2.0f;
    L22:
        if (r100 > 1) goto L44;
        float r107 = (getProgressLeft() + (getProgressWidth() * r100)) - (this.f109207x / 2.0f);
        this.Q.set(r107, getProgressTop() - r106, this.f109207x + r107, getProgressBottom() + r106);
        if (((ArrayList) this.f109193k0).isEmpty() == false) goto L26;
    L29:
        r111.setColor(this.f109206w);
        if (this.D == false) goto L32;
        r110.drawCircle(r107 + (this.f109207x / 2.0f), (getProgressTop() + getProgressBottom()) / 2.0f, this.f109207x, r111);
    L33:
        r100 = r100 + 1;
        goto L22
    L32:
        RectF r108 = this.Q;
        float r109 = this.f109209z;
        r110.drawRoundRect(r108, r109, r109, r111);
        goto L33
    L26:
        if (((ArrayList) this.f109193k0).size() <= r100) goto L29;
        r110.drawBitmap((Bitmap) ListProtector.get(this.f109193k0, r100), null, this.Q, r111);
        goto L33
    L44:
        return;
    }

    public final void j(float r100, float r101) {
        float r102 = Math.min(r100, r101);
        float r103 = Math.max(r102, r101);
        float r104 = r103 - r102;
        float r105 = this.f109204u;
        if (r104 >= r105) goto L5;
        r102 = r103 - r105;
    L5:
        float r106 = this.F;
        if (r102 < r106) goto L22;
        float r107 = this.G;
        if (r103 > r107) goto L20;
        float r108 = r107 - r106;
        SeekBar r109 = this.S;
        if (r109 == null) goto L13;
        r109.f109242z = Math.abs(r102 - r106) / r108;
    L13:
        if (this.f109186e != 2) goto L17;
        SeekBar r110 = this.T;
        if (r110 == null) goto L17;
        r110.f109242z = Math.abs(r103 - this.F) / r108;
    L17:
        invalidate();
        return;
    L20:
        throw new IllegalArgumentException("setProgress() max > (preset max - offsetValue) . #max:" + r103 + " #preset max:" + r103);
    L22:
        throw new IllegalArgumentException("setProgress() min < (preset min - offsetValue) . #min:" + r102 + " #preset min:" + r103);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        int r103 = View.MeasureSpec.getMode(r101);
        if (r103 != 1073741824) goto L6;
        int r104 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L29:
        super.onMeasure(r100, r104);
        return;
    L6:
        if (r103 != Integer.MIN_VALUE) goto L13;
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        if (r102 != (-1)) goto L13;
        r104 = View.MeasureSpec.makeMeasureSpec(((ViewGroup) getParent()).getMeasuredHeight(), Integer.MIN_VALUE);
    L13:
        if (this.f109205v == 2) goto L15;
        float r105 = getRawHeight();
    L27:
        int r106 = (int) r105;
    L28:
        r104 = View.MeasureSpec.makeMeasureSpec(r106, 1073741824);
        goto L29
    L15:
        if (this.f109195m == null) goto L21;
        if (this.f109191j != 1) goto L21;
        float r107 = getRawHeight();
        float r108 = getTickMarkRawHeight();
    L19:
        r105 = (r107 - r108) * 2.0f;
    L21:
        if (this.T != null) goto L23;
    L25:
        r106 = 0;
        goto L28
    L23:
        if (this.S == null) goto L25;
        r107 = getRawHeight();
        r108 = Math.max(this.S.d(), this.T.d()) / 2.0f;
        goto L19
    }

    public final void k(float r100, float r101, float r102) {
        if (r101 <= r100) goto L31;
        if (r102 < 0.0f) goto L29;
        float r103 = r101 - r100;
        if (r102 >= r103) goto L27;
        this.G = r101;
        this.F = r100;
        this.f109204u = r102;
        float r104 = r102 / r103;
        this.K = r104;
        if (this.f109186e != 2) goto L24;
        SeekBar r105 = this.S;
        if (r105 == null) goto L24;
        SeekBar r106 = this.T;
        if (r106 == null) goto L24;
        float r107 = r105.f109242z;
        if ((r107 + r104) <= 1.0f) goto L17;
    L19:
        float r108 = r106.f109242z;
        if ((r108 - r104) < 0.0f) goto L24;
        if ((r108 - r104) >= r107) goto L24;
        r105.f109242z = r108 - r104;
        goto L24
    L17:
        if ((r107 + r104) <= r106.f109242z) goto L19;
        r106.f109242z = r107 + r104;
    L24:
        invalidate();
        return;
    L27:
        throw new IllegalArgumentException("setRange() interval must be less than (max - min) ! #minInterval:" + r102 + " #max - min:" + r103);
    L29:
        throw new IllegalArgumentException("setRange() interval must be greater than zero ! #minInterval:" + r102);
    L31:
        throw new IllegalArgumentException("setRange() max must be greater than min ! #max:" + r101 + " #min:" + r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = (r101 - getPaddingBottom()) - getPaddingTop();
        if (r101 <= 0) goto L40;
        SeekBar r105 = this.S;
        if (r105 == null) goto L40;
        SeekBar r106 = this.T;
        if (r106 == null) goto L40;
        int r107 = this.f109205v;
        if (r107 == 0) goto L12;
        if (r107 == 1) goto L26;
        int r108 = this.f109202s;
        int r109 = (r104 - r108) / 2;
        this.f109182a = r109;
        this.f109183b = r109 + r108;
    L33:
        int r110 = ((int) Math.max(this.S.e(), this.T.e())) / 2;
        this.f109184c = getPaddingLeft() + r110;
        int r111 = (r100 - r110) - getPaddingRight();
        this.f109185d = r111;
        this.f109203t = r111 - this.f109184c;
        RectF r112 = this.N;
        if (r112 == null) goto L36;
        r112.set(getProgressLeft(), getProgressTop(), getProgressRight(), getProgressBottom());
    L36:
        this.f109199p0 = r100 - this.f109185d;
        if (this.f109196n > 0.0f) goto L39;
        this.f109196n = (int) ((getProgressBottom() - getProgressTop()) * 0.45f);
    L39:
        d();
        goto L40
    L26:
        if (this.f109195m != null) goto L28;
    L30:
        this.f109183b = (int) ((r104 - (Math.max(r105.d(), this.T.d()) / 2.0f)) + (this.f109202s / 2.0f));
    L31:
        this.f109182a = this.f109183b - this.f109202s;
        goto L33
    L28:
        if (this.f109191j != 1) goto L30;
        this.f109183b = r104 - getTickMarkRawHeight();
        goto L31
    L12:
        if (r105.f109217a == 1) goto L14;
    L17:
        float r113 = Math.max(r105.c(), this.T.c());
    L18:
        float r114 = Math.max(this.S.d(), this.T.d());
        float r115 = this.f109202s;
        float r116 = r114 - (r115 / 2.0f);
        this.f109182a = (int) (((r116 - r115) / 2.0f) + r113);
        if (this.f109195m != null) goto L21;
    L23:
        this.f109183b = this.f109182a + this.f109202s;
        goto L33
    L21:
        if (this.f109191j != 0) goto L23;
        this.f109182a = (int) Math.max(getTickMarkRawHeight(), r113 + ((r116 - this.f109202s) / 2.0f));
        goto L23
    L14:
        if (r106.f109217a != 1) goto L17;
        r113 = 0.0f;
    L40:
        k(this.F, this.G, this.f109204u);
        int r117 = (getProgressBottom() + getProgressTop()) / 2;
        SeekBar r118 = this.S;
        if (r118 == null) goto L44;
        r118.i(getProgressLeft(), r117);
    L44:
        if (this.f109186e != 2) goto L49;
        SeekBar r119 = this.T;
        if (r119 == null) goto L50;
        r119.i(getProgressLeft(), r117);
        return;
    L50:
        return;
    }
}
