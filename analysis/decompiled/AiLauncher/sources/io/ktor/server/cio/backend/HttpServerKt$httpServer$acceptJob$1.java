package io.ktor.server.cio.backend;

import Ua.InterfaceC1083u;
import Ua.InterfaceC1089x;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.cio.Request;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.ServerSocket;
import io.ktor.network.sockets.Socket;
import io.ktor.network.sockets.SocketOptions;
import io.ktor.server.cio.HttpServerSettings;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.cio.backend.HttpServerKt$httpServer$acceptJob$1", f = "HttpServer.kt", l = {46, 66, 95, 96, 95, 96}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpServerKt$httpServer$acceptJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ q<ServerRequestScope, Request, InterfaceC4014c<? super t>, Object> $handler;
    final /* synthetic */ InterfaceC1089x $rootConnectionJob;
    final /* synthetic */ SelectorManager $selector;
    final /* synthetic */ HttpServerSettings $settings;
    final /* synthetic */ InterfaceC1083u<ServerSocket> $socket;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpServerKt$httpServer$acceptJob$1(SelectorManager selectorManager, HttpServerSettings httpServerSettings, InterfaceC1083u<ServerSocket> interfaceC1083u, InterfaceC1089x interfaceC1089x, long j10, q<? super ServerRequestScope, ? super Request, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super HttpServerKt$httpServer$acceptJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$selector = selectorManager;
        this.$settings = httpServerSettings;
        this.$socket = interfaceC1083u;
        this.$rootConnectionJob = interfaceC1089x;
        this.$timeout = j10;
        this.$handler = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t invokeSuspend$lambda$0(HttpServerSettings httpServerSettings, SocketOptions.AcceptorOptions acceptorOptions) {
        acceptorOptions.setReuseAddress(httpServerSettings.getReuseAddress());
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t invokeSuspend$lambda$2$lambda$1(Socket socket, Throwable th) throws IOException {
        socket.close();
        return t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        HttpServerKt$httpServer$acceptJob$1 httpServerKt$httpServer$acceptJob$1 = new HttpServerKt$httpServer$acceptJob$1(this.$selector, this.$settings, this.$socket, this.$rootConnectionJob, this.$timeout, this.$handler, interfaceC4014c);
        httpServerKt$httpServer$acceptJob$1.L$0 = obj;
        return httpServerKt$httpServer$acceptJob$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((HttpServerKt$httpServer$acceptJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:
    
        if (r5 == r2) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120 A[Catch: all -> 0x007d, IOException -> 0x0081, PHI: r0 r3 r4 r5 r7 r8 r9 r10 r11 r12
      0x0120: PHI (r0v15 java.lang.Object) = (r0v14 java.lang.Object), (r0v28 java.lang.Object) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r3v5 int) = (r3v3 int), (r3v0 int) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r4v7 java.lang.Object) = (r4v5 java.lang.Object), (r4v0 java.lang.Object) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r5v16 long) = (r5v14 long), (r5v17 long) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r7v7 Ua.M) = (r7v5 Ua.M), (r7v9 Ua.M) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r8v7 io.ktor.network.sockets.ServerSocket) = (r8v10 io.ktor.network.sockets.ServerSocket), (r8v11 io.ktor.network.sockets.ServerSocket) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r9v5 p9.q<io.ktor.server.cio.backend.ServerRequestScope, io.ktor.http.cio.Request, e9.c<? super Y8.t>, java.lang.Object>) = 
      (r9v3 p9.q<io.ktor.server.cio.backend.ServerRequestScope, io.ktor.http.cio.Request, e9.c<? super Y8.t>, java.lang.Object>)
      (r9v7 p9.q<io.ktor.server.cio.backend.ServerRequestScope, io.ktor.http.cio.Request, e9.c<? super Y8.t>, java.lang.Object>)
     binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r10v6 Ua.x) = (r10v4 Ua.x), (r10v8 Ua.x) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r11v11 java.io.Closeable) = (r11v9 java.io.Closeable), (r11v13 java.io.Closeable) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x0120: PHI (r12v5 Ua.M) = (r12v3 Ua.M), (r12v7 Ua.M) binds: [B:43:0x011c, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {all -> 0x007d, blocks: (B:26:0x0076, B:45:0x0120, B:46:0x0122, B:42:0x0107, B:52:0x015b, B:50:0x0151), top: B:82:0x0076, outer: #2 }] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [io.ktor.network.sockets.Acceptable, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x011c -> B:45:0x0120). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.backend.HttpServerKt$httpServer$acceptJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
