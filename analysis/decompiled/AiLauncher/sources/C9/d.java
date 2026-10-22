package C9;

import C9.o;
import Z8.C1174w;
import Z8.F;
import ga.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1773a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<ga.b> f1774b;

    static {
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        ArrayList arrayList = new ArrayList(C1174w.x(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(o.c((PrimitiveType) it.next()));
        }
        List listT0 = F.T0(F.T0(F.T0(arrayList, o.a.f1908h.m()), o.a.f1912j.m()), o.a.f1930s.m());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b.a aVar = ga.b.f32721d;
        Iterator it2 = listT0.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(aVar.c((ga.c) it2.next()));
        }
        f1774b = linkedHashSet;
    }

    public final Set<ga.b> a() {
        return f1774b;
    }

    public final Set<ga.b> b() {
        return f1774b;
    }
}
