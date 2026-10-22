package io.ktor.network.tls;

import Y8.t;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "Lio/ktor/network/tls/TLSHandshake;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake$handshakes$1", f = "TLSClientHandshake.kt", l = {F.GESTURE_HEIGHT_DP, DidiCardView.FINISHED_SUMMARY_WIDTH_DP}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class TLSClientHandshake$handshakes$1 extends SuspendLambda implements p<Wa.p<? super TLSHandshake>, InterfaceC4014c<? super t>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TLSClientHandshake this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TLSClientHandshake$handshakes$1(TLSClientHandshake tLSClientHandshake, InterfaceC4014c<? super TLSClientHandshake$handshakes$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = tLSClientHandshake;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TLSClientHandshake$handshakes$1 tLSClientHandshake$handshakes$1 = new TLSClientHandshake$handshakes$1(this.this$0, interfaceC4014c);
        tLSClientHandshake$handshakes$1.L$0 = obj;
        return tLSClientHandshake$handshakes$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super TLSHandshake> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TLSClientHandshake$handshakes$1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
    
        if (r9 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        if (r2.getType() == io.ktor.network.tls.TLSHandshakeType.Finished) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        io.ktor.network.tls.UtilsKt.m168plusAssignHh8V18w(r8.this$0.digest, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        r9 = r0.getChannel();
        r8.L$0 = r0;
        r8.L$1 = g9.h.a(r6);
        r8.L$2 = r5;
        r8.L$3 = r2;
        r8.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0093, code lost:
    
        if (r9.send(r2, r8) != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0054 -> B:17:0x005a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0093 -> B:27:0x0096). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            Wa.p r0 = (Wa.p) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r8.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2f
            if (r2 == r4) goto L2b
            if (r2 != r3) goto L23
            java.lang.Object r2 = r8.L$3
            io.ktor.network.tls.TLSHandshake r2 = (io.ktor.network.tls.TLSHandshake) r2
            java.lang.Object r5 = r8.L$2
            fb.v r5 = (fb.v) r5
            java.lang.Object r6 = r8.L$1
            io.ktor.network.tls.TLSRecord r6 = (io.ktor.network.tls.TLSRecord) r6
            kotlin.C4849c.b(r9)
            goto L96
        L23:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2b:
            kotlin.C4849c.b(r9)
            goto L4a
        L2f:
            kotlin.C4849c.b(r9)
        L32:
            io.ktor.network.tls.TLSClientHandshake r9 = r8.this$0
            Wa.r r9 = r9.getInput()
            r8.L$0 = r0
            r2 = 0
            r8.L$1 = r2
            r8.L$2 = r2
            r8.L$3 = r2
            r8.label = r4
            java.lang.Object r9 = r9.receive(r8)
            if (r9 != r1) goto L4a
            goto L95
        L4a:
            io.ktor.network.tls.TLSRecord r9 = (io.ktor.network.tls.TLSRecord) r9
            io.ktor.network.tls.TLSRecordType r2 = r9.getType()
            io.ktor.network.tls.TLSRecordType r5 = io.ktor.network.tls.TLSRecordType.Handshake
            if (r2 != r5) goto La4
            fb.v r2 = r9.getPacket()
            r6 = r9
            r5 = r2
        L5a:
            boolean r9 = r5.k()
            if (r9 != 0) goto L32
            io.ktor.network.tls.TLSHandshake r2 = io.ktor.network.tls.ParserKt.readTLSHandshake(r5)
            io.ktor.network.tls.TLSHandshakeType r9 = r2.getType()
            io.ktor.network.tls.TLSHandshakeType r7 = io.ktor.network.tls.TLSHandshakeType.HelloRequest
            if (r9 == r7) goto L5a
            io.ktor.network.tls.TLSHandshakeType r9 = r2.getType()
            io.ktor.network.tls.TLSHandshakeType r7 = io.ktor.network.tls.TLSHandshakeType.Finished
            if (r9 == r7) goto L7d
            io.ktor.network.tls.TLSClientHandshake r9 = r8.this$0
            fb.s r9 = io.ktor.network.tls.TLSClientHandshake.access$getDigest$p(r9)
            io.ktor.network.tls.UtilsKt.m168plusAssignHh8V18w(r9, r2)
        L7d:
            Wa.s r9 = r0.getChannel()
            r8.L$0 = r0
            java.lang.Object r7 = g9.h.a(r6)
            r8.L$1 = r7
            r8.L$2 = r5
            r8.L$3 = r2
            r8.label = r3
            java.lang.Object r9 = r9.send(r2, r8)
            if (r9 != r1) goto L96
        L95:
            return r1
        L96:
            io.ktor.network.tls.TLSHandshakeType r9 = r2.getType()
            io.ktor.network.tls.TLSHandshakeType r2 = io.ktor.network.tls.TLSHandshakeType.Finished
            if (r9 != r2) goto L5a
            r5.close()
            Y8.t r8 = Y8.t.f7040a
            return r8
        La4:
            fb.v r8 = r9.getPacket()
            r8.close()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "TLS handshake expected, got "
            r0.append(r1)
            io.ktor.network.tls.TLSRecordType r9 = r9.getType()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake$handshakes$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
