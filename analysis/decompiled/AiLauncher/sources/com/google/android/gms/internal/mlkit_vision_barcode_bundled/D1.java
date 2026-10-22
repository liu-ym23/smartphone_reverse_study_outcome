package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Map;

/* loaded from: classes2.dex */
public final class D1 implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f20013a;

    /* renamed from: b, reason: collision with root package name */
    public Object f20014b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ J1 f20015c;

    public D1(J1 j12, Comparable comparable, Object obj) {
        this.f20015c = j12;
        this.f20013a = comparable;
        this.f20014b = obj;
    }

    public static final boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final Comparable a() {
        return this.f20013a;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f20013a.compareTo(((D1) obj).f20013a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return b(this.f20013a, entry.getKey()) && b(this.f20014b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f20013a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f20014b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f20013a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f20014b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f20015c.r();
        Object obj2 = this.f20014b;
        this.f20014b = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.f20013a) + "=" + String.valueOf(this.f20014b);
    }
}
