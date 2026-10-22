package com.obric.oui.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R$attr;
import androidx.core.internal.view.SupportMenu;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.primitives.Ints;
import com.obric.oui.constraintlayout.motion.widget.FloatLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class MotionLabel extends View implements FloatLayout {
    public float A;
    public float B;
    public float C;
    public Drawable D;
    public Matrix E;
    public Bitmap F;
    public BitmapShader G;
    public Matrix H;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f14003J;
    public float K;
    public float L;
    public Paint M;
    public int N;
    public Rect O;
    public Paint P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public float U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextPaint f14004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f14005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f14009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f14010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewOutlineProvider f14011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f14012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f14017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f14018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14019p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Rect f14020q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14021r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f14022s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14023t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14024u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f14025v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Layout f14026w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14027x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14028y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f14029z;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionLabel f14030a;

        public a(MotionLabel r10) {
            this.f14030a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            int r12 = this.f14030a.getWidth();
            int r13 = this.f14030a.getHeight();
            r11.setRoundRect(0, 0, r12, r13, (Math.min(r12, r13) * MotionLabel.a(this.f14030a)) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionLabel f14031a;

        public b(MotionLabel r10) {
            this.f14031a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            r11.setRoundRect(0, 0, this.f14031a.getWidth(), this.f14031a.getHeight(), MotionLabel.b(this.f14031a));
        }
    }

    public MotionLabel(Context r10) {
        super(r10);
        this.f14004a = new TextPaint();
        this.f14005b = new Path();
        this.f14006c = SupportMenu.USER_MASK;
        this.f14007d = SupportMenu.USER_MASK;
        this.f14008e = false;
        this.f14009f = 0.0f;
        this.f14010g = Float.NaN;
        this.f14013j = 48.0f;
        this.f14014k = Float.NaN;
        this.f14017n = 0.0f;
        this.f14018o = "Hello World";
        this.f14019p = true;
        this.f14020q = new Rect();
        this.f14021r = 1;
        this.f14022s = 1;
        this.f14023t = 1;
        this.f14024u = 1;
        this.f14027x = BadgeDrawable.TOP_START;
        this.f14028y = 0;
        this.f14029z = false;
        this.I = Float.NaN;
        this.f14003J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(r10, null);
    }

    public static /* synthetic */ float a(MotionLabel r10) {
        return r10.f14009f;
    }

    public static /* synthetic */ float b(MotionLabel r10) {
        return r10.f14010g;
    }

    private float getHorizontalOffset() {
        if (Float.isNaN(this.f14014k) == false) goto L5;
        float r10 = 1.0f;
    L6:
        TextPaint r11 = this.f14004a;
        String r12 = this.f14018o;
        float r13 = r10 * r11.measureText(r12, 0, r12.length());
        if (Float.isNaN(this.B) == false) goto L9;
        float r14 = getMeasuredWidth();
    L11:
        return ((((r14 - getPaddingLeft()) - getPaddingRight()) - r13) * (this.K + 1.0f)) / 2.0f;
    L9:
        r14 = this.B;
        goto L11
    L5:
        r10 = this.f14013j / this.f14014k;
        goto L6
    }

    private float getVerticalOffset() {
        if (Float.isNaN(this.f14014k) == false) goto L5;
        float r10 = 1.0f;
    L6:
        Paint.FontMetrics r11 = this.f14004a.getFontMetrics();
        if (Float.isNaN(this.C) == false) goto L9;
        float r12 = getMeasuredHeight();
    L10:
        float r13 = (r12 - getPaddingTop()) - getPaddingBottom();
        float r14 = r11.descent;
        float r15 = r11.ascent;
        return (((r13 - ((r14 - r15) * r10)) * (1.0f - this.L)) / 2.0f) - (r10 * r15);
    L9:
        r12 = this.C;
        goto L10
    L5:
        r10 = this.f14013j / this.f14014k;
        goto L6
    }

    private void setUpTheme(Context r10) {
        TypedValue r11 = new TypedValue();
        r10.getTheme().resolveAttribute(R$attr.colorPrimary, r11, true);
        TextPaint r12 = this.f14004a;
        int r13 = r11.data;
        this.f14006c = r13;
        r12.setColor(r13);
    }

    public final void c(float r10, float r11, float r12, float r13) {
        if (this.H != null) goto L5;
        return;
    L5:
        this.B = r12 - r10;
        this.C = r13 - r11;
        j();
    }

    public Bitmap d(Bitmap r10, int r11) {
        int r12 = r10.getWidth();
        int r13 = r12 / 2;
        int r14 = r10.getHeight() / 2;
        Bitmap r15 = Bitmap.createScaledBitmap(r10, r13, r14, true);
        int r16 = 0;
    L3:
        if (r16 >= r11) goto L9;
        if (r13 < 32) goto L9;
        if (r14 < 32) goto L9;
        r13 = r13 / 2;
        r14 = r14 / 2;
        r15 = Bitmap.createScaledBitmap(r15, r13, r14, true);
        r16 = r16 + 1;
    L9:
        return r15;
    }

    public void e(float r11) {
        if (this.f14008e == false) goto L5;
    L7:
        this.f14005b.reset();
        String r10 = this.f14018o;
        int r12 = r10.length();
        this.f14004a.getTextBounds(r10, 0, r12, this.f14020q);
        this.f14004a.getTextPath(r10, 0, r12, 0.0f, 0.0f, this.f14005b);
        if (r11 == 1.0f) goto L10;
        Log.v("MotionLabel", com.obric.oui.constraintlayout.motion.widget.a.a() + " scale " + r11);
        Matrix r13 = new Matrix();
        r13.postScale(r11, r11);
        this.f14005b.transform(r13);
    L10:
        Rect r14 = this.f14020q;
        r14.right--;
        r14.left++;
        r14.bottom++;
        r14.top--;
        RectF r15 = new RectF();
        r15.bottom = getHeight();
        r15.right = getWidth();
        this.f14019p = false;
        return;
    L5:
        if (r11 != 1.0f) goto L7;
    }

    public final void f(Context r10, AttributeSet r11) {
        setUpTheme(r10);
        if (r11 == null) goto L77;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R$styleable.MotionLabel);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L76;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.MotionLabel_android_text) goto L10;
        setText(r12.getText(r15));
    L75:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R$styleable.MotionLabel_android_fontFamily) goto L13;
        this.f14025v = r12.getString(r15);
        goto L75
    L13:
        if (r15 != R$styleable.MotionLabel_scaleFromTextSize) goto L16;
        this.f14014k = r12.getDimensionPixelSize(r15, (int) this.f14014k);
        goto L75
    L16:
        if (r15 != R$styleable.MotionLabel_android_textSize) goto L19;
        this.f14013j = r12.getDimensionPixelSize(r15, (int) this.f14013j);
        goto L75
    L19:
        if (r15 != R$styleable.MotionLabel_android_textStyle) goto L22;
        this.f14015l = r12.getInt(r15, this.f14015l);
        goto L75
    L22:
        if (r15 != R$styleable.MotionLabel_android_typeface) goto L25;
        this.f14016m = r12.getInt(r15, this.f14016m);
        goto L75
    L25:
        if (r15 != R$styleable.MotionLabel_android_textColor) goto L28;
        this.f14006c = r12.getColor(r15, this.f14006c);
        goto L75
    L28:
        if (r15 != R$styleable.MotionLabel_borderRound) goto L31;
        float r16 = r12.getDimension(r15, this.f14010g);
        this.f14010g = r16;
        setRound(r16);
        goto L75
    L31:
        if (r15 != R$styleable.MotionLabel_borderRoundPercent) goto L34;
        float r17 = r12.getFloat(r15, this.f14009f);
        this.f14009f = r17;
        setRoundPercent(r17);
        goto L75
    L34:
        if (r15 != R$styleable.MotionLabel_android_gravity) goto L37;
        setGravity(r12.getInt(r15, -1));
        goto L75
    L37:
        if (r15 != R$styleable.MotionLabel_android_autoSizeTextType) goto L40;
        this.f14028y = r12.getInt(r15, 0);
        goto L75
    L40:
        if (r15 != R$styleable.MotionLabel_textOutlineColor) goto L43;
        this.f14007d = r12.getInt(r15, this.f14007d);
        this.f14008e = true;
        goto L75
    L43:
        if (r15 != R$styleable.MotionLabel_textOutlineThickness) goto L46;
        this.f14017n = r12.getDimension(r15, this.f14017n);
        this.f14008e = true;
        goto L75
    L46:
        if (r15 != R$styleable.MotionLabel_textBackground) goto L49;
        this.D = r12.getDrawable(r15);
        this.f14008e = true;
        goto L75
    L49:
        if (r15 != R$styleable.MotionLabel_textBackgroundPanX) goto L52;
        this.R = r12.getFloat(r15, this.R);
        goto L75
    L52:
        if (r15 != R$styleable.MotionLabel_textBackgroundPanY) goto L55;
        this.S = r12.getFloat(r15, this.S);
        goto L75
    L55:
        if (r15 != R$styleable.MotionLabel_textPanX) goto L58;
        this.K = r12.getFloat(r15, this.K);
        goto L75
    L58:
        if (r15 != R$styleable.MotionLabel_textPanY) goto L61;
        this.L = r12.getFloat(r15, this.L);
        goto L75
    L61:
        if (r15 != R$styleable.MotionLabel_textBackgroundRotate) goto L64;
        this.U = r12.getFloat(r15, this.U);
        goto L75
    L64:
        if (r15 != R$styleable.MotionLabel_textBackgroundZoom) goto L67;
        this.T = r12.getFloat(r15, this.T);
        goto L75
    L67:
        if (r15 != R$styleable.MotionLabel_textureHeight) goto L70;
        this.I = r12.getDimension(r15, this.I);
        goto L75
    L70:
        if (r15 != R$styleable.MotionLabel_textureWidth) goto L73;
        this.f14003J = r12.getDimension(r15, this.f14003J);
        goto L75
    L73:
        if (r15 != R$styleable.MotionLabel_textureEffect) goto L75;
        this.N = r12.getInt(r15, this.N);
        goto L75
    L76:
        r12.recycle();
    L77:
        i();
        h();
    }

    public final void g(String r10, int r11, int r12) {
        if (r10 == null) goto L7;
        Typeface r13 = Typeface.create(r10, r12);
        if (r13 == null) goto L8;
        setTypeface(r13);
        return;
    L8:
        boolean r14 = true;
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L12;
        r13 = Typeface.SERIF;
    L17:
        float r15 = 0.0f;
        if (r12 <= 0) goto L34;
        if (r13 != null) goto L21;
        Typeface r16 = Typeface.defaultFromStyle(r12);
    L22:
        setTypeface(r16);
        if (r16 == null) goto L25;
        int r17 = r16.getStyle();
    L26:
        int r18 = (~r17) & r12;
        TextPaint r19 = this.f14004a;
        if ((r18 & 1) != 0) goto L30;
        r14 = false;
    L30:
        r19.setFakeBoldText(r14);
        TextPaint r20 = this.f14004a;
        if ((r18 & 2) == 0) goto L33;
        r15 = -0.25f;
    L33:
        r20.setTextSkewX(r15);
        return;
    L25:
        r17 = 0;
        goto L26
    L21:
        r16 = Typeface.create(r13, r12);
        goto L22
    L34:
        this.f14004a.setFakeBoldText(false);
        this.f14004a.setTextSkewX(0.0f);
        setTypeface(r13);
        return;
    L12:
        if (r11 != 3) goto L17;
        r13 = Typeface.MONOSPACE;
        goto L17
    L16:
        r13 = Typeface.SANS_SERIF;
        goto L17
    L7:
        r13 = null;
        goto L8
    }

    public float getRound() {
        return this.f14010g;
    }

    public float getRoundPercent() {
        return this.f14009f;
    }

    public float getScaleFromTextSize() {
        return this.f14014k;
    }

    public float getTextBackgroundPanX() {
        return this.R;
    }

    public float getTextBackgroundPanY() {
        return this.S;
    }

    public float getTextBackgroundRotate() {
        return this.U;
    }

    public float getTextBackgroundZoom() {
        return this.T;
    }

    public int getTextOutlineColor() {
        return this.f14007d;
    }

    public float getTextPanX() {
        return this.K;
    }

    public float getTextPanY() {
        return this.L;
    }

    public float getTextureHeight() {
        return this.I;
    }

    public float getTextureWidth() {
        return this.f14003J;
    }

    public Typeface getTypeface() {
        return this.f14004a.getTypeface();
    }

    public void h() {
        this.f14021r = getPaddingLeft();
        this.f14022s = getPaddingRight();
        this.f14023t = getPaddingTop();
        this.f14024u = getPaddingBottom();
        g(this.f14025v, this.f14016m, this.f14015l);
        this.f14004a.setColor(this.f14006c);
        this.f14004a.setStrokeWidth(this.f14017n);
        this.f14004a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f14004a.setFlags(128);
        setTextSize(this.f14013j);
        this.f14004a.setAntiAlias(true);
    }

    public final void i() {
        if (this.D == null) goto L28;
        this.H = new Matrix();
        int r10 = this.D.getIntrinsicWidth();
        int r11 = this.D.getIntrinsicHeight();
        int r12 = 128;
        if (r10 > 0) goto L12;
        r10 = getWidth();
        if (r10 != 0) goto L12;
        if (Float.isNaN(this.f14003J) == false) goto L11;
        r10 = 128;
        goto L12
    L11:
        r10 = (int) this.f14003J;
    L12:
        if (r11 > 0) goto L21;
        r11 = getHeight();
        if (r11 != 0) goto L21;
        if (Float.isNaN(this.I) == true) goto L19;
        r12 = (int) this.I;
    L19:
        r11 = r12;
    L21:
        if (this.N == 0) goto L23;
        r10 = r10 / 2;
        r11 = r11 / 2;
    L23:
        this.F = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(this.F);
        this.D.setBounds(0, 0, r13.getWidth(), r13.getHeight());
        this.D.setFilterBitmap(true);
        this.D.draw(r13);
        if (this.N == 0) goto L26;
        this.F = d(this.F, 4);
    L26:
        Bitmap r14 = this.F;
        Shader.TileMode r15 = Shader.TileMode.REPEAT;
        this.G = new BitmapShader(r14, r15, r15);
        return;
    }

    public final void j() {
        float r10 = 0.0f;
        if (Float.isNaN(this.R) == false) goto L5;
        float r11 = 0.0f;
    L7:
        if (Float.isNaN(this.S) == false) goto L9;
        float r12 = 0.0f;
    L11:
        if (Float.isNaN(this.T) == false) goto L13;
        float r13 = 1.0f;
    L15:
        if (Float.isNaN(this.U) == true) goto L18;
        r10 = this.U;
    L18:
        this.H.reset();
        float r14 = this.F.getWidth();
        float r15 = this.F.getHeight();
        if (Float.isNaN(this.f14003J) == false) goto L21;
        float r16 = this.B;
    L23:
        if (Float.isNaN(this.I) == false) goto L25;
        float r17 = this.C;
    L27:
        if ((r14 * r17) >= (r15 * r16)) goto L29;
        float r18 = r16 / r14;
    L30:
        float r19 = r13 * r18;
        this.H.postScale(r19, r19);
        float r20 = r14 * r19;
        float r21 = r16 - r20;
        float r22 = r19 * r15;
        float r23 = r17 - r22;
        if (Float.isNaN(this.I) == true) goto L34;
        r23 = this.I / 2.0f;
    L34:
        if (Float.isNaN(this.f14003J) == true) goto L36;
        r21 = this.f14003J / 2.0f;
    L36:
        float r24 = (((r12 * r23) + r17) - r22) * 0.5f;
        this.H.postTranslate((((r11 * r21) + r16) - r20) * 0.5f, r24);
        this.H.postRotate(r10, r16 / 2.0f, r17 / 2.0f);
        this.G.setLocalMatrix(this.H);
        return;
    L29:
        r18 = r17 / r15;
        goto L30
    L25:
        r17 = this.I;
        goto L27
    L21:
        r16 = this.f14003J;
        goto L23
    L13:
        r13 = this.T;
        goto L15
    L9:
        r12 = this.S;
        goto L11
    L5:
        r11 = this.R;
        goto L7
    }

    @Override // android.view.View
    public void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        boolean r14 = Float.isNaN(this.f14014k);
        if (r14 == false) goto L5;
        float r15 = 1.0f;
    L6:
        this.B = r12 - r10;
        this.C = r13 - r11;
        if (this.f14029z == false) goto L22;
        if (this.O != null) goto L11;
        this.P = new Paint();
        this.O = new Rect();
        this.P.set(this.f14004a);
        this.Q = this.P.getTextSize();
    L11:
        Paint r16 = this.P;
        String r17 = this.f14018o;
        r16.getTextBounds(r17, 0, r17.length(), this.O);
        int r18 = this.O.width();
        int r19 = (int) (this.O.height() * 1.3f);
        float r20 = (this.B - this.f14022s) - this.f14021r;
        float r21 = (this.C - this.f14024u) - this.f14023t;
        if (r14 == false) goto L17;
        float r22 = r18;
        float r23 = r19;
        if ((r22 * r21) <= (r23 * r20)) goto L16;
        this.f14004a.setTextSize((this.Q * r20) / r22);
        goto L22
    L16:
        this.f14004a.setTextSize((this.Q * r21) / r23);
        goto L22
    L17:
        float r24 = r18;
        float r25 = r19;
        if ((r24 * r21) <= (r25 * r20)) goto L20;
        r15 = r20 / r24;
        goto L22
    L20:
        r15 = r21 / r25;
    L22:
        if (this.f14008e == true) goto L24;
        if (r14 == false) goto L24;
        return;
    L24:
        c(r10, r11, r12, r13);
        e(r15);
        return;
    L5:
        r15 = this.f14013j / this.f14014k;
        goto L6
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        if (Float.isNaN(this.f14014k) == false) goto L5;
        float r11 = 1.0f;
    L6:
        super.onDraw(r10);
        if (this.f14008e == true) goto L13;
        if (r11 != 1.0f) goto L13;
        float r12 = this.f14021r + getHorizontalOffset();
        r10.drawText(this.f14018o, this.A + r12, this.f14023t + getVerticalOffset(), this.f14004a);
        return;
    L13:
        if (this.f14019p == false) goto L16;
        e(r11);
    L16:
        if (this.E != null) goto L19;
        this.E = new Matrix();
    L19:
        if (this.f14008e == false) goto L28;
        this.M.set(this.f14004a);
        this.E.reset();
        float r13 = this.f14021r + getHorizontalOffset();
        float r14 = this.f14023t + getVerticalOffset();
        this.E.postTranslate(r13, r14);
        this.E.preScale(r11, r11);
        this.f14005b.transform(this.E);
        if (this.G == null) goto L23;
        this.f14004a.setFilterBitmap(true);
        this.f14004a.setShader(this.G);
    L24:
        this.f14004a.setStyle(Paint.Style.FILL);
        this.f14004a.setStrokeWidth(this.f14017n);
        r10.drawPath(this.f14005b, this.f14004a);
        if (this.G == null) goto L27;
        this.f14004a.setShader(null);
    L27:
        this.f14004a.setColor(this.f14007d);
        this.f14004a.setStyle(Paint.Style.STROKE);
        this.f14004a.setStrokeWidth(this.f14017n);
        r10.drawPath(this.f14005b, this.f14004a);
        this.E.reset();
        this.E.postTranslate(-r13, -r14);
        this.f14005b.transform(this.E);
        this.f14004a.set(this.M);
        return;
    L23:
        this.f14004a.setColor(this.f14006c);
        goto L24
    L28:
        float r15 = this.f14021r + getHorizontalOffset();
        float r16 = this.f14023t + getVerticalOffset();
        this.E.reset();
        this.E.preTranslate(r15, r16);
        this.f14005b.transform(this.E);
        this.f14004a.setColor(this.f14006c);
        this.f14004a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f14004a.setStrokeWidth(this.f14017n);
        r10.drawPath(this.f14005b, this.f14004a);
        this.E.reset();
        this.E.preTranslate(-r15, -r16);
        this.f14005b.transform(this.E);
        return;
    L5:
        r11 = this.f14013j / this.f14014k;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r10);
        int r15 = View.MeasureSpec.getSize(r11);
        this.f14029z = false;
        this.f14021r = getPaddingLeft();
        this.f14022s = getPaddingRight();
        this.f14023t = getPaddingTop();
        this.f14024u = getPaddingBottom();
        if (r12 != 1073741824) goto L9;
        if (r13 != 1073741824) goto L9;
        if (this.f14028y == 0) goto L18;
        this.f14029z = true;
    L18:
        setMeasuredDimension(r14, r15);
        return;
    L9:
        TextPaint r16 = this.f14004a;
        String r17 = this.f14018o;
        r16.getTextBounds(r17, 0, r17.length(), this.f14020q);
        if (r12 == 1073741824) goto L12;
        r14 = (int) (this.f14020q.width() + 0.99999f);
    L12:
        r14 = r14 + (this.f14021r + this.f14022s);
        if (r13 == 1073741824) goto L18;
        int r18 = (int) (this.f14004a.getFontMetricsInt(null) + 0.99999f);
        if (r13 != Integer.MIN_VALUE) goto L17;
        r18 = Math.min(r15, r18);
    L17:
        r15 = (this.f14023t + this.f14024u) + r18;
        goto L18
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int r10) {
        if ((r10 & 8388615) != 0) goto L6;
        r10 = r10 | 8388611;
    L6:
        if ((r10 & 112) != 0) goto L9;
        r10 = r10 | 48;
    L9:
        if (r10 == this.f14027x) goto L11;
        invalidate();
    L11:
        this.f14027x = r10;
        int r11 = r10 & 112;
        if (r11 != 48) goto L14;
        this.L = -1.0f;
    L18:
        int r12 = r10 & 8388615;
        if (r12 != 3) goto L21;
    L27:
        this.K = -1.0f;
        return;
    L21:
        if (r12 == 5) goto L26;
        if (r12 == 8388611) goto L27;
        if (r12 == 8388613) goto L26;
        this.K = 0.0f;
        return;
    L26:
        this.K = 1.0f;
        return;
    L14:
        if (r11 == 80) goto L16;
        this.L = 0.0f;
        goto L18
    L16:
        this.L = 1.0f;
        goto L18
    }

    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.f14010g = r10;
        float r11 = this.f14009f;
        this.f14009f = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.f14010g == r10) goto L9;
        boolean r12 = true;
    L10:
        this.f14010g = r10;
        if (r10 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r12 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f14005b != null) goto L16;
        this.f14005b = new Path();
    L16:
        if (this.f14012i != null) goto L19;
        this.f14012i = new RectF();
    L19:
        if (this.f14011h != null) goto L21;
        b r13 = new b(this);
        this.f14011h = r13;
        setOutlineProvider(r13);
    L21:
        setClipToOutline(true);
        this.f14012i.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f14005b.reset();
        Path r14 = this.f14005b;
        RectF r15 = this.f14012i;
        float r16 = this.f14010g;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        goto L23
    L9:
        r12 = false;
        goto L10
    }

    public void setRoundPercent(float r10) {
        if (this.f14009f == r10) goto L5;
        boolean r11 = true;
    L6:
        this.f14009f = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r11 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f14005b != null) goto L12;
        this.f14005b = new Path();
    L12:
        if (this.f14012i != null) goto L15;
        this.f14012i = new RectF();
    L15:
        if (this.f14011h != null) goto L17;
        a r12 = new a(this);
        this.f14011h = r12;
        setOutlineProvider(r12);
    L17:
        setClipToOutline(true);
        int r13 = getWidth();
        int r14 = getHeight();
        float r15 = (Math.min(r13, r14) * this.f14009f) / 2.0f;
        this.f14012i.set(0.0f, 0.0f, r13, r14);
        this.f14005b.reset();
        this.f14005b.addRoundRect(this.f14012i, r15, r15, Path.Direction.CW);
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public void setScaleFromTextSize(float r10) {
        this.f14014k = r10;
    }

    public void setText(CharSequence r10) {
        this.f14018o = r10.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float r10) {
        this.R = r10;
        j();
        invalidate();
    }

    public void setTextBackgroundPanY(float r10) {
        this.S = r10;
        j();
        invalidate();
    }

    public void setTextBackgroundRotate(float r10) {
        this.U = r10;
        j();
        invalidate();
    }

    public void setTextBackgroundZoom(float r10) {
        this.T = r10;
        j();
        invalidate();
    }

    public void setTextFillColor(int r10) {
        this.f14006c = r10;
        invalidate();
    }

    public void setTextOutlineColor(int r10) {
        this.f14007d = r10;
        this.f14008e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float r10) {
        this.f14017n = r10;
        this.f14008e = true;
        if (Float.isNaN(r10) == false) goto L5;
        this.f14017n = 1.0f;
        this.f14008e = false;
    L5:
        invalidate();
    }

    public void setTextPanX(float r10) {
        this.K = r10;
        invalidate();
    }

    public void setTextPanY(float r10) {
        this.L = r10;
        invalidate();
    }

    public void setTextSize(float r10) {
        this.f14013j = r10;
        TextPaint r11 = this.f14004a;
        if (Float.isNaN(this.f14014k) == true) goto L6;
        r10 = this.f14014k;
    L6:
        r11.setTextSize(r10);
        if (Float.isNaN(this.f14014k) == false) goto L9;
        float r12 = 1.0f;
    L10:
        e(r12);
        requestLayout();
        invalidate();
        return;
    L9:
        r12 = this.f14013j / this.f14014k;
        goto L10
    }

    public void setTextureHeight(float r10) {
        this.I = r10;
        j();
        invalidate();
    }

    public void setTextureWidth(float r10) {
        this.f14003J = r10;
        j();
        invalidate();
    }

    public void setTypeface(Typeface r10) {
        if (Objects.equals(this.f14004a.getTypeface(), r10) == true) goto L8;
        this.f14004a.setTypeface(r10);
        if (this.f14026w == null) goto L9;
        this.f14026w = null;
        requestLayout();
        invalidate();
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.FloatLayout
    public void layout(float r10, float r11, float r12, float r13) {
        int r14 = (int) (r10 + 0.5f);
        this.A = r10 - r14;
        int r15 = (int) (r12 + 0.5f);
        int r16 = r15 - r14;
        int r17 = (int) (r13 + 0.5f);
        int r18 = (int) (0.5f + r11);
        int r19 = r17 - r18;
        float r20 = r12 - r10;
        this.B = r20;
        float r21 = r13 - r11;
        this.C = r21;
        c(r10, r11, r12, r13);
        if (getMeasuredHeight() == r19) goto L5;
    L8:
        measure(View.MeasureSpec.makeMeasureSpec(r16, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r19, Ints.MAX_POWER_OF_TWO));
        super.layout(r14, r18, r15, r17);
    L10:
        if (this.f14029z == true) goto L12;
        return;
    L12:
        if (this.O != null) goto L14;
        this.P = new Paint();
        this.O = new Rect();
        this.P.set(this.f14004a);
        this.Q = this.P.getTextSize();
    L14:
        this.B = r20;
        this.C = r21;
        Paint r22 = this.P;
        String r110 = this.f14018o;
        r22.getTextBounds(r110, 0, r110.length(), this.O);
        int r23 = this.O.width();
        float r111 = this.O.height() * 1.3f;
        float r24 = (r20 - this.f14022s) - this.f14021r;
        float r25 = (r21 - this.f14024u) - this.f14023t;
        float r26 = r23;
        if ((r26 * r25) <= (r111 * r24)) goto L17;
        this.f14004a.setTextSize((this.Q * r24) / r26);
    L19:
        if (this.f14008e == true) goto L23;
        if (Float.isNaN(this.f14014k) == false) goto L23;
        return;
    L23:
        if (Float.isNaN(this.f14014k) == false) goto L25;
        float r27 = 1.0f;
    L26:
        e(r27);
        return;
    L25:
        r27 = this.f14013j / this.f14014k;
        goto L26
    L17:
        this.f14004a.setTextSize((this.Q * r25) / r111);
        goto L19
    L5:
        if (getMeasuredWidth() != r16) goto L8;
        super.layout(r14, r18, r15, r17);
        goto L10
    }

    public MotionLabel(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14004a = new TextPaint();
        this.f14005b = new Path();
        this.f14006c = SupportMenu.USER_MASK;
        this.f14007d = SupportMenu.USER_MASK;
        this.f14008e = false;
        this.f14009f = 0.0f;
        this.f14010g = Float.NaN;
        this.f14013j = 48.0f;
        this.f14014k = Float.NaN;
        this.f14017n = 0.0f;
        this.f14018o = "Hello World";
        this.f14019p = true;
        this.f14020q = new Rect();
        this.f14021r = 1;
        this.f14022s = 1;
        this.f14023t = 1;
        this.f14024u = 1;
        this.f14027x = BadgeDrawable.TOP_START;
        this.f14028y = 0;
        this.f14029z = false;
        this.I = Float.NaN;
        this.f14003J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(r10, r11);
    }

    public MotionLabel(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14004a = new TextPaint();
        this.f14005b = new Path();
        this.f14006c = SupportMenu.USER_MASK;
        this.f14007d = SupportMenu.USER_MASK;
        this.f14008e = false;
        this.f14009f = 0.0f;
        this.f14010g = Float.NaN;
        this.f14013j = 48.0f;
        this.f14014k = Float.NaN;
        this.f14017n = 0.0f;
        this.f14018o = "Hello World";
        this.f14019p = true;
        this.f14020q = new Rect();
        this.f14021r = 1;
        this.f14022s = 1;
        this.f14023t = 1;
        this.f14024u = 1;
        this.f14027x = BadgeDrawable.TOP_START;
        this.f14028y = 0;
        this.f14029z = false;
        this.I = Float.NaN;
        this.f14003J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(r10, r11);
    }
}
