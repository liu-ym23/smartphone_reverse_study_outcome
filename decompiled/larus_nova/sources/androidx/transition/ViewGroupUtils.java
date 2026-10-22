package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
class ViewGroupUtils {
    private ViewGroupUtils() {
    }

    public static ViewGroupOverlayImpl getOverlay(ViewGroup r100) {
        return new ViewGroupOverlayApi18(r100);
    }

    public static void suppressLayout(ViewGroup r100, boolean r101) {
        ViewGroupUtilsApi18.suppressLayout(r100, r101);
    }
}
