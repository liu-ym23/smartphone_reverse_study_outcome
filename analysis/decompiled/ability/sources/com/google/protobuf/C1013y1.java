package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.y1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1013y1 extends A1 {
    public static final Class c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(Object obj, long j5, int i) {
        List list = (List) W2.c.k(obj, j5);
        if (list.isEmpty()) {
            List c1005w1 = list instanceof InterfaceC1009x1 ? new C1005w1(i) : ((list instanceof InterfaceC0959k2) && (list instanceof InterfaceC0985r1)) ? ((InterfaceC0985r1) list).mutableCopyWithCapacity(i) : new ArrayList(i);
            W2.p(obj, j5, c1005w1);
            return c1005w1;
        }
        if (c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i);
            arrayList.addAll(list);
            W2.p(obj, j5, arrayList);
            return arrayList;
        }
        if (list instanceof R2) {
            C1005w1 c1005w12 = new C1005w1(list.size() + i);
            c1005w12.addAll((R2) list);
            W2.p(obj, j5, c1005w12);
            return c1005w12;
        }
        if ((list instanceof InterfaceC0959k2) && (list instanceof InterfaceC0985r1)) {
            InterfaceC0985r1 interfaceC0985r1 = (InterfaceC0985r1) list;
            if (!((AbstractC0940g) interfaceC0985r1).f2920a) {
                InterfaceC0985r1 interfaceC0985r1MutableCopyWithCapacity = interfaceC0985r1.mutableCopyWithCapacity(list.size() + i);
                W2.p(obj, j5, interfaceC0985r1MutableCopyWithCapacity);
                return interfaceC0985r1MutableCopyWithCapacity;
            }
        }
        return list;
    }

    @Override // com.google.protobuf.A1
    public final void a(Object obj, long j5) {
        Object objUnmodifiableList;
        List list = (List) W2.c.k(obj, j5);
        if (list instanceof InterfaceC1009x1) {
            objUnmodifiableList = ((InterfaceC1009x1) list).getUnmodifiableView();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC0959k2) && (list instanceof InterfaceC0985r1)) {
                AbstractC0940g abstractC0940g = (AbstractC0940g) ((InterfaceC0985r1) list);
                if (abstractC0940g.f2920a) {
                    abstractC0940g.makeImmutable();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        W2.p(obj, j5, objUnmodifiableList);
    }

    @Override // com.google.protobuf.A1
    public final void b(Object obj, Object obj2, long j5) {
        List list = (List) W2.c.k(obj2, j5);
        List listD = d(obj, j5, list.size());
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        W2.p(obj, j5, list);
    }

    @Override // com.google.protobuf.A1
    public final List c(Object obj, long j5) {
        return d(obj, j5, 10);
    }
}
