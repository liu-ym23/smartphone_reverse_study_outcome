package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f18802a;

    static {
        f18802a = new ConcurrentHashMap();
    }

    public static void a(String r10, CronetUrlRequest r11) {
        if (TextUtils.isEmpty(r10) == true) goto L7;
        if (r11 == null) goto L8;
        f18802a.put(r10, r11);
        return;
    L8:
        return;
    }

    public static CronetUrlRequest b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        return (CronetUrlRequest) f18802a.get(r10);
    }

    public static void c(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        f18802a.remove(r10);
        return;
    }
}
