package com.bytedance.android.sdk.bdticketguard;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes12.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f163973a = null;

    static {
        f163973a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }

    public static final String a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return String.valueOf(r100);
    L13:
        if (r100.length() >= 30) goto L15;
        return "*****";
    L15:
        return r100.substring(0, 10) + "*****" + r100.substring(r100.length() - 10, r100.length());
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
