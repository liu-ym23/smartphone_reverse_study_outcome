package com.bytedance.bdtracker;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.store.kv.IKVStore;
import com.bytedance.bdtracker.e0;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class y5 {
    public static w5<a6> a = new a();

    public static class a extends w5<a6> {
        @Override // com.bytedance.bdtracker.w5
        public a6 a(Object[] objArr) {
            return new a6((Context) objArr[0]);
        }
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void a(IOaidObserver iOaidObserver) {
        a6.a(iOaidObserver);
    }

    public static void a(g gVar) {
        g gVar2;
        a6.k = gVar;
        Map<String, String> map = a6.m;
        if (map == null || (gVar2 = a6.k) == null) {
            return;
        }
        ((e0.b) gVar2).a(map);
    }

    public static void b(Context context) {
        LoggerImpl.global().debug(1, "Oaid#initOaidEarly", new Object[0]);
        a.b(context).a();
    }

    public static void b(IOaidObserver iOaidObserver) {
        a6.b(iOaidObserver);
    }

    public static String a(IKVStore iKVStore) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strB = x5.a.b(iKVStore);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        LoggerImpl.global().debug(1, "getCdid takes " + jElapsedRealtime2 + " ms", new Object[0]);
        return strB;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map a(android.content.Context r13) {
        /*
            java.lang.String r0 = "Oaid#getOaid locked="
            long r1 = android.os.SystemClock.elapsedRealtime()
            com.bytedance.bdtracker.w5<com.bytedance.bdtracker.a6> r3 = com.bytedance.bdtracker.y5.a
            java.lang.Object[] r13 = new java.lang.Object[]{r13}
            java.lang.Object r13 = r3.b(r13)
            com.bytedance.bdtracker.a6 r13 = (com.bytedance.bdtracker.a6) r13
            int r3 = com.bytedance.applog.OaidHelper.oadiTimeout
            long r3 = (long) r3
            boolean r5 = r13.c
            java.lang.String r6 = " ms"
            r7 = 1
            r8 = 0
            if (r5 != 0) goto L20
            r13 = 0
            goto Lb6
        L20:
            r13.a()
            com.bytedance.applog.log.IAppLogLogger r5 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Oaid#getOaid timeoutMills="
            r9.<init>(r10)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r5.debug(r7, r9, r10)
            java.util.Map<java.lang.String, java.lang.String> r5 = com.bytedance.bdtracker.a6.m
            if (r5 != 0) goto La5
            long r9 = android.os.SystemClock.elapsedRealtime()
            com.bytedance.dr.OaidApi r5 = r13.b     // Catch: java.lang.Throwable -> L87
            if (r5 == 0) goto L55
            java.lang.String r11 = "HONOR"
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L87
            boolean r5 = r11.equalsIgnoreCase(r5)     // Catch: java.lang.Throwable -> L87
            if (r5 == 0) goto L55
            r11 = 100
            long r3 = r3 + r11
        L55:
            java.util.concurrent.locks.ReentrantLock r5 = r13.a     // Catch: java.lang.Throwable -> L87
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L87
            boolean r3 = r5.tryLock(r3, r11)     // Catch: java.lang.Throwable -> L87
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L85
            long r4 = r4 - r9
            com.bytedance.applog.log.IAppLogLogger r9 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L85
            r10.append(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = ", took "
            r10.append(r0)     // Catch: java.lang.Throwable -> L85
            r10.append(r4)     // Catch: java.lang.Throwable -> L85
            r10.append(r6)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r10.toString()     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L85
            r9.debug(r7, r0, r4)     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto La5
            goto L96
        L85:
            r0 = move-exception
            goto L89
        L87:
            r0 = move-exception
            r3 = r8
        L89:
            com.bytedance.applog.log.IAppLogLogger r4 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r5 = "Oaid#Get oaid failed"
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L9c
            r4.error(r7, r5, r0, r9)     // Catch: java.lang.Throwable -> L9c
            if (r3 == 0) goto La5
        L96:
            java.util.concurrent.locks.ReentrantLock r13 = r13.a
            r13.unlock()
            goto La5
        L9c:
            r0 = move-exception
            if (r3 == 0) goto La4
            java.util.concurrent.locks.ReentrantLock r13 = r13.a
            r13.unlock()
        La4:
            throw r0
        La5:
            com.bytedance.applog.log.IAppLogLogger r13 = com.bytedance.applog.log.LoggerImpl.global()
            java.util.Map<java.lang.String, java.lang.String> r0 = com.bytedance.bdtracker.a6.m
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r3 = "Oaid#getOaid return apiMap={}"
            r13.debug(r7, r3, r0)
            java.util.Map<java.lang.String, java.lang.String> r13 = com.bytedance.bdtracker.a6.m
        Lb6:
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r1
            com.bytedance.applog.log.IAppLogLogger r0 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Oaid#getOaid takes "
            r1.<init>(r2)
            r1.append(r3)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r0.debug(r7, r1, r2)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.y5.a(android.content.Context):java.util.Map");
    }
}
