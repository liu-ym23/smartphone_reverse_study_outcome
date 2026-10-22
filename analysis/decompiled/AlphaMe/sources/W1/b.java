package W1;

import a2.AbstractC0155a;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d2.AbstractC0536a;
import d2.g;
import k.AbstractC0650d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends AbstractC0650d {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1991d;

    @Override // k.AbstractC0650d
    public final AbstractC0536a d() {
        switch (this.f1991d) {
            case 0:
                d2.c cVar = new d2.c();
                String str = (String) this.f13182b;
                cVar.f12416a = str;
                cVar.f12417b = "20001";
                if (TextUtils.isEmpty(str)) {
                    cVar.f12418c = "appId is empty";
                } else if (TextUtils.isEmpty((String) this.f13183c)) {
                    cVar.f12418c = "appKey is empty";
                }
                return cVar;
            default:
                g gVar = new g();
                String str2 = (String) this.f13182b;
                gVar.f12416a = str2;
                gVar.f12417b = "20001";
                if (TextUtils.isEmpty(str2)) {
                    gVar.f12418c = "appId is empty";
                } else if (TextUtils.isEmpty((String) this.f13183c)) {
                    gVar.f12418c = "appKey is empty";
                }
                return gVar;
        }
    }

    @Override // k.AbstractC0650d
    public final String e(AbstractC0536a abstractC0536a) throws JSONException {
        switch (this.f1991d) {
            case 0:
                d2.c cVar = (d2.c) abstractC0536a;
                AbstractC0155a.a("BasicStatus", "register status to string start");
                AbstractC0155a.a("BasicStatus", "register status to string start: " + cVar);
                try {
                    JSONObject jSONObjectA = AbstractC0536a.a(new JSONObject(), cVar);
                    if (!TextUtils.isEmpty(cVar.f12422d)) {
                        jSONObjectA.put("push_id", cVar.f12422d);
                    }
                    int i4 = cVar.f12423e;
                    if (i4 > 0) {
                        jSONObjectA.put("expire_time", i4);
                    }
                    if (!TextUtils.isEmpty(cVar.f12424f)) {
                        jSONObjectA.put("server", cVar.f12424f);
                    }
                    String string = jSONObjectA.toString();
                    AbstractC0155a.b("BasicStatus", "register status to string success, statusText: " + string);
                    break;
                } catch (JSONException e4) {
                    AbstractC0155a.c("BasicStatus", "register status to string error, " + e4.getMessage());
                    return null;
                }
            default:
                g gVar = (g) abstractC0536a;
                AbstractC0155a.a("BasicStatus", "unregister status to string start");
                AbstractC0155a.a("BasicStatus", "unregister status to string start, UnRegisterStatus:" + gVar);
                try {
                    JSONObject jSONObjectA2 = AbstractC0536a.a(new JSONObject(), gVar);
                    jSONObjectA2.put("is_unregister_success", gVar.f12431d);
                    String string2 = jSONObjectA2.toString();
                    AbstractC0155a.b("BasicStatus", "unregister status to string success, statusText: " + string2);
                    break;
                } catch (JSONException e5) {
                    AbstractC0155a.c("BasicStatus", "unregister status to string error, " + e5.getMessage());
                    return null;
                }
        }
        return null;
    }

    @Override // k.AbstractC0650d
    public final Intent[] f(Context context) {
        switch (this.f1991d) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("app_id", (String) this.f13182b);
                intent.putExtra("app_key", (String) this.f13183c);
                intent.putExtra("strategy_package_name", context.getPackageName());
                intent.putExtra("strategy_type", 2);
                return new Intent[]{intent};
            default:
                Intent intent2 = new Intent();
                intent2.putExtra("app_id", (String) this.f13182b);
                intent2.putExtra("app_key", (String) this.f13183c);
                intent2.putExtra("strategy_package_name", context.getPackageName());
                intent2.putExtra("strategy_type", 32);
                return new Intent[]{intent2};
        }
    }

    @Override // k.AbstractC0650d
    public final String g() {
        switch (this.f1991d) {
            case 0:
                return "register_status";
            default:
                return "un_register_status";
        }
    }

    @Override // k.AbstractC0650d
    public final boolean h() {
        switch (this.f1991d) {
            case 0:
                if (!TextUtils.isEmpty((String) this.f13182b) && !TextUtils.isEmpty((String) this.f13183c)) {
                    break;
                }
                break;
            default:
                if (!TextUtils.isEmpty((String) this.f13182b) && !TextUtils.isEmpty((String) this.f13183c)) {
                    break;
                }
                break;
        }
        return true;
    }
}
