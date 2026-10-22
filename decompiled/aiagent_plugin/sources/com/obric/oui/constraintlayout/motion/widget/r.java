package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewTransitionController.java */
/* JADX INFO: loaded from: classes4.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<q.a> f34905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<q.a> f34906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MotionLayout f34907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<q> f34908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashSet<View> f34909e;
    private String f;

    public r(MotionLayout r2) {
        this.f34908d = new ArrayList();
        this.f = "ViewTransitionController";
        this.f34906b = new ArrayList();
        this.f34907c = r2;
    }

    public void a(q r3) {
        this.f34908d.add(r3);
        this.f34909e = null;
        if (r3.a() != 4) goto L6;
        a(r3, true);
        return;
    L6:
        if (r3.a() != 5) goto L10;
        a(r3, false);
        return;
    }

    private void a(q r8, View... r9) {
        int r4 = this.f34907c.getCurrentState();
        if (r8.f34895a != 2) goto L5;
        r8.a(this, this.f34907c, r4, null, r9);
        return;
    L5:
        if (r4 != (-1)) goto L8;
        a(this.f, "No support for ViewTransition within transition yet. Currently: " + this.f34907c.toString());
        return;
    L8:
        com.obric.oui.constraintlayout.widget.c r5 = this.f34907c.getConstraintSet(r4);
        if (r5 != null) goto L11;
        return;
    L11:
        r8.a(this, this.f34907c, r4, r5, r9);
    }

    void a(int r4, boolean r5) {
        Iterator<q> r3 = this.f34908d.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        q r0 = (q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin");
        if (r0.d() != r4) goto L4;
        r0.a(r5);
        return;
    }

    boolean a(int r4) {
        Iterator<q> r3 = this.f34908d.iterator();
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
        Iterator<q> r1 = this.f34908d.iterator();
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
        int r7 = this.f34907c.getCurrentState();
        if (r7 != (-1)) goto L6;
        return;
    L6:
        if (this.f34909e != null) goto L16;
        this.f34909e = new HashSet();
        Iterator<q> r0 = this.f34908d.iterator();
    L9:
        if (r0.hasNext() == false) goto L16;
        q r1 = (q) ZeusTransformUtils.preCheckCast(r0.next(), q.class, "com.obric.aiagent.plugin");
        int r2 = this.f34907c.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L9;
        View r4 = this.f34907c.getChildAt(r3);
        if (r1.a(r4) == false) goto L15;
        r4.getId();
        this.f34909e.add(r4);
    L15:
        r3 = r3 + 1;
    L16:
        float r10 = r21.getX();
        float r11 = r21.getY();
        Rect r12 = new Rect();
        int r13 = r21.getAction();
        ArrayList<q.a> r5 = this.f34905a;
        if (r5 == null) goto L25;
        if (r5.isEmpty() == true) goto L25;
        Iterator<q.a> r6 = this.f34905a.iterator();
    L22:
        if (r6.hasNext() == false) goto L25;
        ((q.a) ZeusTransformUtils.preCheckCast(r6.next(), q.a.class, "com.obric.aiagent.plugin")).a(r13, r10, r11);
    L25:
        if (r13 == 0) goto L28;
        if (r13 == 1) goto L28;
        return;
    L28:
        com.obric.oui.constraintlayout.widget.c r15 = this.f34907c.getConstraintSet(r7);
        Iterator<q> r16 = this.f34908d.iterator();
    L30:
        if (r16.hasNext() == false) goto L59;
        q r8 = (q) ZeusTransformUtils.preCheckCast(r16.next(), q.class, "com.obric.aiagent.plugin");
        if (r8.a(r13) == false) goto L30;
        Iterator<View> r17 = this.f34909e.iterator();
    L35:
        if (r17.hasNext() == false) goto L30;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r17.next(), View.class, "com.obric.aiagent.plugin");
        if (r8.a(r9) == false) goto L35;
        r9.getHitRect(r12);
        if (r12.contains((int) r10, (int) r11) == false) goto L43;
        r8.a(this, this.f34907c, r7, r15, new View[]{r9});
    L43:
        r8 = r8;
        goto L35
    }

    void a(q.a r2) {
        if (this.f34905a != null) goto L5;
        this.f34905a = new ArrayList();
    L5:
        this.f34905a.add(r2);
    }

    void b(q.a r1) {
        this.f34906b.add(r1);
    }

    void a() {
        ArrayList<q.a> r0 = this.f34905a;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<q.a> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((q.a) ZeusTransformUtils.preCheckCast(r1.next(), q.a.class, "com.obric.aiagent.plugin")).a();
        goto L7
    L9:
        this.f34905a.removeAll(this.f34906b);
        this.f34906b.clear();
        if (this.f34905a.isEmpty() == false) goto L14;
        this.f34905a = null;
        return;
    }

    void b() {
        this.f34907c.invalidate();
    }

    boolean a(int r4, m r5) {
        Iterator<q> r3 = this.f34908d.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        q r0 = (q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin");
        if (r0.d() != r4) goto L4;
        r0.f34896b.a(r5);
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
