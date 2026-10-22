package com.android.server.redmagic;

import android.content.Context;
import android.util.Slog;
import android.view.KeyEvent;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.policy.WindowManagerPolicy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GameKeysCtrl {
    private static GameKeysCtrl mInstance;

    public abstract int interceptKeyBeforeQueueing(KeyEvent r1, int r2, boolean r3);

    public abstract boolean isFinishKeyBeforQueueing(int r1);

    public GameKeysCtrl() {
    }

    public static synchronized GameKeysCtrl getInstance(Context context, PhoneWindowManager phoneWindowMrg, WindowManagerPolicy.WindowManagerFuncs funcs, int userId) {
        monitor-enter(GameKeysCtrl.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (mInstance == null) goto L12;
        GameKeysCtrl r1 = mInstance;     // Catch: Throwable -> L9
        monitor-exit(GameKeysCtrl.class);
        return r1;
    L12:
        monitor-enter(GameKeysCtrl.class);     // Catch: Throwable -> L9
        mInstance = (GameKeysCtrl) Class.forName("com.android.server.redmagic.GameKeysCtrlImpl").getConstructor(new Class[]{Context.class, PhoneWindowManager.class, WindowManagerPolicy.WindowManagerFuncs.class, Integer.TYPE}).newInstance(new Object[]{context, phoneWindowMrg, funcs, Integer.valueOf(userId)});     // Catch: Throwable -> L19 Exception -> L21
        if (mInstance == null) goto L23;
        Slog.d("GameKeysCtrl", "Successfully loaded GameKeysCtrlImpl");     // Catch: Throwable -> L19 Exception -> L21
        GameKeysCtrl r2 = mInstance;     // Catch: Throwable -> L19 Exception -> L21
        monitor-exit(GameKeysCtrl.class);     // Catch: Throwable -> L19
        monitor-exit(GameKeysCtrl.class);
        return r2;
    L23:
        Slog.d("GameKeysCtrl", "failed loaded GameKeysCtrlImpl");     // Catch: Throwable -> L19 Exception -> L21
    L27:
        monitor-exit(GameKeysCtrl.class);     // Catch: Throwable -> L19
        monitor-exit(GameKeysCtrl.class);
        return null;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L21:
        e = move-exception;
        Slog.e("GameKeysCtrl", "Failed to load GameKeysCtrlImpl class", e);     // Catch: Throwable -> L19
        goto L27
    }
}
