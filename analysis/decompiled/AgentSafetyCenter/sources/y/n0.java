package y;

import java.lang.invoke.VarHandle;
import java.util.List;
import s1.w0;
import s1.y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f15794a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15795b;

    /* renamed from: c, reason: collision with root package name */
    public final o0 f15796c;

    /* renamed from: d, reason: collision with root package name */
    public w0 f15797d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15798e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15799f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15800g;

    /* renamed from: h, reason: collision with root package name */
    public u0.i f15801h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ p5.m f15802j;

    public n0(p5.m mVar, int i, long j10, o0 o0Var) {
        this.f15802j = mVar;
        this.f15794a = i;
        this.f15795b = j10;
        this.f15796c = o0Var;
    }

    @Override // y.d0
    public final void a() {
        this.i = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(y.a r25) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.n0.b(y.a):boolean");
    }

    public final boolean c() {
        if (this.f15799f) {
            return false;
        }
        int iC = ((x.h) ((u) this.f15802j.f9741f).f15826b.invoke()).c();
        int i = this.f15794a;
        return i >= 0 && i < iC;
    }

    @Override // y.d0
    public final void cancel() {
        if (this.f15799f) {
            return;
        }
        this.f15799f = true;
        w0 w0Var = this.f15797d;
        if (w0Var != null) {
            w0Var.dispose();
        }
        this.f15797d = null;
    }

    public final void d() {
        if (!c()) {
            g5.f.s("Callers should check whether the request is still valid before calling performComposition()");
            return;
        }
        if (this.f15797d != null) {
            g5.f.s("Request was already composed!");
            return;
        }
        p5.m mVar = this.f15802j;
        x.h hVar = (x.h) ((u) mVar.f9741f).f15826b.invoke();
        int i = this.f15794a;
        Object objD = hVar.d(i);
        this.f15797d = ((y0) mVar.f9742g).a().f(objD, ((u) mVar.f9741f).a(i, objD, hVar.b(i)));
    }

    public final u0.i e() {
        w0 w0Var = this.f15797d;
        if (w0Var == null) {
            g5.f.s("Should precompose before resolving nested prefetch states");
            return null;
        }
        yb.u uVar = new yb.u();
        w0Var.c(new n1.h(uVar, 3));
        List list = (List) uVar.f16098c;
        if (list != null) {
            u0.i iVar = new u0.i();
            iVar.f13661e = this;
            iVar.f13659c = list;
            iVar.f13660d = new List[list.size()];
            if (!list.isEmpty()) {
                VarHandle.storeStoreFence();
                return iVar;
            }
            g5.f.s("NestedPrefetchController shouldn't be created with no states");
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("HandleAndRequestImpl { index = ");
        sb2.append(this.f15794a);
        sb2.append(", constraints = ");
        sb2.append((Object) o2.a.m(this.f15795b));
        sb2.append(", isComposed = ");
        sb2.append(this.f15797d != null);
        sb2.append(", isMeasured = ");
        sb2.append(this.f15798e);
        sb2.append(", isCanceled = ");
        sb2.append(this.f15799f);
        sb2.append(" }");
        return sb2.toString();
    }
}
