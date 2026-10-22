package w8;

import androidx.lifecycle.s0;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final e f10907a = new e(h.f10899g, false);

    /* renamed from: b, reason: collision with root package name */
    public static final e f10908b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f10909c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f10910d;

    static {
        h hVar = h.f10900h;
        f10908b = new e(hVar, false);
        f10909c = new e(hVar, true);
        String strConcat = "java/lang/".concat("Object");
        String strConcat2 = "java/util/function/".concat("Predicate");
        String strConcat3 = "java/util/function/".concat("Function");
        String strConcat4 = "java/util/function/".concat("Consumer");
        String strConcat5 = "java/util/function/".concat("BiFunction");
        String strConcat6 = "java/util/function/".concat("BiConsumer");
        String strConcat7 = "java/util/function/".concat("UnaryOperator");
        String strConcat8 = "java/util/".concat("stream/Stream");
        String strConcat9 = "java/util/".concat("Optional");
        s0 s0Var = new s0(3);
        new nb.f(s0Var, "java/util/".concat("Iterator")).v("forEachRemaining", new p1.l(strConcat4, 1));
        new nb.f(s0Var, "java/lang/".concat("Iterable")).v("spliterator", new m(1, 4));
        nb.f fVar = new nb.f(s0Var, "java/util/".concat("Collection"));
        fVar.v("removeIf", new p1.l(strConcat2, 7));
        fVar.v("stream", new p1.l(strConcat8, 8));
        fVar.v("parallelStream", new p1.l(strConcat8, 9));
        new nb.f(s0Var, "java/util/".concat("List")).v("replaceAll", new p1.l(strConcat7, 10));
        nb.f fVar2 = new nb.f(s0Var, "java/util/".concat("Map"));
        fVar2.v("forEach", new p1.l(strConcat6, 11));
        fVar2.v("putIfAbsent", new p1.l(strConcat, 12));
        fVar2.v("replace", new p1.l(strConcat, 13));
        fVar2.v("replace", new p1.l(strConcat, 14));
        fVar2.v("replaceAll", new p1.l(strConcat5, 15));
        fVar2.v("compute", new j(strConcat, strConcat5, 0));
        fVar2.v("computeIfAbsent", new j(strConcat, strConcat3, 1));
        fVar2.v("computeIfPresent", new j(strConcat, strConcat5, 2));
        fVar2.v("merge", new j(strConcat, strConcat5, 3));
        nb.f fVar3 = new nb.f(s0Var, strConcat9);
        fVar3.v("empty", new p1.l(strConcat9, 16));
        fVar3.v("of", new j(strConcat, strConcat9, 4));
        fVar3.v("ofNullable", new j(strConcat, strConcat9, 5));
        fVar3.v("get", new p1.l(strConcat, 17));
        fVar3.v("ifPresent", new p1.l(strConcat4, 18));
        new nb.f(s0Var, "java/lang/".concat("ref/Reference")).v("get", new p1.l(strConcat, 19));
        new nb.f(s0Var, strConcat2).v("test", new p1.l(strConcat, 20));
        new nb.f(s0Var, "java/util/function/".concat("BiPredicate")).v("test", new p1.l(strConcat, 21));
        new nb.f(s0Var, strConcat4).v("accept", new p1.l(strConcat, 2));
        new nb.f(s0Var, strConcat6).v("accept", new p1.l(strConcat, 3));
        new nb.f(s0Var, strConcat3).v("apply", new p1.l(strConcat, 4));
        new nb.f(s0Var, strConcat5).v("apply", new p1.l(strConcat, 5));
        new nb.f(s0Var, "java/util/function/".concat("Supplier")).v("get", new p1.l(strConcat, 6));
        f10910d = s0Var.f1030a;
    }
}
