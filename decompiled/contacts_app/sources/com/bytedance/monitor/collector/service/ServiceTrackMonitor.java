package com.bytedance.monitor.collector.service;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.monitor.util.ActivityThreadUtils;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceTrackMonitor implements Handler.Callback {
    private static Map<IBinder, Service> mServices;
    private static ServiceTrackMonitor sInstance;
    private static ServiceFollowBean sServiceFollowBean;
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
    L14:
        th = move-exception;
        throw th;
    L4:
        if (mServices == null) goto L20;
    L6:
        Map<IBinder, Service> r0 = mServices;     // Catch: Throwable -> L14
        String r1 = null;
        if (r0 != null) goto L9;
    L12:
        monitor-exit(this);
        return r1;
    L9:
        if (r0.get(r4) == null) goto L12;
        r1 = mServices.get(r4).getClass().getName();     // Catch: Throwable -> L14
        goto L12
    L20:
        Object r2 = ActivityThreadUtils.currentActivityThread();     // Catch: Throwable -> L17
        mServices = (Map) DoubleReflectHelper.getField(r2.getClass(), "mServices").get(r2);     // Catch: Throwable -> L17
        goto L6
    }

    public void start() {
        Handler r0 = (Handler) ActivityThreadUtils.getHInActivityThread();     // Catch: Throwable -> L4
        Field r1 = DoubleReflectHelper.getField(Handler.class, "mCallback");     // Catch: Throwable -> L4
        this.mOriginalCallback = (Handler.Callback) r1.get(r0);     // Catch: Throwable -> L4
        r1.set(r0, this);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (MessageHandleUtils.isServiceMessage(r2) == false) goto L5;
        sServiceFollowBean = ServiceFollowBean.fetchServiceName(r2);     // Catch: Throwable -> L11
    L5:
        Handler.Callback r1 = this.mOriginalCallback;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.handleMessage(r2);
    }

    public static ServiceFollowBean getCurrentService() {
        return sServiceFollowBean;
    }

    public static void clearCurrentService() {
        sServiceFollowBean = null;
    }
}
