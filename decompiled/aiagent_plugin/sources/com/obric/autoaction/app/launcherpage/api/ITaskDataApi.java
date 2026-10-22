package com.obric.autoaction.app.launcherpage.api;

/* JADX INFO: compiled from: ITaskDataApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ITaskDataApi {
    String getInstructionType(String r1);

    String getShortcutInstructionType(String r1);

    void reportTaskCountMobOnForeground();

    void trySweepConditionalTaskIfNeeded();
}
