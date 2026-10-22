package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.gamecp.business.download.GameCenterStrategy$doSubscribe$1;
import com.bytedance.android.livehostapi.business.depend.ad.GameDownloadInfo;
import com.bytedance.android.livehostapi.business.depend.ad.IAdDownloadListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements IAdDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dw.c f125445a;

    public h(GameCenterStrategy$doSubscribe$1 r100) {
        this.f125445a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ad.IAdDownloadListener
    public final void downloadStateChange(GameDownloadInfo r210) {
        Intrinsics.checkNotNullParameter(r210, "gameDownloadInfo");
        dw.a r100 = new dw.a(0, 0, 0, 0, 0, null, 0, false, null, null, 0, null, 0, 0, null, 32767);
        r100.f470287c = r210.getCurrentBytes();
        r100.f470294j = r210.getEnableFeature();
        r100.f470291g = r210.getFailStatus();
        r100.f470290f = r210.getFileName();
        r100.f470292h = r210.getOnlyWifi();
        r100.f470293i = r210.getReserveInfo();
        r100.f470285a = r210.getStatus();
        r100.f470286b = r210.getTotalBytes();
        dw.c r101 = this.f125445a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
