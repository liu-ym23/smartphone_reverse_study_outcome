package pd;

import java.io.IOException;
import jb.v;
import od.c0;
import xb.p;
import yb.l;
import yb.q;
import yb.t;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends l implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f10033c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f10034f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f10035g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c0 f10036h;
    public final /* synthetic */ t i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t f10037j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ u f10038k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ u f10039l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ u f10040m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(q qVar, long j10, t tVar, c0 c0Var, t tVar2, t tVar3, u uVar, u uVar2, u uVar3) {
        super(2);
        this.f10033c = qVar;
        this.f10034f = j10;
        this.f10035g = tVar;
        this.f10036h = c0Var;
        this.i = tVar2;
        this.f10037j = tVar3;
        this.f10038k = uVar;
        this.f10039l = uVar2;
        this.f10040m = uVar3;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        c0 c0Var = this.f10036h;
        if (iIntValue == 1) {
            q qVar = this.f10033c;
            if (qVar.f16094c) {
                od.f.l("bad zip: zip64 extra repeated");
                return null;
            }
            qVar.f16094c = true;
            if (jLongValue < this.f10034f) {
                od.f.l("bad zip: zip64 extra too short");
                return null;
            }
            t tVar = this.f10035g;
            long jR = tVar.f16097c;
            if (jR == 4294967295L) {
                jR = c0Var.r();
            }
            tVar.f16097c = jR;
            t tVar2 = this.i;
            tVar2.f16097c = tVar2.f16097c == 4294967295L ? c0Var.r() : 0L;
            t tVar3 = this.f10037j;
            tVar3.f16097c = tVar3.f16097c == 4294967295L ? c0Var.r() : 0L;
        } else if (iIntValue == 10) {
            if (jLongValue < 4) {
                od.f.l("bad zip: NTFS extra too short");
                return null;
            }
            c0Var.M(4L);
            b.e(c0Var, (int) (jLongValue - 4), new h(this.f10038k, c0Var, this.f10039l, this.f10040m));
        }
        return v.f6774a;
    }
}
