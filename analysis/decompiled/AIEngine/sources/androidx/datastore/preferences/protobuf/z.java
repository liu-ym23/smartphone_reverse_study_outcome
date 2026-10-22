package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.g1;
import androidx.datastore.preferences.protobuf.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1903a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final b f1904b = new b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends z {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?> f1905c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        public static List d(long j10, int i10, Object obj) {
            List list = (List) g1.f1818d.i(j10, obj);
            if (list.isEmpty()) {
                List xVar = list instanceof y ? new x(i10) : ((list instanceof r0) && (list instanceof u.c)) ? ((u.c) list).c0(i10) : new ArrayList(i10);
                g1.o(j10, obj, xVar);
                return xVar;
            }
            if (f1905c.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i10);
                arrayList.addAll(list);
                g1.o(j10, obj, arrayList);
                return arrayList;
            }
            if (list instanceof f1) {
                x xVar2 = new x(list.size() + i10);
                xVar2.addAll((f1) list);
                g1.o(j10, obj, xVar2);
                return xVar2;
            }
            if ((list instanceof r0) && (list instanceof u.c)) {
                u.c cVar = (u.c) list;
                if (!cVar.S()) {
                    u.c cVarC0 = cVar.c0(list.size() + i10);
                    g1.o(j10, obj, cVarC0);
                    return cVarC0;
                }
            }
            return list;
        }

        @Override // androidx.datastore.preferences.protobuf.z
        public final void a(long j10, Object obj) {
            Object objUnmodifiableList;
            List list = (List) g1.f1818d.i(j10, obj);
            if (list instanceof y) {
                objUnmodifiableList = ((y) list).x0();
            } else {
                if (f1905c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof r0) && (list instanceof u.c)) {
                    u.c cVar = (u.c) list;
                    if (cVar.S()) {
                        cVar.o();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            g1.o(j10, obj, objUnmodifiableList);
        }

        @Override // androidx.datastore.preferences.protobuf.z
        public final void b(long j10, Object obj, Object obj2) {
            List list = (List) g1.f1818d.i(j10, obj2);
            List listD = d(j10, list.size(), obj);
            int size = listD.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listD.addAll(list);
            }
            if (size > 0) {
                list = listD;
            }
            g1.o(j10, obj, list);
        }

        @Override // androidx.datastore.preferences.protobuf.z
        public final List c(long j10, Object obj) {
            return d(j10, 10, obj);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends z {
        @Override // androidx.datastore.preferences.protobuf.z
        public final void a(long j10, Object obj) {
            ((u.c) g1.f1818d.i(j10, obj)).o();
        }

        @Override // androidx.datastore.preferences.protobuf.z
        public final void b(long j10, Object obj, Object obj2) {
            g1.e eVar = g1.f1818d;
            u.c cVarC0 = (u.c) eVar.i(j10, obj);
            u.c cVar = (u.c) eVar.i(j10, obj2);
            int size = cVarC0.size();
            int size2 = cVar.size();
            if (size > 0 && size2 > 0) {
                if (!cVarC0.S()) {
                    cVarC0 = cVarC0.c0(size2 + size);
                }
                cVarC0.addAll(cVar);
            }
            if (size > 0) {
                cVar = cVarC0;
            }
            g1.o(j10, obj, cVar);
        }

        @Override // androidx.datastore.preferences.protobuf.z
        public final List c(long j10, Object obj) {
            u.c cVar = (u.c) g1.f1818d.i(j10, obj);
            if (cVar.S()) {
                return cVar;
            }
            int size = cVar.size();
            u.c cVarC0 = cVar.c0(size == 0 ? 10 : size * 2);
            g1.o(j10, obj, cVarC0);
            return cVarC0;
        }
    }

    public abstract void a(long j10, Object obj);

    public abstract void b(long j10, Object obj, Object obj2);

    public abstract List c(long j10, Object obj);
}
