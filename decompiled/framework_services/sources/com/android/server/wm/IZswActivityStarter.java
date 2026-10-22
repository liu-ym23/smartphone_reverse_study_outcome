package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.IBinder;
import android.service.voice.IVoiceInteractionSession;
import com.android.internal.app.IVoiceInteractor;
import com.android.server.uri.NeededUriGrants;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswActivityStarter {
    boolean abortForKidsZoneBlackApp(Context r1, String r2);

    boolean defendReportAppDied(ActivityRecord r1);

    void execute(String r1, String r2);

    String executeRequest(WindowProcessController r1, String r2);

    void executeRequest(Intent r1, String r2, int r3);

    void executeRequest(ActivityRecord r1);

    HsLockTempInfo getHsLockTempInfo(ActivityRecord r1, ActivityRecord r2, IVoiceInteractionSession r3, IVoiceInteractor r4, int r5, ActivityOptions r6, Task r7, TaskFragment r8, BackgroundActivityStartController.BalVerdict r9, NeededUriGrants r10, int r11, Transition r12, boolean r13, WindowProcessController r14);

    boolean isSurpportHSAppLockByFrameWork();

    void launchIntervalMonitor(int r1, ActivityInfo r2);

    boolean shouldAbortExecuteRequestForAppStartOtherAppFilterPrompt(WindowProcessController r1, ActivityInfo r2, Intent r3, String r4, int r5, String r6, int r7, int r8, int r9, int r10, IBinder r11, String r12, int r13, String r14, String r15, ActivityTaskManagerService r16);

    boolean startActivityInner(ActivityRecord r1);
}
