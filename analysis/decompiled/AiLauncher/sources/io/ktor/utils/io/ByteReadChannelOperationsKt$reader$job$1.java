package io.ktor.utils.io;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelOperationsKt$reader$job$1", f = "ByteReadChannelOperations.kt", l = {333, 343, 343, 343}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ByteReadChannelOperationsKt$reader$job$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ p<ReaderScope, InterfaceC4014c<? super t>, Object> $block;
    final /* synthetic */ ByteChannel $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ByteReadChannelOperationsKt$reader$job$1(p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, ByteChannel byteChannel, InterfaceC4014c<? super ByteReadChannelOperationsKt$reader$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$block = pVar;
        this.$channel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ByteReadChannelOperationsKt$reader$job$1 byteReadChannelOperationsKt$reader$job$1 = new ByteReadChannelOperationsKt$reader$job$1(this.$block, this.$channel, interfaceC4014c);
        byteReadChannelOperationsKt$reader$job$1.L$0 = obj;
        return byteReadChannelOperationsKt$reader$job$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ByteReadChannelOperationsKt$reader$job$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a1, code lost:
    
        if (r2.T0(r10) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
    
        if (r2.T0(r10) != r1) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.g] */
    /* JADX WARN: Type inference failed for: r2v3, types: [Ua.x, java.lang.Object, kotlinx.coroutines.g] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L40
            if (r2 == r6) goto L36
            if (r2 == r5) goto L2d
            if (r2 == r4) goto L2d
            if (r2 == r3) goto L20
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L20:
            java.lang.Object r0 = r10.L$2
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r10 = r10.L$1
            Ua.x r10 = (Ua.InterfaceC1089x) r10
            kotlin.C4849c.b(r11)
            goto Ldf
        L2d:
            java.lang.Object r10 = r10.L$1
            Ua.x r10 = (Ua.InterfaceC1089x) r10
            kotlin.C4849c.b(r11)
            goto Lc3
        L36:
            java.lang.Object r2 = r10.L$1
            Ua.x r2 = (Ua.InterfaceC1089x) r2
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L3e
            goto L6d
        L3e:
            r11 = move-exception
            goto La4
        L40:
            kotlin.C4849c.b(r11)
            kotlin.coroutines.d r11 = r0.getCoroutineContext()
            kotlinx.coroutines.g r11 = Ua.C1086v0.o(r11)
            Ua.x r2 = Ua.C1086v0.a(r11)
            p9.p<io.ktor.utils.io.ReaderScope, e9.c<? super Y8.t>, java.lang.Object> r11 = r10.$block     // Catch: java.lang.Throwable -> L3e
            io.ktor.utils.io.ReaderScope r7 = new io.ktor.utils.io.ReaderScope     // Catch: java.lang.Throwable -> L3e
            io.ktor.utils.io.ByteChannel r8 = r10.$channel     // Catch: java.lang.Throwable -> L3e
            kotlin.coroutines.d r9 = r0.getCoroutineContext()     // Catch: java.lang.Throwable -> L3e
            kotlin.coroutines.d r9 = r9.plus(r2)     // Catch: java.lang.Throwable -> L3e
            r7.<init>(r8, r9)     // Catch: java.lang.Throwable -> L3e
            r10.L$0 = r0     // Catch: java.lang.Throwable -> L3e
            r10.L$1 = r2     // Catch: java.lang.Throwable -> L3e
            r10.label = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r11 = r11.invoke(r7, r10)     // Catch: java.lang.Throwable -> L3e
            if (r11 != r1) goto L6d
            goto Ldd
        L6d:
            r2.complete()     // Catch: java.lang.Throwable -> L3e
            kotlin.coroutines.d r11 = r0.getCoroutineContext()     // Catch: java.lang.Throwable -> L3e
            kotlinx.coroutines.g r11 = Ua.C1086v0.o(r11)     // Catch: java.lang.Throwable -> L3e
            boolean r11 = r11.isCancelled()     // Catch: java.lang.Throwable -> L3e
            if (r11 == 0) goto L8f
            io.ktor.utils.io.ByteChannel r11 = r10.$channel     // Catch: java.lang.Throwable -> L3e
            kotlin.coroutines.d r6 = r0.getCoroutineContext()     // Catch: java.lang.Throwable -> L3e
            kotlinx.coroutines.g r6 = Ua.C1086v0.o(r6)     // Catch: java.lang.Throwable -> L3e
            java.util.concurrent.CancellationException r6 = r6.G()     // Catch: java.lang.Throwable -> L3e
            r11.cancel(r6)     // Catch: java.lang.Throwable -> L3e
        L8f:
            java.lang.Object r11 = g9.h.a(r0)
            r10.L$0 = r11
            java.lang.Object r11 = g9.h.a(r2)
            r10.L$1 = r11
            r10.label = r5
            java.lang.Object r10 = r2.T0(r10)
            if (r10 != r1) goto Lc3
            goto Ldd
        La4:
            java.lang.String r5 = "Exception thrown while reading from channel"
            Ua.C1086v0.d(r2, r5, r11)     // Catch: java.lang.Throwable -> Lc6
            io.ktor.utils.io.ByteChannel r5 = r10.$channel     // Catch: java.lang.Throwable -> Lc6
            io.ktor.utils.io.ByteWriteChannelOperationsKt.close(r5, r11)     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r11 = g9.h.a(r0)
            r10.L$0 = r11
            java.lang.Object r11 = g9.h.a(r2)
            r10.L$1 = r11
            r10.label = r4
            java.lang.Object r10 = r2.T0(r10)
            if (r10 != r1) goto Lc3
            goto Ldd
        Lc3:
            Y8.t r10 = Y8.t.f7040a
            return r10
        Lc6:
            r11 = move-exception
            java.lang.Object r0 = g9.h.a(r0)
            r10.L$0 = r0
            java.lang.Object r0 = g9.h.a(r2)
            r10.L$1 = r0
            r10.L$2 = r11
            r10.label = r3
            java.lang.Object r10 = r2.T0(r10)
            if (r10 != r1) goto Lde
        Ldd:
            return r1
        Lde:
            r0 = r11
        Ldf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt$reader$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
