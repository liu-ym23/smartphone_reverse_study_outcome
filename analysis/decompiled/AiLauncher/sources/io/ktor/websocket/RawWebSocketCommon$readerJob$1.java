package io.ktor.websocket;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.websocket.RawWebSocketCommon$readerJob$1", f = "RawWebSocketCommon.kt", l = {98, 102, 105, 109}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class RawWebSocketCommon$readerJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$readerJob$1(RawWebSocketCommon rawWebSocketCommon, InterfaceC4014c<? super RawWebSocketCommon$readerJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RawWebSocketCommon$readerJob$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((RawWebSocketCommon$readerJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a A[Catch: all -> 0x003a, CancellationException -> 0x003c, ProtocolViolationException -> 0x003f, FrameTooBigException -> 0x0042, EOFException | ClosedReceiveChannelException -> 0x00aa, EOFException | ClosedReceiveChannelException -> 0x00aa, PHI: r10
      0x006a: PHI (r10v10 java.lang.Object) = (r10v15 java.lang.Object), (r10v0 java.lang.Object) binds: [B:32:0x0066, B:28:0x0045] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {EOFException | ClosedReceiveChannelException -> 0x00aa, blocks: (B:19:0x0036, B:31:0x004c, B:31:0x004c, B:34:0x006a, B:34:0x006a, B:36:0x0076, B:36:0x0076, B:40:0x0088, B:40:0x0088, B:39:0x0080, B:39:0x0080, B:41:0x008b, B:41:0x008b, B:28:0x0045), top: B:64:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[Catch: all -> 0x003a, CancellationException -> 0x003c, ProtocolViolationException -> 0x003f, FrameTooBigException -> 0x0042, EOFException | ClosedReceiveChannelException -> 0x00aa, EOFException | ClosedReceiveChannelException -> 0x00aa, TryCatch #3 {EOFException | ClosedReceiveChannelException -> 0x00aa, blocks: (B:19:0x0036, B:31:0x004c, B:31:0x004c, B:34:0x006a, B:34:0x006a, B:36:0x0076, B:36:0x0076, B:40:0x0088, B:40:0x0088, B:39:0x0080, B:39:0x0080, B:41:0x008b, B:41:0x008b, B:28:0x0045), top: B:64:0x000b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009d -> B:31:0x004c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$readerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
