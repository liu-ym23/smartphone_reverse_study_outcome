package stepos.support.v7.app.palette;

import B0.g;
import B0.r;
import android.app.Application;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.appcompat.app.o;
import com.google.android.gms.common.api.internal.s;
import com.google.android.material.internal.m;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s0.t;
import x0.f;
import x0.k;
import y0.C0985a;
import z0.AbstractC0998f;
import z0.l;

/* loaded from: classes2.dex */
public final class b implements K0.d {

    /* renamed from: b, reason: collision with root package name */
    public static b f14576b;

    /* renamed from: a, reason: collision with root package name */
    public final List f14577a;

    public b(int i4, List controllers) {
        if (i4 == 2) {
            this.f14577a = controllers;
        } else {
            Intrinsics.checkNotNullParameter(controllers, "controllers");
            this.f14577a = controllers;
        }
    }

    public static synchronized b d() {
        try {
            if (f14576b == null) {
                f14576b = new b(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f14576b;
    }

    public final void a(Application application, String str, String str2, Map map, int i4) {
        StringBuilder sbX = g.x("onActionXEvent, eventName: ", str, ", pageName: ", str2, ", properties: ");
        sbX.append(map);
        sbX.append(", sendType: ");
        sbX.append(i4);
        sbX.append(", replaceMap: null");
        T2.d.a("EventController", sbX.toString());
        if (TextUtils.isEmpty(str)) {
            T2.d.b("EventController", "onActionXEvent fail, eventName is empty");
            return;
        }
        H2.a aVar = new H2.a(application, str, str2, map);
        O2.b bVar = new O2.b();
        bVar.f1542a = aVar;
        bVar.f1543b = i4;
        bVar.f1544c = null;
        L2.c cVar = L2.b.f1231a;
        s sVar = cVar.f1236e;
        if (sVar != null) {
            T2.d.a("EventController", "send success");
            ((ThreadPoolExecutor) R2.a.f1659a.f9664b).execute(new o(18, sVar, bVar));
            return;
        }
        T2.d.f("EventController", "send fail, tracker is null");
        synchronized (this) {
            if (this.f14577a.size() < 300) {
                this.f14577a.add(bVar);
            } else {
                T2.d.f("EventController", "fail event data list is already full");
            }
        }
        ((ThreadPoolExecutor) R2.a.f1659a.f9664b).execute(new m(2, cVar, false));
    }

    public final boolean b(r workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        List list = this.f14577a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            y0.d dVar = (y0.d) obj;
            dVar.getClass();
            Intrinsics.checkNotNullParameter(workSpec, "workSpec");
            if (dVar.b(workSpec) && dVar.c(dVar.f16170a.a())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            t.d().a(k.f15888a, "Work " + workSpec.f167a + " constrained by " + CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, f.f15875a, 31, null));
        }
        return arrayList.isEmpty();
    }

    @Override // K0.d
    public final H0.b c() {
        List list = this.f14577a;
        return ((Q0.a) list.get(0)).f1629d == null ? new H0.d(1, list) : new H0.g(list);
    }

    public final void e(int i4) {
        Iterator it = this.f14577a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i4);
        }
    }

    public b(l trackers) {
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        C0985a c0985a = new C0985a(trackers.f16408a, 0);
        C0985a c0985a2 = new C0985a(trackers.f16409b);
        C0985a c0985a3 = new C0985a(trackers.f16411d, 4);
        AbstractC0998f abstractC0998f = trackers.f16410c;
        this(1, CollectionsKt.listOf((Object[]) new y0.d[]{c0985a, c0985a2, c0985a3, new C0985a(abstractC0998f, 2), new C0985a(abstractC0998f, 3), new y0.g(abstractC0998f), new y0.f(abstractC0998f)}));
    }

    public b(int i4) {
        if (i4 == 2) {
            this.f14577a = Collections.singletonList(new Q0.a(new PointF(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE)));
            return;
        }
        if (i4 == 3) {
            this.f14577a = new ArrayList();
        } else if (i4 != 4) {
            this.f14577a = new ArrayList();
        } else {
            this.f14577a = new ArrayList();
        }
    }
}
