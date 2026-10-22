package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b, reason: collision with root package name */
    public static final MapFieldLite f1760b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1761a = true;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        f1760b = mapFieldLite;
        mapFieldLite.f1761a = false;
    }

    private MapFieldLite() {
    }

    public static int b(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof u.a) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        Charset charset = u.f1888a;
        int i10 = length;
        for (byte b10 : bArr) {
            i10 = (i10 * 31) + b10;
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public final void c() {
        if (!this.f1761a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        c();
        super.clear();
    }

    public final MapFieldLite<K, V> e() {
        if (isEmpty()) {
            return new MapFieldLite<>();
        }
        MapFieldLite<K, V> mapFieldLite = new MapFieldLite<>(this);
        mapFieldLite.f1761a = true;
        return mapFieldLite;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5e
            java.util.Map r6 = (java.util.Map) r6
            r0 = 1
            if (r5 != r6) goto Lc
        La:
            r5 = r0
            goto L5b
        Lc:
            int r2 = r5.size()
            int r3 = r6.size()
            if (r2 == r3) goto L18
        L16:
            r5 = r1
            goto L5b
        L18:
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L20:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto La
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r3 = r6.containsKey(r3)
            if (r3 != 0) goto L37
            goto L16
        L37:
            java.lang.Object r3 = r2.getValue()
            java.lang.Object r2 = r2.getKey()
            java.lang.Object r2 = r6.get(r2)
            boolean r4 = r3 instanceof byte[]
            if (r4 == 0) goto L54
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L54
            byte[] r3 = (byte[]) r3
            byte[] r2 = (byte[]) r2
            boolean r2 = java.util.Arrays.equals(r3, r2)
            goto L58
        L54:
            boolean r2 = r3.equals(r2)
        L58:
            if (r2 != 0) goto L20
            goto L16
        L5b:
            if (r5 == 0) goto L5e
            return r0
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MapFieldLite.equals(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iB = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iB += b(entry.getValue()) ^ b(entry.getKey());
        }
        return iB;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k9, V v3) {
        c();
        Charset charset = u.f1888a;
        k9.getClass();
        v3.getClass();
        return (V) super.put(k9, v3);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        c();
        for (K k9 : map.keySet()) {
            Charset charset = u.f1888a;
            k9.getClass();
            map.get(k9).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        c();
        return (V) super.remove(obj);
    }
}
