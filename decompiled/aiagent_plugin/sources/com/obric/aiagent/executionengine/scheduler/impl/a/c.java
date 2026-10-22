package com.obric.aiagent.executionengine.scheduler.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AtomDag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<T, ArrayList<T>> f18031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.core.util.f.a<ArrayList<T>> f18032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f18033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<T> f18034d;

    public c() {
        this.f18031a = new LinkedHashMap();
        this.f18032b = (androidx.core.util.f.a) ZeusTransformUtils.preCheckCast(new androidx.core.util.f.b(10), androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
        this.f18033c = new ArrayList();
        this.f18034d = new HashSet();
    }

    public final LinkedHashMap<T, ArrayList<T>> a() {
        return this.f18031a;
    }

    public final void a(T r3) {
        if (this.f18031a.containsKey(r3) == true) goto L6;
        ((Map) ZeusTransformUtils.preCheckCast(this.f18031a, Map.class, "com.obric.aiagent.plugin")).put(r3, null);
        return;
    }

    public final void a(T r4, T r5) {
        if (this.f18031a.containsKey(r4) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L15;
        ArrayList<T> r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f18031a.get(r4), ArrayList.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L12;
        r1 = d();
        ((Map) ZeusTransformUtils.preCheckCast(this.f18031a, Map.class, "com.obric.aiagent.plugin")).put(r4, r1);
    L12:
        r1.add(r5);
        return;
    L15:
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge".toString());
    L5:
        if (this.f18031a.containsKey(r5) == false) goto L7;
        r0 = true;
        goto L8
    }

    public final List<T> b(T r2) {
        return (List) ZeusTransformUtils.preCheckCast(this.f18031a.get(r2), List.class, "com.obric.aiagent.plugin");
    }

    public final List<T> c(T r8) {
        Iterator<T> r0 = this.f18031a.keySet().iterator();
        List<T> r1 = null;
    L4:
        if (r0.hasNext() == false) goto L15;
        T r2 = r0.next();
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f18031a.get(r2), ArrayList.class, "com.obric.aiagent.plugin");
        boolean r4 = true;
        if (r3 != null) goto L8;
    L10:
        r4 = false;
    L11:
        if (r4 == false) goto L4;
        if (r1 != null) goto L14;
        r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L14:
        r1.add(r2);
        goto L4
    L8:
        if (r3.contains(r8) != true) goto L10;
    L15:
        return r1;
    }

    public final ArrayList<T> b() {
        this.f18033c.clear();
        this.f18034d.clear();
        Iterator<T> r0 = this.f18031a.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        a(r0.next(), this.f18033c, this.f18034d);
        goto L4
    L7:
        return this.f18033c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(T r5, ArrayList<T> r6, HashSet<T> r7) {
        if (r6.contains(r5) == false) goto L6;
        return;
    L6:
        if (r7.contains(r5) == true) goto L15;
        r7.add(r5);
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f18031a.get(r5), ArrayList.class, "com.obric.aiagent.plugin");
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
        throw new RuntimeException("This graph contains cyclic dependencies; the dfs-ing node (`" + r5 + "`) is in marked set: " + r7);
    }

    private final ArrayList<T> d() {
        ArrayList<T> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f18032b.a(), ArrayList.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public final List<T> c() {
        Iterator<T> r0 = this.f18031a.keySet().iterator();
        ArrayList r1 = null;
    L4:
        if (r0.hasNext() == false) goto L17;
        T r2 = r0.next();
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast((ArrayList) ZeusTransformUtils.preCheckCast(this.f18031a.get(r2), ArrayList.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L4;
        if (r1 != null) goto L15;
        r1 = new ArrayList();
    L15:
        r1.add(r2);
        goto L4
    L8:
        if (r3.isEmpty() == true) goto L11;
        r4 = false;
        goto L12
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }
}
