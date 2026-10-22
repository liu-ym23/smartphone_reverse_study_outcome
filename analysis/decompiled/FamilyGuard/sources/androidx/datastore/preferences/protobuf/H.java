package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
abstract class H {

    /* renamed from: a, reason: collision with root package name */
    private static final H f9936a;

    /* renamed from: b, reason: collision with root package name */
    private static final H f9937b;

    private static final class b extends H {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?> f9938c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        private b() {
            super();
        }

        static <E> List<E> f(Object obj, long j5) {
            return (List) s0.A(obj, j5);
        }

        private static <L> List<L> g(Object obj, long j5, int i5) {
            List<L> listF = f(obj, j5);
            if (listF.isEmpty()) {
                List<L> f5 = listF instanceof G ? new F(i5) : ((listF instanceof b0) && (listF instanceof A.i)) ? ((A.i) listF).d(i5) : new ArrayList<>(i5);
                s0.O(obj, j5, f5);
                return f5;
            }
            if (f9938c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i5);
                arrayList.addAll(listF);
                s0.O(obj, j5, arrayList);
                return arrayList;
            }
            if (listF instanceof r0) {
                F f6 = new F(listF.size() + i5);
                f6.addAll((r0) listF);
                s0.O(obj, j5, f6);
                return f6;
            }
            if ((listF instanceof b0) && (listF instanceof A.i)) {
                A.i iVar = (A.i) listF;
                if (!iVar.l()) {
                    A.i iVarD = iVar.d(listF.size() + i5);
                    s0.O(obj, j5, iVarD);
                    return iVarD;
                }
            }
            return listF;
        }

        @Override // androidx.datastore.preferences.protobuf.H
        void c(Object obj, long j5) {
            Object objUnmodifiableList;
            List list = (List) s0.A(obj, j5);
            if (list instanceof G) {
                objUnmodifiableList = ((G) list).j();
            } else {
                if (f9938c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof b0) && (list instanceof A.i)) {
                    A.i iVar = (A.i) list;
                    if (iVar.l()) {
                        iVar.b();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            s0.O(obj, j5, objUnmodifiableList);
        }

        @Override // androidx.datastore.preferences.protobuf.H
        <E> void d(Object obj, Object obj2, long j5) {
            List listF = f(obj2, j5);
            List listG = g(obj, j5, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            s0.O(obj, j5, listF);
        }

        @Override // androidx.datastore.preferences.protobuf.H
        <L> List<L> e(Object obj, long j5) {
            return g(obj, j5, 10);
        }
    }

    private static final class c extends H {
        private c() {
            super();
        }

        static <E> A.i<E> f(Object obj, long j5) {
            return (A.i) s0.A(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.H
        void c(Object obj, long j5) {
            f(obj, j5).b();
        }

        @Override // androidx.datastore.preferences.protobuf.H
        <E> void d(Object obj, Object obj2, long j5) {
            A.i iVarF = f(obj, j5);
            A.i iVarF2 = f(obj2, j5);
            int size = iVarF.size();
            int size2 = iVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!iVarF.l()) {
                    iVarF = iVarF.d(size2 + size);
                }
                iVarF.addAll(iVarF2);
            }
            if (size > 0) {
                iVarF2 = iVarF;
            }
            s0.O(obj, j5, iVarF2);
        }

        @Override // androidx.datastore.preferences.protobuf.H
        <L> List<L> e(Object obj, long j5) {
            A.i iVarF = f(obj, j5);
            if (iVarF.l()) {
                return iVarF;
            }
            int size = iVarF.size();
            A.i iVarD = iVarF.d(size == 0 ? 10 : size * 2);
            s0.O(obj, j5, iVarD);
            return iVarD;
        }
    }

    static {
        f9936a = new b();
        f9937b = new c();
    }

    static H a() {
        return f9936a;
    }

    static H b() {
        return f9937b;
    }

    abstract void c(Object obj, long j5);

    abstract <L> void d(Object obj, Object obj2, long j5);

    abstract <L> List<L> e(Object obj, long j5);

    private H() {
    }
}
