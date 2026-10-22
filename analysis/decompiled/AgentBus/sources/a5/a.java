package a5;

import android.content.Context;
import android.content.SharedPreferences;
import b0.b2;
import b0.d2;
import b0.j2;
import b0.x;
import c7.m;
import c7.r;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import com.stepos.agentbus.config.AgentBusConfig;
import com.stepos.agentbus.config.ConfigManager;
import i5.l;
import ia.d0;
import ia.g1;
import ia.h0;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import k.b0;
import k.y;
import k5.s;
import k5.t;
import l0.w;
import la.u0;
import o4.b3;
import o4.c0;
import o4.t1;
import org.json.JSONObject;
import p.v;
import q7.a0;
import v1.q;
import w7.e0;
import w7.u;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f208f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f209g;

    public /* synthetic */ a(int i2, Object obj) {
        this.f208f = i2;
        this.f209g = obj;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        Object objN;
        Object objN2;
        String strA;
        String lowerCase;
        String lowerCase2;
        String strName;
        switch (this.f208f) {
            case 0:
                i5.f fVar = (i5.f) this.f209g;
                y5.a aVar = (y5.a) obj;
                q7.k.e(aVar, "event");
                s.info$default((t) fVar.f4656j, "BffPushBridge", a1.a.k("bff wake: packageName=", aVar.f11668a, " traceId=", aVar.f11669b), null, 4, null);
                x4.i iVar = ((v4.a) fVar.f4653g).f10391g.f10458x;
                g7.d dVar = null;
                if (iVar == null) {
                    s.info$default((t) fVar.f4656j, "BffPushBridge", "bff bridge disabled, wake skipped", null, 4, null);
                } else if (iVar.f11188h.get()) {
                    d0.s(iVar.f11187g, null, null, new x4.e(2, dVar, iVar), 3);
                }
                d0.s((na.d) fVar.f4655i, null, null, new b(fVar, aVar, dVar, 0), 3);
                return r.f1986a;
            case 1:
                l lVar = (l) this.f209g;
                y5.c cVar = (y5.c) obj;
                r rVar = r.f1986a;
                q7.k.e(cVar, "event");
                d dVar2 = (d) lVar.f4689i;
                long jLongValue = ((Number) dVar2.f216b.c()).longValue();
                long j2 = dVar2.f217c;
                if (j2 == -1 || jLongValue - j2 >= dVar2.f215a) {
                    dVar2.f217c = jLongValue;
                    s.info$default((t) lVar.f4688h, "CloudWakePushBridge", a1.a.w("cloud wake: traceId=", cVar.f11677a), null, 4, null);
                    try {
                        ((v4.a) lVar.f4687g).c();
                        objN = rVar;
                    } catch (Throwable th) {
                        objN = e0.n(th);
                    }
                    Throwable thA = m.a(objN);
                    if (thA != null) {
                        s.warn$default((t) lVar.f4688h, "CloudWakePushBridge", a1.a.w("cloud wake reconnect failed: ", thA.getMessage()), null, 4, null);
                    }
                } else {
                    s.debug$default((t) lVar.f4688h, "CloudWakePushBridge", a1.a.w("cloud wake throttled traceId=", cVar.f11677a), null, 4, null);
                }
                return rVar;
            case 2:
                h hVar = (h) this.f209g;
                y5.b bVar = (y5.b) obj;
                q7.k.e(bVar, "event");
                z5.c cVar2 = hVar.f248i;
                if (cVar2 != null) {
                    String str = bVar.f11675f;
                    String str2 = bVar.f11676g;
                    String str3 = bVar.f11671b;
                    if (str3.length() == 0) {
                        str3 = bVar.f11672c;
                    }
                    cVar2.l(str, str2, str3, bVar.f11673d, ga.k.L0(500, bVar.f11674e), "tool_push_received", null);
                }
                d0.s(hVar.f244e, null, null, new b(hVar, bVar, null, 1), 3);
                return r.f1986a;
            case 3:
                ((x) this.f209g).u(obj);
                return r.f1986a;
            case 4:
                j2 j2Var = (j2) this.f209g;
                Throwable th2 = (Throwable) obj;
                CancellationException cancellationException = new CancellationException("Recomposer effect job completed");
                cancellationException.initCause(th2);
                synchronized (j2Var.f1207b) {
                    try {
                        g1 g1Var = j2Var.f1208c;
                        if (g1Var != null) {
                            u0 u0Var = j2Var.f1225t;
                            d2 d2Var = d2.f1124g;
                            u0Var.getClass();
                            u0Var.g(null, d2Var);
                            g1Var.d(cancellationException);
                            j2Var.f1222q = null;
                            g1Var.t(new b2(1, j2Var, th2));
                        } else {
                            j2Var.f1209d = cancellationException;
                            u0 u0Var2 = j2Var.f1225t;
                            d2 d2Var2 = d2.f1123f;
                            u0Var2.getClass();
                            u0Var2.g(null, d2Var2);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return r.f1986a;
            case 5:
                b0 b0Var = (b0) this.f209g;
                if (obj instanceof w) {
                    ((w) obj).d(4);
                }
                b0Var.a(obj);
                return r.f1986a;
            case 6:
                return ConfigManager.handleUpdate$lambda$2$lambda$1((AgentBusConfig) this.f209g, (AgentBusConfig) obj);
            case 7:
                d.f fVar2 = (d.f) this.f209g;
                fVar2.a(true);
                return new d.c((z2.e) obj, fVar2);
            case 8:
                return obj == ((d7.a) this.f209g) ? "(this Collection)" : String.valueOf(obj);
            case 9:
                d7.g gVar = (d7.g) this.f209g;
                Map.Entry entry = (Map.Entry) obj;
                q7.k.e(entry, "it");
                StringBuilder sb2 = new StringBuilder();
                Object key = entry.getKey();
                sb2.append(key == gVar ? "(this Map)" : String.valueOf(key));
                sb2.append('=');
                Object value = entry.getValue();
                sb2.append(value != gVar ? String.valueOf(value) : "(this Map)");
                return sb2.toString();
            case 10:
                eb.k kVar = (eb.k) this.f209g;
                q7.k.e(obj, "it");
                return kVar.c();
            case 11:
                l0.f fVar3 = (l0.f) ((p7.k) this.f209g).invoke((l0.k) obj);
                synchronized (l0.m.f5774c) {
                    l0.m.f5775d = l0.m.f5775d.j(fVar3.g());
                }
                return fVar3;
            case 12:
                l0.t tVar = (l0.t) this.f209g;
                synchronized (tVar.f5805g) {
                    l0.s sVar = tVar.f5807i;
                    q7.k.b(sVar);
                    Object obj2 = sVar.f5788b;
                    q7.k.b(obj2);
                    int i2 = sVar.f5790d;
                    y yVar = sVar.f5789c;
                    if (yVar == null) {
                        yVar = new y();
                        sVar.f5789c = yVar;
                        sVar.f5792f.l(obj2, yVar);
                    }
                    sVar.c(obj, i2, obj2, yVar);
                }
                return r.f1986a;
            case 13:
                a6.d dVar3 = (a6.d) this.f209g;
                Map map = (Map) obj;
                q7.k.e(map, "it");
                Object obj3 = map.get("jobId");
                return Boolean.valueOf(q7.k.a(obj3 instanceof String ? (String) obj3 : null, dVar3.f295a));
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                a6.h hVar2 = (a6.h) this.f209g;
                Map map2 = (Map) obj;
                q7.k.e(map2, "m");
                String str4 = hVar2.f319a;
                Map map3 = hVar2.f323e;
                map2.put("id", str4);
                map2.put("version", hVar2.f320b);
                String lowerCase3 = hVar2.f322d.name().toLowerCase(Locale.ROOT);
                q7.k.d(lowerCase3, "toLowerCase(...)");
                map2.put("source", lowerCase3);
                String str5 = hVar2.f324f;
                if (str5 != null) {
                    map2.put("catalog_description", str5);
                }
                if (!map3.isEmpty()) {
                    map2.put("extension", map3);
                }
                return r.f1986a;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                JSONObject jSONObject = (JSONObject) this.f209g;
                String str6 = (String) obj;
                q7.k.e(str6, "it");
                return jSONObject.optString(str6);
            case 16:
                t1 t1Var = (t1) this.f209g;
                long jLongValue2 = ((Long) obj).longValue();
                s.warn$default(t1Var.f7583k, "OpenClawGateway", "screen off: pending activity still present after " + jLongValue2 + "ms; settle anyway", null, 4, null);
                return r.f1986a;
            case 17:
                o4.c cVar3 = (o4.c) this.f209g;
                byte[] bArr = (byte[]) obj;
                q7.k.e(bArr, "payload");
                q7.k.e(cVar3, "identity");
                try {
                    n7.c cVar4 = new n7.c();
                    sb.d dVar4 = new sb.d(cVar3.f7303c);
                    ((qb.c) qb.d.f8836a.get()).getClass();
                    cVar4.reset();
                    cVar4.write(bArr, 0, bArr.length);
                    objN2 = c0.f7304e.encodeToString(cVar4.a(dVar4));
                } catch (Throwable th4) {
                    objN2 = e0.n(th4);
                }
                if (objN2 instanceof c7.l) {
                    objN2 = null;
                }
                return (String) objN2;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                b3 b3Var = (b3) this.f209g;
                Map map4 = (Map) obj;
                q7.k.e(map4, "payload");
                b3Var.f7297n.M(s9.d.p("stepclaw.trace.node", map4));
                return r.f1986a;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                q7.b0 b0Var2 = (q7.b0) this.f209g;
                w7.x xVar = (w7.x) obj;
                q7.k.e(xVar, "it");
                b0Var2.getClass();
                w7.y yVar2 = xVar.f10875a;
                u uVar = xVar.f10876b;
                if (yVar2 == null) {
                    return "*";
                }
                q7.b0 b0Var3 = uVar instanceof q7.b0 ? (q7.b0) uVar : null;
                String strValueOf = (b0Var3 == null || (strA = b0Var3.a(true)) == null) ? String.valueOf(uVar) : strA;
                int i10 = a0.$EnumSwitchMapping$0[yVar2.ordinal()];
                if (i10 == 1) {
                    return strValueOf;
                }
                if (i10 == 2) {
                    return "in ".concat(strValueOf);
                }
                if (i10 == 3) {
                    return "out ".concat(strValueOf);
                }
                throw new a4.u();
            case 20:
                d0.e(((u4.h) this.f209g).f10072d, null);
                return r.f1986a;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                q qVar = (q) obj;
                return ((v1.e) this.f209g).a(new q(null, qVar.f10372b, qVar.f10373c, qVar.f10374d, qVar.f10375e)).f10376f;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                v4.k kVar2 = (v4.k) this.f209g;
                c5.b bVar2 = (c5.b) obj;
                q7.k.e(bVar2, "frame");
                d5.t tVar2 = null;
                if (!q7.k.a(bVar2.d(), "admin.route.preference")) {
                    return null;
                }
                u5.h hVar3 = kVar2.f10455u;
                hVar3.getClass();
                Map mapG = bVar2.g();
                Object obj4 = mapG != null ? mapG.get("mode") : null;
                String str7 = obj4 instanceof String ? (String) obj4 : null;
                if (str7 != null) {
                    lowerCase = str7.toLowerCase(Locale.ROOT);
                    q7.k.d(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                if (q7.k.a(lowerCase, "cloud")) {
                    tVar2 = d5.t.CLOUD;
                } else if (q7.k.a(lowerCase, "edge")) {
                    tVar2 = d5.t.EDGE;
                }
                ((u0) hVar3.f10131c).f(tVar2);
                SharedPreferences sharedPreferences = ((Context) hVar3.f10129a).getSharedPreferences("agentbus_prefs", 0);
                if (tVar2 == null) {
                    sharedPreferences.edit().remove("route_preference").apply();
                } else {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    String lowerCase4 = tVar2.name().toLowerCase(Locale.ROOT);
                    q7.k.d(lowerCase4, "toLowerCase(...)");
                    editorEdit.putString("route_preference", lowerCase4).apply();
                }
                if (tVar2 == null || (strName = tVar2.name()) == null) {
                    lowerCase2 = "auto";
                } else {
                    lowerCase2 = strName.toLowerCase(Locale.ROOT);
                    q7.k.d(lowerCase2, "toLowerCase(...)");
                }
                s.info$default((t) hVar3.f10130b, "RoutePreferenceStore", "route preference → ".concat(lowerCase2), null, 4, null);
                String strB = bVar2.b();
                if (strB == null) {
                    strB = "?";
                }
                return new c5.b("res", d7.e0.U(new c7.j("type", "res"), new c7.j("id", strB), new c7.j("ok", Boolean.TRUE), new c7.j("payload", d7.e0.T(new c7.j("mode", lowerCase2)))));
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                wa.i iVar2 = (wa.i) this.f209g;
                int iIntValue = ((Integer) obj).intValue();
                return iVar2.f10978e[iIntValue] + ": " + iVar2.i(iIntValue).b();
            case 24:
                x4.i iVar3 = (x4.i) this.f209g;
                byte[] bArr2 = (byte[]) obj;
                q7.k.e(bArr2, "bytes");
                d0.s(iVar3.f11187g, null, null, new v(iVar3, bArr2, null, 10), 3);
                return r.f1986a;
            default:
                if (x5.b.f11226f == ((h0) this.f209g)) {
                    x5.b.f11226f = null;
                }
                return r.f1986a;
        }
    }

    public /* synthetic */ a(t1 t1Var, o4.c cVar) {
        this.f208f = 17;
        this.f209g = cVar;
    }
}
