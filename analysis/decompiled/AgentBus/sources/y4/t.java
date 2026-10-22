package y4;

import android.content.Context;
import android.net.nsd.NsdManager;
import b0.g2;
import com.stepos.agentbus.config.AgentBusConfig;
import com.stepos.agentbus.config.EnvProvider;
import com.stepos.agentbus.config.OpenClawGatewayUpstream;
import ia.b0;
import ia.d0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import o4.b3;
import o4.c0;
import o4.f0;
import o4.t1;
import o4.x1;
import o4.y;
import o4.y1;
import o4.y2;
import org.json.JSONArray;
import org.json.JSONObject;
import p.v;
import w7.e0;

/* loaded from: classes.dex */
public final class t implements a {

    /* renamed from: f, reason: collision with root package name */
    public final AgentBusConfig f11652f;

    /* renamed from: g, reason: collision with root package name */
    public final b0 f11653g;

    /* renamed from: h, reason: collision with root package name */
    public final d5.l f11654h;

    /* renamed from: i, reason: collision with root package name */
    public final c5.c f11655i;

    /* renamed from: j, reason: collision with root package name */
    public final k5.a f11656j;

    /* renamed from: k, reason: collision with root package name */
    public final k5.t f11657k;

    /* renamed from: l, reason: collision with root package name */
    public final a3.b f11658l;

    /* renamed from: m, reason: collision with root package name */
    public final h f11659m;

    /* renamed from: n, reason: collision with root package name */
    public final f5.b f11660n;

    /* renamed from: o, reason: collision with root package name */
    public final k5.q f11661o;

    /* renamed from: p, reason: collision with root package name */
    public final s5.e f11662p;

    /* renamed from: q, reason: collision with root package name */
    public final z5.c f11663q;

    /* renamed from: r, reason: collision with root package name */
    public t1 f11664r;

    /* renamed from: s, reason: collision with root package name */
    public y1 f11665s;

    /* renamed from: t, reason: collision with root package name */
    public b3 f11666t;

    /* renamed from: u, reason: collision with root package name */
    public volatile y f11667u;

    public t(Context context, AgentBusConfig agentBusConfig, na.d dVar, d5.l lVar, c5.d dVar2, k5.a aVar, k5.g gVar, a3.b bVar, h hVar, f5.f fVar, a7.d dVar3, s5.e eVar, z5.c cVar) {
        q7.k.e(context, "context");
        q7.k.e(agentBusConfig, "config");
        q7.k.e(dVar, "scope");
        q7.k.e(lVar, "pool");
        q7.k.e(dVar2, "codec");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        q7.k.e(bVar, "capabilityRegistry");
        q7.k.e(fVar, "blobServer");
        q7.k.e(dVar3, "internalBus");
        q7.k.e(eVar, "invokeInterceptor");
        this.f11652f = agentBusConfig;
        this.f11653g = dVar;
        this.f11654h = lVar;
        this.f11655i = dVar2;
        this.f11656j = aVar;
        this.f11657k = gVar;
        this.f11658l = bVar;
        this.f11659m = hVar;
        this.f11660n = fVar;
        this.f11661o = dVar3;
        this.f11662p = eVar;
        this.f11663q = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(y4.t r24, o4.k0 r25, i7.c r26) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.t.b(y4.t, o4.k0, i7.c):java.lang.Object");
    }

    public static LinkedHashMap c(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        q7.k.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, d(jSONObject.opt(next)));
        }
        return linkedHashMap;
    }

    public static Object d(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return c((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        v7.d dVarN = nb.i.N(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(d7.t.A0(dVarN, 10));
        Iterator it = dVarN.iterator();
        while (true) {
            v7.c cVar = (v7.c) it;
            if (!cVar.f10528h) {
                return arrayList;
            }
            arrayList.add(d(jSONArray.opt(cVar.nextInt())));
        }
    }

    @Override // y4.a
    public final void a() {
        x1 x1Var;
        NsdManager nsdManager;
        t1 t1Var = this.f11664r;
        g7.d dVar = null;
        if (t1Var != null) {
            t1Var.E = null;
            t1Var.d("disconnect");
            t1Var.f7596x.t();
            t1Var.f7597y.t();
        }
        y1 y1Var = this.f11665s;
        if (y1Var != null && (x1Var = (x1) y1Var.f7705f) != null && (nsdManager = (NsdManager) y1Var.f7700a) != null) {
            y1Var.f7705f = null;
            try {
                nsdManager.stopServiceDiscovery(x1Var);
            } catch (Throwable th) {
                e0.n(th);
            }
        }
        b3 b3Var = this.f11666t;
        if (b3Var != null) {
            d0.s(this.f11653g, null, null, new y2(b3Var, dVar, 3), 3);
            this.f11654h.h(b3Var.f7284a);
        }
        this.f11666t = null;
    }

    @Override // y4.a
    public final void start() {
        OpenClawGatewayUpstream openclaw = this.f11652f.getGateway().getOpenclaw();
        v vVar = new v(this, (g7.d) null, 15);
        q7.k.e(openclaw, "cfg");
        h hVar = this.f11659m;
        b0 b0Var = hVar.f11568b;
        Context context = hVar.f11567a;
        File filesDir = context.getFilesDir();
        q7.k.d(filesDir, "getFilesDir(...)");
        int i2 = 1;
        g7.d dVar = null;
        t1 t1Var = new t1(b0Var, new c0(context, n7.l.O(filesDir, openclaw.getDeviceKeyFile())), new o4.d0(context, 0), new d(hVar, 3), new c(hVar, 0), new d(hVar, 0), null, vVar, new b0.y(6, hVar, "openclaw-edge"), new b(hVar, 1), hVar.f11569c, new b(hVar, 2), true, new f0(i2, dVar, 0), new f0(i2, dVar, 1), new f0(i2, dVar, 2), null, null, EnvProvider.INSTANCE.getPROD(), new b0.d0(15), null, null);
        this.f11664r = t1Var;
        q qVar = new q(this, 0);
        q qVar2 = new q(this, 1);
        k5.q qVar3 = this.f11661o;
        a3.b bVar = this.f11658l;
        k5.t tVar = this.f11657k;
        b0 b0Var2 = this.f11653g;
        y1 y1Var = new y1(qVar3, bVar, qVar, tVar, b0Var2, qVar2);
        ((a7.d) qVar3).J(k5.h.class, b0Var2, new v(y1Var, dVar, 12));
        d0.s(this.f11653g, null, null, new g2(this, openclaw, t1Var, y1Var, null, 10), 3);
    }
}
