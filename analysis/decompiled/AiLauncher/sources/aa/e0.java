package aa;

import aa.m0;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes5.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C1261i f8124a = new C1261i(NullabilityQualifier.NULLABLE, null, false, false, 8, null);

    /* renamed from: b, reason: collision with root package name */
    public static final C1261i f8125b;

    /* renamed from: c, reason: collision with root package name */
    public static final C1261i f8126c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, f0> f8127d;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        f8125b = new C1261i(nullabilityQualifier, null, false, false, 8, null);
        f8126c = new C1261i(nullabilityQualifier, null, true, false, 8, null);
        ba.x xVar = ba.x.f15368a;
        String strH = xVar.h("Object");
        String strG = xVar.g("Predicate");
        String strG2 = xVar.g("Function");
        String strG3 = xVar.g("Consumer");
        String strG4 = xVar.g("BiFunction");
        String strG5 = xVar.g("BiConsumer");
        String strG6 = xVar.g("UnaryOperator");
        String strI = xVar.i("stream/Stream");
        String strI2 = xVar.i("Optional");
        m0 m0Var = new m0();
        m0.a.b(new m0.a(m0Var, xVar.i("Iterator")), "forEachRemaining", null, new C1264l(strG3), 2, null);
        m0.a.b(new m0.a(m0Var, xVar.h("Iterable")), "spliterator", null, new C1274w(xVar), 2, null);
        m0.a aVar = new m0.a(m0Var, xVar.i(CoreUtil.STR_DEX_COLLECTION_NAME));
        m0.a.b(aVar, "removeIf", null, new C1250H(strG), 2, null);
        m0.a.b(aVar, "stream", null, new T(strI), 2, null);
        m0.a.b(aVar, "parallelStream", null, new Y(strI), 2, null);
        m0.a aVar2 = new m0.a(m0Var, xVar.i("List"));
        m0.a.b(aVar2, "replaceAll", null, new Z(strG6), 2, null);
        aVar2.a("addFirst", "2.1", new a0(strH));
        aVar2.a("addLast", "2.1", new b0(strH));
        aVar2.a("removeFirst", "2.1", new c0(strH));
        aVar2.a("removeLast", "2.1", new d0(strH));
        m0.a aVar3 = new m0.a(m0Var, xVar.i("LinkedList"));
        aVar3.a("addFirst", "2.1", new C1265m(strH));
        aVar3.a("addLast", "2.1", new C1266n(strH));
        aVar3.a("removeFirst", "2.1", new C1267o(strH));
        aVar3.a("removeLast", "2.1", new C1268p(strH));
        m0.a aVar4 = new m0.a(m0Var, xVar.i("LinkedHashSet"));
        aVar4.a("addFirst", "2.2", new C1269q(strH));
        aVar4.a("addLast", "2.2", new r(strH));
        aVar4.a("removeFirst", "2.2", new C1270s(strH));
        aVar4.a("removeLast", "2.2", new C1271t(strH));
        aVar4.a("getFirst", "2.2", new C1272u(strH));
        aVar4.a("getLast", "2.2", new C1273v(strH));
        m0.a aVar5 = new m0.a(m0Var, xVar.i("Map"));
        m0.a.b(aVar5, "forEach", null, new C1275x(strG5), 2, null);
        m0.a.b(aVar5, "putIfAbsent", null, new C1276y(strH), 2, null);
        m0.a.b(aVar5, "replace", null, new C1277z(strH), 2, null);
        m0.a.b(aVar5, "replace", null, new C1243A(strH), 2, null);
        m0.a.b(aVar5, "replaceAll", null, new C1244B(strG4), 2, null);
        m0.a.b(aVar5, "compute", null, new C1245C(strH, strG4), 2, null);
        m0.a.b(aVar5, "computeIfAbsent", null, new C1246D(strH, strG2), 2, null);
        m0.a.b(aVar5, "computeIfPresent", null, new C1247E(strH, strG4), 2, null);
        m0.a.b(aVar5, "merge", null, new C1248F(strH, strG4), 2, null);
        m0.a aVar6 = new m0.a(m0Var, xVar.i("LinkedHashMap"));
        aVar6.a("putFirst", "2.2", new C1249G(strH));
        aVar6.a("putLast", "2.2", new C1251I(strH));
        m0.a aVar7 = new m0.a(m0Var, strI2);
        m0.a.b(aVar7, "empty", null, new C1252J(strI2), 2, null);
        m0.a.b(aVar7, "of", null, new K(strH, strI2), 2, null);
        m0.a.b(aVar7, "ofNullable", null, new L(strH, strI2), 2, null);
        m0.a.b(aVar7, "get", null, new M(strH), 2, null);
        m0.a.b(aVar7, "ifPresent", null, new N(strG3), 2, null);
        m0.a.b(new m0.a(m0Var, xVar.h("ref/Reference")), "get", null, new O(strH), 2, null);
        m0.a.b(new m0.a(m0Var, strG), "test", null, new P(strH), 2, null);
        m0.a.b(new m0.a(m0Var, xVar.g("BiPredicate")), "test", null, new Q(strH), 2, null);
        m0.a.b(new m0.a(m0Var, strG3), "accept", null, new S(strH), 2, null);
        m0.a.b(new m0.a(m0Var, strG5), "accept", null, new U(strH), 2, null);
        m0.a.b(new m0.a(m0Var, strG2), "apply", null, new V(strH), 2, null);
        m0.a.b(new m0.a(m0Var, strG4), "apply", null, new W(strH), 2, null);
        m0.a.b(new m0.a(m0Var, xVar.g("Supplier")), "get", null, new X(strH), 2, null);
        f8127d = m0Var.b();
    }

    public static final Y8.t A(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t B(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i, c1261i, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t C(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.c(str, f8124a);
        return Y8.t.f7040a;
    }

    public static final Y8.t D(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.c(str, f8124a);
        return Y8.t.f7040a;
    }

    public static final Y8.t E(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.d(JvmPrimitiveType.BOOLEAN);
        return Y8.t.f7040a;
    }

    public static final Y8.t F(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i, c1261i, c1261i, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t G(String str, String str2, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        C1261i c1261i2 = f8124a;
        function.b(str2, c1261i, c1261i, c1261i2, c1261i2);
        function.c(str, c1261i2);
        return Y8.t.f7040a;
    }

    public static final Y8.t H(String str, String str2, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str2, c1261i, c1261i, c1261i);
        function.c(str, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t I(String str, String str2, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        C1261i c1261i2 = f8126c;
        C1261i c1261i3 = f8124a;
        function.b(str2, c1261i, c1261i, c1261i2, c1261i3);
        function.c(str, c1261i3);
        return Y8.t.f7040a;
    }

    public static final Y8.t J(String str, String str2, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        C1261i c1261i2 = f8126c;
        function.b(str, c1261i2);
        C1261i c1261i3 = f8124a;
        function.b(str2, c1261i, c1261i2, c1261i2, c1261i3);
        function.c(str, c1261i3);
        return Y8.t.f7040a;
    }

    public static final Y8.t K(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.c(str, f8124a);
        return Y8.t.f7040a;
    }

    public static final Map<String, f0> K0() {
        return f8127d;
    }

    public static final Y8.t L(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.c(str, f8124a);
        return Y8.t.f7040a;
    }

    public static final Y8.t M(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b, f8126c);
        return Y8.t.f7040a;
    }

    public static final Y8.t N(String str, String str2, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8126c;
        function.b(str, c1261i);
        function.c(str2, f8125b, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t O(String str, String str2, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8124a);
        function.c(str2, f8125b, f8126c);
        return Y8.t.f7040a;
    }

    public static final Y8.t P(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8126c);
        return Y8.t.f7040a;
    }

    public static final Y8.t Q(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b, f8126c);
        return Y8.t.f7040a;
    }

    public static final Y8.t R(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8124a);
        return Y8.t.f7040a;
    }

    public static final Y8.t a(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t b(ba.x xVar, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        String strI = xVar.i("Spliterator");
        C1261i c1261i = f8125b;
        function.c(strI, c1261i, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t c(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        function.d(JvmPrimitiveType.BOOLEAN);
        return Y8.t.f7040a;
    }

    public static final Y8.t d(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.d(JvmPrimitiveType.BOOLEAN);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t f(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t g(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.c(str, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t h(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i);
        function.b(str, c1261i);
        function.c(str, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t i(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t j(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i, c1261i);
        function.d(JvmPrimitiveType.BOOLEAN);
        return Y8.t.f7040a;
    }

    public static final Y8.t k(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.c(str, c1261i, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t l(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.c(str, c1261i, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t m(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        C1261i c1261i = f8125b;
        function.b(str, c1261i, c1261i);
        return Y8.t.f7040a;
    }

    public static final Y8.t n(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t o(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t p(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t q(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t r(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t s(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t t(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t u(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t v(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t w(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.b(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t x(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t y(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }

    public static final Y8.t z(String str, m0.a.C0125a function) {
        kotlin.jvm.internal.p.i(function, "$this$function");
        function.c(str, f8125b);
        return Y8.t.f7040a;
    }
}
