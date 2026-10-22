package com.bytedance.android.live.core.utils;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;

/* JADX INFO: loaded from: classes45.dex */
public final class v {
    public static boolean a() {
        if (jc1.k.f(IMiddleWareHostContext.class) != null) goto L5;
        return false;
    L5:
        return ((IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class)).isLocalTest();
    }

    public static boolean b() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isStrictMode();
    }
}
