package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class u1 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ v1 f7081c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f7082f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ p.z f7083g;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i;
        int i3;
        int i10;
        v1 v1Var = this.f7081c;
        int i11 = this.f7082f;
        p.z zVar = this.f7083g;
        u uVar = (u) obj;
        if (v1Var.f7092e == i11 && yb.k.a(zVar, v1Var.f7093f) && (uVar instanceof y)) {
            long[] jArr = zVar.f9650a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i12 = 0;
                while (true) {
                    long j10 = jArr[i12];
                    if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i13 = 8;
                        int i14 = 8 - ((~(i12 - length)) >>> 31);
                        int i15 = 0;
                        while (i15 < i14) {
                            if ((255 & j10) < 128) {
                                int i16 = (i12 << 3) + i15;
                                Object obj2 = zVar.f9651b[i16];
                                boolean z10 = zVar.f9652c[i16] != i11;
                                if (z10) {
                                    y yVar = (y) uVar;
                                    i10 = i13;
                                    p.f0 f0Var = yVar.f7121k;
                                    h5.t.M(f0Var, obj2, v1Var);
                                    i3 = i11;
                                    if (obj2 instanceof i0) {
                                        i0 i0Var = (i0) obj2;
                                        if (!f0Var.c(i0Var)) {
                                            h5.t.N(yVar.f7124n, i0Var);
                                        }
                                        p.f0 f0Var2 = v1Var.f7094g;
                                        if (f0Var2 != null) {
                                            f0Var2.k(obj2);
                                        }
                                    }
                                } else {
                                    i3 = i11;
                                    i10 = i13;
                                }
                                if (z10) {
                                    zVar.g(i16);
                                }
                            } else {
                                i3 = i11;
                                i10 = i13;
                            }
                            j10 >>= i10;
                            i15++;
                            i13 = i10;
                            i11 = i3;
                        }
                        i = i11;
                        if (i14 != i13) {
                            break;
                        }
                    } else {
                        i = i11;
                    }
                    if (i12 == length) {
                        break;
                    }
                    i12++;
                    i11 = i;
                }
            }
        }
        return jb.v.f6774a;
    }
}
