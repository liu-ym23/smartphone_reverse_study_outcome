package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2815a = null;
    private static final Property<Drawable, PointF> i = null;
    private static final Property<a, PointF> j = null;
    private static final Property<a, PointF> k = null;
    private static final Property<View, PointF> l = null;
    private static final Property<View, PointF> m = null;
    private static final Property<View, PointF> n = null;
    private static RectEvaluator r;
    private int[] o;
    private boolean p;
    private boolean q;

    /* JADX INFO: compiled from: ChangeBounds.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f2823e;
        private int f;
        private int g;

        a(View r1) {
            this.f2823e = r1;
        }

        void a(PointF r2) {
            this.f2819a = Math.round(r2.x);
            this.f2820b = Math.round(r2.y);
            int r3 = this.f + 1;
            this.f = r3;
            if (r3 != this.g) goto L6;
            a();
            return;
        }

        void b(PointF r2) {
            this.f2821c = Math.round(r2.x);
            this.f2822d = Math.round(r2.y);
            int r3 = this.g + 1;
            this.g = r3;
            if (this.f != r3) goto L6;
            a();
            return;
        }

        private void a() {
            af.a(this.f2823e, this.f2819a, this.f2820b, this.f2821c, this.f2822d);
            this.f = 0;
            this.g = 0;
        }
    }

    static {
        f2815a = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
        final Class<PointF> r1 = PointF.class;
        final String r2 = "boundsOrigin";
        i = new ChangeBounds$1(r1, r2);
        final Class<PointF> r3 = PointF.class;
        final String r4 = "topLeft";
        j = new ChangeBounds$2(r3, r4);
        final Class<PointF> r5 = PointF.class;
        final String r6 = "bottomRight";
        k = new ChangeBounds$3(r5, r6);
        final Class<PointF> r7 = PointF.class;
        l = new ChangeBounds$4(r7, r6);
        final Class<PointF> r8 = PointF.class;
        m = new ChangeBounds$5(r8, r4);
        final Class<PointF> r9 = PointF.class;
        final String r10 = "position";
        n = new ChangeBounds$6(r9, r10);
        r = new RectEvaluator();
    }

    public e() {
        this.o = new int[2];
        this.p = false;
        this.q = false;
    }

    @Override // androidx.transition.s
    public String[] a() {
        return f2815a;
    }

    private void d(w r8) {
        View r0 = r8.f2870b;
        if (ViewCompat.F(r0) == false) goto L5;
    L8:
        r8.f2869a.put("android:changeBounds:bounds", new Rect(r0.getLeft(), r0.getTop(), r0.getRight(), r0.getBottom()));
        r8.f2869a.put("android:changeBounds:parent", r8.f2870b.getParent());
        if (this.q == false) goto L12;
        r8.f2870b.getLocationInWindow(this.o);
        r8.f2869a.put("android:changeBounds:windowX", Integer.valueOf(this.o[0]));
        r8.f2869a.put("android:changeBounds:windowY", Integer.valueOf(this.o[1]));
    L12:
        if (this.p == false) goto L16;
        r8.f2869a.put("android:changeBounds:clip", ViewCompat.H(r0));
        return;
    L16:
        return;
    L5:
        if (r0.getWidth() != 0) goto L8;
        if (r0.getHeight() != 0) goto L8;
    }

    @Override // androidx.transition.s
    public void a(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public void b(w r1) {
        d(r1);
    }

    private boolean a(View r3, View r4) {
        if (this.q == false) goto L11;
        w r2 = c(r3, true);
        if (r2 != null) goto L10;
        if (r3 != r4) goto L12;
        return true;
    L12:
        return false;
    L10:
        if (r4 != r2.f2870b) goto L12;
        return true;
    L11:
        return true;
    }

    @Override // androidx.transition.s
    public Animator a(final ViewGroup r19, w r20, w r21) {
        if (r20 == null) goto L79;
        if (r21 == null) goto L83;
        Map<String, Object> r3 = r20.f2869a;
        Map<String, Object> r4 = r21.f2869a;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3.get("android:changeBounds:parent"), ViewGroup.class, "com.obric.aiagent.plugin");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4.get("android:changeBounds:parent"), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L77;
        if (r6 == null) goto L82;
        final View r10 = r21.f2870b;
        if (a(r5, r6) == false) goto L69;
        Rect r7 = (Rect) ZeusTransformUtils.preCheckCast(r20.f2869a.get("android:changeBounds:bounds"), Rect.class, "com.obric.aiagent.plugin");
        Rect r8 = (Rect) ZeusTransformUtils.preCheckCast(r21.f2869a.get("android:changeBounds:bounds"), Rect.class, "com.obric.aiagent.plugin");
        int r9 = r7.left;
        final int r11 = r8.left;
        int r12 = r7.top;
        final int r13 = r8.top;
        int r14 = r7.right;
        final int r15 = r8.right;
        int r16 = r7.bottom;
        final int r17 = r8.bottom;
        int r2 = r14 - r9;
        int r18 = r16 - r12;
        int r22 = r15 - r11;
        int r110 = r17 - r13;
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(r20.f2869a.get("android:changeBounds:clip"), Rect.class, "com.obric.aiagent.plugin");
        final Rect r23 = (Rect) ZeusTransformUtils.preCheckCast(r21.f2869a.get("android:changeBounds:clip"), Rect.class, "com.obric.aiagent.plugin");
        if (r2 == 0) goto L15;
        if (r18 == 0) goto L15;
    L17:
        if (r9 != r11) goto L21;
        if (r12 != r13) goto L21;
        int r1 = 0;
    L22:
        int r24 = r16;
        if (r14 != r15) goto L25;
        if (r24 != r17) goto L25;
    L27:
        if (r0 != null) goto L29;
    L30:
        if (r0 != null) goto L33;
        if (r23 == null) goto L33;
    L32:
        r1 = r1 + 1;
    L33:
        if (r1 > 0) goto L35;
        return null;
    L35:
        if (this.p == true) goto L48;
        af.a(r10, r9, r12, r14, r24);
        if (r1 != 2) goto L42;
        if (r2 != r22) goto L41;
        if (r18 != r110) goto L41;
        Animator r25 = n.a(r10, n, i().a(r9, r12, r11, r13));
    L47:
        final View r26 = r10;
    L66:
        if (ZeusTransformUtils.instanceOf(r26.getParent(), ViewGroup.class) == false) goto L68;
        final ViewGroup r27 = (ViewGroup) ZeusTransformUtils.preCheckCast(r26.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        ab.a(r27, true);
        a(new AnonymousClass1(this, r27));
    L68:
        return r25;
    L41:
        final a r28 = new a(r10);
        ObjectAnimator r29 = n.a(r28, j, i().a(r9, r12, r11, r13));
        ObjectAnimator r30 = n.a(r28, k, i().a(r14, r24, r15, r17));
        AnimatorSet r31 = new AnimatorSet();
        r31.playTogether(new Animator[]{r29, r30});
        r31.addListener(new ChangeBounds$7(this, r28));
        r26 = r10;
        r25 = r31;
        goto L66
    L42:
        if (r9 != r11) goto L46;
        if (r12 != r13) goto L46;
        r25 = n.a(r10, l, i().a(r14, r24, r15, r17));
    L46:
        r25 = n.a(r10, m, i().a(r9, r12, r11, r13));
        goto L47
    L48:
        r26 = r10;
        af.a(r26, r9, r12, Math.max(r2, r22) + r9, Math.max(r18, r110) + r12);
        if (r9 != r11) goto L53;
        if (r12 != r13) goto L53;
        ObjectAnimator r32 = null;
    L54:
        if (r0 != null) goto L56;
        int r33 = 0;
        Rect r34 = new Rect(0, 0, r2, r18);
    L57:
        if (r23 != null) goto L59;
        Rect r35 = new Rect(r33, r33, r22, r110);
    L61:
        if (r34.equals(r35) == true) goto L63;
        ViewCompat.a(r26, r34);
        RectEvaluator r36 = r;
        Object[] r37 = new Object[2];
        r37[r33] = r34;
        r37[1] = r35;
        ObjectAnimator r111 = ObjectAnimator.ofObject(r26, "clipBounds", r36, r37);
        r111.addListener(new ChangeBounds$8(this, r26, r23, r11, r13, r15, r17));
        ObjectAnimator r38 = r111;
    L64:
        r25 = TransitionUtils.a(r32, r38);
        goto L66
    L63:
        r38 = null;
        goto L64
    L59:
        r35 = r23;
        goto L61
    L56:
        r33 = 0;
        r34 = r0;
    L53:
        r32 = n.a(r26, n, i().a(r9, r12, r11, r13));
        goto L54
    L29:
        if (r0.equals(r23) == false) goto L32;
    L25:
        r1 = r1 + 1;
    L21:
        r1 = 1;
    L15:
        if (r22 == 0) goto L26;
        if (r110 != 0) goto L17;
    L26:
        r24 = r16;
        r1 = 0;
        goto L27
    L69:
        int r39 = ((Integer) ZeusTransformUtils.preCheckCast(r20.f2869a.get("android:changeBounds:windowX"), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r40 = ((Integer) ZeusTransformUtils.preCheckCast(r20.f2869a.get("android:changeBounds:windowY"), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r41 = ((Integer) ZeusTransformUtils.preCheckCast(r21.f2869a.get("android:changeBounds:windowX"), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r42 = ((Integer) ZeusTransformUtils.preCheckCast(r21.f2869a.get("android:changeBounds:windowY"), Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (r39 != r41) goto L75;
        if (r40 != r42) goto L75;
        return null;
    L75:
        r19.getLocationInWindow(this.o);
        Bitmap r43 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        r10.draw(new Canvas(r43));
        final BitmapDrawable r44 = new BitmapDrawable(r43);
        final float r45 = af.c(r10);
        af.a(r10, 0.0f);
        af.a(r19).a(r44);
        o r46 = i();
        int[] r47 = this.o;
        ObjectAnimator r48 = ObjectAnimator.ofPropertyValuesHolder(r44, new PropertyValuesHolder[]{q.a(i, r46.a(r39 - r47[0], r40 - r47[1], r41 - r47[0], r42 - r47[1]))});
        r48.addListener(new ChangeBounds$10(this, r19, r44, r10, r45));
        return r48;
    L82:
        return null;
    L77:
        return null;
    L83:
        return null;
    L79:
        return null;
    }
}
