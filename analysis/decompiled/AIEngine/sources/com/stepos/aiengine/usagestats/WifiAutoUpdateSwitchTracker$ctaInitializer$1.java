package com.stepos.aiengine.usagestats;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.settings.AiEngineSystemSettings;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.cpuset.b;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class WifiAutoUpdateSwitchTracker$ctaInitializer$1 extends FunctionReferenceImpl implements l<Context, n> {
    @Override // zb.l
    public final n invoke(Context context) {
        Context p02 = context;
        g.f(p02, "p0");
        ((WifiAutoUpdateSwitchTracker) this.receiver).getClass();
        Context applicationContext = p02.getApplicationContext();
        synchronized (WifiAutoUpdateSwitchTracker.f5938b) {
            if (WifiAutoUpdateSwitchTracker.f5939c == null) {
                WifiAutoUpdateSwitchTracker.f5940d = Boolean.valueOf(CTAPermissionManager.INSTANCE.isWlanAutoUpgradeEnabled());
                AiEngineSystemSettings aiEngineSystemSettings = AiEngineSystemSettings.INSTANCE;
                g.c(applicationContext);
                WifiAutoUpdateSwitchTracker.f5939c = aiEngineSystemSettings.registerSwitchObserver(applicationContext, new b(11));
                AIEngineLogger.i(LogModule.SYSTEM, "WifiAutoUpdateSwitchTracker", "started, baseline=" + WifiAutoUpdateSwitchTracker.f5940d);
                n nVar = n.f10413a;
            }
        }
        return n.f10413a;
    }
}
