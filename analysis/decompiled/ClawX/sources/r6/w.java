package r6;

import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final n6.a f5213a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.m f5214b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5215c;
    public final List d;

    /* renamed from: e, reason: collision with root package name */
    public int f5216e;

    /* renamed from: f, reason: collision with root package name */
    public Object f5217f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f5218g;

    public w(n6.a aVar, androidx.emoji2.text.m routeDatabase, o oVar, boolean z) {
        List listK;
        kotlin.jvm.internal.p.e(routeDatabase, "routeDatabase");
        this.f5213a = aVar;
        this.f5214b = routeDatabase;
        this.f5215c = z;
        c5.s sVar = c5.s.f1092a;
        this.d = sVar;
        this.f5217f = sVar;
        this.f5218g = new ArrayList();
        n6.m url = aVar.f3992h;
        kotlin.jvm.internal.p.e(url, "url");
        URI uriG = url.g();
        if (uriG.getHost() == null) {
            listK = o6.f.k(new Proxy[]{Proxy.NO_PROXY});
        } else {
            List<Proxy> listSelect = aVar.f3991g.select(uriG);
            listK = (listSelect == null || listSelect.isEmpty()) ? o6.f.k(new Proxy[]{Proxy.NO_PROXY}) : o6.f.j(listSelect);
        }
        this.d = listK;
        this.f5216e = 0;
    }

    public final boolean a() {
        return this.f5216e < this.d.size() || !this.f5218g.isEmpty();
    }
}
