package h0;

import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i1 {

    /* renamed from: a, reason: collision with root package name */
    public static final float f5014a = 16;

    /* JADX WARN: Removed duplicated region for block: B:69:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(w0.m r23, xb.p r24, xb.p r25, xb.p r26, xb.p r27, int r28, long r29, long r31, w.y0 r33, s0.c r34, k0.s r35, int r36) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.i1.a(w0.m, xb.p, xb.p, xb.p, xb.p, int, long, long, w.y0, s0.c, k0.s, int):void");
    }

    public static final void b(int i, xb.p pVar, s0.c cVar, xb.p pVar2, xb.p pVar3, w.y0 y0Var, xb.p pVar4, k0.s sVar, int i3) {
        int i10;
        s0.c cVar2;
        w.y0 y0Var2;
        xb.p pVar5;
        sVar.Z(-975511942);
        if ((i3 & 6) == 0) {
            i10 = (sVar.d(i) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        if ((i3 & 48) == 0) {
            i10 |= sVar.h(pVar) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            cVar2 = cVar;
            i10 |= sVar.h(cVar2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        } else {
            cVar2 = cVar;
        }
        if ((i3 & 3072) == 0) {
            i10 |= sVar.h(pVar2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i10 |= sVar.h(pVar3) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            y0Var2 = y0Var;
            i10 |= sVar.f(y0Var2) ? 131072 : 65536;
        } else {
            y0Var2 = y0Var;
        }
        if ((1572864 & i3) == 0) {
            pVar5 = pVar4;
            i10 |= sVar.h(pVar5) ? 1048576 : 524288;
        } else {
            pVar5 = pVar4;
        }
        if ((i10 & 599187) == 599186 && sVar.B()) {
            sVar.S();
        } else {
            boolean z10 = ((i10 & 896) == 256) | ((i10 & 112) == 32) | ((i10 & 7168) == 2048) | ((458752 & i10) == 131072) | ((57344 & i10) == 16384) | ((i10 & 14) == 4) | ((3670016 & i10) == 1048576);
            Object objM = sVar.M();
            if (z10 || objM == k0.m.f6974a) {
                e1 e1Var = new e1(pVar, pVar2, pVar3, i, y0Var2, pVar5, cVar2);
                sVar.i0(e1Var);
                objM = e1Var;
            }
            s1.v0.c(null, (xb.p) objM, sVar, 0, 1);
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new h1(i, pVar, cVar, pVar2, pVar3, y0Var, pVar4, i3);
        }
    }
}
