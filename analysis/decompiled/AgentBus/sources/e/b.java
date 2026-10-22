package e;

import c.o;
import i5.f;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final f f3040a;

    /* renamed from: b, reason: collision with root package name */
    public final o f3041b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(f fVar, o oVar) {
        this.f3040a = fVar;
        this.f3041b = oVar;
        if ((fVar == null ? oVar : fVar) == null) {
            throw new IllegalArgumentException("At least one dispatcher (NavigationEventDispatcher or OnBackPressedDispatcher) must be non-null.");
        }
    }
}
