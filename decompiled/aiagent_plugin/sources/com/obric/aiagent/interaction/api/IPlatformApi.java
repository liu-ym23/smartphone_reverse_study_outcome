package com.obric.aiagent.interaction.api;

import android.app.ActivityManager;
import java.util.List;

/* JADX INFO: compiled from: IPlatformApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IPlatformApi {
    List<ActivityManager.RunningTaskInfo> getTasks(int r1, boolean r2, boolean r3, int r4);

    boolean moveTaskToDisplay(int r1, int r2, boolean r3);
}
