package androidx.navigation;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes.dex */
public final class Navigation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Navigation f3820a = null;

    static {
        f3820a = new Navigation();
    }

    public Navigation() {
    }

    public static final /* synthetic */ NavController a(Navigation r10, View r11) {
        return r10.d(r11);
    }

    public static final NavController b(View r10) {
        kotlin.jvm.internal.q.g(r10, "view");
        NavController r11 = f3820a.c(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException("View " + r10 + " does not have a NavController set");
    }

    public static final void e(View r10, NavController r11) {
        kotlin.jvm.internal.q.g(r10, "view");
        r10.setTag(R$id.nav_controller_view_tag, r11);
    }

    public final NavController c(View r10) {
        return (NavController) SequencesKt___SequencesKt.m(SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.f(r10, Navigation$findViewNavController$1.INSTANCE), Navigation$findViewNavController$2.INSTANCE));
    }

    public final NavController d(View r10) {
        Object r11 = r10.getTag(R$id.nav_controller_view_tag);
        if ((r11 instanceof WeakReference) == false) goto L6;
        return (NavController) ((WeakReference) r11).get();
    L6:
        if ((r11 instanceof NavController) == true) goto L11;
        return null;
    L11:
        return (NavController) r11;
    }
}
