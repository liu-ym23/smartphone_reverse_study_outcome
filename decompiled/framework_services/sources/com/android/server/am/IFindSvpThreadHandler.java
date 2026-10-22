package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface IFindSvpThreadHandler {
    default void findingSvpThreadAppDied(ActivityManagerService ams, ProcessRecord app) {
    }

    default void scheduleFindSvpThread(ActivityManagerService ams, ProcessRecord app) {
    }

    default void clearAppSvpThreads(ActivityManagerService ams, ProcessRecord app) {
    }
}
