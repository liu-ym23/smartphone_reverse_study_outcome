package Y2;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import b3.C0563a;
import b3.C0565c;
import com.stepos.minor.Minor;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.g;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import d3.C0667c;
import d3.C0668d;
import d3.C0670f;
import d3.C0671g;
import f3.C0720b;
import g3.C0742e;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6476a = false;

    /* renamed from: b, reason: collision with root package name */
    private final String f6477b;

    /* renamed from: c, reason: collision with root package name */
    private C0720b f6478c;

    public a(String str) {
        this.f6477b = str;
    }

    private boolean c() {
        C0720b c0720b = this.f6478c;
        if (c0720b == null) {
            return false;
        }
        return System.currentTimeMillis() - c0720b.l("key_config_last_time", 0L) <= 21600000;
    }

    public String a(Context context, String str) {
        NetResponse netResponseC;
        if (!C0671g.a(context)) {
            C0742e.c("ConfigController", "getConfigFromServer fail,  bootWizardIsCompleted is false");
            return null;
        }
        if (!C0667c.c(context)) {
            C0742e.c("ConfigController", "getConfigFromServer, network unavailable");
            return null;
        }
        HashMap map = new HashMap();
        C0720b c0720b = this.f6478c;
        if (c0720b != null) {
            String strM = c0720b.m("lastModified", BuildConfig.FLAVOR);
            String strM2 = this.f6478c.m("ETag", BuildConfig.FLAVOR);
            map.put(C0668d.f16615c, strM);
            map.put(C0668d.f16614b, strM2);
        }
        String string = Uri.parse(S2.a.f5233c + str).buildUpon().toString();
        C0742e.c("ConfigController", "try local... cdn url: " + string + ", header: " + map);
        if (!C0670f.a(context)) {
            return null;
        }
        try {
            netResponseC = V2.b.a(context).c(string, map);
        } catch (IOException | RuntimeException e6) {
            C0742e.d("ConfigController", "getConfigFromServer error, " + e6);
            netResponseC = null;
        }
        C0742e.c("ConfigController", "getConfigFromServer response: " + netResponseC);
        if (netResponseC == null || netResponseC.c() != 200) {
            return null;
        }
        return netResponseC.a();
    }

    public boolean b() {
        return this.f6476a && c();
    }

    public void d(Context context) throws JSONException {
        if (this.f6476a) {
            C0742e.c("ConfigController", "initConfig is complete, please do not repeat");
            return;
        }
        if (this.f6478c == null) {
            this.f6478c = new C0720b(context, "com.stepos.statsapp.v3.serverconfig");
        }
        if (c()) {
            C0742e.c("ConfigController", "initConfig, isLocalTimeout is false");
            String strM = this.f6478c.m("response", null);
            if (!TextUtils.isEmpty(strM)) {
                e(strM);
                C0742e.c("ConfigController", "initConfig, responseBody: " + strM);
                this.f6476a = true;
                return;
            }
        }
        String strL = f.m().j() instanceof V3OfflineEmitter ? g.c().l(context, this.f6477b) : a(context, this.f6477b);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        SharedPreferences.Editor editorH = this.f6478c.h();
        editorH.putLong("key_config_last_time", System.currentTimeMillis());
        editorH.putString("response", strL);
        editorH.apply();
        e(strL);
        this.f6476a = true;
    }

    public void e(String str) throws JSONException {
        try {
            C0742e.c("ConfigController", "parseConfigJson 1");
            JSONObject jSONObject = new JSONObject(str);
            C0742e.c("ConfigController", "parseConfigJson 2, config json:" + jSONObject);
            C0742e.c("ConfigController", "parseAndApply, version: " + jSONObject.getInt("version"));
            boolean z5 = jSONObject.getBoolean("active");
            JSONObject jSONObject2 = jSONObject.getJSONObject("uploadPolicy");
            f.m().j().i(z5, jSONObject2.getBoolean("onStart"), jSONObject2.getBoolean("onCharge"), jSONObject2.getBoolean("onReconnect"), jSONObject2.getLong("interval") * 60000, jSONObject2.getInt("cacheCapacity"), jSONObject2.getLong("mobileQuota"), jSONObject2.getInt("neartimeInterval"));
            HashMap map = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                String string = jSONObject3.getString(Minor.COLUMN_NAME);
                map.put(string, new C0563a(string, jSONObject3.getBoolean("active"), jSONObject3.getBoolean("realtime"), jSONObject3.getBoolean("neartime")));
            }
            C0565c c0565cQ = f.m().q();
            if (c0565cQ != null) {
                c0565cQ.g(map);
            }
        } catch (Exception e6) {
            C0742e.d("ConfigController", "parseAndApply error, " + e6.getMessage());
        }
    }
}
