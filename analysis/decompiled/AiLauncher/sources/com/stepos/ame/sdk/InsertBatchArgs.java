package com.stepos.ame.sdk;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B3\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/stepos/ame/sdk/InsertBatchArgs;", "", "vectors", "", "", "metadataList", "", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getVectors", "()Ljava/util/List;", "getMetadataList", "validate", "Lcom/stepos/ame/sdk/AMEError;", "Builder", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InsertBatchArgs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Map<String, Object>> metadataList;
    private final List<float[]> vectors;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00002\u001a\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0018\u00010\u0003J\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/ame/sdk/InsertBatchArgs$Builder;", "", "vectors", "", "", "<init>", "(Ljava/util/List;)V", "metadataList", "", "", "list", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/stepos/ame/sdk/InsertBatchArgs;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private List<? extends Map<String, ? extends Object>> metadataList;
        private final List<float[]> vectors;

        public Builder(List<float[]> vectors) {
            p.i(vectors, "vectors");
            this.vectors = vectors;
        }

        public final InsertBatchArgs build() {
            return new InsertBatchArgs(this.vectors, this.metadataList, null);
        }

        public final Builder metadataList(List<? extends Map<String, ? extends Object>> list) {
            this.metadataList = list;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/stepos/ame/sdk/InsertBatchArgs$Companion;", "", "<init>", "()V", "builder", "Lcom/stepos/ame/sdk/InsertBatchArgs$Builder;", "vectors", "", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Builder builder(List<float[]> vectors) {
            p.i(vectors, "vectors");
            return new Builder(vectors);
        }

        private Companion() {
        }
    }

    public /* synthetic */ InsertBatchArgs(List list, List list2, i iVar) {
        this(list, list2);
    }

    public static final Builder builder(List<float[]> list) {
        return INSTANCE.builder(list);
    }

    public final List<Map<String, Object>> getMetadataList() {
        return this.metadataList;
    }

    public final List<float[]> getVectors() {
        return this.vectors;
    }

    public final AMEError validate() {
        if (this.vectors.isEmpty()) {
            return AMEError.ARGS_EMPTY_INPUT;
        }
        List<Map<String, Object>> list = this.metadataList;
        if (list == null || list.size() == this.vectors.size()) {
            return null;
        }
        return AMEError.ARGS_SIZE_MISMATCH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InsertBatchArgs(List<float[]> list, List<? extends Map<String, ? extends Object>> list2) {
        this.vectors = list;
        this.metadataList = list2;
    }
}
