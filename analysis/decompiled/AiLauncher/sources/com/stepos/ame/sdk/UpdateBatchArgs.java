package com.stepos.ame.sdk;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013BA\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR%\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/stepos/ame/sdk/UpdateBatchArgs;", "", "ids", "", "", "vectors", "", "metadataList", "", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getIds", "()Ljava/util/List;", "getVectors", "getMetadataList", "validate", "Lcom/stepos/ame/sdk/AMEError;", "Builder", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateBatchArgs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Long> ids;
    private final List<Map<String, Object>> metadataList;
    private final List<float[]> vectors;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\u00002\u001a\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n\u0018\u00010\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/ame/sdk/UpdateBatchArgs$Builder;", "", "ids", "", "", "vectors", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "metadataList", "", "", "list", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/stepos/ame/sdk/UpdateBatchArgs;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private final List<Long> ids;
        private List<? extends Map<String, ? extends Object>> metadataList;
        private final List<float[]> vectors;

        public Builder(List<Long> ids, List<float[]> vectors) {
            p.i(ids, "ids");
            p.i(vectors, "vectors");
            this.ids = ids;
            this.vectors = vectors;
        }

        public final UpdateBatchArgs build() {
            return new UpdateBatchArgs(this.ids, this.vectors, this.metadataList, null);
        }

        public final Builder metadataList(List<? extends Map<String, ? extends Object>> list) {
            this.metadataList = list;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/ame/sdk/UpdateBatchArgs$Companion;", "", "<init>", "()V", "builder", "Lcom/stepos/ame/sdk/UpdateBatchArgs$Builder;", "ids", "", "", "vectors", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Builder builder(List<Long> ids, List<float[]> vectors) {
            p.i(ids, "ids");
            p.i(vectors, "vectors");
            return new Builder(ids, vectors);
        }

        private Companion() {
        }
    }

    public /* synthetic */ UpdateBatchArgs(List list, List list2, List list3, i iVar) {
        this(list, list2, list3);
    }

    public static final Builder builder(List<Long> list, List<float[]> list2) {
        return INSTANCE.builder(list, list2);
    }

    public final List<Long> getIds() {
        return this.ids;
    }

    public final List<Map<String, Object>> getMetadataList() {
        return this.metadataList;
    }

    public final List<float[]> getVectors() {
        return this.vectors;
    }

    public final AMEError validate() {
        if (this.ids.isEmpty() || this.vectors.isEmpty()) {
            return AMEError.ARGS_EMPTY_INPUT;
        }
        if (this.ids.size() != this.vectors.size()) {
            return AMEError.ARGS_SIZE_MISMATCH;
        }
        List<Map<String, Object>> list = this.metadataList;
        if (list == null || list.size() == this.ids.size()) {
            return null;
        }
        return AMEError.ARGS_SIZE_MISMATCH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private UpdateBatchArgs(List<Long> list, List<float[]> list2, List<? extends Map<String, ? extends Object>> list3) {
        this.ids = list;
        this.vectors = list2;
        this.metadataList = list3;
    }
}
