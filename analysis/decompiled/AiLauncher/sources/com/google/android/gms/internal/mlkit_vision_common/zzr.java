package com.google.android.gms.internal.mlkit_vision_common;

import A2.C0576b;
import A2.C0629i3;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class zzr implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzs f20174a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzs f20175b;

    /* renamed from: c, reason: collision with root package name */
    public transient zzl f20176c;

    public static zzr d(Object obj, Object obj2) {
        C0629i3.a("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzz.i(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    public abstract zzl b();

    @Override // java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final zzl values() {
        zzl zzlVar = this.f20176c;
        if (zzlVar != null) {
            return zzlVar;
        }
        zzl zzlVarB = b();
        this.f20176c = zzlVarB;
        return zzlVarB;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract zzs e();

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract zzs g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final zzs entrySet() {
        zzs zzsVar = this.f20174a;
        if (zzsVar != null) {
            return zzsVar;
        }
        zzs zzsVarE = e();
        this.f20174a = zzsVarE;
        return zzsVarE;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return C0576b.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzs zzsVar = this.f20175b;
        if (zzsVar != null) {
            return zzsVar;
        }
        zzs zzsVarG = g();
        this.f20175b = zzsVarG;
        return zzsVarG;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
        StringBuilder sb2 = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb2.append('{');
        boolean z10 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z10 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }
}
