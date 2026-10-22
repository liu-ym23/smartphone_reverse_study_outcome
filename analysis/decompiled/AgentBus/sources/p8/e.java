package p8;

import c8.m;
import d7.b0;
import d7.e0;
import d7.x;
import g8.o;
import g8.p;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import l8.t;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f8513a = e0.U(new c7.j("PACKAGE", EnumSet.noneOf(p.class)), new c7.j("TYPE", EnumSet.of(p.CLASS, p.FILE)), new c7.j("ANNOTATION_TYPE", EnumSet.of(p.ANNOTATION_CLASS)), new c7.j("TYPE_PARAMETER", EnumSet.of(p.TYPE_PARAMETER)), new c7.j("FIELD", EnumSet.of(p.FIELD)), new c7.j("LOCAL_VARIABLE", EnumSet.of(p.LOCAL_VARIABLE)), new c7.j("PARAMETER", EnumSet.of(p.VALUE_PARAMETER)), new c7.j("CONSTRUCTOR", EnumSet.of(p.CONSTRUCTOR)), new c7.j("METHOD", EnumSet.of(p.FUNCTION, p.PROPERTY_GETTER, p.PROPERTY_SETTER)), new c7.j("TYPE_USE", EnumSet.of(p.TYPE)));

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8514b = e0.U(new c7.j("RUNTIME", o.f3898f), new c7.j("CLASS", o.f3899g), new c7.j("SOURCE", o.f3900h));

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    public static j9.b a(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof t) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterable iterable = (EnumSet) f8513a.get(e9.f.e(((t) it.next()).f5883b.name()).b());
            if (iterable == null) {
                iterable = b0.f2947f;
            }
            x.D0(arrayList2, iterable);
        }
        ArrayList arrayList3 = new ArrayList(d7.t.A0(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(new j9.i(e9.b.j(m.f2050u), e9.f.e(((p) it2.next()).name())));
        }
        return new j9.b(arrayList3, d.f8512g);
    }
}
