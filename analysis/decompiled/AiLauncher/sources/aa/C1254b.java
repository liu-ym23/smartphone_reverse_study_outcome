package aa;

import java.util.List;
import p9.InterfaceC5063a;

/* renamed from: aa.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1254b implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final List f8112a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1257e f8113b;

    public C1254b(List list, AbstractC1257e abstractC1257e) {
        this.f8112a = list;
        this.f8113b = abstractC1257e;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return AbstractC1257e.a(this.f8112a, this.f8113b);
    }
}
