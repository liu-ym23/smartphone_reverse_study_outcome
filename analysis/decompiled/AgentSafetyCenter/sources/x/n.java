package x;

import java.util.List;
import s1.n0;
import s1.o0;
import s1.p0;
import s1.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public int f15455a;

    /* renamed from: b, reason: collision with root package name */
    public List f15456b;

    /* renamed from: c, reason: collision with root package name */
    public w0.c f15457c;

    /* renamed from: d, reason: collision with root package name */
    public o2.l f15458d;

    /* renamed from: e, reason: collision with root package name */
    public int f15459e;

    /* renamed from: f, reason: collision with root package name */
    public long f15460f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15461g;

    /* renamed from: h, reason: collision with root package name */
    public Object f15462h;
    public androidx.compose.foundation.lazy.layout.a i;

    /* renamed from: j, reason: collision with root package name */
    public int f15463j;

    /* renamed from: k, reason: collision with root package name */
    public int f15464k;

    /* renamed from: l, reason: collision with root package name */
    public int f15465l;

    /* renamed from: m, reason: collision with root package name */
    public int f15466m;

    /* renamed from: n, reason: collision with root package name */
    public int f15467n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f15468o;

    public final long a(int i) {
        int[] iArr = this.f15468o;
        int i3 = i * 2;
        return td.h.c(iArr[i3], iArr[i3 + 1]);
    }

    public final void b(n0 n0Var) {
        p0 p0Var = p0.f11287f;
        List list = this.f15456b;
        if (this.f15467n == Integer.MIN_VALUE) {
            g5.f.s("position() should be called first");
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            o0 o0Var = (o0) list.get(i);
            int i3 = o0Var.f11278f;
            long jA = a(i);
            androidx.compose.foundation.lazy.layout.a aVar = this.i;
            w2.c.d(aVar.f915a.g(this.f15461g));
            long jD = o2.i.d(jA, this.f15460f);
            int i10 = q0.f11291b;
            n0Var.getClass();
            n0.b(n0Var, o0Var);
            o0Var.R(o2.i.d(jD, o0Var.i), 0.0f, p0Var);
        }
    }

    public final void c(int i, int i3, int i10) {
        int[] iArr = this.f15468o;
        this.f15463j = i;
        this.f15467n = i10;
        List list = this.f15456b;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            o0 o0Var = (o0) list.get(i11);
            int i12 = i11 * 2;
            w0.c cVar = this.f15457c;
            if (cVar == null) {
                g5.f.s("null horizontalAlignment when isVertical == true");
                return;
            }
            iArr[i12] = cVar.a(o0Var.f11277c, i3, this.f15458d);
            iArr[i12 + 1] = i;
            i += o0Var.f11278f;
        }
    }
}
