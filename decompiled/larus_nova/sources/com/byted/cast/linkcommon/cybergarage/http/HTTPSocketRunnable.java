package com.byted.cast.linkcommon.cybergarage.http;

import com.byted.cast.common.ContextManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.Socket;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPSocketRunnable implements Runnable {
    private HTTPServer httpServer;
    private ContextManager.CastContext mCastContext;
    private Socket sock;

    @Override // java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_http_HTTPSocketRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_byted_cast_linkcommon_cybergarage_http_HTTPSocketRunnable__run$___twin___() {
        HTTPSocket r100 = new HTTPSocket(this.sock);
        if (r100.open() == true) goto L5;
        return;
    L5:
        HTTPRequest r101 = new HTTPRequest(this.mCastContext);
        r101.setSocket(r100);
    L7:
        if (r101.read() != true) goto L10;
        this.httpServer.performRequestListener(r101);
        if (r101.isKeepAlive() == true) goto L7;
    L10:
        r100.close();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_http_HTTPSocketRunnable_com_larus_apm_impl_protector_RunnableLancet_run(HTTPSocketRunnable r100) {
        r100.com_byted_cast_linkcommon_cybergarage_http_HTTPSocketRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public HTTPSocketRunnable(ContextManager.CastContext r100, HTTPServer r101, Socket r102) {
        this.httpServer = r101;
        this.sock = r102;
        this.mCastContext = r100;
    }
}
