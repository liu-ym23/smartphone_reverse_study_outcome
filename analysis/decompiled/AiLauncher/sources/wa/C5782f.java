package wa;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5063a;

/* renamed from: wa.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5782f implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializedClassDescriptor f43187a;

    public C5782f(DeserializedClassDescriptor deserializedClassDescriptor) {
        this.f43187a = deserializedClassDescriptor;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DeserializedClassDescriptor.P0(this.f43187a);
    }
}
