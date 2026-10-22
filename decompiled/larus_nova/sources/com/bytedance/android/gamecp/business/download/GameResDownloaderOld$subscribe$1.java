package com.bytedance.android.gamecp.business.download;

import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class GameResDownloaderOld$subscribe$1 implements com.bytedance.gamecenter.base.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f52431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.s f52432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Boolean f52433c;

    @Override // com.bytedance.gamecenter.base.p
    public final void a(DownloadInfo r100) {
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void c(JSONObject r100) {
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void d(JSONObject r100) {
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void e(JSONObject r100) {
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void onInstallFailed(DownloadShortInfo r100, int r101) {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public final void onInstalled(DownloadShortInfo r100) {
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void onJumpInstall(DownloadShortInfo r100, int r101) {
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void onShow() {
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void onUpdate() {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener2
    public final void onWaitingDownloadCompleteHandler(DownloadInfo r100) {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public final void onIdle() {
        this.f52431a.getClass();
        yr.c.a("GameResDownloaderOld", "subscribe onIdle");
        this.f52432b.passThrough(0);
        this.f52432b.onReady();
    }

    @Override // com.bytedance.gamecenter.base.p
    public final void b(DownloadShortInfo r100) {
        this.f52431a.getClass();
        yr.c.a("GameResDownloaderOld", "subscribe onCanceled");
        this.f52432b.passThrough(4);
        this.f52432b.onCancel();
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public final void onDownloadFailed(DownloadShortInfo r100) {
        this.f52431a.getClass();
        StringBuilder r101 = new StringBuilder("subscribe onDownloadFailed percent = ");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.failStatus);
    L6:
        r101.append(r102);
        yr.c.a("GameResDownloaderOld", r101.toString());
        this.f52432b.passThrough(5);
        com.bytedance.android.gamecp.base.core.service.depend.s r103 = this.f52432b;
        int r104 = 0;
        if (r100 == null) goto L9;
        int r105 = r100.failStatus;
    L10:
        if (r100 == null) goto L12;
        r104 = r100.realPercent;
    L12:
        r103.onError(r105, r104);
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public final void onDownloadFinished(DownloadShortInfo r100) {
        this.f52431a.getClass();
        StringBuilder r101 = new StringBuilder("subscribe onDownloadFinished fileName = ");
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.fileName;
    L6:
        r101.append(r103);
        yr.c.a("GameResDownloaderOld", r101.toString());
        this.f52432b.passThrough(3);
        com.bytedance.android.gamecp.base.core.service.depend.s r104 = this.f52432b;
        if (r100 == null) goto L9;
        r102 = r100.fileName;
    L9:
        r104.onDownloaded(r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public final void onDownloadActive(DownloadShortInfo r100, final int r101) {
        this.f52431a.getClass();
        yr.c.a("GameResDownloaderOld", "subscribe onDownloadActive percent = " + r101);
        UtilityKotlinExtentionsKt.g(0, false, false, new GameResDownloaderOld$subscribe$1$onDownloadActive$1(this, r101), 7);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public final void onDownloadPaused(DownloadShortInfo r110, int r210) {
        this.f52431a.getClass();
        yr.c.a("GameResDownloaderOld", "subscribe onDownloadPaused percent = " + r210);
        this.f52432b.passThrough(2);
        this.f52432b.onPause(new com.bytedance.android.gamecp.base.core.service.depend.x(r210, null, 0, null, 0, 0, 0, 0.0f, null, this.f52433c.booleanValue(), 1022));
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public final void onDownloadStart(DownloadModel r100, DownloadController r101) {
        Intrinsics.checkNotNullParameter(r100, "downloadModel");
        this.f52431a.getClass();
        yr.c.a("GameResDownloaderOld", "subscribe onDownloadStart");
    }

    public GameResDownloaderOld$subscribe$1(d1 r100, com.bytedance.android.gamecp.business.t r101, Boolean r102) {
        this.f52431a = r100;
        this.f52432b = r101;
        this.f52433c = r102;
    }
}
