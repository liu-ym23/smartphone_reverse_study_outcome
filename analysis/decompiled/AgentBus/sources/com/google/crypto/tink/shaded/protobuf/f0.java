package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f0 extends h0 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f2205c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(int i2, long j2, Object obj) {
        List list = (List) m1.f2246c.i(j2, obj);
        if (list.isEmpty()) {
            List d0Var = list instanceof e0 ? new d0(i2) : ((list instanceof w0) && (list instanceof y)) ? ((y) list).mutableCopyWithCapacity(i2) : new ArrayList(i2);
            m1.p(j2, obj, d0Var);
            return d0Var;
        }
        if (f2205c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i2);
            arrayList.addAll(list);
            m1.p(j2, obj, arrayList);
            return arrayList;
        }
        if (list instanceof h1) {
            d0 d0Var2 = new d0(list.size() + i2);
            d0Var2.addAll((h1) list);
            m1.p(j2, obj, d0Var2);
            return d0Var2;
        }
        if ((list instanceof w0) && (list instanceof y)) {
            y yVar = (y) list;
            if (!((b) yVar).f2176f) {
                y yVarMutableCopyWithCapacity = yVar.mutableCopyWithCapacity(list.size() + i2);
                m1.p(j2, obj, yVarMutableCopyWithCapacity);
                return yVarMutableCopyWithCapacity;
            }
        }
        return list;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final void a(long j2, Object obj) {
        Object objUnmodifiableList;
        List list = (List) m1.f2246c.i(j2, obj);
        if (list instanceof e0) {
            objUnmodifiableList = ((e0) list).getUnmodifiableView();
        } else {
            if (f2205c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof w0) && (list instanceof y)) {
                b bVar = (b) ((y) list);
                if (bVar.f2176f) {
                    bVar.f2176f = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        m1.p(j2, obj, objUnmodifiableList);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final void b(long j2, Object obj, Object obj2) {
        List list = (List) m1.f2246c.i(j2, obj2);
        List listD = d(list.size(), j2, obj);
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        m1.p(j2, obj, list);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final List c(long j2, Object obj) {
        return d(10, j2, obj);
    }
}
