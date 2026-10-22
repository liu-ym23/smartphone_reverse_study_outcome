package com.bytedance.android.shopping.anchorv4.helper;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, u> f166991a = null;

    static {
        f166991a = new LinkedHashMap();
    }

    public static u a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        u r101 = f166991a.get(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        return null;
    }
}
