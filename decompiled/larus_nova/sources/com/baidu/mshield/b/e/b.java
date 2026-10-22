package com.baidu.mshield.b.e;

import android.content.Context;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes39.dex */
public class b {
    public static NetworkInfo a(Context r100) {
        com.baidu.mshield.b.c.a.a("---privacy getActiveNetworkInfo---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.b.a(r100).a();
    }
}
