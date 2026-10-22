package io.ktor.server.cio;

import Ua.Q;
import io.ktor.network.sockets.ServerSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/server/cio/HttpServer;", "", "Lkotlinx/coroutines/g;", "rootServerJob", "acceptJob", "LUa/Q;", "Lio/ktor/network/sockets/ServerSocket;", "serverSocket", "<init>", "(Lkotlinx/coroutines/g;Lkotlinx/coroutines/g;LUa/Q;)V", "Lkotlinx/coroutines/g;", "getRootServerJob", "()Lkotlinx/coroutines/g;", "getAcceptJob", "LUa/Q;", "getServerSocket", "()LUa/Q;", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpServer {
    private final g acceptJob;
    private final g rootServerJob;
    private final Q<ServerSocket> serverSocket;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpServer(g rootServerJob, g acceptJob, Q<? extends ServerSocket> serverSocket) {
        p.i(rootServerJob, "rootServerJob");
        p.i(acceptJob, "acceptJob");
        p.i(serverSocket, "serverSocket");
        this.rootServerJob = rootServerJob;
        this.acceptJob = acceptJob;
        this.serverSocket = serverSocket;
    }

    public final g getAcceptJob() {
        return this.acceptJob;
    }

    public final g getRootServerJob() {
        return this.rootServerJob;
    }

    public final Q<ServerSocket> getServerSocket() {
        return this.serverSocket;
    }
}
