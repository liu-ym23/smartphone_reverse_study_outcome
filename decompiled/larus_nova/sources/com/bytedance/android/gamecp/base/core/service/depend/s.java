package com.bytedance.android.gamecp.base.core.service.depend;

/* JADX INFO: loaded from: classes44.dex */
public interface s {
    void onCancel();

    void onDownloaded(String r100);

    void onError(int r100, int r101);

    void onPause(x r100);

    void onProgress(x r100);

    void onReady();

    void passThrough(int r100);
}
