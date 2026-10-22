package io.ktor.server.cio.backend;

import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.cio.Request;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.ServerSocket;
import io.ktor.network.sockets.Socket;
import io.ktor.server.cio.UnixSocketServerSettings;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.cio.backend.UnixSocketServerKt$unixSocketServer$acceptJob$1", f = "UnixSocketServer.kt", l = {52, 70, 98, 98}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class UnixSocketServerKt$unixSocketServer$acceptJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ q<ServerRequestScope, Request, InterfaceC4014c<? super t>, Object> $handler;
    final /* synthetic */ SelectorManager $selector;
    final /* synthetic */ kotlinx.coroutines.g $serverJob;
    final /* synthetic */ UnixSocketServerSettings $settings;
    final /* synthetic */ InterfaceC1083u<ServerSocket> $socket;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnixSocketServerKt$unixSocketServer$acceptJob$1(UnixSocketServerSettings unixSocketServerSettings, SelectorManager selectorManager, InterfaceC1083u<ServerSocket> interfaceC1083u, kotlinx.coroutines.g gVar, long j10, q<? super ServerRequestScope, ? super Request, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super UnixSocketServerKt$unixSocketServer$acceptJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$settings = unixSocketServerSettings;
        this.$selector = selectorManager;
        this.$socket = interfaceC1083u;
        this.$serverJob = gVar;
        this.$timeout = j10;
        this.$handler = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t invokeSuspend$lambda$1$lambda$0(Socket socket, Throwable th) throws IOException {
        socket.close();
        return t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UnixSocketServerKt$unixSocketServer$acceptJob$1 unixSocketServerKt$unixSocketServer$acceptJob$1 = new UnixSocketServerKt$unixSocketServer$acceptJob$1(this.$settings, this.$selector, this.$socket, this.$serverJob, this.$timeout, this.$handler, interfaceC4014c);
        unixSocketServerKt$unixSocketServer$acceptJob$1.L$0 = obj;
        return unixSocketServerKt$unixSocketServer$acceptJob$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UnixSocketServerKt$unixSocketServer$acceptJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
    
        if (r0 == r6) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a6, code lost:
    
        if (io.ktor.network.sockets.SocketsKt.awaitClosed(r5, r17) == r6) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119 A[Catch: all -> 0x0065, IOException -> 0x006a, PHI: r0 r1 r4 r5 r7 r11 r13 r14 r15
      0x0119: PHI (r0v25 java.lang.Object) = (r0v24 java.lang.Object), (r0v45 java.lang.Object) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r1v13 long) = (r1v11 long), (r1v21 long) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r4v8 Ua.M) = (r4v6 Ua.M), (r4v10 Ua.M) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r5v7 io.ktor.network.sockets.ServerSocket) = (r5v10 io.ktor.network.sockets.ServerSocket), (r5v11 io.ktor.network.sockets.ServerSocket) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r7v4 boolean) = (r7v2 boolean), (r7v0 boolean) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r11v3 int) = (r11v1 int), (r11v0 int) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r13v7 p9.q<io.ktor.server.cio.backend.ServerRequestScope, io.ktor.http.cio.Request, e9.c<? super Y8.t>, java.lang.Object>) = 
      (r13v5 p9.q<io.ktor.server.cio.backend.ServerRequestScope, io.ktor.http.cio.Request, e9.c<? super Y8.t>, java.lang.Object>)
      (r13v10 p9.q<io.ktor.server.cio.backend.ServerRequestScope, io.ktor.http.cio.Request, e9.c<? super Y8.t>, java.lang.Object>)
     binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r14v6 java.io.Closeable) = (r14v4 java.io.Closeable), (r14v8 java.io.Closeable) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0119: PHI (r15v8 Ua.M) = (r15v6 Ua.M), (r15v10 Ua.M) binds: [B:39:0x0115, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {IOException -> 0x006a, blocks: (B:19:0x005e, B:41:0x0119, B:38:0x0103), top: B:69:0x005e }] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v5, types: [io.ktor.network.sockets.Acceptable, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0115 -> B:41:0x0119). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.backend.UnixSocketServerKt$unixSocketServer$acceptJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
