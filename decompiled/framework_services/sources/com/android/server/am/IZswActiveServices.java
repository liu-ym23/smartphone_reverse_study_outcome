package com.android.server.am;

import android.app.IApplicationThread;
import android.content.Context;
import android.content.Intent;
import android.mifavor.MFVUtils;
import android.util.Slog;
import com.zte.doublelay.DoubleLayUtilsCommon;

/* JADX INFO: loaded from: classes.dex */
public interface IZswActiveServices {
    public static final String TAG = "IZswActiveServices";

    void bumpServiceExecutingLocked(ServiceRecord r1);

    void defendBindServiceLocked(ProcessServiceRecord r1, String r2);

    boolean isAutoLaunchDisable(String r1, int r2, String r3);

    String isSkipBringupService(IApplicationThread r1, ServiceRecord r2, boolean r3);

    String isSkipBringupService(ProcessRecord r1, ServiceRecord r2, boolean r3);

    void noteFGServiceTimeoutEnd(ServiceRecord r1);

    void noteFGServiceTimeoutStart(ServiceRecord r1, long r2);

    void noteServiceTimeoutEnd(ProcessRecord r1);

    void noteServiceTimeoutStart(ProcessRecord r1, long r2);

    void serviceDoneExecutingLocked(ServiceRecord r1);

    boolean serviceTimeout(ServiceRecord r1, ProcessRecord r2);

    boolean shouldDisableAllowRestart(ProcessRecord r1, boolean r2);

    static int maybeFallback_DoubleApp(int userId, Context context, Intent service, String methodTag) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return userId;
    L5:
        if (userId != 999) goto L12;
        new DoubleLayUtilsCommon();
        if (DoubleLayUtilsCommon.isServiceIntentAvailable(context, service, userId) == true) goto L9;
        Slog.d(TAG, "debug_999_fallback debug_double " + methodTag + " userid 999 fallback to 0, for " + service + " not installed !");
        return 0;
    L9:
        Slog.d(TAG, "debug_999_fallback debug_double " + methodTag + " userid 999  service: " + service + " installed !");
        return userId;
    L12:
        return userId;
    }
}
