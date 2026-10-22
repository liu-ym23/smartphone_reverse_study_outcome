package com.bytedance.android.gamecp.business.download;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class x0 implements com.bytedance.android.gamecp.base.core.service.depend.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.n f52961a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onCancel() {
        this.f52961a.onCancel();
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.m
    public final void onDownloadStart() {
        com.bytedance.android.gamecp.base.core.service.depend.n r100 = this.f52961a;
        if ((r100 instanceof com.bytedance.android.gamecp.base.core.service.depend.m) == false) goto L6;
        ((com.bytedance.android.gamecp.base.core.service.depend.m) r100).onDownloadStart();
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onReady() {
        this.f52961a.onReady();
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onUpdate() {
        this.f52961a.onUpdate();
    }

    public x0(GamePromoteDownloaderOld.b r100) {
        this.f52961a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onDownloaded(String r100) {
        this.f52961a.onDownloaded(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onError(int r100) {
        this.f52961a.onError(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onInstallFailed(int r100) {
        this.f52961a.onInstallFailed(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onInstalled(com.bytedance.android.gamecp.base.core.service.depend.v r100) {
        Intrinsics.checkNotNullParameter(r100, "installedFinishData");
        this.f52961a.onInstalled(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onJumpInstall(int r100) {
        this.f52961a.onJumpInstall(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        this.f52961a.onPause(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        this.f52961a.onProgress(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void passThrough(int r100) {
        this.f52961a.passThrough(r100);
    }
}
