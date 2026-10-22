package com.bytedance.monitor.collector.service;

import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.apm.alog.AlogMonitor;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceFollowBean {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static Field mFieldBindServiceDataToken;
    private static Field mFieldCreateServiceDataToken;
    private static Field mFieldCreateServiceInfo;
    private static Field mFieldDumpComponentInfoToken;
    private static Field mFieldServiceArgsDataToken;
    private static Field mFieldUnBindServiceDataToken;
    public String mServiceName;
    public String mThreadName;
    public long mTimeStamp;
    public String mToken;
    public int mWhat;

    public ServiceFollowBean() {
    }

    public ServiceFollowBean(String r1, int r2, long r3, String r5) {
        this.mServiceName = r1;
        this.mWhat = r2;
        this.mTimeStamp = r3;
        this.mToken = r5;
        this.mThreadName = Thread.currentThread().getName();
    }

    public static ServiceFollowBean fetchServiceName(Message r14) {
        switch(r14.what) {
            case 114: goto L38;
            case 115: goto L31;
            case 116: goto L29;
            case 117: goto L50;
            case 118: goto L50;
            case 119: goto L50;
            case 120: goto L50;
            case 121: goto L22;
            case 122: goto L15;
            case 123: goto L8;
            default: goto L50;
        };
    L50:
        throw new IllegalArgumentException("message.what = " + r14.what + " is not excepted!");     // Catch: Throwable -> L53
    L8:
        if (mFieldDumpComponentInfoToken != null) goto L10;
        mFieldDumpComponentInfoToken = DoubleReflectHelper.getField(r14.obj.getClass(), "token");     // Catch: Throwable -> L53
    L10:
        IBinder r0 = (IBinder) mFieldDumpComponentInfoToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r0 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r0), r14.what, System.currentTimeMillis(), r0.toString());
    L15:
        if (mFieldUnBindServiceDataToken != null) goto L17;
        mFieldUnBindServiceDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), "token");     // Catch: Throwable -> L53
    L17:
        IBinder r1 = (IBinder) mFieldUnBindServiceDataToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r1 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r1), r14.what, System.currentTimeMillis(), r1.toString());
    L22:
        if (mFieldBindServiceDataToken != null) goto L24;
        mFieldBindServiceDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), "token");     // Catch: Throwable -> L53
    L24:
        IBinder r2 = (IBinder) mFieldBindServiceDataToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r2 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r2), r14.what, System.currentTimeMillis(), r2.toString());
    L29:
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName((IBinder) r14.obj), r14.what, System.currentTimeMillis(), r14.obj.toString());
    L31:
        if (mFieldServiceArgsDataToken != null) goto L33;
        mFieldServiceArgsDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), "token");     // Catch: Throwable -> L53
    L33:
        IBinder r3 = (IBinder) mFieldServiceArgsDataToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r3 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r3), r14.what, System.currentTimeMillis(), r3.toString());
    L38:
        if (mFieldCreateServiceInfo != null) goto L41;
        mFieldCreateServiceInfo = DoubleReflectHelper.getField(r14.obj.getClass(), AlogMonitor.ALOG_RESULT_INFO);     // Catch: Throwable -> L53
    L41:
        if (mFieldCreateServiceDataToken != null) goto L43;
        mFieldCreateServiceDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), "token");     // Catch: Throwable -> L53
    L43:
        ServiceInfo r4 = (ServiceInfo) mFieldCreateServiceInfo.get(r14.obj);     // Catch: Throwable -> L53
        if (r4 == null) goto L46;
        String r5 = r4.name;     // Catch: Throwable -> L53
    L48:
        return new ServiceFollowBean(r5, r14.what, System.currentTimeMillis(), mFieldCreateServiceDataToken.get(r14.obj).toString());
    L46:
        r5 = null;
    L52:
        return new ServiceFollowBean("unknow", r14.what, System.currentTimeMillis(), "unknow");
    }

    public String toString() {
        return "ServiceFollowBean{mServiceName='" + this.mServiceName + "', mWhat=" + this.mWhat + ", mTimeStamp=" + this.mTimeStamp + ", mToken='" + this.mToken + "', mThreadName='" + this.mThreadName + "'}";
    }
}
