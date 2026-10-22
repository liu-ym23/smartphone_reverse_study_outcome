package androidx.coordinatorlayout.widget;

import D.e;
import D.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import q.i;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final e<ArrayList<T>> f9445a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    private final i<T, ArrayList<T>> f9446b = new i<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f9447c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<T> f9448d = new HashSet<>();

    private void e(T t5, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t5)) {
            return;
        }
        if (hashSet.contains(t5)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t5);
        ArrayList<T> arrayList2 = this.f9446b.get(t5);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                e(arrayList2.get(i5), arrayList, hashSet);
            }
        }
        hashSet.remove(t5);
        arrayList.add(t5);
    }

    private ArrayList<T> f() {
        ArrayList<T> arrayListB = this.f9445a.b();
        return arrayListB == null ? new ArrayList<>() : arrayListB;
    }

    private void l(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f9445a.a(arrayList);
    }

    public void a(T t5, T t6) {
        if (!this.f9446b.containsKey(t5) || !this.f9446b.containsKey(t6)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f9446b.get(t5);
        if (arrayListF == null) {
            arrayListF = f();
            this.f9446b.put(t5, arrayListF);
        }
        arrayListF.add(t6);
    }

    public void b(T t5) {
        if (this.f9446b.containsKey(t5)) {
            return;
        }
        this.f9446b.put(t5, null);
    }

    public void c() {
        int size = this.f9446b.size();
        for (int i5 = 0; i5 < size; i5++) {
            ArrayList<T> arrayListJ = this.f9446b.j(i5);
            if (arrayListJ != null) {
                l(arrayListJ);
            }
        }
        this.f9446b.clear();
    }

    public boolean d(T t5) {
        return this.f9446b.containsKey(t5);
    }

    public List<T> g(T t5) {
        ArrayList<T> arrayListH = h(t5);
        if (arrayListH == null) {
            return null;
        }
        return new ArrayList(arrayListH);
    }

    ArrayList<T> h(T t5) {
        return this.f9446b.get(t5);
    }

    public List<T> i(T t5) {
        int size = this.f9446b.size();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < size; i5++) {
            ArrayList<T> arrayListJ = this.f9446b.j(i5);
            if (arrayListJ != null && arrayListJ.contains(t5)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f9446b.f(i5));
            }
        }
        return arrayList;
    }

    public ArrayList<T> j() {
        this.f9447c.clear();
        this.f9448d.clear();
        int size = this.f9446b.size();
        for (int i5 = 0; i5 < size; i5++) {
            e(this.f9446b.f(i5), this.f9447c, this.f9448d);
        }
        return this.f9447c;
    }

    public boolean k(T t5) {
        int size = this.f9446b.size();
        for (int i5 = 0; i5 < size; i5++) {
            ArrayList<T> arrayListJ = this.f9446b.j(i5);
            if (arrayListJ != null && arrayListJ.contains(t5)) {
                return true;
            }
        }
        return false;
    }
}
