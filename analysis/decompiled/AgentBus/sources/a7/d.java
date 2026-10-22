package a7;

import a4.u;
import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.profileinstaller.ProfileInstallReceiver;
import b0.f2;
import c1.m;
import c7.r;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import f8.l;
import f8.l0;
import f8.t;
import f8.z;
import g9.h;
import i1.f0;
import i1.t1;
import i8.c0;
import i8.g0;
import i8.i;
import i8.i0;
import i8.k0;
import i8.r0;
import i8.x;
import ia.b0;
import ia.d0;
import ia.f1;
import j1.y;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import k.n;
import k5.q;
import la.j;
import la.j0;
import n.j1;
import n.o;
import q7.k;
import s8.w;
import t9.s;
import v9.v;

/* loaded from: classes.dex */
public final class d implements ea.a, f3.e, l, q, j, o, j1 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f410f;

    /* renamed from: g, reason: collision with root package name */
    public Object f411g;

    public /* synthetic */ d(int i2, Object obj) {
        this.f410f = i2;
        this.f411g = obj;
    }

    public static c z(n3.c cVar) {
        HashMap map = new HashMap(6);
        map.put("id", new h3.a("id", "INTEGER", true, 1, null, 1));
        map.put("frame_json", new h3.a("frame_json", "TEXT", true, 0, null, 1));
        map.put("size_bytes", new h3.a("size_bytes", "INTEGER", true, 0, null, 1));
        map.put("created_at", new h3.a("created_at", "INTEGER", true, 0, null, 1));
        map.put("ttl_expires_at", new h3.a("ttl_expires_at", "INTEGER", true, 0, null, 1));
        map.put("target_kind", new h3.a("target_kind", "TEXT", true, 0, null, 1));
        h3.e eVar = new h3.e("offline_frame", map, new HashSet(0), new HashSet(0));
        h3.e eVarA = h3.e.a(cVar, "offline_frame");
        if (!eVar.equals(eVarA)) {
            return new c(false, "offline_frame(com.stepos.agentbus.domain.queue.OfflineFrameEntity).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
        }
        HashMap map2 = new HashMap(4);
        map2.put("frame_id", new h3.a("frame_id", "TEXT", true, 1, null, 1));
        map2.put("reason", new h3.a("reason", "TEXT", true, 0, null, 1));
        map2.put("created_at", new h3.a("created_at", "INTEGER", true, 0, null, 1));
        map2.put("expires_at", new h3.a("expires_at", "INTEGER", true, 0, null, 1));
        h3.e eVar2 = new h3.e("offline_frame_tombstone", map2, new HashSet(0), new HashSet(0));
        h3.e eVarA2 = h3.e.a(cVar, "offline_frame_tombstone");
        if (eVar2.equals(eVarA2)) {
            return new c(true, (String) null);
        }
        return new c(false, "offline_frame_tombstone(com.stepos.agentbus.domain.queue.OfflineFrameTombstoneEntity).\n Expected:\n" + eVar2 + "\n Found:\n" + eVarA2);
    }

    @Override // f8.l
    public Object A(r0 r0Var, Object obj) {
        ((g9.g) this.f411g).g0(r0Var, true, (StringBuilder) obj, true);
        return r.f1986a;
    }

    public q6.b B(q6.b bVar, y yVar) {
        Object obj;
        int i2;
        long jB;
        long j2;
        boolean z4;
        Object obj2 = k.o.f5511a;
        n nVar = (n) this.f411g;
        List list = (List) bVar.f8788h;
        n nVar2 = new n(list.size());
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            c1.n nVar3 = (c1.n) list.get(i10);
            long j4 = nVar3.f1822a;
            int iB = l.a.b(nVar.f5508g, nVar.f5510i, j4);
            if (iB < 0 || (obj = nVar.f5509h[iB]) == obj2) {
                obj = null;
            }
            m mVar = (m) obj;
            if (mVar == null) {
                i2 = i10;
                j2 = nVar3.f1823b;
                jB = nVar3.f1825d;
                z4 = false;
            } else {
                long j10 = mVar.f1819a;
                boolean z10 = mVar.f1821c;
                i2 = i10;
                jB = yVar.B(mVar.f1820b);
                j2 = j10;
                z4 = z10;
            }
            long j11 = nVar3.f1822a;
            List list2 = list;
            int i11 = size;
            nVar2.b(j11, new c1.l(j11, nVar3.f1823b, nVar3.f1825d, nVar3.f1826e, nVar3.f1827f, j2, jB, z4, nVar3.f1828g, nVar3.f1830i, nVar3.f1831j, nVar3.f1832k));
            boolean z11 = nVar3.f1826e;
            if (z11) {
                nVar.b(j4, new m(nVar3.f1823b, nVar3.f1824c, z11));
            } else {
                int iB2 = l.a.b(nVar.f5508g, nVar.f5510i, j4);
                if (iB2 >= 0) {
                    Object[] objArr = nVar.f5509h;
                    if (objArr[iB2] != obj2) {
                        objArr[iB2] = obj2;
                        nVar.f5507f = true;
                    }
                }
            }
            i10 = i2 + 1;
            list = list2;
            size = i11;
        }
        return new q6.b(6, nVar2, bVar);
    }

    public void C(k5.r rVar) {
        k.e(rVar, "event");
        ((j0) this.f411g).M(rVar);
    }

    public boolean D(f0 f0Var) {
        if (!f0Var.B()) {
            f1.a.b("DepthSortedSet.remove called on an unattached node");
        }
        return ((t1) this.f411g).remove(f0Var);
    }

    @Override // f8.l
    public Object F(k0 k0Var, Object obj) {
        L(k0Var, (StringBuilder) obj, "setter");
        return r.f1986a;
    }

    @Override // f8.l
    public Object G(z zVar, Object obj) {
        StringBuilder sb2 = (StringBuilder) obj;
        k.e(zVar, "descriptor");
        k.e(sb2, "builder");
        ((g9.g) this.f411g).Q(zVar, sb2, true);
        return r.f1986a;
    }

    public f8.e H(l8.o oVar) {
        k.e(oVar, "javaClass");
        e9.c cVarC = oVar.c();
        Class cls = oVar.f5878a;
        Class<?> declaringClass = cls.getDeclaringClass();
        l8.o oVar2 = declaringClass != null ? new l8.o(declaringClass) : null;
        if (oVar2 != null) {
            f8.e eVarH = H(oVar2);
            o9.n nVarH0 = eVarH != null ? eVarH.h0() : null;
            f8.g gVarB = nVarH0 != null ? nVarH0.b(e9.f.e(cls.getSimpleName()), n8.c.f6884m) : null;
            if (gVarB instanceof f8.e) {
                return (f8.e) gVarB;
            }
        } else {
            s8.r rVar = (s8.r) d7.r.P0(a.a.S(((r8.e) this.f411g).c(cVarC.e())));
            if (rVar != null) {
                w wVar = rVar.f9602o.f9537d;
                wVar.getClass();
                return wVar.v(e9.f.e(cls.getSimpleName()), oVar);
            }
        }
        return null;
    }

    public h4.n J(Class cls, b0 b0Var, p7.n nVar) {
        k.e(b0Var, "scope");
        d0.s(b0Var, null, null, new f2(this, cls, nVar, (g7.d) null), 3);
        return new h4.n(6, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K(f8.t r11, java.lang.StringBuilder r12) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.d.K(f8.t, java.lang.StringBuilder):void");
    }

    public void L(g0 g0Var, StringBuilder sb2, String str) {
        g9.g gVar = (g9.g) this.f411g;
        g9.l lVar = gVar.f3942a;
        int iOrdinal = ((g9.q) lVar.G.a(lVar, g9.l.W[31])).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            K(g0Var, sb2);
        } else {
            gVar.L(g0Var, sb2);
            sb2.append(str.concat(" for "));
            l0 l0VarG0 = g0Var.G0();
            k.d(l0VarG0, "descriptor.correspondingProperty");
            g9.g.o(gVar, l0VarG0, sb2);
        }
    }

    @Override // n.j1, n.h1
    public boolean a() {
        ((i5.f) this.f411g).getClass();
        return false;
    }

    @Override // ea.a
    public Iterable b(Object obj) {
        e8.o oVar = (e8.o) this.f411g;
        Collection collectionD = ((f8.e) obj).h().d();
        k.d(collectionD, "it.typeConstructor.supertypes");
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            f8.g gVarC = ((v) it.next()).E0().c();
            f8.g gVarA = gVarC != null ? gVarC.a() : null;
            f8.e eVar = gVarA instanceof f8.e ? (f8.e) gVarA : null;
            s8.j jVarF = eVar != null ? oVar.f(eVar) : null;
            if (jVarF != null) {
                arrayList.add(jVarF);
            }
        }
        return arrayList;
    }

    @Override // n.h1
    public long c(n.n nVar, n.n nVar2, n.n nVar3) {
        return ((i5.f) this.f411g).c(nVar, nVar2, nVar3);
    }

    @Override // f3.e
    public void d() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // f8.l
    public Object e(x xVar, Object obj) {
        StringBuilder sb2 = (StringBuilder) obj;
        g9.g gVar = (g9.g) this.f411g;
        gVar.getClass();
        gVar.U(xVar.f4897i, "package", sb2);
        if (gVar.f3942a.o()) {
            sb2.append(" in context of ");
            gVar.Q(xVar.f4896h, sb2, false);
        }
        return r.f1986a;
    }

    @Override // f8.l
    public Object f(i8.v vVar, Object obj) {
        ((StringBuilder) obj).append(vVar.getName());
        return r.f1986a;
    }

    @Override // f3.e
    public void g(int i2, Object obj) {
        String str;
        switch (i2) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i2 == 6 || i2 == 7 || i2 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f411g).setResultCode(i2);
    }

    @Override // n.o
    public n.w get(int i2) {
        switch (this.f410f) {
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                return (n.x) this.f411g;
            default:
                return (n.w) this.f411g;
        }
    }

    public void h(f0 f0Var) {
        if (!f0Var.B()) {
            f1.a.b("DepthSortedSet.add called on an unattached node");
        }
        ((t1) this.f411g).add(f0Var);
    }

    public void i(f9.d dVar) {
        if (!dVar.k()) {
            if (!(dVar instanceof f9.z)) {
                String strValueOf = String.valueOf(dVar.getClass());
                throw new IllegalArgumentException(a1.a.m(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
            }
            f9.z zVar = (f9.z) dVar;
            i(zVar.f3609h);
            i(zVar.f3610i);
            return;
        }
        int size = dVar.size();
        int[] iArr = f9.z.f3607m;
        int iBinarySearch = Arrays.binarySearch(iArr, size);
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int i2 = iArr[iBinarySearch + 1];
        Stack stack = (Stack) this.f411g;
        if (stack.isEmpty() || ((f9.d) stack.peek()).size() >= i2) {
            stack.push(dVar);
            return;
        }
        int i10 = iArr[iBinarySearch];
        f9.d zVar2 = (f9.d) stack.pop();
        while (!stack.isEmpty() && ((f9.d) stack.peek()).size() < i10) {
            zVar2 = new f9.z((f9.d) stack.pop(), zVar2);
        }
        f9.z zVar3 = new f9.z(zVar2, dVar);
        while (!stack.isEmpty()) {
            int[] iArr2 = f9.z.f3607m;
            int iBinarySearch2 = Arrays.binarySearch(iArr2, zVar3.f3608g);
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (((f9.d) stack.peek()).size() >= iArr2[iBinarySearch2 + 1]) {
                break;
            } else {
                zVar3 = new f9.z((f9.d) stack.pop(), zVar3);
            }
        }
        stack.push(zVar3);
    }

    public void j() throws IOException {
        Socket socket;
        eb.n nVar = (eb.n) this.f411g;
        Iterator it = nVar.f3315d.iterator();
        k.d(it, "connections.iterator()");
        while (it.hasNext()) {
            eb.m mVar = (eb.m) it.next();
            k.d(mVar, "connection");
            synchronized (mVar) {
                if (mVar.f3310p.isEmpty()) {
                    it.remove();
                    mVar.f3304j = true;
                    socket = mVar.f3298d;
                    k.b(socket);
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                bb.b.e(socket);
            }
        }
        if (nVar.f3315d.isEmpty()) {
            nVar.f3313b.a();
        }
    }

    @Override // f8.l
    public Object k(s sVar, Object obj) {
        StringBuilder sb2 = (StringBuilder) obj;
        g9.g gVar = (g9.g) this.f411g;
        gVar.getClass();
        gVar.z(sb2, sVar, null);
        f8.n nVar = sVar.f9842j;
        k.d(nVar, "typeAlias.visibility");
        gVar.i0(nVar, sb2);
        gVar.L(sVar, sb2);
        sb2.append(gVar.J("typealias"));
        sb2.append(" ");
        gVar.Q(sVar, sb2, true);
        gVar.e0(sb2, sVar.s(), false);
        gVar.B(sVar, sb2);
        sb2.append(" = ");
        sb2.append(gVar.Z(sVar.I0()));
        return r.f1986a;
    }

    @Override // f8.l
    public Object l(c0 c0Var, Object obj) {
        StringBuilder sb2 = (StringBuilder) obj;
        g9.g gVar = (g9.g) this.f411g;
        gVar.getClass();
        gVar.U(c0Var.f4758j, "package-fragment", sb2);
        if (gVar.f3942a.o()) {
            sb2.append(" in ");
            gVar.Q(c0Var.p(), sb2, false);
        }
        return r.f1986a;
    }

    @Override // f8.l
    public Object n(i8.z zVar, Object obj) throws IOException {
        i iVarK0;
        String str;
        StringBuilder sb2 = (StringBuilder) obj;
        g9.g gVar = (g9.g) this.f411g;
        g9.l lVar = gVar.f3942a;
        boolean z4 = zVar.B() == 4;
        if (!gVar.s()) {
            gVar.z(sb2, zVar, null);
            List listW0 = zVar.w0();
            k.d(listW0, "klass.contextReceivers");
            gVar.D(sb2, listW0);
            if (!z4) {
                f8.n nVarC = zVar.c();
                k.d(nVarC, "klass.visibility");
                gVar.i0(nVarC, sb2);
            }
            if ((zVar.B() != 2 || zVar.i() != 4) && (!a1.a.a(zVar.B()) || zVar.i() != 1)) {
                int i2 = zVar.i();
                m.x.y(i2, "klass.modality");
                gVar.M(i2, sb2, g9.g.w(zVar));
            }
            gVar.L(zVar, sb2);
            gVar.O(sb2, gVar.r().contains(h.INNER) && zVar.m(), "inner");
            gVar.O(sb2, gVar.r().contains(h.DATA) && zVar.A0(), "data");
            gVar.O(sb2, gVar.r().contains(h.INLINE) && zVar.e(), "inline");
            gVar.O(sb2, gVar.r().contains(h.VALUE) && zVar.l(), "value");
            gVar.O(sb2, gVar.r().contains(h.FUN) && zVar.J(), "fun");
            if (zVar.C()) {
                str = "companion object";
            } else {
                int iD = n.f.d(zVar.B());
                if (iD == 0) {
                    str = "class";
                } else if (iD == 1) {
                    str = "interface";
                } else if (iD == 2) {
                    str = "enum class";
                } else if (iD == 3) {
                    str = "enum entry";
                } else if (iD == 4) {
                    str = "annotation class";
                } else {
                    if (iD != 5) {
                        throw new u();
                    }
                    str = "object";
                }
            }
            sb2.append(gVar.J(str));
        }
        if (h9.f.l(zVar)) {
            if (((Boolean) lVar.F.a(lVar, g9.l.W[30])).booleanValue()) {
                if (gVar.s()) {
                    sb2.append("companion object");
                }
                g9.g.Y(sb2);
                f8.j jVarP = zVar.p();
                if (jVarP != null) {
                    sb2.append("of ");
                    e9.f name = jVarP.getName();
                    k.d(name, "containingDeclaration.name");
                    sb2.append(gVar.P(name, false));
                }
            }
            if (gVar.v() || !k.a(zVar.getName(), e9.h.f3201b)) {
                if (!gVar.s()) {
                    g9.g.Y(sb2);
                }
                e9.f name2 = zVar.getName();
                k.d(name2, "descriptor.name");
                sb2.append(gVar.P(name2, true));
            }
        } else {
            if (!gVar.s()) {
                g9.g.Y(sb2);
            }
            gVar.Q(zVar, sb2, true);
        }
        if (!z4) {
            List listS = zVar.s();
            k.d(listS, "klass.declaredTypeParameters");
            gVar.e0(sb2, listS, false);
            gVar.B(zVar, sb2);
            if (!a1.a.a(zVar.B()) && ((Boolean) lVar.f3972i.a(lVar, g9.l.W[7])).booleanValue() && (iVarK0 = zVar.k0()) != null) {
                sb2.append(" ");
                gVar.z(sb2, iVarK0, null);
                i iVar = iVarK0;
                f8.n nVarC2 = iVar.c();
                k.d(nVarC2, "primaryConstructor.visibility");
                gVar.i0(nVarC2, sb2);
                sb2.append(gVar.J("constructor"));
                List listX0 = iVar.x0();
                k.d(listX0, "primaryConstructor.valueParameters");
                gVar.h0(sb2, listX0, iVarK0.O());
            }
            if (!((Boolean) lVar.f3986w.a(lVar, g9.l.W[21])).booleanValue() && !c8.h.E(zVar.k())) {
                Collection collectionD = zVar.h().d();
                k.d(collectionD, "klass.typeConstructor.supertypes");
                if (!collectionD.isEmpty() && (collectionD.size() != 1 || !c8.h.x((v) collectionD.iterator().next()))) {
                    g9.g.Y(sb2);
                    sb2.append(": ");
                    d7.r.T0(collectionD, sb2, ", ", null, null, new g9.e(gVar, 2), 60);
                }
            }
            gVar.j0(sb2, listS);
        }
        return r.f1986a;
    }

    @Override // n.h1
    public n.n o(n.n nVar, n.n nVar2, n.n nVar3) {
        return ((i5.f) this.f411g).o(nVar, nVar2, nVar3);
    }

    @Override // f8.l
    public Object p(i8.h hVar, Object obj) {
        ((g9.g) this.f411g).c0(hVar, (StringBuilder) obj, true);
        return r.f1986a;
    }

    @Override // f8.l
    public Object q(i0 i0Var, Object obj) {
        k.e(i0Var, "descriptor");
        g9.g.o((g9.g) this.f411g, i0Var, (StringBuilder) obj);
        return r.f1986a;
    }

    @Override // n.h1
    public n.n r(long j2, n.n nVar, n.n nVar2, n.n nVar3) {
        return ((i5.f) this.f411g).r(j2, nVar, nVar2, nVar3);
    }

    @Override // n.h1
    public n.n s(long j2, n.n nVar, n.n nVar2, n.n nVar3) {
        return ((i5.f) this.f411g).s(j2, nVar, nVar2, nVar3);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    @Override // f8.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object t(i8.i r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.d.t(i8.i, java.lang.Object):java.lang.Object");
    }

    public String toString() {
        switch (this.f410f) {
            case 11:
                return ((t1) this.f411g).toString();
            default:
                return super.toString();
        }
    }

    @Override // f8.l
    public Object u(i8.j0 j0Var, Object obj) {
        L(j0Var, (StringBuilder) obj, "getter");
        return r.f1986a;
    }

    public void w(View view, int i2, boolean z4) {
        ((AutofillManager) this.f411g).notifyViewVisibilityChanged(view, i2, z4);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v4, types: [i7.i, p7.n] */
    @Override // la.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object x(la.k r6, g7.d r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof la.a
            if (r0 == 0) goto L13
            r0 = r7
            la.a r0 = (la.a) r0
            int r1 = r0.f5897i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5897i = r1
            goto L18
        L13:
            la.a r0 = new la.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5895g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5897i
            c7.r r3 = c7.r.f1986a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            ma.r r5 = r0.f5894f
            w7.e0.N(r7)     // Catch: java.lang.Throwable -> L2b
            goto L55
        L2b:
            r6 = move-exception
            goto L5f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            w7.e0.N(r7)
            ma.r r7 = new ma.r
            g7.l r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f5894f = r7     // Catch: java.lang.Throwable -> L5d
            r0.f5897i = r4     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r5 = r5.f411g     // Catch: java.lang.Throwable -> L59
            i7.i r5 = (i7.i) r5     // Catch: java.lang.Throwable -> L59
            java.lang.Object r5 = r5.invoke(r7, r0)     // Catch: java.lang.Throwable -> L59
            if (r5 != r1) goto L50
            goto L51
        L50:
            r5 = r3
        L51:
            if (r5 != r1) goto L54
            return r1
        L54:
            r5 = r7
        L55:
            r5.releaseIntercepted()
            return r3
        L59:
            r5 = move-exception
            r6 = r5
        L5b:
            r5 = r7
            goto L5f
        L5d:
            r6 = move-exception
            goto L5b
        L5f:
            r5.releaseIntercepted()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.d.x(la.k, g7.d):java.lang.Object");
    }

    @Override // f8.l
    public /* bridge */ /* synthetic */ Object y(t tVar, Object obj) {
        K(tVar, (StringBuilder) obj);
        return r.f1986a;
    }

    public d(d dVar, k5.a aVar, k5.g gVar) {
        this.f410f = 26;
        k.e(dVar, "internalBus");
        k.e(aVar, "dispatchers");
        k.e(gVar, "logger");
        this.f411g = d0.b(f1.plus(d0.c(), aVar.f5617b));
        la.k0.c(n5.a.NONE);
        new AtomicLong(0L);
        new AtomicLong(0L);
        new AtomicLong(0L);
    }

    public d(d2.c cVar) {
        this.f410f = 19;
        this.f411g = new m.b0(m.d0.f6053a, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[PHI: r10
      0x002a: PHI (r10v1 int) = (r10v0 int), (r10v5 int), (r10v6 int) binds: [B:5:0x001a, B:10:0x0023, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(int[] r21, float[] r22, float[][] r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r2 = 21
            r0.f410f = r2
            r0.<init>()
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            n.p[][] r4 = new n.p[r2][]
            r5 = 0
            r7 = r3
            r8 = r7
            r6 = r5
        L14:
            if (r6 >= r2) goto L6d
            r9 = r21[r6]
            r10 = 3
            r11 = 2
            if (r9 == 0) goto L2a
            if (r9 == r3) goto L33
            if (r9 == r11) goto L31
            if (r9 == r10) goto L2c
            r10 = 4
            if (r9 == r10) goto L2a
            r10 = 5
            if (r9 == r10) goto L2a
            r13 = r8
            goto L35
        L2a:
            r13 = r10
            goto L35
        L2c:
            if (r7 != r3) goto L33
            goto L31
        L2f:
            r13 = r7
            goto L35
        L31:
            r7 = r11
            goto L2f
        L33:
            r7 = r3
            goto L2f
        L35:
            r8 = r23[r6]
            int r9 = r8.length
            int r9 = r9 / r11
            int r8 = r8.length
            int r8 = r8 % r11
            int r8 = r8 + r9
            n.p[] r9 = new n.p[r8]
            r10 = r5
        L3f:
            if (r10 >= r8) goto L67
            int r11 = r10 * 2
            n.p r12 = new n.p
            r14 = r1[r6]
            int r15 = r6 + 1
            r16 = r15
            r15 = r1[r16]
            r17 = r23[r6]
            r18 = r16
            r16 = r17[r11]
            int r19 = r11 + 1
            r17 = r17[r19]
            r18 = r23[r18]
            r11 = r18[r11]
            r19 = r18[r19]
            r18 = r11
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r9[r10] = r12
            int r10 = r10 + 1
            goto L3f
        L67:
            r4[r6] = r9
            int r6 = r6 + 1
            r8 = r13
            goto L14
        L6d:
            r0.f411g = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.d.<init>(int[], float[], float[][]):void");
    }

    public d(int i2) {
        this.f410f = i2;
        switch (i2) {
            case 1:
                k.e(TimeUnit.MINUTES, "timeUnit");
                this.f411g = new eb.n(db.e.f3030h);
                break;
            case 3:
                this.f411g = new n(10);
                break;
            case 6:
                this.f411g = new HashSet();
                break;
            case 7:
                this.f411g = new LinkedHashSet();
                break;
            case 9:
                this.f411g = new Stack();
                break;
            case 11:
                this.f411g = new t1(i1.l.f4519a);
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                this.f411g = la.k0.b(0, 64, 4);
                break;
            case 28:
                this.f411g = new CopyOnWriteArrayList();
                new HashMap();
                break;
        }
    }

    public d(long[] jArr) {
        k.v vVar;
        this.f410f = 16;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            vVar = new k.v(jArrCopyOf.length);
            int i2 = vVar.f5538b;
            if (i2 >= 0) {
                if (jArrCopyOf.length != 0) {
                    int length = jArrCopyOf.length + i2;
                    long[] jArr2 = vVar.f5537a;
                    if (jArr2.length < length) {
                        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, Math.max(length, (jArr2.length * 3) / 2));
                        k.d(jArrCopyOf2, "copyOf(...)");
                        vVar.f5537a = jArrCopyOf2;
                    }
                    long[] jArr3 = vVar.f5537a;
                    int i10 = vVar.f5538b;
                    if (i2 != i10) {
                        d7.n.X(jArr3, jArr3, jArrCopyOf.length + i2, i2, i10);
                    }
                    d7.n.X(jArrCopyOf, jArr3, i2, 0, jArrCopyOf.length);
                    vVar.f5538b += jArrCopyOf.length;
                }
            } else {
                l.a.d("");
                throw null;
            }
        } else {
            vVar = new k.v(16);
        }
        this.f411g = vVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(p7.n nVar) {
        this.f410f = 18;
        this.f411g = (i7.i) nVar;
    }

    public d(bb.a aVar) {
        this.f410f = 4;
        this.f411g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), aVar);
    }

    public d(float f10, n.n nVar) {
        Object dVar;
        this.f410f = 25;
        if (nVar != null) {
            dVar = new ab.m(f10, nVar);
        } else {
            dVar = new d(f10);
        }
        this.f411g = new i5.f(12, dVar);
    }

    public d(float f10) {
        this.f410f = 23;
        this.f411g = new n.x(f10, 0.01f);
    }
}
