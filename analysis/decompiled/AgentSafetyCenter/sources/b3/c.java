package b3;

import android.view.View;
import android.view.ViewGroup;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ ActionBarCoordinatorLayout f1876c;

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f1876c.f1030u;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f1876c;
        actionBarCoordinatorLayout.A(2);
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = actionBarCoordinatorLayout.f1030u;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
