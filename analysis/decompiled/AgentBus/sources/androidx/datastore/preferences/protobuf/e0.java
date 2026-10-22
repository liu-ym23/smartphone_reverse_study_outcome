package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class e0 extends g0 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f842c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(int i2, long j2, Object obj) {
        List list = (List) s1.f949c.i(j2, obj);
        if (list.isEmpty()) {
            List c0Var = list instanceof d0 ? new c0(i2) : new ArrayList(i2);
            s1.p(j2, obj, c0Var);
            return c0Var;
        }
        if (f842c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i2);
            arrayList.addAll(list);
            s1.p(j2, obj, arrayList);
            return arrayList;
        }
        if (!(list instanceof n1)) {
            return list;
        }
        c0 c0Var2 = new c0(list.size() + i2);
        c0Var2.addAll((n1) list);
        s1.p(j2, obj, c0Var2);
        return c0Var2;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final void a(long j2, Object obj) {
        Object objUnmodifiableList;
        List list = (List) s1.f949c.i(j2, obj);
        if (list instanceof d0) {
            objUnmodifiableList = ((d0) list).getUnmodifiableView();
        } else if (f842c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        s1.p(j2, obj, objUnmodifiableList);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final void b(long j2, Object obj, Object obj2) {
        List list = (List) s1.f949c.i(j2, obj2);
        List listD = d(list.size(), j2, obj);
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        s1.p(j2, obj, list);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final List c(long j2, Object obj) {
        return d(10, j2, obj);
    }
}
