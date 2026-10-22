package androidx.transition;

import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi22.java */
/* JADX INFO: loaded from: classes.dex */
class ai extends ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2798a = true;

    static {
    }

    ai() {
    }

    @Override // androidx.transition.al
    public void a(View r1, int r2, int r3, int r4, int r5) {
        if (f2798a == false) goto L10;
        r1.setLeftTopRightBottom(r2, r3, r4, r5);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        f2798a = false;
        return;
    }
}
