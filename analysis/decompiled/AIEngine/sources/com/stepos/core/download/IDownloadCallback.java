package com.stepos.core.download;

import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Callback
/* loaded from: classes.dex */
public interface IDownloadCallback {
    void onComplete(String str);

    void onError(int i10, String str);

    void onProgress(int i10, long j10, long j11);

    void onUpdate(int i10, int i11);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static void onComplete(IDownloadCallback iDownloadCallback, String localFilePath) {
            g.f(localFilePath, "localFilePath");
        }

        public static void onError(IDownloadCallback iDownloadCallback, int i10, String message) {
            g.f(message, "message");
        }

        public static void onProgress(IDownloadCallback iDownloadCallback, int i10, long j10, long j11) {
        }
    }
}
