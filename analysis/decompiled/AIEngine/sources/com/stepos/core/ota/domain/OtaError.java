package com.stepos.core.ota.domain;

import com.stepos.core.ota.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class OtaError {
    private final Throwable cause;
    private final String message;
    private final Long retryAfterMs;
    private final boolean retryable;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ActivationFailed extends OtaError {
        private final Throwable cause;
        private final String otaId;

        public /* synthetic */ ActivationFailed(String str, Throwable th, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? null : th);
        }

        public static /* synthetic */ ActivationFailed copy$default(ActivationFailed activationFailed, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = activationFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                th = activationFailed.cause;
            }
            return activationFailed.copy(str, th);
        }

        public final String component1() {
            return this.otaId;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final ActivationFailed copy(String otaId, Throwable th) {
            g.f(otaId, "otaId");
            return new ActivationFailed(otaId, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivationFailed)) {
                return false;
            }
            ActivationFailed activationFailed = (ActivationFailed) obj;
            return g.b(this.otaId, activationFailed.otaId) && g.b(this.cause, activationFailed.cause);
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public Throwable getCause() {
            return this.cause;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            int iHashCode = this.otaId.hashCode() * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "ActivationFailed(otaId=" + this.otaId + ", cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActivationFailed(String otaId, Throwable th) {
            super("activation failed: ".concat(otaId), true, 2000L, th, null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
            this.cause = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Cancelled extends OtaError {
        private final String otaId;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancelled(String otaId, String reason) {
            super(d.j(new StringBuilder("cancelled: "), otaId, " (", reason, ")"), false, null, null, 12, null);
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            this.otaId = otaId;
            this.reason = reason;
        }

        public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = cancelled.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = cancelled.reason;
            }
            return cancelled.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.reason;
        }

        public final Cancelled copy(String otaId, String reason) {
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            return new Cancelled(otaId, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cancelled)) {
                return false;
            }
            Cancelled cancelled = (Cancelled) obj;
            return g.b(this.otaId, cancelled.otaId) && g.b(this.reason, cancelled.reason);
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("Cancelled(otaId=", this.otaId, ", reason=", this.reason, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CtaNotGranted extends OtaError {
        private final String detail;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CtaNotGranted(String otaId, String detail) {
            super(d.j(new StringBuilder("cta not granted: "), otaId, " (", detail, ")"), false, null, null, 12, null);
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            this.otaId = otaId;
            this.detail = detail;
        }

        public static /* synthetic */ CtaNotGranted copy$default(CtaNotGranted ctaNotGranted, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = ctaNotGranted.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = ctaNotGranted.detail;
            }
            return ctaNotGranted.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.detail;
        }

        public final CtaNotGranted copy(String otaId, String detail) {
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            return new CtaNotGranted(otaId, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CtaNotGranted)) {
                return false;
            }
            CtaNotGranted ctaNotGranted = (CtaNotGranted) obj;
            return g.b(this.otaId, ctaNotGranted.otaId) && g.b(this.detail, ctaNotGranted.detail);
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.detail.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("CtaNotGranted(otaId=", this.otaId, ", detail=", this.detail, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DecryptFailed extends OtaError {
        private final Throwable cause;
        private final String detail;
        private final String otaId;

        public /* synthetic */ DecryptFailed(String str, String str2, Throwable th, int i10, e eVar) {
            this(str, str2, (i10 & 4) != 0 ? null : th);
        }

        public static /* synthetic */ DecryptFailed copy$default(DecryptFailed decryptFailed, String str, String str2, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = decryptFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = decryptFailed.detail;
            }
            if ((i10 & 4) != 0) {
                th = decryptFailed.cause;
            }
            return decryptFailed.copy(str, str2, th);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.detail;
        }

        public final Throwable component3() {
            return this.cause;
        }

        public final DecryptFailed copy(String otaId, String detail, Throwable th) {
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            return new DecryptFailed(otaId, detail, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DecryptFailed)) {
                return false;
            }
            DecryptFailed decryptFailed = (DecryptFailed) obj;
            return g.b(this.otaId, decryptFailed.otaId) && g.b(this.detail, decryptFailed.detail) && g.b(this.cause, decryptFailed.cause);
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public Throwable getCause() {
            return this.cause;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            int iA = v1.d.a(this.otaId.hashCode() * 31, 31, this.detail);
            Throwable th = this.cause;
            return iA + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            String str = this.otaId;
            String str2 = this.detail;
            Throwable th = this.cause;
            StringBuilder sbS = ai.onnxruntime.a.s("DecryptFailed(otaId=", str, ", detail=", str2, ", cause=");
            sbS.append(th);
            sbS.append(")");
            return sbS.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecryptFailed(String otaId, String detail, Throwable th) {
            super(d.j(new StringBuilder("decrypt failed: "), otaId, " (", detail, ")"), true, 0L, th, null);
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            this.otaId = otaId;
            this.detail = detail;
            this.cause = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class EmptyPayload extends OtaError {
        private final String detail;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptyPayload(String otaId, String detail) {
            super(d.j(new StringBuilder("empty payload: "), otaId, " (", detail, ")"), true, 0L, null, 8, null);
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            this.otaId = otaId;
            this.detail = detail;
        }

        public static /* synthetic */ EmptyPayload copy$default(EmptyPayload emptyPayload, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = emptyPayload.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = emptyPayload.detail;
            }
            return emptyPayload.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.detail;
        }

        public final EmptyPayload copy(String otaId, String detail) {
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            return new EmptyPayload(otaId, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EmptyPayload)) {
                return false;
            }
            EmptyPayload emptyPayload = (EmptyPayload) obj;
            return g.b(this.otaId, emptyPayload.otaId) && g.b(this.detail, emptyPayload.detail);
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.detail.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("EmptyPayload(otaId=", this.otaId, ", detail=", this.detail, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ExtractFailed extends OtaError {
        private final Throwable cause;
        private final String otaId;

        public /* synthetic */ ExtractFailed(String str, Throwable th, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? null : th);
        }

        public static /* synthetic */ ExtractFailed copy$default(ExtractFailed extractFailed, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = extractFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                th = extractFailed.cause;
            }
            return extractFailed.copy(str, th);
        }

        public final String component1() {
            return this.otaId;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final ExtractFailed copy(String otaId, Throwable th) {
            g.f(otaId, "otaId");
            return new ExtractFailed(otaId, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExtractFailed)) {
                return false;
            }
            ExtractFailed extractFailed = (ExtractFailed) obj;
            return g.b(this.otaId, extractFailed.otaId) && g.b(this.cause, extractFailed.cause);
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public Throwable getCause() {
            return this.cause;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            int iHashCode = this.otaId.hashCode() * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "ExtractFailed(otaId=" + this.otaId + ", cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExtractFailed(String otaId, Throwable th) {
            super("extract failed: ".concat(otaId), true, 0L, th, null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
            this.cause = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class InstallFailed extends OtaError {
        private final Throwable cause;
        private final String otaId;
        private final String stage;

        public /* synthetic */ InstallFailed(String str, String str2, Throwable th, int i10, e eVar) {
            this(str, str2, (i10 & 4) != 0 ? null : th);
        }

        public static /* synthetic */ InstallFailed copy$default(InstallFailed installFailed, String str, String str2, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = installFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = installFailed.stage;
            }
            if ((i10 & 4) != 0) {
                th = installFailed.cause;
            }
            return installFailed.copy(str, str2, th);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.stage;
        }

        public final Throwable component3() {
            return this.cause;
        }

        public final InstallFailed copy(String otaId, String stage, Throwable th) {
            g.f(otaId, "otaId");
            g.f(stage, "stage");
            return new InstallFailed(otaId, stage, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InstallFailed)) {
                return false;
            }
            InstallFailed installFailed = (InstallFailed) obj;
            return g.b(this.otaId, installFailed.otaId) && g.b(this.stage, installFailed.stage) && g.b(this.cause, installFailed.cause);
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public Throwable getCause() {
            return this.cause;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final String getStage() {
            return this.stage;
        }

        public int hashCode() {
            int iA = v1.d.a(this.otaId.hashCode() * 31, 31, this.stage);
            Throwable th = this.cause;
            return iA + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            String str = this.otaId;
            String str2 = this.stage;
            Throwable th = this.cause;
            StringBuilder sbS = ai.onnxruntime.a.s("InstallFailed(otaId=", str, ", stage=", str2, ", cause=");
            sbS.append(th);
            sbS.append(")");
            return sbS.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InstallFailed(String otaId, String stage, Throwable th) {
            super(ai.onnxruntime.a.p(new StringBuilder("install failed: "), otaId, " @ ", stage), true, 1000L, th, null);
            g.f(otaId, "otaId");
            g.f(stage, "stage");
            this.otaId = otaId;
            this.stage = stage;
            this.cause = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class IntegrityFailed extends OtaError {
        private final String detail;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrityFailed(String otaId, String detail) {
            super(d.j(new StringBuilder("integrity failed: "), otaId, " (", detail, ")"), true, 0L, null, 8, null);
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            this.otaId = otaId;
            this.detail = detail;
        }

        public static /* synthetic */ IntegrityFailed copy$default(IntegrityFailed integrityFailed, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = integrityFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = integrityFailed.detail;
            }
            return integrityFailed.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.detail;
        }

        public final IntegrityFailed copy(String otaId, String detail) {
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            return new IntegrityFailed(otaId, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntegrityFailed)) {
                return false;
            }
            IntegrityFailed integrityFailed = (IntegrityFailed) obj;
            return g.b(this.otaId, integrityFailed.otaId) && g.b(this.detail, integrityFailed.detail);
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.detail.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("IntegrityFailed(otaId=", this.otaId, ", detail=", this.detail, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class KeyUnavailable extends OtaError {
        private final String detail;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeyUnavailable(String otaId, String detail) {
            super(d.j(new StringBuilder("key unavailable: "), otaId, " (", detail, ")"), false, null, null, 12, null);
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            this.otaId = otaId;
            this.detail = detail;
        }

        public static /* synthetic */ KeyUnavailable copy$default(KeyUnavailable keyUnavailable, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = keyUnavailable.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = keyUnavailable.detail;
            }
            return keyUnavailable.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.detail;
        }

        public final KeyUnavailable copy(String otaId, String detail) {
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            return new KeyUnavailable(otaId, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof KeyUnavailable)) {
                return false;
            }
            KeyUnavailable keyUnavailable = (KeyUnavailable) obj;
            return g.b(this.otaId, keyUnavailable.otaId) && g.b(this.detail, keyUnavailable.detail);
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.detail.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("KeyUnavailable(otaId=", this.otaId, ", detail=", this.detail, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ManifestEmpty extends OtaError {
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ManifestEmpty(String otaId) {
            super("manifest empty: ".concat(otaId), false, null, null, 12, null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
        }

        public static /* synthetic */ ManifestEmpty copy$default(ManifestEmpty manifestEmpty, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = manifestEmpty.otaId;
            }
            return manifestEmpty.copy(str);
        }

        public final String component1() {
            return this.otaId;
        }

        public final ManifestEmpty copy(String otaId) {
            g.f(otaId, "otaId");
            return new ManifestEmpty(otaId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ManifestEmpty) && g.b(this.otaId, ((ManifestEmpty) obj).otaId);
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.otaId.hashCode();
        }

        public String toString() {
            return a0.a.k("ManifestEmpty(otaId=", this.otaId, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Network extends OtaError {
        private final Throwable cause;
        private final String message;

        public /* synthetic */ Network(String str, Throwable th, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? null : th);
        }

        public static /* synthetic */ Network copy$default(Network network, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = network.message;
            }
            if ((i10 & 2) != 0) {
                th = network.cause;
            }
            return network.copy(str, th);
        }

        public final String component1() {
            return this.message;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final Network copy(String message, Throwable th) {
            g.f(message, "message");
            return new Network(message, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Network)) {
                return false;
            }
            Network network = (Network) obj;
            return g.b(this.message, network.message) && g.b(this.cause, network.cause);
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public Throwable getCause() {
            return this.cause;
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Network(message=" + this.message + ", cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Network(String message, Throwable th) {
            super(message, true, 3000L, th, null);
            g.f(message, "message");
            this.message = message;
            this.cause = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PayloadMismatch extends OtaError {
        private final String detail;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PayloadMismatch(String otaId, String detail) {
            super(d.j(new StringBuilder("payload mismatch: "), otaId, " (", detail, ")"), true, 0L, null, 8, null);
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            this.otaId = otaId;
            this.detail = detail;
        }

        public static /* synthetic */ PayloadMismatch copy$default(PayloadMismatch payloadMismatch, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = payloadMismatch.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = payloadMismatch.detail;
            }
            return payloadMismatch.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.detail;
        }

        public final PayloadMismatch copy(String otaId, String detail) {
            g.f(otaId, "otaId");
            g.f(detail, "detail");
            return new PayloadMismatch(otaId, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PayloadMismatch)) {
                return false;
            }
            PayloadMismatch payloadMismatch = (PayloadMismatch) obj;
            return g.b(this.otaId, payloadMismatch.otaId) && g.b(this.detail, payloadMismatch.detail);
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.detail.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("PayloadMismatch(otaId=", this.otaId, ", detail=", this.detail, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class StorageFailed extends OtaError {
        private final Throwable cause;
        private final String otaId;

        public /* synthetic */ StorageFailed(String str, Throwable th, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? null : th);
        }

        public static /* synthetic */ StorageFailed copy$default(StorageFailed storageFailed, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = storageFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                th = storageFailed.cause;
            }
            return storageFailed.copy(str, th);
        }

        public final String component1() {
            return this.otaId;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final StorageFailed copy(String otaId, Throwable th) {
            g.f(otaId, "otaId");
            return new StorageFailed(otaId, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StorageFailed)) {
                return false;
            }
            StorageFailed storageFailed = (StorageFailed) obj;
            return g.b(this.otaId, storageFailed.otaId) && g.b(this.cause, storageFailed.cause);
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public Throwable getCause() {
            return this.cause;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            int iHashCode = this.otaId.hashCode() * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "StorageFailed(otaId=" + this.otaId + ", cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StorageFailed(String otaId, Throwable th) {
            super("storage failed: ".concat(otaId), true, 1000L, th, null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
            this.cause = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Timeout extends OtaError {
        private final String otaId;
        private final String phase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Timeout(String otaId, String phase) {
            super(ai.onnxruntime.a.p(new StringBuilder("timeout: "), otaId, " @ ", phase), true, 2000L, null, 8, null);
            g.f(otaId, "otaId");
            g.f(phase, "phase");
            this.otaId = otaId;
            this.phase = phase;
        }

        public static /* synthetic */ Timeout copy$default(Timeout timeout, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = timeout.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = timeout.phase;
            }
            return timeout.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.phase;
        }

        public final Timeout copy(String otaId, String phase) {
            g.f(otaId, "otaId");
            g.f(phase, "phase");
            return new Timeout(otaId, phase);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Timeout)) {
                return false;
            }
            Timeout timeout = (Timeout) obj;
            return g.b(this.otaId, timeout.otaId) && g.b(this.phase, timeout.phase);
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final String getPhase() {
            return this.phase;
        }

        public int hashCode() {
            return this.phase.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("Timeout(otaId=", this.otaId, ", phase=", this.phase, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Unknown extends OtaError {
        private final Throwable cause;
        private final String otaId;

        public /* synthetic */ Unknown(String str, Throwable th, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? null : th);
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = unknown.otaId;
            }
            if ((i10 & 2) != 0) {
                th = unknown.cause;
            }
            return unknown.copy(str, th);
        }

        public final String component1() {
            return this.otaId;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final Unknown copy(String otaId, Throwable th) {
            g.f(otaId, "otaId");
            return new Unknown(otaId, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Unknown)) {
                return false;
            }
            Unknown unknown = (Unknown) obj;
            return g.b(this.otaId, unknown.otaId) && g.b(this.cause, unknown.cause);
        }

        @Override // com.stepos.core.ota.domain.OtaError
        public Throwable getCause() {
            return this.cause;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            int iHashCode = this.otaId.hashCode() * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Unknown(otaId=" + this.otaId + ", cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unknown(String otaId, Throwable th) {
            super("unknown: ".concat(otaId), false, null, th, 4, null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
            this.cause = th;
        }
    }

    public /* synthetic */ OtaError(String str, boolean z, Long l10, Throwable th, e eVar) {
        this(str, z, l10, th);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        return this.message;
    }

    public final Long getRetryAfterMs() {
        return this.retryAfterMs;
    }

    public final boolean getRetryable() {
        return this.retryable;
    }

    private OtaError(String str, boolean z, Long l10, Throwable th) {
        this.message = str;
        this.retryable = z;
        this.retryAfterMs = l10;
        this.cause = th;
    }

    public /* synthetic */ OtaError(String str, boolean z, Long l10, Throwable th, int i10, e eVar) {
        this(str, z, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : th, null);
    }
}
