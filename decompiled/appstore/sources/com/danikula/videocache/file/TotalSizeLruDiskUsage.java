package com.danikula.videocache.file;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long r10) {
        if (r10 <= 0) goto L7;
        this.maxSize = r10;
        return;
    L7:
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.danikula.videocache.file.LruDiskUsage
    public boolean accept(File r10, long r11, int r12) {
        if (r11 > this.maxSize) goto L5;
        return true;
    L5:
        return false;
    }
}
