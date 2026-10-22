package kotlin.reflect.jvm.internal.impl.name;

import La.D;
import ga.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: kotlin.reflect.jvm.internal.impl.name.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0448a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35823a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.BEGINNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.AFTER_DOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f35823a = iArr;
        }
    }

    public static final <V> V a(c cVar, Map<c, ? extends V> values) {
        Object next;
        p.i(cVar, "<this>");
        p.i(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<c, ? extends V> entry : values.entrySet()) {
            c key = entry.getKey();
            if (p.d(cVar, key) || b(cVar, key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = g((c) ((Map.Entry) next).getKey(), cVar).a().length();
                do {
                    Object next2 = it.next();
                    int length2 = g((c) ((Map.Entry) next2).getKey(), cVar).a().length();
                    if (length > length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 != null) {
            return (V) entry2.getValue();
        }
        return null;
    }

    public static final boolean b(c cVar, c packageName) {
        p.i(cVar, "<this>");
        p.i(packageName, "packageName");
        return p.d(f(cVar), packageName);
    }

    public static final boolean c(c cVar, c packageName) {
        p.i(cVar, "<this>");
        p.i(packageName, "packageName");
        if (p.d(cVar, packageName) || packageName.c()) {
            return true;
        }
        return d(cVar.a(), packageName.a());
    }

    public static final boolean d(String str, String str2) {
        return D.X(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean e(String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            int i11 = C0448a.f35823a[state.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (!Character.isJavaIdentifierStart(cCharAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (cCharAt == '.') {
                    state = State.AFTER_DOT;
                } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
            }
        }
        return state != State.AFTER_DOT;
    }

    public static final c f(c cVar) {
        p.i(cVar, "<this>");
        if (cVar.c()) {
            return null;
        }
        return cVar.d();
    }

    public static final c g(c cVar, c prefix) {
        p.i(cVar, "<this>");
        p.i(prefix, "prefix");
        if (!c(cVar, prefix) || prefix.c()) {
            return cVar;
        }
        if (p.d(cVar, prefix)) {
            return c.f32726d;
        }
        String strSubstring = cVar.a().substring(prefix.a().length() + 1);
        p.h(strSubstring, "substring(...)");
        return new c(strSubstring);
    }
}
