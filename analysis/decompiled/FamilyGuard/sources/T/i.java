package T;

import androidx.fragment.app.ComponentCallbacksC0511f;
import j4.k;

/* loaded from: classes.dex */
public abstract class i extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final ComponentCallbacksC0511f f5306a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ComponentCallbacksC0511f componentCallbacksC0511f, String str) {
        super(str);
        k.g(componentCallbacksC0511f, "fragment");
        this.f5306a = componentCallbacksC0511f;
    }

    public final ComponentCallbacksC0511f a() {
        return this.f5306a;
    }
}
