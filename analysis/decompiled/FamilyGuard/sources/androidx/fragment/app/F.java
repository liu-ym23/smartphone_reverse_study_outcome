package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class F {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<ComponentCallbacksC0511f> f10419a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, E> f10420b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, D> f10421c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private A f10422d;

    F() {
    }

    void A(A a6) {
        this.f10422d = a6;
    }

    D B(String str, D d6) {
        return d6 != null ? this.f10421c.put(str, d6) : this.f10421c.remove(str);
    }

    void a(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (this.f10419a.contains(componentCallbacksC0511f)) {
            throw new IllegalStateException("Fragment already added: " + componentCallbacksC0511f);
        }
        synchronized (this.f10419a) {
            this.f10419a.add(componentCallbacksC0511f);
        }
        componentCallbacksC0511f.f10643l = true;
    }

    void b() {
        this.f10420b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f10420b.get(str) != null;
    }

    void d(int i5) {
        for (E e6 : this.f10420b.values()) {
            if (e6 != null) {
                e6.t(i5);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f10420b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (E e6 : this.f10420b.values()) {
                printWriter.print(str);
                if (e6 != null) {
                    ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
                    printWriter.println(componentCallbacksC0511fK);
                    componentCallbacksC0511fK.m(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f10419a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i5 = 0; i5 < size; i5++) {
                ComponentCallbacksC0511f componentCallbacksC0511f = this.f10419a.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0511f.toString());
            }
        }
    }

    ComponentCallbacksC0511f f(String str) {
        E e6 = this.f10420b.get(str);
        if (e6 != null) {
            return e6.k();
        }
        return null;
    }

    ComponentCallbacksC0511f g(int i5) {
        for (int size = this.f10419a.size() - 1; size >= 0; size--) {
            ComponentCallbacksC0511f componentCallbacksC0511f = this.f10419a.get(size);
            if (componentCallbacksC0511f != null && componentCallbacksC0511f.f10655x == i5) {
                return componentCallbacksC0511f;
            }
        }
        for (E e6 : this.f10420b.values()) {
            if (e6 != null) {
                ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
                if (componentCallbacksC0511fK.f10655x == i5) {
                    return componentCallbacksC0511fK;
                }
            }
        }
        return null;
    }

    ComponentCallbacksC0511f h(String str) {
        if (str != null) {
            for (int size = this.f10419a.size() - 1; size >= 0; size--) {
                ComponentCallbacksC0511f componentCallbacksC0511f = this.f10419a.get(size);
                if (componentCallbacksC0511f != null && str.equals(componentCallbacksC0511f.f10657z)) {
                    return componentCallbacksC0511f;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (E e6 : this.f10420b.values()) {
            if (e6 != null) {
                ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
                if (str.equals(componentCallbacksC0511fK.f10657z)) {
                    return componentCallbacksC0511fK;
                }
            }
        }
        return null;
    }

    ComponentCallbacksC0511f i(String str) {
        ComponentCallbacksC0511f componentCallbacksC0511fO;
        for (E e6 : this.f10420b.values()) {
            if (e6 != null && (componentCallbacksC0511fO = e6.k().o(str)) != null) {
                return componentCallbacksC0511fO;
            }
        }
        return null;
    }

    int j(ComponentCallbacksC0511f componentCallbacksC0511f) {
        View view;
        View view2;
        ViewGroup viewGroup = componentCallbacksC0511f.f10612H;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f10419a.indexOf(componentCallbacksC0511f);
        for (int i5 = iIndexOf - 1; i5 >= 0; i5--) {
            ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10419a.get(i5);
            if (componentCallbacksC0511f2.f10612H == viewGroup && (view2 = componentCallbacksC0511f2.f10613I) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f10419a.size()) {
                return -1;
            }
            ComponentCallbacksC0511f componentCallbacksC0511f3 = this.f10419a.get(iIndexOf);
            if (componentCallbacksC0511f3.f10612H == viewGroup && (view = componentCallbacksC0511f3.f10613I) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List<E> k() {
        ArrayList arrayList = new ArrayList();
        for (E e6 : this.f10420b.values()) {
            if (e6 != null) {
                arrayList.add(e6);
            }
        }
        return arrayList;
    }

    List<ComponentCallbacksC0511f> l() {
        ArrayList arrayList = new ArrayList();
        for (E e6 : this.f10420b.values()) {
            if (e6 != null) {
                arrayList.add(e6.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    ArrayList<D> m() {
        return new ArrayList<>(this.f10421c.values());
    }

    E n(String str) {
        return this.f10420b.get(str);
    }

    List<ComponentCallbacksC0511f> o() {
        ArrayList arrayList;
        if (this.f10419a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f10419a) {
            arrayList = new ArrayList(this.f10419a);
        }
        return arrayList;
    }

    A p() {
        return this.f10422d;
    }

    D q(String str) {
        return this.f10421c.get(str);
    }

    void r(E e6) {
        ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
        if (c(componentCallbacksC0511fK.f10637f)) {
            return;
        }
        this.f10420b.put(componentCallbacksC0511fK.f10637f, e6);
        if (componentCallbacksC0511fK.f10608D) {
            if (componentCallbacksC0511fK.f10607C) {
                this.f10422d.K(componentCallbacksC0511fK);
            } else {
                this.f10422d.U(componentCallbacksC0511fK);
            }
            componentCallbacksC0511fK.f10608D = false;
        }
        if (x.F0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + componentCallbacksC0511fK);
        }
    }

    void s(E e6) {
        ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
        if (componentCallbacksC0511fK.f10607C) {
            this.f10422d.U(componentCallbacksC0511fK);
        }
        if (this.f10420b.put(componentCallbacksC0511fK.f10637f, null) != null && x.F0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + componentCallbacksC0511fK);
        }
    }

    void t() {
        ArrayList<ComponentCallbacksC0511f> arrayList = this.f10419a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            ComponentCallbacksC0511f componentCallbacksC0511f = arrayList.get(i5);
            i5++;
            E e6 = this.f10420b.get(componentCallbacksC0511f.f10637f);
            if (e6 != null) {
                e6.m();
            }
        }
        for (E e7 : this.f10420b.values()) {
            if (e7 != null) {
                e7.m();
                ComponentCallbacksC0511f componentCallbacksC0511fK = e7.k();
                if (componentCallbacksC0511fK.f10644m && !componentCallbacksC0511fK.i0()) {
                    if (componentCallbacksC0511fK.f10645n && !this.f10421c.containsKey(componentCallbacksC0511fK.f10637f)) {
                        e7.r();
                    }
                    s(e7);
                }
            }
        }
    }

    void u(ComponentCallbacksC0511f componentCallbacksC0511f) {
        synchronized (this.f10419a) {
            this.f10419a.remove(componentCallbacksC0511f);
        }
        componentCallbacksC0511f.f10643l = false;
    }

    void v() {
        this.f10420b.clear();
    }

    void w(List<String> list) {
        this.f10419a.clear();
        if (list != null) {
            for (String str : list) {
                ComponentCallbacksC0511f componentCallbacksC0511fF = f(str);
                if (componentCallbacksC0511fF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (x.F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + componentCallbacksC0511fF);
                }
                a(componentCallbacksC0511fF);
            }
        }
    }

    void x(ArrayList<D> arrayList) {
        this.f10421c.clear();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            D d6 = arrayList.get(i5);
            i5++;
            D d7 = d6;
            this.f10421c.put(d7.f10399b, d7);
        }
    }

    ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f10420b.size());
        for (E e6 : this.f10420b.values()) {
            if (e6 != null) {
                ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
                e6.r();
                arrayList.add(componentCallbacksC0511fK.f10637f);
                if (x.F0(2)) {
                    Log.v("FragmentManager", "Saved state of " + componentCallbacksC0511fK + ": " + componentCallbacksC0511fK.f10630b);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> z() {
        synchronized (this.f10419a) {
            try {
                if (this.f10419a.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.f10419a.size());
                ArrayList<ComponentCallbacksC0511f> arrayList2 = this.f10419a;
                int size = arrayList2.size();
                int i5 = 0;
                while (i5 < size) {
                    ComponentCallbacksC0511f componentCallbacksC0511f = arrayList2.get(i5);
                    i5++;
                    ComponentCallbacksC0511f componentCallbacksC0511f2 = componentCallbacksC0511f;
                    arrayList.add(componentCallbacksC0511f2.f10637f);
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + componentCallbacksC0511f2.f10637f + "): " + componentCallbacksC0511f2);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
