package com.bytedance.ttnet.throttle;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.b.i;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TTNetThrottle {
    public static final int DIRECTION_TYPE_DOWN = 2;
    public static final int DIRECTION_TYPE_PC_DOWN = 8;
    public static final int DIRECTION_TYPE_PC_UP = 4;
    public static final int DIRECTION_TYPE_UP = 1;
    private static final String TAG = "TTNetThrottle";

    public TTNetThrottle() {
    }

    public static void start(String[] r2, int r3, long r4) {
        if (r2 == null) goto L20;
        if (r3 == 1) goto L12;
        if (r3 == 2) goto L12;
        if (r3 == 4) goto L12;
        if (r3 != 8) goto L20;
    L12:
        if (r4 < 0) goto L20;
        getCronetHttpClient().a(r2, r3, r4);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L20:
        if (Logger.debug() == false) goto L26;
        Logger.e(TAG, "start throttle params error hosts:" + r2 + " directionType:" + r3 + " bytesPerSec:" + r4);
        return;
    }

    public static void stop(String[] r2, int r3) {
        if (r2 == null) goto L18;
        if (r3 != 1) goto L6;
    L21:
        getCronetHttpClient().a(r2, r3);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (r3 == 2) goto L21;
        if (r3 == 4) goto L21;
        if (r3 == 8) goto L21;
    L18:
        if (Logger.debug() == false) goto L24;
        Logger.e(TAG, "stop throttle params error hosts:" + r2 + " directionType:" + r3);
        return;
    }

    private static i getCronetHttpClient() {
        if (c.b() == false) goto L7;
        return i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }
}
