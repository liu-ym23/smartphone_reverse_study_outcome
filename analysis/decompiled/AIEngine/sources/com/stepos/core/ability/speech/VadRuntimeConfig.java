package com.stepos.core.ability.speech;

import android.os.Bundle;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.common.util.VadParamKeys;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptySet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadRuntimeConfig {
    public static final String CAUSE_ABOVE_MAX = "above_max";
    public static final String CAUSE_BELOW_MIN = "below_min";
    public static final String CAUSE_TYPE_MISMATCH = "type_mismatch";
    public static final String CAUSE_ZERO_OR_TYPE_MISMATCH = "zero_or_type_mismatch";
    public static final Companion Companion = new Companion(null);
    public static final String LEGAL_BOOL = "bool";
    public static final String ORIGIN_OVERRIDE = "override";
    public static final String ORIGIN_REJECTED = "client_rejected";
    private final int leadingSilenceTimeoutMs;
    private final boolean levelEnabled;
    private final int levelIntervalMs;
    private final boolean maxDurationClamped;
    private final int maxDurationMs;
    private final float minSpeechRms;
    private final Set<String> overriddenKeys;
    private final Map<String, Reject> rejections;
    private final int requestedMaxDurationMs;
    private final int silenceDurationMs;
    private final int silenceFrames;
    private final int speechStartFrames;
    private final int speechStartMs;
    private final float threshold;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final String causeOf(boolean z, boolean z3) {
            return z ? VadRuntimeConfig.CAUSE_ZERO_OR_TYPE_MISMATCH : z3 ? VadRuntimeConfig.CAUSE_ABOVE_MAX : VadRuntimeConfig.CAUSE_BELOW_MIN;
        }

        private static final Boolean resolve$readBoolean(Bundle bundle, Map<String, Reject> map, Set<String> set, String str) {
            if (bundle == null || !bundle.containsKey(str)) {
                return null;
            }
            Object obj = bundle.get(str);
            if (obj instanceof Boolean) {
                set.add(str);
                return (Boolean) obj;
            }
            map.put(str, new Reject(VadRuntimeConfig.Companion.typeNameOf(obj), VadRuntimeConfig.LEGAL_BOOL, VadRuntimeConfig.CAUSE_TYPE_MISMATCH));
            return null;
        }

        private static final Float resolve$readFloat(Bundle bundle, Map<String, Reject> map, Set<String> set, String str, float f8, float f9) {
            float fDoubleValue;
            if (bundle != null) {
                if (bundle.containsKey(str)) {
                    Object obj = bundle.get(str);
                    if (obj instanceof Float) {
                        fDoubleValue = ((Number) obj).floatValue();
                    } else if (obj instanceof Double) {
                        fDoubleValue = (float) ((Number) obj).doubleValue();
                    } else {
                        map.put(str, new Reject(VadRuntimeConfig.Companion.typeNameOf(obj), "[" + f8 + "," + f9 + "]", VadRuntimeConfig.CAUSE_TYPE_MISMATCH));
                    }
                    if (f8 <= fDoubleValue && fDoubleValue <= f9) {
                        set.add(str);
                        return Float.valueOf(fDoubleValue);
                    }
                    map.put(str, new Reject(String.valueOf(fDoubleValue), "[" + f8 + "," + f9 + "]", VadRuntimeConfig.Companion.causeOf(fDoubleValue == 0.0f, fDoubleValue > f9)));
                    return null;
                }
            }
            return null;
        }

        private static final Integer resolve$readInt(Bundle bundle, Map<String, Reject> map, Set<String> set, String str, int i10, int i11) {
            if (bundle != null) {
                if (bundle.containsKey(str)) {
                    Object obj = bundle.get(str);
                    if (!(obj instanceof Integer)) {
                        map.put(str, new Reject(VadRuntimeConfig.Companion.typeNameOf(obj), com.stepos.core.ota.d.e(i10, "[", i11, ",", "]"), VadRuntimeConfig.CAUSE_TYPE_MISMATCH));
                        return null;
                    }
                    Number number = (Number) obj;
                    int iIntValue = number.intValue();
                    if (i10 <= iIntValue && iIntValue <= i11) {
                        set.add(str);
                        return (Integer) obj;
                    }
                    map.put(str, new Reject(String.valueOf(number.intValue()), com.stepos.core.ota.d.e(i10, "[", i11, ",", "]"), VadRuntimeConfig.Companion.causeOf(obj.equals(0), number.intValue() > i11)));
                }
            }
            return null;
        }

        private final String typeNameOf(Object obj) {
            return obj != null ? obj.getClass().getSimpleName() : "null";
        }

        public final long executionBudgetMs(p6.j jVar, Bundle bundle, long j10) {
            Integer num;
            int maxDurationMs = resolve(jVar, bundle).getMaxDurationMs();
            if (jVar != null) {
                int i10 = jVar.f11453f;
                Iterator<T> it = jVar.f11456j.values().iterator();
                if (it.hasNext()) {
                    Integer numValueOf = Integer.valueOf(((p6.j) it.next()).f11453f);
                    while (it.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(((p6.j) it.next()).f11453f);
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    num = numValueOf;
                } else {
                    num = null;
                }
                iMax = Math.max(i10, num != null ? num.intValue() : 0);
            }
            return Math.max((Math.max(maxDurationMs, iMax) * 3) / 2, j10);
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public final com.stepos.core.ability.speech.VadRuntimeConfig resolve(p6.j r24, android.os.Bundle r25) {
            /*
                Method dump skipped, instructions count: 380
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadRuntimeConfig.Companion.resolve(p6.j, android.os.Bundle):com.stepos.core.ability.speech.VadRuntimeConfig");
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Reject {
        private final String cause;
        private final String legal;
        private final String recv;

        public Reject(String recv, String legal, String cause) {
            kotlin.jvm.internal.g.f(recv, "recv");
            kotlin.jvm.internal.g.f(legal, "legal");
            kotlin.jvm.internal.g.f(cause, "cause");
            this.recv = recv;
            this.legal = legal;
            this.cause = cause;
        }

        public static /* synthetic */ Reject copy$default(Reject reject, String str, String str2, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = reject.recv;
            }
            if ((i10 & 2) != 0) {
                str2 = reject.legal;
            }
            if ((i10 & 4) != 0) {
                str3 = reject.cause;
            }
            return reject.copy(str, str2, str3);
        }

        public final String component1() {
            return this.recv;
        }

        public final String component2() {
            return this.legal;
        }

        public final String component3() {
            return this.cause;
        }

        public final Reject copy(String recv, String legal, String cause) {
            kotlin.jvm.internal.g.f(recv, "recv");
            kotlin.jvm.internal.g.f(legal, "legal");
            kotlin.jvm.internal.g.f(cause, "cause");
            return new Reject(recv, legal, cause);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Reject)) {
                return false;
            }
            Reject reject = (Reject) obj;
            return kotlin.jvm.internal.g.b(this.recv, reject.recv) && kotlin.jvm.internal.g.b(this.legal, reject.legal) && kotlin.jvm.internal.g.b(this.cause, reject.cause);
        }

        public final String getCause() {
            return this.cause;
        }

        public final String getLegal() {
            return this.legal;
        }

        public final String getRecv() {
            return this.recv;
        }

        public int hashCode() {
            return this.cause.hashCode() + v1.d.a(this.recv.hashCode() * 31, 31, this.legal);
        }

        public String toString() {
            String str = this.recv;
            String str2 = this.legal;
            return ai.onnxruntime.a.o(ai.onnxruntime.a.s("Reject(recv=", str, ", legal=", str2, ", cause="), this.cause, ")");
        }
    }

    public VadRuntimeConfig(float f8, float f9, int i10, int i11, int i12, int i13, int i14, int i15, boolean z, int i16, boolean z3, int i17, Set<String> overriddenKeys, Map<String, Reject> rejections) {
        kotlin.jvm.internal.g.f(overriddenKeys, "overriddenKeys");
        kotlin.jvm.internal.g.f(rejections, "rejections");
        this.threshold = f8;
        this.minSpeechRms = f9;
        this.speechStartFrames = i10;
        this.speechStartMs = i11;
        this.silenceFrames = i12;
        this.silenceDurationMs = i13;
        this.leadingSilenceTimeoutMs = i14;
        this.maxDurationMs = i15;
        this.levelEnabled = z;
        this.levelIntervalMs = i16;
        this.maxDurationClamped = z3;
        this.requestedMaxDurationMs = i17;
        this.overriddenKeys = overriddenKeys;
        this.rejections = rejections;
    }

    public static /* synthetic */ VadRuntimeConfig copy$default(VadRuntimeConfig vadRuntimeConfig, float f8, float f9, int i10, int i11, int i12, int i13, int i14, int i15, boolean z, int i16, boolean z3, int i17, Set set, Map map, int i18, Object obj) {
        return vadRuntimeConfig.copy((i18 & 1) != 0 ? vadRuntimeConfig.threshold : f8, (i18 & 2) != 0 ? vadRuntimeConfig.minSpeechRms : f9, (i18 & 4) != 0 ? vadRuntimeConfig.speechStartFrames : i10, (i18 & 8) != 0 ? vadRuntimeConfig.speechStartMs : i11, (i18 & 16) != 0 ? vadRuntimeConfig.silenceFrames : i12, (i18 & 32) != 0 ? vadRuntimeConfig.silenceDurationMs : i13, (i18 & 64) != 0 ? vadRuntimeConfig.leadingSilenceTimeoutMs : i14, (i18 & TraceIdKeys.MAX_LENGTH) != 0 ? vadRuntimeConfig.maxDurationMs : i15, (i18 & 256) != 0 ? vadRuntimeConfig.levelEnabled : z, (i18 & VadSessionManager.FRAME_BYTES) != 0 ? vadRuntimeConfig.levelIntervalMs : i16, (i18 & 1024) != 0 ? vadRuntimeConfig.maxDurationClamped : z3, (i18 & 2048) != 0 ? vadRuntimeConfig.requestedMaxDurationMs : i17, (i18 & 4096) != 0 ? vadRuntimeConfig.overriddenKeys : set, (i18 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? vadRuntimeConfig.rejections : map);
    }

    private final String effectiveOf(String str) {
        switch (str.hashCode()) {
            case -1927382210:
                return !str.equals(VadParamKeys.SILENCE_DURATION_MS) ? "?" : String.valueOf(this.silenceDurationMs);
            case -1927367722:
                return !str.equals(VadParamKeys.THRESHOLD) ? "?" : String.valueOf(this.threshold);
            case -1246843647:
                return !str.equals(VadParamKeys.MAX_DURATION_MS) ? "?" : String.valueOf(this.maxDurationMs);
            case -1168102543:
                return !str.equals(VadParamKeys.LEVEL_ENABLED) ? "?" : String.valueOf(this.levelEnabled);
            case -907406197:
                return !str.equals(VadParamKeys.SPEECH_START_MS) ? "?" : String.valueOf(this.speechStartMs);
            case -905013904:
                return !str.equals(VadParamKeys.LEADING_SILENCE_TIMEOUT_MS) ? "?" : String.valueOf(this.leadingSilenceTimeoutMs);
            case -716856432:
                return !str.equals(VadParamKeys.LEVEL_INTERVAL_MS) ? "?" : String.valueOf(this.levelIntervalMs);
            case 550745149:
                return !str.equals(VadParamKeys.MIN_SPEECH_RMS) ? "?" : String.valueOf(this.minSpeechRms);
            default:
                return "?";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence rejectionLog$lambda$2(VadRuntimeConfig vadRuntimeConfig, Map.Entry entry) {
        kotlin.jvm.internal.g.f(entry, "<destruct>");
        String str = (String) entry.getKey();
        Reject reject = (Reject) entry.getValue();
        String recv = reject.getRecv();
        String legal = reject.getLegal();
        String cause = reject.getCause();
        String strEffectiveOf = vadRuntimeConfig.effectiveOf(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" recv=");
        sb2.append(recv);
        sb2.append(" legal=");
        sb2.append(legal);
        return com.stepos.core.ota.d.j(sb2, " cause=", cause, " effective=", strEffectiveOf);
    }

    public final float component1() {
        return this.threshold;
    }

    public final int component10() {
        return this.levelIntervalMs;
    }

    public final boolean component11() {
        return this.maxDurationClamped;
    }

    public final int component12() {
        return this.requestedMaxDurationMs;
    }

    public final Set<String> component13() {
        return this.overriddenKeys;
    }

    public final Map<String, Reject> component14() {
        return this.rejections;
    }

    public final float component2() {
        return this.minSpeechRms;
    }

    public final int component3() {
        return this.speechStartFrames;
    }

    public final int component4() {
        return this.speechStartMs;
    }

    public final int component5() {
        return this.silenceFrames;
    }

    public final int component6() {
        return this.silenceDurationMs;
    }

    public final int component7() {
        return this.leadingSilenceTimeoutMs;
    }

    public final int component8() {
        return this.maxDurationMs;
    }

    public final boolean component9() {
        return this.levelEnabled;
    }

    public final VadRuntimeConfig copy(float f8, float f9, int i10, int i11, int i12, int i13, int i14, int i15, boolean z, int i16, boolean z3, int i17, Set<String> overriddenKeys, Map<String, Reject> rejections) {
        kotlin.jvm.internal.g.f(overriddenKeys, "overriddenKeys");
        kotlin.jvm.internal.g.f(rejections, "rejections");
        return new VadRuntimeConfig(f8, f9, i10, i11, i12, i13, i14, i15, z, i16, z3, i17, overriddenKeys, rejections);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VadRuntimeConfig)) {
            return false;
        }
        VadRuntimeConfig vadRuntimeConfig = (VadRuntimeConfig) obj;
        return Float.compare(this.threshold, vadRuntimeConfig.threshold) == 0 && Float.compare(this.minSpeechRms, vadRuntimeConfig.minSpeechRms) == 0 && this.speechStartFrames == vadRuntimeConfig.speechStartFrames && this.speechStartMs == vadRuntimeConfig.speechStartMs && this.silenceFrames == vadRuntimeConfig.silenceFrames && this.silenceDurationMs == vadRuntimeConfig.silenceDurationMs && this.leadingSilenceTimeoutMs == vadRuntimeConfig.leadingSilenceTimeoutMs && this.maxDurationMs == vadRuntimeConfig.maxDurationMs && this.levelEnabled == vadRuntimeConfig.levelEnabled && this.levelIntervalMs == vadRuntimeConfig.levelIntervalMs && this.maxDurationClamped == vadRuntimeConfig.maxDurationClamped && this.requestedMaxDurationMs == vadRuntimeConfig.requestedMaxDurationMs && kotlin.jvm.internal.g.b(this.overriddenKeys, vadRuntimeConfig.overriddenKeys) && kotlin.jvm.internal.g.b(this.rejections, vadRuntimeConfig.rejections);
    }

    public final Set<String> getClientKeys() {
        return mb.x.W(this.overriddenKeys, this.rejections.keySet());
    }

    public final int getLeadingSilenceTimeoutMs() {
        return this.leadingSilenceTimeoutMs;
    }

    public final boolean getLevelEnabled() {
        return this.levelEnabled;
    }

    public final int getLevelIntervalMs() {
        return this.levelIntervalMs;
    }

    public final boolean getMaxDurationClamped() {
        return this.maxDurationClamped;
    }

    public final int getMaxDurationMs() {
        return this.maxDurationMs;
    }

    public final float getMinSpeechRms() {
        return this.minSpeechRms;
    }

    public final Set<String> getOverriddenKeys() {
        return this.overriddenKeys;
    }

    public final Map<String, Reject> getRejections() {
        return this.rejections;
    }

    public final int getRequestedMaxDurationMs() {
        return this.requestedMaxDurationMs;
    }

    public final int getSilenceDurationMs() {
        return this.silenceDurationMs;
    }

    public final int getSilenceFrames() {
        return this.silenceFrames;
    }

    public final int getSpeechStartFrames() {
        return this.speechStartFrames;
    }

    public final int getSpeechStartMs() {
        return this.speechStartMs;
    }

    public final float getThreshold() {
        return this.threshold;
    }

    public int hashCode() {
        return this.rejections.hashCode() + ((this.overriddenKeys.hashCode() + ai.onnxruntime.a.d(this.requestedMaxDurationMs, ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.levelIntervalMs, ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.maxDurationMs, ai.onnxruntime.a.d(this.leadingSilenceTimeoutMs, ai.onnxruntime.a.d(this.silenceDurationMs, ai.onnxruntime.a.d(this.silenceFrames, ai.onnxruntime.a.d(this.speechStartMs, ai.onnxruntime.a.d(this.speechStartFrames, a0.a.a(this.minSpeechRms, Float.hashCode(this.threshold) * 31, 31), 31), 31), 31), 31), 31), 31), 31, this.levelEnabled), 31), 31, this.maxDurationClamped), 31)) * 31);
    }

    public final String judgeParamsLog() {
        float f8 = this.threshold;
        String strOriginTag = originTag(VadParamKeys.THRESHOLD);
        float f9 = this.minSpeechRms;
        String strOriginTag2 = originTag(VadParamKeys.MIN_SPEECH_RMS);
        int i10 = this.speechStartFrames;
        int i11 = this.speechStartMs;
        String strOriginInline = originInline(VadParamKeys.SPEECH_START_MS);
        int i12 = this.silenceFrames;
        int i13 = this.silenceDurationMs;
        String strOriginInline2 = originInline(VadParamKeys.SILENCE_DURATION_MS);
        int i14 = this.leadingSilenceTimeoutMs;
        String strOriginTag3 = originTag(VadParamKeys.LEADING_SILENCE_TIMEOUT_MS);
        StringBuilder sb2 = new StringBuilder("threshold=");
        sb2.append(f8);
        sb2.append(strOriginTag);
        sb2.append(" minSpeechRms=");
        sb2.append(f9);
        com.stepos.core.ota.d.o(i10, strOriginTag2, " startFrames=", "(", sb2);
        h0.e.h(i11, "ms", strOriginInline, ") silenceFrames=", sb2);
        h0.e.l(sb2, i12, "(", i13, "ms");
        sb2.append(strOriginInline2);
        sb2.append(") leadingTimeoutMs=");
        sb2.append(i14);
        sb2.append(strOriginTag3);
        return sb2.toString();
    }

    public final String originInline(String key) {
        kotlin.jvm.internal.g.f(key, "key");
        String strOriginOf = originOf(key);
        return strOriginOf.length() == 0 ? "" : ai.onnxruntime.a.k(",", strOriginOf);
    }

    public final String originOf(String key) {
        kotlin.jvm.internal.g.f(key, "key");
        return this.rejections.containsKey(key) ? ORIGIN_REJECTED : !this.overriddenKeys.contains(key) ? "" : (key.equals(VadParamKeys.MAX_DURATION_MS) && this.maxDurationClamped) ? "override,clamped" : ORIGIN_OVERRIDE;
    }

    public final String originTag(String key) {
        kotlin.jvm.internal.g.f(key, "key");
        String strOriginOf = originOf(key);
        return strOriginOf.length() == 0 ? "" : a0.a.k("(", strOriginOf, ")");
    }

    public final String rejectionLog() {
        return kotlin.collections.a.z0(this.rejections.entrySet(), "; ", null, null, new s(this, 5), 30);
    }

    public String toString() {
        float f8 = this.threshold;
        float f9 = this.minSpeechRms;
        int i10 = this.speechStartFrames;
        int i11 = this.speechStartMs;
        int i12 = this.silenceFrames;
        int i13 = this.silenceDurationMs;
        int i14 = this.leadingSilenceTimeoutMs;
        int i15 = this.maxDurationMs;
        boolean z = this.levelEnabled;
        int i16 = this.levelIntervalMs;
        boolean z3 = this.maxDurationClamped;
        int i17 = this.requestedMaxDurationMs;
        Set<String> set = this.overriddenKeys;
        Map<String, Reject> map = this.rejections;
        StringBuilder sb2 = new StringBuilder("VadRuntimeConfig(threshold=");
        sb2.append(f8);
        sb2.append(", minSpeechRms=");
        sb2.append(f9);
        sb2.append(", speechStartFrames=");
        h0.e.l(sb2, i10, ", speechStartMs=", i11, ", silenceFrames=");
        h0.e.l(sb2, i12, ", silenceDurationMs=", i13, ", leadingSilenceTimeoutMs=");
        h0.e.l(sb2, i14, ", maxDurationMs=", i15, ", levelEnabled=");
        sb2.append(z);
        sb2.append(", levelIntervalMs=");
        sb2.append(i16);
        sb2.append(", maxDurationClamped=");
        sb2.append(z3);
        sb2.append(", requestedMaxDurationMs=");
        sb2.append(i17);
        sb2.append(", overriddenKeys=");
        sb2.append(set);
        sb2.append(", rejections=");
        sb2.append(map);
        sb2.append(")");
        return sb2.toString();
    }

    public final VadRuntimeConfig withMaxDurationFrom(int i10) {
        Set<String> set = this.overriddenKeys;
        kotlin.jvm.internal.g.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(mb.v.a0(set.size()));
        boolean z = false;
        for (Object obj : set) {
            boolean z3 = true;
            if (!z && kotlin.jvm.internal.g.b(obj, VadParamKeys.MAX_DURATION_MS)) {
                z = true;
                z3 = false;
            }
            if (z3) {
                linkedHashSet.add(obj);
            }
        }
        return copy$default(this, 0.0f, 0.0f, 0, 0, 0, 0, 0, i10, false, 0, false, 0, linkedHashSet, kotlin.collections.b.h0(VadParamKeys.MAX_DURATION_MS, this.rejections), 895, null);
    }

    public VadRuntimeConfig(float f8, float f9, int i10, int i11, int i12, int i13, int i14, int i15, boolean z, int i16, boolean z3, int i17, Set set, Map map, int i18, kotlin.jvm.internal.e eVar) {
        this(f8, f9, i10, i11, i12, i13, i14, i15, z, i16, (i18 & 1024) != 0 ? false : z3, (i18 & 2048) != 0 ? 0 : i17, (i18 & 4096) != 0 ? EmptySet.f10003a : set, (i18 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? kotlin.collections.b.d0() : map);
    }
}
