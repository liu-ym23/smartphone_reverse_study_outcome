package com.stepos.pps.data.ouc.cloud;

import android.text.TextUtils;
import com.stepos.pps.data.util.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UserConfig {
    private static final String BUILD_BETA = "beta";
    private static final String BUILD_MP = "mp";
    private static final String KEY_FEATURE_FLAGS = "featureFlags";
    private static final String KEY_USER_TYPE = "userType";
    private static final String KEY_VERSION = "version";
    private static final String TAG = "CloudUserConfig";
    public static final String USER_BETA = "beta";
    public static final String USER_MP = "mp";
    public static final String USER_TEST = "test";
    private int version = 0;
    private final Map<String, String> userType = new HashMap();
    private final Map<String, Boolean> featureFlags = new HashMap();

    public int getVersion() {
        return this.version;
    }

    public String getUserType(String str) {
        return this.userType.get(str);
    }

    public Map<String, String> getUserTypeMap() {
        return new HashMap(this.userType);
    }

    public boolean getFeatureFlag(String str, boolean z) {
        Boolean bool = this.featureFlags.get(str);
        return bool != null ? bool.booleanValue() : z;
    }

    public Map<String, Boolean> getFeatureFlags() {
        return new HashMap(this.featureFlags);
    }

    public boolean isEmpty() {
        return this.version == 0 && this.userType.isEmpty() && this.featureFlags.isEmpty();
    }

    public String resolveUserType(String str) {
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        return "beta".equals(lowerCase) ? "1".equals(this.userType.get("beta")) ? "beta" : USER_TEST : (!"mp".equals(lowerCase) || "0".equals(this.userType.get("mp"))) ? USER_TEST : "mp";
    }

    public static UserConfig fromJson(String str) {
        UserConfig userConfig = new UserConfig();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                userConfig.version = jSONObject.optInt(KEY_VERSION, 0);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(KEY_USER_TYPE);
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        userConfig.userType.put(next, jSONObjectOptJSONObject.optString(next, null));
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(KEY_FEATURE_FLAGS);
                if (jSONObjectOptJSONObject2 != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        userConfig.featureFlags.put(next2, Boolean.valueOf(jSONObjectOptJSONObject2.optBoolean(next2, false)));
                    }
                }
            } catch (Exception e) {
                LogUtil.e(TAG, "fromJson error: " + e.getMessage());
            }
        }
        return userConfig;
    }

    public String toJson() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_VERSION, this.version);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : this.userType.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put(KEY_USER_TYPE, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, Boolean> entry2 : this.featureFlags.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject.put(KEY_FEATURE_FLAGS, jSONObject3);
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtil.e(TAG, "toJson error: " + e.getMessage());
            return "";
        }
    }

    public String toString() {
        return "UserConfig{version=" + this.version + ", userType=" + this.userType + ", featureFlags=" + this.featureFlags + '}';
    }
}
