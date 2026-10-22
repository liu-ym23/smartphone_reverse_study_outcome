package Ia;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class b {

    /* JADX INFO: Add missing generic type declarations: [N] */
    public static class a<N> extends AbstractC0058b<N, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l f3398a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f3399b;

        public a(InterfaceC5074l interfaceC5074l, boolean[] zArr) {
            this.f3398a = interfaceC5074l;
            this.f3399b = zArr;
        }

        @Override // Ia.b.d
        public boolean c(N n10) {
            if (((Boolean) this.f3398a.invoke(n10)).booleanValue()) {
                this.f3399b[0] = true;
            }
            return !this.f3399b[0];
        }

        @Override // Ia.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(this.f3399b[0]);
        }
    }

    /* renamed from: Ia.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0058b<N, R> implements d<N, R> {
        @Override // Ia.b.d
        public void b(N n10) {
        }
    }

    public interface c<N> {
        Iterable<? extends N> a(N n10);
    }

    public interface d<N, R> {
        R a();

        void b(N n10);

        boolean c(N n10);
    }

    public interface e<N> {
        boolean a(N n10);
    }

    public static class f<N> implements e<N> {

        /* renamed from: a, reason: collision with root package name */
        public final Set<N> f3400a;

        public f() {
            this(new HashSet());
        }

        public static /* synthetic */ void b(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        @Override // Ia.b.e
        public boolean a(N n10) {
            return this.f3400a.add(n10);
        }

        public f(Set<N> set) {
            if (set == null) {
                b(0);
            }
            this.f3400a = set;
        }
    }

    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        switch (i10) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i10) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R b(Collection<N> collection, c<N> cVar, d<N, R> dVar) {
        if (collection == null) {
            a(4);
        }
        if (cVar == null) {
            a(5);
        }
        if (dVar == null) {
            a(6);
        }
        return (R) c(collection, cVar, new f(), dVar);
    }

    public static <N, R> R c(Collection<N> collection, c<N> cVar, e<N> eVar, d<N, R> dVar) {
        if (collection == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        if (eVar == null) {
            a(2);
        }
        if (dVar == null) {
            a(3);
        }
        Iterator<N> it = collection.iterator();
        while (it.hasNext()) {
            d(it.next(), cVar, eVar, dVar);
        }
        return dVar.a();
    }

    public static <N> void d(N n10, c<N> cVar, e<N> eVar, d<N, ?> dVar) {
        if (n10 == null) {
            a(22);
        }
        if (cVar == null) {
            a(23);
        }
        if (eVar == null) {
            a(24);
        }
        if (dVar == null) {
            a(25);
        }
        if (eVar.a(n10) && dVar.c(n10)) {
            Iterator<? extends N> it = cVar.a(n10).iterator();
            while (it.hasNext()) {
                d(it.next(), cVar, eVar, dVar);
            }
            dVar.b(n10);
        }
    }

    public static <N> Boolean e(Collection<N> collection, c<N> cVar, InterfaceC5074l<N, Boolean> interfaceC5074l) {
        if (collection == null) {
            a(7);
        }
        if (cVar == null) {
            a(8);
        }
        if (interfaceC5074l == null) {
            a(9);
        }
        return (Boolean) b(collection, cVar, new a(interfaceC5074l, new boolean[1]));
    }
}
