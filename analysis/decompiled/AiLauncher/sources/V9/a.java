package V9;

import E9.InterfaceC0798c;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class a implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final k f6502a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0798c f6503b;

    public a(k kVar, InterfaceC0798c interfaceC0798c) {
        this.f6502a = kVar;
        this.f6503b = interfaceC0798c;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return c.g(this.f6502a, this.f6503b);
    }
}
