package androidx.work.impl.constraints;

import android.content.Context;
import android.net.ConnectivityManager;
import h2.j;
import java.util.ArrayList;
import kotlin.jvm.internal.g;
import mb.l;
import n2.c;
import n2.d;
import n2.e;
import n2.f;
import o2.n;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkConstraintsTracker {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2914a;

    public WorkConstraintsTracker(n trackers) {
        g.f(trackers, "trackers");
        n2.a aVar = new n2.a(trackers.f10733b, 0);
        n2.b bVar = new n2.b(trackers.f10734c);
        n2.a aVar2 = new n2.a(trackers.f10736e, 1);
        o2.g<m2.b> gVar = trackers.f10735d;
        d dVar = new d(gVar);
        n2.g gVar2 = new n2.g(gVar);
        f fVar = new f(gVar);
        e eVar = new e(gVar);
        Context context = trackers.f10732a;
        String str = WorkConstraintsTrackerKt.f2921a;
        g.f(context, "context");
        Object systemService = context.getSystemService("connectivity");
        g.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f2914a = l.d0(new c[]{aVar, bVar, aVar2, dVar, gVar2, fVar, eVar, new NetworkRequestConstraintController((ConnectivityManager) systemService)});
    }

    public final boolean a(p pVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2914a;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            if (((c) obj).a(pVar)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            j.d().a(WorkConstraintsTrackerKt.f2921a, "Work " + pVar.f11505a + " constrained by " + kotlin.collections.a.z0(arrayList, null, null, null, new zb.l<c, CharSequence>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$areAllConstraintsMet$1
                @Override // zb.l
                public final CharSequence invoke(c cVar) {
                    c it = cVar;
                    g.f(it, "it");
                    return it.getClass().getSimpleName();
                }
            }, 31));
        }
        return arrayList.isEmpty();
    }
}
