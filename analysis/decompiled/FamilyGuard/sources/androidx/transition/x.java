package androidx.transition;

import android.view.ViewGroup;

/* loaded from: classes.dex */
class x {

    static class a {
        static int a(ViewGroup viewGroup, int i5) {
            return viewGroup.getChildDrawingOrder(i5);
        }

        static void b(ViewGroup viewGroup, boolean z5) {
            viewGroup.suppressLayout(z5);
        }
    }

    static void a(ViewGroup viewGroup, boolean z5) {
        a.b(viewGroup, z5);
    }
}
