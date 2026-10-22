package com.stepos.core.performance.data;

import a0.a;
import com.stepos.core.ota.d;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelMeta {
    private final long estimatedInitMemoryMb;
    private final ModelCategory modelCategory;
    private final String modelId;

    public ModelMeta(String modelId, long j10, ModelCategory modelCategory) {
        g.f(modelId, "modelId");
        g.f(modelCategory, "modelCategory");
        this.modelId = modelId;
        this.estimatedInitMemoryMb = j10;
        this.modelCategory = modelCategory;
    }

    public static /* synthetic */ ModelMeta copy$default(ModelMeta modelMeta, String str, long j10, ModelCategory modelCategory, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = modelMeta.modelId;
        }
        if ((i10 & 2) != 0) {
            j10 = modelMeta.estimatedInitMemoryMb;
        }
        if ((i10 & 4) != 0) {
            modelCategory = modelMeta.modelCategory;
        }
        return modelMeta.copy(str, j10, modelCategory);
    }

    public final String component1() {
        return this.modelId;
    }

    public final long component2() {
        return this.estimatedInitMemoryMb;
    }

    public final ModelCategory component3() {
        return this.modelCategory;
    }

    public final ModelMeta copy(String modelId, long j10, ModelCategory modelCategory) {
        g.f(modelId, "modelId");
        g.f(modelCategory, "modelCategory");
        return new ModelMeta(modelId, j10, modelCategory);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelMeta)) {
            return false;
        }
        ModelMeta modelMeta = (ModelMeta) obj;
        return g.b(this.modelId, modelMeta.modelId) && this.estimatedInitMemoryMb == modelMeta.estimatedInitMemoryMb && this.modelCategory == modelMeta.modelCategory;
    }

    public final long getEstimatedInitMemoryMb() {
        return this.estimatedInitMemoryMb;
    }

    public final ModelCategory getModelCategory() {
        return this.modelCategory;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public int hashCode() {
        return this.modelCategory.hashCode() + a.c(this.modelId.hashCode() * 31, this.estimatedInitMemoryMb, 31);
    }

    public String toString() {
        String str = this.modelId;
        long j10 = this.estimatedInitMemoryMb;
        ModelCategory modelCategory = this.modelCategory;
        StringBuilder sbL = d.l("ModelMeta(modelId=", j10, str, ", estimatedInitMemoryMb=");
        sbL.append(", modelCategory=");
        sbL.append(modelCategory);
        sbL.append(")");
        return sbL.toString();
    }
}
