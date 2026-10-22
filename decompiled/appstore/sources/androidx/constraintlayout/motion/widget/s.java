package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f2057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f2058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet f2059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f2061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f2062f;

    public class a implements SharedValues.SharedValuesListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f2063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f2065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f2066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ s f2067e;

        public a(s r10, r r11, int r12, boolean r13, int r14) {
            this.f2067e = r10;
            this.f2063a = r11;
            this.f2064b = r12;
            this.f2065c = r13;
            this.f2066d = r14;
        }

        @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
        public void onNewValue(int r10, int r11, int r12) {
            int r13 = this.f2063a.h();
            this.f2063a.n(r11);
            if (this.f2064b != r10) goto L23;
            if (r13 == r11) goto L30;
            int r14 = 0;
            if (this.f2065c == false) goto L16;
            if (this.f2066d != r11) goto L31;
            int r15 = s.a(this.f2067e).getChildCount();
        L10:
            if (r14 >= r15) goto L33;
            View r16 = s.a(this.f2067e).getChildAt(r14);
            if (this.f2063a.l(r16) == false) goto L14;
            int r17 = s.a(this.f2067e).getCurrentState();
            ConstraintSet r18 = s.a(this.f2067e).R(r17);
            r r19 = this.f2063a;
            s r20 = this.f2067e;
            r19.c(r20, s.a(r20), r17, r18, new View[]{r16});
        L14:
            r14 = r14 + 1;
            goto L10
        L33:
            return;
        L31:
            return;
        L16:
            if (this.f2066d == r11) goto L32;
            int r21 = s.a(this.f2067e).getChildCount();
        L18:
            if (r14 >= r21) goto L34;
            View r22 = s.a(this.f2067e).getChildAt(r14);
            if (this.f2063a.l(r22) == false) goto L22;
            int r23 = s.a(this.f2067e).getCurrentState();
            ConstraintSet r24 = s.a(this.f2067e).R(r23);
            r r25 = this.f2063a;
            s r26 = this.f2067e;
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
        this.f2058b = new ArrayList();
        this.f2060d = "ViewTransitionController";
        this.f2062f = new ArrayList();
        this.f2057a = r10;
    }

    public static /* synthetic */ MotionLayout a(s r10) {
        return r10.f2057a;
    }

    public void b(r r10) {
        this.f2058b.add(r10);
        this.f2059c = null;
        if (r10.j() != 4) goto L6;
        g(r10, true);
        return;
    L6:
        if (r10.j() != 5) goto L10;
        g(r10, false);
        return;
    }

    public void c(r.b r10) {
        if (this.f2061e != null) goto L5;
        this.f2061e = new ArrayList();
    L5:
        this.f2061e.add(r10);
    }

    public void d() {
        ArrayList r10 = this.f2061e;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ((r.b) r11.next()).a();
        goto L7
    L9:
        this.f2061e.removeAll(this.f2062f);
        this.f2062f.clear();
        if (this.f2061e.isEmpty() == false) goto L14;
        this.f2061e = null;
        return;
    }

    public boolean e(int r10, l r11) {
        Iterator r12 = this.f2058b.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        r r13 = (r) r12.next();
        if (r13.e() != r10) goto L4;
        r13.f2024f.a(r11);
        return true;
    L9:
        return false;
    }

    public void f() {
        this.f2057a.invalidate();
    }

    public final void g(r r10, boolean r11) {
        int r12 = r10.i();
        int r13 = r10.g();
        ConstraintLayout.getSharedValues().a(r10.i(), new a(this, r10, r12, r11, r13));
    }

    public void h(r.b r10) {
        this.f2062f.add(r10);
    }

    public void touchEvent(MotionEvent r15) {
        int r10 = this.f2057a.getCurrentState();
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (this.f2059c != null) goto L16;
        this.f2059c = new HashSet();
        Iterator r11 = this.f2058b.iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        r r12 = (r) r11.next();
        int r13 = this.f2057a.getChildCount();
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L9;
        View r16 = this.f2057a.getChildAt(r14);
        if (r12.l(r16) == false) goto L15;
        r16.getId();
        this.f2059c.add(r16);
    L15:
        r14 = r14 + 1;
    L16:
        float r17 = r15.getX();
        float r18 = r15.getY();
        Rect r19 = new Rect();
        int r110 = r15.getAction();
        ArrayList r20 = this.f2061e;
        if (r20 != null) goto L19;
    L24:
        if (r110 != 0) goto L26;
    L28:
        ConstraintSet r111 = this.f2057a.R(r10);
        Iterator r112 = this.f2058b.iterator();
    L30:
        if (r112.hasNext() == false) goto L59;
        r r113 = (r) r112.next();
        if (r113.o(r110) == false) goto L30;
        Iterator r114 = this.f2059c.iterator();
    L35:
        if (r114.hasNext() == false) goto L30;
        View r21 = (View) r114.next();
        if (r113.l(r21) == false) goto L35;
        r21.getHitRect(r19);
        if (r19.contains((int) r17, (int) r18) == false) goto L35;
        r113.c(this, this.f2057a, r10, r111, new View[]{r21});
        goto L35
    L59:
        return;
    L26:
        if (r110 == 1) goto L28;
        return;
    L19:
        if (r20.isEmpty() == true) goto L24;
        Iterator r22 = this.f2061e.iterator();
    L22:
        if (r22.hasNext() == false) goto L24;
        ((r.b) r22.next()).d(r110, r17, r18);
        goto L22
    }
}
