package com.bytedance.android.live.openplatform.api.utils;

import am2.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class e {
    public static boolean b() {
        if (new JSONObject(n.f().d()).optInt("system_origin") != 15) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean a() {
        if (n.f().d().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
    }
}
