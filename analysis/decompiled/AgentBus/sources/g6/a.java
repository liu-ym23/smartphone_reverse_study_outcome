package g6;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.stepos.account.oauth.OAuthConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3851a;

    /* renamed from: b, reason: collision with root package name */
    public String f3852b;

    /* renamed from: c, reason: collision with root package name */
    public String f3853c;

    /* renamed from: d, reason: collision with root package name */
    public String f3854d;

    public a(int i2) {
        this.f3851a = i2;
        switch (i2) {
            case 1:
                break;
            default:
                this.f3852b = getClass().getSimpleName();
                break;
        }
    }

    public static JSONObject d(JSONObject jSONObject, a aVar) throws JSONException {
        if (aVar == null) {
            return null;
        }
        jSONObject.put("app_id", aVar.f3852b);
        jSONObject.put("code", aVar.f3853c);
        jSONObject.put(OAuthConstants.FACTOR_RESULT_MESSAGE, aVar.f3854d);
        return jSONObject;
    }

    public static a e(JSONObject jSONObject, a aVar) {
        if (!jSONObject.isNull("app_id")) {
            aVar.f3852b = jSONObject.getString("app_id");
        }
        if (!jSONObject.isNull("code")) {
            aVar.f3853c = jSONObject.getString("code");
        }
        if (!jSONObject.isNull(OAuthConstants.FACTOR_RESULT_MESSAGE)) {
            aVar.f3854d = jSONObject.getString(OAuthConstants.FACTOR_RESULT_MESSAGE);
        }
        return aVar;
    }

    public abstract a a();

    public abstract String b(a aVar);

    public boolean c(Context context) {
        if ("StepX".equalsIgnoreCase(Build.BRAND)) {
            o6.b.f7769a.execute(new c.b(2, this, context));
            return true;
        }
        j6.a.c(this.f3852b, "please invoke api on device Build-in StepOS");
        return false;
    }

    public abstract Intent[] f(Context context);

    public abstract String g();

    public abstract boolean h();

    public String toString() {
        switch (this.f3851a) {
            case 1:
                return "appId=" + this.f3852b + ", code=" + this.f3853c + ", message=" + this.f3854d;
            default:
                return super.toString();
        }
    }
}
