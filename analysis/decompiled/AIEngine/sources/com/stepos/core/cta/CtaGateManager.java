package com.stepos.core.cta;

import android.content.Context;
import com.stepos.aicgroup.f;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import h0.e;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CtaGateManager {
    public static final CtaGateManager INSTANCE = new CtaGateManager();
    private static final String TAG = "CtaGateManager";

    private CtaGateManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void runWhenGranted$default(CtaGateManager ctaGateManager, String str, zb.a aVar, zb.a aVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        ctaGateManager.runWhenGranted(str, aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n runWhenGranted$lambda$4(String str, zb.a aVar, Context it) {
        Object objA;
        g.f(it, "it");
        e.k("runWhenGranted resumed after consent: ", str, LogModule.SERVICE, TAG);
        try {
            aVar.invoke();
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.SERVICE, TAG, "runWhenGranted onGranted failed (resumed): " + str, thB);
        }
        return n.f10413a;
    }

    public final boolean isGranted() {
        return CTAPermissionManager.INSTANCE.hasCTAPermission();
    }

    public final void runWhenGranted(String name, zb.a<n> aVar, zb.a<n> onGranted) {
        Object objA;
        g.f(name, "name");
        g.f(onGranted, "onGranted");
        if (!isGranted()) {
            AIEngineLogger.i(LogModule.SERVICE, TAG, "runWhenGranted deferred (awaiting consent, no prompt): ".concat(name));
            CtaGatedInitManager.INSTANCE.register(new CtaGatedInitializer(name, CtaGate.CTA_ONLY, new f(2, name, onGranted), null, null, 24, null));
            if (aVar != null) {
                aVar.invoke();
                return;
            }
            return;
        }
        AIEngineLogger.d(LogModule.SERVICE, TAG, "runWhenGranted: " + name + " granted, run now");
        try {
            onGranted.invoke();
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.SERVICE, TAG, "runWhenGranted onGranted failed: ".concat(name), thB);
        }
    }
}
