package ua;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import p9.InterfaceC5074l;

/* renamed from: ua.S, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5608S implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final TypeDeserializer f42578a;

    public C5608S(TypeDeserializer typeDeserializer) {
        this.f42578a = typeDeserializer;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return TypeDeserializer.f(this.f42578a, ((Number) obj).intValue());
    }
}
