package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import p9.InterfaceC5063a;
import wa.C5770L;

/* renamed from: ua.J, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5600J implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42545a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$Property f42546b;

    /* renamed from: c, reason: collision with root package name */
    public final C5770L f42547c;

    public C5600J(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        this.f42545a = c5601k;
        this.f42546b = protoBuf$Property;
        this.f42547c = c5770l;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.C(this.f42545a, this.f42546b, this.f42547c);
    }
}
