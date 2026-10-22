package com.stepos.core.ability.settings;

import ai.onnxruntime.a;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.HashMap;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnhancedServiceLauncherKt {
    public static final int ENHANCED_SERVICE_ERR_LAUNCH_FAILED = 6;
    public static final int ENHANCED_SERVICE_ERR_NOT_FOUND = 4;
    public static final int ENHANCED_SERVICE_ERR_NO_CONTEXT = 5;
    public static final int ENHANCED_SERVICE_ERR_PERMISSION = 2;
    public static final int ENHANCED_SERVICE_ERR_RATE_LIMITED = 3;
    public static final int ENHANCED_SERVICE_OK = 0;
    private static final long MIN_INTERVAL_MS = 2000;
    private static final int SETTINGS_TASK_FLAGS = 268468224;
    private static final String TAG = "EnhancedServiceLauncher";
    private static final HashMap<Integer, Long> lastLaunchAt = new HashMap<>();

    private static final boolean allowLaunch(int i10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap<Integer, Long> map = lastLaunchAt;
        synchronized (map) {
            Long l10 = map.get(Integer.valueOf(i10));
            if (jElapsedRealtime - (l10 != null ? l10.longValue() : 0L) < 2000) {
                return false;
            }
            map.put(Integer.valueOf(i10), Long.valueOf(jElapsedRealtime));
            return true;
        }
    }

    public static final int launchEnhancedServiceSettings(Context context, int i10) {
        Object objA;
        Object objA2;
        if (!allowLaunch(i10)) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "launch: rate limited uid=" + i10);
            return 3;
        }
        if (context == null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "launch: appContext null");
            return 5;
        }
        Intent intentResolveEnhancedServiceIntent = resolveEnhancedServiceIntent(context);
        if (intentResolveEnhancedServiceIntent == null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "launch: no settings activity resolved");
            return 4;
        }
        try {
            context.startActivity(intentResolveEnhancedServiceIntent);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.ABILITY, TAG, a.l("startActivity failed: ", thB.getClass().getSimpleName(), " ", thB.getMessage()), thB);
        }
        if (!(objA instanceof Result.Failure)) {
            LogModule logModule = LogModule.ABILITY;
            Object component = intentResolveEnhancedServiceIntent.getComponent();
            if (component == null) {
                component = intentResolveEnhancedServiceIntent.getAction();
            }
            AIEngineLogger.i(logModule, TAG, "launch: uid=" + i10 + " target=" + component);
            return 0;
        }
        Intent intentAddFlags = new Intent("android.settings.SETTINGS").addFlags(SETTINGS_TASK_FLAGS);
        g.e(intentAddFlags, "addFlags(...)");
        try {
            context.startActivity(intentAddFlags);
            objA2 = n.f10413a;
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        boolean z = objA2 instanceof Result.Failure;
        LogModule logModule2 = LogModule.ABILITY;
        StringBuilder sb2 = new StringBuilder("fallback to settings home: launched=");
        sb2.append(!z);
        AIEngineLogger.w(logModule2, TAG, sb2.toString());
        return !z ? 0 : 6;
    }

    private static final Intent resolveEnhancedServiceIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.SubSettings");
        intent.putExtra(":settings:show_fragment", "com.stepos.settings.accessibility.StepOSEnhancedServiceFragment");
        intent.addFlags(SETTINGS_TASK_FLAGS);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        Intent intentAddFlags = new Intent("android.settings.SETTINGS").addFlags(SETTINGS_TASK_FLAGS);
        g.e(intentAddFlags, "addFlags(...)");
        if (intentAddFlags.resolveActivity(context.getPackageManager()) != null) {
            return intentAddFlags;
        }
        return null;
    }
}
