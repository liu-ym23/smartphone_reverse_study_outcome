package kotlinx.coroutines.flow;

import Xa.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$catchImpl$2<T> implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<T> f36463a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Throwable> f36464b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$catchImpl$2(c<? super T> cVar, Ref$ObjectRef<Throwable> ref$ObjectRef) {
        this.f36463a = cVar;
        this.f36464b = ref$ObjectRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
    @Override // Xa.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) r0
            int r1 = r0.f36468d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36468d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f36466b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36468d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L29
            goto L47
        L29:
            r5 = move-exception
            goto L4a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.C4849c.b(r6)
            Xa.c<T> r6 = r4.f36463a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r2 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L29
            r0.f36465a = r2     // Catch: java.lang.Throwable -> L29
            r0.f36468d = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L47
            return r1
        L47:
            Y8.t r4 = Y8.t.f7040a
            return r4
        L4a:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Throwable> r4 = r4.f36464b
            r4.f34820a = r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2.emit(java.lang.Object, e9.c):java.lang.Object");
    }
}
