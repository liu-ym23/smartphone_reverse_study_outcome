package com.stepos.statsapp.v3.lib.plugin.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.personal.info.PersonalInfoHelper;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.net.HttpSecureRequester;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsapp.v3.lib.plugin.utils.NetInfoUtils;
import com.stepos.statsapp.v3.lib.plugin.utils.NetRequestUtil;
import com.stepos.statsapp.v3.lib.plugin.utils.RequestFreqRestrict;
import com.stepos.statsapp.v3.lib.plugin.utils.StepOSUtils;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UmidFetcher {

    /* renamed from: b, reason: collision with root package name */
    private static final String f30892b = "UmidFetcher";

    /* renamed from: c, reason: collision with root package name */
    public static final String f30893c = "com.stepos.statsapp.v3.umid";

    /* renamed from: d, reason: collision with root package name */
    public static final String f30894d = "UMID";

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferencesHelper f30895a;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static UmidFetcher f30896a = new UmidFetcher();

        private b() {
        }
    }

    private void a(Context context, String str) {
        if (this.f30895a == null) {
            this.f30895a = new SharedPreferencesHelper(context, f30893c);
        }
        this.f30895a.commitConfig(f30894d, str);
    }

    private String b(Context context) {
        if (this.f30895a == null) {
            this.f30895a = new SharedPreferencesHelper(context, f30893c);
        }
        String config = this.f30895a.getConfig(f30894d, "");
        Logger.d(f30892b, "getLocalUmId umId:" + config);
        return config;
    }

    private String c(Context context) throws Throwable {
        if (!NetInfoUtils.isOnline(context)) {
            Logger.d(f30892b, "getServerUmId, network unavailable");
            return "";
        }
        String strA = a(context);
        if (TextUtils.isEmpty(strA) || !RequestFreqRestrict.isAllow(context)) {
            return "";
        }
        Logger.d(f30892b, "try getServerUmId... url: " + strA);
        NetResponse netResponseStringPartRequest = HttpSecureRequester.getInstance(context).stringPartRequest(strA, "GET", null, null);
        Logger.d(f30892b, "getServerUmId, response: " + netResponseStringPartRequest);
        if (netResponseStringPartRequest != null && netResponseStringPartRequest.getResponseCode() == 200 && netResponseStringPartRequest.getResponseBody() != null) {
            try {
                JSONObject jSONObject = new JSONObject(netResponseStringPartRequest.getResponseBody());
                if (jSONObject.getInt("code") != 200) {
                    return "";
                }
                Logger.d(f30892b, "Successfully posted");
                String string = jSONObject.getJSONObject(UxipConstants.f30680s).getString("umid");
                if (TextUtils.isEmpty(string)) {
                    return "";
                }
                Logger.d(f30892b, "new umId " + string);
                a(context, string);
                return string;
            } catch (JSONException e10) {
                Logger.w(f30892b, "Exception: " + e10 + " - Cause: " + e10.getCause());
            }
        }
        return "";
    }

    private String d(Context context) {
        String string = Settings.Global.getString(context.getContentResolver(), UxipConstants.ANALYTIC_SDK_UMID);
        Logger.d(f30892b, "getSettingsUmId umId:" + string);
        if (!TextUtils.isEmpty(string)) {
            a(context, string);
        }
        return string;
    }

    private String e(Context context) {
        return StepOSUtils.isBox(context) ? com.stepos.statsapp.v3.lib.plugin.constants.a.TV.toString() : StepOSUtils.isTablet() ? com.stepos.statsapp.v3.lib.plugin.constants.a.PAD.toString() : StepOSUtils.isWearable() ? com.stepos.statsapp.v3.lib.plugin.constants.a.WEARABLE.toString() : com.stepos.statsapp.v3.lib.plugin.constants.a.PHONE.toString();
    }

    public static UmidFetcher getInstance() {
        return b.f30896a;
    }

    public String getUmId(Context context) {
        return getUmId(context, true);
    }

    private UmidFetcher() {
    }

    public synchronized String getUmId(Context context, boolean z10) {
        try {
            String strB = b(context);
            if (TextUtils.isEmpty(strB)) {
                strB = d(context);
            }
            if (!TextUtils.isEmpty(strB) || !z10) {
                return strB;
            }
            return c(context);
        } catch (Throwable th) {
            throw th;
        }
    }

    private String a(Context context) {
        String str = UxipConstants.f30676o;
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(PersonalInfoHelper.getImei())) {
            builderBuildUpon.appendQueryParameter(Parameters.DEVICE_ID, PersonalInfoHelper.getImei());
            map.put(Parameters.DEVICE_ID, PersonalInfoHelper.getImei());
            builderBuildUpon.appendQueryParameter(Parameters.ID_TYPE, "1");
            map.put(Parameters.ID_TYPE, "1");
        } else if (!TextUtils.isEmpty(PersonalInfoHelper.getOaid())) {
            builderBuildUpon.appendQueryParameter(Parameters.DEVICE_ID, PersonalInfoHelper.getOaid());
            map.put(Parameters.DEVICE_ID, PersonalInfoHelper.getOaid());
            builderBuildUpon.appendQueryParameter(Parameters.ID_TYPE, "2");
            map.put(Parameters.ID_TYPE, "2");
        } else if (!TextUtils.isEmpty(PersonalInfoHelper.getAndroidId())) {
            builderBuildUpon.appendQueryParameter(Parameters.DEVICE_ID, PersonalInfoHelper.getAndroidId());
            map.put(Parameters.DEVICE_ID, PersonalInfoHelper.getAndroidId());
            builderBuildUpon.appendQueryParameter(Parameters.ID_TYPE, "3");
            map.put(Parameters.ID_TYPE, "3");
        } else {
            if (TextUtils.isEmpty(PersonalInfoHelper.getEncryptImei())) {
                return null;
            }
            builderBuildUpon.appendQueryParameter(Parameters.DEVICE_ID, PersonalInfoHelper.getEncryptImei());
            map.put(Parameters.DEVICE_ID, PersonalInfoHelper.getEncryptImei());
            builderBuildUpon.appendQueryParameter(Parameters.ID_TYPE, UxipConstants.f30661Y);
            map.put(Parameters.ID_TYPE, UxipConstants.f30661Y);
        }
        String strE = e(context);
        builderBuildUpon.appendQueryParameter(Parameters.TER_TYPE, strE);
        map.put(Parameters.TER_TYPE, strE);
        builderBuildUpon.appendQueryParameter(Parameters.OS_TYPE, UxipConstants.f30662a);
        map.put(Parameters.OS_TYPE, UxipConstants.f30662a);
        String str2 = Build.VERSION.RELEASE;
        builderBuildUpon.appendQueryParameter(Parameters.OS_VERSION, str2);
        map.put(Parameters.OS_VERSION, str2);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strValueOf = String.valueOf(jCurrentTimeMillis);
        builderBuildUpon.appendQueryParameter("ts", strValueOf);
        map.put("ts", strValueOf);
        String strValueOf2 = String.valueOf(jCurrentTimeMillis + new Random().nextInt());
        builderBuildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_NONCE, strValueOf2);
        map.put(Parameters.UXIP_REQUEST_PARAM_NONCE, strValueOf2);
        for (Map.Entry entry : map.entrySet()) {
            Logger.d(f30892b, "buildGetUri, uriParam: " + ((String) entry.getKey()) + Const.STR_MART_COMMA + ((String) entry.getValue()));
        }
        builderBuildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_SIGN, NetRequestUtil.sign("GET", str, map, null));
        return builderBuildUpon.toString();
    }
}
