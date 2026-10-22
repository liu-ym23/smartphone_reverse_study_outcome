package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f13688a = new Object();

    public static final void a(int i, int i3) {
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException("index (" + i + ") is out of bound of [0, " + i3 + ')');
        }
    }

    public static final boolean b(u uVar, int i, o0.c cVar, boolean z10) {
        boolean z11;
        synchronized (f13688a) {
            try {
                int i3 = uVar.f13710d;
                if (i3 == i) {
                    uVar.f13709c = cVar;
                    z11 = true;
                    if (z10) {
                        uVar.f13711e++;
                    }
                    uVar.f13710d = i3 + 1;
                } else {
                    z11 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z11;
    }

    public static final int c(long[] jArr, long j10) {
        int length = jArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i3 = (i + length) >>> 1;
            long j11 = jArr[i3];
            if (j10 > j11) {
                i = i3 + 1;
            } else {
                if (j10 >= j11) {
                    return i3;
                }
                length = i3 - 1;
            }
        }
        return -(i + 1);
    }

    public static f d() {
        return (f) m.f13675b.w();
    }

    public static final u e(q qVar) {
        u uVar = qVar.f13687c;
        uVar.getClass();
        return (u) m.t(uVar, qVar);
    }

    public static final int f(q qVar) {
        u uVar = qVar.f13687c;
        uVar.getClass();
        return ((u) m.i(uVar)).f13711e;
    }

    public static f g(f fVar) {
        if (fVar instanceof z) {
            z zVar = (z) fVar;
            if (zVar.f13724t == s0.h.b()) {
                zVar.f13722r = null;
                return fVar;
            }
        }
        if (fVar instanceof a0) {
            a0 a0Var = (a0) fVar;
            if (a0Var.i == s0.h.b()) {
                a0Var.f13636h = null;
                return fVar;
            }
        }
        f fVarH = m.h(fVar, null, false);
        fVarH.j();
        return fVarH;
    }

    public static final boolean h(q qVar, xb.l lVar) {
        int i;
        o0.c cVar;
        Object objInvoke;
        f fVarK;
        boolean zB;
        do {
            synchronized (f13688a) {
                u uVar = qVar.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.f fVarE = cVar.e();
            objInvoke = lVar.invoke(fVarE);
            o0.c cVarC = fVarE.c();
            if (yb.k.a(cVarC, cVar)) {
                break;
            }
            u uVar3 = qVar.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = b((u) m.w(uVar3, qVar, fVarK), i, cVarC, true);
            }
            m.n(fVarK, qVar);
        } while (!zB);
        return ((Boolean) objInvoke).booleanValue();
    }

    public static Object i(xb.l lVar, xb.a aVar) {
        f zVar;
        if (lVar == null) {
            return aVar.invoke();
        }
        f fVar = (f) m.f13675b.w();
        if (fVar instanceof z) {
            z zVar2 = (z) fVar;
            if (zVar2.f13724t == s0.h.b()) {
                xb.l lVar2 = zVar2.f13722r;
                xb.l lVar3 = zVar2.f13723s;
                try {
                    ((z) fVar).f13722r = m.l(lVar, lVar2, true);
                    ((z) fVar).f13723s = lVar3;
                    return aVar.invoke();
                } finally {
                    zVar2.f13722r = lVar2;
                    zVar2.f13723s = lVar3;
                }
            }
        }
        if (fVar == null || (fVar instanceof b)) {
            zVar = new z(fVar instanceof b ? (b) fVar : null, lVar, null, true, false);
        } else {
            if (lVar == null) {
                return aVar.invoke();
            }
            zVar = fVar.u(lVar);
        }
        try {
            f fVarJ = zVar.j();
            try {
                Object objInvoke = aVar.invoke();
                f.q(fVarJ);
                zVar.c();
                return objInvoke;
            } catch (Throwable th) {
                f.q(fVarJ);
                throw th;
            }
        } catch (Throwable th2) {
            zVar.c();
            throw th2;
        }
    }

    public static void j(f fVar, f fVar2, xb.l lVar) {
        if (fVar != fVar2) {
            fVar2.getClass();
            f.q(fVar);
            fVar2.c();
        } else if (fVar instanceof z) {
            ((z) fVar).f13722r = lVar;
        } else if (fVar instanceof a0) {
            ((a0) fVar).f13636h = lVar;
        } else {
            g5.f.n(fVar, "Non-transparent snapshot was reused: ");
        }
    }

    public static final void k() {
        throw new UnsupportedOperationException();
    }
}
