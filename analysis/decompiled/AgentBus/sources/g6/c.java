package g6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import p6.f;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3859e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i2) {
        super(0);
        this.f3859e = i2;
    }

    @Override // g6.a
    public final a a() {
        switch (this.f3859e) {
            case 0:
                p6.b bVar = new p6.b(1);
                String str = this.f3853c;
                bVar.f3852b = str;
                bVar.f3853c = "20001";
                if (TextUtils.isEmpty(str)) {
                    bVar.f3854d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f3854d)) {
                    bVar.f3854d = "appKey is empty";
                }
                return bVar;
            case 1:
                p6.c cVar = new p6.c(1);
                String str2 = this.f3853c;
                cVar.f3852b = str2;
                cVar.f3853c = "20001";
                if (TextUtils.isEmpty(str2)) {
                    cVar.f3854d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f3854d)) {
                    cVar.f3854d = "appKey is empty";
                } else if (TextUtils.isEmpty(null)) {
                    cVar.f3854d = "pushId is empty";
                }
                return cVar;
            case 2:
                p6.a aVar = new p6.a(1);
                String str3 = this.f3853c;
                aVar.f3852b = str3;
                aVar.f3853c = "20001";
                if (TextUtils.isEmpty(str3)) {
                    aVar.f3854d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f3854d)) {
                    aVar.f3854d = "appKey is empty";
                } else if (TextUtils.isEmpty(null)) {
                    aVar.f3854d = "pushId is empty";
                }
                return aVar;
            default:
                f fVar = new f(1);
                String str4 = this.f3853c;
                fVar.f3852b = str4;
                fVar.f3853c = "20001";
                if (TextUtils.isEmpty(str4)) {
                    fVar.f3854d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f3854d)) {
                    fVar.f3854d = "appKey is empty";
                }
                return fVar;
        }
    }

    @Override // g6.a
    public final String b(a aVar) throws JSONException {
        switch (this.f3859e) {
            case 0:
                p6.b bVar = (p6.b) aVar;
                j6.a.a("BasicStatus", "register status to string start");
                j6.a.a("BasicStatus", "register status to string start: " + bVar);
                try {
                    JSONObject jSONObjectD = a.d(new JSONObject(), bVar);
                    if (!TextUtils.isEmpty(bVar.f8490e)) {
                        jSONObjectD.put("push_id", bVar.f8490e);
                    }
                    int i2 = bVar.f8491f;
                    if (i2 > 0) {
                        jSONObjectD.put("expire_time", i2);
                    }
                    if (!TextUtils.isEmpty(bVar.f8492g)) {
                        jSONObjectD.put("server", bVar.f8492g);
                    }
                    String string = jSONObjectD.toString();
                    j6.a.b("BasicStatus", "register status to string success, statusText: " + string);
                    break;
                } catch (JSONException e10) {
                    j6.a.c("BasicStatus", "register status to string error, " + e10.getMessage());
                    return null;
                }
            case 1:
                p6.c cVar = (p6.c) aVar;
                j6.a.a("BasicStatus", "sub alias status to string start");
                j6.a.a("BasicStatus", "sub alias status to string start, SubAliasStatus: " + cVar);
                try {
                    JSONObject jSONObjectD2 = a.d(new JSONObject(), cVar);
                    if (!TextUtils.isEmpty(cVar.f8493e)) {
                        jSONObjectD2.put("push_id", cVar.f8493e);
                    }
                    jSONObjectD2.put("alias", cVar.f8494f);
                    String string2 = jSONObjectD2.toString();
                    j6.a.b("BasicStatus", "sub alias status to string success, statusText: " + string2);
                    break;
                } catch (JSONException e11) {
                    j6.a.c("BasicStatus", "sub alias status to string error, " + e11.getMessage());
                    return null;
                }
            case 2:
                p6.a aVar2 = (p6.a) aVar;
                j6.a.a("BasicStatus", "switch status to string start");
                j6.a.a("BasicStatus", "switch status to string start: " + aVar2);
                try {
                    JSONObject jSONObjectD3 = a.d(new JSONObject(), aVar2);
                    if (!TextUtils.isEmpty(aVar2.f8489g)) {
                        jSONObjectD3.put("push_id", aVar2.f8489g);
                    }
                    jSONObjectD3.put("is_switch_notification", aVar2.f8487e);
                    jSONObjectD3.put("is_switch_through", aVar2.f8488f);
                    String string3 = jSONObjectD3.toString();
                    j6.a.b("BasicStatus", "switch status success, statusText: " + string3);
                    break;
                } catch (JSONException e12) {
                    j6.a.c("BasicStatus", "switch status error, " + e12.getMessage());
                    return null;
                }
            default:
                f fVar = (f) aVar;
                j6.a.a("BasicStatus", "unregister status to string start");
                j6.a.a("BasicStatus", "unregister status to string start, UnRegisterStatus:" + fVar);
                try {
                    JSONObject jSONObjectD4 = a.d(new JSONObject(), fVar);
                    jSONObjectD4.put("is_unregister_success", fVar.f8499e);
                    String string4 = jSONObjectD4.toString();
                    j6.a.b("BasicStatus", "unregister status to string success, statusText: " + string4);
                    break;
                } catch (JSONException e13) {
                    j6.a.c("BasicStatus", "unregister status to string error, " + e13.getMessage());
                    return null;
                }
        }
        return null;
    }

    @Override // g6.a
    public final Intent[] f(Context context) {
        switch (this.f3859e) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("app_id", this.f3853c);
                intent.putExtra("app_key", this.f3854d);
                intent.putExtra("strategy_package_name", context.getPackageName());
                intent.putExtra("strategy_type", 2);
                return new Intent[]{intent};
            case 1:
                Intent intent2 = new Intent();
                intent2.putExtra("app_id", this.f3853c);
                intent2.putExtra("app_key", this.f3854d);
                intent2.putExtra("strategy_package_name", context.getPackageName());
                intent2.putExtra("push_id", (String) null);
                intent2.putExtra("strategy_type", 8);
                intent2.putExtra("strategy_child_type", 0);
                intent2.putExtra("strategy_params", (String) null);
                return new Intent[]{intent2};
            case 2:
                Intent intent3 = new Intent();
                intent3.putExtra("app_id", this.f3853c);
                intent3.putExtra("app_key", this.f3854d);
                intent3.putExtra("strategy_package_name", context.getPackageName());
                intent3.putExtra("push_id", (String) null);
                intent3.putExtra("strategy_type", 16);
                intent3.putExtra("strategy_child_type", 0);
                intent3.putExtra("strategy_params", "0");
                return new Intent[]{intent3};
            default:
                Intent intent4 = new Intent();
                intent4.putExtra("app_id", this.f3853c);
                intent4.putExtra("app_key", this.f3854d);
                intent4.putExtra("strategy_package_name", context.getPackageName());
                intent4.putExtra("strategy_type", 32);
                return new Intent[]{intent4};
        }
    }

    @Override // g6.a
    public final String g() {
        switch (this.f3859e) {
            case 0:
                return "register_status";
            case 1:
                return "sub_alias_status";
            case 2:
                return "push_status";
            default:
                return "un_register_status";
        }
    }

    @Override // g6.a
    public final boolean h() {
        switch (this.f3859e) {
            case 0:
                if (TextUtils.isEmpty(this.f3853c) || TextUtils.isEmpty(this.f3854d)) {
                }
                break;
            case 1:
                if (TextUtils.isEmpty(this.f3853c) || TextUtils.isEmpty(this.f3854d) || TextUtils.isEmpty(null)) {
                }
                break;
            case 2:
                if (TextUtils.isEmpty(this.f3853c) || TextUtils.isEmpty(this.f3854d) || TextUtils.isEmpty(null)) {
                }
                break;
            default:
                if (TextUtils.isEmpty(this.f3853c) || TextUtils.isEmpty(this.f3854d)) {
                }
                break;
        }
        return false;
    }
}
