package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewTransitionController.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<q.a> f921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<q.a> f922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MotionLayout f923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<q> f924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashSet<View> f925e;
    private String f;

    public r(MotionLayout r2) {
        this.f924d = new ArrayList();
        this.f = "ViewTransitionController";
        this.f922b = new ArrayList();
        this.f923c = r2;
    }

    public void a(q r3) {
        this.f924d.add(r3);
        this.f925e = null;
        if (r3.a() != 4) goto L6;
        a(r3, true);
        return;
    L6:
        if (r3.a() != 5) goto L10;
        a(r3, false);
        return;
    }

    private void a(q r8, View... r9) {
        int r4 = this.f923c.getCurrentState();
        if (r8.f912a != 2) goto L5;
        r8.a(this, this.f923c, r4, null, r9);
        return;
    L5:
        if (r4 != (-1)) goto L8;
        a(this.f, "No support for ViewTransition within transition yet. Currently: " + this.f923c.toString());
        return;
    L8:
        androidx.constraintlayout.widget.c r5 = this.f923c.getConstraintSet(r4);
        if (r5 != null) goto L11;
        return;
    L11:
        r8.a(this, this.f923c, r4, r5, r9);
    }

    void a(int r4, boolean r5) {
        Iterator<q> r3 = this.f924d.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        q r0 = (q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin");
        if (r0.d() != r4) goto L4;
        r0.a(r5);
        return;
    }

    boolean a(int r4) {
        Iterator<q> r3 = this.f924d.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        q r0 = (q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin");
        if (r0.d() != r4) goto L4;
        return r0.e();
    L9:
        return false;
    }

    void a(int r10, View... r11) {
        ArrayList r0 = new ArrayList();
        Iterator<q> r1 = this.f924d.iterator();
        q r2 = null;
    L4:
        if (r1.hasNext() == false) goto L17;
        q r3 = (q) ZeusTransformUtils.preCheckCast(r1.next(), q.class, "com.obric.aiagent.plugin");
        if (r3.d() != r10) goto L4;
        int r4 = r11.length;
        int r6 = 0;
    L8:
        if (r6 >= r4) goto L14;
        View r7 = r11[r6];
        if (r3.b(r7) == false) goto L12;
        r0.add(r7);
    L12:
        r6 = r6 + 1;
        goto L8
    L14:
        if (r0.isEmpty() == true) goto L16;
        a(r3, (View[]) ZeusTransformUtils.preCheckCast(r0.toArray(new View[0]), View[].class, "com.obric.aiagent.plugin"));
        r0.clear();
    L16:
        r2 = r3;
        goto L4
    L17:
        if (r2 != null) goto L28;
        b(this.f, " Could not find ViewTransition");
        return;
    }

    void a(MotionEvent r21) {
        int r7 = this.f923c.getCurrentState();
        if (r7 != (-1)) goto L6;
        return;
    L6:
        if (this.f925e != null) goto L16;
        this.f925e = new HashSet();
        Iterator<q> r0 = this.f924d.iterator();
    L9:
        if (r0.hasNext() == false) goto L16;
        q r1 = (q) ZeusTransformUtils.preCheckCast(r0.next(), q.class, "com.obric.aiagent.plugin");
        int r2 = this.f923c.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L9;
        View r4 = this.f923c.getChildAt(r3);
        if (r1.a(r4) == false) goto L15;
        r4.getId();
        this.f925e.add(r4);
    L15:
        r3 = r3 + 1;
    L16:
        float r10 = r21.getX();
        float r11 = r21.getY();
        Rect r12 = new Rect();
        int r13 = r21.getAction();
        ArrayList<q.a> r5 = this.f921a;
        if (r5 == null) goto L25;
        if (r5.isEmpty() == true) goto L25;
        Iterator<q.a> r6 = this.f921a.iterator();
    L22:
        if (r6.hasNext() == false) goto L25;
        ((q.a) ZeusTransformUtils.preCheckCast(r6.next(), q.a.class, "com.obric.aiagent.plugin")).a(r13, r10, r11);
    L25:
        if (r13 == 0) goto L28;
        if (r13 == 1) goto L28;
        return;
    L28:
        androidx.constraintlayout.widget.c r15 = this.f923c.getConstraintSet(r7);
        Iterator<q> r16 = this.f924d.iterator();
    L30:
        if (r16.hasNext() == false) goto L59;
        q r8 = (q) ZeusTransformUtils.preCheckCast(r16.next(), q.class, "com.obric.aiagent.plugin");
        if (r8.a(r13) == false) goto L30;
        Iterator<View> r17 = this.f925e.iterator();
    L35:
        if (r17.hasNext() == false) goto L30;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r17.next(), View.class, "com.obric.aiagent.plugin");
        if (r8.a(r9) == false) goto L35;
        r9.getHitRect(r12);
        if (r12.contains((int) r10, (int) r11) == false) goto L43;
        r8.a(this, this.f923c, r7, r15, new View[]{r9});
    L43:
        r8 = r8;
        goto L35
    }

    void a(q.a r2) {
        if (this.f921a != null) goto L5;
        this.f921a = new ArrayList();
    L5:
        this.f921a.add(r2);
    }

    void b(q.a r1) {
        this.f922b.add(r1);
    }

    void a() {
        ArrayList<q.a> r0 = this.f921a;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<q.a> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((q.a) ZeusTransformUtils.preCheckCast(r1.next(), q.a.class, "com.obric.aiagent.plugin")).a();
        goto L7
    L9:
        this.f921a.removeAll(this.f922b);
        this.f922b.clear();
        if (this.f921a.isEmpty() == false) goto L14;
        this.f921a = null;
        return;
    }

    void b() {
        this.f923c.invalidate();
    }

    boolean a(int r4, m r5) {
        Iterator<q> r3 = this.f924d.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        q r0 = (q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin");
        if (r0.d() != r4) goto L4;
        r0.f913b.a(r5);
        return true;
    L9:
        return false;
    }

    private void a(final q r10, final boolean r11) {
        final int r3 = r10.c();
        final int r5 = r10.b();
        ConstraintLayout.getSharedValues().a(r10.c(), new AnonymousClass1(this, r10, r3, r11, r5));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
