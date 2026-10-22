package com.android.server.wm;

import android.app.ActivityOptions;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtTaskDisplayArea extends IExtBase {
    default Task getExistedRootTaskLocked(ActivityRecord startActivity) {
        return null;
    }

    default Task getOrCreateRootTask(ActivityRecord r, int windowingMode, int activityType, boolean onTop, Task candidateTask, Task sourceTask, ActivityOptions options, int launchFlags) {
        return null;
    }
}
