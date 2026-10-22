package com.bytedance.android.ec.adapter.impl.converter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a<Source, Target> implements i<Source, Target> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Source, Target> f42769a;

    public abstract Target c(Source r100);

    @Override // com.bytedance.android.ec.adapter.impl.converter.i
    public final void clear() {
        this.f42769a.clear();
    }

    public a() {
        LinkedHashSet<i<?, ?>> r100 = c.f42770a;
        c.f42770a.add(this);
        this.f42769a = new LinkedHashMap();
    }

    public Target a(Source r100) {
        HashMap<Source, Target> r101 = this.f42769a;
        Target r102 = r101.get(r100);
        if (r102 != null) goto L6;
        Target r103 = c(r100);
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }

    public final synchronized Target b(Source r100) {
        monitor-enter(this);
        Target r101 = this.f42769a.get(r100);     // Catch: Throwable -> L9
        if (r101 != null) goto L6;
        r101 = a(r100);     // Catch: Throwable -> L9
    L6:
        this.f42769a.remove(r100);     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    public final Source d(Target r100) {
        HashMap<Source, Target> r101 = this.f42769a;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<Source, Target>> r103 = r101.entrySet().iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L11;
        Map.Entry<Source, Target> r105 = r103.next();
        if (r105.getValue() == r100) goto L9;
        r104 = false;
    L9:
        if (r104 == false) goto L3;
        r102.put(r105.getKey(), r105.getValue());
        goto L3
    L11:
        Set r106 = r102.entrySet();
        if ((!r106.isEmpty()) == false) goto L18;
        Iterator r107 = r106.iterator();
        if (r107.hasNext() == false) goto L18;
        return (Source) ((Map.Entry) r107.next()).getKey();
    L18:
        throw new Exception("not track " + r100);
    }
}
