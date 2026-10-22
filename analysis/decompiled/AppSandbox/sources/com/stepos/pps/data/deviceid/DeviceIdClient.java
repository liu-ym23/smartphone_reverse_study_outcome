package com.stepos.pps.data.deviceid;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class DeviceIdClient {
    private static final long BIND_TIMEOUT_MS = 6000;
    private static final String TAG = "DeviceIdClient";
    private static final int TYPE_DSID = 1;
    private static final int TYPE_OAID = 0;
    private static final Executor sCallbackExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.pps.data.deviceid.DeviceIdClient$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return DeviceIdClient.lambda$static$0(runnable);
        }
    });

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "deviceid-bind");
        thread.setDaemon(true);
        return thread;
    }

    private DeviceIdClient() {
    }

    public static String getOaid(Context context) {
        return fetch(context, 0);
    }

    public static String getDsid(Context context) {
        return fetch(context, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0060 A[EXC_TOP_SPLITTER, PHI: r5
      0x0060: PHI (r5v7 boolean) = (r5v4 boolean), (r5v5 boolean), (r5v8 boolean) binds: [B:24:0x0081, B:27:0x008a, B:15:0x005e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String fetch(android.content.Context r12, final int r13) {
        /*
            java.lang.String r0 = "DeviceIdClient"
            java.lang.String r1 = "fetch type="
            java.lang.String r2 = "bindService(:deviceid) failed, type="
            r3 = 0
            if (r12 != 0) goto La
            return r3
        La:
            android.content.Context r12 = r12.getApplicationContext()
            java.util.concurrent.CountDownLatch r4 = new java.util.concurrent.CountDownLatch
            r5 = 1
            r4.<init>(r5)
            java.lang.String[] r6 = new java.lang.String[r5]
            com.stepos.pps.data.deviceid.DeviceIdClient$1 r7 = new com.stepos.pps.data.deviceid.DeviceIdClient$1
            r7.<init>()
            android.content.Intent r8 = new android.content.Intent
            java.lang.Class<com.stepos.pps.data.deviceid.DeviceIdService> r9 = com.stepos.pps.data.deviceid.DeviceIdService.class
            r8.<init>(r12, r9)
            r9 = 0
            java.util.concurrent.Executor r10 = com.stepos.pps.data.deviceid.DeviceIdClient.sCallbackExecutor     // Catch: java.lang.Throwable -> L66 java.lang.InterruptedException -> L82
            boolean r5 = r12.bindService(r8, r5, r10, r7)     // Catch: java.lang.Throwable -> L66 java.lang.InterruptedException -> L82
            if (r5 != 0) goto L40
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            r4.append(r13)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            android.util.Log.w(r0, r2)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            if (r5 == 0) goto L3f
            r12.unbindService(r7)     // Catch: java.lang.Throwable -> L3f
        L3f:
            return r3
        L40:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            r10 = 6000(0x1770, double:2.9644E-320)
            boolean r2 = r4.await(r10, r2)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            if (r2 != 0) goto L5e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            r2.append(r13)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            java.lang.String r3 = " timeout"
            r2.append(r3)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
            android.util.Log.w(r0, r2)     // Catch: java.lang.Throwable -> L64 java.lang.InterruptedException -> L83
        L5e:
            if (r5 == 0) goto L8d
        L60:
            r12.unbindService(r7)     // Catch: java.lang.Throwable -> L8d
            goto L8d
        L64:
            r2 = move-exception
            goto L68
        L66:
            r2 = move-exception
            r5 = r9
        L68:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L90
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L90
            r3.append(r13)     // Catch: java.lang.Throwable -> L90
            java.lang.String r13 = " error: "
            r3.append(r13)     // Catch: java.lang.Throwable -> L90
            r3.append(r2)     // Catch: java.lang.Throwable -> L90
            java.lang.String r13 = r3.toString()     // Catch: java.lang.Throwable -> L90
            android.util.Log.w(r0, r13)     // Catch: java.lang.Throwable -> L90
            if (r5 == 0) goto L8d
            goto L60
        L82:
            r5 = r9
        L83:
            java.lang.Thread r13 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L90
            r13.interrupt()     // Catch: java.lang.Throwable -> L90
            if (r5 == 0) goto L8d
            goto L60
        L8d:
            r12 = r6[r9]
            return r12
        L90:
            r13 = move-exception
            if (r5 == 0) goto L96
            r12.unbindService(r7)     // Catch: java.lang.Throwable -> L96
        L96:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.deviceid.DeviceIdClient.fetch(android.content.Context, int):java.lang.String");
    }
}
