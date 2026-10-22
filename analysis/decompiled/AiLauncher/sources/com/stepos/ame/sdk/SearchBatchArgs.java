package com.stepos.ame.sdk;

import F6.a;
import Z8.C1173v;
import Z8.M;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ame.api.FilterStrategy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0002 !BA\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/stepos/ame/sdk/SearchBatchArgs;", "", "queries", "", "", "topK", "", "filterJson", "", "overfetchRatio", "withMetadata", "", "filterStrategy", "Lcom/stepos/ame/api/FilterStrategy;", "<init>", "(Ljava/util/List;ILjava/lang/String;IZLcom/stepos/ame/api/FilterStrategy;)V", "getQueries", "()Ljava/util/List;", "getTopK", "()I", "getFilterJson", "()Ljava/lang/String;", "getOverfetchRatio", "getWithMetadata", "()Z", "getFilterStrategy", "()Lcom/stepos/ame/api/FilterStrategy;", "validate", "Lcom/stepos/ame/sdk/AMEError;", "equals", "other", "hashCode", "Builder", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SearchBatchArgs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String filterJson;
    private final FilterStrategy filterStrategy;
    private final int overfetchRatio;
    private final List<float[]> queries;
    private final int topK;
    private final boolean withMetadata;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010 R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010#R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ame/sdk/SearchBatchArgs$Builder;", "", "", "", "queries", "", "topK", "<init>", "(Ljava/util/List;I)V", "LF6/a;", "condition", "filterCondition", "(LF6/a;)Lcom/stepos/ame/sdk/SearchBatchArgs$Builder;", "", "json", "filterRawJson", "(Ljava/lang/String;)Lcom/stepos/ame/sdk/SearchBatchArgs$Builder;", "ratio", "overfetchRatio", "(I)Lcom/stepos/ame/sdk/SearchBatchArgs$Builder;", "", JsonPOJOBuilder.DEFAULT_WITH_PREFIX, "withMetadata", "(Z)Lcom/stepos/ame/sdk/SearchBatchArgs$Builder;", "Lcom/stepos/ame/api/FilterStrategy;", "strategy", "filterStrategy", "(Lcom/stepos/ame/api/FilterStrategy;)Lcom/stepos/ame/sdk/SearchBatchArgs$Builder;", "Lcom/stepos/ame/sdk/SearchBatchArgs;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/stepos/ame/sdk/SearchBatchArgs;", "Ljava/util/List;", "I", "filterJson", "Ljava/lang/String;", "Z", "Lcom/stepos/ame/api/FilterStrategy;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private String filterJson;
        private FilterStrategy filterStrategy;
        private int overfetchRatio;
        private final List<float[]> queries;
        private final int topK;
        private boolean withMetadata;

        public Builder(List<float[]> queries, int i10) {
            p.i(queries, "queries");
            this.queries = queries;
            this.topK = i10;
            this.overfetchRatio = 2;
            this.filterStrategy = FilterStrategy.POST_FILTER;
        }

        public static /* synthetic */ Builder withMetadata$default(Builder builder, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = true;
            }
            return builder.withMetadata(z10);
        }

        public final SearchBatchArgs build() {
            return new SearchBatchArgs(this.queries, this.topK, this.filterJson, this.overfetchRatio, this.withMetadata, this.filterStrategy, null);
        }

        public final Builder filterCondition(a condition) {
            this.filterJson = condition != null ? G6.a.j(condition) : null;
            return this;
        }

        public final Builder filterRawJson(String json) {
            this.filterJson = json;
            return this;
        }

        public final Builder filterStrategy(FilterStrategy strategy) {
            p.i(strategy, "strategy");
            this.filterStrategy = strategy;
            return this;
        }

        public final Builder overfetchRatio(int ratio) {
            this.overfetchRatio = ratio;
            return this;
        }

        public final Builder withMetadata(boolean with) {
            this.withMetadata = with;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/ame/sdk/SearchBatchArgs$Companion;", "", "<init>", "()V", "builder", "Lcom/stepos/ame/sdk/SearchBatchArgs$Builder;", "queries", "", "", "topK", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Builder builder(List<float[]> queries, int topK) {
            p.i(queries, "queries");
            return new Builder(queries, topK);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SearchBatchArgs(List list, int i10, String str, int i11, boolean z10, FilterStrategy filterStrategy, i iVar) {
        this(list, i10, str, i11, z10, filterStrategy);
    }

    public static final Builder builder(List<float[]> list, int i10) {
        return INSTANCE.builder(list, i10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchBatchArgs)) {
            return false;
        }
        SearchBatchArgs searchBatchArgs = (SearchBatchArgs) other;
        if (this.queries.size() == searchBatchArgs.queries.size()) {
            Iterable iterableN = C1173v.n(this.queries);
            if (!(iterableN instanceof Collection) || !((Collection) iterableN).isEmpty()) {
                Iterator it = iterableN.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((M) it).nextInt();
                    if (!Arrays.equals(this.queries.get(iNextInt), searchBatchArgs.queries.get(iNextInt))) {
                        break;
                    }
                }
                if (this.topK == searchBatchArgs.topK || !p.d(this.filterJson, searchBatchArgs.filterJson) || this.overfetchRatio != searchBatchArgs.overfetchRatio || this.withMetadata != searchBatchArgs.withMetadata || this.filterStrategy != searchBatchArgs.filterStrategy) {
                    break;
                }
                return true;
            }
            if (this.topK == searchBatchArgs.topK) {
            }
        }
        return false;
    }

    public final String getFilterJson() {
        return this.filterJson;
    }

    public final FilterStrategy getFilterStrategy() {
        return this.filterStrategy;
    }

    public final int getOverfetchRatio() {
        return this.overfetchRatio;
    }

    public final List<float[]> getQueries() {
        return this.queries;
    }

    public final int getTopK() {
        return this.topK;
    }

    public final boolean getWithMetadata() {
        return this.withMetadata;
    }

    public int hashCode() {
        int i10 = this.topK * 31;
        Iterator<T> it = this.queries.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + Arrays.hashCode((float[]) it.next());
        }
        int i11 = (i10 + iHashCode) * 31;
        String str = this.filterJson;
        return ((((((i11 + (str != null ? str.hashCode() : 0)) * 31) + this.overfetchRatio) * 31) + Boolean.hashCode(this.withMetadata)) * 31) + this.filterStrategy.hashCode();
    }

    public final AMEError validate() {
        if (this.queries.isEmpty()) {
            return AMEError.ARGS_EMPTY_INPUT;
        }
        if (this.topK <= 0) {
            return AMEError.ARGS_INVALID_TOPK;
        }
        return null;
    }

    private SearchBatchArgs(List<float[]> list, int i10, String str, int i11, boolean z10, FilterStrategy filterStrategy) {
        this.queries = list;
        this.topK = i10;
        this.filterJson = str;
        this.overfetchRatio = i11;
        this.withMetadata = z10;
        this.filterStrategy = filterStrategy;
    }
}
