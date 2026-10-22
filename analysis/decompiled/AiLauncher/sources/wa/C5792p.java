package wa;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5063a;

/* renamed from: wa.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5792p implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializedClassDescriptor f43198a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$EnumEntry f43199b;

    public C5792p(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        this.f43198a = deserializedClassDescriptor;
        this.f43199b = protoBuf$EnumEntry;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DeserializedClassDescriptor.c.g(this.f43198a, this.f43199b);
    }
}
