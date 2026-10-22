package p7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11465d;

    public /* synthetic */ d(int i10) {
        this.f11465d = i10;
    }

    @Override // p7.a
    public final String a(l.b bVar) throws JSONException {
        switch (this.f11465d) {
            case 0:
                y7.c cVar = (y7.c) bVar;
                s7.a.a("BasicStatus", "sub alias status to string start");
                s7.a.a("BasicStatus", "sub alias status to string start, SubAliasStatus: " + cVar);
                try {
                    JSONObject jSONObjectC = l.b.c(new JSONObject(), cVar);
                    if (!TextUtils.isEmpty(cVar.f14171e)) {
                        jSONObjectC.put("push_id", cVar.f14171e);
                    }
                    jSONObjectC.put("alias", cVar.h);
                    String string = jSONObjectC.toString();
                    s7.a.b("BasicStatus", "sub alias status to string success, statusText: " + string);
                    break;
                } catch (JSONException e10) {
                    s7.a.c("BasicStatus", "sub alias status to string error, " + e10.getMessage());
                    return null;
                }
            default:
                y7.a aVar = (y7.a) bVar;
                s7.a.a("BasicStatus", "switch status to string start");
                s7.a.a("BasicStatus", "switch status to string start: " + aVar);
                try {
                    JSONObject jSONObjectC2 = l.b.c(new JSONObject(), aVar);
                    if (!TextUtils.isEmpty(aVar.f14168j)) {
                        jSONObjectC2.put("push_id", aVar.f14168j);
                    }
                    jSONObjectC2.put("is_switch_notification", aVar.f14167e);
                    jSONObjectC2.put("is_switch_through", aVar.h);
                    String string2 = jSONObjectC2.toString();
                    s7.a.b("BasicStatus", "switch status success, statusText: " + string2);
                    break;
                } catch (JSONException e11) {
                    s7.a.c("BasicStatus", "switch status error, " + e11.getMessage());
                    return null;
                }
        }
        return null;
    }

    @Override // p7.a
    public final l.b b() {
        switch (this.f11465d) {
            case 0:
                y7.c cVar = new y7.c();
                String str = this.f11458b;
                cVar.f10167b = str;
                cVar.f10168c = "20001";
                if (TextUtils.isEmpty(str)) {
                    cVar.f10169d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f11459c)) {
                    cVar.f10169d = "appKey is empty";
                } else if (TextUtils.isEmpty(null)) {
                    cVar.f10169d = "pushId is empty";
                }
                return cVar;
            default:
                y7.a aVar = new y7.a();
                String str2 = this.f11458b;
                aVar.f10167b = str2;
                aVar.f10168c = "20001";
                if (TextUtils.isEmpty(str2)) {
                    aVar.f10169d = "appId is empty";
                } else if (TextUtils.isEmpty(this.f11459c)) {
                    aVar.f10169d = "appKey is empty";
                } else if (TextUtils.isEmpty(null)) {
                    aVar.f10169d = "pushId is empty";
                }
                return aVar;
        }
    }

    @Override // p7.a
    public final Intent[] d(Context context) {
        switch (this.f11465d) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("app_id", this.f11458b);
                intent.putExtra("app_key", this.f11459c);
                intent.putExtra("strategy_package_name", context.getPackageName());
                intent.putExtra("push_id", (String) null);
                intent.putExtra("strategy_type", 8);
                intent.putExtra("strategy_child_type", 0);
                intent.putExtra("strategy_params", (String) null);
                return new Intent[]{intent};
            default:
                Intent intent2 = new Intent();
                intent2.putExtra("app_id", this.f11458b);
                intent2.putExtra("app_key", this.f11459c);
                intent2.putExtra("strategy_package_name", context.getPackageName());
                intent2.putExtra("push_id", (String) null);
                intent2.putExtra("strategy_type", 16);
                intent2.putExtra("strategy_child_type", 0);
                intent2.putExtra("strategy_params", "0");
                return new Intent[]{intent2};
        }
    }

    @Override // p7.a
    public final String e() {
        switch (this.f11465d) {
            case 0:
                return "sub_alias_status";
            default:
                return "push_status";
        }
    }

    @Override // p7.a
    public final boolean f() {
        switch (this.f11465d) {
            case 0:
                if (TextUtils.isEmpty(this.f11458b) || TextUtils.isEmpty(this.f11459c) || TextUtils.isEmpty(null)) {
                }
                break;
            default:
                if (TextUtils.isEmpty(this.f11458b) || TextUtils.isEmpty(this.f11459c) || TextUtils.isEmpty(null)) {
                }
                break;
        }
        return false;
    }
}
