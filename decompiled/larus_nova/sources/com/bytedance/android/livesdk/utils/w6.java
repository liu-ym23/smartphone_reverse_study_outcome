package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.user.IMiddlewareUserService;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class w6 {
    @JvmStatic
    public static final com.bytedance.android.livesdk.user.e a() {
        return ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
    }

    static {
    }
}
