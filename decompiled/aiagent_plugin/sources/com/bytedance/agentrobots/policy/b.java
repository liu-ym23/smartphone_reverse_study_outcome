package com.bytedance.agentrobots.policy;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: OemGroupResolver.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "OemGroupResolver";

    /* JADX INFO: compiled from: OemGroupResolver.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4044b;

        public a(String r2, String r3) {
            String r0 = "";
            if (r2 == null) goto L5;
            String r4 = r2.toLowerCase();
        L6:
            this.f4043a = r4;
            if (r3 == null) goto L9;
            r0 = r3.toLowerCase();
        L9:
            this.f4044b = r0;
            return;
        L5:
            r4 = "";
            goto L6
        }
    }

    public static a a() {
        return new a(Build.BRAND, Build.MANUFACTURER);
    }

    public static JSONObject a(JSONArray r9, a r10) {
        if (r9 != null) goto L5;
    L35:
        return null;
    L5:
        if (r9.length() == 0) goto L35;
        if (r10 == null) goto L35;
        int r2 = 0;
    L10:
        if (r2 >= r9.length()) goto L34;
        JSONObject r3 = r9.optJSONObject(r2);
        if (r3 == null) goto L33;
        JSONArray r5 = r3.optJSONArray("brands");
        if (r5 == null) goto L33;
        if (r5.length() == 0) goto L33;
        int r6 = 0;
    L21:
        if (r6 >= r5.length()) goto L33;
        String r7 = r5.optString(r6, "").toLowerCase();
        if (TextUtils.isEmpty(r7) == true) goto L30;
        if (r7.equals(r10.f4043a) == true) goto L31;
        if (r7.equals(r10.f4044b) == false) goto L30;
    L31:
        a(TAG, "Matched oem_group");
        return r3;
    L30:
        r6 = r6 + 1;
    L33:
        r2 = r2 + 1;
        goto L10
    L34:
        a(TAG, "No matching oem_group found");
        goto L35
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
