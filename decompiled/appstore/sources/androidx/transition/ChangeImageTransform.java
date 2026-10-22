package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeEvaluator f4940b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property f4941c = null;

    public class a implements TypeEvaluator {
        public a() {
        }

        public Matrix a(float r10, Matrix r11, Matrix r12) {
            return null;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Object evaluate(float r10, Object r11, Object r12) {
            return a(r10, (Matrix) r11, (Matrix) r12);
        }
    }

    public class b extends Property {
        public b(Class r10, String r11) {
            super(r10, r11);
        }

        public Matrix a(ImageView r10) {
            return null;
        }

        public void b(ImageView r10, Matrix r11) {
            h.a(r10, r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((ImageView) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((ImageView) r10, (Matrix) r11);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4942a = null;

        static {
            int[] r10 = new int[ImageView.ScaleType.values().length];
            f4942a = r10;
            r10[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f4942a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        f4939a = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
        f4940b = new a();
        f4941c = new b(Matrix.class, "animatedTransform");
    }

    public ChangeImageTransform(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
    }

    private void captureValues(s r10) {
        View r11 = r10.f5086b;
        if ((r11 instanceof ImageView) == true) goto L5;
        return;
    L5:
        if (r11.getVisibility() != 0) goto L13;
        ImageView r12 = (ImageView) r11;
        if (r12.getDrawable() != null) goto L10;
        return;
    L10:
        Map r13 = r10.f5085a;
        r13.put("android:changeImageTransform:bounds", new Rect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom()));
        r13.put("android:changeImageTransform:matrix", t(r12));
        return;
    }

    public static Matrix s(ImageView r10) {
        Drawable r11 = r10.getDrawable();
        int r12 = r11.getIntrinsicWidth();
        float r13 = r10.getWidth();
        float r14 = r12;
        int r15 = r11.getIntrinsicHeight();
        float r16 = r10.getHeight();
        float r17 = r15;
        float r18 = Math.max(r13 / r14, r16 / r17);
        int r19 = Math.round((r13 - (r14 * r18)) / 2.0f);
        int r20 = Math.round((r16 - (r17 * r18)) / 2.0f);
        Matrix r21 = new Matrix();
        r21.postScale(r18, r18);
        r21.postTranslate(r19, r20);
        return r21;
    }

    public static Matrix t(ImageView r10) {
        Drawable r11 = r10.getDrawable();
        if (r11.getIntrinsicWidth() <= 0) goto L17;
        if (r11.getIntrinsicHeight() <= 0) goto L17;
        int r12 = c.f4942a[r10.getScaleType().ordinal()];
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L13;
        return new Matrix(r10.getImageMatrix());
    L13:
        return s(r10);
    L15:
        return w(r10);
    L17:
        return new Matrix(r10.getImageMatrix());
    }

    public static Matrix w(ImageView r10) {
        Drawable r11 = r10.getDrawable();
        Matrix r12 = new Matrix();
        r12.postScale(r10.getWidth() / r11.getIntrinsicWidth(), r10.getHeight() / r11.getIntrinsicHeight());
        return r12;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r10, s r11, s r12) {
        if (r11 == null) goto L33;
        if (r12 == null) goto L33;
        Rect r13 = (Rect) r11.f5085a.get("android:changeImageTransform:bounds");
        Rect r14 = (Rect) r12.f5085a.get("android:changeImageTransform:bounds");
        if (r13 == null) goto L33;
        if (r14 == null) goto L33;
        Matrix r15 = (Matrix) r11.f5085a.get("android:changeImageTransform:matrix");
        Matrix r16 = (Matrix) r12.f5085a.get("android:changeImageTransform:matrix");
        if (r15 != null) goto L13;
        if (r16 != null) goto L13;
    L16:
        boolean r17 = true;
    L19:
        if (r13.equals(r14) == false) goto L22;
        if (r17 == false) goto L22;
        return null;
    L22:
        ImageView r18 = (ImageView) r12.f5086b;
        Drawable r19 = r18.getDrawable();
        int r20 = r19.getIntrinsicWidth();
        int r21 = r19.getIntrinsicHeight();
        if (r20 <= 0) goto L32;
        if (r21 <= 0) goto L32;
        if (r15 != null) goto L28;
        r15 = i.f5068a;
    L28:
        if (r16 != null) goto L30;
        r16 = i.f5068a;
    L30:
        f4941c.set(r18, r15);
        return u(r18, r15, r16);
    L32:
        return v(r18);
    L13:
        if (r15 != null) goto L15;
    L17:
        r17 = false;
        goto L19
    L15:
        if (r15.equals(r16) == false) goto L17;
    L33:
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f4939a;
    }

    public final ObjectAnimator u(ImageView r10, Matrix r11, Matrix r12) {
        return ObjectAnimator.ofObject(r10, f4941c, new r.a(), new Matrix[]{r11, r12});
    }

    public final ObjectAnimator v(ImageView r10) {
        Property r11 = f4941c;
        TypeEvaluator r12 = f4940b;
        Matrix r13 = i.f5068a;
        return ObjectAnimator.ofObject(r10, r11, r12, new Matrix[]{r13, r13});
    }
}
