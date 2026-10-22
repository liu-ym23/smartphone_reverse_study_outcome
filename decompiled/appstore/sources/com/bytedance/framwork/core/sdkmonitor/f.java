package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static boolean a(List r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.size() == 0) goto L7;
        return false;
    }

    public static List b(JSONObject r10, String r11) {
        JSONArray r12 = r10.optJSONArray(r11);     // Catch: Exception -> L15
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.length() <= 0) goto L21;
        int r13 = r12.length();     // Catch: Exception -> L15
        ArrayList r14 = new ArrayList(r13);     // Catch: Exception -> L15
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L12;
        String r16 = r12.getString(r15);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r16) == true) goto L11;
        r14.add(r16);     // Catch: Exception -> L15
    L11:
        r15 = r15 + 1;
        goto L7
    L12:
        return r14;
    L21:
        return null;
    L22:
        return null;
    }

    public static List c(JSONObject r10, String r11) {
        JSONArray r12 = r10.optJSONArray(r11);     // Catch: Exception -> L15
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.length() <= 0) goto L21;
        int r13 = r12.length();     // Catch: Exception -> L15
        ArrayList r14 = new ArrayList(r13);     // Catch: Exception -> L15
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L12;
        String r16 = r12.getString(r15);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r16) == true) goto L11;
        r14.add(Pattern.compile(r16));     // Catch: Exception -> L15
    L11:
        r15 = r15 + 1;
        goto L7
    L12:
        return r14;
    L21:
        return null;
    L22:
        return null;
    }
}
