package l0;

import java.util.ArrayList;
import k0.e2;
import k0.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public k0.s f7658a;

    /* renamed from: b, reason: collision with root package name */
    public a f7659b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7660c;

    /* renamed from: d, reason: collision with root package name */
    public r0 f7661d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7662e;

    /* renamed from: f, reason: collision with root package name */
    public int f7663f;

    /* renamed from: g, reason: collision with root package name */
    public int f7664g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f7665h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f7666j;

    /* renamed from: k, reason: collision with root package name */
    public int f7667k;

    /* renamed from: l, reason: collision with root package name */
    public int f7668l;

    public final void a() {
        c();
        ArrayList arrayList = this.f7665h;
        if (arrayList.isEmpty()) {
            this.f7664g++;
        } else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public final void b() {
        ArrayList arrayList = this.f7665h;
        int i = this.f7664g;
        if (i > 0) {
            k0 k0Var = this.f7659b.f7656c;
            k0Var.T(g0.f7680c);
            k0Var.f7690e[k0Var.f7691f - k0Var.f7688c[k0Var.f7689d - 1].f7684a] = i;
            this.f7664g = 0;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        a aVar = this.f7659b;
        int size = arrayList.size();
        Object[] objArr = new Object[size];
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = arrayList.get(i3);
        }
        aVar.getClass();
        if (size != 0) {
            k0 k0Var2 = aVar.f7656c;
            k0Var2.T(k.f7687c);
            id.k.R(k0Var2, 0, objArr);
        }
        arrayList.clear();
    }

    public final void c() {
        int i = this.f7668l;
        if (i > 0) {
            int i3 = this.i;
            if (i3 >= 0) {
                b();
                k0 k0Var = this.f7659b.f7656c;
                k0Var.T(y.f7711c);
                int i10 = k0Var.f7691f - k0Var.f7688c[k0Var.f7689d - 1].f7684a;
                int[] iArr = k0Var.f7690e;
                iArr[i10] = i3;
                iArr[i10 + 1] = i;
                this.i = -1;
            } else {
                int i11 = this.f7667k;
                int i12 = this.f7666j;
                b();
                k0 k0Var2 = this.f7659b.f7656c;
                k0Var2.T(v.f7708c);
                int i13 = k0Var2.f7691f - k0Var2.f7688c[k0Var2.f7689d - 1].f7684a;
                int[] iArr2 = k0Var2.f7690e;
                iArr2[i13 + 1] = i11;
                iArr2[i13] = i12;
                iArr2[i13 + 2] = i;
                this.f7666j = -1;
                this.f7667k = -1;
            }
            this.f7668l = 0;
        }
    }

    public final void d(boolean z10) {
        e2 e2Var = this.f7658a.G;
        int i = z10 ? e2Var.i : e2Var.f6888g;
        int i3 = i - this.f7663f;
        if (i3 < 0) {
            k0.t.c("Tried to seek backward");
        }
        if (i3 > 0) {
            k0 k0Var = this.f7659b.f7656c;
            k0Var.T(d.f7673c);
            k0Var.f7690e[k0Var.f7691f - k0Var.f7688c[k0Var.f7689d - 1].f7684a] = i3;
            this.f7663f = i;
        }
    }

    public final void e(int i, int i3) {
        if (i3 > 0) {
            if (!(i >= 0)) {
                k0.t.c("Invalid remove index " + i);
            }
            if (this.i == i) {
                this.f7668l += i3;
                return;
            }
            c();
            this.i = i;
            this.f7668l = i3;
        }
    }
}
