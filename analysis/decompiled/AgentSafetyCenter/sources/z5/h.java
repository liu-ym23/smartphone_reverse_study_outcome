package z5;

import android.content.Context;
import e6.i;
import e6.k;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final i f16455a;

    /* renamed from: b, reason: collision with root package name */
    public final List f16456b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16457c;

    /* renamed from: d, reason: collision with root package name */
    public final i f16458d;

    /* renamed from: e, reason: collision with root package name */
    public final f6.g f16459e;

    /* renamed from: f, reason: collision with root package name */
    public final t5.c f16460f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f16461g;

    public h(i iVar, List list, int i, i iVar2, f6.g gVar, t5.c cVar, boolean z10) {
        this.f16455a = iVar;
        this.f16456b = list;
        this.f16457c = i;
        this.f16458d = iVar2;
        this.f16459e = gVar;
        this.f16460f = cVar;
        this.f16461g = z10;
    }

    public final void a(i iVar, f fVar) {
        Context context = iVar.f3547a;
        i iVar2 = this.f16455a;
        if (context != iVar2.f3547a) {
            od.f.r("Interceptor '", fVar, "' cannot modify the request's context.");
            return;
        }
        if (iVar.f3548b == k.f3572a) {
            od.f.r("Interceptor '", fVar, "' cannot set the request's data to null.");
            return;
        }
        if (iVar.f3549c != iVar2.f3549c) {
            od.f.r("Interceptor '", fVar, "' cannot modify the request's target.");
        } else if (iVar.f3567v != iVar2.f3567v) {
            od.f.r("Interceptor '", fVar, "' cannot modify the request's lifecycle.");
        } else {
            if (iVar.f3568w == iVar2.f3568w) {
                return;
            }
            od.f.r("Interceptor '", fVar, "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(e6.i r14, pb.c r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof z5.g
            if (r0 == 0) goto L13
            r0 = r15
            z5.g r0 = (z5.g) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            z5.g r0 = new z5.g
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.f16453g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2f
            z5.f r13 = r0.f16452f
            z5.h r14 = r0.f16451c
            id.c.I(r15)
            r12 = r15
            r15 = r13
            r13 = r14
            r14 = r12
            goto L6f
        L2f:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r13)
            r13 = 0
            return r13
        L36:
            id.c.I(r15)
            java.util.List r15 = r13.f16456b
            int r2 = r13.f16457c
            if (r2 <= 0) goto L4a
            int r4 = r2 + (-1)
            java.lang.Object r4 = r15.get(r4)
            z5.f r4 = (z5.f) r4
            r13.a(r14, r4)
        L4a:
            java.lang.Object r15 = r15.get(r2)
            z5.f r15 = (z5.f) r15
            int r7 = r2 + 1
            z5.h r4 = new z5.h
            t5.c r10 = r13.f16460f
            boolean r11 = r13.f16461g
            e6.i r5 = r13.f16455a
            java.util.List r6 = r13.f16456b
            f6.g r9 = r13.f16459e
            r8 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.f16451c = r13
            r0.f16452f = r15
            r0.i = r3
            java.lang.Object r14 = r15.d(r4, r0)
            if (r14 != r1) goto L6f
            return r1
        L6f:
            e6.j r14 = (e6.j) r14
            e6.i r0 = r14.b()
            r13.a(r0, r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.h.b(e6.i, pb.c):java.lang.Object");
    }
}
