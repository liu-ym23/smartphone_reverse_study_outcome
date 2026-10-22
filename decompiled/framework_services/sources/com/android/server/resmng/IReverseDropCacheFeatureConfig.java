package com.android.server.resmng;

import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IReverseDropCacheFeatureConfig {
    default int getLevel(ApplicationInfo info) {
        return -1;
    }
}
