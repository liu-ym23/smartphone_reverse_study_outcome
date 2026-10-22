package com.stepos.core.model.manager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelRefRecord {
    private final long acquiredAtNs;
    private final ModelRefHolder holder;
    private final String refToken;
    private final ModelAcquireSource source;

    public ModelRefRecord(String refToken, ModelRefHolder holder, ModelAcquireSource source, long j10) {
        kotlin.jvm.internal.g.f(refToken, "refToken");
        kotlin.jvm.internal.g.f(holder, "holder");
        kotlin.jvm.internal.g.f(source, "source");
        this.refToken = refToken;
        this.holder = holder;
        this.source = source;
        this.acquiredAtNs = j10;
    }

    public static /* synthetic */ ModelRefRecord copy$default(ModelRefRecord modelRefRecord, String str, ModelRefHolder modelRefHolder, ModelAcquireSource modelAcquireSource, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = modelRefRecord.refToken;
        }
        if ((i10 & 2) != 0) {
            modelRefHolder = modelRefRecord.holder;
        }
        if ((i10 & 4) != 0) {
            modelAcquireSource = modelRefRecord.source;
        }
        if ((i10 & 8) != 0) {
            j10 = modelRefRecord.acquiredAtNs;
        }
        ModelAcquireSource modelAcquireSource2 = modelAcquireSource;
        return modelRefRecord.copy(str, modelRefHolder, modelAcquireSource2, j10);
    }

    public final String component1() {
        return this.refToken;
    }

    public final ModelRefHolder component2() {
        return this.holder;
    }

    public final ModelAcquireSource component3() {
        return this.source;
    }

    public final long component4() {
        return this.acquiredAtNs;
    }

    public final ModelRefRecord copy(String refToken, ModelRefHolder holder, ModelAcquireSource source, long j10) {
        kotlin.jvm.internal.g.f(refToken, "refToken");
        kotlin.jvm.internal.g.f(holder, "holder");
        kotlin.jvm.internal.g.f(source, "source");
        return new ModelRefRecord(refToken, holder, source, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelRefRecord)) {
            return false;
        }
        ModelRefRecord modelRefRecord = (ModelRefRecord) obj;
        return kotlin.jvm.internal.g.b(this.refToken, modelRefRecord.refToken) && kotlin.jvm.internal.g.b(this.holder, modelRefRecord.holder) && this.source == modelRefRecord.source && this.acquiredAtNs == modelRefRecord.acquiredAtNs;
    }

    public final long getAcquiredAtNs() {
        return this.acquiredAtNs;
    }

    public final ModelRefHolder getHolder() {
        return this.holder;
    }

    public final String getRefToken() {
        return this.refToken;
    }

    public final ModelAcquireSource getSource() {
        return this.source;
    }

    public int hashCode() {
        return Long.hashCode(this.acquiredAtNs) + ((this.source.hashCode() + ((this.holder.hashCode() + (this.refToken.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "ModelRefRecord(refToken=" + this.refToken + ", holder=" + this.holder + ", source=" + this.source + ", acquiredAtNs=" + this.acquiredAtNs + ")";
    }
}
