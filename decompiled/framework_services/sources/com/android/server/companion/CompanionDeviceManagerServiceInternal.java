package com.android.server.companion;

import android.companion.AssociationInfo;
import com.android.server.companion.datatransfer.contextsync.CrossDeviceCall;
import com.android.server.companion.datatransfer.contextsync.CrossDeviceSyncControllerCallback;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public interface CompanionDeviceManagerServiceInternal {
    void addSelfOwnedCallId(String r1);

    void crossDeviceSync(int r1, Collection<CrossDeviceCall> r2);

    void crossDeviceSync(AssociationInfo r1, Collection<CrossDeviceCall> r2);

    void registerCallMetadataSyncCallback(CrossDeviceSyncControllerCallback r1, int r2);

    void removeInactiveSelfManagedAssociations();

    void removeSelfOwnedCallId(String r1);

    void sendCrossDeviceSyncMessage(int r1, byte[] r2);

    void sendCrossDeviceSyncMessageToAllDevices(int r1, byte[] r2);
}
