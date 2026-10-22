package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.IApplicationThread;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricActivityStarter extends IObricBase {
    default ActivityOptions adjustLaunchParams(LaunchParamsController.LaunchParams launchParams, ActivityRecord r, ActivityOptions options) {
        return options;
    }

    default void setService(ActivityTaskManagerService service) {
    }

    default boolean blockAppLaunch(DisplayContent displayContent, String packageName) {
        return false;
    }

    default boolean recycleTask(Task reusedTask, LaunchParamsController.LaunchParams launchParams) {
        return false;
    }

    default boolean shouldBlockAutoVirtualDisplayLaunch(int callingUid, ActivityOptions options, ActivityRecord sourceRecord, IApplicationThread caller) {
        return false;
    }
}
