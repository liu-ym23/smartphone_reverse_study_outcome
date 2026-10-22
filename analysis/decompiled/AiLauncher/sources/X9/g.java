package X9;

import E9.InterfaceC0797b;
import p9.InterfaceC5074l;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public class g implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0797b f6883a;

    /* renamed from: b, reason: collision with root package name */
    public final h f6884b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC5990d0 f6885c;

    /* renamed from: d, reason: collision with root package name */
    public final a f6886d;

    public g(InterfaceC0797b interfaceC0797b, h hVar, AbstractC5990d0 abstractC5990d0, a aVar) {
        this.f6883a = interfaceC0797b;
        this.f6884b = hVar;
        this.f6885c = abstractC5990d0;
        this.f6886d = aVar;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return h.k(this.f6883a, this.f6884b, this.f6885c, this.f6886d, (kotlin.reflect.jvm.internal.impl.types.checker.c) obj);
    }
}
