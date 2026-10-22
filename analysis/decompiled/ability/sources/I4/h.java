package I4;

import D7.N;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import g1.AbstractC1451a;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final j f798a;
    public ViewGroup d;
    public FrameLayout e;
    public ImageView f;
    public Bitmap g;
    public Bitmap h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f799j;
    public boolean l;
    public final PathInterpolator b = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
    public final PathInterpolator c = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);
    public final float k = 1.0f;
    public final A6.l m = new A6.l(this, 7);

    public h(j jVar) {
        this.f798a = jVar;
    }

    public final void a() {
        FrameLayout frameLayout;
        ImageView imageView;
        ViewGroup viewGroup = this.d;
        if (viewGroup == null || (frameLayout = this.e) == null || (imageView = this.f) == null || viewGroup.getWidth() <= 0) {
            return;
        }
        c();
        float fElapsedRealtime = ((SystemClock.elapsedRealtime() - this.f799j) / 1000.0f) * this.k;
        if (fElapsedRealtime < 0.0f) {
            fElapsedRealtime = 0.0f;
        }
        j jVar = this.f798a;
        float fFloatValue = ((Number) jVar.invoke("uEnterDur")).floatValue();
        if (fFloatValue < 0.001f) {
            fFloatValue = 0.001f;
        }
        float fFloatValue2 = ((Number) jVar.invoke("uExitDur")).floatValue();
        if (fFloatValue2 < 0.001f) {
            fFloatValue2 = 0.001f;
        }
        float fFloatValue3 = ((Number) jVar.invoke("uReleaseAt")).floatValue();
        float fFloatValue4 = ((Number) jVar.invoke("uHoldMs")).floatValue();
        if (fFloatValue3 < 0.0f && fFloatValue4 > 0.5f) {
            fFloatValue3 = (fFloatValue4 * 0.001f) + fFloatValue;
        }
        float interpolation = this.b.getInterpolation(AbstractC1451a.t((fFloatValue3 >= 0.0f ? Math.min(fElapsedRealtime, fFloatValue3) : fElapsedRealtime) / fFloatValue, 0.0f, 1.0f));
        boolean z10 = ((Number) jVar.invoke("uSide")).floatValue() < 0.5f;
        float fFloatValue5 = ((Number) jVar.invoke("uEnterX")).floatValue();
        float fFloatValue6 = ((Number) jVar.invoke("uEnterY")).floatValue();
        float fFloatValue7 = ((Number) jVar.invoke("uExitX")).floatValue();
        float fFloatValue8 = ((Number) jVar.invoke("uExitY")).floatValue();
        float fAbs = Math.abs(fFloatValue5);
        if (z10) {
            fAbs = -fAbs;
        }
        float fAbs2 = z10 ? -Math.abs(fFloatValue7) : Math.abs(fFloatValue7);
        float fB = (0.4f * interpolation) + 0.6f;
        float fB2 = B7.a.b(0.0f, fAbs, interpolation, fAbs);
        float fB3 = fFloatValue6 * interpolation;
        if (fFloatValue3 >= 0.0f && fElapsedRealtime > fFloatValue3) {
            float interpolation2 = this.c.getInterpolation(AbstractC1451a.t((fElapsedRealtime - fFloatValue3) / fFloatValue2, 0.0f, 1.0f));
            interpolation *= 1.0f - interpolation2;
            fB = B7.a.b(0.6f, fB, interpolation2, fB);
            fB2 = B7.a.b(fAbs2, fB2, interpolation2, fB2);
            fB3 = B7.a.b(fFloatValue8, fB3, interpolation2, fB3);
            if (interpolation2 >= 1.0f) {
                this.l = false;
                imageView.setAlpha(0.0f);
                return;
            }
        }
        float f = imageView.getResources().getDisplayMetrics().density;
        float fT = AbstractC1451a.t(((Number) jVar.invoke("uCenterY")).floatValue(), 0.05f, 0.95f);
        float fT2 = AbstractC1451a.t(((Number) jVar.invoke("uIntensity")).floatValue(), 0.0f, 3.0f);
        frameLayout.setTranslationX(fB2 * f);
        frameLayout.setTranslationY((fB3 * f) + ((viewGroup.getHeight() * fT) - (frameLayout.getLayoutParams().height / 2.0f)));
        imageView.setTranslationX(0.0f);
        imageView.setScaleX(fB);
        imageView.setScaleY(1.0f);
        imageView.setAlpha(AbstractC1451a.t(interpolation * fT2, 0.0f, 1.0f));
    }

    public final void b(ViewGroup root) {
        Bitmap bitmapDecodeStream;
        kotlin.jvm.internal.k.f(root, "root");
        if (this.d == root) {
            FrameLayout frameLayout = this.e;
            if ((frameLayout != null ? frameLayout.getParent() : null) == root) {
                FrameLayout frameLayout2 = this.e;
                if (frameLayout2 != null) {
                    frameLayout2.bringToFront();
                }
                c();
                return;
            }
        }
        ViewGroup viewGroup = this.d;
        FrameLayout frameLayout3 = this.e;
        if (viewGroup != null && frameLayout3 != null && frameLayout3.getParent() == viewGroup) {
            viewGroup.removeView(frameLayout3);
        }
        this.e = null;
        this.f = null;
        this.d = root;
        Context context = root.getContext();
        Bitmap bitmap = this.g;
        if (bitmap == null || bitmap.isRecycled()) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("motionkit/textures/ai_key_glow.png");
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    N.t(inputStreamOpen, null);
                } finally {
                }
            } catch (Exception e) {
                Log.e("KeyGlow", "load motionkit/textures/ai_key_glow.png failed", e);
                bitmapDecodeStream = null;
            }
            this.g = bitmapDecodeStream;
        }
        View view = root;
        for (int i = 0; (view instanceof ViewGroup) && i < 4; i++) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            Object parent = viewGroup2.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        FrameLayout frameLayout4 = new FrameLayout(context);
        frameLayout4.setClipChildren(false);
        frameLayout4.setClipToPadding(false);
        frameLayout4.setElevation(0.0f);
        frameLayout4.setTranslationZ(64.0f);
        frameLayout4.setOutlineProvider(null);
        frameLayout4.setClickable(false);
        frameLayout4.setFocusable(false);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImportantForAccessibility(2);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setAlpha(0.0f);
        imageView.setScaleX(0.6f);
        imageView.setScaleY(1.0f);
        frameLayout4.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        root.addView(frameLayout4, new FrameLayout.LayoutParams(1, 1, 8388661));
        this.e = frameLayout4;
        this.f = imageView;
        this.h = null;
        this.i = false;
        frameLayout4.bringToFront();
        if (root.getWidth() > 0) {
            c();
        } else {
            root.post(new D6.b(this, 5));
        }
    }

    public final void c() {
        FrameLayout frameLayout;
        ImageView imageView;
        Bitmap bitmap;
        Bitmap bitmapCreateBitmap;
        ViewGroup viewGroup = this.d;
        if (viewGroup == null || (frameLayout = this.e) == null || (imageView = this.f) == null || (bitmap = this.g) == null) {
            return;
        }
        Bitmap bitmap2 = !bitmap.isRecycled() ? bitmap : null;
        if (bitmap2 != null && viewGroup.getWidth() > 0 && viewGroup.getHeight() > 0) {
            j jVar = this.f798a;
            boolean z10 = ((Number) jVar.invoke("uSide")).floatValue() < 0.5f;
            Bitmap bitmap3 = this.h;
            if (bitmap3 == null || this.i != z10) {
                if (bitmap3 != null) {
                    if (bitmap3 == bitmap2 || bitmap3.isRecycled()) {
                        bitmap3 = null;
                    }
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                }
                if (z10) {
                    Matrix matrix = new Matrix();
                    matrix.preScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                    kotlin.jvm.internal.k.e(bitmapCreateBitmap, "createBitmap(...)");
                } else {
                    bitmapCreateBitmap = bitmap2;
                }
                this.h = bitmapCreateBitmap;
                this.i = z10;
                imageView.setImageBitmap(bitmapCreateBitmap);
            }
            int height = (int) (viewGroup.getHeight() * AbstractC1451a.t(((Number) jVar.invoke("uHeight")).floatValue(), 0.15f, 1.2f));
            if (height < 1) {
                height = 1;
            }
            int width = (int) ((bitmap2.getWidth() * height) / bitmap2.getHeight());
            int i = width >= 1 ? width : 1;
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(i, height);
            }
            int i6 = (z10 ? GravityCompat.START : GravityCompat.END) | 48;
            if (layoutParams2.width != i || layoutParams2.height != height || layoutParams2.gravity != i6) {
                layoutParams2.width = i;
                layoutParams2.height = height;
                layoutParams2.gravity = i6;
                frameLayout.setLayoutParams(layoutParams2);
            }
            imageView.setPivotX(z10 ? 0.0f : i);
            imageView.setPivotY(height / 2.0f);
        }
    }

    public final void d() {
        this.l = false;
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.removeCallbacks(this.m);
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setAlpha(0.0f);
        }
    }
}
