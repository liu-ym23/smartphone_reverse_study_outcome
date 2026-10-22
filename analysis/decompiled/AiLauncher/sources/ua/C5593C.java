package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import p9.InterfaceC5063a;
import wa.C5770L;

/* renamed from: ua.C, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5593C implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42518a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$Property f42519b;

    /* renamed from: c, reason: collision with root package name */
    public final C5770L f42520c;

    public C5593C(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        this.f42518a = c5601k;
        this.f42519b = protoBuf$Property;
        this.f42520c = c5770l;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.B(this.f42518a, this.f42519b, this.f42520c);
    }
}
