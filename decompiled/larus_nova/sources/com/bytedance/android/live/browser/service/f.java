package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements com.bytedance.android.live.browser.utils.i {
    public f() {
    }

    @Override // com.bytedance.android.live.browser.utils.i
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        ALogger.i("AnnieAbilityProviderImpl", "onScreenCapture filePath = " + r100);
        EventCenter.enqueueEvent(new Event("H5_screenShot", System.currentTimeMillis(), null));
    }
}
