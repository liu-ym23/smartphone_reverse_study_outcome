package w2;

import c7.j;
import d7.e0;
import d7.r;
import d7.t;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import q7.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f10649a;

    /* renamed from: b, reason: collision with root package name */
    public final u2.a f10650b;

    public b(LinkedHashMap linkedHashMap, boolean z4) {
        this.f10649a = linkedHashMap;
        this.f10650b = new u2.a(z4);
    }

    public final Map a() {
        j jVar;
        Set<Map.Entry> setEntrySet = this.f10649a.entrySet();
        int iS = e0.S(t.A0(setEntrySet, 10));
        if (iS < 16) {
            iS = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                k.d(bArrCopyOf, "copyOf(this, size)");
                jVar = new j(key, bArrCopyOf);
            } else {
                jVar = new j(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(jVar.f1973f, jVar.f1974g);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        k.d(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }

    public final void b() {
        if (this.f10650b.f9959a.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void c(d dVar, Object obj) {
        k.e(dVar, "key");
        b();
        LinkedHashMap linkedHashMap = this.f10649a;
        if (obj == null) {
            b();
            linkedHashMap.remove(dVar);
            return;
        }
        if (obj instanceof Set) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(r.q1((Set) obj));
            k.d(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(dVar, setUnmodifiableSet);
        } else {
            if (!(obj instanceof byte[])) {
                linkedHashMap.put(dVar, obj);
                return;
            }
            byte[] bArr = (byte[]) obj;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            k.d(bArrCopyOf, "copyOf(this, size)");
            linkedHashMap.put(dVar, bArrCopyOf);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof w2.b
            r1 = 0
            if (r0 != 0) goto L6
            goto L60
        L6:
            w2.b r6 = (w2.b) r6
            java.util.LinkedHashMap r6 = r6.f10649a
            java.util.LinkedHashMap r5 = r5.f10649a
            r0 = 1
            if (r6 != r5) goto L10
            goto L61
        L10:
            int r2 = r6.size()
            int r3 = r5.size()
            if (r2 == r3) goto L1b
            goto L60
        L1b:
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L22
            goto L61
        L22:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2a:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L61
            java.lang.Object r2 = r6.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r3 = r5.get(r3)
            if (r3 == 0) goto L5d
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L58
            boolean r4 = r3 instanceof byte[]
            if (r4 == 0) goto L5d
            byte[] r2 = (byte[]) r2
            byte[] r3 = (byte[]) r3
            boolean r2 = java.util.Arrays.equals(r2, r3)
            if (r2 == 0) goto L5d
            r2 = r0
            goto L5e
        L58:
            boolean r2 = q7.k.a(r2, r3)
            goto L5e
        L5d:
            r2 = r1
        L5e:
            if (r2 != 0) goto L2a
        L60:
            return r1
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = this.f10649a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return r.U0(this.f10649a.entrySet(), ",\n", "{\n", "\n}", a.f10648g, 24);
    }

    public /* synthetic */ b(boolean z4) {
        this(new LinkedHashMap(), z4);
    }
}
