package T;

import android.view.ViewGroup;
import androidx.fragment.app.ComponentCallbacksC0511f;
import j4.k;

/* loaded from: classes.dex */
public final class d extends i {

    /* renamed from: b, reason: collision with root package name */
    private final ViewGroup f5302b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ComponentCallbacksC0511f componentCallbacksC0511f, ViewGroup viewGroup) {
        super(componentCallbacksC0511f, "Attempting to use <fragment> tag to add fragment " + componentCallbacksC0511f + " to container " + viewGroup);
        k.g(componentCallbacksC0511f, "fragment");
        this.f5302b = viewGroup;
    }
}
