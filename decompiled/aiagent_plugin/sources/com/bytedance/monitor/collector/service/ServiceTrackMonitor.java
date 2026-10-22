package com.bytedance.monitor.collector.service;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ServiceTrackMonitor implements Handler.Callback {
    private static Map<IBinder, Service> mServices;
    private static ServiceTrackMonitor sInstance;
    private static c sServiceFollowBean;
    private Handler.Callback mOriginalCallback;

    static {
        sInstance = new ServiceTrackMonitor();
        sServiceFollowBean = null;
    }

    private ServiceTrackMonitor() {
    }

    public static ServiceTrackMonitor getInstance() {
        return sInstance;
    }

    public synchronized String getServiceComponentName(IBinder r4) {
        monitor-enter(this);
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (mServices == null) goto L20;
    L6:
        Map<IBinder, Service> r0 = mServices;     // Catch: Throwable -> L14
        String r1 = null;
        if (r0 != null) goto L9;
    L12:
        monitor-exit(this);
        return r1;
    L9:
        if (r0.get(r5) == null) goto L12;
        r1 = ((Service) ZeusTransformUtils.preCheckCast(mServices.get(r5), Service.class, "com.obric.aiagent.plugin")).getClass().getName();     // Catch: Throwable -> L14
        goto L12
    L20:
        Object r2 = com.bytedance.monitor.a.a.e();     // Catch: Throwable -> L17
        mServices = (Map) ZeusTransformUtils.preCheckCast(a.b(r2.getClass(), "mServices").get(r2), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        throw th;
    }

    public void start() {
        Handler r1 = (Handler) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.a.a.d(), Handler.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Field r2 = a.b(Handler.class, "mCallback");     // Catch: Throwable -> L5
        this.mOriginalCallback = (Handler.Callback) ZeusTransformUtils.preCheckCast(r2.get(r1), Handler.Callback.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r2.set(r1, this);     // Catch: Throwable -> L5
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (b.a(r2) == false) goto L5;
        sServiceFollowBean = c.a(r2);     // Catch: Throwable -> L11
    L5:
        Handler.Callback r1 = this.mOriginalCallback;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.handleMessage(r2);
    }

    public static c getCurrentService() {
        return sServiceFollowBean;
    }

    public static void clearCurrentService() {
        sServiceFollowBean = null;
    }
}
