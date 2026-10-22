package com.bytedance.framwork.core.sdklib.util;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static boolean a(JSONArray r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }
}
