package io.ktor.websocket;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", l = {62, 64, 65, 84, 84, 84, 84}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, InterfaceC4014c<? super RawWebSocketCommon$writerJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((RawWebSocketCommon$writerJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ab, code lost:
    
        if (r9.flushAndClose(r8) == r0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fa, code lost:
    
        if (r9.flushAndClose(r8) != r0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012a, code lost:
    
        if (r9.flushAndClose(r8) != r0) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[Catch: all -> 0x0029, ChannelWriteException -> 0x002c, TRY_ENTER, TryCatch #3 {ChannelWriteException -> 0x002c, all -> 0x0029, blocks: (B:9:0x0025, B:32:0x0082, B:20:0x003c, B:23:0x004e, B:25:0x0052, B:29:0x006f, B:38:0x00af, B:40:0x00b3, B:41:0x00be, B:42:0x00d4, B:34:0x0086, B:16:0x0031, B:17:0x0035), top: B:68:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e A[Catch: all -> 0x0029, ChannelWriteException -> 0x002c, PHI: r9
      0x004e: PHI (r9v24 java.lang.Object) = (r9v0 java.lang.Object), (r9v30 java.lang.Object) binds: [B:17:0x0035, B:21:0x004a] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {ChannelWriteException -> 0x002c, all -> 0x0029, blocks: (B:9:0x0025, B:32:0x0082, B:20:0x003c, B:23:0x004e, B:25:0x0052, B:29:0x006f, B:38:0x00af, B:40:0x00b3, B:41:0x00be, B:42:0x00d4, B:34:0x0086, B:16:0x0031, B:17:0x0035), top: B:68:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052 A[Catch: all -> 0x0029, ChannelWriteException -> 0x002c, TryCatch #3 {ChannelWriteException -> 0x002c, all -> 0x0029, blocks: (B:9:0x0025, B:32:0x0082, B:20:0x003c, B:23:0x004e, B:25:0x0052, B:29:0x006f, B:38:0x00af, B:40:0x00b3, B:41:0x00be, B:42:0x00d4, B:34:0x0086, B:16:0x0031, B:17:0x0035), top: B:68:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[Catch: all -> 0x0029, ChannelWriteException -> 0x002c, PHI: r1
      0x0082: PHI (r1v22 java.lang.Object) = (r1v14 java.lang.Object), (r1v25 java.lang.Object) binds: [B:30:0x007e, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {ChannelWriteException -> 0x002c, all -> 0x0029, blocks: (B:9:0x0025, B:32:0x0082, B:20:0x003c, B:23:0x004e, B:25:0x0052, B:29:0x006f, B:38:0x00af, B:40:0x00b3, B:41:0x00be, B:42:0x00d4, B:34:0x0086, B:16:0x0031, B:17:0x0035), top: B:68:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[Catch: all -> 0x0029, ChannelWriteException -> 0x002c, TRY_LEAVE, TryCatch #3 {ChannelWriteException -> 0x002c, all -> 0x0029, blocks: (B:9:0x0025, B:32:0x0082, B:20:0x003c, B:23:0x004e, B:25:0x0052, B:29:0x006f, B:38:0x00af, B:40:0x00b3, B:41:0x00be, B:42:0x00d4, B:34:0x0086, B:16:0x0031, B:17:0x0035), top: B:68:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0029, ChannelWriteException -> 0x002c, TRY_ENTER, TryCatch #3 {ChannelWriteException -> 0x002c, all -> 0x0029, blocks: (B:9:0x0025, B:32:0x0082, B:20:0x003c, B:23:0x004e, B:25:0x0052, B:29:0x006f, B:38:0x00af, B:40:0x00b3, B:41:0x00be, B:42:0x00d4, B:34:0x0086, B:16:0x0031, B:17:0x0035), top: B:68:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0140  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007e -> B:32:0x0082). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b3 -> B:20:0x003c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x012d -> B:53:0x012d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
