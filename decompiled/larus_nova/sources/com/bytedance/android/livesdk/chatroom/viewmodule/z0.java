package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.user.IMiddlewareUserService;

/* JADX INFO: loaded from: classes8.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f117682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f117683b;

    static {
        f117682a = true;
    }

    public static String a() {
        com.bytedance.android.livesdk.user.e r100 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
        if (r100.isLogin() == true) goto L7;
        return "unknown";
    L7:
        return r100.n();
    }
}
