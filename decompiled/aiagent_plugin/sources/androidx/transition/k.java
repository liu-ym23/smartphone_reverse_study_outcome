package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: GhostViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class k {
    static i a(View r2, ViewGroup r3, Matrix r4) {
        if (Build.VERSION.SDK_INT != 28) goto L7;
        return j.a(r2, r3, r4);
    L7:
        return GhostViewPort.addGhost(r2, r3, r4);
    }

    static void a(View r2) {
        if (Build.VERSION.SDK_INT != 28) goto L5;
        j.a(r2);
        return;
    L5:
        GhostViewPort.removeGhost(r2);
    }
}
