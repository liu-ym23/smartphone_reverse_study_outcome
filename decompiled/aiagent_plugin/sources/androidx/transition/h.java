package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChangeTransform.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends s {
    private static final String[] i = null;
    private static final Property<b, float[]> j = null;
    private static final Property<b, PointF> k = null;
    private static final boolean l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f2827a;
    private boolean m;
    private Matrix n;

    /* JADX INFO: compiled from: ChangeTransform.java */
    private static class a extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f2828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f2829b;

        a(View r3, i r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
            this.f2828a = r3;
            this.f2829b = r5;
        }

        @Override // androidx.transition.t, androidx.transition.s.d
        public void onTransitionEnd(s r4) {
            r4.b(this);
            k.a(this.f2828a);
            this.f2828a.setTag(ZeusTransformUtils.mapRes(R.id.transition_transform, DbHelper.COL_ID, "transition_transform"), null);
            this.f2828a.setTag(ZeusTransformUtils.mapRes(R.id.parent_matrix, DbHelper.COL_ID, "parent_matrix"), null);
        }

        @Override // androidx.transition.t, androidx.transition.s.d
        public void onTransitionPause(s r1) {
            this.f2829b.setVisibility(4);
        }

        @Override // androidx.transition.t, androidx.transition.s.d
        public void onTransitionResume(s r1) {
            this.f2829b.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: ChangeTransform.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Matrix f2830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f2831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f2832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f2833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f2834e;

        b(View r2, float[] r3) {
            this.f2830a = new Matrix();
            this.f2831b = r2;
            float[] r4 = (float[]) ZeusTransformUtils.preCheckCast(r3.clone(), float[].class, "com.obric.aiagent.plugin");
            this.f2832c = r4;
            this.f2833d = r4[2];
            this.f2834e = r4[5];
            b();
        }

        void a(float[] r4) {
            System.arraycopy(r4, 0, this.f2832c, 0, r4.length);
            b();
        }

        void a(PointF r2) {
            this.f2833d = r2.x;
            this.f2834e = r2.y;
            b();
        }

        private void b() {
            float[] r0 = this.f2832c;
            r0[2] = this.f2833d;
            r0[5] = this.f2834e;
            this.f2830a.setValues(r0);
            af.c(this.f2831b, this.f2830a);
        }

        Matrix a() {
            return this.f2830a;
        }
    }

    /* JADX INFO: compiled from: ChangeTransform.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f2835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f2836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f2837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f2838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final float f2839e;
        final float f;
        final float g;
        final float h;

        c(View r2) {
            this.f2835a = r2.getTranslationX();
            this.f2836b = r2.getTranslationY();
            this.f2837c = ViewCompat.r(r2);
            this.f2838d = r2.getScaleX();
            this.f2839e = r2.getScaleY();
            this.f = r2.getRotationX();
            this.g = r2.getRotationY();
            this.h = r2.getRotation();
        }

        public void a(View r10) {
            h.a(r10, this.f2835a, this.f2836b, this.f2837c, this.f2838d, this.f2839e, this.f, this.g, this.h);
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, c.class) == true) goto L5;
            return false;
        L5:
            c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
            if (r5.f2835a == this.f2835a) goto L8;
            return false;
        L8:
            if (r5.f2836b == this.f2836b) goto L10;
            return false;
        L10:
            if (r5.f2837c == this.f2837c) goto L12;
            return false;
        L12:
            if (r5.f2838d == this.f2838d) goto L14;
            return false;
        L14:
            if (r5.f2839e == this.f2839e) goto L16;
            return false;
        L16:
            if (r5.f == this.f) goto L18;
            return false;
        L18:
            if (r5.g == this.g) goto L20;
            return false;
        L20:
            if (r5.h != this.h) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            float r0 = this.f2835a;
            int r3 = 0;
            if (r0 == 0.0f) goto L5;
            int r1 = Float.floatToIntBits(r0);
        L6:
            int r2 = r1 * 31;
            float r4 = this.f2836b;
            if (r4 == 0.0f) goto L9;
            int r5 = Float.floatToIntBits(r4);
        L10:
            int r6 = (r2 + r5) * 31;
            float r7 = this.f2837c;
            if (r7 == 0.0f) goto L13;
            int r8 = Float.floatToIntBits(r7);
        L14:
            int r9 = (r6 + r8) * 31;
            float r10 = this.f2838d;
            if (r10 == 0.0f) goto L17;
            int r11 = Float.floatToIntBits(r10);
        L18:
            int r12 = (r9 + r11) * 31;
            float r13 = this.f2839e;
            if (r13 == 0.0f) goto L21;
            int r14 = Float.floatToIntBits(r13);
        L22:
            int r15 = (r12 + r14) * 31;
            float r16 = this.f;
            if (r16 == 0.0f) goto L25;
            int r17 = Float.floatToIntBits(r16);
        L26:
            int r18 = (r15 + r17) * 31;
            float r19 = this.g;
            if (r19 == 0.0f) goto L29;
            int r20 = Float.floatToIntBits(r19);
        L30:
            int r21 = (r18 + r20) * 31;
            float r22 = this.h;
            if (r22 == 0.0f) goto L34;
            r3 = Float.floatToIntBits(r22);
        L34:
            return r21 + r3;
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r1 = 0;
            goto L6
        }
    }

    static {
        i = new String[]{"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
        final Class<float[]> r1 = float[].class;
        final String r2 = "nonTranslations";
        j = new ChangeTransform$1(r1, r2);
        final Class<PointF> r3 = PointF.class;
        final String r4 = "translations";
        k = new ChangeTransform$2(r3, r4);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r0 = true;
    L6:
        l = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.transition.s
    public String[] a() {
        return i;
    }

    private void d(w r5) {
        View r0 = r5.f2870b;
        if (r0.getVisibility() != 8) goto L5;
        return;
    L5:
        r5.f2869a.put("android:changeTransform:parent", r0.getParent());
        r5.f2869a.put("android:changeTransform:transforms", new c(r0));
        Matrix r1 = r0.getMatrix();
        if (r1 != null) goto L8;
    L11:
        Matrix r2 = null;
    L12:
        r5.f2869a.put("android:changeTransform:matrix", r2);
        if (this.m == false) goto L16;
        Matrix r4 = new Matrix();
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        af.a(r3, r4);
        r4.preTranslate(-r3.getScrollX(), -r3.getScrollY());
        r5.f2869a.put("android:changeTransform:parentMatrix", r4);
        r5.f2869a.put("android:changeTransform:intermediateMatrix", r0.getTag(ZeusTransformUtils.mapRes(R.id.transition_transform, DbHelper.COL_ID, "transition_transform")));
        r5.f2869a.put("android:changeTransform:intermediateParentMatrix", r0.getTag(ZeusTransformUtils.mapRes(R.id.parent_matrix, DbHelper.COL_ID, "parent_matrix")));
        return;
    L16:
        return;
    L8:
        if (r1.isIdentity() == true) goto L11;
        r2 = new Matrix(r1);
        goto L12
    }

    @Override // androidx.transition.s
    public void a(w r3) {
        d(r3);
        if (l == true) goto L6;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r3.f2870b.getParent(), ViewGroup.class, "com.obric.aiagent.plugin")).startViewTransition(r3.f2870b);
        return;
    }

    @Override // androidx.transition.s
    public void b(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public Animator a(ViewGroup r7, w r8, w r9) {
        if (r8 == null) goto L33;
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r8.f2869a.containsKey("android:changeTransform:parent") == true) goto L7;
        return null;
    L7:
        if (r9.f2869a.containsKey("android:changeTransform:parent") == false) goto L37;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8.f2869a.get("android:changeTransform:parent"), ViewGroup.class, "com.obric.aiagent.plugin");
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9.f2869a.get("android:changeTransform:parent"), ViewGroup.class, "com.obric.aiagent.plugin");
        if (this.m == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        Matrix r3 = (Matrix) ZeusTransformUtils.preCheckCast(r8.f2869a.get("android:changeTransform:intermediateMatrix"), Matrix.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L18;
        r8.f2869a.put("android:changeTransform:matrix", r3);
    L18:
        Matrix r4 = (Matrix) ZeusTransformUtils.preCheckCast(r8.f2869a.get("android:changeTransform:intermediateParentMatrix"), Matrix.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L21;
        r8.f2869a.put("android:changeTransform:parentMatrix", r4);
    L21:
        if (r2 == false) goto L23;
        b(r8, r9);
    L23:
        ObjectAnimator r5 = a(r8, r9, r2);
        if (r2 == false) goto L30;
        if (r5 == null) goto L30;
        if (this.f2827a == false) goto L30;
        b(r7, r8, r9);
    L32:
        return r5;
    L30:
        if (l == true) goto L32;
        r0.endViewTransition(r8.f2870b);
        goto L32
    L12:
        if (a(r0, r1) == true) goto L14;
        r2 = true;
        goto L15
    L37:
        return null;
    L33:
        return null;
    }

    private ObjectAnimator a(w r13, w r14, final boolean r15) {
        Matrix r16 = (Matrix) ZeusTransformUtils.preCheckCast(r13.f2869a.get("android:changeTransform:matrix"), Matrix.class, "com.obric.aiagent.plugin");
        Matrix r0 = (Matrix) ZeusTransformUtils.preCheckCast(r14.f2869a.get("android:changeTransform:matrix"), Matrix.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L5;
        r16 = m.f2848a;
    L5:
        if (r0 != null) goto L7;
        r0 = m.f2848a;
    L7:
        final Matrix r6 = r0;
        if (r16.equals(r6) == false) goto L11;
        return null;
    L11:
        final c r8 = (c) ZeusTransformUtils.preCheckCast(r14.f2869a.get("android:changeTransform:transforms"), c.class, "com.obric.aiagent.plugin");
        final View r7 = r14.f2870b;
        a(r7);
        float[] r1 = new float[9];
        r16.getValues(r1);
        float[] r17 = new float[9];
        r6.getValues(r17);
        final b r9 = new b(r7, r1);
        ObjectAnimator r18 = ObjectAnimator.ofPropertyValuesHolder(r9, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(j, new FloatArrayEvaluator(new float[9]), new float[][]{r1, r17}), q.a(k, i().a(r1[2], r1[5], r17[2], r17[5]))});
        AnimatorListenerAdapter r19 = new ChangeTransform$3(this, r15, r6, r7, r8, r9);
        r18.addListener(r19);
        androidx.transition.a.a(r18, r19);
        return r18;
    }

    private boolean a(ViewGroup r4, ViewGroup r5) {
        boolean r1 = true;
        if (b(r4) == true) goto L5;
    L12:
        if (r4 == r5) goto L16;
    L14:
        r1 = false;
    L16:
        return r1;
    L5:
        if (b(r5) == false) goto L12;
        w r3 = c(r4, true);
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r5 != r3.f2870b) goto L14;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.transition.s] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    private void b(ViewGroup r5, w r6, w r7) {
        View r0 = r7.f2870b;
        Matrix r2 = new Matrix((Matrix) ZeusTransformUtils.preCheckCast(r7.f2869a.get("android:changeTransform:parentMatrix"), Matrix.class, "com.obric.aiagent.plugin"));
        af.b(r5, r2);
        i r8 = k.a(r0, r5, r2);
        if (r8 != null) goto L5;
        return;
    L5:
        r8.reserveEndViewTransition((ViewGroup) ZeusTransformUtils.preCheckCast(r6.f2869a.get("android:changeTransform:parent"), ViewGroup.class, "com.obric.aiagent.plugin"), r6.f2870b);
        ?? r4 = this;
    L7:
        if (r4.f2859e == null) goto L9;
        r4 = r4.f2859e;
        goto L7
    L9:
        r4.a(new a(r0, r8));
        if (l == true) goto L12;
        return;
    L12:
        if (r6.f2870b == r7.f2870b) goto L14;
        af.a(r6.f2870b, 0.0f);
    L14:
        af.a(r0, 1.0f);
    }

    private void b(w r7, w r8) {
        Matrix r0 = (Matrix) ZeusTransformUtils.preCheckCast(r8.f2869a.get("android:changeTransform:parentMatrix"), Matrix.class, "com.obric.aiagent.plugin");
        r8.f2870b.setTag(ZeusTransformUtils.mapRes(R.id.parent_matrix, DbHelper.COL_ID, "parent_matrix"), r0);
        Matrix r6 = this.n;
        r6.reset();
        r0.invert(r6);
        Matrix r9 = (Matrix) ZeusTransformUtils.preCheckCast(r7.f2869a.get("android:changeTransform:matrix"), Matrix.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
        r9 = new Matrix();
        r7.f2869a.put("android:changeTransform:matrix", r9);
    L5:
        r9.postConcat((Matrix) ZeusTransformUtils.preCheckCast(r7.f2869a.get("android:changeTransform:parentMatrix"), Matrix.class, "com.obric.aiagent.plugin"));
        r9.postConcat(r6);
    }

    static void a(View r9) {
        a(r9, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void a(View r0, float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8) {
        r0.setTranslationX(r1);
        r0.setTranslationY(r2);
        ViewCompat.b(r0, r3);
        r0.setScaleX(r4);
        r0.setScaleY(r5);
        r0.setRotationX(r6);
        r0.setRotationY(r7);
        r0.setRotation(r8);
    }
}
