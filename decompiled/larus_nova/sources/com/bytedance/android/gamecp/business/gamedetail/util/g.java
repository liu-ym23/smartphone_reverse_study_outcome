package com.bytedance.android.gamecp.business.gamedetail.util;

import com.bytedance.android.gamecp.common.setting.config.h1;
import java.util.List;
import wu.u0;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f55636a;

    public static List a() {
        h1 r100 = u0.f561396a.getValue();
        if (r100 == null) goto L5;
        List<String> r101 = r100.d();
    L7:
        if (f55636a == true) goto L9;
        f55636a = true;
        yr.c.e("GameDetailLynxLazy", "lazyRenderList = " + r101);
    L9:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public static boolean b() {
        List r100 = a();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    static {
    }
}
