package wa;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5063a;

/* renamed from: wa.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5791o implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializedClassDescriptor.c f43197a;

    public C5791o(DeserializedClassDescriptor.c cVar) {
        this.f43197a = cVar;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DeserializedClassDescriptor.c.h(this.f43197a);
    }
}
