package ya;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: ya.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6018y extends E0 {

    /* renamed from: c, reason: collision with root package name */
    public final E0 f44139c;

    public C6018y(E0 substitution) {
        kotlin.jvm.internal.p.i(substitution, "substitution");
        this.f44139c = substitution;
    }

    @Override // ya.E0
    public boolean a() {
        return this.f44139c.a();
    }

    @Override // ya.E0
    public F9.g d(F9.g annotations) {
        kotlin.jvm.internal.p.i(annotations, "annotations");
        return this.f44139c.d(annotations);
    }

    @Override // ya.E0
    public B0 e(S key) {
        kotlin.jvm.internal.p.i(key, "key");
        return this.f44139c.e(key);
    }

    @Override // ya.E0
    public boolean f() {
        return this.f44139c.f();
    }

    @Override // ya.E0
    public S g(S topLevelType, Variance position) {
        kotlin.jvm.internal.p.i(topLevelType, "topLevelType");
        kotlin.jvm.internal.p.i(position, "position");
        return this.f44139c.g(topLevelType, position);
    }
}
