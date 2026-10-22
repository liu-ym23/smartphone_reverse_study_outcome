package com.android.server.pm;

import android.content.pm.PackagePartitions;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ScanPartition extends PackagePartitions.SystemPartition {
    public final ApexManager.ActiveApexInfo apexInfo;
    public final int scanFlag;

    public ScanPartition(PackagePartitions.SystemPartition partition) {
        super(partition);
        this.scanFlag = scanFlagForPartition(partition);
        this.apexInfo = null;
    }

    public ScanPartition(File folder, ScanPartition original, ApexManager.ActiveApexInfo apexInfo) {
        super(folder, original);
        int scanFlags = original.scanFlag;
        this.apexInfo = apexInfo;
        if (apexInfo == null) goto L10;
        scanFlags = scanFlags | 8388608;
        if (apexInfo.isFactory == false) goto L8;
        scanFlags = scanFlags | 33554432;
    L8:
        if (apexInfo.activeApexChanged == false) goto L10;
        scanFlags = scanFlags | 16777216;
    L10:
        this.scanFlag = scanFlags;
    }

    private static int scanFlagForPartition(PackagePartitions.SystemPartition partition) {
        switch(partition.type) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        return 2097152;
    L8:
        return 1048576;
    L10:
        return 262144;
    L12:
        return 4194304;
    L14:
        return 524288;
    L16:
        return 0;
    L5:
        throw new IllegalStateException("Unable to determine scan flag for " + partition.getFolder());
    }

    public String toString() {
        return getFolder().getAbsolutePath() + ":" + this.scanFlag;
    }
}
