package com.bytedance.android.ec.core.anchorv3;

import android.text.TextUtils;
import com.bytedance.android.ec.base.service.ECServiceManager;
import jd3.w;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43797a = 0;

    static {
    }

    public static String a(String r100) {
        if (TextUtils.equals(r100, "search_result_card") == false) goto L5;
        boolean r101 = ECServiceManager.f42805a;
        return ((s83.g) ECServiceManager.c(s83.g.class)).S("ecommerce");
    L5:
        return null;
    }

    public static void b(String r100) {
        jd3.q r101 = new jd3.q();
        r101.f498414a = r100;
        r101.post(null, null);
    }

    public static void c(int r100, String r101, String r102, Throwable r103) {
        int r104 = a63.a.f1951a;
        int r105 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        w r106 = new w();
        r106.setResult(r100);
        r106.f498549b = r102;
        if (r103 == null) goto L5;
        String r107 = r103.getMessage();
    L6:
        r106.f498550c = r107;
        r106.f498551d = r101;
        r106.post(null, null);
        return;
    L5:
        r107 = null;
        goto L6
    }
}
