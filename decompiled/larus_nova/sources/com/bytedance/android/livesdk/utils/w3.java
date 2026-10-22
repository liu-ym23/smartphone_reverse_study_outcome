package com.bytedance.android.livesdk.utils;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostPerformanceHelper;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.config.b40;
import com.bytedance.android.livesdk.config.s41;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s41 f159202a = null;

    static {
        f159202a = b40.f119842a.getValue();
    }

    @JvmStatic
    public static final void a(int r100, Activity r101) {
        if (f159202a.enable == false) goto L13;
        if (r100 < 0) goto L14;
        if (r101 == null) goto L17;
        com.bytedance.android.livesdk.service.h r102 = TTLiveSDKContext.getHostService();
        if (r102 == null) goto L15;
        IHostPerformanceHelper r103 = ((com.bytedance.android.livesdk.service.f) r102).g();
        if (r103 == null) goto L16;
        r103.dropFrameByKita(r100, r101);
        return;
    L16:
        return;
    L15:
        return;
    L17:
        return;
    L14:
        return;
    }
}
