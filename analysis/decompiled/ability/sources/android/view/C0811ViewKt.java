package android.view;

import C7.c;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"findViewTreeSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "view", "Landroid/view/View;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.savedstate.ViewKt, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0811ViewKt {
    @c
    public static final /* synthetic */ SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View view) {
        k.f(view, "view");
        return C0812ViewTreeSavedStateRegistryOwner.get(view);
    }
}
