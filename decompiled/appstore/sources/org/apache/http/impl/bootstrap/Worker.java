package org.apache.http.impl.bootstrap;

import java.io.IOException;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpServerConnection;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpService;

/* JADX INFO: loaded from: classes4.dex */
class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    public Worker(HttpService r10, HttpServerConnection r11, ExceptionLogger r12) {
        this.httpservice = r10;
        this.conn = r11;
        this.exceptionLogger = r12;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    @Override // java.lang.Runnable
    public void run() {
        BasicHttpContext r10 = new BasicHttpContext();     // Catch: Throwable -> L8 Exception -> L10
        HttpCoreContext r11 = HttpCoreContext.adapt(r10);     // Catch: Throwable -> L8 Exception -> L10
    L4:
        if (Thread.interrupted() == true) goto L12;
        if (this.conn.isOpen() == false) goto L12;
        this.httpservice.handleRequest(this.conn, r11);     // Catch: Throwable -> L8 Exception -> L10
        r10.clear();     // Catch: Throwable -> L8 Exception -> L10
    L12:
        this.conn.close();     // Catch: Throwable -> L8 Exception -> L10
        this.conn.shutdown();     // Catch: IOException -> L15
    L28:
        return;
    L8:
        th = move-exception;
        this.conn.shutdown();     // Catch: IOException -> L22
    L24:
        throw th;
    L22:
        e = move-exception;
        this.exceptionLogger.log(e);
    L10:
        e = move-exception;
        this.exceptionLogger.log(e);     // Catch: Throwable -> L8
        this.conn.shutdown();     // Catch: IOException -> L15
    L15:
        e = move-exception;
        this.exceptionLogger.log(e);
    }
}
