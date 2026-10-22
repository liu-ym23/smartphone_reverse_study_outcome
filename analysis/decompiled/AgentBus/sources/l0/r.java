package l0;

/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5786a = new Object();

    public static final void a(int i2, int i10) {
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException("index (" + i2 + ") is out of bound of [0, " + i10 + ')');
        }
    }

    public static final boolean b(u uVar, int i2, f0.c cVar, boolean z4) {
        boolean z10;
        synchronized (f5786a) {
            try {
                int i10 = uVar.f5810d;
                if (i10 == i2) {
                    uVar.f5809c = cVar;
                    z10 = true;
                    if (z4) {
                        uVar.f5811e++;
                    }
                    uVar.f5810d = i10 + 1;
                } else {
                    z10 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public static final int c(long[] jArr, long j2) {
        int length = jArr.length - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i10 = (i2 + length) >>> 1;
            long j4 = jArr[i10];
            if (j2 > j4) {
                i2 = i10 + 1;
            } else {
                if (j2 >= j4) {
                    return i10;
                }
                length = i10 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final u d(q qVar) {
        u uVar = qVar.f5785f;
        q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.<get-readable>>");
        return (u) m.t(uVar, qVar);
    }

    public static final int e(q qVar) {
        u uVar = qVar.f5785f;
        q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return ((u) m.i(uVar)).f5811e;
    }

    public static f f(f fVar) {
        if (fVar instanceof z) {
            z zVar = (z) fVar;
            if (zVar.f5824t == j0.i.b()) {
                zVar.f5822r = null;
                return fVar;
            }
        }
        if (fVar instanceof a0) {
            a0 a0Var = (a0) fVar;
            if (a0Var.f5731i == j0.i.b()) {
                a0Var.f5730h = null;
                return fVar;
            }
        }
        f fVarH = m.h(fVar, null, false);
        fVarH.j();
        return fVarH;
    }

    public static final boolean g(q qVar, p7.k kVar) {
        int i2;
        f0.c cVar;
        Object objInvoke;
        f fVarK;
        boolean zB;
        do {
            synchronized (f5786a) {
                u uVar = qVar.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i2 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.g gVarJ = cVar.j();
            objInvoke = kVar.invoke(gVarJ);
            f0.c cVarH = gVarJ.h();
            if (q7.k.a(cVarH, cVar)) {
                break;
            }
            u uVar3 = qVar.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = b((u) m.w(uVar3, qVar, fVarK), i2, cVarH, true);
            }
            m.n(fVarK, qVar);
        } while (!zB);
        return ((Boolean) objInvoke).booleanValue();
    }

    public static Object h(p7.a aVar, p7.k kVar) {
        f zVar;
        if (kVar == null) {
            return aVar.c();
        }
        f fVar = (f) m.f5773b.z();
        if (fVar instanceof z) {
            z zVar2 = (z) fVar;
            if (zVar2.f5824t == j0.i.b()) {
                p7.k kVar2 = zVar2.f5822r;
                p7.k kVar3 = zVar2.f5823s;
                try {
                    ((z) fVar).f5822r = m.l(kVar, kVar2, true);
                    ((z) fVar).f5823s = kVar3;
                    return aVar.c();
                } finally {
                    zVar2.f5822r = kVar2;
                    zVar2.f5823s = kVar3;
                }
            }
        }
        if (fVar == null || (fVar instanceof b)) {
            zVar = new z(fVar instanceof b ? (b) fVar : null, kVar, null, true, false);
        } else {
            if (kVar == null) {
                return aVar.c();
            }
            zVar = fVar.u(kVar);
        }
        try {
            f fVarJ = zVar.j();
            try {
                Object objC = aVar.c();
                f.q(fVarJ);
                zVar.c();
                return objC;
            } catch (Throwable th) {
                f.q(fVarJ);
                throw th;
            }
        } catch (Throwable th2) {
            zVar.c();
            throw th2;
        }
    }

    public static void i(f fVar, f fVar2, p7.k kVar) {
        if (fVar != fVar2) {
            fVar2.getClass();
            f.q(fVar);
            fVar2.c();
        } else if (fVar instanceof z) {
            ((z) fVar).f5822r = kVar;
        } else if (fVar instanceof a0) {
            ((a0) fVar).f5730h = kVar;
        } else {
            throw new IllegalStateException(("Non-transparent snapshot was reused: " + fVar).toString());
        }
    }

    public static final void j() {
        throw new UnsupportedOperationException();
    }
}
