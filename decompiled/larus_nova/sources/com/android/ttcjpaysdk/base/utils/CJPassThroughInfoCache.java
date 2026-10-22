package com.android.ttcjpaysdk.base.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPassThroughInfoCache;", "", "()V", "CACHE_TTL_MS", "", "TAG", "", "cache", "Lorg/json/JSONObject;", "cacheTimestamp", "lock", "clear", "", "createPassThroughInfo", MonitorConstants.CONNECT_TYPE_GET, "getWithoutCache", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPassThroughInfoCache {
    private static final long CACHE_TTL_MS = 3000;
    public static final CJPassThroughInfoCache INSTANCE = null;
    private static final String TAG = "CJPassThroughInfoCache";
    private static JSONObject cache;
    private static long cacheTimestamp;
    private static final Object lock = null;

    private CJPassThroughInfoCache() {
    }

    static {
        INSTANCE = new CJPassThroughInfoCache();
        lock = new Object();
    }

    @JvmStatic
    public static final void clear() {
        Object r100 = lock;
        monitor-enter(r100);
        cache = null;     // Catch: Throwable -> L8
        cacheTimestamp = 0;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final JSONObject createPassThroughInfo() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = CJPayBasicUtils.getBioInfo();
        JSONObject r102 = CJPayBasicUtils.getNetProxyInfo();
        JSONObject r103 = CJPayBasicUtils.getPhoneAuthInfo();
        String r104 = CJPayBasicUtils.getCameraPermission();
        String r105 = CJPayBasicUtils.getVoicePermission();
        if (TextUtils.isEmpty(r105) == true) goto L6;
        r100.put("voice_authorization", r105);
    L6:
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r100.put("camera_authorization", r104);
    L8:
        r100.put("network_status", r102);
        r100.put("bio_info", r101);
        r100.put("phone_auth_info", r103);
        return r100;
    }

    @JvmStatic
    public static final JSONObject get() {
        Object r100 = lock;
        monitor-enter(r100);
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        JSONObject r102 = cache;     // Catch: Throwable -> L23
        if (r102 != null) goto L7;
    L26:
        JSONObject r103 = INSTANCE.createPassThroughInfo();     // Catch: Exception -> L18 Throwable -> L23
        cache = r103;     // Catch: Exception -> L18 Throwable -> L23
        cacheTimestamp = SystemClock.elapsedRealtime();     // Catch: Exception -> L18 Throwable -> L23
        CJLogger.d(TAG, "get compute");     // Catch: Exception -> L18 Throwable -> L23
    L20:
        r102 = r103;
    L21:
        monitor-exit(r100);
        return r102;
    L18:
        e = move-exception;
        CJLogger.c(TAG, "get error", e);     // Catch: Throwable -> L23
        r103 = new JSONObject();     // Catch: Throwable -> L23
        goto L20
    L7:
        if ((r101 - cacheTimestamp) >= 3000) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L26;
        CJLogger.d(TAG, "get hit cache");     // Catch: Throwable -> L23
        goto L21
    L9:
        r104 = false;
    L23:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final JSONObject getWithoutCache() {
        return INSTANCE.createPassThroughInfo();
    L4:
        e = move-exception;
        CJLogger.c(TAG, "getWithoutCache error", e);
        return new JSONObject();
    }
}
