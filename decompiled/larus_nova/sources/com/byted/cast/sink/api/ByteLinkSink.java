package com.byted.cast.sink.api;

import android.app.Application;
import android.content.Context;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.sink.ISourceDeviceInfoListener;
import com.byted.cast.sdk.RTCStatistics;
import com.byted.cast.sink.api.multiple.IMultipleActiveControl;
import com.byted.cast.sink.api.multiple.IMultipleLoader;
import com.byted.cast.sink.api.multiple.IMultipleReverseControl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public class ByteLinkSink {
    public static final int ENGINE_CAST_ERROR = 501;
    public static final int ENGINE_CONNECT_ERROR = 500;
    public static final int ENGINE_FATAL_ERROR = 502;
    public static final int NSD_SERVER_PORT = 5001;
    public static final String NSD_SERVICE_NAME = "bytelink-cast";
    public static final int RENDER_EGL_SURFACE = 1;
    public static final int RENDER_SURFACE = 0;
    public static final int SYNC_LOW_LATENCY = 0;
    public static final int SYNC_NORMAL = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, ByteLinkSink> f33790b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.byted.cast.sink.impl.b f33791a;

    static {
        f33790b = new HashMap();
    }

    private ByteLinkSink(ContextManager.CastContext r100) {
        this.f33791a = new com.byted.cast.sink.impl.b(r100);
    }

    public static ByteLinkSink getInstance(ContextManager.CastContext r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getContextId();
    L6:
        monitor-enter(ByteLinkSink.class);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f33790b.containsKey(r101) == false) goto L10;
        ByteLinkSink r102 = f33790b.get(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ByteLinkSink.class);     // Catch: Throwable -> L13
        return r102;
    L10:
        ByteLinkSink r103 = new ByteLinkSink(r100);     // Catch: Throwable -> L13
        f33790b.put(r101, r103);     // Catch: Throwable -> L13
        r102 = r103;
        goto L11
    L4:
        r101 = "bytelink_sink";
        goto L6
    }

    public void destroy() {
        this.f33791a.a();
    }

    public void dumpMediaData(int r100, int r101) {
        this.f33791a.a(r100, r101);
    }

    public IMultipleActiveControl getMultipleActiveControl() {
        return this.f33791a.c();
    }

    public IMultipleLoader getMultipleLoader() {
        return this.f33791a.d();
    }

    public Object getOption(int r100, Object... r101) {
        return this.f33791a.a(r100, r101);
    }

    public ServerInfo getServerInfo() {
        return this.f33791a.e();
    }

    public RTCStatistics getStatistics() {
        return this.f33791a.f();
    }

    public void init(Context r100, String r101) {
        this.f33791a.a(r100, r101);
    }

    public void init(Context r100, String r101, boolean r102) {
        this.f33791a.a(r100, r101, r102);
    }

    public boolean notifyPreempt(boolean r100, ClientInfo r101) {
        return this.f33791a.a(r100, r101);
    }

    public void requestIdrFromSource(String r100) {
        this.f33791a.b(r100);
    }

    public boolean reverseConnect(String r100, int r101) {
        return this.f33791a.a(r100, r101);
    }

    public boolean reverseDisconnect() {
        return this.f33791a.i();
    }

    public boolean reverseInvite(String r100) {
        return this.f33791a.c(r100);
    }

    public void sendMetaData(String r100, String r101) {
        this.f33791a.a(r100, r101);
    }

    public void setAVSyncType(int r100) {
        this.f33791a.a(r100);
    }

    public void setApplication(Application r100) {
        this.f33791a.a(r100);
    }

    public void setAudioDropPolicyByMs(int r100, int r101) {
        this.f33791a.b(r100, r101);
    }

    public void setAudioMaxDelayByMs(int r100) {
        this.f33791a.b(r100);
    }

    public void setLogLevel(int r100) {
        this.f33791a.c(r100);
    }

    public void setMultipleReverseControl(IMultipleReverseControl r100) {
        this.f33791a.a(r100);
    }

    public void setOnLogMonitor(IOnLogMonitor r100) {
        this.f33791a.a(r100);
    }

    public void setOption(int r100, Object... r101) {
        this.f33791a.b(r100, r101);
    }

    public void setPreemptListener(IPreemptListener r100) {
        this.f33791a.a(r100);
    }

    public void setRenderMode(int r100) {
        this.f33791a.d(r100);
    }

    public void setServerListener(IServerListener r100) {
        this.f33791a.a(r100);
    }

    public void setSourceDeviceInfoListener(ISourceDeviceInfoListener r100) {
        this.f33791a.a(r100);
    }

    public void startServer(String r100) {
        this.f33791a.d(r100);
    }

    public void stopServer() {
        this.f33791a.k();
    }
}
