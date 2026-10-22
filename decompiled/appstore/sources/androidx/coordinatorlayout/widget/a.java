package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pools$Pool f2426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleArrayMap f2427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f2429d;

    public a() {
        this.f2426a = new d(10);
        this.f2427b = new SimpleArrayMap();
        this.f2428c = new ArrayList();
        this.f2429d = new HashSet();
    }

    public void a(Object r10, Object r11) {
        if (this.f2427b.containsKey(r10) == false) goto L12;
        if (this.f2427b.containsKey(r11) == false) goto L12;
        ArrayList r12 = (ArrayList) this.f2427b.get(r10);
        if (r12 != null) goto L9;
        r12 = f();
        this.f2427b.put(r10, r12);
    L9:
        r12.add(r11);
        return;
    L12:
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void b(Object r10) {
        if (this.f2427b.containsKey(r10) == true) goto L6;
        this.f2427b.put(r10, null);
        return;
    }

    public void c() {
        int r10 = this.f2427b.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        ArrayList r12 = (ArrayList) this.f2427b.valueAt(r11);
        if (r12 == null) goto L7;
        l(r12);
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.f2427b.clear();
    }

    public boolean d(Object r10) {
        return this.f2427b.containsKey(r10);
    }

    public final void e(Object r10, ArrayList r11, HashSet r12) {
        if (r11.contains(r10) == false) goto L6;
        return;
    L6:
        if (r12.contains(r10) == true) goto L15;
        r12.add(r10);
        ArrayList r13 = (ArrayList) this.f2427b.get(r10);
        if (r13 == null) goto L12;
        int r14 = r13.size();
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L12;
        e(r13.get(r15), r11, r12);
        r15 = r15 + 1;
    L12:
        r12.remove(r10);
        r11.add(r10);
        return;
    L15:
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    public final ArrayList f() {
        ArrayList r10 = (ArrayList) this.f2426a.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new ArrayList();
    }

    public List g(Object r10) {
        ArrayList r11 = h(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r11);
    }

    public ArrayList h(Object r10) {
        return (ArrayList) this.f2427b.get(r10);
    }

    public List i(Object r10) {
        int r11 = this.f2427b.size();
        ArrayList r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L12;
        ArrayList r14 = (ArrayList) this.f2427b.valueAt(r13);
        if (r14 == null) goto L11;
        if (r14.contains(r10) == false) goto L11;
        if (r12 != null) goto L10;
        r12 = new ArrayList();
    L10:
        r12.add(this.f2427b.keyAt(r13));
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return r12;
    }

    public ArrayList j() {
        this.f2428c.clear();
        this.f2429d.clear();
        int r10 = this.f2427b.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        e(this.f2427b.keyAt(r11), this.f2428c, this.f2429d);
        r11 = r11 + 1;
        goto L3
    L6:
        return this.f2428c;
    }

    public boolean k(Object r10) {
        int r11 = this.f2427b.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        ArrayList r13 = (ArrayList) this.f2427b.valueAt(r12);
        if (r13 == null) goto L10;
        if (r13.contains(r10) == false) goto L10;
        return true;
    L10:
        r12 = r12 + 1;
        goto L3
    L11:
        return false;
    }

    public final void l(ArrayList r10) {
        r10.clear();
        this.f2426a.release(r10);
    }
}
