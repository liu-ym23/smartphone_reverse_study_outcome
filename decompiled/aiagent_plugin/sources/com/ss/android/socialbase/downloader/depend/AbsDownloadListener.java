package com.ss.android.socialbase.downloader.depend;

import android.util.Pair;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    static {
    }

    public AbsDownloadListener() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onPrepare", "Name: " + r3.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onStart", "Name: " + r3.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo r5) {
        if (Logger.debugScene(r5) == false) goto L9;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getTotalBytes() == 0) goto L11;
        Logger.taskDebug(TAG, r5.getId(), "onProgress", String.format("Name: %s %.2f%%", new Object[]{r5.getName(), Float.valueOf((r5.getCurBytes() / r5.getTotalBytes()) * 100.0f)}));
        return;
    L11:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onPause", "Name: " + r3.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onSuccessed", "Name: " + r3.getName() + " " + r3.isSuccessByCache());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo r4, BaseException r5) {
        if (Logger.debugScene(r4) == false) goto L11;
        if (r4 == null) goto L12;
        String r3 = TAG;
        Object[] r0 = new Object[2];
        r0[0] = r4.getName();
        if (r5 == null) goto L8;
        String r6 = r5.getErrorMessage();
    L9:
        r0[1] = r6;
        Logger.taskDebug(r3, r4, "onFailed", String.format("Name: %s because of : %s", r0));
        return;
    L8:
        r6 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onCanceled", "Name: " + r3.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onFirstStart", "Name: " + r3.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onFirstSuccess", "Name: " + r3.getName());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo r4, BaseException r5) {
        if (Logger.debugScene(r4) == false) goto L11;
        if (r4 == null) goto L12;
        String r3 = TAG;
        Object[] r0 = new Object[2];
        r0[0] = r4.getName();
        if (r5 == null) goto L8;
        String r6 = r5.getErrorMessage();
    L9:
        r0[1] = r6;
        Logger.taskDebug(r3, r4, "onRetry", String.format("Name: %s because of : %s", r0));
        return;
    L8:
        r6 = "unkown";
        goto L9
    L12:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo r4, BaseException r5) {
        if (Logger.debugScene(r4) == false) goto L11;
        if (r4 == null) goto L12;
        String r3 = TAG;
        Object[] r0 = new Object[2];
        r0[0] = r4.getName();
        if (r5 == null) goto L8;
        String r6 = r5.getErrorMessage();
    L9:
        r0[1] = r6;
        Logger.taskDebug(r3, r4, "onRetryDelay", String.format("Name: %s because of : %s", r0));
        return;
    L8:
        r6 = "unkown";
        goto L9
    L12:
        return;
    }

    public void onIntercept(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onIntercept", "Name: " + r3.getName());
        return;
    L8:
        return;
    }

    public void onReceiveData(DownloadInfo r2, byte[] r3, int r4) {
        if (Logger.debugScene(r2) == false) goto L7;
        if (r2 == null) goto L8;
        Logger.taskDebug(TAG, r2, "onReceiveData", "Name: " + r2.getName() + " data len:" + r4);
        return;
    L8:
        return;
    }

    public void onReceiveHeader(DownloadInfo r3, List<Pair<String, String>> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onReceiveHeader", "Name: " + r3.getName() + " header:" + r2);
        return;
    L8:
        return;
    }

    public void onReceiveRequestLog(DownloadInfo r3, String r4) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onReceiveRequestLog", "Name: " + r3.getName() + " requestLog:" + r4);
        return;
    L8:
        return;
    }
}
