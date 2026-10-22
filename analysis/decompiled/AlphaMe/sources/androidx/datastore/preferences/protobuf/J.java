package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class J extends L {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f3428c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX WARN: Multi-variable type inference failed */
    public static List d(int i4, long j4, Object obj) {
        H h4;
        List list = (List) z0.f3558d.i(j4, obj);
        if (list.isEmpty()) {
            List h5 = list instanceof I ? new H(i4) : ((list instanceof InterfaceC0252d0) && (list instanceof C)) ? ((C) list).b(i4) : new ArrayList(i4);
            z0.r(j4, obj, h5);
            return h5;
        }
        if (f3428c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i4);
            arrayList.addAll(list);
            z0.r(j4, obj, arrayList);
            h4 = arrayList;
        } else {
            if (!(list instanceof u0)) {
                if (!(list instanceof InterfaceC0252d0) || !(list instanceof C)) {
                    return list;
                }
                C c4 = (C) list;
                if (((AbstractC0249c) c4).f3464a) {
                    return list;
                }
                C cB = c4.b(list.size() + i4);
                z0.r(j4, obj, cB);
                return cB;
            }
            H h6 = new H(list.size() + i4);
            h6.addAll((u0) list);
            z0.r(j4, obj, h6);
            h4 = h6;
        }
        return h4;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final void a(long j4, Object obj) {
        Object objUnmodifiableList;
        List list = (List) z0.f3558d.i(j4, obj);
        if (list instanceof I) {
            objUnmodifiableList = ((I) list).k();
        } else {
            if (f3428c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC0252d0) && (list instanceof C)) {
                AbstractC0249c abstractC0249c = (AbstractC0249c) ((C) list);
                if (abstractC0249c.f3464a) {
                    abstractC0249c.f3464a = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        z0.r(j4, obj, objUnmodifiableList);
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final void b(long j4, Object obj, Object obj2) {
        List list = (List) z0.f3558d.i(j4, obj2);
        List listD = d(list.size(), j4, obj);
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        z0.r(j4, obj, list);
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final List c(long j4, Object obj) {
        return d(10, j4, obj);
    }
}
