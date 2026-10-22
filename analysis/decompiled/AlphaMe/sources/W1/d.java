package W1;

import a2.AbstractC0155a;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d2.AbstractC0536a;
import d2.C0537b;
import k.AbstractC0650d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d extends AbstractC0650d {
    @Override // k.AbstractC0650d
    public final AbstractC0536a d() {
        C0537b c0537b = new C0537b();
        String str = (String) this.f13182b;
        c0537b.f12416a = str;
        c0537b.f12417b = "20001";
        if (TextUtils.isEmpty(str)) {
            c0537b.f12418c = "appId is empty";
        } else if (TextUtils.isEmpty((String) this.f13183c)) {
            c0537b.f12418c = "appKey is empty";
        } else if (TextUtils.isEmpty(null)) {
            c0537b.f12418c = "pushId is empty";
        }
        return c0537b;
    }

    @Override // k.AbstractC0650d
    public final String e(AbstractC0536a abstractC0536a) throws JSONException {
        C0537b c0537b = (C0537b) abstractC0536a;
        AbstractC0155a.a("BasicStatus", "switch status to string start");
        AbstractC0155a.a("BasicStatus", "switch status to string start: " + c0537b);
        try {
            JSONObject jSONObjectA = AbstractC0536a.a(new JSONObject(), c0537b);
            if (!TextUtils.isEmpty(c0537b.f12421f)) {
                jSONObjectA.put("push_id", c0537b.f12421f);
            }
            jSONObjectA.put("is_switch_notification", c0537b.f12419d);
            jSONObjectA.put("is_switch_through", c0537b.f12420e);
            String string = jSONObjectA.toString();
            AbstractC0155a.b("BasicStatus", "switch status success, statusText: " + string);
            return string;
        } catch (JSONException e4) {
            AbstractC0155a.c("BasicStatus", "switch status error, " + e4.getMessage());
            return null;
        }
    }

    @Override // k.AbstractC0650d
    public final Intent[] f(Context context) {
        Intent intent = new Intent();
        intent.putExtra("app_id", (String) this.f13182b);
        intent.putExtra("app_key", (String) this.f13183c);
        intent.putExtra("strategy_package_name", context.getPackageName());
        intent.putExtra("push_id", (String) null);
        intent.putExtra("strategy_type", 16);
        intent.putExtra("strategy_child_type", 0);
        intent.putExtra("strategy_params", "0");
        return new Intent[]{intent};
    }

    @Override // k.AbstractC0650d
    public final String g() {
        return "push_status";
    }

    @Override // k.AbstractC0650d
    public final boolean h() {
        return (TextUtils.isEmpty((String) this.f13182b) || TextUtils.isEmpty((String) this.f13183c) || TextUtils.isEmpty(null)) ? false : true;
    }
}
