package com.stepos.core.ability.pipeline;

import h0.e;
import kotlin.jvm.internal.g;
import p6.d;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PipelineStage {
    private final d<?, ?> ability;
    private final String abilityId;
    private final int index;
    private final Class<? extends c> inputType;
    private final Class<? extends v6.d> outputType;

    public PipelineStage(int i10, String abilityId, d<?, ?> ability, Class<? extends c> inputType, Class<? extends v6.d> outputType) {
        g.f(abilityId, "abilityId");
        g.f(ability, "ability");
        g.f(inputType, "inputType");
        g.f(outputType, "outputType");
        this.index = i10;
        this.abilityId = abilityId;
        this.ability = ability;
        this.inputType = inputType;
        this.outputType = outputType;
    }

    public static /* synthetic */ PipelineStage copy$default(PipelineStage pipelineStage, int i10, String str, d dVar, Class cls, Class cls2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = pipelineStage.index;
        }
        if ((i11 & 2) != 0) {
            str = pipelineStage.abilityId;
        }
        if ((i11 & 4) != 0) {
            dVar = pipelineStage.ability;
        }
        if ((i11 & 8) != 0) {
            cls = pipelineStage.inputType;
        }
        if ((i11 & 16) != 0) {
            cls2 = pipelineStage.outputType;
        }
        Class cls3 = cls2;
        d dVar2 = dVar;
        return pipelineStage.copy(i10, str, dVar2, cls, cls3);
    }

    public final int component1() {
        return this.index;
    }

    public final String component2() {
        return this.abilityId;
    }

    public final d<?, ?> component3() {
        return this.ability;
    }

    public final Class<? extends c> component4() {
        return this.inputType;
    }

    public final Class<? extends v6.d> component5() {
        return this.outputType;
    }

    public final PipelineStage copy(int i10, String abilityId, d<?, ?> ability, Class<? extends c> inputType, Class<? extends v6.d> outputType) {
        g.f(abilityId, "abilityId");
        g.f(ability, "ability");
        g.f(inputType, "inputType");
        g.f(outputType, "outputType");
        return new PipelineStage(i10, abilityId, ability, inputType, outputType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PipelineStage)) {
            return false;
        }
        PipelineStage pipelineStage = (PipelineStage) obj;
        return this.index == pipelineStage.index && g.b(this.abilityId, pipelineStage.abilityId) && g.b(this.ability, pipelineStage.ability) && g.b(this.inputType, pipelineStage.inputType) && g.b(this.outputType, pipelineStage.outputType);
    }

    public final d<?, ?> getAbility() {
        return this.ability;
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Class<? extends c> getInputType() {
        return this.inputType;
    }

    public final Class<? extends v6.d> getOutputType() {
        return this.outputType;
    }

    public int hashCode() {
        return this.outputType.hashCode() + ((this.inputType.hashCode() + ((this.ability.hashCode() + v1.d.a(Integer.hashCode(this.index) * 31, 31, this.abilityId)) * 31)) * 31);
    }

    public String toString() {
        int i10 = this.index;
        String str = this.abilityId;
        d<?, ?> dVar = this.ability;
        Class<? extends c> cls = this.inputType;
        Class<? extends v6.d> cls2 = this.outputType;
        StringBuilder sbE = e.e("PipelineStage(index=", i10, ", abilityId=", str, ", ability=");
        sbE.append(dVar);
        sbE.append(", inputType=");
        sbE.append(cls);
        sbE.append(", outputType=");
        sbE.append(cls2);
        sbE.append(")");
        return sbE.toString();
    }
}
