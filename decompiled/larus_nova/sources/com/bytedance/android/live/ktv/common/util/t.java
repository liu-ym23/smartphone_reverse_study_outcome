package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: classes45.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedPrefHelper f70701a = null;

    static {
        f70701a = SharedPrefHelper.b(s1.getContext());
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder("KtvRoom");
        IMiddlewareUserService r101 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.user.e r102 = r101.user();
        if (r102 == null) goto L8;
        Object r103 = r102.n();
        if (r103 == null) goto L8;
    L9:
        r100.append(r103);
        return r100.toString();
    L8:
        r103 = 0L;
        goto L9
    }
}
