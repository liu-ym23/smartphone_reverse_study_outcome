package ua;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import p9.InterfaceC5074l;

/* renamed from: ua.T, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5609T implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final TypeDeserializer f42579a;

    public C5609T(TypeDeserializer typeDeserializer) {
        this.f42579a = typeDeserializer;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return TypeDeserializer.v(this.f42579a, ((Number) obj).intValue());
    }
}
