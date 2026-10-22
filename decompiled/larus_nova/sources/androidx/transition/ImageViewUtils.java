package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.larus.nova.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class ImageViewUtils {
    private static final String TAG = "ImageViewUtils";
    private static Method sAnimateTransformMethod;
    private static boolean sAnimateTransformMethodFetched;

    /* JADX INFO: renamed from: androidx.transition.ImageViewUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ ImageView val$view;

        public AnonymousClass1(ImageView r100) {
            this.val$view = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            ImageView.ScaleType r101 = (ImageView.ScaleType) this.val$view.getTag(R.id.save_scale_type);
            this.val$view.setScaleType(r101);
            this.val$view.setTag(R.id.save_scale_type, null);
            if (r101 != ImageView.ScaleType.MATRIX) goto L5;
            ImageView r102 = this.val$view;
            r102.setImageMatrix((Matrix) r102.getTag(R.id.save_image_matrix));
            this.val$view.setTag(R.id.save_image_matrix, null);
        L5:
            r100.removeListener(this);
        }
    }

    public static void reserveEndAnimateTransform(ImageView r100, Animator r101) {
    }

    public static void startAnimateTransform(ImageView r100) {
    }

    private static void fetchAnimateTransformMethod() {
        if (sAnimateTransformMethodFetched == false) goto L9;
        return;
    L9:
        Method r100 = ImageView.class.getDeclaredMethod("animateTransform", new Class[]{Matrix.class});     // Catch: NoSuchMethodException -> L8
        sAnimateTransformMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sAnimateTransformMethodFetched = true;
    }

    private ImageViewUtils() {
    }

    public static void animateTransform(ImageView r100, Matrix r101) {
        fetchAnimateTransformMethod();
        Method r102 = sAnimateTransformMethod;
        if (r102 != null) goto L12;
        return;
    L12:
        r102.invoke(r100, new Object[]{r101});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }
}
