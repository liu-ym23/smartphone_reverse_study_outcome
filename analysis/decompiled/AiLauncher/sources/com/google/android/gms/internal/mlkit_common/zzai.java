package com.google.android.gms.internal.mlkit_common;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import y2.C5925f;
import y2.O;

/* loaded from: classes2.dex */
public abstract class zzai implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzaj f19917a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzaj f19918b;

    /* renamed from: c, reason: collision with root package name */
    public transient zzab f19919c;

    public static zzai d(Object obj, Object obj2) {
        O.a("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzaq.i(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    public abstract zzab b();

    @Override // java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final zzab values() {
        zzab zzabVar = this.f19919c;
        if (zzabVar != null) {
            return zzabVar;
        }
        zzab zzabVarB = b();
        this.f19919c = zzabVarB;
        return zzabVarB;
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

    public abstract zzaj e();

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

    public abstract zzaj g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final zzaj entrySet() {
        zzaj zzajVar = this.f19917a;
        if (zzajVar != null) {
            return zzajVar;
        }
        zzaj zzajVarE = e();
        this.f19917a = zzajVarE;
        return zzajVarE;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return C5925f.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzaj zzajVar = this.f19918b;
        if (zzajVar != null) {
            return zzajVar;
        }
        zzaj zzajVarG = g();
        this.f19918b = zzajVarG;
        return zzajVarG;
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
