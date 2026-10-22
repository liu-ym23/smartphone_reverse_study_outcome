package m0;

import androidx.emoji2.text.m;
import c5.o;
import c5.z;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3889a;

    /* renamed from: b, reason: collision with root package name */
    public final m f3890b;

    public b(LinkedHashMap linkedHashMap, boolean z) {
        this.f3889a = linkedHashMap;
        m mVar = new m();
        mVar.f621a = new AtomicBoolean(z);
        this.f3890b = mVar;
    }

    @Override // m0.e
    public final Map a() {
        b5.g gVar;
        Set<Map.Entry> setEntrySet = this.f3889a.entrySet();
        int iT = z.T(o.n0(setEntrySet, 10));
        if (iT < 16) {
            iT = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iT);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                p.d(bArrCopyOf, "copyOf(this, size)");
                gVar = new b5.g(key, bArrCopyOf);
            } else {
                gVar = new b5.g(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(gVar.f892a, gVar.f893b);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        p.d(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }

    @Override // m0.e
    public final Object b(c key) {
        p.e(key, "key");
        Object obj = this.f3889a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        p.d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final void c() {
        if (((AtomicBoolean) this.f3890b.f621a).get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void d(c key, Object obj) {
        p.e(key, "key");
        e(key, obj);
    }

    public final void e(c key, Object obj) {
        p.e(key, "key");
        c();
        LinkedHashMap linkedHashMap = this.f3889a;
        if (obj == null) {
            c();
            linkedHashMap.remove(key);
            return;
        }
        if (obj instanceof Set) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(c5.m.R0((Set) obj));
            p.d(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(key, setUnmodifiableSet);
        } else {
            if (!(obj instanceof byte[])) {
                linkedHashMap.put(key, obj);
                return;
            }
            byte[] bArr = (byte[]) obj;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            p.d(bArrCopyOf, "copyOf(this, size)");
            linkedHashMap.put(key, bArrCopyOf);
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
            boolean r0 = r6 instanceof m0.b
            r1 = 0
            if (r0 != 0) goto L6
            goto L60
        L6:
            m0.b r6 = (m0.b) r6
            java.util.LinkedHashMap r6 = r6.f3889a
            java.util.LinkedHashMap r5 = r5.f3889a
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
            boolean r2 = kotlin.jvm.internal.p.a(r2, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: m0.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = this.f3889a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return c5.m.A0(this.f3889a.entrySet(), ",\n", "{\n", "\n}", a.f3888b, 24);
    }

    public /* synthetic */ b(boolean z) {
        this(new LinkedHashMap(), z);
    }
}
