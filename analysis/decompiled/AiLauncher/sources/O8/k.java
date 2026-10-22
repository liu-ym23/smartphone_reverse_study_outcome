package O8;

import O8.h;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class k {

    public interface b {
        boolean a(Object obj);

        void b(Object obj);
    }

    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Integer> f5280a;

        public c() {
            this.f5280a = new HashSet(3);
        }

        public static Integer c(Object obj) {
            return Integer.valueOf(System.identityHashCode(obj));
        }

        @Override // O8.k.b
        public boolean a(Object obj) {
            return this.f5280a.contains(c(obj));
        }

        @Override // O8.k.b
        public void b(Object obj) {
            this.f5280a.add(c(obj));
        }
    }

    public static String a(h.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        d(sb2, new c(), aVar);
        return sb2.toString();
    }

    public static String b(h.c cVar) {
        StringBuilder sb2 = new StringBuilder();
        e(sb2, new c(), cVar);
        return sb2.toString();
    }

    public static String c(h.f fVar) {
        StringBuilder sb2 = new StringBuilder();
        f(sb2, new c(), fVar);
        return sb2.toString();
    }

    public static void d(StringBuilder sb2, b bVar, h.a aVar) {
        sb2.append("Grammar{id=0x");
        sb2.append(Integer.toHexString(System.identityHashCode(aVar)));
        sb2.append(",name=\"");
        sb2.append(aVar.name());
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        if (bVar.a(aVar)) {
            sb2.append(",[...]");
        } else {
            bVar.b(aVar);
            sb2.append(",tokens=[");
            boolean z10 = true;
            for (h.f fVar : aVar.a()) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(',');
                }
                f(sb2, bVar, fVar);
            }
            sb2.append(']');
        }
        sb2.append('}');
    }

    public static void e(StringBuilder sb2, b bVar, h.c cVar) {
        sb2.append("Pattern{id=0x");
        sb2.append(Integer.toHexString(System.identityHashCode(cVar)));
        if (bVar.a(cVar)) {
            sb2.append(",[...]");
        } else {
            bVar.b(cVar);
            sb2.append(",regex=\"");
            sb2.append(cVar.e());
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            if (cVar.f()) {
                sb2.append(",lookbehind=true");
            }
            if (cVar.c()) {
                sb2.append(",greedy=true");
            }
            if (cVar.a() != null) {
                sb2.append(",alias=\"");
                sb2.append(cVar.a());
                sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            h.a aVarD = cVar.d();
            if (aVarD != null) {
                sb2.append(",inside=");
                d(sb2, bVar, aVarD);
            }
        }
        sb2.append('}');
    }

    public static void f(StringBuilder sb2, b bVar, h.f fVar) {
        sb2.append("Token{id=0x");
        sb2.append(Integer.toHexString(System.identityHashCode(fVar)));
        sb2.append(",name=\"");
        sb2.append(fVar.name());
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        if (bVar.a(fVar)) {
            sb2.append(",[...]");
        } else {
            bVar.b(fVar);
            sb2.append(",patterns=[");
            boolean z10 = true;
            for (h.c cVar : fVar.a()) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(',');
                }
                e(sb2, bVar, cVar);
            }
            sb2.append(']');
        }
        sb2.append('}');
    }
}
