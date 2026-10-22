package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes11.dex */
public class CircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ImageView.ScaleType f160771k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Bitmap.Config f160772l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f160773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BitmapShader f160774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f160775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f160776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f160777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f160778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f160779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f160780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f160781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f160782j;

    static {
        f160771k = ImageView.ScaleType.CENTER_CROP;
        f160772l = Bitmap.Config.ARGB_8888;
    }

    public final void init() {
        super.setScaleType(f160771k);
        this.f160781i = true;
        if (this.f160782j == false) goto L6;
        l();
        this.f160782j = false;
        return;
    }

    public final void l() {
        if (this.f160781i == true) goto L7;
        this.f160782j = true;
        return;
    L7:
        if (this.f160773a != null) goto L9;
        return;
    L9:
        Bitmap r100 = this.f160773a;
        Shader.TileMode r101 = Shader.TileMode.CLAMP;
        this.f160774b = new BitmapShader(r100, r101, r101);
        this.f160775c.setAntiAlias(true);
        this.f160775c.setShader(this.f160774b);
        this.f160776d = this.f160773a.getWidth();
        this.f160777e = this.f160773a.getHeight();
        float r102 = 0.0f;
        this.f160779g.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f160778f = Math.min(this.f160779g.width() / 2.0f, this.f160779g.height() / 2.0f);
        this.f160780h.set(null);
        if ((this.f160776d * this.f160779g.height()) <= (this.f160777e * this.f160779g.width())) goto L12;
        float r103 = this.f160779g.height() / this.f160777e;
        r102 = (this.f160779g.width() - (this.f160776d * r103)) * 0.5f;
        float r104 = 0.0f;
    L13:
        this.f160780h.setScale(r103, r103);
        Matrix r105 = this.f160780h;
        RectF r106 = this.f160779g;
        r105.postTranslate(((int) (r102 + 0.5f)) + r106.left, ((int) (r104 + 0.5f)) + r106.top);
        this.f160774b.setLocalMatrix(this.f160780h);
        invalidate();
        return;
    L12:
        r103 = this.f160779g.width() / this.f160776d;
        r104 = (this.f160779g.height() - (this.f160777e * r103)) * 0.5f;
        goto L13
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f160771k;
    }

    public CircleImageView(Context r100) {
        super(r100);
        this.f160775c = new Paint();
        this.f160779g = new RectF();
        this.f160780h = new Matrix();
        init();
    }

    public final Bitmap j(Drawable r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof BitmapDrawable) == true) goto L8;
    L15:
        return null;
    L10:
        if ((r100 instanceof ColorDrawable) == false) goto L12;
        Bitmap r101 = Bitmap.createBitmap(2, 2, f160772l);     // Catch: OutOfMemoryError -> L15
    L13:
        Canvas r102 = new Canvas(r101);     // Catch: OutOfMemoryError -> L15
        r100.setBounds(0, 0, r102.getWidth(), r102.getHeight());     // Catch: OutOfMemoryError -> L15
        r100.draw(r102);     // Catch: OutOfMemoryError -> L15
        return r101;
    L12:
        r101 = Bitmap.createBitmap(r100.getIntrinsicWidth(), r100.getIntrinsicHeight(), f160772l);     // Catch: OutOfMemoryError -> L15
        goto L13
    L8:
        return ((BitmapDrawable) r100).getBitmap();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        r100.drawCircle(getWidth() / 2, getHeight() / 2, this.f160778f, this.f160775c);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        this.f160773a = r100;
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        this.f160773a = j(r100);
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        super.setImageResource(r100);
        this.f160773a = j(getDrawable());
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r100) {
        super.setImageURI(r100);
        this.f160773a = j(getDrawable());
        l();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        if (r100 != f160771k) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r100}));
    }

    public CircleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f160775c = new Paint();
        this.f160779g = new RectF();
        this.f160780h = new Matrix();
        init();
    }

    public CircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160775c = new Paint();
        this.f160779g = new RectF();
        this.f160780h = new Matrix();
        init();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        l();
    }
}
