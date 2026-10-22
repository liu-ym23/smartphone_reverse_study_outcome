package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.JoinSpec;
import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.platformstorage.e;
import androidx.core.util.Preconditions;

@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class JoinSpecToPlatformConverter {
    private JoinSpecToPlatformConverter() {
    }

    @SuppressLint({"WrongConstant"})
    public static JoinSpec toPlatformJoinSpec(Context context, androidx.appsearch.app.JoinSpec joinSpec) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(joinSpec);
        e.m();
        return e.e(joinSpec.getChildPropertyExpression()).setNestedSearch(joinSpec.getNestedQuery(), SearchSpecToPlatformConverter.toPlatformSearchSpec(context, joinSpec.getNestedSearchSpec())).setMaxJoinedResultCount(joinSpec.getMaxJoinedResultCount()).setAggregationScoringStrategy(joinSpec.getAggregationScoringStrategy()).build();
    }
}
