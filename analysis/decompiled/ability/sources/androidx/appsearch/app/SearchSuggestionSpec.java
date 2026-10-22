package androidx.appsearch.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "SearchSuggestionSpecCreator")
/* loaded from: classes.dex */
public final class SearchSuggestionSpec extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchSuggestionSpec> CREATOR = new StubCreators.SearchSuggestionSpecCreator();
    public static final int SUGGESTION_RANKING_STRATEGY_DOCUMENT_COUNT = 0;
    public static final int SUGGESTION_RANKING_STRATEGY_NONE = 2;
    public static final int SUGGESTION_RANKING_STRATEGY_TERM_FREQUENCY = 1;

    @NonNull
    @AbstractSafeParcelable.Field(id = 4)
    final Bundle mFilterDocumentIds;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getFilterNamespaces", id = 1)
    private final List<String> mFilterNamespaces;

    @NonNull
    @AbstractSafeParcelable.Field(id = 3)
    final Bundle mFilterProperties;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getFilterSchemas", id = 2)
    private final List<String> mFilterSchemas;

    @AbstractSafeParcelable.Field(getter = "getMaximumResultCount", id = 6)
    private final int mMaximumResultCount;

    @AbstractSafeParcelable.Field(getter = "getRankingStrategy", id = 5)
    private final int mRankingStrategy;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getSearchStringParameters", id = 7)
    private final List<String> mSearchStringParameters;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SuggestionRankingStrategy {
    }

    @AbstractSafeParcelable.Constructor
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SearchSuggestionSpec(@NonNull @AbstractSafeParcelable.Param(id = 1) List<String> list, @NonNull @AbstractSafeParcelable.Param(id = 2) List<String> list2, @NonNull @AbstractSafeParcelable.Param(id = 3) Bundle bundle, @NonNull @AbstractSafeParcelable.Param(id = 4) Bundle bundle2, @AbstractSafeParcelable.Param(id = 5) int i, @AbstractSafeParcelable.Param(id = 6) int i6, @Nullable @AbstractSafeParcelable.Param(id = 7) List<String> list3) {
        Preconditions.checkArgument(i6 >= 1, "MaximumResultCount must be positive.");
        this.mFilterNamespaces = (List) Preconditions.checkNotNull(list);
        this.mFilterSchemas = (List) Preconditions.checkNotNull(list2);
        this.mFilterProperties = (Bundle) Preconditions.checkNotNull(bundle);
        this.mFilterDocumentIds = (Bundle) Preconditions.checkNotNull(bundle2);
        this.mRankingStrategy = i;
        this.mMaximumResultCount = i6;
        this.mSearchStringParameters = list3 != null ? Collections.unmodifiableList(list3) : Collections.EMPTY_LIST;
    }

    @NonNull
    public Map<String, List<String>> getFilterDocumentIds() {
        Set<String> setKeySet = this.mFilterDocumentIds.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            arrayMap.put(str, (List) Preconditions.checkNotNull(this.mFilterDocumentIds.getStringArrayList(str)));
        }
        return arrayMap;
    }

    @NonNull
    public List<String> getFilterNamespaces() {
        List<String> list = this.mFilterNamespaces;
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
    public Map<String, List<String>> getFilterProperties() {
        Set<String> setKeySet = this.mFilterProperties.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            arrayMap.put(str, (List) Preconditions.checkNotNull(this.mFilterProperties.getStringArrayList(str)));
        }
        return arrayMap;
    }

    @NonNull
    public List<String> getFilterSchemas() {
        List<String> list = this.mFilterSchemas;
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    public int getMaximumResultCount() {
        return this.mMaximumResultCount;
    }

    public int getRankingStrategy() {
        return this.mRankingStrategy;
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
    public List<String> getSearchStringParameters() {
        return this.mSearchStringParameters;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    public static final class Builder {
        private final int mTotalResultCount;
        private ArrayList<String> mNamespaces = new ArrayList<>();
        private ArrayList<String> mSchemas = new ArrayList<>();
        private Bundle mTypePropertyFilters = new Bundle();
        private Bundle mDocumentIds = new Bundle();
        private int mRankingStrategy = 0;
        private List<String> mSearchStringParameters = new ArrayList();
        private boolean mBuilt = false;

        public Builder(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int i) {
            Preconditions.checkArgument(i >= 1, "maximumResultCount must be positive.");
            this.mTotalResultCount = i;
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mNamespaces = new ArrayList<>(this.mNamespaces);
                this.mSchemas = new ArrayList<>(this.mSchemas);
                this.mTypePropertyFilters = BundleUtil.deepCopy(this.mTypePropertyFilters);
                this.mDocumentIds = BundleUtil.deepCopy(this.mDocumentIds);
                this.mSearchStringParameters = new ArrayList(this.mSearchStringParameters);
                this.mBuilt = false;
            }
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
        @CanIgnoreReturnValue
        public Builder addFilterDocumentIds(@NonNull String str, @NonNull String... strArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterDocumentIds(str, Arrays.asList(strArr));
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
        @CanIgnoreReturnValue
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
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
        public Builder addSearchStringParameters(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addSearchStringParameters(Arrays.asList(strArr));
        }

        @NonNull
        public SearchSuggestionSpec build() {
            if (!this.mSchemas.isEmpty()) {
                ArraySet arraySet = new ArraySet(this.mSchemas);
                for (String str : this.mTypePropertyFilters.keySet()) {
                    if (!arraySet.contains(str)) {
                        throw new IllegalStateException(B7.a.m("The schema: ", str, " exists in the property filter but doesn't exist in the schema filter."));
                    }
                }
            }
            if (!this.mNamespaces.isEmpty()) {
                ArraySet arraySet2 = new ArraySet(this.mNamespaces);
                for (String str2 : this.mDocumentIds.keySet()) {
                    if (!arraySet2.contains(str2)) {
                        throw new IllegalStateException(B7.a.m("The namespace: ", str2, " exists in the document id filter but doesn't exist in the namespace filter."));
                    }
                }
            }
            this.mBuilt = true;
            return new SearchSuggestionSpec(this.mNamespaces, this.mSchemas, this.mTypePropertyFilters, this.mDocumentIds, this.mRankingStrategy, this.mTotalResultCount, this.mSearchStringParameters);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setRankingStrategy(int i) {
            Preconditions.checkArgumentInRange(i, 0, 2, "Suggestion ranking strategy");
            resetIfBuilt();
            this.mRankingStrategy = i;
            return this;
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
        @CanIgnoreReturnValue
        public Builder addFilterNamespaces(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mNamespaces.addAll(collection);
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
        public Builder addFilterDocumentIds(@NonNull String str, @NonNull Collection<String> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList<String> arrayList = new ArrayList<>(collection.size());
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add((String) Preconditions.checkNotNull(it.next()));
            }
            this.mDocumentIds.putStringArrayList(str, arrayList);
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
        public Builder addFilterProperties(@NonNull Class<?> cls, @NonNull Collection<String> collection) throws AppSearchException {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            return addFilterProperties(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }
    }
}
