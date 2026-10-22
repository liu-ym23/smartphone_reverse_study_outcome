package com.bytedance.android.ec.hybrid.list.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f47071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Object> f47072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<m> f47073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Object> f47074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECHybridListItemVO f47075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f47076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f47077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f47078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f47079i;

    public final c a() {
        c r100 = new c();
        r100.f47071a = this.f47071a;
        LinkedHashMap r101 = new LinkedHashMap();
        Map<String, Object> r102 = this.f47072b;
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, Object> r104 = r103.next();
        r101.put(r104.getKey(), r104.getValue());
    L8:
        Unit r105 = Unit.INSTANCE;
        r100.f47072b = r101;
        ArrayList r106 = new ArrayList();
        List<m> r107 = this.f47073c;
        if (r107 == null) goto L14;
        Iterator<T> r108 = r107.iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        r106.add(((m) r108.next()).a());
    L14:
        Unit r109 = Unit.INSTANCE;
        r100.f47073c = r106;
        LinkedHashMap r110 = new LinkedHashMap();
        Map<String, Object> r111 = this.f47074d;
        if (r111 == null) goto L20;
        Iterator<Map.Entry<String, Object>> r112 = r111.entrySet().iterator();
    L18:
        if (r112.hasNext() == false) goto L20;
        Map.Entry<String, Object> r113 = r112.next();
        r110.put(r113.getKey(), r113.getValue());
    L20:
        Unit r114 = Unit.INSTANCE;
        r100.f47074d = r110;
        r100.f47076f = this.f47076f;
        r100.f47077g = this.f47077g;
        r100.f47078h = this.f47078h;
        return r100;
    }

    public final Map<String, Object> b() {
        Map<String, Object> r100 = this.f47072b;
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);
    L6:
        if (r102 == null) goto L34;
        if ((r102 instanceof String) == false) goto L11;
        r101 = r102;
    L11:
        String r103 = (String) r101;
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L34;
        if (this.f47079i == false) goto L23;
        this.f47079i = false;
        ECHybridListItemVO r105 = this.f47075e;
        if (r105 == null) goto L32;
        String r106 = r105.b();
        if (r106 == null) goto L32;
        Map<String, Object> r107 = this.f47072b;
        if (r107 == null) goto L32;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r106);
    L32:
        return this.f47072b;
    L23:
        return this.f47072b;
    L14:
        if (r103.length() == 0) goto L17;
        r104 = false;
    L34:
        return this.f47072b;
    L5:
        r102 = null;
        goto L6
    }

    public c() {
        this.f47079i = true;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
