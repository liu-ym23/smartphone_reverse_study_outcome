package com.stepos.core.ota.domain.install;

import com.stepos.core.ota.domain.OtaError;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class StageOutcome {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Fail extends StageOutcome {
        private final OtaError error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Fail(OtaError error) {
            super(null);
            g.f(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Fail copy$default(Fail fail, OtaError otaError, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                otaError = fail.error;
            }
            return fail.copy(otaError);
        }

        public final OtaError component1() {
            return this.error;
        }

        public final Fail copy(OtaError error) {
            g.f(error, "error");
            return new Fail(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Fail) && g.b(this.error, ((Fail) obj).error);
        }

        public final OtaError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Fail(error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Proceed extends StageOutcome {
        public static final Proceed INSTANCE = new Proceed();

        private Proceed() {
            super(null);
        }
    }

    public /* synthetic */ StageOutcome(e eVar) {
        this();
    }

    private StageOutcome() {
    }
}
