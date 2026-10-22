package okhttp3.internal.connection;

import bd.l;
import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f11088a;

    /* renamed from: b, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f11089b;

    /* renamed from: c, reason: collision with root package name */
    public final ed.c f11090c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11091d;

    /* renamed from: e, reason: collision with root package name */
    public final List<? extends Proxy> f11092e;

    /* renamed from: f, reason: collision with root package name */
    public int f11093f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11094g;
    public final ArrayList h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f11095a;

        /* renamed from: b, reason: collision with root package name */
        public int f11096b;

        public a(ArrayList arrayList) {
            this.f11095a = arrayList;
        }
    }

    public i(okhttp3.a address, stepos.support.v7.app.palette.b routeDatabase, ed.c connectionUser, boolean z) {
        List<? extends Proxy> listF;
        kotlin.jvm.internal.g.f(address, "address");
        kotlin.jvm.internal.g.f(routeDatabase, "routeDatabase");
        kotlin.jvm.internal.g.f(connectionUser, "connectionUser");
        this.f11088a = address;
        this.f11089b = routeDatabase;
        this.f11090c = connectionUser;
        this.f11091d = z;
        EmptyList emptyList = EmptyList.f10001a;
        this.f11092e = emptyList;
        this.f11094g = emptyList;
        this.h = new ArrayList();
        okhttp3.g gVar = address.h;
        connectionUser.d(gVar);
        URI uriJ = gVar.j();
        if (uriJ.getHost() == null) {
            listF = l.f(Proxy.NO_PROXY);
        } else {
            List<Proxy> listSelect = address.f10929g.select(uriJ);
            listF = (listSelect == null || listSelect.isEmpty()) ? l.f(Proxy.NO_PROXY) : l.l(listSelect);
        }
        this.f11092e = listF;
        this.f11093f = 0;
        connectionUser.e(gVar, listF);
    }

    public final boolean a() {
        return this.f11093f < this.f11092e.size() || !this.h.isEmpty();
    }
}
