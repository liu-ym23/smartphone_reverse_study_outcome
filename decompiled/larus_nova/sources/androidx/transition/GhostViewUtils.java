package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    public static void removeGhost(View r100) {
        GhostViewApi21.removeGhost(r100);
    }

    public static GhostViewImpl addGhost(View r100, ViewGroup r101, Matrix r102) {
        return GhostViewApi21.addGhost(r100, r101, r102);
    }
}
