package r8;

import D7.A;
import D7.w;
import e8.n;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import n8.m;

/* renamed from: r8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1883e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5683a = kotlin.collections.a.R(new Pair("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), new Pair("TYPE", EnumSet.of(KotlinTarget.f4972r, KotlinTarget.f4960D)), new Pair("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.f4973s)), new Pair("TYPE_PARAMETER", EnumSet.of(KotlinTarget.f4974t)), new Pair("FIELD", EnumSet.of(KotlinTarget.f4975v)), new Pair("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.f4976w)), new Pair("PARAMETER", EnumSet.of(KotlinTarget.f4977x)), new Pair("CONSTRUCTOR", EnumSet.of(KotlinTarget.y)), new Pair("METHOD", EnumSet.of(KotlinTarget.f4978z, KotlinTarget.f4957A, KotlinTarget.f4958B)), new Pair("TYPE_USE", EnumSet.of(KotlinTarget.f4959C)));
    public static final Object b = kotlin.collections.a.R(new Pair("RUNTIME", KotlinRetention.f4956a), new Pair("CLASS", KotlinRetention.b), new Pair("SOURCE", KotlinRetention.c));

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    public static L8.b a(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof m) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterable iterable = (EnumSet) f5683a.get(G8.f.e(((m) it.next()).b.name()).b());
            if (iterable == null) {
                iterable = EmptySet.f4895a;
            }
            A.e0(iterable, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(w.c0(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            KotlinTarget kotlinTarget = (KotlinTarget) it2.next();
            G8.c topLevelFqName = n.u;
            k.f(topLevelFqName, "topLevelFqName");
            G8.c cVarE = topLevelFqName.e();
            G8.f fVarF = topLevelFqName.f();
            k.e(fVarF, "shortName(...)");
            arrayList3.add(new L8.i(new G8.b(cVarE, fVarF), G8.f.e(kotlinTarget.name())));
        }
        return new L8.b(C1882d.f5682a, arrayList3);
    }
}
