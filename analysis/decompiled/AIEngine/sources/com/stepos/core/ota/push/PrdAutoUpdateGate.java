package com.stepos.core.ota.push;

import android.content.Context;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.push.AutoUpdatePushLogic;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrdAutoUpdateGate {
    public static final PrdAutoUpdateGate INSTANCE = new PrdAutoUpdateGate();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Result {
        private final boolean allowed;
        private final List<String> fails;

        public Result(boolean z, List<String> fails) {
            g.f(fails, "fails");
            this.allowed = z;
            this.fails = fails;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, boolean z, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z = result.allowed;
            }
            if ((i10 & 2) != 0) {
                list = result.fails;
            }
            return result.copy(z, list);
        }

        public final boolean component1() {
            return this.allowed;
        }

        public final List<String> component2() {
            return this.fails;
        }

        public final Result copy(boolean z, List<String> fails) {
            g.f(fails, "fails");
            return new Result(z, fails);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return this.allowed == result.allowed && g.b(this.fails, result.fails);
        }

        public final boolean getAllowed() {
            return this.allowed;
        }

        public final List<String> getFails() {
            return this.fails;
        }

        public int hashCode() {
            return this.fails.hashCode() + (Boolean.hashCode(this.allowed) * 31);
        }

        public final String toLogString() {
            return this.allowed ? "PASS" : a0.a.k("FAIL[", kotlin.collections.a.z0(this.fails, ",", null, null, null, 62), "]");
        }

        public String toString() {
            return "Result(allowed=" + this.allowed + ", fails=" + this.fails + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SessionState {
        private final long candidateBytes;
        private final long unchargedBytesSoFar;
        private final long unchargedElapsedMs;

        public SessionState(long j10, long j11, long j12) {
            this.candidateBytes = j10;
            this.unchargedBytesSoFar = j11;
            this.unchargedElapsedMs = j12;
        }

        public static /* synthetic */ SessionState copy$default(SessionState sessionState, long j10, long j11, long j12, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = sessionState.candidateBytes;
            }
            long j13 = j10;
            if ((i10 & 2) != 0) {
                j11 = sessionState.unchargedBytesSoFar;
            }
            long j14 = j11;
            if ((i10 & 4) != 0) {
                j12 = sessionState.unchargedElapsedMs;
            }
            return sessionState.copy(j13, j14, j12);
        }

        public final long component1() {
            return this.candidateBytes;
        }

        public final long component2() {
            return this.unchargedBytesSoFar;
        }

        public final long component3() {
            return this.unchargedElapsedMs;
        }

        public final SessionState copy(long j10, long j11, long j12) {
            return new SessionState(j10, j11, j12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionState)) {
                return false;
            }
            SessionState sessionState = (SessionState) obj;
            return this.candidateBytes == sessionState.candidateBytes && this.unchargedBytesSoFar == sessionState.unchargedBytesSoFar && this.unchargedElapsedMs == sessionState.unchargedElapsedMs;
        }

        public final long getCandidateBytes() {
            return this.candidateBytes;
        }

        public final long getUnchargedBytesSoFar() {
            return this.unchargedBytesSoFar;
        }

        public final long getUnchargedElapsedMs() {
            return this.unchargedElapsedMs;
        }

        public int hashCode() {
            return Long.hashCode(this.unchargedElapsedMs) + a0.a.c(Long.hashCode(this.candidateBytes) * 31, this.unchargedBytesSoFar, 31);
        }

        public String toString() {
            long j10 = this.candidateBytes;
            long j11 = this.unchargedBytesSoFar;
            long j12 = this.unchargedElapsedMs;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "SessionState(candidateBytes=", ", unchargedBytesSoFar=");
            sbQ.append(j11);
            return a0.a.d(j12, ", unchargedElapsedMs=", ")", sbQ);
        }
    }

    private PrdAutoUpdateGate() {
    }

    public static /* synthetic */ List diagnose$default(PrdAutoUpdateGate prdAutoUpdateGate, Context context, SessionState sessionState, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return prdAutoUpdateGate.diagnose(context, sessionState, z);
    }

    public static /* synthetic */ Result evaluate$default(PrdAutoUpdateGate prdAutoUpdateGate, Context context, SessionState sessionState, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return prdAutoUpdateGate.evaluate(context, sessionState, z);
    }

    private final AutoUpdatePushLogic.SilentEnv gatherEnv(Context context, SessionState sessionState, boolean z) {
        boolean z3 = z || CTAPermissionManager.INSTANCE.isWlanAutoUpgradeEnabled();
        CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
        boolean z10 = z3;
        boolean zIsModelOtaAllowed = cTAPermissionManager.isModelOtaAllowed();
        boolean zIsCtaFirmwareMode = cTAPermissionManager.isCtaFirmwareMode();
        AutoUpdateEnv autoUpdateEnv = AutoUpdateEnv.INSTANCE;
        boolean zIsWifiValidated = autoUpdateEnv.isWifiValidated(context);
        boolean zIsCharging = autoUpdateEnv.isCharging(context);
        int iBatteryPct = autoUpdateEnv.batteryPct(context);
        boolean zIsScreenOff = autoUpdateEnv.isScreenOff(context);
        long jFreeBytes = autoUpdateEnv.freeBytes(context);
        long candidateBytes = sessionState.getCandidateBytes();
        long unchargedBytesSoFar = sessionState.getUnchargedBytesSoFar();
        long unchargedElapsedMs = sessionState.getUnchargedElapsedMs();
        AutoUpdateTunables autoUpdateTunables = AutoUpdateTunables.INSTANCE;
        return new AutoUpdatePushLogic.SilentEnv(z10, zIsModelOtaAllowed, zIsCtaFirmwareMode, zIsWifiValidated, zIsCharging, iBatteryPct, zIsScreenOff, jFreeBytes, AutoUpdateEnv.MIN_FREE_BYTES, candidateBytes, unchargedBytesSoFar, unchargedElapsedMs, autoUpdateTunables.getMaxUnchargedSessionBytes(), autoUpdateTunables.getMaxUnchargedSessionMs());
    }

    public final List<AutoUpdatePushLogic.Check> diagnose(Context ctx, SessionState session, boolean z) {
        g.f(ctx, "ctx");
        g.f(session, "session");
        return AutoUpdatePushLogic.INSTANCE.silentChecks(gatherEnv(ctx, session, z));
    }

    public final Result evaluate(Context ctx, SessionState session, boolean z) {
        g.f(ctx, "ctx");
        g.f(session, "session");
        List<AutoUpdatePushLogic.Check> listDiagnose = diagnose(ctx, session, z);
        AutoUpdatePushLogic autoUpdatePushLogic = AutoUpdatePushLogic.INSTANCE;
        return new Result(autoUpdatePushLogic.allPass(listDiagnose), autoUpdatePushLogic.failedNames(listDiagnose));
    }
}
