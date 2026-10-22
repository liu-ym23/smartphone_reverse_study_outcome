package s1;

import android.content.Context;
import android.util.Log;
import com.stepos.agentbus.config.AgentBusConfig;
import com.stepos.agentbus.config.BffBridgeConfig;
import com.stepos.agentbus.config.CloudBridgeConfig;
import com.stepos.agentbus.config.DebugAccountConfig;
import com.stepos.agentbus.config.GatewayConfig;
import com.stepos.agentbus.config.OpenClawCloudUpstream;
import com.stepos.agentbus.config.OpenClawGatewayUpstream;
import com.stepos.agentbus.config.ResourceConfig;
import com.stepos.agentbus.config.RestApiConfig;
import com.stepos.agentbus.platform.AgentBusApp;
import com.stepos.cloud.securedata.SecureDataJson;
import com.stepos.cloud.securedata.model.KeyExchangeApiResponse;
import com.stepos.cloud.securedata.model.PublicKeyApiResponse;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class u implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9307f;

    public /* synthetic */ u(int i2) {
        this.f9307f = i2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        int i2;
        int i10;
        int i11;
        int i12;
        long j2;
        c2.s sVar;
        switch (this.f9307f) {
            case 0:
                String str = obj != null ? (String) obj : null;
                q7.k.b(str);
                return new j0(str);
            case 1:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list = (List) obj;
                Object obj2 = list.get(0);
                String str2 = obj2 != null ? (String) obj2 : null;
                q7.k.b(str2);
                Object obj3 = list.get(1);
                return new i(str2, (q7.k.a(obj3, Boolean.FALSE) || obj3 == null) ? null : (f0) ((p7.k) y.f9320i.f8787g).invoke(obj3));
            case 2:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list2 = (List) obj;
                Object obj4 = list2.get(0);
                c2.k kVar = obj4 != null ? (c2.k) obj4 : null;
                q7.k.b(kVar);
                int i13 = kVar.f1874a;
                Object obj5 = list2.get(1);
                c2.m mVar = obj5 != null ? (c2.m) obj5 : null;
                q7.k.b(mVar);
                int i14 = mVar.f1878a;
                Object obj6 = list2.get(2);
                d2.o[] oVarArr = d2.n.f2797b;
                x xVar = y.f9328q;
                Boolean bool = Boolean.FALSE;
                q7.k.a(obj6, bool);
                d2.n nVar = obj6 != null ? (d2.n) xVar.f9311g.invoke(obj6) : null;
                q7.k.b(nVar);
                long j4 = nVar.f2799a;
                Object obj7 = list2.get(3);
                c2.q qVar = c2.q.f1883c;
                c2.q qVar2 = (q7.k.a(obj7, bool) || obj7 == null) ? null : (c2.q) ((p7.k) y.f9323l.f8787g).invoke(obj7);
                Object obj8 = list2.get(4);
                r rVar = (q7.k.a(obj8, bool) || obj8 == null) ? null : (r) ((p7.k) z.f9333a.f8787g).invoke(obj8);
                Object obj9 = list2.get(5);
                c2.i iVar = c2.i.f1868c;
                c2.i iVar2 = (q7.k.a(obj9, bool) || obj9 == null) ? null : (c2.i) ((p7.k) y.f9332u.f8787g).invoke(obj9);
                Object obj10 = list2.get(6);
                c2.e eVar = (q7.k.a(obj10, bool) || obj10 == null) ? null : (c2.e) ((p7.k) z.f9334b.f8787g).invoke(obj10);
                q7.k.b(eVar);
                int i15 = eVar.f1862a;
                Object obj11 = list2.get(7);
                c2.d dVar = obj11 != null ? (c2.d) obj11 : null;
                q7.k.b(dVar);
                int i16 = dVar.f1860a;
                Object obj12 = list2.get(8);
                boolean zA = q7.k.a(obj12, bool);
                q6.b bVar = z.f9335c;
                if (zA || obj12 == null) {
                    i2 = i13;
                    i10 = i16;
                    i11 = i15;
                    i12 = i14;
                    j2 = j4;
                    sVar = null;
                } else {
                    i2 = i13;
                    i10 = i16;
                    i11 = i15;
                    i12 = i14;
                    j2 = j4;
                    sVar = (c2.s) ((p7.k) bVar.f8787g).invoke(obj12);
                }
                return new p(i2, i12, j2, qVar2, rVar, iVar2, i11, i10, sVar);
            case 3:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list3 = (List) obj;
                Object obj13 = list3.get(0);
                int i17 = u0.m.f9917g;
                Boolean bool2 = Boolean.FALSE;
                q7.k.a(obj13, bool2);
                u0.m mVar2 = obj13 != null ? obj13.equals(bool2) ? new u0.m(u0.m.f9916f) : new u0.m(u0.z.b(((Integer) obj13).intValue())) : null;
                q7.k.b(mVar2);
                long j10 = mVar2.f9918a;
                Object obj14 = list3.get(1);
                d2.o[] oVarArr2 = d2.n.f2797b;
                p7.k kVar2 = y.f9328q.f9311g;
                q7.k.a(obj14, bool2);
                d2.n nVar2 = obj14 != null ? (d2.n) kVar2.invoke(obj14) : null;
                q7.k.b(nVar2);
                long j11 = nVar2.f2799a;
                Object obj15 = list3.get(2);
                v1.k kVar3 = v1.k.f10357g;
                v1.k kVar4 = (q7.k.a(obj15, bool2) || obj15 == null) ? null : (v1.k) ((p7.k) y.f9324m.f8787g).invoke(obj15);
                Object obj16 = list3.get(3);
                v1.i iVar3 = obj16 != null ? (v1.i) obj16 : null;
                Object obj17 = list3.get(4);
                v1.j jVar = obj17 != null ? (v1.j) obj17 : null;
                Object obj18 = list3.get(6);
                String str3 = obj18 != null ? (String) obj18 : null;
                Object obj19 = list3.get(7);
                q7.k.a(obj19, bool2);
                d2.n nVar3 = obj19 != null ? (d2.n) kVar2.invoke(obj19) : null;
                q7.k.b(nVar3);
                long j12 = nVar3.f2799a;
                Object obj20 = list3.get(8);
                c2.a aVar = (q7.k.a(obj20, bool2) || obj20 == null) ? null : (c2.a) ((p7.k) y.f9325n.f8787g).invoke(obj20);
                Object obj21 = list3.get(9);
                c2.p pVar = (q7.k.a(obj21, bool2) || obj21 == null) ? null : (c2.p) ((p7.k) y.f9322k.f8787g).invoke(obj21);
                Object obj22 = list3.get(10);
                y1.b bVar2 = y1.b.f11542h;
                y1.b bVar3 = (q7.k.a(obj22, bool2) || obj22 == null) ? null : (y1.b) ((p7.k) y.f9330s.f8787g).invoke(obj22);
                Object obj23 = list3.get(11);
                q7.k.a(obj23, bool2);
                u0.m mVar3 = obj23 != null ? obj23.equals(bool2) ? new u0.m(u0.m.f9916f) : new u0.m(u0.z.b(((Integer) obj23).intValue())) : null;
                q7.k.b(mVar3);
                long j13 = mVar3.f9918a;
                Object obj24 = list3.get(12);
                c2.l lVar = (q7.k.a(obj24, bool2) || obj24 == null) ? null : (c2.l) ((p7.k) y.f9321j.f8787g).invoke(obj24);
                Object obj25 = list3.get(13);
                u0.b0 b0Var = u0.b0.f9889d;
                return new a0(j10, j11, kVar4, iVar3, jVar, (v1.p) null, str3, j12, aVar, pVar, bVar3, j13, lVar, (q7.k.a(obj25, bool2) || obj25 == null) ? null : (u0.b0) ((p7.k) y.f9326o.f8787g).invoke(obj25), 49184);
            case 4:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list4 = (List) obj;
                Object obj26 = list4.get(0);
                Boolean bool3 = obj26 != null ? (Boolean) obj26 : null;
                q7.k.b(bool3);
                boolean zBooleanValue = bool3.booleanValue();
                Object obj27 = list4.get(1);
                q7.k.b(obj27 != null ? (h) obj27 : null);
                return new r(zBooleanValue);
            case 5:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.Int");
                return new c2.e(((Integer) obj).intValue());
            case 6:
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                List list5 = (List) obj;
                Object obj28 = list5.get(0);
                c2.r rVar2 = obj28 != null ? (c2.r) obj28 : null;
                q7.k.b(rVar2);
                int i18 = rVar2.f1886a;
                Object obj29 = list5.get(1);
                Boolean bool4 = obj29 != null ? (Boolean) obj29 : null;
                q7.k.b(bool4);
                return new c2.s(i18, bool4.booleanValue());
            case 7:
                Context context = (Context) obj;
                int i19 = AgentBusApp.f2679h;
                q7.k.e(context, "ctx");
                OpenClawGatewayUpstream openClawGatewayUpstream = new OpenClawGatewayUpstream("127.0.0.1:18789", false, false, null, false, null, null, null, null, null, null, null, 2040, null);
                String strA = u5.f.a(context);
                u5.e eVar2 = strA.equals("test") ? new u5.e("claw-node-connection-socket.stepos.com:443/ws/device", "https://biz-gw.t-stepos.com", "9fb1602ed92541a7bdabd0ce66cd45ce", "9pv65zQUtnH2huYnRPCE", false, 518) : new u5.e("claw-connection-socket-mtls.stepaos.com:443/ws/device", "https://biz-gw.stepaos.com", "7f1285a1cce243508c58e3a4c0fa4ae2", "bt6bI9U7wKl8FwT6tJ3u", true, 6);
                StringBuilder sb2 = new StringBuilder("Using endpoint: ");
                String str4 = eVar2.f10112a;
                sb2.append(str4);
                sb2.append(" mtls=");
                sb2.append(eVar2.f10119h);
                sb2.append(" fallback=");
                sb2.append(eVar2.f10120i);
                sb2.append(" (env: ");
                sb2.append(strA);
                sb2.append(")");
                Log.i("EnvManager", sb2.toString());
                CloudBridgeConfig cloudBridgeConfig = new CloudBridgeConfig(true, new OpenClawCloudUpstream(str4, true, null, false, null, eVar2.f10113b, null, null, null, null, null, null, eVar2.f10119h, null, eVar2.f10114c, eVar2.f10115d, eVar2.f10116e, eVar2.f10117f, eVar2.f10118g, eVar2.f10120i, 11228, null));
                String strA2 = u5.f.a(null);
                String str5 = strA2.equals("test") ? "wss://test-otter-connection.t-stepos.com/ws" : "wss://otter-connection.stepaos.com/ws";
                Log.i("EnvBffUrls", m.x.x("BFF WS url=", str5, " (env=", strA2, ")"));
                return new v4.k(context, new AgentBusConfig(0, null, null, null, new RestApiConfig(false, 0, 2, null), null, null, null, null, null, null, null, null, null, null, new ResourceConfig("openclaw", "/mnt/openclaw/rootfs"), new GatewayConfig("openclaw", openClawGatewayUpstream, cloudBridgeConfig, new BffBridgeConfig(true, str5, null, 0, 0, 0L, 0L, 0L, 0L, 508, null), new DebugAccountConfig(false, null, 2, null)), null, null, null, 950255, null));
            case 8:
                Byte b10 = (Byte) obj;
                b10.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b10}, 1));
            case 9:
                String str6 = (String) obj;
                q7.k.e(str6, "it");
                return Boolean.valueOf(v4.k.f10420o0.contains(str6));
            case 10:
                Byte b11 = (Byte) obj;
                b11.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b11}, 1));
            case 11:
                String str7 = (String) obj;
                q7.k.e(str7, "it");
                xa.c codec = SecureDataJson.INSTANCE.getCodec();
                codec.getClass();
                return (PublicKeyApiResponse) codec.a(PublicKeyApiResponse.INSTANCE.serializer(), str7);
            case 12:
                String str8 = (String) obj;
                q7.k.e(str8, "it");
                xa.c codec2 = SecureDataJson.INSTANCE.getCodec();
                codec2.getClass();
                return (KeyExchangeApiResponse) codec2.a(KeyExchangeApiResponse.INSTANCE.serializer(), str8);
            default:
                Byte b12 = (Byte) obj;
                b12.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b12}, 1));
        }
    }

    public /* synthetic */ u(AgentBusApp agentBusApp) {
        this.f9307f = 7;
    }
}
