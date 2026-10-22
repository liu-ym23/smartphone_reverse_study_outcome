package T;

import androidx.fragment.app.ComponentCallbacksC0511f;
import j4.k;

/* loaded from: classes.dex */
public final class f extends h {

    /* renamed from: b, reason: collision with root package name */
    private final ComponentCallbacksC0511f f5303b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5304c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ComponentCallbacksC0511f componentCallbacksC0511f, ComponentCallbacksC0511f componentCallbacksC0511f2, int i5) {
        super(componentCallbacksC0511f, "Attempting to set target fragment " + componentCallbacksC0511f2 + " with request code " + i5 + " for fragment " + componentCallbacksC0511f);
        k.g(componentCallbacksC0511f, "fragment");
        k.g(componentCallbacksC0511f2, "targetFragment");
        this.f5303b = componentCallbacksC0511f2;
        this.f5304c = i5;
    }
}
