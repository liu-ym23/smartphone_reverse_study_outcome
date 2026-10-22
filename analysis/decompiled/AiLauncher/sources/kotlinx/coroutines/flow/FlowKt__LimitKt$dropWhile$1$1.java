package kotlinx.coroutines.flow;

import Xa.c;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.p;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f36480a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c<T> f36481b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p<T, InterfaceC4014c<? super Boolean>, Object> f36482c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref$BooleanRef ref$BooleanRef, c<? super T> cVar, p<? super T, ? super InterfaceC4014c<? super Boolean>, ? extends Object> pVar) {
        this.f36480a = ref$BooleanRef;
        this.f36481b = cVar;
        this.f36482c = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r6.emit(r7, r0) == r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        if (r6.emit(r7, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Xa.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.f36486d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36486d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f36484b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36486d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.C4849c.b(r8)
            goto L88
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r7 = r0.f36483a
            kotlin.C4849c.b(r8)
            goto L6b
        L3d:
            kotlin.C4849c.b(r8)
            goto L5b
        L41:
            kotlin.C4849c.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f36480a
            boolean r8 = r8.f34815a
            if (r8 == 0) goto L5e
            Xa.c<T> r6 = r6.f36481b
            java.lang.Object r8 = g9.h.a(r7)
            r0.f36483a = r8
            r0.f36486d = r5
            java.lang.Object r6 = r6.emit(r7, r0)
            if (r6 != r1) goto L5b
            goto L87
        L5b:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L5e:
            p9.p<T, e9.c<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f36482c
            r0.f36483a = r7
            r0.f36486d = r4
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L6b
            goto L87
        L6b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L8b
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f36480a
            r8.f34815a = r5
            Xa.c<T> r6 = r6.f36481b
            java.lang.Object r8 = g9.h.a(r7)
            r0.f36483a = r8
            r0.f36486d = r3
            java.lang.Object r6 = r6.emit(r7, r0)
            if (r6 != r1) goto L88
        L87:
            return r1
        L88:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L8b:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.emit(java.lang.Object, e9.c):java.lang.Object");
    }
}
