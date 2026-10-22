package com.bytedance.android.gamecp.business.downloadview.hande;

import com.bytedance.android.gamecp.base.core.service.depend.n;
import com.bytedance.android.gamecp.base.core.service.depend.v;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f53057a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public void onCancel() {
        n r100 = this.f53057a;
        if (r100 == null) goto L6;
        r100.onCancel();
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public void onReady() {
        n r100 = this.f53057a;
        if (r100 == null) goto L6;
        r100.onReady();
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onUpdate() {
        n r100 = this.f53057a;
        if (r100 == null) goto L6;
        r100.onUpdate();
        return;
    }

    public a(n r100) {
        this.f53057a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onDownloaded(String r100) {
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.onDownloaded(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onError(int r100) {
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onInstallFailed(int r100) {
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.onInstallFailed(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onInstalled(v r100) {
        Intrinsics.checkNotNullParameter(r100, "installedFinishData");
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.onInstalled(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onJumpInstall(int r100) {
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.onJumpInstall(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public void onPause(x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.onPause(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public void onProgress(x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.onProgress(r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.n
    public void passThrough(int r100) {
        n r101 = this.f53057a;
        if (r101 == null) goto L6;
        r101.passThrough(r100);
        return;
    }
}
