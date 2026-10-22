package com.stepos.core.common.runtime;

import android.content.Context;
import com.stepos.core.ability.speech.AsrCloudConfig;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import gc.a;
import gc.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import jd.b;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import org.json.JSONObject;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EngineRuntimeConfig {
    private static final String CONFIG_DIR = "config";
    private static final String KEY_MEMORY_RELEASE = "memoryRelease";
    private static final String KEY_MODEL_ENCRYPTION = "modelEncryption";
    public static final int MIN_ABSOLUTE_TARGET_MB = 800;
    public static final int MIN_RSS_TARGET_MB = 1000;
    private static final String RUNTIME_JSON = "engine_runtime.json";
    private static final String TAG = "EngineRuntimeConfig";
    public static final EngineRuntimeConfig INSTANCE = new EngineRuntimeConfig();
    private static volatile Snapshot snapshot = Snapshot.Companion.getDEFAULT();

    private EngineRuntimeConfig() {
    }

    private final String readAssets(Context context) {
        Object objA;
        try {
            InputStream inputStreamOpen = context.getAssets().open(RUNTIME_JSON);
            g.e(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                objA = b.F(bufferedReader);
                bufferedReader.close();
            } finally {
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            ai.onnxruntime.a.w("assets engine_runtime.json 缺失: ", thB.getMessage(), LogModule.CLOUDCONFIG, TAG);
            objA = null;
        }
        return (String) objA;
    }

    private final String readConfigDir(Context context) {
        Object objA;
        try {
            File file = new File(new File(context.getDataDir(), CONFIG_DIR), RUNTIME_JSON);
            if (!file.exists()) {
                file = null;
            }
            objA = file != null ? d.Z(file, a.f9106b) : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return (String) (objA instanceof Result.Failure ? null : objA);
    }

    public final void apply(byte[] bytes) {
        Object objA;
        g.f(bytes, "bytes");
        try {
            objA = parse(new String(bytes, a.f9106b));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            ai.onnxruntime.a.w("apply parse failed, keep current: ", thB.getMessage(), LogModule.CLOUDCONFIG, TAG);
            return;
        }
        Snapshot snapshot2 = (Snapshot) objA;
        snapshot = snapshot2;
        AIEngineLogger.i(LogModule.CLOUDCONFIG, TAG, "apply done: " + snapshot2);
    }

    public final String dump() {
        return "EngineRuntimeConfig: " + snapshot;
    }

    public final String effectiveJson$common_release(Context context) {
        g.f(context, "context");
        return pickJson(readConfigDir(context), readAssets(context));
    }

    public final Snapshot getSnapshot() {
        return snapshot;
    }

    public final void init(Context context) {
        Object objA;
        g.f(context, "context");
        try {
            objA = parse(effectiveJson$common_release(context));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            ai.onnxruntime.a.w("init parse failed, use DEFAULT: ", thB.getMessage(), LogModule.CLOUDCONFIG, TAG);
            objA = Snapshot.Companion.getDEFAULT();
        }
        snapshot = (Snapshot) objA;
        AIEngineLogger.i(LogModule.CLOUDCONFIG, TAG, "init done: " + snapshot);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.common.runtime.EngineRuntimeConfig.Snapshot parse(java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.runtime.EngineRuntimeConfig.parse(java.lang.String):com.stepos.core.common.runtime.EngineRuntimeConfig$Snapshot");
    }

    public final String pickJson(String str, String str2) {
        Object objA;
        Object objA2;
        if (str != null && !q.t0(str)) {
            try {
                objA2 = new JSONObject(str);
            } catch (Throwable th) {
                objA2 = c.a(th);
            }
            if (!(objA2 instanceof Result.Failure)) {
                return str;
            }
        }
        if (str2 == null || q.t0(str2)) {
            return "{}";
        }
        try {
            objA = new JSONObject(str2);
        } catch (Throwable th2) {
            objA = c.a(th2);
        }
        return !(objA instanceof Result.Failure) ? str2 : "{}";
    }

    public final boolean shouldEncryptModel(String modelId) {
        g.f(modelId, "modelId");
        return snapshot.getModelEncryptionEnabled() && !snapshot.getExcludeModelIds().contains(modelId);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Snapshot {
        public static final Companion Companion = new Companion(null);
        private static final Snapshot DEFAULT = new Snapshot(3000, AsrCloudConfig.MAX_SILENCE_MS, 2500, 1500, HysteresisStrategy.DEFAULT_DWELL_MS, 2000, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS, FileStorageUploader.LOG_HEARTBEAT_MS, HysteresisStrategy.DEFAULT_DWELL_MS, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, FileStorageUploader.LOG_HEARTBEAT_MS, false, null, 12288, null);
        private final int absoluteTargetLowMb;
        private final int absoluteTargetUltraLowMb;
        private final long cameraCooldownMs;
        private final long cameraResumeDelayMs;
        private final Set<String> excludeModelIds;
        private final long fgTaskWindowMs;
        private final boolean modelEncryptionEnabled;
        private final long pressureLowCooldownMs;
        private final long pressureNormalCooldownMs;
        private final long pressureUltraLowCooldownMs;
        private final int rssTargetBgOnlyMb;
        private final int rssTargetWithFgMb;
        private final long thermalRecoverCooldownMs;
        private final long ultraLowCancelWaitMs;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            public final Snapshot getDEFAULT() {
                return Snapshot.DEFAULT;
            }

            private Companion() {
            }
        }

        public Snapshot(int i10, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z, Set set, int i14, e eVar) {
            this(i10, i11, i12, i13, j10, j11, j12, j13, j14, j15, j16, j17, (i14 & 4096) != 0 ? false : z, (i14 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? EmptySet.f10003a : set);
        }

        public final int component1() {
            return this.rssTargetBgOnlyMb;
        }

        public final long component10() {
            return this.pressureNormalCooldownMs;
        }

        public final long component11() {
            return this.pressureLowCooldownMs;
        }

        public final long component12() {
            return this.pressureUltraLowCooldownMs;
        }

        public final boolean component13() {
            return this.modelEncryptionEnabled;
        }

        public final Set<String> component14() {
            return this.excludeModelIds;
        }

        public final int component2() {
            return this.rssTargetWithFgMb;
        }

        public final int component3() {
            return this.absoluteTargetLowMb;
        }

        public final int component4() {
            return this.absoluteTargetUltraLowMb;
        }

        public final long component5() {
            return this.fgTaskWindowMs;
        }

        public final long component6() {
            return this.ultraLowCancelWaitMs;
        }

        public final long component7() {
            return this.cameraCooldownMs;
        }

        public final long component8() {
            return this.cameraResumeDelayMs;
        }

        public final long component9() {
            return this.thermalRecoverCooldownMs;
        }

        public final Snapshot copy(int i10, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z, Set<String> excludeModelIds) {
            g.f(excludeModelIds, "excludeModelIds");
            return new Snapshot(i10, i11, i12, i13, j10, j11, j12, j13, j14, j15, j16, j17, z, excludeModelIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) obj;
            return this.rssTargetBgOnlyMb == snapshot.rssTargetBgOnlyMb && this.rssTargetWithFgMb == snapshot.rssTargetWithFgMb && this.absoluteTargetLowMb == snapshot.absoluteTargetLowMb && this.absoluteTargetUltraLowMb == snapshot.absoluteTargetUltraLowMb && this.fgTaskWindowMs == snapshot.fgTaskWindowMs && this.ultraLowCancelWaitMs == snapshot.ultraLowCancelWaitMs && this.cameraCooldownMs == snapshot.cameraCooldownMs && this.cameraResumeDelayMs == snapshot.cameraResumeDelayMs && this.thermalRecoverCooldownMs == snapshot.thermalRecoverCooldownMs && this.pressureNormalCooldownMs == snapshot.pressureNormalCooldownMs && this.pressureLowCooldownMs == snapshot.pressureLowCooldownMs && this.pressureUltraLowCooldownMs == snapshot.pressureUltraLowCooldownMs && this.modelEncryptionEnabled == snapshot.modelEncryptionEnabled && g.b(this.excludeModelIds, snapshot.excludeModelIds);
        }

        public final int getAbsoluteTargetLowMb() {
            return this.absoluteTargetLowMb;
        }

        public final int getAbsoluteTargetUltraLowMb() {
            return this.absoluteTargetUltraLowMb;
        }

        public final long getCameraCooldownMs() {
            return this.cameraCooldownMs;
        }

        public final long getCameraResumeDelayMs() {
            return this.cameraResumeDelayMs;
        }

        public final Set<String> getExcludeModelIds() {
            return this.excludeModelIds;
        }

        public final long getFgTaskWindowMs() {
            return this.fgTaskWindowMs;
        }

        public final boolean getModelEncryptionEnabled() {
            return this.modelEncryptionEnabled;
        }

        public final long getPressureLowCooldownMs() {
            return this.pressureLowCooldownMs;
        }

        public final long getPressureNormalCooldownMs() {
            return this.pressureNormalCooldownMs;
        }

        public final long getPressureUltraLowCooldownMs() {
            return this.pressureUltraLowCooldownMs;
        }

        public final int getRssTargetBgOnlyMb() {
            return this.rssTargetBgOnlyMb;
        }

        public final int getRssTargetWithFgMb() {
            return this.rssTargetWithFgMb;
        }

        public final long getThermalRecoverCooldownMs() {
            return this.thermalRecoverCooldownMs;
        }

        public final long getUltraLowCancelWaitMs() {
            return this.ultraLowCancelWaitMs;
        }

        public int hashCode() {
            return this.excludeModelIds.hashCode() + ai.onnxruntime.a.f(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.absoluteTargetUltraLowMb, ai.onnxruntime.a.d(this.absoluteTargetLowMb, ai.onnxruntime.a.d(this.rssTargetWithFgMb, Integer.hashCode(this.rssTargetBgOnlyMb) * 31, 31), 31), 31), this.fgTaskWindowMs, 31), this.ultraLowCancelWaitMs, 31), this.cameraCooldownMs, 31), this.cameraResumeDelayMs, 31), this.thermalRecoverCooldownMs, 31), this.pressureNormalCooldownMs, 31), this.pressureLowCooldownMs, 31), this.pressureUltraLowCooldownMs, 31), 31, this.modelEncryptionEnabled);
        }

        public String toString() {
            int i10 = this.rssTargetBgOnlyMb;
            int i11 = this.rssTargetWithFgMb;
            int i12 = this.absoluteTargetLowMb;
            int i13 = this.absoluteTargetUltraLowMb;
            long j10 = this.fgTaskWindowMs;
            long j11 = this.ultraLowCancelWaitMs;
            long j12 = this.cameraCooldownMs;
            long j13 = this.cameraResumeDelayMs;
            long j14 = this.thermalRecoverCooldownMs;
            long j15 = this.pressureNormalCooldownMs;
            long j16 = this.pressureLowCooldownMs;
            long j17 = this.pressureUltraLowCooldownMs;
            boolean z = this.modelEncryptionEnabled;
            Set<String> set = this.excludeModelIds;
            StringBuilder sbD = h0.e.d(i10, "Snapshot(rssTargetBgOnlyMb=", i11, ", rssTargetWithFgMb=", ", absoluteTargetLowMb=");
            h0.e.l(sbD, i12, ", absoluteTargetUltraLowMb=", i13, ", fgTaskWindowMs=");
            sbD.append(j10);
            a0.a.s(j11, ", ultraLowCancelWaitMs=", ", cameraCooldownMs=", sbD);
            sbD.append(j12);
            a0.a.s(j13, ", cameraResumeDelayMs=", ", thermalRecoverCooldownMs=", sbD);
            sbD.append(j14);
            a0.a.s(j15, ", pressureNormalCooldownMs=", ", pressureLowCooldownMs=", sbD);
            sbD.append(j16);
            a0.a.s(j17, ", pressureUltraLowCooldownMs=", ", modelEncryptionEnabled=", sbD);
            sbD.append(z);
            sbD.append(", excludeModelIds=");
            sbD.append(set);
            sbD.append(")");
            return sbD.toString();
        }

        public Snapshot(int i10, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z, Set<String> excludeModelIds) {
            g.f(excludeModelIds, "excludeModelIds");
            this.rssTargetBgOnlyMb = i10;
            this.rssTargetWithFgMb = i11;
            this.absoluteTargetLowMb = i12;
            this.absoluteTargetUltraLowMb = i13;
            this.fgTaskWindowMs = j10;
            this.ultraLowCancelWaitMs = j11;
            this.cameraCooldownMs = j12;
            this.cameraResumeDelayMs = j13;
            this.thermalRecoverCooldownMs = j14;
            this.pressureNormalCooldownMs = j15;
            this.pressureLowCooldownMs = j16;
            this.pressureUltraLowCooldownMs = j17;
            this.modelEncryptionEnabled = z;
            this.excludeModelIds = excludeModelIds;
        }
    }
}
