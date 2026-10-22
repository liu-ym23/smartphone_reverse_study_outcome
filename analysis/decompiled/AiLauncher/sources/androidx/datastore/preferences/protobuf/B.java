package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1359w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public static final B f13404a;

    /* renamed from: b, reason: collision with root package name */
    public static final B f13405b;

    public static final class b extends B {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?> f13406c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        public b() {
            super();
        }

        public static <E> List<E> f(Object obj, long j10) {
            return (List) j0.A(obj, j10);
        }

        public static <L> List<L> g(Object obj, long j10, int i10) {
            List<L> listF = f(obj, j10);
            if (listF.isEmpty()) {
                List<L> c1362z = listF instanceof A ? new C1362z(i10) : ((listF instanceof U) && (listF instanceof C1359w.i)) ? ((C1359w.i) listF).mutableCopyWithCapacity(i10) : new ArrayList<>(i10);
                j0.O(obj, j10, c1362z);
                return c1362z;
            }
            if (f13406c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i10);
                arrayList.addAll(listF);
                j0.O(obj, j10, arrayList);
                return arrayList;
            }
            if (listF instanceof i0) {
                C1362z c1362z2 = new C1362z(listF.size() + i10);
                c1362z2.addAll((i0) listF);
                j0.O(obj, j10, c1362z2);
                return c1362z2;
            }
            if ((listF instanceof U) && (listF instanceof C1359w.i)) {
                C1359w.i iVar = (C1359w.i) listF;
                if (!iVar.isModifiable()) {
                    C1359w.i iVarMutableCopyWithCapacity = iVar.mutableCopyWithCapacity(listF.size() + i10);
                    j0.O(obj, j10, iVarMutableCopyWithCapacity);
                    return iVarMutableCopyWithCapacity;
                }
            }
            return listF;
        }

        @Override // androidx.datastore.preferences.protobuf.B
        public void c(Object obj, long j10) {
            Object objUnmodifiableList;
            List list = (List) j0.A(obj, j10);
            if (list instanceof A) {
                objUnmodifiableList = ((A) list).getUnmodifiableView();
            } else {
                if (f13406c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof U) && (list instanceof C1359w.i)) {
                    C1359w.i iVar = (C1359w.i) list;
                    if (iVar.isModifiable()) {
                        iVar.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            j0.O(obj, j10, objUnmodifiableList);
        }

        @Override // androidx.datastore.preferences.protobuf.B
        public <E> void d(Object obj, Object obj2, long j10) {
            List listF = f(obj2, j10);
            List listG = g(obj, j10, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            j0.O(obj, j10, listF);
        }

        @Override // androidx.datastore.preferences.protobuf.B
        public <L> List<L> e(Object obj, long j10) {
            return g(obj, j10, 10);
        }
    }

    public static final class c extends B {
        public c() {
            super();
        }

        public static <E> C1359w.i<E> f(Object obj, long j10) {
            return (C1359w.i) j0.A(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.B
        public void c(Object obj, long j10) {
            f(obj, j10).makeImmutable();
        }

        @Override // androidx.datastore.preferences.protobuf.B
        public <E> void d(Object obj, Object obj2, long j10) {
            C1359w.i iVarF = f(obj, j10);
            C1359w.i iVarF2 = f(obj2, j10);
            int size = iVarF.size();
            int size2 = iVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!iVarF.isModifiable()) {
                    iVarF = iVarF.mutableCopyWithCapacity(size2 + size);
                }
                iVarF.addAll(iVarF2);
            }
            if (size > 0) {
                iVarF2 = iVarF;
            }
            j0.O(obj, j10, iVarF2);
        }

        @Override // androidx.datastore.preferences.protobuf.B
        public <L> List<L> e(Object obj, long j10) {
            C1359w.i iVarF = f(obj, j10);
            if (iVarF.isModifiable()) {
                return iVarF;
            }
            int size = iVarF.size();
            C1359w.i iVarMutableCopyWithCapacity = iVarF.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            j0.O(obj, j10, iVarMutableCopyWithCapacity);
            return iVarMutableCopyWithCapacity;
        }
    }

    static {
        f13404a = new b();
        f13405b = new c();
    }

    public static B a() {
        return f13404a;
    }

    public static B b() {
        return f13405b;
    }

    public abstract void c(Object obj, long j10);

    public abstract <L> void d(Object obj, Object obj2, long j10);

    public abstract <L> List<L> e(Object obj, long j10);

    public B() {
    }
}
