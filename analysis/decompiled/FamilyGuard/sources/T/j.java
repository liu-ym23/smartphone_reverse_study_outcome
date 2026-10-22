package T;

import android.view.ViewGroup;
import androidx.fragment.app.ComponentCallbacksC0511f;
import j4.k;

/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: b, reason: collision with root package name */
    private final ViewGroup f5307b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ComponentCallbacksC0511f componentCallbacksC0511f, ViewGroup viewGroup) {
        super(componentCallbacksC0511f, "Attempting to add fragment " + componentCallbacksC0511f + " to container " + viewGroup + " which is not a FragmentContainerView");
        k.g(componentCallbacksC0511f, "fragment");
        k.g(viewGroup, "container");
        this.f5307b = viewGroup;
    }
}
