package com.stepos.core.common.cloud;

import android.content.Context;
import android.provider.Settings;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.q;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BffGatewayBootstrap {
    private static final String TAG = "BffGatewayBootstrap";
    private static volatile boolean testEnv;
    public static final BffGatewayBootstrap INSTANCE = new BffGatewayBootstrap();
    private static final AtomicReference<Context> ctxRef = new AtomicReference<>(null);
    private static volatile String appId = "";
    private static volatile String appSecret = "";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Env {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ Env[] $VALUES;
        public static final Env TEST = new Env("TEST", 0);
        public static final Env PROD = new Env("PROD", 1);

        private static final /* synthetic */ Env[] $values() {
            return new Env[]{TEST, PROD};
        }

        static {
            Env[] envArr$values = $values();
            $VALUES = envArr$values;
            $ENTRIES = kotlin.enums.a.a(envArr$values);
        }

        private Env(String str, int i10) {
        }

        public static sb.a<Env> getEntries() {
            return $ENTRIES;
        }

        public static Env valueOf(String str) {
            return (Env) Enum.valueOf(Env.class, str);
        }

        public static Env[] values() {
            return (Env[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Params {
        private final String prodAppId;
        private final String prodAppSecret;
        private final String testAppId;
        private final String testAppSecret;

        public Params(String testAppId, String testAppSecret, String prodAppId, String prodAppSecret) {
            kotlin.jvm.internal.g.f(testAppId, "testAppId");
            kotlin.jvm.internal.g.f(testAppSecret, "testAppSecret");
            kotlin.jvm.internal.g.f(prodAppId, "prodAppId");
            kotlin.jvm.internal.g.f(prodAppSecret, "prodAppSecret");
            this.testAppId = testAppId;
            this.testAppSecret = testAppSecret;
            this.prodAppId = prodAppId;
            this.prodAppSecret = prodAppSecret;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = params.testAppId;
            }
            if ((i10 & 2) != 0) {
                str2 = params.testAppSecret;
            }
            if ((i10 & 4) != 0) {
                str3 = params.prodAppId;
            }
            if ((i10 & 8) != 0) {
                str4 = params.prodAppSecret;
            }
            return params.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.testAppId;
        }

        public final String component2() {
            return this.testAppSecret;
        }

        public final String component3() {
            return this.prodAppId;
        }

        public final String component4() {
            return this.prodAppSecret;
        }

        public final Params copy(String testAppId, String testAppSecret, String prodAppId, String prodAppSecret) {
            kotlin.jvm.internal.g.f(testAppId, "testAppId");
            kotlin.jvm.internal.g.f(testAppSecret, "testAppSecret");
            kotlin.jvm.internal.g.f(prodAppId, "prodAppId");
            kotlin.jvm.internal.g.f(prodAppSecret, "prodAppSecret");
            return new Params(testAppId, testAppSecret, prodAppId, prodAppSecret);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return kotlin.jvm.internal.g.b(this.testAppId, params.testAppId) && kotlin.jvm.internal.g.b(this.testAppSecret, params.testAppSecret) && kotlin.jvm.internal.g.b(this.prodAppId, params.prodAppId) && kotlin.jvm.internal.g.b(this.prodAppSecret, params.prodAppSecret);
        }

        public final String getProdAppId() {
            return this.prodAppId;
        }

        public final String getProdAppSecret() {
            return this.prodAppSecret;
        }

        public final String getTestAppId() {
            return this.testAppId;
        }

        public final String getTestAppSecret() {
            return this.testAppSecret;
        }

        public int hashCode() {
            return this.prodAppSecret.hashCode() + v1.d.a(v1.d.a(this.testAppId.hashCode() * 31, 31, this.testAppSecret), 31, this.prodAppId);
        }

        public String toString() {
            String str = this.testAppId;
            String str2 = this.testAppSecret;
            return com.stepos.core.ota.d.j(ai.onnxruntime.a.s("Params(testAppId=", str, ", testAppSecret=", str2, ", prodAppId="), this.prodAppId, ", prodAppSecret=", this.prodAppSecret, ")");
        }
    }

    private BffGatewayBootstrap() {
    }

    private final Env resolveEnv(Context context) {
        Object objA;
        try {
            objA = Settings.Secure.getString(context.getContentResolver(), "net_env");
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return kotlin.jvm.internal.g.b((String) objA, "test") ? Env.TEST : Env.PROD;
    }

    public final Context appContext$common_release() {
        return ctxRef.get();
    }

    public final String appId$common_release() {
        return appId;
    }

    public final String appSecret$common_release() {
        return appSecret;
    }

    public final boolean isReady() {
        return (ctxRef.get() == null || q.t0(appId) || q.t0(appSecret)) ? false : true;
    }

    public final boolean isTestEnv$common_release() {
        return testEnv;
    }

    public final void setup(Context context, Params params) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(params, "params");
        Context applicationContext = context.getApplicationContext();
        AtomicReference<Context> atomicReference = ctxRef;
        while (!atomicReference.compareAndSet(null, applicationContext)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        kotlin.jvm.internal.g.c(applicationContext);
        Env envResolveEnv = resolveEnv(applicationContext);
        Env env = Env.TEST;
        testEnv = envResolveEnv == env;
        appId = envResolveEnv == env ? params.getTestAppId() : params.getProdAppId();
        appSecret = envResolveEnv == env ? params.getTestAppSecret() : params.getProdAppSecret();
        AIEngineLogger.i(LogModule.ABILITY, TAG, "setup done env=" + envResolveEnv + " appId=" + appId + " appSecretLen=" + appSecret.length());
        AccountWatcher.INSTANCE.register(applicationContext);
    }
}
