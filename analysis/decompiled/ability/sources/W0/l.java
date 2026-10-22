package W0;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class l implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1483a;

    public /* synthetic */ l(int i) {
        this.f1483a = i;
    }

    @Override // W0.n
    public final String a() {
        switch (this.f1483a) {
            case 0:
                return "exception";
            default:
                return "trace";
        }
    }

    @Override // W0.n
    public final ArrayList b() {
        switch (this.f1483a) {
            case 0:
                g gVar = f.f1476a;
                T0.a aVar = gVar.l;
                return (aVar == null || S0.b.r0(aVar.c)) ? gVar.h : gVar.l.c;
            default:
                g gVar2 = f.f1476a;
                T0.a aVar2 = gVar2.l;
                return (aVar2 == null || S0.b.r0(aVar2.d)) ? gVar2.g : gVar2.l.d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073 A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:14:0x0035, B:30:0x006c, B:33:0x0073, B:34:0x0077, B:36:0x007d, B:38:0x0088, B:17:0x003d, B:19:0x004c, B:22:0x0052, B:26:0x005c), top: B:67:0x0035, outer: #3 }] */
    @Override // W0.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] c(java.util.HashMap r12) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.l.c(java.util.HashMap):byte[]");
    }
}
