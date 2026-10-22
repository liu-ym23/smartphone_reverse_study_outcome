package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: ChangeImageTransform.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2825a = null;
    private static final TypeEvaluator<Matrix> i = null;
    private static final Property<ImageView, Matrix> j = null;

    /* JADX INFO: renamed from: androidx.transition.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChangeImageTransform.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2826a = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            f2826a = r0;
            r0[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f2826a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        f2825a = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
        i = new ChangeImageTransform$1();
        final Class<Matrix> r1 = Matrix.class;
        final String r2 = "animatedTransform";
        j = new ChangeImageTransform$2(r1, r2);
    }

    private void d(w r6) {
        View r5 = r6.f2870b;
        if (ZeusTransformUtils.instanceOf(r5, ImageView.class) == true) goto L5;
        return;
    L5:
        if (r5.getVisibility() != 0) goto L13;
        ImageView r0 = (ImageView) ZeusTransformUtils.preCheckCast(r5, ImageView.class, "com.obric.aiagent.plugin");
        if (r0.getDrawable() != null) goto L10;
        return;
    L10:
        Map<String, Object> r7 = r6.f2869a;
        r7.put("android:changeImageTransform:bounds", new Rect(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom()));
        r7.put("android:changeImageTransform:matrix", b(r0));
        return;
    }

    @Override // androidx.transition.s
    public void a(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public void b(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public String[] a() {
        return f2825a;
    }

    @Override // androidx.transition.s
    public Animator a(ViewGroup r6, w r7, w r8) {
        if (r7 == null) goto L33;
        if (r8 == null) goto L33;
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(r7.f2869a.get("android:changeImageTransform:bounds"), Rect.class, "com.obric.aiagent.plugin");
        Rect r1 = (Rect) ZeusTransformUtils.preCheckCast(r8.f2869a.get("android:changeImageTransform:bounds"), Rect.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L33;
        if (r1 == null) goto L33;
        Matrix r9 = (Matrix) ZeusTransformUtils.preCheckCast(r7.f2869a.get("android:changeImageTransform:matrix"), Matrix.class, "com.obric.aiagent.plugin");
        Matrix r2 = (Matrix) ZeusTransformUtils.preCheckCast(r8.f2869a.get("android:changeImageTransform:matrix"), Matrix.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L13;
        if (r2 != null) goto L13;
    L16:
        boolean r4 = true;
    L19:
        if (r0.equals(r1) == false) goto L22;
        if (r4 == false) goto L22;
        return null;
    L22:
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r8.f2870b, ImageView.class, "com.obric.aiagent.plugin");
        Drawable r11 = r10.getDrawable();
        int r3 = r11.getIntrinsicWidth();
        int r12 = r11.getIntrinsicHeight();
        if (r3 <= 0) goto L32;
        if (r12 <= 0) goto L32;
        if (r9 != null) goto L28;
        r9 = m.f2848a;
    L28:
        if (r2 != null) goto L30;
        r2 = m.f2848a;
    L30:
        j.set(r10, r9);
        return a(r10, r9, r2);
    L32:
        return a(r10);
    L13:
        if (r9 != null) goto L15;
    L17:
        r4 = false;
        goto L19
    L15:
        if (r9.equals(r2) == false) goto L17;
    L33:
        return null;
    }

    private ObjectAnimator a(ImageView r5) {
        return ObjectAnimator.ofObject(r5, j, i, new Matrix[]{m.f2848a, m.f2848a});
    }

    private ObjectAnimator a(ImageView r4, Matrix r5, Matrix r6) {
        return ObjectAnimator.ofObject(r4, j, new TransitionUtils.MatrixEvaluator(), new Matrix[]{r5, r6});
    }

    private static Matrix b(ImageView r2) {
        Drawable r0 = r2.getDrawable();
        if (r0.getIntrinsicWidth() <= 0) goto L16;
        if (r0.getIntrinsicHeight() <= 0) goto L16;
        int r1 = AnonymousClass1.f2826a[r2.getScaleType().ordinal()];
        if (r1 == 1) goto L14;
        if (r1 != 2) goto L16;
        return d(r2);
    L14:
        return c(r2);
    L16:
        return new Matrix(r2.getImageMatrix());
    }

    private static Matrix c(ImageView r4) {
        Drawable r0 = r4.getDrawable();
        Matrix r1 = new Matrix();
        r1.postScale(r4.getWidth() / r0.getIntrinsicWidth(), r4.getHeight() / r0.getIntrinsicHeight());
        return r1;
    }

    private static Matrix d(ImageView r5) {
        Drawable r0 = r5.getDrawable();
        int r1 = r0.getIntrinsicWidth();
        float r2 = r5.getWidth();
        float r3 = r1;
        int r4 = r0.getIntrinsicHeight();
        float r6 = r5.getHeight();
        float r7 = r4;
        float r8 = Math.max(r2 / r3, r6 / r7);
        int r9 = Math.round((r2 - (r3 * r8)) / 2.0f);
        int r10 = Math.round((r6 - (r7 * r8)) / 2.0f);
        Matrix r11 = new Matrix();
        r11.postScale(r8, r8);
        r11.postTranslate(r9, r10);
        return r11;
    }
}
