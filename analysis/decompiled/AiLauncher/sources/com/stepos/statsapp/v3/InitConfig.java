package com.stepos.statsapp.v3;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class InitConfig {
    public static boolean noBootUp = false;
    public static boolean printLog = false;
    public static String replacePackage = "";

    public static class Channel {
        public static final int M_LINK = 4;
        public static final int STEPOS = 0;
    }

    public InitConfig replacePackage(String str) {
        Log.d("UsageStatsProxy3", "##### InitConfig replacePackage: " + str);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("InitConfig - replacePackage can't be empty if set");
        }
        replacePackage = str;
        return this;
    }

    public InitConfig setForceOffline(boolean z10) {
        return this;
    }

    public InitConfig setNoBootUp(boolean z10) {
        noBootUp = z10;
        return this;
    }

    public InitConfig setNoEncrypt(boolean z10) {
        return this;
    }

    public InitConfig setOffline(boolean z10) {
        return this;
    }

    public InitConfig setPrintLog(boolean z10) {
        printLog = z10;
        return this;
    }

    public InitConfig setReportChannel(int i10) {
        return this;
    }

    public InitConfig setSendEventSync(boolean z10) {
        return this;
    }

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("noBootUp", noBootUp);
            jSONObject.put("replacePackage", replacePackage);
            jSONObject.put("printLog", printLog);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }
}
