package com.stepos.core.common.atomic;

import android.content.Context;
import b6.i;
import com.stepos.ability.sdk.client.d;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import v5.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AtomicSdkBootstrap {
    private static final String TAG = "AtomicSdkBootstrap";
    public static final AtomicSdkBootstrap INSTANCE = new AtomicSdkBootstrap();
    private static final Object lock = new Object();
    private static final AtomicReference<Context> appContextRef = new AtomicReference<>(null);

    private AtomicSdkBootstrap() {
    }

    public final boolean ensureInitialized() {
        Object objA;
        if (isInitialized()) {
            return true;
        }
        Context context = appContextRef.get();
        if (context == null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "ensureInitialized skipped: appContext not primed — atomic dispatch will be UNAVAILABLE");
            return false;
        }
        synchronized (lock) {
            if (INSTANCE.isInitialized()) {
                return true;
            }
            try {
                d.f5570a.getClass();
                if (d.f5581m) {
                    b.b("Init ignore. Cause already init.");
                } else {
                    b.b("Init start.");
                    d.f5581m = true;
                    Context applicationContext = context.getApplicationContext();
                    g.e(applicationContext, "getApplicationContext(...)");
                    d.f5571b = applicationContext;
                    d.b(new i(5));
                }
                AIEngineLogger.i(LogModule.ABILITY, TAG, "AgentServiceClient.init() submitted; bind is async");
                objA = Boolean.TRUE;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.ABILITY, TAG, "AgentServiceClient.init failed: " + thB.getMessage() + " — atomic dispatch will be UNAVAILABLE", thB);
                objA = Boolean.FALSE;
            }
            return ((Boolean) objA).booleanValue();
        }
    }

    public final boolean isInitialized() {
        Object objA;
        try {
            d.f5570a.getClass();
            objA = Boolean.valueOf(d.f5581m);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void prime(Context context) {
        g.f(context, "context");
        AtomicReference<Context> atomicReference = appContextRef;
        Context applicationContext = context.getApplicationContext();
        while (!atomicReference.compareAndSet(null, applicationContext) && atomicReference.get() == null) {
        }
    }

    public final void release() {
        Object objA;
        synchronized (lock) {
            if (INSTANCE.isInitialized()) {
                try {
                    d.f5570a.getClass();
                    d.h();
                    AIEngineLogger.i(LogModule.ABILITY, TAG, "AgentServiceClient.release() done — unbound AgentService");
                    objA = n.f10413a;
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.ABILITY, TAG, "AgentServiceClient.release failed: " + thB.getMessage(), thB);
                }
            }
        }
    }
}
