package p7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y7.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: d, reason: collision with root package name */
    public int f11466d;

    @Override // p7.a
    public final String a(l.b bVar) throws JSONException {
        y7.d dVar = (y7.d) bVar;
        s7.a.a("BasicStatus", "sub tags status to string start");
        s7.a.a("BasicStatus", "sub tags status to string start, SubTagsStatus: " + dVar);
        try {
            JSONObject jSONObjectC = l.b.c(new JSONObject(), dVar);
            if (!TextUtils.isEmpty(dVar.f14172e)) {
                jSONObjectC.put("push_id", dVar.f14172e);
            }
            if (dVar.h != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < dVar.h.size(); i10++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tag_id", ((d.a) dVar.h.get(i10)).f14173a);
                    jSONObject.put("tag_name", ((d.a) dVar.h.get(i10)).f14174b);
                    jSONArray.put(jSONObject);
                }
                jSONObjectC.put("tag_list", jSONArray);
            }
            String string = jSONObjectC.toString();
            s7.a.b("BasicStatus", "sub tags status to string success, statusText: " + string);
            return string;
        } catch (JSONException e10) {
            s7.a.c("BasicStatus", "sub tags status to string error, " + e10.getMessage());
            return null;
        }
    }

    @Override // p7.a
    public final l.b b() {
        y7.d dVar = new y7.d();
        String str = this.f11458b;
        dVar.f10167b = str;
        dVar.f10168c = "20001";
        if (TextUtils.isEmpty(str)) {
            dVar.f10169d = "appId is empty";
            return dVar;
        }
        if (TextUtils.isEmpty(this.f11459c)) {
            dVar.f10169d = "appKey is empty";
            return dVar;
        }
        if (TextUtils.isEmpty(null)) {
            dVar.f10169d = "pushId is empty";
        }
        return dVar;
    }

    @Override // p7.a
    public final Intent[] d(Context context) {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f11458b);
        intent.putExtra("app_key", this.f11459c);
        intent.putExtra("strategy_package_name", context.getPackageName());
        intent.putExtra("push_id", (String) null);
        intent.putExtra("strategy_type", 4);
        intent.putExtra("strategy_child_type", this.f11466d);
        intent.putExtra("strategy_params", (String) null);
        return new Intent[]{intent};
    }

    @Override // p7.a
    public final String e() {
        return "sub_tags_status";
    }

    @Override // p7.a
    public final boolean f() {
        return (TextUtils.isEmpty(this.f11458b) || TextUtils.isEmpty(this.f11459c) || TextUtils.isEmpty(null)) ? false : true;
    }
}
