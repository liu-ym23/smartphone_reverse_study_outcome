package androidx.appsearch.platformstorage.converter;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.SearchSuggestionResult;
import androidx.appsearch.platformstorage.e;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SearchSuggestionResultToPlatformConverter {
    private SearchSuggestionResultToPlatformConverter() {
    }

    public static List<SearchSuggestionResult> toJetpackSearchSuggestionResults(List<android.app.appsearch.SearchSuggestionResult> list) {
        Preconditions.checkNotNull(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new SearchSuggestionResult.Builder().setSuggestedResult(e.g(list.get(i)).getSuggestedResult()).build());
        }
        return arrayList;
    }
}
