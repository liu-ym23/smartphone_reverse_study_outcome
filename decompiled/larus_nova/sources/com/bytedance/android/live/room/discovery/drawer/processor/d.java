package com.bytedance.android.live.room.discovery.drawer.processor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i(LogFilterName.LIVE_DRAWER_LOG, r100);
    }
}
