package p0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class j {

    /* renamed from: g, reason: collision with root package name */
    public static int f38045g;

    /* renamed from: b, reason: collision with root package name */
    public int f38047b;

    /* renamed from: d, reason: collision with root package name */
    public int f38049d;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f38046a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public boolean f38048c = false;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<a> f38050e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f38051f = -1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ConstraintWidget> f38052a;

        /* renamed from: b, reason: collision with root package name */
        public int f38053b;

        /* renamed from: c, reason: collision with root package name */
        public int f38054c;

        /* renamed from: d, reason: collision with root package name */
        public int f38055d;

        /* renamed from: e, reason: collision with root package name */
        public int f38056e;

        /* renamed from: f, reason: collision with root package name */
        public int f38057f;

        /* renamed from: g, reason: collision with root package name */
        public int f38058g;

        public a(ConstraintWidget constraintWidget, androidx.constraintlayout.core.c cVar, int i10) {
            this.f38052a = new WeakReference<>(constraintWidget);
            this.f38053b = cVar.y(constraintWidget.f11964Q);
            this.f38054c = cVar.y(constraintWidget.f11966R);
            this.f38055d = cVar.y(constraintWidget.f11968S);
            this.f38056e = cVar.y(constraintWidget.f11970T);
            this.f38057f = cVar.y(constraintWidget.f11972U);
            this.f38058g = i10;
        }
    }

    public j(int i10) {
        int i11 = f38045g;
        f38045g = i11 + 1;
        this.f38047b = i11;
        this.f38049d = i10;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f38046a.contains(constraintWidget)) {
            return false;
        }
        this.f38046a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList<j> arrayList) {
        int size = this.f38046a.size();
        if (this.f38051f != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                j jVar = arrayList.get(i10);
                if (this.f38051f == jVar.f38047b) {
                    g(this.f38049d, jVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f38047b;
    }

    public int d() {
        return this.f38049d;
    }

    public final String e() {
        int i10 = this.f38049d;
        return i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown";
    }

    public int f(androidx.constraintlayout.core.c cVar, int i10) {
        if (this.f38046a.size() == 0) {
            return 0;
        }
        return j(cVar, this.f38046a, i10);
    }

    public void g(int i10, j jVar) {
        Iterator<ConstraintWidget> it = this.f38046a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            jVar.a(next);
            if (i10 == 0) {
                next.f11969S0 = jVar.c();
            } else {
                next.f11971T0 = jVar.c();
            }
        }
        this.f38051f = jVar.f38047b;
    }

    public void h(boolean z10) {
        this.f38048c = z10;
    }

    public void i(int i10) {
        this.f38049d = i10;
    }

    public final int j(androidx.constraintlayout.core.c cVar, ArrayList<ConstraintWidget> arrayList, int i10) {
        int iY;
        int iY2;
        androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) arrayList.get(0).M();
        cVar.E();
        dVar.g(cVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).g(cVar, false);
        }
        if (i10 == 0 && dVar.f12096g1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar, cVar, arrayList, 0);
        }
        if (i10 == 1 && dVar.f12097h1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar, cVar, arrayList, 1);
        }
        try {
            cVar.A();
        } catch (Exception e10) {
            System.err.println(e10.toString() + "\n" + Arrays.toString(e10.getStackTrace()).replace("[", "   at ").replace(Const.STR_MART_COMMA, "\n   at").replace("]", ""));
        }
        this.f38050e = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f38050e.add(new a(arrayList.get(i12), cVar, i10));
        }
        if (i10 == 0) {
            iY = cVar.y(dVar.f11964Q);
            iY2 = cVar.y(dVar.f11968S);
            cVar.E();
        } else {
            iY = cVar.y(dVar.f11966R);
            iY2 = cVar.y(dVar.f11970T);
            cVar.E();
        }
        return iY2 - iY;
    }

    public String toString() {
        String str = e() + " [" + this.f38047b + "] <";
        Iterator<ConstraintWidget> it = this.f38046a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().v();
        }
        return str + " >";
    }
}
