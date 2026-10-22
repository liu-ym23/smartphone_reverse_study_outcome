package wa;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5063a;

/* renamed from: wa.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5780d implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializedClassDescriptor f43185a;

    public C5780d(DeserializedClassDescriptor deserializedClassDescriptor) {
        this.f43185a = deserializedClassDescriptor;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DeserializedClassDescriptor.f1(this.f43185a);
    }
}
