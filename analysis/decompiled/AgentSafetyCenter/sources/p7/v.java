package p7;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends m7.n {

    /* renamed from: c, reason: collision with root package name */
    public static final u f9901c;

    /* renamed from: a, reason: collision with root package name */
    public m7.e f9902a;

    /* renamed from: b, reason: collision with root package name */
    public int f9903b;

    static {
        u uVar = new u();
        uVar.f9900c = 1;
        VarHandle.storeStoreFence();
        f9901c = uVar;
    }

    public final Serializable a(u7.a aVar, u7.b bVar) {
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 5) {
            return aVar.W();
        }
        if (iOrdinal == 6) {
            return k0.a.a(this.f9903b, aVar);
        }
        if (iOrdinal == 7) {
            return Boolean.valueOf(aVar.O());
        }
        if (iOrdinal == 8) {
            aVar.U();
            return null;
        }
        g5.f.r(bVar, "Unexpected token: ");
        return null;
    }

    @Override // m7.n
    public final Object read(u7.a aVar) {
        Object arrayList;
        Serializable arrayList2;
        u7.b bVarY = aVar.Y();
        int iOrdinal = bVarY.ordinal();
        if (iOrdinal == 0) {
            aVar.d();
            arrayList = new ArrayList();
        } else if (iOrdinal != 2) {
            arrayList = null;
        } else {
            aVar.e();
            arrayList = new o7.n(true);
        }
        if (arrayList == null) {
            return a(aVar, bVarY);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.H()) {
                String strS = arrayList instanceof Map ? aVar.S() : null;
                u7.b bVarY2 = aVar.Y();
                int iOrdinal2 = bVarY2.ordinal();
                if (iOrdinal2 == 0) {
                    aVar.d();
                    arrayList2 = new ArrayList();
                } else if (iOrdinal2 != 2) {
                    arrayList2 = null;
                } else {
                    aVar.e();
                    arrayList2 = new o7.n(true);
                }
                boolean z10 = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = a(aVar, bVarY2);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strS, arrayList2);
                }
                if (z10) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    aVar.n();
                } else {
                    aVar.o();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        if (obj == null) {
            cVar.C();
            return;
        }
        m7.e eVar = this.f9902a;
        Class<?> cls = obj.getClass();
        eVar.getClass();
        m7.n nVarC = eVar.c(t7.a.get((Class) cls));
        if (!(nVarC instanceof v)) {
            nVarC.write(cVar, obj);
        } else {
            cVar.g();
            cVar.o();
        }
    }
}
