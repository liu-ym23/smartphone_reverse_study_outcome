package q0;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l0.AbstractC0822a;

/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    protected List<AbstractC0964k> f19780a = null;

    /* renamed from: b, reason: collision with root package name */
    protected List<AbstractC0956c> f19781b = null;

    /* renamed from: c, reason: collision with root package name */
    protected List<W> f19782c = null;

    /* renamed from: d, reason: collision with root package name */
    protected List<i0> f19783d = null;

    /* renamed from: e, reason: collision with root package name */
    protected List<S> f19784e = null;

    /* renamed from: f, reason: collision with root package name */
    protected List<X> f19785f = null;

    /* renamed from: g, reason: collision with root package name */
    protected List<InterfaceC0949L> f19786g = null;

    /* renamed from: h, reason: collision with root package name */
    protected List<InterfaceC0974v> f19787h = null;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f19788i = true;

    public void d(c0 c0Var) {
        if (c0Var == null) {
            return;
        }
        if (c0Var instanceof X) {
            m().add((X) c0Var);
        }
        if (c0Var instanceof S) {
            k().add((S) c0Var);
        }
        if (c0Var instanceof i0) {
            n().add((i0) c0Var);
        }
        if (c0Var instanceof InterfaceC0974v) {
            i().add((InterfaceC0974v) c0Var);
        }
        if (c0Var instanceof W) {
            l().add((W) c0Var);
        }
        if (c0Var instanceof AbstractC0964k) {
            h().add((AbstractC0964k) c0Var);
        }
        if (c0Var instanceof AbstractC0956c) {
            g().add((AbstractC0956c) c0Var);
        }
        if (c0Var instanceof InterfaceC0949L) {
            j().add((InterfaceC0949L) c0Var);
        }
    }

    public boolean e(C0946I c0946i, Object obj, String str, Object obj2) {
        List<W> list = c0946i.f19782c;
        if (list != null) {
            Iterator<W> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().d(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<W> list2 = this.f19782c;
        if (list2 == null) {
            return true;
        }
        Iterator<W> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().d(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    public boolean f(C0946I c0946i, Object obj, String str) {
        List<X> list = c0946i.f19785f;
        if (list != null) {
            Iterator<X> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().b(c0946i, obj, str)) {
                    return false;
                }
            }
        }
        List<X> list2 = this.f19785f;
        if (list2 == null) {
            return true;
        }
        Iterator<X> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().b(c0946i, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public List<AbstractC0956c> g() {
        if (this.f19781b == null) {
            this.f19781b = new ArrayList();
            this.f19788i = false;
        }
        return this.f19781b;
    }

    public List<AbstractC0964k> h() {
        if (this.f19780a == null) {
            this.f19780a = new ArrayList();
            this.f19788i = false;
        }
        return this.f19780a;
    }

    public List<InterfaceC0974v> i() {
        if (this.f19787h == null) {
            this.f19787h = new ArrayList();
            this.f19788i = false;
        }
        return this.f19787h;
    }

    public List<InterfaceC0949L> j() {
        if (this.f19786g == null) {
            this.f19786g = new ArrayList();
            this.f19788i = false;
        }
        return this.f19786g;
    }

    public List<S> k() {
        if (this.f19784e == null) {
            this.f19784e = new ArrayList();
            this.f19788i = false;
        }
        return this.f19784e;
    }

    public List<W> l() {
        if (this.f19782c == null) {
            this.f19782c = new ArrayList();
            this.f19788i = false;
        }
        return this.f19782c;
    }

    public List<X> m() {
        if (this.f19785f == null) {
            this.f19785f = new ArrayList();
            this.f19788i = false;
        }
        return this.f19785f;
    }

    public List<i0> n() {
        if (this.f19783d == null) {
            this.f19783d = new ArrayList();
            this.f19788i = false;
        }
        return this.f19783d;
    }

    protected String o(C0946I c0946i, Object obj, String str, Object obj2) {
        List<S> list = c0946i.f19784e;
        if (list != null) {
            Iterator<S> it = list.iterator();
            while (it.hasNext()) {
                str = it.next().a(obj, str, obj2);
            }
        }
        List<S> list2 = this.f19784e;
        if (list2 != null) {
            Iterator<S> it2 = list2.iterator();
            while (it2.hasNext()) {
                str = it2.next().a(obj, str, obj2);
            }
        }
        return str;
    }

    protected Object p(C0946I c0946i, C0963j c0963j, Object obj, String str, Object obj2, int i5) {
        boolean z5;
        if (obj2 != null) {
            int i6 = c0946i.f19676k.f19798c;
            f0 f0Var = f0.WriteNonStringValueAsString;
            if ((f0.d(i6, i5, f0Var) || !(c0963j == null || (c0963j.a() & f0Var.f19849a) == 0)) && (((z5 = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String strB = (!z5 || c0963j == null) ? null : c0963j.b();
                obj2 = strB != null ? new DecimalFormat(strB).format(obj2) : obj2.toString();
            } else if (c0963j != null && c0963j.c()) {
                obj2 = AbstractC0822a.q((String) obj2);
            }
        }
        List<i0> list = c0946i.f19783d;
        if (list != null) {
            Iterator<i0> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().a(obj, str, obj2);
            }
        }
        List<i0> list2 = this.f19783d;
        if (list2 != null) {
            Iterator<i0> it2 = list2.iterator();
            while (it2.hasNext()) {
                obj2 = it2.next().a(obj, str, obj2);
            }
        }
        List<InterfaceC0974v> list3 = c0946i.f19787h;
        if (list3 != null) {
            Iterator<InterfaceC0974v> it3 = list3.iterator();
            while (it3.hasNext()) {
                obj2 = it3.next().e(c0963j, obj, str, obj2);
            }
        }
        List<InterfaceC0974v> list4 = this.f19787h;
        if (list4 != null) {
            Iterator<InterfaceC0974v> it4 = list4.iterator();
            while (it4.hasNext()) {
                obj2 = it4.next().e(c0963j, obj, str, obj2);
            }
        }
        return obj2;
    }
}
