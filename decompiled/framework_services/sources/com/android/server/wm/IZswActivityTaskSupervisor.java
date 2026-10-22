package com.android.server.wm;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswActivityTaskSupervisor {
    boolean isHSCallingUid(Context r1, int r2);

    void noteAppForeground(ActivityRecord r1, ActivityRecord r2);

    void notePausingActivity(ActivityRecord r1);

    void noteResumingActivityEvent(ActivityRecord r1);

    void noteStartActivity(String r1, String r2);

    boolean shouldSkiProcesspKill(String r1);

    boolean skipKillProcessForSpecialApp(Intent r1, String r2, String r3);

    boolean updateIsRecents();
}
