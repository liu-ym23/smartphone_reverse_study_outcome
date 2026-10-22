package com.android.server.am;

import android.app.IActivityManagerExt;
import android.content.Context;
import android.pico.utils.IExtBase;
import com.android.internal.os.TimeoutRecord;

/* JADX INFO: loaded from: classes.dex */
public interface IExtActivityManagerService extends IExtBase {
    boolean checkSystemApp(int r1, String r2);

    void dispatchProcessState(String r1, int r2, int r3, boolean r4);

    IActivityManagerExt getIExt();

    boolean handleShortFgsAnrTimeout(ServiceRecord r1, TimeoutRecord r2);

    void initGameModeController(Context r1);

    void interceptClearUserDataIfNeeded(String r1);

    boolean shouldKillAfterAnrDumpWithoutDialog(TimeoutRecord r1);

    void startGameModeController();

    void systemReady();
}
