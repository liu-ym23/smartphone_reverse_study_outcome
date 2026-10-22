package com.google.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public final class w3 implements Map.Entry, Comparable {

    /* renamed from: f, reason: collision with root package name */
    public final Comparable f2622f;

    /* renamed from: g, reason: collision with root package name */
    public Object f2623g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v3 f2624h;

    public w3(v3 v3Var, Comparable comparable, Object obj) {
        this.f2624h = v3Var;
        this.f2622f = comparable;
        this.f2623g = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2622f.compareTo(((w3) obj).f2622f);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f2622f;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f2623g;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f2622f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f2623g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f2622f;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f2623g;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f2624h.b();
        Object obj2 = this.f2623g;
        this.f2623g = obj;
        return obj2;
    }

    public final String toString() {
        return this.f2622f + "=" + this.f2623g;
    }
}
