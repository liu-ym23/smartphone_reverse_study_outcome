package io.ktor.network.tls;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake$output$2$1$1", f = "TLSClientHandshake.kt", l = {132, 133}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class TLSClientHandshake$output$2$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ByteWriteChannel $rawOutput;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TLSClientHandshake this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TLSClientHandshake$output$2$1$1(TLSClientHandshake tLSClientHandshake, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super TLSClientHandshake$output$2$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = tLSClientHandshake;
        this.$rawOutput = byteWriteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TLSClientHandshake$output$2$1$1(this.this$0, this.$rawOutput, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TLSClientHandshake$output$2$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
    
        if (r11.flushAndClose(r10) == r0) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r0 = r10.L$1
            io.ktor.network.tls.TLSRecord r0 = (io.ktor.network.tls.TLSRecord) r0
            java.lang.Object r0 = r10.L$0
            io.ktor.network.tls.TLSRecord r0 = (io.ktor.network.tls.TLSRecord) r0
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L1b
            goto L9f
        L1b:
            r0 = move-exception
            r11 = r0
            goto Lab
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L27:
            java.lang.Object r1 = r10.L$1
            io.ktor.network.tls.TLSRecord r1 = (io.ktor.network.tls.TLSRecord) r1
            java.lang.Object r3 = r10.L$0
            io.ktor.network.tls.TLSRecord r3 = (io.ktor.network.tls.TLSRecord) r3
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L1b
            goto L88
        L33:
            kotlin.C4849c.b(r11)
            io.ktor.network.tls.TLSRecordType r5 = io.ktor.network.tls.TLSRecordType.Alert     // Catch: java.lang.Throwable -> L1b
            fb.a r7 = new fb.a     // Catch: java.lang.Throwable -> L1b
            r7.<init>()     // Catch: java.lang.Throwable -> L1b
            io.ktor.network.tls.TLSAlertLevel r11 = io.ktor.network.tls.TLSAlertLevel.WARNING     // Catch: java.lang.Throwable -> L1b
            int r11 = r11.getCode()     // Catch: java.lang.Throwable -> L1b
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L1b
            r7.H0(r11)     // Catch: java.lang.Throwable -> L1b
            io.ktor.network.tls.TLSAlertType r11 = io.ktor.network.tls.TLSAlertType.CloseNotify     // Catch: java.lang.Throwable -> L1b
            int r11 = r11.getCode()     // Catch: java.lang.Throwable -> L1b
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L1b
            r7.H0(r11)     // Catch: java.lang.Throwable -> L1b
            Y8.t r11 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L1b
            io.ktor.network.tls.TLSRecord r4 = new io.ktor.network.tls.TLSRecord     // Catch: java.lang.Throwable -> L1b
            r6 = 0
            r8 = 2
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L1b
            io.ktor.network.tls.TLSClientHandshake r11 = r10.this$0     // Catch: java.lang.Throwable -> L1b
            boolean r11 = r11.getUseCipher()     // Catch: java.lang.Throwable -> L1b
            if (r11 == 0) goto L6f
            io.ktor.network.tls.TLSClientHandshake r11 = r10.this$0     // Catch: java.lang.Throwable -> L1b
            io.ktor.network.tls.cipher.TLSCipher r11 = io.ktor.network.tls.TLSClientHandshake.access$getCipher(r11)     // Catch: java.lang.Throwable -> L1b
            io.ktor.network.tls.TLSRecord r11 = r11.encrypt(r4)     // Catch: java.lang.Throwable -> L1b
            r1 = r11
            goto L70
        L6f:
            r1 = r4
        L70:
            io.ktor.utils.io.ByteWriteChannel r11 = r10.$rawOutput     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r5 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L1b
            r10.L$0 = r5     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r5 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L1b
            r10.L$1 = r5     // Catch: java.lang.Throwable -> L1b
            r10.label = r3     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r11 = io.ktor.network.tls.RenderKt.writeRecord(r11, r1, r10)     // Catch: java.lang.Throwable -> L1b
            if (r11 != r0) goto L87
            goto L9e
        L87:
            r3 = r4
        L88:
            io.ktor.utils.io.ByteWriteChannel r11 = r10.$rawOutput     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r3 = g9.h.a(r3)     // Catch: java.lang.Throwable -> L1b
            r10.L$0 = r3     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r1 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L1b
            r10.L$1 = r1     // Catch: java.lang.Throwable -> L1b
            r10.label = r2     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r11 = r11.flushAndClose(r10)     // Catch: java.lang.Throwable -> L1b
            if (r11 != r0) goto L9f
        L9e:
            return r0
        L9f:
            io.ktor.network.tls.TLSClientHandshake r10 = r10.this$0
            Ua.x r10 = io.ktor.network.tls.TLSClientHandshake.access$getCloseTask$p(r10)
            r10.complete()
            Y8.t r10 = Y8.t.f7040a
            return r10
        Lab:
            io.ktor.network.tls.TLSClientHandshake r10 = r10.this$0
            Ua.x r10 = io.ktor.network.tls.TLSClientHandshake.access$getCloseTask$p(r10)
            r10.complete()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake$output$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
