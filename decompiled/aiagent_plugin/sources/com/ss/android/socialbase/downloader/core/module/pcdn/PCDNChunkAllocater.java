package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;

/* JADX INFO: loaded from: classes4.dex */
public class PCDNChunkAllocater {
    private DownloadInfo mDownloadInfo;
    private int mIndex;
    private long mMaxChunkLength;
    private long mStartOffset;

    public PCDNChunkAllocater(DownloadInfo r3, long r4) {
        this.mDownloadInfo = r3;
        this.mMaxChunkLength = r4;
        this.mStartOffset = DownloadHelper.getFirstOffset(r3) + r3.getStartOffset();
    }

    public PCDNChunk obtainPCDNChunk() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mStartOffset >= this.mDownloadInfo.getTotalBytes()) goto L6;
        PCDNChunk r0 = new PCDNChunk();     // Catch: Throwable -> L15
        r0.mIndex = this.mIndex;     // Catch: Throwable -> L15
        r0.mStartOffset = this.mStartOffset;     // Catch: Throwable -> L15
        long r1 = (this.mStartOffset + this.mMaxChunkLength) - 1;     // Catch: Throwable -> L15
        if (r1 >= this.mDownloadInfo.getTotalBytes()) goto L11;
        r0.mEndOffset = r1;     // Catch: Throwable -> L15
    L12:
        this.mStartOffset += this.mMaxChunkLength;     // Catch: Throwable -> L15
        this.mIndex++;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r0;
    L11:
        r0.mEndOffset = (this.mDownloadInfo.getStartOffset() + this.mDownloadInfo.getTotalBytes()) - 1;     // Catch: Throwable -> L15
        goto L12
    L6:
        monitor-exit(this);     // Catch: Throwable -> L15
        return null;
    }
}
