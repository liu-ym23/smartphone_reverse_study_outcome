package com.android.server.devicepolicy;

import android.app.admin.DeviceAdminInfo;
import android.content.ComponentName;
import com.android.internal.util.JournaledFile;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public interface PolicyUpgraderDataProvider {
    Function<ComponentName, DeviceAdminInfo> getAdminInfoSupplier(int r1);

    List<String> getPlatformSuspendedPackages(int r1);

    int[] getUsersForUpgrade();

    JournaledFile makeDevicePoliciesJournaledFile(int r1);

    JournaledFile makePoliciesVersionJournaledFile(int r1);
}
