package com.android.server.companion.datatransfer.contextsync;

import android.companion.AssociationInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class CrossDeviceSyncControllerCallback {
    static final int TYPE_CONNECTION_SERVICE = 1;
    static final int TYPE_IN_CALL_SERVICE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public CrossDeviceSyncControllerCallback() {
    }

    void processContextSyncMessage(int associationId, CallMetadataSyncData callMetadataSyncData) {
    }

    void requestCrossDeviceSync(AssociationInfo associationInfo) {
    }

    void updateNumberOfActiveSyncAssociations(int userId, boolean added) {
    }

    void cleanUpCallIds(Set<String> callIds) {
    }
}
