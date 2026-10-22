package androidx.navigation;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"ActivityNavigatorExtras", "Landroidx/navigation/ActivityNavigator$Extras;", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "flags", "", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActivityNavigatorExtrasKt {
    public static final ActivityNavigator.Extras ActivityNavigatorExtras(ActivityOptionsCompat r100, int r101) {
        ActivityNavigator.Extras.Builder r102 = new ActivityNavigator.Extras.Builder();
        if (r100 == null) goto L5;
        r102.setActivityOptions(r100);
    L5:
        r102.addFlags(r101);
        return r102.build();
    }

    public static /* synthetic */ ActivityNavigator.Extras ActivityNavigatorExtras$default(ActivityOptionsCompat r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        return ActivityNavigatorExtras(r100, r101);
    }
}
