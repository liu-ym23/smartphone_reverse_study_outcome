package androidx.appsearch.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.appsearch.util.BundleUtil;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@SafeParcelable.Class(creator = "SearchSpecCreator")
/* loaded from: classes.dex */
public final class SearchSpec extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchSpec> CREATOR = new StubCreators.SearchSpecCreator();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int DEFAULT_NUM_PER_PAGE = 10;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_COSINE = 1;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_DEFAULT = 0;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_DOT_PRODUCT = 2;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_EUCLIDEAN = 3;
    public static final int GROUPING_TYPE_PER_NAMESPACE = 2;
    public static final int GROUPING_TYPE_PER_PACKAGE = 1;

    @FlaggedApi(Flags.FLAG_ENABLE_GROUPING_TYPE_PER_SCHEMA)
    public static final int GROUPING_TYPE_PER_SCHEMA = 4;
    private static final int MAX_NUM_PER_PAGE = 10000;
    private static final int MAX_SNIPPET_COUNT = 10000;
    private static final int MAX_SNIPPET_PER_PROPERTY_COUNT = 10000;
    private static final int MAX_SNIPPET_SIZE_LIMIT = 10000;
    public static final int ORDER_ASCENDING = 1;
    public static final int ORDER_DESCENDING = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static final String PROJECTION_SCHEMA_TYPE_WILDCARD = "*";
    public static final int RANKING_STRATEGY_ADVANCED_RANKING_EXPRESSION = 9;
    public static final int RANKING_STRATEGY_CREATION_TIMESTAMP = 2;
    public static final int RANKING_STRATEGY_DOCUMENT_SCORE = 1;
    public static final int RANKING_STRATEGY_JOIN_AGGREGATE_SCORE = 8;
    public static final int RANKING_STRATEGY_NONE = 0;
    public static final int RANKING_STRATEGY_RELEVANCE_SCORE = 3;
    public static final int RANKING_STRATEGY_SYSTEM_USAGE_COUNT = 6;
    public static final int RANKING_STRATEGY_SYSTEM_USAGE_LAST_USED_TIMESTAMP = 7;
    public static final int RANKING_STRATEGY_USAGE_COUNT = 4;
    public static final int RANKING_STRATEGY_USAGE_LAST_USED_TIMESTAMP = 5;

    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
    public static final String SCHEMA_TYPE_WILDCARD = "*";
    public static final int TERM_MATCH_EXACT_ONLY = 1;
    public static final int TERM_MATCH_PREFIX = 2;

    @AbstractSafeParcelable.Field(getter = "getAdvancedRankingExpression", id = 17)
    private final String mAdvancedRankingExpression;

    @AbstractSafeParcelable.Field(getter = "getDefaultEmbeddingSearchMetricType", id = 21)
    private final int mDefaultEmbeddingSearchMetricType;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getEmbeddingParameters", id = 20)
    private final List<EmbeddingVector> mEmbeddingParameters;

    @AbstractSafeParcelable.Field(getter = "getEnabledFeatures", id = 18)
    private final List<String> mEnabledFeatures;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getFilterDocumentIds", id = 24)
    private final List<String> mFilterDocumentIds;

    @AbstractSafeParcelable.Field(getter = "getResultGroupingLimit", id = 14)
    private final int mGroupingLimit;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getInformationalRankingExpressions", id = 22)
    private final List<String> mInformationalRankingExpressions;

    @Nullable
    @AbstractSafeParcelable.Field(getter = "getJoinSpec", id = 16)
    private final JoinSpec mJoinSpec;

    @AbstractSafeParcelable.Field(getter = "getMaxSnippetSize", id = 11)
    private final int mMaxSnippetSize;

    @AbstractSafeParcelable.Field(getter = "getFilterNamespaces", id = 3)
    private final List<String> mNamespaces;

    @AbstractSafeParcelable.Field(getter = "getOrder", id = 8)
    private final int mOrder;

    @AbstractSafeParcelable.Field(getter = "getFilterPackageNames", id = 5)
    private final List<String> mPackageNames;

    @AbstractSafeParcelable.Field(id = 12)
    final Bundle mProjectionTypePropertyMasks;

    @AbstractSafeParcelable.Field(getter = "getRankingStrategy", id = 7)
    private final int mRankingStrategy;

    @AbstractSafeParcelable.Field(getter = "getResultCountPerPage", id = 6)
    private final int mResultCountPerPage;

    @AbstractSafeParcelable.Field(getter = "getResultGroupingTypeFlags", id = 13)
    private final int mResultGroupingTypeFlags;

    @AbstractSafeParcelable.Field(getter = "shouldRetrieveEmbeddingMatchInfos", id = 25)
    private final boolean mRetrieveEmbeddingMatchInfos;

    @AbstractSafeParcelable.Field(getter = "getFilterSchemas", id = 2)
    private final List<String> mSchemas;

    @Nullable
    @AbstractSafeParcelable.Field(getter = "getSearchSourceLogTag", id = 19)
    private final String mSearchSourceLogTag;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getSearchStringParameters", id = 23)
    private final List<String> mSearchStringParameters;

    @AbstractSafeParcelable.Field(getter = "getSnippetCount", id = 9)
    private final int mSnippetCount;

    @AbstractSafeParcelable.Field(getter = "getSnippetCountPerProperty", id = 10)
    private final int mSnippetCountPerProperty;

    @AbstractSafeParcelable.Field(getter = "getTermMatch", id = 1)
    private final int mTermMatchType;

    @AbstractSafeParcelable.Field(id = 4)
    final Bundle mTypePropertyFilters;

    @AbstractSafeParcelable.Field(id = 15)
    final Bundle mTypePropertyWeightsField;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface EmbeddingSearchMetricType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface GroupingType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Order {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RankingStrategy {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface TermMatch {
    }

    @AbstractSafeParcelable.Constructor
    public SearchSpec(@AbstractSafeParcelable.Param(id = 1) int i, @NonNull @AbstractSafeParcelable.Param(id = 2) List<String> list, @NonNull @AbstractSafeParcelable.Param(id = 3) List<String> list2, @NonNull @AbstractSafeParcelable.Param(id = 4) Bundle bundle, @NonNull @AbstractSafeParcelable.Param(id = 5) List<String> list3, @AbstractSafeParcelable.Param(id = 6) int i6, @AbstractSafeParcelable.Param(id = 7) int i10, @AbstractSafeParcelable.Param(id = 8) int i11, @AbstractSafeParcelable.Param(id = 9) int i12, @AbstractSafeParcelable.Param(id = 10) int i13, @AbstractSafeParcelable.Param(id = 11) int i14, @NonNull @AbstractSafeParcelable.Param(id = 12) Bundle bundle2, @AbstractSafeParcelable.Param(id = 13) int i15, @AbstractSafeParcelable.Param(id = 14) int i16, @NonNull @AbstractSafeParcelable.Param(id = 15) Bundle bundle3, @Nullable @AbstractSafeParcelable.Param(id = 16) JoinSpec joinSpec, @NonNull @AbstractSafeParcelable.Param(id = 17) String str, @NonNull @AbstractSafeParcelable.Param(id = 18) List<String> list4, @Nullable @AbstractSafeParcelable.Param(id = 19) String str2, @Nullable @AbstractSafeParcelable.Param(id = 20) List<EmbeddingVector> list5, @AbstractSafeParcelable.Param(id = 21) int i17, @Nullable @AbstractSafeParcelable.Param(id = 22) List<String> list6, @Nullable @AbstractSafeParcelable.Param(id = 23) List<String> list7, @Nullable @AbstractSafeParcelable.Param(id = 24) List<String> list8, @AbstractSafeParcelable.Param(id = 25) boolean z10) {
        this.mTermMatchType = i;
        this.mSchemas = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
        this.mNamespaces = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2));
        this.mTypePropertyFilters = (Bundle) Preconditions.checkNotNull(bundle);
        this.mPackageNames = Collections.unmodifiableList((List) Preconditions.checkNotNull(list3));
        this.mResultCountPerPage = i6;
        this.mRankingStrategy = i10;
        this.mOrder = i11;
        this.mSnippetCount = i12;
        this.mSnippetCountPerProperty = i13;
        this.mMaxSnippetSize = i14;
        this.mProjectionTypePropertyMasks = (Bundle) Preconditions.checkNotNull(bundle2);
        this.mResultGroupingTypeFlags = i15;
        this.mGroupingLimit = i16;
        this.mTypePropertyWeightsField = (Bundle) Preconditions.checkNotNull(bundle3);
        this.mJoinSpec = joinSpec;
        this.mAdvancedRankingExpression = (String) Preconditions.checkNotNull(str);
        this.mEnabledFeatures = Collections.unmodifiableList((List) Preconditions.checkNotNull(list4));
        this.mSearchSourceLogTag = str2;
        if (list5 != null) {
            this.mEmbeddingParameters = Collections.unmodifiableList(list5);
        } else {
            this.mEmbeddingParameters = Collections.EMPTY_LIST;
        }
        this.mDefaultEmbeddingSearchMetricType = i17;
        if (list6 != null) {
            this.mInformationalRankingExpressions = Collections.unmodifiableList(list6);
        } else {
            this.mInformationalRankingExpressions = Collections.EMPTY_LIST;
        }
        this.mSearchStringParameters = list7 != null ? Collections.unmodifiableList(list7) : Collections.EMPTY_LIST;
        this.mFilterDocumentIds = list8 != null ? Collections.unmodifiableList(list8) : Collections.EMPTY_LIST;
        this.mRetrieveEmbeddingMatchInfos = z10;
    }

    @NonNull
    public String getAdvancedRankingExpression() {
        return this.mAdvancedRankingExpression;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public int getDefaultEmbeddingSearchMetricType() {
        return this.mDefaultEmbeddingSearchMetricType;
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public List<EmbeddingVector> getEmbeddingParameters() {
        return this.mEmbeddingParameters;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<String> getEnabledFeatures() {
        return this.mEnabledFeatures;
    }

    @NonNull
    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_DOCUMENT_IDS)
    public List<String> getFilterDocumentIds() {
        return this.mFilterDocumentIds;
    }

    @NonNull
    public List<String> getFilterNamespaces() {
        List<String> list = this.mNamespaces;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @NonNull
    public List<String> getFilterPackageNames() {
        List<String> list = this.mPackageNames;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
    public Map<String, List<String>> getFilterProperties() {
        Set<String> setKeySet = this.mTypePropertyFilters.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            arrayMap.put(str, (List) Preconditions.checkNotNull(this.mTypePropertyFilters.getStringArrayList(str)));
        }
        return arrayMap;
    }

    @NonNull
    public List<String> getFilterSchemas() {
        List<String> list = this.mSchemas;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
    public List<String> getInformationalRankingExpressions() {
        return this.mInformationalRankingExpressions;
    }

    @Nullable
    public JoinSpec getJoinSpec() {
        return this.mJoinSpec;
    }

    public int getMaxSnippetSize() {
        return this.mMaxSnippetSize;
    }

    public int getOrder() {
        return this.mOrder;
    }

    @NonNull
    public Map<String, List<PropertyPath>> getProjectionPaths() {
        Set<String> setKeySet = this.mProjectionTypePropertyMasks.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mProjectionTypePropertyMasks.getStringArrayList(str);
            if (stringArrayList != null) {
                ArrayList arrayList = new ArrayList(stringArrayList.size());
                for (int i = 0; i < stringArrayList.size(); i++) {
                    arrayList.add(new PropertyPath(stringArrayList.get(i)));
                }
                arrayMap.put(str, arrayList);
            }
        }
        return arrayMap;
    }

    @NonNull
    public Map<String, List<String>> getProjections() {
        Set<String> setKeySet = this.mProjectionTypePropertyMasks.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mProjectionTypePropertyMasks.getStringArrayList(str);
            Objects.requireNonNull(stringArrayList);
            arrayMap.put(str, stringArrayList);
        }
        return arrayMap;
    }

    @NonNull
    public Map<String, Map<PropertyPath, Double>> getPropertyWeightPaths() {
        Set<String> setKeySet = this.mTypePropertyWeightsField.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            Bundle bundle = this.mTypePropertyWeightsField.getBundle(str);
            if (bundle != null) {
                Set<String> setKeySet2 = bundle.keySet();
                ArrayMap arrayMap2 = new ArrayMap(setKeySet2.size());
                for (String str2 : setKeySet2) {
                    arrayMap2.put(new PropertyPath(str2), Double.valueOf(bundle.getDouble(str2)));
                }
                arrayMap.put(str, arrayMap2);
            }
        }
        return arrayMap;
    }

    @NonNull
    public Map<String, Map<String, Double>> getPropertyWeights() {
        Set<String> setKeySet = this.mTypePropertyWeightsField.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            Bundle bundle = this.mTypePropertyWeightsField.getBundle(str);
            if (bundle != null) {
                Set<String> setKeySet2 = bundle.keySet();
                ArrayMap arrayMap2 = new ArrayMap(setKeySet2.size());
                for (String str2 : setKeySet2) {
                    arrayMap2.put(str2, Double.valueOf(bundle.getDouble(str2)));
                }
                arrayMap.put(str, arrayMap2);
            }
        }
        return arrayMap;
    }

    public int getRankingStrategy() {
        return this.mRankingStrategy;
    }

    public int getResultCountPerPage() {
        return this.mResultCountPerPage;
    }

    public int getResultGroupingLimit() {
        return this.mGroupingLimit;
    }

    public int getResultGroupingTypeFlags() {
        return this.mResultGroupingTypeFlags;
    }

    @Nullable
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG)
    public String getSearchSourceLogTag() {
        return this.mSearchSourceLogTag;
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
    public List<String> getSearchStringParameters() {
        return this.mSearchStringParameters;
    }

    public int getSnippetCount() {
        return this.mSnippetCount;
    }

    public int getSnippetCountPerProperty() {
        return this.mSnippetCountPerProperty;
    }

    public int getTermMatch() {
        return this.mTermMatchType;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_HAS_PROPERTY_FUNCTION)
    public boolean isListFilterHasPropertyFunctionEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_HAS_PROPERTY_FUNCTION");
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION)
    public boolean isListFilterMatchScoreExpressionFunctionEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION");
    }

    public boolean isListFilterQueryLanguageEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_QUERY_LANGUAGE");
    }

    public boolean isNumericSearchEnabled() {
        return this.mEnabledFeatures.contains("NUMERIC_SEARCH");
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_SCORABLE_PROPERTY)
    public boolean isScorablePropertyRankingEnabled() {
        return this.mEnabledFeatures.contains("SCHEMA_SCORABLE_PROPERTY_CONFIG");
    }

    public boolean isVerbatimSearchEnabled() {
        return this.mEnabledFeatures.contains("VERBATIM_SEARCH");
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
    public boolean shouldRetrieveEmbeddingMatchInfos() {
        return this.mRetrieveEmbeddingMatchInfos;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    public static final class Builder {
        private String mAdvancedRankingExpression;
        private boolean mBuilt;
        private int mDefaultEmbeddingSearchMetricType;
        private List<EmbeddingVector> mEmbeddingParameters;
        private ArraySet<String> mEnabledFeatures;
        private List<String> mFilterDocumentIds;
        private int mGroupingLimit;
        private int mGroupingTypeFlags;
        private List<String> mInformationalRankingExpressions;

        @Nullable
        private JoinSpec mJoinSpec;
        private int mMaxSnippetSize;
        private List<String> mNamespaces;
        private int mOrder;
        private List<String> mPackageNames;
        private Bundle mProjectionTypePropertyMasks;
        private int mRankingStrategy;
        private int mResultCountPerPage;
        private boolean mRetrieveEmbeddingMatchInfos;
        private List<String> mSchemas;

        @Nullable
        private String mSearchSourceLogTag;
        private List<String> mSearchStringParameters;
        private int mSnippetCount;
        private int mSnippetCountPerProperty;
        private int mTermMatchType;
        private Bundle mTypePropertyFilters;
        private Bundle mTypePropertyWeights;

        public Builder() {
            this.mSchemas = new ArrayList();
            this.mNamespaces = new ArrayList();
            this.mTypePropertyFilters = new Bundle();
            this.mPackageNames = new ArrayList();
            this.mEnabledFeatures = new ArraySet<>();
            this.mProjectionTypePropertyMasks = new Bundle();
            this.mTypePropertyWeights = new Bundle();
            this.mEmbeddingParameters = new ArrayList();
            this.mSearchStringParameters = new ArrayList();
            this.mFilterDocumentIds = new ArrayList();
            this.mResultCountPerPage = 10;
            this.mTermMatchType = 2;
            this.mDefaultEmbeddingSearchMetricType = 1;
            this.mSnippetCount = 0;
            this.mSnippetCountPerProperty = 10000;
            this.mMaxSnippetSize = 0;
            this.mRankingStrategy = 0;
            this.mOrder = 0;
            this.mGroupingTypeFlags = 0;
            this.mGroupingLimit = 0;
            this.mAdvancedRankingExpression = "";
            this.mInformationalRankingExpressions = new ArrayList();
            this.mRetrieveEmbeddingMatchInfos = false;
            this.mBuilt = false;
        }

        private void modifyEnabledFeature(@NonNull String str, boolean z10) {
            resetIfBuilt();
            if (z10) {
                this.mEnabledFeatures.add(str);
            } else {
                this.mEnabledFeatures.remove(str);
            }
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mSchemas = new ArrayList(this.mSchemas);
                this.mTypePropertyFilters = BundleUtil.deepCopy(this.mTypePropertyFilters);
                this.mNamespaces = new ArrayList(this.mNamespaces);
                this.mPackageNames = new ArrayList(this.mPackageNames);
                this.mProjectionTypePropertyMasks = BundleUtil.deepCopy(this.mProjectionTypePropertyMasks);
                this.mTypePropertyWeights = BundleUtil.deepCopy(this.mTypePropertyWeights);
                this.mEmbeddingParameters = new ArrayList(this.mEmbeddingParameters);
                this.mInformationalRankingExpressions = new ArrayList(this.mInformationalRankingExpressions);
                this.mSearchStringParameters = new ArrayList(this.mSearchStringParameters);
                this.mFilterDocumentIds = new ArrayList(this.mFilterDocumentIds);
                this.mBuilt = false;
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
        public Builder addEmbeddingParameters(@NonNull EmbeddingVector... embeddingVectorArr) {
            Preconditions.checkNotNull(embeddingVectorArr);
            resetIfBuilt();
            return addEmbeddingParameters(Arrays.asList(embeddingVectorArr));
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addFilterDocumentClasses(@NonNull Collection<? extends Class<?>> collection) throws AppSearchException {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            DocumentClassFactoryRegistry documentClassFactoryRegistry = DocumentClassFactoryRegistry.getInstance();
            Iterator<? extends Class<?>> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(documentClassFactoryRegistry.getOrCreateFactory((Class) it.next()).getSchemaName());
            }
            addFilterSchemas(arrayList);
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_DOCUMENT_IDS)
        @CanIgnoreReturnValue
        public Builder addFilterDocumentIds(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterDocumentIds(Arrays.asList(strArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterNamespaces(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterNamespaces(Arrays.asList(strArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterPackageNames(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterPackageNames(Arrays.asList(strArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
        public Builder addFilterProperties(@NonNull String str, @NonNull Collection<String> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList<String> arrayList = new ArrayList<>(collection.size());
            for (String str2 : collection) {
                Preconditions.checkNotNull(str2);
                arrayList.add(str2);
            }
            this.mTypePropertyFilters.putStringArrayList(str, arrayList);
            return this;
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterPropertyPaths(@NonNull String str, @NonNull Collection<PropertyPath> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<PropertyPath> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            return addFilterProperties(str, arrayList);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterSchemas(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterSchemas(Arrays.asList(strArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
        public Builder addInformationalRankingExpressions(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addInformationalRankingExpressions(Arrays.asList(strArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addProjection(@NonNull String str, @NonNull Collection<String> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList<String> arrayList = new ArrayList<>(collection.size());
            for (String str2 : collection) {
                Preconditions.checkNotNull(str2);
                arrayList.add(str2);
            }
            this.mProjectionTypePropertyMasks.putStringArrayList(str, arrayList);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addProjectionPaths(@NonNull String str, @NonNull Collection<PropertyPath> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<PropertyPath> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            return addProjection(str, arrayList);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addProjectionPathsForDocumentClass(@NonNull Class<?> cls, @NonNull Collection<PropertyPath> collection) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<PropertyPath> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            return addProjectionsForDocumentClass(cls, arrayList);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addProjectionsForDocumentClass(@NonNull Class<?> cls, @NonNull Collection<String> collection) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return addProjection(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
        public Builder addSearchStringParameters(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addSearchStringParameters(Arrays.asList(strArr));
        }

        @NonNull
        public SearchSpec build() {
            int i;
            JoinSpec joinSpec = this.mJoinSpec;
            if (joinSpec != null) {
                if (this.mRankingStrategy != 8 && joinSpec.getAggregationScoringStrategy() != 0) {
                    throw new IllegalStateException("Aggregate scoring strategy has been set in the nested JoinSpec, but ranking strategy is not RANKING_STRATEGY_JOIN_AGGREGATE_SCORE");
                }
            } else if (this.mRankingStrategy == 8) {
                throw new IllegalStateException("Attempting to rank based on joined documents, but no JoinSpec provided");
            }
            if (!this.mTypePropertyWeights.isEmpty() && (i = this.mRankingStrategy) != 3 && i != 9) {
                throw new IllegalArgumentException("Property weights are only compatible with the RANKING_STRATEGY_RELEVANCE_SCORE and RANKING_STRATEGY_ADVANCED_RANKING_EXPRESSION ranking strategies.");
            }
            this.mBuilt = true;
            return new SearchSpec(this.mTermMatchType, this.mSchemas, this.mNamespaces, this.mTypePropertyFilters, this.mPackageNames, this.mResultCountPerPage, this.mRankingStrategy, this.mOrder, this.mSnippetCount, this.mSnippetCountPerProperty, this.mMaxSnippetSize, this.mProjectionTypePropertyMasks, this.mGroupingTypeFlags, this.mGroupingLimit, this.mTypePropertyWeights, this.mJoinSpec, this.mAdvancedRankingExpression, new ArrayList(this.mEnabledFeatures), this.mSearchSourceLogTag, this.mEmbeddingParameters, this.mDefaultEmbeddingSearchMetricType, this.mInformationalRankingExpressions, this.mSearchStringParameters, this.mFilterDocumentIds, this.mRetrieveEmbeddingMatchInfos);
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearEmbeddingParameters() {
            resetIfBuilt();
            this.mEmbeddingParameters.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearFilterDocumentIds() {
            resetIfBuilt();
            this.mFilterDocumentIds.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearFilterNamespaces() {
            resetIfBuilt();
            this.mNamespaces.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearFilterPackageNames() {
            resetIfBuilt();
            this.mPackageNames.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearFilterProperties() {
            resetIfBuilt();
            this.mTypePropertyFilters.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearFilterSchemas() {
            resetIfBuilt();
            this.mSchemas.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearInformationalRankingExpressions() {
            resetIfBuilt();
            this.mInformationalRankingExpressions.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearJoinSpec() {
            resetIfBuilt();
            this.mJoinSpec = null;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearProjections() {
            resetIfBuilt();
            this.mProjectionTypePropertyMasks.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearPropertyWeights() {
            resetIfBuilt();
            this.mTypePropertyWeights.clear();
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearResultGrouping() {
            resetIfBuilt();
            this.mGroupingTypeFlags = 0;
            this.mGroupingLimit = 0;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearSearchSourceLogTag() {
            resetIfBuilt();
            this.mSearchSourceLogTag = null;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        @CanIgnoreReturnValue
        public Builder clearSearchStringParameters() {
            resetIfBuilt();
            this.mSearchStringParameters.clear();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
        public Builder setDefaultEmbeddingSearchMetricType(int i) {
            Preconditions.checkArgumentInRange(i, 1, 3, "Embedding search metric type");
            resetIfBuilt();
            this.mDefaultEmbeddingSearchMetricType = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setJoinSpec(@NonNull JoinSpec joinSpec) {
            resetIfBuilt();
            this.mJoinSpec = (JoinSpec) Preconditions.checkNotNull(joinSpec);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_HAS_PROPERTY_FUNCTION)
        public Builder setListFilterHasPropertyFunctionEnabled(boolean z10) {
            modifyEnabledFeature("LIST_FILTER_HAS_PROPERTY_FUNCTION", z10);
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION)
        @CanIgnoreReturnValue
        public Builder setListFilterMatchScoreExpressionFunctionEnabled(boolean z10) {
            modifyEnabledFeature("LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION", z10);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setListFilterQueryLanguageEnabled(boolean z10) {
            modifyEnabledFeature("LIST_FILTER_QUERY_LANGUAGE", z10);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setMaxSnippetSize(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "maxSnippetSize");
            resetIfBuilt();
            this.mMaxSnippetSize = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setNumericSearchEnabled(boolean z10) {
            modifyEnabledFeature("NUMERIC_SEARCH", z10);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setOrder(int i) {
            Preconditions.checkArgumentInRange(i, 0, 1, "Result ranking order");
            resetIfBuilt();
            this.mOrder = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setPropertyWeightPaths(@NonNull String str, @NonNull Map<PropertyPath, Double> map) {
            Preconditions.checkNotNull(map);
            ArrayMap arrayMap = new ArrayMap(map.size());
            for (Map.Entry<PropertyPath, Double> entry : map.entrySet()) {
                arrayMap.put(((PropertyPath) Preconditions.checkNotNull(entry.getKey())).toString(), entry.getValue());
            }
            return setPropertyWeights(str, arrayMap);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setPropertyWeightPathsForDocumentClass(@NonNull Class<?> cls, @NonNull Map<PropertyPath, Double> map) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            return setPropertyWeightPaths(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), map);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setPropertyWeights(@NonNull String str, @NonNull Map<String, Double> map) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(map);
            Bundle bundle = new Bundle();
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                String str2 = (String) Preconditions.checkNotNull(entry.getKey());
                Double d = (Double) Preconditions.checkNotNull(entry.getValue());
                if (d.doubleValue() <= 0.0d) {
                    throw new IllegalArgumentException("Cannot set non-positive property weight value " + d + " for property path: " + str2);
                }
                bundle.putDouble(str2, d.doubleValue());
            }
            this.mTypePropertyWeights.putBundle(str, bundle);
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setPropertyWeightsForDocumentClass(@NonNull Class<?> cls, @NonNull Map<String, Double> map) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            return setPropertyWeights(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), map);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setRankingStrategy(int i) {
            Preconditions.checkArgumentInRange(i, 0, 8, "Result ranking strategy");
            resetIfBuilt();
            this.mRankingStrategy = i;
            this.mAdvancedRankingExpression = "";
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setResultCountPerPage(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "resultCountPerPage");
            resetIfBuilt();
            this.mResultCountPerPage = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setResultGrouping(int i, int i6) {
            Preconditions.checkState(i != 0, "Result grouping type cannot be zero.");
            resetIfBuilt();
            this.mGroupingTypeFlags = i;
            this.mGroupingLimit = i6;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_EMBEDDING_MATCH_INFO)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder setRetrieveEmbeddingMatchInfos(boolean z10) {
            resetIfBuilt();
            this.mRetrieveEmbeddingMatchInfos = z10;
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SCORABLE_PROPERTY)
        @CanIgnoreReturnValue
        public Builder setScorablePropertyRankingEnabled(boolean z10) {
            modifyEnabledFeature("SCHEMA_SCORABLE_PROPERTY_CONFIG", z10);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG)
        public Builder setSearchSourceLogTag(@NonNull String str) {
            Preconditions.checkStringNotEmpty(str);
            Preconditions.checkArgument(str.length() <= 100, "The maximum supported tag length is 100. This tag is too long: " + str.length());
            resetIfBuilt();
            this.mSearchSourceLogTag = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setSnippetCount(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "snippetCount");
            resetIfBuilt();
            this.mSnippetCount = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setSnippetCountPerProperty(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "snippetCountPerProperty");
            resetIfBuilt();
            this.mSnippetCountPerProperty = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setTermMatch(int i) {
            Preconditions.checkArgumentInRange(i, 1, 2, "Term match type");
            resetIfBuilt();
            this.mTermMatchType = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setVerbatimSearchEnabled(boolean z10) {
            modifyEnabledFeature("VERBATIM_SEARCH", z10);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
        public Builder addEmbeddingParameters(@NonNull Collection<EmbeddingVector> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mEmbeddingParameters.addAll(collection);
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_DOCUMENT_IDS)
        @CanIgnoreReturnValue
        public Builder addFilterDocumentIds(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mFilterDocumentIds.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterNamespaces(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mNamespaces.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterPackageNames(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mPackageNames.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterSchemas(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mSchemas.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
        public Builder addSearchStringParameters(@NonNull List<String> list) {
            Preconditions.checkNotNull(list);
            resetIfBuilt();
            this.mSearchStringParameters.addAll(list);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
        public Builder addInformationalRankingExpressions(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mInformationalRankingExpressions.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setRankingStrategy(@NonNull String str) {
            Preconditions.checkStringNotEmpty(str);
            resetIfBuilt();
            this.mRankingStrategy = 9;
            this.mAdvancedRankingExpression = str;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterPropertyPaths(@NonNull Class<?> cls, @NonNull Collection<PropertyPath> collection) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            return addFilterPropertyPaths(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addFilterDocumentClasses(@NonNull Class<?>... clsArr) throws AppSearchException {
            Preconditions.checkNotNull(clsArr);
            resetIfBuilt();
            return addFilterDocumentClasses(Arrays.asList(clsArr));
        }

        @NonNull
        public Builder addFilterProperties(@NonNull Class<?> cls, @NonNull Collection<String> collection) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            return addFilterProperties(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }

        @OptIn(markerClass = {ExperimentalAppSearchApi.class})
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder(@NonNull SearchSpec searchSpec) {
            this.mSchemas = new ArrayList();
            this.mNamespaces = new ArrayList();
            this.mTypePropertyFilters = new Bundle();
            this.mPackageNames = new ArrayList();
            this.mEnabledFeatures = new ArraySet<>();
            this.mProjectionTypePropertyMasks = new Bundle();
            this.mTypePropertyWeights = new Bundle();
            this.mEmbeddingParameters = new ArrayList();
            this.mSearchStringParameters = new ArrayList();
            this.mFilterDocumentIds = new ArrayList();
            this.mResultCountPerPage = 10;
            this.mTermMatchType = 2;
            this.mDefaultEmbeddingSearchMetricType = 1;
            this.mSnippetCount = 0;
            this.mSnippetCountPerProperty = 10000;
            this.mMaxSnippetSize = 0;
            this.mRankingStrategy = 0;
            this.mOrder = 0;
            this.mGroupingTypeFlags = 0;
            this.mGroupingLimit = 0;
            this.mAdvancedRankingExpression = "";
            this.mInformationalRankingExpressions = new ArrayList();
            this.mRetrieveEmbeddingMatchInfos = false;
            this.mBuilt = false;
            Objects.requireNonNull(searchSpec);
            this.mSchemas = new ArrayList(searchSpec.getFilterSchemas());
            this.mNamespaces = new ArrayList(searchSpec.getFilterNamespaces());
            for (Map.Entry<String, List<String>> entry : searchSpec.getFilterProperties().entrySet()) {
                addFilterProperties(entry.getKey(), entry.getValue());
            }
            this.mPackageNames = new ArrayList(searchSpec.getFilterPackageNames());
            this.mEnabledFeatures = new ArraySet<>(searchSpec.getEnabledFeatures());
            for (Map.Entry<String, List<String>> entry2 : searchSpec.getProjections().entrySet()) {
                addProjection(entry2.getKey(), entry2.getValue());
            }
            for (Map.Entry<String, Map<String, Double>> entry3 : searchSpec.getPropertyWeights().entrySet()) {
                setPropertyWeights(entry3.getKey(), entry3.getValue());
            }
            this.mEmbeddingParameters = new ArrayList(searchSpec.getEmbeddingParameters());
            this.mSearchStringParameters = new ArrayList(searchSpec.getSearchStringParameters());
            this.mResultCountPerPage = searchSpec.getResultCountPerPage();
            this.mTermMatchType = searchSpec.getTermMatch();
            this.mDefaultEmbeddingSearchMetricType = searchSpec.getDefaultEmbeddingSearchMetricType();
            this.mSnippetCount = searchSpec.getSnippetCount();
            this.mSnippetCountPerProperty = searchSpec.getSnippetCountPerProperty();
            this.mMaxSnippetSize = searchSpec.getMaxSnippetSize();
            this.mRankingStrategy = searchSpec.getRankingStrategy();
            this.mOrder = searchSpec.getOrder();
            this.mGroupingTypeFlags = searchSpec.getResultGroupingTypeFlags();
            this.mGroupingLimit = searchSpec.getResultGroupingLimit();
            this.mJoinSpec = searchSpec.getJoinSpec();
            this.mAdvancedRankingExpression = searchSpec.getAdvancedRankingExpression();
            this.mInformationalRankingExpressions = new ArrayList(searchSpec.getInformationalRankingExpressions());
            this.mSearchSourceLogTag = searchSpec.getSearchSourceLogTag();
            this.mFilterDocumentIds = new ArrayList(searchSpec.getFilterDocumentIds());
            this.mRetrieveEmbeddingMatchInfos = searchSpec.shouldRetrieveEmbeddingMatchInfos();
        }
    }
}
