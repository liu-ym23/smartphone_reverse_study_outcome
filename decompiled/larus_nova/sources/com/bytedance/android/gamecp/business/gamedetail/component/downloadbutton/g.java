package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import com.bytedance.android.gamecp.base.core.service.depend.n;
import com.bytedance.android.gamecp.base.core.service.depend.v;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameDownloadButtonItemWidget f54291a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onCancel() {
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onDownloaded(String r100) {
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onError(int r100) {
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onInstallFailed(int r100) {
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onJumpInstall(int r100) {
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onUpdate() {
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void passThrough(int r100) {
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onReady() {
        DownloadButtonAnimation r100 = this.f54291a.f54274J;
        if (r100 == null) goto L6;
        yr.b.b(3, "DownloadButtonAnimation", "onReady");
        r100.a(false, false);
        return;
    }

    public g(GameDownloadButtonItemWidget r100) {
        this.f54291a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onInstalled(v r100) {
        Intrinsics.checkNotNullParameter(r100, "installedFinishData");
        DownloadButtonAnimation r101 = this.f54291a.f54274J;
        if (r101 == null) goto L6;
        yr.b.b(3, "DownloadButtonAnimation", "onInstalled");
        r101.a(false, true);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onPause(x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        DownloadButtonAnimation r101 = this.f54291a.f54274J;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "progressData");
        yr.b.b(3, "DownloadButtonAnimation", "onPause");
        r101.a(true, false);
        r101.e();
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onProgress(x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        DownloadButtonAnimation r101 = this.f54291a.f54274J;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "progressData");
        yr.b.b(3, "DownloadButtonAnimation", "onProgress");
        r101.a(true, false);
        r101.e();
        r101.f54253h = true;
        return;
    }
}
