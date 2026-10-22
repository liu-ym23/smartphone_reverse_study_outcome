package android.ss.com.vboost.request;

import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4731a = "a";

    public static Object a(d r100) {
        if (android.ss.com.vboost.i.c.e().a(r100) == true) goto L5;
        LogUtil.warn(f4731a, "not support this capability!" + r100.f4738a);
        Object r101 = null;
    L9:
        RequestManager.getInstance().completeDirectRequest(r100);
        return r101;
    L5:
        if (r100.f4747j == true) goto L7;
        r101 = android.ss.com.vboost.i.c.e().b(r100);
        goto L9
    L7:
        r101 = android.ss.com.vboost.i.c.e().c(r100);
        goto L9
    }
}
