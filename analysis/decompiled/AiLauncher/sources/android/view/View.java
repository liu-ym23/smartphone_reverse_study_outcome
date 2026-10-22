package android.view;

import E0.a;
import android.view.runtime.R$id;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;)V", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Landroidx/lifecycle/LifecycleOwner;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.lifecycle.X, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class View {
    public static final LifecycleOwner a(android.view.View view) {
        p.i(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R$id.view_tree_lifecycle_owner);
            LifecycleOwner lifecycleOwner = tag instanceof LifecycleOwner ? (LifecycleOwner) tag : null;
            if (lifecycleOwner != null) {
                return lifecycleOwner;
            }
            Object objA = a.a(view);
            view = objA instanceof android.view.View ? (android.view.View) objA : null;
        }
        return null;
    }

    public static final void b(android.view.View view, LifecycleOwner lifecycleOwner) {
        p.i(view, "<this>");
        view.setTag(R$id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
