package androidx.compose.ui.platform;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/BoundsHelperApi24Impl;", "Landroidx/compose/ui/platform/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BoundsHelperApi24Impl implements BoundsHelper {
    public static final BoundsHelperApi24Impl INSTANCE = null;

    static {
        INSTANCE = new BoundsHelperApi24Impl();
    }

    private BoundsHelperApi24Impl() {
    }

    @Override // androidx.compose.ui.platform.BoundsHelper
    public Rect currentWindowBounds(Activity r100) {
        Rect r101 = new Rect();
        Display r102 = r100.getWindowManager().getDefaultDisplay();
        r102.getRectSize(r101);
        if (r100.isInMultiWindowMode() == true) goto L10;
        Point r103 = new Point();
        r102.getRealSize(r103);
        int r104 = AndroidWindowInfo_androidKt.access$getNavigationBarHeight(r100);
        int r105 = r101.bottom;
        if ((r105 + r104) != r103.y) goto L7;
        r101.bottom = r105 + r104;
        goto L10
    L7:
        int r106 = r101.right;
        if ((r106 + r104) != r103.x) goto L10;
        r101.right = r106 + r104;
    L10:
        return r101;
    }
}
