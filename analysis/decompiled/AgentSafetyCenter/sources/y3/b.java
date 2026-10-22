package y3;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kb.l;
import kb.m;
import kb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f15883a;

    /* renamed from: b, reason: collision with root package name */
    public final sa.c f15884b;

    public b(LinkedHashMap linkedHashMap, boolean z10) {
        this.f15883a = linkedHashMap;
        sa.c cVar = new sa.c(14, false);
        cVar.f12170f = new AtomicBoolean(z10);
        VarHandle.storeStoreFence();
        this.f15884b = cVar;
    }

    public final Map a() {
        jb.g gVar;
        Set<Map.Entry> setEntrySet = this.f15883a.entrySet();
        int iL = x.L(m.m0(setEntrySet, 10));
        if (iL < 16) {
            iL = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                gVar = new jb.g(entry.getKey(), Arrays.copyOf(bArr, bArr.length));
            } else {
                gVar = new jb.g(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(gVar.f6759c, gVar.f6760f);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public final void b() {
        if (((AtomicBoolean) this.f15884b.f12170f).get()) {
            od.f.e("Do mutate preferences once returned to DataStore.");
        }
    }

    public final Object c(e eVar) {
        eVar.getClass();
        Object obj = this.f15883a.get(eVar);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final void d(e eVar, Object obj) {
        eVar.getClass();
        e(eVar, obj);
    }

    public final void e(e eVar, Object obj) {
        eVar.getClass();
        b();
        LinkedHashMap linkedHashMap = this.f15883a;
        if (obj == null) {
            b();
            linkedHashMap.remove(eVar);
        } else if (obj instanceof Set) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(l.O0((Set) obj));
            setUnmodifiableSet.getClass();
            linkedHashMap.put(eVar, setUnmodifiableSet);
        } else if (!(obj instanceof byte[])) {
            linkedHashMap.put(eVar, obj);
        } else {
            byte[] bArr = (byte[]) obj;
            linkedHashMap.put(eVar, Arrays.copyOf(bArr, bArr.length));
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
            boolean r0 = r6 instanceof y3.b
            r1 = 0
            if (r0 != 0) goto L6
            goto L60
        L6:
            y3.b r6 = (y3.b) r6
            java.util.LinkedHashMap r6 = r6.f15883a
            java.util.LinkedHashMap r5 = r5.f15883a
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
            boolean r2 = yb.k.a(r2, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: y3.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = this.f15883a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return l.B0(this.f15883a.entrySet(), ",\n", "{\n", "\n}", a.f15882c, 24);
    }

    public /* synthetic */ b(boolean z10) {
        this(new LinkedHashMap(), z10);
    }
}
