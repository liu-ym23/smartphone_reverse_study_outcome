package androidx.appsearch.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.GenericDocumentParcel;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.appsearch.util.BundleUtil;
import androidx.collection.ArrayMap;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "SearchResultCreator")
/* loaded from: classes.dex */
public final class SearchResult extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchResult> CREATOR = new StubCreators.SearchResultCreator();

    @AbstractSafeParcelable.Field(getter = "getDatabaseName", id = 4)
    private final String mDatabaseName;

    @AbstractSafeParcelable.Field(id = 1)
    final GenericDocumentParcel mDocument;

    @Nullable
    private GenericDocument mDocumentCached;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getInformationalRankingSignals", id = 7)
    private final List<Double> mInformationalRankingSignals;

    @AbstractSafeParcelable.Field(getter = "getJoinedResults", id = 6)
    private final List<SearchResult> mJoinedResults;

    @AbstractSafeParcelable.Field(id = 2)
    final List<MatchInfo> mMatchInfos;

    @Nullable
    private List<MatchInfo> mMatchInfosCached;

    @AbstractSafeParcelable.Field(getter = "getPackageName", id = 3)
    private final String mPackageName;

    @NonNull
    @AbstractSafeParcelable.Field(id = 8)
    final Bundle mParentTypeMap;

    @AbstractSafeParcelable.Field(getter = "getRankingSignal", id = 5)
    private final double mRankingSignal;

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
    @SafeParcelable.Class(creator = "EmbeddingMatchInfoCreator")
    public static final class EmbeddingMatchInfo extends AbstractSafeParcelable {

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Parcelable.Creator<EmbeddingMatchInfo> CREATOR = new StubCreators.EmbeddingMatchInfoCreator();

        @AbstractSafeParcelable.Field(getter = "getEmbeddingSearchMetricType", id = 3)
        private final int mEmbeddingSearchMetricType;

        @AbstractSafeParcelable.Field(getter = "getQueryEmbeddingVectorIndex", id = 2)
        private final int mQueryEmbeddingVectorIndex;

        @AbstractSafeParcelable.Field(getter = "getSemanticScore", id = 1)
        private final double mSemanticScore;

        @ExperimentalAppSearchApi
        @AbstractSafeParcelable.Constructor
        public EmbeddingMatchInfo(@AbstractSafeParcelable.Param(id = 1) double d, @AbstractSafeParcelable.Param(id = 2) int i, @AbstractSafeParcelable.Param(id = 3) int i6) {
            Preconditions.checkArgumentInRange(i6, 1, 3, "Embedding search metric type");
            this.mSemanticScore = d;
            this.mQueryEmbeddingVectorIndex = i;
            this.mEmbeddingSearchMetricType = i6;
        }

        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public int getEmbeddingSearchMetricType() {
            return this.mEmbeddingSearchMetricType;
        }

        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public int getQueryEmbeddingVectorIndex() {
            return this.mQueryEmbeddingVectorIndex;
        }

        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public double getSemanticScore() {
            return this.mSemanticScore;
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }
    }

    public static final class MatchRange {
        private final int mEnd;
        private final int mStart;

        public MatchRange(int i, int i6) {
            if (i > i6) {
                throw new IllegalArgumentException("Start point must be less than or equal to end point");
            }
            this.mStart = i;
            this.mEnd = i6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MatchRange)) {
                return false;
            }
            MatchRange matchRange = (MatchRange) obj;
            return getStart() == matchRange.getStart() && getEnd() == matchRange.getEnd();
        }

        public int getEnd() {
            return this.mEnd;
        }

        public int getStart() {
            return this.mStart;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mStart), Integer.valueOf(this.mEnd));
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("MatchRange { start: ");
            sb.append(this.mStart);
            sb.append(" , end: ");
            return androidx.appfunctions.metadata.a.o(sb, "}", this.mEnd);
        }
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
    @SafeParcelable.Class(creator = "TextMatchInfoCreator")
    public static final class TextMatchInfo extends AbstractSafeParcelable {

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Parcelable.Creator<TextMatchInfo> CREATOR = new StubCreators.TextMatchInfoCreator();

        @Nullable
        private MatchRange mExactMatchRangeCached;

        @AbstractSafeParcelable.Field(id = 2)
        final int mExactMatchRangeEnd;

        @AbstractSafeParcelable.Field(id = 1)
        final int mExactMatchRangeStart;

        @Nullable
        private String mFullText;

        @AbstractSafeParcelable.Field(id = 6)
        final int mSnippetRangeEnd;

        @AbstractSafeParcelable.Field(id = 5)
        final int mSnippetRangeStart;

        @Nullable
        private MatchRange mSubmatchRangeCached;

        @AbstractSafeParcelable.Field(id = 4)
        final int mSubmatchRangeEnd;

        @AbstractSafeParcelable.Field(id = 3)
        final int mSubmatchRangeStart;

        @Nullable
        private MatchRange mWindowRangeCached;

        @Nullable
        private String mPropertyPath = null;

        @Nullable
        private GenericDocument mDocument = null;

        @ExperimentalAppSearchApi
        @AbstractSafeParcelable.Constructor
        public TextMatchInfo(@AbstractSafeParcelable.Param(id = 1) int i, @AbstractSafeParcelable.Param(id = 2) int i6, @AbstractSafeParcelable.Param(id = 3) int i10, @AbstractSafeParcelable.Param(id = 4) int i11, @AbstractSafeParcelable.Param(id = 5) int i12, @AbstractSafeParcelable.Param(id = 6) int i13) {
            this.mExactMatchRangeStart = i;
            this.mExactMatchRangeEnd = i6;
            this.mSubmatchRangeStart = i10;
            this.mSubmatchRangeEnd = i11;
            this.mSnippetRangeStart = i12;
            this.mSnippetRangeEnd = i13;
        }

        private void checkSubmatchSupported() {
            if (this.mSubmatchRangeStart == -1) {
                throw new UnsupportedOperationException("Submatch is not supported with this backend/Android API level combination");
            }
        }

        private static String getPropertyValues(GenericDocument genericDocument, String str) {
            String propertyString = genericDocument.getPropertyString(str);
            if (propertyString != null) {
                return propertyString;
            }
            throw new IllegalStateException(B7.a.k("No content found for requested property path: ", str));
        }

        private CharSequence getSubstring(MatchRange matchRange) {
            return getFullText().substring(matchRange.getStart(), matchRange.getEnd());
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public CharSequence getExactMatch() {
            return getSubstring(getExactMatchRange());
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public MatchRange getExactMatchRange() {
            if (this.mExactMatchRangeCached == null) {
                this.mExactMatchRangeCached = new MatchRange(this.mExactMatchRangeStart, this.mExactMatchRangeEnd);
            }
            return this.mExactMatchRangeCached;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public String getFullText() {
            String str;
            if (this.mFullText == null) {
                GenericDocument genericDocument = this.mDocument;
                if (genericDocument == null || (str = this.mPropertyPath) == null) {
                    throw new IllegalStateException("Document or property path has not been populated; this TextMatchInfo cannot be used yet");
                }
                this.mFullText = getPropertyValues(genericDocument, str);
            }
            return this.mFullText;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public CharSequence getSnippet() {
            return getSubstring(getSnippetRange());
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public MatchRange getSnippetRange() {
            if (this.mWindowRangeCached == null) {
                this.mWindowRangeCached = new MatchRange(this.mSnippetRangeStart, this.mSnippetRangeEnd);
            }
            return this.mWindowRangeCached;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public CharSequence getSubmatch() {
            checkSubmatchSupported();
            return getSubstring(getSubmatchRange());
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public MatchRange getSubmatchRange() {
            checkSubmatchSupported();
            if (this.mSubmatchRangeCached == null) {
                this.mSubmatchRangeCached = new MatchRange(this.mSubmatchRangeStart, this.mSubmatchRangeEnd);
            }
            return this.mSubmatchRangeCached;
        }

        public void setDocument(@NonNull GenericDocument genericDocument) {
            this.mDocument = (GenericDocument) Preconditions.checkNotNull(genericDocument);
        }

        public void setPropertyPath(@NonNull String str) {
            this.mPropertyPath = (String) Preconditions.checkNotNull(str);
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }
    }

    @AbstractSafeParcelable.Constructor
    public SearchResult(@NonNull @AbstractSafeParcelable.Param(id = 1) GenericDocumentParcel genericDocumentParcel, @NonNull @AbstractSafeParcelable.Param(id = 2) List<MatchInfo> list, @NonNull @AbstractSafeParcelable.Param(id = 3) String str, @NonNull @AbstractSafeParcelable.Param(id = 4) String str2, @AbstractSafeParcelable.Param(id = 5) double d, @NonNull @AbstractSafeParcelable.Param(id = 6) List<SearchResult> list2, @Nullable @AbstractSafeParcelable.Param(id = 7) List<Double> list3, @Nullable @AbstractSafeParcelable.Param(id = 8) Bundle bundle) {
        this.mDocument = (GenericDocumentParcel) Preconditions.checkNotNull(genericDocumentParcel);
        this.mMatchInfos = (List) Preconditions.checkNotNull(list);
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        this.mRankingSignal = d;
        this.mJoinedResults = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2));
        if (list3 != null) {
            this.mInformationalRankingSignals = Collections.unmodifiableList(list3);
        } else {
            this.mInformationalRankingSignals = Collections.EMPTY_LIST;
        }
        if (bundle != null) {
            this.mParentTypeMap = bundle;
        } else {
            this.mParentTypeMap = Bundle.EMPTY;
        }
    }

    @NonNull
    public String getDatabaseName() {
        return this.mDatabaseName;
    }

    @NonNull
    public <T> T getDocument(@NonNull Class<T> cls) throws AppSearchException {
        return (T) getDocument(cls, null);
    }

    @NonNull
    public GenericDocument getGenericDocument() {
        if (this.mDocumentCached == null) {
            this.mDocumentCached = new GenericDocument(this.mDocument);
        }
        return this.mDocumentCached;
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
    public List<Double> getInformationalRankingSignals() {
        return this.mInformationalRankingSignals;
    }

    @NonNull
    public List<SearchResult> getJoinedResults() {
        return this.mJoinedResults;
    }

    @NonNull
    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public List<MatchInfo> getMatchInfos() {
        if (this.mMatchInfosCached == null) {
            this.mMatchInfosCached = new ArrayList(this.mMatchInfos.size());
            for (int i = 0; i < this.mMatchInfos.size(); i++) {
                MatchInfo matchInfo = this.mMatchInfos.get(i);
                matchInfo.setDocument(getGenericDocument());
                if (matchInfo.getTextMatch() != null) {
                    matchInfo.mTextMatch.setPropertyPath(matchInfo.getPropertyPath());
                }
                List<MatchInfo> list = this.mMatchInfosCached;
                if (list != null) {
                    list.add(matchInfo);
                }
            }
            this.mMatchInfosCached = Collections.unmodifiableList(this.mMatchInfosCached);
        }
        return (List) Preconditions.checkNotNull(this.mMatchInfosCached);
    }

    @NonNull
    public String getPackageName() {
        return this.mPackageName;
    }

    @NonNull
    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_RESULT_PARENT_TYPES)
    public Map<String, List<String>> getParentTypeMap() {
        Set<String> setKeySet = this.mParentTypeMap.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mParentTypeMap.getStringArrayList(str);
            if (stringArrayList != null) {
                arrayMap.put(str, stringArrayList);
            }
        }
        return arrayMap;
    }

    public double getRankingSignal() {
        return this.mRankingSignal;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @NonNull
    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public <T> T getDocument(@NonNull Class<T> cls, @Nullable Map<String, List<String>> map) throws AppSearchException {
        Preconditions.checkNotNull(cls);
        return (T) getGenericDocument().toDocumentClass(cls, new DocumentClassMappingContext(map, getParentTypeMap()));
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    @SafeParcelable.Class(creator = "MatchInfoCreator")
    public static final class MatchInfo extends AbstractSafeParcelable {

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Parcelable.Creator<MatchInfo> CREATOR = new StubCreators.MatchInfoCreator();

        @Nullable
        @AbstractSafeParcelable.Field(getter = "getEmbeddingMatch", id = 9)
        private final EmbeddingMatchInfo mEmbeddingMatch;

        @AbstractSafeParcelable.Field(id = 3)
        final int mExactMatchRangeEnd;

        @AbstractSafeParcelable.Field(id = 2)
        final int mExactMatchRangeStart;

        @AbstractSafeParcelable.Field(getter = "getPropertyPath", id = 1)
        private final String mPropertyPath;

        @AbstractSafeParcelable.Field(id = 7)
        final int mSnippetRangeEnd;

        @AbstractSafeParcelable.Field(id = 6)
        final int mSnippetRangeStart;

        @AbstractSafeParcelable.Field(id = 5)
        final int mSubmatchRangeEnd;

        @AbstractSafeParcelable.Field(id = 4)
        final int mSubmatchRangeStart;

        @Nullable
        @AbstractSafeParcelable.Field(getter = "getTextMatch", id = 8)
        private final TextMatchInfo mTextMatch;

        @Nullable
        private PropertyPath mPropertyPathObject = null;

        @Nullable
        private GenericDocument mDocument = null;

        @AbstractSafeParcelable.Constructor
        public MatchInfo(@NonNull @AbstractSafeParcelable.Param(id = 1) String str, @AbstractSafeParcelable.Param(id = 2) int i, @AbstractSafeParcelable.Param(id = 3) int i6, @AbstractSafeParcelable.Param(id = 4) int i10, @AbstractSafeParcelable.Param(id = 5) int i11, @AbstractSafeParcelable.Param(id = 6) int i12, @AbstractSafeParcelable.Param(id = 7) int i13, @Nullable @AbstractSafeParcelable.Param(id = 8) TextMatchInfo textMatchInfo, @Nullable @AbstractSafeParcelable.Param(id = 9) EmbeddingMatchInfo embeddingMatchInfo) {
            String str2 = (String) Preconditions.checkNotNull(str);
            this.mPropertyPath = str2;
            this.mExactMatchRangeStart = i;
            this.mExactMatchRangeEnd = i6;
            this.mSubmatchRangeStart = i10;
            this.mSubmatchRangeEnd = i11;
            this.mSnippetRangeStart = i12;
            this.mSnippetRangeEnd = i13;
            this.mEmbeddingMatch = embeddingMatchInfo;
            if (textMatchInfo == null && embeddingMatchInfo == null) {
                TextMatchInfo textMatchInfo2 = new TextMatchInfo(i, i6, i10, i11, i12, i13);
                textMatchInfo2.setPropertyPath(str2);
                textMatchInfo = textMatchInfo2;
            }
            this.mTextMatch = textMatchInfo;
        }

        @Nullable
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public EmbeddingMatchInfo getEmbeddingMatch() {
            return this.mEmbeddingMatch;
        }

        @NonNull
        public CharSequence getExactMatch() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? "" : textMatchInfo.getExactMatch();
        }

        @NonNull
        public MatchRange getExactMatchRange() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? new MatchRange(0, 0) : textMatchInfo.getExactMatchRange();
        }

        @NonNull
        public String getFullText() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? "" : textMatchInfo.getFullText();
        }

        @NonNull
        public String getPropertyPath() {
            return this.mPropertyPath;
        }

        @NonNull
        public PropertyPath getPropertyPathObject() {
            if (this.mPropertyPathObject == null) {
                this.mPropertyPathObject = new PropertyPath(this.mPropertyPath);
            }
            return this.mPropertyPathObject;
        }

        @NonNull
        public CharSequence getSnippet() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? "" : textMatchInfo.getSnippet();
        }

        @NonNull
        public MatchRange getSnippetRange() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? new MatchRange(0, 0) : textMatchInfo.getSnippetRange();
        }

        @NonNull
        public CharSequence getSubmatch() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? "" : textMatchInfo.getSubmatch();
        }

        @NonNull
        public MatchRange getSubmatchRange() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? new MatchRange(0, 0) : textMatchInfo.getSubmatchRange();
        }

        @Nullable
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        public TextMatchInfo getTextMatch() {
            return this.mTextMatch;
        }

        public void setDocument(@NonNull GenericDocument genericDocument) {
            this.mDocument = (GenericDocument) Preconditions.checkNotNull(genericDocument);
            TextMatchInfo textMatchInfo = this.mTextMatch;
            if (textMatchInfo != null) {
                textMatchInfo.setDocument(genericDocument);
            }
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }

        public static final class Builder {
            private EmbeddingMatchInfo mEmbeddingMatch;
            private MatchRange mExactMatchRange;
            private final String mPropertyPath;
            private MatchRange mSnippetRange;
            private MatchRange mSubmatchRange;

            public Builder(@NonNull String str) {
                this.mEmbeddingMatch = null;
                this.mExactMatchRange = new MatchRange(0, 0);
                this.mSubmatchRange = new MatchRange(-1, -1);
                this.mSnippetRange = new MatchRange(0, 0);
                this.mPropertyPath = (String) Preconditions.checkNotNull(str);
            }

            @NonNull
            public MatchInfo build() {
                TextMatchInfo textMatchInfo;
                if (this.mEmbeddingMatch == null) {
                    textMatchInfo = new TextMatchInfo(this.mExactMatchRange.getStart(), this.mExactMatchRange.getEnd(), this.mSubmatchRange.getStart(), this.mSubmatchRange.getEnd(), this.mSnippetRange.getStart(), this.mSnippetRange.getEnd());
                    textMatchInfo.setPropertyPath(this.mPropertyPath);
                } else {
                    textMatchInfo = null;
                }
                return new MatchInfo(this.mPropertyPath, this.mExactMatchRange.getStart(), this.mExactMatchRange.getEnd(), this.mSubmatchRange.getStart(), this.mSubmatchRange.getEnd(), this.mSnippetRange.getStart(), this.mSnippetRange.getEnd(), textMatchInfo, this.mEmbeddingMatch);
            }

            @NonNull
            @ExperimentalAppSearchApi
            @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
            @CanIgnoreReturnValue
            public Builder setEmbeddingMatch(@Nullable EmbeddingMatchInfo embeddingMatchInfo) {
                this.mEmbeddingMatch = embeddingMatchInfo;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setExactMatchRange(@NonNull MatchRange matchRange) {
                this.mExactMatchRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setSnippetRange(@NonNull MatchRange matchRange) {
                this.mSnippetRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setSubmatchRange(@NonNull MatchRange matchRange) {
                this.mSubmatchRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public Builder(@NonNull MatchInfo matchInfo) {
                this.mEmbeddingMatch = null;
                this.mExactMatchRange = new MatchRange(0, 0);
                this.mSubmatchRange = new MatchRange(-1, -1);
                this.mSnippetRange = new MatchRange(0, 0);
                Preconditions.checkNotNull(matchInfo);
                this.mPropertyPath = matchInfo.mPropertyPath;
                this.mEmbeddingMatch = matchInfo.getEmbeddingMatch();
                this.mExactMatchRange = matchInfo.getExactMatchRange();
                this.mSubmatchRange = new MatchRange(matchInfo.mSubmatchRangeStart, matchInfo.mSubmatchRangeEnd);
                this.mSnippetRange = matchInfo.getSnippetRange();
            }
        }
    }

    public static final class Builder {
        private boolean mBuilt;
        private final String mDatabaseName;
        private GenericDocument mGenericDocument;
        private List<Double> mInformationalRankingSignals;
        private List<SearchResult> mJoinedResults;
        private List<MatchInfo> mMatchInfos;
        private final String mPackageName;
        private Bundle mParentTypeMap;
        private double mRankingSignal;

        public Builder(@NonNull String str, @NonNull String str2) {
            this.mMatchInfos = new ArrayList();
            this.mInformationalRankingSignals = new ArrayList();
            this.mParentTypeMap = new Bundle();
            this.mJoinedResults = new ArrayList();
            this.mBuilt = false;
            this.mPackageName = (String) Preconditions.checkNotNull(str);
            this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mMatchInfos = new ArrayList(this.mMatchInfos);
                this.mJoinedResults = new ArrayList(this.mJoinedResults);
                this.mInformationalRankingSignals = new ArrayList(this.mInformationalRankingSignals);
                this.mParentTypeMap = BundleUtil.deepCopy(this.mParentTypeMap);
                this.mBuilt = false;
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
        public Builder addInformationalRankingSignal(double d) {
            resetIfBuilt();
            this.mInformationalRankingSignals.add(Double.valueOf(d));
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addJoinedResult(@NonNull SearchResult searchResult) {
            resetIfBuilt();
            this.mJoinedResults.add(searchResult);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addMatchInfo(@NonNull MatchInfo matchInfo) {
            Preconditions.checkState(matchInfo.mDocument == null, "This MatchInfo is already associated with a SearchResult and can't be reassigned");
            resetIfBuilt();
            this.mMatchInfos.add(matchInfo);
            return this;
        }

        @NonNull
        public SearchResult build() {
            this.mBuilt = true;
            return new SearchResult(this.mGenericDocument.getDocumentParcel(), this.mMatchInfos, this.mPackageName, this.mDatabaseName, this.mRankingSignal, this.mJoinedResults, this.mInformationalRankingSignals, this.mParentTypeMap);
        }

        @NonNull
        @CanIgnoreReturnValue
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder clearJoinedResults() {
            resetIfBuilt();
            this.mJoinedResults.clear();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder clearMatchInfos() {
            resetIfBuilt();
            this.mMatchInfos.clear();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setDocument(@NonNull Object obj) throws AppSearchException {
            Preconditions.checkNotNull(obj);
            resetIfBuilt();
            return setGenericDocument(GenericDocument.fromDocumentClass(obj));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setGenericDocument(@NonNull GenericDocument genericDocument) {
            Preconditions.checkNotNull(genericDocument);
            resetIfBuilt();
            this.mGenericDocument = genericDocument;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_RESULT_PARENT_TYPES)
        @CanIgnoreReturnValue
        public Builder setParentTypeMap(@NonNull Map<String, List<String>> map) {
            Preconditions.checkNotNull(map);
            resetIfBuilt();
            this.mParentTypeMap.clear();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                Preconditions.checkNotNull(entry.getKey());
                Preconditions.checkNotNull(entry.getValue());
                ArrayList<String> arrayList = new ArrayList<>(entry.getValue().size());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    arrayList.add((String) Preconditions.checkNotNull(entry.getValue().get(i)));
                }
                this.mParentTypeMap.putStringArrayList(entry.getKey(), arrayList);
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setRankingSignal(double d) {
            resetIfBuilt();
            this.mRankingSignal = d;
            return this;
        }

        @OptIn(markerClass = {ExperimentalAppSearchApi.class})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull SearchResult searchResult) {
            this.mMatchInfos = new ArrayList();
            this.mInformationalRankingSignals = new ArrayList();
            this.mParentTypeMap = new Bundle();
            this.mJoinedResults = new ArrayList();
            this.mBuilt = false;
            Preconditions.checkNotNull(searchResult);
            this.mPackageName = searchResult.getPackageName();
            this.mDatabaseName = searchResult.getDatabaseName();
            this.mGenericDocument = searchResult.getGenericDocument();
            this.mRankingSignal = searchResult.getRankingSignal();
            this.mInformationalRankingSignals = new ArrayList(searchResult.getInformationalRankingSignals());
            setParentTypeMap(searchResult.getParentTypeMap());
            List<MatchInfo> matchInfos = searchResult.getMatchInfos();
            for (int i = 0; i < matchInfos.size(); i++) {
                addMatchInfo(new MatchInfo.Builder(matchInfos.get(i)).build());
            }
            List<SearchResult> joinedResults = searchResult.getJoinedResults();
            for (int i6 = 0; i6 < joinedResults.size(); i6++) {
                addJoinedResult(joinedResults.get(i6));
            }
        }
    }
}
