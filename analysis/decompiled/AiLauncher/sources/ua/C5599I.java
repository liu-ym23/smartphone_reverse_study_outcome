package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import p9.InterfaceC5063a;
import wa.C5770L;

/* renamed from: ua.I, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5599I implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42542a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$Property f42543b;

    /* renamed from: c, reason: collision with root package name */
    public final C5770L f42544c;

    public C5599I(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        this.f42542a = c5601k;
        this.f42543b = protoBuf$Property;
        this.f42544c = c5770l;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.A(this.f42542a, this.f42543b, this.f42544c);
    }
}
