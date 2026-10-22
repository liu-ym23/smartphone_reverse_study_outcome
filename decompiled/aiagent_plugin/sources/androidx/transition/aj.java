package androidx.transition;

import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi23.java */
/* JADX INFO: loaded from: classes.dex */
class aj extends ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2799a = true;

    static {
    }

    aj() {
    }

    @Override // androidx.transition.al
    public void a(View r3, int r4) {
        if (Build.VERSION.SDK_INT != 28) goto L6;
        super.a(r3, r4);
        return;
    L6:
        if (f2799a == false) goto L14;
        r3.setTransitionVisibility(r4);     // Catch: NoSuchMethodError -> L9
        return;
    L9:
        f2799a = false;
        return;
    }
}
