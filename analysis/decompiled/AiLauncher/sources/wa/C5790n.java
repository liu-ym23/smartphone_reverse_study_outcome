package wa;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5074l;

/* renamed from: wa.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5790n implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializedClassDescriptor.c f43195a;

    /* renamed from: b, reason: collision with root package name */
    public final DeserializedClassDescriptor f43196b;

    public C5790n(DeserializedClassDescriptor.c cVar, DeserializedClassDescriptor deserializedClassDescriptor) {
        this.f43195a = cVar;
        this.f43196b = deserializedClassDescriptor;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return DeserializedClassDescriptor.c.f(this.f43195a, this.f43196b, (ga.e) obj);
    }
}
