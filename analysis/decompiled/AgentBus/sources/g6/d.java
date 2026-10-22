package g6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p6.e;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: e, reason: collision with root package name */
    public int f3860e;

    @Override // g6.a
    public final a a() {
        e eVar = new e(1);
        String str = this.f3853c;
        eVar.f3852b = str;
        eVar.f3853c = "20001";
        if (TextUtils.isEmpty(str)) {
            eVar.f3854d = "appId is empty";
            return eVar;
        }
        if (TextUtils.isEmpty(this.f3854d)) {
            eVar.f3854d = "appKey is empty";
            return eVar;
        }
        if (TextUtils.isEmpty(null)) {
            eVar.f3854d = "pushId is empty";
        }
        return eVar;
    }

    @Override // g6.a
    public final String b(a aVar) throws JSONException {
        e eVar = (e) aVar;
        j6.a.a("BasicStatus", "sub tags status to string start");
        j6.a.a("BasicStatus", "sub tags status to string start, SubTagsStatus: " + eVar);
        try {
            JSONObject jSONObjectD = a.d(new JSONObject(), eVar);
            if (!TextUtils.isEmpty(eVar.f8497e)) {
                jSONObjectD.put("push_id", eVar.f8497e);
            }
            if (eVar.f8498f != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < eVar.f8498f.size(); i2++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tag_id", ((p6.d) eVar.f8498f.get(i2)).f8495a);
                    jSONObject.put("tag_name", ((p6.d) eVar.f8498f.get(i2)).f8496b);
                    jSONArray.put(jSONObject);
                }
                jSONObjectD.put("tag_list", jSONArray);
            }
            String string = jSONObjectD.toString();
            j6.a.b("BasicStatus", "sub tags status to string success, statusText: " + string);
            return string;
        } catch (JSONException e10) {
            j6.a.c("BasicStatus", "sub tags status to string error, " + e10.getMessage());
            return null;
        }
    }

    @Override // g6.a
    public final Intent[] f(Context context) {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f3853c);
        intent.putExtra("app_key", this.f3854d);
        intent.putExtra("strategy_package_name", context.getPackageName());
        intent.putExtra("push_id", (String) null);
        intent.putExtra("strategy_type", 4);
        intent.putExtra("strategy_child_type", this.f3860e);
        intent.putExtra("strategy_params", (String) null);
        return new Intent[]{intent};
    }

    @Override // g6.a
    public final String g() {
        return "sub_tags_status";
    }

    @Override // g6.a
    public final boolean h() {
        return (TextUtils.isEmpty(this.f3853c) || TextUtils.isEmpty(this.f3854d) || TextUtils.isEmpty(null)) ? false : true;
    }
}
