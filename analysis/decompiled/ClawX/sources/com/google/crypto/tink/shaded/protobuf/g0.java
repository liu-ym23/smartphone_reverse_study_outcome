package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g0 extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f1462c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(int i8, long j4, Object obj) {
        List list = (List) n1.f1499c.i(obj, j4);
        if (list.isEmpty()) {
            List e0Var = list instanceof f0 ? new e0(i8) : ((list instanceof x0) && (list instanceof z)) ? ((z) list).a(i8) : new ArrayList(i8);
            n1.p(j4, obj, e0Var);
            return e0Var;
        }
        if (f1462c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i8);
            arrayList.addAll(list);
            n1.p(j4, obj, arrayList);
            return arrayList;
        }
        if (list instanceof i1) {
            e0 e0Var2 = new e0(list.size() + i8);
            e0Var2.addAll((i1) list);
            n1.p(j4, obj, e0Var2);
            return e0Var2;
        }
        if ((list instanceof x0) && (list instanceof z)) {
            z zVar = (z) list;
            if (!((b) zVar).f1433a) {
                z zVarA = zVar.a(list.size() + i8);
                n1.p(j4, obj, zVarA);
                return zVarA;
            }
        }
        return list;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i0
    public final void a(Object obj, long j4) {
        Object objUnmodifiableList;
        List list = (List) n1.f1499c.i(obj, j4);
        if (list instanceof f0) {
            objUnmodifiableList = ((f0) list).c();
        } else {
            if (f1462c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof x0) && (list instanceof z)) {
                b bVar = (b) ((z) list);
                if (bVar.f1433a) {
                    bVar.f1433a = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        n1.p(j4, obj, objUnmodifiableList);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i0
    public final void b(long j4, Object obj, Object obj2) {
        List list = (List) n1.f1499c.i(obj2, j4);
        List listD = d(list.size(), j4, obj);
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        n1.p(j4, obj, list);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i0
    public final List c(Object obj, long j4) {
        return d(10, j4, obj);
    }
}
