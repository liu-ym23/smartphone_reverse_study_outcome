package androidx.transition;

import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi19.java */
/* JADX INFO: loaded from: classes.dex */
class ag extends al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2794a = true;

    static {
    }

    @Override // androidx.transition.al
    public void b(View r1) {
    }

    @Override // androidx.transition.al
    public void c(View r1) {
    }

    ag() {
    }

    @Override // androidx.transition.al
    public void a(View r1, float r2) {
        if (f2794a == true) goto L9;
    L7:
        r1.setAlpha(r2);
        return;
    L9:
        r1.setTransitionAlpha(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        f2794a = false;
        goto L7
    }

    @Override // androidx.transition.al
    public float a(View r1) {
        if (f2794a == false) goto L8;
        return r1.getTransitionAlpha();
    L6:
        f2794a = false;
    L8:
        return r1.getAlpha();
    }
}
