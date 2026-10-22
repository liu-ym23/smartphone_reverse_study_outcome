package com.bytedance.platform.godzilla.anr.sp;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class QueuedWorkProxyBelowAndroid0 {
    private static final String CLASS_NAME = "android.app.QueuedWork";
    private static final String FILE_NAME_PENDING_WORK_FINISH = "sPendingWorkFinishers";
    private static final String TAG = "QueuedWkProxyBAndroid0";

    private QueuedWorkProxyBelowAndroid0() {
    }

    public static void replaceQueueWorkPendingWorkFinishers() {
        Log.d(TAG, "start hook, time stamp = " + System.currentTimeMillis());
        Field r2 = Class.forName(CLASS_NAME).getDeclaredField(FILE_NAME_PENDING_WORK_FINISH);     // Catch: Exception -> L13
        r2.setAccessible(true);     // Catch: Exception -> L11
        ConcurrentLinkedQueue r3 = (ConcurrentLinkedQueue) r2.get(null);     // Catch: Exception -> L11
        if (r3 != null) goto L22;
    L19:
        Log.d(TAG, "end hook, time stamp = " + System.currentTimeMillis());
        return;
    L22:
        r2.set(null, new ConcurrentLinkedQueueProxy(r3));     // Catch: Exception -> L9
        Log.d(TAG, "Below android 0,replaceQueueWorkPendingWorkFinishers success.");     // Catch: Exception -> L9
    L9:
        e = e;
    L15:
        if (r3 == null) goto L18;
        if (r2 == null) goto L18;
        r2.set(null, r3);     // Catch: Exception -> L21
    L18:
        Log.e(TAG, "Below android 0,,hook sPendingWorkFinishers fail.", e);
    L11:
        e = e;
        r3 = null;
    L13:
        e = e;
        r2 = null;
        r3 = null;
        goto L15
    }
}
