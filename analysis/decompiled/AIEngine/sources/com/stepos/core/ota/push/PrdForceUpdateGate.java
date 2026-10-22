package com.stepos.core.ota.push;

import android.content.Context;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.push.AutoUpdatePushLogic;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrdForceUpdateGate {
    public static final PrdForceUpdateGate INSTANCE = new PrdForceUpdateGate();

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

    private PrdForceUpdateGate() {
    }

    public final List<AutoUpdatePushLogic.Check> diagnose(Context ctx) {
        g.f(ctx, "ctx");
        AutoUpdatePushLogic autoUpdatePushLogic = AutoUpdatePushLogic.INSTANCE;
        boolean zIsModelOtaAllowed = CTAPermissionManager.INSTANCE.isModelOtaAllowed();
        AutoUpdateEnv autoUpdateEnv = AutoUpdateEnv.INSTANCE;
        return autoUpdatePushLogic.forceChecks(new AutoUpdatePushLogic.ForceEnv(zIsModelOtaAllowed, autoUpdateEnv.isWifiValidated(ctx), autoUpdateEnv.freeBytes(ctx), AutoUpdateEnv.MIN_FREE_BYTES));
    }

    public final Result evaluate(Context ctx) {
        g.f(ctx, "ctx");
        List<AutoUpdatePushLogic.Check> listDiagnose = diagnose(ctx);
        AutoUpdatePushLogic autoUpdatePushLogic = AutoUpdatePushLogic.INSTANCE;
        return new Result(autoUpdatePushLogic.allPass(listDiagnose), autoUpdatePushLogic.failedNames(listDiagnose));
    }
}
