package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: androidx.appcompat.widget.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0450u {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f8609c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    private final ProgressBar f8610a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f8611b;

    /* renamed from: androidx.appcompat.widget.u$a */
    private static class a {
        public static void a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i5) {
            layerDrawable2.setLayerGravity(i5, layerDrawable.getLayerGravity(i5));
            layerDrawable2.setLayerWidth(i5, layerDrawable.getLayerWidth(i5));
            layerDrawable2.setLayerHeight(i5, layerDrawable.getLayerHeight(i5));
            layerDrawable2.setLayerInsetLeft(i5, layerDrawable.getLayerInsetLeft(i5));
            layerDrawable2.setLayerInsetRight(i5, layerDrawable.getLayerInsetRight(i5));
            layerDrawable2.setLayerInsetTop(i5, layerDrawable.getLayerInsetTop(i5));
            layerDrawable2.setLayerInsetBottom(i5, layerDrawable.getLayerInsetBottom(i5));
            layerDrawable2.setLayerInsetStart(i5, layerDrawable.getLayerInsetStart(i5));
            layerDrawable2.setLayerInsetEnd(i5, layerDrawable.getLayerInsetEnd(i5));
        }
    }

    C0450u(ProgressBar progressBar) {
        this.f8610a = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable e(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i5 = 0; i5 < numberOfFrames; i5++) {
            Drawable drawableD = d(animationDrawable.getFrame(i5), true);
            drawableD.setLevel(10000);
            animationDrawable2.addFrame(drawableD, animationDrawable.getDuration(i5));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    Bitmap b() {
        return this.f8611b;
    }

    void c(AttributeSet attributeSet, int i5) {
        a0 a0VarV = a0.v(this.f8610a.getContext(), attributeSet, f8609c, i5, 0);
        Drawable drawableH = a0VarV.h(0);
        if (drawableH != null) {
            this.f8610a.setIndeterminateDrawable(e(drawableH));
        }
        Drawable drawableH2 = a0VarV.h(1);
        if (drawableH2 != null) {
            this.f8610a.setProgressDrawable(d(drawableH2, false));
        }
        a0VarV.x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    Drawable d(Drawable drawable, boolean z5) {
        if (drawable instanceof androidx.core.graphics.drawable.b) {
            androidx.core.graphics.drawable.b bVar = (androidx.core.graphics.drawable.b) drawable;
            Drawable drawableB = bVar.b();
            if (drawableB != null) {
                bVar.a(d(drawableB, z5));
                return drawable;
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i5 = 0; i5 < numberOfLayers; i5++) {
                    int id = layerDrawable.getId(i5);
                    drawableArr[i5] = d(layerDrawable.getDrawable(i5), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i6 = 0; i6 < numberOfLayers; i6++) {
                    layerDrawable2.setId(i6, layerDrawable.getId(i6));
                    a.a(layerDrawable, layerDrawable2, i6);
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f8611b == null) {
                    this.f8611b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(a());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z5 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }
}
