package H1;

import F1.A;
import F1.B;
import F1.C0065a;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class s implements B {

    /* renamed from: a, reason: collision with root package name */
    public final l1.g f756a;

    /* renamed from: b, reason: collision with root package name */
    public final F1.i f757b;

    /* renamed from: c, reason: collision with root package name */
    public final G1.g f758c;

    /* renamed from: d, reason: collision with root package name */
    public final d f759d;

    /* renamed from: e, reason: collision with root package name */
    public final List f760e;

    public s(l1.g gVar, G1.g gVar2, d dVar, List list) {
        C0065a c0065a = F1.h.f431a;
        this.f756a = gVar;
        this.f757b = c0065a;
        this.f758c = gVar2;
        this.f759d = dVar;
        this.f760e = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!G1.s.f630a.a(obj, accessibleObject)) {
            throw new F1.q(AbstractC0351g.p(J1.c.d(accessibleObject, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."), 5);
        }
    }

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        B0.f.E(this.f760e);
        return J1.c.f880a.J(rawType) ? new r(rawType, c(nVar, typeToken, rawType, true)) : new q(this.f756a.b(typeToken), c(nVar, typeToken, rawType, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v38, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.LinkedHashMap c(F1.n r34, com.google.gson.reflect.TypeToken r35, java.lang.Class r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H1.s.c(F1.n, com.google.gson.reflect.TypeToken, java.lang.Class, boolean):java.util.LinkedHashMap");
    }

    public final boolean d(Field field, boolean z4) {
        Class<?> type = field.getType();
        G1.g gVar = this.f758c;
        gVar.getClass();
        if (!G1.g.c(type)) {
            gVar.b(z4);
            if ((field.getModifiers() & SyslogConstants.LOG_LOCAL1) == 0 && !field.isSynthetic() && !G1.g.c(field.getType())) {
                List list = z4 ? gVar.f600a : gVar.f601b;
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    if (it.hasNext()) {
                        B0.g.y(it.next());
                        throw null;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
