package com.baidu.mshield.b.e;

import android.content.Context;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public class b {
    public static NetworkInfo a(Context context) {
        com.baidu.mshield.b.c.a.a("---privacy getActiveNetworkInfo---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.e.b.a(context).a();
    }
}
