package E9;

import Ca.h;

/* renamed from: E9.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0813s<Type extends Ca.h> extends g0<Type> {

    /* renamed from: a, reason: collision with root package name */
    public final ga.e f2487a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f2488b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0813s(ga.e underlyingPropertyName, Type underlyingType) {
        super(null);
        kotlin.jvm.internal.p.i(underlyingPropertyName, "underlyingPropertyName");
        kotlin.jvm.internal.p.i(underlyingType, "underlyingType");
        this.f2487a = underlyingPropertyName;
        this.f2488b = underlyingType;
    }

    @Override // E9.g0
    public boolean a(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return kotlin.jvm.internal.p.d(this.f2487a, name);
    }

    public final ga.e c() {
        return this.f2487a;
    }

    public final Type d() {
        return this.f2488b;
    }

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.f2487a + ", underlyingType=" + this.f2488b + ')';
    }
}
