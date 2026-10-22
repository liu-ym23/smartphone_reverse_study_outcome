package com.baidu.platform.comapi.map;

import android.view.Surface;

/* JADX INFO: loaded from: classes39.dex */
class VulkanDetect {
    public static native long getNativeWindow(Surface r100);

    public static native boolean isSupportedVulkan();

    public static native void releaseNativeWindow(long r100);

    public VulkanDetect() {
    }
}
