package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0017¨\u0006\u000f"}, d2 = {"Landroidx/activity/EdgeToEdgeApi29;", "Landroidx/activity/EdgeToEdgeImpl;", "()V", "setUp", "", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", "view", "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EdgeToEdgeApi29 implements EdgeToEdgeImpl {
    public EdgeToEdgeApi29() {
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle r100, SystemBarStyle r101, Window r102, View r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "statusBarStyle");
        Intrinsics.checkNotNullParameter(r101, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(r102, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r103, "view");
        boolean r106 = false;
        WindowCompat.setDecorFitsSystemWindows(r102, false);
        r102.setStatusBarColor(r100.getScrimWithEnforcedContrast$activity_release(r104));
        r102.setNavigationBarColor(r101.getScrimWithEnforcedContrast$activity_release(r105));
        r102.setStatusBarContrastEnforced(false);
        if (r101.getNightMode$activity_release() != 0) goto L5;
        r106 = true;
    L5:
        r102.setNavigationBarContrastEnforced(r106);
        WindowInsetsControllerCompat r107 = new WindowInsetsControllerCompat(r102, r103);
        r107.setAppearanceLightStatusBars(!r104);
        r107.setAppearanceLightNavigationBars(true ^ r105);
    }
}
