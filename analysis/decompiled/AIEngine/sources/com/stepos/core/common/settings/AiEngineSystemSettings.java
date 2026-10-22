package com.stepos.core.common.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.m;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiEngineSystemSettings {
    public static final AiEngineSystemSettings INSTANCE = new AiEngineSystemSettings();
    public static final String KEY_CTA_AGREE_STATUS = "ai_engine_cta_agree_status";
    public static final String KEY_MODEL_SERVICE_STATUS = "ai_engine_model_service_status";
    public static final String KEY_WIFI_AUTO_UPDATE = "ai_engine_wifi_auto_update";

    private AiEngineSystemSettings() {
    }

    public static /* synthetic */ boolean isCtaAgreed$default(AiEngineSystemSettings aiEngineSystemSettings, Context context, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return aiEngineSystemSettings.isCtaAgreed(context, z);
    }

    public static /* synthetic */ boolean isModelServiceEnabled$default(AiEngineSystemSettings aiEngineSystemSettings, Context context, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = true;
        }
        return aiEngineSystemSettings.isModelServiceEnabled(context, z);
    }

    public static /* synthetic */ boolean isWifiAutoUpdateEnabled$default(AiEngineSystemSettings aiEngineSystemSettings, Context context, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return aiEngineSystemSettings.isWifiAutoUpdateEnabled(context, z);
    }

    private final String readRaw(Context context, String str) {
        Object objA;
        try {
            objA = Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (String) objA;
    }

    public final boolean isCtaAgreed(Context context, boolean z) {
        g.f(context, "context");
        return readBool(context, KEY_CTA_AGREE_STATUS, z);
    }

    public final boolean isModelServiceEnabled(Context context, boolean z) {
        g.f(context, "context");
        return readBool(context, KEY_MODEL_SERVICE_STATUS, z);
    }

    public final boolean isWifiAutoUpdateEnabled(Context context, boolean z) {
        g.f(context, "context");
        return readBool(context, KEY_WIFI_AUTO_UPDATE, z);
    }

    public final boolean readBool(Context context, String key, boolean z) {
        g.f(context, "context");
        g.f(key, "key");
        String raw = readRaw(context, key);
        if (g.b(raw, "1")) {
            return true;
        }
        if (!g.b(raw, "0") && raw == null) {
            return z;
        }
        return false;
    }

    public final ContentObserver registerSwitchObserver(Context context, final a<n> onChanged) {
        g.f(context, "context");
        g.f(onChanged, "onChanged");
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        final Handler handler = new Handler(Looper.getMainLooper());
        ContentObserver contentObserver = new ContentObserver(handler) { // from class: com.stepos.core.common.settings.AiEngineSystemSettings$registerSwitchObserver$observer$1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                onChanged.invoke();
            }
        };
        try {
            contentResolver.registerContentObserver(Settings.System.getUriFor(KEY_CTA_AGREE_STATUS), false, contentObserver);
            contentResolver.registerContentObserver(Settings.System.getUriFor(KEY_MODEL_SERVICE_STATUS), false, contentObserver);
            contentResolver.registerContentObserver(Settings.System.getUriFor(KEY_WIFI_AUTO_UPDATE), false, contentObserver);
            n nVar = n.f10413a;
            return contentObserver;
        } catch (Throwable th) {
            c.a(th);
            return contentObserver;
        }
    }

    public final boolean setCtaAgreed(Context context, boolean z) {
        g.f(context, "context");
        return writeBool(context, KEY_CTA_AGREE_STATUS, z);
    }

    public final boolean setModelServiceEnabled(Context context, boolean z) {
        g.f(context, "context");
        return writeBool(context, KEY_MODEL_SERVICE_STATUS, z);
    }

    public final boolean setWifiAutoUpdate(Context context, boolean z) {
        g.f(context, "context");
        return writeBool(context, KEY_WIFI_AUTO_UPDATE, z);
    }

    public final void takeOwnershipOfCtaSwitches(Context context) {
        g.f(context, "context");
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        for (String str : m.b0(KEY_CTA_AGREE_STATUS, KEY_MODEL_SERVICE_STATUS)) {
            String raw = INSTANCE.readRaw(context, str);
            if (raw != null) {
                try {
                    Settings.System.putString(contentResolver, str, raw);
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        }
    }

    public final void unregisterSwitchObserver(Context context, ContentObserver observer) {
        g.f(context, "context");
        g.f(observer, "observer");
        try {
            context.getApplicationContext().getContentResolver().unregisterContentObserver(observer);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public final boolean writeBool(Context context, String key, boolean z) {
        Object objA;
        g.f(context, "context");
        g.f(key, "key");
        try {
            objA = Boolean.valueOf(Settings.System.putString(context.getContentResolver(), key, z ? "1" : "0"));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }
}
