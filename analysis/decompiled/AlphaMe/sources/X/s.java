package X;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public int f2078a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final y f2079b;

    /* renamed from: c, reason: collision with root package name */
    public y f2080c;

    /* renamed from: d, reason: collision with root package name */
    public y f2081d;

    /* renamed from: e, reason: collision with root package name */
    public int f2082e;

    /* renamed from: f, reason: collision with root package name */
    public int f2083f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2084g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f2085h;

    public s(y yVar, boolean z4, int[] iArr) {
        this.f2079b = yVar;
        this.f2080c = yVar;
        this.f2084g = z4;
        this.f2085h = iArr;
    }

    public final void a() {
        this.f2078a = 1;
        this.f2080c = this.f2079b;
        this.f2083f = 0;
    }

    public final boolean b() {
        int[] iArr;
        Y.a aVarC = this.f2080c.f2104b.c();
        int iA = aVarC.a(6);
        if ((iA == 0 || ((ByteBuffer) aVarC.f2114d).get(iA + aVarC.f2111a) == 0) && this.f2082e != 65039) {
            return this.f2084g && ((iArr = this.f2085h) == null || Arrays.binarySearch(iArr, this.f2080c.f2104b.a(0)) < 0);
        }
        return true;
    }
}
