package com.bytedance.android.shopping.feed.utils;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f175469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f175470b;

    static {
    }

    public static s a(String r100) {
        if (r100 != null) goto L22;
        return null;
    L22:
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), com.bytedance.android.ec.core.event.a.VALUE_MEMBER);     // Catch: Exception -> L21
        if (r101 == null) goto L20;
        int r102 = r101.optInt("membership_status");     // Catch: Exception -> L21
        String r103 = r101.optString("button_text");     // Catch: Exception -> L21
        String r104 = r101.optString("join_member_url");     // Catch: Exception -> L21
        String r105 = JSONObjectProtectorUtils.getString(r101, "default_text");     // Catch: Exception -> L21
        if (r102 <= 0) goto L20;
        boolean r106 = false;
        if (r103.length() <= 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L20;
        if (r104.length() <= 0) goto L17;
        r106 = true;
    L17:
        if (r106 == false) goto L20;
        return new s(r102, r103, r104, r105);
    L12:
        r107 = false;
    L20:
        return null;
    }
}
