package com.stepos.ame.sdk;

import F6.a;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ame.api.FilterStrategy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0002\u001f B;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/stepos/ame/sdk/SearchArgs;", "", "query", "", "topK", "", "filterJson", "", "overfetchRatio", "withMetadata", "", "filterStrategy", "Lcom/stepos/ame/api/FilterStrategy;", "<init>", "([FILjava/lang/String;IZLcom/stepos/ame/api/FilterStrategy;)V", "getQuery", "()[F", "getTopK", "()I", "getFilterJson", "()Ljava/lang/String;", "getOverfetchRatio", "getWithMetadata", "()Z", "getFilterStrategy", "()Lcom/stepos/ame/api/FilterStrategy;", "validate", "Lcom/stepos/ame/sdk/AMEError;", "equals", "other", "hashCode", "Builder", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SearchArgs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String filterJson;
    private final FilterStrategy filterStrategy;
    private final int overfetchRatio;
    private final float[] query;
    private final int topK;
    private final boolean withMetadata;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ame/sdk/SearchArgs$Builder;", "", "", "query", "", "topK", "<init>", "([FI)V", "LF6/a;", "condition", "filterCondition", "(LF6/a;)Lcom/stepos/ame/sdk/SearchArgs$Builder;", "", "json", "filterRawJson", "(Ljava/lang/String;)Lcom/stepos/ame/sdk/SearchArgs$Builder;", "ratio", "overfetchRatio", "(I)Lcom/stepos/ame/sdk/SearchArgs$Builder;", "", JsonPOJOBuilder.DEFAULT_WITH_PREFIX, "withMetadata", "(Z)Lcom/stepos/ame/sdk/SearchArgs$Builder;", "Lcom/stepos/ame/api/FilterStrategy;", "strategy", "filterStrategy", "(Lcom/stepos/ame/api/FilterStrategy;)Lcom/stepos/ame/sdk/SearchArgs$Builder;", "Lcom/stepos/ame/sdk/SearchArgs;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/stepos/ame/sdk/SearchArgs;", "[F", "I", "filterJson", "Ljava/lang/String;", "Z", "Lcom/stepos/ame/api/FilterStrategy;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private String filterJson;
        private FilterStrategy filterStrategy;
        private int overfetchRatio;
        private final float[] query;
        private final int topK;
        private boolean withMetadata;

        public Builder(float[] query, int i10) {
            p.i(query, "query");
            this.query = query;
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

        public final SearchArgs build() {
            return new SearchArgs(this.query, this.topK, this.filterJson, this.overfetchRatio, this.withMetadata, this.filterStrategy, null);
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/ame/sdk/SearchArgs$Companion;", "", "<init>", "()V", "builder", "Lcom/stepos/ame/sdk/SearchArgs$Builder;", "query", "", "topK", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Builder builder(float[] query, int topK) {
            p.i(query, "query");
            return new Builder(query, topK);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SearchArgs(float[] fArr, int i10, String str, int i11, boolean z10, FilterStrategy filterStrategy, i iVar) {
        this(fArr, i10, str, i11, z10, filterStrategy);
    }

    public static final Builder builder(float[] fArr, int i10) {
        return INSTANCE.builder(fArr, i10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchArgs)) {
            return false;
        }
        SearchArgs searchArgs = (SearchArgs) other;
        return Arrays.equals(this.query, searchArgs.query) && this.topK == searchArgs.topK && p.d(this.filterJson, searchArgs.filterJson) && this.overfetchRatio == searchArgs.overfetchRatio && this.withMetadata == searchArgs.withMetadata && this.filterStrategy == searchArgs.filterStrategy;
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

    public final float[] getQuery() {
        return this.query;
    }

    public final int getTopK() {
        return this.topK;
    }

    public final boolean getWithMetadata() {
        return this.withMetadata;
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.query) * 31) + this.topK) * 31;
        String str = this.filterJson;
        return ((((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.overfetchRatio) * 31) + Boolean.hashCode(this.withMetadata)) * 31) + this.filterStrategy.hashCode();
    }

    public final AMEError validate() {
        if (this.query.length == 0) {
            return AMEError.ARGS_EMPTY_INPUT;
        }
        if (this.topK <= 0) {
            return AMEError.ARGS_INVALID_TOPK;
        }
        return null;
    }

    private SearchArgs(float[] fArr, int i10, String str, int i11, boolean z10, FilterStrategy filterStrategy) {
        this.query = fArr;
        this.topK = i10;
        this.filterJson = str;
        this.overfetchRatio = i11;
        this.withMetadata = z10;
        this.filterStrategy = filterStrategy;
    }
}
