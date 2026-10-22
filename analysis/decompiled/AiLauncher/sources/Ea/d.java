package Ea;

import E9.b0;
import kotlin.jvm.internal.p;
import ya.S;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f2497a;

    /* renamed from: b, reason: collision with root package name */
    public final S f2498b;

    /* renamed from: c, reason: collision with root package name */
    public final S f2499c;

    public d(b0 typeParameter, S inProjection, S outProjection) {
        p.i(typeParameter, "typeParameter");
        p.i(inProjection, "inProjection");
        p.i(outProjection, "outProjection");
        this.f2497a = typeParameter;
        this.f2498b = inProjection;
        this.f2499c = outProjection;
    }

    public final S a() {
        return this.f2498b;
    }

    public final S b() {
        return this.f2499c;
    }

    public final b0 c() {
        return this.f2497a;
    }

    public final boolean d() {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a.b(this.f2498b, this.f2499c);
    }
}
