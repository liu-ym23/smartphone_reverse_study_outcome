package com.android.server.usage;

import android.annotation.SystemApi;
import android.content.pm.PackageStats;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes3.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface StorageStatsManagerLocal {

    public interface StorageStatsAugmenter {
        void augmentStatsForPackageForUser(PackageStats r1, String r2, UserHandle r3, boolean r4);

        void augmentStatsForUid(PackageStats r1, int r2, boolean r3);

        void augmentStatsForUser(PackageStats r1, UserHandle r2);
    }

    void registerStorageStatsAugmenter(StorageStatsAugmenter r1, String r2);
}
