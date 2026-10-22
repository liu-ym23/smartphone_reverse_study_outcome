package androidx.appsearch.usagereporting;

import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.usagereporting.TakenAction;
import androidx.core.util.Preconditions;

@Document(name = C$$__AppSearch__SearchAction.SCHEMA_NAME)
@ExperimentalAppSearchApi
/* loaded from: classes.dex */
public class SearchAction extends TakenAction {

    @Document.LongProperty
    private final int mFetchedResultCount;

    @Document.StringProperty(indexingType = 2)
    private final String mQuery;

    @Document.BuilderProducer
    public static final class Builder extends TakenAction.BuilderImpl<Builder> {
        private int mFetchedResultCount;
        private String mQuery;

        public Builder(String str, String str2, long j5) {
            this(str, str2, j5, 1);
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ TakenAction.BuilderImpl setDocumentTtlMillis(long j5) {
            return super.setDocumentTtlMillis(j5);
        }

        @CanIgnoreReturnValue
        public Builder setFetchedResultCount(int i) {
            this.mFetchedResultCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setQuery(String str) {
            this.mQuery = str;
            return this;
        }

        public Builder(SearchAction searchAction) {
            super((TakenAction) Preconditions.checkNotNull(searchAction));
            this.mQuery = searchAction.getQuery();
            this.mFetchedResultCount = searchAction.getFetchedResultCount();
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public SearchAction build() {
            return new SearchAction(this.mNamespace, this.mId, this.mDocumentTtlMillis, this.mActionTimestampMillis, this.mActionType, this.mQuery, this.mFetchedResultCount);
        }

        public Builder(String str, String str2, long j5, int i) {
            super(str, str2, j5, i);
            this.mFetchedResultCount = -1;
        }
    }

    public SearchAction(String str, String str2, long j5, long j6, int i, String str3, int i6) {
        super(str, str2, j5, j6, i);
        this.mQuery = str3;
        this.mFetchedResultCount = i6;
    }

    public int getFetchedResultCount() {
        return this.mFetchedResultCount;
    }

    public String getQuery() {
        return this.mQuery;
    }
}
