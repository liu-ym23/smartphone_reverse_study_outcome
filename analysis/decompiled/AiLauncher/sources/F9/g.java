package F9;

import Z8.C1173v;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.p;
import q9.InterfaceC5162a;

/* loaded from: classes5.dex */
public interface g extends Iterable<c>, InterfaceC5162a {

    /* renamed from: m0, reason: collision with root package name */
    public static final a f2609m0 = a.f2610a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f2610a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final g f2611b = new C0032a();

        /* renamed from: F9.g$a$a, reason: collision with other inner class name */
        public static final class C0032a implements g {
            @Override // F9.g
            public /* bridge */ boolean E(ga.c cVar) {
                return b.b(this, cVar);
            }

            public Void b(ga.c fqName) {
                p.i(fqName, "fqName");
                return null;
            }

            @Override // F9.g
            public /* bridge */ /* synthetic */ c d(ga.c cVar) {
                return (c) b(cVar);
            }

            @Override // F9.g
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return C1173v.m().iterator();
            }

            public String toString() {
                return "EMPTY";
            }
        }

        public final g a(List<? extends c> annotations) {
            p.i(annotations, "annotations");
            return annotations.isEmpty() ? f2611b : new h(annotations);
        }

        public final g b() {
            return f2611b;
        }
    }

    public static final class b {
        public static c a(g gVar, ga.c fqName) {
            c next;
            p.i(fqName, "fqName");
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (p.d(next.f(), fqName)) {
                    break;
                }
            }
            return next;
        }

        public static boolean b(g gVar, ga.c fqName) {
            p.i(fqName, "fqName");
            return gVar.d(fqName) != null;
        }
    }

    boolean E(ga.c cVar);

    c d(ga.c cVar);

    boolean isEmpty();
}
