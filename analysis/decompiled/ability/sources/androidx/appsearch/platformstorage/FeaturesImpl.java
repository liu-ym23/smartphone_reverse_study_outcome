package androidx.appsearch.platformstorage;

import android.content.Context;
import android.os.Build;
import androidx.annotation.OptIn;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.Features;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
final class FeaturesImpl implements Features {
    private final Context mContext;

    public FeaturesImpl(Context context) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
    }

    @Override // androidx.appsearch.app.Features
    public int getMaxIndexedProperties() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return 64;
        }
        return (i != 33 || AppSearchVersionUtil.getAppSearchVersionCode(this.mContext) < AppSearchVersionUtil.APPSEARCH_U_BASE_VERSION_CODE) ? 16 : 64;
    }

    @Override // androidx.appsearch.app.Features
    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public boolean isFeatureSupported(String str) {
        int i;
        i = Build.VERSION.SDK_INT;
        str.getClass();
        switch (str) {
            case "SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG":
            case "ENTERPRISE_GLOBAL_SEARCH_SESSION":
            case "SCHEMA_ADD_PARENT_TYPE":
            case "SEARCH_SPEC_GROUPING_TYPE_PER_SCHEMA":
            case "SET_SCHEMA_REQUEST_ADD_SCHEMA_TYPE_VISIBLE_TO_CONFIG":
            case "SCHEMA_ADD_INDEXABLE_NESTED_PROPERTIES":
            case "LIST_FILTER_HAS_PROPERTY_FUNCTION":
            case "SEARCH_SPEC_ADD_FILTER_PROPERTIES":
            case "SET_SCHEMA_REQUEST_SET_PUBLICLY_VISIBLE":
                if (i >= 35) {
                }
                break;
            case "SEARCH_SPEC_ADVANCED_RANKING_EXPRESSION":
            case "JOIN_SPEC_AND_QUALIFIED_ID":
            case "SET_SCHEMA_CIRCULAR_REFERENCES":
            case "TOKENIZER_TYPE_RFC822":
            case "LIST_FILTER_QUERY_LANGUAGE":
            case "VERBATIM_SEARCH":
            case "SEARCH_SPEC_PROPERTY_WEIGHTS":
            case "SEARCH_SUGGESTION":
            case "NUMERIC_SEARCH":
                if (i >= 34) {
                }
                break;
            case "INDEXER_MOBILE_APPLICATIONS":
                if (AppSearchVersionUtil.isAtLeastB() || AppSearchVersionUtil.getAppSearchVersionCode(this.mContext) >= AppSearchVersionUtil.APPSEARCH_M2024_11_VERSION_CODE) {
                }
                break;
            case "SEARCH_SPEC_RANKING_FUNCTION_MAX_MIN_OR_DEFAULT":
            case "SEARCH_SPEC_RANKING_FUNCTION_FILTER_BY_RANGE":
                if (i >= 35 || AppSearchVersionUtil.getAppSearchVersionCode(this.mContext) >= AppSearchVersionUtil.APPSEARCH_V_BASE_VERSION_CODE) {
                }
                break;
        }
        return false;
    }
}
