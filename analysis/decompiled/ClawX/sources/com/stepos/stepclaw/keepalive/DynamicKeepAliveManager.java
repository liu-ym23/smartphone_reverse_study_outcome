package com.stepos.stepclaw.keepalive;

import a8.b;
import android.util.Log;
import com.stepos.keepalive.StepOSKeepAliveManager;
import com.stepos.stepclaw.SecurePrefs;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/stepclaw/keepalive/DynamicKeepAliveManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "PROCESS_NAME", "FLAG_ALIVE", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "FLAG_PERF", "activeFlags", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "start", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "flag", "timeoutMs", "stop", "isActive", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DynamicKeepAliveManager {
    public static final int FLAG_ALIVE = 1;
    public static final int FLAG_PERF = 2;
    private static final String PROCESS_NAME = "com.stepos.stepclaw";
    private static final String TAG = "DynamicKeepAlive";
    public static final DynamicKeepAliveManager INSTANCE = new DynamicKeepAliveManager();
    private static volatile Set<Integer> activeFlags = new LinkedHashSet();

    private DynamicKeepAliveManager() {
    }

    public static /* synthetic */ boolean isActive$default(DynamicKeepAliveManager dynamicKeepAliveManager, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 1;
        }
        return dynamicKeepAliveManager.isActive(i8);
    }

    public static /* synthetic */ boolean start$default(DynamicKeepAliveManager dynamicKeepAliveManager, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 1;
        }
        return dynamicKeepAliveManager.start(i8, i9);
    }

    public static /* synthetic */ boolean stop$default(DynamicKeepAliveManager dynamicKeepAliveManager, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 1;
        }
        return dynamicKeepAliveManager.stop(i8);
    }

    public final boolean isActive(int flag) {
        boolean zContains;
        synchronized (this) {
            zContains = activeFlags.contains(Integer.valueOf(flag));
        }
        return zContains;
    }

    public final boolean start(int flag, int timeoutMs) {
        try {
            boolean processTempKeepAlive = StepOSKeepAliveManager.get().setProcessTempKeepAlive(PROCESS_NAME, flag, timeoutMs);
            if (!processTempKeepAlive) {
                Log.w(TAG, "start failed: service returned false, flag=" + flag);
                return processTempKeepAlive;
            }
            synchronized (this) {
                activeFlags.add(Integer.valueOf(flag));
            }
            Log.i(TAG, "started: flag=" + flag + " timeout=" + timeoutMs + "ms");
            return processTempKeepAlive;
        } catch (Throwable th) {
            b.y("start unavailable: ", th.getMessage(), TAG);
            return false;
        }
    }

    public final boolean stop(int flag) {
        try {
            boolean zEndProcessTempKeepAlive = StepOSKeepAliveManager.get().endProcessTempKeepAlive(PROCESS_NAME, flag);
            if (!zEndProcessTempKeepAlive) {
                Log.w(TAG, "stop failed: service returned false, flag=" + flag);
                return zEndProcessTempKeepAlive;
            }
            synchronized (this) {
                activeFlags.remove(Integer.valueOf(flag));
            }
            Log.i(TAG, "stopped: flag=" + flag);
            return zEndProcessTempKeepAlive;
        } catch (Throwable th) {
            b.y("stop unavailable: ", th.getMessage(), TAG);
            return false;
        }
    }
}
