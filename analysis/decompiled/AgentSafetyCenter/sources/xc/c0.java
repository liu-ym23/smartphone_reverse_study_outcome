package xc;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class c0 implements vc.e, f {

    /* renamed from: a, reason: collision with root package name */
    public final String f15611a;

    /* renamed from: b, reason: collision with root package name */
    public final n f15612b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15613c;

    /* renamed from: d, reason: collision with root package name */
    public int f15614d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f15615e;

    /* renamed from: f, reason: collision with root package name */
    public final List[] f15616f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean[] f15617g;

    /* renamed from: h, reason: collision with root package name */
    public Object f15618h;
    public final Object i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f15619j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f15620k;

    public c0(String str, n nVar, int i) {
        this.f15611a = str;
        this.f15612b = nVar;
        this.f15613c = i;
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            strArr[i10] = "[UNINITIALIZED]";
        }
        this.f15615e = strArr;
        int i11 = this.f15613c;
        this.f15616f = new List[i11];
        this.f15617g = new boolean[i11];
        this.f15618h = kb.t.f7405c;
        jb.e eVar = jb.e.f6756c;
        b0 b0Var = new b0(i3);
        b0Var.f15608f = this;
        VarHandle.storeStoreFence();
        this.i = h5.t.G(eVar, b0Var);
        b0 b0Var2 = new b0(1);
        b0Var2.f15608f = this;
        VarHandle.storeStoreFence();
        this.f15619j = h5.t.G(eVar, b0Var2);
        b0 b0Var3 = new b0(2);
        b0Var3.f15608f = this;
        VarHandle.storeStoreFence();
        this.f15620k = h5.t.G(eVar, b0Var3);
    }

    @Override // vc.e
    public final String a() {
        return this.f15611a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    @Override // xc.f
    public final Set b() {
        return this.f15618h.keySet();
    }

    @Override // vc.e
    public final boolean c() {
        return false;
    }

    @Override // vc.e
    public final int d() {
        return this.f15613c;
    }

    @Override // vc.e
    public final String e(int i) {
        return this.f15615e[i];
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, jb.d] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, jb.d] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            vc.e eVar = (vc.e) obj;
            if (this.f15611a.equals(eVar.a()) && Arrays.equals((vc.e[]) this.f15619j.getValue(), (vc.e[]) ((c0) obj).f15619j.getValue())) {
                int iD = eVar.d();
                int i = this.f15613c;
                if (i == iD) {
                    for (int i3 = 0; i3 < i; i3++) {
                        if (yb.k.a(f(i3).a(), eVar.f(i3).a()) && yb.k.a(f(i3).getKind(), eVar.f(i3).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, jb.d] */
    @Override // vc.e
    public vc.e f(int i) {
        return ((tc.a[]) this.i.getValue())[i].getDescriptor();
    }

    public final void g(String str, boolean z10) {
        str.getClass();
        int i = this.f15614d + 1;
        this.f15614d = i;
        String[] strArr = this.f15615e;
        strArr[i] = str;
        this.f15617g[i] = z10;
        this.f15616f[i] = null;
        if (i == this.f15613c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                map.put(strArr[i3], Integer.valueOf(i3));
            }
            this.f15618h = map;
        }
    }

    @Override // vc.e
    public t.o getKind() {
        return vc.g.f14891b;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, jb.d] */
    public int hashCode() {
        return ((Number) this.f15620k.getValue()).intValue();
    }

    public String toString() {
        ec.g gVarO = p5.f.O(0, this.f15613c);
        String strConcat = this.f15611a.concat("(");
        a9.e eVar = new a9.e(19);
        eVar.f257f = this;
        VarHandle.storeStoreFence();
        return kb.l.B0(gVarO, ", ", strConcat, ")", eVar, 24);
    }
}
