package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f5079a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f5080b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f5081c = false;

    public static class a implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f5082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f5083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f5084c;

        public a() {
            this.f5082a = new float[9];
            this.f5083b = new float[9];
            this.f5084c = new Matrix();
        }

        public Matrix a(float r10, Matrix r11, Matrix r12) {
            r11.getValues(this.f5082a);
            r12.getValues(this.f5083b);
            int r13 = 0;
        L4:
            if (r13 >= 9) goto L6;
            float[] r14 = this.f5083b;
            float r15 = r14[r13];
            float r16 = this.f5082a[r13];
            r14[r13] = r16 + ((r15 - r16) * r10);
            r13 = r13 + 1;
            goto L4
        L6:
            this.f5084c.setValues(this.f5083b);
            return this.f5084c;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Object evaluate(float r10, Object r11, Object r12) {
            return a(r10, (Matrix) r11, (Matrix) r12);
        }
    }

    static {
        f5079a = true;
        f5080b = true;
        f5081c = true;
    }

    public static View a(ViewGroup r10, View r11, View r12) {
        Matrix r13 = new Matrix();
        r13.setTranslate(-r12.getScrollX(), -r12.getScrollY());
        y.j(r11, r13);
        y.k(r10, r13);
        RectF r14 = new RectF(0.0f, 0.0f, r11.getWidth(), r11.getHeight());
        r13.mapRect(r14);
        int r15 = Math.round(r14.left);
        int r16 = Math.round(r14.top);
        int r17 = Math.round(r14.right);
        int r18 = Math.round(r14.bottom);
        ImageView r19 = new ImageView(r11.getContext());
        r19.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap r20 = b(r11, r13, r14, r10);
        if (r20 == null) goto L5;
        r19.setImageBitmap(r20);
    L5:
        r19.measure(View.MeasureSpec.makeMeasureSpec(r17 - r15, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r18 - r16, Ints.MAX_POWER_OF_TWO));
        r19.layout(r15, r16, r17, r18);
        return r19;
    }

    public static Bitmap b(View r10, Matrix r11, RectF r12, ViewGroup r13) {
        if (f5079a == false) goto L8;
        boolean r14 = !r10.isAttachedToWindow();
        if (r13 != null) goto L7;
        boolean r15 = false;
    L9:
        boolean r16 = f5080b;
        Bitmap r17 = null;
        if (r16 == false) goto L15;
        if (r14 == false) goto L15;
        if (r15 == true) goto L14;
        return null;
    L14:
        ViewGroup r18 = (ViewGroup) r10.getParent();
        int r19 = r18.indexOfChild(r10);
        r13.getOverlay().add(r10);
    L16:
        int r20 = Math.round(r12.width());
        int r21 = Math.round(r12.height());
        if (r20 <= 0) goto L23;
        if (r21 <= 0) goto L23;
        float r22 = Math.min(1.0f, 1048576.0f / (r20 * r21));
        int r23 = Math.round(r20 * r22);
        int r24 = Math.round(r21 * r22);
        r11.postTranslate(-r12.left, -r12.top);
        r11.postScale(r22, r22);
        if (f5081c == false) goto L22;
        Picture r110 = new Picture();
        Canvas r25 = r110.beginRecording(r23, r24);
        r25.concat(r11);
        r10.draw(r25);
        r110.endRecording();
        r17 = Bitmap.createBitmap(r110);
        goto L23
    L22:
        r17 = Bitmap.createBitmap(r23, r24, Bitmap.Config.ARGB_8888);
        Canvas r111 = new Canvas(r17);
        r111.concat(r11);
        r10.draw(r111);
    L23:
        if (r16 == false) goto L26;
        if (r14 == false) goto L26;
        r13.getOverlay().remove(r10);
        r18.addView(r10, r19);
    L26:
        return r17;
    L15:
        r19 = 0;
        r18 = null;
        goto L16
    L7:
        r15 = r13.isAttachedToWindow();
        goto L9
    L8:
        r14 = false;
        r15 = false;
        goto L9
    }

    public static Animator c(Animator r10, Animator r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        if (r11 != null) goto L6;
        return r10;
    L6:
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(new Animator[]{r10, r11});
        return r12;
    }
}
