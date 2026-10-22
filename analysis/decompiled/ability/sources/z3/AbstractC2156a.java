package z3;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;

/* renamed from: z3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2156a implements u3.m {

    /* renamed from: a, reason: collision with root package name */
    public final String f6946a;
    public final JsonNode b;
    public final u3.j c;

    public AbstractC2156a(t tVar, JsonNode jsonNode, u3.j jVar) {
        this.f6946a = tVar.getValue();
        this.b = jsonNode;
        this.c = jVar;
    }

    public static boolean d(u3.f fVar, String str) {
        fVar.f6698a.getClass();
        return false;
    }

    public static boolean f(u3.f fVar, String str) {
        Iterator itDescendingIterator = fVar.h.descendingIterator();
        Iterator itDescendingIterator2 = fVar.g.descendingIterator();
        if (itDescendingIterator.hasNext()) {
            itDescendingIterator.next();
        }
        boolean z10 = false;
        while (itDescendingIterator2.hasNext()) {
            if (((u3.i) itDescendingIterator2.next()).g.has(str)) {
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

    public static boolean g(u3.f fVar) {
        return fVar.k && f(fVar, "unevaluatedItems");
    }

    public static boolean h(u3.f fVar) {
        return fVar.f6699j && f(fVar, "unevaluatedProperties");
    }

    @Override // u3.m
    public void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        c(fVar);
    }

    public final boolean c(u3.f fVar) {
        d(fVar, e());
        return false;
    }

    public String e() {
        return this.f6946a;
    }

    public void i() {
    }

    public final String toString() {
        return e();
    }
}
