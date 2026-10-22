package kotlinx.coroutines.flow;

import Xa.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__LimitKt$drop$2$1<T> implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f36473a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f36474b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c<T> f36475c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$drop$2$1(Ref$IntRef ref$IntRef, int i10, c<? super T> cVar) {
        this.f36473a = ref$IntRef;
        this.f36474b = i10;
        this.f36475c = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Xa.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1) r0
            int r1 = r0.f36479d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36479d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f36477b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36479d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.C4849c.b(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = r5.f36473a
            int r2 = r7.f34818a
            int r4 = r5.f36474b
            if (r2 < r4) goto L50
            Xa.c<T> r5 = r5.f36475c
            java.lang.Object r7 = g9.h.a(r6)
            r0.f36476a = r7
            r0.f36479d = r3
            java.lang.Object r5 = r5.emit(r6, r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            Y8.t r5 = Y8.t.f7040a
            return r5
        L50:
            int r2 = r2 + r3
            r7.f34818a = r2
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1.emit(java.lang.Object, e9.c):java.lang.Object");
    }
}
