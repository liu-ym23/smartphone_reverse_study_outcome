package com.bytedance.crypto.utils;

import com.bytedance.crypto.bridge.ITeaBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TeaTracker {
    private static final String TAG = "TeaTracker";
    private static ITeaBridge mTeaBridge;

    public TeaTracker() {
    }

    public static String getDeviceId() {
        ITeaBridge r0 = mTeaBridge;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.onGetDeviceId();
    }

    public static void init(ITeaBridge r2) {
        mTeaBridge = (ITeaBridge) ZeusTransformUtils.wrapperContextForParams(r2, ITeaBridge.class, "com.obric.aiagent.plugin");
    }
}
