package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes11.dex */
public final class w5 {
    public w5() {
    }

    public static void a() {
        String r100 = "Expect Not Call In SaaS Env. msg:null";
        ALogger.e("SaaSAssertionUtils", r100, new IllegalAccessError(r100));
    }

    static {
    }
}
