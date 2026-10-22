package E0;

import C0.v;
import E0.h;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public class g extends X0.g<InterfaceC1340f, v<?>> implements h {

    /* renamed from: e, reason: collision with root package name */
    private h.a f1292e;

    public g(long j5) {
        super(j5);
    }

    @Override // E0.h
    public void a(int i5) {
        if (i5 >= 40) {
            b();
        } else if (i5 >= 20 || i5 == 15) {
            m(h() / 2);
        }
    }

    @Override // E0.h
    public /* bridge */ /* synthetic */ v c(InterfaceC1340f interfaceC1340f, v vVar) {
        return (v) super.k(interfaceC1340f, vVar);
    }

    @Override // E0.h
    public /* bridge */ /* synthetic */ v d(InterfaceC1340f interfaceC1340f) {
        return (v) super.l(interfaceC1340f);
    }

    @Override // E0.h
    public void e(h.a aVar) {
        this.f1292e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // X0.g
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(v<?> vVar) {
        return vVar == null ? super.i(null) : vVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // X0.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(InterfaceC1340f interfaceC1340f, v<?> vVar) {
        h.a aVar = this.f1292e;
        if (aVar == null || vVar == null) {
            return;
        }
        aVar.b(vVar);
    }
}
