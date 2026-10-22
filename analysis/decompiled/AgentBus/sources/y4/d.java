package y4;

import org.json.JSONObject;
import w7.e0;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11556f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f11557g;

    public /* synthetic */ d(h hVar, int i2) {
        this.f11556f = i2;
        this.f11557g = hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [c7.l] */
    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        String strN;
        String str = (String) obj;
        String str2 = (String) obj2;
        String str3 = (String) obj3;
        switch (this.f11556f) {
            case 0:
                q7.k.e(str, "role");
                q7.k.e(str2, "event");
                if (str3 != null) {
                    try {
                        strN = new JSONObject(str3).optString("stream");
                    } catch (Throwable th) {
                        strN = e0.n(th);
                    }
                    str = strN instanceof c7.l ? null : strN;
                }
                boolean zEquals = str2.equals("tick");
                h hVar = this.f11557g;
                if (zEquals || str2.equals("health")) {
                    k5.s.debug$default(hVar.f11569c, "openclaw-edge", a1.a.k("[", str, "] event=", str2), null, 4, null);
                } else if (str2.equals("agent") && !q7.k.a(str, "assistant")) {
                    k5.t tVar = hVar.f11569c;
                    int length = str3 != null ? str3.length() : 0;
                    StringBuilder sbP = a1.a.p("[", str, "] agent event stream=", str, " payloadLen=");
                    sbP.append(length);
                    k5.s.info$default(tVar, "openclaw-edge", sbP.toString(), null, 4, null);
                } else if (!str2.equals("agent")) {
                    k5.s.debug$default(hVar.f11569c, "openclaw-edge", a1.a.k("[", str, "] event=", str2), null, 4, null);
                }
                return c7.r.f1986a;
            case 1:
                q7.k.e(str, "role");
                q7.k.e(str3, "addr");
                k5.t tVar2 = this.f11557g.f11569c;
                StringBuilder sbP2 = a1.a.p("[", str, "] ONLINE serverName=", str2, " remote=");
                sbP2.append(str3);
                k5.s.info$default(tVar2, "openclaw-cloud", sbP2.toString(), null, 4, null);
                break;
            case 2:
                q7.k.e(str, "role");
                q7.k.e(str2, "event");
                boolean zEquals2 = str2.equals("tick");
                h hVar2 = this.f11557g;
                if (zEquals2) {
                    k5.s.debug$default(hVar2.f11569c, "openclaw-cloud", a1.a.j("[", str, "] event=tick"), null, 4, null);
                } else {
                    k5.s.debug$default(hVar2.f11569c, "openclaw-cloud", a1.a.k("[", str, "] event=", str2), null, 4, null);
                }
                return c7.r.f1986a;
            default:
                q7.k.e(str, "role");
                q7.k.e(str3, "addr");
                k5.t tVar3 = this.f11557g.f11569c;
                StringBuilder sbP3 = a1.a.p("[", str, "] ONLINE serverName=", str2, " remote=");
                sbP3.append(str3);
                k5.s.info$default(tVar3, "openclaw-edge", sbP3.toString(), null, 4, null);
                break;
        }
        return c7.r.f1986a;
    }
}
