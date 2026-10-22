package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f13373g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f13374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f13378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13379f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f13380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f13386g;

        public a(ConstraintWidget r10, LinearSystem r11, int r12) {
            this.f13380a = new WeakReference(r10);
            this.f13381b = r11.y(r10.Q);
            this.f13382c = r11.y(r10.R);
            this.f13383d = r11.y(r10.S);
            this.f13384e = r11.y(r10.T);
            this.f13385f = r11.y(r10.U);
            this.f13386g = r12;
        }
    }

    static {
    }

    public l(int r10) {
        this.f13374a = new ArrayList();
        this.f13376c = false;
        this.f13378e = null;
        this.f13379f = -1;
        int r11 = f13373g;
        f13373g = r11 + 1;
        this.f13375b = r11;
        this.f13377d = r10;
    }

    public boolean a(ConstraintWidget r10) {
        if (this.f13374a.contains(r10) == false) goto L6;
        return false;
    L6:
        this.f13374a.add(r10);
        return true;
    }

    public void b(ArrayList r10) {
        int r11 = this.f13374a.size();
        if (this.f13379f == (-1)) goto L12;
        if (r11 <= 0) goto L12;
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L12;
        l r13 = (l) r10.get(r12);
        if (this.f13379f != r13.f13375b) goto L11;
        g(this.f13377d, r13);
    L11:
        r12 = r12 + 1;
    L12:
        if (r11 != 0) goto L18;
        r10.remove(this);
        return;
    }

    public int c() {
        return this.f13375b;
    }

    public int d() {
        return this.f13377d;
    }

    public final String e() {
        int r10 = this.f13377d;
        if (r10 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r10 != 1) goto L11;
        return "Vertical";
    L11:
        if (r10 != 2) goto L14;
        return "Both";
    L14:
        return "Unknown";
    }

    public int f(LinearSystem r10, int r11) {
        if (this.f13374a.size() != 0) goto L7;
        return 0;
    L7:
        return j(r10, this.f13374a, r11);
    }

    public void g(int r10, l r11) {
        Iterator r12 = this.f13374a.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        ConstraintWidget r13 = (ConstraintWidget) r12.next();
        r11.a(r13);
        if (r10 == 0) goto L7;
        r13.T0 = r11.c();
        goto L4
    L7:
        r13.S0 = r11.c();
        goto L4
    L9:
        this.f13379f = r11.f13375b;
    }

    public void h(boolean r10) {
        this.f13376c = r10;
    }

    public void i(int r10) {
        this.f13377d = r10;
    }

    public final int j(LinearSystem r10, ArrayList r11, int r12) {
        int r13 = 0;
        com.obric.oui.constraintlayout.core.widgets.d r14 = (com.obric.oui.constraintlayout.core.widgets.d) ((ConstraintWidget) r11.get(0)).J();
        r10.E();
        r14.d(r10, false);
        int r15 = 0;
    L4:
        if (r15 >= r11.size()) goto L6;
        ((ConstraintWidget) r11.get(r15)).d(r10, false);
        r15 = r15 + 1;
        goto L4
    L6:
        if (r12 != 0) goto L11;
        if (r14.f13415g1 <= 0) goto L11;
        com.obric.oui.constraintlayout.core.widgets.b.b(r14, r10, r11, 0);
    L11:
        if (r12 == 1) goto L13;
    L28:
        r10.A();     // Catch: Exception -> L17
    L19:
        this.f13378e = new ArrayList();
    L21:
        if (r13 >= r11.size()) goto L23;
        this.f13378e.add(new a((ConstraintWidget) r11.get(r13), r10, r12));
        r13 = r13 + 1;
        goto L21
    L23:
        if (r12 != 0) goto L27;
        int r16 = r10.y(r14.Q);
        int r17 = r10.y(r14.S);
        r10.E();
    L26:
        return r17 - r16;
    L27:
        r16 = r10.y(r14.R);
        r17 = r10.y(r14.T);
        r10.E();
    L17:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        goto L19
    L13:
        if (r14.f13416h1 <= 0) goto L28;
        com.obric.oui.constraintlayout.core.widgets.b.b(r14, r10, r11, 1);
        goto L28
    }

    public String toString() {
        String r10 = e() + " [" + this.f13375b + "] <";
        Iterator r11 = this.f13374a.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10 = r10 + " " + ((ConstraintWidget) r11.next()).s();
        goto L4
    L7:
        return r10 + " >";
    }
}
