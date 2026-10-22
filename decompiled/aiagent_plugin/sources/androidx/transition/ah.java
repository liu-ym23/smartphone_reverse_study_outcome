package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi21.java */
/* JADX INFO: loaded from: classes.dex */
class ah extends ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2795a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2796b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2797c = true;

    static {
    }

    ah() {
    }

    @Override // androidx.transition.al
    public void a(View r1, Matrix r2) {
        if (f2796b == false) goto L10;
        r1.transformMatrixToGlobal(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        f2796b = false;
        return;
    }

    @Override // androidx.transition.al
    public void b(View r1, Matrix r2) {
        if (f2797c == false) goto L10;
        r1.transformMatrixToLocal(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        f2797c = false;
        return;
    }

    @Override // androidx.transition.al
    public void c(View r1, Matrix r2) {
        if (f2795a == false) goto L10;
        r1.setAnimationMatrix(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        f2795a = false;
        return;
    }
}
