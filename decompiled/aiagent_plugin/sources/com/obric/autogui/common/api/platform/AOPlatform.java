package com.obric.autogui.common.api.platform;

import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.DynamicProxy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOPlatform {
    public static final AOPlatform INSTANCE = null;
    private static final String TAG = "AOPlatform";
    private static AOPlatformInterface mPlatform;

    static {
        INSTANCE = new AOPlatform();
    }

    private AOPlatform() {
    }

    public final boolean isInitialized() {
        if (mPlatform == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final AOPlatformInterface getPlatform() {
        AOPlatformInterface r2 = mPlatform;
        if (r2 == null) goto L5;
        return r2;
    L5:
        Loog.INSTANCE.e(TAG, "The Platform interface isn't initialized.");
        throw new IllegalStateException("Not initialised Platform.");
    }

    public final void init() {
        AOPlatformProviderInterface r5 = (AOPlatformProviderInterface) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(AOPlatformProviderInterface.class), AOPlatformProviderInterface.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L9:
        Loog.INSTANCE.e(TAG, "Cannot initialise the Platform interface.");
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, DynamicProxy.class) == true) goto L9;
        AOPlatformInterface r6 = r5.getPlatform();
        Loog.INSTANCE.i(TAG, "[O-Auto] Platform initialize: " + r6.getInformation() + ", " + r6.init() + '.');
        mPlatform = r6;
    }
}
