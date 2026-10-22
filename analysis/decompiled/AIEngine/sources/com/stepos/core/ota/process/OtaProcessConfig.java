package com.stepos.core.ota.process;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.tencent.mmkv.MMKV;
import kotlin.Result;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcessConfig {
    public static final boolean DEFAULT_ENABLED = true;
    private static final String PROP = "persist.sys.aiengine.ota_process";
    private static final String TAG = "OtaProcessConfig";
    public static final OtaProcessConfig INSTANCE = new OtaProcessConfig();
    private static volatile boolean enabled = true;

    private OtaProcessConfig() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.Result$Failure] */
    private final String readProp(String str, String str2) {
        String strA;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            g.d(objInvoke, "null cannot be cast to non-null type kotlin.String");
            strA = (String) objInvoke;
        } catch (Throwable th) {
            strA = kotlin.c.a(th);
        }
        if (!(strA instanceof Result.Failure)) {
            str2 = strA;
        }
        return str2;
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final void init(Context context) {
        g.f(context, "context");
        MMKV.m(context);
        enabled = g.b(readProp(PROP, "1"), "1");
        AIEngineLogger.i(LogModule.OTA, TAG, "ota process split enabled=" + enabled + " (prop=persist.sys.aiengine.ota_process)");
    }
}
