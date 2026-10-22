package pb;

import java.io.IOException;
import ob.e0;
import p7.n;
import q7.m;
import q7.r;
import q7.u;

/* loaded from: classes.dex */
public final class h extends m implements n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r f8600g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f8601h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ u f8602i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e0 f8603j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ u f8604k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ u f8605l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(r rVar, long j2, u uVar, e0 e0Var, u uVar2, u uVar3) {
        super(2);
        this.f8600g = rVar;
        this.f8601h = j2;
        this.f8602i = uVar;
        this.f8603j = e0Var;
        this.f8604k = uVar2;
        this.f8605l = uVar3;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 1) {
            r rVar = this.f8600g;
            if (rVar.f8816f) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            rVar.f8816f = true;
            if (jLongValue < this.f8601h) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            u uVar = this.f8602i;
            long jE = uVar.f8819f;
            e0 e0Var = this.f8603j;
            if (jE == 4294967295L) {
                jE = e0Var.e();
            }
            uVar.f8819f = jE;
            u uVar2 = this.f8604k;
            uVar2.f8819f = uVar2.f8819f == 4294967295L ? e0Var.e() : 0L;
            u uVar3 = this.f8605l;
            uVar3.f8819f = uVar3.f8819f == 4294967295L ? e0Var.e() : 0L;
        }
        return c7.r.f1986a;
    }
}
