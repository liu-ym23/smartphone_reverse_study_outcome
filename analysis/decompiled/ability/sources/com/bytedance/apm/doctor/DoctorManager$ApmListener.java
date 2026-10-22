package com.bytedance.apm.doctor;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface DoctorManager$ApmListener {
    void onDataEvent(int i, String str, JSONObject jSONObject);

    void onEvent(String str, String str2);
}
