package io.modelcontextprotocol.kotlin.sdk.client;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3$writeJob$1", f = "StdioClientTransport.kt", l = {143}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class StdioClientTransport$start$3$writeJob$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ fb.s $outputStream;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ StdioClientTransport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StdioClientTransport$start$3$writeJob$1(StdioClientTransport stdioClientTransport, fb.s sVar, InterfaceC4014c<? super StdioClientTransport$start$3$writeJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = stdioClientTransport;
        this.$outputStream = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invokeSuspend$lambda$0() {
        return "Write coroutine started.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invokeSuspend$lambda$2() {
        return "Error writing to output stream";
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        StdioClientTransport$start$3$writeJob$1 stdioClientTransport$start$3$writeJob$1 = new StdioClientTransport$start$3$writeJob$1(this.this$0, this.$outputStream, interfaceC4014c);
        stdioClientTransport$start$3$writeJob$1.L$0 = obj;
        return stdioClientTransport$start$3$writeJob$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((StdioClientTransport$start$3$writeJob$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:6:0x002c, B:19:0x0086, B:21:0x008e, B:16:0x0063, B:22:0x00a7, B:15:0x0058), top: B:42:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:6:0x002c, B:19:0x0086, B:21:0x008e, B:16:0x0063, B:22:0x00a7, B:15:0x0058), top: B:42:0x000e, outer: #1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0083 -> B:8:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3$writeJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
