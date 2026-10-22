package androidx.core.viewtree;

import android.view.View;
import android.view.ViewParent;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¨\u0006\u0006"}, d2 = {"getParentOrViewTreeDisjointParent", "Landroid/view/ViewParent;", "Landroid/view/View;", "setViewTreeDisjointParent", "", "parent", "core-viewtree_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewTree {
    public static final ViewParent getParentOrViewTreeDisjointParent(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L5;
        return r101;
    L5:
        Object r102 = r100.getTag(R.id.view_tree_disjoint_parent);
        if ((r102 instanceof ViewParent) == true) goto L10;
        return null;
    L10:
        return (ViewParent) r102;
    }

    public static final void setViewTreeDisjointParent(View r100, ViewParent r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTag(R.id.view_tree_disjoint_parent, r101);
    }
}
