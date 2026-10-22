package com.stepos.core.ota.domain.install;

import ai.onnxruntime.a;
import com.stepos.core.ota.domain.OtaError;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class InstallOutcome {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Failure extends InstallOutcome {
        private final OtaError error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(OtaError error) {
            super(null);
            g.f(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, OtaError otaError, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                otaError = failure.error;
            }
            return failure.copy(otaError);
        }

        public final OtaError component1() {
            return this.error;
        }

        public final Failure copy(OtaError error) {
            g.f(error, "error");
            return new Failure(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && g.b(this.error, ((Failure) obj).error);
        }

        public final OtaError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Success extends InstallOutcome {
        private final int version;

        public Success(int i10) {
            super(null);
            this.version = i10;
        }

        public static /* synthetic */ Success copy$default(Success success, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = success.version;
            }
            return success.copy(i10);
        }

        public final int component1() {
            return this.version;
        }

        public final Success copy(int i10) {
            return new Success(i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && this.version == ((Success) obj).version;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return Integer.hashCode(this.version);
        }

        public String toString() {
            return a.g(this.version, "Success(version=", ")");
        }
    }

    public /* synthetic */ InstallOutcome(e eVar) {
        this();
    }

    private InstallOutcome() {
    }
}
