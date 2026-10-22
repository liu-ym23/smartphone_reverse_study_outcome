package com.blankj.utilcode.util;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static String a(byte[] r10) {
        if (r10 != null) goto L4;
        return "";
    L4:
        if (r10.length != 0) goto L7;
        return "";
    L7:
        return Base64.encodeToString(r10, 2);
    }
}
