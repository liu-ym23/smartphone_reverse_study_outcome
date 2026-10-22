package h0;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final w0.m f5092a = androidx.compose.foundation.layout.c.f(w0.j.f15113c, j0.h.f6439a);

    /* JADX WARN: Removed duplicated region for block: B:78:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(h1.b r16, java.lang.String r17, w0.m r18, long r19, k0.s r21, int r22) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.o0.a(h1.b, java.lang.String, w0.m, long, k0.s, int):void");
    }

    public static final void b(i1.f fVar, w0.m mVar, long j10, k0.s sVar, int i) {
        int i3;
        k0.s sVar2;
        w0.m mVar2;
        long j11;
        sVar.Z(-126890956);
        if ((i & 6) == 0) {
            i3 = (sVar.f(fVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.f(null) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar.e(j10) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i3 & 1171) == 1170 && sVar.B()) {
            sVar.S();
            sVar2 = sVar;
            j11 = j10;
            mVar2 = mVar;
        } else {
            sVar.U();
            if ((i & 1) != 0 && !sVar.z()) {
                sVar.S();
            }
            sVar.r();
            sVar2 = sVar;
            a(i1.b.c(fVar, sVar), null, mVar, j10, sVar2, (i3 & 112) | 8 | (i3 & 896) | (i3 & 7168));
            mVar2 = mVar;
            j11 = j10;
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new m0(fVar, mVar2, j11, i);
        }
    }
}
