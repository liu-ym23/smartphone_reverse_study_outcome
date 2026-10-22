package com.stepos.core.ota.downloader;

import java.util.List;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface DownloadEngine {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void enqueue$default(DownloadEngine downloadEngine, DownloadRequest downloadRequest, l lVar, l lVar2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
            }
            if ((i10 & 2) != 0) {
                lVar = null;
            }
            if ((i10 & 4) != 0) {
                lVar2 = null;
            }
            downloadEngine.enqueue(downloadRequest, lVar, lVar2);
        }
    }

    DownloadEngine addListener(DownloadListener downloadListener);

    void cancelGroup(int i10);

    void deleteGroup(int i10);

    void enqueue(DownloadRequest downloadRequest, l<? super DownloadRequest, n> lVar, l<? super Throwable, n> lVar2);

    List<DownloadTask> getDownloadsInGroup(int i10);

    void pauseGroup(int i10);

    void release();

    void removeListener(DownloadListener downloadListener);

    void resumeGroup(int i10);
}
