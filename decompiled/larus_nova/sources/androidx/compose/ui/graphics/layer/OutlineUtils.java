package androidx.compose.ui.graphics.layer;

import android.os.Build;
import android.view.View;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/layer/OutlineUtils;", "", "<init>", "()V", "rebuildOutlineMethod", "Ljava/lang/reflect/Method;", "hasRetrievedMethod", "", "rebuildOutline", "view", "Landroid/view/View;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OutlineUtils {
    public static final OutlineUtils INSTANCE = null;
    private static boolean hasRetrievedMethod;
    private static Method rebuildOutlineMethod;

    static {
        INSTANCE = new OutlineUtils();
    }

    private OutlineUtils() {
    }

    public final boolean rebuildOutline(View r100) {
        if (Build.VERSION.SDK_INT < 22) goto L26;
        r100.invalidateOutline();
        return true;
    L26:
        monitor-enter(this);     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L9:
        if (hasRetrievedMethod == true) goto L13;
        hasRetrievedMethod = true;     // Catch: Throwable -> L21
        Method r101 = View.class.getDeclaredMethod("rebuildOutline", new Class[0]);     // Catch: Throwable -> L21
        if (r101 == null) goto L14;
        r101.setAccessible(true);     // Catch: Throwable -> L21
        rebuildOutlineMethod = r101;     // Catch: Throwable -> L21
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L14:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r101 == null) goto L17;
        r101.invoke(r100, new Object[0]);     // Catch: Throwable -> L24
    L17:
        if (r101 != null) goto L27;
        return false;
    L27:
        return true;
    L13:
        r101 = rebuildOutlineMethod;     // Catch: Throwable -> L21
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L24:
        return false;
    }
}
