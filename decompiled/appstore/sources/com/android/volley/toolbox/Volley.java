package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.android.volley.RequestQueue;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public Volley() {
    }

    public static RequestQueue newRequestQueue(Context r10, HttpStack r11) {
        File r12 = new File(r10.getCacheDir(), DEFAULT_CACHE_DIR);
        String r13 = r10.getPackageName();     // Catch: PackageManager.NameNotFoundException -> L8
        PackageInfo r14 = r10.getPackageManager().getPackageInfo(r13, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        String r15 = String.valueOf(r13);     // Catch: PackageManager.NameNotFoundException -> L8
        int r16 = r14.versionCode;     // Catch: PackageManager.NameNotFoundException -> L8
        StringBuilder r17 = new StringBuilder(r15.length() + 12);     // Catch: PackageManager.NameNotFoundException -> L8
        r17.append(r15);     // Catch: PackageManager.NameNotFoundException -> L8
        r17.append(LibrarianImpl.Constants.SEPARATOR);     // Catch: PackageManager.NameNotFoundException -> L8
        r17.append(r16);     // Catch: PackageManager.NameNotFoundException -> L8
    L4:
        if (r11 != null) goto L6;
        r11 = new HurlStack();
    L6:
        BasicNetwork r18 = new BasicNetwork(r11);
        RequestQueue r19 = new RequestQueue(new DiskBasedCache(r12), r18);
        r19.start();
        return r19;
    }

    public static RequestQueue newRequestQueue(Context r10) {
        return newRequestQueue(r10, null);
    }
}
