package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class l0 extends LinkedHashMap {

    /* renamed from: g, reason: collision with root package name */
    public static final l0 f898g;

    /* renamed from: f, reason: collision with root package name */
    public boolean f899f = true;

    static {
        l0 l0Var = new l0();
        f898g = l0Var;
        l0Var.f899f = false;
    }

    public final void a() {
        if (!this.f899f) {
            throw new UnsupportedOperationException();
        }
    }

    public final l0 b() {
        if (isEmpty()) {
            return new l0();
        }
        l0 l0Var = new l0(this);
        l0Var.f899f = true;
        return l0Var;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        a();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.equals(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iHashCode;
        int i2 = 0;
        for (Map.Entry entry : entrySet()) {
            Object key = entry.getKey();
            int iHashCode2 = 1;
            if (key instanceof byte[]) {
                byte[] bArr = (byte[]) key;
                int length = bArr.length;
                Charset charset = y.f968a;
                iHashCode = length;
                for (byte b10 : bArr) {
                    iHashCode = (iHashCode * 31) + b10;
                }
                if (iHashCode == 0) {
                    iHashCode = 1;
                }
            } else {
                iHashCode = key.hashCode();
            }
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr2 = (byte[]) value;
                int length2 = bArr2.length;
                Charset charset2 = y.f968a;
                int i10 = length2;
                for (byte b11 : bArr2) {
                    i10 = (i10 * 31) + b11;
                }
                if (i10 != 0) {
                    iHashCode2 = i10;
                }
            } else {
                iHashCode2 = value.hashCode();
            }
            i2 += iHashCode ^ iHashCode2;
        }
        return i2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        a();
        Charset charset = y.f968a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        a();
        for (Object obj : map.keySet()) {
            Charset charset = y.f968a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        a();
        return super.remove(obj);
    }
}
