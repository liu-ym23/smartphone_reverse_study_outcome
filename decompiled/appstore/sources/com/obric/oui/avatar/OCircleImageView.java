package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.common.oui.R$styleable;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes4.dex */
public class OCircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ImageView.ScaleType f12365v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Bitmap.Config f12366w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f12367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f12368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f12369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f12370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f12371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f12372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f12377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f12378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorFilter f12381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12387u;

    public static /* synthetic */ class a {
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCircleImageView f12388a;

        public b(OCircleImageView r10) {
            this.f12388a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            if (OCircleImageView.a(this.f12388a) == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r10, r11);
            return;
        L5:
            Rect r12 = new Rect();
            OCircleImageView.b(this.f12388a).roundOut(r12);
            r11.setRoundRect(r12, r12.width() / 2.0f);
        }

        public /* synthetic */ b(OCircleImageView r10, a r11) {
            this(r10);
        }
    }

    static {
        f12365v = ImageView.ScaleType.CENTER_CROP;
        f12366w = Bitmap.Config.ARGB_8888;
    }

    public OCircleImageView(Context r10) {
        super(r10);
        this.f12367a = new RectF();
        this.f12368b = new RectF();
        this.f12369c = new Matrix();
        this.f12370d = new Paint();
        this.f12371e = new Paint();
        this.f12372f = new Paint();
        this.f12373g = -16777216;
        this.f12374h = 0;
        this.f12375i = 0;
        this.f12376j = PrivateKeyType.INVALID;
        g();
    }

    public static /* synthetic */ boolean a(OCircleImageView r10) {
        return r10.f12386t;
    }

    public static /* synthetic */ RectF b(OCircleImageView r10) {
        return r10.f12368b;
    }

    private void g() {
        this.f12382p = true;
        super.setScaleType(f12365v);
        this.f12370d.setAntiAlias(true);
        this.f12370d.setDither(true);
        this.f12370d.setFilterBitmap(true);
        this.f12370d.setAlpha(this.f12376j);
        this.f12370d.setColorFilter(this.f12381o);
        this.f12371e.setStyle(Paint.Style.STROKE);
        this.f12371e.setAntiAlias(true);
        this.f12371e.setColor(this.f12373g);
        this.f12371e.setStrokeWidth(this.f12374h);
        this.f12372f.setStyle(Paint.Style.FILL);
        this.f12372f.setAntiAlias(true);
        this.f12372f.setColor(this.f12375i);
        setOutlineProvider(new b(this, null));
    }

    public final RectF c() {
        int r10 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r11 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r12 = Math.min(r10, r11);
        float r13 = getPaddingLeft() + ((r10 - r12) / 2.0f);
        float r14 = getPaddingTop() + ((r11 - r12) / 2.0f);
        float r15 = r12;
        return new RectF(r13, r14, r13 + r15, r15 + r14);
    }

    public final RectF d() {
        int r10 = getWidth() - (this.f12387u * 2);
        int r11 = getHeight() - (this.f12387u * 2);
        int r12 = Math.min(r11, r10);
        int r13 = this.f12387u;
        float r14 = r13 + ((r10 - r12) / 2.0f);
        float r15 = r13 + ((r11 - r12) / 2.0f);
        float r16 = r12;
        return new RectF(r14, r15, r14 + r16, r16 + r15);
    }

    public final Bitmap e(Drawable r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof BitmapDrawable) == true) goto L8;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        if ((r10 instanceof ColorDrawable) == false) goto L14;
        Bitmap r11 = Bitmap.createBitmap(2, 2, f12366w);     // Catch: Exception -> L12
    L15:
        Canvas r12 = new Canvas(r11);     // Catch: Exception -> L12
        r10.setBounds(0, 0, r12.getWidth(), r12.getHeight());     // Catch: Exception -> L12
        r10.draw(r12);     // Catch: Exception -> L12
        return r11;
    L14:
        r11 = Bitmap.createBitmap(r10.getIntrinsicWidth(), r10.getIntrinsicHeight(), f12366w);     // Catch: Exception -> L12
        goto L15
    L8:
        return ((BitmapDrawable) r10).getBitmap();
    }

    public final boolean f(float r10, float r11) {
        if (this.f12368b.isEmpty() == false) goto L6;
        return true;
    L6:
        if ((Math.pow(r10 - this.f12368b.centerX(), 2.0d) + Math.pow(r11 - this.f12368b.centerY(), 2.0d)) <= Math.pow(this.f12380n, 2.0d)) goto L10;
        return false;
    L10:
        return true;
    }

    public int getBorderColor() {
        return this.f12373g;
    }

    public int getBorderWidth() {
        return this.f12374h;
    }

    public int getCircleBackgroundColor() {
        return this.f12375i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f12381o;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.f12376j;
    }

    public final void h() {
        Bitmap r10 = e(getDrawable());
        this.f12377k = r10;
        if (r10 != null) goto L5;
    L7:
        this.f12378l = null;
    L9:
        if (this.f12382p == true) goto L12;
        return;
    L12:
        if (this.f12377k == null) goto L14;
        j();
        return;
    L14:
        this.f12370d.setShader(null);
        return;
    L5:
        if (r10.isMutable() == false) goto L7;
        this.f12378l = new Canvas(this.f12377k);
        goto L9
    }

    public final void i() {
        this.f12368b.set(c());
        this.f12380n = Math.min((this.f12368b.height() - this.f12374h) / 2.0f, (this.f12368b.width() - this.f12374h) / 2.0f);
        this.f12367a.set(d());
        if (this.f12385s == true) goto L7;
        int r10 = this.f12374h;
        if (r10 <= 0) goto L7;
        this.f12367a.inset(r10 - 1.0f, r10 - 1.0f);
    L7:
        this.f12379m = Math.min(this.f12367a.height() / 2.0f, this.f12367a.width() / 2.0f);
        j();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r10) {
        this.f12384r = true;
        invalidate();
    }

    public final void j() {
        if (this.f12377k != null) goto L5;
        return;
    L5:
        this.f12369c.set(null);
        int r10 = this.f12377k.getHeight();
        float r11 = this.f12377k.getWidth();
        float r12 = r10;
        float r13 = 0.0f;
        if ((this.f12367a.height() * r11) <= (this.f12367a.width() * r12)) goto L8;
        float r14 = this.f12367a.height() / r12;
        float r15 = (this.f12367a.width() - (r11 * r14)) * 0.5f;
        float r16 = 0.0f;
        r13 = r15;
    L9:
        this.f12369c.setScale(r14, r14);
        Matrix r17 = this.f12369c;
        float r18 = (int) (r13 + 0.5f);
        RectF r19 = this.f12367a;
        r17.postTranslate(r18 + r19.left, ((int) (r16 + 0.5f)) + r19.top);
        this.f12383q = true;
        return;
    L8:
        r14 = this.f12367a.width() / r11;
        r16 = (this.f12367a.height() - (r12 * r14)) * 0.5f;
        goto L9
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r10) {
        if (this.f12386t == false) goto L7;
        super.onDraw(r10);
        return;
    L7:
        if (this.f12375i == 0) goto L10;
        r10.drawCircle(this.f12368b.centerX(), this.f12368b.centerY(), this.f12380n, this.f12372f);
    L10:
        if (this.f12377k == null) goto L21;
        if (this.f12384r == false) goto L17;
        if (this.f12378l == null) goto L17;
        this.f12384r = false;
        Drawable r11 = getDrawable();
        r11.setBounds(0, 0, this.f12378l.getWidth(), this.f12378l.getHeight());
        r11.draw(this.f12378l);
    L17:
        if (this.f12383q == false) goto L19;
        this.f12383q = false;
        Bitmap r12 = this.f12377k;
        Shader.TileMode r13 = Shader.TileMode.CLAMP;
        BitmapShader r14 = new BitmapShader(r12, r13, r13);
        r14.setLocalMatrix(this.f12369c);
        this.f12370d.setShader(r14);
    L19:
        r10.drawCircle(this.f12367a.centerX(), this.f12367a.centerY(), this.f12379m, this.f12370d);
    L21:
        if (this.f12374h <= 0) goto L24;
        r10.drawCircle(this.f12368b.centerX(), this.f12368b.centerY(), this.f12380n, this.f12371e);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        i();
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.f12386t == false) goto L7;
        return super.onTouchEvent(r10);
    L7:
        if (f(r10.getX(), r10.getY()) == true) goto L9;
    L11:
        return false;
    L9:
        if (super.onTouchEvent(r10) == false) goto L11;
        return true;
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r10) {
        if (r10 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(@ColorInt int r10) {
        if (r10 != this.f12373g) goto L5;
        return;
    L5:
        this.f12373g = r10;
        this.f12371e.setColor(r10);
        invalidate();
    }

    public void setBorderOverlay(boolean r10) {
        if (r10 != this.f12385s) goto L5;
        return;
    L5:
        this.f12385s = r10;
        i();
        invalidate();
    }

    public void setBorderWidth(int r10) {
        if (r10 != this.f12374h) goto L5;
        return;
    L5:
        this.f12374h = r10;
        this.f12371e.setStrokeWidth(r10);
        i();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int r10) {
        if (r10 != this.f12375i) goto L5;
        return;
    L5:
        this.f12375i = r10;
        this.f12372f.setColor(r10);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int r10) {
        setCircleBackgroundColor(getContext().getResources().getColor(r10));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r10) {
        if (r10 != this.f12381o) goto L5;
        return;
    L5:
        this.f12381o = r10;
        if (this.f12382p == false) goto L9;
        this.f12370d.setColorFilter(r10);
        invalidate();
        return;
    }

    public void setContentPadding(int r10) {
        this.f12387u = r10;
        i();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r10) {
        if (r10 != this.f12386t) goto L5;
        return;
    L5:
        this.f12386t = r10;
        if (r10 == false) goto L8;
        this.f12377k = null;
        this.f12378l = null;
        this.f12370d.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        h();
        goto L9
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r10) {
        int r11 = r10 & PrivateKeyType.INVALID;
        if (r11 != this.f12376j) goto L5;
        return;
    L5:
        this.f12376j = r11;
        if (this.f12382p == false) goto L9;
        this.f12370d.setAlpha(r11);
        invalidate();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r10) {
        super.setImageBitmap(r10);
        h();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        super.setImageDrawable(r10);
        h();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int r10) {
        super.setImageResource(r10);
        h();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r10) {
        super.setImageURI(r10);
        h();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
        i();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int r10, int r11, int r12, int r13) {
        super.setPaddingRelative(r10, r11, r12, r13);
        i();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r10) {
        if (r10 != f12365v) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r10}));
    }

    public OCircleImageView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OCircleImageView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f12367a = new RectF();
        this.f12368b = new RectF();
        this.f12369c = new Matrix();
        this.f12370d = new Paint();
        this.f12371e = new Paint();
        this.f12372f = new Paint();
        this.f12373g = -16777216;
        this.f12374h = 0;
        this.f12375i = 0;
        this.f12376j = PrivateKeyType.INVALID;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OCircleImageView, r12, 0);
        this.f12374h = r13.getDimensionPixelSize(R$styleable.OCircleImageView_o_civ_border_width, 0);
        this.f12373g = r13.getColor(R$styleable.OCircleImageView_o_civ_border_color, -16777216);
        this.f12385s = r13.getBoolean(R$styleable.OCircleImageView_o_civ_border_overlay, false);
        this.f12375i = r13.getColor(R$styleable.OCircleImageView_o_civ_circle_background_color, 0);
        r13.recycle();
        g();
    }
}
