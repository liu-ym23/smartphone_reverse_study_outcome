package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y {
    public static Collection a(Object r10) {
        if ((r10 instanceof KMappedMarker) == false) goto L8;
        if ((r10 instanceof KMutableCollection) == true) goto L8;
        p(r10, "kotlin.collections.MutableCollection");
    L8:
        return f(r10);
    }

    public static Iterable b(Object r10) {
        if ((r10 instanceof KMappedMarker) == false) goto L8;
        if ((r10 instanceof KMutableIterable) == true) goto L8;
        p(r10, "kotlin.collections.MutableIterable");
    L8:
        return g(r10);
    }

    public static List c(Object r10) {
        if ((r10 instanceof KMappedMarker) == false) goto L8;
        if ((r10 instanceof KMutableList) == true) goto L8;
        p(r10, "kotlin.collections.MutableList");
    L8:
        return h(r10);
    }

    public static Map d(Object r10) {
        if ((r10 instanceof KMappedMarker) == false) goto L8;
        if ((r10 instanceof KMutableMap) == true) goto L8;
        p(r10, "kotlin.collections.MutableMap");
    L8:
        return i(r10);
    }

    public static Object e(Object r10, int r11) {
        if (r10 != null) goto L4;
    L6:
        return r10;
    L4:
        if (k(r10, r11) == true) goto L6;
        p(r10, "kotlin.jvm.functions.Function" + r11);
        goto L6
    }

    public static Collection f(Object r10) {
        return (Collection) r10;
    L4:
        e = move-exception;
        throw o(e);
    }

    public static Iterable g(Object r10) {
        return (Iterable) r10;
    L4:
        e = move-exception;
        throw o(e);
    }

    public static List h(Object r10) {
        return (List) r10;
    L4:
        e = move-exception;
        throw o(e);
    }

    public static Map i(Object r10) {
        return (Map) r10;
    L4:
        e = move-exception;
        throw o(e);
    }

    public static int j(Object r10) {
        if ((r10 instanceof FunctionBase) == false) goto L7;
        return ((FunctionBase) r10).getArity();
    L7:
        if ((r10 instanceof Function0) == false) goto L11;
        return 0;
    L11:
        if ((r10 instanceof Function1) == false) goto L15;
        return 1;
    L15:
        if ((r10 instanceof Function2) == false) goto L19;
        return 2;
    L19:
        if ((r10 instanceof Function3) == false) goto L23;
        return 3;
    L23:
        if ((r10 instanceof Function4) == false) goto L27;
        return 4;
    L27:
        if ((r10 instanceof Function5) == false) goto L31;
        return 5;
    L31:
        if ((r10 instanceof Function6) == false) goto L35;
        return 6;
    L35:
        if ((r10 instanceof Function7) == false) goto L39;
        return 7;
    L39:
        if ((r10 instanceof Function8) == false) goto L43;
        return 8;
    L43:
        if ((r10 instanceof Function9) == false) goto L47;
        return 9;
    L47:
        if ((r10 instanceof Function10) == false) goto L51;
        return 10;
    L51:
        if ((r10 instanceof Function11) == false) goto L55;
        return 11;
    L55:
        if ((r10 instanceof Function12) == false) goto L59;
        return 12;
    L59:
        if ((r10 instanceof Function13) == false) goto L63;
        return 13;
    L63:
        if ((r10 instanceof Function14) == false) goto L67;
        return 14;
    L67:
        if ((r10 instanceof Function15) == false) goto L71;
        return 15;
    L71:
        if ((r10 instanceof Function16) == false) goto L75;
        return 16;
    L75:
        if ((r10 instanceof Function17) == false) goto L79;
        return 17;
    L79:
        if ((r10 instanceof Function18) == false) goto L83;
        return 18;
    L83:
        if ((r10 instanceof Function19) == false) goto L87;
        return 19;
    L87:
        if ((r10 instanceof Function20) == false) goto L91;
        return 20;
    L91:
        if ((r10 instanceof Function21) == false) goto L95;
        return 21;
    L95:
        if ((r10 instanceof Function22) == false) goto L98;
        return 22;
    L98:
        return -1;
    }

    public static boolean k(Object r10, int r11) {
        if ((r10 instanceof Function) == true) goto L5;
    L7:
        return false;
    L5:
        if (j(r10) != r11) goto L7;
        return true;
    }

    public static boolean l(Object r10) {
        if ((r10 instanceof List) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r10 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r10 instanceof KMutableList) == false) goto L9;
        goto L8
    }

    public static boolean m(Object r10) {
        if ((r10 instanceof Set) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r10 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r10 instanceof KMutableSet) == false) goto L9;
        goto L8
    }

    public static Throwable n(Throwable r10) {
        return q.o(r10, y.class.getName());
    }

    public static ClassCastException o(ClassCastException r10) {
        throw ((ClassCastException) n(r10));
    }

    public static void p(Object r10, String r11) {
        if (r10 != null) goto L4;
        String r12 = "null";
    L5:
        q(r12 + " cannot be cast to " + r11);
        return;
    L4:
        r12 = r10.getClass().getName();
        goto L5
    }

    public static void q(String r10) {
        throw o(new ClassCastException(r10));
    }
}
