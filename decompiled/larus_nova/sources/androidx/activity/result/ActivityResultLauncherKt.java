package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {EventVerify.TYPE_LAUNCH, "", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "options", "Landroidx/core/app/ActivityOptionsCompat;", "launchUnit", "activity-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultLauncherKt {
    public static final void launch(ActivityResultLauncher<Void> r100, ActivityOptionsCompat r101) {
        r100.launch(null, r101);
    }

    public static final void launchUnit(ActivityResultLauncher<Unit> r100, ActivityOptionsCompat r101) {
        r100.launch(Unit.INSTANCE, r101);
    }

    public static /* synthetic */ void launch$default(ActivityResultLauncher r100, ActivityOptionsCompat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        launch(r100, r101);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher r100, ActivityOptionsCompat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        launchUnit(r100, r101);
    }
}
