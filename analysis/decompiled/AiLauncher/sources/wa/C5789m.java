package wa;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5063a;

/* renamed from: wa.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5789m implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializedClassDescriptor f43194a;

    public C5789m(DeserializedClassDescriptor deserializedClassDescriptor) {
        this.f43194a = deserializedClassDescriptor;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DeserializedClassDescriptor.b.M(this.f43194a);
    }
}
