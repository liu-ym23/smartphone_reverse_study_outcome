package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TypeIntrinsics.java */
/* JADX INFO: loaded from: classes4.dex */
public class ae {
    public ae() {
    }

    private static <T extends Throwable> T a(T r1) {
        return (T) o.a(r1, ae.class.getName());
    }

    public static void a(Object r1, String r2) {
        if (r1 != null) goto L4;
        String r3 = "null";
    L5:
        a(r3 + " cannot be cast to " + r2);
        return;
    L4:
        r3 = r1.getClass().getName();
        goto L5
    }

    public static void a(String r1) {
        throw a(new ClassCastException(r1));
    }

    public static ClassCastException a(ClassCastException r2) {
        throw ((ClassCastException) ZeusTransformUtils.preCheckCast(a(r2), ClassCastException.class, "com.obric.aiagent.plugin"));
    }

    public static Iterable a(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.c.class) == true) goto L8;
        a(r1, "kotlin.collections.MutableIterable");
    L8:
        return b(r1);
    }

    public static Iterable b(Object r2) {
        return (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw a(e);
    }

    public static Collection c(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.b.class) == true) goto L8;
        a(r1, "kotlin.collections.MutableCollection");
    L8:
        return d(r1);
    }

    public static Collection d(Object r2) {
        return (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw a(e);
    }

    public static boolean e(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, List.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.e.class) == false) goto L9;
        goto L8
    }

    public static List f(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.e.class) == true) goto L8;
        a(r1, "kotlin.collections.MutableList");
    L8:
        return g(r1);
    }

    public static List g(Object r2) {
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw a(e);
    }

    public static boolean h(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Set.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.h.class) == false) goto L9;
        goto L8
    }

    public static boolean i(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Map.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.g.class) == false) goto L9;
        goto L8
    }

    public static Map j(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.g.class) == true) goto L8;
        a(r1, "kotlin.collections.MutableMap");
    L8:
        return k(r1);
    }

    public static Map k(Object r2) {
        return (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw a(e);
    }

    public static Map.Entry l(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.a.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, d.h.b.a.g.a.class) == true) goto L8;
        a(r1, "kotlin.collections.MutableMap.MutableEntry");
    L8:
        return m(r1);
    }

    public static Map.Entry m(Object r2) {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw a(e);
    }

    public static int n(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, j.class) == false) goto L7;
        return ((j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.aiagent.plugin")).getArity();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.a.class) == false) goto L11;
        return 0;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.b.class) == false) goto L15;
        return 1;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.m.class) == false) goto L19;
        return 2;
    L19:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.q.class) == false) goto L23;
        return 3;
    L23:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.r.class) == false) goto L27;
        return 4;
    L27:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.s.class) == false) goto L31;
        return 5;
    L31:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.t.class) == false) goto L35;
        return 6;
    L35:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.u.class) == false) goto L39;
        return 7;
    L39:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.v.class) == false) goto L43;
        return 8;
    L43:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.w.class) == false) goto L47;
        return 9;
    L47:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.c.class) == false) goto L51;
        return 10;
    L51:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.d.class) == false) goto L55;
        return 11;
    L55:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.e.class) == false) goto L59;
        return 12;
    L59:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.f.class) == false) goto L63;
        return 13;
    L63:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.g.class) == false) goto L67;
        return 14;
    L67:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.h.class) == false) goto L71;
        return 15;
    L71:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.i.class) == false) goto L75;
        return 16;
    L75:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.j.class) == false) goto L79;
        return 17;
    L79:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.k.class) == false) goto L83;
        return 18;
    L83:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.l.class) == false) goto L87;
        return 19;
    L87:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.n.class) == false) goto L91;
        return 20;
    L91:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.o.class) == false) goto L95;
        return 21;
    L95:
        if (ZeusTransformUtils.instanceOf(r2, d.h.a.p.class) == false) goto L98;
        return 22;
    L98:
        return -1;
    }

    public static boolean a(Object r1, int r2) {
        if (ZeusTransformUtils.instanceOf(r1, d.c.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (n(r1) != r2) goto L7;
        return true;
    }

    public static Object b(Object r2, int r3) {
        if (r2 != null) goto L4;
    L6:
        return r2;
    L4:
        if (a(r2, r3) == true) goto L6;
        a(r2, "kotlin.jvm.functions.Function" + r3);
        goto L6
    }
}
