package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class MainThreadAsyncHandler {
    private static volatile Handler sHandler;

    private MainThreadAsyncHandler() {
    }

    public static Handler getInstance() {
        if (sHandler == null) goto L7;
        return sHandler;
    L7:
        monitor-enter(MainThreadAsyncHandler.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sHandler != null) goto L11;
        sHandler = HandlerCompat.createAsync(Looper.getMainLooper());     // Catch: Throwable -> L14
    L11:
        monitor-exit(MainThreadAsyncHandler.class);     // Catch: Throwable -> L14
        return sHandler;
    }
}
