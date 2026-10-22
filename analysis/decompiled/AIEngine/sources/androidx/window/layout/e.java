package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.f;
import androidx.window.layout.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {
    public static g a(Activity activity, FoldingFeature foldingFeature) {
        g.a aVar;
        f.b bVar;
        int type = foldingFeature.getType();
        if (type == 1) {
            aVar = g.a.f2739b;
        } else {
            if (type != 2) {
                return null;
            }
            aVar = g.a.f2740c;
        }
        int state = foldingFeature.getState();
        if (state == 1) {
            bVar = f.b.f2733b;
        } else {
            if (state != 2) {
                return null;
            }
            bVar = f.b.f2734c;
        }
        Rect bounds = foldingFeature.getBounds();
        kotlin.jvm.internal.g.e(bounds, "oemFeature.bounds");
        int i10 = bounds.left;
        int i11 = bounds.top;
        int i12 = bounds.right;
        int i13 = bounds.bottom;
        o.f2758a.getClass();
        Rect bounds2 = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        kotlin.jvm.internal.g.e(bounds2, "activity.windowManager.currentWindowMetrics.bounds");
        Rect rect = new Rect(bounds2.left, bounds2.top, bounds2.right, bounds2.bottom);
        int i14 = i13 - i11;
        if (i14 == 0 && i12 - i10 == 0) {
            return null;
        }
        int i15 = i12 - i10;
        if (i15 != rect.width() && i14 != rect.height()) {
            return null;
        }
        if (i15 < rect.width() && i14 < rect.height()) {
            return null;
        }
        if (i15 == rect.width() && i14 == rect.height()) {
            return null;
        }
        Rect bounds3 = foldingFeature.getBounds();
        kotlin.jvm.internal.g.e(bounds3, "oemFeature.bounds");
        return new g(new g2.b(bounds3), aVar, bVar);
    }

    public static m b(Activity activity, WindowLayoutInfo info) {
        g gVarA;
        kotlin.jvm.internal.g.f(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        kotlin.jvm.internal.g.e(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature feature : displayFeatures) {
            if (feature instanceof FoldingFeature) {
                kotlin.jvm.internal.g.e(feature, "feature");
                gVarA = a(activity, feature);
            } else {
                gVarA = null;
            }
            if (gVarA != null) {
                arrayList.add(gVarA);
            }
        }
        return new m(arrayList);
    }
}
