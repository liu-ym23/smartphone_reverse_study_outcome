package androidx.compose.foundation.gestures;

import java.lang.invoke.VarHandle;
import t.b1;
import u.f0;
import u.k;
import u.l0;
import u.m0;
import u.n0;
import u.u0;
import w0.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f871a = new m0();

    /* renamed from: b, reason: collision with root package name */
    public static final l0 f872b = new l0();

    /* renamed from: c, reason: collision with root package name */
    public static final n0 f873c = new n0();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(u.z0 r11, long r12, pb.c r14) {
        /*
            boolean r0 = r14 instanceof u.o0
            if (r0 == 0) goto L13
            r0 = r14
            u.o0 r0 = (u.o0) r0
            int r1 = r0.f13539h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13539h = r1
            goto L18
        L13:
            u.o0 r0 = new u.o0
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f13538g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f13539h
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            yb.r r11 = r0.f13537f
            u.z0 r12 = r0.f13536c
            id.c.I(r14)
            r9 = r11
            r11 = r12
            goto L55
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r11)
            r11 = 0
            return r11
        L34:
            id.c.I(r14)
            yb.r r9 = new yb.r
            r9.<init>()
            m8.y r4 = new m8.y
            r10 = 0
            r5 = 2
            r8 = r11
            r6 = r12
            r4.<init>(r5, r6, r8, r9, r10)
            r0.f13536c = r8
            r0.f13537f = r9
            r0.f13539h = r3
            t.u0 r11 = t.u0.f13068c
            java.lang.Object r11 = r8.e(r11, r4, r0)
            if (r11 != r1) goto L54
            return r1
        L54:
            r11 = r8
        L55:
            float r12 = r9.f16095c
            long r11 = r11.g(r12)
            c1.b r11 = c1.b.a(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.a.a(u.z0, long, pb.c):java.lang.Object");
    }

    public static final m b(m mVar, u0 u0Var, f0 f0Var, b1 b1Var, boolean z10, boolean z11, k kVar, v.k kVar2) {
        ScrollableElement scrollableElement = new ScrollableElement();
        scrollableElement.f865c = u0Var;
        scrollableElement.f866f = f0Var;
        scrollableElement.f867g = b1Var;
        scrollableElement.f868h = z10;
        scrollableElement.i = z11;
        scrollableElement.f869j = kVar;
        scrollableElement.f870k = kVar2;
        VarHandle.storeStoreFence();
        return mVar.d(scrollableElement);
    }
}
