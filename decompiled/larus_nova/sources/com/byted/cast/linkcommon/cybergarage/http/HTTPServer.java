package com.byted.cast.linkcommon.cybergarage.http;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.linkcommon.cybergarage.util.ListenerList;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPServer implements Runnable {
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_TIMEOUT = 20000;
    public static final String NAME = "CyberHTTP";
    private static final String TAG = "HTTPServer";
    public static final String VERSION = "1.0";
    private InetAddress bindAddr;
    private int bindPort;
    private ListenerList httpRequestListenerList;
    private Thread httpServerThread;
    private HTTPServerType httpServerType;
    private final ContextManager.CastContext mCastContext;
    private final CastLogger mLogger;
    private final CastMonitor mMonitor;
    private ServerSocket serverSock;
    protected int timeout;

    /* JADX INFO: renamed from: com.byted.cast.linkcommon.cybergarage.http.HTTPServer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$linkcommon$cybergarage$http$HTTPServerType = null;

        static {
            int[] r100 = new int[HTTPServerType.values().length];
            $SwitchMap$com$byted$cast$linkcommon$cybergarage$http$HTTPServerType = r100;
            r100[HTTPServerType.DLNA_SINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$byted$cast$linkcommon$cybergarage$http$HTTPServerType[HTTPServerType.DLNA_SOURCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$byted$cast$linkcommon$cybergarage$http$HTTPServerType[HTTPServerType.BDLINK_SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$byted$cast$linkcommon$cybergarage$http$HTTPServerType[HTTPServerType.BDLINK_SINK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public synchronized int getTimeout() {
        monitor-enter(this);
        int r100 = this.timeout;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_http_HTTPServer_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public boolean stop() {
        this.httpServerThread = null;
        return true;
    }

    public static String getName() {
        return System.getProperty("os.name") + HTTP.URL_DEFAULT + System.getProperty("os.version") + " CyberHTTP/1.0";
    }

    public Socket accept() throws Exception {
        ServerSocket r100 = this.serverSock;
        if (r100 != null) goto L6;
        return null;
    L6:
        Socket r101 = r100.accept();
        r101.setSoTimeout(getTimeout());
        return r101;
    }

    public boolean close() {
        ServerSocket r100 = this.serverSock;
        if (r100 != null) goto L11;
        return true;
    L11:
        r100.close();     // Catch: Exception -> L8
        this.serverSock = null;     // Catch: Exception -> L8
        this.bindAddr = null;     // Catch: Exception -> L8
        this.bindPort = 0;     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        this.mLogger.e(e.getMessage());
        return false;
    }

    public String getBindAddress() {
        InetAddress r100 = this.bindAddr;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.toString();
    }

    public boolean isOpened() {
        if (this.serverSock == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean start() {
        ServerSocket r100 = this.serverSock;
        String r101 = Constants.DLNA_SEARCH_TAG;
        if (r100 != null) goto L10;
        CastLogger r102 = this.mLogger;
        if (HTTPServerType.DLNA_SOURCE == this.httpServerType) goto L8;
        r101 = "";
    L8:
        r102.d(TAG, r101.concat(" start server failure serverSock null"));
        trackStartServerInfoEvent(this.httpServerType + " start server failure serverSock null");
        return false;
    L10:
        StringBuilder r103 = new StringBuilder(this.httpServerType + ".HTTPServer/");
        r103.append(this.serverSock.getLocalSocketAddress());
        CastLogger r104 = this.mLogger;
        StringBuilder r105 = new StringBuilder();
        if (HTTPServerType.DLNA_SOURCE == this.httpServerType) goto L14;
        r101 = "";
    L14:
        r105.append(r101);
        r105.append(" start HTTPServer name:");
        r105.append(r103);
        r104.d(TAG, r105.toString());
        PthreadThreadV2 r106 = new PthreadThreadV2(this, r103.toString());
        this.httpServerThread = r106;
        ThreadMethodProxy.start(r106);
        return true;
    }

    public void com_byted_cast_linkcommon_cybergarage_http_HTTPServer__run$___twin___() {
        if (isOpened() == true) goto L5;
        return;
    L5:
        this.mLogger.d(TAG, "start run");
        Thread r100 = ThreadMethodProxy.currentThread();
    L7:
        if (this.httpServerThread != r100) goto L14;
        Thread.yield();
        Socket r101 = accept();     // Catch: Exception -> L12
        if (r101 == null) goto L7;
        Dispatcher.getInstance().enqueue(new HTTPSocketRunnable(this.mCastContext, this, r101));
    L12:
        e = move-exception;
        trackStartServerInfoEvent(this.httpServerType + "Http server run exception:" + e.getMessage());
    L14:
        this.mLogger.d(TAG, "finish run");
    }

    public InetAddress getBindInetAddress() {
        return this.bindAddr;
    }

    public int getBindPort() {
        return this.bindPort;
    }

    public ServerSocket getServerSock() {
        return this.serverSock;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_http_HTTPServer_com_larus_apm_impl_protector_RunnableLancet_run(HTTPServer r100) {
        r100.com_byted_cast_linkcommon_cybergarage_http_HTTPServer__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private void trackStartServerInfoEvent(String r100) {
        this.mLogger.w(TAG, r100);
        int r101 = AnonymousClass1.$SwitchMap$com$byted$cast$linkcommon$cybergarage$http$HTTPServerType[this.httpServerType.ordinal()];
        if (r101 != 1) goto L5;
        this.mMonitor.sendSinkEvent(CastMonitor.BDDLNA_START_SERVER_INFO, r100);
        return;
    L5:
        if (r101 != 2) goto L7;
        this.mMonitor.sendSourceEvent(CastMonitor.BDDLNA_START_SERVER_INFO, r100);
        return;
    L7:
        if (r101 != 3) goto L9;
        this.mMonitor.sendSourceEvent(CastMonitor.BDLINK_START_SERVER_INFO, r100);
        return;
    L9:
        if (r101 != 4) goto L19;
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, r100);
        return;
    }

    public void addRequestListener(HTTPRequestListener r100) {
        this.httpRequestListenerList.add(r100);
    }

    public void performRequestListener(HTTPRequest r100) {
        int r101 = this.httpRequestListenerList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((HTTPRequestListener) this.httpRequestListenerList.get(r102)).httpRequestRecieved(r100);
        r102 = r102 + 1;
        goto L3
    }

    public void removeRequestListener(HTTPRequestListener r100) {
        this.httpRequestListenerList.remove(r100);
    }

    public synchronized void setTimeout(int r100) {
        monitor-enter(this);
        this.timeout = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public HTTPServer(ContextManager.CastContext r100, HTTPServerType r101) {
        this.serverSock = null;
        this.bindAddr = null;
        this.bindPort = 0;
        this.timeout = 20000;
        this.httpRequestListenerList = new ListenerList();
        this.httpServerThread = null;
        this.serverSock = null;
        this.httpServerType = r101;
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(r100);
    }

    public boolean open(String r100, int r101) {
        if (this.serverSock == null) goto L15;
        return true;
    L15:
        this.bindAddr = InetAddress.getByName(r100);     // Catch: IOException -> L10
        this.bindPort = r101;     // Catch: IOException -> L10
        ServerSocket r102 = new ServerSocket();     // Catch: IOException -> L10
        this.serverSock = r102;     // Catch: IOException -> L10
        r102.setReuseAddress(true);     // Catch: IOException -> L10
        this.serverSock.bind(new InetSocketAddress(this.bindAddr, this.bindPort), 0);     // Catch: IOException -> L10
        if (this.serverSock.getLocalPort() == this.bindPort) goto L9;
        this.bindPort = this.serverSock.getLocalPort();     // Catch: IOException -> L10
    L9:
        return true;
    L10:
        e = move-exception;
        this.mLogger.w(TAG, "start server socket failure, addr:" + r100 + ", bindAddr:" + this.bindAddr + ", port:" + this.bindPort + ", error:" + e.getMessage() + ", thread:" + ThreadMethodProxy.currentThread());
        close();
        if (this.httpServerType != HTTPServerType.BDLINK_SINK) goto L14;
        ContextManager.getMonitor(this.mCastContext).sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink HTTPServer open failure addr:" + r100 + ",port:" + r101 + ", error: " + e.getMessage());
    L14:
        return false;
    }

    public HashMap<String, String> openServer(String r100, int r110) {
        HashMap<String, String> r101 = new HashMap();
        if (this.serverSock == null) goto L14;
        r101.put("result", "true");
        r101.put("err_exception", "");
        return r101;
    L14:
        this.bindAddr = InetAddress.getByName(r100);     // Catch: IOException -> L11
        this.bindPort = r110;     // Catch: IOException -> L11
        ServerSocket r111 = new ServerSocket();     // Catch: IOException -> L11
        this.serverSock = r111;     // Catch: IOException -> L11
        r111.setReuseAddress(true);     // Catch: IOException -> L11
        this.serverSock.bind(new InetSocketAddress(this.bindAddr, this.bindPort), 0);     // Catch: IOException -> L11
        if (this.serverSock.getLocalPort() == this.bindPort) goto L9;
        this.bindPort = this.serverSock.getLocalPort();     // Catch: IOException -> L11
    L9:
        r101.put("result", "true");
        r101.put("err_exception", "");
        return r101;
    L11:
        e = move-exception;
        this.mLogger.w(TAG, "start server socket failure, addr:" + r100 + ", bindAddr:" + this.bindAddr + ", port:" + this.bindPort + ", error:" + e.getMessage() + ", thread:" + ThreadMethodProxy.currentThread());
        close();
        r101.put("result", "false");
        r101.put("err_exception", e.getMessage());
        return r101;
    }

    public boolean open(InetAddress r100, int r101) {
        if (this.serverSock == null) goto L15;
        return true;
    L15:
        this.bindAddr = r100;     // Catch: IOException -> L10
        this.bindPort = r101;     // Catch: IOException -> L10
        ServerSocket r102 = new ServerSocket();     // Catch: IOException -> L10
        this.serverSock = r102;     // Catch: IOException -> L10
        r102.setReuseAddress(true);     // Catch: IOException -> L10
        this.serverSock.bind(new InetSocketAddress(this.bindAddr, this.bindPort), 0);     // Catch: IOException -> L10
        if (this.serverSock.getLocalPort() == this.bindPort) goto L9;
        this.bindPort = this.serverSock.getLocalPort();     // Catch: IOException -> L10
    L9:
        return true;
    L10:
        e = move-exception;
        this.mLogger.w(TAG, "start server socket failure, addr:" + r100 + ", bindAddr:" + this.bindAddr + ", port:" + this.bindPort + ", error:" + e.getMessage() + ", thread:" + ThreadMethodProxy.currentThread());
        close();
        if (this.httpServerType != HTTPServerType.BDLINK_SINK) goto L14;
        CastMonitor.getInstance().sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink HTTPServer open failure addr:" + r100 + ",port:" + r101 + ", error: " + e.getMessage());
    L14:
        return false;
    }
}
