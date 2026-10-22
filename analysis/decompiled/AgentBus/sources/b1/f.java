package b1;

import i1.j;
import i1.x1;
import n0.l;
import p7.k;
import q7.m;
import q7.v;
import s0.q;

/* loaded from: classes.dex */
public final class f extends m implements k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1476g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v f1477h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(v vVar, int i2) {
        super(1);
        this.f1476g = i2;
        this.f1477h = vVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        boolean z4;
        switch (this.f1476g) {
            case 0:
                j jVar = (x1) obj;
                if (((l) jVar).f6797f.f6810s) {
                    this.f1477h.f8820f = jVar;
                    z4 = false;
                } else {
                    z4 = true;
                }
                return Boolean.valueOf(z4);
            default:
                this.f1477h.f8820f = (q) obj;
                return Boolean.TRUE;
        }
    }
}
