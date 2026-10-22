package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface IZswAppErrors {
    boolean doNotShowDialgForBgApp(ProcessRecord r1, boolean r2, AppErrorResult r3);

    Long getCrashCnt(String r1);

    void handleSkipCrashDialog(String r1, AppErrorResult r2);

    boolean isSystemOrWhiteListApp(ProcessRecord r1, String r2);

    void reportCrashEvent(String r1);

    void reportCrashEventInner(ProcessRecord r1, String r2);

    boolean shouldReturnForWebviewError(ProcessRecord r1, String r2);

    boolean shouldSkipCrashDialog(ProcessRecord r1);
}
