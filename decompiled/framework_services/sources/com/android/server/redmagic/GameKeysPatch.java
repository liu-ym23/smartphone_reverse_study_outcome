package com.android.server.redmagic;

import android.app.ActivityManager;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Slog;
import com.android.server.wm.ActivityRecord;
import com.android.server.wm.RootWindowContainer;
import com.android.server.wm.WindowProcessController;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GameKeysPatch {
    public static final boolean ZTE_FEATURE_GAME_FX = true;
    private static GameKeysPatch mInstance;

    public abstract int antiMisporatetToastAndType(Context r1, boolean r2, boolean r3, boolean r4);

    public abstract boolean interceptEnqueueNotificationInternal(Context r1, String r2, int r3, Notification r4);

    public abstract boolean interceptExecuteRequest(Context r1, RootWindowContainer r2, Intent r3, ResolveInfo r4, int r5, boolean r6, WindowProcessController r7);

    public abstract boolean interceptRequestTransientBars(Context r1, boolean r2, boolean r3);

    public abstract boolean isSwipeNone(Context r1, int r2, float r3);

    public abstract void monitorWxMiniPrograme(Context r1, ActivityRecord r2, ActivityManager.TaskDescription r3);

    public GameKeysPatch() {
    }

    public static synchronized GameKeysPatch getInstance() {
        monitor-enter(GameKeysPatch.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (mInstance == null) goto L37;
        GameKeysPatch r1 = mInstance;     // Catch: Throwable -> L9
        monitor-exit(GameKeysPatch.class);
        return r1;
    L37:
        monitor-enter(GameKeysPatch.class);     // Catch: Throwable -> L9
        mInstance = (GameKeysPatch) Class.forName("com.android.server.redmagic.GameKeysPatchImpl").newInstance();     // Catch: Throwable -> L19 Exception -> L21
        if (mInstance == null) goto L23;
        Slog.d("GameKeysPatch", "Successfully loaded GameKeysPatchImpl");     // Catch: Throwable -> L19 Exception -> L21
        GameKeysPatch r2 = mInstance;     // Catch: Throwable -> L19 Exception -> L21
        monitor-exit(GameKeysPatch.class);     // Catch: Throwable -> L19
        monitor-exit(GameKeysPatch.class);
        return r2;
    L23:
        Slog.d("GameKeysPatch", "failed loaded GameKeysPatchImpl");     // Catch: Throwable -> L19 Exception -> L21
    L27:
        monitor-exit(GameKeysPatch.class);     // Catch: Throwable -> L19
        monitor-exit(GameKeysPatch.class);
        return null;
    L21:
        e = move-exception;
        Slog.e("GameKeysPatch", "Failed to load GameKeysPatchImpl class", e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    }
}
