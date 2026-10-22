package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.android.volley.RequestQueue;
import java.io.File;

/* loaded from: classes.dex */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack, int i4) throws PackageManager.NameNotFoundException {
        File file = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageName);
            sb.append("/");
            sb.append(packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (httpStack == null) {
            httpStack = new HurlStack();
        }
        BasicNetwork basicNetwork = new BasicNetwork(httpStack);
        RequestQueue requestQueue = i4 <= -1 ? new RequestQueue(new DiskBasedCache(file), basicNetwork) : new RequestQueue(new DiskBasedCache(file, i4), basicNetwork);
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context, int i4) {
        return newRequestQueue(context, null, i4);
    }

    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        return newRequestQueue(context, httpStack, -1);
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (HttpStack) null);
    }
}
