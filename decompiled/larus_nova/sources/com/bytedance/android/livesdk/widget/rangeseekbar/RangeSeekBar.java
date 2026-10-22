package com.bytedance.android.livesdk.widget.rangeseekbar;

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
import ov2.a;
import ov2.b;
import ov2.c;

/* JADX INFO: loaded from: classes11.dex */
public class RangeSeekBar extends View {
    public float A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public float G;
    public float H;
    public int H0;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f161949J;
    public float K;
    public float L;
    public a L0;
    public boolean M;
    public final Paint N;
    public final RectF O;
    public final RectF P;
    public boolean P0;
    public final Rect Q;
    public final RectF R;
    public final Rect S;
    public SeekBar T;
    public SeekBar U;
    public SeekBar V;
    public Bitmap W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f161950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f161951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f161952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f161953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f161954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f161955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f161956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f161957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f161958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f161959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f161960k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Bitmap f161961k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f161962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence[] f161963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f161964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f161965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f161966p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final List<Bitmap> f161967p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f161968q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f161969r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f161970s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f161971t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f161972u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f161973v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f161974w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f161975x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f161976y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f161977z;

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
        if (this.W != null) goto L6;
        this.W = c.d(getContext(), this.f161971t, this.f161970s, this.f161968q);
    L6:
        if (this.f161961k0 != null) goto L9;
        this.f161961k0 = c.d(getContext(), this.f161971t, this.f161970s, this.f161969r);
        return;
    }

    public b[] getRangeSeekBarState() {
        b r100 = new b();
        SeekBar r101 = this.T;
        float r102 = r101.L.getMinProgress() + ((r101.L.getMaxProgress() - r101.L.getMinProgress()) * r101.A);
        r100.f526873b = r102;
        r100.f526872a = String.valueOf(r102);
        if (c.a(r100.f526873b, this.G) != 0) goto L6;
        r100.f526874c = true;
    L8:
        b r103 = new b();
        if (this.f161954e != 2) goto L17;
        SeekBar r104 = this.U;
        float r105 = r104.L.getMinProgress() + ((r104.L.getMaxProgress() - r104.L.getMinProgress()) * r104.A);
        r103.f526873b = r105;
        r103.f526872a = String.valueOf(r105);
        if (c.a(this.U.A, this.G) != 0) goto L14;
        r103.f526874c = true;
        goto L17
    L14:
        if (c.a(this.U.A, this.H) != 0) goto L17;
        r103.f526875d = true;
    L17:
        return new b[]{r100, r103};
    L6:
        if (c.a(r100.f526873b, this.H) != 0) goto L8;
        r100.f526875d = true;
        goto L8
    }

    public float getRawHeight() {
        if (this.f161954e != 1) goto L9;
        SeekBar r100 = this.T;
        float r101 = ((r100.f161988d + r100.f161992h) + r100.f161990f) + r100.d();
        if (this.f161959j == 1) goto L7;
        return r101;
    L7:
        if (this.f161963m != null) goto L17;
        return r101;
    L17:
        return ((r101 - (this.T.d() / 2.0f)) + (this.f161970s / 2.0f)) + Math.max((this.T.d() - this.f161970s) / 2.0f, getTickMarkRawHeight());
    L9:
        SeekBar r102 = this.T;
        float r103 = ((r102.f161988d + r102.f161992h) + r102.f161990f) + r102.d();
        SeekBar r104 = this.U;
        float r105 = Math.max(r103, ((r104.f161988d + r104.f161992h) + r104.f161990f) + r104.d());
        if (this.f161959j == 1) goto L12;
        return r105;
    L12:
        if (this.f161963m == null) goto L19;
        float r106 = Math.max(this.T.d(), this.U.d());
        return ((r105 - (r106 / 2.0f)) + (this.f161970s / 2.0f)) + Math.max((r106 - this.f161970s) / 2.0f, getTickMarkRawHeight());
    L19:
        return r105;
    }

    public int getTickMarkRawHeight() {
        CharSequence[] r100 = this.f161963m;
        if (r100 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r100.length <= 0) goto L8;
        return (this.f161956g + c.e(String.valueOf(r100[0]), this.f161957h).height()) + 3;
    }

    public final void h() {
        SeekBar r100 = this.V;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f162006v > 1.0f) goto L7;
        return;
    L7:
        if (this.M == false) goto L12;
        this.M = false;
        r100.S = r100.f162003s;
        r100.T = r100.f162004t;
        int r101 = r100.L.getProgressBottom();
        int r102 = r100.T;
        int r103 = r102 / 2;
        r100.f162009y = r101 - r103;
        r100.f162010z = r101 + r103;
        r100.k(r100.f162001q, r100.S, r102);
        return;
    }

    public final void i() {
        SeekBar r100 = this.V;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f162006v > 1.0f) goto L7;
        return;
    L7:
        if (this.M == true) goto L12;
        this.M = true;
        r100.S = (int) r100.e();
        r100.T = (int) r100.d();
        int r101 = r100.L.getProgressBottom();
        int r102 = r100.T;
        int r103 = r102 / 2;
        r100.f162009y = r101 - r103;
        r100.f162010z = r101 + r103;
        r100.k(r100.f162001q, r100.S, r102);
        return;
    }

    public final boolean l() {
        if (this.B >= 1) goto L5;
    L9:
        return false;
    L5:
        if (this.f161977z <= 0.0f) goto L9;
        if (this.f161976y <= 0.0f) goto L9;
        return true;
    }

    public final void e() {
        if (l() == true) goto L5;
        return;
    L5:
        if (this.F != 0) goto L8;
        return;
    L8:
        if (this.f161967p0.isEmpty() == false) goto L15;
        Bitmap r100 = c.d(getContext(), (int) this.f161976y, (int) this.f161977z, this.F);
        int r101 = 0;
    L11:
        if (r101 > this.B) goto L17;
        this.f161967p0.add(r100);
        r101 = r101 + 1;
        goto L11
    L17:
        return;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f161978a = this.G;
        r100.f161979b = this.H;
        r100.f161980c = this.f161972u;
        b[] r101 = getRangeSeekBarState();
        r100.f161982e = r101[0].f526873b;
        r100.f161983f = r101[1].f526873b;
        return r100;
    }

    public int getGravity() {
        return this.f161973v;
    }

    public SeekBar getLeftSeekBar() {
        return this.T;
    }

    public float getMaxProgress() {
        return this.H;
    }

    public float getMinInterval() {
        return this.f161972u;
    }

    public float getMinProgress() {
        return this.G;
    }

    public int getProgressBottom() {
        return this.f161951b;
    }

    public int getProgressColor() {
        return this.f161965o;
    }

    public int getProgressDefaultColor() {
        return this.f161966p;
    }

    public int getProgressDefaultDrawableId() {
        return this.f161969r;
    }

    public int getProgressDrawableId() {
        return this.f161968q;
    }

    public int getProgressHeight() {
        return this.f161970s;
    }

    public int getProgressLeft() {
        return this.f161952c;
    }

    public int getProgressPaddingRight() {
        return this.H0;
    }

    public float getProgressRadius() {
        return this.f161964n;
    }

    public int getProgressRight() {
        return this.f161953d;
    }

    public int getProgressTop() {
        return this.f161950a;
    }

    public int getProgressWidth() {
        return this.f161971t;
    }

    public SeekBar getRightSeekBar() {
        return this.U;
    }

    public int getSeekBarMode() {
        return this.f161954e;
    }

    public int getStepCount() {
        return this.B;
    }

    public List<Bitmap> getStepsBitmaps() {
        return this.f161967p0;
    }

    public int getStepsCircleBorderColor() {
        return this.f161974w;
    }

    public int getStepsColor() {
        return this.f161975x;
    }

    public int getStepsDrawableId() {
        return this.F;
    }

    public float getStepsHeight() {
        return this.f161977z;
    }

    public float getStepsRadius() {
        return this.A;
    }

    public float getStepsWidth() {
        return this.f161976y;
    }

    public int getTickMarkGravity() {
        return this.f161958i;
    }

    public int getTickMarkInRangeTextColor() {
        return this.f161962l;
    }

    public int getTickMarkLayoutGravity() {
        return this.f161959j;
    }

    public int getTickMarkMode() {
        return this.f161955f;
    }

    public CharSequence[] getTickMarkTextArray() {
        return this.f161963m;
    }

    public int getTickMarkTextColor() {
        return this.f161960k;
    }

    public int getTickMarkTextMargin() {
        return this.f161956g;
    }

    public int getTickMarkTextSize() {
        return this.f161957h;
    }

    public RangeSeekBar(Context r100) {
        this(r100, null);
    }

    public final float a(float r100) {
        float r101 = 0.0f;
        if (this.V != null) goto L5;
        return 0.0f;
    L5:
        float r102 = ((r100 - getProgressLeft()) * 1.0f) / this.f161971t;
        if (r100 < getProgressLeft()) goto L13;
        if (r100 <= getProgressRight()) goto L11;
        r101 = 1.0f;
        goto L13
    L11:
        r101 = r102;
    L13:
        if (this.f161954e != 2) goto L25;
        SeekBar r103 = this.V;
        SeekBar r104 = this.T;
        if (r103 != r104) goto L20;
        float r105 = this.U.A;
        float r106 = this.L;
        if (r101 > (r105 - r106)) goto L27;
        return r101;
    L27:
        return r105 - r106;
    L20:
        if (r103 != this.U) goto L28;
        float r107 = r104.A;
        float r108 = this.L;
        if (r101 < (r107 + r108)) goto L24;
        return r101;
    L24:
        return r107 + r108;
    L28:
        return r101;
    L25:
        return r101;
    }

    public final void b(boolean r100) {
        boolean r101 = false;
        if (r100 == false) goto L12;
        SeekBar r102 = this.V;
        if (r102 == null) goto L12;
        SeekBar r103 = this.T;
        if (r102 != r103) goto L9;
        r101 = true;
    L9:
        r103.f161984J = r101;
        if (this.f161954e != 2) goto L16;
        this.U.f161984J = !r101;
        return;
    L16:
        return;
    L12:
        this.T.f161984J = false;
        if (this.f161954e != 2) goto L18;
        this.U.f161984J = false;
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        Paint r100 = this.N;
        CharSequence[] r101 = this.f161963m;
        if (r101 == null) goto L37;
        int r102 = this.f161971t / (r101.length - 1);
        int r103 = 0;
    L5:
        CharSequence[] r104 = this.f161963m;
        if (r103 >= r104.length) goto L37;
        String r105 = r104[r103].toString();
        if (TextUtils.isEmpty(r105) == true) goto L35;
        r100.getTextBounds(r105, 0, r105.length(), this.S);
        r100.setColor(this.f161960k);
        if (this.f161955f != 1) goto L50;
        int r106 = this.f161958i;
        if (r106 != 2) goto L15;
        int r107 = (getProgressLeft() + (r103 * r102)) - this.S.width();
    L18:
        float r108 = r107;
    L31:
        if (this.f161959j != 0) goto L33;
        int r109 = getProgressTop() - this.f161956g;
    L34:
        r110.drawText(r105, r108, r109, r100);
        goto L35
    L33:
        r109 = (getProgressBottom() + this.f161956g) + this.S.height();
        goto L34
    L15:
        if (r106 != 1) goto L17;
        r108 = (getProgressLeft() + (r103 * r102)) - (this.S.width() / 2.0f);
        goto L31
    L17:
        r107 = getProgressLeft() + (r103 * r102);
        goto L18
    L50:
        float r111 = CastFloatProtector.parseFloat(r105);     // Catch: NumberFormatException -> L21
    L22:
        b[] r112 = getRangeSeekBarState();
        if (c.a(r111, r112[0].f526873b) != (-1)) goto L25;
    L29:
        float r113 = getProgressLeft();
        float r114 = this.f161971t;
        float r115 = this.G;
        r108 = (r113 + ((r114 * (r111 - r115)) / (this.H - r115))) - (this.S.width() / 2.0f);
        goto L31
    L25:
        if (c.a(r111, r112[1].f526873b) == 1) goto L29;
        if (this.f161954e != 2) goto L29;
        r100.setColor(this.f161962l);
    L21:
        r111 = 0.0f;
    L35:
        r103 = r103 + 1;
    L37:
        if (this.E == false) goto L39;
        f(r110, this.N);
        g(r110, this.N);
    L40:
        SeekBar r116 = this.T;
        if (r116.f161985a != 3) goto L43;
        r116.j(true);
    L43:
        this.T.b(r110);
        if (this.f161954e != 2) goto L55;
        SeekBar r117 = this.U;
        if (r117.f161985a != 3) goto L48;
        r117.j(true);
    L48:
        this.U.b(r110);
        return;
    L55:
        return;
    L39:
        g(r110, this.N);
        f(r110, this.N);
        goto L40
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;     // Catch: Exception -> L4
        super.onRestoreInstanceState(r101.getSuperState());     // Catch: Exception -> L4
        k(r101.f161978a, r101.f161979b, r101.f161980c);     // Catch: Exception -> L4
        j(r101.f161982e, r101.f161983f);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.I == true) goto L5;
        return true;
    L5:
        int r101 = r100.getAction();
        float r102 = 1.0f;
        if (r101 == 0) goto L74;
        if (r101 == 1) goto L56;
        if (r101 != 2) goto L10;
        float r103 = r100.getX();
        float r104 = r100.getY();
        if (Math.abs(r103 - this.f161949J) > Math.abs(r104 - this.K)) goto L31;
        if (this.P0 == true) goto L31;
        return false;
    L31:
        if (getParent() == null) goto L34;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.P0 = true;
    L34:
        if (this.f161954e == 2) goto L36;
    L51:
        i();
        SeekBar r105 = this.V;
        float r106 = r105.B;
        if (r106 >= 1.0f) goto L55;
        r102 = 0.1f + r106;
    L55:
        r105.B = r102;
        this.f161949J = r103;
        r105.l(a(r103));
        this.V.j(true);
        c(r103, true);
        invalidate();
        b(true);
    L73:
        return super.onTouchEvent(r100);
    L36:
        if (this.T.A != this.U.A) goto L51;
        this.V.h();
        a r107 = this.L0;
        if (r107 == null) goto L41;
        r107.b();
    L41:
        if ((r103 - this.f161949J) <= 0.0f) goto L45;
        SeekBar r108 = this.V;
        if (r108 == this.U) goto L48;
        r108.j(false);
        h();
        this.V = this.U;
    L48:
        a r109 = this.L0;
        if (r109 == null) goto L51;
        r109.a();
        goto L51
    L45:
        SeekBar r110 = this.V;
        if (r110 == this.T) goto L48;
        r110.j(false);
        h();
        this.V = this.T;
        goto L48
    L10:
        if (r101 != 3) goto L73;
        if (this.f161954e != 2) goto L15;
        this.U.j(false);
    L15:
        SeekBar r111 = this.V;
        if (r111 != this.T) goto L19;
        h();
    L21:
        this.T.j(false);
        c(r100.getX(), false);
        if (getParent() == null) goto L24;
        getParent().requestDisallowInterceptTouchEvent(true);
    L24:
        b(false);
        goto L73
    L19:
        if (r111 != this.U) goto L21;
        h();
        goto L21
    L56:
        float r112 = a(r100.getX());
        if (l() == true) goto L59;
    L61:
        this.V.l(r112);
    L63:
        if (this.f161954e != 2) goto L65;
        this.U.j(false);
    L65:
        this.T.j(false);
        this.V.h();
        h();
        c(r100.getX(), false);
        if (getParent() == null) goto L68;
        getParent().requestDisallowInterceptTouchEvent(true);
    L68:
        a r113 = this.L0;
        if (r113 == null) goto L71;
        r113.b();
    L71:
        b(false);
        goto L73
    L59:
        if (this.D == false) goto L61;
        float r114 = 1.0f / this.B;
        this.V.l(new BigDecimal(r112 / r114).setScale(0, RoundingMode.HALF_UP).intValue() * r114);
        goto L63
    L74:
        this.f161949J = r100.getX();
        this.K = r100.getY();
        this.P0 = false;
        if (this.f161954e == 2) goto L77;
        this.V = this.T;
        i();
    L90:
        a r115 = this.L0;
        if (r115 == null) goto L93;
        r115.a();
    L93:
        b(true);
        return true;
    L77:
        if (this.U.A < 1.0f) goto L82;
        if (this.T.a(r100.getX(), r100.getY()) == false) goto L82;
        this.V = this.T;
        i();
    L82:
        if (this.U.a(r100.getX(), r100.getY()) == false) goto L84;
        this.V = this.U;
        i();
        goto L90
    L84:
        float r116 = ((this.f161949J - getProgressLeft()) * 1.0f) / this.f161971t;
        if (Math.abs(this.T.A - r116) >= Math.abs(this.U.A - r116)) goto L87;
        this.V = this.T;
    L88:
        this.V.l(a(this.f161949J));
        goto L90
    L87:
        this.V = this.U;
        goto L88
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.I = r100;
    }

    public void setGravity(int r100) {
        this.f161973v = r100;
    }

    public void setIndicatorText(String r100) {
        this.T.I = r100;
        if (this.f161954e != 2) goto L6;
        this.U.I = r100;
        return;
    }

    public void setIndicatorTextDecimalFormat(String r100) {
        SeekBar r101 = this.T;
        r101.getClass();
        r101.R = new DecimalFormat(r100);
        if (this.f161954e != 2) goto L6;
        SeekBar r102 = this.U;
        r102.getClass();
        r102.R = new DecimalFormat(r100);
        return;
    }

    public void setIndicatorTextStringFormat(String r100) {
        this.T.M = r100;
        if (this.f161954e != 2) goto L6;
        this.U.M = r100;
        return;
    }

    public void setOnRangeChangedListener(a r100) {
        this.L0 = r100;
    }

    public void setProgress(float r100) {
        j(r100, this.H);
    }

    public void setProgressBottom(int r100) {
        this.f161951b = r100;
    }

    public void setProgressColor(int r100) {
        this.f161965o = r100;
    }

    public void setProgressDefaultColor(int r100) {
        this.f161966p = r100;
    }

    public void setProgressDefaultDrawableId(int r100) {
        this.f161969r = r100;
        this.f161961k0 = null;
        d();
    }

    public void setProgressDrawableId(int r100) {
        this.f161968q = r100;
        this.W = null;
        d();
    }

    public void setProgressHeight(int r100) {
        this.f161970s = r100;
    }

    public void setProgressLeft(int r100) {
        this.f161952c = r100;
    }

    public void setProgressRadius(float r100) {
        this.f161964n = r100;
    }

    public void setProgressRight(int r100) {
        this.f161953d = r100;
    }

    public void setProgressTop(int r100) {
        this.f161950a = r100;
    }

    public void setProgressWidth(int r100) {
        this.f161971t = r100;
    }

    public void setSeekBarMode(int r100) {
        this.f161954e = r100;
        SeekBar r101 = this.U;
        boolean r102 = true;
        if (r100 != 1) goto L6;
        r102 = false;
    L6:
        r101.K = r102;
    }

    public void setStep(int r100) {
        int r101 = this.B;
        if (r101 > 0) goto L5;
        return;
    L5:
        setProgress((r100 * 100.0f) / r101);
    }

    public void setStepCircleStyle(boolean r100) {
        this.E = r100;
    }

    public void setStepCount(int r100) {
        this.B = r100;
    }

    public void setStepsAutoBonding(boolean r100) {
        this.D = r100;
    }

    public void setStepsBitmaps(List<Bitmap> r100) {
        if (r100 == null) goto L10;
        if (r100.isEmpty() == true) goto L10;
        if (r100.size() <= this.B) goto L10;
        ((ArrayList) this.f161967p0).clear();
        ((ArrayList) this.f161967p0).addAll(r100);
        return;
    L10:
        throw new IllegalArgumentException("stepsBitmaps must > stepCount !");
    }

    public void setStepsCircleBorderColor(int r100) {
        this.f161974w = r100;
    }

    public void setStepsColor(int r100) {
        this.f161975x = r100;
    }

    public void setStepsDrawable(List<Integer> r100) {
        if (r100 == null) goto L18;
        if (r100.isEmpty() == true) goto L18;
        if (r100.size() <= this.B) goto L18;
        if (l() == false) goto L16;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L11:
        if (r102 >= r100.size()) goto L13;
        r101.add(c.d(getContext(), (int) this.f161976y, (int) this.f161977z, ((Integer) ListProtector.get(r100, r102)).intValue()));
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
        ((ArrayList) this.f161967p0).clear();
        this.F = r100;
        e();
    }

    public void setStepsHeight(float r100) {
        this.f161977z = r100;
    }

    public void setStepsRadius(float r100) {
        this.A = r100;
    }

    public void setStepsWidth(float r100) {
        this.f161976y = r100;
    }

    public void setTickMarkGravity(int r100) {
        this.f161958i = r100;
    }

    public void setTickMarkInRangeTextColor(int r100) {
        this.f161962l = r100;
    }

    public void setTickMarkLayoutGravity(int r100) {
        this.f161959j = r100;
    }

    public void setTickMarkMode(int r100) {
        this.f161955f = r100;
    }

    public void setTickMarkTextArray(CharSequence[] r100) {
        this.f161963m = r100;
    }

    public void setTickMarkTextColor(int r100) {
        this.f161960k = r100;
    }

    public void setTickMarkTextMargin(int r100) {
        this.f161956g = r100;
    }

    public void setTickMarkTextSize(int r100) {
        this.f161957h = r100;
    }

    public void setTypeface(Typeface r100) {
        this.N.setTypeface(r100);
    }

    public RangeSeekBar(Context r210, AttributeSet r211) {
        super(r210, r211);
        this.I = true;
        this.M = false;
        this.N = new Paint();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new Rect();
        this.R = new RectF();
        this.S = new Rect();
        this.f161967p0 = new ArrayList();
        this.P0 = false;
        TypedArray r100 = getContext().obtainStyledAttributes(r211, new int[]{R.attr.rsb_gravity, R.attr.rsb_indicator_arrow_size, R.attr.rsb_indicator_background_color, R.attr.rsb_indicator_drawable, R.attr.rsb_indicator_drawable_use_default, R.attr.rsb_indicator_height, R.attr.rsb_indicator_margin, R.attr.rsb_indicator_padding_bottom, R.attr.rsb_indicator_padding_left, R.attr.rsb_indicator_padding_right, R.attr.rsb_indicator_padding_top, R.attr.rsb_indicator_radius, R.attr.rsb_indicator_show_mode, R.attr.rsb_indicator_text_color, R.attr.rsb_indicator_text_gravity, R.attr.rsb_indicator_text_size, R.attr.rsb_indicator_width, R.attr.rsb_max, R.attr.rsb_min, R.attr.rsb_min_interval, R.attr.rsb_mode, R.attr.rsb_progress_color, R.attr.rsb_progress_default_color, R.attr.rsb_progress_drawable, R.attr.rsb_progress_drawable_default, R.attr.rsb_progress_height, R.attr.rsb_progress_radius, R.attr.rsb_step_auto_bonding, R.attr.rsb_step_circle_style, R.attr.rsb_step_color, R.attr.rsb_step_drawable, R.attr.rsb_step_height, R.attr.rsb_step_radius, R.attr.rsb_step_start_end_lines, R.attr.rsb_step_width, R.attr.rsb_steps, R.attr.rsb_thumb_drawable, R.attr.rsb_thumb_height, R.attr.rsb_thumb_inactivated_drawable, R.attr.rsb_thumb_scale_ratio, R.attr.rsb_thumb_width, R.attr.rsb_tick_mark_gravity, R.attr.rsb_tick_mark_in_range_text_color, R.attr.rsb_tick_mark_layout_gravity, R.attr.rsb_tick_mark_mode, R.attr.rsb_tick_mark_number, R.attr.rsb_tick_mark_text_array, R.attr.rsb_tick_mark_text_color, R.attr.rsb_tick_mark_text_margin, R.attr.rsb_tick_mark_text_size});     // Catch: Exception -> L5
        this.f161954e = r100.getInt(20, 2);     // Catch: Exception -> L5
        this.G = r100.getFloat(18, 0.0f);     // Catch: Exception -> L5
        this.H = r100.getFloat(17, 100.0f);     // Catch: Exception -> L5
        this.f161972u = r100.getFloat(19, 0.0f);     // Catch: Exception -> L5
        this.f161973v = r100.getInt(0, 0);     // Catch: Exception -> L5
        this.f161965o = r100.getColor(21, -11806366);     // Catch: Exception -> L5
        this.f161964n = (int) r100.getDimension(26, -1.0f);     // Catch: Exception -> L5
        this.f161966p = r100.getColor(22, -2631721);     // Catch: Exception -> L5
        this.f161968q = r100.getResourceId(23, 0);     // Catch: Exception -> L5
        this.f161969r = r100.getResourceId(24, 0);     // Catch: Exception -> L5
        this.f161970s = (int) r100.getDimension(25, c.b(getContext(), 2.0f));     // Catch: Exception -> L5
        this.f161955f = r100.getInt(44, 0);     // Catch: Exception -> L5
        this.f161958i = r100.getInt(41, 1);     // Catch: Exception -> L5
        this.f161959j = r100.getInt(43, 0);     // Catch: Exception -> L5
        this.f161963m = r100.getTextArray(46);     // Catch: Exception -> L5
        this.f161956g = (int) r100.getDimension(48, c.b(getContext(), 7.0f));     // Catch: Exception -> L5
        this.f161957h = (int) r100.getDimension(49, c.b(getContext(), 12.0f));     // Catch: Exception -> L5
        this.f161960k = r100.getColor(47, this.f161966p);     // Catch: Exception -> L5
        this.f161962l = r100.getColor(47, this.f161965o);     // Catch: Exception -> L5
        this.B = r100.getInt(35, 0);     // Catch: Exception -> L5
        this.C = r100.getBoolean(33, false);     // Catch: Exception -> L5
        this.f161975x = r100.getColor(29, -6447715);     // Catch: Exception -> L5
        this.A = r100.getDimension(32, 0.0f);     // Catch: Exception -> L5
        this.f161976y = r100.getDimension(34, 0.0f);     // Catch: Exception -> L5
        this.f161977z = r100.getDimension(31, 0.0f);     // Catch: Exception -> L5
        this.F = r100.getResourceId(30, 0);     // Catch: Exception -> L5
        this.D = r100.getBoolean(27, true);     // Catch: Exception -> L5
        this.E = r100.getBoolean(28, false);     // Catch: Exception -> L5
        r100.recycle();     // Catch: Exception -> L5
    L7:
        this.N.setFlags(1);
        this.N.setStyle(Paint.Style.FILL);
        this.N.setColor(this.f161966p);
        this.N.setTextSize(this.f161957h);
        boolean r101 = true;
        this.T = new SeekBar(this, r211, true);
        SeekBar r102 = new SeekBar(this, r211, false);
        this.U = r102;
        if (this.f161954e != 1) goto L11;
        r101 = false;
    L11:
        r102.K = r101;
        e();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void c(float r100, boolean r101) {
        if (this.L0 != null) goto L6;
        return;
    L6:
        if (l() == true) goto L8;
    L10:
        b[] r102 = getRangeSeekBarState();
        a r103 = this.L0;
        float r104 = r102[0].f526873b;
        float r105 = r102[1].f526873b;
        r103.d(this, r104);
        return;
    L8:
        if (this.D == false) goto L10;
        this.L0.c(this, new BigDecimal(a(r100) / (1.0f / this.B)).setScale(0, RoundingMode.HALF_UP).intValue(), r101);
        goto L10
    }

    public final void f(Canvas r110, Paint r111) {
        Bitmap r100 = this.f161961k0;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L12:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L16;
        r110.drawBitmap(this.f161961k0, null, this.O, r111);
    L18:
        if (this.f161954e != 2) goto L20;
        this.P.top = getProgressTop();
        RectF r103 = this.P;
        SeekBar r104 = this.T;
        r103.left = (r104.f162007w + (r104.e() / 2.0f)) + (this.f161971t * this.T.A);
        RectF r105 = this.P;
        SeekBar r106 = this.U;
        r105.right = (r106.f162007w + (r106.e() / 2.0f)) + (this.f161971t * this.U.A);
        this.P.bottom = getProgressBottom();
    L21:
        Bitmap r107 = this.W;
        if (r107 != null) goto L24;
    L29:
        r101 = false;
    L30:
        if (r101 == false) goto L36;
        Rect r112 = this.Q;
        r112.top = 0;
        r112.bottom = this.W.getHeight();
        int r113 = this.W.getWidth();
        if (this.f161954e != 2) goto L34;
        Rect r108 = this.Q;
        float r114 = r113;
        r108.left = (int) (this.T.A * r114);
        r108.right = (int) (r114 * this.U.A);
    L35:
        r110.drawBitmap(this.W, this.Q, this.P, null);
        return;
    L34:
        Rect r109 = this.Q;
        r109.left = 0;
        r109.right = (int) (r113 * this.T.A);
        goto L35
    L36:
        r111.setColor(this.f161965o);
        RectF r115 = this.P;
        float r116 = this.f161964n;
        r110.drawRoundRect(r115, r116, r116, r111);
        return;
    L24:
        if (r107.isRecycled() == true) goto L29;
        if (r107.getWidth() <= 0) goto L29;
        if (r107.getHeight() > 0) goto L30;
    L20:
        this.P.top = getProgressTop();
        RectF r117 = this.P;
        SeekBar r118 = this.T;
        r117.left = r118.f162007w + (r118.e() / 2.0f);
        RectF r119 = this.P;
        SeekBar r120 = this.T;
        r119.right = (r120.f162007w + (r120.e() / 2.0f)) + (this.f161971t * this.T.A);
        this.P.bottom = getProgressBottom();
        goto L21
    L16:
        r111.setColor(this.f161966p);
        RectF r121 = this.O;
        float r122 = this.f161964n;
        r110.drawRoundRect(r121, r122, r122, r111);
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
        if (l() == false) goto L25;
        float r101 = (getProgressWidth() * 1.0f) / this.B;
        float r102 = (this.f161977z - getProgressHeight()) / 2.0f;
    L6:
        if (r100 > this.B) goto L51;
        float r103 = (getProgressLeft() + (r100 * r101)) - (this.f161976y / 2.0f);
        this.R.set(r103, getProgressTop() - r102, this.f161976y + r103, getProgressBottom() + r102);
        if (((ArrayList) this.f161967p0).isEmpty() == false) goto L10;
    L13:
        int r104 = this.f161974w;
        if (r104 == 0) goto L19;
        r111.setColor(r104);
        float r105 = r103 + (this.f161976y / 2.0f);
        float r106 = (getProgressTop() + getProgressBottom()) / 2.0f;
        r110.drawCircle(r105, r106, this.f161976y, r111);
        r111.setColor(this.f161975x);
        if (this.E == false) goto L18;
        r110.drawCircle(r105, r106, this.f161976y - 1.0f, r111);
    L23:
        r100 = r100 + 1;
        goto L6
    L18:
        RectF r107 = this.R;
        float r108 = this.A;
        r110.drawRoundRect(r107, r108, r108, r111);
        goto L23
    L19:
        r111.setColor(this.f161975x);
        if (this.E == false) goto L22;
        r110.drawCircle(r103 + (this.f161976y / 2.0f), (getProgressTop() + getProgressBottom()) / 2.0f, this.f161976y, r111);
        goto L23
    L22:
        RectF r109 = this.R;
        float r112 = this.A;
        r110.drawRoundRect(r109, r112, r112, r111);
        goto L23
    L10:
        if (((ArrayList) this.f161967p0).size() <= r100) goto L13;
        r110.drawBitmap((Bitmap) ListProtector.get(this.f161967p0, r100), null, this.R, r111);
        goto L23
    L51:
        return;
    L25:
        if (this.C == false) goto L40;
        float r113 = (this.f161977z - getProgressHeight()) / 2.0f;
    L28:
        if (r100 > 1) goto L52;
        float r114 = (getProgressLeft() + (getProgressWidth() * r100)) - (this.f161976y / 2.0f);
        this.R.set(r114, getProgressTop() - r113, this.f161976y + r114, getProgressBottom() + r113);
        if (((ArrayList) this.f161967p0).isEmpty() == false) goto L32;
    L35:
        r111.setColor(this.f161975x);
        if (this.E == false) goto L38;
        r110.drawCircle(r114 + (this.f161976y / 2.0f), (getProgressTop() + getProgressBottom()) / 2.0f, this.f161976y, r111);
    L39:
        r100 = r100 + 1;
        goto L28
    L38:
        RectF r115 = this.R;
        float r116 = this.A;
        r110.drawRoundRect(r115, r116, r116, r111);
        goto L39
    L32:
        if (((ArrayList) this.f161967p0).size() <= r100) goto L35;
        r110.drawBitmap((Bitmap) ListProtector.get(this.f161967p0, r100), null, this.R, r111);
        goto L39
    L52:
        return;
    }

    public final void j(float r100, float r101) {
        float r102 = Math.min(r100, r101);
        float r103 = Math.max(r102, r101);
        float r104 = r103 - r102;
        float r105 = this.f161972u;
        if (r104 >= r105) goto L5;
        r102 = r103 - r105;
    L5:
        float r106 = this.G;
        if (r102 < r106) goto L17;
        float r107 = this.H;
        if (r103 > r107) goto L15;
        float r108 = r107 - r106;
        this.T.A = Math.abs(r102 - r106) / r108;
        if (this.f161954e != 2) goto L12;
        this.U.A = Math.abs(r103 - this.G) / r108;
    L12:
        invalidate();
        return;
    L15:
        throw new IllegalArgumentException("setProgress() max > (preset max - offsetValue) . #max:" + r103 + " #preset max:" + r103);
    L17:
        throw new IllegalArgumentException("setProgress() min < (preset min - offsetValue) . #min:" + r102 + " #preset min:" + r103);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        int r103 = View.MeasureSpec.getMode(r101);
        if (r103 != 1073741824) goto L6;
        int r104 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L23:
        super.onMeasure(r100, r104);
        return;
    L6:
        if (r103 != Integer.MIN_VALUE) goto L13;
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        if (r102 != (-1)) goto L13;
        r104 = View.MeasureSpec.makeMeasureSpec(((ViewGroup) getParent()).getMeasuredHeight(), Integer.MIN_VALUE);
    L13:
        if (this.f161973v == 2) goto L15;
        float r105 = getRawHeight();
    L22:
        r104 = View.MeasureSpec.makeMeasureSpec((int) r105, 1073741824);
        goto L23
    L15:
        if (this.f161963m != null) goto L17;
    L19:
        float r106 = getRawHeight();
        float r107 = Math.max(this.T.d(), this.U.d()) / 2.0f;
    L20:
        r105 = (r106 - r107) * 2.0f;
        goto L22
    L17:
        if (this.f161959j != 1) goto L19;
        r106 = getRawHeight();
        r107 = getTickMarkRawHeight();
        goto L20
    }

    public final void k(float r100, float r101, float r102) {
        if (r101 <= r100) goto L27;
        if (r102 < 0.0f) goto L25;
        float r103 = r101 - r100;
        if (r102 >= r103) goto L23;
        this.H = r101;
        this.G = r100;
        this.f161972u = r102;
        float r104 = r102 / r103;
        this.L = r104;
        if (this.f161954e != 2) goto L20;
        SeekBar r105 = this.T;
        float r106 = r105.A;
        if ((r106 + r104) > 1.0f) goto L15;
        float r107 = r106 + r104;
        SeekBar r108 = this.U;
        if (r107 <= r108.A) goto L15;
        r108.A = r106 + r104;
    L15:
        float r109 = this.U.A;
        if ((r109 - r104) < 0.0f) goto L20;
        if ((r109 - r104) >= r106) goto L20;
        r105.A = r109 - r104;
    L20:
        invalidate();
        return;
    L23:
        throw new IllegalArgumentException("setRange() interval must be less than (max - min) ! #minInterval:" + r102 + " #max - min:" + r103);
    L25:
        throw new IllegalArgumentException("setRange() interval must be greater than zero ! #minInterval:" + r102);
    L27:
        throw new IllegalArgumentException("setRange() max must be greater than min ! #max:" + r101 + " #min:" + r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = (r101 - getPaddingBottom()) - getPaddingTop();
        if (r101 <= 0) goto L33;
        int r105 = this.f161973v;
        if (r105 != 0) goto L20;
        SeekBar r106 = this.T;
        if (r106.f161985a == 1) goto L10;
    L13:
        float r107 = Math.max(r106.c(), this.U.c());
    L14:
        float r108 = Math.max(this.T.d(), this.U.d());
        float r109 = this.f161970s;
        float r110 = r108 - (r109 / 2.0f);
        this.f161950a = (int) (((r110 - r109) / 2.0f) + r107);
        if (this.f161963m != null) goto L17;
    L19:
        this.f161951b = this.f161950a + this.f161970s;
    L29:
        int r111 = ((int) Math.max(this.T.e(), this.U.e())) / 2;
        this.f161952c = getPaddingLeft() + r111;
        int r112 = (r100 - r111) - getPaddingRight();
        this.f161953d = r112;
        this.f161971t = r112 - this.f161952c;
        this.O.set(getProgressLeft(), getProgressTop(), getProgressRight(), getProgressBottom());
        this.H0 = r100 - this.f161953d;
        if (this.f161964n > 0.0f) goto L32;
        this.f161964n = (int) ((getProgressBottom() - getProgressTop()) * 0.45f);
    L32:
        d();
        goto L33
    L17:
        if (this.f161959j != 0) goto L19;
        this.f161950a = (int) Math.max(getTickMarkRawHeight(), r107 + ((r110 - this.f161970s) / 2.0f));
        goto L19
    L10:
        if (this.U.f161985a != 1) goto L13;
        r107 = 0.0f;
        goto L14
    L20:
        if (r105 == 1) goto L22;
        int r113 = this.f161970s;
        int r114 = (r104 - r113) / 2;
        this.f161950a = r114;
        this.f161951b = r114 + r113;
        goto L29
    L22:
        if (this.f161963m != null) goto L24;
    L26:
        this.f161951b = (int) ((r104 - (Math.max(this.T.d(), this.U.d()) / 2.0f)) + (this.f161970s / 2.0f));
    L27:
        this.f161950a = this.f161951b - this.f161970s;
        goto L29
    L24:
        if (this.f161959j != 1) goto L26;
        this.f161951b = r104 - getTickMarkRawHeight();
    L33:
        k(this.G, this.H, this.f161972u);
        int r115 = (getProgressBottom() + getProgressTop()) / 2;
        this.T.i(getProgressLeft(), r115);
        if (this.f161954e != 2) goto L37;
        this.U.i(getProgressLeft(), r115);
        return;
    }
}
