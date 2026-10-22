package aa;

import aa.AbstractC1257e;
import p9.InterfaceC5074l;

/* renamed from: aa.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1253a implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1257e f8109a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1257e.a f8110b;

    public C1253a(AbstractC1257e abstractC1257e, AbstractC1257e.a aVar) {
        this.f8109a = abstractC1257e;
        this.f8110b = aVar;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return Boolean.valueOf(AbstractC1257e.l(this.f8109a, this.f8110b, obj));
    }
}
