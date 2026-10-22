package androidx.coordinatorlayout.widget;

import B0.e;
import B0.f;
import androidx.collection.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final e<ArrayList<T>> f12926a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    public final t<T, ArrayList<T>> f12927b = new t<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f12928c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet<T> f12929d = new HashSet<>();

    public void a(T t10, T t11) {
        if (!this.f12927b.containsKey(t10) || !this.f12927b.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f12927b.get(t10);
        if (arrayListF == null) {
            arrayListF = f();
            this.f12927b.put(t10, arrayListF);
        }
        arrayListF.add(t11);
    }

    public void b(T t10) {
        if (this.f12927b.containsKey(t10)) {
            return;
        }
        this.f12927b.put(t10, null);
    }

    public void c() {
        int size = this.f12927b.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListValueAt = this.f12927b.valueAt(i10);
            if (arrayListValueAt != null) {
                l(arrayListValueAt);
            }
        }
        this.f12927b.clear();
    }

    public boolean d(T t10) {
        return this.f12927b.containsKey(t10);
    }

    public final void e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t10)) {
            return;
        }
        if (hashSet.contains(t10)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t10);
        ArrayList<T> arrayList2 = this.f12927b.get(t10);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                e(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(t10);
        arrayList.add(t10);
    }

    public final ArrayList<T> f() {
        ArrayList<T> arrayListAcquire = this.f12926a.acquire();
        return arrayListAcquire == null ? new ArrayList<>() : arrayListAcquire;
    }

    public List<T> g(T t10) {
        ArrayList<T> arrayListH = h(t10);
        if (arrayListH == null) {
            return null;
        }
        return new ArrayList(arrayListH);
    }

    public ArrayList<T> h(T t10) {
        return this.f12927b.get(t10);
    }

    public List<T> i(T t10) {
        int size = this.f12927b.getSize();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListValueAt = this.f12927b.valueAt(i10);
            if (arrayListValueAt != null && arrayListValueAt.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f12927b.keyAt(i10));
            }
        }
        return arrayList;
    }

    public ArrayList<T> j() {
        this.f12928c.clear();
        this.f12929d.clear();
        int size = this.f12927b.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f12927b.keyAt(i10), this.f12928c, this.f12929d);
        }
        return this.f12928c;
    }

    public boolean k(T t10) {
        int size = this.f12927b.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListValueAt = this.f12927b.valueAt(i10);
            if (arrayListValueAt != null && arrayListValueAt.contains(t10)) {
                return true;
            }
        }
        return false;
    }

    public final void l(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f12926a.release(arrayList);
    }
}
