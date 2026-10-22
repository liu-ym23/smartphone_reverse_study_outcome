package com.baidu.sec.privacy.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.sec.privacy.f.e;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f9436a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f9437b;

    public b(Context context) {
        f9437b = context;
    }

    public static b a(Context context) {
        if (f9436a == null) {
            synchronized (b.class) {
                f9436a = new b(context);
            }
        }
        return f9436a;
    }

    @SuppressLint({"MissingPermission"})
    public NetworkInfo a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f9437b.getSystemService("connectivity");
            if (e.a(f9437b, new String[]{"android.permission.ACCESS_NETWORK_STATE"})) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return null;
        }
    }
}
