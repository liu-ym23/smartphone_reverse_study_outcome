package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: CronetUrlRequestMapping.java */
/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, CronetUrlRequest> f38158a;

    static {
        f38158a = new ConcurrentHashMap();
    }

    public static void a(String r1, CronetUrlRequest r2) {
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (r2 == null) goto L8;
        f38158a.put(r1, r2);
        return;
    L8:
        return;
    }

    public static void a(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        f38158a.remove(r1);
        return;
    }

    public static CronetUrlRequest b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        return (CronetUrlRequest) ZeusTransformUtils.preCheckCast(f38158a.get(r2), CronetUrlRequest.class, "com.obric.aiagent.plugin");
    }
}
