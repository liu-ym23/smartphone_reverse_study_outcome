package com.bytedance.apm.perf;

import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonDataAssembly.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(JSONObject r3, String r4) {
        r3.put(DBHelper.COL_TIME, System.currentTimeMillis());
        r3.put("crash_time", System.currentTimeMillis());
        r3.put("is_main_process", com.bytedance.apm.c.d());
        r3.put("process_name", com.bytedance.apm.c.c());
        r3.put("event_type", r4);
        r3.put(DBHelper.BATTERY_COL_SCENE, ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    public static void a(com.bytedance.apm.d.b.e r5) {
        String r1 = e.a().b();
        JSONObject r2 = r5.f4562e;
        if (r2 != null) goto L14;
        r2 = new JSONObject();
    L14:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L13
    L8:
        r2.put(DBHelper.BATTERY_COL_SCENE, r1);     // Catch: JSONException -> L13
        r2.put("process_name", com.bytedance.apm.c.c());     // Catch: JSONException -> L13
        r2.put("is_main_process", com.bytedance.apm.c.d());     // Catch: JSONException -> L13
        if (r2.isNull("is_front") == false) goto L11;
        r2.put("is_front", ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L13
    L11:
        r5.f4562e = r2;     // Catch: JSONException -> L13
        return;
    }

    public static void a(com.bytedance.apm.d.b.e r1, boolean r2) {
        r1.d(e.a().a(r2));
    }
}
