package g9;

import android.content.Context;
import android.util.Log;
import com.stepos.agentsafetycenter.MainActivity;
import com.stepos.agentsafetycenter.R;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4649c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4650f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4651g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4652h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(xb.l lVar, Context context, String str, z8.c cVar, nb.c cVar2) {
        super(2, cVar2);
        this.f4649c = 3;
        this.f4650f = lVar;
        this.f4652h = context;
        this.f4651g = str;
        this.i = cVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f4649c) {
            case 0:
                y yVar = new y((String) this.f4651g, (b0) this.i, (String) this.f4652h, cVar);
                yVar.f4650f = obj;
                return yVar;
            case 1:
                return new y((List) this.f4650f, (x.r) this.f4651g, (k0.c1) this.f4652h, (k0.c1) this.i, cVar, 1);
            case 2:
                return new y((m8.a) this.f4650f, (m8.k0) this.f4651g, (k0.c1) this.f4652h, (k0.c1) this.i, cVar, 2);
            case 3:
                return new y((xb.l) this.f4650f, (Context) this.f4652h, (String) this.f4651g, (z8.c) this.i, cVar);
            case 4:
                return new y((k0.c1) this.f4650f, (k0.c1) this.f4651g, (k0.c1) this.f4652h, (k0.c1) this.i, cVar, 4);
            default:
                y yVar2 = new y((b0) this.i, (String) this.f4651g, (String) this.f4652h, cVar);
                yVar2.f4650f = obj;
                return yVar2;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Exception {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f4649c) {
            case 0:
                return ((y) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
            case 1:
                y yVar = (y) create(tVar, cVar);
                jb.v vVar = jb.v.f6774a;
                yVar.invokeSuspend(vVar);
                return vVar;
            case 2:
                y yVar2 = (y) create(tVar, cVar);
                jb.v vVar2 = jb.v.f6774a;
                yVar2.invokeSuspend(vVar2);
                return vVar2;
            case 3:
                return ((y) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
            case 4:
                y yVar3 = (y) create(tVar, cVar);
                jb.v vVar3 = jb.v.f6774a;
                yVar3.invokeSuspend(vVar3);
                return vVar3;
            default:
                return ((y) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Exception {
        jb.h hVarL;
        l8.a aVar;
        String str;
        int i;
        Object objL;
        Object objL2;
        i9.c cVar;
        jb.h hVarL2;
        l8.a aVar2;
        String str2;
        int i3 = this.f4649c;
        String str3 = "";
        int i10 = 2;
        jb.v vVar = jb.v.f6774a;
        Exception exc = null;
        boolean z10 = false;
        Object obj2 = this.f4652h;
        Object obj3 = this.i;
        Object obj4 = this.f4651g;
        switch (i3) {
            case 0:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                String str4 = (String) obj4;
                b0 b0Var = (b0) obj3;
                String str5 = (String) obj2;
                try {
                    l8.b bVar = l8.b.f7755a;
                    aa.j jVar = new aa.j(i10);
                    jVar.f326f = b0Var;
                    jVar.f327g = str4;
                    jVar.f328h = str5;
                    VarHandle.storeStoreFence();
                    ad.n nVarE = l8.b.e();
                    aVar = (l8.a) jVar.invoke(nVarE);
                    if (aVar.f7752a == 401) {
                        String strA = nVarE.a("Authorization");
                        if (strA != null) {
                            str3 = strA;
                        }
                        if (bVar.d(str3)) {
                            aVar = (l8.a) jVar.invoke(l8.b.e());
                        }
                    }
                    str = aVar.f7753b;
                    i = aVar.f7752a;
                    Log.i("PermissionCloudApi", str4 + " <- http=" + i + " bodyBytes=" + str.length());
                    ad.n nVar = aVar.f7754c;
                    Set set = p9.a.f9925a;
                    Log.i("PermissionCloudApi", str4 + " responseHeaders=" + p9.a.b(nVar));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append(" body");
                    Log.i("PermissionCloudApi", p9.a.a(str, sb2.toString()));
                } catch (Throwable th) {
                    hVarL = id.c.l(th);
                }
                if (!aVar.a()) {
                    throw new IOException("HTTP " + i + ": " + str);
                }
                try {
                    objL = Boolean.valueOf(new JSONObject(str).optBoolean("success", true));
                } catch (Throwable th2) {
                    objL = id.c.l(th2);
                }
                Boolean bool = Boolean.TRUE;
                boolean z11 = objL instanceof jb.h;
                Object obj5 = objL;
                if (z11) {
                    obj5 = bool;
                }
                hVarL = str;
                if (!((Boolean) obj5).booleanValue()) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String strOptString = jSONObject.optString("message");
                        boolean zG0 = hc.h.g0(strOptString);
                        objL2 = strOptString;
                        if (zG0) {
                            objL2 = jSONObject.optString("msg");
                        }
                    } catch (Throwable th3) {
                        objL2 = id.c.l(th3);
                    }
                    throw new IOException("API success=false " + ((String) (objL2 instanceof jb.h ? str : objL2)));
                }
                Throwable thB = jb.i.b(hVarL);
                if (thB != null) {
                    Log.w("PermissionCloudApi", str4 + " post failed: " + thB.getMessage(), thB);
                }
                return jb.i.a(hVarL);
            case 1:
                List list = (List) this.f4650f;
                ob.a aVar4 = ob.a.f9351c;
                id.c.I(obj);
                if (!((Boolean) ((k0.c1) obj2).getValue()).booleanValue() && !list.isEmpty() && (cVar = (i9.c) kb.l.y0(((x.r) obj4).g(), list)) != null) {
                    ((k0.c1) obj3).setValue(p5.f.I(cVar.f5845b));
                }
                return vVar;
            case 2:
                m8.k0 k0Var = (m8.k0) obj4;
                ob.a aVar5 = ob.a.f9351c;
                id.c.I(obj);
                k0.c1 c1Var = (k0.c1) obj2;
                int i11 = MainActivity.f2491h;
                k8.d0 d0Var = (k8.d0) c1Var.getValue();
                k0.c1 c1Var2 = (k0.c1) obj3;
                c1Var.setValue((k8.d0) c1Var2.getValue());
                if (d0Var != null && !d0Var.equals((k8.d0) c1Var2.getValue()) && ((m8.a) this.f4650f).f8287t != null) {
                    k0Var.q();
                }
                if ((((k8.d0) c1Var2.getValue()) instanceof k8.x) && d0Var != null && !(d0Var instanceof k8.x)) {
                    j4.a aVarH = androidx.lifecycle.s0.h(k0Var);
                    rc.e eVar = kc.e0.f7430a;
                    kc.w.u(aVarH, rc.d.f10552f, null, new m8.d(4, k0Var, z10 ? 1 : 0), 2);
                    k0Var.Q(null, false);
                }
                return vVar;
            case 3:
                String str6 = (String) obj4;
                ob.a aVar6 = ob.a.f9351c;
                id.c.I(obj);
                xb.l lVar = (xb.l) this.f4650f;
                if (lVar != null) {
                    lVar.invoke(((Context) obj2).getString(R.string.log_fetching_daily_status) + " (" + str6 + ")");
                }
                z8.c cVar2 = (z8.c) obj3;
                str6.getClass();
                cVar2.getClass();
                l8.b bVar2 = l8.b.f7755a;
                if (!l8.b.c()) {
                    od.f.l("gateway Authorization not ready");
                    return null;
                }
                String strN = k0.a.n(cVar2.f16493a, "/v1/tool_security/device/daily_status");
                Log.i("SecurityLogApi", "POST tool_security/device/daily_status start date=" + str6 + " url=" + strN);
                int i12 = 0;
                while (i12 < 3) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("date", str6);
                        String string = jSONObject2.toString();
                        string.getClass();
                        ad.b0 b0VarL = td.h.l(string, cVar2.f16495c);
                        z8.c cVar3 = cVar2;
                        try {
                            androidx.activity.d0 d0Var2 = new androidx.activity.d0(0, cVar3, z8.c.class, "dailyStatusHeaders", "dailyStatusHeaders()Lokhttp3/Headers;", 0, 0, 8);
                            z8.b bVar3 = new z8.b();
                            bVar3.f16489c = cVar2;
                            bVar3.f16490f = i12;
                            bVar3.f16491g = strN;
                            bVar3.f16492h = jSONObject2;
                            bVar3.i = b0VarL;
                            VarHandle.storeStoreFence();
                            l8.a aVarA = z8.c.a(cVar2, d0Var2, bVar3);
                            String str7 = aVarA.f7753b;
                            Log.i("SecurityLogApi", "POST tool_security/device/daily_status <- http=" + aVarA.f7752a + " bodyBytes=" + str7.length());
                            ad.n nVar2 = aVarA.f7754c;
                            Set set2 = p9.a.f9925a;
                            Log.i("SecurityLogApi", "POST tool_security/device/daily_status responseHeaders=" + p9.a.b(nVar2));
                            Log.i("SecurityLogApi", p9.a.a(str7, "POST tool_security/device/daily_status body"));
                            if (!aVarA.a()) {
                                throw new IOException("HTTP " + aVarA.f7752a + ": " + str7);
                                break;
                            } else {
                                k9.e eVar2 = new k9.e();
                                eVar2.f7368a = str7;
                                VarHandle.storeStoreFence();
                                return eVar2;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            cVar2 = cVar3;
                            exc = e;
                            int i13 = i12 + 1;
                            Log.w("SecurityLogApi", "POST tool_security/device/daily_status error attempt=" + i13 + ": " + exc.getMessage(), exc);
                            if (i12 < 2) {
                                Thread.sleep(i13 * 350);
                            }
                            i12 = i13;
                        }
                    } catch (Exception e11) {
                        e = e11;
                    }
                }
                Log.e("SecurityLogApi", "POST tool_security/device/daily_status exhausted retries", exc);
                if (exc != null) {
                    throw exc;
                }
                throw new IOException("daily_status 请求失败");
            case 4:
                ob.a aVar7 = ob.a.f9351c;
                id.c.I(obj);
                k0.c1 c1Var3 = (k0.c1) this.f4650f;
                float f5 = s8.w0.f12043g;
                c1Var3.setValue(null);
                ((k0.c1) obj4).setValue(null);
                ((k0.c1) obj2).setValue(new s8.e1());
                ((k0.c1) obj3).setValue(null);
                return vVar;
            default:
                ob.a aVar8 = ob.a.f9351c;
                id.c.I(obj);
                b0 b0Var2 = (b0) obj3;
                String str8 = (String) obj4;
                String str9 = (String) obj2;
                try {
                    l8.b bVar4 = l8.b.f7755a;
                    aa.j jVar2 = new aa.j(10);
                    jVar2.f326f = b0Var2;
                    jVar2.f327g = str8;
                    jVar2.f328h = str9;
                    VarHandle.storeStoreFence();
                    ad.n nVarE2 = l8.b.e();
                    aVar2 = (l8.a) jVar2.invoke(nVarE2);
                    if (aVar2.f7752a == 401) {
                        String strA2 = nVarE2.a("Authorization");
                        if (strA2 != null) {
                            str3 = strA2;
                        }
                        if (bVar4.d(str3)) {
                            aVar2 = (l8.a) jVar2.invoke(l8.b.e());
                        }
                    }
                    String str10 = aVar2.f7753b;
                    b0.a(b0Var2, str8, str9, aVar2.f7752a, str10, aVar2.f7754c);
                    str2 = str10;
                } catch (Throwable th4) {
                    hVarL2 = id.c.l(th4);
                }
                if (!aVar2.a()) {
                    throw new IOException("HTTP " + aVar2.f7752a + ": " + str2);
                }
                hVarL2 = str2;
                String str11 = (String) obj4;
                Throwable thB2 = jb.i.b(hVarL2);
                if (thB2 != null) {
                    Log.w("LedgerCloudApi", str11 + " post failed: " + thB2.getMessage());
                }
                return jb.i.a(hVarL2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(Object obj, Object obj2, k0.c1 c1Var, k0.c1 c1Var2, nb.c cVar, int i) {
        super(2, cVar);
        this.f4649c = i;
        this.f4650f = obj;
        this.f4651g = obj2;
        this.f4652h = c1Var;
        this.i = c1Var2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(String str, b0 b0Var, String str2, nb.c cVar) {
        super(2, cVar);
        this.f4649c = 0;
        this.f4651g = str;
        this.i = b0Var;
        this.f4652h = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, String str, String str2, nb.c cVar) {
        super(2, cVar);
        this.f4649c = 5;
        this.i = b0Var;
        this.f4651g = str;
        this.f4652h = str2;
    }
}
