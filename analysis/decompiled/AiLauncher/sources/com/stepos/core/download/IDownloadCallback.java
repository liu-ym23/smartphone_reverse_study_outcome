package com.stepos.core.download;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Callback
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/core/download/IDownloadCallback;", "", "", VoiceWakeupReceiver.EXTRA_STATE, "progress", "LY8/t;", "onUpdate", "(II)V", "", "downloaded", "total", "onProgress", "(IJJ)V", "", "localFilePath", "onComplete", "(Ljava/lang/String;)V", "code", "message", "onError", "(ILjava/lang/String;)V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IDownloadCallback {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onComplete(IDownloadCallback iDownloadCallback, String localFilePath) {
            p.i(localFilePath, "localFilePath");
        }

        public static void onError(IDownloadCallback iDownloadCallback, int i10, String message) {
            p.i(message, "message");
        }

        public static void onProgress(IDownloadCallback iDownloadCallback, int i10, long j10, long j11) {
        }
    }

    void onComplete(String localFilePath);

    void onError(int code, String message);

    void onProgress(int progress, long downloaded, long total);

    void onUpdate(int state, int progress);
}
