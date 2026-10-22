package z8;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;

/* loaded from: classes4.dex */
public final class t {
    public static final t k = new t(false, false, false, false, false, new t(false, false, false, false, false, null, false, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS), false, null, null, 988);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6990a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final t f;
    public final boolean g;
    public final t h;
    public final t i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f6991j;

    public t(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, t tVar, boolean z15, t tVar2, t tVar3, int i) {
        z10 = (i & 1) != 0 ? true : z10;
        z11 = (i & 2) != 0 ? true : z11;
        z12 = (i & 4) != 0 ? false : z12;
        z13 = (i & 8) != 0 ? false : z13;
        z14 = (i & 16) != 0 ? false : z14;
        tVar = (i & 32) != 0 ? null : tVar;
        z15 = (i & 64) != 0 ? true : z15;
        tVar2 = (i & 128) != 0 ? tVar : tVar2;
        tVar3 = (i & 256) != 0 ? tVar : tVar3;
        boolean z16 = (i & 512) == 0;
        this.f6990a = z10;
        this.b = z11;
        this.c = z12;
        this.d = z13;
        this.e = z14;
        this.f = tVar;
        this.g = z15;
        this.h = tVar2;
        this.i = tVar3;
        this.f6991j = z16;
    }
}
