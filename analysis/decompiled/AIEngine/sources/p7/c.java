package p7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11464d;

    @Override // p7.a
    public final String a(l.b bVar) throws JSONException {
        switch (this.f11464d) {
            case 0:
                y7.b bVar2 = (y7.b) bVar;
                s7.a.a("BasicStatus", "register status to string start");
                s7.a.a("BasicStatus", "register status to string start: " + bVar2);
                try {
                    JSONObject jSONObjectC = l.b.c(new JSONObject(), bVar2);
                    if (!TextUtils.isEmpty(bVar2.f14169e)) {
                        jSONObjectC.put("push_id", bVar2.f14169e);
                    }
                    int i10 = bVar2.h;
                    if (i10 > 0) {
                        jSONObjectC.put("expire_time", i10);
                    }
                    if (!TextUtils.isEmpty(bVar2.f14170j)) {
                        jSONObjectC.put("server", bVar2.f14170j);
                    }
                    String string = jSONObjectC.toString();
                    s7.a.b("BasicStatus", "register status to string success, statusText: " + string);
                    break;
                } catch (JSONException e10) {
                    s7.a.c("BasicStatus", "register status to string error, " + e10.getMessage());
                    return null;
                }
            default:
                y7.e eVar = (y7.e) bVar;
                s7.a.a("BasicStatus", "unregister status to string start");
                s7.a.a("BasicStatus", "unregister status to string start, UnRegisterStatus:" + eVar);
                try {
                    JSONObject jSONObjectC2 = l.b.c(new JSONObject(), eVar);
                    jSONObjectC2.put("is_unregister_success", eVar.f14175e);
                    String string2 = jSONObjectC2.toString();
                    s7.a.b("BasicStatus", "unregister status to string success, statusText: " + string2);
                    break;
                } catch (JSONException e11) {
                    s7.a.c("BasicStatus", "unregister status to string error, " + e11.getMessage());
                    return null;
                }
        }
        return null;
    }

    @Override // p7.a
    public final l.b b() {
        switch (this.f11464d) {
            case 0:
                y7.b bVar = new y7.b();
                String str = this.f11458b;
                bVar.f10167b = str;
                bVar.f10168c = "20001";
                if (TextUtils.isEmpty(str)) {
                    bVar.f10169d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f11459c)) {
                    bVar.f10169d = "appKey is empty";
                }
                return bVar;
            default:
                y7.e eVar = new y7.e();
                String str2 = this.f11458b;
                eVar.f10167b = str2;
                eVar.f10168c = "20001";
                if (TextUtils.isEmpty(str2)) {
                    eVar.f10169d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f11459c)) {
                    eVar.f10169d = "appKey is empty";
                }
                return eVar;
        }
    }

    @Override // p7.a
    public final Intent[] d(Context context) {
        switch (this.f11464d) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("app_id", this.f11458b);
                intent.putExtra("app_key", this.f11459c);
                intent.putExtra("strategy_package_name", context.getPackageName());
                intent.putExtra("strategy_type", 2);
                return new Intent[]{intent};
            default:
                Intent intent2 = new Intent();
                intent2.putExtra("app_id", this.f11458b);
                intent2.putExtra("app_key", this.f11459c);
                intent2.putExtra("strategy_package_name", context.getPackageName());
                intent2.putExtra("strategy_type", 32);
                return new Intent[]{intent2};
        }
    }

    @Override // p7.a
    public final String e() {
        switch (this.f11464d) {
            case 0:
                return "register_status";
            default:
                return "un_register_status";
        }
    }

    @Override // p7.a
    public final boolean f() {
        switch (this.f11464d) {
            case 0:
                if (TextUtils.isEmpty(this.f11458b) || TextUtils.isEmpty(this.f11459c)) {
                }
                break;
            default:
                if (TextUtils.isEmpty(this.f11458b) || TextUtils.isEmpty(this.f11459c)) {
                }
                break;
        }
        return false;
    }
}
