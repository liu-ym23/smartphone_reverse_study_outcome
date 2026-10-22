package androidx.lifecycle;

import Z2.D0;
import java.util.Map;

/* renamed from: androidx.lifecycle.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0314k extends T {

    /* renamed from: m, reason: collision with root package name */
    public C0307d f3958m;

    @Override // androidx.lifecycle.P
    public final void e() {
        m.e eVar = (m.e) this.f3904l.iterator();
        if (eVar.hasNext()) {
            B0.g.y(((Map.Entry) eVar.next()).getValue());
            throw null;
        }
        C0307d c0307d = this.f3958m;
        if (c0307d != null) {
            D0 d02 = c0307d.f3925g;
            if (d02 != null) {
                d02.b(null);
            }
            c0307d.f3925g = null;
            if (c0307d.f3924f != null) {
                return;
            }
            c0307d.f3924f = t0.J.y(c0307d.f3922d, null, new C0306c(c0307d, null), 3);
        }
    }

    @Override // androidx.lifecycle.P
    public final void f() {
        m.e eVar = (m.e) this.f3904l.iterator();
        if (eVar.hasNext()) {
            B0.g.y(((Map.Entry) eVar.next()).getValue());
            throw null;
        }
        C0307d c0307d = this.f3958m;
        if (c0307d != null) {
            if (c0307d.f3925g != null) {
                throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
            }
            f3.d dVar = Z2.Q.f2189a;
            c0307d.f3925g = t0.J.y(c0307d.f3922d, d3.q.f12477a.getImmediate(), new C0305b(c0307d, null), 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Unit i(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.lifecycle.C0313j
            if (r0 == 0) goto L13
            r0 = r5
            androidx.lifecycle.j r0 = (androidx.lifecycle.C0313j) r0
            int r1 = r0.f3956c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3956c = r1
            goto L18
        L13:
            androidx.lifecycle.j r0 = new androidx.lifecycle.j
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f3954a
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r0.f3956c
            if (r0 == 0) goto L31
            r4 = 1
            if (r0 != r4) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            r4 = 0
            goto L34
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
        L34:
            r4.getClass()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.C0314k.i(kotlin.coroutines.Continuation):kotlin.Unit");
    }
}
