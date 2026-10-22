package pb;

import c7.r;
import java.io.IOException;
import ob.e0;
import p7.n;
import q7.m;
import q7.v;

/* loaded from: classes.dex */
public final class i extends m implements n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e0 f8606g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v f8607h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ v f8608i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ v f8609j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e0 e0Var, v vVar, v vVar2, v vVar3) {
        super(2);
        this.f8606g = e0Var;
        this.f8607h = vVar;
        this.f8608i = vVar2;
        this.f8609j = vVar3;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 21589) {
            if (jLongValue < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            byte b10 = this.f8606g.readByte();
            boolean z4 = (b10 & 1) == 1;
            boolean z10 = (b10 & 2) == 2;
            boolean z11 = (b10 & 4) == 4;
            long j2 = z4 ? 5L : 1L;
            if (z10) {
                j2 += 4;
            }
            if (z11) {
                j2 += 4;
            }
            if (jLongValue < j2) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z4) {
                this.f8607h.f8820f = Long.valueOf(r2.d() * 1000);
            }
            if (z10) {
                this.f8608i.f8820f = Long.valueOf(r2.d() * 1000);
            }
            if (z11) {
                this.f8609j.f8820f = Long.valueOf(r2.d() * 1000);
            }
        }
        return r.f1986a;
    }
}
