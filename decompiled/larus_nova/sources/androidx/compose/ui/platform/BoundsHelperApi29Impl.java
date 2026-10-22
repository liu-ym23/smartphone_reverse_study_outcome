package androidx.compose.ui.platform;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/BoundsHelperApi29Impl;", "Landroidx/compose/ui/platform/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BoundsHelperApi29Impl implements BoundsHelper {
    public static final BoundsHelperApi29Impl INSTANCE = null;

    static {
        INSTANCE = new BoundsHelperApi29Impl();
    }

    private BoundsHelperApi29Impl() {
    }

    @Override // androidx.compose.ui.platform.BoundsHelper
    public Rect currentWindowBounds(Activity r100) {
        Configuration r101 = r100.getResources().getConfiguration();
        Field r102 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        Object r103 = r102.get(r101);     // Catch: Exception -> L5
        Object r104 = r103.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r103, new Object[0]);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.graphics.Rect");     // Catch: Exception -> L5
        return new Rect((Rect) r104);
    L5:
        e = move-exception;
        if ((e instanceof NoSuchFieldException) == true) goto L17;
        if ((e instanceof NoSuchMethodException) == true) goto L17;
        if ((e instanceof IllegalAccessException) == true) goto L17;
        if ((e instanceof InvocationTargetException) == true) goto L17;
        throw e;
    L17:
        return BoundsHelperApi28Impl.INSTANCE.currentWindowBounds(r100);
    }
}
