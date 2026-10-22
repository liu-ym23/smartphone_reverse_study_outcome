package com.stepos.pps.data.deviceid;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class SafeCertClient {
    private static final String ACTION_SAFE_CERTIFICATION = "com.stepos.secureservice.SafeCertification";
    private static final String SAFE_CERT_SERVICE = "com.stepos.secureservice.certification.SafeCertService";
    private static final String SECURE_SERVICE_PKG = "com.stepos.secureservice";
    private static final String TAG = "SafeCertClient";
    private static final long TIMEOUT_MS = 4000;
    private static final Executor sCallbackExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.pps.data.deviceid.SafeCertClient$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return SafeCertClient.lambda$static$0(runnable);
        }
    });

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "safecert-bind");
        thread.setDaemon(true);
        return thread;
    }

    private SafeCertClient() {
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0054 A[EXC_TOP_SPLITTER, PHI: r4
      0x0054: PHI (r4v7 boolean) = (r4v4 boolean), (r4v5 boolean), (r4v8 boolean) binds: [B:24:0x006d, B:27:0x0076, B:15:0x0052] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getEncryptedOaid(android.content.Context r11) {
        /*
            java.lang.String r0 = "SafeCertClient"
            java.lang.String r1 = "getEncryptedOaid error: "
            r2 = 0
            if (r11 != 0) goto L8
            return r2
        L8:
            android.content.Context r11 = r11.getApplicationContext()
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch
            r4 = 1
            r3.<init>(r4)
            java.lang.String[] r5 = new java.lang.String[r4]
            com.stepos.pps.data.deviceid.SafeCertClient$1 r6 = new com.stepos.pps.data.deviceid.SafeCertClient$1
            r6.<init>()
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            android.content.ComponentName r8 = new android.content.ComponentName
            java.lang.String r9 = "com.stepos.secureservice"
            java.lang.String r10 = "com.stepos.secureservice.certification.SafeCertService"
            r8.<init>(r9, r10)
            r7.setComponent(r8)
            java.lang.String r8 = "com.stepos.secureservice.SafeCertification"
            r7.setAction(r8)
            r8 = 0
            java.util.concurrent.Executor r9 = com.stepos.pps.data.deviceid.SafeCertClient.sCallbackExecutor     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L6e
            boolean r4 = r11.bindService(r7, r4, r9, r6)     // Catch: java.lang.Throwable -> L5a java.lang.InterruptedException -> L6e
            if (r4 != 0) goto L43
            java.lang.String r3 = "bindService(SafeCertService) failed"
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L6f
            if (r4 == 0) goto L42
            r11.unbindService(r6)     // Catch: java.lang.Throwable -> L42
        L42:
            return r2
        L43:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L6f
            r9 = 4000(0xfa0, double:1.9763E-320)
            boolean r2 = r3.await(r9, r2)     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L6f
            if (r2 != 0) goto L52
            java.lang.String r2 = "getEncryptedOaid timeout"
            android.util.Log.w(r0, r2)     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L6f
        L52:
            if (r4 == 0) goto L79
        L54:
            r11.unbindService(r6)     // Catch: java.lang.Throwable -> L79
            goto L79
        L58:
            r2 = move-exception
            goto L5c
        L5a:
            r2 = move-exception
            r4 = r8
        L5c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L8f
            r3.append(r2)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L8f
            android.util.Log.w(r0, r1)     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L79
            goto L54
        L6e:
            r4 = r8
        L6f:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8f
            r1.interrupt()     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L79
            goto L54
        L79:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "getEncryptedId result:"
            r11.<init>(r1)
            r1 = r5[r8]
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            android.util.Log.d(r0, r11)
            r11 = r5[r8]
            return r11
        L8f:
            r0 = move-exception
            if (r4 == 0) goto L95
            r11.unbindService(r6)     // Catch: java.lang.Throwable -> L95
        L95:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.deviceid.SafeCertClient.getEncryptedOaid(android.content.Context):java.lang.String");
    }
}
