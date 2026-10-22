package ua;

import E9.InterfaceC0819y;
import ea.InterfaceC4020d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import ma.AbstractC4927g;
import ta.C5527a;

/* renamed from: ua.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5619e extends AbstractC5615a<F9.c> implements InterfaceC5618d<F9.c, AbstractC4927g<?>> {

    /* renamed from: b, reason: collision with root package name */
    public final C5620f f42593b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5619e(InterfaceC0819y module, E9.D notFoundClasses, C5527a protocol) {
        super(protocol);
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.p.i(protocol, "protocol");
        this.f42593b = new C5620f(module, notFoundClasses);
    }

    @Override // ua.InterfaceC5621g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public F9.c f(ProtoBuf$Annotation proto, InterfaceC4020d nameResolver) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        return this.f42593b.a(proto, nameResolver);
    }

    @Override // ua.InterfaceC5618d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC4927g<?> g(AbstractC5604N container, ProtoBuf$Property proto, ya.S expectedType) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(expectedType, "expectedType");
        return null;
    }

    @Override // ua.InterfaceC5618d
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public AbstractC4927g<?> i(AbstractC5604N container, ProtoBuf$Property proto, ya.S expectedType) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(expectedType, "expectedType");
        ProtoBuf$Annotation.Argument.Value value = (ProtoBuf$Annotation.Argument.Value) ea.f.a(proto, n().b());
        if (value == null) {
            return null;
        }
        return this.f42593b.f(expectedType, value, container.b());
    }
}
