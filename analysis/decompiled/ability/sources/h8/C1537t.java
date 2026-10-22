package h8;

import a9.InterfaceC0311c;

/* renamed from: h8.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1537t extends AbstractC1508P {

    /* renamed from: a, reason: collision with root package name */
    public final G8.f f4588a;
    public final InterfaceC0311c b;

    public C1537t(G8.f fVar, InterfaceC0311c underlyingType) {
        kotlin.jvm.internal.k.f(underlyingType, "underlyingType");
        this.f4588a = fVar;
        this.b = underlyingType;
    }

    @Override // h8.AbstractC1508P
    public final boolean a(G8.f fVar) {
        return this.f4588a.equals(fVar);
    }

    public final String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.f4588a + ", underlyingType=" + this.b + ')';
    }
}
