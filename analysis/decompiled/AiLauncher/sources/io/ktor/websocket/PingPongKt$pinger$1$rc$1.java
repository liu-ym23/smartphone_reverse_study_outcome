package io.ktor.websocket;

import Ua.M;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", l = {77, 81}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Wa.g<Frame.Pong> $channel;
    final /* synthetic */ s<Frame> $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PingPongKt$pinger$1$rc$1(s<? super Frame> sVar, String str, Wa.g<Frame.Pong> gVar, InterfaceC4014c<? super PingPongKt$pinger$1$rc$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$outgoing = sVar;
        this.$pingMessage = str;
        this.$channel = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PingPongKt$pinger$1$rc$1(this.$outgoing, this.$pingMessage, this.$channel, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PingPongKt$pinger$1$rc$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r10 == r0) goto L15;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004a -> B:16:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r10)
            goto L4d
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1a:
            kotlin.C4849c.b(r10)
            goto L42
        L1e:
            kotlin.C4849c.b(r10)
            vc.c r10 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()
            java.lang.String r1 = "WebSocket Pinger: sending ping frame"
            r10.trace(r1)
            Wa.s<io.ktor.websocket.Frame> r10 = r9.$outgoing
            io.ktor.websocket.Frame$Ping r1 = new io.ktor.websocket.Frame$Ping
            java.lang.String r4 = r9.$pingMessage
            java.nio.charset.Charset r5 = La.C0953c.ISO_8859_1
            byte[] r4 = io.ktor.utils.io.core.StringsKt.toByteArray(r4, r5)
            r1.<init>(r4)
            r9.label = r3
            java.lang.Object r10 = r10.send(r1, r9)
            if (r10 != r0) goto L42
            goto L4c
        L42:
            Wa.g<io.ktor.websocket.Frame$Pong> r10 = r9.$channel
            r9.label = r2
            java.lang.Object r10 = r10.receive(r9)
            if (r10 != r0) goto L4d
        L4c:
            return r0
        L4d:
            io.ktor.websocket.Frame$Pong r10 = (io.ktor.websocket.Frame.Pong) r10
            byte[] r3 = r10.getData()
            byte[] r1 = r10.getData()
            int r5 = r1.length
            r7 = 4
            r8 = 0
            r4 = 0
            r6 = 0
            java.lang.String r1 = La.D.F(r3, r4, r5, r6, r7, r8)
            java.lang.String r3 = r9.$pingMessage
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            if (r1 == 0) goto L83
            vc.c r9 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "WebSocket Pinger: received valid pong frame "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.trace(r10)
            Y8.t r9 = Y8.t.f7040a
            return r9
        L83:
            vc.c r1 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "WebSocket Pinger: received invalid pong frame "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r10 = ", continue waiting"
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            r1.trace(r10)
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1$rc$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
