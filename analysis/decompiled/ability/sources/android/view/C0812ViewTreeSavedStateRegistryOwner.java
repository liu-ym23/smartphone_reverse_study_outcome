package android.view;

import android.view.View;
import androidx.core.viewtree.ViewTree;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroid/view/View;", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "LC7/r;", "set", "(Landroid/view/View;Landroidx/savedstate/SavedStateRegistryOwner;)V", "setViewTreeSavedStateRegistryOwner", "get", "(Landroid/view/View;)Landroidx/savedstate/SavedStateRegistryOwner;", "findViewTreeSavedStateRegistryOwner", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.savedstate.ViewTreeSavedStateRegistryOwner, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0812ViewTreeSavedStateRegistryOwner {
    public static final SavedStateRegistryOwner get(View view) {
        k.f(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(C0810R.id.view_tree_saved_state_registry_owner);
            SavedStateRegistryOwner savedStateRegistryOwner = tag instanceof SavedStateRegistryOwner ? (SavedStateRegistryOwner) tag : null;
            if (savedStateRegistryOwner != null) {
                return savedStateRegistryOwner;
            }
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }

    public static final void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        k.f(view, "<this>");
        view.setTag(C0810R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
