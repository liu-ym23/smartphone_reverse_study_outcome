package i8;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import v9.v0;

/* loaded from: classes.dex */
public class i extends u implements f8.i {
    public final boolean I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f8.e eVar, f8.i iVar, g8.j jVar, boolean z4, int i2, f8.n0 n0Var) {
        super(i2, e9.h.f3204e, eVar, iVar, n0Var, jVar);
        if (eVar == null) {
            R(0);
            throw null;
        }
        if (jVar == null) {
            R(1);
            throw null;
        }
        if (i2 == 0) {
            R(2);
            throw null;
        }
        if (n0Var == null) {
            R(3);
            throw null;
        }
        this.I = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void R(int r8) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.i.R(int):void");
    }

    @Override // f8.i
    public final boolean G() {
        return this.I;
    }

    @Override // f8.i
    public final f8.e H() {
        f8.e eVarP = p();
        if (eVarP != null) {
            return eVarP;
        }
        R(18);
        throw null;
    }

    @Override // i8.u, f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.t(this, obj);
    }

    @Override // i8.u
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public i I0(int i2, e9.f fVar, f8.j jVar, f8.t tVar, f8.n0 n0Var, g8.j jVar2) {
        if (jVar == null) {
            R(23);
            throw null;
        }
        if (i2 == 0) {
            R(24);
            throw null;
        }
        if (jVar2 == null) {
            R(25);
            throw null;
        }
        if (i2 == 1 || i2 == 4) {
            return new i((f8.e) jVar, this, jVar2, this.I, 1, n0Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + jVar + "\nkind: " + a1.a.y(i2));
    }

    @Override // i8.n, f8.j
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public final f8.e p() {
        f8.e eVar = (f8.e) super.p();
        if (eVar != null) {
            return eVar;
        }
        R(17);
        throw null;
    }

    @Override // i8.u, i8.n, i8.m, f8.j
    /* renamed from: T0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final i a() {
        i iVar = (i) super.a();
        if (iVar != null) {
            return iVar;
        }
        R(19);
        throw null;
    }

    public final void U0(List list, f8.n nVar) {
        if (list == null) {
            R(13);
            throw null;
        }
        if (nVar != null) {
            V0(list, nVar, p().s());
        } else {
            R(14);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0(java.util.List r12, f8.n r13, java.util.List r14) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L60
            if (r13 == 0) goto L5a
            if (r14 == 0) goto L54
            f8.e r1 = r11.p()
            boolean r2 = r1.m()
            if (r2 == 0) goto L21
            f8.j r1 = r1.p()
            boolean r2 = r1 instanceof f8.e
            if (r2 == 0) goto L21
            f8.e r1 = (f8.e) r1
            i8.v r1 = r1.B0()
            r4 = r1
            goto L22
        L21:
            r4 = r0
        L22:
            f8.e r1 = r11.p()
            java.util.List r2 = r1.w0()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L3e
            java.util.List r1 = r1.w0()
            if (r1 == 0) goto L38
        L36:
            r5 = r1
            goto L43
        L38:
            r11 = 15
            R(r11)
            throw r0
        L3e:
            java.util.List r1 = java.util.Collections.EMPTY_LIST
            if (r1 == 0) goto L4e
            goto L36
        L43:
            r8 = 0
            r9 = 1
            r3 = 0
            r2 = r11
            r7 = r12
            r10 = r13
            r6 = r14
            r2.L0(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        L4e:
            r11 = 16
            R(r11)
            throw r0
        L54:
            r11 = 12
            R(r11)
            throw r0
        L5a:
            r11 = 11
            R(r11)
            throw r0
        L60:
            r11 = 10
            R(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.i.V0(java.util.List, f8.n, java.util.List):void");
    }

    @Override // i8.u, f8.t, f8.p0
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public final i d(v0 v0Var) {
        if (v0Var != null) {
            return (i) super.d(v0Var);
        }
        R(20);
        throw null;
    }

    @Override // i8.u, f8.c
    public final f8.c Y(f8.e eVar, int i2, f8.n nVar) {
        return (i) G0(eVar, i2, nVar);
    }

    @Override // i8.u, f8.c
    public final void d0(Collection collection) {
        if (collection != null) {
            return;
        }
        R(22);
        throw null;
    }

    @Override // i8.u, f8.c, f8.b
    public final Collection r() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        R(21);
        throw null;
    }
}
