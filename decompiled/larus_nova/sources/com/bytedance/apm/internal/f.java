package com.bytedance.apm.internal;

import android.text.TextUtils;
import com.bytedance.apm.doctor.DoctorManager;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements DoctorManager.ApmListener {
    public f() {
    }

    @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
    public final void onEvent(String r100, String r101) {
        a("onEvent key=" + r100, r101, false);
    }

    public static void a(String r100, String r110, boolean r111) {
        int r101 = (4000 - r100.length()) - 5;
        if (r110.length() > r101) goto L8;
        if (r111 == false) goto L6;
        ps3.b.a(new String[]{r100, " ".concat(r110)});
        return;
    L6:
        ps3.b.a(new String[]{r100, " ".concat(r110)});
        return;
    L8:
        int r102 = 0;
    L10:
        if (r102 >= r110.length()) goto L19;
        int r103 = r102 + r101;
        if (r103 >= r110.length()) goto L14;
        String r104 = r110.substring(r102, r103);
    L15:
        if (r111 == false) goto L17;
        ps3.b.a(new String[]{r100, " " + r104});
    L18:
        r102 = r103;
        goto L10
    L17:
        ps3.b.a(new String[]{r100, " " + r104});
        goto L18
    L14:
        r104 = r110.substring(r102);
        goto L15
    }

    @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
    public final void onDataEvent(int r100, String r101, JSONObject r102) {
        if (TextUtils.equals(r101, "DATA_CACHE") == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r101, "DATA_SEND_END") == false) goto L7;
        return;
    L7:
        if (TextUtils.equals(r101, "DATA_SEND_RESPONSE") == false) goto L10;
        return;
    L10:
        if (TextUtils.equals(r101, "DATA_RECEIVE") == true) goto L12;
    L14:
        a("onDataEvent[" + r100 + "] " + r101 + " [service:" + r102.optString("service") + "|logType:" + r102.optString(FrescoMonitorConst.LOG_TYPE) + "] = ", r102.toString(), r101.contains("ERROR"));
        return;
    L12:
        if (r102.optJSONObject("DATA_DOCTOR").optBoolean("DATA_SAMPLE") == true) goto L14;
        r101 = "DATA_NOT_SAMPLED";
        goto L14
    }
}
