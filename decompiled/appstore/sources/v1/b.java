package v1;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.core.ActivityLifeObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static void a(m1.e r10, boolean r11) {
        r10.a(e.a().b(r11));
    }

    public static void b(JSONObject r10, String r11) {
        r10.put("timestamp", System.currentTimeMillis());
        r10.put(CommonKey.KEY_CRASH_TIME, System.currentTimeMillis());
        r10.put("is_main_process", w0.c.F());
        r10.put("process_name", w0.c.h());
        r10.put("event_type", r11);
        r10.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    public static void c(m1.e r10) {
        String r11 = e.a().c();
        JSONObject r12 = r10.f22046f;
        if (r12 != null) goto L14;
        r12 = new JSONObject();
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        r11 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L13
    L8:
        r12.put("scene", r11);     // Catch: JSONException -> L13
        r12.put("process_name", w0.c.h());     // Catch: JSONException -> L13
        r12.put("is_main_process", w0.c.F());     // Catch: JSONException -> L13
        if (r12.isNull(CommonKey.KEY_IS_FRONT) == false) goto L11;
        r12.put(CommonKey.KEY_IS_FRONT, ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L13
    L11:
        r10.f22046f = r12;     // Catch: JSONException -> L13
        return;
    }
}
