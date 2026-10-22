package T;

import androidx.fragment.app.ComponentCallbacksC0511f;
import j4.k;

/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: b, reason: collision with root package name */
    private final String f5284b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ComponentCallbacksC0511f componentCallbacksC0511f, String str) {
        super(componentCallbacksC0511f, "Attempting to reuse fragment " + componentCallbacksC0511f + " with previous ID " + str);
        k.g(componentCallbacksC0511f, "fragment");
        k.g(str, "previousFragmentId");
        this.f5284b = str;
    }
}
