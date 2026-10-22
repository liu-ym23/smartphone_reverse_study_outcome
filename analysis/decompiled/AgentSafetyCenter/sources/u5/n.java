package u5;

import androidx.recyclerview.widget.RecyclerView;
import coil.compose.ContentPainterElement;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;
import k0.v1;
import u1.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final m f14080a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final u f14081b = new u();

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(u5.o r17, w0.m r18, xb.l r19, w0.e r20, s1.j r21, k0.s r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.n.a(u5.o, w0.m, xb.l, w0.e, s1.j, k0.s, int, int):void");
    }

    public static final void b(w0.m mVar, l lVar, w0.e eVar, s1.j jVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(777774312);
        if ((i & 14) == 0) {
            i3 = (sVar.f(mVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= sVar.f(lVar) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= sVar.f(null) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 7168) == 0) {
            i3 |= sVar.f(eVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((57344 & i) == 0) {
            i3 |= sVar.f(jVar) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i3 |= sVar.c(1.0f) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i3 |= sVar.f(null) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i3 |= sVar.g(true) ? 8388608 : 4194304;
        }
        if ((i3 & 23967451) == 4793490 && sVar.B()) {
            sVar.S();
        } else {
            f6.e eVar2 = w.f14106b;
            w0.m mVarH = com.stepos.statsrpk.h.h(mVar);
            ContentPainterElement contentPainterElement = new ContentPainterElement();
            contentPainterElement.f2281c = lVar;
            contentPainterElement.f2282f = eVar;
            contentPainterElement.f2283g = jVar;
            contentPainterElement.f2284h = 1.0f;
            VarHandle.storeStoreFence();
            w0.m mVarD = mVarH.d(contentPainterElement);
            sVar.Y(544976794);
            int iHashCode = Long.hashCode(sVar.T);
            w0.m mVarM = t.o.m(sVar, mVarD);
            s0.g gVarL = sVar.l();
            u1.j.f13840e.getClass();
            z zVar = u1.i.f13833b;
            sVar.Y(1405779621);
            sVar.b0();
            if (sVar.S) {
                sVar.k(new ad.l(zVar, 27));
            } else {
                sVar.l0();
            }
            k0.z.B(b.f14051a, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            sVar.q(true);
            sVar.q(false);
            sVar.q(false);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            a aVar = new a();
            aVar.f14047c = mVar;
            aVar.f14048f = lVar;
            aVar.f14049g = eVar;
            aVar.f14050h = jVar;
            aVar.i = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = aVar;
        }
    }

    public static void c(String str) {
        throw new IllegalArgumentException(androidx.activity.b.j("Unsupported type: ", str, ". ", k0.a.C("If you wish to display this ", str, ", use androidx.compose.foundation.Image.")));
    }

    public static final void d(e6.i iVar) {
        Object obj = iVar.f3548b;
        if (obj instanceof e6.h) {
            g5.f.s("Unsupported type: ImageRequest.Builder. Did you forget to call ImageRequest.Builder.build()?");
            return;
        }
        if (obj instanceof d1.e) {
            c("ImageBitmap");
            throw null;
        }
        if (obj instanceof i1.f) {
            c("ImageVector");
            throw null;
        }
        if (obj instanceof h1.b) {
            c("Painter");
            throw null;
        }
        if (iVar.f3549c == null) {
            return;
        }
        g5.f.s("request.target must be null.");
    }
}
