package pd;

import java.io.IOException;
import jb.v;
import od.c0;
import xb.p;
import yb.l;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends l implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10029c = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c0 f10030f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ u f10031g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u f10032h;
    public final /* synthetic */ u i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c0 c0Var, u uVar, u uVar2, u uVar3) {
        super(2);
        this.f10030f = c0Var;
        this.f10031g = uVar;
        this.f10032h = uVar2;
        this.i = uVar3;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        switch (this.f10029c) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                long jLongValue = ((Number) obj2).longValue();
                if (iIntValue == 1) {
                    u uVar = this.f10031g;
                    if (uVar.f16098c != null) {
                        od.f.l("bad zip: NTFS extra attribute tag 0x0001 repeated");
                        break;
                    } else if (jLongValue != 24) {
                        od.f.l("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                        break;
                    } else {
                        c0 c0Var = this.f10030f;
                        uVar.f16098c = Long.valueOf(c0Var.r());
                        this.f10032h.f16098c = Long.valueOf(c0Var.r());
                        this.i.f16098c = Long.valueOf(c0Var.r());
                    }
                }
                break;
            default:
                int iIntValue2 = ((Number) obj).intValue();
                long jLongValue2 = ((Number) obj2).longValue();
                if (iIntValue2 == 21589) {
                    if (jLongValue2 < 1) {
                        od.f.l("bad zip: extended timestamp extra too short");
                        break;
                    } else {
                        c0 c0Var2 = this.f10030f;
                        byte bG = c0Var2.g();
                        boolean z10 = (bG & 1) == 1;
                        boolean z11 = (bG & 2) == 2;
                        boolean z12 = (bG & 4) == 4;
                        long j10 = z10 ? 5L : 1L;
                        if (z11) {
                            j10 += 4;
                        }
                        if (z12) {
                            j10 += 4;
                        }
                        if (jLongValue2 < j10) {
                            od.f.l("bad zip: extended timestamp extra too short");
                            break;
                        } else {
                            if (z10) {
                                this.f10031g.f16098c = Integer.valueOf(c0Var2.o());
                            }
                            if (z11) {
                                this.f10032h.f16098c = Integer.valueOf(c0Var2.o());
                            }
                            if (z12) {
                                this.i.f16098c = Integer.valueOf(c0Var2.o());
                            }
                        }
                    }
                }
                break;
        }
        return v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(u uVar, c0 c0Var, u uVar2, u uVar3) {
        super(2);
        this.f10031g = uVar;
        this.f10030f = c0Var;
        this.f10032h = uVar2;
        this.i = uVar3;
    }
}
