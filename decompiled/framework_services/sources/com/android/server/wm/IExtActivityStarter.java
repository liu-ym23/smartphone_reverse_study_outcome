package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.pico.utils.IExtBase;
import android.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtActivityStarter extends IExtBase {
    boolean refuseStartLauncherInFreeform(Intent r1, int r2, IBinder r3);

    default Pair<Intent, Pair<ResolveInfo, ActivityInfo>> startConfirmActivityIfNeeded(ActivityTaskManagerService service, ActivityInfo aInfo, Intent intent, ActivityRecord sourceRecord, ActivityRecord resultRecord, WindowProcessController callerApp, int callingUid, int realCallingUid, int filterCallingUid, String callingPackage, String callingFeatureId, int realCallingPid, int userId, String resolvedType, int startFlags, ActivityOptions checkedOptions) {
        return null;
    }
}
