package com.bytedance.android.ec.hybrid.list.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Object> f47139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, Object> f47140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<c> f47141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Object> f47142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<c> f47143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, ? extends Object> f47144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<c> f47145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f47146h;

    public n() {
    }

    public final n a() {
        n r100 = new n();
        HashMap<String, Object> r101 = new HashMap();
        HashMap<String, Object> r102 = this.f47139a;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        Unit r103 = Unit.INSTANCE;
        r100.f47139a = r101;
        HashMap<String, Object> r104 = new HashMap();
        HashMap<String, Object> r105 = this.f47140b;
        if (r105 == null) goto L11;
        Iterator<Map.Entry<String, Object>> r106 = r105.entrySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        Map.Entry<String, Object> r107 = r106.next();
        r104.put(r107.getKey(), r107.getValue());
    L11:
        Unit r108 = Unit.INSTANCE;
        r100.f47140b = r104;
        ArrayList r109 = new ArrayList();
        List<c> r110 = this.f47141c;
        if (r110 == null) goto L17;
        Iterator<T> r111 = r110.iterator();
    L15:
        if (r111.hasNext() == false) goto L17;
        r109.add(((c) r111.next()).a());
    L17:
        Unit r112 = Unit.INSTANCE;
        r100.f47141c = r109;
        HashMap r113 = new HashMap();
        Map<String, ? extends Object> r114 = this.f47142d;
        if (r114 == null) goto L23;
        Iterator<Map.Entry<String, ? extends Object>> r115 = r114.entrySet().iterator();
    L21:
        if (r115.hasNext() == false) goto L23;
        Map.Entry<String, ? extends Object> r116 = r115.next();
        r113.put(r116.getKey(), r116.getValue());
    L23:
        Unit r117 = Unit.INSTANCE;
        r100.f47142d = r113;
        ArrayList r118 = new ArrayList();
        List<c> r119 = this.f47143e;
        if (r119 == null) goto L29;
        Iterator<T> r120 = r119.iterator();
    L27:
        if (r120.hasNext() == false) goto L29;
        r118.add(((c) r120.next()).a());
    L29:
        Unit r121 = Unit.INSTANCE;
        r100.f47143e = r118;
        HashMap r122 = new HashMap();
        Map<String, ? extends Object> r123 = this.f47144f;
        if (r123 == null) goto L35;
        Iterator<Map.Entry<String, ? extends Object>> r124 = r123.entrySet().iterator();
    L33:
        if (r124.hasNext() == false) goto L35;
        Map.Entry<String, ? extends Object> r125 = r124.next();
        r122.put(r125.getKey(), r125.getValue());
    L35:
        Unit r126 = Unit.INSTANCE;
        r100.f47144f = r122;
        ArrayList r127 = new ArrayList();
        List<c> r128 = this.f47145g;
        if (r128 == null) goto L41;
        Iterator<T> r129 = r128.iterator();
    L39:
        if (r129.hasNext() == false) goto L41;
        r127.add(((c) r129.next()).a());
    L41:
        Unit r130 = Unit.INSTANCE;
        r100.f47145g = r127;
        r100.f47146h = this.f47146h;
        return r100;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
