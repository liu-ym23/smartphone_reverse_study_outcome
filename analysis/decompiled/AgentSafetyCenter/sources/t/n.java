package t;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class n {
    public static final void a(w0.m mVar, xb.l lVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-932836462);
        if ((i & 6) == 0) {
            i3 = (sVar.f(mVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (((i3 | (sVar.h(lVar) ? 32 : 16)) & 19) == 18 && sVar.B()) {
            sVar.S();
        } else {
            t0.a.b(sVar, androidx.compose.ui.draw.a.a(mVar, lVar));
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.c(mVar, i, 3, lVar);
        }
    }

    public static final x0.c b(int i) {
        x0.c cVar = new x0.c();
        cVar.f15513b = i;
        VarHandle.storeStoreFence();
        return cVar;
    }

    public static final void c(x.h hVar, Object obj, int i, Object obj2, k0.s sVar, int i3) {
        int i10;
        sVar.Z(1439843069);
        if ((i3 & 6) == 0) {
            i10 = (sVar.f(hVar) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        if ((i3 & 48) == 0) {
            i10 |= sVar.f(obj) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i10 |= sVar.d(i) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i3 & 3072) == 0) {
            i10 |= sVar.f(obj2) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i10 & 1171) == 1170 && sVar.B()) {
            sVar.S();
        } else {
            ((t0.c) obj).e(obj2, s0.h.d(980966366, new x.g(i, obj2, hVar), sVar), sVar, 48);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new y.v(hVar, obj, i, obj2, i3);
        }
    }

    public static final boolean d(z0.d dVar, long j10) {
        if (!dVar.f15114c.f15126r) {
            return false;
        }
        u1.s sVar = u1.f.u(dVar).H.f13743c;
        if (!sVar.R.f15126r) {
            return false;
        }
        long jD = sVar.D(0L);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jD >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jD & 4294967295L));
        long j11 = dVar.f16145v;
        float f5 = ((int) (j11 >> 32)) + fIntBitsToFloat;
        float f10 = ((int) (j11 & 4294967295L)) + fIntBitsToFloat2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j10 >> 32));
        if (fIntBitsToFloat > fIntBitsToFloat3 || fIntBitsToFloat3 > f5) {
            return false;
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        return fIntBitsToFloat2 <= fIntBitsToFloat4 && fIntBitsToFloat4 <= f10;
    }

    public static vc.f e(String str, o oVar, vc.e[] eVarArr) {
        if (hc.h.g0(str)) {
            g5.f.s("Blank serial names are prohibited");
            return null;
        }
        if (oVar.equals(vc.g.f14891b)) {
            g5.f.s("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            return null;
        }
        vc.a aVar = new vc.a(str);
        return new vc.f(str, oVar, aVar.f14868b.size(), kb.k.u0(eVarArr), aVar);
    }

    public static final long f(FileInputStream fileInputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = fileInputStream.read(bArr);
        long j10 = 0;
        while (i >= 0) {
            outputStream.write(bArr, 0, i);
            j10 += i;
            i = fileInputStream.read(bArr);
        }
        return j10;
    }

    public static stepos.support.v7.app.f g(List list, kc.t tVar, a1.b bVar) {
        list.getClass();
        y3.d dVar = new y3.d(bVar, 0);
        v3.d0 d0Var = new v3.d0();
        d0Var.f14619a = v3.c0.f14612c;
        d0Var.f14620b = dVar;
        VarHandle.storeStoreFence();
        r2.i iVar = new r2.i(24);
        nb.c cVar = null;
        List listE = ac.a.E(new t5.e(list, cVar, 5));
        v3.z zVar = new v3.z();
        zVar.f14752c = d0Var;
        zVar.f14753f = iVar;
        zVar.f14754g = tVar;
        zVar.f14755h = nc.k0.k(new androidx.lifecycle.l0(zVar, cVar, 26));
        zVar.i = new sc.c();
        androidx.room.k kVar = new androidx.room.k();
        kVar.f1564a = nc.k0.a(v3.r0.f14714b);
        VarHandle.storeStoreFence();
        zVar.f14758l = kVar;
        p5.i iVar2 = new p5.i();
        iVar2.f9733h = zVar;
        iVar2.f9730c = new sc.c();
        kc.l lVar = new kc.l(true);
        lVar.K(null);
        iVar2.f9731f = lVar;
        iVar2.f9732g = kb.l.L0(listE);
        VarHandle.storeStoreFence();
        zVar.f14759m = iVar2;
        zVar.f14760n = new jb.k(new v3.k(zVar, 1));
        zVar.f14761o = new jb.k(new v3.k(zVar, 0));
        a2.m mVar = new a2.m(zVar, 27);
        t5.e eVar = new t5.e(zVar, cVar, 7);
        p5.i iVar3 = new p5.i();
        iVar3.f9730c = tVar;
        iVar3.f9731f = eVar;
        int i = 6;
        iVar3.f9732g = h5.t.c(Reader.READ_DONE, 6, null);
        iVar3.f9733h = new sa.c(9);
        kc.x0 x0Var = (kc.x0) tVar.n().get(kc.w0.f7498c);
        if (x0Var != null) {
            x0Var.g(new v1.i0(i, mVar, iVar3));
        }
        VarHandle.storeStoreFence();
        zVar.f14762p = iVar3;
        VarHandle.storeStoreFence();
        int i3 = 15;
        stepos.support.v7.app.f fVar = new stepos.support.v7.app.f(i3);
        fVar.f12315f = zVar;
        VarHandle.storeStoreFence();
        stepos.support.v7.app.f fVar2 = new stepos.support.v7.app.f(i3);
        fVar2.f12315f = fVar;
        return fVar2;
    }

    public static String h(b9.a aVar) {
        Object next;
        String string;
        Map map = aVar.f2043b;
        kb.b bVarD = yb.k.d(new String[]{j(map.get("truth_id")), j(map.get("TRUTH_ID")), k(aVar.f2044c), j(map.get("_meta"))});
        while (true) {
            if (!bVarD.hasNext()) {
                next = null;
                break;
            }
            next = bVarD.next();
            String str = (String) next;
            if (str != null && !hc.h.g0(str)) {
                break;
            }
        }
        String str2 = (String) next;
        if (str2 == null || (string = hc.h.w0(str2).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public static t2.m i(t2.k kVar) {
        t2.j jVar = new t2.j();
        jVar.f13161c = new t2.n();
        t2.m mVar = new t2.m();
        t2.l lVar = new t2.l();
        lVar.f13163l = mVar;
        VarHandle.storeStoreFence();
        mVar.f13165f = lVar;
        mVar.f13164c = new WeakReference(jVar);
        VarHandle.storeStoreFence();
        jVar.f13160b = mVar;
        jVar.f13159a = kVar.getClass();
        try {
            Object objA = kVar.a(jVar);
            if (objA == null) {
                return mVar;
            }
            jVar.f13159a = objA;
            return mVar;
        } catch (Exception e10) {
            mVar.f13165f.i(e10);
            return mVar;
        }
    }

    public static String j(Object obj) {
        if (!(obj instanceof String)) {
            if (obj instanceof Map) {
                return k((Map) obj);
            }
            return null;
        }
        String string = hc.h.w0((String) obj).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    public static String k(Map map) {
        String string;
        String string2;
        if (map == null) {
            return null;
        }
        Object obj = map.get("truth_id");
        if (obj == null) {
            obj = map.get("TRUTH_ID");
        }
        if (obj == null || (string = obj.toString()) == null || (string2 = hc.h.w0(string).toString()) == null || string2.length() <= 0) {
            return null;
        }
        return string2;
    }

    public static final w.g0 l(f3.b bVar) {
        int i = bVar.f3900a;
        int i3 = bVar.f3901b;
        int i10 = bVar.f3902c;
        int i11 = bVar.f3903d;
        w.g0 g0Var = new w.g0();
        g0Var.f14976a = i;
        g0Var.f14977b = i3;
        g0Var.f14978c = i10;
        g0Var.f14979d = i11;
        VarHandle.storeStoreFence();
        return g0Var;
    }

    public static final boolean m(Throwable th, xb.a aVar) {
        Collection collectionAsList;
        Object objInvoke;
        th.getClass();
        Integer num = sb.a.f12172a;
        v0.d dVar = null;
        if (num == null || num.intValue() >= 19) {
            Throwable[] suppressed = th.getSuppressed();
            suppressed.getClass();
            collectionAsList = Arrays.asList(suppressed);
            collectionAsList.getClass();
        } else {
            Method method = rb.a.f10528b;
            if (method == null || (objInvoke = method.invoke(th, null)) == null) {
                collectionAsList = kb.s.f7404c;
            } else {
                collectionAsList = Arrays.asList((Throwable[]) objInvoke);
                collectionAsList.getClass();
            }
        }
        boolean z10 = false;
        if (!collectionAsList.isEmpty()) {
            Iterator it = collectionAsList.iterator();
            while (it.hasNext()) {
                if (((Throwable) it.next()) instanceof v0.d) {
                    return false;
                }
            }
        }
        try {
            List list = (List) aVar.invoke();
            boolean zIsEmpty = list.isEmpty();
            z10 = !zIsEmpty;
            if (!zIsEmpty) {
                dVar = new v0.d();
                dVar.f14320c = list;
                VarHandle.storeStoreFence();
            }
        } catch (Throwable th2) {
            dVar = th2;
        }
        if (dVar != null) {
            com.stepos.statsrpk.h.b(th, dVar);
        }
        return z10;
    }
}
