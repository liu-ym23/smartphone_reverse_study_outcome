package android.view;

import androidx.core.viewtree.ViewTree;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroid/view/View;", "Landroidx/activity/FullyDrawnReporterOwner;", "fullyDrawnReporterOwner", "LC7/r;", "set", "(Landroid/view/View;Landroidx/activity/FullyDrawnReporterOwner;)V", "setViewTreeFullyDrawnReporterOwner", "get", "(Landroid/view/View;)Landroidx/activity/FullyDrawnReporterOwner;", "findViewTreeFullyDrawnReporterOwner", "activity_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.activity.ViewTreeFullyDrawnReporterOwner, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class View {
    public static final FullyDrawnReporterOwner get(android.view.View view) {
        k.f(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.report_drawn);
            FullyDrawnReporterOwner fullyDrawnReporterOwner = tag instanceof FullyDrawnReporterOwner ? (FullyDrawnReporterOwner) tag : null;
            if (fullyDrawnReporterOwner != null) {
                return fullyDrawnReporterOwner;
            }
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof android.view.View ? (android.view.View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }

    public static final void set(android.view.View view, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        k.f(view, "<this>");
        k.f(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
