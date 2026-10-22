package com.android.server.wm;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswActivityTaskManagerService {
    String getPkgNameForTask(int r1);

    void removeTask(int r1);

    boolean removeTaskExt(int r1, boolean r2);

    void setLastResumedActivityUncheckLocked(ActivityRecord r1);

    void updateGlobalConfigurationLocked(Configuration r1);
}
