package com.android.server.pm.profile;

import com.android.server.SystemServiceManager;

/* JADX INFO: loaded from: classes2.dex */
public interface ISystemAppProfileCollectionManagerService {
    default boolean startIfNeeded(SystemServiceManager systemServiceManager) {
        return false;
    }
}
