package n4;

import c5.m;
import java.util.List;
import k4.k;
import k4.q;
import k4.t;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public final q f3982a;

    public i(q qVar) {
        this.f3982a = qVar;
        b5.f fVar = b5.f.f890b;
        final int i8 = 0;
        b8.h.w(fVar, new p5.a(this) { // from class: n4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f3979b;

            {
                this.f3979b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i9 = i8;
                i iVar = this.f3979b;
                switch (i9) {
                    case 0:
                        q qVar2 = iVar.f3982a;
                        List list = t.f3636a;
                        String strD = qVar2.d("Content-Disposition");
                        if (strD == null) {
                            return null;
                        }
                        int i10 = k4.c.d;
                        k kVar = (k) m.B0(b8.h.G(strD));
                        return new k4.c(kVar.f3625a, kVar.f3626b);
                    default:
                        q qVar3 = iVar.f3982a;
                        List list2 = t.f3636a;
                        String strD2 = qVar3.d("Content-Type");
                        if (strD2 == null) {
                            return null;
                        }
                        k4.g gVar = k4.g.f3611f;
                        return b8.h.F(strD2);
                }
            }
        });
        final int i9 = 1;
        b8.h.w(fVar, new p5.a(this) { // from class: n4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f3979b;

            {
                this.f3979b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i92 = i9;
                i iVar = this.f3979b;
                switch (i92) {
                    case 0:
                        q qVar2 = iVar.f3982a;
                        List list = t.f3636a;
                        String strD = qVar2.d("Content-Disposition");
                        if (strD == null) {
                            return null;
                        }
                        int i10 = k4.c.d;
                        k kVar = (k) m.B0(b8.h.G(strD));
                        return new k4.c(kVar.f3625a, kVar.f3626b);
                    default:
                        q qVar3 = iVar.f3982a;
                        List list2 = t.f3636a;
                        String strD2 = qVar3.d("Content-Type");
                        if (strD2 == null) {
                            return null;
                        }
                        k4.g gVar = k4.g.f3611f;
                        return b8.h.F(strD2);
                }
            }
        });
    }
}
