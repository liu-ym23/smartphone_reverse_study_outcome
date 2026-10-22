package com.stepos.stepclaw.config;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u0003R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/stepos/stepclaw/config/DeviceGatewayTokenStore;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "context", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getOrCreate", "(Landroid/content/Context;)Ljava/lang/String;", "Lb5/a0;", "clearMemoryCacheForTests$step_runtime_release", "clearMemoryCacheForTests", "TAG", "Ljava/lang/String;", "PREFS_NAME", "KEY_DERIVED_TOKEN", "memoryCache", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceGatewayTokenStore {
    public static final DeviceGatewayTokenStore INSTANCE = new DeviceGatewayTokenStore();
    private static final String KEY_DERIVED_TOKEN = "derived_token";
    private static final String PREFS_NAME = "stepclaw.gateway.auth";
    private static final String TAG = "DeviceGatewayToken";
    private static volatile String memoryCache;

    private DeviceGatewayTokenStore() {
    }

    public final void clearMemoryCacheForTests$step_runtime_release() {
        memoryCache = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getOrCreate(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "derived gateway token deviceBound="
            java.lang.String r1 = "context"
            kotlin.jvm.internal.p.e(r6, r1)
            java.lang.String r1 = com.stepos.stepclaw.config.DeviceGatewayTokenStore.memoryCache
            if (r1 == 0) goto Lc
            return r1
        Lc:
            monitor-enter(r5)
            java.lang.String r1 = com.stepos.stepclaw.config.DeviceGatewayTokenStore.memoryCache     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L13
            monitor-exit(r5)
            return r1
        L13:
            android.content.Context r6 = r6.getApplicationContext()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = "stepclaw.gateway.auth"
            r2 = 0
            android.content.SharedPreferences r1 = r6.getSharedPreferences(r1, r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = "derived_token"
            r3 = 0
            java.lang.String r2 = r1.getString(r2, r3)     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L38
            java.lang.CharSequence r2 = x5.n.T1(r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L38
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L3a
            if (r4 <= 0) goto L38
            goto L3c
        L38:
            r2 = r3
            goto L3c
        L3a:
            r6 = move-exception
            goto L92
        L3c:
            if (r2 == 0) goto L42
            com.stepos.stepclaw.config.DeviceGatewayTokenStore.memoryCache = r2     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r5)
            return r2
        L42:
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r2)     // Catch: java.lang.Throwable -> L3a
            if (r6 == 0) goto L63
            java.lang.CharSequence r6 = x5.n.T1(r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L3a
            if (r6 == 0) goto L63
            int r2 = r6.length()     // Catch: java.lang.Throwable -> L3a
            if (r2 <= 0) goto L5f
            goto L60
        L5f:
            r6 = r3
        L60:
            if (r6 == 0) goto L63
            goto L65
        L63:
            java.lang.String r6 = "unknown"
        L65:
            com.stepos.stepclaw.config.GatewayTokenDeriver r2 = com.stepos.stepclaw.config.GatewayTokenDeriver.INSTANCE     // Catch: java.lang.Throwable -> L3a
            r4 = 2
            java.lang.String r6 = com.stepos.stepclaw.config.GatewayTokenDeriver.derive$default(r2, r6, r3, r4, r3)     // Catch: java.lang.Throwable -> L3a
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "derived_token"
            android.content.SharedPreferences$Editor r1 = r1.putString(r3, r6)     // Catch: java.lang.Throwable -> L3a
            r1.apply()     // Catch: java.lang.Throwable -> L3a
            com.stepos.stepclaw.config.DeviceGatewayTokenStore.memoryCache = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = "DeviceGatewayToken"
            java.lang.String r2 = r2.maskToken(r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3a
            r3.append(r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            android.util.Log.i(r1, r0)     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r5)
            return r6
        L92:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.config.DeviceGatewayTokenStore.getOrCreate(android.content.Context):java.lang.String");
    }
}
