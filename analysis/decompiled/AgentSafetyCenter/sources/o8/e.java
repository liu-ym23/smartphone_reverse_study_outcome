package o8;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import d1.f0;
import h0.q1;
import java.lang.invoke.VarHandle;
import java.util.List;
import k0.s;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final long f9307a = f0.c(4278913804L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f9308b = f0.c(4294309367L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f9309c = f0.c(4287532691L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f9310d = f0.c(4281303295L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f9311e = f0.c(4282006076L);

    public static final void a(List list, xb.a aVar, s sVar, int i) {
        String strP;
        sVar.Z(-1108476733);
        int i3 = (sVar.h(list) ? 4 : 2) | i | (sVar.h(aVar) ? 32 : 16);
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            String strB0 = kb.l.B0(list, "、", null, null, null, 62);
            String strO = t2.a.o(R.string.auth_gate_a11y_title, sVar);
            if (hc.h.g0(strB0)) {
                sVar.X(1373469979);
                strP = t2.a.o(R.string.auth_gate_a11y_body, sVar);
                sVar.q(false);
            } else {
                sVar.X(1373543790);
                strP = t2.a.p(R.string.auth_gate_a11y_body_named, new Object[]{strB0}, sVar);
                sVar.q(false);
            }
            e(strO, strP, t2.a.o(R.string.auth_gate_a11y_action_settings, sVar), aVar, null, null, sVar, (i3 << 6) & 7168, 48);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            j9.i iVar = new j9.i(3);
            iVar.f6671f = list;
            iVar.f6672g = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = iVar;
        }
    }

    public static final void b(xb.a aVar, xb.a aVar2, s sVar, int i) {
        xb.a aVar3;
        xb.a aVar4;
        s sVar2;
        sVar.Z(418506148);
        int i3 = i | (sVar.h(aVar) ? 4 : 2) | (sVar.h(aVar2) ? 32 : 16);
        int i10 = 1;
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            aVar3 = aVar;
            aVar4 = aVar2;
            sVar2 = sVar;
            e(t2.a.o(R.string.auth_gate_canceled_title, sVar), t2.a.o(R.string.auth_gate_canceled_body, sVar), t2.a.o(R.string.auth_gate_canceled_retry, sVar), aVar3, t2.a.o(R.string.auth_gate_canceled_settings, sVar), aVar4, sVar2, ((i3 << 9) & 7168) | ((i3 << 12) & 458752), 0);
        } else {
            aVar3 = aVar;
            aVar4 = aVar2;
            sVar2 = sVar;
            sVar2.S();
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            j9.s sVar3 = new j9.s(i10);
            sVar3.f6715f = aVar3;
            sVar3.f6716g = aVar4;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = sVar3;
        }
    }

    public static final void c(i iVar, xb.a aVar, xb.a aVar2, s sVar, int i) {
        iVar.getClass();
        aVar.getClass();
        aVar2.getClass();
        sVar.Z(282742969);
        int i3 = i | (sVar.f(iVar) ? 4 : 2) | (sVar.h(aVar) ? 32 : 16) | (sVar.h(aVar2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        int i10 = 0;
        int i11 = 1;
        if (sVar.P(i3 & 1, (i3 & 147) != 146)) {
            a aVar3 = new a(i10);
            aVar3.f9290f = iVar;
            aVar3.f9291g = aVar;
            aVar3.f9292h = aVar2;
            VarHandle.storeStoreFence();
            o9.c.a(false, false, s0.h.d(1919272941, aVar3, sVar), sVar, 384);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            a aVar4 = new a(i11);
            aVar4.f9290f = iVar;
            aVar4.f9291g = aVar;
            aVar4.f9292h = aVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = aVar4;
        }
    }

    public static final void d(String str, long j10, long j11, xb.a aVar, s sVar, int i) {
        int i3;
        sVar.Z(-495645818);
        if ((i & 6) == 0) {
            i3 = (sVar.f(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.e(j10) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.e(j11) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar.h(aVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        int i10 = 0;
        if (sVar.P(i3 & 1, (i3 & 1171) != 1170)) {
            a0.d dVarA = a0.e.a(14);
            w0.m mVarE = androidx.compose.foundation.a.e(androidx.compose.foundation.layout.c.c(androidx.compose.foundation.layout.c.b(w0.j.f15113c, 1.0f), 48), false, null, aVar, 7);
            c cVar = new c(i10);
            cVar.f9301f = str;
            cVar.f9302g = j11;
            VarHandle.storeStoreFence();
            q1.a(mVarE, dVarA, j10, 0L, 0.0f, 0.0f, s0.h.d(-1729087199, cVar, sVar), sVar, ((i3 << 3) & 896) | 12582912, 120);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            d dVar = new d();
            dVar.f9303c = str;
            dVar.f9304f = j10;
            dVar.f9305g = j11;
            dVar.f9306h = aVar;
            dVar.i = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = dVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(java.lang.String r33, java.lang.String r34, java.lang.String r35, xb.a r36, java.lang.String r37, xb.a r38, k0.s r39, int r40, int r41) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o8.e.e(java.lang.String, java.lang.String, java.lang.String, xb.a, java.lang.String, xb.a, k0.s, int, int):void");
    }
}
