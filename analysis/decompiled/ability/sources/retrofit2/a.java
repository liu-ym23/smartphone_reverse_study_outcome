package retrofit2;

import H7.c;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import m9.C1718k;
import qa.InterfaceC1852d;
import qa.r;
import v0.C2054a;
import w0.C2086g;

/* loaded from: classes4.dex */
public abstract class a {
    public static final Object a(InterfaceC1852d interfaceC1852d, c cVar) {
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        c1718k.j(new r(interfaceC1852d, 0));
        interfaceC1852d.g(new C2054a(c1718k));
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    public static final Object b(InterfaceC1852d interfaceC1852d, c cVar) {
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        c1718k.j(new r(interfaceC1852d, 1));
        interfaceC1852d.g(new C2086g(c1718k));
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(java.lang.Throwable r5, H7.c r6) {
        /*
            boolean r0 = r6 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r6
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f5970a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.b
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 == r2) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            kotlin.b.b(r6)
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        L34:
            kotlin.b.b(r6)
            r0.b = r2
            u9.d r6 = m9.AbstractC1691I.f5315a
            H7.h r1 = r0.getContext()
            A.a r2 = new A.a
            r3 = 15
            r4 = 0
            r2.<init>(r3, r0, r4, r5)
            r6.dispatch(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.a.c(java.lang.Throwable, H7.c):void");
    }
}
