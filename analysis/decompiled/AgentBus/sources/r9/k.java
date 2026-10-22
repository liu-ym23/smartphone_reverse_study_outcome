package r9;

import com.stepos.agentbus.config.AgentBusConfig;
import ia.b0;
import ia.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k implements y4.a {

    /* renamed from: f, reason: collision with root package name */
    public final Object f9070f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f9071g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f9072h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f9073i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f9074j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f9075k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f9076l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f9077m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f9078n;

    public k(AgentBusConfig agentBusConfig, na.d dVar, d5.l lVar, c5.d dVar2, s9.d dVar3, k5.a aVar, k5.g gVar, a7.d dVar4) {
        q7.k.e(agentBusConfig, "config");
        q7.k.e(dVar, "scope");
        q7.k.e(lVar, "pool");
        q7.k.e(dVar2, "codec");
        q7.k.e(dVar3, "validator");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        q7.k.e(dVar4, "internalBus");
        this.f9070f = agentBusConfig;
        this.f9071g = dVar;
        this.f9072h = lVar;
        this.f9073i = dVar2;
        this.f9074j = dVar3;
        this.f9075k = aVar;
        this.f9076l = gVar;
        this.f9077m = dVar4;
        this.f9078n = new ArrayList();
    }

    @Override // y4.a
    public void a() {
        ArrayList arrayList = (ArrayList) this.f9078n;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d0.s((b0) this.f9071g, null, null, new d5.y((d5.z) it.next(), null, 1), 3);
        }
        arrayList.clear();
    }

    public k b(f8.j jVar, List list, b9.f fVar, b9.g gVar, b9.h hVar, b9.a aVar) {
        q7.k.e(list, "typeParameterProtos");
        q7.k.e(fVar, "nameResolver");
        q7.k.e(hVar, "versionRequirementTable");
        q7.k.e(aVar, "metadataVersion");
        i iVar = (i) this.f9070f;
        int i2 = aVar.f1550b;
        return new k(iVar, fVar, jVar, gVar, ((i2 != 1 || aVar.f1551c < 4) && i2 <= 1) ? (b9.h) this.f9074j : hVar, aVar, (t9.j) this.f9076l, (a7.g) this.f9077m, list);
    }

    public void d(String str, d5.t tVar, a3.b bVar) {
        d5.m mVar = d5.m.GATEWAY;
        c5.c cVar = (c5.c) this.f9073i;
        s9.d dVar = (s9.d) this.f9074j;
        d5.c cVar2 = new d5.c(str, a.a.S("stepclaw.routing.v1"));
        AgentBusConfig agentBusConfig = (AgentBusConfig) this.f9070f;
        d5.z zVar = new d5.z(str, mVar, tVar, bVar, cVar, dVar, cVar2, new d5.s(agentBusConfig.getCloud().getReconnect().getInitialDelayMs(), agentBusConfig.getCloud().getReconnect().getMaxDelayMs(), agentBusConfig.getCloud().getReconnect().getBackoffMultiplier()), (k5.a) this.f9075k, (k5.t) this.f9076l, (k5.q) this.f9077m);
        ((ArrayList) this.f9078n).add(zVar);
        ((d5.l) this.f9072h).f(zVar);
        if (zVar.f2941o != null) {
            return;
        }
        zVar.f2941o = d0.s(zVar.f2937k, null, null, new d5.y(zVar, null, 0), 3);
    }

    @Override // y4.a
    public void start() {
        d5.t tVar = d5.t.EDGE;
        AgentBusConfig agentBusConfig = (AgentBusConfig) this.f9070f;
        String str = "ws://" + agentBusConfig.getEdge().getHost() + ":" + agentBusConfig.getEdge().getPort() + "/ws";
        long connectTimeoutMs = agentBusConfig.getEdge().getConnectTimeoutMs();
        long readTimeoutMs = agentBusConfig.getTimeouts().getReadTimeoutMs();
        c6.m mVar = c6.m.WS;
        d("stepclaw.agentbus.edge", tVar, new a3.b(str, connectTimeoutMs, readTimeoutMs, mVar, (k5.a) this.f9075k, (k5.t) this.f9076l));
        d5.t tVar2 = d5.t.CLOUD;
        String url = agentBusConfig.getCloud().getUrl();
        long connectTimeoutMs2 = agentBusConfig.getCloud().getConnectTimeoutMs();
        long readTimeoutMs2 = agentBusConfig.getTimeouts().getReadTimeoutMs();
        if (ga.r.g0(agentBusConfig.getCloud().getUrl(), "wss", false)) {
            mVar = c6.m.WSS;
        }
        d("stepclaw.agentbus.cloud", tVar2, new a3.b(url, connectTimeoutMs2, readTimeoutMs2, mVar, (k5.a) this.f9075k, (k5.t) this.f9076l));
    }

    public k(i iVar, b9.f fVar, f8.j jVar, b9.g gVar, b9.h hVar, b9.a aVar, t9.j jVar2, a7.g gVar2, List list) {
        String strJ;
        q7.k.e(iVar, "components");
        q7.k.e(fVar, "nameResolver");
        q7.k.e(jVar, "containingDeclaration");
        q7.k.e(hVar, "versionRequirementTable");
        q7.k.e(aVar, "metadataVersion");
        q7.k.e(list, "typeParameters");
        this.f9070f = iVar;
        this.f9071g = fVar;
        this.f9072h = jVar;
        this.f9073i = gVar;
        this.f9074j = hVar;
        this.f9075k = aVar;
        this.f9076l = jVar2;
        this.f9077m = new a7.g(this, gVar2, list, "Deserializer for \"" + jVar.getName() + '\"', (jVar2 == null || (strJ = jVar2.j()) == null) ? "[container not found]" : strJ);
        this.f9078n = new r(this);
    }
}
