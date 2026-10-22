package com.obric.autoaction.app.launcherpage.api;

import android.content.Context;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.TimerTask;
import d.c.d;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IAutoTaskApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoTaskApi {
    Object appendSemanticIconExt(String r1, Map<String, String> r2, d<? super Map<String, String>> r3);

    boolean hasSemanticIconExt(Map<String, String> r1);

    Object onTaskDelete(EventTask r1, d<? super x> r2);

    void onTimerTasksRemoved(List<TimerTask> r1, boolean r2);

    void reportTimerTaskUpgradeMob(boolean r1, String r2);

    void syncPinShortcut(Context r1);
}
