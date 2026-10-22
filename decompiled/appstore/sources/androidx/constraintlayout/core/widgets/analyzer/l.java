package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f1580g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f1581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f1585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1586f;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f1587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1591e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1592f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1593g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l f1594h;

        public a(l r10, ConstraintWidget r11, LinearSystem r12, int r13) {
            this.f1594h = r10;
            this.f1587a = new WeakReference(r11);
            this.f1588b = r12.y(r11.Q);
            this.f1589c = r12.y(r11.R);
            this.f1590d = r12.y(r11.S);
            this.f1591e = r12.y(r11.T);
            this.f1592f = r12.y(r11.U);
            this.f1593g = r13;
        }
    }

    static {
    }

    public l(int r10) {
        this.f1581a = new ArrayList();
        this.f1583c = false;
        this.f1585e = null;
        this.f1586f = -1;
        int r11 = f1580g;
        f1580g = r11 + 1;
        this.f1582b = r11;
        this.f1584d = r10;
    }

    public boolean a(ConstraintWidget r10) {
        if (this.f1581a.contains(r10) == false) goto L6;
        return false;
    L6:
        this.f1581a.add(r10);
        return true;
    }

    public void b(ArrayList r10) {
        int r11 = this.f1581a.size();
        if (this.f1586f == (-1)) goto L12;
        if (r11 <= 0) goto L12;
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L12;
        l r13 = (l) r10.get(r12);
        if (this.f1586f != r13.f1582b) goto L11;
        g(this.f1584d, r13);
    L11:
        r12 = r12 + 1;
    L12:
        if (r11 != 0) goto L18;
        r10.remove(this);
        return;
    }

    public int c() {
        return this.f1582b;
    }

    public int d() {
        return this.f1584d;
    }

    public final String e() {
        int r10 = this.f1584d;
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
        if (this.f1581a.size() != 0) goto L7;
        return 0;
    L7:
        return j(r10, this.f1581a, r11);
    }

    public void g(int r10, l r11) {
        Iterator r12 = this.f1581a.iterator();
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
        this.f1586f = r11.f1582b;
    }

    public void h(boolean r10) {
        this.f1583c = r10;
    }

    public void i(int r10) {
        this.f1584d = r10;
    }

    public final int j(LinearSystem r10, ArrayList r11, int r12) {
        int r13 = 0;
        ConstraintWidgetContainer r14 = (ConstraintWidgetContainer) ((ConstraintWidget) r11.get(0)).J();
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
        if (r14.f1493h1 <= 0) goto L11;
        androidx.constraintlayout.core.widgets.b.b(r14, r10, r11, 0);
    L11:
        if (r12 == 1) goto L13;
    L28:
        r10.A();     // Catch: Exception -> L17
    L19:
        this.f1585e = new ArrayList();
    L21:
        if (r13 >= r11.size()) goto L23;
        this.f1585e.add(new a(this, (ConstraintWidget) r11.get(r13), r10, r12));
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
        e.printStackTrace();
        goto L19
    L13:
        if (r14.f1494i1 <= 0) goto L28;
        androidx.constraintlayout.core.widgets.b.b(r14, r10, r11, 1);
        goto L28
    }

    public String toString() {
        String r10 = e() + " [" + this.f1582b + "] <";
        Iterator r11 = this.f1581a.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10 = r10 + " " + ((ConstraintWidget) r11.next()).s();
        goto L4
    L7:
        return r10 + " >";
    }
}
