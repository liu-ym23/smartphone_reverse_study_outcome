package W1;

import a2.AbstractC0155a;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d2.AbstractC0536a;
import d2.e;
import d2.f;
import k.AbstractC0650d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c extends AbstractC0650d {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1992d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1993e;

    public c(int i4) {
        this.f1992d = i4;
        if (i4 != 1) {
            return;
        }
        this.f1993e = 3;
    }

    @Override // k.AbstractC0650d
    public final AbstractC0536a d() {
        switch (this.f1992d) {
            case 0:
                d2.d dVar = new d2.d();
                String str = (String) this.f13182b;
                dVar.f12416a = str;
                dVar.f12417b = "20001";
                if (TextUtils.isEmpty(str)) {
                    dVar.f12418c = "appId is empty";
                } else if (TextUtils.isEmpty((String) this.f13183c)) {
                    dVar.f12418c = "appKey is empty";
                } else if (TextUtils.isEmpty(null)) {
                    dVar.f12418c = "pushId is empty";
                }
                return dVar;
            default:
                f fVar = new f();
                String str2 = (String) this.f13182b;
                fVar.f12416a = str2;
                fVar.f12417b = "20001";
                if (TextUtils.isEmpty(str2)) {
                    fVar.f12418c = "appId is empty";
                } else if (TextUtils.isEmpty((String) this.f13183c)) {
                    fVar.f12418c = "appKey is empty";
                } else if (TextUtils.isEmpty(null)) {
                    fVar.f12418c = "pushId is empty";
                }
                return fVar;
        }
    }

    @Override // k.AbstractC0650d
    public final String e(AbstractC0536a abstractC0536a) throws JSONException {
        switch (this.f1992d) {
            case 0:
                d2.d dVar = (d2.d) abstractC0536a;
                AbstractC0155a.a("BasicStatus", "sub alias status to string start");
                AbstractC0155a.a("BasicStatus", "sub alias status to string start, SubAliasStatus: " + dVar);
                try {
                    JSONObject jSONObjectA = AbstractC0536a.a(new JSONObject(), dVar);
                    if (!TextUtils.isEmpty(dVar.f12425d)) {
                        jSONObjectA.put("push_id", dVar.f12425d);
                    }
                    jSONObjectA.put("alias", dVar.f12426e);
                    String string = jSONObjectA.toString();
                    AbstractC0155a.b("BasicStatus", "sub alias status to string success, statusText: " + string);
                    break;
                } catch (JSONException e4) {
                    AbstractC0155a.c("BasicStatus", "sub alias status to string error, " + e4.getMessage());
                    return null;
                }
            default:
                f fVar = (f) abstractC0536a;
                AbstractC0155a.a("BasicStatus", "sub tags status to string start");
                AbstractC0155a.a("BasicStatus", "sub tags status to string start, SubTagsStatus: " + fVar);
                try {
                    JSONObject jSONObjectA2 = AbstractC0536a.a(new JSONObject(), fVar);
                    if (!TextUtils.isEmpty(fVar.f12429d)) {
                        jSONObjectA2.put("push_id", fVar.f12429d);
                    }
                    if (fVar.f12430e != null) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i4 = 0; i4 < fVar.f12430e.size(); i4++) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tag_id", ((e) fVar.f12430e.get(i4)).f12427a);
                            jSONObject.put("tag_name", ((e) fVar.f12430e.get(i4)).f12428b);
                            jSONArray.put(jSONObject);
                        }
                        jSONObjectA2.put("tag_list", jSONArray);
                    }
                    String string2 = jSONObjectA2.toString();
                    AbstractC0155a.b("BasicStatus", "sub tags status to string success, statusText: " + string2);
                    break;
                } catch (JSONException e5) {
                    AbstractC0155a.c("BasicStatus", "sub tags status to string error, " + e5.getMessage());
                    return null;
                }
        }
        return null;
    }

    @Override // k.AbstractC0650d
    public final Intent[] f(Context context) {
        switch (this.f1992d) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("app_id", (String) this.f13182b);
                intent.putExtra("app_key", (String) this.f13183c);
                intent.putExtra("strategy_package_name", context.getPackageName());
                intent.putExtra("push_id", (String) null);
                intent.putExtra("strategy_type", 8);
                intent.putExtra("strategy_child_type", this.f1993e);
                intent.putExtra("strategy_params", (String) null);
                return new Intent[]{intent};
            default:
                Intent intent2 = new Intent();
                intent2.putExtra("app_id", (String) this.f13182b);
                intent2.putExtra("app_key", (String) this.f13183c);
                intent2.putExtra("strategy_package_name", context.getPackageName());
                intent2.putExtra("push_id", (String) null);
                intent2.putExtra("strategy_type", 4);
                intent2.putExtra("strategy_child_type", this.f1993e);
                intent2.putExtra("strategy_params", (String) null);
                return new Intent[]{intent2};
        }
    }

    @Override // k.AbstractC0650d
    public final String g() {
        switch (this.f1992d) {
            case 0:
                return "sub_alias_status";
            default:
                return "sub_tags_status";
        }
    }

    @Override // k.AbstractC0650d
    public final boolean h() {
        switch (this.f1992d) {
            case 0:
                if (!TextUtils.isEmpty((String) this.f13182b) && !TextUtils.isEmpty((String) this.f13183c) && !TextUtils.isEmpty(null)) {
                    break;
                }
                break;
            default:
                if (!TextUtils.isEmpty((String) this.f13182b) && !TextUtils.isEmpty((String) this.f13183c) && !TextUtils.isEmpty(null)) {
                    break;
                }
                break;
        }
        return true;
    }
}
