package rc;

import rc.a1;

/* loaded from: classes5.dex */
public class W extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public String f39169d;

    /* renamed from: e, reason: collision with root package name */
    public int f39170e;

    /* renamed from: f, reason: collision with root package name */
    public a1.a f39171f;

    public W(String str, int i10) {
        this.f39169d = str;
        this.f39170e = i10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        Cc.e eVar;
        Cc.e eVar2;
        Cc.e eVar3;
        if (this.f39171f == null) {
            return new X(this.f39169d, this.f39170e, C5307t.W(y02.m()));
        }
        C5307t c5307t = (C5307t) y02.n();
        int i10 = (c5307t.f39415f ? 2 : 0) | (c5307t.f39411b ? 1 : 0);
        boolean z10 = c5307t.f39412c;
        if (c5307t.f39413d) {
            a1.a aVar = this.f39171f;
            String str = aVar.f39215a;
            if (str == null) {
                eVar2 = new Cc.e(aVar.f39216b, 0, 10);
                eVar3 = eVar2;
            } else {
                eVar = new Cc.e(str, 0, 10);
                eVar3 = eVar;
            }
        } else {
            a1.a aVar2 = this.f39171f;
            String str2 = aVar2.f39216b;
            if (str2 == null) {
                eVar2 = new Cc.e(aVar2.f39215a, 0, 10);
                eVar3 = eVar2;
            } else {
                eVar = new Cc.e(str2, 0, 10);
                eVar3 = eVar;
            }
        }
        return new X(this.f39169d, i10, C5307t.W(y02.m()), eVar3, z10);
    }

    public W(String str, a1.a aVar) {
        this(str, 0);
        this.f39171f = aVar;
    }
}
