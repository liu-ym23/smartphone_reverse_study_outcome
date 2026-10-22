package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001d\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/ExtensionsWindowLayoutInfoAdapter;", "", "()V", "translate", "Landroidx/window/layout/FoldingFeature;", "activity", "Landroid/app/Activity;", "oemFeature", "Landroidx/window/extensions/layout/FoldingFeature;", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "info", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "validBounds", "", "bounds", "Landroidx/window/core/Bounds;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsWindowLayoutInfoAdapter {
    public static final ExtensionsWindowLayoutInfoAdapter INSTANCE = null;

    static {
        INSTANCE = new ExtensionsWindowLayoutInfoAdapter();
    }

    private ExtensionsWindowLayoutInfoAdapter() {
    }

    private final boolean validBounds(Activity r100, Bounds r101) {
        Rect r102 = WindowMetricsCalculatorCompat.INSTANCE.computeCurrentWindowMetrics(r100).getBounds();
        if (r101.isZero() == false) goto L6;
        return false;
    L6:
        if (r101.getWidth() == r102.width()) goto L11;
        if (r101.getHeight() == r102.height()) goto L11;
        return false;
    L11:
        if (r101.getWidth() >= r102.width()) goto L16;
        if (r101.getHeight() >= r102.height()) goto L16;
        return false;
    L16:
        if (r101.getWidth() == r102.width()) goto L18;
        return true;
    L18:
        if (r101.getHeight() != r102.height()) goto L22;
        return false;
    L22:
        return true;
    }

    public final FoldingFeature translate$window_release(Activity r100, androidx.window.extensions.layout.FoldingFeature r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "oemFeature");
        int r102 = r101.getType();
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L6;
        return null;
    L6:
        HardwareFoldingFeature.Type r103 = HardwareFoldingFeature.Type.Companion.getHINGE();
    L8:
        int r104 = r101.getState();
        if (r104 == 1) goto L13;
        if (r104 == 2) goto L12;
        return null;
    L12:
        FoldingFeature.State r105 = FoldingFeature.State.HALF_OPENED;
    L15:
        if (validBounds(r100, new Bounds(r101.getBounds())) == true) goto L17;
        return null;
    L17:
        return new HardwareFoldingFeature(new Bounds(r101.getBounds()), r103, r105);
    L13:
        r105 = FoldingFeature.State.FLAT;
        goto L15
    L7:
        r103 = HardwareFoldingFeature.Type.Companion.getFOLD();
        goto L8
    }

    public final WindowLayoutInfo translate$window_release(Activity r100, androidx.window.extensions.layout.WindowLayoutInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        List r102 = r101.getDisplayFeatures();
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L12;
        androidx.window.extensions.layout.FoldingFeature r105 = (androidx.window.extensions.layout.DisplayFeature) r104.next();
        if ((r105 instanceof androidx.window.extensions.layout.FoldingFeature) == false) goto L8;
        FoldingFeature r106 = INSTANCE.translate$window_release(r100, r105);
    L9:
        if (r106 == null) goto L4;
        r103.add(r106);
        goto L4
    L8:
        r106 = null;
        goto L9
    L12:
        return new WindowLayoutInfo(r103);
    }
}
