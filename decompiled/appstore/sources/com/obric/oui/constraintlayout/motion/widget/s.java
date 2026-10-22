package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f13931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f13932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet f13933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f13935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f13936f;

    public class a implements SharedValues.SharedValuesListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f13937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f13939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f13940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ s f13941e;

        public a(s r10, r r11, int r12, boolean r13, int r14) {
            this.f13941e = r10;
            this.f13937a = r11;
            this.f13938b = r12;
            this.f13939c = r13;
            this.f13940d = r14;
        }

        @Override // com.obric.oui.constraintlayout.widget.SharedValues.SharedValuesListener
        public void onNewValue(int r10, int r11, int r12) {
            int r13 = this.f13937a.h();
            this.f13937a.n(r11);
            if (this.f13938b != r10) goto L23;
            if (r13 == r11) goto L30;
            int r14 = 0;
            if (this.f13939c == false) goto L16;
            if (this.f13940d != r11) goto L31;
            int r15 = s.a(this.f13941e).getChildCount();
        L10:
            if (r14 >= r15) goto L33;
            View r16 = s.a(this.f13941e).getChildAt(r14);
            if (this.f13937a.l(r16) == false) goto L14;
            int r17 = s.a(this.f13941e).getCurrentState();
            com.obric.oui.constraintlayout.widget.a r18 = s.a(this.f13941e).j0(r17);
            r r19 = this.f13937a;
            s r20 = this.f13941e;
            r19.c(r20, s.a(r20), r17, r18, new View[]{r16});
        L14:
            r14 = r14 + 1;
            goto L10
        L33:
            return;
        L31:
            return;
        L16:
            if (this.f13940d == r11) goto L32;
            int r21 = s.a(this.f13941e).getChildCount();
        L18:
            if (r14 >= r21) goto L34;
            View r22 = s.a(this.f13941e).getChildAt(r14);
            if (this.f13937a.l(r22) == false) goto L22;
            int r23 = s.a(this.f13941e).getCurrentState();
            com.obric.oui.constraintlayout.widget.a r24 = s.a(this.f13941e).j0(r23);
            r r25 = this.f13937a;
            s r26 = this.f13941e;
            r25.c(r26, s.a(r26), r23, r24, new View[]{r22});
        L22:
            r14 = r14 + 1;
            goto L18
        L34:
            return;
        L32:
            return;
        L30:
            return;
        }
    }

    public s(MotionLayout r10) {
        this.f13932b = new ArrayList();
        this.f13934d = "ViewTransitionController";
        this.f13936f = new ArrayList();
        this.f13931a = r10;
    }

    public static /* synthetic */ MotionLayout a(s r10) {
        return r10.f13931a;
    }

    public void b(r r10) {
        this.f13932b.add(r10);
        this.f13933c = null;
        if (r10.j() != 4) goto L6;
        g(r10, true);
        return;
    L6:
        if (r10.j() != 5) goto L10;
        g(r10, false);
        return;
    }

    public void c(r.b r10) {
        if (this.f13935e != null) goto L5;
        this.f13935e = new ArrayList();
    L5:
        this.f13935e.add(r10);
    }

    public void d() {
        ArrayList r10 = this.f13935e;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ((r.b) r11.next()).a();
        goto L7
    L9:
        this.f13935e.removeAll(this.f13936f);
        this.f13936f.clear();
        if (this.f13935e.isEmpty() == false) goto L14;
        this.f13935e = null;
        return;
    }

    public boolean e(int r10, l r11) {
        Iterator r12 = this.f13932b.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        r r13 = (r) r12.next();
        if (r13.e() != r10) goto L4;
        r13.f13897f.a(r11);
        return true;
    L9:
        return false;
    }

    public void f() {
        this.f13931a.invalidate();
    }

    public final void g(r r10, boolean r11) {
        int r12 = r10.i();
        int r13 = r10.g();
        ConstraintLayout.getSharedValues().a(r10.i(), new a(this, r10, r12, r11, r13));
    }

    public void h(r.b r10) {
        this.f13936f.add(r10);
    }

    public void i(int r10, View... r11) {
        ArrayList r12 = new ArrayList();
        Iterator r13 = this.f13932b.iterator();
        r r14 = null;
    L4:
        if (r13.hasNext() == false) goto L17;
        r r15 = (r) r13.next();
        if (r15.e() != r10) goto L4;
        int r16 = r11.length;
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L14;
        View r18 = r11[r17];
        if (r15.d(r18) == false) goto L12;
        r12.add(r18);
    L12:
        r17 = r17 + 1;
        goto L8
    L14:
        if (r12.isEmpty() == true) goto L16;
        j(r15, (View[]) r12.toArray(new View[0]));
        r12.clear();
    L16:
        r14 = r15;
        goto L4
    L17:
        if (r14 != null) goto L28;
        Log.e(this.f13934d, " Could not find ViewTransition");
        return;
    }

    public final void j(r r10, View... r11) {
        int r12 = this.f13931a.getCurrentState();
        if (r10.f13896e != 2) goto L5;
        r10.c(this, this.f13931a, r12, null, r11);
        return;
    L5:
        if (r12 != (-1)) goto L8;
        Log.w(this.f13934d, "No support for ViewTransition within transition yet. Currently: " + this.f13931a.toString());
        return;
    L8:
        com.obric.oui.constraintlayout.widget.a r13 = this.f13931a.j0(r12);
        if (r13 != null) goto L11;
        return;
    L11:
        r10.c(this, this.f13931a, r12, r13, r11);
    }

    public void touchEvent(MotionEvent r15) {
        int r10 = this.f13931a.getCurrentState();
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (this.f13933c != null) goto L16;
        this.f13933c = new HashSet();
        Iterator r11 = this.f13932b.iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        r r12 = (r) r11.next();
        int r13 = this.f13931a.getChildCount();
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L9;
        View r16 = this.f13931a.getChildAt(r14);
        if (r12.l(r16) == false) goto L15;
        r16.getId();
        this.f13933c.add(r16);
    L15:
        r14 = r14 + 1;
    L16:
        float r17 = r15.getX();
        float r18 = r15.getY();
        Rect r19 = new Rect();
        int r110 = r15.getAction();
        ArrayList r20 = this.f13935e;
        if (r20 != null) goto L19;
    L24:
        if (r110 != 0) goto L26;
    L28:
        com.obric.oui.constraintlayout.widget.a r111 = this.f13931a.j0(r10);
        Iterator r112 = this.f13932b.iterator();
    L30:
        if (r112.hasNext() == false) goto L59;
        r r113 = (r) r112.next();
        if (r113.o(r110) == false) goto L30;
        Iterator r114 = this.f13933c.iterator();
    L35:
        if (r114.hasNext() == false) goto L30;
        View r21 = (View) r114.next();
        if (r113.l(r21) == false) goto L35;
        r21.getHitRect(r19);
        if (r19.contains((int) r17, (int) r18) == false) goto L35;
        r113.c(this, this.f13931a, r10, r111, new View[]{r21});
        goto L35
    L59:
        return;
    L26:
        if (r110 == 1) goto L28;
        return;
    L19:
        if (r20.isEmpty() == true) goto L24;
        Iterator r22 = this.f13935e.iterator();
    L22:
        if (r22.hasNext() == false) goto L24;
        ((r.b) r22.next()).d(r110, r17, r18);
        goto L22
    }
}
