package com.stepos.aiengine.usagestats;

import android.app.Application;
import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import com.google.android.material.button.a;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class UsageStatsBootstrap$ctaInitializer$1 extends FunctionReferenceImpl implements l<Context, n> {
    @Override // zb.l
    public final n invoke(Context context) {
        Object objA;
        Context p02 = context;
        g.f(p02, "p0");
        ((UsageStatsBootstrap) this.receiver).getClass();
        AtomicBoolean atomicBoolean = UsageStatsBootstrap.f5935b;
        Context applicationContext = p02.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            AIEngineLogger.w(LogModule.SYSTEM, "UsageStatsBootstrap", "init skipped: appContext not Application");
        } else if (!CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            AIEngineLogger.i(LogModule.SYSTEM, "UsageStatsBootstrap", "init skipped: CTA not granted");
        } else if (atomicBoolean.compareAndSet(false, true)) {
            try {
                b1.f1786i = new a(application);
                ea.a.a(application);
                AIEngineLogger.i(LogModule.SYSTEM, "UsageStatsBootstrap", "UsageStats SDK initialized");
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                atomicBoolean.set(false);
                AIEngineLogger.e(LogModule.SYSTEM, "UsageStatsBootstrap", "UsageStats SDK init failed", thB);
            }
        }
        return n.f10413a;
    }
}
