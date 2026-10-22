package com.android.server.wm;

import android.app.ProfilerInfo;
import android.app.doppelganger.DoppelgangerManager;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityStackSupervisorHook {
    private static final boolean DEBUG_DOPPELGANGER = false;
    private static final String EXTRA_PARAM_DOPPELGANGER_UID = "extra_param_doppelganger_uid";
    private static final String TAG = "ActivityStackSupervisorHook";

    public ActivityStackSupervisorHook() {
    }

    static Pair<Pair<ResolveInfo, Intent>, SafeActivityOptions> hookStartActivityMayWait(ActivityTaskSupervisor supervisor, ResolveInfo rInfo, Intent intent, int userId, String resolvedType, ProfilerInfo profilerInfo, String callingPackage, SafeActivityOptions options) {
        if (userId != 10) goto L12;
        if (rInfo == null) goto L10;
        if (rInfo.activityInfo == null) goto L10;
        if (TextUtils.equals(rInfo.activityInfo.packageName, callingPackage) == true) goto L12;
    L10:
        if (DoppelgangerManager.needResolveOwnerUserFirst(intent) == false) goto L12;
        ResolveInfo rInfo2 = supervisor.resolveIntent(intent, resolvedType, 0, 0, Binder.getCallingUid(), Binder.getCallingPid());
    L13:
        if (rInfo2 != null) goto L23;
        if (userId != 10) goto L23;
        ResolveInfo rInfo3 = supervisor.resolveIntent(intent, resolvedType, userId, 0, Binder.getCallingUid(), Binder.getCallingPid());
        if (rInfo3 == null) goto L21;
        if (rInfo3.activityInfo == null) goto L21;
        DoppelgangerManager.saveForwardRelation(callingPackage, userId, rInfo3.activityInfo, intent);
    L21:
        return new Pair(new Pair(rInfo3, intent), options);
    L23:
        if (rInfo2 != null) goto L25;
    L32:
        Intent intent2 = intent;
    L33:
        if (intent2 == intent) goto L41;
        int toUser = intent2.getIntExtra("doppelganger_to_user", Integer.MAX_VALUE);
        if (toUser == Integer.MAX_VALUE) goto L38;
        intent2.removeExtra("doppelganger_to_user");
        return new Pair(new Pair(supervisor.resolveIntent(intent, resolvedType, toUser, 0, Binder.getCallingUid(), Binder.getCallingPid()), intent), options);
    L38:
        Intent intent3 = intent2;
        return new Pair(new Pair(supervisor.resolveIntent(intent3, resolvedType, 0, 0, Binder.getCallingUid(), Binder.getCallingPid()), intent3), null);
    L41:
        return new Pair(new Pair(rInfo2, intent), options);
    L25:
        if (rInfo2.activityInfo == null) goto L32;
        if (options != null) goto L28;
    L30:
        Bundle bundle = null;
    L31:
        intent2 = DoppelgangerManager.hookDoppelgangerIntent(callingPackage, rInfo2.activityInfo, intent, userId, bundle);
        goto L33
    L28:
        if (options.getOriginalOptions() == null) goto L30;
        bundle = options.getOriginalOptions().toBundle();
    L12:
        rInfo2 = rInfo;
        goto L13
    }
}
