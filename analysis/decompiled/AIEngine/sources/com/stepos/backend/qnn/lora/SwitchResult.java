package com.stepos.backend.qnn.lora;

import com.stepos.core.ota.d;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class SwitchResult {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Error extends SwitchResult {
        private final String cause;
        private final String loraId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String loraId, String cause) {
            super(null);
            g.f(loraId, "loraId");
            g.f(cause, "cause");
            this.loraId = loraId;
            this.cause = cause;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = error.loraId;
            }
            if ((i10 & 2) != 0) {
                str2 = error.cause;
            }
            return error.copy(str, str2);
        }

        public final String component1() {
            return this.loraId;
        }

        public final String component2() {
            return this.cause;
        }

        public final Error copy(String loraId, String cause) {
            g.f(loraId, "loraId");
            g.f(cause, "cause");
            return new Error(loraId, cause);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return g.b(this.loraId, error.loraId) && g.b(this.cause, error.cause);
        }

        public final String getCause() {
            return this.cause;
        }

        public final String getLoraId() {
            return this.loraId;
        }

        public int hashCode() {
            return this.cause.hashCode() + (this.loraId.hashCode() * 31);
        }

        public String toString() {
            return e.c("Error(loraId=", this.loraId, ", cause=", this.cause, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Reset extends SwitchResult {
        private final long costMs;
        private final String loraId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reset(String loraId, long j10) {
            super(null);
            g.f(loraId, "loraId");
            this.loraId = loraId;
            this.costMs = j10;
        }

        public static /* synthetic */ Reset copy$default(Reset reset, String str, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = reset.loraId;
            }
            if ((i10 & 2) != 0) {
                j10 = reset.costMs;
            }
            return reset.copy(str, j10);
        }

        public final String component1() {
            return this.loraId;
        }

        public final long component2() {
            return this.costMs;
        }

        public final Reset copy(String loraId, long j10) {
            g.f(loraId, "loraId");
            return new Reset(loraId, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Reset)) {
                return false;
            }
            Reset reset = (Reset) obj;
            return g.b(this.loraId, reset.loraId) && this.costMs == reset.costMs;
        }

        public final long getCostMs() {
            return this.costMs;
        }

        public final String getLoraId() {
            return this.loraId;
        }

        public int hashCode() {
            return Long.hashCode(this.costMs) + (this.loraId.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbL = d.l("Reset(loraId=", this.costMs, this.loraId, ", costMs=");
            sbL.append(")");
            return sbL.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Success extends SwitchResult {
        private final long costMs;
        private final String loraId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String loraId, long j10) {
            super(null);
            g.f(loraId, "loraId");
            this.loraId = loraId;
            this.costMs = j10;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = success.loraId;
            }
            if ((i10 & 2) != 0) {
                j10 = success.costMs;
            }
            return success.copy(str, j10);
        }

        public final String component1() {
            return this.loraId;
        }

        public final long component2() {
            return this.costMs;
        }

        public final Success copy(String loraId, long j10) {
            g.f(loraId, "loraId");
            return new Success(loraId, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return g.b(this.loraId, success.loraId) && this.costMs == success.costMs;
        }

        public final long getCostMs() {
            return this.costMs;
        }

        public final String getLoraId() {
            return this.loraId;
        }

        public int hashCode() {
            return Long.hashCode(this.costMs) + (this.loraId.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbL = d.l("Success(loraId=", this.costMs, this.loraId, ", costMs=");
            sbL.append(")");
            return sbL.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Timeout extends SwitchResult {
        private final String loraId;
        private final long waitedMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Timeout(String loraId, long j10) {
            super(null);
            g.f(loraId, "loraId");
            this.loraId = loraId;
            this.waitedMs = j10;
        }

        public static /* synthetic */ Timeout copy$default(Timeout timeout, String str, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = timeout.loraId;
            }
            if ((i10 & 2) != 0) {
                j10 = timeout.waitedMs;
            }
            return timeout.copy(str, j10);
        }

        public final String component1() {
            return this.loraId;
        }

        public final long component2() {
            return this.waitedMs;
        }

        public final Timeout copy(String loraId, long j10) {
            g.f(loraId, "loraId");
            return new Timeout(loraId, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Timeout)) {
                return false;
            }
            Timeout timeout = (Timeout) obj;
            return g.b(this.loraId, timeout.loraId) && this.waitedMs == timeout.waitedMs;
        }

        public final String getLoraId() {
            return this.loraId;
        }

        public final long getWaitedMs() {
            return this.waitedMs;
        }

        public int hashCode() {
            return Long.hashCode(this.waitedMs) + (this.loraId.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbL = d.l("Timeout(loraId=", this.waitedMs, this.loraId, ", waitedMs=");
            sbL.append(")");
            return sbL.toString();
        }
    }

    public /* synthetic */ SwitchResult(kotlin.jvm.internal.e eVar) {
        this();
    }

    private SwitchResult() {
    }
}
