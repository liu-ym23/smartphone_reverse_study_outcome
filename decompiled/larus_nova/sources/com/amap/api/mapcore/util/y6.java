package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f28437a;

    static {
        f28437a = new HashMap();
    }

    public static String a(Context r100, w5 r101, String r102) {
        if (r101 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101.d()) == true) goto L20;
        String r103 = f28437a.get(r101.d() + r102);
        if (TextUtils.isEmpty(r103) == true) goto L9;
        return r103;
    L9:
        String r104 = r102 + r101.d();
        if (r100 != null) goto L12;
        return "";
    L12:
        if (TextUtils.isEmpty(r104) == false) goto L15;
        return "";
    L15:
        return x5.c(j5.a(x5.c(r100.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(r104, ""))));
    L20:
        return null;
    }

    public static void a(Context r100, w5 r101, String r102, String r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101.d()) == true) goto L21;
        String r104 = r102 + r101.d();
        f28437a.put(r101.d() + r102, r103);
        if (r100 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") == false) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r103) == true) goto L23;
        String r105 = x5.b(j5.b(x5.e(r103)));
        SharedPreferences.Editor r106 = r100.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        r106.putString(r104, r105);
        r106.commit();
        return;
    L23:
        return;
    }
}
