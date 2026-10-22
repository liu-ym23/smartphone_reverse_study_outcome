package M0;

import androidx.core.app.NotificationCompat;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e {
    public static void a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                JSONArray jSONArray2 = jSONObjectOptJSONObject.getJSONArray(SettingsConfig.KEY_DATA);
                JSONArray jSONArray3 = new JSONArray();
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    int length2 = jSONArray2.length();
                    for (int i6 = 0; i6 < length2; i6++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i6);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("payload", jSONObjectOptJSONObject2);
                        jSONObject2.put("log_type", jSONObjectOptJSONObject2.opt(NotificationCompat.CATEGORY_SERVICE));
                        jSONArray3.put(jSONObject2);
                    }
                }
                jSONObjectOptJSONObject.put(SettingsConfig.KEY_DATA, jSONArray3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
