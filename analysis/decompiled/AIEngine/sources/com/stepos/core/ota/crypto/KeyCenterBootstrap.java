package com.stepos.core.ota.crypto;

import a0.a;
import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.net.NetEnv;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import gc.q;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyCenterBootstrap {
    private static final String PATH = "/key-center";
    private static final String TAG = "KeyCenterBootstrap";
    public static final KeyCenterBootstrap INSTANCE = new KeyCenterBootstrap();
    private static final AtomicReference<Context> ctxRef = new AtomicReference<>(null);
    private static volatile String baseUrl = "";
    private static volatile String appId = "";
    private static volatile String appSecret = "";
    private static volatile String deviceAuthToken = "";
    private static volatile String fallbackProofKey = "";

    private KeyCenterBootstrap() {
    }

    public final String appId$ota_release() {
        return appId;
    }

    public final String appSecret$ota_release() {
        return appSecret;
    }

    public final String baseUrl$ota_release() {
        return baseUrl;
    }

    public final String deviceAuthToken$ota_release() {
        return deviceAuthToken;
    }

    public final String fallbackProofKey$ota_release() {
        return fallbackProofKey;
    }

    public final boolean isReady() {
        return (q.t0(baseUrl) || q.t0(appId) || q.t0(appSecret) || q.t0(deviceAuthToken)) ? false : true;
    }

    public final List<String> missingFields() {
        ListBuilder listBuilderY = b1.y();
        if (q.t0(baseUrl)) {
            listBuilderY.add("baseUrl");
        }
        if (q.t0(appId)) {
            listBuilderY.add("appId");
        }
        if (q.t0(appSecret)) {
            listBuilderY.add("appSecret");
        }
        if (q.t0(deviceAuthToken)) {
            listBuilderY.add("deviceAuthToken");
        }
        return b1.i(listBuilderY);
    }

    public final void setup(Context context, Params params) {
        g.f(context, "context");
        g.f(params, "params");
        Context applicationContext = context.getApplicationContext();
        AtomicReference<Context> atomicReference = ctxRef;
        while (!atomicReference.compareAndSet(null, applicationContext)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        NetEnv netEnv = NetEnv.INSTANCE;
        g.c(applicationContext);
        boolean zIsTest = netEnv.isTest(applicationContext);
        baseUrl = a.k("https://biz-gw.", netEnv.host(applicationContext), PATH);
        appId = zIsTest ? params.getTestAppId() : params.getProdAppId();
        appSecret = zIsTest ? params.getTestAppSecret() : params.getProdAppSecret();
        deviceAuthToken = zIsTest ? params.getTestDeviceAuthToken() : params.getProdDeviceAuthToken();
        fallbackProofKey = zIsTest ? params.getTestFallbackProofKey() : params.getProdFallbackProofKey();
        LogModule logModule = LogModule.OTA;
        String str = zIsTest ? "TEST" : "PROD";
        String str2 = baseUrl;
        String str3 = appId;
        int length = appSecret.length();
        int length2 = deviceAuthToken.length();
        int length3 = fallbackProofKey.length();
        StringBuilder sbS = ai.onnxruntime.a.s("setup done env=", str, " baseUrl=", str2, " appId=");
        d.o(length, str3, " secretLen=", " tokenLen=", sbS);
        sbS.append(length2);
        sbS.append(" proofKeyLen=");
        sbS.append(length3);
        AIEngineLogger.i(logModule, TAG, sbS.toString());
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Params {
        private final String prodAppId;
        private final String prodAppSecret;
        private final String prodDeviceAuthToken;
        private final String prodFallbackProofKey;
        private final String testAppId;
        private final String testAppSecret;
        private final String testDeviceAuthToken;
        private final String testFallbackProofKey;

        public Params(String testAppId, String testAppSecret, String testDeviceAuthToken, String prodAppId, String prodAppSecret, String prodDeviceAuthToken, String testFallbackProofKey, String prodFallbackProofKey) {
            g.f(testAppId, "testAppId");
            g.f(testAppSecret, "testAppSecret");
            g.f(testDeviceAuthToken, "testDeviceAuthToken");
            g.f(prodAppId, "prodAppId");
            g.f(prodAppSecret, "prodAppSecret");
            g.f(prodDeviceAuthToken, "prodDeviceAuthToken");
            g.f(testFallbackProofKey, "testFallbackProofKey");
            g.f(prodFallbackProofKey, "prodFallbackProofKey");
            this.testAppId = testAppId;
            this.testAppSecret = testAppSecret;
            this.testDeviceAuthToken = testDeviceAuthToken;
            this.prodAppId = prodAppId;
            this.prodAppSecret = prodAppSecret;
            this.prodDeviceAuthToken = prodDeviceAuthToken;
            this.testFallbackProofKey = testFallbackProofKey;
            this.prodFallbackProofKey = prodFallbackProofKey;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = params.testAppId;
            }
            if ((i10 & 2) != 0) {
                str2 = params.testAppSecret;
            }
            if ((i10 & 4) != 0) {
                str3 = params.testDeviceAuthToken;
            }
            if ((i10 & 8) != 0) {
                str4 = params.prodAppId;
            }
            if ((i10 & 16) != 0) {
                str5 = params.prodAppSecret;
            }
            if ((i10 & 32) != 0) {
                str6 = params.prodDeviceAuthToken;
            }
            if ((i10 & 64) != 0) {
                str7 = params.testFallbackProofKey;
            }
            if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
                str8 = params.prodFallbackProofKey;
            }
            String str9 = str7;
            String str10 = str8;
            String str11 = str5;
            String str12 = str6;
            return params.copy(str, str2, str3, str4, str11, str12, str9, str10);
        }

        public final String component1() {
            return this.testAppId;
        }

        public final String component2() {
            return this.testAppSecret;
        }

        public final String component3() {
            return this.testDeviceAuthToken;
        }

        public final String component4() {
            return this.prodAppId;
        }

        public final String component5() {
            return this.prodAppSecret;
        }

        public final String component6() {
            return this.prodDeviceAuthToken;
        }

        public final String component7() {
            return this.testFallbackProofKey;
        }

        public final String component8() {
            return this.prodFallbackProofKey;
        }

        public final Params copy(String testAppId, String testAppSecret, String testDeviceAuthToken, String prodAppId, String prodAppSecret, String prodDeviceAuthToken, String testFallbackProofKey, String prodFallbackProofKey) {
            g.f(testAppId, "testAppId");
            g.f(testAppSecret, "testAppSecret");
            g.f(testDeviceAuthToken, "testDeviceAuthToken");
            g.f(prodAppId, "prodAppId");
            g.f(prodAppSecret, "prodAppSecret");
            g.f(prodDeviceAuthToken, "prodDeviceAuthToken");
            g.f(testFallbackProofKey, "testFallbackProofKey");
            g.f(prodFallbackProofKey, "prodFallbackProofKey");
            return new Params(testAppId, testAppSecret, testDeviceAuthToken, prodAppId, prodAppSecret, prodDeviceAuthToken, testFallbackProofKey, prodFallbackProofKey);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return g.b(this.testAppId, params.testAppId) && g.b(this.testAppSecret, params.testAppSecret) && g.b(this.testDeviceAuthToken, params.testDeviceAuthToken) && g.b(this.prodAppId, params.prodAppId) && g.b(this.prodAppSecret, params.prodAppSecret) && g.b(this.prodDeviceAuthToken, params.prodDeviceAuthToken) && g.b(this.testFallbackProofKey, params.testFallbackProofKey) && g.b(this.prodFallbackProofKey, params.prodFallbackProofKey);
        }

        public final String getProdAppId() {
            return this.prodAppId;
        }

        public final String getProdAppSecret() {
            return this.prodAppSecret;
        }

        public final String getProdDeviceAuthToken() {
            return this.prodDeviceAuthToken;
        }

        public final String getProdFallbackProofKey() {
            return this.prodFallbackProofKey;
        }

        public final String getTestAppId() {
            return this.testAppId;
        }

        public final String getTestAppSecret() {
            return this.testAppSecret;
        }

        public final String getTestDeviceAuthToken() {
            return this.testDeviceAuthToken;
        }

        public final String getTestFallbackProofKey() {
            return this.testFallbackProofKey;
        }

        public int hashCode() {
            return this.prodFallbackProofKey.hashCode() + v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(this.testAppId.hashCode() * 31, 31, this.testAppSecret), 31, this.testDeviceAuthToken), 31, this.prodAppId), 31, this.prodAppSecret), 31, this.prodDeviceAuthToken), 31, this.testFallbackProofKey);
        }

        public String toString() {
            String str = this.testAppId;
            String str2 = this.testAppSecret;
            String str3 = this.testDeviceAuthToken;
            String str4 = this.prodAppId;
            String str5 = this.prodAppSecret;
            String str6 = this.prodDeviceAuthToken;
            String str7 = this.testFallbackProofKey;
            String str8 = this.prodFallbackProofKey;
            StringBuilder sbS = ai.onnxruntime.a.s("Params(testAppId=", str, ", testAppSecret=", str2, ", testDeviceAuthToken=");
            ai.onnxruntime.a.z(sbS, str3, ", prodAppId=", str4, ", prodAppSecret=");
            ai.onnxruntime.a.z(sbS, str5, ", prodDeviceAuthToken=", str6, ", testFallbackProofKey=");
            return d.j(sbS, str7, ", prodFallbackProofKey=", str8, ")");
        }

        public /* synthetic */ Params(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, e eVar) {
            this(str, str2, str3, str4, str5, str6, (i10 & 64) != 0 ? "" : str7, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? "" : str8);
        }
    }
}
