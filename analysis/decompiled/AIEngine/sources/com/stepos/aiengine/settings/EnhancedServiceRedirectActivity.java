package com.stepos.aiengine.settings;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.stepos.core.ability.settings.EnhancedServiceLauncherKt;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import kotlin.Result;
import kotlin.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnhancedServiceRedirectActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object objA;
        super.onCreate(bundle);
        int iIntValue = -1;
        if (Build.VERSION.SDK_INT >= 34) {
            try {
                objA = Integer.valueOf(getLaunchedFromUid());
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = -1;
            }
            iIntValue = ((Number) objA).intValue();
        }
        int iLaunchEnhancedServiceSettings = EnhancedServiceLauncherKt.launchEnhancedServiceSettings(getApplicationContext(), iIntValue);
        AIEngineLogger.i(LogModule.ABILITY, "EnhancedServiceRedirect", d.e(iIntValue, "redirect to enhanced service settings: callerUid=", iLaunchEnhancedServiceSettings, " rc=", iLaunchEnhancedServiceSettings == 0 ? "" : " (failed)"));
        finish();
        overridePendingTransition(0, 0);
    }
}
