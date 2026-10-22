package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements ProxyInterface {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap f1825g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f1826h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f1827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f1828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1832f;

    static {
        HashMap r10 = new HashMap();
        f1825g = r10;
        HashMap r11 = new HashMap();
        f1826h = r11;
        r10.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r10.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r10.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r10.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r10.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r10.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r10.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r10.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r10.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r10.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r10.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r10.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r10.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r11.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r11.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r11.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r11.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r11.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r11.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r11.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r11.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r11.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r11.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r11.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r11.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public b(MotionLayout r10) {
        this.f1829c = null;
        this.f1830d = null;
        this.f1831e = -1;
        this.f1832f = -1;
        this.f1827a = r10;
    }

    public static void a(int r10, ConstraintSet r11, View r12, HashMap r13, int r14, int r15) {
        String r16 = (String) f1825g.get(Pair.create(Integer.valueOf(r14), Integer.valueOf(r15)));
        String r17 = (String) r13.get(r16);
        if (r17 == null) goto L11;
        String r18 = (String) f1826h.get(r16);
        if (r18 == null) goto L8;
        int r19 = b(r10, (String) r13.get(r18));
    L7:
        int r20 = r19;
        int r21 = Integer.parseInt(r17);
        r11.u(r12.getId(), r14, r21, r15, r20);
        return;
    L8:
        r19 = 0;
        goto L7
    }

    public static int b(int r10, String r11) {
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r12 = r11.indexOf(100);
        if (r12 != (-1)) goto L9;
        return 0;
    L9:
        return (int) ((Integer.valueOf(r11.substring(0, r12)).intValue() * r10) / 160.0f);
    }

    public static void c(int r10, ConstraintSet r11, View r12, HashMap r13) {
        String r14 = (String) r13.get("layout_editor_absoluteX");
        if (r14 == null) goto L5;
        r11.W(r12.getId(), b(r10, r14));
    L5:
        String r15 = (String) r13.get("layout_editor_absoluteY");
        if (r15 == null) goto L9;
        r11.X(r12.getId(), b(r10, r15));
        return;
    }

    public static void d(ConstraintSet r10, View r11, HashMap r12, int r13) {
        if (r13 != 1) goto L5;
        String r14 = "layout_constraintVertical_bias";
    L6:
        String r15 = (String) r12.get(r14);
        if (r15 == null) goto L13;
        if (r13 != 0) goto L10;
        r10.a0(r11.getId(), Float.parseFloat(r15));
        return;
    L10:
        if (r13 != 1) goto L15;
        r10.d0(r11.getId(), Float.parseFloat(r15));
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r14 = "layout_constraintHorizontal_bias";
        goto L6
    }

    public static void e(int r10, ConstraintSet r11, View r12, HashMap r13, int r14) {
        if (r14 != 1) goto L5;
        String r15 = "layout_height";
    L6:
        String r16 = (String) r13.get(r15);
        if (r16 != null) goto L9;
        return;
    L9:
        if (r16.equalsIgnoreCase("wrap_content") == true) goto L11;
        int r17 = b(r10, r16);
    L12:
        if (r14 != 0) goto L14;
        r11.x(r12.getId(), r17);
        return;
    L14:
        r11.w(r12.getId(), r17);
        return;
    L11:
        r17 = -2;
        goto L12
    L5:
        r15 = "layout_width";
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int r10, String r11, Object r12, float[] r13, int r14, float[] r15, int r16) {
        View r17 = (View) r12;
        if (r10 == 0) goto L11;
        MotionLayout r18 = this.f1827a;
        if (r18.f1726a != null) goto L7;
        return -1;
    L7:
        if (r17 == null) goto L10;
        l r19 = (l) r18.f1746k.get(r17);
        if (r19 == null) goto L10;
    L13:
        if (r10 == 0) goto L26;
        if (r10 != 1) goto L16;
        int r20 = this.f1827a.f1726a.p() / 16;
        r19.d(r15, r20);
        return r20;
    L16:
        if (r10 != 2) goto L18;
        int r21 = this.f1827a.f1726a.p() / 16;
        r19.c(r15, null);
        return r21;
    L18:
        if (r10 == 3) goto L20;
        return -1;
    L20:
        this.f1827a.f1726a.p();
        return r19.i(r11, r15, r16);
    L26:
        return 1;
    L10:
        return -1;
    L11:
        r19 = null;
        goto L13
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object r10, int r11, float r12, float r13) {
        if ((r10 instanceof View) == true) goto L5;
        return 0.0f;
    L5:
        l r14 = (l) this.f1827a.f1746k.get((View) r10);
        if (r14 != null) goto L9;
        return 0.0f;
    L9:
        return r14.s(r11, r12, r13);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object r10, float r11, float r12) {
        View r13 = (View) r10;
        MotionLayout r14 = this.f1827a;
        if (r14.f1726a != null) goto L7;
        return -1;
    L7:
        if (r13 == null) goto L13;
        l r15 = (l) r14.f1746k.get(r13);
        if (r15 != null) goto L11;
        return null;
    L11:
        ViewGroup r16 = (ViewGroup) r13.getParent();
        return r15.t(r16.getWidth(), r16.getHeight(), r11, r12);
    L13:
        return null;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object r10, Object r11, float r12, float r13, String[] r14, float[] r15) {
        if ((r10 instanceof h) == false) goto L7;
        h r16 = (h) r10;
        View r17 = (View) r11;
        ((l) this.f1827a.f1746k.get(r17)).B(r17, r16, r12, r13, r14, r15);
        this.f1827a.c0();
        this.f1827a.f1762s = true;
        return Boolean.TRUE;
    L7:
        return Boolean.FALSE;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.f1827a.getTransitionTimeMs();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int r10, String r11, Object r12, Object r13) {
        View r14 = (View) r12;
        HashMap r15 = (HashMap) r13;
        int r16 = this.f1827a.Y(r11);
        ConstraintSet r17 = this.f1827a.f1726a.l(r16);
        if (r17 != null) goto L5;
        return;
    L5:
        r17.n(r14.getId());
        e(r10, r17, r14, r15, 0);
        e(r10, r17, r14, r15, 1);
        a(r10, r17, r14, r15, 6, 6);
        a(r10, r17, r14, r15, 6, 7);
        a(r10, r17, r14, r15, 7, 7);
        a(r10, r17, r14, r15, 7, 6);
        a(r10, r17, r14, r15, 1, 1);
        a(r10, r17, r14, r15, 1, 2);
        a(r10, r17, r14, r15, 2, 2);
        a(r10, r17, r14, r15, 2, 1);
        a(r10, r17, r14, r15, 3, 3);
        a(r10, r17, r14, r15, 3, 4);
        a(r10, r17, r14, r15, 4, 3);
        a(r10, r17, r14, r15, 4, 4);
        a(r10, r17, r14, r15, 5, 5);
        d(r17, r14, r15, 0);
        d(r17, r14, r15, 1);
        c(r10, r17, r14, r15);
        this.f1827a.q0(r16, r17);
        this.f1827a.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object r10, int r11, String r12, Object r13) {
        o r14 = this.f1827a.f1726a;
        if (r14 == null) goto L6;
        r14.Y((View) r10, r11, r12, r13);
        MotionLayout r15 = this.f1827a;
        r15.f1758q = r11 / 100.0f;
        r15.f1754o = 0.0f;
        r15.c0();
        this.f1827a.M(true);
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object r10, int r11, int r12, float r13, float r14) {
        if ((r10 instanceof View) == true) goto L5;
        return false;
    L5:
        MotionLayout r15 = this.f1827a;
        if (r15.f1726a == null) goto L13;
        l r16 = (l) r15.f1746k.get(r10);
        MotionLayout r17 = this.f1827a;
        int r18 = (int) (r17.f1752n * 100.0f);
        if (r16 == null) goto L13;
        View r19 = (View) r10;
        if (r17.f1726a.J(r19, r18) == false) goto L13;
        float r20 = r16.s(2, r13, r14);
        float r21 = r16.s(5, r13, r14);
        this.f1827a.f1726a.Y(r19, r18, "motion:percentX", Float.valueOf(r20));
        this.f1827a.f1726a.Y(r19, r18, "motion:percentY", Float.valueOf(r21));
        this.f1827a.c0();
        this.f1827a.M(true);
        this.f1827a.invalidate();
        return true;
    L13:
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float r10) {
        MotionLayout r11 = this.f1827a;
        if (r11.f1726a != null) goto L5;
        r11.f1726a = this.f1828b;
    L5:
        r11.setProgress(r10);
        this.f1827a.M(true);
        this.f1827a.requestLayout();
        this.f1827a.invalidate();
    }
}
