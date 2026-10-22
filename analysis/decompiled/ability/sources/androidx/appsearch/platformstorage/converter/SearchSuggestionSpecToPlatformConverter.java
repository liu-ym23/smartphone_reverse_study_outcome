package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.SearchSuggestionSpec;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.platformstorage.e;
import androidx.core.util.Preconditions;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SearchSuggestionSpecToPlatformConverter {

    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addFilterProperties(SearchSuggestionSpec.Builder builder, String str, Collection<String> collection) {
            builder.addFilterProperties(str, collection);
        }
    }

    private SearchSuggestionSpecToPlatformConverter() {
    }

    @SuppressLint({"WrongConstant"})
    public static SearchSuggestionSpec toPlatformSearchSuggestionSpec(androidx.appsearch.app.SearchSuggestionSpec searchSuggestionSpec) {
        Preconditions.checkNotNull(searchSuggestionSpec);
        e.A();
        SearchSuggestionSpec.Builder builderH = e.h(searchSuggestionSpec.getMaximumResultCount());
        builderH.addFilterNamespaces(searchSuggestionSpec.getFilterNamespaces()).addFilterSchemas(searchSuggestionSpec.getFilterSchemas()).setRankingStrategy(searchSuggestionSpec.getRankingStrategy());
        for (Map.Entry<String, List<String>> entry : searchSuggestionSpec.getFilterDocumentIds().entrySet()) {
            builderH.addFilterDocumentIds(entry.getKey(), (Collection<String>) entry.getValue());
        }
        Map<String, List<String>> filterProperties = searchSuggestionSpec.getFilterProperties();
        if (!filterProperties.isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("SEARCH_SPEC_ADD_FILTER_PROPERTIES is not available on this AppSearch implementation.");
            }
            for (Map.Entry<String, List<String>> entry2 : filterProperties.entrySet()) {
                ApiHelperForV.addFilterProperties(builderH, entry2.getKey(), entry2.getValue());
            }
        }
        if (searchSuggestionSpec.getSearchStringParameters().isEmpty()) {
            return builderH.build();
        }
        throw new UnsupportedOperationException("SEARCH_SPEC_SEARCH_STRING_PARAMETERS is not available on this AppSearch implementation.");
    }
}
