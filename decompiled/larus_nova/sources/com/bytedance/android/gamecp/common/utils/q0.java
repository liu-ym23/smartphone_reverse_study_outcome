package com.bytedance.android.gamecp.common.utils;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes44.dex */
public final class q0 {
    @JvmStatic
    public static final boolean a() {
        LocalTestManager.a(new Class[]{uv.a.class});
        return "Android_Pad".equals(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getDevicePlatform());
    }

    static {
    }
}
