package com.bytedance.android.livehostapi.business.depend.gamecp;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH&¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameDownloadListener;", "", "onCancel", "", "onDownloaded", "filePath", "", LynxVideoManagerLite.EVENT_ON_ERROR, "errorCode", "", "onInstalled", "installedFinishData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/InstalledFinishData;", "onPause", "progressData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/ProgressData;", "onProgress", "onReady", "onUpdate", "passThrough", "status", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameDownloadListener {
    void onCancel();

    void onDownloaded(String r100);

    void onError(int r100);

    void onInstalled(InstalledFinishData r100);

    void onPause(ProgressData r100);

    void onProgress(ProgressData r100);

    void onReady();

    void onUpdate();

    void passThrough(int r100);
}
