package com.bytedance.android.gamecp.common.download;

import bw.j;
import com.ss.android.download.api.config.DownloadEventLogger;
import com.ss.android.download.api.model.DownloadEventModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements DownloadEventLogger {
    public g() {
    }

    @Override // com.ss.android.download.api.config.DownloadEventLogger
    public void onEvent(DownloadEventModel r100) {
        Intrinsics.checkNotNullParameter(r100, "eventModel");
    }

    @Override // com.ss.android.download.api.config.DownloadEventLogger
    public final void onV3Event(DownloadEventModel r100) {
        Intrinsics.checkNotNullParameter(r100, "eventModel");
        j r101 = com.bytedance.android.gamecp.host_api.a.b().getLogService();
        String r102 = r100.getV3EventName();
        int r103 = com.bytedance.android.gamecp.common.track.b.f56775a;
        r101.logV3(r102, com.bytedance.android.gamecp.common.track.b.e(r100.getV3EventParams()));
    }
}
