package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzfg extends LinkedHashMap {

    /* renamed from: b, reason: collision with root package name */
    public static final zzfg f20161b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f20162a;

    static {
        zzfg zzfgVar = new zzfg();
        f20161b = zzfgVar;
        zzfgVar.f20162a = false;
    }

    private zzfg() {
        this.f20162a = true;
    }

    public static zzfg d() {
        return f20161b;
    }

    public static int n(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof H0) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = N0.f20038a;
        int length = bArr.length;
        int iB = N0.b(length, bArr, 0, length);
        if (iB == 0) {
            return 1;
        }
        return iB;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        q();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public final zzfg g() {
        return isEmpty() ? new zzfg() : new zzfg(this);
    }

    public final void h() {
        this.f20162a = false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iN = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iN += n(entry.getValue()) ^ n(entry.getKey());
        }
        return iN;
    }

    public final void i(zzfg zzfgVar) {
        q();
        if (zzfgVar.isEmpty()) {
            return;
        }
        putAll(zzfgVar);
    }

    public final boolean j() {
        return this.f20162a;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        q();
        Charset charset = N0.f20038a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        q();
        for (Object obj : map.keySet()) {
            Charset charset = N0.f20038a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    public final void q() {
        if (!this.f20162a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        q();
        return super.remove(obj);
    }

    public zzfg(Map map) {
        super(map);
        this.f20162a = true;
    }
}
