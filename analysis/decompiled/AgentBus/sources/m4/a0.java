package m4;

import android.content.Intent;
import b0.f1;
import com.stepos.agentbus.platform.AgentBusService;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6149f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f6150g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f6151h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f6152i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6153j;

    public /* synthetic */ a0(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f6149f = i2;
        this.f6150g = obj;
        this.f6151h = obj2;
        this.f6152i = obj3;
        this.f6153j = obj4;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f6149f) {
            case 0:
                String str = (String) this.f6150g;
                String str2 = (String) this.f6151h;
                String str3 = (String) this.f6152i;
                String str4 = (String) this.f6153j;
                Map map = (Map) obj;
                q7.k.e(map, "cfg");
                Object obj2 = map.get("models");
                Map linkedHashMap = q7.z.f(obj2) ? (Map) obj2 : null;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    map.put("models", linkedHashMap);
                }
                Object obj3 = linkedHashMap.get("providers");
                Map linkedHashMap2 = q7.z.f(obj3) ? (Map) obj3 : null;
                if (linkedHashMap2 == null) {
                    linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap.put("providers", linkedHashMap2);
                }
                if (str != null) {
                    Object obj4 = linkedHashMap2.get(str);
                    Map linkedHashMap3 = q7.z.f(obj4) ? (Map) obj4 : null;
                    if (linkedHashMap3 == null) {
                        linkedHashMap3 = new LinkedHashMap();
                        linkedHashMap2.put(str, linkedHashMap3);
                    }
                    if (str2 != null) {
                        linkedHashMap3.put("baseUrl", str2);
                    }
                    if (str3 != null) {
                        linkedHashMap3.put("api", str3);
                    }
                }
                if (str != null && str4 != null) {
                    Object obj5 = map.get("agents");
                    Map linkedHashMap4 = q7.z.f(obj5) ? (Map) obj5 : null;
                    if (linkedHashMap4 == null) {
                        linkedHashMap4 = new LinkedHashMap();
                        map.put("agents", linkedHashMap4);
                    }
                    Object obj6 = linkedHashMap4.get("defaults");
                    Map linkedHashMap5 = q7.z.f(obj6) ? (Map) obj6 : null;
                    if (linkedHashMap5 == null) {
                        linkedHashMap5 = new LinkedHashMap();
                        linkedHashMap4.put("defaults", linkedHashMap5);
                    }
                    linkedHashMap5.put("model", str + "/" + str4);
                }
                return c7.r.f1986a;
            default:
                c.i iVar = (c.i) this.f6150g;
                f1 f1Var = (f1) this.f6151h;
                f1 f1Var2 = (f1) this.f6152i;
                f1 f1Var3 = (f1) this.f6153j;
                b0.l0 l0Var = (b0.l0) obj;
                q7.k.e(l0Var, "$this$DisposableEffect");
                w5.s sVar = new w5.s(f1Var, f1Var2, f1Var3);
                iVar.bindService(new Intent(iVar, (Class<?>) AgentBusService.class), sVar, 1);
                return new d.d(l0Var, iVar, sVar);
        }
    }
}
