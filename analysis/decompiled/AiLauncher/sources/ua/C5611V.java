package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import p9.InterfaceC5074l;

/* renamed from: ua.V, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5611V implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final TypeDeserializer f42582a;

    public C5611V(TypeDeserializer typeDeserializer) {
        this.f42582a = typeDeserializer;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return TypeDeserializer.z(this.f42582a, (ProtoBuf$Type) obj);
    }
}
