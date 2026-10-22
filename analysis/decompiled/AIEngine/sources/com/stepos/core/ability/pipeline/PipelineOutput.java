package com.stepos.core.ability.pipeline;

import ai.onnxruntime.a;
import h0.e;
import kotlin.jvm.internal.g;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PipelineOutput {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Done extends PipelineOutput {
        private final d finalOutput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Done(d finalOutput) {
            super(null);
            g.f(finalOutput, "finalOutput");
            this.finalOutput = finalOutput;
        }

        public static /* synthetic */ Done copy$default(Done done, d dVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                dVar = done.finalOutput;
            }
            return done.copy(dVar);
        }

        public final d component1() {
            return this.finalOutput;
        }

        public final Done copy(d finalOutput) {
            g.f(finalOutput, "finalOutput");
            return new Done(finalOutput);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Done) && g.b(this.finalOutput, ((Done) obj).finalOutput);
        }

        public final d getFinalOutput() {
            return this.finalOutput;
        }

        public int hashCode() {
            return this.finalOutput.hashCode();
        }

        public String toString() {
            return "Done(finalOutput=" + this.finalOutput + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Error extends PipelineOutput {
        private final String abilityId;
        private final String message;
        private final int stageIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i10, String abilityId, String message) {
            super(null);
            g.f(abilityId, "abilityId");
            g.f(message, "message");
            this.stageIndex = i10;
            this.abilityId = abilityId;
            this.message = message;
        }

        public static /* synthetic */ Error copy$default(Error error, int i10, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = error.stageIndex;
            }
            if ((i11 & 2) != 0) {
                str = error.abilityId;
            }
            if ((i11 & 4) != 0) {
                str2 = error.message;
            }
            return error.copy(i10, str, str2);
        }

        public final int component1() {
            return this.stageIndex;
        }

        public final String component2() {
            return this.abilityId;
        }

        public final String component3() {
            return this.message;
        }

        public final Error copy(int i10, String abilityId, String message) {
            g.f(abilityId, "abilityId");
            g.f(message, "message");
            return new Error(i10, abilityId, message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return this.stageIndex == error.stageIndex && g.b(this.abilityId, error.abilityId) && g.b(this.message, error.message);
        }

        public final String getAbilityId() {
            return this.abilityId;
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getStageIndex() {
            return this.stageIndex;
        }

        public int hashCode() {
            return this.message.hashCode() + v1.d.a(Integer.hashCode(this.stageIndex) * 31, 31, this.abilityId);
        }

        public String toString() {
            int i10 = this.stageIndex;
            String str = this.abilityId;
            return a.o(e.e("Error(stageIndex=", i10, ", abilityId=", str, ", message="), this.message, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Partial extends PipelineOutput {
        private final String abilityId;
        private final d output;
        private final int stageIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Partial(int i10, String abilityId, d output) {
            super(null);
            g.f(abilityId, "abilityId");
            g.f(output, "output");
            this.stageIndex = i10;
            this.abilityId = abilityId;
            this.output = output;
        }

        public static /* synthetic */ Partial copy$default(Partial partial, int i10, String str, d dVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = partial.stageIndex;
            }
            if ((i11 & 2) != 0) {
                str = partial.abilityId;
            }
            if ((i11 & 4) != 0) {
                dVar = partial.output;
            }
            return partial.copy(i10, str, dVar);
        }

        public final int component1() {
            return this.stageIndex;
        }

        public final String component2() {
            return this.abilityId;
        }

        public final d component3() {
            return this.output;
        }

        public final Partial copy(int i10, String abilityId, d output) {
            g.f(abilityId, "abilityId");
            g.f(output, "output");
            return new Partial(i10, abilityId, output);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Partial)) {
                return false;
            }
            Partial partial = (Partial) obj;
            return this.stageIndex == partial.stageIndex && g.b(this.abilityId, partial.abilityId) && g.b(this.output, partial.output);
        }

        public final String getAbilityId() {
            return this.abilityId;
        }

        public final d getOutput() {
            return this.output;
        }

        public final int getStageIndex() {
            return this.stageIndex;
        }

        public int hashCode() {
            return this.output.hashCode() + v1.d.a(Integer.hashCode(this.stageIndex) * 31, 31, this.abilityId);
        }

        public String toString() {
            int i10 = this.stageIndex;
            String str = this.abilityId;
            d dVar = this.output;
            StringBuilder sbE = e.e("Partial(stageIndex=", i10, ", abilityId=", str, ", output=");
            sbE.append(dVar);
            sbE.append(")");
            return sbE.toString();
        }
    }

    public /* synthetic */ PipelineOutput(kotlin.jvm.internal.e eVar) {
        this();
    }

    private PipelineOutput() {
    }
}
