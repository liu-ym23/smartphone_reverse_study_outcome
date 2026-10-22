package e9;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import h0.b1;
import h0.q1;
import java.lang.invoke.VarHandle;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f3653a = d1.f0.c(4282006076L);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3654b = 0;

    public static final void a(boolean z10, String str, String str2, String str3, String str4, xb.a aVar, xb.a aVar2, xb.a aVar3, w0.m mVar, k0.s sVar, int i) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        aVar.getClass();
        aVar2.getClass();
        aVar3.getClass();
        sVar.Z(316406953);
        int i3 = i | (sVar.g(z10) ? 4 : 2) | (sVar.f(str) ? 32 : 16) | (sVar.f(str2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.f(str3) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.f(str4) ? 16384 : 8192);
        if ((i & 196608) == 0) {
            i3 |= sVar.h(aVar) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= sVar.h(aVar2) ? 1048576 : 524288;
        }
        int i10 = 0;
        if (sVar.P(i3 & 1, (306783379 & i3) != 306783378)) {
            long j10 = j9.b0.f6643l;
            b0 b0Var = new b0(i10);
            b0Var.f3618f = str;
            b0Var.f3619g = str2;
            b0Var.f3620h = str3;
            b0Var.f3621j = aVar;
            b0Var.i = str4;
            b0Var.f3622k = aVar2;
            VarHandle.storeStoreFence();
            n9.c.a(z10, aVar3, mVar, j10, false, s0.h.d(462025847, b0Var, sVar), sVar, (i3 & 14) | 200112, 16);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            c0 c0Var = new c0();
            c0Var.f3623c = z10;
            c0Var.f3624f = str;
            c0Var.f3625g = str2;
            c0Var.f3626h = str3;
            c0Var.i = str4;
            c0Var.f3627j = aVar;
            c0Var.f3628k = aVar2;
            c0Var.f3629l = aVar3;
            c0Var.f3630m = mVar;
            c0Var.f3631n = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = c0Var;
        }
    }

    public static final void b(String str, boolean z10, xb.a aVar, w0.m mVar, k0.s sVar, int i) {
        int i3;
        xb.a aVar2 = aVar;
        w0.m mVar2 = mVar;
        sVar.Z(-760836420);
        int i10 = i | (sVar.f(str) ? 4 : 2) | (sVar.g(z10) ? 32 : 16) | (sVar.h(aVar2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.f(mVar2) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024);
        int i11 = 0;
        if (!sVar.P(i10 & 1, (i10 & 1171) != 1170)) {
            i3 = 0;
            sVar.S();
        } else if (z10) {
            sVar.X(-1535174034);
            w0.m mVarH = androidx.compose.foundation.layout.b.h(mVar2, 4, 0.0f, 2);
            a0.d dVarA = a0.e.a(12);
            d0 d0Var = new d0(i11);
            d0Var.f3637f = str;
            VarHandle.storeStoreFence();
            i3 = 0;
            q1.b(aVar2, mVarH, false, dVarA, f3653a, 0L, 0.0f, null, null, s0.h.d(970039330, d0Var, sVar), sVar, ((i10 >> 6) & 14) | 24576, 996);
            sVar.q(false);
            aVar2 = aVar;
            mVar2 = mVar;
        } else {
            i3 = 0;
            sVar.X(-1534614577);
            e0 e0Var = new e0(i3);
            e0Var.f3643f = str;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(52132189, e0Var, sVar);
            int i12 = i10 >> 6;
            int i13 = (i12 & 14) | 805306368 | (i12 & 112);
            aVar2 = aVar;
            mVar2 = mVar;
            b1.e(aVar2, mVar2, false, null, null, null, cVarD, sVar, i13, 508);
            sVar.q(false);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            f0 f0Var = new f0(i3);
            f0Var.i = str;
            f0Var.f3647f = z10;
            f0Var.f3648g = aVar2;
            f0Var.f3649h = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = f0Var;
        }
    }
}
