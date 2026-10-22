package r3;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static List a(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        if (r10.optInt("wrapper_type_description", -1) == 1) goto L9;
        r11.add(r10);
        return r11;
    L9:
        JSONArray r12 = r10.optJSONArray("wrapper_array_data");
        if (r12 != null) goto L12;
        return null;
    L12:
        int r13 = 0;
    L14:
        if (r13 >= r12.length()) goto L17;
        r11.add(r12.get(r13));     // Catch: Exception -> L18
    L16:
        r13 = r13 + 1;
        goto L14
    L17:
        return r11;
    }

    public static JSONObject b(String r10, JSONArray r11) {
        JSONObject r12 = new JSONObject().put("wrapper_array_data", r11);     // Catch: Exception -> L4
        r12.put("log_type", r10);     // Catch: Exception -> L4
        r12.put("wrapper_type_description", 1);     // Catch: Exception -> L4
        return r12;
    L4:
        return null;
    }
}
