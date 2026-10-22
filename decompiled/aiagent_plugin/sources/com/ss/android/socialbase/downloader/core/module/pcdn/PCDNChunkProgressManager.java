package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PCDNChunkProgressManager {
    private Map<Integer, ChunkCacheItem> mCacheDownloadedSize;
    private int mChunkProgressIndex;
    private IDownloadCache mDownloadCache;
    private DownloadInfo mDownloadInfo;
    private IDownloadRunnableCallback mDownloadRunnableCallback;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.core.module.pcdn.PCDNChunkProgressManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ChunkCacheItem {
        private long downloadSize;
        private boolean isFinished;
        final /* synthetic */ PCDNChunkProgressManager this$0;

        private ChunkCacheItem(PCDNChunkProgressManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ChunkCacheItem(PCDNChunkProgressManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ boolean access$000(ChunkCacheItem r0) {
            return r0.isFinished;
        }

        static /* synthetic */ boolean access$002(ChunkCacheItem r0, boolean r1) {
            r0.isFinished = r1;
            return r1;
        }

        static /* synthetic */ long access$100(ChunkCacheItem r2) {
            return r2.downloadSize;
        }

        static /* synthetic */ long access$102(ChunkCacheItem r0, long r1) {
            r0.downloadSize = r1;
            return r1;
        }
    }

    public PCDNChunkProgressManager(IDownloadRunnableCallback r3, IDownloadCache r4, DownloadInfo r5) {
        IDownloadRunnableCallback r6 = (IDownloadRunnableCallback) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadRunnableCallback.class, "com.obric.aiagent.plugin");
        IDownloadCache r7 = (IDownloadCache) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadCache.class, "com.obric.aiagent.plugin");
        this.mCacheDownloadedSize = new HashMap();
        this.mDownloadRunnableCallback = r6;
        this.mDownloadCache = r7;
        this.mDownloadInfo = r5;
    }

    public void onDownloadChunkFinish(int r9) {
        monitor-enter(this);
        int r0 = this.mChunkProgressIndex;     // Catch: Throwable -> L28
        if (r9 != r0) goto L6;
        this.mChunkProgressIndex = r0 + 1;     // Catch: Throwable -> L28
        long r4 = 0;
    L11:
        ChunkCacheItem r10 = (ChunkCacheItem) ZeusTransformUtils.preCheckCast(this.mCacheDownloadedSize.get(Integer.valueOf(this.mChunkProgressIndex)), ChunkCacheItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r10 == null) goto L18;
        r4 = r4 + ChunkCacheItem.access$100(r10);     // Catch: Throwable -> L28
        if (ChunkCacheItem.access$000(r10) == false) goto L16;
        this.mCacheDownloadedSize.remove(Integer.valueOf(this.mChunkProgressIndex));     // Catch: Throwable -> L28
        this.mChunkProgressIndex++;     // Catch: Throwable -> L28
        goto L11
    L16:
        ChunkCacheItem.access$102(r10, 0);     // Catch: Throwable -> L28
        this.mCacheDownloadedSize.put(Integer.valueOf(this.mChunkProgressIndex), r10);     // Catch: Throwable -> L28
    L18:
        if (r4 > 0) goto L31;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L31:
        this.mDownloadRunnableCallback.onProgress(r4);     // Catch: Throwable -> L23
        this.mDownloadInfo.updateRealDownloadTime(true);     // Catch: Throwable -> L23
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);     // Catch: Throwable -> L23
    L25:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        goto L25
    L6:
        if (this.mCacheDownloadedSize.containsKey(Integer.valueOf(r9)) == false) goto L8;
        ChunkCacheItem r1 = (ChunkCacheItem) ZeusTransformUtils.preCheckCast(this.mCacheDownloadedSize.get(Integer.valueOf(r9)), ChunkCacheItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        ChunkCacheItem.access$002(r1, true);     // Catch: Throwable -> L28
        this.mCacheDownloadedSize.put(Integer.valueOf(r9), r1);     // Catch: Throwable -> L28
    L8:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public boolean onProgress(int r4, long r5) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r4 != this.mChunkProgressIndex) goto L8;
        boolean r6 = this.mDownloadRunnableCallback.onProgress(r5);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return r6;
    L8:
        ChunkCacheItem r0 = (ChunkCacheItem) ZeusTransformUtils.preCheckCast(this.mCacheDownloadedSize.get(Integer.valueOf(r4)), ChunkCacheItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r0 != null) goto L11;
        r0 = new ChunkCacheItem(this, null);     // Catch: Throwable -> L14
    L11:
        ChunkCacheItem.access$102(r0, ChunkCacheItem.access$100(r0) + r5);     // Catch: Throwable -> L14
        this.mCacheDownloadedSize.put(Integer.valueOf(r4), r0);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    }
}
