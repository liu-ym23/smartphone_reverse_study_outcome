package io.ktor.network.sockets;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "Lio/ktor/network/sockets/Datagram;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.network.sockets.DatagramSocketImpl$receiver$1", f = "DatagramSocketImpl.kt", l = {52, 52}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DatagramSocketImpl$receiver$1 extends SuspendLambda implements p<Wa.p<? super Datagram>, InterfaceC4014c<? super t>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DatagramSocketImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatagramSocketImpl$receiver$1(DatagramSocketImpl datagramSocketImpl, InterfaceC4014c<? super DatagramSocketImpl$receiver$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = datagramSocketImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        DatagramSocketImpl$receiver$1 datagramSocketImpl$receiver$1 = new DatagramSocketImpl$receiver$1(this.this$0, interfaceC4014c);
        datagramSocketImpl$receiver$1.L$0 = obj;
        return datagramSocketImpl$receiver$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super Datagram> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DatagramSocketImpl$receiver$1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c A[Catch: ClosedChannelException | IOException -> 0x004a, ClosedChannelException | IOException -> 0x004a, PHI: r2 r7
      0x003c: PHI (r2v1 Wa.s) = (r2v2 Wa.s), (r2v4 Wa.s) binds: [B:15:0x0039, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]
      0x003c: PHI (r7v1 java.lang.Object) = (r7v4 java.lang.Object), (r7v0 java.lang.Object) binds: [B:15:0x0039, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {ClosedChannelException | IOException -> 0x004a, blocks: (B:6:0x0012, B:14:0x0029, B:14:0x0029, B:17:0x003c, B:17:0x003c, B:11:0x0022, B:11:0x0022), top: B:22:0x000c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0047 -> B:14:0x0029). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            Wa.p r0 = (Wa.p) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r6.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L4a
            goto L29
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1e:
            java.lang.Object r2 = r6.L$1
            Wa.s r2 = (Wa.s) r2
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            goto L3c
        L26:
            kotlin.C4849c.b(r7)
        L29:
            Wa.s r2 = r0.getChannel()     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            io.ktor.network.sockets.DatagramSocketImpl r7 = r6.this$0     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r6.L$0 = r0     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r6.L$1 = r2     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r6.label = r4     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            java.lang.Object r7 = io.ktor.network.sockets.DatagramSocketImpl.access$receiveImpl(r7, r6)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            if (r7 != r1) goto L3c
            goto L49
        L3c:
            r6.L$0 = r0     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r5 = 0
            r6.L$1 = r5     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r6.label = r3     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            java.lang.Object r7 = r2.send(r7, r6)     // Catch: java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            if (r7 != r1) goto L29
        L49:
            return r1
        L4a:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSocketImpl$receiver$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
