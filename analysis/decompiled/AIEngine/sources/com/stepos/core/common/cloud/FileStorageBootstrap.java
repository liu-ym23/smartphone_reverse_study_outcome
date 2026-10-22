package com.stepos.core.common.cloud;

import android.content.Context;
import android.provider.Settings;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import gc.q;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileStorageBootstrap {
    private static final String TAG = "FileStorageBootstrap";
    private static volatile boolean ready;
    public static final FileStorageBootstrap INSTANCE = new FileStorageBootstrap();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

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
        private final String prodBizCode;
        private final String prodGatewayBaseUrl;
        private final String prodSourceType;
        private final String testAppId;
        private final String testAppSecret;
        private final String testBizCode;
        private final String testGatewayBaseUrl;
        private final String testSourceType;

        public Params(String testAppId, String testAppSecret, String testGatewayBaseUrl, String prodAppId, String prodAppSecret, String prodGatewayBaseUrl, String testBizCode, String testSourceType, String prodBizCode, String prodSourceType) {
            kotlin.jvm.internal.g.f(testAppId, "testAppId");
            kotlin.jvm.internal.g.f(testAppSecret, "testAppSecret");
            kotlin.jvm.internal.g.f(testGatewayBaseUrl, "testGatewayBaseUrl");
            kotlin.jvm.internal.g.f(prodAppId, "prodAppId");
            kotlin.jvm.internal.g.f(prodAppSecret, "prodAppSecret");
            kotlin.jvm.internal.g.f(prodGatewayBaseUrl, "prodGatewayBaseUrl");
            kotlin.jvm.internal.g.f(testBizCode, "testBizCode");
            kotlin.jvm.internal.g.f(testSourceType, "testSourceType");
            kotlin.jvm.internal.g.f(prodBizCode, "prodBizCode");
            kotlin.jvm.internal.g.f(prodSourceType, "prodSourceType");
            this.testAppId = testAppId;
            this.testAppSecret = testAppSecret;
            this.testGatewayBaseUrl = testGatewayBaseUrl;
            this.prodAppId = prodAppId;
            this.prodAppSecret = prodAppSecret;
            this.prodGatewayBaseUrl = prodGatewayBaseUrl;
            this.testBizCode = testBizCode;
            this.testSourceType = testSourceType;
            this.prodBizCode = prodBizCode;
            this.prodSourceType = prodSourceType;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = params.testAppId;
            }
            if ((i10 & 2) != 0) {
                str2 = params.testAppSecret;
            }
            if ((i10 & 4) != 0) {
                str3 = params.testGatewayBaseUrl;
            }
            if ((i10 & 8) != 0) {
                str4 = params.prodAppId;
            }
            if ((i10 & 16) != 0) {
                str5 = params.prodAppSecret;
            }
            if ((i10 & 32) != 0) {
                str6 = params.prodGatewayBaseUrl;
            }
            if ((i10 & 64) != 0) {
                str7 = params.testBizCode;
            }
            if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
                str8 = params.testSourceType;
            }
            if ((i10 & 256) != 0) {
                str9 = params.prodBizCode;
            }
            if ((i10 & VadSessionManager.FRAME_BYTES) != 0) {
                str10 = params.prodSourceType;
            }
            String str11 = str9;
            String str12 = str10;
            String str13 = str7;
            String str14 = str8;
            String str15 = str5;
            String str16 = str6;
            return params.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
        }

        public final String component1() {
            return this.testAppId;
        }

        public final String component10() {
            return this.prodSourceType;
        }

        public final String component2() {
            return this.testAppSecret;
        }

        public final String component3() {
            return this.testGatewayBaseUrl;
        }

        public final String component4() {
            return this.prodAppId;
        }

        public final String component5() {
            return this.prodAppSecret;
        }

        public final String component6() {
            return this.prodGatewayBaseUrl;
        }

        public final String component7() {
            return this.testBizCode;
        }

        public final String component8() {
            return this.testSourceType;
        }

        public final String component9() {
            return this.prodBizCode;
        }

        public final Params copy(String testAppId, String testAppSecret, String testGatewayBaseUrl, String prodAppId, String prodAppSecret, String prodGatewayBaseUrl, String testBizCode, String testSourceType, String prodBizCode, String prodSourceType) {
            kotlin.jvm.internal.g.f(testAppId, "testAppId");
            kotlin.jvm.internal.g.f(testAppSecret, "testAppSecret");
            kotlin.jvm.internal.g.f(testGatewayBaseUrl, "testGatewayBaseUrl");
            kotlin.jvm.internal.g.f(prodAppId, "prodAppId");
            kotlin.jvm.internal.g.f(prodAppSecret, "prodAppSecret");
            kotlin.jvm.internal.g.f(prodGatewayBaseUrl, "prodGatewayBaseUrl");
            kotlin.jvm.internal.g.f(testBizCode, "testBizCode");
            kotlin.jvm.internal.g.f(testSourceType, "testSourceType");
            kotlin.jvm.internal.g.f(prodBizCode, "prodBizCode");
            kotlin.jvm.internal.g.f(prodSourceType, "prodSourceType");
            return new Params(testAppId, testAppSecret, testGatewayBaseUrl, prodAppId, prodAppSecret, prodGatewayBaseUrl, testBizCode, testSourceType, prodBizCode, prodSourceType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return kotlin.jvm.internal.g.b(this.testAppId, params.testAppId) && kotlin.jvm.internal.g.b(this.testAppSecret, params.testAppSecret) && kotlin.jvm.internal.g.b(this.testGatewayBaseUrl, params.testGatewayBaseUrl) && kotlin.jvm.internal.g.b(this.prodAppId, params.prodAppId) && kotlin.jvm.internal.g.b(this.prodAppSecret, params.prodAppSecret) && kotlin.jvm.internal.g.b(this.prodGatewayBaseUrl, params.prodGatewayBaseUrl) && kotlin.jvm.internal.g.b(this.testBizCode, params.testBizCode) && kotlin.jvm.internal.g.b(this.testSourceType, params.testSourceType) && kotlin.jvm.internal.g.b(this.prodBizCode, params.prodBizCode) && kotlin.jvm.internal.g.b(this.prodSourceType, params.prodSourceType);
        }

        public final String getProdAppId() {
            return this.prodAppId;
        }

        public final String getProdAppSecret() {
            return this.prodAppSecret;
        }

        public final String getProdBizCode() {
            return this.prodBizCode;
        }

        public final String getProdGatewayBaseUrl() {
            return this.prodGatewayBaseUrl;
        }

        public final String getProdSourceType() {
            return this.prodSourceType;
        }

        public final String getTestAppId() {
            return this.testAppId;
        }

        public final String getTestAppSecret() {
            return this.testAppSecret;
        }

        public final String getTestBizCode() {
            return this.testBizCode;
        }

        public final String getTestGatewayBaseUrl() {
            return this.testGatewayBaseUrl;
        }

        public final String getTestSourceType() {
            return this.testSourceType;
        }

        public int hashCode() {
            return this.prodSourceType.hashCode() + v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(this.testAppId.hashCode() * 31, 31, this.testAppSecret), 31, this.testGatewayBaseUrl), 31, this.prodAppId), 31, this.prodAppSecret), 31, this.prodGatewayBaseUrl), 31, this.testBizCode), 31, this.testSourceType), 31, this.prodBizCode);
        }

        public String toString() {
            String str = this.testAppId;
            String str2 = this.testAppSecret;
            String str3 = this.testGatewayBaseUrl;
            String str4 = this.prodAppId;
            String str5 = this.prodAppSecret;
            String str6 = this.prodGatewayBaseUrl;
            String str7 = this.testBizCode;
            String str8 = this.testSourceType;
            String str9 = this.prodBizCode;
            String str10 = this.prodSourceType;
            StringBuilder sbS = ai.onnxruntime.a.s("Params(testAppId=", str, ", testAppSecret=", str2, ", testGatewayBaseUrl=");
            ai.onnxruntime.a.z(sbS, str3, ", prodAppId=", str4, ", prodAppSecret=");
            ai.onnxruntime.a.z(sbS, str5, ", prodGatewayBaseUrl=", str6, ", testBizCode=");
            ai.onnxruntime.a.z(sbS, str7, ", testSourceType=", str8, ", prodBizCode=");
            return com.stepos.core.ota.d.j(sbS, str9, ", prodSourceType=", str10, ")");
        }
    }

    private FileStorageBootstrap() {
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

    /* JADX WARN: Type inference failed for: r2v5, types: [com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$tokenProvider$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$headerProvider$1] */
    public final boolean ensureSetup(Context context, Params params) {
        Object objA;
        Env envResolveEnv;
        String testAppId;
        String testAppSecret;
        String testGatewayBaseUrl;
        String testBizCode;
        String testSourceType;
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(params, "params");
        if (ready) {
            return true;
        }
        if (!initialized.compareAndSet(false, true)) {
            return ready;
        }
        try {
            envResolveEnv = resolveEnv(context);
            Env env = Env.TEST;
            testAppId = envResolveEnv == env ? params.getTestAppId() : params.getProdAppId();
            testAppSecret = envResolveEnv == env ? params.getTestAppSecret() : params.getProdAppSecret();
            testGatewayBaseUrl = envResolveEnv == env ? params.getTestGatewayBaseUrl() : params.getProdGatewayBaseUrl();
            testBizCode = envResolveEnv == env ? params.getTestBizCode() : params.getProdBizCode();
            testSourceType = envResolveEnv == env ? params.getTestSourceType() : params.getProdSourceType();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (q.t0(testAppId)) {
            throw new IllegalArgumentException(("appId blank (env=" + envResolveEnv + ")").toString());
        }
        if (q.t0(testAppSecret)) {
            throw new IllegalArgumentException(("appSecret blank (env=" + envResolveEnv + ")").toString());
        }
        if (q.t0(testGatewayBaseUrl)) {
            throw new IllegalArgumentException(("gatewayBaseUrl blank (env=" + envResolveEnv + ")").toString());
        }
        ?? r22 = new m8.c() { // from class: com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$tokenProvider$1
            @Override // m8.c
            public Object getToken(qb.b<? super String> bVar) {
                return AccountTokenCache.INSTANCE.bearerToken("fileStorage", bVar);
            }
        };
        ?? r32 = new m8.a() { // from class: com.stepos.core.common.cloud.FileStorageBootstrap$ensureSetup$1$headerProvider$1
            @Override // m8.a
            public Object getHeaders(qb.b<? super Map<String, String>> bVar) {
                return kotlin.collections.b.d0();
            }
        };
        m8.b bVar = new m8.b(testAppId, testAppSecret, testBizCode, testGatewayBaseUrl, testSourceType);
        com.stepos.common.utils.filestorage.a.c(bVar, r22, r32);
        ready = true;
        AIEngineLogger.i(LogModule.ABILITY, TAG, "FileStorageBootstrap: setup done env=" + envResolveEnv + " appId=" + testAppId + " appSecretLen=" + testAppSecret.length() + " gatewayBaseUrl=" + testGatewayBaseUrl + " serviceName=" + bVar.f10524e + " bizCode=" + testBizCode + " sourceType=" + testSourceType);
        objA = Boolean.TRUE;
        Throwable thB = Result.b(objA);
        if (thB != null) {
            initialized.set(false);
            AIEngineLogger.e(LogModule.ABILITY, TAG, "FileStorageBootstrap: setup failed", thB);
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final boolean isReady() {
        return ready;
    }
}
