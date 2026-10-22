package com.danikula.videocache.file;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class TotalCountLruDiskUsage extends LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int r10) {
        if (r10 <= 0) goto L7;
        this.maxCount = r10;
        return;
    L7:
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    @Override // com.danikula.videocache.file.LruDiskUsage
    public boolean accept(File r10, long r11, int r12) {
        if (r12 > this.maxCount) goto L5;
        return true;
    L5:
        return false;
    }
}
