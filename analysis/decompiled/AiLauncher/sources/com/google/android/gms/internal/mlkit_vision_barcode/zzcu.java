package com.google.android.gms.internal.mlkit_vision_barcode;

import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import z2.C6070N;
import z2.C6245r;

/* loaded from: classes2.dex */
public abstract class zzcu implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzcv f19989a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzcv f19990b;

    /* renamed from: c, reason: collision with root package name */
    public transient zzcn f19991c;

    public static zzcu d(Object obj, Object obj2) {
        C6245r.b("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzdp.i(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    public abstract zzcn b();

    @Override // java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final zzcn values() {
        zzcn zzcnVar = this.f19991c;
        if (zzcnVar != null) {
            return zzcnVar;
        }
        zzcn zzcnVarB = b();
        this.f19991c = zzcnVarB;
        return zzcnVarB;
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

    public abstract zzcv e();

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

    public abstract zzcv g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final zzcv entrySet() {
        zzcv zzcvVar = this.f19989a;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        zzcv zzcvVarE = e();
        this.f19989a = zzcvVarE;
        return zzcvVarE;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return C6070N.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzcv zzcvVar = this.f19990b;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        zzcv zzcvVarG = g();
        this.f19990b = zzcvVarG;
        return zzcvVarG;
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
        C6245r.a(size, ContentDisposition.Parameters.Size);
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
