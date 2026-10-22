package wa;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5063a;

/* renamed from: wa.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5786j implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final List f43191a;

    public C5786j(List list) {
        this.f43191a = list;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DeserializedClassDescriptor.a.A(this.f43191a);
    }
}
