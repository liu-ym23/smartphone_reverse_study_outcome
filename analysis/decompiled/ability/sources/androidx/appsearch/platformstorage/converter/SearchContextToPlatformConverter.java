package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.AppSearchManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.core.util.Preconditions;

@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SearchContextToPlatformConverter {
    private SearchContextToPlatformConverter() {
    }

    public static AppSearchManager.SearchContext toPlatformSearchContext(PlatformStorage.SearchContext searchContext) {
        Preconditions.checkNotNull(searchContext);
        return new AppSearchManager.SearchContext.Builder(searchContext.getDatabaseName()).build();
    }
}
