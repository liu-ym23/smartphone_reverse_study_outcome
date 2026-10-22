package com.google.protobuf;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class N1 implements Map {

    /* renamed from: a, reason: collision with root package name */
    public final O1 f2860a;
    public final Map b;

    public N1(O1 o12, Map map) {
        this.f2860a = o12;
        this.b = map;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f2860a.L();
        this.b.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.b.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.b.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return new M1(this.f2860a, this.b.entrySet());
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return this.b.equals(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.b.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return new M1(this.f2860a, this.b.keySet());
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f2860a.L();
        Charset charset = AbstractC0989s1.f2940a;
        obj.getClass();
        obj2.getClass();
        return this.b.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f2860a.L();
        for (Object obj : map.keySet()) {
            Charset charset = AbstractC0989s1.f2940a;
            obj.getClass();
            map.get(obj).getClass();
        }
        this.b.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        this.f2860a.L();
        return this.b.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.b.size();
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return new L1(this.f2860a, this.b.values());
    }
}
