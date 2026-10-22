package com.android.server.am;

import android.app.IApplicationThread;
import android.app.IBackNavigationListenerEx;
import android.app.ProfilerInfo;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import android.pico.utils.IExtBase;
import com.android.server.wm.ActivityTaskManagerService;
import com.android.server.wm.SafeActivityOptions;

/* JADX INFO: loaded from: classes.dex */
public interface IExtATMService extends IExtBase {
    void addDisablePackage(String[] r1);

    boolean isAppBlockedByAuto(String r1);

    void onBackNavigationDoneInVirtualDisplay();

    void onBackNavigationStartedInVirtualDisplay();

    void preBindApplication(ApplicationInfo r1);

    boolean registerBackNavigationInVirtualDisplayListenerEx(IBackNavigationListenerEx r1);

    boolean unregisterBackNavigationInVirtualDisplayListenerEx(IBackNavigationListenerEx r1);

    default boolean deferStartActivityIfNeeded(ActivityTaskManagerService service, IApplicationThread caller, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, ProfilerInfo profilerInfo, SafeActivityOptions options, int userId, int callingPid, int callingUid) {
        return false;
    }
}
