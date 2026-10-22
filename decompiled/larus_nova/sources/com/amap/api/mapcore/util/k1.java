package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27468a;

    public k1(Context r100) {
        this.f27468a = r100;
    }

    private boolean a(c1 r110) {
        if (r110 == null) goto L43;
        String r100 = r110.getPinyin();
        boolean r101 = a(r100, this.f27468a, "vmap/");
        if (r100.equals("quanguogaiyaotu") == false) goto L7;
        r100 = "quanguo";
    L7:
        boolean r102 = true;
        if (a(r100, this.f27468a, "map/") == true) goto L12;
        if (r101 == true) goto L12;
        boolean r103 = false;
    L13:
        String r104 = a2.b(r110.getUrl());
        Context r105 = this.f27468a;
        if (TextUtils.isEmpty(r104) == true) goto L21;
        String r106 = w3.c(r105);
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106 + "map/" + r104);     // Catch: Exception -> L28 IOException -> L30
        if (r107.exists() == false) goto L44;
        if (a2.a(r107) == true) goto L44;
    L44:
        a2.a(r106 + "map/");     // Catch: Exception -> L24 IOException -> L26
        a2.a(r104, r105);     // Catch: Exception -> L24 IOException -> L26
        boolean r108 = true;
    L32:
        if (r108 == true) goto L36;
        if (r103 == true) goto L36;
        r102 = false;
    L36:
        if (r102 == false) goto L42;
        r110.f27099v.c();
        if (r110.f27103z == false) goto L40;
        r110.f27099v.d();
    L40:
        r110.f27103z = false;
        return r102;
    L42:
        r110.f27099v.a(r110.f27098u.e());
        goto L43
    L26:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();
    L28:
        e = move-exception;
        e.printStackTrace();
    L21:
        r108 = false;
    L12:
        r103 = true;
    L43:
        return false;
    }

    public void b(c1 r100) {
        a(r100);
    }

    private boolean a(String r100, Context r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String r103 = w3.b(r101);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103 + r102 + r100 + ".dat");     // Catch: Exception -> L20 IOException -> L23
        if (r104.exists() == false) goto L26;
        if (a2.a(r104) == true) goto L26;
        return false;
    L26:
        a2.a(r103 + r102);     // Catch: Exception -> L14 IOException -> L17
        a2.a(r100, r101);     // Catch: Exception -> L14 IOException -> L17
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
        return false;
    L23:
        e = move-exception;
        e.printStackTrace();
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
