package com.stepos.core.ability.speech;

import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.error.AIEngineError;
import h7.e;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SpeechCloudOrchestrator implements h7.d {
    private final String capabilityLabel;
    private final boolean cloudAvailable;
    private final zb.a<Boolean> isCtaGranted;
    private final zb.a<Boolean> isLoggedIn;
    private final boolean localAvailable;
    private final String logTag;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ExecutionPreference.values().length];
            try {
                ExecutionPreference executionPreference = ExecutionPreference.f6386a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ExecutionPreference executionPreference2 = ExecutionPreference.f6386a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ExecutionPreference executionPreference3 = ExecutionPreference.f6386a;
                iArr[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CloudNetworkStatus.values().length];
            try {
                iArr2[CloudNetworkStatus.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CloudNetworkStatus.POLICY_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CloudNetworkStatus.WIFI_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CloudNetworkStatus.WEAK_CELLULAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CloudNetworkStatus.AVAILABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public SpeechCloudOrchestrator(boolean z, boolean z3, String logTag, String capabilityLabel, zb.a<Boolean> isLoggedIn, zb.a<Boolean> isCtaGranted) {
        kotlin.jvm.internal.g.f(logTag, "logTag");
        kotlin.jvm.internal.g.f(capabilityLabel, "capabilityLabel");
        kotlin.jvm.internal.g.f(isLoggedIn, "isLoggedIn");
        kotlin.jvm.internal.g.f(isCtaGranted, "isCtaGranted");
        this.localAvailable = z;
        this.cloudAvailable = z3;
        this.logTag = logTag;
        this.capabilityLabel = capabilityLabel;
        this.isLoggedIn = isLoggedIn;
        this.isCtaGranted = isCtaGranted;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0() {
        return CTAPermissionManager.INSTANCE.hasCTAPermission();
    }

    private final h7.e autoFallback(String str, String str2) {
        if (this.localAvailable) {
            AIEngineLogger.i(LogModule.ABILITY, this.logTag, "Local: " + str2);
            return new e.c(str, 1);
        }
        AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject AUTO: " + str2 + ", local model disabled");
        return new e.d(h0.e.c("云端 ", this.capabilityLabel, " 网络不可用（", str, "），且端侧模型未启用"), AIEngineError.CLOUD_NETWORK_UNAVAILABLE);
    }

    private final h7.e ctaFallback() {
        if (this.localAvailable) {
            AIEngineLogger.i(LogModule.ABILITY, this.logTag, "Local: CTA not granted, fallback local (AUTO)");
            return new e.c(ai.onnxruntime.a.k("CTA 未授权，回退端侧 ", this.capabilityLabel), 1);
        }
        AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject AUTO: CTA not granted, local model disabled");
        return new e.d(a0.a.k("CTA 未授权，无法使用云端 ", this.capabilityLabel, "，且端侧模型未启用"), AIEngineError.CTA_NOT_GRANTED);
    }

    private final h7.e decideCloudOnly(h7.b bVar) {
        if (this.cloudAvailable) {
            if (this.isCtaGranted.invoke().booleanValue()) {
                return networkDecisionToCloudOnly(CloudNetworkEvaluator.INSTANCE.evaluate(bVar.f9364b));
            }
            AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject CLOUD_ONLY: CTA not granted");
            return new e.d(ai.onnxruntime.a.k("业务指定云端，但 CTA 未授权，无法使用云端 ", this.capabilityLabel), AIEngineError.CTA_NOT_GRANTED);
        }
        if (this.localAvailable) {
            AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject CLOUD_ONLY: cloud not enabled");
            return new e.d(ai.onnxruntime.a.k("业务指定云端，但未启用云端 ", this.capabilityLabel), AIEngineError.CLOUD_MODEL_DISABLED);
        }
        AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject CLOUD_ONLY: ability disabled (local & cloud off)");
        return new e.d(a0.a.k("能力已下线：端侧与云端 ", this.capabilityLabel, " 均未启用"), AIEngineError.ABILITY_DISABLED);
    }

    private final h7.e loginFallback() {
        if (this.localAvailable) {
            AIEngineLogger.i(LogModule.ABILITY, this.logTag, "Local: not logged in, fallback local (AUTO)");
            return new e.c(ai.onnxruntime.a.k("未登录，回退端侧 ", this.capabilityLabel), 1);
        }
        AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject AUTO: not logged in, local model disabled");
        return new e.d(a0.a.k("未登录，无法使用云端 ", this.capabilityLabel, "，且端侧模型未启用"), AIEngineError.CLOUD_AUTH_FAILED);
    }

    private final h7.e networkDecisionToAuto(CloudNetworkStatus cloudNetworkStatus) {
        int i10 = WhenMappings.$EnumSwitchMapping$1[cloudNetworkStatus.ordinal()];
        if (i10 == 1) {
            return autoFallback("无网络连接", "no network");
        }
        if (i10 == 2) {
            return autoFallback("离线策略", "offline-only policy");
        }
        if (i10 == 3) {
            return autoFallback("需要 WiFi，当前为蜂窝网络", "WiFi required but on cellular");
        }
        if (i10 == 4) {
            return autoFallback(ai.onnxruntime.a.k("弱网（2G/3G），使用端侧 ", this.capabilityLabel), "weak cellular (2G/3G)");
        }
        if (i10 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (!this.isLoggedIn.invoke().booleanValue()) {
            return loginFallback();
        }
        AIEngineLogger.i(LogModule.ABILITY, this.logTag, "Cloud: network available (AUTO)");
        return new e.a(ai.onnxruntime.a.k("网络可用，使用云端 ", this.capabilityLabel), 1);
    }

    private final h7.e networkDecisionToCloudOnly(CloudNetworkStatus cloudNetworkStatus) {
        int i10 = WhenMappings.$EnumSwitchMapping$1[cloudNetworkStatus.ordinal()];
        if (i10 == 1) {
            return new e.d("业务指定云端，但当前无网络", AIEngineError.CLOUD_NETWORK_UNAVAILABLE);
        }
        if (i10 == 2) {
            return new e.d("业务指定云端，但网络策略为仅离线", AIEngineError.CLOUD_NETWORK_UNAVAILABLE);
        }
        if (i10 == 3) {
            return new e.d("业务指定云端，但需要 WiFi（当前为蜂窝）", AIEngineError.CLOUD_NETWORK_UNAVAILABLE);
        }
        if (i10 == 4) {
            return new e.d("业务指定云端，但当前为弱网（2G/3G）", AIEngineError.CLOUD_NETWORK_UNAVAILABLE);
        }
        if (i10 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (this.isLoggedIn.invoke().booleanValue()) {
            AIEngineLogger.i(LogModule.ABILITY, this.logTag, "Cloud: business CLOUD_ONLY");
            return new e.a("业务指定云端", 1);
        }
        AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject CLOUD_ONLY: not logged in");
        return new e.d(ai.onnxruntime.a.k("业务指定云端，但未登录，无法使用云端 ", this.capabilityLabel), AIEngineError.CLOUD_AUTH_FAILED);
    }

    @Override // h7.d
    public <T> Object makeDecision(T t8, String str, h7.b bVar, qb.b<? super h7.e> bVar2) {
        int iOrdinal = bVar.f9365c.ordinal();
        if (iOrdinal == 0) {
            if (this.cloudAvailable) {
                return !this.isCtaGranted.invoke().booleanValue() ? ctaFallback() : networkDecisionToAuto(CloudNetworkEvaluator.INSTANCE.evaluate(bVar.f9364b));
            }
            if (this.localAvailable) {
                AIEngineLogger.i(LogModule.ABILITY, this.logTag, "Local: cloud not enabled");
                return new e.c(ai.onnxruntime.a.k("未启用云端 ", this.capabilityLabel), 1);
            }
            AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject AUTO: ability disabled (local & cloud off)");
            return new e.d(a0.a.k("能力已下线：端侧与云端 ", this.capabilityLabel, " 均未启用"), AIEngineError.ABILITY_DISABLED);
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return decideCloudOnly(bVar);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (this.localAvailable) {
            AIEngineLogger.i(LogModule.ABILITY, this.logTag, "Local: business LOCAL_ONLY");
            return new e.c("业务指定端侧", 1);
        }
        AIEngineLogger.w(LogModule.ABILITY, this.logTag, "Reject LOCAL_ONLY: local model disabled");
        return new e.d(ai.onnxruntime.a.k("业务指定端侧，但端侧模型未启用 ", this.capabilityLabel), AIEngineError.LOCAL_MODEL_DISABLED);
    }

    public /* synthetic */ SpeechCloudOrchestrator(boolean z, boolean z3, String str, String str2, zb.a aVar, zb.a aVar2, int i10, kotlin.jvm.internal.e eVar) {
        this(z, z3, str, str2, aVar, (i10 & 32) != 0 ? new b(3) : aVar2);
    }
}
