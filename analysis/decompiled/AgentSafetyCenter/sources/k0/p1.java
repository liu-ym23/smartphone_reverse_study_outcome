package k0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7008a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7009b;

    /* renamed from: c, reason: collision with root package name */
    public int f7010c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f7011d;

    /* renamed from: e, reason: collision with root package name */
    public final p.u f7012e;

    /* renamed from: f, reason: collision with root package name */
    public final jb.k f7013f;

    public p1(ArrayList arrayList, int i) {
        this.f7008a = arrayList;
        this.f7009b = i;
        if (i < 0) {
            q1.a("Invalid start index");
        }
        this.f7011d = new ArrayList();
        p.u uVar = new p.u();
        int size = arrayList.size();
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            v0 v0Var = (v0) this.f7008a.get(i10);
            int i11 = v0Var.f7086c;
            int i12 = v0Var.f7087d;
            uVar.h(i11, new o0(i10, i3, i12));
            i3 += i12;
        }
        this.f7012e = uVar;
        o1 o1Var = new o1();
        o1Var.f6992c = this;
        VarHandle.storeStoreFence();
        this.f7013f = new jb.k(o1Var);
    }

    public final boolean a(int i, int i3) {
        int i10;
        p.u uVar = this.f7012e;
        o0 o0Var = (o0) uVar.b(i);
        if (o0Var == null) {
            return false;
        }
        int i11 = o0Var.f6990b;
        int i12 = i3 - o0Var.f6991c;
        o0Var.f6991c = i3;
        if (i12 == 0) {
            return true;
        }
        Object[] objArr = uVar.f9582c;
        long[] jArr = uVar.f9580a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i13 = 0;
        while (true) {
            long j10 = jArr[i13];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8 - ((~(i13 - length)) >>> 31);
                for (int i15 = 0; i15 < i14; i15++) {
                    if ((255 & j10) < 128) {
                        o0 o0Var2 = (o0) objArr[(i13 << 3) + i15];
                        if (o0Var2.f6990b >= i11 && !o0Var2.equals(o0Var) && (i10 = o0Var2.f6990b + i12) >= 0) {
                            o0Var2.f6990b = i10;
                        }
                    }
                    j10 >>= 8;
                }
                if (i14 != 8) {
                    return true;
                }
            }
            if (i13 == length) {
                return true;
            }
            i13++;
        }
    }
}
