package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a implements w7.s {

    /* renamed from: a, reason: collision with root package name */
    public final String f1907a;

    /* renamed from: b, reason: collision with root package name */
    public final JsonNode f1908b;

    /* renamed from: c, reason: collision with root package name */
    public final w7.n f1909c;

    public a(x xVar, JsonNode jsonNode, w7.n nVar) {
        this.f1907a = xVar.getValue();
        this.f1908b = jsonNode;
        this.f1909c = nVar;
    }

    public static boolean d(w7.f fVar, String str) {
        fVar.f15306a.getClass();
        return false;
    }

    public static boolean f(w7.f fVar, String str) {
        Iterator itDescendingIterator = fVar.f15313h.descendingIterator();
        Iterator itDescendingIterator2 = fVar.f15312g.descendingIterator();
        if (itDescendingIterator.hasNext()) {
            itDescendingIterator.next();
        }
        boolean z10 = false;
        while (itDescendingIterator2.hasNext()) {
            if (((w7.l) itDescendingIterator2.next()).f15331g.has(str)) {
                return true;
            }
            if (z10) {
                break;
            }
            if (itDescendingIterator.hasNext()) {
                Object next = itDescendingIterator.next();
                if ("properties".equals(next) || "items".equals(next)) {
                    z10 = true;
                }
            }
        }
        return false;
    }

    public static boolean g(w7.f fVar) {
        return fVar.f15315k && f(fVar, "unevaluatedItems");
    }

    public static boolean h(w7.f fVar) {
        return fVar.f15314j && f(fVar, "unevaluatedProperties");
    }

    @Override // w7.s
    public void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        c(fVar);
    }

    public final boolean c(w7.f fVar) {
        d(fVar, e());
        return false;
    }

    public String e() {
        return this.f1907a;
    }

    public final String toString() {
        return e();
    }

    public void i() {
    }
}
