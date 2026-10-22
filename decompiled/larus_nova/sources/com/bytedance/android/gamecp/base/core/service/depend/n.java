package com.bytedance.android.gamecp.base.core.service.depend;

/* JADX INFO: loaded from: classes44.dex */
public interface n {
    void onCancel();

    void onDownloaded(String r100);

    void onError(int r100);

    void onInstallFailed(int r100);

    void onInstalled(v r100);

    void onJumpInstall(int r100);

    void onPause(x r100);

    void onProgress(x r100);

    void onReady();

    void onUpdate();

    void passThrough(int r100);
}
