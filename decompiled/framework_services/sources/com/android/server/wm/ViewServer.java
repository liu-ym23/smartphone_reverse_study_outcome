package com.android.server.wm;

import android.os.IBinder;
import android.util.Slog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
class ViewServer implements Runnable {
    private static final String COMMAND_PROTOCOL_VERSION = "PROTOCOL";
    private static final String COMMAND_SERVER_VERSION = "SERVER";
    private static final String COMMAND_WINDOW_MANAGER_AUTOLIST = "AUTOLIST";
    private static final String COMMAND_WINDOW_MANAGER_GET_FOCUS = "GET_FOCUS";
    private static final String COMMAND_WINDOW_MANAGER_LIST = "LIST";
    private static final String LOG_TAG = "WindowManager";
    private static final String VALUE_PROTOCOL_VERSION = "4";
    private static final String VALUE_SERVER_VERSION = "4";
    public static final int VIEW_SERVER_DEFAULT_PORT = 4939;
    private static final int VIEW_SERVER_MAX_CONNECTIONS = 10;
    private final int mPort;
    private ServerSocket mServer;
    private Thread mThread;
    private ExecutorService mThreadPool;
    private final WindowManagerService mWindowManager;

    class ViewServerWorker implements Runnable, WindowManagerService.WindowChangeListener, WindowManagerInternal.WindowFocusChangeListener {
        private Socket mClient;
        private boolean mNeedFocusedWindowUpdate;
        private boolean mNeedWindowListUpdate;
        final /* synthetic */ ViewServer this$0;

        public ViewServerWorker(ViewServer this$0, Socket client) {
            this.this$0 = this$0;
            this.mClient = client;
            this.mNeedWindowListUpdate = false;
            this.mNeedFocusedWindowUpdate = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(this.mClient.getInputStream()), 1024);     // Catch: Throwable -> L6 IOException -> L8
            String request = in.readLine();     // Catch: Throwable -> L6 IOException -> L8
            int index = request.indexOf(32);     // Catch: Throwable -> L6 IOException -> L8
            if (index != (-1)) goto L10;
            String command = request;
            String parameters = "";
        L13:
            if (ViewServer.COMMAND_PROTOCOL_VERSION.equalsIgnoreCase(command) == false) goto L16;
            boolean result = ViewServer.m10369$$Nest$smwriteValue(this.mClient, "4");     // Catch: Throwable -> L6 IOException -> L8
        L28:
            if (result == true) goto L71;
            Slog.w(ViewServer.LOG_TAG, "An error occurred with the command: " + command);     // Catch: Throwable -> L6 IOException -> L8
        L71:
            in.close();     // Catch: IOException -> L33
        L36:
            if (this.mClient == null) goto L52;
            this.mClient.close();     // Catch: IOException -> L39
            return;
        L52:
            return;
        L33:
            e = move-exception;
            e.printStackTrace();
            goto L36
        L16:
            if (ViewServer.COMMAND_SERVER_VERSION.equalsIgnoreCase(command) == false) goto L19;
            result = ViewServer.m10369$$Nest$smwriteValue(this.mClient, "4");     // Catch: Throwable -> L6 IOException -> L8
            goto L28
        L19:
            if (ViewServer.COMMAND_WINDOW_MANAGER_LIST.equalsIgnoreCase(command) == false) goto L22;
            result = ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).viewServerListWindows(this.mClient);     // Catch: Throwable -> L6 IOException -> L8
            goto L28
        L22:
            if (ViewServer.COMMAND_WINDOW_MANAGER_GET_FOCUS.equalsIgnoreCase(command) == false) goto L25;
            result = ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).viewServerGetFocusedWindow(this.mClient);     // Catch: Throwable -> L6 IOException -> L8
            goto L28
        L25:
            if (ViewServer.COMMAND_WINDOW_MANAGER_AUTOLIST.equalsIgnoreCase(command) == false) goto L27;
            result = windowManagerAutolistLoop();     // Catch: Throwable -> L6 IOException -> L8
            goto L28
        L27:
            result = ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).viewServerWindowCommand(this.mClient, command, parameters);     // Catch: Throwable -> L6 IOException -> L8
            goto L28
        L10:
            command = request.substring(0, index);     // Catch: Throwable -> L6 IOException -> L8
            parameters = request.substring(index + 1);     // Catch: Throwable -> L6 IOException -> L8
        L8:
            e = move-exception;
            Slog.w(ViewServer.LOG_TAG, "Connection error: ", e);     // Catch: Throwable -> L6
            if (in == null) goto L49;
            in.close();     // Catch: IOException -> L46
        L46:
            e = move-exception;
            e.printStackTrace();
        L49:
            if (this.mClient == null) goto L76;
            this.mClient.close();     // Catch: IOException -> L39
            return;
        L76:
            return;
        L39:
            e = move-exception;
            e.printStackTrace();
            return;
        L6:
            th = move-exception;
            if (in == null) goto L59;
            in.close();     // Catch: IOException -> L56
        L56:
            e = move-exception;
            e.printStackTrace();
        L59:
            if (this.mClient == null) goto L80;
            this.mClient.close();     // Catch: IOException -> L62
            throw th;
        L62:
            e = move-exception;
            e.printStackTrace();
            throw th;
        L80:
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerService.WindowChangeListener
        public void windowsChanged() {
            monitor-enter(this);
            this.mNeedWindowListUpdate = true;     // Catch: Throwable -> L7
            notifyAll();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal.WindowFocusChangeListener
        public void focusChanged(IBinder focusedWindowToken) {
            monitor-enter(this);
            this.mNeedFocusedWindowUpdate = true;     // Catch: Throwable -> L7
            notifyAll();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean windowManagerAutolistLoop() {
            ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).addWindowChangeListener(this);
            ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).addWindowFocusChangeListener(this);
            BufferedWriter out = null;
            out = new BufferedWriter(new OutputStreamWriter(this.mClient.getOutputStream()));     // Catch: Throwable -> L24 Exception -> L26
        L5:
            if (Thread.interrupted() == true) goto L58;
            boolean needWindowListUpdate = false;
            boolean needFocusedWindowUpdate = false;
            monitor-enter(this);     // Catch: Throwable -> L24 Exception -> L26
        L56:
            if (this.mNeedWindowListUpdate == true) goto L16;
            if (this.mNeedFocusedWindowUpdate == true) goto L16;
            wait();     // Catch: Throwable -> L13
        L16:
            if (this.mNeedWindowListUpdate == false) goto L19;
            this.mNeedWindowListUpdate = false;     // Catch: Throwable -> L13
            needWindowListUpdate = true;
        L19:
            if (this.mNeedFocusedWindowUpdate == false) goto L21;
            this.mNeedFocusedWindowUpdate = false;     // Catch: Throwable -> L13
            needFocusedWindowUpdate = true;
        L21:
            monitor-exit(this);     // Catch: Throwable -> L13
            if (needWindowListUpdate == false) goto L28;
            out.write("LIST UPDATE\n");     // Catch: Throwable -> L24 Exception -> L26
            out.flush();     // Catch: Throwable -> L24 Exception -> L26
        L28:
            if (needFocusedWindowUpdate == false) goto L5;
            out.write("ACTION_FOCUS UPDATE\n");     // Catch: Throwable -> L24 Exception -> L26
            out.flush();     // Catch: Throwable -> L24 Exception -> L26
            goto L5
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24 Exception -> L26
            goto L45
        L58:
            out.close();     // Catch: IOException -> L36
        L37:
            ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).removeWindowChangeListener(this);
            ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).removeWindowFocusChangeListener(this);
            return true;
        L24:
            th = move-exception;
            if (out != null) goto L52;
        L42:
            ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).removeWindowChangeListener(this);
            ViewServer.m10368$$Nest$fgetmWindowManager(this.this$0).removeWindowFocusChangeListener(this);
            throw th;
        L52:
            out.close();     // Catch: IOException -> L41
        L45:
            if (out == null) goto L37;
            out.close();     // Catch: IOException -> L48
            goto L37
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m10368$$Nest$fgetmWindowManager(ViewServer r0) {
        return r0.mWindowManager;
    }

    /* JADX INFO: renamed from: -$$Nest$smwriteValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10369$$Nest$smwriteValue(Socket r0, String r1) {
        return writeValue(r0, r1);
    }

    ViewServer(WindowManagerService windowManager, int port) {
        this.mWindowManager = windowManager;
        this.mPort = port;
    }

    boolean start() throws IOException {
        if (this.mThread == null) goto L6;
        return false;
    L6:
        this.mServer = new ServerSocket(this.mPort, 10, InetAddress.getLocalHost());
        this.mThread = new Thread(this, "Remote View Server [port=" + this.mPort + "]");
        this.mThreadPool = Executors.newFixedThreadPool(10);
        this.mThread.start();
        return true;
    }

    boolean stop() {
        if (this.mThread == null) goto L22;
        this.mThread.interrupt();
        if (this.mThreadPool != null) goto L20;
    L10:
        this.mThreadPool = null;
        this.mThread = null;
        this.mServer.close();     // Catch: IOException -> L14
        this.mServer = null;     // Catch: IOException -> L14
        return true;
    L15:
        Slog.w(LOG_TAG, "Could not close the view server");
        return false;
    L20:
        this.mThreadPool.shutdownNow();     // Catch: SecurityException -> L8
    L9:
        Slog.w(LOG_TAG, "Could not stop all view server threads");
        goto L10
    L22:
        return false;
    }

    boolean isRunning() {
        if (this.mThread != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mThread.isAlive() == false) goto L7;
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
    L3:
        if (Thread.currentThread() != this.mThread) goto L16;
        Socket client = this.mServer.accept();     // Catch: Exception -> L8
        if (this.mThreadPool != null) goto L6;
        client.close();     // Catch: Exception -> L8 IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L8
        goto L3
    L6:
        this.mThreadPool.submit(new ViewServerWorker(this, client));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Slog.w(LOG_TAG, "Connection error: ", e);
        goto L3
    }

    private static boolean writeValue(Socket client, String value) {
        BufferedWriter out = null;
        OutputStream clientStream = client.getOutputStream();     // Catch: Throwable -> L10 Exception -> L12
        out = new BufferedWriter(new OutputStreamWriter(clientStream), 8192);     // Catch: Throwable -> L10 Exception -> L12
        out.write(value);     // Catch: Throwable -> L10 Exception -> L12
        out.write("\n");     // Catch: Throwable -> L10 Exception -> L12
        out.flush();     // Catch: Throwable -> L10 Exception -> L12
        boolean result = true;
        out.close();     // Catch: IOException -> L7
    L24:
        return result;
    L10:
        th = move-exception;
        if (out != null) goto L27;
    L18:
        throw th;
    L27:
        out.close();     // Catch: IOException -> L17
    L8:
        return false;
    L19:
        result = false;
        if (out == null) goto L30;
        out.close();     // Catch: IOException -> L7
        goto L24
    L30:
        return false;
    }
}
