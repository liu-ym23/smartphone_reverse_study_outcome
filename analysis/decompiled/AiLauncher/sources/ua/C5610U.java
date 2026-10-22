package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import p9.InterfaceC5063a;

/* renamed from: ua.U, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5610U implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final TypeDeserializer f42580a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$Type f42581b;

    public C5610U(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type) {
        this.f42580a = typeDeserializer;
        this.f42581b = protoBuf$Type;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return TypeDeserializer.r(this.f42580a, this.f42581b);
    }
}
