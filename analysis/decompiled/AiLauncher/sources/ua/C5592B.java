package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import p9.InterfaceC5063a;
import wa.C5770L;

/* renamed from: ua.B, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5592B implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42515a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$Property f42516b;

    /* renamed from: c, reason: collision with root package name */
    public final C5770L f42517c;

    public C5592B(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        this.f42515a = c5601k;
        this.f42516b = protoBuf$Property;
        this.f42517c = c5770l;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.z(this.f42515a, this.f42516b, this.f42517c);
    }
}
