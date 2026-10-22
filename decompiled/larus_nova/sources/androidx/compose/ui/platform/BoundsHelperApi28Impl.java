package androidx.compose.ui.platform;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/BoundsHelperApi28Impl;", "Landroidx/compose/ui/platform/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BoundsHelperApi28Impl implements BoundsHelper {
    public static final BoundsHelperApi28Impl INSTANCE = null;

    static {
        INSTANCE = new BoundsHelperApi28Impl();
    }

    private BoundsHelperApi28Impl() {
    }

    @Override // androidx.compose.ui.platform.BoundsHelper
    public Rect currentWindowBounds(Activity r100) {
        Rect r101 = new Rect();
        Configuration r102 = r100.getResources().getConfiguration();
        Field r103 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: Exception -> L9
        r103.setAccessible(true);     // Catch: Exception -> L9
        Object r104 = r103.get(r102);     // Catch: Exception -> L9
        if (r100.isInMultiWindowMode() == false) goto L7;
        Object r105 = r104.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r104, new Object[0]);     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.graphics.Rect");     // Catch: Exception -> L9
        r101.set((Rect) r105);     // Catch: Exception -> L9
    L53:
    L21:
        Display r106 = r100.getWindowManager().getDefaultDisplay();
        Point r107 = new Point();
        r106.getRealSize(r107);
        if (r100.isInMultiWindowMode() == true) goto L33;
        int r108 = AndroidWindowInfo_androidKt.access$getNavigationBarHeight(r100);
        int r109 = r101.bottom;
        if ((r109 + r108) != r107.y) goto L26;
        r101.bottom = r109 + r108;
        goto L33
    L26:
        int r110 = r101.right;
        if ((r110 + r108) != r107.x) goto L30;
        r101.right = r110 + r108;
        goto L33
    L30:
        if (r101.left != r108) goto L33;
        r101.left = 0;
    L33:
        if (r101.width() < r107.x) goto L37;
        if (r101.height() < r107.y) goto L37;
    L52:
        return r101;
    L37:
        if (r100.isInMultiWindowMode() == true) goto L52;
        DisplayCutout r111 = AndroidWindowInfo_androidKt.access$getCutoutForDisplay(r106);
        if (r111 == null) goto L52;
        if (r101.left != r111.getSafeInsetLeft()) goto L44;
        r101.left = 0;
    L44:
        if ((r107.x - r101.right) != r111.getSafeInsetRight()) goto L47;
        r101.right += r111.getSafeInsetRight();
    L47:
        if (r101.top != r111.getSafeInsetTop()) goto L50;
        r101.top = 0;
    L50:
        if ((r107.y - r101.bottom) != r111.getSafeInsetBottom()) goto L52;
        r101.bottom += r111.getSafeInsetBottom();
        goto L52
    L7:
        Object r112 = r104.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r104, new Object[0]);     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.graphics.Rect");     // Catch: Exception -> L9
        r101.set((Rect) r112);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        if ((e instanceof NoSuchFieldException) == false) goto L13;
    L20:
        AndroidWindowInfo_androidKt.access$getRectSizeFromDisplay(r100, r101);
        goto L21
    L13:
        if ((e instanceof NoSuchMethodException) == true) goto L20;
        if ((e instanceof IllegalAccessException) == true) goto L20;
        if ((e instanceof InvocationTargetException) == true) goto L20;
        throw e;
    }
}
