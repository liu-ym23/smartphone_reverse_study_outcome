package androidx.appsearch.usagereporting;

import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.usagereporting.TakenAction;
import androidx.core.util.Preconditions;

@Document(name = C$$__AppSearch__ImpressionAction.SCHEMA_NAME)
@ExperimentalAppSearchApi
/* loaded from: classes.dex */
public class ImpressionAction extends TakenAction {

    @Document.StringProperty(indexingType = 2)
    private final String mQuery;

    @Document.StringProperty(joinableValueType = 1)
    private final String mReferencedQualifiedId;

    @Document.LongProperty
    private final int mResultRankGlobal;

    @Document.LongProperty
    private final int mResultRankInBlock;

    @Document.BuilderProducer
    public static final class Builder extends TakenAction.BuilderImpl<Builder> {
        private String mQuery;
        private String mReferencedQualifiedId;
        private int mResultRankGlobal;
        private int mResultRankInBlock;

        public Builder(String str, String str2, long j5) {
            this(str, str2, j5, 3);
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ TakenAction.BuilderImpl setDocumentTtlMillis(long j5) {
            return super.setDocumentTtlMillis(j5);
        }

        @CanIgnoreReturnValue
        public Builder setQuery(String str) {
            this.mQuery = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setReferencedQualifiedId(String str) {
            this.mReferencedQualifiedId = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setResultRankGlobal(int i) {
            this.mResultRankGlobal = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setResultRankInBlock(int i) {
            this.mResultRankInBlock = i;
            return this;
        }

        public Builder(ImpressionAction impressionAction) {
            super((TakenAction) Preconditions.checkNotNull(impressionAction));
            this.mQuery = impressionAction.getQuery();
            this.mReferencedQualifiedId = impressionAction.getReferencedQualifiedId();
            this.mResultRankInBlock = impressionAction.getResultRankInBlock();
            this.mResultRankGlobal = impressionAction.getResultRankGlobal();
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public ImpressionAction build() {
            return new ImpressionAction(this.mNamespace, this.mId, this.mDocumentTtlMillis, this.mActionTimestampMillis, this.mActionType, this.mQuery, this.mReferencedQualifiedId, this.mResultRankInBlock, this.mResultRankGlobal);
        }

        public Builder(String str, String str2, long j5, int i) {
            super(str, str2, j5, i);
            this.mResultRankInBlock = -1;
            this.mResultRankGlobal = -1;
        }
    }

    public ImpressionAction(String str, String str2, long j5, long j6, int i, String str3, String str4, int i6, int i10) {
        super(str, str2, j5, j6, i);
        this.mQuery = str3;
        this.mReferencedQualifiedId = str4;
        this.mResultRankInBlock = i6;
        this.mResultRankGlobal = i10;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String getReferencedQualifiedId() {
        return this.mReferencedQualifiedId;
    }

    public int getResultRankGlobal() {
        return this.mResultRankGlobal;
    }

    public int getResultRankInBlock() {
        return this.mResultRankInBlock;
    }
}
