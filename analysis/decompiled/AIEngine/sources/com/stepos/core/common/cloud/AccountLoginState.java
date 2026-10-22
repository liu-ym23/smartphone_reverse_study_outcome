package com.stepos.core.common.cloud;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AccountLoginState {
    private static final long AUTHORITATIVE_TTL_MS = 600000;
    private static final long FALLBACK_TTL_MS = 60000;
    public static final AccountLoginState INSTANCE = new AccountLoginState();
    private static final AtomicReference<Snapshot> cached = new AtomicReference<>(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Snapshot {
        private final long expiresAtMs;
        private final boolean loggedIn;

        public Snapshot(boolean z, long j10) {
            this.loggedIn = z;
            this.expiresAtMs = j10;
        }

        public final long getExpiresAtMs() {
            return this.expiresAtMs;
        }

        public final boolean getLoggedIn() {
            return this.loggedIn;
        }
    }

    private AccountLoginState() {
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean queryAndCache(long r8) {
        /*
            r7 = this;
            java.lang.String r7 = "basic"
            com.stepos.core.common.cloud.BffGatewayBootstrap r0 = com.stepos.core.common.cloud.BffGatewayBootstrap.INSTANCE
            android.content.Context r0 = r0.appContext$common_release()
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            android.content.ContentResolver r2 = r0.getContentResolver()     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "net_env"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)     // Catch: java.lang.Throwable -> La1
            android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> La1
            android.content.Context r7 = r0.getApplicationContext()     // Catch: java.lang.Throwable -> La1
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La1
            r0.<init>()     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "https://i."
            r0.<init>(r3)     // Catch: java.lang.Throwable -> La1
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La1
            r4 = 1
            if (r3 != 0) goto L69
            r2.getClass()     // Catch: java.lang.Throwable -> La1
            int r3 = r2.hashCode()
            r5 = -1
            switch(r3) {
                case 99349: goto L52;
                case 114214: goto L47;
                case 3556498: goto L3c;
                default: goto L3b;
            }
        L3b:
            goto L5c
        L3c:
            java.lang.String r3 = "test"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L45
            goto L5c
        L45:
            r5 = 2
            goto L5c
        L47:
            java.lang.String r3 = "stg"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L50
            goto L5c
        L50:
            r5 = r4
            goto L5c
        L52:
            java.lang.String r3 = "dev"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L5b
            goto L5c
        L5b:
            r5 = r1
        L5c:
            switch(r5) {
                case 0: goto L66;
                case 1: goto L63;
                case 2: goto L60;
                default: goto L5f;
            }
        L5f:
            goto L69
        L60:
            java.lang.String r3 = "t-stepaos.com"
            goto L6b
        L63:
            java.lang.String r3 = "s-stepaos.com"
            goto L6b
        L66:
            java.lang.String r3 = "d-stepaos.com"
            goto L6b
        L69:
            java.lang.String r3 = "stepaos.com"
        L6b:
            r0.append(r3)     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "/uc/oauth/member/getBasicInfo"
            r0.append(r3)     // Catch: java.lang.Throwable -> La1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "[Cloud]Account.SDK"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1
            java.lang.String r6 = "env: "
            r5.<init>(r6)     // Catch: java.lang.Throwable -> La1
            r5.append(r2)     // Catch: java.lang.Throwable -> La1
            java.lang.String r2 = ", url: "
            r5.append(r2)     // Catch: java.lang.Throwable -> La1
            r5.append(r0)     // Catch: java.lang.Throwable -> La1
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> La1
            android.util.Log.i(r3, r0)     // Catch: java.lang.Throwable -> La1
            if (r7 != 0) goto L95
            goto L9c
        L95:
            android.accounts.Account r7 = mb.y.w(r7)     // Catch: java.lang.Throwable -> La1
            if (r7 == 0) goto L9c
            r1 = r4
        L9c:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La1
            goto La6
        La1:
            r7 = move-exception
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
        La6:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            boolean r1 = r7 instanceof kotlin.Result.Failure
            if (r1 == 0) goto Lad
            r7 = r0
        Lad:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.util.concurrent.atomic.AtomicReference<com.stepos.core.common.cloud.AccountLoginState$Snapshot> r0 = com.stepos.core.common.cloud.AccountLoginState.cached
            com.stepos.core.common.cloud.AccountLoginState$Snapshot r1 = new com.stepos.core.common.cloud.AccountLoginState$Snapshot
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 + r8
            r1.<init>(r7, r2)
            r0.set(r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.cloud.AccountLoginState.queryAndCache(long):boolean");
    }

    public final boolean isLoggedIn() {
        Snapshot snapshot = cached.get();
        return (snapshot == null || SystemClock.elapsedRealtime() >= snapshot.getExpiresAtMs()) ? queryAndCache(60000L) : snapshot.getLoggedIn();
    }

    public final boolean refreshAndGet() {
        return queryAndCache(AUTHORITATIVE_TTL_MS);
    }
}
