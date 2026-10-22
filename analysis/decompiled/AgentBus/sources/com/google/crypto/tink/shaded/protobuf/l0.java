package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class l0 extends LinkedHashMap {

    /* renamed from: g, reason: collision with root package name */
    public static final l0 f2240g;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2241f = true;

    static {
        l0 l0Var = new l0();
        f2240g = l0Var;
        l0Var.f2241f = false;
    }

    public static int a(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof x) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        Charset charset = z.f2296a;
        int i2 = length;
        for (byte b10 : bArr) {
            i2 = (i2 * 31) + b10;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final void b() {
        if (!this.f2241f) {
            throw new UnsupportedOperationException();
        }
    }

    public final l0 c() {
        if (isEmpty()) {
            return new l0();
        }
        l0 l0Var = new l0(this);
        l0Var.f2241f = true;
        return l0Var;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.l0.equals(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iA = 0;
        for (Map.Entry entry : entrySet()) {
            iA += a(entry.getValue()) ^ a(entry.getKey());
        }
        return iA;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        Charset charset = z.f2296a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        b();
        for (Object obj : map.keySet()) {
            Charset charset = z.f2296a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        return super.remove(obj);
    }
}
