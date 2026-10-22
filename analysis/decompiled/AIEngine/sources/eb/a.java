package eb;

import cb.j;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.c;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2core.Reason;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f8627a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    public volatile List<? extends Download> f8628b;

    public a() {
        EmptyList emptyList = EmptyList.f10001a;
    }

    public final void a(List<? extends Download> downloads, Download download, Reason reason) {
        g.f(downloads, "downloads");
        g.f(reason, "reason");
        this.f8628b = downloads;
        ArrayList arrayList = new ArrayList();
        for (Object obj : downloads) {
            if (((Download) obj).getStatus() == Status.f8190d) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : downloads) {
            if (((Download) obj2).getStatus() == Status.f8197o) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : downloads) {
            if (((Download) obj3).getStatus() == Status.h) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : downloads) {
            if (((Download) obj4).getStatus() == Status.f8191e) {
                arrayList4.add(obj4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj5 : downloads) {
            if (((Download) obj5).getStatus() == Status.f8192j) {
                arrayList5.add(obj5);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj6 : downloads) {
            if (((Download) obj6).getStatus() == Status.f8193k) {
                arrayList6.add(obj6);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        for (Object obj7 : downloads) {
            if (((Download) obj7).getStatus() == Status.f8194l) {
                arrayList7.add(obj7);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj8 : downloads) {
            if (((Download) obj8).getStatus() == Status.f8196n) {
                arrayList8.add(obj8);
            }
        }
        ArrayList arrayList9 = new ArrayList();
        for (Object obj9 : downloads) {
            if (((Download) obj9).getStatus() == Status.f8195m) {
                arrayList9.add(obj9);
            }
        }
        if (reason != Reason.f8228o) {
            j.f3349c.post(new c(this, downloads, reason, download));
        }
    }
}
