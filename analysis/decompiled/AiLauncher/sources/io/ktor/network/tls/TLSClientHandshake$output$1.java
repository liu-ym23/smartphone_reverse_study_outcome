package io.ktor.network.tls;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/c;", "Lio/ktor/network/tls/TLSRecord;", "LY8/t;", "<anonymous>", "(LWa/c;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake$output$1", f = "TLSClientHandshake.kt", l = {109, 114}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class TLSClientHandshake$output$1 extends SuspendLambda implements p<Wa.c<TLSRecord>, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ByteWriteChannel $rawOutput;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TLSClientHandshake this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TLSClientHandshake$output$1(TLSClientHandshake tLSClientHandshake, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super TLSClientHandshake$output$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = tLSClientHandshake;
        this.$rawOutput = byteWriteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TLSClientHandshake$output$1 tLSClientHandshake$output$1 = new TLSClientHandshake$output$1(this.this$0, this.$rawOutput, interfaceC4014c);
        tLSClientHandshake$output$1.L$0 = obj;
        return tLSClientHandshake$output$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.c<TLSRecord> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TLSClientHandshake$output$1) create(cVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        if (io.ktor.network.tls.RenderKt.writeRecord(r6, r5, r9) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009d -> B:8:0x0021). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.L$0
            Wa.c r0 = (Wa.c) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r9.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L2e
            if (r2 != r3) goto L26
            java.lang.Object r2 = r9.L$3
            io.ktor.network.tls.TLSRecord r2 = (io.ktor.network.tls.TLSRecord) r2
            java.lang.Object r2 = r9.L$2
            io.ktor.network.tls.TLSRecord r2 = (io.ktor.network.tls.TLSRecord) r2
            java.lang.Object r2 = r9.L$1
            Wa.i r2 = (Wa.i) r2
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L23
        L21:
            r10 = r2
            goto L41
        L23:
            r9 = move-exception
            goto La0
        L26:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2e:
            java.lang.Object r2 = r9.L$1
            Wa.i r2 = (Wa.i) r2
            kotlin.C4849c.b(r10)
            goto L56
        L36:
            kotlin.C4849c.b(r10)
            Wa.g r10 = r0.getChannel()
            Wa.i r10 = r10.iterator()
        L41:
            r9.L$0 = r0
            r9.L$1 = r10
            r2 = 0
            r9.L$2 = r2
            r9.L$3 = r2
            r9.label = r4
            java.lang.Object r2 = r10.a(r9)
            if (r2 != r1) goto L53
            goto L9f
        L53:
            r8 = r2
            r2 = r10
            r10 = r8
        L56:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto La7
            java.lang.Object r10 = r2.next()
            io.ktor.network.tls.TLSRecord r10 = (io.ktor.network.tls.TLSRecord) r10
            io.ktor.network.tls.TLSClientHandshake r5 = r9.this$0     // Catch: java.lang.Throwable -> L23
            boolean r5 = r5.getUseCipher()     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L77
            io.ktor.network.tls.TLSClientHandshake r5 = r9.this$0     // Catch: java.lang.Throwable -> L23
            io.ktor.network.tls.cipher.TLSCipher r5 = io.ktor.network.tls.TLSClientHandshake.access$getCipher(r5)     // Catch: java.lang.Throwable -> L23
            io.ktor.network.tls.TLSRecord r5 = r5.encrypt(r10)     // Catch: java.lang.Throwable -> L23
            goto L78
        L77:
            r5 = r10
        L78:
            io.ktor.network.tls.TLSRecordType r6 = r10.getType()     // Catch: java.lang.Throwable -> L23
            io.ktor.network.tls.TLSRecordType r7 = io.ktor.network.tls.TLSRecordType.ChangeCipherSpec     // Catch: java.lang.Throwable -> L23
            if (r6 != r7) goto L85
            io.ktor.network.tls.TLSClientHandshake r6 = r9.this$0     // Catch: java.lang.Throwable -> L23
            r6.setUseCipher(r4)     // Catch: java.lang.Throwable -> L23
        L85:
            io.ktor.utils.io.ByteWriteChannel r6 = r9.$rawOutput     // Catch: java.lang.Throwable -> L23
            r9.L$0 = r0     // Catch: java.lang.Throwable -> L23
            r9.L$1 = r2     // Catch: java.lang.Throwable -> L23
            java.lang.Object r10 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L23
            r9.L$2 = r10     // Catch: java.lang.Throwable -> L23
            java.lang.Object r10 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L23
            r9.L$3 = r10     // Catch: java.lang.Throwable -> L23
            r9.label = r3     // Catch: java.lang.Throwable -> L23
            java.lang.Object r10 = io.ktor.network.tls.RenderKt.writeRecord(r6, r5, r9)     // Catch: java.lang.Throwable -> L23
            if (r10 != r1) goto L21
        L9f:
            return r1
        La0:
            Wa.g r10 = r0.getChannel()
            r10.close(r9)
        La7:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake$output$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
