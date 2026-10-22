package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import p9.InterfaceC5063a;

/* renamed from: ua.E, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5595E implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42524a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f42525b;

    /* renamed from: c, reason: collision with root package name */
    public final ProtoBuf$Property f42526c;

    public C5595E(C5601K c5601k, boolean z10, ProtoBuf$Property protoBuf$Property) {
        this.f42524a = c5601k;
        this.f42525b = z10;
        this.f42526c = protoBuf$Property;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.q(this.f42524a, this.f42525b, this.f42526c);
    }
}
