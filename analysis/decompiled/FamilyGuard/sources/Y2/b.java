package Y2;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import d3.C0667c;
import d3.C0668d;
import d3.C0670f;
import d3.C0671g;
import f3.C0720b;
import g3.C0742e;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private C0720b f6479a;

    /* renamed from: Y2.b$b, reason: collision with other inner class name */
    private static class C0091b {

        /* renamed from: a, reason: collision with root package name */
        private static b f6480a = new b();
    }

    private String a(Context context) {
        String str = S2.a.f5232b;
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(O2.b.e())) {
            builderBuildUpon.appendQueryParameter("device_id", O2.b.e());
            map.put("device_id", O2.b.e());
            builderBuildUpon.appendQueryParameter("id_type", "1");
            map.put("id_type", "1");
        } else if (!TextUtils.isEmpty(O2.b.l())) {
            builderBuildUpon.appendQueryParameter("device_id", O2.b.l());
            map.put("device_id", O2.b.l());
            builderBuildUpon.appendQueryParameter("id_type", "2");
            map.put("id_type", "2");
        } else if (!TextUtils.isEmpty(O2.b.c())) {
            builderBuildUpon.appendQueryParameter("device_id", O2.b.c());
            map.put("device_id", O2.b.c());
            builderBuildUpon.appendQueryParameter("id_type", "3");
            map.put("id_type", "3");
        } else {
            if (TextUtils.isEmpty(O2.b.d())) {
                return null;
            }
            builderBuildUpon.appendQueryParameter("device_id", O2.b.d());
            map.put("device_id", O2.b.d());
            builderBuildUpon.appendQueryParameter("id_type", "4");
            map.put("id_type", "4");
        }
        String strF = f(context);
        builderBuildUpon.appendQueryParameter("ter_type", strF);
        map.put("ter_type", strF);
        builderBuildUpon.appendQueryParameter("os_type", "android");
        map.put("os_type", "android");
        String str2 = Build.VERSION.RELEASE;
        builderBuildUpon.appendQueryParameter("os_version", str2);
        map.put("os_version", str2);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strValueOf = String.valueOf(jCurrentTimeMillis);
        builderBuildUpon.appendQueryParameter("ts", strValueOf);
        map.put("ts", strValueOf);
        String strValueOf2 = String.valueOf(jCurrentTimeMillis + new Random().nextInt());
        builderBuildUpon.appendQueryParameter("nonce", strValueOf2);
        map.put("nonce", strValueOf2);
        for (Map.Entry entry : map.entrySet()) {
            C0742e.c("UmidFetcher", "buildGetUri, uriParam: " + ((String) entry.getKey()) + "," + ((String) entry.getValue()));
        }
        builderBuildUpon.appendQueryParameter("sign", C0668d.a("GET", str, map, null));
        return builderBuildUpon.toString();
    }

    private void b(Context context, String str) {
        if (this.f6479a == null) {
            this.f6479a = new C0720b(context, "com.stepos.statsapp.v3.umid");
        }
        this.f6479a.e("UMID", str);
    }

    private String c(Context context) {
        if (this.f6479a == null) {
            this.f6479a = new C0720b(context, "com.stepos.statsapp.v3.umid");
        }
        String strM = this.f6479a.m("UMID", BuildConfig.FLAVOR);
        C0742e.c("UmidFetcher", "getLocalUmId umId:" + strM);
        return strM;
    }

    private String d(Context context) throws Throwable {
        if (!C0667c.c(context)) {
            C0742e.c("UmidFetcher", "getServerUmId, network unavailable");
            return BuildConfig.FLAVOR;
        }
        String strA = a(context);
        if (TextUtils.isEmpty(strA) || !C0670f.a(context)) {
            return BuildConfig.FLAVOR;
        }
        C0742e.c("UmidFetcher", "try getServerUmId... url: " + strA);
        NetResponse netResponseJ = V2.a.e(context).j(strA, "GET", null, null);
        C0742e.c("UmidFetcher", "getServerUmId, response: " + netResponseJ);
        if (netResponseJ != null && netResponseJ.c() == 200 && netResponseJ.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(netResponseJ.a());
                if (jSONObject.getInt("code") != 200) {
                    return BuildConfig.FLAVOR;
                }
                C0742e.c("UmidFetcher", "Successfully posted");
                String string = jSONObject.getJSONObject("value").getString("umid");
                if (TextUtils.isEmpty(string)) {
                    return BuildConfig.FLAVOR;
                }
                C0742e.c("UmidFetcher", "new umId " + string);
                b(context, string);
                return string;
            } catch (JSONException e6) {
                C0742e.l("UmidFetcher", "Exception: " + e6 + " - Cause: " + e6.getCause());
            }
        }
        return BuildConfig.FLAVOR;
    }

    private String e(Context context) {
        String string = Settings.Global.getString(context.getContentResolver(), "stepos_analytic_sdk_umid");
        C0742e.c("UmidFetcher", "getSettingsUmId umId:" + string);
        if (!TextUtils.isEmpty(string)) {
            b(context, string);
        }
        return string;
    }

    private String f(Context context) {
        return C0671g.j(context) ? S2.b.TV.toString() : C0671g.m() ? S2.b.PAD.toString() : C0671g.n() ? S2.b.WEARABLE.toString() : S2.b.PHONE.toString();
    }

    public static b g() {
        return C0091b.f6480a;
    }

    public String h(Context context) {
        return i(context, true);
    }

    public synchronized String i(Context context, boolean z5) {
        try {
            String strC = c(context);
            if (TextUtils.isEmpty(strC)) {
                strC = e(context);
            }
            if (!TextUtils.isEmpty(strC) || !z5) {
                return strC;
            }
            return d(context);
        } catch (Throwable th) {
            throw th;
        }
    }

    private b() {
    }
}
