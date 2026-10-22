package com.stepos.statsapp.v3.lib.plugin.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsapp.v3.lib.plugin.utils.NetInfoUtils;
import com.stepos.statsapp.v3.lib.plugin.utils.NetRequestUtil;
import com.stepos.statsapp.v3.lib.plugin.utils.RequestFreqRestrict;
import com.stepos.statsapp.v3.lib.plugin.utils.StepOSUtils;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigController {
    private static final long REQUEST_INTERVAL = 21600000;
    private static final String TAG = "ConfigController";
    private final String appId;
    private boolean mComplete = false;
    private SharedPreferencesHelper sharedPreferencesHelper;

    public ConfigController(String str) {
        this.appId = str;
    }

    private boolean isLocalEffective() {
        SharedPreferencesHelper sharedPreferencesHelper = this.sharedPreferencesHelper;
        if (sharedPreferencesHelper == null) {
            return false;
        }
        return System.currentTimeMillis() - sharedPreferencesHelper.getConfig(UxipConstants.f30687z, 0L) <= 21600000;
    }

    public String getConfigFromServer(Context context, String str) {
        NetResponse netResponseA;
        if (!StepOSUtils.bootWizardIsCompleted(context)) {
            Logger.d(TAG, "getConfigFromServer fail,  bootWizardIsCompleted is false");
            return null;
        }
        if (!NetInfoUtils.isOnline(context)) {
            Logger.d(TAG, "getConfigFromServer, network unavailable");
            return null;
        }
        HashMap map = new HashMap();
        SharedPreferencesHelper sharedPreferencesHelper = this.sharedPreferencesHelper;
        if (sharedPreferencesHelper != null) {
            String config = sharedPreferencesHelper.getConfig("lastModified", "");
            String config2 = this.sharedPreferencesHelper.getConfig("ETag", "");
            map.put(NetRequestUtil.HEADER_If_Modified_Since, config);
            map.put(NetRequestUtil.HEADER_If_None_Match, config2);
        }
        String string = Uri.parse(UxipConstants.f30677p + str).buildUpon().toString();
        Logger.d(TAG, "try local... cdn url: " + string + ", header: " + map);
        if (!RequestFreqRestrict.isAllow(context)) {
            return null;
        }
        try {
            netResponseA = com.stepos.statsapp.v3.lib.plugin.net.a.a(context).a(string, map);
        } catch (IOException | RuntimeException e10) {
            Logger.e(TAG, "getConfigFromServer error, " + e10);
            netResponseA = null;
        }
        Logger.d(TAG, "getConfigFromServer response: " + netResponseA);
        if (netResponseA == null || netResponseA.getResponseCode() != 200) {
            return null;
        }
        return netResponseA.getResponseBody();
    }

    public boolean isComplete() {
        return this.mComplete && isLocalEffective();
    }

    public void loadConfig(Context context) throws JSONException {
        if (this.mComplete) {
            Logger.d(TAG, "initConfig is complete, please do not repeat");
            return;
        }
        if (this.sharedPreferencesHelper == null) {
            this.sharedPreferencesHelper = new SharedPreferencesHelper(context, UxipConstants.f30684w);
        }
        if (isLocalEffective()) {
            Logger.d(TAG, "initConfig, isLocalTimeout is false");
            String config = this.sharedPreferencesHelper.getConfig(UxipConstants.f30685x, (String) null);
            if (!TextUtils.isEmpty(config)) {
                parseAndApply(config);
                Logger.d(TAG, "initConfig, responseBody: " + config);
                this.mComplete = true;
                return;
            }
        }
        String strB = a.c().b() instanceof V3OfflineEmitter ? com.stepos.statsapp.v3.lib.plugin.emitter.remote.a.a().b(context, this.appId) : getConfigFromServer(context, this.appId);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferencesHelper.edit();
        editorEdit.putLong(UxipConstants.f30687z, System.currentTimeMillis());
        editorEdit.putString(UxipConstants.f30685x, strB);
        editorEdit.apply();
        parseAndApply(strB);
        this.mComplete = true;
    }

    public void parseAndApply(String str) throws JSONException {
        try {
            Logger.d(TAG, "parseConfigJson 1");
            JSONObject jSONObject = new JSONObject(str);
            Logger.d(TAG, "parseConfigJson 2, config json:" + jSONObject);
            Logger.d(TAG, "parseAndApply, version: " + jSONObject.getInt("version"));
            boolean z10 = jSONObject.getBoolean("active");
            JSONObject jSONObject2 = jSONObject.getJSONObject(UxipConstants.f30639C);
            a.c().b().updateConfig(z10, jSONObject2.getBoolean(UxipConstants.f30640D), jSONObject2.getBoolean(UxipConstants.f30641E), jSONObject2.getBoolean(UxipConstants.f30642F), jSONObject2.getLong(UxipConstants.f30643G) * 60000, jSONObject2.getInt(UxipConstants.f30645I), jSONObject2.getLong(UxipConstants.f30644H), jSONObject2.getInt(UxipConstants.f30646J));
            HashMap map = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                String string = jSONObject3.getString("name");
                map.put(string, new com.stepos.statsapp.v3.lib.plugin.tracker.a(string, jSONObject3.getBoolean("active"), jSONObject3.getBoolean("realtime"), jSONObject3.getBoolean(UxipConstants.f30651O)));
            }
            com.stepos.statsapp.v3.lib.plugin.tracker.b bVarH = a.c().h();
            if (bVarH != null) {
                bVarH.a(map);
            }
        } catch (Exception e10) {
            Logger.e(TAG, "parseAndApply error, " + e10.getMessage());
        }
    }
}
