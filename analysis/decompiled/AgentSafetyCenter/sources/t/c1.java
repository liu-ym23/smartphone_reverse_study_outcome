package t;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillId;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k0.s1;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c1 {
    public static final void a(Object obj, int i, y.b0 b0Var, s0.c cVar, k0.s sVar, int i3) {
        int i10;
        sVar.Z(-2079116560);
        if ((i3 & 6) == 0) {
            i10 = (sVar.h(obj) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        if ((i3 & 48) == 0) {
            i10 |= sVar.d(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i10 |= sVar.h(b0Var) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i3 & 3072) == 0) {
            i10 |= sVar.h(cVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i10 & 1171) == 1170 && sVar.B()) {
            sVar.S();
        } else {
            boolean zF = sVar.f(obj) | sVar.f(b0Var);
            Object objM = sVar.M();
            Object obj2 = k0.m.f6974a;
            Object obj3 = objM;
            if (zF || objM == obj2) {
                y.z zVar = new y.z();
                zVar.f15839a = obj;
                zVar.f15840b = b0Var;
                zVar.f15841c = new k0.h1(-1);
                zVar.f15842d = new k0.h1(0);
                zVar.f15843e = k0.z.v(null);
                zVar.f15844f = k0.z.v(null);
                VarHandle.storeStoreFence();
                sVar.i0(zVar);
                obj3 = zVar;
            }
            y.z zVar2 = (y.z) obj3;
            k0.h1 h1Var = zVar2.f15841c;
            k0.k1 k1Var = zVar2.f15843e;
            k0.k1 k1Var2 = zVar2.f15844f;
            h1Var.h(i);
            s1 s1Var = s1.m0.f11267a;
            y.z zVar3 = (y.z) sVar.j(s1Var);
            u0.f fVarD = u0.r.d();
            xb.l lVarE = fVarD != null ? fVarD.e() : null;
            u0.f fVarG = u0.r.g(fVarD);
            try {
                if (zVar3 != ((y.z) k1Var2.getValue())) {
                    k1Var2.setValue(zVar3);
                    if (zVar2.f15842d.g() > 0) {
                        y.z zVar4 = (y.z) k1Var.getValue();
                        if (zVar4 != null) {
                            zVar4.b();
                        }
                        if (zVar3 != null) {
                            zVar3.a();
                        } else {
                            zVar3 = null;
                        }
                        k1Var.setValue(zVar3);
                    }
                }
                u0.r.j(fVarD, fVarG, lVarE);
                boolean zF2 = sVar.f(zVar2);
                Object objM2 = sVar.M();
                if (zF2 || objM2 == obj2) {
                    objM2 = new y.a0(zVar2, 0);
                    sVar.i0(objM2);
                }
                k0.z.d(zVar2, (xb.l) objM2, sVar);
                k0.z.a(s1Var.a(zVar2), cVar, sVar, ((i10 >> 6) & 112) | 8);
            } catch (Throwable th) {
                u0.r.j(fVarD, fVarG, lVarE);
                throw th;
            }
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new y.v(obj, i, b0Var, cVar, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ad.z b(xb.l lVar) {
        ad.z zVar = new ad.z(4);
        zVar.f637b = (yb.l) lVar;
        u.l lVar2 = new u.l();
        lVar2.f13521a = zVar;
        VarHandle.storeStoreFence();
        zVar.f638c = lVar2;
        x0 x0Var = new x0();
        x0Var.f13087a = new AtomicReference(null);
        x0Var.f13088b = new sc.c();
        VarHandle.storeStoreFence();
        zVar.f639d = x0Var;
        Boolean bool = Boolean.FALSE;
        zVar.f640e = k0.z.v(bool);
        zVar.f641f = k0.z.v(bool);
        zVar.f642g = k0.z.v(bool);
        VarHandle.storeStoreFence();
        return zVar;
    }

    public static final boolean e(ArrayList arrayList) {
        List list;
        long j10;
        if (arrayList.size() >= 2) {
            if (arrayList.size() <= 1) {
                list = kb.s.f7404c;
            } else {
                ArrayList arrayList2 = new ArrayList();
                Object obj = arrayList.get(0);
                int size = arrayList.size() - 1;
                int i = 0;
                while (i < size) {
                    i++;
                    Object obj2 = arrayList.get(i);
                    a2.p pVar = (a2.p) obj2;
                    a2.p pVar2 = (a2.p) obj;
                    float fAbs = Math.abs(Float.intBitsToFloat((int) (pVar2.g().a() >> 32)) - Float.intBitsToFloat((int) (pVar.g().a() >> 32)));
                    float fAbs2 = Math.abs(Float.intBitsToFloat((int) (pVar2.g().a() & 4294967295L)) - Float.intBitsToFloat((int) (pVar.g().a() & 4294967295L)));
                    arrayList2.add(c1.b.a((Float.floatToRawIntBits(fAbs) << 32) | (Float.floatToRawIntBits(fAbs2) & 4294967295L)));
                    obj = obj2;
                }
                list = arrayList2;
            }
            if (list.size() == 1) {
                j10 = ((c1.b) kb.l.w0(list)).f2165a;
            } else {
                if (list.isEmpty()) {
                    q2.a.b("Empty collection can't be reduced.");
                }
                Object objW0 = kb.l.w0(list);
                int size2 = list.size() - 1;
                if (1 <= size2) {
                    int i3 = 1;
                    while (true) {
                        objW0 = c1.b.a(c1.b.h(((c1.b) objW0).f2165a, ((c1.b) list.get(i3)).f2165a));
                        if (i3 == size2) {
                            break;
                        }
                        i3++;
                    }
                }
                j10 = ((c1.b) objW0).f2165a;
            }
            if (Float.intBitsToFloat((int) (4294967295L & j10)) >= Float.intBitsToFloat((int) (j10 >> 32))) {
                return false;
            }
        }
        return true;
    }

    public static final double f(int i, int i3, int i10, int i11, f6.f fVar) {
        double d7 = i10 / i;
        double d10 = i11 / i3;
        int iOrdinal = fVar.ordinal();
        if (iOrdinal == 0) {
            return Math.max(d7, d10);
        }
        if (iOrdinal == 1) {
            return Math.min(d7, d10);
        }
        g5.f.a();
        return 0.0d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final t5.g g(Context context) {
        a4.n nVar = new a4.n();
        Context applicationContext = context.getApplicationContext();
        nVar.f190a = applicationContext;
        e6.c cVar = i6.c.f5803a;
        v5.l lVar = v5.l.f14795c;
        i6.e eVar = new i6.e();
        VarHandle.storeStoreFence();
        VarHandle.storeStoreFence();
        t5.d dVar = new t5.d(0);
        dVar.f13180f = nVar;
        VarHandle.storeStoreFence();
        jb.k kVar = new jb.k(dVar);
        int i = 1;
        t5.d dVar2 = new t5.d(i);
        dVar2.f13180f = nVar;
        VarHandle.storeStoreFence();
        jb.k kVar2 = new jb.k(dVar2);
        jb.k kVar3 = new jb.k(new androidx.room.c(20));
        t5.g gVar = new t5.g();
        gVar.f13192a = applicationContext;
        gVar.f13193b = cVar;
        gVar.f13194c = kVar;
        gVar.f13195d = eVar;
        kc.k1 k1VarC = kc.w.c();
        rc.e eVar2 = kc.e0.f7430a;
        kc.w.a(ac.a.N(k1VarC, pc.n.f9978a.i).plus(new g2.g(gVar)));
        i6.f fVar = new i6.f();
        fVar.f5808c = new WeakReference(gVar);
        fVar.i = true;
        VarHandle.storeStoreFence();
        int i3 = 4;
        p5.e eVar3 = new p5.e(i3);
        eVar3.f9722f = fVar;
        eVar3.f9723g = new i6.e();
        VarHandle.storeStoreFence();
        gVar.f13196e = eVar3;
        ad.y yVar = new ad.y();
        kb.s sVar = kb.s.f7404c;
        yVar.f631a = new ArrayList(sVar);
        yVar.f632b = new ArrayList(sVar);
        yVar.f633c = new ArrayList(sVar);
        yVar.f634d = new ArrayList(sVar);
        yVar.f635e = new ArrayList(sVar);
        VarHandle.storeStoreFence();
        yVar.c(new b6.a(2), ad.q.class);
        int i10 = 5;
        yVar.c(new b6.a(i10), String.class);
        yVar.c(new b6.a(i), Uri.class);
        yVar.c(new b6.a(i3), Uri.class);
        int i11 = 3;
        yVar.c(new b6.a(i11), Integer.class);
        yVar.c(new b6.a(0 == true ? 1 : 0), byte[].class);
        ((ArrayList) yVar.f633c).add(new jb.g(new a6.a(1), Uri.class));
        a6.a aVar = new a6.a(0);
        VarHandle.storeStoreFence();
        ((ArrayList) yVar.f633c).add(new jb.g(aVar, File.class));
        y5.i iVar = new y5.i();
        iVar.f15909a = kVar3;
        iVar.f15910b = kVar2;
        VarHandle.storeStoreFence();
        yVar.d(iVar, Uri.class);
        yVar.d(new y5.a(i10), File.class);
        yVar.d(new y5.a(0 == true ? 1 : 0), Uri.class);
        yVar.d(new y5.a(i11), Uri.class);
        yVar.d(new y5.a(6), Uri.class);
        yVar.d(new y5.a(i3), Drawable.class);
        yVar.d(new y5.a(1), Bitmap.class);
        yVar.d(new y5.a(2), ByteBuffer.class);
        v5.b bVar = new v5.b();
        bVar.f14773a = lVar;
        int i12 = sc.i.f12185a;
        bVar.f14774b = new sc.h(4);
        VarHandle.storeStoreFence();
        ((ArrayList) yVar.f635e).add(bVar);
        t5.b bVarF = yVar.f();
        gVar.f13197f = bVarF;
        List list = bVarF.f13173a;
        z5.f fVar2 = new z5.f();
        fVar2.f16447a = gVar;
        fVar2.f16448b = fVar;
        fVar2.f16449c = eVar3;
        a1.g gVar2 = new a1.g(i10, (boolean) (0 == true ? 1 : 0));
        gVar2.f19f = gVar;
        VarHandle.storeStoreFence();
        fVar2.f16450d = gVar2;
        VarHandle.storeStoreFence();
        gVar.f13198g = kb.l.G0(list, fVar2);
        new AtomicBoolean(false);
        VarHandle.storeStoreFence();
        return gVar;
    }

    public static sa.c h(View view) {
        AutofillId autofillId = view.getAutofillId();
        sa.c cVar = new sa.c(13, false);
        cVar.f12170f = autofillId;
        VarHandle.storeStoreFence();
        return cVar;
    }

    public static final String j(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i = reader.read(cArr);
        while (i >= 0) {
            stringWriter.write(cArr, 0, i);
            i = reader.read(cArr);
        }
        String string = stringWriter.toString();
        string.getClass();
        return string;
    }

    public static final h1 k(k0.s sVar) {
        int i = 0;
        Object[] objArr = new Object[0];
        p5.u uVar = h1.i;
        boolean zD = sVar.d(0);
        Object objM = sVar.M();
        if (zD || objM == k0.m.f6974a) {
            objM = new p0(i, 2);
            sVar.i0(objM);
        }
        return (h1) t0.a.j(objArr, uVar, (xb.a) objM, sVar, 0, 4);
    }

    public static final void l(a2.p pVar, o3.e eVar) {
        Object objG = pVar.k().f75c.g(a2.u.f123g);
        if (objG == null) {
            objG = null;
        }
        if (objG != null) {
            od.f.j();
            return;
        }
        a2.p pVarL = pVar.l();
        if (pVarL == null) {
            return;
        }
        Object objG2 = pVarL.k().f75c.g(a2.u.f121e);
        if (objG2 == null) {
            objG2 = null;
        }
        if (objG2 != null) {
            Object objG3 = pVarL.k().f75c.g(a2.u.f122f);
            a2.b bVar = (a2.b) (objG3 != null ? objG3 : null);
            if (bVar == null || (bVar.f33a >= 0 && bVar.f34b >= 0)) {
                if (pVar.k().f75c.c(a2.u.F)) {
                    ArrayList arrayList = new ArrayList();
                    List listJ = a2.p.j(4, pVarL);
                    int size = listJ.size();
                    int i = 0;
                    for (int i3 = 0; i3 < size; i3++) {
                        a2.p pVar2 = (a2.p) listJ.get(i3);
                        if (pVar2.k().f75c.c(a2.u.F)) {
                            arrayList.add(pVar2);
                            if (pVar2.f87c.u() < pVar.f87c.u()) {
                                i++;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    boolean zE = e(arrayList);
                    int i10 = zE ? 0 : i;
                    int i11 = zE ? i : 0;
                    Object objG4 = pVar.k().f75c.g(a2.u.F);
                    if (objG4 == null) {
                        objG4 = Boolean.FALSE;
                    }
                    eVar.f9149a.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, 1, i11, 1, false, ((Boolean) objG4).booleanValue()));
                }
            }
        }
    }

    public static w0.m n(w0.m mVar, h1 h1Var) {
        androidx.compose.foundation.d dVar = new androidx.compose.foundation.d(h1Var, true);
        w0.h hVar = new w0.h();
        hVar.f15111f = dVar;
        VarHandle.storeStoreFence();
        return mVar.d(hVar);
    }

    public abstract int c(int i, o2.l lVar, s1.o0 o0Var, int i3);

    public Integer d(s1.o0 o0Var) {
        return null;
    }

    public abstract float i(Object obj);

    public abstract void m(float f5, Object obj);
}
