package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;
import f.C4027a;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public c f12563a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12564b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f12565c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f12566d;

    /* renamed from: e, reason: collision with root package name */
    public float f12567e;

    /* renamed from: f, reason: collision with root package name */
    public float f12568f;

    /* renamed from: g, reason: collision with root package name */
    public float f12569g;

    /* renamed from: h, reason: collision with root package name */
    public Path f12570h;

    /* renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f12571i;

    /* renamed from: j, reason: collision with root package name */
    public RectF f12572j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable[] f12573k;

    /* renamed from: l, reason: collision with root package name */
    public LayerDrawable f12574l;

    /* renamed from: m, reason: collision with root package name */
    public float f12575m;

    /* renamed from: n, reason: collision with root package name */
    public float f12576n;

    /* renamed from: o, reason: collision with root package name */
    public float f12577o;

    /* renamed from: p, reason: collision with root package name */
    public float f12578p;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.f12568f) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f12569g);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float[] f12581a = new float[20];

        /* renamed from: b, reason: collision with root package name */
        public ColorMatrix f12582b = new ColorMatrix();

        /* renamed from: c, reason: collision with root package name */
        public ColorMatrix f12583c = new ColorMatrix();

        /* renamed from: d, reason: collision with root package name */
        public float f12584d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f12585e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f12586f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f12587g = 1.0f;

        public final void a(float f10) {
            float[] fArr = this.f12581a;
            fArr[0] = f10;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f10;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void b(float f10) {
            float f11 = 1.0f - f10;
            float f12 = 0.2999f * f11;
            float f13 = 0.587f * f11;
            float f14 = f11 * 0.114f;
            float[] fArr = this.f12581a;
            fArr[0] = f12 + f10;
            fArr[1] = f13;
            fArr[2] = f14;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f12;
            fArr[6] = f13 + f10;
            fArr[7] = f14;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f12;
            fArr[11] = f13;
            fArr[12] = f14 + f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void c(ImageView imageView) {
            boolean z10;
            this.f12582b.reset();
            float f10 = this.f12585e;
            boolean z11 = true;
            if (f10 != 1.0f) {
                b(f10);
                this.f12582b.set(this.f12581a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = this.f12586f;
            if (f11 != 1.0f) {
                this.f12583c.setScale(f11, f11, f11, 1.0f);
                this.f12582b.postConcat(this.f12583c);
                z10 = true;
            }
            float f12 = this.f12587g;
            if (f12 != 1.0f) {
                d(f12);
                this.f12583c.set(this.f12581a);
                this.f12582b.postConcat(this.f12583c);
                z10 = true;
            }
            float f13 = this.f12584d;
            if (f13 != 1.0f) {
                a(f13);
                this.f12583c.set(this.f12581a);
                this.f12582b.postConcat(this.f12583c);
            } else {
                z11 = z10;
            }
            if (z11) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f12582b));
            } else {
                imageView.clearColorFilter();
            }
        }

        public final void d(float f10) {
            float fLog;
            float fPow;
            if (f10 <= 0.0f) {
                f10 = 0.01f;
            }
            float f11 = (5000.0f / f10) / 100.0f;
            if (f11 > 66.0f) {
                double d10 = f11 - 60.0f;
                fPow = ((float) Math.pow(d10, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d10, 0.07551485300064087d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f11)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            float fLog2 = f11 < 66.0f ? f11 > 19.0f ? (((float) Math.log(f11 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.f12581a;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12563a = new c();
        this.f12564b = true;
        this.f12565c = null;
        this.f12566d = null;
        this.f12567e = 0.0f;
        this.f12568f = 0.0f;
        this.f12569g = Float.NaN;
        this.f12573k = new Drawable[2];
        this.f12575m = Float.NaN;
        this.f12576n = Float.NaN;
        this.f12577o = Float.NaN;
        this.f12578p = Float.NaN;
        h(context, attributeSet);
    }

    private void setOverlay(boolean z10) {
        this.f12564b = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f12563a.f12584d;
    }

    public float getContrast() {
        return this.f12563a.f12586f;
    }

    public float getCrossfade() {
        return this.f12567e;
    }

    public float getImagePanX() {
        return this.f12575m;
    }

    public float getImagePanY() {
        return this.f12576n;
    }

    public float getImageRotate() {
        return this.f12578p;
    }

    public float getImageZoom() {
        return this.f12577o;
    }

    public float getRound() {
        return this.f12569g;
    }

    public float getRoundPercent() {
        return this.f12568f;
    }

    public float getSaturation() {
        return this.f12563a.f12585e;
    }

    public float getWarmth() {
        return this.f12563a.f12587g;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f12565c = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f12567e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f12564b));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f12575m));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f12576n));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f12578p));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f12577o));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f12566d = drawable;
            if (this.f12565c == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f12566d = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f12573k;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f12566d = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f12573k;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f12566d = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f12573k[1] = this.f12565c.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f12573k);
            this.f12574l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f12567e * 255.0f));
            if (!this.f12564b) {
                this.f12574l.getDrawable(0).setAlpha((int) ((1.0f - this.f12567e) * 255.0f));
            }
            super.setImageDrawable(this.f12574l);
        }
    }

    public final void i() {
        if (Float.isNaN(this.f12575m) && Float.isNaN(this.f12576n) && Float.isNaN(this.f12577o) && Float.isNaN(this.f12578p)) {
            return;
        }
        float f10 = Float.isNaN(this.f12575m) ? 0.0f : this.f12575m;
        float f11 = Float.isNaN(this.f12576n) ? 0.0f : this.f12576n;
        float f12 = Float.isNaN(this.f12577o) ? 1.0f : this.f12577o;
        float f13 = Float.isNaN(this.f12578p) ? 0.0f : this.f12578p;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f14 = f12 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f14, f14);
        float f15 = intrinsicWidth * f14;
        float f16 = f14 * intrinsicHeight;
        matrix.postTranslate((((f10 * (width - f15)) + width) - f15) * 0.5f, (((f11 * (height - f16)) + height) - f16) * 0.5f);
        matrix.postRotate(f13, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void j() {
        if (Float.isNaN(this.f12575m) && Float.isNaN(this.f12576n) && Float.isNaN(this.f12577o) && Float.isNaN(this.f12578p)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            i();
        }
    }

    @Override // android.view.View
    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        i();
    }

    public void setAltImageDrawable(Drawable drawable) {
        Drawable drawableMutate = drawable.mutate();
        this.f12565c = drawableMutate;
        Drawable[] drawableArr = this.f12573k;
        drawableArr[0] = this.f12566d;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f12573k);
        this.f12574l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f12567e);
    }

    public void setAltImageResource(int i10) {
        Drawable drawableB = C4027a.b(getContext(), i10);
        this.f12565c = drawableB;
        setAltImageDrawable(drawableB);
    }

    public void setBrightness(float f10) {
        c cVar = this.f12563a;
        cVar.f12584d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        c cVar = this.f12563a;
        cVar.f12586f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.f12567e = f10;
        if (this.f12573k != null) {
            if (!this.f12564b) {
                this.f12574l.getDrawable(0).setAlpha((int) ((1.0f - this.f12567e) * 255.0f));
            }
            this.f12574l.getDrawable(1).setAlpha((int) (this.f12567e * 255.0f));
            super.setImageDrawable(this.f12574l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f12565c == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f12566d = drawableMutate;
        Drawable[] drawableArr = this.f12573k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f12565c;
        LayerDrawable layerDrawable = new LayerDrawable(this.f12573k);
        this.f12574l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f12567e);
    }

    public void setImagePanX(float f10) {
        this.f12575m = f10;
        j();
    }

    public void setImagePanY(float f10) {
        this.f12576n = f10;
        j();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f12565c == null) {
            super.setImageResource(i10);
            return;
        }
        Drawable drawableMutate = C4027a.b(getContext(), i10).mutate();
        this.f12566d = drawableMutate;
        Drawable[] drawableArr = this.f12573k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f12565c;
        LayerDrawable layerDrawable = new LayerDrawable(this.f12573k);
        this.f12574l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f12567e);
    }

    public void setImageRotate(float f10) {
        this.f12578p = f10;
        j();
    }

    public void setImageZoom(float f10) {
        this.f12577o = f10;
        j();
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f12569g = f10;
            float f11 = this.f12568f;
            this.f12568f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f12569g != f10;
        this.f12569g = f10;
        if (f10 != 0.0f) {
            if (this.f12570h == null) {
                this.f12570h = new Path();
            }
            if (this.f12572j == null) {
                this.f12572j = new RectF();
            }
            if (this.f12571i == null) {
                b bVar = new b();
                this.f12571i = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f12572j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f12570h.reset();
            Path path = this.f12570h;
            RectF rectF = this.f12572j;
            float f12 = this.f12569g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f12568f != f10;
        this.f12568f = f10;
        if (f10 != 0.0f) {
            if (this.f12570h == null) {
                this.f12570h = new Path();
            }
            if (this.f12572j == null) {
                this.f12572j = new RectF();
            }
            if (this.f12571i == null) {
                a aVar = new a();
                this.f12571i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f12568f) / 2.0f;
            this.f12572j.set(0.0f, 0.0f, width, height);
            this.f12570h.reset();
            this.f12570h.addRoundRect(this.f12572j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        c cVar = this.f12563a;
        cVar.f12585e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        c cVar = this.f12563a;
        cVar.f12587g = f10;
        cVar.c(this);
    }
}
