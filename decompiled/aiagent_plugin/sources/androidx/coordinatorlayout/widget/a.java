package androidx.coordinatorlayout.widget;

import androidx.b.g;
import androidx.core.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: DirectedAcyclicGraph.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f.a<ArrayList<T>> f1021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<T, ArrayList<T>> f1022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f1023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<T> f1024d;

    public a() {
        this.f1021a = new f.b(10);
        this.f1022b = new g();
        this.f1023c = new ArrayList();
        this.f1024d = new HashSet();
    }

    public void a(T r2) {
        if (this.f1022b.containsKey(r2) == true) goto L6;
        this.f1022b.put(r2, null);
        return;
    }

    public boolean b(T r1) {
        return this.f1022b.containsKey(r1);
    }

    public void a(T r4, T r5) {
        if (this.f1022b.containsKey(r4) == false) goto L12;
        if (this.f1022b.containsKey(r5) == false) goto L12;
        ArrayList<T> r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f1022b.get(r4), ArrayList.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
        r0 = c();
        this.f1022b.put(r4, r0);
    L9:
        r0.add(r5);
        return;
    L12:
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public List c(T r2) {
        return (List) ZeusTransformUtils.preCheckCast(this.f1022b.get(r2), List.class, "com.obric.aiagent.plugin");
    }

    public List<T> d(T r7) {
        int r0 = this.f1022b.size();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f1022b.c(r2), ArrayList.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        if (r3.contains(r7) == false) goto L11;
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        r1.add(this.f1022b.b(r2));
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return r1;
    }

    public boolean e(T r7) {
        int r0 = this.f1022b.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f1022b.c(r2), ArrayList.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L10;
        if (r3.contains(r7) == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    public void a() {
        int r0 = this.f1022b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        ArrayList<T> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f1022b.c(r1), ArrayList.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        a(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.f1022b.clear();
    }

    public ArrayList<T> b() {
        this.f1023c.clear();
        this.f1024d.clear();
        int r0 = this.f1022b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        a(this.f1022b.b(r1), this.f1023c, this.f1024d);
        r1 = r1 + 1;
        goto L3
    L6:
        return this.f1023c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(T r5, ArrayList<T> r6, HashSet<T> r7) {
        if (r6.contains(r5) == false) goto L6;
        return;
    L6:
        if (r7.contains(r5) == true) goto L15;
        r7.add(r5);
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f1022b.get(r5), ArrayList.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L12;
        int r1 = 0;
        int r2 = r0.size();
    L10:
        if (r1 >= r2) goto L12;
        a(r0.get(r1), r6, r7);
        r1 = r1 + 1;
    L12:
        r7.remove(r5);
        r6.add(r5);
        return;
    L15:
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private ArrayList<T> c() {
        ArrayList<T> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f1021a.a(), ArrayList.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    private void a(ArrayList<T> r1) {
        r1.clear();
        this.f1021a.a(r1);
    }
}
