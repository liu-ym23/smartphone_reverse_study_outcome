package y8;

import java.util.LinkedHashMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* renamed from: y8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2146i {

    /* renamed from: a, reason: collision with root package name */
    public static final C2141d f6916a = new C2141d(NullabilityQualifier.b, false);
    public static final C2141d b;
    public static final C2141d c;
    public static final LinkedHashMap d;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.c;
        b = new C2141d(nullabilityQualifier, false);
        c = new C2141d(nullabilityQualifier, true);
        String strConcat = "java/lang/".concat("Object");
        String strConcat2 = "java/util/function/".concat("Predicate");
        String strConcat3 = "java/util/function/".concat("Function");
        String strConcat4 = "java/util/function/".concat("Consumer");
        String strConcat5 = "java/util/function/".concat("BiFunction");
        String strConcat6 = "java/util/function/".concat("BiConsumer");
        String strConcat7 = "java/util/function/".concat("UnaryOperator");
        String strConcat8 = "java/util/".concat("stream/Stream");
        String strConcat9 = "java/util/".concat("Optional");
        v3.b bVar = new v3.b(1);
        new O2.a(bVar, "java/util/".concat("Iterator")).n("forEachRemaining", null, new C2144g(strConcat4, 0));
        new O2.a(bVar, "java/lang/".concat("Iterable")).n("spliterator", null, new C2148k(4));
        O2.a aVar = new O2.a(bVar, "java/util/".concat("Collection"));
        aVar.n("removeIf", null, new C2144g(strConcat2, 15));
        aVar.n("stream", null, new C2144g(strConcat8, 22));
        aVar.n("parallelStream", null, new C2144g(strConcat8, 23));
        O2.a aVar2 = new O2.a(bVar, "java/util/".concat("List"));
        aVar2.n("replaceAll", null, new C2144g(strConcat7, 24));
        aVar2.n("addFirst", "2.1", new C2144g(strConcat, 25));
        aVar2.n("addLast", "2.1", new C2144g(strConcat, 26));
        aVar2.n("removeFirst", "2.1", new C2144g(strConcat, 27));
        aVar2.n("removeLast", "2.1", new C2144g(strConcat, 28));
        O2.a aVar3 = new O2.a(bVar, "java/util/".concat("LinkedList"));
        aVar3.n("addFirst", "2.1", new C2144g(strConcat, 1));
        aVar3.n("addLast", "2.1", new C2144g(strConcat, 2));
        aVar3.n("removeFirst", "2.1", new C2144g(strConcat, 3));
        aVar3.n("removeLast", "2.1", new C2144g(strConcat, 4));
        O2.a aVar4 = new O2.a(bVar, "java/util/".concat("Map"));
        aVar4.n("forEach", null, new C2144g(strConcat6, 5));
        aVar4.n("putIfAbsent", null, new C2144g(strConcat, 6));
        aVar4.n("replace", null, new C2144g(strConcat, 7));
        aVar4.n("replace", null, new C2144g(strConcat, 8));
        aVar4.n("replaceAll", null, new C2144g(strConcat5, 9));
        aVar4.n("compute", null, new C2145h(0, strConcat, strConcat5));
        aVar4.n("computeIfAbsent", null, new C2145h(1, strConcat, strConcat3));
        aVar4.n("computeIfPresent", null, new C2145h(2, strConcat, strConcat5));
        aVar4.n("merge", null, new C2145h(3, strConcat, strConcat5));
        O2.a aVar5 = new O2.a(bVar, strConcat9);
        aVar5.n("empty", null, new C2144g(strConcat9, 10));
        aVar5.n("of", null, new C2145h(4, strConcat, strConcat9));
        aVar5.n("ofNullable", null, new C2145h(5, strConcat, strConcat9));
        aVar5.n("get", null, new C2144g(strConcat, 11));
        aVar5.n("ifPresent", null, new C2144g(strConcat4, 12));
        new O2.a(bVar, "java/lang/".concat("ref/Reference")).n("get", null, new C2144g(strConcat, 13));
        new O2.a(bVar, strConcat2).n("test", null, new C2144g(strConcat, 14));
        new O2.a(bVar, "java/util/function/".concat("BiPredicate")).n("test", null, new C2144g(strConcat, 16));
        new O2.a(bVar, strConcat4).n("accept", null, new C2144g(strConcat, 17));
        new O2.a(bVar, strConcat6).n("accept", null, new C2144g(strConcat, 18));
        new O2.a(bVar, strConcat3).n("apply", null, new C2144g(strConcat, 19));
        new O2.a(bVar, strConcat5).n("apply", null, new C2144g(strConcat, 20));
        new O2.a(bVar, "java/util/function/".concat("Supplier")).n("get", null, new C2144g(strConcat, 21));
        d = bVar.b;
    }
}
